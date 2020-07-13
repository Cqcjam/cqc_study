package com.cqc.learning.spring.validate;

import com.alibaba.fastjson.annotation.JSONField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.validate
 * @date 2020/6/30-11:12
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthValidate {

    String value();

    @JSONField
    int limit();

}
