package com.ead.busbooking.service;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Service
public class DateConverterService {

    public Date convertFromStringToDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat( "E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH);
        return format.parse(date);
    }
    public String convertFromDateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    public String convertFromDateToStringWithTime(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
        return dateFormat.format(date);
    }
}
