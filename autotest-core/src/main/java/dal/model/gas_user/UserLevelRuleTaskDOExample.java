package dal.model.gas_user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLevelRuleTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLevelRuleTaskDOExample() {
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusIsNull() {
            addCriterion("execution_status is null");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusIsNotNull() {
            addCriterion("execution_status is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusEqualTo(String value) {
            addCriterion("execution_status =", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusNotEqualTo(String value) {
            addCriterion("execution_status <>", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusGreaterThan(String value) {
            addCriterion("execution_status >", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusGreaterThanOrEqualTo(String value) {
            addCriterion("execution_status >=", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusLessThan(String value) {
            addCriterion("execution_status <", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusLessThanOrEqualTo(String value) {
            addCriterion("execution_status <=", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusLike(String value) {
            addCriterion("execution_status like", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusNotLike(String value) {
            addCriterion("execution_status not like", value, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusIn(List<String> values) {
            addCriterion("execution_status in", values, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusNotIn(List<String> values) {
            addCriterion("execution_status not in", values, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusBetween(String value1, String value2) {
            addCriterion("execution_status between", value1, value2, "executionStatus");
            return (Criteria) this;
        }

        public Criteria andExecutionStatusNotBetween(String value1, String value2) {
            addCriterion("execution_status not between", value1, value2, "executionStatus");
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

        public Criteria andSubscriptIsNull() {
            addCriterion("subscript is null");
            return (Criteria) this;
        }

        public Criteria andSubscriptIsNotNull() {
            addCriterion("subscript is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriptEqualTo(Integer value) {
            addCriterion("subscript =", value, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptNotEqualTo(Integer value) {
            addCriterion("subscript <>", value, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptGreaterThan(Integer value) {
            addCriterion("subscript >", value, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptGreaterThanOrEqualTo(Integer value) {
            addCriterion("subscript >=", value, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptLessThan(Integer value) {
            addCriterion("subscript <", value, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptLessThanOrEqualTo(Integer value) {
            addCriterion("subscript <=", value, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptIn(List<Integer> values) {
            addCriterion("subscript in", values, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptNotIn(List<Integer> values) {
            addCriterion("subscript not in", values, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptBetween(Integer value1, Integer value2) {
            addCriterion("subscript between", value1, value2, "subscript");
            return (Criteria) this;
        }

        public Criteria andSubscriptNotBetween(Integer value1, Integer value2) {
            addCriterion("subscript not between", value1, value2, "subscript");
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