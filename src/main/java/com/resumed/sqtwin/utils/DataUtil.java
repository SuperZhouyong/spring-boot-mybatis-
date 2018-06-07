package com.resumed.sqtwin.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther Super
 * @data 2018/4/11 0011
 * @time 下午 16:59
 */
public class DataUtil {
    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static final ThreadLocal<DateFormat> dfDate = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    public static final ThreadLocal<DateFormat> dfDateYear = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy");
        }
    };

    public static String getTimestamp() {
        DateFormat dateFormat = df.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.set(dateFormat);
        }
        return dateFormat.format(new Date());
    }

    public static String getTimeDta() {
        DateFormat dateFormat = dfDate.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dfDate.set(dateFormat);
        }
        return dateFormat.format(new Date());
    }
    public static String getTimeDtaParsetoString(Date date) {
        DateFormat dateFormat = dfDate.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dfDate.set(dateFormat);
        }
        return dateFormat.format(date);
    }
    public static String getTimestampParsetoString(Date date) {
        DateFormat dateFormat = df.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.set(dateFormat);
        }
        return dateFormat.format(date);
    }

}
