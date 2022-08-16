# SpringBoot2.3.0下Shiro<=1.5.1权限绕过

影响版本

SpringBoot<=2.3.0 Release

Spring-shiro<=1.5.1

## 场景一

看本篇之前可以看看上一篇[SpringBoot2.3.0以下路由%2e跨目录处理](https://github.com/Y4tacker/JavaSec/blob/main/11.Spring/SpringBoot2.3.0%E4%BB%A5%E4%B8%8B%E8%B7%AF%E7%94%B1%252e%E8%B7%A8%E7%9B%AE%E5%BD%95%E5%A4%84%E7%90%86(%E5%8F%AF%E7%94%A8%E4%BA%8E%E6%9D%83%E9%99%90%E7%BB%95%E8%BF%87)/index.md)

这个绕过主要是利用了 shiro 对 url 中的 ";" 处理来绕过，之后我们配合spring当中低版本下对跨目录的处理来恢复正常请求

来看看`shiro`的处理，我们看看是如何来匹配限制的，在`org.apache.shiro.web.filter.PathMatchingFilter#pathsMatch(java.lang.String, javax.servlet.ServletRequest)`

在这当中首先调用`getPathWithinApplication`来获取检测的路由

```java
protected boolean pathsMatch(String path, ServletRequest request) {
  String requestURI = this.getPathWithinApplication(request);
  log.trace("Attempting to match pattern '{}' with current requestURI '{}'...", path, requestURI);
  return this.pathsMatch(path, requestURI);
}
```

而这里最终处理其实是在`org.apache.shiro.web.util.WebUtils#getPathWithinApplication`当中

```java
public static String getPathWithinApplication(HttpServletRequest request) {
  String contextPath = getContextPath(request);
  String requestUri = getRequestUri(request);
  if (StringUtils.startsWithIgnoreCase(requestUri, contextPath)) {
    String path = requestUri.substring(contextPath.length());
    return StringUtils.hasText(path) ? path : "/";
  } else {
    return requestUri;
  }
}
```

在这个场景下，我们主要关注获取requestUri这部分,这里先获取请求的uri

```java
public static String getRequestUri(HttpServletRequest request) {
  String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
  if (uri == null) {
    uri = request.getRequestURI();
  }

  return normalize(decodeAndCleanUriString(request, uri));
}
```

之后关键就在`decodeAndCleanUriString`当中，第一行其实就是做URL解码操作不需要多看，之后就是如何处理分号的问题，可以看到shiro对分号处理是直接截取返回分号前内容，简单来说就是`/aa;/bb`返回`/aa`，之后的路径标准化处理不关键

```java
private static String decodeAndCleanUriString(HttpServletRequest request, String uri) {
  uri = decodeRequestString(request, uri);
  int semicolonIndex = uri.indexOf(59);
  return semicolonIndex != -1 ? uri.substring(0, semicolonIndex) : uri;
}
```

因此我们访问`/aa;/%2e%2e/unauthorize`,shiro就会认为这次的请求是`/aa`从而绕过了权限的校验过程

而spring处理请求则是找到能匹配到path的handler，在低版本下则是获取servletPath，在之前那篇当中也简单提过这里面会对URL做URL解码，解码后会做路径标准化处理最终也就处理了我们的跨目录的处理

同时的话这是tomcat做的处理，而tomcat如何处理`;`也在之前的文章中提到过([Tomcat中的url解析特性](https://github.com/Y4tacker/JavaSec/blob/main/8.%E5%85%B3%E4%BA%8ETomcat%E7%9A%84%E4%B8%80%E4%BA%9B%E5%88%86%E4%BA%AB/Tomcat%E4%B8%ADurl%E8%A7%A3%E6%9E%90%E7%89%B9%E6%80%A7/index.md))

之后匹配到具体的路由则会访问返回内容，也是很简单的

顺便也可以看看在1.5.2当中shiro是怎么做的修复

```java
public static String getRequestUri(HttpServletRequest request) {
  String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
  if (uri == null) {
    uri = valueOrEmpty(request.getContextPath()) + "/" + valueOrEmpty(request.getServletPath()) + valueOrEmpty(request.getPathInfo());
  }

  return normalize(decodeAndCleanUriString(request, uri));
}
```

关键点在于request.getServletPath()，它最终调用

```java
public String getServletPath() {
  return this.mappingData.wrapperPath.toString();
}
```

也是开头提到的文章提到过哦,里面的值就是之前做处理的部分`org.apache.catalina.connector.CoyoteAdapter#postParseRequest`，具体操作就是url解码后做路径标准化处理，因此最终这个uri的值就变成了`//unauthorize`再经过之后` normalize(decodeAndCleanUriString(request, uri))`处理过后则最终成功拦截

这样就安全了么？并不是的可以看到这里使用decodeAndCleanUriString，做了url解码而本身已经做了一次了，这里就做了两次url解码，因此也可以进行特定配置下绕过，我们下篇在谈



## 场景二

或者也可以通过`/;abcd/unauthorize`或者`/;/unauthorize`绕过访问

原理一样的只是拓展下payload，毕竟上面这个访问的url

对spring来说第一次处理后变成`//unauthorize`再经过路径标准化后`/unauthorize`，而shiro是直接去掉了`;`后面的部分再做路由拦截
