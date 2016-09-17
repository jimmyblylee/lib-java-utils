/**
 * Project Name : commons-util <br>
 * File Name : DateUtils.java <br>
 * Package Name : com.lee.util <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName : DateUtils <br>
 * Description : date utils <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com
 */
public abstract class DateUtils {

    /**
     * Description : get age by birthday <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param date the date which will be comput the age of now
     * @return age
     */
    public static int getAgeByBirthday(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(date);
        if (birth.get(Calendar.DAY_OF_YEAR) > now.get(Calendar.DAY_OF_YEAR)) {
            return now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) - 1;
        } else {
            return now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        }
    }

    /**
     * Description : convert long to date string by yyyy-MM-dd <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param dateLong long date which will be format
     * @return String formated by "yyyy-MM-dd"
     */
    public static String formatDateToYMD(Long dateLong) {
        Date Date = new Date(dateLong);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(Date);
    }

    /**
     * Description : convert long to date string by yyyy年MM月dd日 <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param dateLong long date
     * @return String formated by "yyyy年MM月dd日"
     */
    public static String formatDateToYMD2(Long dateLong) {
        Date Date = new Date(dateLong);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(Date);
    }

    /**
     * Description : convert date string to date by formate yyyy年MM月dd日 <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param dateString formated string with pattern "yyyy年MM月dd日"
     * @return the date by formated string
     */
    public static Date formatYMD2ToDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("exception happens while formatting date!", e);
        }
    }

    /**
     * Description : convert date string to date by formate yyyy-MM-dd <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param dateString formated string with pattern "yyyy-MM-dd"
     * @return the date by formated string
     */
    public static Date formatYMDToDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("exception happens while formatting date!", e);
        }
    }

    /**
     * Description : convert date string yyyy年MM月dd日 to yyyyMMdd <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param dateString "yyyy年MM月dd日" formated string
     * @return "yyyyMMdd" formated string
     */
    public static String formatYMDToString(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(formatYMDToDate(dateString));
    }

    /**
     * Description : format the date by given pattern <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param date target date
     * @param pattern string which you want format to
     * @return formated string by given pattern
     */
    public static String format(Date date, String pattern) {
        if (date == null) { return ""; }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
