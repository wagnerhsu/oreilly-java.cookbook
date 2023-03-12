package com.wagner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateParse {
    public static void main(String[] args) {

        String armisticeDateString = "1918-11-11";
        LocalDate armisticeDate = LocalDate.parse(armisticeDateString);
        log.debug("Date: " + armisticeDate);

        String armisticeDateTimeString = "1918-11-11T11:00";
        LocalDateTime armisticeDateTime = LocalDateTime.parse(armisticeDateTimeString);
        log.debug("Date/Time: " + armisticeDateTime);
        // end::part1[]

        // tag::part2[]
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM uuuu");
        String anotherDate = "27 Jan 2027";
        LocalDate random = LocalDate.parse(anotherDate, df);
        log.debug(anotherDate + " parses as " + random);
        // end::part2[]

        log.debug(armisticeDate + " formats as " + df.format(armisticeDate));
    }
}