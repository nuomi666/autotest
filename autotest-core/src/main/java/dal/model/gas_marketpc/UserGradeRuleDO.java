package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_grade_rule")
public class UserGradeRuleDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 会员评级规则编码
     */
    @Column(name = "rule_set_code")
    private String ruleSetCode;

    /**
     * 统计周期（月）
     */
    private Integer months;

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
     * 获取会员评级规则编码
     *
     * @return rule_set_code - 会员评级规则编码
     */
    public String getRuleSetCode() {
        return ruleSetCode;
    }

    /**
     * 设置会员评级规则编码
     *
     * @param ruleSetCode 会员评级规则编码
     */
    public void setRuleSetCode(String ruleSetCode) {
        this.ruleSetCode = ruleSetCode == null ? null : ruleSetCode.trim();
    }

    /**
     * 获取统计周期（月）
     *
     * @return months - 统计周期（月）
     */
    public Integer getMonths() {
        return months;
    }

    /**
     * 设置统计周期（月）
     *
     * @param months 统计周期（月）
     */
    public void setMonths(Integer months) {
        this.months = months;
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
        sb.append(", ruleSetCode=").append(ruleSetCode);
        sb.append(", months=").append(months);
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
        UserGradeRuleDO other = (UserGradeRuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getRuleSetCode() == null ? other.getRuleSetCode() == null : this.getRuleSetCode().equals(other.getRuleSetCode()))
            && (this.getMonths() == null ? other.getMonths() == null : this.getMonths().equals(other.getMonths()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getRuleSetCode() == null) ? 0 : getRuleSetCode().hashCode());
        result = prime * result + ((getMonths() == null) ? 0 : getMonths().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}