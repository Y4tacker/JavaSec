# 补充

## CDATA特性

jsp支持xml格式

```jsp
String cmd = request.getPar<![CDATA[ameter]]>("shell");
```

## 与Charsets.forName有关

```java
java.net.URLDecoder.decode("aa","utf8");
new java.lang.String(new byte[]{66},"utf-8");
```

