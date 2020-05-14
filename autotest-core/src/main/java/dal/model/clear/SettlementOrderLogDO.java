package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "settlement_order_log")
public class SettlementOrderLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 全局唯一
     */
    private String gid;

    /**
     * 业务单号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 账期yyyyMMdd
     */
    @Column(name = "settlement_date")
    private String settlementDate;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 提现渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 签约商户真实姓名
     */
    @Column(name = "partner_real_name")
    private String partnerRealName;

    /**
     * 结算状态：INIT,SUCCESS,FAIL
     */
    @Column(name = "settlement_status")
    private String settlementStatus;

    /**
     * 结算时间
     */
    @Column(name = "settlement_time")
    private Date settlementTime;

    /**
     * 结算类型
     */
    @Column(name = "settlement_type")
    private String settlementType;

    /**
     * 结算账号
     */
    @Column(name = "settlement_account_no")
    private String settlementAccountNo;

    /**
     * 结算卡号
     */
    @Column(name = "settlement_card_no")
    private String settlementCardNo;

    /**
     * 结算姓名
     */
    @Column(name = "settlement_name")
    private String settlementName;

    /**
     * 结算金额
     */
    @Column(name = "settlement_amount")
    private Long settlementAmount;

    /**
     * 结算结束时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 结算备注
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
     * 获取全局唯一
     *
     * @return gid - 全局唯一
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局唯一
     *
     * @param gid 全局唯一
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取业务单号
     *
     * @return biz_no - 业务单号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务单号
     *
     * @param bizNo 业务单号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
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
     * 获取提现渠道id
     *
     * @return channel_id - 提现渠道id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置提现渠道id
     *
     * @param channelId 提现渠道id
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
     * 获取结算状态：INIT,SUCCESS,FAIL
     *
     * @return settlement_status - 结算状态：INIT,SUCCESS,FAIL
     */
    public String getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * 设置结算状态：INIT,SUCCESS,FAIL
     *
     * @param settlementStatus 结算状态：INIT,SUCCESS,FAIL
     */
    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus == null ? null : settlementStatus.trim();
    }

    /**
     * 获取结算时间
     *
     * @return settlement_time - 结算时间
     */
    public Date getSettlementTime() {
        return settlementTime;
    }

    /**
     * 设置结算时间
     *
     * @param settlementTime 结算时间
     */
    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }

    /**
     * 获取结算类型
     *
     * @return settlement_type - 结算类型
     */
    public String getSettlementType() {
        return settlementType;
    }

    /**
     * 设置结算类型
     *
     * @param settlementType 结算类型
     */
    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType == null ? null : settlementType.trim();
    }

    /**
     * 获取结算账号
     *
     * @return settlement_account_no - 结算账号
     */
    public String getSettlementAccountNo() {
        return settlementAccountNo;
    }

    /**
     * 设置结算账号
     *
     * @param settlementAccountNo 结算账号
     */
    public void setSettlementAccountNo(String settlementAccountNo) {
        this.settlementAccountNo = settlementAccountNo == null ? null : settlementAccountNo.trim();
    }

    /**
     * 获取结算卡号
     *
     * @return settlement_card_no - 结算卡号
     */
    public String getSettlementCardNo() {
        return settlementCardNo;
    }

    /**
     * 设置结算卡号
     *
     * @param settlementCardNo 结算卡号
     */
    public void setSettlementCardNo(String settlementCardNo) {
        this.settlementCardNo = settlementCardNo == null ? null : settlementCardNo.trim();
    }

    /**
     * 获取结算姓名
     *
     * @return settlement_name - 结算姓名
     */
    public String getSettlementName() {
        return settlementName;
    }

    /**
     * 设置结算姓名
     *
     * @param settlementName 结算姓名
     */
    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName == null ? null : settlementName.trim();
    }

    /**
     * 获取结算金额
     *
     * @return settlement_amount - 结算金额
     */
    public Long getSettlementAmount() {
        return settlementAmount;
    }

    /**
     * 设置结算金额
     *
     * @param settlementAmount 结算金额
     */
    public void setSettlementAmount(Long settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    /**
     * 获取结算结束时间
     *
     * @return finish_time - 结算结束时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置结算结束时间
     *
     * @param finishTime 结算结束时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取结算备注
     *
     * @return comment - 结算备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置结算备注
     *
     * @param comment 结算备注
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
        sb.append(", gid=").append(gid);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", settlementDate=").append(settlementDate);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", channelId=").append(channelId);
        sb.append(", partnerRealName=").append(partnerRealName);
        sb.append(", settlementStatus=").append(settlementStatus);
        sb.append(", settlementTime=").append(settlementTime);
        sb.append(", settlementType=").append(settlementType);
        sb.append(", settlementAccountNo=").append(settlementAccountNo);
        sb.append(", settlementCardNo=").append(settlementCardNo);
        sb.append(", settlementName=").append(settlementName);
        sb.append(", settlementAmount=").append(settlementAmount);
        sb.append(", finishTime=").append(finishTime);
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
        SettlementOrderLogDO other = (SettlementOrderLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getSettlementDate() == null ? other.getSettlementDate() == null : this.getSettlementDate().equals(other.getSettlementDate()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getSettlementStatus() == null ? other.getSettlementStatus() == null : this.getSettlementStatus().equals(other.getSettlementStatus()))
            && (this.getSettlementTime() == null ? other.getSettlementTime() == null : this.getSettlementTime().equals(other.getSettlementTime()))
            && (this.getSettlementType() == null ? other.getSettlementType() == null : this.getSettlementType().equals(other.getSettlementType()))
            && (this.getSettlementAccountNo() == null ? other.getSettlementAccountNo() == null : this.getSettlementAccountNo().equals(other.getSettlementAccountNo()))
            && (this.getSettlementCardNo() == null ? other.getSettlementCardNo() == null : this.getSettlementCardNo().equals(other.getSettlementCardNo()))
            && (this.getSettlementName() == null ? other.getSettlementName() == null : this.getSettlementName().equals(other.getSettlementName()))
            && (this.getSettlementAmount() == null ? other.getSettlementAmount() == null : this.getSettlementAmount().equals(other.getSettlementAmount()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
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
        result = prime * result + ((getSettlementDate() == null) ? 0 : getSettlementDate().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getPartnerRealName() == null) ? 0 : getPartnerRealName().hashCode());
        result = prime * result + ((getSettlementStatus() == null) ? 0 : getSettlementStatus().hashCode());
        result = prime * result + ((getSettlementTime() == null) ? 0 : getSettlementTime().hashCode());
        result = prime * result + ((getSettlementType() == null) ? 0 : getSettlementType().hashCode());
        result = prime * result + ((getSettlementAccountNo() == null) ? 0 : getSettlementAccountNo().hashCode());
        result = prime * result + ((getSettlementCardNo() == null) ? 0 : getSettlementCardNo().hashCode());
        result = prime * result + ((getSettlementName() == null) ? 0 : getSettlementName().hashCode());
        result = prime * result + ((getSettlementAmount() == null) ? 0 : getSettlementAmount().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}