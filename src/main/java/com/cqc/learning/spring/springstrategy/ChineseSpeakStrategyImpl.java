package com.cqc.learning.spring.springstrategy;

import org.springframework.stereotype.Component;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.springstrategy
 * @date 2020/5/11-16:49
 */
@Component
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
