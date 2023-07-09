package com.example.swimmingpoolservice.utils;

import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtil {
    public static Date getCurrentDate() {
        return new Date();
    }

    public static ZonedDateTime getZonedCurrentDate() {
        //      ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        return ZonedDateTime.now();
    }
}