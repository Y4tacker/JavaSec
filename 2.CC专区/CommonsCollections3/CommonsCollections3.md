# CommonsCollections3

## 分析

为什么需要CC3，主要是绕过黑名单避免我们使⽤ `InvokerTransformer`⼿⼯调⽤ `newTransformer() `⽅法

我们来看看`InstantiateTransformer`这个类的`transform`方法![](img/1.png)

可以看到这里帮助我们利用反射实例化一个类，而我们需要实例化的类是`TrAXFilter`

看看他的构造方法![](img/2.png)

看到`newTransformer`便不难想到利用`TemplatesImpl`执行字节码了

接下来就是解决如何触发这个了，还是使用动态代理

为了兼容性还是采用lazymap的get请求触发，详细的过程cc1已经说了没必要重复