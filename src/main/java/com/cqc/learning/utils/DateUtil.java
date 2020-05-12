/*
package com.cqc.learning.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

*/
/**
 * @description 日期工具类
 * @author caoqingcong
 * @projectName netease-shop-v2
 * @packageName org.dfw.spark.api.util
 * @date 2020/4/7-19:14
 *//*

public class DateUtil {
    public static String MM_DD = "MM-dd";
    public static String YYYY_MM = "yyyy-MM";
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String MM_DD_HH_MM = "MM-dd HH:mm";
    public static String MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";
    public static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String MM_DD_EN = "MM/dd";
    public static String YYYY_MM_EN = "yyyy/MM";
    public static String YYYY_MM_DD_EN = "yyyy/MM/dd";
    public static String MM_DD_HH_MM_EN = "MM/dd HH:mm";
    public static String MM_DD_HH_MM_SS_EN = "MM/dd HH:mm:ss";
    public static String YYYY_MM_DD_HH_MM_EN = "yyyy/MM/dd HH:mm";
    public static String YYYY_MM_DD_HH_MM_SS_EN = "yyyy/MM/dd HH:mm:ss";
    public static String MM_DD_CN = "MM月dd日";
    public static String YYYY_MM_CN = "yyyy年MM月";
    public static String YYYY_MM_DD_CN = "yyyy年MM月dd日";
    public static String MM_DD_HH_MM_CN = "MM月dd日 HH:mm";
    public static String MM_DD_HH_MM_SS_CN = "MM月dd日 HH:mm:ss";
    public static String YYYY_MM_DD_HH_MM_CN = "yyyy年MM月dd日 HH:mm";
    public static String YYYY_MM_DD_HH_MM_SS_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static String HH_MM = "HH:mm";
    public static String HH_MM_SS = "HH:mm:ss";
    public static String YYYYMMDD = "yyyyMMdd";
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static String YYYYMM = "yyyyMM";
    public static String HHMMSS = "HHmmss";
    public static String year = "yyyy";
    public static String month = "MM";
    public static String day = "dd";


    public static DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
    public static DateTimeFormatter ymdSDF = DateTimeFormatter.ofPattern(YYYY_MM_DD);
    public static DateTimeFormatter yearSDF = DateTimeFormatter.ofPattern(year);
    public static DateTimeFormatter monthSDF = DateTimeFormatter.ofPattern(month);
    public static DateTimeFormatter daySDF = DateTimeFormatter.ofPattern(day);
    public static DateTimeFormatter yyyyMMddHHmm = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM);
    public static DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern(YYYY_MM_DD);
    public static DateTimeFormatter yyyyMMddHH_NOT_ = DateTimeFormatter.ofPattern(YYYYMMDD);
    public static DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern(YYYY_MM);
    public static DateTimeFormatter YYYYMMSDF = DateTimeFormatter.ofPattern(YYYYMM);
    public static DateTimeFormatter yyyyMMddHHMMSS = DateTimeFormatter.ofPattern(YYYYMMDD + HHMMSS);

    public static long DATEMM = 86400L;

    */
/**
     * 获得当前时间 格式：2014-12-02 10:38:53
     *
     * @return String
     *//*

    public static String getCurrentTime() {
        return DateUtil.getCurrentTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
    }

    */
/**
     * 获取指定格式当前时间
     *
     * @param format
     * @return
     *//*

    public static String getCurrentTime(String format) {
        return DateFormatUtils.format(new Date(), format);
    }

    */
/**
     * 可以获取昨天的日期 格式：2014-12-01
     *
     * @return String
     *//*

    public static String getYesterdayYYYYMMDD() {
        LocalDateTime localDateTime = getYesterdayLocalDateTime();
        String str = yyyyMMdd.format(localDateTime);
        return str;
    }


    */
/**
     * 可以获取后退N天的日期 格式：传入2 得到2014-11-30
     *
     * @param backDay
     * @return String
     *//*

    public static String getStrDate(String backDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.parseInt("-" + backDay));
        String back = DateFormatUtils.format(calendar.getTime(), YYYY_MM_DD);
        return back;
    }

    */
/**
     * 可以获取 得到2014-11-30
     *
     * @param dateStr 20141130
     * @return
     *//*

    public static String getDate(String dateStr) {
        Date date = null;
        try {
            date = DateUtils.parseDate(dateStr, YYYYMMDD);
        } catch (ParseException e) {
            return "";
        }
        String dateNewStr = DateFormatUtils.format(date, YYYY_MM_DD);
        return dateNewStr;
    }

    */
/**
     * 获取指定日期 的后几天
     *
     * @param date
     * @param day
     * @return
     *//*

    public static Date getDateByAddDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    */
/**
     * 获取当前的年、月、日
     *
     * @return String
     *//*

    public static String formatDate(Date date, Object... pattern) {
        if (date == null) {
            return null;
        }
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    public static String getCurrentYear() {
        return formatDate(new Date(), year);
    }

    public static String getCurrentMonth() {
        return formatDate(new Date(), month);
    }

    public static String getCurrentDay() {
        return formatDate(new Date(), day);
    }

    */
/**
     * 获取年月日 也就是当前时间 格式：2014-12-02
     *
     * @return String
     *//*

    public static String getCurrentymd() {
        return ymdSDF.format(LocalDate.now());
    }

    */
/**
     * 获取今天0点开始的秒数
     *
     * @return long
     *//*

    public static long getTimeNumberToday() {

        String str = yyyyMMdd.format(LocalDateTime.now());
        try {
            Date date = DateUtils.parseDate(str, YYYY_MM_DD);
            return date.getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    */
/**
     * 获取今天的日期 格式：20141202
     *
     * @return String
     *//*

    public static String getTodateStr() {
        String str = yyyyMMddHH_NOT_.format(LocalDate.now());
        return str;
    }

    */
/**
     * 获取今天的日期
     * 格式：20190325175959
     *
     * @return String
     *//*

    public static String getTodateStr2() {
        String str = DateUtil.formatDate(new Date(), YYYYMMDD + HHMMSS);
        return str;
    }

    */
/**
     * 获取昨天的日期 格式：20141201
     *
     * @return String
     *//*

    public static String getYesterdayStr() {
        LocalDateTime localDateTime = getYesterdayLocalDateTime();
        String str = yyyyMMddHH_NOT_.format(localDateTime);
        return str;
    }

    private static LocalDateTime getYesterdayLocalDateTime() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    */
/**
     * 获得昨天零点
     *
     * @return Date
     *//*

    public static Date getYesterDayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR, 0);
        return cal.getTime();
    }

    */
/**
     * 把long型日期转String
     *
     * @param date   long型日期；
     * @param format 日期格式；
     * @return
     *//*

    public static String longToStr(long date, String format) {
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.utils.Date类型
        Date dt2 = new Date(date * 1000L);
        String sDateTime = DateFormatUtils.format(dt2, format);// 得到精确到秒的表示：08/31/2006 21:08:00
        return sDateTime;
    }

    */
/**
     * 获得今天零点
     *
     * @return Date
     *//*

    public static Date getTodayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR, 0);
        return cal.getTime();
    }

    */
/**
     * 获得昨天23时59分59秒
     *
     * @return
     *//*

    public static Date getYesterDay24Hour() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR, 23);
        return cal.getTime();
    }

    */
/**
     * String To Date
     *
     * @param date   待转换的字符串型日期；
     * @param format 转化的日期格式
     * @return 返回该字符串的日期型数据；
     *//*

    public static Date strToDate(String date, String format) {
        try {
            return DateUtils.parseDate(date, format);
        } catch (ParseException e) {
            return null;
        }
    }

    */
/**
     * Date To String
     *
     * @param date   待转换的日期；
     * @param format 转化的日期格式
     * @return 返回该字符串的日期型数据；
     *//*

    public static String dateToStr(Date date, String format) {
        return DateFormatUtils.format(date, format);
    }

    */
/**
     * 获得指定日期所在的自然周的第一天，即周日
     *
     * @param date 日期
     * @return 自然周的第一天
     *//*

    public static Date getStartDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, 1);
        date = c.getTime();
        return date;
    }

    */
/**
     * 获得指定日期所在的自然周的最后一天，即周六
     *
     * @param date
     * @return
     *//*

    public static Date getLastDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, 7);
        date = c.getTime();
        return date;
    }

    */
/**
     * 获得指定日期所在当月第一天
     *
     * @param date
     * @return
     *//*

    public static Date getStartDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        return date;
    }

    */
/**
     * 获得指定日期所在当月最后一天
     *
     * @param date
     * @return
     *//*

    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        date = c.getTime();
        return date;
    }

    */
/**
     * 获得指定日期的下一个月的第一天
     *
     * @param date
     * @return
     *//*

    public static Date getStartDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        return date;
    }

    */
/**
     * 获得指定日期的下一个月的最后一天
     *
     * @param date
     * @return
     *//*

    public static Date getLastDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 2);
        c.add(Calendar.DATE, -1);
        date = c.getTime();
        return date;
    }

    */
/**
     * 求某一个时间向前多少秒的时间(currentTimeToBefer)
     *
     * @param givedTime        给定的时间
     * @param interval         间隔时间的毫秒数；计算方式 ：n(天)*24(小时)*60(分钟)*60(秒)(类型)
     * @param format_Date_Sign 输出日期的格式；如yyyy-MM-dd、yyyyMMdd等；
     *//*

    public static String givedTimeToBefer(String givedTime, long interval, String format_Date_Sign) {
        String tomorrow = null;
        try {
            Date gDate = DateUtils.parseDate(givedTime, format_Date_Sign);
            long current = gDate.getTime(); // 将Calendar表示的时间转换成毫秒
            long beforeOrAfter = current - interval * 1000L; // 将Calendar表示的时间转换成毫秒
            Date date = new Date(beforeOrAfter); // 用timeTwo作参数构造date2
            tomorrow = DateFormatUtils.format(date, format_Date_Sign);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tomorrow;
    }

    */
/**
     * 把String 日期转换成long型日期
     *
     * @param date   String 型日期；
     * @param format 日期格式；
     * @return
     *//*

    public static long strToLong(String date, String format) {
        Date dt2 = null;
        long lTime = 0;
        try {
            dt2 = DateUtils.parseDate(date, format);
            // 继续转换得到秒数的long型
            lTime = dt2.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lTime;
    }

    */
/**
     * 得到两个日期间的之间的日期；
     *
     * @param endTime   结束时间
     * @param beginTime 开始时间
     * @param isEndTime 是否包含结束日期；
     * @return
     *//*

    public static List<String> getTwoDay(String beginTime, String endTime, boolean isEndTime) {
        List<String> result = new ArrayList<String>();
        if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime.equals(""))))
            return null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
            Date date = format.parse(endTime);
            endTime = format.format(date);
            Date mydate = format.parse(beginTime);
            long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
            result = getDate(endTime, Integer.parseInt(day + ""), isEndTime);
        } catch (Exception e) {
        }
        return result;
    }

    */
/**
     * 得到二个日期间的间隔天数；
     *
     * @param endTime   结束时间
     * @param beginTime 开始时间
     * @param isEndTime 是否包含结束日期；
     * @return
     *//*

    public static Integer getTwoDayInterval(String beginTime, String endTime, boolean isEndTime, String format) {
        if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime.equals(""))))
            return 0;
        return getTwoDayInterval(DateUtil.strToDate(beginTime, format), DateUtil.strToDate(endTime, format), isEndTime);
    }

    */
/**
     * 得到二个日期间的间隔天数；
     *
     * @param endTime   结束时间
     * @param beginTime 开始时间
     * @param isEndTime 是否包含结束日期；
     * @return
     *//*

    public static Integer getTwoDayInterval(Date beginTime, Date endTime, boolean isEndTime) {
        if (endTime == null || beginTime == null)
            return 0;
        long day = 0L;
        try {
            day = (endTime.getTime() - beginTime.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return 0;
        }
        return Integer.parseInt(day + "");
    }

    */
/**
     * 根据结束时间以及间隔差值，求符合要求的日期集合；
     *
     * @param endTime
     * @param interval
     * @param isEndTime
     * @return
     *//*

    public static List<String> getDate(String endTime, Integer interval, boolean isEndTime) {
        List<String> result = new ArrayList<String>();
        if (interval == 0 || isEndTime) {
            if (isEndTime)
                result.add(endTime);
        }
        if (interval > 0) {
            int begin = 0;
            for (int i = begin; i < interval; i++) {
                endTime = givedTimeToBefer(endTime, DATEMM, YYYY_MM_DD);
                result.add(endTime);
            }
        }
        return result;
    }

    */
/**
     * 校验时间是否正确
     *
     * @return
     *//*

    public static boolean validateDate(String sDate, String sFormat) {
        SimpleDateFormat format = new SimpleDateFormat(sFormat);
        Date date = null;
        try {
            date = (Date) format.parseObject(sDate);
        } catch (ParseException e) {
            System.out.println("日期校验失败：" + e.getMessage());
            return false;
        }
        String str = format.format(date);

        return str.equals(sDate);
    }

    */
/**
     * 获取日期
     *
     * @param formatStr 日期格式
     * @return 日期字符串
     *//*

    public static String getNewDate(String formatStr) {
        String str = DateFormatUtils.format(new Date(), formatStr);
        return str;
    }

    */
/**
     * 将Date格式化成符合默认日期格式的字符串 *
     *
     * @param date *
     * @return 返回样例:2012-03-29
     *//*

    public static String formatDate(Date date, String formatPattern) {
        String sDate = DateFormatUtils.format(date, formatPattern);
        return sDate;
    }

    */
/**
     * 获取指定参数的给定日期时间的前或后几个指定时间单位
     *
     * @param srcDate    原日期时间,如果为null则取当前系统日期
     * @param srcFormat  原日期时间格式 如:yyyyMMdd,yyyyMMddHHmmss等
     * @param field      时间间隔单位,使用Calendar类中静态属性
     * @param count      间隔数值,负数表示往后,整数表示向前
     * @param destFormat 目标时间的格式,如:yyyyMMdd,yyyyMMddHHmmss等
     * @return 指定格式目标日期时间
     * @Title getFormatDateByFieldAndCount
     *//*

    public static String getFormatDateByFieldAndCount(String srcDate, String srcFormat, int field, int count,
                                                      String destFormat) {
        String destDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(srcFormat);
        sdf.setLenient(false);
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        if (StringUtils.isEmpty(srcDate)) {
            srcDate = sdf.format(cal.getTime());
        }
        try {
            cal.setTime(sdf.parse(srcDate));

            cal.add(field, count);

            SimpleDateFormat destSdf = new SimpleDateFormat(destFormat);
            destSdf.setLenient(false);
            destDate = destSdf.format(cal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return destDate;
    }

    */
/**
     * 解析指定的字符串日期的年/月/日
     *
     * @param strDate yyyyMMdd
     * @return
     *//*

    public static String parseStrDateToYearMonthDay(String strDate, String returnYearOrMonthOrDday) {
        Calendar calendar = Calendar.getInstance();// 日历对象
        Date tempDate = DateUtil.strToDate(strDate, YYYYMMDD);
        calendar.setTime(tempDate);
        String yearStr = calendar.get(Calendar.YEAR) + "";// 获取年份
        String monthStr = String.valueOf(calendar.get(Calendar.MONTH) + 1); // 获取月份
        int day = calendar.get(Calendar.DATE);
        String dayStr = String.valueOf(day);// 获取日
        String resultDate = "";
        switch (returnYearOrMonthOrDday) {
            case "YEAR":
                resultDate = yearStr + "年";
                break;
            case "year":
                resultDate = yearStr;
                break;
            case "MONTH":
                resultDate = yearStr + "年" + monthStr + "月";
                break;
            case "month":
                resultDate = yearStr + "-" + monthStr;
                break;
            case "DAY":
                resultDate = yearStr + "年" + monthStr + "月" + dayStr + "日";
                break;
            case "day":
                resultDate = yearStr + "-" + monthStr + "-" + dayStr;
                break;
            default:
                resultDate = day + "";
                break;
        }
        return resultDate;
    }

    */
/**
     * 获取指定日期范围内的每天日期数据
     *
     * @param startDate
     * @param endDate
     * @return
     *//*

    public static List<String> findDates(String startDate, String endDate) {
        List<String> dateList = new ArrayList<String>();
        SimpleDateFormat sd = new SimpleDateFormat(YYYYMMDD);
        Date beginDate = null;
        Date lastDate = null;
        try {
            beginDate = sd.parse(startDate);
            lastDate = sd.parse(endDate);
        } catch (ParseException e) {
        }
        dateList.add(sd.format(beginDate));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(beginDate);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(lastDate);
        // 测试此日期是否在指定日期之后
        while (lastDate.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(sd.format(calBegin.getTime()));
        }
        return dateList;
    }

    public static List<String> findMonth(String beginDate, String endDate) {
        List<String> rangeSet = new ArrayList<>();
        beginDate = DateUtil.dateToStr(DateUtil.strToDate(beginDate, YYYYMMDD), YYYY_MM);
        endDate = DateUtil.dateToStr(DateUtil.strToDate(endDate, YYYYMMDD), YYYY_MM);
        Date begin_date = null;
        Date end_date = null;
        SimpleDateFormat formatyyyyMM = new SimpleDateFormat(YYYY_MM);
        try {
            begin_date = formatyyyyMM.parse(beginDate);// 定义起始日期
            end_date = formatyyyyMM.parse(endDate);// 定义结束日期
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar dd = Calendar.getInstance();// 定义日期实例
        dd.setTime(begin_date);// 设置日期起始时间
        while (!dd.getTime().after(end_date)) {// 判断是否到结束日期
            rangeSet.add(formatyyyyMM.format(dd.getTime()));
            dd.add(Calendar.MONTH, 1);// 进行当前日期月份加1
        }
        return rangeSet;
    }

    */
/**
     * 获取上一月 格式：yyyyMM
     *
     * @return
     *//*

    public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat(YYYYMM);
        String lastMonth = formatter.format(cal.getTime());
        return lastMonth;
    }

    */
/**
     * 获取当前日期的上一周
     *
     * @return
     *//*

    public static String getLastWeek() {
        SimpleDateFormat formatyyyyMMddHH_NOT_ = new SimpleDateFormat(YYYYMMDD);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, -1);
        String lastMonth = formatyyyyMMddHH_NOT_.format(cal.getTime());
        return lastMonth;
    }


    */
/**
     * 获取指定日期的 指定间隔月数
     *
     * @param date
     * @param month
     * @return
     *//*

    public static Date getDateByAddMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }


    public static Date getDateByAddWeek(Date date, int week) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, week);
        return calendar.getTime();
    }


    */
/**
     * 获取传入的日期所在周的周一日期
     *
     * @param date
     * @return
     *//*

    public static String getDateOfMonDay(String date) {
        Calendar cal = Calendar.getInstance();
        Date time = null;
        SimpleDateFormat formatyyyyMMddHH_NOT_ = new SimpleDateFormat(YYYYMMDD);
        try {
            time = formatyyyyMMddHH_NOT_.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(time);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        return formatyyyyMMddHH_NOT_.format(cal.getTime());
    }

    */
/**
     * 获取传入的日期所在周的周日日期
     *
     * @param date
     * @return
     *//*

    public static String getDateOfSunDay(String date) {
        Calendar cal = Calendar.getInstance();
        Date time = null;
        SimpleDateFormat formatyyyyMMddHH_NOT_ = new SimpleDateFormat(YYYYMMDD);
        try {
            time = formatyyyyMMddHH_NOT_.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(time);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, 6);
        return formatyyyyMMddHH_NOT_.format(cal.getTime());
    }

    */
/**
     * 根据传入日期获取上一周的周一日期
     *
     * @param beginDate
     * @param endDate
     * @return
     *//*


    public static List<String> findMonthRange(String beginDate, String endDate) {
        List<String> rangeSet = new ArrayList<>();
        beginDate = DateUtil.dateToStr(DateUtil.strToDate(beginDate, YYYYMM), YYYYMM);
        endDate = DateUtil.dateToStr(DateUtil.strToDate(endDate, YYYYMM), YYYYMM);
        Date begin_date = null;
        Date end_date = null;
        try {
            SimpleDateFormat sdfYYYYMM = new SimpleDateFormat(YYYYMM);
            begin_date = sdfYYYYMM.parse(beginDate);// 定义起始日期
            end_date = sdfYYYYMM.parse(endDate);// 定义结束日期
            Calendar dd = Calendar.getInstance();// 定义日期实例
            dd.setTime(begin_date);// 设置日期起始时间
            while (!dd.getTime().after(end_date)) {// 判断是否到结束日期
                rangeSet.add(sdfYYYYMM.format(dd.getTime()));
                dd.add(Calendar.MONTH, 1);// 进行当前日期月份加1
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rangeSet;
    }

    public static List<String> findYearRange(String beginDate, String endDate) {
        List<String> rangeSet = new ArrayList<>();
        beginDate = DateUtil.dateToStr(DateUtil.strToDate(beginDate, YYYYMM), year);
        endDate = DateUtil.dateToStr(DateUtil.strToDate(endDate, YYYYMM), year);
        Date begin_date = null;
        Date end_date = null;
        try {
            SimpleDateFormat sdfYear = new SimpleDateFormat(year);
            begin_date = sdfYear.parse(beginDate);// 定义起始日期
            end_date = sdfYear.parse(endDate);// 定义结束日期
            Calendar dd = Calendar.getInstance();// 定义日期实例
            dd.setTime(begin_date);// 设置日期起始时间
            while (!dd.getTime().after(end_date)) {// 判断是否到结束日期
                rangeSet.add(sdfYear.format(dd.getTime()));
                dd.add(Calendar.YEAR, 1);// 进行当前日期月份加1
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rangeSet;
    }

    */
/**
     * 传入日期返回日期所在月的周数
     *
     * @param strDate
     * @return
     *//*

    public static int getWeekNum(String strDate) {
        Date date = null;
        try {
            date = DateUtils.parseDate(strDate, YYYYMMDD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    */
/**
     * 获取某时间段内所有周的列表（开始时间，结束时间）
     *
     * @param startDate
     * @param endDate
     * @return
     *//*

    public static List<String[]> getWeekList(Date startDate, Date endDate) {
        List<String[]> weekList = new ArrayList<>();
        //转换成joda-time的对象
        DateTime firstDay = new DateTime(startDate).dayOfWeek().withMinimumValue();
        DateTime lastDay = new DateTime(endDate).dayOfWeek().withMaximumValue();
        //计算两日期间的区间天数
        Period p = new Period(firstDay, lastDay, PeriodType.days());
        int days = p.getDays();
        if (days > 0) {
            int weekLength = 7;
            for (int i = 0; i < days; i = i + weekLength) {
                String monDay = firstDay.plusDays(i).toString("yyyyMMdd");
                String sunDay = firstDay.plusDays(i + 6).toString("yyyyMMdd");
                String[] week = {monDay, sunDay};
                weekList.add(week);
            }
        }
        return weekList;
    }

    */
/**
     * 获取前天的日期
     *
     * @return
     *//*

    public static String getBeforeYesterdayStr() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 2000L);
        String str = DateFormatUtils.format(date, YYYYMMDD);
        return str;
    }

    */
/**
     * 获取前天的月份
     *
     * @return
     *//*

    public static String getMonthOfBeforeYesterdayStr() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 2000L);
        String str = DateFormatUtils.format(date, YYYYMM);
        return str;
    }

    */
/**
     * 获取前天的年份
     *
     * @return
     *//*

    public static String getYearOfBeforeYesterdayStr() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 2000L);
        String str = DateFormatUtils.format(date, year);
        return str;
    }

    public static String getLastMonthStartDay() {
        //获取上个月的第一天
        Calendar cal = Calendar.getInstance();
        //上个月
        cal.add(Calendar.MONTH, -1);
        //设置为1号,当前日期既为本月第一天 
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = DateFormatUtils.format(cal.getTime(), YYYYMMDD);
        System.out.println("上月第一天:" + firstDay);
        return firstDay;
    }

    public static String getLastMonthEndDay() {
        //获取上个月的最后一天
        Calendar call = Calendar.getInstance();
        //设置上个月最后一天
        call.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = DateFormatUtils.format(call.getTime(), YYYYMMDD);
        System.out.println("上月最后一天:" + lastDay);
        return lastDay;
    }

    */
/**
     * 获取指定日期的时间戳
     * @param strDate 指定日期格式 yyyyMMdd
     * @return Long 时间戳
     * @throws ParseException
     *//*

    public static Long getDateTimeStamp(String strDate) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    */
/**
     * 获取当月第一天的时间戳
     * @return Long
     *//*

    public static Long getCurrentMonthFirstDayTimeStamp(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0); //获取当前月第一天
        c.set(Calendar.DAY_OF_MONTH, 1); //设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 0); //将小时至0
        c.set(Calendar.MINUTE, 0); //将分钟至0
        c.set(Calendar.SECOND,0); //将秒至0
        c.set(Calendar.MILLISECOND, 0); //将毫秒至0
        return c.getTimeInMillis();
    }

    */
/**
     * 获取当月最后一天的时间戳
     * @return Long
     *//*

    public static Long getCurrentMonthLastDayTimeStamp(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH)); //设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 23); //将小时至0
        c.set(Calendar.MINUTE, 59); //将分钟至0
        c.set(Calendar.SECOND,59); //将秒至0
        c.set(Calendar.MILLISECOND, 999); //将毫秒至0
        return c.getTimeInMillis();
    }

    */
/**
     * 获取指定日期的时间戳
     * @param strDate 指定日期格式 yyyyMMdd
     * @return Long 时间戳
     * @throws ParseException
     *//*

    public static Long getDateTimeStamp(String strDate, String format) throws ParseException {

        DateFormat df = new SimpleDateFormat(format);
        Date date = df.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }



       */
/* public static void main(String args[]){
            System.out.println(DateUtil.getCurrentDay());
            System.out.println(DateUtil.getCurrentTime());
            System.out.println(DateUtil.getCurrentTime("yyyy-MM-dd"));
            System.out.println(DateUtil.getLastMonthEndDay());
            System.out.println(DateUtil.getLastMonthStartDay());
            System.out.println(DateUtil.getYesterDayZeroHour());
            System.out.println(DateUtil.getYesterdayYYYYMMDD());
            System.out.println(DateUtil.getYesterdayStr());
            System.out.println(DateUtil.getYesterDay24Hour());
            System.out.println(DateUtil.getYearOfBeforeYesterdayStr());
            System.out.println(DateUtil.getWeekNum("20190802"));
            List<String[]> weekList = DateUtil.getWeekList(org.joda.time.LocalDateTime.now().toDate(), getLastDayOfNextMonth(org.joda.time.LocalDateTime.now().toDate()));
            for(String s[]:weekList){
                System.out.println(s);
            }
            System.out.println(DateUtil.getTodayZeroHour());
            System.out.println(DateUtil.getTodateStr());
            System.out.println(DateUtil.getTodateStr2());
            System.out.println(DateUtil.getTimeNumberToday());
            System.out.println(DateUtil.getStartDayOfWeek(org.joda.time.LocalDateTime.now().toDate()));
            System.out.println(DateUtil.getStartDayOfMonth(org.joda.time.LocalDateTime.now().toDate()));
            System.out.println(DateUtil.getStartDayOfNextMonth(org.joda.time.LocalDateTime.now().toDate()));
            System.out.println(DateUtil.getMonthOfBeforeYesterdayStr());
            System.out.println(DateUtil.getLastWeek());
            System.out.println(DateUtil.getCurrentymd());
            System.out.println(DateUtil.getCurrentMonth());
            System.out.println(DateUtil.getCurrentYear());
            System.out.println(DateUtil.getTwoDayInterval(org.joda.time.LocalDateTime.now().toDate(), getLastDayOfNextMonth(org.joda.time.LocalDateTime.now().toDate()), true));
        }*//*

}

*/
