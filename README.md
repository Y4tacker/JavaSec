

# JavaSec

![JavaSec](https://socialify.git.ci/Y4tacker/JavaSec/image?description=1&font=Source%20Code%20Pro&forks=1&issues=1&language=1&name=1&owner=1&pulls=1&stargazers=1&theme=Dark)

## 0.For Me

仅仅只是想写给自己看

一个记录我Java安全学习过程的仓库，本仓库不是真正意义上的教学仓库(rep中的内容都是我在平时的一些笔记没有很强逻辑性，内容水平自然也是参差不齐，可能有些对我来说很简单的便忽略不计对其他人来说却是难点，因此作为一个学习目录的话可能会好很多)，单纯这是笔者简单记一些笔记，顺便见证自己从0到0.1的过程吧，另外后面如果看到一些好的东西在学习完之后也会贴上链接，少了很多介绍性的东西，以后等厉害了再慢慢补充吧.当然如果感觉还不错的话，师傅们记得给个 Star 呀 ~

<p align="right">@Y4tacker</p>

<p align="right">2021年10月18日，梦的开始</p>

<br/>
知识星球试运营，后面主要会发一些应急漏洞的分析(前提我会😜) 
Ps:想不想进随意，大部分漏洞我都会发在博客当中，少部分自己觉得不那么有意思的漏洞可能只会发在星球中

<img src="https://github.com/Y4tacker/JavaSec/assets/56486273/08eab771-b1cd-4d97-a3a9-173b78fdc997" align="center"></img>


## 1.基础篇

- [Java反射](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E5%8F%8D%E5%B0%84/%E5%8F%8D%E5%B0%84.md)
  - [补充:通过反射修改用final static修饰的变量](https://github.com/Y4tacker/JavaSec/tree/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E9%80%9A%E8%BF%87%E5%8F%8D%E5%B0%84%E4%BF%AE%E6%94%B9%E7%94%A8final%E4%BF%AE%E9%A5%B0%E7%9A%84%E5%8F%98%E9%87%8F)
- [Java动态代理](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86/%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86.md)
- [JNDI注入](https://www.mi1k7ea.com/2019/09/15/%E6%B5%85%E6%9E%90JNDI%E6%B3%A8%E5%85%A5/)
- [反序列化](https://www.zhihu.com/question/47794528/answer/672095170)
- [类加载器与双亲委派模型](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E4%B8%8E%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E4%B8%8E%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B.md)
- [两种实现Java类隔离加载的方法](https://max.book118.com/html/2021/0415/5213012132003221.shtm)(当然同名目录下也有pdf，防止以后站不在了)
- [ClassLoader(类加载机制)](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/ClassLoader(%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6)/ClassLoader(%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6).md)
- [SPI学习](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/SPI/SPI.md)
- [JavaAgent](http://wjlshare.com/archives/1582)
- [Java9模块化特性](https://developer.aliyun.com/article/618778)
- [JMX](https://zhuanlan.zhihu.com/p/166530442)
  - [JMX补充学习这哥们写的不错](https://github.com/ZhangZiSheng001/02-jmx-demo)
- [JDWP远程执行命令](https://www.mi1k7ea.com/2021/08/06/%E6%B5%85%E6%9E%90JDWP%E8%BF%9C%E7%A8%8B%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C%E6%BC%8F%E6%B4%9E/)
- [Tomcat中容器的pipeline机制(学了以后更好帮助Tomcat-Valve类型内存马理解)](https://www.cnblogs.com/coldridgeValley/p/5816414.html)
- [ASM学习+Class文件结构了解+JVM一些简单知识](https://github.com/Y4tacker/JavaSec/tree/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/ASM%E5%AD%A6%E4%B9%A0/index.md)
- [Xpath注入](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/Xpath%E6%B3%A8%E5%85%A5/index.md)
- [JSTL(看菜鸟教程即可)](https://www.runoob.com/jsp/jsp-jstl.html)
- [JEP290基础概念](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/JEP290%E7%9A%84%E5%9F%BA%E6%9C%AC%E6%A6%82%E5%BF%B5/index.md)
- [Java中的XXE](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/Java%E4%B8%AD%E7%9A%84XXE/index.md)
  - [XML外部实体注入（XXE）攻击方式汇总(关于XXE可以延伸继续看看)](https://tttang.com/archive/1813/)
  - [绕过WAF保护的XXE(一些通用的流量混淆方式)](https://xz.aliyun.com/t/4059?accounttraceid=04ba92e87b2342b9a14daca5812cc52aoxob&time__1311=n4mx0DnDBiitiQo4GNulxU2nD9iBDc70ZAnYD)
- [通过反射扫描被注解修饰的类](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E9%80%9A%E8%BF%87%E5%8F%8D%E5%B0%84%E6%89%AB%E6%8F%8F%E8%A2%AB%E6%B3%A8%E8%A7%A3%E4%BF%AE%E9%A5%B0%E7%9A%84%E7%B1%BB/index.md)
- [低版本下Java文件系统00截断](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E4%BD%8E%E7%89%88%E6%9C%AC%E4%B8%8BJava%E6%96%87%E4%BB%B6%E7%B3%BB%E7%BB%9F00%E6%88%AA%E6%96%AD/index.md)
- [有趣的XSS之Normalize](https://github.com/Y4tacker/JavaSec/blob/main/1.%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E6%9C%89%E8%B6%A3%E7%9A%84XSS%E4%B9%8BNormalize/index.md)
- [红队-java代码审计生命周期(带你简单了解审计)](https://www.secpulse.com/archives/193771.html)

## 2.反序列化

很早前学了，后面补上，更多是说一点关键的东西，不会很详细，好吧这里再拓展成反序列化专区好了

如果想系统学习CC链、CB链的话这部分还是推荐p牛的[Java安全漫谈](https://github.com/phith0n/JavaThings)，我只是简单写写便于自己复习而已(这部分看我下面的share并不适合新人，过了这么久看过网上很多文章还是觉得P牛写的更适合新人)

- [Java反序列化之URLDNS](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/Java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BURLDNS/Java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BURLDNS.md)
- [CommonsCollections1笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections1/CommonsCollections1.md)
- [CommonsCollections2笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections2/CommonsCollections2.md)
- [CommonsCollections3笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections3/CommonsCollections3.md)
- [CommonsCollections5笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections5/CommonsCollections5.md)
- [CommonsCollections6-HashSet笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections6-HashSet/CommonsCollections6-HashSet.md)
- [CommonsCollections6-HashMap笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections6-HashMap/CommonsCollections6-HashMap.md)
- [CommonsCollections6-Shiro1.2.4笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections6-Shiro1.2.4/CommonsCollections6-Shiro1.2.4.md)
- [CommonsCollections7笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections7/CommonsCollections7.md)
- [CommonCollectionsWithoutChainedTransformer](https://github.com/Y4tacker/JavaSec/blob/main/2.%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B8%93%E5%8C%BA/CommonCollectionsWithoutChainedTransformer/index.md)
- [使用TemplatesImpl改造CommonsCollections2](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/%E4%BD%BF%E7%94%A8TemplatesImpl%E6%94%B9%E9%80%A0CommonsCollections2/%E4%BD%BF%E7%94%A8TemplatesImpl%E6%94%B9%E9%80%A0CommonsCollections2.md)
- [网上看到的套娃CommonsCollections11](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsCollections11/CommonsCollections11.md)
- [CommonsBeanutils1笔记](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsBeanutils1/CommonsBeanutils1%E7%AC%94%E8%AE%B0.md)
- [CommonsBeanutils1-Shiro(无CC依赖)](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/CommonsBeanutils1-Shiro(%E6%97%A0CC%E4%BE%9D%E8%B5%96)/CommonsBeanutils1-Shiro(%E6%97%A0CC%E4%BE%9D%E8%B5%96).md)
- [FileUpload1-写文件\删除文件](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/FileUpload/index.md)
- [C3P0利用链简单分析](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/C3P0/C3P0.md)
- [C3P0Tomcat不出网利用(思路就是之前高版本JNDI注入的思路)](http://www.yulegeyu.com/2021/10/10/JAVA%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8BC3P0%E4%B8%8D%E5%87%BA%E7%BD%91%E5%88%A9%E7%94%A8/)
- [反制Ysoserial0.0.6版本-JRMP](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/%E5%8F%8D%E5%88%B6Ysoserial0.0.6%E7%89%88%E6%9C%AC-JRMP/%E5%8F%8D%E5%88%B6Ysoserial0.0.6%E7%89%88%E6%9C%AC-JRMP.md)
- [SnakeYAML反序列化及可利用Gadget](https://y4tacker.github.io/2022/02/08/year/2022/2/SnakeYAML%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%8F%8A%E5%8F%AF%E5%88%A9%E7%94%A8Gadget%E5%88%86%E6%9E%90/)
- [SnakeYAML出网探测Gadget(自己瞎琢磨出来的，不过在1.7以下版本就不行)](https://y4tacker.github.io/2022/02/08/year/2022/2/SnakeYAML%E5%AE%9E%E7%8E%B0Gadget%E6%8E%A2%E6%B5%8B/)
- [XStream反序列化学习](https://y4tacker.github.io/2022/02/10/year/2022/2/XStream%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96/)
- [解决反序列化serialVesionUID不一致问题(BestMatch：打破双亲委派对jbxz用工具最方便)](https://gv7.me/articles/2020/deserialization-of-serialvesionuid-conflicts-using-a-custom-classloader/)
- [自己搞的把ROME利用链长度缩小4400-1320(Base64)](https://y4tacker.github.io/2022/03/07/year/2022/3/ROME%E6%94%B9%E9%80%A0%E8%AE%A1%E5%88%92/)
- [JDK7u21](https://github.com/Y4tacker/JavaSec/blob/main/2.%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B8%93%E5%8C%BA/JDK7u21/index.md)
- [AspectJWeaver写文件](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/AspectJWeaver/AspectJWeaver.md)
- [反序列化在渗透测试当中值得关注的点](https://github.com/Y4tacker/JavaSec/blob/main/2.%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B8%93%E5%8C%BA/%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%9C%A8%E6%B8%97%E9%80%8F%E6%B5%8B%E8%AF%95%E5%BD%93%E4%B8%AD%E5%80%BC%E5%BE%97%E5%85%B3%E6%B3%A8%E7%9A%84%E7%82%B9/index.md)
- [UTF-8 Overlong Encoding导致的安全问题(在绕过流量设备上非常有帮助)](https://mp.weixin.qq.com/s/fcuKNfLXiFxWrIYQPq7OCg)
- [构造java探测class反序列化gadget](https://mp.weixin.qq.com/s/KncxkSIZ7HVXZ0iNAX8xPA)
  - [对URLDNS探测class的补充(为什么本地明明没有这个类却有"DNS解析")](https://github.com/Y4tacker/JavaSec/blob/main/2.%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B8%93%E5%8C%BA/URLDNS%E6%8E%A2%E6%B5%8Bclass%E7%9A%84%E8%A1%A5%E5%85%85/index.md)
- [利用Swing构造反序列化SSRF/RCE(JDK CVE-2023-21939)](https://github.com/Y4Sec-Team/CVE-2023-21939)
- Hessian反序列化
  - [Hessian 反序列化知一二](https://su18.org/post/hessian/)
  
  - [hessian-only-jdk利用补充](https://github.com/waderwu/My-CTF-Challenges/blob/master/0ctf-2022/hessian-onlyJdk/writeup/readme.md)
  - [hessian-onlyjdk-jdk11+jdk.jfr.internal.Utils利用补充](https://guokeya.github.io/post/psaIZKtC4/)

## 3.Fastjson/Jackson专区

可以对比jackson简单学习下，这里我也会简单提一下jackson的一些利用，当然不会很详细，但是会简单列出一些触发原理，而且有些payload是共通的，这里也不以收集各个依赖下利用的payload为主

- Jackson

  - [Jackson的利用触发及小细节(比较鸡肋仅作为学习了解)](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Jackson%E7%9A%84%E5%88%A9%E7%94%A8%E8%A7%A6%E5%8F%91/index.md)

  - [Jackson原生反序列化Gadgets(实用)](https://xz.aliyun.com/t/12485#toc-5)
    - [Jackson构造过程会触发利用导致中断可通过重写类解决(附上demo学习)](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson%E4%B8%93%E5%8C%BA/Jackson%E5%8E%9F%E7%94%9F%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96Gadget/Jackson.txt(%E6%94%B9zip%E5%90%8E%E7%BC%80%E8%A7%A3%E5%8E%8B).txt)
    - [从JSON1链中学习处理JACKSON链的不稳定性(使用JdkDynamicAopProxy让触发更稳定)](https://xz.aliyun.com/t/12846#toc-4)

- Fastjson

  - [Fastjson基本用法](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Fastjson%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95/Fastjson%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95.md)

  - [Fastjson1.1.15-1.2.4与BCEL字节码加载](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Fastjson1.1.15-1.2.4%E4%B8%8EBCEL%E5%AD%97%E8%8A%82%E7%A0%81%E5%8A%A0%E8%BD%BD/Fastjson1.1.15-1.2.4%E4%B8%8EBCEL%E5%AD%97%E8%8A%82%E7%A0%81%E5%8A%A0%E8%BD%BD.md)

  - [Fastjson1.22-1.24反序列化分析之JNDI](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Fastjson1.22-1.24/Fastjson1.22-1.24%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%88%86%E6%9E%90%E4%B9%8BJNDI/Fastjson1.22-1.24.md)

  - [Fastjson1.22-1.24反序列化分析之TemplateImpl](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Fastjson1.22-1.24/Fastjson1.22-1.24%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E5%88%86%E6%9E%90%E4%B9%8BTemplateImpl/Fastjson1.22-1.24.md)

  - [Fastjson1.2.25-1.2.41补丁绕过(用L;绕过、需要开启autotype)](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Bypass/Fastjson1.2.25-1.2.41%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.41%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)

  - [Fastjson1.2.25-1.2.42补丁绕过(双写L;绕过、需要开启autotype)](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Bypass/Fastjson1.2.25-1.2.42%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.42%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)

  - [Fastjson1.2.25-1.2.43补丁绕过(用左中括号绕过、需要开启autotype)](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Bypass/Fastjson1.2.25-1.2.43%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.43%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)

  - [Fastjson1.2.25-1.2.45补丁绕过(mybatis的3.x版本且<3.5.0、需要开启autotype)](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Bypass/Fastjson1.2.25-1.2.45%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87/Fastjson1.2.25-1.2.45%E8%A1%A5%E4%B8%81%E7%BB%95%E8%BF%87.md)

  - [Fastjson1.2.25-1.2.47绕过](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/Bypass/Fastjson1.2.25-1.2.47%E7%BB%95%E8%BF%87%E6%97%A0%E9%9C%80AutoType/Fastjson1.2.25-1.2.47%E7%BB%95%E8%BF%87%E6%97%A0%E9%9C%80AutoType.md)

  - [Fastjson1.2.48-1.2.68反序列化漏洞](https://www.anquanke.com/post/id/232774)

  - [Fastjson1.2.68不使用ref引用，不用parseObject触发get方法](https://su18.org/post/fastjson-1.2.68/#getter-%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8)

  - [关于blackhat2021披露的fastjson1.2.68链的一些细节，防止公众号以后找不到同目录下有备份](https://mp.weixin.qq.com/s?__biz=MzUzNDMyNjI3Mg==&mid=2247484866&idx=1&sn=23fb7897f6e54cdf61031a65c602487d&scene=21#wechat_redirect)

  - [2021L3HCTF中关于Fastjson1.2.68的骚操作](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/%E5%85%B6%E4%BB%96/L3HCTF%202021%20Official%20Write%20Up.pdf)

  - [一些有趣的Trick](https://github.com/Y4tacker/JavaSec/blob/main/3.FastJson专区/%E6%9C%89%E8%B6%A3Trick/FastJson%20Trick.md)

  - [fastjson低版本不出网利用(常规很简单的炒陈饭看看就行)](https://mp.weixin.qq.com/s?__biz=MzAwNzk0NTkxNw==&mid=2247486057&idx=1&sn=6799b8b77f058247705beaa6995dcb82&chksm=9b7721bbac00a8adc3ca7b23590bcb7493fc93091eaf76efe4662b7d6f86068e38d20338c3c1&mpshare=1&scene=2&srcid=1109kLt9Pm0fZdiqQ8zbB0IX&sharer_sharetime=1667995572392&sharer_shareid=917ce1404b071ce27556675ad135266f#rd)

  - [FastJson与原生反序列化(一)](https://y4tacker.github.io/2023/03/20/year/2023/3/FastJson%E4%B8%8E%E5%8E%9F%E7%94%9F%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96/)

  - [FastJson与原生反序列化(二)](https://y4tacker.github.io/2023/04/26/year/2023/4/FastJson%E4%B8%8E%E5%8E%9F%E7%94%9F%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96-%E4%BA%8C/)

  - [Fastjson低版本不出网利用(常规很简单的炒陈饭看看就行)](https://mp.weixin.qq.com/s?__biz=MzAwNzk0NTkxNw==&mid=2247486057&idx=1&sn=6799b8b77f058247705beaa6995dcb82&chksm=9b7721bbac00a8adc3ca7b23590bcb7493fc93091eaf76efe4662b7d6f86068e38d20338c3c1&mpshare=1&scene=2&srcid=1109kLt9Pm0fZdiqQ8zbB0IX&sharer_sharetime=1667995572392&sharer_shareid=917ce1404b071ce27556675ad135266f#rd)

  - [Fastjson与原生反序列化](https://y4tacker.github.io/2023/03/20/year/2023/3/FastJson%E4%B8%8E%E5%8E%9F%E7%94%9F%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96/)

- 其他
  - [Java JSON解析特性分析](https://javasec.org/javaweb/JSON/FEATURE.html)
  - [黑盒判断目标的fastjson版本](https://mp.weixin.qq.com/s/jbkN86qq9JxkGNOhwv9nxA)
  - [fastjson探测class/如何判断是fastjson、jackson、gson](https://github.com/safe6Sec/Fastjson)
  - [记一次 Fastjson Gadget 寻找](https://mp.weixin.qq.com/s/dJkZuf6Ho6EK71bbnXI0EA)

## 4.Weblogic专区(虽然也挖了一堆，暂时不想写)
- [T3协议学习](https://github.com/Y4tacker/JavaSec/blob/main/4.Weblogic专区/T3%E5%8D%8F%E8%AE%AE%E5%AD%A6%E4%B9%A0/T3%E5%8D%8F%E8%AE%AE%E5%AD%A6%E4%B9%A0.md)
- [CVE-2015-4852复现分析](https://github.com/Y4tacker/JavaSec/blob/main/4.Weblogic专区/CVE-2015-4852%E5%A4%8D%E7%8E%B0%E5%88%86%E6%9E%90/CVE-2015-4852%E5%A4%8D%E7%8E%B0%E5%88%86%E6%9E%90.md)
- [Weblogic使用ClassLoader和RMI来回显命令执行结果](https://xz.aliyun.com/t/7228)

- [Weblogic SSRF Involving Deserialized JDBC Connection](https://pyn3rd.github.io/2022/06/18/Weblogic-SSRF-Involving-Deserialized-JDBC-Connection/)



## 5.内存马学习专区

- 基础知识

  - [Shell中的幽灵王者—JAVAWEB 内存马 【认知篇】](https://mp.weixin.qq.com/s/NKq4BZ8fLK7bsGSK5UhoGQ)

  - [JavaWeb与Tomcat介绍](https://github.com/Y4tacker/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat%E4%BB%8B%E7%BB%8D/Tomcat%E4%BB%8B%E7%BB%8D.md)

  - [Tomcat-Listener型内存马](https://github.com/Y4tacker/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat-Listener%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC/Tomcat-Listener%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC.md)

  - [Tomcat-Filter型内存马](https://github.com/Y4tacker/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat-Filter%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC/Tomcat-Filter%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC.md)

  - [Tomcat-Servlet型内存马](https://github.com/Y4tacker/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Tomcat-Servlet%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC/Tomcat-Servlet%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC.md)

  - [Tomcat-Valve内存马](https://mp.weixin.qq.com/s/x4pxmeqC1DvRi9AdxZ-0Lw)

  - [Tomcat-Upgrade内存马](https://mp.weixin.qq.com/s/RuP8cfjUXnLVJezBBBqsYw)

  - [WebSocket代理内存马](https://github.com/veo/wsMemShell)

  - [Executor内存马的实现](https://mp.weixin.qq.com/s/uHxQf86zHJvg9frTbjdIdA)

  - [浅谈 Java Agent 内存马(网上看到大师傅写的很详细直接搬运工了)](http://wjlshare.com/archives/1582)

  - [SpringBoot内存马学习-通过添加新路由](https://github.com/Y4tacker/JavaSec/tree/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Spring/%E9%92%88%E5%AF%B9springboot%E7%9A%84controller%E5%86%85%E5%AD%98%E9%A9%AC)

  - [利用intercetor注入Spring内存马](https://github.com/Y4tacker/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Spring/%E5%88%A9%E7%94%A8intercetor%E6%B3%A8%E5%85%A5Spring%E5%86%85%E5%AD%98%E9%A9%AC/index.md)

  - [Timer型内存马](https://github.com/Y4tacker/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Tomcat/Timer%E5%9E%8B%E5%86%85%E5%AD%98%E9%A9%AC/index.md)

  - [看不见的Jsp-Webshell(有点像平时CTF里面php的不死马的效果)](https://mp.weixin.qq.com/s/1ZiLD396088TxiW_dUOFsQ)

  - [看不见的 Jsp-WebShell 第二式增强之无痕](https://mp.weixin.qq.com/s/7b3Fyu_K6ZRgKlp6RkdYoA)

  - [Spring cloud gateway通过SPEL注入内存马](https://gv7.me/articles/2022/the-spring-cloud-gateway-inject-memshell-through-spel-expressions/)
    - [Java安全攻防之Spring Cloud Gateway攻击Redis](https://mp.weixin.qq.com/s/6U1KaLrrtq2dxg55IYASFg)


- Tools
  - [一款支持高度自定义的 Java 内存马生成工具(配合这个学习别人的内存马构造)](https://github.com/pen4uin/java-memshell-generator)



## 6.JavaAgent学习专区

- [Java Instrument插桩技术初体验](https://github.com/Y4tacker/JavaSec/blob/main/6.JavaAgent/JavaInstrument%E6%8F%92%E6%A1%A9%E6%8A%80%E6%9C%AF/JavaInstrument%E6%8F%92%E6%A1%A9%E6%8A%80%E6%9C%AF.md)
- [PreMain之addTransformer与redefineClasses用法学习](https://github.com/Y4tacker/JavaSec/blob/main/6.JavaAgent/PreMain%E4%B9%8BaddTransformer%E4%B8%8EredefineClasses%E7%94%A8%E6%B3%95%E5%AD%A6%E4%B9%A0/PreMain%E4%B9%8BaddTransformer%E4%B8%8EredefineClasses%E7%94%A8%E6%B3%95%E5%AD%A6%E4%B9%A0.md)
- [AgentMain(JVM启动后动态Instrument)](https://github.com/Y4tacker/JavaSec/blob/main/6.JavaAgent/AgentMain/AgentMain.md)
- [通过JVMTI实现C/C++的JavaAgent交互](https://luckymrwang.github.io/2020/12/28/%E7%A0%B4%E8%A7%A3-Java-Agent-%E6%8E%A2%E9%92%88%E9%BB%91%E7%A7%91%E6%8A%80/#JVMTIAgent)

后面因为一些原因打算更系统学习，感觉在这里面直接添加有点臃肿，故开了一个新的repo来记录整个学习阶段，移步[RaspLearning](https://github.com/Y4tacker/RaspLearning)

## 7.Struts2学习专区

一开始不想搞这个是因为很少人用了，后面想了一下可以具体看看struts2当中对OGNL策略如何做提升处理学学别人的绕过(Ps:不教怎么复现搭建环境)

- [Struts2简介与漏洞环境搭建](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA/%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA.md)
- [S2-001学习(由于是第一篇我还是分析的比较详细，后面不会重复本篇里面的一些流程内容)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/s2-001%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/Struts2-001.md)
- [S2-002学习(太鸡肋了感觉实战也比较难出现)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-002%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/S2-002%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90.md)
- [S2-003学习(比较有趣的一个洞很多小细节)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/s2-003%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)
- [S2-005学习(通过Ognl将上下文_memberAccess中的acceptProperties设为空绕过)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/s2-005%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)
- [S2-007学习(字符串拼接导致OGNL解析)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-007%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)
- [S2-008学习(很鸡肋，稍微有点用的有开启devMode解析任意Ognl)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-008%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)

后面突然觉得调试的过程很无聊我也不感兴趣，更感兴趣的是关于Struts当中Ognl的攻防所以后面更偏向于这方面研究，而不再具体跟踪中间的调用过程

- [S2-015学习(静态方法受限制以及没有setAllowStaticMethodAccess后如何绕过)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-015%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)
- [S2-032学习(清空_memberAccess当中excludedXXX限制通过构造函数调用/使用DefaultMemberAccess覆盖SecurityMemberAccess绕过限制)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-032%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)
- [S2-045学习(通过container获取全局共享的OgnlUtil实例来清除SecurityMemberAccess当中属性的限制)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-045%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)
- [S2-057学习(突破#context被删除限制，从attr作用域获取context对象)](https://github.com/Y4tacker/JavaSec/blob/main/7.Struts2%E4%B8%93%E5%8C%BA/S2-057%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/index.md)
- [S2-066学习(变量覆盖的有趣的例子)](https://y4tacker.github.io/2023/12/09/year/2023/12/Apache-Struts2-%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E5%88%86%E6%9E%90-S2-066/)


## 8.关于Tomcat的一些小研究

- [JSTL的可利用点](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/JSTL%E7%9A%84%E5%8F%AF%E5%88%A9%E7%94%A8%E7%82%B9/index.md)

- [一次jsp的奇异探索](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/%E4%B8%80%E6%AC%A1jsp%E7%9A%84%E5%A5%87%E5%BC%82%E6%8E%A2%E7%B4%A2/1.md)
- [Tomcat写文件新利用思路](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/Tomcat%E5%86%99%E6%96%87%E4%BB%B6%E6%96%B0%E5%88%A9%E7%94%A8%E6%80%9D%E8%B7%AF/DC.md)
- [两个关于Tomcat的问题](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/%E4%B8%A4%E4%B8%AA%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E9%97%AE%E9%A2%98/1.md)

- [Java文件上传大杀器-绕waf(针对commons-fileupload组件)](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/Common-fileupload%E7%BB%84%E4%BB%B6%E7%BB%95%E8%BF%87/Java%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E5%A4%A7%E6%9D%80%E5%99%A8-%E7%BB%95waf(%E9%92%88%E5%AF%B9commons-fileupload%E7%BB%84%E4%BB%B6).md)

- [探寻Tomcat文件上传流量层面绕waf新姿势](https://y4tacker.github.io/2022/06/19/year/2022/6/%E6%8E%A2%E5%AF%BBTomcat%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E6%B5%81%E9%87%8F%E5%B1%82%E9%9D%A2%E7%BB%95waf%E6%96%B0%E5%A7%BF%E5%8A%BF/)

- [Tomcat上传.war触发JNDI](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/Tomcat%E4%B8%8A%E4%BC%A0.war%E8%A7%A6%E5%8F%91JNDI/index.md)

- [Servlet的线程安全问题](https://y4tacker.github.io/2022/02/03/year/2022/2/Servlet%E7%9A%84%E7%BA%BF%E7%A8%8B%E5%AE%89%E5%85%A8%E9%97%AE%E9%A2%98/)




## 9.JDBC Attack

关于Make JDBC Attacks Brilliant Again的简单记录，当我们在 JDBC Connection URL可控的情况下，攻击者可以进行什么样的攻击？这部分可以配合[探索高版本 JDK 下 JNDI 漏洞的利用方法](https://tttang.com/archive/1405/)来进行拓展攻击

- [MySQL-JDBC-反序列化漏洞](https://github.com/Y4tacker/JavaSec/blob/main/2.反序列化专区/MySQL-JDBC-%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%BC%8F%E6%B4%9E/MySQL%20JDBC-%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%BC%8F%E6%B4%9E.md)
  - (补充各版本区别)[MySQL JDBC 客户端反序列化漏洞分析](https://www.anquanke.com/post/id/203086)
  - [对fnmsd关于detectCustomCollations触发点的版本纠正](https://xz.aliyun.com/t/10923)
- [H2-RCE](https://github.com/Y4tacker/JavaSec/blob/main/9.JDBC%20Attack/h2/index.md)
- [ModeShape-JNDI](https://github.com/Y4tacker/JavaSec/blob/main/9.JDBC%20Attack/ModeShape/index.md)
- [IBM DB2-JNDI](https://github.com/Y4tacker/JavaSec/blob/main/9.JDBC%20Attack/IBM-DB2/index.md)
- [Apache Derby可触发反序列化](https://github.com/Y4tacker/JavaSec/blob/main/9.JDBC%20Attack/Apache-Derby/index.md)
- [SQLite SSRF](https://github.com/Y4tacker/JavaSec/blob/main/9.JDBC%20Attack/SQLite/index.md)
- [PostgreSQL-RCE(敌不动我不动，你先发poc我放心)](https://github.com/Y4tacker/JavaSec/blob/main/9.JDBC%20Attack/PostGreSQL/index.md)
  - [Make JDBC Attacks Brilliant Again 番外篇(作为上面Postgresql的拓展)](https://tttang.com/archive/1462/)

- [Hive-RCE](https://github.com/Y4tacker/hue-hive-rce)
- [2023BalckHat Asia上补充关于informix-sqli、db2、cloudspanner、avatica、snowflake的利用姿势](https://i.blackhat.com/Asia-23/AS-23-Yuanzhen-A-new-attack-interface-in-Java.pdf)
- [JDBC利用链结合原生反序列化的思路](https://mogwailabs.de/en/blog/2023/04/look-mama-no-templatesimpl/)
- [JDBC Attack URL 绕过合集](https://mp.weixin.qq.com/s/lmoWKK41ZQzZOh-P26VUng)

## 10.关于JNDI的整理

因为比较重要单独列出来了

- [Java RMI 攻击由浅入深(深入源码，师傅写的很好)](https://su18.org/post/rmi-attack/)
- [如何绕过高版本 JDK 的限制进行 JNDI 注入利用](https://paper.seebug.org/942/#classreference-factory)
  - (自己写的流程补充)[高低版JDK下的JNDI注入绕过流程跟踪](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E9%AB%98%E4%BD%8E%E7%89%88JDK%E4%B8%8B%E7%9A%84JNDI%E6%B3%A8%E5%85%A5%E7%BB%95%E8%BF%87%E6%B5%81%E7%A8%8B%E8%B7%9F%E8%B8%AA/%E9%AB%98%E4%BD%8E%E7%89%88JDK%E4%B8%8B%E7%9A%84JNDI%E6%B3%A8%E5%85%A5%E7%BB%95%E8%BF%87%E6%B5%81%E7%A8%8B%E8%B7%9F%E8%B8%AA.md)
- [探索高版本 JDK 下 JNDI 漏洞的利用方法](https://tttang.com/archive/1405/)
- [JNDI jdk高版本绕过—— Druid](https://xz.aliyun.com/t/10656)



## 11.Spring
- [浅谈SpringWeb请求解析过程(很不错的文章把低版本一些绕过的特性基本都提到了)](https://forum.butian.net/share/2214)
- [浅谈Spring与安全约束SecurityConstraint](https://forum.butian.net/index.php/share/2283)
- [SpirngBoot下结合Tomcat实现无OOB方式下的回显](https://github.com/Y4tacker/JavaSec/blob/main/5.%E5%86%85%E5%AD%98%E9%A9%AC%E5%AD%A6%E4%B9%A0/Spring/springboot-tomcat%E5%9B%9E%E6%98%BE/index.md)
- [低版本SpringBoot-SpEL表达式注入漏洞复现分析](https://y4tacker.github.io/2022/02/07/year/2022/2/%E4%BD%8E%E7%89%88%E6%9C%ACSpringBoot-SpEL%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B3%A8%E5%85%A5%E6%BC%8F%E6%B4%9E%E5%A4%8D%E7%8E%B0%E5%88%86%E6%9E%90/)
- [SpringCloud-SnakeYAML-RCE(高版本不可用)](https://y4tacker.github.io/2022/02/08/year/2022/2/SpringCloud-SnakeYAML-RCE/)
- [Spring Boot Vulnerability Exploit Check List](https://github.com/LandGrey/SpringBootVulExploit)
- [SSRF to Rce with Jolokia and Mbeans](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/SSRF%20to%20RCE%20with%20Jolokia%20and%20MBeans%20%E2%80%A2%20Think%20Love%20Share.pdf)
- [CVE-2022-22947 SpringCloudGateWay 远程代码执行](https://github.com/Y4tacker/JavaSec/blob/main/11.Spring/CVE-2022-22947%20SpringCloudGateWay%20%E8%BF%9C%E7%A8%8B%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C/index.md)
- [Spring Cloud Function-SPEL(利用面不大)](https://hosch3n.github.io/2022/03/26/SpringCloudFunction%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/)
- [SpringMVC框架任意代码执行漏洞(CVE-2010-1622)分析](http://rui0.cn/archives/1158)
- [Spring Beans RCE分析(CVE-2022-22965)(我还是喜欢叫Spring4shell，自己懒得写了，这篇还可以，稍微注意下AccessLogValve这个类WBS)](https://xz.aliyun.com/t/11129)
- [Spring Data MongoDB SpEL表达式注入(CVE-2022-22980)(能看但是有些逻辑还是讲得很混乱总体而已还是好的作为参考即可)](https://xz.aliyun.com/t/11484)
- [SpringBoot全局注册Filter过滤XSS](https://github.com/Y4tacker/JavaSec/blob/main/11.Spring/SpringBoot%E5%85%A8%E5%B1%80%E6%B3%A8%E5%86%8CFilter%E8%BF%87%E6%BB%A4XSS/index.md)
- [Springboot devtools反序列化(难点在于secret的获取，当然比如有actuator端点暴露情况下就会变得容易)](https://novysodope.github.io/2022/05/11/77/)
- [浅谈Spring中的Controller参数的验证机制(注意Hibernate Validator的正确配置)](https://forum.butian.net/share/2538)

## 12.Shiro

- [Shiro RememberMe 漏洞检测的探索之路(长亭的一些总结非常不错)](https://stack.chaitin.com/techblog/detail?id=39)
- [Shiro另类检测方式](http://www.lmxspace.com/2020/08/24/%E4%B8%80%E7%A7%8D%E5%8F%A6%E7%B1%BB%E7%9A%84shiro%E6%A3%80%E6%B5%8B%E6%96%B9%E5%BC%8F/)
- [浅谈Shiro执行任意反序列化gadget的方案](https://github.com/Y4tacker/JavaSec/blob/main/12.Shiro/%E6%B5%85%E8%B0%88Shiro%E6%89%A7%E8%A1%8C%E4%BB%BB%E6%84%8F%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96gadget%E7%9A%84%E6%96%B9%E6%A1%88/index.md)
- [CVE-2010-3863权限绕过(通过/./admin绕过/admin,/abc/../admin)](https://github.com/Y4tacker/JavaSec/blob/main/12.Shiro/CVE-2010-3863%E6%9D%83%E9%99%90%E7%BB%95%E8%BF%87/index.md)
- [CVE-2016-6802权限绕过(通过/abc/../y4tacker/admin绕过)](https://github.com/Y4tacker/JavaSec/blob/main/12.Shiro/CVE-2016-6802%E6%9D%83%E9%99%90%E7%BB%95%E8%BF%87/index.md)
- [Shiro550-TemplatesImpl(CC6-Shiro)](https://github.com/phith0n/JavaThings/blob/master/shiroattack/src/main/java/com/govuln/shiroattack/CommonsCollectionsShiro.java)
- [CommonsBeanutils与无 commons-collections的Shiro反序列化利用](https://github.com/phith0n/JavaThings/blob/master/shiroattack/src/main/java/com/govuln/shiroattack/CommonsBeanutils1Shiro.java)
- [另类的shiro检验key的检测方式](http://www.lmxspace.com/2020/08/24/%E4%B8%80%E7%A7%8D%E5%8F%A6%E7%B1%BB%E7%9A%84shiro%E6%A3%80%E6%B5%8B%E6%96%B9%E5%BC%8F/)
- [shiro反序列化漏洞攻击拓展面--修改key](https://tttang.com/archive/1457/)
- [Tomcat-Header长度受限突破shiro回显](https://github.com/Y4tacker/JavaSec/blob/main/12.Shiro/Tomcat-Header%E9%95%BF%E5%BA%A6%E5%8F%97%E9%99%90%E7%AA%81%E7%A0%B4shiro%E5%9B%9E%E6%98%BE/index.md)
- [Spring下Shiro<1.5.0权限绕过(/unauthorize/)](https://github.com/Y4tacker/JavaSec/blob/main/12.Shiro/SHIRO682/index.md)
- [CVE-2020-13933特殊场景权限绕过(通过/unauthorize/%3b)](https://github.com/Y4tacker/JavaSec/blob/main/12.Shiro/CVE-2020-13933%E6%9D%83%E9%99%90%E7%BB%95%E8%BF%87/index.md)
- [SpringBoot2.3.0下Shiro<=1.5.1权限绕过(通过/aa;/%2e%2e/unauthorize绕过对/unauthorize拦截，当然也可以不用目录穿越/;y4tacker/unauthorize也可以)](https://github.com/Y4tacker/JavaSec/tree/main/11.Spring/SpringBoot2.3.0%E4%B8%8BShiro%3C%3D1.5.1%E6%9D%83%E9%99%90%E7%BB%95%E8%BF%87)
- [Spring-Shiro1.5.2 Bypass(通过/unauthorize/a%252Fa绕过对/unauthorize/*的权限限制)](https://github.com/Y4tacker/JavaSec/blob/main/12.Shiro/Spring-Shiro1.5.2%20Bypass/index.md) 
- [记一次 Shiro 的实战利用(突破限制shiro 550利用payload的长度，这种方式不能很好对抗检测文件落地，其实也可以配合上下文一些无害属性多次set写入加载)](https://mp.weixin.qq.com/s/w9sMhMrCy1pofOV-h94qbQ)





## 13.回显相关技术学习

- [通杀漏洞利用回显方法-linux平台](https://www.00theway.org/2020/01/17/java-god-s-eye/)
- [linux下java反序列化通杀回显方法的低配版实现](https://xz.aliyun.com/t/7307)
- [Tomcat中一种半通用回显方法](https://xz.aliyun.com/t/7348)
- [半自动化挖掘request实现多种中间件回显](https://gv7.me/articles/2020/semi-automatic-mining-request-implements-multiple-middleware-echo/)


## 14. JSPWebshell

- [JSP-Webshells集合(三梦的总结挺全面的利用点)](https://github.com/threedr3am/JSP-Webshells)
- [JspWebShell新姿势解读](https://y4tacker.github.io/2022/05/16/year/2022/5/JspWebShell%E6%96%B0%E5%A7%BF%E5%8A%BF%E8%A7%A3%E8%AF%BB/)
- [jsp新webshell的探索之旅](https://y4tacker.github.io/2022/02/03/year/2022/2/jsp%E6%96%B0webshell%E7%9A%84%E6%8E%A2%E7%B4%A2%E4%B9%8B%E6%97%85/)
- [JspWebshell编码混淆篇(unicode和html实体编码那些就懒得写了技术性不强)](https://y4tacker.github.io/2022/11/27/year/2022/11/%E6%B5%85%E8%B0%88JspWebshell%E4%B9%8B%E7%BC%96%E7%A0%81/)


## 15.Waf

- [Java文件上传大杀器-绕waf(针对commons-fileupload组件)](https://y4tacker.github.io/2022/02/25/year/2022/2/Java%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E5%A4%A7%E6%9D%80%E5%99%A8-%E7%BB%95waf(%E9%92%88%E5%AF%B9commons-fileupload%E7%BB%84%E4%BB%B6)/)
- [探寻Java文件上传流量层面waf绕过姿势系列一](https://y4tacker.github.io/2022/06/19/year/2022/6/%E6%8E%A2%E5%AF%BBTomcat%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E6%B5%81%E9%87%8F%E5%B1%82%E9%9D%A2%E7%BB%95waf%E6%96%B0%E5%A7%BF%E5%8A%BF/)
- [探寻Java文件上传流量层面waf绕过姿势系列二](https://y4tacker.github.io/2022/06/21/year/2022/6/%E6%8E%A2%E5%AF%BBJava%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E6%B5%81%E9%87%8F%E5%B1%82%E9%9D%A2waf%E7%BB%95%E8%BF%87%E5%A7%BF%E5%8A%BF%E7%B3%BB%E5%88%97%E4%BA%8C/)
- [Java反序列化数据绕WAF之加大量脏数据 | 回忆飘如雪 (gv7.me)](https://gv7.me/articles/2021/java-deserialize-data-bypass-waf-by-adding-a-lot-of-dirty-data/)
- [Java反序列化脏数据新姿势-对大师傅的姿势补充(个人的小研究)](https://y4tacker.github.io/2022/02/05/year/2022/2/%E5%AF%B9Java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%95%B0%E6%8D%AE%E7%BB%95WAF%E6%96%B0%E5%A7%BF%E5%8A%BF%E7%9A%84%E8%A1%A5%E5%85%85/)
- [Fastjson词法引擎绕waf](https://y4tacker.github.io/2022/03/30/year/2022/3/%E6%B5%85%E8%B0%88Fastjson%E7%BB%95waf/)
- [RCE via SSTI on Spring Boot Error Page with Akamai WAF Bypass](https://h1pmnh.github.io/post/writeup_spring_el_waf_bypass/)


## 16.漏洞复现

- Apache
  - [Apache Commons Configuration 远程代码执行(虽然是配置文件RCE但也有学习意义)](https://xz.aliyun.com/t/11527)
  - [Apache Spark shell command injection vulnerability via Spark UI(之前很早前在我的各个知识星球分享了)](https://github.com/Y4tacker/JavaSec/blob/main/16.%E6%BC%8F%E6%B4%9E%E5%A4%8D%E7%8E%B0/CVE-2022-33891/index.md)
  - [Apache Commons JXPath 远程代码执行](https://github.com/Y4tacker/JavaSec/blob/main/16.%E6%BC%8F%E6%B4%9E%E5%A4%8D%E7%8E%B0/CVE-2022-41852/index.md)
  - [Apache Commons Text 远程代码执行](https://github.com/Y4tacker/JavaSec/blob/main/16.%E6%BC%8F%E6%B4%9E%E5%A4%8D%E7%8E%B0/CVE-2022-42889/index.md)
  - [Log4j2-RCE分析](http://blog.gm7.org/%E4%B8%AA%E4%BA%BA%E7%9F%A5%E8%AF%86%E5%BA%93/02.%E4%BB%A3%E7%A0%81%E5%AE%A1%E8%AE%A1/01.Java%E5%AE%89%E5%85%A8/03.%E5%BA%94%E7%94%A8%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/06.log4j2_rce%E5%88%86%E6%9E%90.html#%E5%A4%8D%E7%8E%B0)
    - [Log4j2不出网检测(靠类型转换、危害有限思路值得学习)](https://cloud.tencent.com/developer/article/2036012)
  - [Apache Flink RCE via jar/plan API Endpoint in JDK8](https://mp.weixin.qq.com/s?__biz=MzkyNDA5NjgyMg==&mid=2247495227&idx=1&sn=5ab9bcc3d89d57ff9799f88c3363814c&chksm=c1d9ae62f6ae2774dd25902c116f6c24f3e5bbf68836f676c25aac53f2c6b771b4a3823c3e7e&mpshare=1&scene=1&srcid=0325kmXWImZrXe0btPMEsJDY&sharer_sharetime=1679735505328&sharer_shareid=19374164c9d8647c6159e09a97bb1208#rd)
  - [Apache Dubbo 反序列化漏洞（CVE-2023-23638）分析及利用探索](https://yyhylh.github.io/2023/04/08/Apache%20dubbo%20%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%BC%8F%E6%B4%9E%EF%BC%88CVE-2023-23638%EF%BC%89%E5%88%86%E6%9E%90%E5%8F%8A%E5%88%A9%E7%94%A8%E6%8E%A2%E7%B4%A2/)
  - [Apache Dubbo反序列化漏洞（CVE-2023-23638）完整利用及工程化实践](https://yyhylh.github.io/2023/05/11/Apache%20Dubbo%20%EF%BC%88CVE-2023-23638%EF%BC%89%E5%AE%8C%E6%95%B4%E5%88%A9%E7%94%A8%E5%8F%8A%E5%B7%A5%E7%A8%8B%E5%8C%96%E5%AE%9E%E8%B7%B5/)
  - [Apache Airflow: Bypass permission verification to view task instances of other dags(CVE-2023-42663)](https://hackerone.com/reports/2208656)
  - [Apache Jackrabbit RMI 远程代码执行漏洞分析(CVE-2023-37895)(这个漏洞适合了解RMI攻击的基础)](https://xz.aliyun.com/t/13118)
  - [Apache ActiveMQ Jolokia远程代码执行不依赖JDK打法](https://y4tacker.github.io/2023/11/30/year/2023/11/Apache-ActiveMQ-Jolokia%E8%BF%9C%E7%A8%8B%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C%E4%B8%8D%E4%BE%9D%E8%B5%96JDK%E6%89%93%E6%B3%95/)
  - Apache OFBiz
     - [Apache OFBiz漏洞 CVE-2023-49070 的前世今生(非常详细)](https://mp.weixin.qq.com/s/iAvitO6otPdHSu1SjRNX3g)
     - [Apache OFBiz未授权命令执行浅析(CVE-2023-51467)](https://y4tacker.github.io/2023/12/27/year/2023/12/Apache-OFBiz%E6%9C%AA%E6%8E%88%E6%9D%83%E5%91%BD%E4%BB%A4%E6%89%A7%E8%A1%8C%E6%B5%85%E6%9E%90-CVE-2023-51467/)
- Oracle
  - [Oracle E-Business Suite Unauthenticated RCE](https://github.com/Y4tacker/JavaSec/blob/main/16.%E6%BC%8F%E6%B4%9E%E5%A4%8D%E7%8E%B0/CVE-2022-21587/index.md)
  - [Exploiting an Order of Operations Bug to Achieve RCE in Oracle Opera](https://blog.assetnote.io/2023/04/30/rce-oracle-opera/)
  - [Oracle Access Manager Pre-Auth RCE (CVE-2021–35587 Analysis)](https://testbnull.medium.com/oracle-access-manager-pre-auth-rce-cve-2021-35587-analysis-1302a4542316)
- Spring
  - [Spring-Kafka-POC-CVE-2023-34040](https://github.com/Contrast-Security-OSS/Spring-Kafka-POC-CVE-2023-34040)
- Nacos
  - [Aliababa Nacos hessian JRaft反序列化(文章里提到的只能打一次有误，后经过研究可以打多次)](https://y4er.com/posts/nacos-hessian-rce/ )
    - [Nacos 多次打非完美方案(这人也没完全考虑到容错，但是网上暂时只有这人的，实际上在构建WriteRequest缺少setOperation)(慎用！别把别人打崩了！)](https://github.com/c0olw/NacosRce)
- Adobe
  - [CVE-2023-29298: Adobe ColdFusion Access Control Bypass](https://www.rapid7.com/blog/post/2023/07/11/cve-2023-29298-adobe-coldfusion-access-control-bypass/)
  - [Analysis CVE-2023-29300: Adobe ColdFusion Pre-Auth RCE](https://blog.projectdiscovery.io/adobe-coldfusion-rce/)
- Smartbi
  - [浅析Smartbi逻辑漏洞](https://y4tacker.github.io/2023/07/05/year/2023/7/%E6%B5%85%E6%9E%90Smartbi%E9%80%BB%E8%BE%91%E6%BC%8F%E6%B4%9E/)
- CrushFTP
  - [CrushFTP Unauthenticated Remote Code Execution(CVE-2023-43177)](https://y4tacker.github.io/2023/12/10/year/2023/12/CrushFTP-Unauthenticated-Remote-Code-Execution-CVE-2023-43177/)
  - [浅析CrushFTP之VFS逃逸](https://y4tacker.github.io/2024/04/23/year/2024/4/%E6%B5%85%E6%9E%90CrushFTP%E4%B9%8BVFS%E9%80%83%E9%80%B8/)
  - [CrushFTP Unauthenticated Remote Code Execution(CVE-2024-4040)](https://attackerkb.com/topics/20oYjlmfXa/cve-2024-4040/rapid7-analysis)
  - [CrushFTP后利用提权分析(CVE-2024-4040)](https://y4tacker.github.io/2024/04/25/year/2024/4/CrushFTP%E5%90%8E%E5%88%A9%E7%94%A8%E6%8F%90%E6%9D%83%E5%88%86%E6%9E%90-CVE-2024-4040/)
- Others
  - [HtmlUnit-RCE](https://siebene.github.io/2022/12/30/HtmlUnit-RCE/)
  - [openfire鉴权绕过漏洞原理解析(主要是学习jetty对%u002e请求的解析支持)](https://mp.weixin.qq.com/s/EzfB8CM4y4aNtKFJqSOM1w)
  - [Metabase-Pre auth RCE](https://blog.assetnote.io/2023/07/22/pre-auth-rce-metabase/)
  - [Ivanti Sentry Authentication Bypass](https://www.horizon3.ai/ivanti-sentry-authentication-bypass-cve-2023-38035-deep-dive/)
  - [UNAUTHENTICATED SERVER SIDE REQUEST FORGERY & CRLF INJECTION IN GEOSERVER WMS(CRLF注入的好例子)](https://www.synacktiv.com/advisories/unauthenticated-server-side-request-forgery-crlf-injection-in-geoserver-wms)
  - [JetBrains TeamCity 任意代码执行漏洞分析(CVE-2023-42793)](https://forum.butian.net/share/2514)
  - [SysAid On-Prem Software(CVE-2023-47246)](https://forum.butian.net/share/2577)
  - [MCMS属性覆盖全版本Bypass分析(又又又是一个属性覆盖带来的漏洞)](https://y4tacker.github.io/2023/12/28/year/2023/12/%E5%8F%88%E5%8F%88%E5%8F%88%E6%98%AF%E4%B8%80%E4%B8%AA%E5%B1%9E%E6%80%A7%E8%A6%86%E7%9B%96%E5%B8%A6%E6%9D%A5%E7%9A%84%E6%BC%8F%E6%B4%9E/)
  - [Atlassian Confluence-Remote Code Execution(CVE-2023-22527)](https://blog.projectdiscovery.io/atlassian-confluence-ssti-remote-code-execution/)
  - [Jenkins文件读取漏洞拾遗（CVE-2024-23897）](https://www.leavesongs.com/PENETRATION/jenkins-cve-2024-23897.html)


## 17.模板引擎+表达式相关

- 模板引擎

  - [velocity 模板注入](https://www.cnblogs.com/nice0e3/p/16218857.html)

  - [freemarker 模板注入](https://www.cnblogs.com/nice0e3/p/16217471.html)

  - [pebble模板注入](https://github.com/Y4tacker/JavaSec/blob/main/%E6%AF%94%E8%B5%9B%E5%8F%8D%E6%80%9D/2022/8/uiuctf-pebble/index.md)

  - [thymeleaf模板注入](https://xz.aliyun.com/t/10514)

  - [国产Jfinal用的Enjoy模板引擎主要研究不出网利用](https://y4tacker.github.io/2022/04/14/year/2022/4/Enjoy%E6%A8%A1%E6%9D%BF%E5%BC%95%E6%93%8E%E5%88%86%E6%9E%90/)
  - [Beetl3.15.0以下模板注入(高版本仍然有办法Rce)](https://gitee.com/xiandafu/beetl/issues/I6RUIP)


- 表达式

  - EL表达式

    - [普通EL表达式命令回显的简单研究](https://forum.butian.net/share/886)

    - [一种新型Java一句话木马的实现](https://yzddmr6.com/posts/%E4%B8%80%E7%A7%8D%E6%96%B0%E5%9E%8BJava%E4%B8%80%E5%8F%A5%E8%AF%9D%E6%9C%A8%E9%A9%AC%E7%9A%84%E5%AE%9E%E7%8E%B0/)
    - [el表达式绕waf的trick](https://github.com/Y4tacker/JavaSec/blob/main/17.%E6%A8%A1%E6%9D%BF%E5%BC%95%E6%93%8E%2B%E8%A1%A8%E8%BE%BE%E5%BC%8F%E7%9B%B8%E5%85%B3/el%E8%A1%A8%E8%BE%BE%E5%BC%8F%E7%BB%95waf%E7%9A%84trick/index.md)

  

## 18.各框架对URI处理的特性及Trick

- [Tomcat URL解析差异性导致的安全问题(网上看到的主要关注HttpServletRequest中几个解析URL的函数这个问题)](https://xz.aliyun.com/t/7544)
- [Tomcat中url解析特性](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/Tomcat%E4%B8%ADurl%E8%A7%A3%E6%9E%90%E7%89%B9%E6%80%A7/index.md)
- [SpringBoot2.3.0以下路由%2e跨目录处理(可用于权限绕过)](https://github.com/Y4tacker/JavaSec/blob/main/11.Spring/SpringBoot2.3.0%E4%BB%A5%E4%B8%8B%E8%B7%AF%E7%94%B1%252e%E8%B7%A8%E7%9B%AE%E5%BD%95%E5%A4%84%E7%90%86(%E5%8F%AF%E7%94%A8%E4%BA%8E%E6%9D%83%E9%99%90%E7%BB%95%E8%BF%87)/index.md)

- [网上看到的Jetty的部分解析特性(支持%uxxx)](https://www.wangan.com/p/7fyg8k2c7781675a)


## 19.ASM与JVM学习


- [JAVA虚拟机执行模型(关注引入了栈映射帧，用于加快虚拟机中类验证过程的速度)](https://www.cnblogs.com/coding-way/p/6600647.html)
- [What is a stack map frame](https://stackoverflow.com/questions/25109942/what-is-a-stack-map-frame)
  - 这里比较有意思的是：Java 1.7引入了此选项以加速类验证。框架分为两部分：变量类型和堆栈类型。第一帧由方法类型描述。在每个GOTO / JUMP调用之后，您需要提供堆栈映射框架的更新描述。为了节省空间，可以使用SAME，APPEND等选项，也可以通过指定变量类型的FULL数组再次描述所有变量。
- [为什么JVM需要DUP指令](https://www.cnblogs.com/clayjj/p/7698035.html)

## 20.议题
- [Hacking FernFlower](https://y4tacker.github.io/2023/12/22/year/2023/12/Hacking-FernFlower/)
  - [议题相关代码](https://github.com/Y4tacker/HackingFernFlower)



## 其他分享
- JMX
  - [JMX RMI攻击利用](https://github.com/k1n9/k1n9.github.io/blob/aeeb609fe6a25d67bc2dc5f990a501368fb25409/_posts/2017-08-24-attack-jmx-rmi.md)
  - [一次从jmx到rce](https://mp.weixin.qq.com/s?__biz=MzIwMzIyMjYzNA==&mid=2247506824&idx=1&sn=1bff6060290c0fdb7fe059cff2c61153&chksm=96d0208da1a7a99b6e61c8e3c332d324c0296bbccf1163cb8a10760e57cd17e150cb23a0e36a&mpshare=1&scene=1&srcid=1220PA2K5MY7dM3gWTr06z4r&sharer_sharetime=1671532238935&sharer_shareid=19374164c9d8647c6159e09a97bb1208#rd)
  - [tomcat-jmxproxy-rce-exp(JMX with AccessLogValve)](https://www.wangan.com/p/11v6cf3fcad1500e)
- [GadgetInspector源码分析](https://y4tacker.github.io/2022/05/09/year/2022/5/GadgetInspector%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90/)
- [CVE-2021-2471 JDBC-XXE漏洞分析](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/CVE-2021-2471%20JDBC-XXE%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/CVE-2021-2471%20JDBC-XXE%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90.md)
- [spring-messaging 远程代码执行漏洞分析](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/spring-messaging%20%E8%BF%9C%E7%A8%8B%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90/spring-messaging%20%E8%BF%9C%E7%A8%8B%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90.md)
- [CVE-2020-9484 Tomcat-RCE漏洞分析报告(备注:三梦师傅的文章，提升了我对Tomcat配置的了解)](https://threedr3am.github.io/2020/06/12/CVE-2020-9484%20Tomcat-RCE%E6%BC%8F%E6%B4%9E%E5%88%86%E6%9E%90%E6%8A%A5%E5%91%8A/)
- [Java “后反序列化漏洞” 利用思路](https://paper.seebug.org/1133/)
- [关于Servlet的线程安全问题](https://y4tacker.github.io/2022/02/03/year/2022/2/Servlet%E7%9A%84%E7%BA%BF%E7%A8%8B%E5%AE%89%E5%85%A8%E9%97%AE%E9%A2%98/)
- [BypassSM](https://github.com/Y4tacker/JavaSec/blob/main/其他/BypassSM/bypasssm.md)
- [Spring Boot FatJar任意写目录漏洞导致Getshell](https://www.cnblogs.com/wh4am1/p/14681335.html)
- [利用TemplatesImpl执行字节码](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E5%88%A9%E7%94%A8TemplatesImpl%E6%89%A7%E8%A1%8C%E5%AD%97%E8%8A%82%E7%A0%81/%E5%88%A9%E7%94%A8TemplatesImpl%E6%89%A7%E8%A1%8C%E5%AD%97%E8%8A%82%E7%A0%81.md)
- [为什么补丁都喜欢打在resolveClass](https://github.com/Y4tacker/JavaSec/blob/main/4.Weblogic专区/%E4%B8%BA%E4%BB%80%E4%B9%88%E8%A1%A5%E4%B8%81%E5%96%9C%E6%AC%A2%E6%89%93%E5%9C%A8resolveClass/%E4%B8%BA%E4%BB%80%E4%B9%88%E8%A1%A5%E4%B8%81%E5%96%9C%E6%AC%A2%E6%89%93%E5%9C%A8resolveClass.md)
- [Java沙箱绕过](https://www.anquanke.com/post/id/151398)
- [一种普遍存在于java系统的缺陷 - Memory DoS](https://threedr3am.github.io/2021/11/18/%E4%B8%80%E7%A7%8D%E6%99%AE%E9%81%8D%E5%AD%98%E5%9C%A8%E4%BA%8Ejava%E7%B3%BB%E7%BB%9F%E7%9A%84%E7%BC%BA%E9%99%B7-Memory%20DoS/#more)
- [如何关闭百度的Rasp](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/%E5%85%B3%E9%97%AD%E7%99%BE%E5%BA%A6%E7%9A%84Rasp/index.md)
- [漫谈 JEP 290](https://paper.seebug.org/1689/#_1)
- [Java Web —— 从内存中Dump JDBC数据库明文密码(还挺好玩的)](https://mp.weixin.qq.com/s/QCfqO2BJuhSOr58rldZzxA)
- [如何带依赖打包Jar](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/Maven/index.md)
- [一些Java二次反序列化的点(持续收集)](https://github.com/Y4tacker/JavaSec/blob/main/%E5%85%B6%E4%BB%96/Java%E4%BA%8C%E6%AC%A1%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96/Java%E8%A7%A6%E5%8F%91%E4%BA%8C%E6%AC%A1%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E7%9A%84%E7%82%B9.md)
  - [帆软channel接口反序列化漏洞分析(二次反序列化一些实战场景利用)](https://forum.butian.net/share/2806)
- [自己写的OpenRasp分析](https://y4tacker.github.io/2022/05/28/year/2022/5/OpenRasp%E5%88%86%E6%9E%90/)
- [Apache Unomi 表达式注入攻防](https://github.com/1135/unomi_exploit)
- [JEXL3表达式注入](https://xz.aliyun.com/t/8099)
- [利用JVMTI实现JAR包加密(还没看很牛逼就是了)](https://mp.weixin.qq.com/s/jH8TNvY8bAu0m2kQBvpQyg)
- [安全同学讲Maven重打包的故事](https://mp.weixin.qq.com/s?__biz=MzIzOTU0NTQ0MA==&mid=2247510513&idx=1&sn=fbcd84ba56d0c04dbd28b42f10f3bfb1&chksm=e92a94fede5d1de8e8301f8efb9db5e3f1a4fc14a5e29be541668d706a77141bbbd8d63db1ac&mpshare=1&scene=1&srcid=1025aCfF1bF9RgdhX85sgkj3&sharer_sharetime=1666696525299&sharer_shareid=4a549281c7d8f067d766da5aff57a064#rd)
- [某软件监控页面RCE漏洞分析(虽然过于简单，但是可以借此了解下OA系统)](https://xz.aliyun.com/t/11778)
- [JDK-Xalan的XSLT整数截断漏洞利用构造](https://mp.weixin.qq.com/s/xxAtjFvk9RxWiY-pwGf8Ow)
- [某Cloud系统漏洞分析](https://forum.butian.net/share/2529)
- [任意文件下载漏洞的利用思考(总结非常细！)](https://mp.weixin.qq.com/s/3y62xuQJAj2gmtBSKvHHug)


## 比赛反思

特地加了一栏吧，希望从比赛当中了解Java相关的东西学习一些新的点！

- [Codegate2022(关键词:绕过开头file协议读文件、xpath注入读系统配置)](https://github.com/Y4tacker/JavaSec/blob/main/%E6%AF%94%E8%B5%9B%E5%8F%8D%E6%80%9D/2022/3/Codegate2022/index.md)
- [SUSCTF2022(关键词:绕rasp、fastjson、xxe)](https://github.com/Y4tacker/JavaSec/tree/main/%E6%AF%94%E8%B5%9B%E5%8F%8D%E6%80%9D/2022/3/SUSCTF2022)
- [D^3CTF2022(关键词:ROME链缩短、Mybatis与Ognl)](https://y4tacker.github.io/2022/03/07/year/2022/3/ROME%E6%94%B9%E9%80%A0%E8%AE%A1%E5%88%92/)
- [虎符CTF2022(关键词:Hessian反序列化、Rome二次反序列化、java.security.SignedObject#getObject、UnixPrintService命令执行、Tabby)](https://y4tacker.github.io/2022/03/21/year/2022/3/2022%E8%99%8E%E7%AC%A6CTF-Java%E9%83%A8%E5%88%86/)
- [MRCTF2022(关键词:Kryo反序列化、Rome二次反序列化、内存马、Bypass SerialKiller黑名单-找替代类)](https://y4tacker.github.io/2022/04/24/year/2022/4/2022MRCTF-Java%E9%83%A8%E5%88%86/)
- [GoogleCTF2022(关键词：Log4j2、Bundle、ReDoS)](https://github.com/Y4tacker/JavaSec/blob/main/%E6%AF%94%E8%B5%9B%E5%8F%8D%E6%80%9D/2022/3/2022GooGleCTF/index.md)
- [UIUCTF2022-Spoink(关键词：Pebble最新模板注入Bypass、Spring中无路由上传文件处理)](https://github.com/Y4tacker/JavaSec/blob/main/%E6%AF%94%E8%B5%9B%E5%8F%8D%E6%80%9D/2022/8/uiuctf-pebble/index.md)
- [TetCTF2023&Liferay(CVE-2019-16891)(Pre-Auth RCE)](https://y4tacker.github.io/2023/01/03/year/2023/TetCTF2023-Liferay-CVE-2019-16891-Pre-Auth-RCE/)



## 环境

- [如何远程调试Weblogic](https://github.com/QAX-A-Team/WeblogicEnvironment)
- [使用idea进行tomcat源码调试](https://zhuanlan.zhihu.com/p/35454131)
- [一些国产系统的环境搭建问题](https://github.com/ax1sX/SecurityList/)

 

## Todolist

- 解决反序列化serialVesionUID不一致问题--已经拿下
- [Dubbo学习之后开启](https://xz.aliyun.com/t/10916)
- [无文件落地Agent型内存马植入(Java内存攻击技术漫谈-Rebyond)](https://xz.aliyun.com/t/10075#toc-5)
- 自己对所有文件上传框架Trick总结
- 消化腾讯大师傅写的关于文件上传waf



## 注意事项

* 本仓库仅用于合法合规用途，严禁用于违法违规用途。
* 本工具中所涉及的漏洞均为网上已公开。



## 优质博客

- [Y4tacker(自己的能不写吗)](https://y4tacker.github.io/)
- [三梦](https://threedr3am.github.io/)
- [su18](https://su18.org/)
- [landgrey](https://landgrey.me/)
- [回忆飘如雪](https://gv7.me/)



## 更多



<div align=center><img src="https://api.star-history.com/svg?repos=Y4tacker/JavaSec&type=Timeline" div align=center/></div>
