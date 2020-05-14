package dal.model.shelluser;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_level_rule")
public class UserLevelRuleDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 周期类型
     */
    @Column(name = "use_time_unit")
    private String useTimeUnit;

    /**
     * 等级更新类型
     */
    @Column(name = "level_update_type")
    private String levelUpdateType;

    /**
     * 每月和每周和每年执行时间
     */
    private String days;

    /**
     * 等级规则
     */
    @Column(name = "level_rule")
    private String levelRule;

    /**
     * cron表达式
     */
    private String corn;

    /**
     * 积分累加天数
     */
    @Column(name = "cumulative_of_days")
    private Integer cumulativeOfDays;

    private String status;

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
     * 获取等级更新类型
     *
     * @return level_update_type - 等级更新类型
     */
    public String getLevelUpdateType() {
        return levelUpdateType;
    }

    /**
     * 设置等级更新类型
     *
     * @param levelUpdateType 等级更新类型
     */
    public void setLevelUpdateType(String levelUpdateType) {
        this.levelUpdateType = levelUpdateType == null ? null : levelUpdateType.trim();
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
     * 获取等级规则
     *
     * @return level_rule - 等级规则
     */
    public String getLevelRule() {
        return levelRule;
    }

    /**
     * 设置等级规则
     *
     * @param levelRule 等级规则
     */
    public void setLevelRule(String levelRule) {
        this.levelRule = levelRule == null ? null : levelRule.trim();
    }

    /**
     * 获取cron表达式
     *
     * @return corn - cron表达式
     */
    public String getCorn() {
        return corn;
    }

    /**
     * 设置cron表达式
     *
     * @param corn cron表达式
     */
    public void setCorn(String corn) {
        this.corn = corn == null ? null : corn.trim();
    }

    /**
     * 获取积分累加天数
     *
     * @return cumulative_of_days - 积分累加天数
     */
    public Integer getCumulativeOfDays() {
        return cumulativeOfDays;
    }

    /**
     * 设置积分累加天数
     *
     * @param cumulativeOfDays 积分累加天数
     */
    public void setCumulativeOfDays(Integer cumulativeOfDays) {
        this.cumulativeOfDays = cumulativeOfDays;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", useTimeUnit=").append(useTimeUnit);
        sb.append(", levelUpdateType=").append(levelUpdateType);
        sb.append(", days=").append(days);
        sb.append(", levelRule=").append(levelRule);
        sb.append(", corn=").append(corn);
        sb.append(", cumulativeOfDays=").append(cumulativeOfDays);
        sb.append(", status=").append(status);
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
        UserLevelRuleDO other = (UserLevelRuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getUseTimeUnit() == null ? other.getUseTimeUnit() == null : this.getUseTimeUnit().equals(other.getUseTimeUnit()))
            && (this.getLevelUpdateType() == null ? other.getLevelUpdateType() == null : this.getLevelUpdateType().equals(other.getLevelUpdateType()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getLevelRule() == null ? other.getLevelRule() == null : this.getLevelRule().equals(other.getLevelRule()))
            && (this.getCorn() == null ? other.getCorn() == null : this.getCorn().equals(other.getCorn()))
            && (this.getCumulativeOfDays() == null ? other.getCumulativeOfDays() == null : this.getCumulativeOfDays().equals(other.getCumulativeOfDays()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getUseTimeUnit() == null) ? 0 : getUseTimeUnit().hashCode());
        result = prime * result + ((getLevelUpdateType() == null) ? 0 : getLevelUpdateType().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getLevelRule() == null) ? 0 : getLevelRule().hashCode());
        result = prime * result + ((getCorn() == null) ? 0 : getCorn().hashCode());
        result = prime * result + ((getCumulativeOfDays() == null) ? 0 : getCumulativeOfDays().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}