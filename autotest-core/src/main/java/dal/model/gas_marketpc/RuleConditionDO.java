package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "rule_condition")
public class RuleConditionDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 规则编码
     */
    @Column(name = "rule_code")
    private String ruleCode;

    /**
     * 条件左值
     */
    @Column(name = "left_value")
    private String leftValue;

    /**
     * 比较器
     */
    private String comparator;

    /**
     * 条件右值
     */
    @Column(name = "right_value")
    private String rightValue;

    /**
     * 类型：统计类和非统计类
     */
    private String type;

    /**
     * 规则内容
     */
    private String script;

    /**
     * 环境上下文(预留字段)
     */
    private String context;

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
     * 获取规则编码
     *
     * @return rule_code - 规则编码
     */
    public String getRuleCode() {
        return ruleCode;
    }

    /**
     * 设置规则编码
     *
     * @param ruleCode 规则编码
     */
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode == null ? null : ruleCode.trim();
    }

    /**
     * 获取条件左值
     *
     * @return left_value - 条件左值
     */
    public String getLeftValue() {
        return leftValue;
    }

    /**
     * 设置条件左值
     *
     * @param leftValue 条件左值
     */
    public void setLeftValue(String leftValue) {
        this.leftValue = leftValue == null ? null : leftValue.trim();
    }

    /**
     * 获取比较器
     *
     * @return comparator - 比较器
     */
    public String getComparator() {
        return comparator;
    }

    /**
     * 设置比较器
     *
     * @param comparator 比较器
     */
    public void setComparator(String comparator) {
        this.comparator = comparator == null ? null : comparator.trim();
    }

    /**
     * 获取条件右值
     *
     * @return right_value - 条件右值
     */
    public String getRightValue() {
        return rightValue;
    }

    /**
     * 设置条件右值
     *
     * @param rightValue 条件右值
     */
    public void setRightValue(String rightValue) {
        this.rightValue = rightValue == null ? null : rightValue.trim();
    }

    /**
     * 获取类型：统计类和非统计类
     *
     * @return type - 类型：统计类和非统计类
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型：统计类和非统计类
     *
     * @param type 类型：统计类和非统计类
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取规则内容
     *
     * @return script - 规则内容
     */
    public String getScript() {
        return script;
    }

    /**
     * 设置规则内容
     *
     * @param script 规则内容
     */
    public void setScript(String script) {
        this.script = script == null ? null : script.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", ruleCode=").append(ruleCode);
        sb.append(", leftValue=").append(leftValue);
        sb.append(", comparator=").append(comparator);
        sb.append(", rightValue=").append(rightValue);
        sb.append(", type=").append(type);
        sb.append(", script=").append(script);
        sb.append(", context=").append(context);
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
        RuleConditionDO other = (RuleConditionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRuleCode() == null ? other.getRuleCode() == null : this.getRuleCode().equals(other.getRuleCode()))
            && (this.getLeftValue() == null ? other.getLeftValue() == null : this.getLeftValue().equals(other.getLeftValue()))
            && (this.getComparator() == null ? other.getComparator() == null : this.getComparator().equals(other.getComparator()))
            && (this.getRightValue() == null ? other.getRightValue() == null : this.getRightValue().equals(other.getRightValue()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getScript() == null ? other.getScript() == null : this.getScript().equals(other.getScript()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRuleCode() == null) ? 0 : getRuleCode().hashCode());
        result = prime * result + ((getLeftValue() == null) ? 0 : getLeftValue().hashCode());
        result = prime * result + ((getComparator() == null) ? 0 : getComparator().hashCode());
        result = prime * result + ((getRightValue() == null) ? 0 : getRightValue().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getScript() == null) ? 0 : getScript().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}