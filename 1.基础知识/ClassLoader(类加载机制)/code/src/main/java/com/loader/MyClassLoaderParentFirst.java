package com.loader;

import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
//import sun.misc.Launcher;

public class MyClassLoaderParentFirst extends ClassLoader{

    private Map<String, String> classPathMap = new HashMap<>();

    public MyClassLoaderParentFirst() {
        classPathMap.put("com.loader.TestA", "E:\\MyGIthub\\JavaSec\\1.基础知识\\ClassLoader(类加载机制)\\code\\target\\classes\\com\\loader\\TestA.class");
        classPathMap.put("com.loader.TestB", "E:\\MyGIthub\\JavaSec\\1.基础知识\\ClassLoader(类加载机制)\\code\\target\\classes\\com\\loader\\TestB.class");
    }

    // 重写了 findClass 方法
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if (!file.exists()) {
            throw new ClassNotFoundException();
        }
        byte[] classBytes = getClassData(file);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException();
        }
        return defineClass(classBytes, 0, classBytes.length);
    }

    private byte[] getClassData(File file) {
        try (
                InputStream ins = new FileInputStream(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            byte[] buffer = new byte[4096];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[] {};
    }
    public static void main(String[] args) throws Exception {
        MyClassLoaderParentFirst myClassLoaderParentFirst = new MyClassLoaderParentFirst();
        Class testAClass = myClassLoaderParentFirst.findClass("com.loader.TestA");
        Method mainMethod = testAClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, new Object[]{args});
    }

}

