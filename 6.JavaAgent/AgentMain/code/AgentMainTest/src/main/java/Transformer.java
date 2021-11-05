import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Transformer implements ClassFileTransformer {
    public static final String classNumberReturns2 = "E:\\AgentMainTest\\target\\classes\\TransClass.class.2";

    public Transformer() {
    }

    public static byte[] getBytesFromFile(String fileName) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int a;
        while((a = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, a);
        }

        return outputStream.toByteArray();
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (!className.equals("TransClass")) {
            return null;
        } else {
            try {
                return getBytesFromFile(classNumberReturns2);
            } catch (Exception var7) {
                var7.printStackTrace();
                return null;
            }
        }
    }

    public static void main(String[] args)throws Exception {
        System.out.println(getBytesFromFile(classNumberReturns2));
    }
}
