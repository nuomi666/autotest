package dal.model.cashier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteStrategyDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RouteStrategyDOExample() {
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

        public Criteria andRouteStrategyIdIsNull() {
            addCriterion("route_strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdIsNotNull() {
            addCriterion("route_strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdEqualTo(String value) {
            addCriterion("route_strategy_id =", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdNotEqualTo(String value) {
            addCriterion("route_strategy_id <>", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdGreaterThan(String value) {
            addCriterion("route_strategy_id >", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdGreaterThanOrEqualTo(String value) {
            addCriterion("route_strategy_id >=", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdLessThan(String value) {
            addCriterion("route_strategy_id <", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdLessThanOrEqualTo(String value) {
            addCriterion("route_strategy_id <=", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdLike(String value) {
            addCriterion("route_strategy_id like", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdNotLike(String value) {
            addCriterion("route_strategy_id not like", value, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdIn(List<String> values) {
            addCriterion("route_strategy_id in", values, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdNotIn(List<String> values) {
            addCriterion("route_strategy_id not in", values, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdBetween(String value1, String value2) {
            addCriterion("route_strategy_id between", value1, value2, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyIdNotBetween(String value1, String value2) {
            addCriterion("route_strategy_id not between", value1, value2, "routeStrategyId");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameIsNull() {
            addCriterion("route_strategy_name is null");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameIsNotNull() {
            addCriterion("route_strategy_name is not null");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameEqualTo(String value) {
            addCriterion("route_strategy_name =", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameNotEqualTo(String value) {
            addCriterion("route_strategy_name <>", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameGreaterThan(String value) {
            addCriterion("route_strategy_name >", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameGreaterThanOrEqualTo(String value) {
            addCriterion("route_strategy_name >=", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameLessThan(String value) {
            addCriterion("route_strategy_name <", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameLessThanOrEqualTo(String value) {
            addCriterion("route_strategy_name <=", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameLike(String value) {
            addCriterion("route_strategy_name like", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameNotLike(String value) {
            addCriterion("route_strategy_name not like", value, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameIn(List<String> values) {
            addCriterion("route_strategy_name in", values, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameNotIn(List<String> values) {
            addCriterion("route_strategy_name not in", values, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameBetween(String value1, String value2) {
            addCriterion("route_strategy_name between", value1, value2, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyNameNotBetween(String value1, String value2) {
            addCriterion("route_strategy_name not between", value1, value2, "routeStrategyName");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsIsNull() {
            addCriterion("route_strategy_algs is null");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsIsNotNull() {
            addCriterion("route_strategy_algs is not null");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsEqualTo(String value) {
            addCriterion("route_strategy_algs =", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsNotEqualTo(String value) {
            addCriterion("route_strategy_algs <>", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsGreaterThan(String value) {
            addCriterion("route_strategy_algs >", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsGreaterThanOrEqualTo(String value) {
            addCriterion("route_strategy_algs >=", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsLessThan(String value) {
            addCriterion("route_strategy_algs <", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsLessThanOrEqualTo(String value) {
            addCriterion("route_strategy_algs <=", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsLike(String value) {
            addCriterion("route_strategy_algs like", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsNotLike(String value) {
            addCriterion("route_strategy_algs not like", value, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsIn(List<String> values) {
            addCriterion("route_strategy_algs in", values, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsNotIn(List<String> values) {
            addCriterion("route_strategy_algs not in", values, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsBetween(String value1, String value2) {
            addCriterion("route_strategy_algs between", value1, value2, "routeStrategyAlgs");
            return (Criteria) this;
        }

        public Criteria andRouteStrategyAlgsNotBetween(String value1, String value2) {
            addCriterion("route_strategy_algs not between", value1, value2, "routeStrategyAlgs");
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

        public Criteria andMarkDeleteIsNull() {
            addCriterion("mark_delete is null");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteIsNotNull() {
            addCriterion("mark_delete is not null");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteEqualTo(String value) {
            addCriterion("mark_delete =", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotEqualTo(String value) {
            addCriterion("mark_delete <>", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteGreaterThan(String value) {
            addCriterion("mark_delete >", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("mark_delete >=", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteLessThan(String value) {
            addCriterion("mark_delete <", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteLessThanOrEqualTo(String value) {
            addCriterion("mark_delete <=", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteLike(String value) {
            addCriterion("mark_delete like", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotLike(String value) {
            addCriterion("mark_delete not like", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteIn(List<String> values) {
            addCriterion("mark_delete in", values, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotIn(List<String> values) {
            addCriterion("mark_delete not in", values, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteBetween(String value1, String value2) {
            addCriterion("mark_delete between", value1, value2, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotBetween(String value1, String value2) {
            addCriterion("mark_delete not between", value1, value2, "markDelete");
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