package com.cqc.learning.java.jvm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.java.jvm
 * @date 2020/5/7-12:56
 */
public class GcReference {

    public Object object = null;

    private static final int _1MB = 1024 * 1024 * 1024;

    private byte[] bigSize = new byte[_1MB];

    public static void main(String[] args) throws ParseException {
        testGc();
    }

    public static void testGc() throws ParseException {
        /*GcReference obj1 = new GcReference();
        GcReference obj2 = new GcReference();
        obj1.object = obj2;
        obj2.object = obj1;
        obj1 = null;
        obj2 = null;
        System.gc();*/
        String rechargeDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println(rechargeDate);
        Long beginTimeStamp = getDateTimeStamp(rechargeDate);
        System.out.println(beginTimeStamp);
        System.out.println(beginTimeStamp + 86400000);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

    }

    public static Long getDateTimeStamp(String strDate) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }
}
