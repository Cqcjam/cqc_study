package com.cqc.learning.spring.bean;

import com.cqc.learning.java.stream.StreamTest;
import com.cqc.learning.spring.bean.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.bean
 * @date 2020/4/19-15:52
 */
@Configuration
public class TestConfiguration {

    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setAge(12);
        return person;
    }
}
