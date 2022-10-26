package com.ead.busbooking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Service
public class DateConverterService {

    public Date convertFromStringToDate(String date){
        String string = "2020-04-10T04:00:00.000Z";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(string, formatter);
        return Date.from(localDate.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());
    }
}
