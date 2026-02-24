package com.wagner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReferenceDemo2 {
    void cloz() {
        log.info("Stand-in close() method called");
    }

    public static void main(String[] args) throws Exception {
        ReferenceDemo2 rd2 = new ReferenceDemo2();

        // Use a method reference to assign the AutoCloseable interface
        // variable "ac" to the matching method signature "c" (obviously
        // short for close, but just to see the method name isn't what matters).
        try (AutoCloseable autoCloseable = rd2::cloz) {
            log.info("Some action happening here.");
        }
    }
}
