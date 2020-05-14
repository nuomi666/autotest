package dal.model.gas_marketpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserGroupDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserGroupDOExample() {
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

        public Criteria andPlatPartnerIdIsNull() {
            addCriterion("plat_partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdIsNotNull() {
            addCriterion("plat_partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdEqualTo(String value) {
            addCriterion("plat_partner_id =", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotEqualTo(String value) {
            addCriterion("plat_partner_id <>", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdGreaterThan(String value) {
            addCriterion("plat_partner_id >", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("plat_partner_id >=", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdLessThan(String value) {
            addCriterion("plat_partner_id <", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("plat_partner_id <=", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdLike(String value) {
            addCriterion("plat_partner_id like", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotLike(String value) {
            addCriterion("plat_partner_id not like", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdIn(List<String> values) {
            addCriterion("plat_partner_id in", values, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotIn(List<String> values) {
            addCriterion("plat_partner_id not in", values, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdBetween(String value1, String value2) {
            addCriterion("plat_partner_id between", value1, value2, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotBetween(String value1, String value2) {
            addCriterion("plat_partner_id not between", value1, value2, "platPartnerId");
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

        public Criteria andUserGroupTypeIsNull() {
            addCriterion("user_group_type is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeIsNotNull() {
            addCriterion("user_group_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeEqualTo(String value) {
            addCriterion("user_group_type =", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeNotEqualTo(String value) {
            addCriterion("user_group_type <>", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeGreaterThan(String value) {
            addCriterion("user_group_type >", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_group_type >=", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeLessThan(String value) {
            addCriterion("user_group_type <", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeLessThanOrEqualTo(String value) {
            addCriterion("user_group_type <=", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeLike(String value) {
            addCriterion("user_group_type like", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeNotLike(String value) {
            addCriterion("user_group_type not like", value, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeIn(List<String> values) {
            addCriterion("user_group_type in", values, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeNotIn(List<String> values) {
            addCriterion("user_group_type not in", values, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeBetween(String value1, String value2) {
            addCriterion("user_group_type between", value1, value2, "userGroupType");
            return (Criteria) this;
        }

        public Criteria andUserGroupTypeNotBetween(String value1, String value2) {
            addCriterion("user_group_type not between", value1, value2, "userGroupType");
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

        public Criteria andTotalListIsNull() {
            addCriterion("total_list is null");
            return (Criteria) this;
        }

        public Criteria andTotalListIsNotNull() {
            addCriterion("total_list is not null");
            return (Criteria) this;
        }

        public Criteria andTotalListEqualTo(Integer value) {
            addCriterion("total_list =", value, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListNotEqualTo(Integer value) {
            addCriterion("total_list <>", value, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListGreaterThan(Integer value) {
            addCriterion("total_list >", value, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_list >=", value, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListLessThan(Integer value) {
            addCriterion("total_list <", value, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListLessThanOrEqualTo(Integer value) {
            addCriterion("total_list <=", value, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListIn(List<Integer> values) {
            addCriterion("total_list in", values, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListNotIn(List<Integer> values) {
            addCriterion("total_list not in", values, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListBetween(Integer value1, Integer value2) {
            addCriterion("total_list between", value1, value2, "totalList");
            return (Criteria) this;
        }

        public Criteria andTotalListNotBetween(Integer value1, Integer value2) {
            addCriterion("total_list not between", value1, value2, "totalList");
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