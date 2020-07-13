package com.cqc.learning.spring.springstrategy.validate;

import com.cqc.learning.spring.validate.Validate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.springstrategy.validate
 * @date 2020/6/30-11:34
 */
@Component
public class ValidateStrategyChoose implements InitializingBean, ApplicationContextAware {

    private ApplicationContext context;

    private Map<String, Validate> validateMap = new HashMap<>();

    public Validate choose(String name) {
        return validateMap.get(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Validate> beanMap = context.getBeansOfType(Validate.class);
        for (Map.Entry<String, Validate> bean : beanMap.entrySet()) {
            validateMap.put(bean.getValue().name(), bean.getValue());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
