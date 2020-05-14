package dal.model.gas_marketpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantExtendInfoDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantExtendInfoDOExample() {
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

        public Criteria andEvaluateGradeRuleIsNull() {
            addCriterion("evaluate_grade_rule is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleIsNotNull() {
            addCriterion("evaluate_grade_rule is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleEqualTo(String value) {
            addCriterion("evaluate_grade_rule =", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleNotEqualTo(String value) {
            addCriterion("evaluate_grade_rule <>", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleGreaterThan(String value) {
            addCriterion("evaluate_grade_rule >", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_grade_rule >=", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleLessThan(String value) {
            addCriterion("evaluate_grade_rule <", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleLessThanOrEqualTo(String value) {
            addCriterion("evaluate_grade_rule <=", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleLike(String value) {
            addCriterion("evaluate_grade_rule like", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleNotLike(String value) {
            addCriterion("evaluate_grade_rule not like", value, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleIn(List<String> values) {
            addCriterion("evaluate_grade_rule in", values, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleNotIn(List<String> values) {
            addCriterion("evaluate_grade_rule not in", values, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleBetween(String value1, String value2) {
            addCriterion("evaluate_grade_rule between", value1, value2, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andEvaluateGradeRuleNotBetween(String value1, String value2) {
            addCriterion("evaluate_grade_rule not between", value1, value2, "evaluateGradeRule");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIsNull() {
            addCriterion("max_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIsNotNull() {
            addCriterion("max_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountEqualTo(Long value) {
            addCriterion("max_discount_amount =", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotEqualTo(Long value) {
            addCriterion("max_discount_amount <>", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountGreaterThan(Long value) {
            addCriterion("max_discount_amount >", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("max_discount_amount >=", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountLessThan(Long value) {
            addCriterion("max_discount_amount <", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("max_discount_amount <=", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIn(List<Long> values) {
            addCriterion("max_discount_amount in", values, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotIn(List<Long> values) {
            addCriterion("max_discount_amount not in", values, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("max_discount_amount between", value1, value2, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("max_discount_amount not between", value1, value2, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponIsNull() {
            addCriterion("max_use_coupon is null");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponIsNotNull() {
            addCriterion("max_use_coupon is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponEqualTo(Integer value) {
            addCriterion("max_use_coupon =", value, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponNotEqualTo(Integer value) {
            addCriterion("max_use_coupon <>", value, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponGreaterThan(Integer value) {
            addCriterion("max_use_coupon >", value, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_use_coupon >=", value, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponLessThan(Integer value) {
            addCriterion("max_use_coupon <", value, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponLessThanOrEqualTo(Integer value) {
            addCriterion("max_use_coupon <=", value, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponIn(List<Integer> values) {
            addCriterion("max_use_coupon in", values, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponNotIn(List<Integer> values) {
            addCriterion("max_use_coupon not in", values, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponBetween(Integer value1, Integer value2) {
            addCriterion("max_use_coupon between", value1, value2, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxUseCouponNotBetween(Integer value1, Integer value2) {
            addCriterion("max_use_coupon not between", value1, value2, "maxUseCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponIsNull() {
            addCriterion("max_give_coupon is null");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponIsNotNull() {
            addCriterion("max_give_coupon is not null");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponEqualTo(Integer value) {
            addCriterion("max_give_coupon =", value, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponNotEqualTo(Integer value) {
            addCriterion("max_give_coupon <>", value, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponGreaterThan(Integer value) {
            addCriterion("max_give_coupon >", value, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_give_coupon >=", value, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponLessThan(Integer value) {
            addCriterion("max_give_coupon <", value, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponLessThanOrEqualTo(Integer value) {
            addCriterion("max_give_coupon <=", value, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponIn(List<Integer> values) {
            addCriterion("max_give_coupon in", values, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponNotIn(List<Integer> values) {
            addCriterion("max_give_coupon not in", values, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponBetween(Integer value1, Integer value2) {
            addCriterion("max_give_coupon between", value1, value2, "maxGiveCoupon");
            return (Criteria) this;
        }

        public Criteria andMaxGiveCouponNotBetween(Integer value1, Integer value2) {
            addCriterion("max_give_coupon not between", value1, value2, "maxGiveCoupon");
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