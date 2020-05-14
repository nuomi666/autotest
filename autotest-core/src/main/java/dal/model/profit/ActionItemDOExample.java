package dal.model.profit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionItemDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActionItemDOExample() {
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andTerminiIsNull() {
            addCriterion("termini is null");
            return (Criteria) this;
        }

        public Criteria andTerminiIsNotNull() {
            addCriterion("termini is not null");
            return (Criteria) this;
        }

        public Criteria andTerminiEqualTo(String value) {
            addCriterion("termini =", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiNotEqualTo(String value) {
            addCriterion("termini <>", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiGreaterThan(String value) {
            addCriterion("termini >", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiGreaterThanOrEqualTo(String value) {
            addCriterion("termini >=", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiLessThan(String value) {
            addCriterion("termini <", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiLessThanOrEqualTo(String value) {
            addCriterion("termini <=", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiLike(String value) {
            addCriterion("termini like", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiNotLike(String value) {
            addCriterion("termini not like", value, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiIn(List<String> values) {
            addCriterion("termini in", values, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiNotIn(List<String> values) {
            addCriterion("termini not in", values, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiBetween(String value1, String value2) {
            addCriterion("termini between", value1, value2, "termini");
            return (Criteria) this;
        }

        public Criteria andTerminiNotBetween(String value1, String value2) {
            addCriterion("termini not between", value1, value2, "termini");
            return (Criteria) this;
        }

        public Criteria andActionExprIsNull() {
            addCriterion("action_expr is null");
            return (Criteria) this;
        }

        public Criteria andActionExprIsNotNull() {
            addCriterion("action_expr is not null");
            return (Criteria) this;
        }

        public Criteria andActionExprEqualTo(String value) {
            addCriterion("action_expr =", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprNotEqualTo(String value) {
            addCriterion("action_expr <>", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprGreaterThan(String value) {
            addCriterion("action_expr >", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprGreaterThanOrEqualTo(String value) {
            addCriterion("action_expr >=", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprLessThan(String value) {
            addCriterion("action_expr <", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprLessThanOrEqualTo(String value) {
            addCriterion("action_expr <=", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprLike(String value) {
            addCriterion("action_expr like", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprNotLike(String value) {
            addCriterion("action_expr not like", value, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprIn(List<String> values) {
            addCriterion("action_expr in", values, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprNotIn(List<String> values) {
            addCriterion("action_expr not in", values, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprBetween(String value1, String value2) {
            addCriterion("action_expr between", value1, value2, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andActionExprNotBetween(String value1, String value2) {
            addCriterion("action_expr not between", value1, value2, "actionExpr");
            return (Criteria) this;
        }

        public Criteria andAlgIsNull() {
            addCriterion("alg is null");
            return (Criteria) this;
        }

        public Criteria andAlgIsNotNull() {
            addCriterion("alg is not null");
            return (Criteria) this;
        }

        public Criteria andAlgEqualTo(String value) {
            addCriterion("alg =", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgNotEqualTo(String value) {
            addCriterion("alg <>", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgGreaterThan(String value) {
            addCriterion("alg >", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgGreaterThanOrEqualTo(String value) {
            addCriterion("alg >=", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgLessThan(String value) {
            addCriterion("alg <", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgLessThanOrEqualTo(String value) {
            addCriterion("alg <=", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgLike(String value) {
            addCriterion("alg like", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgNotLike(String value) {
            addCriterion("alg not like", value, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgIn(List<String> values) {
            addCriterion("alg in", values, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgNotIn(List<String> values) {
            addCriterion("alg not in", values, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgBetween(String value1, String value2) {
            addCriterion("alg between", value1, value2, "alg");
            return (Criteria) this;
        }

        public Criteria andAlgNotBetween(String value1, String value2) {
            addCriterion("alg not between", value1, value2, "alg");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdIsNull() {
            addCriterion("action_strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdIsNotNull() {
            addCriterion("action_strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdEqualTo(Long value) {
            addCriterion("action_strategy_id =", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdNotEqualTo(Long value) {
            addCriterion("action_strategy_id <>", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdGreaterThan(Long value) {
            addCriterion("action_strategy_id >", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("action_strategy_id >=", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdLessThan(Long value) {
            addCriterion("action_strategy_id <", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdLessThanOrEqualTo(Long value) {
            addCriterion("action_strategy_id <=", value, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdIn(List<Long> values) {
            addCriterion("action_strategy_id in", values, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdNotIn(List<Long> values) {
            addCriterion("action_strategy_id not in", values, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdBetween(Long value1, Long value2) {
            addCriterion("action_strategy_id between", value1, value2, "actionStrategyId");
            return (Criteria) this;
        }

        public Criteria andActionStrategyIdNotBetween(Long value1, Long value2) {
            addCriterion("action_strategy_id not between", value1, value2, "actionStrategyId");
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