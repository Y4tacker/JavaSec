# S2-059分析

## 环境搭建

Struts.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
        "http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>

    <constant name="struts.devMode" value="false"/>
    <package name="s2-059" namespace="/" extends="struts-default">
        <action name="index" class="com.test.s2001.action.IndexAction">
            <result name="success">index.jsp</result>
        </action>
    </package>

</struts>
```

indexAction

```java
package com.test.s2001.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction  extends ActionSupport {

    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String execute(){
        System.out.println(id);
        return SUCCESS;
    }
}
```

index.jsp，为了直观看到漏洞结果简单写了个js

```jsp
<%@ page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>S2059</title>
</head>
<body>
<s:a id="%{id}">SimpleTest</s:a>
</body>
<script>
    document.querySelector("body > a").text = document.querySelector("body > a").id
</script>
</html>

```

## 分析

diff可以发现首先在OgnlUtil类当中各属性的set方法由public改为protected，不能直接显式调用set方法

同时看看status-default.xml当中的黑名单

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
                com.opensymphony.xwork2.ActionContext" />

    <!-- this must be valid regex, each '.' in package name must be escaped! -->
    <!-- it's more flexible but slower than simple string comparison -->
    <!-- constant name="struts.excludedPackageNamePatterns" value="^java\.lang\..*,^ognl.*,^(?!javax\.servlet\..+)(javax\..+)" / -->

    <!-- this is simpler version of the above used with string comparison -->
    <constant name="struts.excludedPackageNames"
              value="
                ognl.,
                javax.,
                freemarker.core.,
                freemarker.template.,
                freemarker.ext.rhino.,
                sun.reflect.,
                javassist.,
                org.objectweb.asm.,
                com.opensymphony.xwork2.ognl.,
                com.opensymphony.xwork2.security.,
                com.opensymphony.xwork2.util." />
```

相较之前可以看到其中和ognl有关的部分从`excludedClasses`改到了`excludedPackageNames`当中（很暴力完全没办法访问到），同时在ognl的高版本中也就是3.2.10之后，甚至删除掉了`DefaultMemberAccess`，静态变量静态变量`DEFAULT_MEMBER_ACCESS`也被删除了，这样我们就不再能够像之前那样用`DEFAULT_MEMBER_ACCESS` 对象去覆盖` _memberAccess`
