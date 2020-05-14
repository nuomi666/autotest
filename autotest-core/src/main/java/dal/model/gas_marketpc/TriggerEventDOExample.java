package dal.model.gas_marketpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TriggerEventDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TriggerEventDOExample() {
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

        public Criteria andEventNameIsNull() {
            addCriterion("event_name is null");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNotNull() {
            addCriterion("event_name is not null");
            return (Criteria) this;
        }

        public Criteria andEventNameEqualTo(String value) {
            addCriterion("event_name =", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotEqualTo(String value) {
            addCriterion("event_name <>", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThan(String value) {
            addCriterion("event_name >", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThanOrEqualTo(String value) {
            addCriterion("event_name >=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThan(String value) {
            addCriterion("event_name <", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThanOrEqualTo(String value) {
            addCriterion("event_name <=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLike(String value) {
            addCriterion("event_name like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotLike(String value) {
            addCriterion("event_name not like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameIn(List<String> values) {
            addCriterion("event_name in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotIn(List<String> values) {
            addCriterion("event_name not in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameBetween(String value1, String value2) {
            addCriterion("event_name between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotBetween(String value1, String value2) {
            addCriterion("event_name not between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventRouteIsNull() {
            addCriterion("event_route is null");
            return (Criteria) this;
        }

        public Criteria andEventRouteIsNotNull() {
            addCriterion("event_route is not null");
            return (Criteria) this;
        }

        public Criteria andEventRouteEqualTo(String value) {
            addCriterion("event_route =", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteNotEqualTo(String value) {
            addCriterion("event_route <>", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteGreaterThan(String value) {
            addCriterion("event_route >", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteGreaterThanOrEqualTo(String value) {
            addCriterion("event_route >=", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteLessThan(String value) {
            addCriterion("event_route <", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteLessThanOrEqualTo(String value) {
            addCriterion("event_route <=", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteLike(String value) {
            addCriterion("event_route like", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteNotLike(String value) {
            addCriterion("event_route not like", value, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteIn(List<String> values) {
            addCriterion("event_route in", values, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteNotIn(List<String> values) {
            addCriterion("event_route not in", values, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteBetween(String value1, String value2) {
            addCriterion("event_route between", value1, value2, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventRouteNotBetween(String value1, String value2) {
            addCriterion("event_route not between", value1, value2, "eventRoute");
            return (Criteria) this;
        }

        public Criteria andEventScopeIsNull() {
            addCriterion("event_scope is null");
            return (Criteria) this;
        }

        public Criteria andEventScopeIsNotNull() {
            addCriterion("event_scope is not null");
            return (Criteria) this;
        }

        public Criteria andEventScopeEqualTo(String value) {
            addCriterion("event_scope =", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeNotEqualTo(String value) {
            addCriterion("event_scope <>", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeGreaterThan(String value) {
            addCriterion("event_scope >", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeGreaterThanOrEqualTo(String value) {
            addCriterion("event_scope >=", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeLessThan(String value) {
            addCriterion("event_scope <", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeLessThanOrEqualTo(String value) {
            addCriterion("event_scope <=", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeLike(String value) {
            addCriterion("event_scope like", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeNotLike(String value) {
            addCriterion("event_scope not like", value, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeIn(List<String> values) {
            addCriterion("event_scope in", values, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeNotIn(List<String> values) {
            addCriterion("event_scope not in", values, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeBetween(String value1, String value2) {
            addCriterion("event_scope between", value1, value2, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventScopeNotBetween(String value1, String value2) {
            addCriterion("event_scope not between", value1, value2, "eventScope");
            return (Criteria) this;
        }

        public Criteria andEventStatusIsNull() {
            addCriterion("event_status is null");
            return (Criteria) this;
        }

        public Criteria andEventStatusIsNotNull() {
            addCriterion("event_status is not null");
            return (Criteria) this;
        }

        public Criteria andEventStatusEqualTo(String value) {
            addCriterion("event_status =", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotEqualTo(String value) {
            addCriterion("event_status <>", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusGreaterThan(String value) {
            addCriterion("event_status >", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusGreaterThanOrEqualTo(String value) {
            addCriterion("event_status >=", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLessThan(String value) {
            addCriterion("event_status <", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLessThanOrEqualTo(String value) {
            addCriterion("event_status <=", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLike(String value) {
            addCriterion("event_status like", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotLike(String value) {
            addCriterion("event_status not like", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusIn(List<String> values) {
            addCriterion("event_status in", values, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotIn(List<String> values) {
            addCriterion("event_status not in", values, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusBetween(String value1, String value2) {
            addCriterion("event_status between", value1, value2, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotBetween(String value1, String value2) {
            addCriterion("event_status not between", value1, value2, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionIsNull() {
            addCriterion("event_description is null");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionIsNotNull() {
            addCriterion("event_description is not null");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionEqualTo(String value) {
            addCriterion("event_description =", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotEqualTo(String value) {
            addCriterion("event_description <>", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionGreaterThan(String value) {
            addCriterion("event_description >", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("event_description >=", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionLessThan(String value) {
            addCriterion("event_description <", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionLessThanOrEqualTo(String value) {
            addCriterion("event_description <=", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionLike(String value) {
            addCriterion("event_description like", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotLike(String value) {
            addCriterion("event_description not like", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionIn(List<String> values) {
            addCriterion("event_description in", values, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotIn(List<String> values) {
            addCriterion("event_description not in", values, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionBetween(String value1, String value2) {
            addCriterion("event_description between", value1, value2, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotBetween(String value1, String value2) {
            addCriterion("event_description not between", value1, value2, "eventDescription");
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