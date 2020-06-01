package com.cqc.learning.spring.springstrategy;

import org.springframework.stereotype.Component;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.springstrategy
 * @date 2020/5/11-16:49
 */
@Component
public class EnglishSpeakStrategyImpl implements ISpeakStrategyService{
    @Override
    public String speak() {
        return "I'm speaking English";
    }
    @Override
    public String name() {
        return "english";
    }
}
