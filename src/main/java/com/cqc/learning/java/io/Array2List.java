package com.cqc.learning.java.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数据和list转换
 * @author caoqingcong
 */
public class Array2List {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        // list转换array
        // 使用泛型，无需显式类型转换
        String[] array = list.toArray(new String[0]);
        System.out.println(array[2]);

        // array转list
        List list2 = Arrays.asList(array);
        System.out.println(list2);

        System.out.println(String.format("%sAAAAA%sBBBBB", "sid111111", "content2222"));

        String str = null;
        System.out.println(str.split(","));
    }
}
