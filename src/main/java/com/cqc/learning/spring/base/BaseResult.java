
package com.cqc.learning.spring.base;

import lombok.Data;
import org.springframework.util.Assert;

/**
 * 通用返回实体
 * @param <T>
 */
@Data
public class BaseResult<T> {
    private static final int CODE_SUCCESS = 0;
    private static final String MSG_SUCCESS = "success";

    private static final int CODE_ERROR = 1;
    private static final String MSG_ERROR = "内部错误";
    
    private int code;
    
    private String message;
    
    private T data;
    
    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult() {
    }

    public static <T> BaseResult<T> success() {
        return BaseResult.success(null);
    }
    
    public static <T> BaseResult<T> success(T data) {
        BaseResult<T> result = new BaseResult<>(CODE_SUCCESS, MSG_SUCCESS, data);
        return result;
    }

    public static <T> BaseResult<T> error() {
        return error(CODE_ERROR, MSG_ERROR, null);
    }
    
    public static <T> BaseResult<T> error(Integer code) {
        return error(code, MSG_ERROR, null);
    }

    public static <T> BaseResult<T> error(Integer code, String msg) {
        return error(code, msg, null);
    }

    public static <T> BaseResult<T> error(Integer code, String msg, T data) {
        Assert.isTrue(CODE_SUCCESS != code, "code 必须是错误的！");
        BaseResult<T> result = new BaseResult<>(code, msg, data);
        return result;
    }

    public static <T> BaseResult<T> permissionDenied() {
        return error(403, "权限不足！");
    }
}
