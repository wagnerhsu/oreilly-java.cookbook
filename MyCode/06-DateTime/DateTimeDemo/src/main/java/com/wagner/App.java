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
        DateTimeFormatterDemo();
    }

    private static void DateTimeFormatterDemo() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        logger.debug(df.format(date));
        // By default, toString will use ISO 8601 format like '2022-09-23T16:25:59.455'
        logger.debug(date.toString());
    }

    private static void LocalDateDemoAndTime() {
        LocalDate date = LocalDate.now();
        logger.debug(String.format("LocalDate: %s", date.toString()));
        LocalTime time = LocalTime.now();
        logger.debug(String.format("LocalTime: %s", time.toString()));
    }
}
