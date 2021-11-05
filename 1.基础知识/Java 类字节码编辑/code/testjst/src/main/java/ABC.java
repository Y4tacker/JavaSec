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
