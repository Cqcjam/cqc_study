package com.cqc.learning.spring.service.impl;

import com.cqc.learning.spring.entity.TOrderDetail;
import com.cqc.learning.spring.mapper.mappers.TOrderDetailMapper;
import com.cqc.learning.spring.service.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.service.impl
 * @date 2020/5/31-17:49
 */
@Component
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    TOrderDetailMapper tOrderDetailMapper;

    @Override
    public TOrderDetail getOrderById(Integer id) {
        return tOrderDetailMapper.queryByDetailId(id);
    }
}
