package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "settlement_task_log")
public class SettlementTaskLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 清分状态：INIT,SUCCESS,FAIL
     */
    @Column(name = "clear_status")
    private String clearStatus;

    /**
     * 清分时间
     */
    @Column(name = "clear_time")
    private Date clearTime;

    /**
     * 清分备注
     */
    @Column(name = "clear_comment")
    private String clearComment;

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
     * 结算备注
     */
    @Column(name = "settlement_comment")
    private String settlementComment;

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
     * 获取清分状态：INIT,SUCCESS,FAIL
     *
     * @return clear_status - 清分状态：INIT,SUCCESS,FAIL
     */
    public String getClearStatus() {
        return clearStatus;
    }

    /**
     * 设置清分状态：INIT,SUCCESS,FAIL
     *
     * @param clearStatus 清分状态：INIT,SUCCESS,FAIL
     */
    public void setClearStatus(String clearStatus) {
        this.clearStatus = clearStatus == null ? null : clearStatus.trim();
    }

    /**
     * 获取清分时间
     *
     * @return clear_time - 清分时间
     */
    public Date getClearTime() {
        return clearTime;
    }

    /**
     * 设置清分时间
     *
     * @param clearTime 清分时间
     */
    public void setClearTime(Date clearTime) {
        this.clearTime = clearTime;
    }

    /**
     * 获取清分备注
     *
     * @return clear_comment - 清分备注
     */
    public String getClearComment() {
        return clearComment;
    }

    /**
     * 设置清分备注
     *
     * @param clearComment 清分备注
     */
    public void setClearComment(String clearComment) {
        this.clearComment = clearComment == null ? null : clearComment.trim();
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
     * 获取结算备注
     *
     * @return settlement_comment - 结算备注
     */
    public String getSettlementComment() {
        return settlementComment;
    }

    /**
     * 设置结算备注
     *
     * @param settlementComment 结算备注
     */
    public void setSettlementComment(String settlementComment) {
        this.settlementComment = settlementComment == null ? null : settlementComment.trim();
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
        sb.append(", settlementDate=").append(settlementDate);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", channelId=").append(channelId);
        sb.append(", partnerRealName=").append(partnerRealName);
        sb.append(", clearStatus=").append(clearStatus);
        sb.append(", clearTime=").append(clearTime);
        sb.append(", clearComment=").append(clearComment);
        sb.append(", settlementStatus=").append(settlementStatus);
        sb.append(", settlementTime=").append(settlementTime);
        sb.append(", settlementComment=").append(settlementComment);
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
        SettlementTaskLogDO other = (SettlementTaskLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSettlementDate() == null ? other.getSettlementDate() == null : this.getSettlementDate().equals(other.getSettlementDate()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getClearStatus() == null ? other.getClearStatus() == null : this.getClearStatus().equals(other.getClearStatus()))
            && (this.getClearTime() == null ? other.getClearTime() == null : this.getClearTime().equals(other.getClearTime()))
            && (this.getClearComment() == null ? other.getClearComment() == null : this.getClearComment().equals(other.getClearComment()))
            && (this.getSettlementStatus() == null ? other.getSettlementStatus() == null : this.getSettlementStatus().equals(other.getSettlementStatus()))
            && (this.getSettlementTime() == null ? other.getSettlementTime() == null : this.getSettlementTime().equals(other.getSettlementTime()))
            && (this.getSettlementComment() == null ? other.getSettlementComment() == null : this.getSettlementComment().equals(other.getSettlementComment()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSettlementDate() == null) ? 0 : getSettlementDate().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getPartnerRealName() == null) ? 0 : getPartnerRealName().hashCode());
        result = prime * result + ((getClearStatus() == null) ? 0 : getClearStatus().hashCode());
        result = prime * result + ((getClearTime() == null) ? 0 : getClearTime().hashCode());
        result = prime * result + ((getClearComment() == null) ? 0 : getClearComment().hashCode());
        result = prime * result + ((getSettlementStatus() == null) ? 0 : getSettlementStatus().hashCode());
        result = prime * result + ((getSettlementTime() == null) ? 0 : getSettlementTime().hashCode());
        result = prime * result + ((getSettlementComment() == null) ? 0 : getSettlementComment().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}