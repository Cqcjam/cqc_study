package com.cqc.learning.spring.controller;

import com.cqc.learning.spring.service.service.OrderDetailService;
import com.cqc.learning.spring.validate.LengthValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.controller
 * @date 2020/5/31-17:59
 */
@RestController
public class OrderController {

    @Autowired
    OrderDetailService service;

    @RequestMapping("/getOrder")
    public String getOrder(@LengthValidate(limit = 5,value = "参数长度限制") String id){
        return id;
        //return JSON.toJSONString(service.getOrderById(id));
    }
}
