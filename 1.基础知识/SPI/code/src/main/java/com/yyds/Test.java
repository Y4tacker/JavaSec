package com.yyds;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;
import sun.net.www.protocol.http.AuthScheme;

public class Test {
    public static void main(String[] args) {
        Iterator<SPIService> providers = Service.providers(SPIService.class);
//        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

        while(providers.hasNext()) {
            SPIService ser = providers.next();
            ser.execute();
        }
//        System.out.println("--------------------------------");
//        Iterator<SPIService> iterator = load.iterator();
//        while(iterator.hasNext()) {
//            SPIService ser = iterator.next();
//            ser.execute();
//        }
    }
}
