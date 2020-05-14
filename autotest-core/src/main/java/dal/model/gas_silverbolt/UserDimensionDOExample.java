package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDimensionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDimensionDOExample() {
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

        public Criteria andDimensionTypeIsNull() {
            addCriterion("dimension_type is null");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeIsNotNull() {
            addCriterion("dimension_type is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeEqualTo(String value) {
            addCriterion("dimension_type =", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeNotEqualTo(String value) {
            addCriterion("dimension_type <>", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeGreaterThan(String value) {
            addCriterion("dimension_type >", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dimension_type >=", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeLessThan(String value) {
            addCriterion("dimension_type <", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeLessThanOrEqualTo(String value) {
            addCriterion("dimension_type <=", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeLike(String value) {
            addCriterion("dimension_type like", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeNotLike(String value) {
            addCriterion("dimension_type not like", value, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeIn(List<String> values) {
            addCriterion("dimension_type in", values, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeNotIn(List<String> values) {
            addCriterion("dimension_type not in", values, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeBetween(String value1, String value2) {
            addCriterion("dimension_type between", value1, value2, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionTypeNotBetween(String value1, String value2) {
            addCriterion("dimension_type not between", value1, value2, "dimensionType");
            return (Criteria) this;
        }

        public Criteria andDimensionNameIsNull() {
            addCriterion("dimension_name is null");
            return (Criteria) this;
        }

        public Criteria andDimensionNameIsNotNull() {
            addCriterion("dimension_name is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionNameEqualTo(String value) {
            addCriterion("dimension_name =", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotEqualTo(String value) {
            addCriterion("dimension_name <>", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameGreaterThan(String value) {
            addCriterion("dimension_name >", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameGreaterThanOrEqualTo(String value) {
            addCriterion("dimension_name >=", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameLessThan(String value) {
            addCriterion("dimension_name <", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameLessThanOrEqualTo(String value) {
            addCriterion("dimension_name <=", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameLike(String value) {
            addCriterion("dimension_name like", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotLike(String value) {
            addCriterion("dimension_name not like", value, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameIn(List<String> values) {
            addCriterion("dimension_name in", values, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotIn(List<String> values) {
            addCriterion("dimension_name not in", values, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameBetween(String value1, String value2) {
            addCriterion("dimension_name between", value1, value2, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionNameNotBetween(String value1, String value2) {
            addCriterion("dimension_name not between", value1, value2, "dimensionName");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeIsNull() {
            addCriterion("dimension_code is null");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeIsNotNull() {
            addCriterion("dimension_code is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeEqualTo(String value) {
            addCriterion("dimension_code =", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeNotEqualTo(String value) {
            addCriterion("dimension_code <>", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeGreaterThan(String value) {
            addCriterion("dimension_code >", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dimension_code >=", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeLessThan(String value) {
            addCriterion("dimension_code <", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeLessThanOrEqualTo(String value) {
            addCriterion("dimension_code <=", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeLike(String value) {
            addCriterion("dimension_code like", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeNotLike(String value) {
            addCriterion("dimension_code not like", value, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeIn(List<String> values) {
            addCriterion("dimension_code in", values, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeNotIn(List<String> values) {
            addCriterion("dimension_code not in", values, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeBetween(String value1, String value2) {
            addCriterion("dimension_code between", value1, value2, "dimensionCode");
            return (Criteria) this;
        }

        public Criteria andDimensionCodeNotBetween(String value1, String value2) {
            addCriterion("dimension_code not between", value1, value2, "dimensionCode");
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