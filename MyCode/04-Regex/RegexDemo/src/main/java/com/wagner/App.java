package com.wagner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        MacherDemo();
    }

    private static void MacherDemo() {
        String patt = "Q[^u]\\d+\\.";
        Pattern r = Pattern.compile(patt);
        String line = "Order QT300. Now!QT400.";
        Matcher m = r.matcher(line);
        while (m.find()) {
            logger.debug(String.format("%d-%d", m.start(), m.end()));
            logger.debug(line.substring(m.start(), m.end()));
        }
    }
}
