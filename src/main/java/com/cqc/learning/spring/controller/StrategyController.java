package com.cqc.learning.spring.controller;

import com.cqc.learning.spring.springstrategy.ISpeakStrategyService;
import com.cqc.learning.spring.springstrategy.StrateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.controller
 * @date 2020/5/31-16:03
 */
@RestController
public class StrategyController {

    @Autowired
    private StrateContext strateContext;

    @RequestMapping("/getStrategy")
    public String getSpeakStrategy(String strategy){
        ISpeakStrategyService service = strateContext.getStrategy(strategy);
        return service.speak();
    }

}
