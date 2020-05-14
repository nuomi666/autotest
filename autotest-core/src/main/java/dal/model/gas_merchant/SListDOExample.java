package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.List;

public class SListDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SListDOExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andName1IsNull() {
            addCriterion("name1 is null");
            return (Criteria) this;
        }

        public Criteria andName1IsNotNull() {
            addCriterion("name1 is not null");
            return (Criteria) this;
        }

        public Criteria andName1EqualTo(String value) {
            addCriterion("name1 =", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotEqualTo(String value) {
            addCriterion("name1 <>", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThan(String value) {
            addCriterion("name1 >", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThanOrEqualTo(String value) {
            addCriterion("name1 >=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThan(String value) {
            addCriterion("name1 <", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThanOrEqualTo(String value) {
            addCriterion("name1 <=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Like(String value) {
            addCriterion("name1 like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotLike(String value) {
            addCriterion("name1 not like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1In(List<String> values) {
            addCriterion("name1 in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotIn(List<String> values) {
            addCriterion("name1 not in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Between(String value1, String value2) {
            addCriterion("name1 between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotBetween(String value1, String value2) {
            addCriterion("name1 not between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andC1IsNull() {
            addCriterion("c1 is null");
            return (Criteria) this;
        }

        public Criteria andC1IsNotNull() {
            addCriterion("c1 is not null");
            return (Criteria) this;
        }

        public Criteria andC1EqualTo(String value) {
            addCriterion("c1 =", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotEqualTo(String value) {
            addCriterion("c1 <>", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThan(String value) {
            addCriterion("c1 >", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThanOrEqualTo(String value) {
            addCriterion("c1 >=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThan(String value) {
            addCriterion("c1 <", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThanOrEqualTo(String value) {
            addCriterion("c1 <=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Like(String value) {
            addCriterion("c1 like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotLike(String value) {
            addCriterion("c1 not like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1In(List<String> values) {
            addCriterion("c1 in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotIn(List<String> values) {
            addCriterion("c1 not in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Between(String value1, String value2) {
            addCriterion("c1 between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotBetween(String value1, String value2) {
            addCriterion("c1 not between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC2IsNull() {
            addCriterion("c2 is null");
            return (Criteria) this;
        }

        public Criteria andC2IsNotNull() {
            addCriterion("c2 is not null");
            return (Criteria) this;
        }

        public Criteria andC2EqualTo(String value) {
            addCriterion("c2 =", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotEqualTo(String value) {
            addCriterion("c2 <>", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThan(String value) {
            addCriterion("c2 >", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThanOrEqualTo(String value) {
            addCriterion("c2 >=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThan(String value) {
            addCriterion("c2 <", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThanOrEqualTo(String value) {
            addCriterion("c2 <=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Like(String value) {
            addCriterion("c2 like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotLike(String value) {
            addCriterion("c2 not like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2In(List<String> values) {
            addCriterion("c2 in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotIn(List<String> values) {
            addCriterion("c2 not in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Between(String value1, String value2) {
            addCriterion("c2 between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotBetween(String value1, String value2) {
            addCriterion("c2 not between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC3IsNull() {
            addCriterion("c3 is null");
            return (Criteria) this;
        }

        public Criteria andC3IsNotNull() {
            addCriterion("c3 is not null");
            return (Criteria) this;
        }

        public Criteria andC3EqualTo(String value) {
            addCriterion("c3 =", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotEqualTo(String value) {
            addCriterion("c3 <>", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThan(String value) {
            addCriterion("c3 >", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThanOrEqualTo(String value) {
            addCriterion("c3 >=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThan(String value) {
            addCriterion("c3 <", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThanOrEqualTo(String value) {
            addCriterion("c3 <=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Like(String value) {
            addCriterion("c3 like", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotLike(String value) {
            addCriterion("c3 not like", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3In(List<String> values) {
            addCriterion("c3 in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotIn(List<String> values) {
            addCriterion("c3 not in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Between(String value1, String value2) {
            addCriterion("c3 between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotBetween(String value1, String value2) {
            addCriterion("c3 not between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC4IsNull() {
            addCriterion("c4 is null");
            return (Criteria) this;
        }

        public Criteria andC4IsNotNull() {
            addCriterion("c4 is not null");
            return (Criteria) this;
        }

        public Criteria andC4EqualTo(String value) {
            addCriterion("c4 =", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotEqualTo(String value) {
            addCriterion("c4 <>", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThan(String value) {
            addCriterion("c4 >", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThanOrEqualTo(String value) {
            addCriterion("c4 >=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThan(String value) {
            addCriterion("c4 <", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThanOrEqualTo(String value) {
            addCriterion("c4 <=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Like(String value) {
            addCriterion("c4 like", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotLike(String value) {
            addCriterion("c4 not like", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4In(List<String> values) {
            addCriterion("c4 in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotIn(List<String> values) {
            addCriterion("c4 not in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Between(String value1, String value2) {
            addCriterion("c4 between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotBetween(String value1, String value2) {
            addCriterion("c4 not between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC5IsNull() {
            addCriterion("c5 is null");
            return (Criteria) this;
        }

        public Criteria andC5IsNotNull() {
            addCriterion("c5 is not null");
            return (Criteria) this;
        }

        public Criteria andC5EqualTo(String value) {
            addCriterion("c5 =", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotEqualTo(String value) {
            addCriterion("c5 <>", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5GreaterThan(String value) {
            addCriterion("c5 >", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5GreaterThanOrEqualTo(String value) {
            addCriterion("c5 >=", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5LessThan(String value) {
            addCriterion("c5 <", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5LessThanOrEqualTo(String value) {
            addCriterion("c5 <=", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5Like(String value) {
            addCriterion("c5 like", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotLike(String value) {
            addCriterion("c5 not like", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5In(List<String> values) {
            addCriterion("c5 in", values, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotIn(List<String> values) {
            addCriterion("c5 not in", values, "c5");
            return (Criteria) this;
        }

        public Criteria andC5Between(String value1, String value2) {
            addCriterion("c5 between", value1, value2, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotBetween(String value1, String value2) {
            addCriterion("c5 not between", value1, value2, "c5");
            return (Criteria) this;
        }

        public Criteria andC6IsNull() {
            addCriterion("c6 is null");
            return (Criteria) this;
        }

        public Criteria andC6IsNotNull() {
            addCriterion("c6 is not null");
            return (Criteria) this;
        }

        public Criteria andC6EqualTo(String value) {
            addCriterion("c6 =", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6NotEqualTo(String value) {
            addCriterion("c6 <>", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6GreaterThan(String value) {
            addCriterion("c6 >", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6GreaterThanOrEqualTo(String value) {
            addCriterion("c6 >=", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6LessThan(String value) {
            addCriterion("c6 <", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6LessThanOrEqualTo(String value) {
            addCriterion("c6 <=", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6Like(String value) {
            addCriterion("c6 like", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6NotLike(String value) {
            addCriterion("c6 not like", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6In(List<String> values) {
            addCriterion("c6 in", values, "c6");
            return (Criteria) this;
        }

        public Criteria andC6NotIn(List<String> values) {
            addCriterion("c6 not in", values, "c6");
            return (Criteria) this;
        }

        public Criteria andC6Between(String value1, String value2) {
            addCriterion("c6 between", value1, value2, "c6");
            return (Criteria) this;
        }

        public Criteria andC6NotBetween(String value1, String value2) {
            addCriterion("c6 not between", value1, value2, "c6");
            return (Criteria) this;
        }

        public Criteria andC7IsNull() {
            addCriterion("c7 is null");
            return (Criteria) this;
        }

        public Criteria andC7IsNotNull() {
            addCriterion("c7 is not null");
            return (Criteria) this;
        }

        public Criteria andC7EqualTo(String value) {
            addCriterion("c7 =", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7NotEqualTo(String value) {
            addCriterion("c7 <>", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7GreaterThan(String value) {
            addCriterion("c7 >", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7GreaterThanOrEqualTo(String value) {
            addCriterion("c7 >=", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7LessThan(String value) {
            addCriterion("c7 <", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7LessThanOrEqualTo(String value) {
            addCriterion("c7 <=", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7Like(String value) {
            addCriterion("c7 like", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7NotLike(String value) {
            addCriterion("c7 not like", value, "c7");
            return (Criteria) this;
        }

        public Criteria andC7In(List<String> values) {
            addCriterion("c7 in", values, "c7");
            return (Criteria) this;
        }

        public Criteria andC7NotIn(List<String> values) {
            addCriterion("c7 not in", values, "c7");
            return (Criteria) this;
        }

        public Criteria andC7Between(String value1, String value2) {
            addCriterion("c7 between", value1, value2, "c7");
            return (Criteria) this;
        }

        public Criteria andC7NotBetween(String value1, String value2) {
            addCriterion("c7 not between", value1, value2, "c7");
            return (Criteria) this;
        }

        public Criteria andC8IsNull() {
            addCriterion("c8 is null");
            return (Criteria) this;
        }

        public Criteria andC8IsNotNull() {
            addCriterion("c8 is not null");
            return (Criteria) this;
        }

        public Criteria andC8EqualTo(String value) {
            addCriterion("c8 =", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8NotEqualTo(String value) {
            addCriterion("c8 <>", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8GreaterThan(String value) {
            addCriterion("c8 >", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8GreaterThanOrEqualTo(String value) {
            addCriterion("c8 >=", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8LessThan(String value) {
            addCriterion("c8 <", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8LessThanOrEqualTo(String value) {
            addCriterion("c8 <=", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8Like(String value) {
            addCriterion("c8 like", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8NotLike(String value) {
            addCriterion("c8 not like", value, "c8");
            return (Criteria) this;
        }

        public Criteria andC8In(List<String> values) {
            addCriterion("c8 in", values, "c8");
            return (Criteria) this;
        }

        public Criteria andC8NotIn(List<String> values) {
            addCriterion("c8 not in", values, "c8");
            return (Criteria) this;
        }

        public Criteria andC8Between(String value1, String value2) {
            addCriterion("c8 between", value1, value2, "c8");
            return (Criteria) this;
        }

        public Criteria andC8NotBetween(String value1, String value2) {
            addCriterion("c8 not between", value1, value2, "c8");
            return (Criteria) this;
        }

        public Criteria andC9IsNull() {
            addCriterion("c9 is null");
            return (Criteria) this;
        }

        public Criteria andC9IsNotNull() {
            addCriterion("c9 is not null");
            return (Criteria) this;
        }

        public Criteria andC9EqualTo(String value) {
            addCriterion("c9 =", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9NotEqualTo(String value) {
            addCriterion("c9 <>", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9GreaterThan(String value) {
            addCriterion("c9 >", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9GreaterThanOrEqualTo(String value) {
            addCriterion("c9 >=", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9LessThan(String value) {
            addCriterion("c9 <", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9LessThanOrEqualTo(String value) {
            addCriterion("c9 <=", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9Like(String value) {
            addCriterion("c9 like", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9NotLike(String value) {
            addCriterion("c9 not like", value, "c9");
            return (Criteria) this;
        }

        public Criteria andC9In(List<String> values) {
            addCriterion("c9 in", values, "c9");
            return (Criteria) this;
        }

        public Criteria andC9NotIn(List<String> values) {
            addCriterion("c9 not in", values, "c9");
            return (Criteria) this;
        }

        public Criteria andC9Between(String value1, String value2) {
            addCriterion("c9 between", value1, value2, "c9");
            return (Criteria) this;
        }

        public Criteria andC9NotBetween(String value1, String value2) {
            addCriterion("c9 not between", value1, value2, "c9");
            return (Criteria) this;
        }

        public Criteria andC10IsNull() {
            addCriterion("c10 is null");
            return (Criteria) this;
        }

        public Criteria andC10IsNotNull() {
            addCriterion("c10 is not null");
            return (Criteria) this;
        }

        public Criteria andC10EqualTo(String value) {
            addCriterion("c10 =", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10NotEqualTo(String value) {
            addCriterion("c10 <>", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10GreaterThan(String value) {
            addCriterion("c10 >", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10GreaterThanOrEqualTo(String value) {
            addCriterion("c10 >=", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10LessThan(String value) {
            addCriterion("c10 <", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10LessThanOrEqualTo(String value) {
            addCriterion("c10 <=", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10Like(String value) {
            addCriterion("c10 like", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10NotLike(String value) {
            addCriterion("c10 not like", value, "c10");
            return (Criteria) this;
        }

        public Criteria andC10In(List<String> values) {
            addCriterion("c10 in", values, "c10");
            return (Criteria) this;
        }

        public Criteria andC10NotIn(List<String> values) {
            addCriterion("c10 not in", values, "c10");
            return (Criteria) this;
        }

        public Criteria andC10Between(String value1, String value2) {
            addCriterion("c10 between", value1, value2, "c10");
            return (Criteria) this;
        }

        public Criteria andC10NotBetween(String value1, String value2) {
            addCriterion("c10 not between", value1, value2, "c10");
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