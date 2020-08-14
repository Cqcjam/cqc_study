package com.cqc.learning.designmode.createmode.builder.test;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.designmode.createmode.builder.test
 * @date 2020/7/22-23:23
 */
public class Client {

    public static void main(String[] args) {
        Direct direct = new Direct();
        ProductTest test = direct.getProduct(new ConcreteBuilderTest());
        test.show();
    }
}
