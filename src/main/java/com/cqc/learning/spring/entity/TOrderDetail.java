package com.cqc.learning.spring.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TOrderDetail)实体类
 *
 * @author makejava
 * @since 2020-05-31 16:38:55
 */
public class TOrderDetail implements Serializable {
    private static final long serialVersionUID = -30512650035172357L;
    
    private Integer id;
    /**
    * 子订单id
    */
    private String sid;
    /**
    * 订单id
    */
    private String oid;
    /**
    * 订单类型
    */
    private String type;
    
    private String state;
    /**
    * 商品编码
    */
    private String skuCode;
    /**
    * 品牌
    */
    private String brand;
    /**
    * 商品名称
    */
    private String name;
    /**
    * 类目
    */
    private String cat;
    /**
    * 属性
    */
    private String property;
    /**
    * 数量
    */
    private Integer num;
    /**
    * 供应商
    */
    private String supplierEmail;
    /**
    * 供应商
    */
    private String supplierName;
    /**
    * 含税单价
    */
    private String price;
    /**
    * 未税单价
    */
    private String unTaxPrice;
    /**
    * 税率，两位小数
    */
    private String taxRate;
    /**
    * 价格单位
    */
    private String unit;
    /**
    * 发票类型
    */
    private String invoiceType;
    /**
    * 发票抬头
    */
    private String header;
    /**
    * 下单时间
    */
    private Date orderTime;
    /**
    * 发货时间
    */
    private Date deliverTime;
    /**
    * 发货方式
    */
    private String expressType;
    /**
    * 到货周期
    */
    private String arrivalCycle;
    /**
    * 保修信息
    */
    private String guarantee;
    /**
    * 内购备注
    */
    private String huiRemark;
    /**
    * 下单备注
    */
    private String orderRemark;
    /**
    * 采购接单时间
    */
    private Date purchaseOrderTime;
    /**
    * 支付类型
    */
    private String buyerPayType;
    /**
    * 支付方式(内购)
    */
    private String payType;
    /**
    * 采购员
    */
    private String buyerName;
    
    private String buyerEmail;
    /**
    * 取消备注
    */
    private String cancelRemark;
    
    private Date cancelTime;
    /**
    * 支付备注
    */
    private String payRemark;
    /**
    * 收货人
    */
    private String consignee;
    /**
    * 电话
    */
    private String phone;
    
    private String address;
    /**
    * 创建时间
    */
    private Date createTime;
    
    private String transactionId;
    
    private Date receivedTime;
    /**
    * 删除标记
    */
    private Integer delFlag;
    
    private Integer ass;
    /**
    * 商家商品编码
    */
    private String supplierCode;
    /**
    * sku主图
    */
    private String imgSkuList;
    /**
    * 结算状态1-已结算 2-待结算  3-结算中 默认为0-初始态 不需要结算
    */
    private String settleStatus;
    /**
    * 销售金额
    */
    private String salePrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnTaxPrice() {
        return unTaxPrice;
    }

    public void setUnTaxPrice(String unTaxPrice) {
        this.unTaxPrice = unTaxPrice;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getArrivalCycle() {
        return arrivalCycle;
    }

    public void setArrivalCycle(String arrivalCycle) {
        this.arrivalCycle = arrivalCycle;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getHuiRemark() {
        return huiRemark;
    }

    public void setHuiRemark(String huiRemark) {
        this.huiRemark = huiRemark;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Date getPurchaseOrderTime() {
        return purchaseOrderTime;
    }

    public void setPurchaseOrderTime(Date purchaseOrderTime) {
        this.purchaseOrderTime = purchaseOrderTime;
    }

    public String getBuyerPayType() {
        return buyerPayType;
    }

    public void setBuyerPayType(String buyerPayType) {
        this.buyerPayType = buyerPayType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getAss() {
        return ass;
    }

    public void setAss(Integer ass) {
        this.ass = ass;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getImgSkuList() {
        return imgSkuList;
    }

    public void setImgSkuList(String imgSkuList) {
        this.imgSkuList = imgSkuList;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

}