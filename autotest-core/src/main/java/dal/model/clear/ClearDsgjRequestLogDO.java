package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_dsgj_request_log")
public class ClearDsgjRequestLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 平台商户名称
     */
    @Column(name = "plat_partner_real_name")
    private String platPartnerRealName;

    /**
     * 资金状态
     */
    @Column(name = "amount_status")
    private String amountStatus;

    /**
     * 清分日期
     */
    @Column(name = "clear_date")
    private String clearDate;

    /**
     * 清分文件名称
     */
    @Column(name = "clear_file_name")
    private String clearFileName;

    /**
     * 交易金额
     */
    @Column(name = "trade_amount")
    private Long tradeAmount;

    /**
     * 交易笔数
     */
    @Column(name = "trade_count")
    private Integer tradeCount;

    /**
     * 退款金额
     */
    @Column(name = "refund_amount")
    private Long refundAmount;

    /**
     * 退款笔数
     */
    @Column(name = "refund_count")
    private Integer refundCount;

    /**
     * 清分金额
     */
    @Column(name = "clear_amount")
    private Long clearAmount;

    /**
     * 签约商手续费
     */
    @Column(name = "partner_fee_amount")
    private Long partnerFeeAmount;

    /**
     * 平台分成金额
     */
    @Column(name = "plat_share_amount")
    private Long platShareAmount;

    /**
     * 渠道手续费
     */
    @Column(name = "channel_fee_amount")
    private Long channelFeeAmount;

    /**
     * 备注
     */
    private String comment;

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
     * 获取平台商户名称
     *
     * @return plat_partner_real_name - 平台商户名称
     */
    public String getPlatPartnerRealName() {
        return platPartnerRealName;
    }

    /**
     * 设置平台商户名称
     *
     * @param platPartnerRealName 平台商户名称
     */
    public void setPlatPartnerRealName(String platPartnerRealName) {
        this.platPartnerRealName = platPartnerRealName == null ? null : platPartnerRealName.trim();
    }

    /**
     * 获取资金状态
     *
     * @return amount_status - 资金状态
     */
    public String getAmountStatus() {
        return amountStatus;
    }

    /**
     * 设置资金状态
     *
     * @param amountStatus 资金状态
     */
    public void setAmountStatus(String amountStatus) {
        this.amountStatus = amountStatus == null ? null : amountStatus.trim();
    }

    /**
     * 获取清分日期
     *
     * @return clear_date - 清分日期
     */
    public String getClearDate() {
        return clearDate;
    }

    /**
     * 设置清分日期
     *
     * @param clearDate 清分日期
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
     * 获取交易金额
     *
     * @return trade_amount - 交易金额
     */
    public Long getTradeAmount() {
        return tradeAmount;
    }

    /**
     * 设置交易金额
     *
     * @param tradeAmount 交易金额
     */
    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * 获取交易笔数
     *
     * @return trade_count - 交易笔数
     */
    public Integer getTradeCount() {
        return tradeCount;
    }

    /**
     * 设置交易笔数
     *
     * @param tradeCount 交易笔数
     */
    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
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
    public Integer getRefundCount() {
        return refundCount;
    }

    /**
     * 设置退款笔数
     *
     * @param refundCount 退款笔数
     */
    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    /**
     * 获取清分金额
     *
     * @return clear_amount - 清分金额
     */
    public Long getClearAmount() {
        return clearAmount;
    }

    /**
     * 设置清分金额
     *
     * @param clearAmount 清分金额
     */
    public void setClearAmount(Long clearAmount) {
        this.clearAmount = clearAmount;
    }

    /**
     * 获取签约商手续费
     *
     * @return partner_fee_amount - 签约商手续费
     */
    public Long getPartnerFeeAmount() {
        return partnerFeeAmount;
    }

    /**
     * 设置签约商手续费
     *
     * @param partnerFeeAmount 签约商手续费
     */
    public void setPartnerFeeAmount(Long partnerFeeAmount) {
        this.partnerFeeAmount = partnerFeeAmount;
    }

    /**
     * 获取平台分成金额
     *
     * @return plat_share_amount - 平台分成金额
     */
    public Long getPlatShareAmount() {
        return platShareAmount;
    }

    /**
     * 设置平台分成金额
     *
     * @param platShareAmount 平台分成金额
     */
    public void setPlatShareAmount(Long platShareAmount) {
        this.platShareAmount = platShareAmount;
    }

    /**
     * 获取渠道手续费
     *
     * @return channel_fee_amount - 渠道手续费
     */
    public Long getChannelFeeAmount() {
        return channelFeeAmount;
    }

    /**
     * 设置渠道手续费
     *
     * @param channelFeeAmount 渠道手续费
     */
    public void setChannelFeeAmount(Long channelFeeAmount) {
        this.channelFeeAmount = channelFeeAmount;
    }

    /**
     * 获取备注
     *
     * @return comment - 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置备注
     *
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platPartnerRealName=").append(platPartnerRealName);
        sb.append(", amountStatus=").append(amountStatus);
        sb.append(", clearDate=").append(clearDate);
        sb.append(", clearFileName=").append(clearFileName);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", tradeCount=").append(tradeCount);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", refundCount=").append(refundCount);
        sb.append(", clearAmount=").append(clearAmount);
        sb.append(", partnerFeeAmount=").append(partnerFeeAmount);
        sb.append(", platShareAmount=").append(platShareAmount);
        sb.append(", channelFeeAmount=").append(channelFeeAmount);
        sb.append(", comment=").append(comment);
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
        ClearDsgjRequestLogDO other = (ClearDsgjRequestLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatPartnerRealName() == null ? other.getPlatPartnerRealName() == null : this.getPlatPartnerRealName().equals(other.getPlatPartnerRealName()))
            && (this.getAmountStatus() == null ? other.getAmountStatus() == null : this.getAmountStatus().equals(other.getAmountStatus()))
            && (this.getClearDate() == null ? other.getClearDate() == null : this.getClearDate().equals(other.getClearDate()))
            && (this.getClearFileName() == null ? other.getClearFileName() == null : this.getClearFileName().equals(other.getClearFileName()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getTradeCount() == null ? other.getTradeCount() == null : this.getTradeCount().equals(other.getTradeCount()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getRefundCount() == null ? other.getRefundCount() == null : this.getRefundCount().equals(other.getRefundCount()))
            && (this.getClearAmount() == null ? other.getClearAmount() == null : this.getClearAmount().equals(other.getClearAmount()))
            && (this.getPartnerFeeAmount() == null ? other.getPartnerFeeAmount() == null : this.getPartnerFeeAmount().equals(other.getPartnerFeeAmount()))
            && (this.getPlatShareAmount() == null ? other.getPlatShareAmount() == null : this.getPlatShareAmount().equals(other.getPlatShareAmount()))
            && (this.getChannelFeeAmount() == null ? other.getChannelFeeAmount() == null : this.getChannelFeeAmount().equals(other.getChannelFeeAmount()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerRealName() == null) ? 0 : getPlatPartnerRealName().hashCode());
        result = prime * result + ((getAmountStatus() == null) ? 0 : getAmountStatus().hashCode());
        result = prime * result + ((getClearDate() == null) ? 0 : getClearDate().hashCode());
        result = prime * result + ((getClearFileName() == null) ? 0 : getClearFileName().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getTradeCount() == null) ? 0 : getTradeCount().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getRefundCount() == null) ? 0 : getRefundCount().hashCode());
        result = prime * result + ((getClearAmount() == null) ? 0 : getClearAmount().hashCode());
        result = prime * result + ((getPartnerFeeAmount() == null) ? 0 : getPartnerFeeAmount().hashCode());
        result = prime * result + ((getPlatShareAmount() == null) ? 0 : getPlatShareAmount().hashCode());
        result = prime * result + ((getChannelFeeAmount() == null) ? 0 : getChannelFeeAmount().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}