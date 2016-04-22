package com.pru.shifty.api.util;

import java.util.Calendar;
import java.util.Date;

public final class ShiftDateUtils {

    private static final int DAYS_IN_A_WEEK = 7;
    private static final int LAST_MIN_SECOND = 59;
    private static final int LAST_HOUR = 23;

    public static Date getEndWeeksEnd(Date startDate, int weeks){
        int weekByDays = weeks * DAYS_IN_A_WEEK;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, LAST_HOUR, LAST_MIN_SECOND, LAST_MIN_SECOND);
        calendar.add(Calendar.DATE, weekByDays);
        return calendar.getTime();
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }
}
