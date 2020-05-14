package dal.model.shelluser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserIntegralResetRuleDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserIntegralResetRuleDOExample() {
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

        public Criteria andResetSwitchIsNull() {
            addCriterion("reset_switch is null");
            return (Criteria) this;
        }

        public Criteria andResetSwitchIsNotNull() {
            addCriterion("reset_switch is not null");
            return (Criteria) this;
        }

        public Criteria andResetSwitchEqualTo(String value) {
            addCriterion("reset_switch =", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchNotEqualTo(String value) {
            addCriterion("reset_switch <>", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchGreaterThan(String value) {
            addCriterion("reset_switch >", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchGreaterThanOrEqualTo(String value) {
            addCriterion("reset_switch >=", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchLessThan(String value) {
            addCriterion("reset_switch <", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchLessThanOrEqualTo(String value) {
            addCriterion("reset_switch <=", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchLike(String value) {
            addCriterion("reset_switch like", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchNotLike(String value) {
            addCriterion("reset_switch not like", value, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchIn(List<String> values) {
            addCriterion("reset_switch in", values, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchNotIn(List<String> values) {
            addCriterion("reset_switch not in", values, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchBetween(String value1, String value2) {
            addCriterion("reset_switch between", value1, value2, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andResetSwitchNotBetween(String value1, String value2) {
            addCriterion("reset_switch not between", value1, value2, "resetSwitch");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeIsNull() {
            addCriterion("integral_reset_type is null");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeIsNotNull() {
            addCriterion("integral_reset_type is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeEqualTo(String value) {
            addCriterion("integral_reset_type =", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeNotEqualTo(String value) {
            addCriterion("integral_reset_type <>", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeGreaterThan(String value) {
            addCriterion("integral_reset_type >", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("integral_reset_type >=", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeLessThan(String value) {
            addCriterion("integral_reset_type <", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeLessThanOrEqualTo(String value) {
            addCriterion("integral_reset_type <=", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeLike(String value) {
            addCriterion("integral_reset_type like", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeNotLike(String value) {
            addCriterion("integral_reset_type not like", value, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeIn(List<String> values) {
            addCriterion("integral_reset_type in", values, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeNotIn(List<String> values) {
            addCriterion("integral_reset_type not in", values, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeBetween(String value1, String value2) {
            addCriterion("integral_reset_type between", value1, value2, "integralResetType");
            return (Criteria) this;
        }

        public Criteria andIntegralResetTypeNotBetween(String value1, String value2) {
            addCriterion("integral_reset_type not between", value1, value2, "integralResetType");
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