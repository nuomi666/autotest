package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsGroupColumnDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsGroupColumnDOExample() {
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

        public Criteria andColumnNameIsNull() {
            addCriterion("column_name is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("column_name is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(String value) {
            addCriterion("column_name =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(String value) {
            addCriterion("column_name <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(String value) {
            addCriterion("column_name >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("column_name >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(String value) {
            addCriterion("column_name <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(String value) {
            addCriterion("column_name <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLike(String value) {
            addCriterion("column_name like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotLike(String value) {
            addCriterion("column_name not like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<String> values) {
            addCriterion("column_name in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<String> values) {
            addCriterion("column_name not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(String value1, String value2) {
            addCriterion("column_name between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(String value1, String value2) {
            addCriterion("column_name not between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnCodeIsNull() {
            addCriterion("column_code is null");
            return (Criteria) this;
        }

        public Criteria andColumnCodeIsNotNull() {
            addCriterion("column_code is not null");
            return (Criteria) this;
        }

        public Criteria andColumnCodeEqualTo(String value) {
            addCriterion("column_code =", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeNotEqualTo(String value) {
            addCriterion("column_code <>", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeGreaterThan(String value) {
            addCriterion("column_code >", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("column_code >=", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeLessThan(String value) {
            addCriterion("column_code <", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeLessThanOrEqualTo(String value) {
            addCriterion("column_code <=", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeLike(String value) {
            addCriterion("column_code like", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeNotLike(String value) {
            addCriterion("column_code not like", value, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeIn(List<String> values) {
            addCriterion("column_code in", values, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeNotIn(List<String> values) {
            addCriterion("column_code not in", values, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeBetween(String value1, String value2) {
            addCriterion("column_code between", value1, value2, "columnCode");
            return (Criteria) this;
        }

        public Criteria andColumnCodeNotBetween(String value1, String value2) {
            addCriterion("column_code not between", value1, value2, "columnCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeIsNull() {
            addCriterion("order_by_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeIsNotNull() {
            addCriterion("order_by_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeEqualTo(String value) {
            addCriterion("order_by_code =", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeNotEqualTo(String value) {
            addCriterion("order_by_code <>", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeGreaterThan(String value) {
            addCriterion("order_by_code >", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_by_code >=", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeLessThan(String value) {
            addCriterion("order_by_code <", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeLessThanOrEqualTo(String value) {
            addCriterion("order_by_code <=", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeLike(String value) {
            addCriterion("order_by_code like", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeNotLike(String value) {
            addCriterion("order_by_code not like", value, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeIn(List<String> values) {
            addCriterion("order_by_code in", values, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeNotIn(List<String> values) {
            addCriterion("order_by_code not in", values, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeBetween(String value1, String value2) {
            addCriterion("order_by_code between", value1, value2, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andOrderByCodeNotBetween(String value1, String value2) {
            addCriterion("order_by_code not between", value1, value2, "orderByCode");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNull() {
            addCriterion("column_type is null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNotNull() {
            addCriterion("column_type is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeEqualTo(String value) {
            addCriterion("column_type =", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotEqualTo(String value) {
            addCriterion("column_type <>", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThan(String value) {
            addCriterion("column_type >", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("column_type >=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThan(String value) {
            addCriterion("column_type <", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThanOrEqualTo(String value) {
            addCriterion("column_type <=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLike(String value) {
            addCriterion("column_type like", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotLike(String value) {
            addCriterion("column_type not like", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIn(List<String> values) {
            addCriterion("column_type in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotIn(List<String> values) {
            addCriterion("column_type not in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeBetween(String value1, String value2) {
            addCriterion("column_type between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotBetween(String value1, String value2) {
            addCriterion("column_type not between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andMustFilterIsNull() {
            addCriterion("must_filter is null");
            return (Criteria) this;
        }

        public Criteria andMustFilterIsNotNull() {
            addCriterion("must_filter is not null");
            return (Criteria) this;
        }

        public Criteria andMustFilterEqualTo(String value) {
            addCriterion("must_filter =", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterNotEqualTo(String value) {
            addCriterion("must_filter <>", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterGreaterThan(String value) {
            addCriterion("must_filter >", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterGreaterThanOrEqualTo(String value) {
            addCriterion("must_filter >=", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterLessThan(String value) {
            addCriterion("must_filter <", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterLessThanOrEqualTo(String value) {
            addCriterion("must_filter <=", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterLike(String value) {
            addCriterion("must_filter like", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterNotLike(String value) {
            addCriterion("must_filter not like", value, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterIn(List<String> values) {
            addCriterion("must_filter in", values, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterNotIn(List<String> values) {
            addCriterion("must_filter not in", values, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterBetween(String value1, String value2) {
            addCriterion("must_filter between", value1, value2, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andMustFilterNotBetween(String value1, String value2) {
            addCriterion("must_filter not between", value1, value2, "mustFilter");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNull() {
            addCriterion("subtotal is null");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNotNull() {
            addCriterion("subtotal is not null");
            return (Criteria) this;
        }

        public Criteria andSubtotalEqualTo(String value) {
            addCriterion("subtotal =", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotEqualTo(String value) {
            addCriterion("subtotal <>", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThan(String value) {
            addCriterion("subtotal >", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThanOrEqualTo(String value) {
            addCriterion("subtotal >=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThan(String value) {
            addCriterion("subtotal <", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThanOrEqualTo(String value) {
            addCriterion("subtotal <=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLike(String value) {
            addCriterion("subtotal like", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotLike(String value) {
            addCriterion("subtotal not like", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalIn(List<String> values) {
            addCriterion("subtotal in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotIn(List<String> values) {
            addCriterion("subtotal not in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalBetween(String value1, String value2) {
            addCriterion("subtotal between", value1, value2, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotBetween(String value1, String value2) {
            addCriterion("subtotal not between", value1, value2, "subtotal");
            return (Criteria) this;
        }

        public Criteria andAcrossIsNull() {
            addCriterion("across is null");
            return (Criteria) this;
        }

        public Criteria andAcrossIsNotNull() {
            addCriterion("across is not null");
            return (Criteria) this;
        }

        public Criteria andAcrossEqualTo(String value) {
            addCriterion("across =", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossNotEqualTo(String value) {
            addCriterion("across <>", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossGreaterThan(String value) {
            addCriterion("across >", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossGreaterThanOrEqualTo(String value) {
            addCriterion("across >=", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossLessThan(String value) {
            addCriterion("across <", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossLessThanOrEqualTo(String value) {
            addCriterion("across <=", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossLike(String value) {
            addCriterion("across like", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossNotLike(String value) {
            addCriterion("across not like", value, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossIn(List<String> values) {
            addCriterion("across in", values, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossNotIn(List<String> values) {
            addCriterion("across not in", values, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossBetween(String value1, String value2) {
            addCriterion("across between", value1, value2, "across");
            return (Criteria) this;
        }

        public Criteria andAcrossNotBetween(String value1, String value2) {
            addCriterion("across not between", value1, value2, "across");
            return (Criteria) this;
        }

        public Criteria andCycleIsNull() {
            addCriterion("cycle is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(String value) {
            addCriterion("cycle =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(String value) {
            addCriterion("cycle <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(String value) {
            addCriterion("cycle >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(String value) {
            addCriterion("cycle >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(String value) {
            addCriterion("cycle <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(String value) {
            addCriterion("cycle <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLike(String value) {
            addCriterion("cycle like", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotLike(String value) {
            addCriterion("cycle not like", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(List<String> values) {
            addCriterion("cycle in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(List<String> values) {
            addCriterion("cycle not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(String value1, String value2) {
            addCriterion("cycle between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(String value1, String value2) {
            addCriterion("cycle not between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andShowValueIsNull() {
            addCriterion("show_value is null");
            return (Criteria) this;
        }

        public Criteria andShowValueIsNotNull() {
            addCriterion("show_value is not null");
            return (Criteria) this;
        }

        public Criteria andShowValueEqualTo(String value) {
            addCriterion("show_value =", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueNotEqualTo(String value) {
            addCriterion("show_value <>", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueGreaterThan(String value) {
            addCriterion("show_value >", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueGreaterThanOrEqualTo(String value) {
            addCriterion("show_value >=", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueLessThan(String value) {
            addCriterion("show_value <", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueLessThanOrEqualTo(String value) {
            addCriterion("show_value <=", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueLike(String value) {
            addCriterion("show_value like", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueNotLike(String value) {
            addCriterion("show_value not like", value, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueIn(List<String> values) {
            addCriterion("show_value in", values, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueNotIn(List<String> values) {
            addCriterion("show_value not in", values, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueBetween(String value1, String value2) {
            addCriterion("show_value between", value1, value2, "showValue");
            return (Criteria) this;
        }

        public Criteria andShowValueNotBetween(String value1, String value2) {
            addCriterion("show_value not between", value1, value2, "showValue");
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