package com.cqc.learning.java.base;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.java.jvm
 * @date 2020/5/14-10:22
 */
public class FinalTest {

    public static void main(String[] args) {
        new FinalTest().testFinal();
    }

    public void testFinal() {

        final Integer var1 = 1;
        new Thread(() -> {
            Integer var2 = 2;
            System.out.println(var2);
        }).start();
        System.out.println(var1);

    }
}
