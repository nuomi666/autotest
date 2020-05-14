package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "rule")
public class RuleDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 规则名字
     */
    @Column(name = "rule_name")
    private String ruleName;

    /**
     * 规则编码
     */
    @Column(name = "rule_code")
    private String ruleCode;

    /**
     * 规则集编码
     */
    @Column(name = "rule_set_code")
    private String ruleSetCode;

    /**
     * 规则分组
     */
    @Column(name = "rule_group")
    private String ruleGroup;

    /**
     * 执行优先级
     */
    private Integer priority;

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
     * 获取规则名字
     *
     * @return rule_name - 规则名字
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * 设置规则名字
     *
     * @param ruleName 规则名字
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
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
     * 获取规则集编码
     *
     * @return rule_set_code - 规则集编码
     */
    public String getRuleSetCode() {
        return ruleSetCode;
    }

    /**
     * 设置规则集编码
     *
     * @param ruleSetCode 规则集编码
     */
    public void setRuleSetCode(String ruleSetCode) {
        this.ruleSetCode = ruleSetCode == null ? null : ruleSetCode.trim();
    }

    /**
     * 获取规则分组
     *
     * @return rule_group - 规则分组
     */
    public String getRuleGroup() {
        return ruleGroup;
    }

    /**
     * 设置规则分组
     *
     * @param ruleGroup 规则分组
     */
    public void setRuleGroup(String ruleGroup) {
        this.ruleGroup = ruleGroup == null ? null : ruleGroup.trim();
    }

    /**
     * 获取执行优先级
     *
     * @return priority - 执行优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置执行优先级
     *
     * @param priority 执行优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
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
        sb.append(", ruleName=").append(ruleName);
        sb.append(", ruleCode=").append(ruleCode);
        sb.append(", ruleSetCode=").append(ruleSetCode);
        sb.append(", ruleGroup=").append(ruleGroup);
        sb.append(", priority=").append(priority);
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
        RuleDO other = (RuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
            && (this.getRuleCode() == null ? other.getRuleCode() == null : this.getRuleCode().equals(other.getRuleCode()))
            && (this.getRuleSetCode() == null ? other.getRuleSetCode() == null : this.getRuleSetCode().equals(other.getRuleSetCode()))
            && (this.getRuleGroup() == null ? other.getRuleGroup() == null : this.getRuleGroup().equals(other.getRuleGroup()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
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
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getRuleCode() == null) ? 0 : getRuleCode().hashCode());
        result = prime * result + ((getRuleSetCode() == null) ? 0 : getRuleSetCode().hashCode());
        result = prime * result + ((getRuleGroup() == null) ? 0 : getRuleGroup().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getScript() == null) ? 0 : getScript().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}