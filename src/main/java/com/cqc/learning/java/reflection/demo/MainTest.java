package com.cqc.learning.java.reflection.demo;

import java.lang.reflect.Proxy;

public class MainTest {

    public static void main(String[] args) {
        IGoods iGoods = new RedGoods();
        GoodsHandler handler = new GoodsHandler(iGoods);
        IGoods var =  (IGoods) Proxy.newProxyInstance(iGoods.getClass().getClassLoader(),
                iGoods.getClass().getInterfaces(), handler);
        var.color();
    }
}
