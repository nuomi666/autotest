package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsModelDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsModelDOExample() {
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

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(String value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(String value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(String value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(String value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(String value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLike(String value) {
            addCriterion("model_type like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotLike(String value) {
            addCriterion("model_type not like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<String> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<String> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(String value1, String value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(String value1, String value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andOffSetIsNull() {
            addCriterion("off_set is null");
            return (Criteria) this;
        }

        public Criteria andOffSetIsNotNull() {
            addCriterion("off_set is not null");
            return (Criteria) this;
        }

        public Criteria andOffSetEqualTo(Long value) {
            addCriterion("off_set =", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetNotEqualTo(Long value) {
            addCriterion("off_set <>", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetGreaterThan(Long value) {
            addCriterion("off_set >", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetGreaterThanOrEqualTo(Long value) {
            addCriterion("off_set >=", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetLessThan(Long value) {
            addCriterion("off_set <", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetLessThanOrEqualTo(Long value) {
            addCriterion("off_set <=", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetIn(List<Long> values) {
            addCriterion("off_set in", values, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetNotIn(List<Long> values) {
            addCriterion("off_set not in", values, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetBetween(Long value1, Long value2) {
            addCriterion("off_set between", value1, value2, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetNotBetween(Long value1, Long value2) {
            addCriterion("off_set not between", value1, value2, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetExprIsNull() {
            addCriterion("off_set_expr is null");
            return (Criteria) this;
        }

        public Criteria andOffSetExprIsNotNull() {
            addCriterion("off_set_expr is not null");
            return (Criteria) this;
        }

        public Criteria andOffSetExprEqualTo(String value) {
            addCriterion("off_set_expr =", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprNotEqualTo(String value) {
            addCriterion("off_set_expr <>", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprGreaterThan(String value) {
            addCriterion("off_set_expr >", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprGreaterThanOrEqualTo(String value) {
            addCriterion("off_set_expr >=", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprLessThan(String value) {
            addCriterion("off_set_expr <", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprLessThanOrEqualTo(String value) {
            addCriterion("off_set_expr <=", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprLike(String value) {
            addCriterion("off_set_expr like", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprNotLike(String value) {
            addCriterion("off_set_expr not like", value, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprIn(List<String> values) {
            addCriterion("off_set_expr in", values, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprNotIn(List<String> values) {
            addCriterion("off_set_expr not in", values, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprBetween(String value1, String value2) {
            addCriterion("off_set_expr between", value1, value2, "offSetExpr");
            return (Criteria) this;
        }

        public Criteria andOffSetExprNotBetween(String value1, String value2) {
            addCriterion("off_set_expr not between", value1, value2, "offSetExpr");
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

        public Criteria andWindowTypeIsNull() {
            addCriterion("window_type is null");
            return (Criteria) this;
        }

        public Criteria andWindowTypeIsNotNull() {
            addCriterion("window_type is not null");
            return (Criteria) this;
        }

        public Criteria andWindowTypeEqualTo(String value) {
            addCriterion("window_type =", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeNotEqualTo(String value) {
            addCriterion("window_type <>", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeGreaterThan(String value) {
            addCriterion("window_type >", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("window_type >=", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeLessThan(String value) {
            addCriterion("window_type <", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeLessThanOrEqualTo(String value) {
            addCriterion("window_type <=", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeLike(String value) {
            addCriterion("window_type like", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeNotLike(String value) {
            addCriterion("window_type not like", value, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeIn(List<String> values) {
            addCriterion("window_type in", values, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeNotIn(List<String> values) {
            addCriterion("window_type not in", values, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeBetween(String value1, String value2) {
            addCriterion("window_type between", value1, value2, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowTypeNotBetween(String value1, String value2) {
            addCriterion("window_type not between", value1, value2, "windowType");
            return (Criteria) this;
        }

        public Criteria andWindowUnitIsNull() {
            addCriterion("window_unit is null");
            return (Criteria) this;
        }

        public Criteria andWindowUnitIsNotNull() {
            addCriterion("window_unit is not null");
            return (Criteria) this;
        }

        public Criteria andWindowUnitEqualTo(String value) {
            addCriterion("window_unit =", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitNotEqualTo(String value) {
            addCriterion("window_unit <>", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitGreaterThan(String value) {
            addCriterion("window_unit >", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitGreaterThanOrEqualTo(String value) {
            addCriterion("window_unit >=", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitLessThan(String value) {
            addCriterion("window_unit <", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitLessThanOrEqualTo(String value) {
            addCriterion("window_unit <=", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitLike(String value) {
            addCriterion("window_unit like", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitNotLike(String value) {
            addCriterion("window_unit not like", value, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitIn(List<String> values) {
            addCriterion("window_unit in", values, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitNotIn(List<String> values) {
            addCriterion("window_unit not in", values, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitBetween(String value1, String value2) {
            addCriterion("window_unit between", value1, value2, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowUnitNotBetween(String value1, String value2) {
            addCriterion("window_unit not between", value1, value2, "windowUnit");
            return (Criteria) this;
        }

        public Criteria andWindowLengthIsNull() {
            addCriterion("window_length is null");
            return (Criteria) this;
        }

        public Criteria andWindowLengthIsNotNull() {
            addCriterion("window_length is not null");
            return (Criteria) this;
        }

        public Criteria andWindowLengthEqualTo(Integer value) {
            addCriterion("window_length =", value, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthNotEqualTo(Integer value) {
            addCriterion("window_length <>", value, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthGreaterThan(Integer value) {
            addCriterion("window_length >", value, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("window_length >=", value, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthLessThan(Integer value) {
            addCriterion("window_length <", value, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthLessThanOrEqualTo(Integer value) {
            addCriterion("window_length <=", value, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthIn(List<Integer> values) {
            addCriterion("window_length in", values, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthNotIn(List<Integer> values) {
            addCriterion("window_length not in", values, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthBetween(Integer value1, Integer value2) {
            addCriterion("window_length between", value1, value2, "windowLength");
            return (Criteria) this;
        }

        public Criteria andWindowLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("window_length not between", value1, value2, "windowLength");
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

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(String value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(String value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(String value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(String value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(String value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(String value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLike(String value) {
            addCriterion("enable like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotLike(String value) {
            addCriterion("enable not like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<String> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<String> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(String value1, String value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(String value1, String value2) {
            addCriterion("enable not between", value1, value2, "enable");
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

        public Criteria andAggregatesIsNull() {
            addCriterion("aggregates is null");
            return (Criteria) this;
        }

        public Criteria andAggregatesIsNotNull() {
            addCriterion("aggregates is not null");
            return (Criteria) this;
        }

        public Criteria andAggregatesEqualTo(String value) {
            addCriterion("aggregates =", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesNotEqualTo(String value) {
            addCriterion("aggregates <>", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesGreaterThan(String value) {
            addCriterion("aggregates >", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesGreaterThanOrEqualTo(String value) {
            addCriterion("aggregates >=", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesLessThan(String value) {
            addCriterion("aggregates <", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesLessThanOrEqualTo(String value) {
            addCriterion("aggregates <=", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesLike(String value) {
            addCriterion("aggregates like", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesNotLike(String value) {
            addCriterion("aggregates not like", value, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesIn(List<String> values) {
            addCriterion("aggregates in", values, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesNotIn(List<String> values) {
            addCriterion("aggregates not in", values, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesBetween(String value1, String value2) {
            addCriterion("aggregates between", value1, value2, "aggregates");
            return (Criteria) this;
        }

        public Criteria andAggregatesNotBetween(String value1, String value2) {
            addCriterion("aggregates not between", value1, value2, "aggregates");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNull() {
            addCriterion("conditions is null");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNotNull() {
            addCriterion("conditions is not null");
            return (Criteria) this;
        }

        public Criteria andConditionsEqualTo(String value) {
            addCriterion("conditions =", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotEqualTo(String value) {
            addCriterion("conditions <>", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThan(String value) {
            addCriterion("conditions >", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThanOrEqualTo(String value) {
            addCriterion("conditions >=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThan(String value) {
            addCriterion("conditions <", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThanOrEqualTo(String value) {
            addCriterion("conditions <=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLike(String value) {
            addCriterion("conditions like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotLike(String value) {
            addCriterion("conditions not like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsIn(List<String> values) {
            addCriterion("conditions in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotIn(List<String> values) {
            addCriterion("conditions not in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsBetween(String value1, String value2) {
            addCriterion("conditions between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotBetween(String value1, String value2) {
            addCriterion("conditions not between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNull() {
            addCriterion("groups is null");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNotNull() {
            addCriterion("groups is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsEqualTo(String value) {
            addCriterion("groups =", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotEqualTo(String value) {
            addCriterion("groups <>", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThan(String value) {
            addCriterion("groups >", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThanOrEqualTo(String value) {
            addCriterion("groups >=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThan(String value) {
            addCriterion("groups <", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThanOrEqualTo(String value) {
            addCriterion("groups <=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLike(String value) {
            addCriterion("groups like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotLike(String value) {
            addCriterion("groups not like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsIn(List<String> values) {
            addCriterion("groups in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotIn(List<String> values) {
            addCriterion("groups not in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsBetween(String value1, String value2) {
            addCriterion("groups between", value1, value2, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotBetween(String value1, String value2) {
            addCriterion("groups not between", value1, value2, "groups");
            return (Criteria) this;
        }

        public Criteria andDistinctsIsNull() {
            addCriterion("distincts is null");
            return (Criteria) this;
        }

        public Criteria andDistinctsIsNotNull() {
            addCriterion("distincts is not null");
            return (Criteria) this;
        }

        public Criteria andDistinctsEqualTo(String value) {
            addCriterion("distincts =", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsNotEqualTo(String value) {
            addCriterion("distincts <>", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsGreaterThan(String value) {
            addCriterion("distincts >", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsGreaterThanOrEqualTo(String value) {
            addCriterion("distincts >=", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsLessThan(String value) {
            addCriterion("distincts <", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsLessThanOrEqualTo(String value) {
            addCriterion("distincts <=", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsLike(String value) {
            addCriterion("distincts like", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsNotLike(String value) {
            addCriterion("distincts not like", value, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsIn(List<String> values) {
            addCriterion("distincts in", values, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsNotIn(List<String> values) {
            addCriterion("distincts not in", values, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsBetween(String value1, String value2) {
            addCriterion("distincts between", value1, value2, "distincts");
            return (Criteria) this;
        }

        public Criteria andDistinctsNotBetween(String value1, String value2) {
            addCriterion("distincts not between", value1, value2, "distincts");
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