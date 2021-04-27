package com.cqc.learning.designmode.behaviormode.response;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author caoqingcong
 */
@Slf4j
public class LastHandler extends AbstractHandler {

    AbstractHandler next;

    @Override
    public void setNext(AbstractHandler next) {
        super.setNext(next);
    }

    /**
     * 处理请求
     *
     * @param request
     */
    @Override
    public void dealRequest(String request) {
        if (StringUtils.isNotBlank(request)) {
            log.info("链式完成");
        }
    }
}
