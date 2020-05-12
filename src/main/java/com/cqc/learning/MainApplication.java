package com.cqc.learning;

import com.cqc.learning.spring.springstrategy.ISpeakStrategyService;
import com.cqc.learning.spring.springstrategy.StrateContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class MainApplication {

	@Resource
	StrateContext strateContext;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class);
		new MainApplication().test();
		//new SpringApplication().setMainApplicationClass(MainApplication.class);
	}

	public void test() {
		ISpeakStrategyService service = strateContext.getStrategy("chinese");
		System.out.println(service.speak());
	}
}
