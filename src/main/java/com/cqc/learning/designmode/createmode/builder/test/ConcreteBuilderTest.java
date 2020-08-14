package com.cqc.learning.designmode.createmode.builder.test;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.designmode.createmode.builder.test
 * @date 2020/7/22-23:23
 */
public class ConcreteBuilderTest implements IBuilderTest{

    private ProductTest productTest;

    public ConcreteBuilderTest() {
        productTest =  new ProductTest();
    }

    @Override
    public void buildPart1() {
        productTest.setPart1("part1");
    }

    @Override
    public void buildPart2() {
        productTest.setPart2("part2");
    }

    @Override
    public ProductTest builderProduct() {
        return productTest;
    }
}
