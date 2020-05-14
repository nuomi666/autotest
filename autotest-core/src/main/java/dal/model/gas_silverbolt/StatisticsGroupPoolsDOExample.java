package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsGroupPoolsDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsGroupPoolsDOExample() {
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

        public Criteria andPoolsNameIsNull() {
            addCriterion("pools_name is null");
            return (Criteria) this;
        }

        public Criteria andPoolsNameIsNotNull() {
            addCriterion("pools_name is not null");
            return (Criteria) this;
        }

        public Criteria andPoolsNameEqualTo(String value) {
            addCriterion("pools_name =", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameNotEqualTo(String value) {
            addCriterion("pools_name <>", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameGreaterThan(String value) {
            addCriterion("pools_name >", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameGreaterThanOrEqualTo(String value) {
            addCriterion("pools_name >=", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameLessThan(String value) {
            addCriterion("pools_name <", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameLessThanOrEqualTo(String value) {
            addCriterion("pools_name <=", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameLike(String value) {
            addCriterion("pools_name like", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameNotLike(String value) {
            addCriterion("pools_name not like", value, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameIn(List<String> values) {
            addCriterion("pools_name in", values, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameNotIn(List<String> values) {
            addCriterion("pools_name not in", values, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameBetween(String value1, String value2) {
            addCriterion("pools_name between", value1, value2, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsNameNotBetween(String value1, String value2) {
            addCriterion("pools_name not between", value1, value2, "poolsName");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeIsNull() {
            addCriterion("pools_code is null");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeIsNotNull() {
            addCriterion("pools_code is not null");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeEqualTo(String value) {
            addCriterion("pools_code =", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeNotEqualTo(String value) {
            addCriterion("pools_code <>", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeGreaterThan(String value) {
            addCriterion("pools_code >", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pools_code >=", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeLessThan(String value) {
            addCriterion("pools_code <", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeLessThanOrEqualTo(String value) {
            addCriterion("pools_code <=", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeLike(String value) {
            addCriterion("pools_code like", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeNotLike(String value) {
            addCriterion("pools_code not like", value, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeIn(List<String> values) {
            addCriterion("pools_code in", values, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeNotIn(List<String> values) {
            addCriterion("pools_code not in", values, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeBetween(String value1, String value2) {
            addCriterion("pools_code between", value1, value2, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andPoolsCodeNotBetween(String value1, String value2) {
            addCriterion("pools_code not between", value1, value2, "poolsCode");
            return (Criteria) this;
        }

        public Criteria andGroupSqlIsNull() {
            addCriterion("group_sql is null");
            return (Criteria) this;
        }

        public Criteria andGroupSqlIsNotNull() {
            addCriterion("group_sql is not null");
            return (Criteria) this;
        }

        public Criteria andGroupSqlEqualTo(String value) {
            addCriterion("group_sql =", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlNotEqualTo(String value) {
            addCriterion("group_sql <>", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlGreaterThan(String value) {
            addCriterion("group_sql >", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlGreaterThanOrEqualTo(String value) {
            addCriterion("group_sql >=", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlLessThan(String value) {
            addCriterion("group_sql <", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlLessThanOrEqualTo(String value) {
            addCriterion("group_sql <=", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlLike(String value) {
            addCriterion("group_sql like", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlNotLike(String value) {
            addCriterion("group_sql not like", value, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlIn(List<String> values) {
            addCriterion("group_sql in", values, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlNotIn(List<String> values) {
            addCriterion("group_sql not in", values, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlBetween(String value1, String value2) {
            addCriterion("group_sql between", value1, value2, "groupSql");
            return (Criteria) this;
        }

        public Criteria andGroupSqlNotBetween(String value1, String value2) {
            addCriterion("group_sql not between", value1, value2, "groupSql");
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