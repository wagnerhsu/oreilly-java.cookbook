package com.wagner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        LombokDemo();
    }

    private static void LombokDemo() {
        User user = new User();
        user.setId("1");
        user.setName("name");
        user.setAge(1);
        logger.debug(new Gson().toJson(user));
    }
}
