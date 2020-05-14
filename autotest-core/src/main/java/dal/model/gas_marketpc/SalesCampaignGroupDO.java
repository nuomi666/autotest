package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sales_campaign_group")
public class SalesCampaignGroupDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动组ID
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 活动组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 活动组状态
     */
    @Column(name = "enable_status")
    private String enableStatus;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 是否可以叠加优惠券
     */
    @Column(name = "coupon_overlap")
    private Byte couponOverlap;

    /**
     * 单次最大优惠金额
     */
    @Column(name = "discount_max_amount")
    private Long discountMaxAmount;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 关联活动编号
     */
    @Column(name = "campaign_nos")
    private String campaignNos;

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
     * 获取活动组ID
     *
     * @return group_id - 活动组ID
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置活动组ID
     *
     * @param groupId 活动组ID
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * 获取活动组名称
     *
     * @return group_name - 活动组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置活动组名称
     *
     * @param groupName 活动组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 获取活动组状态
     *
     * @return enable_status - 活动组状态
     */
    public String getEnableStatus() {
        return enableStatus;
    }

    /**
     * 设置活动组状态
     *
     * @param enableStatus 活动组状态
     */
    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus == null ? null : enableStatus.trim();
    }

    /**
     * 获取商户ID
     *
     * @return partner_id - 商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户ID
     *
     * @param partnerId 商户ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商ID
     *
     * @return plat_partner_id - 平台商ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商ID
     *
     * @param platPartnerId 平台商ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取是否可以叠加优惠券
     *
     * @return coupon_overlap - 是否可以叠加优惠券
     */
    public Byte getCouponOverlap() {
        return couponOverlap;
    }

    /**
     * 设置是否可以叠加优惠券
     *
     * @param couponOverlap 是否可以叠加优惠券
     */
    public void setCouponOverlap(Byte couponOverlap) {
        this.couponOverlap = couponOverlap;
    }

    /**
     * 获取单次最大优惠金额
     *
     * @return discount_max_amount - 单次最大优惠金额
     */
    public Long getDiscountMaxAmount() {
        return discountMaxAmount;
    }

    /**
     * 设置单次最大优惠金额
     *
     * @param discountMaxAmount 单次最大优惠金额
     */
    public void setDiscountMaxAmount(Long discountMaxAmount) {
        this.discountMaxAmount = discountMaxAmount;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取关联活动编号
     *
     * @return campaign_nos - 关联活动编号
     */
    public String getCampaignNos() {
        return campaignNos;
    }

    /**
     * 设置关联活动编号
     *
     * @param campaignNos 关联活动编号
     */
    public void setCampaignNos(String campaignNos) {
        this.campaignNos = campaignNos == null ? null : campaignNos.trim();
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
        sb.append(", groupId=").append(groupId);
        sb.append(", groupName=").append(groupName);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", couponOverlap=").append(couponOverlap);
        sb.append(", discountMaxAmount=").append(discountMaxAmount);
        sb.append(", priority=").append(priority);
        sb.append(", campaignNos=").append(campaignNos);
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
        SalesCampaignGroupDO other = (SalesCampaignGroupDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getEnableStatus() == null ? other.getEnableStatus() == null : this.getEnableStatus().equals(other.getEnableStatus()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getCouponOverlap() == null ? other.getCouponOverlap() == null : this.getCouponOverlap().equals(other.getCouponOverlap()))
            && (this.getDiscountMaxAmount() == null ? other.getDiscountMaxAmount() == null : this.getDiscountMaxAmount().equals(other.getDiscountMaxAmount()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getCampaignNos() == null ? other.getCampaignNos() == null : this.getCampaignNos().equals(other.getCampaignNos()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getEnableStatus() == null) ? 0 : getEnableStatus().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getCouponOverlap() == null) ? 0 : getCouponOverlap().hashCode());
        result = prime * result + ((getDiscountMaxAmount() == null) ? 0 : getDiscountMaxAmount().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getCampaignNos() == null) ? 0 : getCampaignNos().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}