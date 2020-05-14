package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "precise_give_coupon")
public class PreciseGiveCouponDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动编号
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 赠送的优惠券信息
     */
    @Column(name = "give_coupon_info")
    private String giveCouponInfo;

    /**
     * 赠送的优惠券信息规则
     */
    @Column(name = "precise_give_coupon_rule")
    private String preciseGiveCouponRule;

    /**
     * 赠送时间
     */
    @Column(name = "give_time")
    private Date giveTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 精准送券规则集编码
     */
    @Column(name = "rule_set_code")
    private String ruleSetCode;

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
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
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
     * 获取赠送的优惠券信息
     *
     * @return give_coupon_info - 赠送的优惠券信息
     */
    public String getGiveCouponInfo() {
        return giveCouponInfo;
    }

    /**
     * 设置赠送的优惠券信息
     *
     * @param giveCouponInfo 赠送的优惠券信息
     */
    public void setGiveCouponInfo(String giveCouponInfo) {
        this.giveCouponInfo = giveCouponInfo == null ? null : giveCouponInfo.trim();
    }

    /**
     * 获取赠送的优惠券信息规则
     *
     * @return precise_give_coupon_rule - 赠送的优惠券信息规则
     */
    public String getPreciseGiveCouponRule() {
        return preciseGiveCouponRule;
    }

    /**
     * 设置赠送的优惠券信息规则
     *
     * @param preciseGiveCouponRule 赠送的优惠券信息规则
     */
    public void setPreciseGiveCouponRule(String preciseGiveCouponRule) {
        this.preciseGiveCouponRule = preciseGiveCouponRule == null ? null : preciseGiveCouponRule.trim();
    }

    /**
     * 获取赠送时间
     *
     * @return give_time - 赠送时间
     */
    public Date getGiveTime() {
        return giveTime;
    }

    /**
     * 设置赠送时间
     *
     * @param giveTime 赠送时间
     */
    public void setGiveTime(Date giveTime) {
        this.giveTime = giveTime;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取精准送券规则集编码
     *
     * @return rule_set_code - 精准送券规则集编码
     */
    public String getRuleSetCode() {
        return ruleSetCode;
    }

    /**
     * 设置精准送券规则集编码
     *
     * @param ruleSetCode 精准送券规则集编码
     */
    public void setRuleSetCode(String ruleSetCode) {
        this.ruleSetCode = ruleSetCode == null ? null : ruleSetCode.trim();
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
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", name=").append(name);
        sb.append(", giveCouponInfo=").append(giveCouponInfo);
        sb.append(", preciseGiveCouponRule=").append(preciseGiveCouponRule);
        sb.append(", giveTime=").append(giveTime);
        sb.append(", status=").append(status);
        sb.append(", ruleSetCode=").append(ruleSetCode);
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
        PreciseGiveCouponDO other = (PreciseGiveCouponDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGiveCouponInfo() == null ? other.getGiveCouponInfo() == null : this.getGiveCouponInfo().equals(other.getGiveCouponInfo()))
            && (this.getPreciseGiveCouponRule() == null ? other.getPreciseGiveCouponRule() == null : this.getPreciseGiveCouponRule().equals(other.getPreciseGiveCouponRule()))
            && (this.getGiveTime() == null ? other.getGiveTime() == null : this.getGiveTime().equals(other.getGiveTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRuleSetCode() == null ? other.getRuleSetCode() == null : this.getRuleSetCode().equals(other.getRuleSetCode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGiveCouponInfo() == null) ? 0 : getGiveCouponInfo().hashCode());
        result = prime * result + ((getPreciseGiveCouponRule() == null) ? 0 : getPreciseGiveCouponRule().hashCode());
        result = prime * result + ((getGiveTime() == null) ? 0 : getGiveTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRuleSetCode() == null) ? 0 : getRuleSetCode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}