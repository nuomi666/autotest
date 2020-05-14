package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsGroupProgramDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsGroupProgramDOExample() {
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

        public Criteria andOperateIdIsNull() {
            addCriterion("operate_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNotNull() {
            addCriterion("operate_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIdEqualTo(String value) {
            addCriterion("operate_id =", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotEqualTo(String value) {
            addCriterion("operate_id <>", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThan(String value) {
            addCriterion("operate_id >", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThanOrEqualTo(String value) {
            addCriterion("operate_id >=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThan(String value) {
            addCriterion("operate_id <", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThanOrEqualTo(String value) {
            addCriterion("operate_id <=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLike(String value) {
            addCriterion("operate_id like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotLike(String value) {
            addCriterion("operate_id not like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdIn(List<String> values) {
            addCriterion("operate_id in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotIn(List<String> values) {
            addCriterion("operate_id not in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdBetween(String value1, String value2) {
            addCriterion("operate_id between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotBetween(String value1, String value2) {
            addCriterion("operate_id not between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andProgramNameIsNull() {
            addCriterion("program_name is null");
            return (Criteria) this;
        }

        public Criteria andProgramNameIsNotNull() {
            addCriterion("program_name is not null");
            return (Criteria) this;
        }

        public Criteria andProgramNameEqualTo(String value) {
            addCriterion("program_name =", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotEqualTo(String value) {
            addCriterion("program_name <>", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameGreaterThan(String value) {
            addCriterion("program_name >", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameGreaterThanOrEqualTo(String value) {
            addCriterion("program_name >=", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLessThan(String value) {
            addCriterion("program_name <", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLessThanOrEqualTo(String value) {
            addCriterion("program_name <=", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLike(String value) {
            addCriterion("program_name like", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotLike(String value) {
            addCriterion("program_name not like", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameIn(List<String> values) {
            addCriterion("program_name in", values, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotIn(List<String> values) {
            addCriterion("program_name not in", values, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameBetween(String value1, String value2) {
            addCriterion("program_name between", value1, value2, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotBetween(String value1, String value2) {
            addCriterion("program_name not between", value1, value2, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramCodeIsNull() {
            addCriterion("program_code is null");
            return (Criteria) this;
        }

        public Criteria andProgramCodeIsNotNull() {
            addCriterion("program_code is not null");
            return (Criteria) this;
        }

        public Criteria andProgramCodeEqualTo(String value) {
            addCriterion("program_code =", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeNotEqualTo(String value) {
            addCriterion("program_code <>", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeGreaterThan(String value) {
            addCriterion("program_code >", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeGreaterThanOrEqualTo(String value) {
            addCriterion("program_code >=", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeLessThan(String value) {
            addCriterion("program_code <", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeLessThanOrEqualTo(String value) {
            addCriterion("program_code <=", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeLike(String value) {
            addCriterion("program_code like", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeNotLike(String value) {
            addCriterion("program_code not like", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeIn(List<String> values) {
            addCriterion("program_code in", values, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeNotIn(List<String> values) {
            addCriterion("program_code not in", values, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeBetween(String value1, String value2) {
            addCriterion("program_code between", value1, value2, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeNotBetween(String value1, String value2) {
            addCriterion("program_code not between", value1, value2, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIsNull() {
            addCriterion("program_type is null");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIsNotNull() {
            addCriterion("program_type is not null");
            return (Criteria) this;
        }

        public Criteria andProgramTypeEqualTo(String value) {
            addCriterion("program_type =", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeNotEqualTo(String value) {
            addCriterion("program_type <>", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeGreaterThan(String value) {
            addCriterion("program_type >", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeGreaterThanOrEqualTo(String value) {
            addCriterion("program_type >=", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeLessThan(String value) {
            addCriterion("program_type <", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeLessThanOrEqualTo(String value) {
            addCriterion("program_type <=", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeLike(String value) {
            addCriterion("program_type like", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeNotLike(String value) {
            addCriterion("program_type not like", value, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIn(List<String> values) {
            addCriterion("program_type in", values, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeNotIn(List<String> values) {
            addCriterion("program_type not in", values, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeBetween(String value1, String value2) {
            addCriterion("program_type between", value1, value2, "programType");
            return (Criteria) this;
        }

        public Criteria andProgramTypeNotBetween(String value1, String value2) {
            addCriterion("program_type not between", value1, value2, "programType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeIsNull() {
            addCriterion("grade_type is null");
            return (Criteria) this;
        }

        public Criteria andGradeTypeIsNotNull() {
            addCriterion("grade_type is not null");
            return (Criteria) this;
        }

        public Criteria andGradeTypeEqualTo(String value) {
            addCriterion("grade_type =", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeNotEqualTo(String value) {
            addCriterion("grade_type <>", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeGreaterThan(String value) {
            addCriterion("grade_type >", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("grade_type >=", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeLessThan(String value) {
            addCriterion("grade_type <", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeLessThanOrEqualTo(String value) {
            addCriterion("grade_type <=", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeLike(String value) {
            addCriterion("grade_type like", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeNotLike(String value) {
            addCriterion("grade_type not like", value, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeIn(List<String> values) {
            addCriterion("grade_type in", values, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeNotIn(List<String> values) {
            addCriterion("grade_type not in", values, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeBetween(String value1, String value2) {
            addCriterion("grade_type between", value1, value2, "gradeType");
            return (Criteria) this;
        }

        public Criteria andGradeTypeNotBetween(String value1, String value2) {
            addCriterion("grade_type not between", value1, value2, "gradeType");
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