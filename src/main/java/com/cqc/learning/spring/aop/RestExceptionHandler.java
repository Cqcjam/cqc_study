
package com.cqc.learning.spring.aop;

import com.cqc.learning.spring.base.BaseResult;
import com.cqc.learning.spring.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * controller层的异常捕获，自定义返回异常信息
 * 
 * 这里可以自定义异常后的处理，如发送告警邮件，popo消息等
 */
@Slf4j
@Component
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 处理业务异常，返回业务异常信息
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResult businessExceptionHandler(BusinessException e) {
        return BaseResult.error(e.getCode(), e.getMsg());
    }

    /**
     * 其余异常，返回内部错误
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResult exceptionHandler(Exception e, HttpServletRequest request) {
        log.error("exceptionHandler exception, url = [{}]. method = [{}]",
                request.getRequestURI(), request.getMethod());
        return BaseResult.error();
    }

}
