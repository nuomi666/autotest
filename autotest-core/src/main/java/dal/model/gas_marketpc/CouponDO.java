package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "coupon")
public class CouponDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 优惠券定义id
     */
    @Column(name = "definition_id")
    private String definitionId;

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
     * 优惠券名字
     */
    @Column(name = "coupon_name")
    private String couponName;

    /**
     * 优惠券类型：油品券/商品券/通用券
     */
    @Column(name = "coupon_biz_type")
    private String couponBizType;

    /**
     * 状态
     */
    private String status;

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
     * 每次最多使用几张该类优惠券
     */
    @Column(name = "max_use")
    private Integer maxUse;

    /**
     * 频次对应的时间段
     */
    @Column(name = "time_slots")
    private String timeSlots;

    /**
     * 优惠券使用规则
     */
    @Column(name = "coupon_use_rule")
    private String couponUseRule;

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
     * 获取优惠券定义id
     *
     * @return definition_id - 优惠券定义id
     */
    public String getDefinitionId() {
        return definitionId;
    }

    /**
     * 设置优惠券定义id
     *
     * @param definitionId 优惠券定义id
     */
    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId == null ? null : definitionId.trim();
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
     * 获取优惠券名字
     *
     * @return coupon_name - 优惠券名字
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 设置优惠券名字
     *
     * @param couponName 优惠券名字
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    /**
     * 获取优惠券类型：油品券/商品券/通用券
     *
     * @return coupon_biz_type - 优惠券类型：油品券/商品券/通用券
     */
    public String getCouponBizType() {
        return couponBizType;
    }

    /**
     * 设置优惠券类型：油品券/商品券/通用券
     *
     * @param couponBizType 优惠券类型：油品券/商品券/通用券
     */
    public void setCouponBizType(String couponBizType) {
        this.couponBizType = couponBizType == null ? null : couponBizType.trim();
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
     * 获取每次最多使用几张该类优惠券
     *
     * @return max_use - 每次最多使用几张该类优惠券
     */
    public Integer getMaxUse() {
        return maxUse;
    }

    /**
     * 设置每次最多使用几张该类优惠券
     *
     * @param maxUse 每次最多使用几张该类优惠券
     */
    public void setMaxUse(Integer maxUse) {
        this.maxUse = maxUse;
    }

    /**
     * 获取频次对应的时间段
     *
     * @return time_slots - 频次对应的时间段
     */
    public String getTimeSlots() {
        return timeSlots;
    }

    /**
     * 设置频次对应的时间段
     *
     * @param timeSlots 频次对应的时间段
     */
    public void setTimeSlots(String timeSlots) {
        this.timeSlots = timeSlots == null ? null : timeSlots.trim();
    }

    /**
     * 获取优惠券使用规则
     *
     * @return coupon_use_rule - 优惠券使用规则
     */
    public String getCouponUseRule() {
        return couponUseRule;
    }

    /**
     * 设置优惠券使用规则
     *
     * @param couponUseRule 优惠券使用规则
     */
    public void setCouponUseRule(String couponUseRule) {
        this.couponUseRule = couponUseRule == null ? null : couponUseRule.trim();
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
        sb.append(", definitionId=").append(definitionId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", couponName=").append(couponName);
        sb.append(", couponBizType=").append(couponBizType);
        sb.append(", status=").append(status);
        sb.append(", useTimeUnit=").append(useTimeUnit);
        sb.append(", days=").append(days);
        sb.append(", maxUse=").append(maxUse);
        sb.append(", timeSlots=").append(timeSlots);
        sb.append(", couponUseRule=").append(couponUseRule);
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
        CouponDO other = (CouponDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDefinitionId() == null ? other.getDefinitionId() == null : this.getDefinitionId().equals(other.getDefinitionId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getCouponName() == null ? other.getCouponName() == null : this.getCouponName().equals(other.getCouponName()))
            && (this.getCouponBizType() == null ? other.getCouponBizType() == null : this.getCouponBizType().equals(other.getCouponBizType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUseTimeUnit() == null ? other.getUseTimeUnit() == null : this.getUseTimeUnit().equals(other.getUseTimeUnit()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getMaxUse() == null ? other.getMaxUse() == null : this.getMaxUse().equals(other.getMaxUse()))
            && (this.getTimeSlots() == null ? other.getTimeSlots() == null : this.getTimeSlots().equals(other.getTimeSlots()))
            && (this.getCouponUseRule() == null ? other.getCouponUseRule() == null : this.getCouponUseRule().equals(other.getCouponUseRule()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDefinitionId() == null) ? 0 : getDefinitionId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getCouponName() == null) ? 0 : getCouponName().hashCode());
        result = prime * result + ((getCouponBizType() == null) ? 0 : getCouponBizType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUseTimeUnit() == null) ? 0 : getUseTimeUnit().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getMaxUse() == null) ? 0 : getMaxUse().hashCode());
        result = prime * result + ((getTimeSlots() == null) ? 0 : getTimeSlots().hashCode());
        result = prime * result + ((getCouponUseRule() == null) ? 0 : getCouponUseRule().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}