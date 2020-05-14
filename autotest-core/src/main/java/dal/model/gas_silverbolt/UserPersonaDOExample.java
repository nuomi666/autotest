package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPersonaDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserPersonaDOExample() {
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

        public Criteria andPersonaNameIsNull() {
            addCriterion("persona_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonaNameIsNotNull() {
            addCriterion("persona_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonaNameEqualTo(String value) {
            addCriterion("persona_name =", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameNotEqualTo(String value) {
            addCriterion("persona_name <>", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameGreaterThan(String value) {
            addCriterion("persona_name >", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameGreaterThanOrEqualTo(String value) {
            addCriterion("persona_name >=", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameLessThan(String value) {
            addCriterion("persona_name <", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameLessThanOrEqualTo(String value) {
            addCriterion("persona_name <=", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameLike(String value) {
            addCriterion("persona_name like", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameNotLike(String value) {
            addCriterion("persona_name not like", value, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameIn(List<String> values) {
            addCriterion("persona_name in", values, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameNotIn(List<String> values) {
            addCriterion("persona_name not in", values, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameBetween(String value1, String value2) {
            addCriterion("persona_name between", value1, value2, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaNameNotBetween(String value1, String value2) {
            addCriterion("persona_name not between", value1, value2, "personaName");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeIsNull() {
            addCriterion("persona_code is null");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeIsNotNull() {
            addCriterion("persona_code is not null");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeEqualTo(String value) {
            addCriterion("persona_code =", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeNotEqualTo(String value) {
            addCriterion("persona_code <>", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeGreaterThan(String value) {
            addCriterion("persona_code >", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("persona_code >=", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeLessThan(String value) {
            addCriterion("persona_code <", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeLessThanOrEqualTo(String value) {
            addCriterion("persona_code <=", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeLike(String value) {
            addCriterion("persona_code like", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeNotLike(String value) {
            addCriterion("persona_code not like", value, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeIn(List<String> values) {
            addCriterion("persona_code in", values, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeNotIn(List<String> values) {
            addCriterion("persona_code not in", values, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeBetween(String value1, String value2) {
            addCriterion("persona_code between", value1, value2, "personaCode");
            return (Criteria) this;
        }

        public Criteria andPersonaCodeNotBetween(String value1, String value2) {
            addCriterion("persona_code not between", value1, value2, "personaCode");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusIsNull() {
            addCriterion("calculate_status is null");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusIsNotNull() {
            addCriterion("calculate_status is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusEqualTo(String value) {
            addCriterion("calculate_status =", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusNotEqualTo(String value) {
            addCriterion("calculate_status <>", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusGreaterThan(String value) {
            addCriterion("calculate_status >", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusGreaterThanOrEqualTo(String value) {
            addCriterion("calculate_status >=", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusLessThan(String value) {
            addCriterion("calculate_status <", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusLessThanOrEqualTo(String value) {
            addCriterion("calculate_status <=", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusLike(String value) {
            addCriterion("calculate_status like", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusNotLike(String value) {
            addCriterion("calculate_status not like", value, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusIn(List<String> values) {
            addCriterion("calculate_status in", values, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusNotIn(List<String> values) {
            addCriterion("calculate_status not in", values, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusBetween(String value1, String value2) {
            addCriterion("calculate_status between", value1, value2, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andCalculateStatusNotBetween(String value1, String value2) {
            addCriterion("calculate_status not between", value1, value2, "calculateStatus");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNull() {
            addCriterion("scan_count is null");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNotNull() {
            addCriterion("scan_count is not null");
            return (Criteria) this;
        }

        public Criteria andScanCountEqualTo(Integer value) {
            addCriterion("scan_count =", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotEqualTo(Integer value) {
            addCriterion("scan_count <>", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThan(Integer value) {
            addCriterion("scan_count >", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_count >=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThan(Integer value) {
            addCriterion("scan_count <", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThanOrEqualTo(Integer value) {
            addCriterion("scan_count <=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountIn(List<Integer> values) {
            addCriterion("scan_count in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotIn(List<Integer> values) {
            addCriterion("scan_count not in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountBetween(Integer value1, Integer value2) {
            addCriterion("scan_count between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_count not between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanSizeIsNull() {
            addCriterion("scan_size is null");
            return (Criteria) this;
        }

        public Criteria andScanSizeIsNotNull() {
            addCriterion("scan_size is not null");
            return (Criteria) this;
        }

        public Criteria andScanSizeEqualTo(Integer value) {
            addCriterion("scan_size =", value, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeNotEqualTo(Integer value) {
            addCriterion("scan_size <>", value, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeGreaterThan(Integer value) {
            addCriterion("scan_size >", value, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_size >=", value, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeLessThan(Integer value) {
            addCriterion("scan_size <", value, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeLessThanOrEqualTo(Integer value) {
            addCriterion("scan_size <=", value, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeIn(List<Integer> values) {
            addCriterion("scan_size in", values, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeNotIn(List<Integer> values) {
            addCriterion("scan_size not in", values, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeBetween(Integer value1, Integer value2) {
            addCriterion("scan_size between", value1, value2, "scanSize");
            return (Criteria) this;
        }

        public Criteria andScanSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_size not between", value1, value2, "scanSize");
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