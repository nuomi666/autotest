package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WashPreciseGiveDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WashPreciseGiveDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCampaignNoIsNull() {
            addCriterion("campaign_no is null");
            return (Criteria) this;
        }

        public Criteria andCampaignNoIsNotNull() {
            addCriterion("campaign_no is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignNoEqualTo(String value) {
            addCriterion("campaign_no =", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotEqualTo(String value) {
            addCriterion("campaign_no <>", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoGreaterThan(String value) {
            addCriterion("campaign_no >", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_no >=", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLessThan(String value) {
            addCriterion("campaign_no <", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLessThanOrEqualTo(String value) {
            addCriterion("campaign_no <=", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLike(String value) {
            addCriterion("campaign_no like", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotLike(String value) {
            addCriterion("campaign_no not like", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoIn(List<String> values) {
            addCriterion("campaign_no in", values, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotIn(List<String> values) {
            addCriterion("campaign_no not in", values, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoBetween(String value1, String value2) {
            addCriterion("campaign_no between", value1, value2, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotBetween(String value1, String value2) {
            addCriterion("campaign_no not between", value1, value2, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNull() {
            addCriterion("partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNotNull() {
            addCriterion("partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdEqualTo(String value) {
            addCriterion("partner_id =", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotEqualTo(String value) {
            addCriterion("partner_id <>", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThan(String value) {
            addCriterion("partner_id >", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("partner_id >=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThan(String value) {
            addCriterion("partner_id <", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("partner_id <=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLike(String value) {
            addCriterion("partner_id like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotLike(String value) {
            addCriterion("partner_id not like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIn(List<String> values) {
            addCriterion("partner_id in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotIn(List<String> values) {
            addCriterion("partner_id not in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdBetween(String value1, String value2) {
            addCriterion("partner_id between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotBetween(String value1, String value2) {
            addCriterion("partner_id not between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIsNull() {
            addCriterion("filter_type is null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIsNotNull() {
            addCriterion("filter_type is not null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeEqualTo(String value) {
            addCriterion("filter_type =", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotEqualTo(String value) {
            addCriterion("filter_type <>", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThan(String value) {
            addCriterion("filter_type >", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("filter_type >=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThan(String value) {
            addCriterion("filter_type <", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThanOrEqualTo(String value) {
            addCriterion("filter_type <=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLike(String value) {
            addCriterion("filter_type like", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotLike(String value) {
            addCriterion("filter_type not like", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIn(List<String> values) {
            addCriterion("filter_type in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotIn(List<String> values) {
            addCriterion("filter_type not in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeBetween(String value1, String value2) {
            addCriterion("filter_type between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotBetween(String value1, String value2) {
            addCriterion("filter_type not between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterRuleIsNull() {
            addCriterion("filter_rule is null");
            return (Criteria) this;
        }

        public Criteria andFilterRuleIsNotNull() {
            addCriterion("filter_rule is not null");
            return (Criteria) this;
        }

        public Criteria andFilterRuleEqualTo(String value) {
            addCriterion("filter_rule =", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotEqualTo(String value) {
            addCriterion("filter_rule <>", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleGreaterThan(String value) {
            addCriterion("filter_rule >", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleGreaterThanOrEqualTo(String value) {
            addCriterion("filter_rule >=", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleLessThan(String value) {
            addCriterion("filter_rule <", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleLessThanOrEqualTo(String value) {
            addCriterion("filter_rule <=", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleLike(String value) {
            addCriterion("filter_rule like", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotLike(String value) {
            addCriterion("filter_rule not like", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleIn(List<String> values) {
            addCriterion("filter_rule in", values, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotIn(List<String> values) {
            addCriterion("filter_rule not in", values, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleBetween(String value1, String value2) {
            addCriterion("filter_rule between", value1, value2, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotBetween(String value1, String value2) {
            addCriterion("filter_rule not between", value1, value2, "filterRule");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoIsNull() {
            addCriterion("user_group_no is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoIsNotNull() {
            addCriterion("user_group_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoEqualTo(String value) {
            addCriterion("user_group_no =", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotEqualTo(String value) {
            addCriterion("user_group_no <>", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoGreaterThan(String value) {
            addCriterion("user_group_no >", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_group_no >=", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoLessThan(String value) {
            addCriterion("user_group_no <", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoLessThanOrEqualTo(String value) {
            addCriterion("user_group_no <=", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoLike(String value) {
            addCriterion("user_group_no like", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotLike(String value) {
            addCriterion("user_group_no not like", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoIn(List<String> values) {
            addCriterion("user_group_no in", values, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotIn(List<String> values) {
            addCriterion("user_group_no not in", values, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoBetween(String value1, String value2) {
            addCriterion("user_group_no between", value1, value2, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotBetween(String value1, String value2) {
            addCriterion("user_group_no not between", value1, value2, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andHandleRulesIsNull() {
            addCriterion("handle_rules is null");
            return (Criteria) this;
        }

        public Criteria andHandleRulesIsNotNull() {
            addCriterion("handle_rules is not null");
            return (Criteria) this;
        }

        public Criteria andHandleRulesEqualTo(String value) {
            addCriterion("handle_rules =", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesNotEqualTo(String value) {
            addCriterion("handle_rules <>", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesGreaterThan(String value) {
            addCriterion("handle_rules >", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesGreaterThanOrEqualTo(String value) {
            addCriterion("handle_rules >=", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesLessThan(String value) {
            addCriterion("handle_rules <", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesLessThanOrEqualTo(String value) {
            addCriterion("handle_rules <=", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesLike(String value) {
            addCriterion("handle_rules like", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesNotLike(String value) {
            addCriterion("handle_rules not like", value, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesIn(List<String> values) {
            addCriterion("handle_rules in", values, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesNotIn(List<String> values) {
            addCriterion("handle_rules not in", values, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesBetween(String value1, String value2) {
            addCriterion("handle_rules between", value1, value2, "handleRules");
            return (Criteria) this;
        }

        public Criteria andHandleRulesNotBetween(String value1, String value2) {
            addCriterion("handle_rules not between", value1, value2, "handleRules");
            return (Criteria) this;
        }

        public Criteria andGiveTimeIsNull() {
            addCriterion("give_time is null");
            return (Criteria) this;
        }

        public Criteria andGiveTimeIsNotNull() {
            addCriterion("give_time is not null");
            return (Criteria) this;
        }

        public Criteria andGiveTimeEqualTo(Date value) {
            addCriterion("give_time =", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeNotEqualTo(Date value) {
            addCriterion("give_time <>", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeGreaterThan(Date value) {
            addCriterion("give_time >", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("give_time >=", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeLessThan(Date value) {
            addCriterion("give_time <", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("give_time <=", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeIn(List<Date> values) {
            addCriterion("give_time in", values, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeNotIn(List<Date> values) {
            addCriterion("give_time not in", values, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeBetween(Date value1, Date value2) {
            addCriterion("give_time between", value1, value2, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("give_time not between", value1, value2, "giveTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeIsNull() {
            addCriterion("rule_set_code is null");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeIsNotNull() {
            addCriterion("rule_set_code is not null");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeEqualTo(String value) {
            addCriterion("rule_set_code =", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotEqualTo(String value) {
            addCriterion("rule_set_code <>", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeGreaterThan(String value) {
            addCriterion("rule_set_code >", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_set_code >=", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeLessThan(String value) {
            addCriterion("rule_set_code <", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeLessThanOrEqualTo(String value) {
            addCriterion("rule_set_code <=", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeLike(String value) {
            addCriterion("rule_set_code like", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotLike(String value) {
            addCriterion("rule_set_code not like", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeIn(List<String> values) {
            addCriterion("rule_set_code in", values, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotIn(List<String> values) {
            addCriterion("rule_set_code not in", values, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeBetween(String value1, String value2) {
            addCriterion("rule_set_code between", value1, value2, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotBetween(String value1, String value2) {
            addCriterion("rule_set_code not between", value1, value2, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeIsNull() {
            addCriterion("raw_add_time is null");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeIsNotNull() {
            addCriterion("raw_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeEqualTo(Date value) {
            addCriterion("raw_add_time =", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeNotEqualTo(Date value) {
            addCriterion("raw_add_time <>", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeGreaterThan(Date value) {
            addCriterion("raw_add_time >", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("raw_add_time >=", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeLessThan(Date value) {
            addCriterion("raw_add_time <", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("raw_add_time <=", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeIn(List<Date> values) {
            addCriterion("raw_add_time in", values, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeNotIn(List<Date> values) {
            addCriterion("raw_add_time not in", values, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeBetween(Date value1, Date value2) {
            addCriterion("raw_add_time between", value1, value2, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("raw_add_time not between", value1, value2, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeIsNull() {
            addCriterion("raw_update_time is null");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeIsNotNull() {
            addCriterion("raw_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeEqualTo(Date value) {
            addCriterion("raw_update_time =", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeNotEqualTo(Date value) {
            addCriterion("raw_update_time <>", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeGreaterThan(Date value) {
            addCriterion("raw_update_time >", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("raw_update_time >=", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeLessThan(Date value) {
            addCriterion("raw_update_time <", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("raw_update_time <=", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeIn(List<Date> values) {
            addCriterion("raw_update_time in", values, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeNotIn(List<Date> values) {
            addCriterion("raw_update_time not in", values, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("raw_update_time between", value1, value2, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("raw_update_time not between", value1, value2, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonaIdIsNull() {
            addCriterion("persona_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonaIdIsNotNull() {
            addCriterion("persona_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonaIdEqualTo(Long value) {
            addCriterion("persona_id =", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdNotEqualTo(Long value) {
            addCriterion("persona_id <>", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdGreaterThan(Long value) {
            addCriterion("persona_id >", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("persona_id >=", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdLessThan(Long value) {
            addCriterion("persona_id <", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdLessThanOrEqualTo(Long value) {
            addCriterion("persona_id <=", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdIn(List<Long> values) {
            addCriterion("persona_id in", values, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdNotIn(List<Long> values) {
            addCriterion("persona_id not in", values, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdBetween(Long value1, Long value2) {
            addCriterion("persona_id between", value1, value2, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdNotBetween(Long value1, Long value2) {
            addCriterion("persona_id not between", value1, value2, "personaId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}