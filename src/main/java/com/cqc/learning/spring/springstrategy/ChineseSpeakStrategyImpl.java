package com.cqc.learning.spring.springstrategy;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.springstrategy
 * @date 2020/5/11-16:49
 */
public class ChineseSpeakStrategyImpl implements ISpeakStrategyService{
    @Override
    public String name() {
        return "chinese";
    }

    @Override
    public String speak() {
        return "I'm speaking Chinese";
    }
}
