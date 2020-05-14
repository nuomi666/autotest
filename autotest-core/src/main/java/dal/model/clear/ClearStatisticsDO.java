package dal.model.clear;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_statistics")
public class ClearStatisticsDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 签约商户真实姓名
     */
    @Column(name = "partner_real_name")
    private String partnerRealName;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 订单金额，分
     */
    @Column(name = "order_amount")
    private Long orderAmount;

    /**
     * 结算金额，分
     */
    @Column(name = "clear_amount")
    private Long clearAmount;

    /**
     * 退款金额
     */
    @Column(name = "refund_amount")
    private Long refundAmount;

    /**
     * 退款笔数
     */
    @Column(name = "refund_count")
    private Long refundCount;

    /**
     * 交易金额
     */
    @Column(name = "transaction_amount")
    private Long transactionAmount;

    /**
     * 交易笔数
     */
    @Column(name = "transaction_count")
    private Long transactionCount;

    /**
     * 交易状态
     */
    @Column(name = "bill_info_status")
    private String billInfoStatus;

    /**
     * 商户手续费金额，单位元
     */
    @Column(name = "merchant_fee_amount")
    private BigDecimal merchantFeeAmount;

    /**
     * 渠道手续费，单位元
     */
    @Column(name = "channel_fee_amount")
    private BigDecimal channelFeeAmount;

    /**
     * 账期yyyyMMdd
     */
    @Column(name = "settlement_date")
    private String settlementDate;

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
     * 获取结算金额，分
     *
     * @return clear_amount - 结算金额，分
     */
    public Long getClearAmount() {
        return clearAmount;
    }

    /**
     * 设置结算金额，分
     *
     * @param clearAmount 结算金额，分
     */
    public void setClearAmount(Long clearAmount) {
        this.clearAmount = clearAmount;
    }

    /**
     * 获取退款金额
     *
     * @return refund_amount - 退款金额
     */
    public Long getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置退款金额
     *
     * @param refundAmount 退款金额
     */
    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * 获取退款笔数
     *
     * @return refund_count - 退款笔数
     */
    public Long getRefundCount() {
        return refundCount;
    }

    /**
     * 设置退款笔数
     *
     * @param refundCount 退款笔数
     */
    public void setRefundCount(Long refundCount) {
        this.refundCount = refundCount;
    }

    /**
     * 获取交易金额
     *
     * @return transaction_amount - 交易金额
     */
    public Long getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * 设置交易金额
     *
     * @param transactionAmount 交易金额
     */
    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * 获取交易笔数
     *
     * @return transaction_count - 交易笔数
     */
    public Long getTransactionCount() {
        return transactionCount;
    }

    /**
     * 设置交易笔数
     *
     * @param transactionCount 交易笔数
     */
    public void setTransactionCount(Long transactionCount) {
        this.transactionCount = transactionCount;
    }

    /**
     * 获取交易状态
     *
     * @return bill_info_status - 交易状态
     */
    public String getBillInfoStatus() {
        return billInfoStatus;
    }

    /**
     * 设置交易状态
     *
     * @param billInfoStatus 交易状态
     */
    public void setBillInfoStatus(String billInfoStatus) {
        this.billInfoStatus = billInfoStatus == null ? null : billInfoStatus.trim();
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
        sb.append(", channelId=").append(channelId);
        sb.append(", partnerRealName=").append(partnerRealName);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", clearAmount=").append(clearAmount);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", refundCount=").append(refundCount);
        sb.append(", transactionAmount=").append(transactionAmount);
        sb.append(", transactionCount=").append(transactionCount);
        sb.append(", billInfoStatus=").append(billInfoStatus);
        sb.append(", merchantFeeAmount=").append(merchantFeeAmount);
        sb.append(", channelFeeAmount=").append(channelFeeAmount);
        sb.append(", settlementDate=").append(settlementDate);
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
        ClearStatisticsDO other = (ClearStatisticsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getClearAmount() == null ? other.getClearAmount() == null : this.getClearAmount().equals(other.getClearAmount()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getRefundCount() == null ? other.getRefundCount() == null : this.getRefundCount().equals(other.getRefundCount()))
            && (this.getTransactionAmount() == null ? other.getTransactionAmount() == null : this.getTransactionAmount().equals(other.getTransactionAmount()))
            && (this.getTransactionCount() == null ? other.getTransactionCount() == null : this.getTransactionCount().equals(other.getTransactionCount()))
            && (this.getBillInfoStatus() == null ? other.getBillInfoStatus() == null : this.getBillInfoStatus().equals(other.getBillInfoStatus()))
            && (this.getMerchantFeeAmount() == null ? other.getMerchantFeeAmount() == null : this.getMerchantFeeAmount().equals(other.getMerchantFeeAmount()))
            && (this.getChannelFeeAmount() == null ? other.getChannelFeeAmount() == null : this.getChannelFeeAmount().equals(other.getChannelFeeAmount()))
            && (this.getSettlementDate() == null ? other.getSettlementDate() == null : this.getSettlementDate().equals(other.getSettlementDate()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getPartnerRealName() == null) ? 0 : getPartnerRealName().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getClearAmount() == null) ? 0 : getClearAmount().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getRefundCount() == null) ? 0 : getRefundCount().hashCode());
        result = prime * result + ((getTransactionAmount() == null) ? 0 : getTransactionAmount().hashCode());
        result = prime * result + ((getTransactionCount() == null) ? 0 : getTransactionCount().hashCode());
        result = prime * result + ((getBillInfoStatus() == null) ? 0 : getBillInfoStatus().hashCode());
        result = prime * result + ((getMerchantFeeAmount() == null) ? 0 : getMerchantFeeAmount().hashCode());
        result = prime * result + ((getChannelFeeAmount() == null) ? 0 : getChannelFeeAmount().hashCode());
        result = prime * result + ((getSettlementDate() == null) ? 0 : getSettlementDate().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}