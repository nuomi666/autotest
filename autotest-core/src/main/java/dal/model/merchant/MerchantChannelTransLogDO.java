package dal.model.merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_channel_trans_log")
public class MerchantChannelTransLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 全局流水号
     */
    private String gid;

    /**
     * 业务订单号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 渠道流水号
     */
    @Column(name = "channel_trans_id")
    private String channelTransId;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 渠道方商户号
     */
    @Column(name = "channel_sub_merchant_id")
    private String channelSubMerchantId;

    /**
     * 清结算结算账户
     */
    @Column(name = "settlement_account")
    private String settlementAccount;

    /**
     * 交易金额(单位分)
     */
    private Long amount;

    /**
     * 手续费(单位分)
     */
    @Column(name = "handling_fee")
    private Long handlingFee;

    /**
     * 备注信息
     */
    private String memo;

    /**
     * 交易状态
     */
    @Column(name = "trade_status")
    private String tradeStatus;

    /**
     * 交易类型描述
     */
    @Column(name = "trans_description")
    private String transDescription;

    /**
     * 交易金额变动类型(收入/支出)
     */
    @Column(name = "trans_amount_type")
    private String transAmountType;

    /**
     * 渠道处理时间
     */
    @Column(name = "channel_processing_time")
    private String channelProcessingTime;

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
     * 获取全局流水号
     *
     * @return gid - 全局流水号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局流水号
     *
     * @param gid 全局流水号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取业务订单号
     *
     * @return biz_no - 业务订单号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务订单号
     *
     * @param bizNo 业务订单号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
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
     * 获取渠道流水号
     *
     * @return channel_trans_id - 渠道流水号
     */
    public String getChannelTransId() {
        return channelTransId;
    }

    /**
     * 设置渠道流水号
     *
     * @param channelTransId 渠道流水号
     */
    public void setChannelTransId(String channelTransId) {
        this.channelTransId = channelTransId == null ? null : channelTransId.trim();
    }

    /**
     * 获取渠道
     *
     * @return channel - 渠道
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置渠道
     *
     * @param channel 渠道
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * 获取渠道方商户号
     *
     * @return channel_sub_merchant_id - 渠道方商户号
     */
    public String getChannelSubMerchantId() {
        return channelSubMerchantId;
    }

    /**
     * 设置渠道方商户号
     *
     * @param channelSubMerchantId 渠道方商户号
     */
    public void setChannelSubMerchantId(String channelSubMerchantId) {
        this.channelSubMerchantId = channelSubMerchantId == null ? null : channelSubMerchantId.trim();
    }

    /**
     * 获取清结算结算账户
     *
     * @return settlement_account - 清结算结算账户
     */
    public String getSettlementAccount() {
        return settlementAccount;
    }

    /**
     * 设置清结算结算账户
     *
     * @param settlementAccount 清结算结算账户
     */
    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount == null ? null : settlementAccount.trim();
    }

    /**
     * 获取交易金额(单位分)
     *
     * @return amount - 交易金额(单位分)
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置交易金额(单位分)
     *
     * @param amount 交易金额(单位分)
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取手续费(单位分)
     *
     * @return handling_fee - 手续费(单位分)
     */
    public Long getHandlingFee() {
        return handlingFee;
    }

    /**
     * 设置手续费(单位分)
     *
     * @param handlingFee 手续费(单位分)
     */
    public void setHandlingFee(Long handlingFee) {
        this.handlingFee = handlingFee;
    }

    /**
     * 获取备注信息
     *
     * @return memo - 备注信息
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注信息
     *
     * @param memo 备注信息
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取交易状态
     *
     * @return trade_status - 交易状态
     */
    public String getTradeStatus() {
        return tradeStatus;
    }

    /**
     * 设置交易状态
     *
     * @param tradeStatus 交易状态
     */
    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    /**
     * 获取交易类型描述
     *
     * @return trans_description - 交易类型描述
     */
    public String getTransDescription() {
        return transDescription;
    }

    /**
     * 设置交易类型描述
     *
     * @param transDescription 交易类型描述
     */
    public void setTransDescription(String transDescription) {
        this.transDescription = transDescription == null ? null : transDescription.trim();
    }

    /**
     * 获取交易金额变动类型(收入/支出)
     *
     * @return trans_amount_type - 交易金额变动类型(收入/支出)
     */
    public String getTransAmountType() {
        return transAmountType;
    }

    /**
     * 设置交易金额变动类型(收入/支出)
     *
     * @param transAmountType 交易金额变动类型(收入/支出)
     */
    public void setTransAmountType(String transAmountType) {
        this.transAmountType = transAmountType == null ? null : transAmountType.trim();
    }

    /**
     * 获取渠道处理时间
     *
     * @return channel_processing_time - 渠道处理时间
     */
    public String getChannelProcessingTime() {
        return channelProcessingTime;
    }

    /**
     * 设置渠道处理时间
     *
     * @param channelProcessingTime 渠道处理时间
     */
    public void setChannelProcessingTime(String channelProcessingTime) {
        this.channelProcessingTime = channelProcessingTime == null ? null : channelProcessingTime.trim();
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
        sb.append(", gid=").append(gid);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", channelTransId=").append(channelTransId);
        sb.append(", channel=").append(channel);
        sb.append(", channelSubMerchantId=").append(channelSubMerchantId);
        sb.append(", settlementAccount=").append(settlementAccount);
        sb.append(", amount=").append(amount);
        sb.append(", handlingFee=").append(handlingFee);
        sb.append(", memo=").append(memo);
        sb.append(", tradeStatus=").append(tradeStatus);
        sb.append(", transDescription=").append(transDescription);
        sb.append(", transAmountType=").append(transAmountType);
        sb.append(", channelProcessingTime=").append(channelProcessingTime);
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
        MerchantChannelTransLogDO other = (MerchantChannelTransLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getChannelTransId() == null ? other.getChannelTransId() == null : this.getChannelTransId().equals(other.getChannelTransId()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getChannelSubMerchantId() == null ? other.getChannelSubMerchantId() == null : this.getChannelSubMerchantId().equals(other.getChannelSubMerchantId()))
            && (this.getSettlementAccount() == null ? other.getSettlementAccount() == null : this.getSettlementAccount().equals(other.getSettlementAccount()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getHandlingFee() == null ? other.getHandlingFee() == null : this.getHandlingFee().equals(other.getHandlingFee()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getTradeStatus() == null ? other.getTradeStatus() == null : this.getTradeStatus().equals(other.getTradeStatus()))
            && (this.getTransDescription() == null ? other.getTransDescription() == null : this.getTransDescription().equals(other.getTransDescription()))
            && (this.getTransAmountType() == null ? other.getTransAmountType() == null : this.getTransAmountType().equals(other.getTransAmountType()))
            && (this.getChannelProcessingTime() == null ? other.getChannelProcessingTime() == null : this.getChannelProcessingTime().equals(other.getChannelProcessingTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getChannelTransId() == null) ? 0 : getChannelTransId().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getChannelSubMerchantId() == null) ? 0 : getChannelSubMerchantId().hashCode());
        result = prime * result + ((getSettlementAccount() == null) ? 0 : getSettlementAccount().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getHandlingFee() == null) ? 0 : getHandlingFee().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getTradeStatus() == null) ? 0 : getTradeStatus().hashCode());
        result = prime * result + ((getTransDescription() == null) ? 0 : getTransDescription().hashCode());
        result = prime * result + ((getTransAmountType() == null) ? 0 : getTransAmountType().hashCode());
        result = prime * result + ((getChannelProcessingTime() == null) ? 0 : getChannelProcessingTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}