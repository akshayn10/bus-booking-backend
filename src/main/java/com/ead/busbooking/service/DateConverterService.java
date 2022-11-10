package com.ead.busbooking.service;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class DateConverterService {

    public Date convertFromStringToDate(String date) {
        DateFormat format = new SimpleDateFormat( "E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH);
        Date date1 = new Date();
        try{
            date1 = format.parse(date);
        }
        catch(ParseException p){
            System.out.println(p.getMessage());
        }
        return date1;

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
