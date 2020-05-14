package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailHeadDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailHeadDOExample() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("model_id like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("model_id not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andHeadNameIsNull() {
            addCriterion("head_name is null");
            return (Criteria) this;
        }

        public Criteria andHeadNameIsNotNull() {
            addCriterion("head_name is not null");
            return (Criteria) this;
        }

        public Criteria andHeadNameEqualTo(String value) {
            addCriterion("head_name =", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameNotEqualTo(String value) {
            addCriterion("head_name <>", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameGreaterThan(String value) {
            addCriterion("head_name >", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameGreaterThanOrEqualTo(String value) {
            addCriterion("head_name >=", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameLessThan(String value) {
            addCriterion("head_name <", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameLessThanOrEqualTo(String value) {
            addCriterion("head_name <=", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameLike(String value) {
            addCriterion("head_name like", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameNotLike(String value) {
            addCriterion("head_name not like", value, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameIn(List<String> values) {
            addCriterion("head_name in", values, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameNotIn(List<String> values) {
            addCriterion("head_name not in", values, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameBetween(String value1, String value2) {
            addCriterion("head_name between", value1, value2, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadNameNotBetween(String value1, String value2) {
            addCriterion("head_name not between", value1, value2, "headName");
            return (Criteria) this;
        }

        public Criteria andHeadCodeIsNull() {
            addCriterion("head_code is null");
            return (Criteria) this;
        }

        public Criteria andHeadCodeIsNotNull() {
            addCriterion("head_code is not null");
            return (Criteria) this;
        }

        public Criteria andHeadCodeEqualTo(String value) {
            addCriterion("head_code =", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeNotEqualTo(String value) {
            addCriterion("head_code <>", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeGreaterThan(String value) {
            addCriterion("head_code >", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeGreaterThanOrEqualTo(String value) {
            addCriterion("head_code >=", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeLessThan(String value) {
            addCriterion("head_code <", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeLessThanOrEqualTo(String value) {
            addCriterion("head_code <=", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeLike(String value) {
            addCriterion("head_code like", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeNotLike(String value) {
            addCriterion("head_code not like", value, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeIn(List<String> values) {
            addCriterion("head_code in", values, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeNotIn(List<String> values) {
            addCriterion("head_code not in", values, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeBetween(String value1, String value2) {
            addCriterion("head_code between", value1, value2, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadCodeNotBetween(String value1, String value2) {
            addCriterion("head_code not between", value1, value2, "headCode");
            return (Criteria) this;
        }

        public Criteria andHeadColumnIsNull() {
            addCriterion("head_column is null");
            return (Criteria) this;
        }

        public Criteria andHeadColumnIsNotNull() {
            addCriterion("head_column is not null");
            return (Criteria) this;
        }

        public Criteria andHeadColumnEqualTo(String value) {
            addCriterion("head_column =", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnNotEqualTo(String value) {
            addCriterion("head_column <>", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnGreaterThan(String value) {
            addCriterion("head_column >", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnGreaterThanOrEqualTo(String value) {
            addCriterion("head_column >=", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnLessThan(String value) {
            addCriterion("head_column <", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnLessThanOrEqualTo(String value) {
            addCriterion("head_column <=", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnLike(String value) {
            addCriterion("head_column like", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnNotLike(String value) {
            addCriterion("head_column not like", value, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnIn(List<String> values) {
            addCriterion("head_column in", values, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnNotIn(List<String> values) {
            addCriterion("head_column not in", values, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnBetween(String value1, String value2) {
            addCriterion("head_column between", value1, value2, "headColumn");
            return (Criteria) this;
        }

        public Criteria andHeadColumnNotBetween(String value1, String value2) {
            addCriterion("head_column not between", value1, value2, "headColumn");
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

        public Criteria andFilterHeadConfigIsNull() {
            addCriterion("filter_head_config is null");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigIsNotNull() {
            addCriterion("filter_head_config is not null");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigEqualTo(String value) {
            addCriterion("filter_head_config =", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigNotEqualTo(String value) {
            addCriterion("filter_head_config <>", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigGreaterThan(String value) {
            addCriterion("filter_head_config >", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigGreaterThanOrEqualTo(String value) {
            addCriterion("filter_head_config >=", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigLessThan(String value) {
            addCriterion("filter_head_config <", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigLessThanOrEqualTo(String value) {
            addCriterion("filter_head_config <=", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigLike(String value) {
            addCriterion("filter_head_config like", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigNotLike(String value) {
            addCriterion("filter_head_config not like", value, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigIn(List<String> values) {
            addCriterion("filter_head_config in", values, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigNotIn(List<String> values) {
            addCriterion("filter_head_config not in", values, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigBetween(String value1, String value2) {
            addCriterion("filter_head_config between", value1, value2, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andFilterHeadConfigNotBetween(String value1, String value2) {
            addCriterion("filter_head_config not between", value1, value2, "filterHeadConfig");
            return (Criteria) this;
        }

        public Criteria andMaskIsNull() {
            addCriterion("mask is null");
            return (Criteria) this;
        }

        public Criteria andMaskIsNotNull() {
            addCriterion("mask is not null");
            return (Criteria) this;
        }

        public Criteria andMaskEqualTo(String value) {
            addCriterion("mask =", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskNotEqualTo(String value) {
            addCriterion("mask <>", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskGreaterThan(String value) {
            addCriterion("mask >", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskGreaterThanOrEqualTo(String value) {
            addCriterion("mask >=", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskLessThan(String value) {
            addCriterion("mask <", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskLessThanOrEqualTo(String value) {
            addCriterion("mask <=", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskLike(String value) {
            addCriterion("mask like", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskNotLike(String value) {
            addCriterion("mask not like", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskIn(List<String> values) {
            addCriterion("mask in", values, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskNotIn(List<String> values) {
            addCriterion("mask not in", values, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskBetween(String value1, String value2) {
            addCriterion("mask between", value1, value2, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskNotBetween(String value1, String value2) {
            addCriterion("mask not between", value1, value2, "mask");
            return (Criteria) this;
        }

        public Criteria andSumValueIsNull() {
            addCriterion("sum_value is null");
            return (Criteria) this;
        }

        public Criteria andSumValueIsNotNull() {
            addCriterion("sum_value is not null");
            return (Criteria) this;
        }

        public Criteria andSumValueEqualTo(String value) {
            addCriterion("sum_value =", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueNotEqualTo(String value) {
            addCriterion("sum_value <>", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueGreaterThan(String value) {
            addCriterion("sum_value >", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueGreaterThanOrEqualTo(String value) {
            addCriterion("sum_value >=", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueLessThan(String value) {
            addCriterion("sum_value <", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueLessThanOrEqualTo(String value) {
            addCriterion("sum_value <=", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueLike(String value) {
            addCriterion("sum_value like", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueNotLike(String value) {
            addCriterion("sum_value not like", value, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueIn(List<String> values) {
            addCriterion("sum_value in", values, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueNotIn(List<String> values) {
            addCriterion("sum_value not in", values, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueBetween(String value1, String value2) {
            addCriterion("sum_value between", value1, value2, "sumValue");
            return (Criteria) this;
        }

        public Criteria andSumValueNotBetween(String value1, String value2) {
            addCriterion("sum_value not between", value1, value2, "sumValue");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNull() {
            addCriterion("order_by is null");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNotNull() {
            addCriterion("order_by is not null");
            return (Criteria) this;
        }

        public Criteria andOrderByEqualTo(String value) {
            addCriterion("order_by =", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotEqualTo(String value) {
            addCriterion("order_by <>", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThan(String value) {
            addCriterion("order_by >", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThanOrEqualTo(String value) {
            addCriterion("order_by >=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThan(String value) {
            addCriterion("order_by <", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThanOrEqualTo(String value) {
            addCriterion("order_by <=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLike(String value) {
            addCriterion("order_by like", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotLike(String value) {
            addCriterion("order_by not like", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByIn(List<String> values) {
            addCriterion("order_by in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotIn(List<String> values) {
            addCriterion("order_by not in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByBetween(String value1, String value2) {
            addCriterion("order_by between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotBetween(String value1, String value2) {
            addCriterion("order_by not between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOnShowIsNull() {
            addCriterion("on_show is null");
            return (Criteria) this;
        }

        public Criteria andOnShowIsNotNull() {
            addCriterion("on_show is not null");
            return (Criteria) this;
        }

        public Criteria andOnShowEqualTo(String value) {
            addCriterion("on_show =", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowNotEqualTo(String value) {
            addCriterion("on_show <>", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowGreaterThan(String value) {
            addCriterion("on_show >", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowGreaterThanOrEqualTo(String value) {
            addCriterion("on_show >=", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowLessThan(String value) {
            addCriterion("on_show <", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowLessThanOrEqualTo(String value) {
            addCriterion("on_show <=", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowLike(String value) {
            addCriterion("on_show like", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowNotLike(String value) {
            addCriterion("on_show not like", value, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowIn(List<String> values) {
            addCriterion("on_show in", values, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowNotIn(List<String> values) {
            addCriterion("on_show not in", values, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowBetween(String value1, String value2) {
            addCriterion("on_show between", value1, value2, "onShow");
            return (Criteria) this;
        }

        public Criteria andOnShowNotBetween(String value1, String value2) {
            addCriterion("on_show not between", value1, value2, "onShow");
            return (Criteria) this;
        }

        public Criteria andHeadMemoIsNull() {
            addCriterion("head_memo is null");
            return (Criteria) this;
        }

        public Criteria andHeadMemoIsNotNull() {
            addCriterion("head_memo is not null");
            return (Criteria) this;
        }

        public Criteria andHeadMemoEqualTo(String value) {
            addCriterion("head_memo =", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoNotEqualTo(String value) {
            addCriterion("head_memo <>", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoGreaterThan(String value) {
            addCriterion("head_memo >", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoGreaterThanOrEqualTo(String value) {
            addCriterion("head_memo >=", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoLessThan(String value) {
            addCriterion("head_memo <", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoLessThanOrEqualTo(String value) {
            addCriterion("head_memo <=", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoLike(String value) {
            addCriterion("head_memo like", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoNotLike(String value) {
            addCriterion("head_memo not like", value, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoIn(List<String> values) {
            addCriterion("head_memo in", values, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoNotIn(List<String> values) {
            addCriterion("head_memo not in", values, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoBetween(String value1, String value2) {
            addCriterion("head_memo between", value1, value2, "headMemo");
            return (Criteria) this;
        }

        public Criteria andHeadMemoNotBetween(String value1, String value2) {
            addCriterion("head_memo not between", value1, value2, "headMemo");
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