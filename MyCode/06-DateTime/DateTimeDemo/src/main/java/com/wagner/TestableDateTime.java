package com.wagner;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestableDateTime {
    public static void main(String[] args) {
        log.info("LocalDate:{} \n LocalTime:{} \nLocalDateTime:{}",
                LocalDate.now(), LocalTime.now(), LocalDateTime.now());
        log.info("{}", LocalDateTime.now(Clock.systemDefaultZone()));
        Date d = new Date();
        // By default, LocalDateTime toString will use ISO 8601 format like
        // '2023-03-12T17:03:13.509072900'
        log.info("Date:{} localDateTime:{}", d.toString(), LocalDateTime.now().toString());
    }
}
