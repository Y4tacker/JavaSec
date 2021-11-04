package com.yyds;

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
    public static final String classNumberReturns2 = "E:\\testJar\\target\\classes\\com\\yyds\\TransClass.class.2";

    public static byte[] getBytesFromFile(String fileName) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\testJar\\target\\classes\\com\\yyds\\TransClass.class.2"));
        int a;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((a=fileInputStream.read(bytes))!= -1){
            outputStream.write(bytes,0,a);
        }
        return outputStream.toByteArray();
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (!className.equals("com/yyds/TransClass")) {
            return null;
        }
        try {
            return getBytesFromFile(classNumberReturns2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
