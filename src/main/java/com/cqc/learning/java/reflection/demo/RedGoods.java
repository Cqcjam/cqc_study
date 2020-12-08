package com.cqc.learning.java.reflection.demo;

/**
 * @author caoqingcong
 */
public class RedGoods implements IGoods{
    /**
     * 食物颜色
     *
     * @return
     */
    @Override
    public String color() {
        System.out.println("this color is red");
        return "this color is red";
    }
}
