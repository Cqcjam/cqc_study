package com.cqc.learning.java.stream;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AccountDetail {

    private Long id;
    
    private String sid;

    private String oid;

    private String accountState;

    private AccountState state;

    private String accountTime;

    private String brand;

    private String name;

    private String property;

    private int num;

    private double purchasePrice;

    private double purchaseTotalPrice;

    private double historyAccountPrice;

    private double wangAccountPrice;

    private double zhiAccountPrice;

    private double accountTotalPrice;

    private String supplierName;

    private String payType;

    private String transactionId;

    private Date orderTime;

    private Date deliverTime;

    private Date receivedTime;

    private int historyAccountis;

    private Date rawbackTime;

    private String company;

    private String expressId;

    private int expressIs;

    private String expressType;

    private String accountRemark;

    private String supplierRemark;

    private List<String> auth;

    private Date ct;

    private String startDate;

    private String endDate;

    private Double salePrice;

    private String settleStatus;
    
    private Integer historyGoodsNum;
    
    private Integer delFlag;

    private Integer ass;

    private Integer assNum;

    private double profitPrice;

    private String supplierEmail;

    private String supplierType;

    private String refuseReason;

    private Integer partPoling;

    private double finishAccount;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getReceivedTime() {
        return receivedTime;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getRawbackTime() {
        return rawbackTime;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCt() {
        return ct;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public enum AccountState{

        /**
         * WAIT_START(未发起),
         WAIT_CONFIRM(待确认),
         CONFIRM(已确认),
         FILING(已归档),
         PART_FILING(部分归档),
         REFUSE(已拒绝)]

         */
        WAIT_START,
        WAIT_CONFIRM,
        CONFIRM,
        FILING,
        PART_FOLING,
        REFUSE
    }

}
