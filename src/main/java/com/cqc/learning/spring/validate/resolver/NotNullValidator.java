
package com.cqc.learning.spring.validate.resolver;

import com.cqc.learning.spring.validate.NotNull;
import com.cqc.learning.spring.validate.Validate;
import org.springframework.stereotype.Component;

import java.lang.reflect.AnnotatedElement;

@Component
public class NotNullValidator implements Validate {
    @Override
    public String name() {
        return "NotNull";
    }

    @Override
    public String validate(Object o, AnnotatedElement element) {
        NotNull notNull = element.getAnnotation(NotNull.class);
        if (notNull != null && o == null) {
            return notNull.value();
        }
        return null;
    }
}
