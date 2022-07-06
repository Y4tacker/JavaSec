# 通过反射扫描被注解修饰的类

## 注解

首先来谈谈注解是什么？

简单说来其实就是Java中的一个常见特性，是 JDK5.0 引入的一种注释机制。

Java 语言中的类、方法、变量、参数和包等都可以被标注。和 Javadoc 不同，Java 标注可以通过反射获取标注内容。在编译器生成类文件时，标注可以被嵌入到字节码中。Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容 。 当然它也支持自定义 Java 标注。



具体的如何去实现可以看看：https://www.jianshu.com/p/b7d596874e71

## 通过反射获取具体实现

前提注解的元注解有`@Retention(RetentionPolicy.RUNTIME)`(代表虚拟机将在运行期间保留注解，因此可以通过反射机制读取注解的信息)



## 使用现有reflections框架

```xml
<dependency>
  <groupId>org.reflections</groupId>
  <artifactId>reflections</artifactId>
  <version>0.9.11</version>
</dependency>

<dependency> 
  <groupId>com.google.guava</groupId> 
  <artifactId>guava</artifactId>
  <version>21.0</version>
</dependency>
```

具体扫描代码

```java
        Reflections f = new Reflections("org.apache.logging.log4j.core");
        int i = 0;
        Set<Class<?>> set = f.getTypesAnnotatedWith(ConverterKeys.class);
        for (Class<?> tmp:set){
            if (tmp.isInterface()){
                System.out.println(i+".interface:"+tmp.getName());
            }else {
                System.out.println(i+".class:"+tmp.getName());
            }
            i +=1 ;

        }
```

但是发现这个的结果不准确，比如扫描得到这个类`org.apache.logging.log4j.core.pattern.LevelPatternConverter$SimpleLevelPatternConverter`点开一看这个内部类根本就没有`@ConverterKeys`注解修饰甚至连一个注解都没有，我也不想去看这个具体的实现，索性重写



## 自己实现一个更精准的扫描

直接上代码吧里面有注释

```java
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ScanPackageByAnnotation {

    public void addClass(Set<Class<?>> classes, String filePath, String packageName) throws Exception {
        File[] files = new File(filePath).listFiles(file -> (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory());
        assert files != null;
        for (File file : files) {
            String fileName = file.getName();
            if (file.isFile()) {
                String classsName = fileName.substring(0, fileName.lastIndexOf("."));
                if (!packageName.isEmpty()) {
                    classsName = packageName + "." + classsName;
                }
                ClassLoader classLoader = new ClassLoader() {
                    @Override
                    public Class<?> loadClass(String name) throws ClassNotFoundException {
                        return super.loadClass(name);
                    }
                };
                classes.add(classLoader.loadClass(classsName));
            }

        }
    }

    public Set<Class<?>> getClassesByPackageName(String packageName) throws Exception {
        //返回的结果
        HashSet<Class<?>> retClasses = new HashSet<>();
        // 获取包的名字 并进行替换
        String packageDirName = packageName.replace('.', '/');
        // 是否循环迭代
        boolean recursive = true;
        Enumeration<URL> dirs = null;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

            while (dirs.hasMoreElements()){
                // 获取下一个元素
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)){
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    addClass(retClasses, filePath, packageName);
                }else if("jar".equals(protocol)){
                    // 如果是jar包文件
                    // 定义一个JarFile
                    JarFile jar;
                    try {
                        // 获取jar
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // 如果是以/开头的
                            if (name.charAt(0) == '/') {
                                // 获取后面的字符串
                                name = name.substring(1);
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                // 如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    // 获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx).replace('/', '.');
                                }
                                // 如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive) {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory()) {
                                        // 去掉后面的".class" 获取真正的类名
                                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                                        try {
                                            // 添加到classes
                                            retClasses.add(Class.forName(packageName + '.' + className));
                                        } catch (ClassNotFoundException|NoClassDefFoundError ignored) {
//                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){

        }

        return  retClasses;

    }

    public <A extends Annotation> Set<Class<?>> getAnnotationClasses(String packageName, Class<A> annotationClass) throws Exception {

        //找用了annotationClass注解的类
        Set<Class<?>> controllers = new HashSet<>();
        Set<Class<?>> clsList = getClassesByPackageName(packageName);
        if (clsList != null && clsList.size() > 0) {
            for (Class<?> cls : clsList) {
                if (cls.getAnnotation(annotationClass) != null) {
                    controllers.add(cls);
                }
            }
        }
        return controllers;
    }

    public static void main(String[] args) throws Exception{
        Set<Class<?>> classesByPackageName = new ScanPackageByAnnotation().getAnnotationClasses("org.apache.logging.log4j.core", ConverterKeys.class);
        for (Class<?> tmp:classesByPackageName){
            if (tmp.isInterface()){
                System.out.println("interface:"+tmp.getName());
            }else {
                System.out.println("class:"+tmp.getName());

            }

            
        }

    }
}
```

这个出来的结果就是精准的了，具体可以自己测试



## 参考文章

https://www.runoob.com/w3cnote/java-annotation.html
