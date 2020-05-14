package dal.model.gas_marketpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserGroupListDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserGroupListDOExample() {
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

        public Criteria andUserGroupNoIsNull() {
            addCriterion("user_group_no is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoIsNotNull() {
            addCriterion("user_group_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoEqualTo(String value) {
            addCriterion("user_group_no =", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotEqualTo(String value) {
            addCriterion("user_group_no <>", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoGreaterThan(String value) {
            addCriterion("user_group_no >", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_group_no >=", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoLessThan(String value) {
            addCriterion("user_group_no <", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoLessThanOrEqualTo(String value) {
            addCriterion("user_group_no <=", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoLike(String value) {
            addCriterion("user_group_no like", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotLike(String value) {
            addCriterion("user_group_no not like", value, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoIn(List<String> values) {
            addCriterion("user_group_no in", values, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotIn(List<String> values) {
            addCriterion("user_group_no not in", values, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoBetween(String value1, String value2) {
            addCriterion("user_group_no between", value1, value2, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupNoNotBetween(String value1, String value2) {
            addCriterion("user_group_no not between", value1, value2, "userGroupNo");
            return (Criteria) this;
        }

        public Criteria andListTypeIsNull() {
            addCriterion("list_type is null");
            return (Criteria) this;
        }

        public Criteria andListTypeIsNotNull() {
            addCriterion("list_type is not null");
            return (Criteria) this;
        }

        public Criteria andListTypeEqualTo(String value) {
            addCriterion("list_type =", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotEqualTo(String value) {
            addCriterion("list_type <>", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeGreaterThan(String value) {
            addCriterion("list_type >", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeGreaterThanOrEqualTo(String value) {
            addCriterion("list_type >=", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeLessThan(String value) {
            addCriterion("list_type <", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeLessThanOrEqualTo(String value) {
            addCriterion("list_type <=", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeLike(String value) {
            addCriterion("list_type like", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotLike(String value) {
            addCriterion("list_type not like", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeIn(List<String> values) {
            addCriterion("list_type in", values, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotIn(List<String> values) {
            addCriterion("list_type not in", values, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeBetween(String value1, String value2) {
            addCriterion("list_type between", value1, value2, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotBetween(String value1, String value2) {
            addCriterion("list_type not between", value1, value2, "listType");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andSymbolNoIsNull() {
            addCriterion("symbol_no is null");
            return (Criteria) this;
        }

        public Criteria andSymbolNoIsNotNull() {
            addCriterion("symbol_no is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolNoEqualTo(String value) {
            addCriterion("symbol_no =", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoNotEqualTo(String value) {
            addCriterion("symbol_no <>", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoGreaterThan(String value) {
            addCriterion("symbol_no >", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoGreaterThanOrEqualTo(String value) {
            addCriterion("symbol_no >=", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoLessThan(String value) {
            addCriterion("symbol_no <", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoLessThanOrEqualTo(String value) {
            addCriterion("symbol_no <=", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoLike(String value) {
            addCriterion("symbol_no like", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoNotLike(String value) {
            addCriterion("symbol_no not like", value, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoIn(List<String> values) {
            addCriterion("symbol_no in", values, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoNotIn(List<String> values) {
            addCriterion("symbol_no not in", values, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoBetween(String value1, String value2) {
            addCriterion("symbol_no between", value1, value2, "symbolNo");
            return (Criteria) this;
        }

        public Criteria andSymbolNoNotBetween(String value1, String value2) {
            addCriterion("symbol_no not between", value1, value2, "symbolNo");
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