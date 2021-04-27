package com.cqc.learning.designmode.behaviormode.response;

/**
 * @author caoqingcong
 */
public abstract class AbstractHandler {

    private AbstractHandler handler;

    public void setNext(AbstractHandler next) {
        this.handler = next;
    }

    /**
     * 处理请求
     * @param request
     */
    public abstract void dealRequest(String request);

}
