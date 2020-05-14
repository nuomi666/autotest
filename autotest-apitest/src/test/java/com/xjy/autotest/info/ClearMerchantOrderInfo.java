package com.xjy.autotest.info;


import com.xyb.adk.common.util.money.Money;
import com.xyb.pay.api.common.enums.TransTagEnum;
import com.xyb.pay.api.common.enums.TransTypeEnum;
import lombok.Data;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 渠道订单信息
 **/
public class ClearMerchantOrderInfo {
    /**
     * 交易类型
     */
    private TransTypeEnum transType;

    /**
     * 交易tag
     */
    private TransTagEnum transTag;

    /**
     * 渠道id
     */
    private String channelId;

    /**
     * 签约商户id
     */
    private String partnerId;

    /**
     * 平台商户id
     */
    private String platPartnerId;

    /**
     * 签约商户订单号
     */
    private String merchantOrderNo;
    /**
     * 平台商户订单号
     */
    private String platMerchantOrderNo;
    /**
     * 交易单号
     */
    private String merchantTradeNo;
    /**
     * 退款单号
     */
    private String merchantRefundNo;

    /**
     * 商户订单金额
     */
    private Money merchantOrderAmount;

    /**
     * 商户交易（支付、退款、提现）金额
     */
    private Money merchantAmount;

    /**
     * 商户交易时间
     */
    private Date merchantTradeTime;
    /**
     * 支付人用户id
     */
    private String payeeUserId;

    /**
     * 支付人用户账户
     */
    private String payeeAccountNo;

    /**
     * 收款人用户id
     */
    private String payerUserId;

    /**
     * 收款人账户
     */
    private String payerAccountNo;

    /**
     * 商户手续费费率，百分比。为平台给商家的费率
     */
    private Float merchantFee;

    /**
     * 渠道费率，百分比。为渠道给平台的费率底价
     */
    private Float merchantChannelFee;

    /*** 以下数据不由mq传递获取 */
    /**
     * 商家手续费，单位元，不同渠道保留位数不一样
     */
    private BigDecimal merchantFeeAmount;

    /**
     * 平台实际手续费，单位元，不同渠道保留位数不一样
     */
    private BigDecimal channelFeeAmount;

    /**
     * 商家费率计算规则
     * EACH("EACH","单笔金额"),
     * PERIOD("PERIOD","周期总额")
     */
    private String merchantRateType;

    /**
     * 平台费率计算规则
     * EACH("EACH","单笔金额"),
     * PERIOD("PERIOD","周期总额")
     */
    private String channelRateType;

    public TransTypeEnum getTransType() {
        return transType;
    }

    public void setTransType(TransTypeEnum transType) {
        this.transType = transType;
    }

    public TransTagEnum getTransTag() {
        return transTag;
    }

    public void setTransTag(TransTagEnum transTag) {
        this.transTag = transTag;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPlatPartnerId() {
        return platPartnerId;
    }

    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo;
    }

    public String getMerchantTradeNo() {
        return merchantTradeNo;
    }

    public void setMerchantTradeNo(String merchantTradeNo) {
        this.merchantTradeNo = merchantTradeNo;
    }

    public String getMerchantRefundNo() {
        return merchantRefundNo;
    }

    public void setMerchantRefundNo(String merchantRefundNo) {
        this.merchantRefundNo = merchantRefundNo;
    }

    public Money getMerchantOrderAmount() {
        return merchantOrderAmount;
    }

    public void setMerchantOrderAmount(Money merchantOrderAmount) {
        this.merchantOrderAmount = merchantOrderAmount;
    }

    public Money getMerchantAmount() {
        return merchantAmount;
    }

    public void setMerchantAmount(Money merchantAmount) {
        this.merchantAmount = merchantAmount;
    }

    public Date getMerchantTradeTime() {
        return merchantTradeTime;
    }

    public void setMerchantTradeTime(Date merchantTradeTime) {
        this.merchantTradeTime = merchantTradeTime;
    }

    public String getPayeeUserId() {
        return payeeUserId;
    }

    public void setPayeeUserId(String payeeUserId) {
        this.payeeUserId = payeeUserId;
    }

    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    public String getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId;
    }

    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo;
    }

    public Float getMerchantFee() {
        return merchantFee;
    }

    public void setMerchantFee(Float merchantFee) {
        this.merchantFee = merchantFee;
    }

    public Float getMerchantChannelFee() {
        return merchantChannelFee;
    }

    public void setMerchantChannelFee(Float merchantChannelFee) {
        this.merchantChannelFee = merchantChannelFee;
    }

    public BigDecimal getMerchantFeeAmount() {
        return merchantFeeAmount;
    }

    public void setMerchantFeeAmount(BigDecimal merchantFeeAmount) {
        this.merchantFeeAmount = merchantFeeAmount;
    }

    public BigDecimal getChannelFeeAmount() {
        return channelFeeAmount;
    }

    public void setChannelFeeAmount(BigDecimal channelFeeAmount) {
        this.channelFeeAmount = channelFeeAmount;
    }

    public String getMerchantRateType() {
        return merchantRateType;
    }

    public void setMerchantRateType(String merchantRateType) {
        this.merchantRateType = merchantRateType;
    }

    public String getChannelRateType() {
        return channelRateType;
    }

    public void setChannelRateType(String channelRateType) {
        this.channelRateType = channelRateType;
    }

    @Override
    public String toString() {
        return "ClearMerchantOrderInfo{" +
                "transType=" + transType +
                ", transTag=" + transTag +
                ", channelId='" + channelId + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", platPartnerId='" + platPartnerId + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                ", platMerchantOrderNo='" + platMerchantOrderNo + '\'' +
                ", merchantTradeNo='" + merchantTradeNo + '\'' +
                ", merchantRefundNo='" + merchantRefundNo + '\'' +
                ", merchantOrderAmount=" + merchantOrderAmount +
                ", merchantAmount=" + merchantAmount +
                ", merchantTradeTime=" + merchantTradeTime +
                ", payeeUserId='" + payeeUserId + '\'' +
                ", payeeAccountNo='" + payeeAccountNo + '\'' +
                ", payerUserId='" + payerUserId + '\'' +
                ", payerAccountNo='" + payerAccountNo + '\'' +
                ", merchantFee=" + merchantFee +
                ", merchantChannelFee=" + merchantChannelFee +
                ", merchantFeeAmount=" + merchantFeeAmount +
                ", channelFeeAmount=" + channelFeeAmount +
                ", merchantRateType='" + merchantRateType + '\'' +
                ", channelRateType='" + channelRateType + '\'' +
                '}';
    }
}
