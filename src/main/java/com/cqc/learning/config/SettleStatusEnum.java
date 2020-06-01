package com.cqc.learning.config;

/**
 * @author caoqingcong
 * @projectName netease-purchase-v2
 * @packageName org.dfw.app.domain.common
 * @date 2020/5/22-10:53
 */
public enum SettleStatusEnum {

    INITIAL("0", "初始状态"),
    SUCCESS_SETTLE("1", "已结算"),
    WAIT_SETTLE("2", "待结算"),
    SETTLE_ING("3", "结算中")
    ;
    SettleStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public static String getMessageByCode(String code) {
        if (null == code) return null;
        for (SettleStatusEnum enumTemp : SettleStatusEnum.values()) {
            if (enumTemp.getCode().equals(code)) {
                return enumTemp.getMessage();
            }
        }
        return null;
    }
    public String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    private String code;
    private String message;
}
