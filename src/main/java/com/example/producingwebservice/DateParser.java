package com.example.producingwebservice;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    private String pattern;
    private DateFormat dateFormat;

    public DateParser(String pattern) {
        this.pattern = pattern;
        this.dateFormat = new SimpleDateFormat(pattern);
    }

    public Date parseDate(String dateString) throws ParseException {
        return dateFormat.parse(dateString);
    }

    public String formatDate(Date date) {
        return dateFormat.format(date);
    }


}
