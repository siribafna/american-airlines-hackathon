package com.improving.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static boolean timeIsBefore(String startTime, String endTime)  {
        try {
            String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            Date date = simpleDateFormat.parse(startTime);
            Date date2 = simpleDateFormat.parse(endTime);

            if(date2.getTime() < date.getTime())
                    return false;



            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSameDay(String startTime, String endTime) {
        try {
            String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            Date date = simpleDateFormat.parse(startTime);
            Date date2 = simpleDateFormat.parse(endTime);

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            Integer dayOfMonth1 = cal1.get(Calendar.DAY_OF_MONTH);
            Integer dayOfMonth2 = cal2.get(Calendar.DAY_OF_MONTH);

            return dayOfMonth1 == dayOfMonth2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

}
