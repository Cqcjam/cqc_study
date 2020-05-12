package com.cqc.learning.spring.springstrategy;

import com.cqc.learning.MainApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caoqingcong
 * @description TODO
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.springstrategy
 * @date 2020/5/11-19:36
 */
@SpringBootApplication
public class Client {

    @Autowired
    StrateContext strateContext;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
        new Client().test();
    }

    public void test() {
        ISpeakStrategyService service = strateContext.getStrategy("chinese");
        System.out.println(service.speak());

    }

}
