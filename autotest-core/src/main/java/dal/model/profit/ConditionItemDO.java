package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "condition_item")
public class ConditionItemDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 变量关键字
     */
    private String variable;

    /**
     * 符号
     */
    private String symbol;

    /**
     * 值表达式
     */
    @Column(name = "value_expr")
    private String valueExpr;

    /**
     * 开关状态
     */
    private String state;

    /**
     * 条件策略ID
     */
    @Column(name = "condition_strategy_id")
    private Long conditionStrategyId;

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
     * 获取变量关键字
     *
     * @return variable - 变量关键字
     */
    public String getVariable() {
        return variable;
    }

    /**
     * 设置变量关键字
     *
     * @param variable 变量关键字
     */
    public void setVariable(String variable) {
        this.variable = variable == null ? null : variable.trim();
    }

    /**
     * 获取符号
     *
     * @return symbol - 符号
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 设置符号
     *
     * @param symbol 符号
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    /**
     * 获取值表达式
     *
     * @return value_expr - 值表达式
     */
    public String getValueExpr() {
        return valueExpr;
    }

    /**
     * 设置值表达式
     *
     * @param valueExpr 值表达式
     */
    public void setValueExpr(String valueExpr) {
        this.valueExpr = valueExpr == null ? null : valueExpr.trim();
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
        sb.append(", variable=").append(variable);
        sb.append(", symbol=").append(symbol);
        sb.append(", valueExpr=").append(valueExpr);
        sb.append(", state=").append(state);
        sb.append(", conditionStrategyId=").append(conditionStrategyId);
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
        ConditionItemDO other = (ConditionItemDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVariable() == null ? other.getVariable() == null : this.getVariable().equals(other.getVariable()))
            && (this.getSymbol() == null ? other.getSymbol() == null : this.getSymbol().equals(other.getSymbol()))
            && (this.getValueExpr() == null ? other.getValueExpr() == null : this.getValueExpr().equals(other.getValueExpr()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getConditionStrategyId() == null ? other.getConditionStrategyId() == null : this.getConditionStrategyId().equals(other.getConditionStrategyId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVariable() == null) ? 0 : getVariable().hashCode());
        result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
        result = prime * result + ((getValueExpr() == null) ? 0 : getValueExpr().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getConditionStrategyId() == null) ? 0 : getConditionStrategyId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}