package dal.model.clear;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_merchant_order")
public class ClearMerchantOrderDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 签约商户真实姓名
     */
    @Column(name = "partner_real_name")
    private String partnerRealName;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 交易类型
     */
    @Column(name = "trans_type")
    private String transType;

    /**
     * 交易tag
     */
    @Column(name = "trans_tag")
    private String transTag;

    /**
     * 订单类型，由交易类型和tag组合，用于判断清分金额的收入支出
     */
    @Column(name = "order_type")
    private String orderType;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 业务单号，用于唯一约束
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 平台商户订单号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 商户交易单号
     */
    @Column(name = "merchant_trade_no")
    private String merchantTradeNo;

    /**
     * 商户退款单号
     */
    @Column(name = "merchant_refund_no")
    private String merchantRefundNo;

    /**
     * 商户订单金额，分
     */
    @Column(name = "merchant_order_amount")
    private Long merchantOrderAmount;

    /**
     * 商户交易（支付、退款、提现）金额，分
     */
    @Column(name = "merchant_amount")
    private Long merchantAmount;

    /**
     * 商户手续费金额，单位元
     */
    @Column(name = "merchant_fee_amount")
    private BigDecimal merchantFeeAmount;

    /**
     * 商户手续费费率，百分比
     */
    @Column(name = "merchant_fee")
    private BigDecimal merchantFee;

    /**
     * 商户手续费结算方式
     */
    @Column(name = "merchant_rate_type")
    private String merchantRateType;

    /**
     * 渠道手续费金额，单位元
     */
    @Column(name = "channel_fee_amount")
    private BigDecimal channelFeeAmount;

    /**
     * 渠道手续费率，百分比
     */
    @Column(name = "channel_fee")
    private BigDecimal channelFee;

    /**
     * 渠道手续费结算方式
     */
    @Column(name = "channel_rate_type")
    private String channelRateType;

    /**
     * 商户交易时间
     */
    @Column(name = "merchant_trade_time")
    private Date merchantTradeTime;

    /**
     * 账期yyyyMMdd
     */
    @Column(name = "settlement_date")
    private String settlementDate;

    /**
     * 交易来源
     */
    @Column(name = "trade_resource")
    private String tradeResource;

    /**
     * 清分状态
     */
    @Column(name = "clear_status")
    private String clearStatus;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取签约商户id
     *
     * @return partner_id - 签约商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户id
     *
     * @param partnerId 签约商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取签约商户真实姓名
     *
     * @return partner_real_name - 签约商户真实姓名
     */
    public String getPartnerRealName() {
        return partnerRealName;
    }

    /**
     * 设置签约商户真实姓名
     *
     * @param partnerRealName 签约商户真实姓名
     */
    public void setPartnerRealName(String partnerRealName) {
        this.partnerRealName = partnerRealName == null ? null : partnerRealName.trim();
    }

    /**
     * 获取渠道id
     *
     * @return channel_id - 渠道id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道id
     *
     * @param channelId 渠道id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取平台商户id
     *
     * @return plat_partner_id - 平台商户id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户id
     *
     * @param platPartnerId 平台商户id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取交易类型
     *
     * @return trans_type - 交易类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * 设置交易类型
     *
     * @param transType 交易类型
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * 获取交易tag
     *
     * @return trans_tag - 交易tag
     */
    public String getTransTag() {
        return transTag;
    }

    /**
     * 设置交易tag
     *
     * @param transTag 交易tag
     */
    public void setTransTag(String transTag) {
        this.transTag = transTag == null ? null : transTag.trim();
    }

    /**
     * 获取订单类型，由交易类型和tag组合，用于判断清分金额的收入支出
     *
     * @return order_type - 订单类型，由交易类型和tag组合，用于判断清分金额的收入支出
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置订单类型，由交易类型和tag组合，用于判断清分金额的收入支出
     *
     * @param orderType 订单类型，由交易类型和tag组合，用于判断清分金额的收入支出
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * 获取商户订单号
     *
     * @return merchant_order_no - 商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置商户订单号
     *
     * @param merchantOrderNo 商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /**
     * 获取业务单号，用于唯一约束
     *
     * @return biz_no - 业务单号，用于唯一约束
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务单号，用于唯一约束
     *
     * @param bizNo 业务单号，用于唯一约束
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取平台商户订单号
     *
     * @return plat_merchant_order_no - 平台商户订单号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台商户订单号
     *
     * @param platMerchantOrderNo 平台商户订单号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
    }

    /**
     * 获取商户交易单号
     *
     * @return merchant_trade_no - 商户交易单号
     */
    public String getMerchantTradeNo() {
        return merchantTradeNo;
    }

    /**
     * 设置商户交易单号
     *
     * @param merchantTradeNo 商户交易单号
     */
    public void setMerchantTradeNo(String merchantTradeNo) {
        this.merchantTradeNo = merchantTradeNo == null ? null : merchantTradeNo.trim();
    }

    /**
     * 获取商户退款单号
     *
     * @return merchant_refund_no - 商户退款单号
     */
    public String getMerchantRefundNo() {
        return merchantRefundNo;
    }

    /**
     * 设置商户退款单号
     *
     * @param merchantRefundNo 商户退款单号
     */
    public void setMerchantRefundNo(String merchantRefundNo) {
        this.merchantRefundNo = merchantRefundNo == null ? null : merchantRefundNo.trim();
    }

    /**
     * 获取商户订单金额，分
     *
     * @return merchant_order_amount - 商户订单金额，分
     */
    public Long getMerchantOrderAmount() {
        return merchantOrderAmount;
    }

    /**
     * 设置商户订单金额，分
     *
     * @param merchantOrderAmount 商户订单金额，分
     */
    public void setMerchantOrderAmount(Long merchantOrderAmount) {
        this.merchantOrderAmount = merchantOrderAmount;
    }

    /**
     * 获取商户交易（支付、退款、提现）金额，分
     *
     * @return merchant_amount - 商户交易（支付、退款、提现）金额，分
     */
    public Long getMerchantAmount() {
        return merchantAmount;
    }

    /**
     * 设置商户交易（支付、退款、提现）金额，分
     *
     * @param merchantAmount 商户交易（支付、退款、提现）金额，分
     */
    public void setMerchantAmount(Long merchantAmount) {
        this.merchantAmount = merchantAmount;
    }

    /**
     * 获取商户手续费金额，单位元
     *
     * @return merchant_fee_amount - 商户手续费金额，单位元
     */
    public BigDecimal getMerchantFeeAmount() {
        return merchantFeeAmount;
    }

    /**
     * 设置商户手续费金额，单位元
     *
     * @param merchantFeeAmount 商户手续费金额，单位元
     */
    public void setMerchantFeeAmount(BigDecimal merchantFeeAmount) {
        this.merchantFeeAmount = merchantFeeAmount;
    }

    /**
     * 获取商户手续费费率，百分比
     *
     * @return merchant_fee - 商户手续费费率，百分比
     */
    public BigDecimal getMerchantFee() {
        return merchantFee;
    }

    /**
     * 设置商户手续费费率，百分比
     *
     * @param merchantFee 商户手续费费率，百分比
     */
    public void setMerchantFee(BigDecimal merchantFee) {
        this.merchantFee = merchantFee;
    }

    /**
     * 获取商户手续费结算方式
     *
     * @return merchant_rate_type - 商户手续费结算方式
     */
    public String getMerchantRateType() {
        return merchantRateType;
    }

    /**
     * 设置商户手续费结算方式
     *
     * @param merchantRateType 商户手续费结算方式
     */
    public void setMerchantRateType(String merchantRateType) {
        this.merchantRateType = merchantRateType == null ? null : merchantRateType.trim();
    }

    /**
     * 获取渠道手续费金额，单位元
     *
     * @return channel_fee_amount - 渠道手续费金额，单位元
     */
    public BigDecimal getChannelFeeAmount() {
        return channelFeeAmount;
    }

    /**
     * 设置渠道手续费金额，单位元
     *
     * @param channelFeeAmount 渠道手续费金额，单位元
     */
    public void setChannelFeeAmount(BigDecimal channelFeeAmount) {
        this.channelFeeAmount = channelFeeAmount;
    }

    /**
     * 获取渠道手续费率，百分比
     *
     * @return channel_fee - 渠道手续费率，百分比
     */
    public BigDecimal getChannelFee() {
        return channelFee;
    }

    /**
     * 设置渠道手续费率，百分比
     *
     * @param channelFee 渠道手续费率，百分比
     */
    public void setChannelFee(BigDecimal channelFee) {
        this.channelFee = channelFee;
    }

    /**
     * 获取渠道手续费结算方式
     *
     * @return channel_rate_type - 渠道手续费结算方式
     */
    public String getChannelRateType() {
        return channelRateType;
    }

    /**
     * 设置渠道手续费结算方式
     *
     * @param channelRateType 渠道手续费结算方式
     */
    public void setChannelRateType(String channelRateType) {
        this.channelRateType = channelRateType == null ? null : channelRateType.trim();
    }

    /**
     * 获取商户交易时间
     *
     * @return merchant_trade_time - 商户交易时间
     */
    public Date getMerchantTradeTime() {
        return merchantTradeTime;
    }

    /**
     * 设置商户交易时间
     *
     * @param merchantTradeTime 商户交易时间
     */
    public void setMerchantTradeTime(Date merchantTradeTime) {
        this.merchantTradeTime = merchantTradeTime;
    }

    /**
     * 获取账期yyyyMMdd
     *
     * @return settlement_date - 账期yyyyMMdd
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * 设置账期yyyyMMdd
     *
     * @param settlementDate 账期yyyyMMdd
     */
    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate == null ? null : settlementDate.trim();
    }

    /**
     * 获取交易来源
     *
     * @return trade_resource - 交易来源
     */
    public String getTradeResource() {
        return tradeResource;
    }

    /**
     * 设置交易来源
     *
     * @param tradeResource 交易来源
     */
    public void setTradeResource(String tradeResource) {
        this.tradeResource = tradeResource == null ? null : tradeResource.trim();
    }

    /**
     * 获取清分状态
     *
     * @return clear_status - 清分状态
     */
    public String getClearStatus() {
        return clearStatus;
    }

    /**
     * 设置清分状态
     *
     * @param clearStatus 清分状态
     */
    public void setClearStatus(String clearStatus) {
        this.clearStatus = clearStatus == null ? null : clearStatus.trim();
    }

    /**
     * @return raw_add_time
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * @param rawAddTime
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * @return raw_update_time
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * @param rawUpdateTime
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerRealName=").append(partnerRealName);
        sb.append(", channelId=").append(channelId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", transType=").append(transType);
        sb.append(", transTag=").append(transTag);
        sb.append(", orderType=").append(orderType);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantTradeNo=").append(merchantTradeNo);
        sb.append(", merchantRefundNo=").append(merchantRefundNo);
        sb.append(", merchantOrderAmount=").append(merchantOrderAmount);
        sb.append(", merchantAmount=").append(merchantAmount);
        sb.append(", merchantFeeAmount=").append(merchantFeeAmount);
        sb.append(", merchantFee=").append(merchantFee);
        sb.append(", merchantRateType=").append(merchantRateType);
        sb.append(", channelFeeAmount=").append(channelFeeAmount);
        sb.append(", channelFee=").append(channelFee);
        sb.append(", channelRateType=").append(channelRateType);
        sb.append(", merchantTradeTime=").append(merchantTradeTime);
        sb.append(", settlementDate=").append(settlementDate);
        sb.append(", tradeResource=").append(tradeResource);
        sb.append(", clearStatus=").append(clearStatus);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ClearMerchantOrderDO other = (ClearMerchantOrderDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getTransType() == null ? other.getTransType() == null : this.getTransType().equals(other.getTransType()))
            && (this.getTransTag() == null ? other.getTransTag() == null : this.getTransTag().equals(other.getTransTag()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantTradeNo() == null ? other.getMerchantTradeNo() == null : this.getMerchantTradeNo().equals(other.getMerchantTradeNo()))
            && (this.getMerchantRefundNo() == null ? other.getMerchantRefundNo() == null : this.getMerchantRefundNo().equals(other.getMerchantRefundNo()))
            && (this.getMerchantOrderAmount() == null ? other.getMerchantOrderAmount() == null : this.getMerchantOrderAmount().equals(other.getMerchantOrderAmount()))
            && (this.getMerchantAmount() == null ? other.getMerchantAmount() == null : this.getMerchantAmount().equals(other.getMerchantAmount()))
            && (this.getMerchantFeeAmount() == null ? other.getMerchantFeeAmount() == null : this.getMerchantFeeAmount().equals(other.getMerchantFeeAmount()))
            && (this.getMerchantFee() == null ? other.getMerchantFee() == null : this.getMerchantFee().equals(other.getMerchantFee()))
            && (this.getMerchantRateType() == null ? other.getMerchantRateType() == null : this.getMerchantRateType().equals(other.getMerchantRateType()))
            && (this.getChannelFeeAmount() == null ? other.getChannelFeeAmount() == null : this.getChannelFeeAmount().equals(other.getChannelFeeAmount()))
            && (this.getChannelFee() == null ? other.getChannelFee() == null : this.getChannelFee().equals(other.getChannelFee()))
            && (this.getChannelRateType() == null ? other.getChannelRateType() == null : this.getChannelRateType().equals(other.getChannelRateType()))
            && (this.getMerchantTradeTime() == null ? other.getMerchantTradeTime() == null : this.getMerchantTradeTime().equals(other.getMerchantTradeTime()))
            && (this.getSettlementDate() == null ? other.getSettlementDate() == null : this.getSettlementDate().equals(other.getSettlementDate()))
            && (this.getTradeResource() == null ? other.getTradeResource() == null : this.getTradeResource().equals(other.getTradeResource()))
            && (this.getClearStatus() == null ? other.getClearStatus() == null : this.getClearStatus().equals(other.getClearStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerRealName() == null) ? 0 : getPartnerRealName().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getTransType() == null) ? 0 : getTransType().hashCode());
        result = prime * result + ((getTransTag() == null) ? 0 : getTransTag().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantTradeNo() == null) ? 0 : getMerchantTradeNo().hashCode());
        result = prime * result + ((getMerchantRefundNo() == null) ? 0 : getMerchantRefundNo().hashCode());
        result = prime * result + ((getMerchantOrderAmount() == null) ? 0 : getMerchantOrderAmount().hashCode());
        result = prime * result + ((getMerchantAmount() == null) ? 0 : getMerchantAmount().hashCode());
        result = prime * result + ((getMerchantFeeAmount() == null) ? 0 : getMerchantFeeAmount().hashCode());
        result = prime * result + ((getMerchantFee() == null) ? 0 : getMerchantFee().hashCode());
        result = prime * result + ((getMerchantRateType() == null) ? 0 : getMerchantRateType().hashCode());
        result = prime * result + ((getChannelFeeAmount() == null) ? 0 : getChannelFeeAmount().hashCode());
        result = prime * result + ((getChannelFee() == null) ? 0 : getChannelFee().hashCode());
        result = prime * result + ((getChannelRateType() == null) ? 0 : getChannelRateType().hashCode());
        result = prime * result + ((getMerchantTradeTime() == null) ? 0 : getMerchantTradeTime().hashCode());
        result = prime * result + ((getSettlementDate() == null) ? 0 : getSettlementDate().hashCode());
        result = prime * result + ((getTradeResource() == null) ? 0 : getTradeResource().hashCode());
        result = prime * result + ((getClearStatus() == null) ? 0 : getClearStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}