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
