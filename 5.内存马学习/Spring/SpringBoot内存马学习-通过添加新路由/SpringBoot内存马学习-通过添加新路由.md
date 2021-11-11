# SpringBoot内存马学习-通过添加新路由

## 注册类时简单分析

在AbstractHandlerMethodMapping的initHandlerMethods方法下断点

首先获取全部的bean再遍历，遍历的目的是寻找Controller类

![](img/1.png)