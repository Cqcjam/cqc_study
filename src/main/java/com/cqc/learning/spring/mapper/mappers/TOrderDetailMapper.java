package com.cqc.learning.spring.mapper.mappers;

import com.cqc.learning.spring.entity.TOrderDetail;
import com.cqc.learning.spring.mapper.base.BaseMapper;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.mapper
 * @date 2020/5/31-18:34
 */
public interface TOrderDetailMapper extends BaseMapper<TOrderDetail> {

    TOrderDetail queryByDetailId(Integer id);
}
