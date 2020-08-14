package com.cqc.learning.designmode.createmode.builder.test;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.designmode.createmode.builder.test
 * @date 2020/7/22-23:23
 */
public class Direct {


    public ProductTest getProduct(IBuilderTest iBuilder) {
        iBuilder.buildPart1();
        iBuilder.buildPart2();
        return iBuilder.builderProduct();
    }
}
