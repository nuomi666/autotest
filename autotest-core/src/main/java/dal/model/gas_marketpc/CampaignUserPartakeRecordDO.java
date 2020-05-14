package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "campaign_user_partake_record")
public class CampaignUserPartakeRecordDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事件订单号
     */
    @Column(name = "event_id")
    private String eventId;

    /**
     * 平台商id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 商户Id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动编号
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 活动类型
     */
    @Column(name = "campaign_type")
    private String campaignType;

    /**
     * 执行状态
     */
    private String status;

    /**
     * 参与时间
     */
    @Column(name = "partake_time")
    private Date partakeTime;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 会员姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 礼包编号
     */
    @Column(name = "gift_no")
    private String giftNo;

    /**
     * 礼包名称
     */
    @Column(name = "gift_name")
    private String giftName;

    /**
     * gid
     */
    private String gid;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 赠送明细
     */
    @Column(name = "give_details")
    private String giveDetails;

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
     * 获取事件订单号
     *
     * @return event_id - 事件订单号
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * 设置事件订单号
     *
     * @param eventId 事件订单号
     */
    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    /**
     * 获取平台商id
     *
     * @return plat_partner_id - 平台商id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商id
     *
     * @param platPartnerId 平台商id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取商户Id
     *
     * @return partner_id - 商户Id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户Id
     *
     * @param partnerId 商户Id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取用户手机号
     *
     * @return mobile - 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     *
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取活动编号
     *
     * @return campaign_no - 活动编号
     */
    public String getCampaignNo() {
        return campaignNo;
    }

    /**
     * 设置活动编号
     *
     * @param campaignNo 活动编号
     */
    public void setCampaignNo(String campaignNo) {
        this.campaignNo = campaignNo == null ? null : campaignNo.trim();
    }

    /**
     * 获取活动类型
     *
     * @return campaign_type - 活动类型
     */
    public String getCampaignType() {
        return campaignType;
    }

    /**
     * 设置活动类型
     *
     * @param campaignType 活动类型
     */
    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType == null ? null : campaignType.trim();
    }

    /**
     * 获取执行状态
     *
     * @return status - 执行状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置执行状态
     *
     * @param status 执行状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取参与时间
     *
     * @return partake_time - 参与时间
     */
    public Date getPartakeTime() {
        return partakeTime;
    }

    /**
     * 设置参与时间
     *
     * @param partakeTime 参与时间
     */
    public void setPartakeTime(Date partakeTime) {
        this.partakeTime = partakeTime;
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取会员姓名
     *
     * @return real_name - 会员姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置会员姓名
     *
     * @param realName 会员姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取礼包编号
     *
     * @return gift_no - 礼包编号
     */
    public String getGiftNo() {
        return giftNo;
    }

    /**
     * 设置礼包编号
     *
     * @param giftNo 礼包编号
     */
    public void setGiftNo(String giftNo) {
        this.giftNo = giftNo == null ? null : giftNo.trim();
    }

    /**
     * 获取礼包名称
     *
     * @return gift_name - 礼包名称
     */
    public String getGiftName() {
        return giftName;
    }

    /**
     * 设置礼包名称
     *
     * @param giftName 礼包名称
     */
    public void setGiftName(String giftName) {
        this.giftName = giftName == null ? null : giftName.trim();
    }

    /**
     * 获取gid
     *
     * @return gid - gid
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置gid
     *
     * @param gid gid
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
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

    /**
     * 获取赠送明细
     *
     * @return give_details - 赠送明细
     */
    public String getGiveDetails() {
        return giveDetails;
    }

    /**
     * 设置赠送明细
     *
     * @param giveDetails 赠送明细
     */
    public void setGiveDetails(String giveDetails) {
        this.giveDetails = giveDetails == null ? null : giveDetails.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", eventId=").append(eventId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", userId=").append(userId);
        sb.append(", mobile=").append(mobile);
        sb.append(", name=").append(name);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", campaignType=").append(campaignType);
        sb.append(", status=").append(status);
        sb.append(", partakeTime=").append(partakeTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", realName=").append(realName);
        sb.append(", giftNo=").append(giftNo);
        sb.append(", giftName=").append(giftName);
        sb.append(", gid=").append(gid);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", giveDetails=").append(giveDetails);
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
        CampaignUserPartakeRecordDO other = (CampaignUserPartakeRecordDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getCampaignType() == null ? other.getCampaignType() == null : this.getCampaignType().equals(other.getCampaignType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPartakeTime() == null ? other.getPartakeTime() == null : this.getPartakeTime().equals(other.getPartakeTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getGiftNo() == null ? other.getGiftNo() == null : this.getGiftNo().equals(other.getGiftNo()))
            && (this.getGiftName() == null ? other.getGiftName() == null : this.getGiftName().equals(other.getGiftName()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getGiveDetails() == null ? other.getGiveDetails() == null : this.getGiveDetails().equals(other.getGiveDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getCampaignType() == null) ? 0 : getCampaignType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPartakeTime() == null) ? 0 : getPartakeTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getGiftNo() == null) ? 0 : getGiftNo().hashCode());
        result = prime * result + ((getGiftName() == null) ? 0 : getGiftName().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getGiveDetails() == null) ? 0 : getGiveDetails().hashCode());
        return result;
    }
}