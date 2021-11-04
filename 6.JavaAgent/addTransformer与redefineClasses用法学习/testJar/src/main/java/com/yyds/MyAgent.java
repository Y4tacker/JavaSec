package com.yyds;

import java.lang.instrument.Instrumentation;

public class MyAgent {
    public static void premain(String args, Instrumentation inst) throws Exception {
        inst.addTransformer(new Transformer());
    }
}
