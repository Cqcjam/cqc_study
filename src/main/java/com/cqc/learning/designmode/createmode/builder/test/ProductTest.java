package com.cqc.learning.designmode.createmode.builder.test;

import lombok.Data;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.designmode.createmode.builder.test
 * @date 2020/7/22-23:22
 */
@Data
public class ProductTest {

    private String part1;

    private String part2;

    void show(){
        System.out.println(this.part1 +
                this.part2);
    }

}
