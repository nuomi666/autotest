package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cron_task")
public class CronTaskDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 下次执行时间
     */
    @Column(name = "next_schedule_time")
    private Date nextScheduleTime;

    /**
     * 最后一次执行时间
     */
    @Column(name = "last_schedule_time")
    private Date lastScheduleTime;

    /**
     * 规则id
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 条件策略id
     */
    @Column(name = "condition_strategy_id")
    private Long conditionStrategyId;

    /**
     * 动作策略ID
     */
    @Column(name = "action_strategy_id")
    private Long actionStrategyId;

    /**
     * 开关状态
     */
    private String state;

    /**
     * 执行状态
     */
    @Column(name = "execute_state")
    private String executeState;

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
     * 获取下次执行时间
     *
     * @return next_schedule_time - 下次执行时间
     */
    public Date getNextScheduleTime() {
        return nextScheduleTime;
    }

    /**
     * 设置下次执行时间
     *
     * @param nextScheduleTime 下次执行时间
     */
    public void setNextScheduleTime(Date nextScheduleTime) {
        this.nextScheduleTime = nextScheduleTime;
    }

    /**
     * 获取最后一次执行时间
     *
     * @return last_schedule_time - 最后一次执行时间
     */
    public Date getLastScheduleTime() {
        return lastScheduleTime;
    }

    /**
     * 设置最后一次执行时间
     *
     * @param lastScheduleTime 最后一次执行时间
     */
    public void setLastScheduleTime(Date lastScheduleTime) {
        this.lastScheduleTime = lastScheduleTime;
    }

    /**
     * 获取规则id
     *
     * @return rule_id - 规则id
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置规则id
     *
     * @param ruleId 规则id
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取条件策略id
     *
     * @return condition_strategy_id - 条件策略id
     */
    public Long getConditionStrategyId() {
        return conditionStrategyId;
    }

    /**
     * 设置条件策略id
     *
     * @param conditionStrategyId 条件策略id
     */
    public void setConditionStrategyId(Long conditionStrategyId) {
        this.conditionStrategyId = conditionStrategyId;
    }

    /**
     * 获取动作策略ID
     *
     * @return action_strategy_id - 动作策略ID
     */
    public Long getActionStrategyId() {
        return actionStrategyId;
    }

    /**
     * 设置动作策略ID
     *
     * @param actionStrategyId 动作策略ID
     */
    public void setActionStrategyId(Long actionStrategyId) {
        this.actionStrategyId = actionStrategyId;
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
     * 获取执行状态
     *
     * @return execute_state - 执行状态
     */
    public String getExecuteState() {
        return executeState;
    }

    /**
     * 设置执行状态
     *
     * @param executeState 执行状态
     */
    public void setExecuteState(String executeState) {
        this.executeState = executeState == null ? null : executeState.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", nextScheduleTime=").append(nextScheduleTime);
        sb.append(", lastScheduleTime=").append(lastScheduleTime);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", conditionStrategyId=").append(conditionStrategyId);
        sb.append(", actionStrategyId=").append(actionStrategyId);
        sb.append(", state=").append(state);
        sb.append(", executeState=").append(executeState);
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
        CronTaskDO other = (CronTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNextScheduleTime() == null ? other.getNextScheduleTime() == null : this.getNextScheduleTime().equals(other.getNextScheduleTime()))
            && (this.getLastScheduleTime() == null ? other.getLastScheduleTime() == null : this.getLastScheduleTime().equals(other.getLastScheduleTime()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getConditionStrategyId() == null ? other.getConditionStrategyId() == null : this.getConditionStrategyId().equals(other.getConditionStrategyId()))
            && (this.getActionStrategyId() == null ? other.getActionStrategyId() == null : this.getActionStrategyId().equals(other.getActionStrategyId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getExecuteState() == null ? other.getExecuteState() == null : this.getExecuteState().equals(other.getExecuteState()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNextScheduleTime() == null) ? 0 : getNextScheduleTime().hashCode());
        result = prime * result + ((getLastScheduleTime() == null) ? 0 : getLastScheduleTime().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getConditionStrategyId() == null) ? 0 : getConditionStrategyId().hashCode());
        result = prime * result + ((getActionStrategyId() == null) ? 0 : getActionStrategyId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getExecuteState() == null) ? 0 : getExecuteState().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}