# JavaSec

仅仅只是想写给自己看

一个记录我Java安全学习过程的仓库，本仓库不是教学仓库，单纯简单记笔记，顺便见证自己从0到0.1的过程吧，少了很多介绍性的东西，以后等厉害了再慢慢补充吧

@Y4tacker

## 1.基础篇

基础篇有些可以写，但更多网上其实各个大佬都写了点，可能先偷个懒搬运链接，之后慢慢填坑写自己的东西，主要是节约点时间(偷懒)

- [Java反射](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E5%8F%8D%E5%B0%84/%E5%8F%8D%E5%B0%84.md)
- [Java动态代理](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86/%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86.md)
- [Java Instrument插桩技术学习(以后慢慢填坑)](https://github.com/Stakcery/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/JavaInstrument%E6%8F%92%E6%A1%A9%E6%8A%80%E6%9C%AF/JavaInstrument%E6%8F%92%E6%A1%A9%E6%8A%80%E6%9C%AF.md)
- [JNDI注入](https://www.mi1k7ea.com/2019/09/15/%E6%B5%85%E6%9E%90JNDI%E6%B3%A8%E5%85%A5/)
- [反序列化](https://www.zhihu.com/question/47794528/answer/672095170)

## 2.CC专区

很早前学了，后面补上，更多是说一点关键的东西，不会很详细

- [CommonsCollections1笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections1/CommonsCollections1.md)
- [CommonsCollections2笔记](https://github.com/Stakcery/JavaSec/blob/main/2.CC%E4%B8%93%E5%8C%BA/CommonsCollections2/CommonsCollections2.md)

....to be continued

## 3.Fastjson专区

- [Fastjson基本用法](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Fastjson%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95/Fastjson%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95.md)
- [Fastjson1.22-1.24反序列化分析之JNDI](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Fastjson1.22-1.24/Fastjson1.22-1.24%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%88%86%E6%9E%90%E4%B9%8BJNDI/Fastjson1.22-1.24.md)
- [Fastjson1.22-1.24反序列化分析之TemplateImpl](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Fastjson1.22-1.24/Fastjson1.22-1.24%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%88%86%E6%9E%90%E4%B9%8BTemplateImpl/Fastjson1.22-1.24.md)
- [Fastjson1.2.25-1.2.41补丁绕过(用L;绕过、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.41%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.41%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.42补丁绕过(双写L;绕过、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.42%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.42%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.43补丁绕过(用左中括号绕过、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.43%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.43%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.45补丁绕过(mybatis的3.x版本且<3.5.0、需要开启autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.45%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.45%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)
- [Fastjson1.2.25-1.2.47绕过(无需autotype)](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Bypass/Fastjson1.2.25-1.2.47%E7%BB%95%E8%BF%87%E6%97%A0%E9%9C%80AutoType/Fastjson1.2.25-1.2.47%E7%BB%95%E8%BF%87%E6%97%A0%E9%9C%80AutoType.md)
- [一些有趣的Trick](https://github.com/Stakcery/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/%E6%9C%89%E8%B6%A3Trick/FastJson%20Trick.md)



## 4.Weblogic专区

- [如何远程调试Weblogic](https://github.com/QAX-A-Team/WeblogicEnvironment)
- [T3协议学习](https://github.com/Stakcery/JavaSec/blob/main/4.Weblogic%E4%B8%93%E5%8C%BA/T3%E5%8D%8F%E8%AE%AE%E5%AD%A6%E4%B9%A0/T3%E5%8D%8F%E8%AE%AE%E5%AD%A6%E4%B9%A0.md)

## 其他

- [利用TemplatesImpl执行字节码](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E5%88%A9%E7%94%A8TemplatesImpl%E6%89%A7%E8%A1%8C%E5%AD%97%E8%8A%82%E7%A0%81/%E5%88%A9%E7%94%A8TemplatesImpl%E6%89%A7%E8%A1%8C%E5%AD%97%E8%8A%82%E7%A0%81.md)
- [Java反序列化之URLDNS](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/Java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BURLDNS/Java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BURLDNS.md)
- [高低版JDK下的JNDI注入绕过流程跟踪(Jdk8u191+)](https://github.com/Stakcery/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E9%AB%98%E4%BD%8E%E7%89%88JDK%E4%B8%8B%E7%9A%84JNDI%E6%B3%A8%E5%85%A5%E7%BB%95%E8%BF%87%E6%B5%81%E7%A8%8B%E8%B7%9F%E8%B8%AA/%E9%AB%98%E4%BD%8E%E7%89%88JDK%E4%B8%8B%E7%9A%84JNDI%E6%B3%A8%E5%85%A5%E7%BB%95%E8%BF%87%E6%B5%81%E7%A8%8B%E8%B7%9F%E8%B8%AA.md)

- [Java沙箱绕过](https://www.anquanke.com/post/id/151398)

