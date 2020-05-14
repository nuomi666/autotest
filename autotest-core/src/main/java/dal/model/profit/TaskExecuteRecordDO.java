package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "task_execute_record")
public class TaskExecuteRecordDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易单号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 分润流水号
     */
    @Column(name = "serial_no")
    private String serialNo;

    /**
     * 交易金额，用于计算分润金额（分）
     */
    private Long amount;

    /**
     * 执行时间
     */
    @Column(name = "execute_time")
    private Date executeTime;

    /**
     * 结束时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 执行状态
     */
    private String state;

    /**
     * 条件策略ID
     */
    @Column(name = "condition_strategy_id")
    private Long conditionStrategyId;

    /**
     * 条件表达式
     */
    @Column(name = "condition_expr")
    private String conditionExpr;

    /**
     * 动作策略ID
     */
    @Column(name = "action_strategy_id")
    private Long actionStrategyId;

    /**
     * 规则ID
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 规则类别
     */
    @Column(name = "rule_type")
    private String ruleType;

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
     * 获取交易单号
     *
     * @return trade_no - 交易单号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易单号
     *
     * @param tradeNo 交易单号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取分润流水号
     *
     * @return serial_no - 分润流水号
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 设置分润流水号
     *
     * @param serialNo 分润流水号
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    /**
     * 获取交易金额，用于计算分润金额（分）
     *
     * @return amount - 交易金额，用于计算分润金额（分）
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置交易金额，用于计算分润金额（分）
     *
     * @param amount 交易金额，用于计算分润金额（分）
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取执行时间
     *
     * @return execute_time - 执行时间
     */
    public Date getExecuteTime() {
        return executeTime;
    }

    /**
     * 设置执行时间
     *
     * @param executeTime 执行时间
     */
    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    /**
     * 获取结束时间
     *
     * @return finish_time - 结束时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置结束时间
     *
     * @param finishTime 结束时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取执行状态
     *
     * @return state - 执行状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置执行状态
     *
     * @param state 执行状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取条件策略ID
     *
     * @return condition_strategy_id - 条件策略ID
     */
    public Long getConditionStrategyId() {
        return conditionStrategyId;
    }

    /**
     * 设置条件策略ID
     *
     * @param conditionStrategyId 条件策略ID
     */
    public void setConditionStrategyId(Long conditionStrategyId) {
        this.conditionStrategyId = conditionStrategyId;
    }

    /**
     * 获取条件表达式
     *
     * @return condition_expr - 条件表达式
     */
    public String getConditionExpr() {
        return conditionExpr;
    }

    /**
     * 设置条件表达式
     *
     * @param conditionExpr 条件表达式
     */
    public void setConditionExpr(String conditionExpr) {
        this.conditionExpr = conditionExpr == null ? null : conditionExpr.trim();
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
     * 获取规则类别
     *
     * @return rule_type - 规则类别
     */
    public String getRuleType() {
        return ruleType;
    }

    /**
     * 设置规则类别
     *
     * @param ruleType 规则类别
     */
    public void setRuleType(String ruleType) {
        this.ruleType = ruleType == null ? null : ruleType.trim();
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
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", amount=").append(amount);
        sb.append(", executeTime=").append(executeTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", state=").append(state);
        sb.append(", conditionStrategyId=").append(conditionStrategyId);
        sb.append(", conditionExpr=").append(conditionExpr);
        sb.append(", actionStrategyId=").append(actionStrategyId);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", ruleType=").append(ruleType);
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
        TaskExecuteRecordDO other = (TaskExecuteRecordDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getExecuteTime() == null ? other.getExecuteTime() == null : this.getExecuteTime().equals(other.getExecuteTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getConditionStrategyId() == null ? other.getConditionStrategyId() == null : this.getConditionStrategyId().equals(other.getConditionStrategyId()))
            && (this.getConditionExpr() == null ? other.getConditionExpr() == null : this.getConditionExpr().equals(other.getConditionExpr()))
            && (this.getActionStrategyId() == null ? other.getActionStrategyId() == null : this.getActionStrategyId().equals(other.getActionStrategyId()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getRuleType() == null ? other.getRuleType() == null : this.getRuleType().equals(other.getRuleType()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getExecuteTime() == null) ? 0 : getExecuteTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getConditionStrategyId() == null) ? 0 : getConditionStrategyId().hashCode());
        result = prime * result + ((getConditionExpr() == null) ? 0 : getConditionExpr().hashCode());
        result = prime * result + ((getActionStrategyId() == null) ? 0 : getActionStrategyId().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getRuleType() == null) ? 0 : getRuleType().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}