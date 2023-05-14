package com.example.swimmingpoolservice.utils;

import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtil {

    public static Date getCurrentDate() {
        java.util.Date date = new java.util.Date();
        return date;
    }

    public static ZonedDateTime getZonedCurrentDate() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        return zonedDateTime;
    }
}