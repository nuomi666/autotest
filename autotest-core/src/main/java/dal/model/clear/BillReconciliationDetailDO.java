package dal.model.clear;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bill_reconciliation_detail")
public class BillReconciliationDetailDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 批次号：日期_签约商户id_渠道id
     */
    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 账单日期
     */
    @Column(name = "bill_date")
    private String billDate;

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
     * 订单对账key值，由对账模型md5生成
     */
    @Column(name = "order_key")
    private String orderKey;

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
     * 对账状态：INIT(初始化)、SUCCESS(成功)、ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     */
    @Column(name = "bill_status")
    private String billStatus;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 渠道订单号
     */
    @Column(name = "channel_order_no")
    private String channelOrderNo;

    /**
     * 渠道交易单号
     */
    @Column(name = "channel_trade_no")
    private String channelTradeNo;

    /**
     * 渠道第三方交易流水号
     */
    @Column(name = "channel_transaction_no")
    private String channelTransactionNo;

    /**
     * 渠道退款单号
     */
    @Column(name = "channel_refund_no")
    private String channelRefundNo;

    /**
     * 渠道订单金额，分
     */
    @Column(name = "channel_order_amount")
    private Long channelOrderAmount;

    /**
     * 渠道交易（支付、退款、提现）金额，分
     */
    @Column(name = "channel_amount")
    private Long channelAmount;

    /**
     * 渠道手续费金额。单位元
     */
    @Column(name = "channel_fee_amount")
    private BigDecimal channelFeeAmount;

    /**
     * 渠道手续费费率，百分比
     */
    @Column(name = "channel_fee")
    private BigDecimal channelFee;

    /**
     * 渠道交易时间
     */
    @Column(name = "channel_trade_time")
    private Date channelTradeTime;

    /**
     * 渠道商户id
     */
    @Column(name = "channel_partner_id")
    private String channelPartnerId;

    /**
     * 渠道第三方商户id
     */
    @Column(name = "channel_third_partner_id")
    private String channelThirdPartnerId;

    /**
     * 渠道第三方用户id
     */
    @Column(name = "channel_third_user_id")
    private String channelThirdUserId;

    /**
     * 渠道交易备注
     */
    @Column(name = "channel_trade_memo")
    private String channelTradeMemo;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

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
     * 商户交易时间
     */
    @Column(name = "merchant_trade_time")
    private Date merchantTradeTime;

    /**
     * 商户渠道手续费金额，单位元
     */
    @Column(name = "merchant_channel_fee_amount")
    private BigDecimal merchantChannelFeeAmount;

    /**
     * 渠道手续费率，百分比
     */
    @Column(name = "merchant_channel_fee")
    private BigDecimal merchantChannelFee;

    /**
     * 订单商户模式
     */
    @Column(name = "merchant_mode")
    private String merchantMode;

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
     * 获取批次号：日期_签约商户id_渠道id
     *
     * @return batch_no - 批次号：日期_签约商户id_渠道id
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置批次号：日期_签约商户id_渠道id
     *
     * @param batchNo 批次号：日期_签约商户id_渠道id
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * 获取账单日期
     *
     * @return bill_date - 账单日期
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * 设置账单日期
     *
     * @param billDate 账单日期
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
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
     * 获取对账状态：INIT(初始化)、SUCCESS(成功)、ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     *
     * @return bill_status - 对账状态：INIT(初始化)、SUCCESS(成功)、ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     */
    public String getBillStatus() {
        return billStatus;
    }

    /**
     * 设置对账状态：INIT(初始化)、SUCCESS(成功)、ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     *
     * @param billStatus 对账状态：INIT(初始化)、SUCCESS(成功)、ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     */
    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
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
     * 获取渠道订单号
     *
     * @return channel_order_no - 渠道订单号
     */
    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    /**
     * 设置渠道订单号
     *
     * @param channelOrderNo 渠道订单号
     */
    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo == null ? null : channelOrderNo.trim();
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
     * 获取渠道第三方交易流水号
     *
     * @return channel_transaction_no - 渠道第三方交易流水号
     */
    public String getChannelTransactionNo() {
        return channelTransactionNo;
    }

    /**
     * 设置渠道第三方交易流水号
     *
     * @param channelTransactionNo 渠道第三方交易流水号
     */
    public void setChannelTransactionNo(String channelTransactionNo) {
        this.channelTransactionNo = channelTransactionNo == null ? null : channelTransactionNo.trim();
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
     * 获取渠道订单金额，分
     *
     * @return channel_order_amount - 渠道订单金额，分
     */
    public Long getChannelOrderAmount() {
        return channelOrderAmount;
    }

    /**
     * 设置渠道订单金额，分
     *
     * @param channelOrderAmount 渠道订单金额，分
     */
    public void setChannelOrderAmount(Long channelOrderAmount) {
        this.channelOrderAmount = channelOrderAmount;
    }

    /**
     * 获取渠道交易（支付、退款、提现）金额，分
     *
     * @return channel_amount - 渠道交易（支付、退款、提现）金额，分
     */
    public Long getChannelAmount() {
        return channelAmount;
    }

    /**
     * 设置渠道交易（支付、退款、提现）金额，分
     *
     * @param channelAmount 渠道交易（支付、退款、提现）金额，分
     */
    public void setChannelAmount(Long channelAmount) {
        this.channelAmount = channelAmount;
    }

    /**
     * 获取渠道手续费金额。单位元
     *
     * @return channel_fee_amount - 渠道手续费金额。单位元
     */
    public BigDecimal getChannelFeeAmount() {
        return channelFeeAmount;
    }

    /**
     * 设置渠道手续费金额。单位元
     *
     * @param channelFeeAmount 渠道手续费金额。单位元
     */
    public void setChannelFeeAmount(BigDecimal channelFeeAmount) {
        this.channelFeeAmount = channelFeeAmount;
    }

    /**
     * 获取渠道手续费费率，百分比
     *
     * @return channel_fee - 渠道手续费费率，百分比
     */
    public BigDecimal getChannelFee() {
        return channelFee;
    }

    /**
     * 设置渠道手续费费率，百分比
     *
     * @param channelFee 渠道手续费费率，百分比
     */
    public void setChannelFee(BigDecimal channelFee) {
        this.channelFee = channelFee;
    }

    /**
     * 获取渠道交易时间
     *
     * @return channel_trade_time - 渠道交易时间
     */
    public Date getChannelTradeTime() {
        return channelTradeTime;
    }

    /**
     * 设置渠道交易时间
     *
     * @param channelTradeTime 渠道交易时间
     */
    public void setChannelTradeTime(Date channelTradeTime) {
        this.channelTradeTime = channelTradeTime;
    }

    /**
     * 获取渠道商户id
     *
     * @return channel_partner_id - 渠道商户id
     */
    public String getChannelPartnerId() {
        return channelPartnerId;
    }

    /**
     * 设置渠道商户id
     *
     * @param channelPartnerId 渠道商户id
     */
    public void setChannelPartnerId(String channelPartnerId) {
        this.channelPartnerId = channelPartnerId == null ? null : channelPartnerId.trim();
    }

    /**
     * 获取渠道第三方商户id
     *
     * @return channel_third_partner_id - 渠道第三方商户id
     */
    public String getChannelThirdPartnerId() {
        return channelThirdPartnerId;
    }

    /**
     * 设置渠道第三方商户id
     *
     * @param channelThirdPartnerId 渠道第三方商户id
     */
    public void setChannelThirdPartnerId(String channelThirdPartnerId) {
        this.channelThirdPartnerId = channelThirdPartnerId == null ? null : channelThirdPartnerId.trim();
    }

    /**
     * 获取渠道第三方用户id
     *
     * @return channel_third_user_id - 渠道第三方用户id
     */
    public String getChannelThirdUserId() {
        return channelThirdUserId;
    }

    /**
     * 设置渠道第三方用户id
     *
     * @param channelThirdUserId 渠道第三方用户id
     */
    public void setChannelThirdUserId(String channelThirdUserId) {
        this.channelThirdUserId = channelThirdUserId == null ? null : channelThirdUserId.trim();
    }

    /**
     * 获取渠道交易备注
     *
     * @return channel_trade_memo - 渠道交易备注
     */
    public String getChannelTradeMemo() {
        return channelTradeMemo;
    }

    /**
     * 设置渠道交易备注
     *
     * @param channelTradeMemo 渠道交易备注
     */
    public void setChannelTradeMemo(String channelTradeMemo) {
        this.channelTradeMemo = channelTradeMemo == null ? null : channelTradeMemo.trim();
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
     * 获取商户渠道手续费金额，单位元
     *
     * @return merchant_channel_fee_amount - 商户渠道手续费金额，单位元
     */
    public BigDecimal getMerchantChannelFeeAmount() {
        return merchantChannelFeeAmount;
    }

    /**
     * 设置商户渠道手续费金额，单位元
     *
     * @param merchantChannelFeeAmount 商户渠道手续费金额，单位元
     */
    public void setMerchantChannelFeeAmount(BigDecimal merchantChannelFeeAmount) {
        this.merchantChannelFeeAmount = merchantChannelFeeAmount;
    }

    /**
     * 获取渠道手续费率，百分比
     *
     * @return merchant_channel_fee - 渠道手续费率，百分比
     */
    public BigDecimal getMerchantChannelFee() {
        return merchantChannelFee;
    }

    /**
     * 设置渠道手续费率，百分比
     *
     * @param merchantChannelFee 渠道手续费率，百分比
     */
    public void setMerchantChannelFee(BigDecimal merchantChannelFee) {
        this.merchantChannelFee = merchantChannelFee;
    }

    /**
     * 获取订单商户模式
     *
     * @return merchant_mode - 订单商户模式
     */
    public String getMerchantMode() {
        return merchantMode;
    }

    /**
     * 设置订单商户模式
     *
     * @param merchantMode 订单商户模式
     */
    public void setMerchantMode(String merchantMode) {
        this.merchantMode = merchantMode == null ? null : merchantMode.trim();
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
        sb.append(", batchNo=").append(batchNo);
        sb.append(", billDate=").append(billDate);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", orderKey=").append(orderKey);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", tradeResource=").append(tradeResource);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelOrderNo=").append(channelOrderNo);
        sb.append(", channelTradeNo=").append(channelTradeNo);
        sb.append(", channelTransactionNo=").append(channelTransactionNo);
        sb.append(", channelRefundNo=").append(channelRefundNo);
        sb.append(", channelOrderAmount=").append(channelOrderAmount);
        sb.append(", channelAmount=").append(channelAmount);
        sb.append(", channelFeeAmount=").append(channelFeeAmount);
        sb.append(", channelFee=").append(channelFee);
        sb.append(", channelTradeTime=").append(channelTradeTime);
        sb.append(", channelPartnerId=").append(channelPartnerId);
        sb.append(", channelThirdPartnerId=").append(channelThirdPartnerId);
        sb.append(", channelThirdUserId=").append(channelThirdUserId);
        sb.append(", channelTradeMemo=").append(channelTradeMemo);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantTradeNo=").append(merchantTradeNo);
        sb.append(", merchantRefundNo=").append(merchantRefundNo);
        sb.append(", merchantOrderAmount=").append(merchantOrderAmount);
        sb.append(", merchantAmount=").append(merchantAmount);
        sb.append(", merchantFeeAmount=").append(merchantFeeAmount);
        sb.append(", merchantFee=").append(merchantFee);
        sb.append(", merchantTradeTime=").append(merchantTradeTime);
        sb.append(", merchantChannelFeeAmount=").append(merchantChannelFeeAmount);
        sb.append(", merchantChannelFee=").append(merchantChannelFee);
        sb.append(", merchantMode=").append(merchantMode);
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
        BillReconciliationDetailDO other = (BillReconciliationDetailDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getOrderKey() == null ? other.getOrderKey() == null : this.getOrderKey().equals(other.getOrderKey()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getTradeResource() == null ? other.getTradeResource() == null : this.getTradeResource().equals(other.getTradeResource()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelOrderNo() == null ? other.getChannelOrderNo() == null : this.getChannelOrderNo().equals(other.getChannelOrderNo()))
            && (this.getChannelTradeNo() == null ? other.getChannelTradeNo() == null : this.getChannelTradeNo().equals(other.getChannelTradeNo()))
            && (this.getChannelTransactionNo() == null ? other.getChannelTransactionNo() == null : this.getChannelTransactionNo().equals(other.getChannelTransactionNo()))
            && (this.getChannelRefundNo() == null ? other.getChannelRefundNo() == null : this.getChannelRefundNo().equals(other.getChannelRefundNo()))
            && (this.getChannelOrderAmount() == null ? other.getChannelOrderAmount() == null : this.getChannelOrderAmount().equals(other.getChannelOrderAmount()))
            && (this.getChannelAmount() == null ? other.getChannelAmount() == null : this.getChannelAmount().equals(other.getChannelAmount()))
            && (this.getChannelFeeAmount() == null ? other.getChannelFeeAmount() == null : this.getChannelFeeAmount().equals(other.getChannelFeeAmount()))
            && (this.getChannelFee() == null ? other.getChannelFee() == null : this.getChannelFee().equals(other.getChannelFee()))
            && (this.getChannelTradeTime() == null ? other.getChannelTradeTime() == null : this.getChannelTradeTime().equals(other.getChannelTradeTime()))
            && (this.getChannelPartnerId() == null ? other.getChannelPartnerId() == null : this.getChannelPartnerId().equals(other.getChannelPartnerId()))
            && (this.getChannelThirdPartnerId() == null ? other.getChannelThirdPartnerId() == null : this.getChannelThirdPartnerId().equals(other.getChannelThirdPartnerId()))
            && (this.getChannelThirdUserId() == null ? other.getChannelThirdUserId() == null : this.getChannelThirdUserId().equals(other.getChannelThirdUserId()))
            && (this.getChannelTradeMemo() == null ? other.getChannelTradeMemo() == null : this.getChannelTradeMemo().equals(other.getChannelTradeMemo()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantTradeNo() == null ? other.getMerchantTradeNo() == null : this.getMerchantTradeNo().equals(other.getMerchantTradeNo()))
            && (this.getMerchantRefundNo() == null ? other.getMerchantRefundNo() == null : this.getMerchantRefundNo().equals(other.getMerchantRefundNo()))
            && (this.getMerchantOrderAmount() == null ? other.getMerchantOrderAmount() == null : this.getMerchantOrderAmount().equals(other.getMerchantOrderAmount()))
            && (this.getMerchantAmount() == null ? other.getMerchantAmount() == null : this.getMerchantAmount().equals(other.getMerchantAmount()))
            && (this.getMerchantFeeAmount() == null ? other.getMerchantFeeAmount() == null : this.getMerchantFeeAmount().equals(other.getMerchantFeeAmount()))
            && (this.getMerchantFee() == null ? other.getMerchantFee() == null : this.getMerchantFee().equals(other.getMerchantFee()))
            && (this.getMerchantTradeTime() == null ? other.getMerchantTradeTime() == null : this.getMerchantTradeTime().equals(other.getMerchantTradeTime()))
            && (this.getMerchantChannelFeeAmount() == null ? other.getMerchantChannelFeeAmount() == null : this.getMerchantChannelFeeAmount().equals(other.getMerchantChannelFeeAmount()))
            && (this.getMerchantChannelFee() == null ? other.getMerchantChannelFee() == null : this.getMerchantChannelFee().equals(other.getMerchantChannelFee()))
            && (this.getMerchantMode() == null ? other.getMerchantMode() == null : this.getMerchantMode().equals(other.getMerchantMode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getOrderKey() == null) ? 0 : getOrderKey().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getTradeResource() == null) ? 0 : getTradeResource().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelOrderNo() == null) ? 0 : getChannelOrderNo().hashCode());
        result = prime * result + ((getChannelTradeNo() == null) ? 0 : getChannelTradeNo().hashCode());
        result = prime * result + ((getChannelTransactionNo() == null) ? 0 : getChannelTransactionNo().hashCode());
        result = prime * result + ((getChannelRefundNo() == null) ? 0 : getChannelRefundNo().hashCode());
        result = prime * result + ((getChannelOrderAmount() == null) ? 0 : getChannelOrderAmount().hashCode());
        result = prime * result + ((getChannelAmount() == null) ? 0 : getChannelAmount().hashCode());
        result = prime * result + ((getChannelFeeAmount() == null) ? 0 : getChannelFeeAmount().hashCode());
        result = prime * result + ((getChannelFee() == null) ? 0 : getChannelFee().hashCode());
        result = prime * result + ((getChannelTradeTime() == null) ? 0 : getChannelTradeTime().hashCode());
        result = prime * result + ((getChannelPartnerId() == null) ? 0 : getChannelPartnerId().hashCode());
        result = prime * result + ((getChannelThirdPartnerId() == null) ? 0 : getChannelThirdPartnerId().hashCode());
        result = prime * result + ((getChannelThirdUserId() == null) ? 0 : getChannelThirdUserId().hashCode());
        result = prime * result + ((getChannelTradeMemo() == null) ? 0 : getChannelTradeMemo().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantTradeNo() == null) ? 0 : getMerchantTradeNo().hashCode());
        result = prime * result + ((getMerchantRefundNo() == null) ? 0 : getMerchantRefundNo().hashCode());
        result = prime * result + ((getMerchantOrderAmount() == null) ? 0 : getMerchantOrderAmount().hashCode());
        result = prime * result + ((getMerchantAmount() == null) ? 0 : getMerchantAmount().hashCode());
        result = prime * result + ((getMerchantFeeAmount() == null) ? 0 : getMerchantFeeAmount().hashCode());
        result = prime * result + ((getMerchantFee() == null) ? 0 : getMerchantFee().hashCode());
        result = prime * result + ((getMerchantTradeTime() == null) ? 0 : getMerchantTradeTime().hashCode());
        result = prime * result + ((getMerchantChannelFeeAmount() == null) ? 0 : getMerchantChannelFeeAmount().hashCode());
        result = prime * result + ((getMerchantChannelFee() == null) ? 0 : getMerchantChannelFee().hashCode());
        result = prime * result + ((getMerchantMode() == null) ? 0 : getMerchantMode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}