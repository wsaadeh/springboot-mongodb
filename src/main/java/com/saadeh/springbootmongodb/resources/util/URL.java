package com.saadeh.springbootmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class URL {
    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }

    }

    public static LocalDate convertDate(String textDate,LocalDate defaultValue){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("GMT"));
        try {
            return LocalDate.parse(textDate,dtf);
        }catch (RuntimeException e){
            return defaultValue;
        }

    }
}
