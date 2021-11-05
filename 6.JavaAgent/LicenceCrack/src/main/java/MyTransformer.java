import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {
    public String HookPath;

    public MyTransformer(String hookPath) {
        HookPath = hookPath;
    }

    public static byte[] getFileBytes(String filename) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        byte[] bytes = new byte[1024];
        int read;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((read =fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,read);
        }
        return outputStream.toByteArray();
    }
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals("CrackLicenseTest")){
            return null;
        }else {
            try {
                ClassPool aDefault = ClassPool.getDefault();

                byte[] bytes = getFileBytes("E:\\LicenceCrack\\target\\classes\\CrackLicenseTest.class");
                CtClass ctClass = aDefault.makeClass(new ByteArrayInputStream(bytes));
                CtMethod ctMethod = ctClass.getDeclaredMethod(
                        "checkExpiry", new CtClass[]{aDefault.getCtClass("java.lang.String")}
                );
                ctMethod.insertBefore("return false;");
                ctMethod.insertBefore("System.out.println(\"License到期时间：\" + $1);");
                bytes = ctClass.toBytecode();
                return bytes;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        getFileBytes("E:\\LicenceCrack\\target\\classes\\CrackLicenseTest.class");
    }
}
