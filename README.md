# JavaSec

仅仅只是想写给自己看

一个记录我Java安全学习过程的仓库，本仓库不是教学仓库，单纯简单记笔记，顺便见证自己从0到0.1的过程吧，少了很多介绍性的东西，以后等厉害了再慢慢补充吧

@Y4tacker

## 1.基础篇

- [Java反射](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E5%8F%8D%E5%B0%84/%E5%8F%8D%E5%B0%84.md)
- [补充:通过反射修改用final修饰的变量](https://github.com/Stakcery/JavaSec/tree/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E9%80%9A%E8%BF%87%E5%8F%8D%E5%B0%84%E4%BF%AE%E6%94%B9%E7%94%A8final%E4%BF%AE%E9%A5%B0%E7%9A%84%E5%8F%98%E9%87%8F)
- [Java动态代理](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86/%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86.md)
- [JNDI注入](https://www.mi1k7ea.com/2019/09/15/%E6%B5%85%E6%9E%90JNDI%E6%B3%A8%E5%85%A5/)
- [反序列化](https://www.zhihu.com/question/47794528/answer/672095170)
- [类加载器与双亲委派模型](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E4%B8%8E%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E4%B8%8E%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B.md)
- [两种实现Java类隔离加载的方法](https://max.book118.com/html/2021/0415/5213012132003221.shtm)(当然同名目录下也有pdf，防止以后站不在了)
- [ClassLoader(类加载机制)](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/ClassLoader(%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6)/ClassLoader(%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6).md)
- [SPI学习](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/SPI/SPI.md)
- [Java 类字节码编辑](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/Java%20%E7%B1%BB%E5%AD%97%E8%8A%82%E7%A0%81%E7%BC%96%E8%BE%91/Java%20%E7%B1%BB%E5%AD%97%E8%8A%82%E7%A0%81%E7%BC%96%E8%BE%91.md)
- [JavaAgent](http://wjlshare.com/archives/1582)

## 2.CC专区(Ysoserial专区)

很早前学了，后面补上，更多是说一点关键的东西，不会很详细

- [Java反序列化之URLDNS](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/Java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BURLDNS/Java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BURLDNS.md)

- [CommonsCollections1笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections1/CommonsCollections1.md)
- [CommonsCollections2笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections2/CommonsCollections2.md)
- [CommonsCollections3笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections3/CommonsCollections3.md)
- [CommonsCollections5笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections5/CommonsCollections5.md)
- [CommonsCollections6-HashSet笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections6-HashSet/CommonsCollections6-HashSet.md)
- [CommonsCollections6-HashMap笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections6-HashMap/CommonsCollections6-HashMap.md)
- [CommonsCollections6-Shiro1.2.4笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections6-Shiro1.2.4/CommonsCollections6-Shiro1.2.4.md)
- [CommonsCollections7笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections7/CommonsCollections7.md)
- [使用TemplatesImpl改造CommonsCollections2](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/%E4%BD%BF%E7%94%A8TemplatesImpl%E6%94%B9%E9%80%A0CommonsCollections2/%E4%BD%BF%E7%94%A8TemplatesImpl%E6%94%B9%E9%80%A0CommonsCollections2.md)
- [CommonsBeanutils1笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsBeanutils1/CommonsBeanutils1%E7%AC%94%E8%AE%B0.md)
- [CommonsBeanutils1-Shiro(无CC依赖)](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsBeanutils1-Shiro(%E6%97%A0CC%E4%BE%9D%E8%B5%96)/CommonsBeanutils1-Shiro(%E6%97%A0CC%E4%BE%9D%E8%B5%96).md)
- [C3P0利用链简单分析](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/C3P0/C3P0.md)
- [C3P0Tomcat不出网利用(思路就是之前高版本JNDI注入的思路)](http://www.yulegeyu.com/2021/10/10/JAVA%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BC3P0%E4%B8%8D%E5%87%BA%E7%BD%91%E5%88%A9%E7%94%A8/)
- [MySQL-JDBC-反序列化漏洞](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/MySQL-JDBC-%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%BC%8F%E6%B4%9E/MySQL%20JDBC-%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%BC%8F%E6%B4%9E.md)
- [反制Ysoserial0.0.6版本-JRMP(打个标签weblogic搞定后看看)](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/%E5%8F%8D%E5%88%B6Ysoserial0.0.6%E7%89%88%E6%9C%AC-JRMP/%E5%8F%8D%E5%88%B6Ysoserial0.0.6%E7%89%88%E6%9C%AC-JRMP.md)
- [网上看到的神秘套娃CommonsCollections11](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections11/CommonsCollections11.md)

....to be continued

## 3.Fastjson专区

- [Fastjson基本用法](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Fastjson%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95/Fastjson%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95.md)
- [Fastjson1.1.15-1.2.4与BCEL字节码加载](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Fastjson1.1.15-1.2.4%E4%B8%8EBCEL%E5%AD%97%E8%8A%82%E7%A0%81%E5%8A%A0%E8%BD%BD/Fastjson1.1.15-1.2.4%E4%B8%8EBCEL%E5%AD%97%E8%8A%82%E7%A0%81%E5%8A%A0%E8%BD%BD.md)
- [Fastjson1.22-1.24反序列化分析之JNDI](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Fastjson1.22-1.24/Fastjson1.22-1.24%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%88%86%E6%9E%90%E4%B9%8BJNDI/Fastjson1.22-1.24.md)
- [Fastjson1.22-1.24反序列化分析之TemplateImpl](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Fastjson1.22-1.24/Fastjson1.22-1.24%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%88%86%E6%9E%90%E4%B9%8BTemplateImpl/Fastjson1.22-1.24.md)
- [Fastjson1.2.25-1.2.41补丁绕过(用L;绕过、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.41%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.41%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.42补丁绕过(双写L;绕过、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.42%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.42%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.43补丁绕过(用左中括号绕过、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.43%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.43%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.45补丁绕过(mybatis的3.x版本且<3.5.0、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.45%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.45%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.47绕过](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.47%E7%BB%95%E8%BF%87%E6%97%A0%E9%9C%80AutoType/Fastjson1.2.25-1.2.47%E7%BB%95%E8%BF%87%E6%97%A0%E9%9C%80AutoType.md)
- [Fastjson1.2.48-1.2.68反序列化漏洞](https://www.anquanke.com/post/id/232774)
- [Fastjson1.2.68不使用ref引用，不用parseObject触发get方法](https://su18.org/post/fastjson-1.2.68/#getter-%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8)
- [关于blackhat2021披露的fastjson1.2.68链的一些细节，防止公众号以后找不到同目录下有备份](https://mp.weixin.qq.com/s?__biz=MzUzNDMyNjI3Mg==&mid=2247484866&idx=1&sn=23fb7897f6e54cdf61031a65c602487d&scene=21#wechat_redirect)
- [2021L3HCTF中关于Fastjson1.2.68的骚操作](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/%E5%85%B6%E4%BB%96/L3HCTF%202021%20Official%20Write%20Up.pdf)
- [一些有趣的Trick](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/%E6%9C%89%E8%B6%A3Trick/FastJson%20Trick.md)



## 4.Weblogic专区

- [T3协议学习](https://github.com/Stakcery/JavaSec/blob/main/4.Weblogic%E4%B8%93%E5%8C%BA/T3%E5%8D%8F%E8%AE%AE%E5%AD%A6%E4%B9%A0/T3%E5%8D%8F%E8%AE%AE%E5%AD%A6%E4%B9%A0.md)
- [CVE-2015-4852复现分析](https://github.com/Stakcery/JavaSec/blob/main/4.Weblogic%E4%B8%93%E5%8C%BA/CVE-2015-4852%E5%A4%8D%E7%8E%B0%E5%88%86%E6%9E%90/CVE-2015-4852%E5%A4%8D%E7%8E%B0%E5%88%86%E6%9E%90.md)
- [Weblogic使用ClassLoader和RMI来回显命令执行结果](https://xz.aliyun.com/t/7228)



## 5.内存马学习专区

- [JavaWeb与Tomcat介绍](https://github.com/Stakcery/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat%E4%BB%8B%E7%BB%8D/Tomcat%E4%BB%8B%E7%BB%8D.md)
- [Tomcat-Listener型内存马](https://github.com/Stakcery/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat-Listener%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC/Tomcat-Listener%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC.md)
- [Tomcat-Filter型内存马](https://github.com/Stakcery/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat-Filter%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC/Tomcat-Filter%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC.md)
- [Tomcat-Servlet型内存马](https://github.com/Stakcery/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat-Servlet%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC/Tomcat-Servlet%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC.md)
- [浅谈 Java Agent 内存马(网上看到大师傅写的很详细直接搬运工了)](http://wjlshare.com/archives/1582)
- [SpringBoot内存马学习-通过添加新路由](https://github.com/Stakcery/JavaSec/tree/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Spring/%E9%92%88%E5%AF%B9springboot%E7%9A%84controller%E5%86%85%E5%AD%98%E9%A9%AC)
- [利用intercetor注入Spring内存马](https://github.com/Stakcery/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Spring/%E5%88%A9%E7%94%A8intercetor%E6%B3%A8%E5%85%A5Spring%E5%86%85%E5%AD%98%E9%A9%AC/index.md)



## 6.JavaAgent学习专区

- [Java Instrument插桩技术初体验](https://github.com/Stakcery/JavaSec/blob/main/6.JavaAgent/JavaInstrument%E6%8F%92%E6%A1%A9%E6%8A%80%E6%9C%AF/JavaInstrument%E6%8F%92%E6%A1%A9%E6%8A%80%E6%9C%AF.md)
- [PreMain之addTransformer与redefineClasses用法学习](https://github.com/Stakcery/JavaSec/blob/main/6.JavaAgent/PreMain%E4%B9%8BaddTransformer%E4%B8%8EredefineClasses%E7%94%A8%E6%B3%95%E5%AD%A6%E4%B9%A0/PreMain%E4%B9%8BaddTransformer%E4%B8%8EredefineClasses%E7%94%A8%E6%B3%95%E5%AD%A6%E4%B9%A0.md)
- [AgentMain(JVM启动后动态Instrument)](https://github.com/Stakcery/JavaSec/blob/main/6.JavaAgent/AgentMain/AgentMain.md)

## 7.Struts2学习专区

- [Struts2简介与漏洞环境搭建](https://github.com/Stakcery/JavaSec/blob/main/7.Struts22%E4%B8%93%E5%8C%BA/%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA/%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA.md)
- [Struts2框架处理流程与Struts2-001漏洞分析(Struts 2.0.0-Struts 2.0.8)](https://github.com/Stakcery/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/Struts2%E6%A1%86%E6%9E%B6%E5%A4%84%E7%90%86%E6%B5%81%E7%A8%8B/Struts2%E6%A1%86%E6%9E%B6%E5%A4%84%E7%90%86%E6%B5%81%E7%A8%8B%E4%B8%8EStruts2-001.md)
- [S2-002漏洞分析(Struts 2.0.0 - Struts 2.1.8.1)](https://github.com/Stakcery/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-002%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/S2-002%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90.md)

## 8.关于Tomcat的一些小发现的分享

- [一次jsp的奇异探索](https://github.com/Stakcery/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/%E4%B8%80%E6%AC%A1jsp%E7%9A%84%E5%A5%87%E5%BC%82%E6%8E%A2%E7%B4%A2/1.md)
- [Tomcat写文件新利用思路](https://github.com/Stakcery/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/Tomcat%E5%86%99%E6%96%87%E4%BB%B6%E6%96%B0%E5%88%A9%E7%94%A8%E6%80%9D%E8%B7%AF/DC.md)
- [两个关于Tomcat的问题](https://github.com/Stakcery/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/%E4%B8%A4%E4%B8%AA%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E9%97%AE%E9%A2%98/1.md)

## 9.关于JNDI的整理

因为比较重要单独列出来了

- [Java RMI 攻击由浅入深(深入源码，师傅写的很好)](https://su18.org/post/rmi-attack/)

- [如何绕过高版本 JDK 的限制进行 JNDI 注入利用](https://paper.seebug.org/942/#classreference-factory)
- [探索高版本 JDK 下 JNDI 漏洞的利用方法](https://tttang.com/archive/1405/)

## 其他分享

- [SpirngBoot下结合Tomcat实现无OOB方式下的回显](https://github.com/Stakcery/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Spring/springboot-tomcat%E5%9B%9E%E6%98%BE/index.md)
- [BypassSM](https://github.com/Stakcery/JavaSec/blob/main/其他/BypassSM/bypasssm.md)
- [JSP-Webshells集合](https://github.com/threedr3am/JSP-Webshells)
- [Spring Boot FatJar任意写目录漏洞导致Getshell](https://www.cnblogs.com/wh4am1/p/14681335.html)
- [利用TemplatesImpl执行字节码](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E5%88%A9%E7%94%A8TemplatesImpl%E6%89%A7%E8%A1%8C%E5%AD%97%E8%8A%82%E7%A0%81/%E5%88%A9%E7%94%A8TemplatesImpl%E6%89%A7%E8%A1%8C%E5%AD%97%E8%8A%82%E7%A0%81.md)
- [为什么补丁都喜欢打在resolveClass](https://github.com/Stakcery/JavaSec/blob/main/4.Weblogic%E4%B8%93%E5%8C%BA/%E4%B8%BA%E4%BB%80%E4%B9%88%E8%A1%A5%E4%B8%81%E5%96%9C%E6%AC%A2%E6%89%93%E5%9C%A8resolveClass/%E4%B8%BA%E4%BB%80%E4%B9%88%E8%A1%A5%E4%B8%81%E5%96%9C%E6%AC%A2%E6%89%93%E5%9C%A8resolveClass.md)
- [高低版JDK下的JNDI注入绕过流程跟踪(Jdk8u191+)](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E9%AB%98%E4%BD%8E%E7%89%88JDK%E4%B8%8B%E7%9A%84JNDI%E6%B3%A8%E5%85%A5%E7%BB%95%E8%BF%87%E6%B5%81%E7%A8%8B%E8%B7%9F%E8%B8%AA/%E9%AB%98%E4%BD%8E%E7%89%88JDK%E4%B8%8B%E7%9A%84JNDI%E6%B3%A8%E5%85%A5%E7%BB%95%E8%BF%87%E6%B5%81%E7%A8%8B%E8%B7%9F%E8%B8%AA.md)
- [Java沙箱绕过](https://www.anquanke.com/post/id/151398)

## 漏洞复现与分析

- [CVE-2021-2471 JDBC-XXE漏洞分析](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/CVE-2021-2471%20JDBC-XXE%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/CVE-2021-2471%20JDBC-XXE%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90.md)
- [spring-messaging 远程代码执行漏洞分析](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/spring-messaging%20%E8%BF%9C%E7%A8%8B%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/spring-messaging%20%E8%BF%9C%E7%A8%8B%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90.md)

## 环境

- [如何远程调试Weblogic](https://github.com/QAX-A-Team/WeblogicEnvironment)

- [使用idea进行tomcat源码调试](https://zhuanlan.zhihu.com/p/35454131)

 

