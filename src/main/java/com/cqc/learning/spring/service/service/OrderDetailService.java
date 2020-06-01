package com.cqc.learning.spring.service.service;

import com.cqc.learning.spring.entity.TOrderDetail;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.service.service
 * @date 2020/5/31-17:49
 */
public interface OrderDetailService {

    TOrderDetail getOrderById(Integer id);
}
