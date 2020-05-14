package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsTaskDOExample() {
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

        public Criteria andSpoutNameIsNull() {
            addCriterion("spout_name is null");
            return (Criteria) this;
        }

        public Criteria andSpoutNameIsNotNull() {
            addCriterion("spout_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpoutNameEqualTo(String value) {
            addCriterion("spout_name =", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameNotEqualTo(String value) {
            addCriterion("spout_name <>", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameGreaterThan(String value) {
            addCriterion("spout_name >", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameGreaterThanOrEqualTo(String value) {
            addCriterion("spout_name >=", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameLessThan(String value) {
            addCriterion("spout_name <", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameLessThanOrEqualTo(String value) {
            addCriterion("spout_name <=", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameLike(String value) {
            addCriterion("spout_name like", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameNotLike(String value) {
            addCriterion("spout_name not like", value, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameIn(List<String> values) {
            addCriterion("spout_name in", values, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameNotIn(List<String> values) {
            addCriterion("spout_name not in", values, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameBetween(String value1, String value2) {
            addCriterion("spout_name between", value1, value2, "spoutName");
            return (Criteria) this;
        }

        public Criteria andSpoutNameNotBetween(String value1, String value2) {
            addCriterion("spout_name not between", value1, value2, "spoutName");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andDataScanIsNull() {
            addCriterion("data_scan is null");
            return (Criteria) this;
        }

        public Criteria andDataScanIsNotNull() {
            addCriterion("data_scan is not null");
            return (Criteria) this;
        }

        public Criteria andDataScanEqualTo(String value) {
            addCriterion("data_scan =", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanNotEqualTo(String value) {
            addCriterion("data_scan <>", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanGreaterThan(String value) {
            addCriterion("data_scan >", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanGreaterThanOrEqualTo(String value) {
            addCriterion("data_scan >=", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanLessThan(String value) {
            addCriterion("data_scan <", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanLessThanOrEqualTo(String value) {
            addCriterion("data_scan <=", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanLike(String value) {
            addCriterion("data_scan like", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanNotLike(String value) {
            addCriterion("data_scan not like", value, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanIn(List<String> values) {
            addCriterion("data_scan in", values, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanNotIn(List<String> values) {
            addCriterion("data_scan not in", values, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanBetween(String value1, String value2) {
            addCriterion("data_scan between", value1, value2, "dataScan");
            return (Criteria) this;
        }

        public Criteria andDataScanNotBetween(String value1, String value2) {
            addCriterion("data_scan not between", value1, value2, "dataScan");
            return (Criteria) this;
        }

        public Criteria andStartIndexIsNull() {
            addCriterion("start_index is null");
            return (Criteria) this;
        }

        public Criteria andStartIndexIsNotNull() {
            addCriterion("start_index is not null");
            return (Criteria) this;
        }

        public Criteria andStartIndexEqualTo(String value) {
            addCriterion("start_index =", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexNotEqualTo(String value) {
            addCriterion("start_index <>", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexGreaterThan(String value) {
            addCriterion("start_index >", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexGreaterThanOrEqualTo(String value) {
            addCriterion("start_index >=", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexLessThan(String value) {
            addCriterion("start_index <", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexLessThanOrEqualTo(String value) {
            addCriterion("start_index <=", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexLike(String value) {
            addCriterion("start_index like", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexNotLike(String value) {
            addCriterion("start_index not like", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexIn(List<String> values) {
            addCriterion("start_index in", values, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexNotIn(List<String> values) {
            addCriterion("start_index not in", values, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexBetween(String value1, String value2) {
            addCriterion("start_index between", value1, value2, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexNotBetween(String value1, String value2) {
            addCriterion("start_index not between", value1, value2, "startIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexIsNull() {
            addCriterion("end_index is null");
            return (Criteria) this;
        }

        public Criteria andEndIndexIsNotNull() {
            addCriterion("end_index is not null");
            return (Criteria) this;
        }

        public Criteria andEndIndexEqualTo(String value) {
            addCriterion("end_index =", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotEqualTo(String value) {
            addCriterion("end_index <>", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexGreaterThan(String value) {
            addCriterion("end_index >", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexGreaterThanOrEqualTo(String value) {
            addCriterion("end_index >=", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexLessThan(String value) {
            addCriterion("end_index <", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexLessThanOrEqualTo(String value) {
            addCriterion("end_index <=", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexLike(String value) {
            addCriterion("end_index like", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotLike(String value) {
            addCriterion("end_index not like", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexIn(List<String> values) {
            addCriterion("end_index in", values, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotIn(List<String> values) {
            addCriterion("end_index not in", values, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexBetween(String value1, String value2) {
            addCriterion("end_index between", value1, value2, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotBetween(String value1, String value2) {
            addCriterion("end_index not between", value1, value2, "endIndex");
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