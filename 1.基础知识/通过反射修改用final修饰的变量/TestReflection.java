package com.yyds;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflection {
    public static final String test = "abc";
    public static void main(String[] args) throws Exception{
        TestReflection testReflection = new TestReflection();
        Field test = testReflection.getClass().getDeclaredField("test");
        Field modifier = test.getClass().getDeclaredField("modifiers");
        modifier.setAccessible(true);
        modifier.setInt(test,test.getModifiers() & ~Modifier.FINAL);
        test.set(testReflection,"success");
        System.out.println(test.get(testReflection));
    }
}
