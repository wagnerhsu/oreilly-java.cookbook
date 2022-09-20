package com.wagner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info(App.class.getName());
        logger.info(App.class.getSimpleName());
        logger.info(App.class.getCanonicalName());
    }
}
