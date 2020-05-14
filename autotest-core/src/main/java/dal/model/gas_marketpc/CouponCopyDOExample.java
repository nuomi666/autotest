package dal.model.gas_marketpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponCopyDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponCopyDOExample() {
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

        public Criteria andDefinitionIdIsNull() {
            addCriterion("definition_id is null");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdIsNotNull() {
            addCriterion("definition_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdEqualTo(String value) {
            addCriterion("definition_id =", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotEqualTo(String value) {
            addCriterion("definition_id <>", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdGreaterThan(String value) {
            addCriterion("definition_id >", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("definition_id >=", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdLessThan(String value) {
            addCriterion("definition_id <", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdLessThanOrEqualTo(String value) {
            addCriterion("definition_id <=", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdLike(String value) {
            addCriterion("definition_id like", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotLike(String value) {
            addCriterion("definition_id not like", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdIn(List<String> values) {
            addCriterion("definition_id in", values, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotIn(List<String> values) {
            addCriterion("definition_id not in", values, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdBetween(String value1, String value2) {
            addCriterion("definition_id between", value1, value2, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotBetween(String value1, String value2) {
            addCriterion("definition_id not between", value1, value2, "definitionId");
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

        public Criteria andCouponNameIsNull() {
            addCriterion("coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNotNull() {
            addCriterion("coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNameEqualTo(String value) {
            addCriterion("coupon_name =", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotEqualTo(String value) {
            addCriterion("coupon_name <>", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThan(String value) {
            addCriterion("coupon_name >", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_name >=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThan(String value) {
            addCriterion("coupon_name <", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThanOrEqualTo(String value) {
            addCriterion("coupon_name <=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLike(String value) {
            addCriterion("coupon_name like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotLike(String value) {
            addCriterion("coupon_name not like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameIn(List<String> values) {
            addCriterion("coupon_name in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotIn(List<String> values) {
            addCriterion("coupon_name not in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameBetween(String value1, String value2) {
            addCriterion("coupon_name between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotBetween(String value1, String value2) {
            addCriterion("coupon_name not between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeIsNull() {
            addCriterion("coupon_biz_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeIsNotNull() {
            addCriterion("coupon_biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeEqualTo(String value) {
            addCriterion("coupon_biz_type =", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeNotEqualTo(String value) {
            addCriterion("coupon_biz_type <>", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeGreaterThan(String value) {
            addCriterion("coupon_biz_type >", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_biz_type >=", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeLessThan(String value) {
            addCriterion("coupon_biz_type <", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeLessThanOrEqualTo(String value) {
            addCriterion("coupon_biz_type <=", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeLike(String value) {
            addCriterion("coupon_biz_type like", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeNotLike(String value) {
            addCriterion("coupon_biz_type not like", value, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeIn(List<String> values) {
            addCriterion("coupon_biz_type in", values, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeNotIn(List<String> values) {
            addCriterion("coupon_biz_type not in", values, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeBetween(String value1, String value2) {
            addCriterion("coupon_biz_type between", value1, value2, "couponBizType");
            return (Criteria) this;
        }

        public Criteria andCouponBizTypeNotBetween(String value1, String value2) {
            addCriterion("coupon_biz_type not between", value1, value2, "couponBizType");
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

        public Criteria andMaxUseIsNull() {
            addCriterion("max_use is null");
            return (Criteria) this;
        }

        public Criteria andMaxUseIsNotNull() {
            addCriterion("max_use is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUseEqualTo(Integer value) {
            addCriterion("max_use =", value, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseNotEqualTo(Integer value) {
            addCriterion("max_use <>", value, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseGreaterThan(Integer value) {
            addCriterion("max_use >", value, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_use >=", value, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseLessThan(Integer value) {
            addCriterion("max_use <", value, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseLessThanOrEqualTo(Integer value) {
            addCriterion("max_use <=", value, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseIn(List<Integer> values) {
            addCriterion("max_use in", values, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseNotIn(List<Integer> values) {
            addCriterion("max_use not in", values, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseBetween(Integer value1, Integer value2) {
            addCriterion("max_use between", value1, value2, "maxUse");
            return (Criteria) this;
        }

        public Criteria andMaxUseNotBetween(Integer value1, Integer value2) {
            addCriterion("max_use not between", value1, value2, "maxUse");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsIsNull() {
            addCriterion("time_slots is null");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsIsNotNull() {
            addCriterion("time_slots is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsEqualTo(String value) {
            addCriterion("time_slots =", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsNotEqualTo(String value) {
            addCriterion("time_slots <>", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsGreaterThan(String value) {
            addCriterion("time_slots >", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsGreaterThanOrEqualTo(String value) {
            addCriterion("time_slots >=", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsLessThan(String value) {
            addCriterion("time_slots <", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsLessThanOrEqualTo(String value) {
            addCriterion("time_slots <=", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsLike(String value) {
            addCriterion("time_slots like", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsNotLike(String value) {
            addCriterion("time_slots not like", value, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsIn(List<String> values) {
            addCriterion("time_slots in", values, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsNotIn(List<String> values) {
            addCriterion("time_slots not in", values, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsBetween(String value1, String value2) {
            addCriterion("time_slots between", value1, value2, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andTimeSlotsNotBetween(String value1, String value2) {
            addCriterion("time_slots not between", value1, value2, "timeSlots");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleIsNull() {
            addCriterion("coupon_use_rule is null");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleIsNotNull() {
            addCriterion("coupon_use_rule is not null");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleEqualTo(String value) {
            addCriterion("coupon_use_rule =", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleNotEqualTo(String value) {
            addCriterion("coupon_use_rule <>", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleGreaterThan(String value) {
            addCriterion("coupon_use_rule >", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_use_rule >=", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleLessThan(String value) {
            addCriterion("coupon_use_rule <", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleLessThanOrEqualTo(String value) {
            addCriterion("coupon_use_rule <=", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleLike(String value) {
            addCriterion("coupon_use_rule like", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleNotLike(String value) {
            addCriterion("coupon_use_rule not like", value, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleIn(List<String> values) {
            addCriterion("coupon_use_rule in", values, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleNotIn(List<String> values) {
            addCriterion("coupon_use_rule not in", values, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleBetween(String value1, String value2) {
            addCriterion("coupon_use_rule between", value1, value2, "couponUseRule");
            return (Criteria) this;
        }

        public Criteria andCouponUseRuleNotBetween(String value1, String value2) {
            addCriterion("coupon_use_rule not between", value1, value2, "couponUseRule");
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