package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bill_batch_statistics")
public class BillBatchStatisticsDO implements Serializable {
    /**
     * 主键
     */
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
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 账期YYYYmmdd
     */
    @Column(name = "bill_date")
    private String billDate;

    /**
     * 渠道商户id
     */
    @Column(name = "channel_partner_id")
    private String channelPartnerId;

    /**
     * 交易类型：支付、退款、提现
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 渠道订单总数
     */
    @Column(name = "channel_order_count")
    private Integer channelOrderCount;

    /**
     * 渠道订单总金额,分
     */
    @Column(name = "channel_order_amount")
    private Long channelOrderAmount;

    /**
     * 差错订单总数
     */
    @Column(name = "error_order_count")
    private Integer errorOrderCount;

    /**
     * 差错订单总金额，分
     */
    @Column(name = "error_order_amount")
    private Long errorOrderAmount;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
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
     * 获取账期YYYYmmdd
     *
     * @return bill_date - 账期YYYYmmdd
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * 设置账期YYYYmmdd
     *
     * @param billDate 账期YYYYmmdd
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
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
     * 获取渠道订单总数
     *
     * @return channel_order_count - 渠道订单总数
     */
    public Integer getChannelOrderCount() {
        return channelOrderCount;
    }

    /**
     * 设置渠道订单总数
     *
     * @param channelOrderCount 渠道订单总数
     */
    public void setChannelOrderCount(Integer channelOrderCount) {
        this.channelOrderCount = channelOrderCount;
    }

    /**
     * 获取渠道订单总金额,分
     *
     * @return channel_order_amount - 渠道订单总金额,分
     */
    public Long getChannelOrderAmount() {
        return channelOrderAmount;
    }

    /**
     * 设置渠道订单总金额,分
     *
     * @param channelOrderAmount 渠道订单总金额,分
     */
    public void setChannelOrderAmount(Long channelOrderAmount) {
        this.channelOrderAmount = channelOrderAmount;
    }

    /**
     * 获取差错订单总数
     *
     * @return error_order_count - 差错订单总数
     */
    public Integer getErrorOrderCount() {
        return errorOrderCount;
    }

    /**
     * 设置差错订单总数
     *
     * @param errorOrderCount 差错订单总数
     */
    public void setErrorOrderCount(Integer errorOrderCount) {
        this.errorOrderCount = errorOrderCount;
    }

    /**
     * 获取差错订单总金额，分
     *
     * @return error_order_amount - 差错订单总金额，分
     */
    public Long getErrorOrderAmount() {
        return errorOrderAmount;
    }

    /**
     * 设置差错订单总金额，分
     *
     * @param errorOrderAmount 差错订单总金额，分
     */
    public void setErrorOrderAmount(Long errorOrderAmount) {
        this.errorOrderAmount = errorOrderAmount;
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
        sb.append(", partnerRealName=").append(partnerRealName);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", channelId=").append(channelId);
        sb.append(", billDate=").append(billDate);
        sb.append(", channelPartnerId=").append(channelPartnerId);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", channelOrderCount=").append(channelOrderCount);
        sb.append(", channelOrderAmount=").append(channelOrderAmount);
        sb.append(", errorOrderCount=").append(errorOrderCount);
        sb.append(", errorOrderAmount=").append(errorOrderAmount);
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
        BillBatchStatisticsDO other = (BillBatchStatisticsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getChannelPartnerId() == null ? other.getChannelPartnerId() == null : this.getChannelPartnerId().equals(other.getChannelPartnerId()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getChannelOrderCount() == null ? other.getChannelOrderCount() == null : this.getChannelOrderCount().equals(other.getChannelOrderCount()))
            && (this.getChannelOrderAmount() == null ? other.getChannelOrderAmount() == null : this.getChannelOrderAmount().equals(other.getChannelOrderAmount()))
            && (this.getErrorOrderCount() == null ? other.getErrorOrderCount() == null : this.getErrorOrderCount().equals(other.getErrorOrderCount()))
            && (this.getErrorOrderAmount() == null ? other.getErrorOrderAmount() == null : this.getErrorOrderAmount().equals(other.getErrorOrderAmount()))
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
        result = prime * result + ((getPartnerRealName() == null) ? 0 : getPartnerRealName().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getChannelPartnerId() == null) ? 0 : getChannelPartnerId().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getChannelOrderCount() == null) ? 0 : getChannelOrderCount().hashCode());
        result = prime * result + ((getChannelOrderAmount() == null) ? 0 : getChannelOrderAmount().hashCode());
        result = prime * result + ((getErrorOrderCount() == null) ? 0 : getErrorOrderCount().hashCode());
        result = prime * result + ((getErrorOrderAmount() == null) ? 0 : getErrorOrderAmount().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}