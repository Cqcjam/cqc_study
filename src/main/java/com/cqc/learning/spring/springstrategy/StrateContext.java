package com.cqc.learning.spring.springstrategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.springstrategy
 * @date 2020/5/11-16:50
 */
@Component
public class StrateContext implements InitializingBean, ApplicationContextAware {

    private ApplicationContext ac;

    private Map<String, ISpeakStrategyService> strategyMap = new HashMap<>();

    public ISpeakStrategyService getStrategy(String strategyType) {
        return strategyMap.get(strategyType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, ISpeakStrategyService> beanMap = ac.getBeansOfType(ISpeakStrategyService.class);
        for (ISpeakStrategyService bean : beanMap.values()) {
            this.strategyMap.put(bean.name(), bean);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }
}
