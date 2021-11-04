package com.yyds;

import java.io.IOException;

public class calc implements SPIService{
    static {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {

    }
}
