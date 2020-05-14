package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "condition_strategy")
public class ConditionStrategyDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 策略优先级，值越小，优先级越高
     */
    private Integer priority;

    /**
     * 类型，事务型，周期型
     */
    private String type;

    /**
     * cron表达式 事务型为空，周期型为cron
     */
    @Column(name = "cron_express")
    private String cronExpress;

    /**
     * 条件表达式
     */
    @Column(name = "condition_express")
    private String conditionExpress;

    /**
     * 开关状态
     */
    private String state;

    /**
     * 规则ID
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 新增时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 更新时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 序列化的组合表达式
     */
    @Column(name = "serial_express")
    private String serialExpress;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取策略优先级，值越小，优先级越高
     *
     * @return priority - 策略优先级，值越小，优先级越高
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置策略优先级，值越小，优先级越高
     *
     * @param priority 策略优先级，值越小，优先级越高
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取类型，事务型，周期型
     *
     * @return type - 类型，事务型，周期型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型，事务型，周期型
     *
     * @param type 类型，事务型，周期型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取cron表达式 事务型为空，周期型为cron
     *
     * @return cron_express - cron表达式 事务型为空，周期型为cron
     */
    public String getCronExpress() {
        return cronExpress;
    }

    /**
     * 设置cron表达式 事务型为空，周期型为cron
     *
     * @param cronExpress cron表达式 事务型为空，周期型为cron
     */
    public void setCronExpress(String cronExpress) {
        this.cronExpress = cronExpress == null ? null : cronExpress.trim();
    }

    /**
     * 获取条件表达式
     *
     * @return condition_express - 条件表达式
     */
    public String getConditionExpress() {
        return conditionExpress;
    }

    /**
     * 设置条件表达式
     *
     * @param conditionExpress 条件表达式
     */
    public void setConditionExpress(String conditionExpress) {
        this.conditionExpress = conditionExpress == null ? null : conditionExpress.trim();
    }

    /**
     * 获取开关状态
     *
     * @return state - 开关状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置开关状态
     *
     * @param state 开关状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取规则ID
     *
     * @return rule_id - 规则ID
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置规则ID
     *
     * @param ruleId 规则ID
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取更新时间
     *
     * @return raw_update_time - 更新时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param rawUpdateTime 更新时间
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    /**
     * 获取序列化的组合表达式
     *
     * @return serial_express - 序列化的组合表达式
     */
    public String getSerialExpress() {
        return serialExpress;
    }

    /**
     * 设置序列化的组合表达式
     *
     * @param serialExpress 序列化的组合表达式
     */
    public void setSerialExpress(String serialExpress) {
        this.serialExpress = serialExpress == null ? null : serialExpress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", priority=").append(priority);
        sb.append(", type=").append(type);
        sb.append(", cronExpress=").append(cronExpress);
        sb.append(", conditionExpress=").append(conditionExpress);
        sb.append(", state=").append(state);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", serialExpress=").append(serialExpress);
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
        ConditionStrategyDO other = (ConditionStrategyDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCronExpress() == null ? other.getCronExpress() == null : this.getCronExpress().equals(other.getCronExpress()))
            && (this.getConditionExpress() == null ? other.getConditionExpress() == null : this.getConditionExpress().equals(other.getConditionExpress()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getSerialExpress() == null ? other.getSerialExpress() == null : this.getSerialExpress().equals(other.getSerialExpress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCronExpress() == null) ? 0 : getCronExpress().hashCode());
        result = prime * result + ((getConditionExpress() == null) ? 0 : getConditionExpress().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getSerialExpress() == null) ? 0 : getSerialExpress().hashCode());
        return result;
    }
}