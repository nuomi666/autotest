package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonasConditionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonasConditionDOExample() {
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

        public Criteria andConditionTypeIsNull() {
            addCriterion("condition_type is null");
            return (Criteria) this;
        }

        public Criteria andConditionTypeIsNotNull() {
            addCriterion("condition_type is not null");
            return (Criteria) this;
        }

        public Criteria andConditionTypeEqualTo(String value) {
            addCriterion("condition_type =", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotEqualTo(String value) {
            addCriterion("condition_type <>", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeGreaterThan(String value) {
            addCriterion("condition_type >", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("condition_type >=", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeLessThan(String value) {
            addCriterion("condition_type <", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeLessThanOrEqualTo(String value) {
            addCriterion("condition_type <=", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeLike(String value) {
            addCriterion("condition_type like", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotLike(String value) {
            addCriterion("condition_type not like", value, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeIn(List<String> values) {
            addCriterion("condition_type in", values, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotIn(List<String> values) {
            addCriterion("condition_type not in", values, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeBetween(String value1, String value2) {
            addCriterion("condition_type between", value1, value2, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionTypeNotBetween(String value1, String value2) {
            addCriterion("condition_type not between", value1, value2, "conditionType");
            return (Criteria) this;
        }

        public Criteria andConditionNameIsNull() {
            addCriterion("condition_name is null");
            return (Criteria) this;
        }

        public Criteria andConditionNameIsNotNull() {
            addCriterion("condition_name is not null");
            return (Criteria) this;
        }

        public Criteria andConditionNameEqualTo(String value) {
            addCriterion("condition_name =", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotEqualTo(String value) {
            addCriterion("condition_name <>", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameGreaterThan(String value) {
            addCriterion("condition_name >", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameGreaterThanOrEqualTo(String value) {
            addCriterion("condition_name >=", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameLessThan(String value) {
            addCriterion("condition_name <", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameLessThanOrEqualTo(String value) {
            addCriterion("condition_name <=", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameLike(String value) {
            addCriterion("condition_name like", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotLike(String value) {
            addCriterion("condition_name not like", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameIn(List<String> values) {
            addCriterion("condition_name in", values, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotIn(List<String> values) {
            addCriterion("condition_name not in", values, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameBetween(String value1, String value2) {
            addCriterion("condition_name between", value1, value2, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotBetween(String value1, String value2) {
            addCriterion("condition_name not between", value1, value2, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionCodeIsNull() {
            addCriterion("condition_code is null");
            return (Criteria) this;
        }

        public Criteria andConditionCodeIsNotNull() {
            addCriterion("condition_code is not null");
            return (Criteria) this;
        }

        public Criteria andConditionCodeEqualTo(String value) {
            addCriterion("condition_code =", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeNotEqualTo(String value) {
            addCriterion("condition_code <>", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeGreaterThan(String value) {
            addCriterion("condition_code >", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("condition_code >=", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeLessThan(String value) {
            addCriterion("condition_code <", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeLessThanOrEqualTo(String value) {
            addCriterion("condition_code <=", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeLike(String value) {
            addCriterion("condition_code like", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeNotLike(String value) {
            addCriterion("condition_code not like", value, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeIn(List<String> values) {
            addCriterion("condition_code in", values, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeNotIn(List<String> values) {
            addCriterion("condition_code not in", values, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeBetween(String value1, String value2) {
            addCriterion("condition_code between", value1, value2, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionCodeNotBetween(String value1, String value2) {
            addCriterion("condition_code not between", value1, value2, "conditionCode");
            return (Criteria) this;
        }

        public Criteria andConditionColumnIsNull() {
            addCriterion("condition_column is null");
            return (Criteria) this;
        }

        public Criteria andConditionColumnIsNotNull() {
            addCriterion("condition_column is not null");
            return (Criteria) this;
        }

        public Criteria andConditionColumnEqualTo(String value) {
            addCriterion("condition_column =", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnNotEqualTo(String value) {
            addCriterion("condition_column <>", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnGreaterThan(String value) {
            addCriterion("condition_column >", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnGreaterThanOrEqualTo(String value) {
            addCriterion("condition_column >=", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnLessThan(String value) {
            addCriterion("condition_column <", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnLessThanOrEqualTo(String value) {
            addCriterion("condition_column <=", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnLike(String value) {
            addCriterion("condition_column like", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnNotLike(String value) {
            addCriterion("condition_column not like", value, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnIn(List<String> values) {
            addCriterion("condition_column in", values, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnNotIn(List<String> values) {
            addCriterion("condition_column not in", values, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnBetween(String value1, String value2) {
            addCriterion("condition_column between", value1, value2, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andConditionColumnNotBetween(String value1, String value2) {
            addCriterion("condition_column not between", value1, value2, "conditionColumn");
            return (Criteria) this;
        }

        public Criteria andFiledTypeIsNull() {
            addCriterion("filed_type is null");
            return (Criteria) this;
        }

        public Criteria andFiledTypeIsNotNull() {
            addCriterion("filed_type is not null");
            return (Criteria) this;
        }

        public Criteria andFiledTypeEqualTo(String value) {
            addCriterion("filed_type =", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeNotEqualTo(String value) {
            addCriterion("filed_type <>", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeGreaterThan(String value) {
            addCriterion("filed_type >", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeGreaterThanOrEqualTo(String value) {
            addCriterion("filed_type >=", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeLessThan(String value) {
            addCriterion("filed_type <", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeLessThanOrEqualTo(String value) {
            addCriterion("filed_type <=", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeLike(String value) {
            addCriterion("filed_type like", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeNotLike(String value) {
            addCriterion("filed_type not like", value, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeIn(List<String> values) {
            addCriterion("filed_type in", values, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeNotIn(List<String> values) {
            addCriterion("filed_type not in", values, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeBetween(String value1, String value2) {
            addCriterion("filed_type between", value1, value2, "filedType");
            return (Criteria) this;
        }

        public Criteria andFiledTypeNotBetween(String value1, String value2) {
            addCriterion("filed_type not between", value1, value2, "filedType");
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