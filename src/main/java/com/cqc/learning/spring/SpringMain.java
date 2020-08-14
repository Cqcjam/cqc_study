package com.cqc.learning.spring;

import com.cqc.learning.MainApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.cqc.learning.spring.mapper.mappers")
@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }
}
