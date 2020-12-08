package com.cqc.learning.java.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Md5Check {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println( d.format(new Date(1540179259000L)));
    }
}
