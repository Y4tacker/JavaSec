# Java类字节码编辑

## Javassist介绍

`Javassist`是一个开源的分析、编辑和创建Java字节码的类库；相比ASM，`Javassist`提供了更加简单便捷的API，使用`Javassist`我们可以像写Java代码一样直接插入Java代码片段，让我们不再需要关注Java底层的字节码的和栈操作，仅需要学会如何使用`Javassist`的API即可实现字节码编辑

`Javassist`为我们提供了类似于Java反射机制的API，如：[CtClass](http://www.javassist.org/html/javassist/CtClass.html)，[CtConstructor](http://www.javassist.org/html/javassist/CtConstructor.html)、[CtMethod](http://www.javassist.org/html/javassist/CtMethod.html)、[CtField](http://www.javassist.org/html/javassist/CtField.html)与Java反射的`Class`、`Constructor`、`Method`、`Field`非常的类似。

| 类            | 描述                                                         |
| ------------- | ------------------------------------------------------------ |
| ClassPool     | ClassPool是一个存储CtClass的容器，如果调用`get`方法会搜索并创建一个表示该类的CtClass对象 |
| CtClass       | CtClass表示的是从ClassPool获取的类对象，可对该类就行读写编辑等操作 |
| CtMethod      | 可读写的类方法对象                                           |
| CtConstructor | 可读写的类构造方法对象                                       |
| CtField       | 可读写的类成员变量对象                                       |

`Javassist`使用了内置的标识符来表示一些特定的含义，如：`$_`表示返回值。我们可以在动态插入类代码的时候使用这些特殊的标识符来表示对应的对象。

| 表达式            | 描述                                      |
| ----------------- | ----------------------------------------- |
| `$0, $1, $2, ...` | `this`和方法参数                          |
| `$args`           | `Object[]`类型的参数数组                  |
| `$$`              | 所有的参数，如`m($$)`等价于`m($1,$2,...)` |
| `$cflow(...)`     | cflow变量                                 |
| `$r`              | 返回类型，用于类型转换                    |
| `$w`              | 包装类型，用于类型转换                    |
| `$_`              | 方法返回值                                |
| `$sig`            | 方法签名，返回`java.lang.Class[]`数组类型 |
| `$type`           | 返回值类型，`java.lang.Class`类型         |
| `$class`          | 当前类，`java.lang.Class`类型             |

## 读取类/成员变量/方法信息

```java
import javassist.*;

import java.util.Arrays;

public class ABC {
    public static void main(String[] args) throws Exception{
        ClassPool classPool  = ClassPool.getDefault();
        CtClass ctClass = classPool.get("HelloWorld");
        System.out.println(
                "解析类名：" + ctClass.getName() + "，父类：" + ctClass.getSuperclass().getName() +
                        "，实现接口：" + Arrays.toString(ctClass.getInterfaces())
        );
        System.out.println("----------------------------------------------");
        // 获取所有的构造方法
        CtConstructor[] declaredConstructors = ctClass.getDeclaredConstructors();
        for (CtConstructor ctConstructor:declaredConstructors){
            System.out.println(ctConstructor.getMethodInfo());
        }
        // 获取所有的成员变量
        CtField[] ctFields = ctClass.getDeclaredFields();

        // 获取所有的成员方法
        CtMethod[] ctMethods = ctClass.getDeclaredMethods();
        // 输出所有成员变量
        for (CtField ctField : ctFields) {
            System.out.println(ctField);
        }
        // 输出所有的成员方法
        for (CtMethod ctMethod : ctMethods) {
            System.out.println(ctMethod);
        }
    }
}
```

## 修改类方法

`CtMethod`提供了类方法修改的API，如：`setModifiers`可修改类的访问修饰符，`insertBefore`和`insertAfter`能够实现在类方法执行的前后插入任意的Java代码片段，`setBody`可以修改整个方法的代码等。

```java
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class DEF {
    public static void main(String[] args) throws Exception{
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("HelloWorld");
        CtMethod helloMethod = ctClass.getDeclaredMethod("helllo", new CtClass[]{classPool.get("java.lang.String")});
        // 修改方法的访问权限为private$$
        helloMethod.setModifiers(Modifier.PRIVATE);

        // 输出hello方法的content参数值
        helloMethod.insertBefore("System.out.println($1);");

        // 输出hello方法的返回值
        helloMethod.insertAfter("System.out.println($_); return \"Return:\" + $_;");

        File classFilePath = new File(new File(System.getProperty("user.dir"), "target/classes"), "HelloWorld.class");

        // 使用类CtClass，生成类二进制
        byte[] bytes = ctClass.toBytecode();

        // 将class二进制内容写入到类文件
        FileUtils.writeByteArrayToFile(classFilePath, bytes);
    }
}
```

## 动态创建Java类二进制

```java
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class HIJ {
    public static void main(String[] args) throws Exception{
        // 创建ClassPool对象
        ClassPool classPool = ClassPool.getDefault();

        // 使用ClassPool创建一个JavassistHelloWorld类
//        CtClass ctClass = classPool.makeClass("HelloWorld");
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\testjst\\target\\classes\\HelloWorld.class"));
        int read;
        byte[] bytess = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((read=fileInputStream.read(bytess))!=-1){
            outputStream.write(bytess,0,read);
        }
        // 使用javassist将类二进制解析成CtClass对象

        CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(outputStream.toByteArray()));
        try {
            // 创建类成员变量content
            CtField ctField = CtField.make("private static String content = \"Hello world~\";", ctClass);

            // 将成员变量添加到ctClass对象中
            ctClass.addField(ctField);

            // 创建一个主方法并输出content对象值
            CtMethod ctMethod = CtMethod.make(
                    "public static void main(String[] args) {System.out.println(content);}", ctClass
            );

            // 将成员方法添加到ctClass对象中
            ctClass.addMethod(ctMethod);

            File classFilePath = new File(new File(System.getProperty("user.dir"), "target/classes/"), "HelloWorld.class");

            // 使用类CtClass，生成类二进制
            byte[] bytes = ctClass.toBytecode();

            // 将class二进制内容写入到类文件
            FileUtils.writeByteArrayToFile(classFilePath, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```



## 官方文档

[Getting Started with Javassist](http://www.javassist.org/tutorial/tutorial.html)