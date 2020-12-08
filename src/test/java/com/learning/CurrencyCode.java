package com.learning;

import lombok.Getter;

/**
 * 币种转换
 * @author caoqingcong
 */
@Getter
public enum CurrencyCode {
    /**
     * 币种编码， 币种描述
     */
    USD("USD", "美元"),
    EUR("EUR", "欧元"),
    HKD("HKD", "港币"),
    JPY("JPY", "日元"),
    CAD("CAD", "加元"),
    TWD("TWD", "台币")
    ;
    private String currencyCode;
    private String currencyDesc;

    CurrencyCode(String currencyCode, String currencyDesc) {
        this.currencyCode = currencyCode;
        this.currencyDesc = currencyDesc;
    }

    public static String getCurrencyCodeByDesc(String currencyDesc) {
        if (null == currencyDesc) {
            return null;
        }
        for (CurrencyCode var : values()) {
            if (currencyDesc.equals(var.getCurrencyDesc())) {
                return var.getCurrencyCode();
            }
        }
        return null;
    }
}
