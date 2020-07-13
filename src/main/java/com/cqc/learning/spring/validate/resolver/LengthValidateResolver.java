package com.cqc.learning.spring.validate.resolver;

import com.cqc.learning.spring.validate.LengthValidate;
import com.cqc.learning.spring.validate.Validate;
import org.springframework.stereotype.Component;

import java.lang.reflect.AnnotatedElement;

/**
 * 校验字符串类型的数据长度
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.spring.validate.resolver
 * @date 2020/6/30-11:13
 */
@Component
public class LengthValidateResolver implements Validate {

    @Override
    public String name() {
        return "LengthValidate";
    }

    @Override
    public String validate(Object obj, AnnotatedElement element) {
        LengthValidate lengthValidate = element.getAnnotation(LengthValidate.class);
        if (null != lengthValidate && null != obj) {
            if (obj instanceof String) {
                int lengthLimit = lengthValidate.limit();
                if (obj.toString().length() >= lengthLimit) {
                    return lengthValidate.value();
                }
            }
        }
        return null;
    }
}
