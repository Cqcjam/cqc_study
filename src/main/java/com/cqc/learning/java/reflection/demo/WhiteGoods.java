package com.cqc.learning.java.reflection.demo;

/**
 * @author caoqingcong
 */
public class WhiteGoods implements IGoods{
    /**
     * 食物颜色
     *
     * @return
     */
    @Override
    public String color() {
        System.out.println("this color is white");
        return "this color is white";
    }
}
