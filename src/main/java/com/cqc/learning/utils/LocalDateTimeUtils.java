package com.cqc.learning.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author caoqingcong
 */
public class LocalDateTimeUtils {


    /**
     * 按照指定的样式返回当前时间
     *
     * @param pattern 样式
     * @return String
     */
    private static String getCurrentTime(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.now().format(formatter);
        //return formatter.format(LocalDateTime.now());
    }

    public static final String yyyyMMdd2 = "yyyy-MM-dd";
    public static final String yyyyMMdd3 = "yyyy/MM/dd";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMM = "yyyy-MM";
    public static final String MMdd = "MM-dd";
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String yyyy_MM_dd_HH = "yyyy-MM-dd HH";
    public static final String yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String HH_mm_ss = "HH:mm:ss";
    public static final String HH_mm = "HH:mm";

    /**
     * Date转换为LocalDateTime
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 获取指定日期的毫秒
     */
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     */
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定时间的指定格式
     */
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatTimeWithDefaultPattern(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(yyyy_MM_dd_HH_mm_ss));
    }


    /**
     * 获取当前时间的指定格式
     */
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 获取当前时间的指定格式(默认格式)
     */
    public static String formatNowDefaultPattern() {
        return formatTime(LocalDateTime.now(), yyyy_MM_dd_HH_mm_ss);
    }

    /**
     * 获取指定时间
     */
    public static LocalDateTime parseWithDefaultPattern(String dateTimeText) {
        return LocalDateTime.parse(dateTimeText, DateTimeFormatter.ofPattern(yyyy_MM_dd_HH_mm_ss));
    }


    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param field     单位(年月日时分秒)
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    //获取一天的开始时间，2017,7,22 00:00
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    //获取一天的结束时间，2017,7,22 23:59:59.999999999
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }


    public static void main(String[] args) {
       // System.out.println(getCurrentTime("yyyy-MM-dd HH:mm:ss"));
      //  System.out.println(getCurrentTime("yyyy-MM-dd HH:mm:ss.SSS"));
        //System.out.println(getNextMonth("2021-02-02"));

      /*  double d = 0.155;
        BigDecimal b = new BigDecimal(String.valueOf(d));
        d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);

        double d1 = 114.165;
        System.out.println(String.format("%.2f", d1));

        double d2 = 114.145;
        NumberFormat nf = NumberFormat.getNumberInstance();
// 保留两位小数
        nf.setMaximumFractionDigits(2);
// 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        System.out.println(nf.format(d2));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        System.out.println(simpleDateFormat.format(new Date()));*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            //获取上月的最后一天
            String lastDayOfLastMonth = format.format(calendar.getTime());
        System.out.println(lastDayOfLastMonth.substring(0,7));

        System.out.println(getNextMonth("2021-02-25"));
    }


    /**
     * 获取汇率日期的使用月份-即汇率日期的下一个月份
     * @param rateDate
     * @return
     */
    private static String getNextMonth(String rateDate) {
        //如果为空 默认使用当前月
        if (StringUtils.isBlank(rateDate)) {
            LocalDate localDate = LocalDate.now();
            rateDate = assembleDate(localDate);
        } else {
            LocalDate localDate = LocalDate.parse(rateDate, DateTimeFormatter.ofPattern(yyyyMMdd2));
            localDate = localDate.minusMonths(-1);
            rateDate = assembleDate(localDate);
        }
        return rateDate;
    }

    /**
     * 拼接字符
     * @param localDate
     * @return
     */
    private static  String assembleDate(LocalDate localDate) {
            StringBuilder sb = new StringBuilder();
            String curreentYear = String.valueOf(localDate.getYear());
            int monthCount = localDate.getMonthValue();
            String curreentMonth = monthCount < 10
                    ? "0" + monthCount : String.valueOf(monthCount) ;
            return sb.append(curreentYear)
                    .append("-").append(curreentMonth).toString();
    }
}
