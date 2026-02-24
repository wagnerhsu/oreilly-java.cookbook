package com.wagner;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReferenceDemo3 {
    interface FunInterface {
        void process(int i, String j, char c, double d);
    }

    public static void work(int i, String j, char c, double d) {
        log.info("Moo");
    }

    public void workInstance(int i, String j, char c, double d) {
        log.info("Moo");
    }

    public static void main(String[] args) {
        FunInterface sample = ReferenceDemo3::work;
        log.info("My process method is " + sample);
        var rd = new ReferenceDemo3();
        sample = rd::workInstance;
        log.info(sample.toString());
    }
}
