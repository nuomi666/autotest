package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.List;

public class TmpPointsGoodsMapDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmpPointsGoodsMapDOExample() {
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

        public Criteria andOldPointsGoodsIdIsNull() {
            addCriterion("old_points_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdIsNotNull() {
            addCriterion("old_points_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdEqualTo(String value) {
            addCriterion("old_points_goods_id =", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdNotEqualTo(String value) {
            addCriterion("old_points_goods_id <>", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdGreaterThan(String value) {
            addCriterion("old_points_goods_id >", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("old_points_goods_id >=", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdLessThan(String value) {
            addCriterion("old_points_goods_id <", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("old_points_goods_id <=", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdLike(String value) {
            addCriterion("old_points_goods_id like", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdNotLike(String value) {
            addCriterion("old_points_goods_id not like", value, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdIn(List<String> values) {
            addCriterion("old_points_goods_id in", values, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdNotIn(List<String> values) {
            addCriterion("old_points_goods_id not in", values, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdBetween(String value1, String value2) {
            addCriterion("old_points_goods_id between", value1, value2, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andOldPointsGoodsIdNotBetween(String value1, String value2) {
            addCriterion("old_points_goods_id not between", value1, value2, "oldPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdIsNull() {
            addCriterion("new_points_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdIsNotNull() {
            addCriterion("new_points_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdEqualTo(String value) {
            addCriterion("new_points_goods_id =", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdNotEqualTo(String value) {
            addCriterion("new_points_goods_id <>", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdGreaterThan(String value) {
            addCriterion("new_points_goods_id >", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("new_points_goods_id >=", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdLessThan(String value) {
            addCriterion("new_points_goods_id <", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("new_points_goods_id <=", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdLike(String value) {
            addCriterion("new_points_goods_id like", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdNotLike(String value) {
            addCriterion("new_points_goods_id not like", value, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdIn(List<String> values) {
            addCriterion("new_points_goods_id in", values, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdNotIn(List<String> values) {
            addCriterion("new_points_goods_id not in", values, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdBetween(String value1, String value2) {
            addCriterion("new_points_goods_id between", value1, value2, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andNewPointsGoodsIdNotBetween(String value1, String value2) {
            addCriterion("new_points_goods_id not between", value1, value2, "newPointsGoodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
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