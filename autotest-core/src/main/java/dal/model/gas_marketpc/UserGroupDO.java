package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_group")
public class UserGroupDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分组编号
     */
    @Column(name = "user_group_no")
    private String userGroupNo;

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
     * 分组名称
     */
    private String name;

    /**
     * 分组类型
     */
    @Column(name = "user_group_type")
    private String userGroupType;

    /**
     * 筛选条件
     */
    @Column(name = "filter_rule")
    private String filterRule;

    /**
     * 组内名单数
     */
    @Column(name = "total_list")
    private Integer totalList;

    /**
     * 备注
     */
    private String memo;

    /**
     * 分组筛选规则集编码
     */
    @Column(name = "rule_set_code")
    private String ruleSetCode;

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
     * 获取分组编号
     *
     * @return user_group_no - 分组编号
     */
    public String getUserGroupNo() {
        return userGroupNo;
    }

    /**
     * 设置分组编号
     *
     * @param userGroupNo 分组编号
     */
    public void setUserGroupNo(String userGroupNo) {
        this.userGroupNo = userGroupNo == null ? null : userGroupNo.trim();
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
     * 获取分组名称
     *
     * @return name - 分组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分组名称
     *
     * @param name 分组名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取分组类型
     *
     * @return user_group_type - 分组类型
     */
    public String getUserGroupType() {
        return userGroupType;
    }

    /**
     * 设置分组类型
     *
     * @param userGroupType 分组类型
     */
    public void setUserGroupType(String userGroupType) {
        this.userGroupType = userGroupType == null ? null : userGroupType.trim();
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
     * 获取组内名单数
     *
     * @return total_list - 组内名单数
     */
    public Integer getTotalList() {
        return totalList;
    }

    /**
     * 设置组内名单数
     *
     * @param totalList 组内名单数
     */
    public void setTotalList(Integer totalList) {
        this.totalList = totalList;
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
     * 获取分组筛选规则集编码
     *
     * @return rule_set_code - 分组筛选规则集编码
     */
    public String getRuleSetCode() {
        return ruleSetCode;
    }

    /**
     * 设置分组筛选规则集编码
     *
     * @param ruleSetCode 分组筛选规则集编码
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", userGroupNo=").append(userGroupNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", name=").append(name);
        sb.append(", userGroupType=").append(userGroupType);
        sb.append(", filterRule=").append(filterRule);
        sb.append(", totalList=").append(totalList);
        sb.append(", memo=").append(memo);
        sb.append(", ruleSetCode=").append(ruleSetCode);
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
        UserGroupDO other = (UserGroupDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserGroupNo() == null ? other.getUserGroupNo() == null : this.getUserGroupNo().equals(other.getUserGroupNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUserGroupType() == null ? other.getUserGroupType() == null : this.getUserGroupType().equals(other.getUserGroupType()))
            && (this.getFilterRule() == null ? other.getFilterRule() == null : this.getFilterRule().equals(other.getFilterRule()))
            && (this.getTotalList() == null ? other.getTotalList() == null : this.getTotalList().equals(other.getTotalList()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRuleSetCode() == null ? other.getRuleSetCode() == null : this.getRuleSetCode().equals(other.getRuleSetCode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserGroupNo() == null) ? 0 : getUserGroupNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUserGroupType() == null) ? 0 : getUserGroupType().hashCode());
        result = prime * result + ((getFilterRule() == null) ? 0 : getFilterRule().hashCode());
        result = prime * result + ((getTotalList() == null) ? 0 : getTotalList().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRuleSetCode() == null) ? 0 : getRuleSetCode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}