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
