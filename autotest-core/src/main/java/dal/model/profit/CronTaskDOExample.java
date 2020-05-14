package dal.model.profit;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CronTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CronTaskDOExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andNextScheduleTimeIsNull() {
            addCriterion("next_schedule_time is null");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeIsNotNull() {
            addCriterion("next_schedule_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeEqualTo(Date value) {
            addCriterionForJDBCDate("next_schedule_time =", value, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("next_schedule_time <>", value, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("next_schedule_time >", value, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("next_schedule_time >=", value, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeLessThan(Date value) {
            addCriterionForJDBCDate("next_schedule_time <", value, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("next_schedule_time <=", value, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeIn(List<Date> values) {
            addCriterionForJDBCDate("next_schedule_time in", values, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("next_schedule_time not in", values, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("next_schedule_time between", value1, value2, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andNextScheduleTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("next_schedule_time not between", value1, value2, "nextScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeIsNull() {
            addCriterion("last_schedule_time is null");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeIsNotNull() {
            addCriterion("last_schedule_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeEqualTo(Date value) {
            addCriterionForJDBCDate("last_schedule_time =", value, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("last_schedule_time <>", value, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("last_schedule_time >", value, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_schedule_time >=", value, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeLessThan(Date value) {
            addCriterionForJDBCDate("last_schedule_time <", value, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_schedule_time <=", value, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeIn(List<Date> values) {
            addCriterionForJDBCDate("last_schedule_time in", values, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("last_schedule_time not in", values, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_schedule_time between", value1, value2, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andLastScheduleTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_schedule_time not between", value1, value2, "lastScheduleTime");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(Long value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(Long value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(Long value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(Long value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<Long> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<Long> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(Long value1, Long value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdIsNull() {
            addCriterion("condition_strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdIsNotNull() {
            addCriterion("condition_strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdEqualTo(Long value) {
            addCriterion("condition_strategy_id =", value, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdNotEqualTo(Long value) {
            addCriterion("condition_strategy_id <>", value, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdGreaterThan(Long value) {
            addCriterion("condition_strategy_id >", value, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("condition_strategy_id >=", value, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdLessThan(Long value) {
            addCriterion("condition_strategy_id <", value, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdLessThanOrEqualTo(Long value) {
            addCriterion("condition_strategy_id <=", value, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdIn(List<Long> values) {
            addCriterion("condition_strategy_id in", values, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdNotIn(List<Long> values) {
            addCriterion("condition_strategy_id not in", values, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdBetween(Long value1, Long value2) {
            addCriterion("condition_strategy_id between", value1, value2, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andConditionStrategyIdNotBetween(Long value1, Long value2) {
            addCriterion("condition_strategy_id not between", value1, value2, "conditionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdIsNull() {
            addCriterion("action_strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdIsNotNull() {
            addCriterion("action_strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdEqualTo(Long value) {
            addCriterion("action_strategy_id =", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdNotEqualTo(Long value) {
            addCriterion("action_strategy_id <>", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdGreaterThan(Long value) {
            addCriterion("action_strategy_id >", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("action_strategy_id >=", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdLessThan(Long value) {
            addCriterion("action_strategy_id <", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdLessThanOrEqualTo(Long value) {
            addCriterion("action_strategy_id <=", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdIn(List<Long> values) {
            addCriterion("action_strategy_id in", values, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdNotIn(List<Long> values) {
            addCriterion("action_strategy_id not in", values, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdBetween(Long value1, Long value2) {
            addCriterion("action_strategy_id between", value1, value2, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdNotBetween(Long value1, Long value2) {
            addCriterion("action_strategy_id not between", value1, value2, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andExecuteStateIsNull() {
            addCriterion("execute_state is null");
            return (Criteria) this;
        }

        public Criteria andExecuteStateIsNotNull() {
            addCriterion("execute_state is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteStateEqualTo(String value) {
            addCriterion("execute_state =", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateNotEqualTo(String value) {
            addCriterion("execute_state <>", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateGreaterThan(String value) {
            addCriterion("execute_state >", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateGreaterThanOrEqualTo(String value) {
            addCriterion("execute_state >=", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateLessThan(String value) {
            addCriterion("execute_state <", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateLessThanOrEqualTo(String value) {
            addCriterion("execute_state <=", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateLike(String value) {
            addCriterion("execute_state like", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateNotLike(String value) {
            addCriterion("execute_state not like", value, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateIn(List<String> values) {
            addCriterion("execute_state in", values, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateNotIn(List<String> values) {
            addCriterion("execute_state not in", values, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateBetween(String value1, String value2) {
            addCriterion("execute_state between", value1, value2, "executeState");
            return (Criteria) this;
        }

        public Criteria andExecuteStateNotBetween(String value1, String value2) {
            addCriterion("execute_state not between", value1, value2, "executeState");
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