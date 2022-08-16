# 浅谈Shiro执行任意反序列化gadget的方案

为什么有这个主要是transformer数组执行的限制，在我心中只有一个比较好的方案，总的来说就是做中转

一个是很明显既然受限制不能使用transformer数组，那我们就只调用一个单独的transform方法，而InvokerTransformer可以帮助我们调用任意方法，这时候有一个`RMIConnector`类它调用`connect`方法，配合`JMXServiceURL`可以做二次反序列化，绕过这一点限制

这样的例子也不少见，比如`java.security.SignedObject#getObject`也可以触发二次反序列化

另一个的话就是攻击RMI的手段，简单来说就是用JRMP就行

可选的有`UnicastRemoteObject`/`UnicastRef`/`RemoteObject`

很简单应该还有其他解决方法，太多了
