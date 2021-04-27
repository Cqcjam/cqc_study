package com.cqc.learning.designmode.behaviormode.response;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author caoqingcong
 */
@Slf4j
public class EatHandler extends AbstractHandler {

    AbstractHandler next;

    @Override
    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    /**
     * 处理请求
     *
     * @param request
     */
    @Override
    public void dealRequest(String request) {
        if (StringUtils.isNotBlank(request) && BaseConst.EAT.equals(request.substring(5,8))) {
            log.info("吃的链式请求完成");
            next.dealRequest(request);
        }
    }
}
