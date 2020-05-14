package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsSourceDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsSourceDOExample() {
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

        public Criteria andSourceTableIsNull() {
            addCriterion("source_table is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableIsNotNull() {
            addCriterion("source_table is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableEqualTo(String value) {
            addCriterion("source_table =", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotEqualTo(String value) {
            addCriterion("source_table <>", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThan(String value) {
            addCriterion("source_table >", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThanOrEqualTo(String value) {
            addCriterion("source_table >=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThan(String value) {
            addCriterion("source_table <", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThanOrEqualTo(String value) {
            addCriterion("source_table <=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLike(String value) {
            addCriterion("source_table like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotLike(String value) {
            addCriterion("source_table not like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableIn(List<String> values) {
            addCriterion("source_table in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotIn(List<String> values) {
            addCriterion("source_table not in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableBetween(String value1, String value2) {
            addCriterion("source_table between", value1, value2, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotBetween(String value1, String value2) {
            addCriterion("source_table not between", value1, value2, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andIdFiledIsNull() {
            addCriterion("id_filed is null");
            return (Criteria) this;
        }

        public Criteria andIdFiledIsNotNull() {
            addCriterion("id_filed is not null");
            return (Criteria) this;
        }

        public Criteria andIdFiledEqualTo(String value) {
            addCriterion("id_filed =", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledNotEqualTo(String value) {
            addCriterion("id_filed <>", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledGreaterThan(String value) {
            addCriterion("id_filed >", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledGreaterThanOrEqualTo(String value) {
            addCriterion("id_filed >=", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledLessThan(String value) {
            addCriterion("id_filed <", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledLessThanOrEqualTo(String value) {
            addCriterion("id_filed <=", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledLike(String value) {
            addCriterion("id_filed like", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledNotLike(String value) {
            addCriterion("id_filed not like", value, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledIn(List<String> values) {
            addCriterion("id_filed in", values, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledNotIn(List<String> values) {
            addCriterion("id_filed not in", values, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledBetween(String value1, String value2) {
            addCriterion("id_filed between", value1, value2, "idFiled");
            return (Criteria) this;
        }

        public Criteria andIdFiledNotBetween(String value1, String value2) {
            addCriterion("id_filed not between", value1, value2, "idFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledIsNull() {
            addCriterion("time_filed is null");
            return (Criteria) this;
        }

        public Criteria andTimeFiledIsNotNull() {
            addCriterion("time_filed is not null");
            return (Criteria) this;
        }

        public Criteria andTimeFiledEqualTo(String value) {
            addCriterion("time_filed =", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledNotEqualTo(String value) {
            addCriterion("time_filed <>", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledGreaterThan(String value) {
            addCriterion("time_filed >", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledGreaterThanOrEqualTo(String value) {
            addCriterion("time_filed >=", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledLessThan(String value) {
            addCriterion("time_filed <", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledLessThanOrEqualTo(String value) {
            addCriterion("time_filed <=", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledLike(String value) {
            addCriterion("time_filed like", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledNotLike(String value) {
            addCriterion("time_filed not like", value, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledIn(List<String> values) {
            addCriterion("time_filed in", values, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledNotIn(List<String> values) {
            addCriterion("time_filed not in", values, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledBetween(String value1, String value2) {
            addCriterion("time_filed between", value1, value2, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTimeFiledNotBetween(String value1, String value2) {
            addCriterion("time_filed not between", value1, value2, "timeFiled");
            return (Criteria) this;
        }

        public Criteria andTableColumnIsNull() {
            addCriterion("table_column is null");
            return (Criteria) this;
        }

        public Criteria andTableColumnIsNotNull() {
            addCriterion("table_column is not null");
            return (Criteria) this;
        }

        public Criteria andTableColumnEqualTo(String value) {
            addCriterion("table_column =", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnNotEqualTo(String value) {
            addCriterion("table_column <>", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnGreaterThan(String value) {
            addCriterion("table_column >", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnGreaterThanOrEqualTo(String value) {
            addCriterion("table_column >=", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnLessThan(String value) {
            addCriterion("table_column <", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnLessThanOrEqualTo(String value) {
            addCriterion("table_column <=", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnLike(String value) {
            addCriterion("table_column like", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnNotLike(String value) {
            addCriterion("table_column not like", value, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnIn(List<String> values) {
            addCriterion("table_column in", values, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnNotIn(List<String> values) {
            addCriterion("table_column not in", values, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnBetween(String value1, String value2) {
            addCriterion("table_column between", value1, value2, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andTableColumnNotBetween(String value1, String value2) {
            addCriterion("table_column not between", value1, value2, "tableColumn");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Long value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Long value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Long value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Long value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Long value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Long value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Long> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Long> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Long value1, Long value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Long value1, Long value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStartSizeIsNull() {
            addCriterion("start_size is null");
            return (Criteria) this;
        }

        public Criteria andStartSizeIsNotNull() {
            addCriterion("start_size is not null");
            return (Criteria) this;
        }

        public Criteria andStartSizeEqualTo(Long value) {
            addCriterion("start_size =", value, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeNotEqualTo(Long value) {
            addCriterion("start_size <>", value, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeGreaterThan(Long value) {
            addCriterion("start_size >", value, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("start_size >=", value, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeLessThan(Long value) {
            addCriterion("start_size <", value, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeLessThanOrEqualTo(Long value) {
            addCriterion("start_size <=", value, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeIn(List<Long> values) {
            addCriterion("start_size in", values, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeNotIn(List<Long> values) {
            addCriterion("start_size not in", values, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeBetween(Long value1, Long value2) {
            addCriterion("start_size between", value1, value2, "startSize");
            return (Criteria) this;
        }

        public Criteria andStartSizeNotBetween(Long value1, Long value2) {
            addCriterion("start_size not between", value1, value2, "startSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeIsNull() {
            addCriterion("end_size is null");
            return (Criteria) this;
        }

        public Criteria andEndSizeIsNotNull() {
            addCriterion("end_size is not null");
            return (Criteria) this;
        }

        public Criteria andEndSizeEqualTo(Long value) {
            addCriterion("end_size =", value, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeNotEqualTo(Long value) {
            addCriterion("end_size <>", value, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeGreaterThan(Long value) {
            addCriterion("end_size >", value, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("end_size >=", value, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeLessThan(Long value) {
            addCriterion("end_size <", value, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeLessThanOrEqualTo(Long value) {
            addCriterion("end_size <=", value, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeIn(List<Long> values) {
            addCriterion("end_size in", values, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeNotIn(List<Long> values) {
            addCriterion("end_size not in", values, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeBetween(Long value1, Long value2) {
            addCriterion("end_size between", value1, value2, "endSize");
            return (Criteria) this;
        }

        public Criteria andEndSizeNotBetween(Long value1, Long value2) {
            addCriterion("end_size not between", value1, value2, "endSize");
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