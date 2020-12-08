package com.cqc.learning.spring.exception;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonExceptionController {

    @RequestMapping("/testException")
    public Integer test() {
        try {
            int i = 0;
            return 1/i;
        } catch (Exception e) {
            throw new BusinessException(1, "错误");
        }
    }

}
