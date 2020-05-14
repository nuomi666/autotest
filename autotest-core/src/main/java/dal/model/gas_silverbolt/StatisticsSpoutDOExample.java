package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsSpoutDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsSpoutDOExample() {
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

        public Criteria andScanTableIsNull() {
            addCriterion("scan_table is null");
            return (Criteria) this;
        }

        public Criteria andScanTableIsNotNull() {
            addCriterion("scan_table is not null");
            return (Criteria) this;
        }

        public Criteria andScanTableEqualTo(String value) {
            addCriterion("scan_table =", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableNotEqualTo(String value) {
            addCriterion("scan_table <>", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableGreaterThan(String value) {
            addCriterion("scan_table >", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableGreaterThanOrEqualTo(String value) {
            addCriterion("scan_table >=", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableLessThan(String value) {
            addCriterion("scan_table <", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableLessThanOrEqualTo(String value) {
            addCriterion("scan_table <=", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableLike(String value) {
            addCriterion("scan_table like", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableNotLike(String value) {
            addCriterion("scan_table not like", value, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableIn(List<String> values) {
            addCriterion("scan_table in", values, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableNotIn(List<String> values) {
            addCriterion("scan_table not in", values, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableBetween(String value1, String value2) {
            addCriterion("scan_table between", value1, value2, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanTableNotBetween(String value1, String value2) {
            addCriterion("scan_table not between", value1, value2, "scanTable");
            return (Criteria) this;
        }

        public Criteria andScanFileIsNull() {
            addCriterion("scan_file is null");
            return (Criteria) this;
        }

        public Criteria andScanFileIsNotNull() {
            addCriterion("scan_file is not null");
            return (Criteria) this;
        }

        public Criteria andScanFileEqualTo(String value) {
            addCriterion("scan_file =", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileNotEqualTo(String value) {
            addCriterion("scan_file <>", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileGreaterThan(String value) {
            addCriterion("scan_file >", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileGreaterThanOrEqualTo(String value) {
            addCriterion("scan_file >=", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileLessThan(String value) {
            addCriterion("scan_file <", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileLessThanOrEqualTo(String value) {
            addCriterion("scan_file <=", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileLike(String value) {
            addCriterion("scan_file like", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileNotLike(String value) {
            addCriterion("scan_file not like", value, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileIn(List<String> values) {
            addCriterion("scan_file in", values, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileNotIn(List<String> values) {
            addCriterion("scan_file not in", values, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileBetween(String value1, String value2) {
            addCriterion("scan_file between", value1, value2, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanFileNotBetween(String value1, String value2) {
            addCriterion("scan_file not between", value1, value2, "scanFile");
            return (Criteria) this;
        }

        public Criteria andScanTypeIsNull() {
            addCriterion("scan_type is null");
            return (Criteria) this;
        }

        public Criteria andScanTypeIsNotNull() {
            addCriterion("scan_type is not null");
            return (Criteria) this;
        }

        public Criteria andScanTypeEqualTo(String value) {
            addCriterion("scan_type =", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeNotEqualTo(String value) {
            addCriterion("scan_type <>", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeGreaterThan(String value) {
            addCriterion("scan_type >", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("scan_type >=", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeLessThan(String value) {
            addCriterion("scan_type <", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeLessThanOrEqualTo(String value) {
            addCriterion("scan_type <=", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeLike(String value) {
            addCriterion("scan_type like", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeNotLike(String value) {
            addCriterion("scan_type not like", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeIn(List<String> values) {
            addCriterion("scan_type in", values, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeNotIn(List<String> values) {
            addCriterion("scan_type not in", values, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeBetween(String value1, String value2) {
            addCriterion("scan_type between", value1, value2, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeNotBetween(String value1, String value2) {
            addCriterion("scan_type not between", value1, value2, "scanType");
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

        public Criteria andFilterIsNull() {
            addCriterion("filter is null");
            return (Criteria) this;
        }

        public Criteria andFilterIsNotNull() {
            addCriterion("filter is not null");
            return (Criteria) this;
        }

        public Criteria andFilterEqualTo(String value) {
            addCriterion("filter =", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterNotEqualTo(String value) {
            addCriterion("filter <>", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterGreaterThan(String value) {
            addCriterion("filter >", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterGreaterThanOrEqualTo(String value) {
            addCriterion("filter >=", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterLessThan(String value) {
            addCriterion("filter <", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterLessThanOrEqualTo(String value) {
            addCriterion("filter <=", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterLike(String value) {
            addCriterion("filter like", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterNotLike(String value) {
            addCriterion("filter not like", value, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterIn(List<String> values) {
            addCriterion("filter in", values, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterNotIn(List<String> values) {
            addCriterion("filter not in", values, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterBetween(String value1, String value2) {
            addCriterion("filter between", value1, value2, "filter");
            return (Criteria) this;
        }

        public Criteria andFilterNotBetween(String value1, String value2) {
            addCriterion("filter not between", value1, value2, "filter");
            return (Criteria) this;
        }

        public Criteria andScanColumnIsNull() {
            addCriterion("scan_column is null");
            return (Criteria) this;
        }

        public Criteria andScanColumnIsNotNull() {
            addCriterion("scan_column is not null");
            return (Criteria) this;
        }

        public Criteria andScanColumnEqualTo(String value) {
            addCriterion("scan_column =", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnNotEqualTo(String value) {
            addCriterion("scan_column <>", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnGreaterThan(String value) {
            addCriterion("scan_column >", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnGreaterThanOrEqualTo(String value) {
            addCriterion("scan_column >=", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnLessThan(String value) {
            addCriterion("scan_column <", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnLessThanOrEqualTo(String value) {
            addCriterion("scan_column <=", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnLike(String value) {
            addCriterion("scan_column like", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnNotLike(String value) {
            addCriterion("scan_column not like", value, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnIn(List<String> values) {
            addCriterion("scan_column in", values, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnNotIn(List<String> values) {
            addCriterion("scan_column not in", values, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnBetween(String value1, String value2) {
            addCriterion("scan_column between", value1, value2, "scanColumn");
            return (Criteria) this;
        }

        public Criteria andScanColumnNotBetween(String value1, String value2) {
            addCriterion("scan_column not between", value1, value2, "scanColumn");
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