package dal.model.shelluser;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_integral_reset_rule")
public class UserIntegralResetRuleDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 积分清零开关
     */
    @Column(name = "reset_switch")
    private String resetSwitch;

    /**
     * 积分清零类型
     */
    @Column(name = "integral_reset_type")
    private String integralResetType;

    /**
     * 周期类型
     */
    @Column(name = "use_time_unit")
    private String useTimeUnit;

    /**
     * corn表达式
     */
    private String corn;

    /**
     * 每月和每周和每年执行时间
     */
    private String days;

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
     * 获取积分清零开关
     *
     * @return reset_switch - 积分清零开关
     */
    public String getResetSwitch() {
        return resetSwitch;
    }

    /**
     * 设置积分清零开关
     *
     * @param resetSwitch 积分清零开关
     */
    public void setResetSwitch(String resetSwitch) {
        this.resetSwitch = resetSwitch == null ? null : resetSwitch.trim();
    }

    /**
     * 获取积分清零类型
     *
     * @return integral_reset_type - 积分清零类型
     */
    public String getIntegralResetType() {
        return integralResetType;
    }

    /**
     * 设置积分清零类型
     *
     * @param integralResetType 积分清零类型
     */
    public void setIntegralResetType(String integralResetType) {
        this.integralResetType = integralResetType == null ? null : integralResetType.trim();
    }

    /**
     * 获取周期类型
     *
     * @return use_time_unit - 周期类型
     */
    public String getUseTimeUnit() {
        return useTimeUnit;
    }

    /**
     * 设置周期类型
     *
     * @param useTimeUnit 周期类型
     */
    public void setUseTimeUnit(String useTimeUnit) {
        this.useTimeUnit = useTimeUnit == null ? null : useTimeUnit.trim();
    }

    /**
     * 获取corn表达式
     *
     * @return corn - corn表达式
     */
    public String getCorn() {
        return corn;
    }

    /**
     * 设置corn表达式
     *
     * @param corn corn表达式
     */
    public void setCorn(String corn) {
        this.corn = corn == null ? null : corn.trim();
    }

    /**
     * 获取每月和每周和每年执行时间
     *
     * @return days - 每月和每周和每年执行时间
     */
    public String getDays() {
        return days;
    }

    /**
     * 设置每月和每周和每年执行时间
     *
     * @param days 每月和每周和每年执行时间
     */
    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
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
        sb.append(", resetSwitch=").append(resetSwitch);
        sb.append(", integralResetType=").append(integralResetType);
        sb.append(", useTimeUnit=").append(useTimeUnit);
        sb.append(", corn=").append(corn);
        sb.append(", days=").append(days);
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
        UserIntegralResetRuleDO other = (UserIntegralResetRuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getResetSwitch() == null ? other.getResetSwitch() == null : this.getResetSwitch().equals(other.getResetSwitch()))
            && (this.getIntegralResetType() == null ? other.getIntegralResetType() == null : this.getIntegralResetType().equals(other.getIntegralResetType()))
            && (this.getUseTimeUnit() == null ? other.getUseTimeUnit() == null : this.getUseTimeUnit().equals(other.getUseTimeUnit()))
            && (this.getCorn() == null ? other.getCorn() == null : this.getCorn().equals(other.getCorn()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getResetSwitch() == null) ? 0 : getResetSwitch().hashCode());
        result = prime * result + ((getIntegralResetType() == null) ? 0 : getIntegralResetType().hashCode());
        result = prime * result + ((getUseTimeUnit() == null) ? 0 : getUseTimeUnit().hashCode());
        result = prime * result + ((getCorn() == null) ? 0 : getCorn().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}