package com.wagner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        LocalDateDemoAndTime();
    }

    private static void LocalDateDemoAndTime() {
        LocalDate date = LocalDate.now();
        logger.debug(String.format("LocalDate: %s", date.toString()));
        LocalTime time = LocalTime.now();
        logger.debug(String.format("LocalTime: %s", time.toString()));
    }
}
