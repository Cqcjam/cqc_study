package com.cqc.learning.designmode.createmode.singlemode;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.designmode.createmode.singlemode
 * @date 2020/7/22-23:04
 */
public class SingleModeClient {

    public static void main(String[] args) {
        StaticInnerClassCreateSingle.getInstance().getMethod();
    }

}
