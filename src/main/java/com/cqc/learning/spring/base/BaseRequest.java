
package com.cqc.learning.spring.base;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 通用请求实体参数
 */
@Getter
@Setter
public class BaseRequest {
    
    private Integer pageNum;
    
    private Integer pageSize;
    
    private Long startTime;
    
    private Long endTime;
    
    private Map<String, Object> params;
}
