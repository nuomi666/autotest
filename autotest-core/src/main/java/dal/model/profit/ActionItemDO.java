package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "action_item")
public class ActionItemDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 来源
     */
    private String source;

    /**
     * 去向
     */
    private String termini;

    /**
     * 行为表达式,计算金额（分）
     */
    @Column(name = "action_expr")
    private String actionExpr;

    /**
     * 舍入算法（CEIL：向上舍入；FLOOR：向下舍入；ROUND：标准舍入），默认四舍五入
     */
    private String alg;

    /**
     * 执行顺序
     */
    private Integer sequence;

    /**
     * 动作策略ID
     */
    @Column(name = "action_strategy_id")
    private Long actionStrategyId;

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
     * 执行序列化表达式,计算金额（分）
     */
    @Column(name = "serial_expr")
    private String serialExpr;

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
     * 获取来源
     *
     * @return source - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取去向
     *
     * @return termini - 去向
     */
    public String getTermini() {
        return termini;
    }

    /**
     * 设置去向
     *
     * @param termini 去向
     */
    public void setTermini(String termini) {
        this.termini = termini == null ? null : termini.trim();
    }

    /**
     * 获取行为表达式,计算金额（分）
     *
     * @return action_expr - 行为表达式,计算金额（分）
     */
    public String getActionExpr() {
        return actionExpr;
    }

    /**
     * 设置行为表达式,计算金额（分）
     *
     * @param actionExpr 行为表达式,计算金额（分）
     */
    public void setActionExpr(String actionExpr) {
        this.actionExpr = actionExpr == null ? null : actionExpr.trim();
    }

    /**
     * 获取舍入算法（CEIL：向上舍入；FLOOR：向下舍入；ROUND：标准舍入），默认四舍五入
     *
     * @return alg - 舍入算法（CEIL：向上舍入；FLOOR：向下舍入；ROUND：标准舍入），默认四舍五入
     */
    public String getAlg() {
        return alg;
    }

    /**
     * 设置舍入算法（CEIL：向上舍入；FLOOR：向下舍入；ROUND：标准舍入），默认四舍五入
     *
     * @param alg 舍入算法（CEIL：向上舍入；FLOOR：向下舍入；ROUND：标准舍入），默认四舍五入
     */
    public void setAlg(String alg) {
        this.alg = alg == null ? null : alg.trim();
    }

    /**
     * 获取执行顺序
     *
     * @return sequence - 执行顺序
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置执行顺序
     *
     * @param sequence 执行顺序
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
     * 获取执行序列化表达式,计算金额（分）
     *
     * @return serial_expr - 执行序列化表达式,计算金额（分）
     */
    public String getSerialExpr() {
        return serialExpr;
    }

    /**
     * 设置执行序列化表达式,计算金额（分）
     *
     * @param serialExpr 执行序列化表达式,计算金额（分）
     */
    public void setSerialExpr(String serialExpr) {
        this.serialExpr = serialExpr == null ? null : serialExpr.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", source=").append(source);
        sb.append(", termini=").append(termini);
        sb.append(", actionExpr=").append(actionExpr);
        sb.append(", alg=").append(alg);
        sb.append(", sequence=").append(sequence);
        sb.append(", actionStrategyId=").append(actionStrategyId);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", serialExpr=").append(serialExpr);
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
        ActionItemDO other = (ActionItemDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getTermini() == null ? other.getTermini() == null : this.getTermini().equals(other.getTermini()))
            && (this.getActionExpr() == null ? other.getActionExpr() == null : this.getActionExpr().equals(other.getActionExpr()))
            && (this.getAlg() == null ? other.getAlg() == null : this.getAlg().equals(other.getAlg()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getActionStrategyId() == null ? other.getActionStrategyId() == null : this.getActionStrategyId().equals(other.getActionStrategyId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getSerialExpr() == null ? other.getSerialExpr() == null : this.getSerialExpr().equals(other.getSerialExpr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getTermini() == null) ? 0 : getTermini().hashCode());
        result = prime * result + ((getActionExpr() == null) ? 0 : getActionExpr().hashCode());
        result = prime * result + ((getAlg() == null) ? 0 : getAlg().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getActionStrategyId() == null) ? 0 : getActionStrategyId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getSerialExpr() == null) ? 0 : getSerialExpr().hashCode());
        return result;
    }
}