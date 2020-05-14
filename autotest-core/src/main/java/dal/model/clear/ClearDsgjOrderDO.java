package dal.model.clear;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_dsgj_order")
public class ClearDsgjOrderDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单对账key值，由对账模型md5生成
     */
    @Column(name = "order_key")
    private String orderKey;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 交易类型：支付、退款、提现
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 交易来源
     */
    @Column(name = "trade_resource")
    private String tradeResource;

    /**
     * 渠道交易单号
     */
    @Column(name = "channel_trade_no")
    private String channelTradeNo;

    /**
     * 渠道退款单号
     */
    @Column(name = "channel_refund_no")
    private String channelRefundNo;

    /**
     * 订单金额，分
     */
    @Column(name = "order_amount")
    private Long orderAmount;

    /**
     * 交易金额，分
     */
    @Column(name = "trade_amount")
    private Long tradeAmount;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 商户子订单
     */
    @Column(name = "merchant_sub_order_no")
    private String merchantSubOrderNo;

    /**
     * 订单类型母订单/子订单
     */
    @Column(name = "order_rank_type")
    private String orderRankType;

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
     * 商户手续费，单位元
     */
    @Column(name = "merchant_fee_amount")
    private BigDecimal merchantFeeAmount;

    /**
     * 商户手续费费率，百分比
     */
    @Column(name = "merchant_fee")
    private BigDecimal merchantFee;

    /**
     * 渠道手续费，单位元
     */
    @Column(name = "channel_fee_amount")
    private BigDecimal channelFeeAmount;

    /**
     * 渠道手续费率，百分比
     */
    @Column(name = "channel_fee")
    private BigDecimal channelFee;

    /**
     * 商户交易时间
     */
    @Column(name = "trade_time")
    private Date tradeTime;

    /**
     * 清分日期yyyyMMdd
     */
    @Column(name = "clear_date")
    private String clearDate;

    /**
     * 清分文件名称
     */
    @Column(name = "clear_file_name")
    private String clearFileName;

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
     * 获取订单对账key值，由对账模型md5生成
     *
     * @return order_key - 订单对账key值，由对账模型md5生成
     */
    public String getOrderKey() {
        return orderKey;
    }

    /**
     * 设置订单对账key值，由对账模型md5生成
     *
     * @param orderKey 订单对账key值，由对账模型md5生成
     */
    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey == null ? null : orderKey.trim();
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
     * 获取交易类型：支付、退款、提现
     *
     * @return trade_type - 交易类型：支付、退款、提现
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * 设置交易类型：支付、退款、提现
     *
     * @param tradeType 交易类型：支付、退款、提现
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
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
     * 获取渠道交易单号
     *
     * @return channel_trade_no - 渠道交易单号
     */
    public String getChannelTradeNo() {
        return channelTradeNo;
    }

    /**
     * 设置渠道交易单号
     *
     * @param channelTradeNo 渠道交易单号
     */
    public void setChannelTradeNo(String channelTradeNo) {
        this.channelTradeNo = channelTradeNo == null ? null : channelTradeNo.trim();
    }

    /**
     * 获取渠道退款单号
     *
     * @return channel_refund_no - 渠道退款单号
     */
    public String getChannelRefundNo() {
        return channelRefundNo;
    }

    /**
     * 设置渠道退款单号
     *
     * @param channelRefundNo 渠道退款单号
     */
    public void setChannelRefundNo(String channelRefundNo) {
        this.channelRefundNo = channelRefundNo == null ? null : channelRefundNo.trim();
    }

    /**
     * 获取订单金额，分
     *
     * @return order_amount - 订单金额，分
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单金额，分
     *
     * @param orderAmount 订单金额，分
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取交易金额，分
     *
     * @return trade_amount - 交易金额，分
     */
    public Long getTradeAmount() {
        return tradeAmount;
    }

    /**
     * 设置交易金额，分
     *
     * @param tradeAmount 交易金额，分
     */
    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
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
     * 获取商户子订单
     *
     * @return merchant_sub_order_no - 商户子订单
     */
    public String getMerchantSubOrderNo() {
        return merchantSubOrderNo;
    }

    /**
     * 设置商户子订单
     *
     * @param merchantSubOrderNo 商户子订单
     */
    public void setMerchantSubOrderNo(String merchantSubOrderNo) {
        this.merchantSubOrderNo = merchantSubOrderNo == null ? null : merchantSubOrderNo.trim();
    }

    /**
     * 获取订单类型母订单/子订单
     *
     * @return order_rank_type - 订单类型母订单/子订单
     */
    public String getOrderRankType() {
        return orderRankType;
    }

    /**
     * 设置订单类型母订单/子订单
     *
     * @param orderRankType 订单类型母订单/子订单
     */
    public void setOrderRankType(String orderRankType) {
        this.orderRankType = orderRankType == null ? null : orderRankType.trim();
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
     * 获取商户手续费，单位元
     *
     * @return merchant_fee_amount - 商户手续费，单位元
     */
    public BigDecimal getMerchantFeeAmount() {
        return merchantFeeAmount;
    }

    /**
     * 设置商户手续费，单位元
     *
     * @param merchantFeeAmount 商户手续费，单位元
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
     * 获取渠道手续费，单位元
     *
     * @return channel_fee_amount - 渠道手续费，单位元
     */
    public BigDecimal getChannelFeeAmount() {
        return channelFeeAmount;
    }

    /**
     * 设置渠道手续费，单位元
     *
     * @param channelFeeAmount 渠道手续费，单位元
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
     * 获取商户交易时间
     *
     * @return trade_time - 商户交易时间
     */
    public Date getTradeTime() {
        return tradeTime;
    }

    /**
     * 设置商户交易时间
     *
     * @param tradeTime 商户交易时间
     */
    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * 获取清分日期yyyyMMdd
     *
     * @return clear_date - 清分日期yyyyMMdd
     */
    public String getClearDate() {
        return clearDate;
    }

    /**
     * 设置清分日期yyyyMMdd
     *
     * @param clearDate 清分日期yyyyMMdd
     */
    public void setClearDate(String clearDate) {
        this.clearDate = clearDate == null ? null : clearDate.trim();
    }

    /**
     * 获取清分文件名称
     *
     * @return clear_file_name - 清分文件名称
     */
    public String getClearFileName() {
        return clearFileName;
    }

    /**
     * 设置清分文件名称
     *
     * @param clearFileName 清分文件名称
     */
    public void setClearFileName(String clearFileName) {
        this.clearFileName = clearFileName == null ? null : clearFileName.trim();
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
        sb.append(", orderKey=").append(orderKey);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", tradeResource=").append(tradeResource);
        sb.append(", channelTradeNo=").append(channelTradeNo);
        sb.append(", channelRefundNo=").append(channelRefundNo);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", merchantSubOrderNo=").append(merchantSubOrderNo);
        sb.append(", orderRankType=").append(orderRankType);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantTradeNo=").append(merchantTradeNo);
        sb.append(", merchantRefundNo=").append(merchantRefundNo);
        sb.append(", merchantFeeAmount=").append(merchantFeeAmount);
        sb.append(", merchantFee=").append(merchantFee);
        sb.append(", channelFeeAmount=").append(channelFeeAmount);
        sb.append(", channelFee=").append(channelFee);
        sb.append(", tradeTime=").append(tradeTime);
        sb.append(", clearDate=").append(clearDate);
        sb.append(", clearFileName=").append(clearFileName);
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
        ClearDsgjOrderDO other = (ClearDsgjOrderDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderKey() == null ? other.getOrderKey() == null : this.getOrderKey().equals(other.getOrderKey()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getTradeResource() == null ? other.getTradeResource() == null : this.getTradeResource().equals(other.getTradeResource()))
            && (this.getChannelTradeNo() == null ? other.getChannelTradeNo() == null : this.getChannelTradeNo().equals(other.getChannelTradeNo()))
            && (this.getChannelRefundNo() == null ? other.getChannelRefundNo() == null : this.getChannelRefundNo().equals(other.getChannelRefundNo()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getMerchantSubOrderNo() == null ? other.getMerchantSubOrderNo() == null : this.getMerchantSubOrderNo().equals(other.getMerchantSubOrderNo()))
            && (this.getOrderRankType() == null ? other.getOrderRankType() == null : this.getOrderRankType().equals(other.getOrderRankType()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantTradeNo() == null ? other.getMerchantTradeNo() == null : this.getMerchantTradeNo().equals(other.getMerchantTradeNo()))
            && (this.getMerchantRefundNo() == null ? other.getMerchantRefundNo() == null : this.getMerchantRefundNo().equals(other.getMerchantRefundNo()))
            && (this.getMerchantFeeAmount() == null ? other.getMerchantFeeAmount() == null : this.getMerchantFeeAmount().equals(other.getMerchantFeeAmount()))
            && (this.getMerchantFee() == null ? other.getMerchantFee() == null : this.getMerchantFee().equals(other.getMerchantFee()))
            && (this.getChannelFeeAmount() == null ? other.getChannelFeeAmount() == null : this.getChannelFeeAmount().equals(other.getChannelFeeAmount()))
            && (this.getChannelFee() == null ? other.getChannelFee() == null : this.getChannelFee().equals(other.getChannelFee()))
            && (this.getTradeTime() == null ? other.getTradeTime() == null : this.getTradeTime().equals(other.getTradeTime()))
            && (this.getClearDate() == null ? other.getClearDate() == null : this.getClearDate().equals(other.getClearDate()))
            && (this.getClearFileName() == null ? other.getClearFileName() == null : this.getClearFileName().equals(other.getClearFileName()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderKey() == null) ? 0 : getOrderKey().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getTradeResource() == null) ? 0 : getTradeResource().hashCode());
        result = prime * result + ((getChannelTradeNo() == null) ? 0 : getChannelTradeNo().hashCode());
        result = prime * result + ((getChannelRefundNo() == null) ? 0 : getChannelRefundNo().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantSubOrderNo() == null) ? 0 : getMerchantSubOrderNo().hashCode());
        result = prime * result + ((getOrderRankType() == null) ? 0 : getOrderRankType().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantTradeNo() == null) ? 0 : getMerchantTradeNo().hashCode());
        result = prime * result + ((getMerchantRefundNo() == null) ? 0 : getMerchantRefundNo().hashCode());
        result = prime * result + ((getMerchantFeeAmount() == null) ? 0 : getMerchantFeeAmount().hashCode());
        result = prime * result + ((getMerchantFee() == null) ? 0 : getMerchantFee().hashCode());
        result = prime * result + ((getChannelFeeAmount() == null) ? 0 : getChannelFeeAmount().hashCode());
        result = prime * result + ((getChannelFee() == null) ? 0 : getChannelFee().hashCode());
        result = prime * result + ((getTradeTime() == null) ? 0 : getTradeTime().hashCode());
        result = prime * result + ((getClearDate() == null) ? 0 : getClearDate().hashCode());
        result = prime * result + ((getClearFileName() == null) ? 0 : getClearFileName().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}