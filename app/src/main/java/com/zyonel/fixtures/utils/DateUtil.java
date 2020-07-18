package com.zyonel.fixtures.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static String convertToLocalDateTimeViaInstant(Date dateToConvert) {
        LocalDateTime dt = dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        String minute = String.valueOf(dt.getMinute() > 10 ? dt.getMinute() : '0'+ String.valueOf(dt.getMinute()));
        String hour = String.valueOf(dt.getHour());
        return String.format("%s:%s", hour, minute);
    }
}
