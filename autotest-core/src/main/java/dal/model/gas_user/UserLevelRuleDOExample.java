package dal.model.gas_user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLevelRuleDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLevelRuleDOExample() {
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

        public Criteria andUseTimeUnitIsNull() {
            addCriterion("use_time_unit is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitIsNotNull() {
            addCriterion("use_time_unit is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitEqualTo(String value) {
            addCriterion("use_time_unit =", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotEqualTo(String value) {
            addCriterion("use_time_unit <>", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitGreaterThan(String value) {
            addCriterion("use_time_unit >", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitGreaterThanOrEqualTo(String value) {
            addCriterion("use_time_unit >=", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitLessThan(String value) {
            addCriterion("use_time_unit <", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitLessThanOrEqualTo(String value) {
            addCriterion("use_time_unit <=", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitLike(String value) {
            addCriterion("use_time_unit like", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotLike(String value) {
            addCriterion("use_time_unit not like", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitIn(List<String> values) {
            addCriterion("use_time_unit in", values, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotIn(List<String> values) {
            addCriterion("use_time_unit not in", values, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitBetween(String value1, String value2) {
            addCriterion("use_time_unit between", value1, value2, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotBetween(String value1, String value2) {
            addCriterion("use_time_unit not between", value1, value2, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeIsNull() {
            addCriterion("level_update_type is null");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeIsNotNull() {
            addCriterion("level_update_type is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeEqualTo(String value) {
            addCriterion("level_update_type =", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeNotEqualTo(String value) {
            addCriterion("level_update_type <>", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeGreaterThan(String value) {
            addCriterion("level_update_type >", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("level_update_type >=", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeLessThan(String value) {
            addCriterion("level_update_type <", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeLessThanOrEqualTo(String value) {
            addCriterion("level_update_type <=", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeLike(String value) {
            addCriterion("level_update_type like", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeNotLike(String value) {
            addCriterion("level_update_type not like", value, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeIn(List<String> values) {
            addCriterion("level_update_type in", values, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeNotIn(List<String> values) {
            addCriterion("level_update_type not in", values, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeBetween(String value1, String value2) {
            addCriterion("level_update_type between", value1, value2, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andLevelUpdateTypeNotBetween(String value1, String value2) {
            addCriterion("level_update_type not between", value1, value2, "levelUpdateType");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(String value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(String value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(String value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(String value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(String value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(String value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLike(String value) {
            addCriterion("days like", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotLike(String value) {
            addCriterion("days not like", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<String> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<String> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(String value1, String value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(String value1, String value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andLevelRuleIsNull() {
            addCriterion("level_rule is null");
            return (Criteria) this;
        }

        public Criteria andLevelRuleIsNotNull() {
            addCriterion("level_rule is not null");
            return (Criteria) this;
        }

        public Criteria andLevelRuleEqualTo(String value) {
            addCriterion("level_rule =", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleNotEqualTo(String value) {
            addCriterion("level_rule <>", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleGreaterThan(String value) {
            addCriterion("level_rule >", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleGreaterThanOrEqualTo(String value) {
            addCriterion("level_rule >=", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleLessThan(String value) {
            addCriterion("level_rule <", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleLessThanOrEqualTo(String value) {
            addCriterion("level_rule <=", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleLike(String value) {
            addCriterion("level_rule like", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleNotLike(String value) {
            addCriterion("level_rule not like", value, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleIn(List<String> values) {
            addCriterion("level_rule in", values, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleNotIn(List<String> values) {
            addCriterion("level_rule not in", values, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleBetween(String value1, String value2) {
            addCriterion("level_rule between", value1, value2, "levelRule");
            return (Criteria) this;
        }

        public Criteria andLevelRuleNotBetween(String value1, String value2) {
            addCriterion("level_rule not between", value1, value2, "levelRule");
            return (Criteria) this;
        }

        public Criteria andCornIsNull() {
            addCriterion("corn is null");
            return (Criteria) this;
        }

        public Criteria andCornIsNotNull() {
            addCriterion("corn is not null");
            return (Criteria) this;
        }

        public Criteria andCornEqualTo(String value) {
            addCriterion("corn =", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornNotEqualTo(String value) {
            addCriterion("corn <>", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornGreaterThan(String value) {
            addCriterion("corn >", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornGreaterThanOrEqualTo(String value) {
            addCriterion("corn >=", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornLessThan(String value) {
            addCriterion("corn <", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornLessThanOrEqualTo(String value) {
            addCriterion("corn <=", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornLike(String value) {
            addCriterion("corn like", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornNotLike(String value) {
            addCriterion("corn not like", value, "corn");
            return (Criteria) this;
        }

        public Criteria andCornIn(List<String> values) {
            addCriterion("corn in", values, "corn");
            return (Criteria) this;
        }

        public Criteria andCornNotIn(List<String> values) {
            addCriterion("corn not in", values, "corn");
            return (Criteria) this;
        }

        public Criteria andCornBetween(String value1, String value2) {
            addCriterion("corn between", value1, value2, "corn");
            return (Criteria) this;
        }

        public Criteria andCornNotBetween(String value1, String value2) {
            addCriterion("corn not between", value1, value2, "corn");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysIsNull() {
            addCriterion("cumulative_of_days is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysIsNotNull() {
            addCriterion("cumulative_of_days is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysEqualTo(Integer value) {
            addCriterion("cumulative_of_days =", value, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysNotEqualTo(Integer value) {
            addCriterion("cumulative_of_days <>", value, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysGreaterThan(Integer value) {
            addCriterion("cumulative_of_days >", value, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("cumulative_of_days >=", value, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysLessThan(Integer value) {
            addCriterion("cumulative_of_days <", value, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysLessThanOrEqualTo(Integer value) {
            addCriterion("cumulative_of_days <=", value, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysIn(List<Integer> values) {
            addCriterion("cumulative_of_days in", values, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysNotIn(List<Integer> values) {
            addCriterion("cumulative_of_days not in", values, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysBetween(Integer value1, Integer value2) {
            addCriterion("cumulative_of_days between", value1, value2, "cumulativeOfDays");
            return (Criteria) this;
        }

        public Criteria andCumulativeOfDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("cumulative_of_days not between", value1, value2, "cumulativeOfDays");
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