package com.cqc.learning.spring.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class CommonExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public String catchBusinessException(){
        System.out.println("捕获异常");
        return "error";
    }

}
