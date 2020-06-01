package com.cqc.learning.java.jvm;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.java.jvm
 * @date 2020/5/14-16:38
 */
public class ClassLoaderTest {

    static {
        System.out.println("ClassLoaderTest init");
    }

    public static final String HELLO = "Hello";
}
