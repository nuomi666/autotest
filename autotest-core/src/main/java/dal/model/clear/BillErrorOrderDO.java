package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bill_error_order")
public class BillErrorOrderDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 批次号
     */
    @Column(name = "batch_no")
    private String batchNo;

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
     * 对账状态ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     */
    @Column(name = "bill_status")
    private String billStatus;

    /**
     * 交易类型：支付、退款、提现
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 渠道订单号
     */
    @Column(name = "channel_order_no")
    private String channelOrderNo;

    /**
     * 渠道订单金额，分
     */
    @Column(name = "channel_order_amount")
    private Long channelOrderAmount;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 商户交易单号
     */
    @Column(name = "merchant_trade_no")
    private String merchantTradeNo;

    /**
     * 平台交易订单号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 商户订单金额，分
     */
    @Column(name = "merchant_order_amount")
    private Long merchantOrderAmount;

    /**
     * 处理状态：INIT(未处理)、RESOLVED(已解决)
     */
    @Column(name = "solve_status")
    private String solveStatus;

    /**
     * 处理描述
     */
    @Column(name = "solve_comment")
    private String solveComment;

    /**
     * 差错账期
     */
    @Column(name = "bill_date")
    private String billDate;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

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
     * 获取批次号
     *
     * @return batch_no - 批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置批次号
     *
     * @param batchNo 批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
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
     * 获取对账状态ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     *
     * @return bill_status - 对账状态ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     */
    public String getBillStatus() {
        return billStatus;
    }

    /**
     * 设置对账状态ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     *
     * @param billStatus 对账状态ERROR_AMOUNT(金额错误)、ERROR_NO_OUT(缺少外部订单)、ERROR_NO_IN(缺少内部订单)
     */
    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
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
     * 获取平台交易订单号
     *
     * @return plat_merchant_order_no - 平台交易订单号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台交易订单号
     *
     * @param platMerchantOrderNo 平台交易订单号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
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
     * 获取处理状态：INIT(未处理)、RESOLVED(已解决)
     *
     * @return solve_status - 处理状态：INIT(未处理)、RESOLVED(已解决)
     */
    public String getSolveStatus() {
        return solveStatus;
    }

    /**
     * 设置处理状态：INIT(未处理)、RESOLVED(已解决)
     *
     * @param solveStatus 处理状态：INIT(未处理)、RESOLVED(已解决)
     */
    public void setSolveStatus(String solveStatus) {
        this.solveStatus = solveStatus == null ? null : solveStatus.trim();
    }

    /**
     * 获取处理描述
     *
     * @return solve_comment - 处理描述
     */
    public String getSolveComment() {
        return solveComment;
    }

    /**
     * 设置处理描述
     *
     * @param solveComment 处理描述
     */
    public void setSolveComment(String solveComment) {
        this.solveComment = solveComment == null ? null : solveComment.trim();
    }

    /**
     * 获取差错账期
     *
     * @return bill_date - 差错账期
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * 设置差错账期
     *
     * @param billDate 差错账期
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", orderKey=").append(orderKey);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", channelOrderNo=").append(channelOrderNo);
        sb.append(", channelOrderAmount=").append(channelOrderAmount);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", merchantTradeNo=").append(merchantTradeNo);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantOrderAmount=").append(merchantOrderAmount);
        sb.append(", solveStatus=").append(solveStatus);
        sb.append(", solveComment=").append(solveComment);
        sb.append(", billDate=").append(billDate);
        sb.append(", channelId=").append(channelId);
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
        BillErrorOrderDO other = (BillErrorOrderDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getOrderKey() == null ? other.getOrderKey() == null : this.getOrderKey().equals(other.getOrderKey()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getChannelOrderNo() == null ? other.getChannelOrderNo() == null : this.getChannelOrderNo().equals(other.getChannelOrderNo()))
            && (this.getChannelOrderAmount() == null ? other.getChannelOrderAmount() == null : this.getChannelOrderAmount().equals(other.getChannelOrderAmount()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getMerchantTradeNo() == null ? other.getMerchantTradeNo() == null : this.getMerchantTradeNo().equals(other.getMerchantTradeNo()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantOrderAmount() == null ? other.getMerchantOrderAmount() == null : this.getMerchantOrderAmount().equals(other.getMerchantOrderAmount()))
            && (this.getSolveStatus() == null ? other.getSolveStatus() == null : this.getSolveStatus().equals(other.getSolveStatus()))
            && (this.getSolveComment() == null ? other.getSolveComment() == null : this.getSolveComment().equals(other.getSolveComment()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getOrderKey() == null) ? 0 : getOrderKey().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getChannelOrderNo() == null) ? 0 : getChannelOrderNo().hashCode());
        result = prime * result + ((getChannelOrderAmount() == null) ? 0 : getChannelOrderAmount().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantTradeNo() == null) ? 0 : getMerchantTradeNo().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantOrderAmount() == null) ? 0 : getMerchantOrderAmount().hashCode());
        result = prime * result + ((getSolveStatus() == null) ? 0 : getSolveStatus().hashCode());
        result = prime * result + ((getSolveComment() == null) ? 0 : getSolveComment().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}