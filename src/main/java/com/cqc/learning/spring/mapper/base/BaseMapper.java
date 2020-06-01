package com.cqc.learning.spring.mapper.base;

import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.Mapper;
/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.mapper
 * @date 2020/5/31-18:33
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
