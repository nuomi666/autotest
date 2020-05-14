package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "precise_give")
public class PreciseGiveDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动编号
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 筛选方式
     */
    @Column(name = "filter_type")
    private String filterType;

    /**
     * 筛选条件
     */
    @Column(name = "filter_rule")
    private String filterRule;

    /**
     * 会员分组编号
     */
    @Column(name = "user_group_no")
    private String userGroupNo;

    /**
     * 执行规则
     */
    @Column(name = "handle_rules")
    private String handleRules;

    /**
     * 赠送时间
     */
    @Column(name = "give_time")
    private Date giveTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String memo;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 精准投放规则集编码
     */
    @Column(name = "rule_set_code")
    private String ruleSetCode;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 会员模型ID
     */
    @Column(name = "persona_id")
    private Long personaId;

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
     * 获取活动编号
     *
     * @return campaign_no - 活动编号
     */
    public String getCampaignNo() {
        return campaignNo;
    }

    /**
     * 设置活动编号
     *
     * @param campaignNo 活动编号
     */
    public void setCampaignNo(String campaignNo) {
        this.campaignNo = campaignNo == null ? null : campaignNo.trim();
    }

    /**
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商ID
     *
     * @return plat_partner_id - 平台商ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商ID
     *
     * @param platPartnerId 平台商ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取筛选方式
     *
     * @return filter_type - 筛选方式
     */
    public String getFilterType() {
        return filterType;
    }

    /**
     * 设置筛选方式
     *
     * @param filterType 筛选方式
     */
    public void setFilterType(String filterType) {
        this.filterType = filterType == null ? null : filterType.trim();
    }

    /**
     * 获取筛选条件
     *
     * @return filter_rule - 筛选条件
     */
    public String getFilterRule() {
        return filterRule;
    }

    /**
     * 设置筛选条件
     *
     * @param filterRule 筛选条件
     */
    public void setFilterRule(String filterRule) {
        this.filterRule = filterRule == null ? null : filterRule.trim();
    }

    /**
     * 获取会员分组编号
     *
     * @return user_group_no - 会员分组编号
     */
    public String getUserGroupNo() {
        return userGroupNo;
    }

    /**
     * 设置会员分组编号
     *
     * @param userGroupNo 会员分组编号
     */
    public void setUserGroupNo(String userGroupNo) {
        this.userGroupNo = userGroupNo == null ? null : userGroupNo.trim();
    }

    /**
     * 获取执行规则
     *
     * @return handle_rules - 执行规则
     */
    public String getHandleRules() {
        return handleRules;
    }

    /**
     * 设置执行规则
     *
     * @param handleRules 执行规则
     */
    public void setHandleRules(String handleRules) {
        this.handleRules = handleRules == null ? null : handleRules.trim();
    }

    /**
     * 获取赠送时间
     *
     * @return give_time - 赠送时间
     */
    public Date getGiveTime() {
        return giveTime;
    }

    /**
     * 设置赠送时间
     *
     * @param giveTime 赠送时间
     */
    public void setGiveTime(Date giveTime) {
        this.giveTime = giveTime;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取操作员
     *
     * @return operator - 操作员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作员
     *
     * @param operator 操作员
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取精准投放规则集编码
     *
     * @return rule_set_code - 精准投放规则集编码
     */
    public String getRuleSetCode() {
        return ruleSetCode;
    }

    /**
     * 设置精准投放规则集编码
     *
     * @param ruleSetCode 精准投放规则集编码
     */
    public void setRuleSetCode(String ruleSetCode) {
        this.ruleSetCode = ruleSetCode == null ? null : ruleSetCode.trim();
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

    /**
     * 获取会员模型ID
     *
     * @return persona_id - 会员模型ID
     */
    public Long getPersonaId() {
        return personaId;
    }

    /**
     * 设置会员模型ID
     *
     * @param personaId 会员模型ID
     */
    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", name=").append(name);
        sb.append(", filterType=").append(filterType);
        sb.append(", filterRule=").append(filterRule);
        sb.append(", userGroupNo=").append(userGroupNo);
        sb.append(", handleRules=").append(handleRules);
        sb.append(", giveTime=").append(giveTime);
        sb.append(", status=").append(status);
        sb.append(", memo=").append(memo);
        sb.append(", operator=").append(operator);
        sb.append(", ruleSetCode=").append(ruleSetCode);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", personaId=").append(personaId);
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
        PreciseGiveDO other = (PreciseGiveDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFilterType() == null ? other.getFilterType() == null : this.getFilterType().equals(other.getFilterType()))
            && (this.getFilterRule() == null ? other.getFilterRule() == null : this.getFilterRule().equals(other.getFilterRule()))
            && (this.getUserGroupNo() == null ? other.getUserGroupNo() == null : this.getUserGroupNo().equals(other.getUserGroupNo()))
            && (this.getHandleRules() == null ? other.getHandleRules() == null : this.getHandleRules().equals(other.getHandleRules()))
            && (this.getGiveTime() == null ? other.getGiveTime() == null : this.getGiveTime().equals(other.getGiveTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getRuleSetCode() == null ? other.getRuleSetCode() == null : this.getRuleSetCode().equals(other.getRuleSetCode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getPersonaId() == null ? other.getPersonaId() == null : this.getPersonaId().equals(other.getPersonaId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFilterType() == null) ? 0 : getFilterType().hashCode());
        result = prime * result + ((getFilterRule() == null) ? 0 : getFilterRule().hashCode());
        result = prime * result + ((getUserGroupNo() == null) ? 0 : getUserGroupNo().hashCode());
        result = prime * result + ((getHandleRules() == null) ? 0 : getHandleRules().hashCode());
        result = prime * result + ((getGiveTime() == null) ? 0 : getGiveTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getRuleSetCode() == null) ? 0 : getRuleSetCode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getPersonaId() == null) ? 0 : getPersonaId().hashCode());
        return result;
    }
}