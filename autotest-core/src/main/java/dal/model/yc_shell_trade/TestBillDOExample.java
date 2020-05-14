package dal.model.yc_shell_trade;

import java.util.ArrayList;
import java.util.List;

public class TestBillDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestBillDOExample() {
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

        public Criteria andBillDateIsNull() {
            addCriterion("bill_date is null");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNotNull() {
            addCriterion("bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andBillDateEqualTo(String value) {
            addCriterion("bill_date =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(String value) {
            addCriterion("bill_date <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(String value) {
            addCriterion("bill_date >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(String value) {
            addCriterion("bill_date >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(String value) {
            addCriterion("bill_date <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(String value) {
            addCriterion("bill_date <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLike(String value) {
            addCriterion("bill_date like", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotLike(String value) {
            addCriterion("bill_date not like", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<String> values) {
            addCriterion("bill_date in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<String> values) {
            addCriterion("bill_date not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(String value1, String value2) {
            addCriterion("bill_date between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(String value1, String value2) {
            addCriterion("bill_date not between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoIsNull() {
            addCriterion("plat_merchant_order_no is null");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoIsNotNull() {
            addCriterion("plat_merchant_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoEqualTo(String value) {
            addCriterion("plat_merchant_order_no =", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoNotEqualTo(String value) {
            addCriterion("plat_merchant_order_no <>", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoGreaterThan(String value) {
            addCriterion("plat_merchant_order_no >", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("plat_merchant_order_no >=", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoLessThan(String value) {
            addCriterion("plat_merchant_order_no <", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoLessThanOrEqualTo(String value) {
            addCriterion("plat_merchant_order_no <=", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoLike(String value) {
            addCriterion("plat_merchant_order_no like", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoNotLike(String value) {
            addCriterion("plat_merchant_order_no not like", value, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoIn(List<String> values) {
            addCriterion("plat_merchant_order_no in", values, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoNotIn(List<String> values) {
            addCriterion("plat_merchant_order_no not in", values, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoBetween(String value1, String value2) {
            addCriterion("plat_merchant_order_no between", value1, value2, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andPlatMerchantOrderNoNotBetween(String value1, String value2) {
            addCriterion("plat_merchant_order_no not between", value1, value2, "platMerchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoIsNull() {
            addCriterion("merchant_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoIsNotNull() {
            addCriterion("merchant_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoEqualTo(String value) {
            addCriterion("merchant_trade_no =", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoNotEqualTo(String value) {
            addCriterion("merchant_trade_no <>", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoGreaterThan(String value) {
            addCriterion("merchant_trade_no >", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_trade_no >=", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoLessThan(String value) {
            addCriterion("merchant_trade_no <", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_trade_no <=", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoLike(String value) {
            addCriterion("merchant_trade_no like", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoNotLike(String value) {
            addCriterion("merchant_trade_no not like", value, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoIn(List<String> values) {
            addCriterion("merchant_trade_no in", values, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoNotIn(List<String> values) {
            addCriterion("merchant_trade_no not in", values, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoBetween(String value1, String value2) {
            addCriterion("merchant_trade_no between", value1, value2, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeNoNotBetween(String value1, String value2) {
            addCriterion("merchant_trade_no not between", value1, value2, "merchantTradeNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoIsNull() {
            addCriterion("merchant_refund_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoIsNotNull() {
            addCriterion("merchant_refund_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoEqualTo(String value) {
            addCriterion("merchant_refund_no =", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoNotEqualTo(String value) {
            addCriterion("merchant_refund_no <>", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoGreaterThan(String value) {
            addCriterion("merchant_refund_no >", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_refund_no >=", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoLessThan(String value) {
            addCriterion("merchant_refund_no <", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_refund_no <=", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoLike(String value) {
            addCriterion("merchant_refund_no like", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoNotLike(String value) {
            addCriterion("merchant_refund_no not like", value, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoIn(List<String> values) {
            addCriterion("merchant_refund_no in", values, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoNotIn(List<String> values) {
            addCriterion("merchant_refund_no not in", values, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoBetween(String value1, String value2) {
            addCriterion("merchant_refund_no between", value1, value2, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantRefundNoNotBetween(String value1, String value2) {
            addCriterion("merchant_refund_no not between", value1, value2, "merchantRefundNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountIsNull() {
            addCriterion("merchant_amount is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountIsNotNull() {
            addCriterion("merchant_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountEqualTo(String value) {
            addCriterion("merchant_amount =", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountNotEqualTo(String value) {
            addCriterion("merchant_amount <>", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountGreaterThan(String value) {
            addCriterion("merchant_amount >", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_amount >=", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountLessThan(String value) {
            addCriterion("merchant_amount <", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountLessThanOrEqualTo(String value) {
            addCriterion("merchant_amount <=", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountLike(String value) {
            addCriterion("merchant_amount like", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountNotLike(String value) {
            addCriterion("merchant_amount not like", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountIn(List<String> values) {
            addCriterion("merchant_amount in", values, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountNotIn(List<String> values) {
            addCriterion("merchant_amount not in", values, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountBetween(String value1, String value2) {
            addCriterion("merchant_amount between", value1, value2, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountNotBetween(String value1, String value2) {
            addCriterion("merchant_amount not between", value1, value2, "merchantAmount");
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