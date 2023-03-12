package com.wagner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateFormatter {
    public static void main(String[] args) {

        // Format a date ISO8601-like but with slashes instead of dashes
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/LL/dd");
        log.debug("{}", df.format(LocalDate.now()));

        // Parse a String to a date using the same formatter
        log.debug("{}", LocalDate.parse("2014/04/01", df));

        // Format a Date and Time without timezone information
        DateTimeFormatter nTZ = DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
        log.debug("{}", ZonedDateTime.now().format(nTZ));

        LocalDateTime date = LocalDateTime.now();
        df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        log.debug("{}  {}", df.format(date), date);
    }
}