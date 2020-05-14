package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sales_campaign")
public class SalesCampaignDO implements Serializable {
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
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动描述
     */
    private String description;

    /**
     * 活动生命周期：时间段/周期/长期
     */
    @Column(name = "life_cycle")
    private String lifeCycle;

    /**
     * 活动开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 活动结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 频次类型
     */
    @Column(name = "use_time_unit")
    private String useTimeUnit;

    /**
     * 频次对应的天/周
     */
    private String days;

    /**
     * 频次对应的时间段
     */
    @Column(name = "time_slot")
    private String timeSlot;

    /**
     * 状态
     */
    private String status;

    /**
     * 触发事件路由
     */
    @Column(name = "event_routes")
    private String eventRoutes;

    /**
     * 参与活动的条件
     */
    @Column(name = "partake_rule")
    private String partakeRule;

    /**
     * 环境上下文(预留字段)
     */
    private String context;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 活动规则
     */
    @Column(name = "campaign_rules")
    private String campaignRules;

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
     * 获取活动描述
     *
     * @return description - 活动描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置活动描述
     *
     * @param description 活动描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取活动生命周期：时间段/周期/长期
     *
     * @return life_cycle - 活动生命周期：时间段/周期/长期
     */
    public String getLifeCycle() {
        return lifeCycle;
    }

    /**
     * 设置活动生命周期：时间段/周期/长期
     *
     * @param lifeCycle 活动生命周期：时间段/周期/长期
     */
    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle == null ? null : lifeCycle.trim();
    }

    /**
     * 获取活动开始时间
     *
     * @return start_time - 活动开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置活动开始时间
     *
     * @param startTime 活动开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取活动结束时间
     *
     * @return end_time - 活动结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置活动结束时间
     *
     * @param endTime 活动结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取频次类型
     *
     * @return use_time_unit - 频次类型
     */
    public String getUseTimeUnit() {
        return useTimeUnit;
    }

    /**
     * 设置频次类型
     *
     * @param useTimeUnit 频次类型
     */
    public void setUseTimeUnit(String useTimeUnit) {
        this.useTimeUnit = useTimeUnit == null ? null : useTimeUnit.trim();
    }

    /**
     * 获取频次对应的天/周
     *
     * @return days - 频次对应的天/周
     */
    public String getDays() {
        return days;
    }

    /**
     * 设置频次对应的天/周
     *
     * @param days 频次对应的天/周
     */
    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
    }

    /**
     * 获取频次对应的时间段
     *
     * @return time_slot - 频次对应的时间段
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * 设置频次对应的时间段
     *
     * @param timeSlot 频次对应的时间段
     */
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot == null ? null : timeSlot.trim();
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
     * 获取触发事件路由
     *
     * @return event_routes - 触发事件路由
     */
    public String getEventRoutes() {
        return eventRoutes;
    }

    /**
     * 设置触发事件路由
     *
     * @param eventRoutes 触发事件路由
     */
    public void setEventRoutes(String eventRoutes) {
        this.eventRoutes = eventRoutes == null ? null : eventRoutes.trim();
    }

    /**
     * 获取参与活动的条件
     *
     * @return partake_rule - 参与活动的条件
     */
    public String getPartakeRule() {
        return partakeRule;
    }

    /**
     * 设置参与活动的条件
     *
     * @param partakeRule 参与活动的条件
     */
    public void setPartakeRule(String partakeRule) {
        this.partakeRule = partakeRule == null ? null : partakeRule.trim();
    }

    /**
     * 获取环境上下文(预留字段)
     *
     * @return context - 环境上下文(预留字段)
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置环境上下文(预留字段)
     *
     * @param context 环境上下文(预留字段)
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
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
     * 获取活动规则
     *
     * @return campaign_rules - 活动规则
     */
    public String getCampaignRules() {
        return campaignRules;
    }

    /**
     * 设置活动规则
     *
     * @param campaignRules 活动规则
     */
    public void setCampaignRules(String campaignRules) {
        this.campaignRules = campaignRules == null ? null : campaignRules.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", lifeCycle=").append(lifeCycle);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", useTimeUnit=").append(useTimeUnit);
        sb.append(", days=").append(days);
        sb.append(", timeSlot=").append(timeSlot);
        sb.append(", status=").append(status);
        sb.append(", eventRoutes=").append(eventRoutes);
        sb.append(", partakeRule=").append(partakeRule);
        sb.append(", context=").append(context);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", campaignRules=").append(campaignRules);
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
        SalesCampaignDO other = (SalesCampaignDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getLifeCycle() == null ? other.getLifeCycle() == null : this.getLifeCycle().equals(other.getLifeCycle()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getUseTimeUnit() == null ? other.getUseTimeUnit() == null : this.getUseTimeUnit().equals(other.getUseTimeUnit()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getTimeSlot() == null ? other.getTimeSlot() == null : this.getTimeSlot().equals(other.getTimeSlot()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEventRoutes() == null ? other.getEventRoutes() == null : this.getEventRoutes().equals(other.getEventRoutes()))
            && (this.getPartakeRule() == null ? other.getPartakeRule() == null : this.getPartakeRule().equals(other.getPartakeRule()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getCampaignRules() == null ? other.getCampaignRules() == null : this.getCampaignRules().equals(other.getCampaignRules()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getLifeCycle() == null) ? 0 : getLifeCycle().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getUseTimeUnit() == null) ? 0 : getUseTimeUnit().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getTimeSlot() == null) ? 0 : getTimeSlot().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEventRoutes() == null) ? 0 : getEventRoutes().hashCode());
        result = prime * result + ((getPartakeRule() == null) ? 0 : getPartakeRule().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getCampaignRules() == null) ? 0 : getCampaignRules().hashCode());
        return result;
    }
}