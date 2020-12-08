package com.cqc.learning.java.reflection.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author caoqingcong
 */
public class GoodsHandler implements InvocationHandler{

    private IGoods iGoods;

    public GoodsHandler(IGoods iGoods) {
        this.iGoods = iGoods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 。。" + method.getName());
        Object obj = method.invoke(iGoods, args);
        System.out.println("after 。。" + obj.toString());
        return obj;
    }
}
