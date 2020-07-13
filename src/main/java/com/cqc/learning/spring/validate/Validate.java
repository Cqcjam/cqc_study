package com.cqc.learning.spring.validate;

import java.lang.reflect.AnnotatedElement;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.validate
 * @date 2020/6/30-11:08
 */
public interface Validate {

    String name();

    /**
     *
     * @param obj 对象
     * @param element 这个接口（AnnotatedElement）
     *                的对象代表了在当前JVM中的一个“被注解元素”（可以是Class，Method，Field，Constructor，Package等）。
     * @return string
     */
    String validate(Object obj, AnnotatedElement element);
}
