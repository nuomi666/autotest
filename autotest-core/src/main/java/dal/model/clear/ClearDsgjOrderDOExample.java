package dal.model.clear;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClearDsgjOrderDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClearDsgjOrderDOExample() {
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

        public Criteria andOrderKeyIsNull() {
            addCriterion("order_key is null");
            return (Criteria) this;
        }

        public Criteria andOrderKeyIsNotNull() {
            addCriterion("order_key is not null");
            return (Criteria) this;
        }

        public Criteria andOrderKeyEqualTo(String value) {
            addCriterion("order_key =", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyNotEqualTo(String value) {
            addCriterion("order_key <>", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyGreaterThan(String value) {
            addCriterion("order_key >", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyGreaterThanOrEqualTo(String value) {
            addCriterion("order_key >=", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyLessThan(String value) {
            addCriterion("order_key <", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyLessThanOrEqualTo(String value) {
            addCriterion("order_key <=", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyLike(String value) {
            addCriterion("order_key like", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyNotLike(String value) {
            addCriterion("order_key not like", value, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyIn(List<String> values) {
            addCriterion("order_key in", values, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyNotIn(List<String> values) {
            addCriterion("order_key not in", values, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyBetween(String value1, String value2) {
            addCriterion("order_key between", value1, value2, "orderKey");
            return (Criteria) this;
        }

        public Criteria andOrderKeyNotBetween(String value1, String value2) {
            addCriterion("order_key not between", value1, value2, "orderKey");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNull() {
            addCriterion("partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNotNull() {
            addCriterion("partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdEqualTo(String value) {
            addCriterion("partner_id =", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotEqualTo(String value) {
            addCriterion("partner_id <>", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThan(String value) {
            addCriterion("partner_id >", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("partner_id >=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThan(String value) {
            addCriterion("partner_id <", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("partner_id <=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLike(String value) {
            addCriterion("partner_id like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotLike(String value) {
            addCriterion("partner_id not like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIn(List<String> values) {
            addCriterion("partner_id in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotIn(List<String> values) {
            addCriterion("partner_id not in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdBetween(String value1, String value2) {
            addCriterion("partner_id between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotBetween(String value1, String value2) {
            addCriterion("partner_id not between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdIsNull() {
            addCriterion("plat_partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdIsNotNull() {
            addCriterion("plat_partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdEqualTo(String value) {
            addCriterion("plat_partner_id =", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotEqualTo(String value) {
            addCriterion("plat_partner_id <>", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdGreaterThan(String value) {
            addCriterion("plat_partner_id >", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("plat_partner_id >=", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdLessThan(String value) {
            addCriterion("plat_partner_id <", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("plat_partner_id <=", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdLike(String value) {
            addCriterion("plat_partner_id like", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotLike(String value) {
            addCriterion("plat_partner_id not like", value, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdIn(List<String> values) {
            addCriterion("plat_partner_id in", values, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotIn(List<String> values) {
            addCriterion("plat_partner_id not in", values, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdBetween(String value1, String value2) {
            addCriterion("plat_partner_id between", value1, value2, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerIdNotBetween(String value1, String value2) {
            addCriterion("plat_partner_id not between", value1, value2, "platPartnerId");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeResourceIsNull() {
            addCriterion("trade_resource is null");
            return (Criteria) this;
        }

        public Criteria andTradeResourceIsNotNull() {
            addCriterion("trade_resource is not null");
            return (Criteria) this;
        }

        public Criteria andTradeResourceEqualTo(String value) {
            addCriterion("trade_resource =", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceNotEqualTo(String value) {
            addCriterion("trade_resource <>", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceGreaterThan(String value) {
            addCriterion("trade_resource >", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceGreaterThanOrEqualTo(String value) {
            addCriterion("trade_resource >=", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceLessThan(String value) {
            addCriterion("trade_resource <", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceLessThanOrEqualTo(String value) {
            addCriterion("trade_resource <=", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceLike(String value) {
            addCriterion("trade_resource like", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceNotLike(String value) {
            addCriterion("trade_resource not like", value, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceIn(List<String> values) {
            addCriterion("trade_resource in", values, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceNotIn(List<String> values) {
            addCriterion("trade_resource not in", values, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceBetween(String value1, String value2) {
            addCriterion("trade_resource between", value1, value2, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andTradeResourceNotBetween(String value1, String value2) {
            addCriterion("trade_resource not between", value1, value2, "tradeResource");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoIsNull() {
            addCriterion("channel_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoIsNotNull() {
            addCriterion("channel_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoEqualTo(String value) {
            addCriterion("channel_trade_no =", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoNotEqualTo(String value) {
            addCriterion("channel_trade_no <>", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoGreaterThan(String value) {
            addCriterion("channel_trade_no >", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_trade_no >=", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoLessThan(String value) {
            addCriterion("channel_trade_no <", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoLessThanOrEqualTo(String value) {
            addCriterion("channel_trade_no <=", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoLike(String value) {
            addCriterion("channel_trade_no like", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoNotLike(String value) {
            addCriterion("channel_trade_no not like", value, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoIn(List<String> values) {
            addCriterion("channel_trade_no in", values, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoNotIn(List<String> values) {
            addCriterion("channel_trade_no not in", values, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoBetween(String value1, String value2) {
            addCriterion("channel_trade_no between", value1, value2, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeNoNotBetween(String value1, String value2) {
            addCriterion("channel_trade_no not between", value1, value2, "channelTradeNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoIsNull() {
            addCriterion("channel_refund_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoIsNotNull() {
            addCriterion("channel_refund_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoEqualTo(String value) {
            addCriterion("channel_refund_no =", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoNotEqualTo(String value) {
            addCriterion("channel_refund_no <>", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoGreaterThan(String value) {
            addCriterion("channel_refund_no >", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_refund_no >=", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoLessThan(String value) {
            addCriterion("channel_refund_no <", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoLessThanOrEqualTo(String value) {
            addCriterion("channel_refund_no <=", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoLike(String value) {
            addCriterion("channel_refund_no like", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoNotLike(String value) {
            addCriterion("channel_refund_no not like", value, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoIn(List<String> values) {
            addCriterion("channel_refund_no in", values, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoNotIn(List<String> values) {
            addCriterion("channel_refund_no not in", values, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoBetween(String value1, String value2) {
            addCriterion("channel_refund_no between", value1, value2, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andChannelRefundNoNotBetween(String value1, String value2) {
            addCriterion("channel_refund_no not between", value1, value2, "channelRefundNo");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(Long value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(Long value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(Long value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(Long value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<Long> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<Long> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(Long value1, Long value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(Long value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(Long value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(Long value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(Long value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<Long> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<Long> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(Long value1, Long value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIsNull() {
            addCriterion("merchant_order_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIsNotNull() {
            addCriterion("merchant_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoEqualTo(String value) {
            addCriterion("merchant_order_no =", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotEqualTo(String value) {
            addCriterion("merchant_order_no <>", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoGreaterThan(String value) {
            addCriterion("merchant_order_no >", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_order_no >=", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLessThan(String value) {
            addCriterion("merchant_order_no <", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_order_no <=", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLike(String value) {
            addCriterion("merchant_order_no like", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotLike(String value) {
            addCriterion("merchant_order_no not like", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIn(List<String> values) {
            addCriterion("merchant_order_no in", values, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotIn(List<String> values) {
            addCriterion("merchant_order_no not in", values, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoBetween(String value1, String value2) {
            addCriterion("merchant_order_no between", value1, value2, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotBetween(String value1, String value2) {
            addCriterion("merchant_order_no not between", value1, value2, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoIsNull() {
            addCriterion("merchant_sub_order_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoIsNotNull() {
            addCriterion("merchant_sub_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoEqualTo(String value) {
            addCriterion("merchant_sub_order_no =", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoNotEqualTo(String value) {
            addCriterion("merchant_sub_order_no <>", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoGreaterThan(String value) {
            addCriterion("merchant_sub_order_no >", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_sub_order_no >=", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoLessThan(String value) {
            addCriterion("merchant_sub_order_no <", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_sub_order_no <=", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoLike(String value) {
            addCriterion("merchant_sub_order_no like", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoNotLike(String value) {
            addCriterion("merchant_sub_order_no not like", value, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoIn(List<String> values) {
            addCriterion("merchant_sub_order_no in", values, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoNotIn(List<String> values) {
            addCriterion("merchant_sub_order_no not in", values, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoBetween(String value1, String value2) {
            addCriterion("merchant_sub_order_no between", value1, value2, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantSubOrderNoNotBetween(String value1, String value2) {
            addCriterion("merchant_sub_order_no not between", value1, value2, "merchantSubOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeIsNull() {
            addCriterion("order_rank_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeIsNotNull() {
            addCriterion("order_rank_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeEqualTo(String value) {
            addCriterion("order_rank_type =", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeNotEqualTo(String value) {
            addCriterion("order_rank_type <>", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeGreaterThan(String value) {
            addCriterion("order_rank_type >", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_rank_type >=", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeLessThan(String value) {
            addCriterion("order_rank_type <", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeLessThanOrEqualTo(String value) {
            addCriterion("order_rank_type <=", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeLike(String value) {
            addCriterion("order_rank_type like", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeNotLike(String value) {
            addCriterion("order_rank_type not like", value, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeIn(List<String> values) {
            addCriterion("order_rank_type in", values, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeNotIn(List<String> values) {
            addCriterion("order_rank_type not in", values, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeBetween(String value1, String value2) {
            addCriterion("order_rank_type between", value1, value2, "orderRankType");
            return (Criteria) this;
        }

        public Criteria andOrderRankTypeNotBetween(String value1, String value2) {
            addCriterion("order_rank_type not between", value1, value2, "orderRankType");
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

        public Criteria andMerchantFeeAmountIsNull() {
            addCriterion("merchant_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountIsNotNull() {
            addCriterion("merchant_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountEqualTo(BigDecimal value) {
            addCriterion("merchant_fee_amount =", value, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountNotEqualTo(BigDecimal value) {
            addCriterion("merchant_fee_amount <>", value, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountGreaterThan(BigDecimal value) {
            addCriterion("merchant_fee_amount >", value, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_fee_amount >=", value, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountLessThan(BigDecimal value) {
            addCriterion("merchant_fee_amount <", value, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_fee_amount <=", value, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountIn(List<BigDecimal> values) {
            addCriterion("merchant_fee_amount in", values, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountNotIn(List<BigDecimal> values) {
            addCriterion("merchant_fee_amount not in", values, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_fee_amount between", value1, value2, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_fee_amount not between", value1, value2, "merchantFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeIsNull() {
            addCriterion("merchant_fee is null");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeIsNotNull() {
            addCriterion("merchant_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeEqualTo(BigDecimal value) {
            addCriterion("merchant_fee =", value, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeNotEqualTo(BigDecimal value) {
            addCriterion("merchant_fee <>", value, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeGreaterThan(BigDecimal value) {
            addCriterion("merchant_fee >", value, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_fee >=", value, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeLessThan(BigDecimal value) {
            addCriterion("merchant_fee <", value, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_fee <=", value, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeIn(List<BigDecimal> values) {
            addCriterion("merchant_fee in", values, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeNotIn(List<BigDecimal> values) {
            addCriterion("merchant_fee not in", values, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_fee between", value1, value2, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andMerchantFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_fee not between", value1, value2, "merchantFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIsNull() {
            addCriterion("channel_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIsNotNull() {
            addCriterion("channel_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountEqualTo(BigDecimal value) {
            addCriterion("channel_fee_amount =", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotEqualTo(BigDecimal value) {
            addCriterion("channel_fee_amount <>", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountGreaterThan(BigDecimal value) {
            addCriterion("channel_fee_amount >", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("channel_fee_amount >=", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountLessThan(BigDecimal value) {
            addCriterion("channel_fee_amount <", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("channel_fee_amount <=", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIn(List<BigDecimal> values) {
            addCriterion("channel_fee_amount in", values, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotIn(List<BigDecimal> values) {
            addCriterion("channel_fee_amount not in", values, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("channel_fee_amount between", value1, value2, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("channel_fee_amount not between", value1, value2, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeIsNull() {
            addCriterion("channel_fee is null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeIsNotNull() {
            addCriterion("channel_fee is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeEqualTo(BigDecimal value) {
            addCriterion("channel_fee =", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeNotEqualTo(BigDecimal value) {
            addCriterion("channel_fee <>", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeGreaterThan(BigDecimal value) {
            addCriterion("channel_fee >", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("channel_fee >=", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeLessThan(BigDecimal value) {
            addCriterion("channel_fee <", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("channel_fee <=", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeIn(List<BigDecimal> values) {
            addCriterion("channel_fee in", values, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeNotIn(List<BigDecimal> values) {
            addCriterion("channel_fee not in", values, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("channel_fee between", value1, value2, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("channel_fee not between", value1, value2, "channelFee");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("trade_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Date value) {
            addCriterion("trade_time =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Date value) {
            addCriterion("trade_time <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Date value) {
            addCriterion("trade_time >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trade_time >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Date value) {
            addCriterion("trade_time <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("trade_time <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Date> values) {
            addCriterion("trade_time in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Date> values) {
            addCriterion("trade_time not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Date value1, Date value2) {
            addCriterion("trade_time between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("trade_time not between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andClearDateIsNull() {
            addCriterion("clear_date is null");
            return (Criteria) this;
        }

        public Criteria andClearDateIsNotNull() {
            addCriterion("clear_date is not null");
            return (Criteria) this;
        }

        public Criteria andClearDateEqualTo(String value) {
            addCriterion("clear_date =", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotEqualTo(String value) {
            addCriterion("clear_date <>", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateGreaterThan(String value) {
            addCriterion("clear_date >", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateGreaterThanOrEqualTo(String value) {
            addCriterion("clear_date >=", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLessThan(String value) {
            addCriterion("clear_date <", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLessThanOrEqualTo(String value) {
            addCriterion("clear_date <=", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLike(String value) {
            addCriterion("clear_date like", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotLike(String value) {
            addCriterion("clear_date not like", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateIn(List<String> values) {
            addCriterion("clear_date in", values, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotIn(List<String> values) {
            addCriterion("clear_date not in", values, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateBetween(String value1, String value2) {
            addCriterion("clear_date between", value1, value2, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotBetween(String value1, String value2) {
            addCriterion("clear_date not between", value1, value2, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearFileNameIsNull() {
            addCriterion("clear_file_name is null");
            return (Criteria) this;
        }

        public Criteria andClearFileNameIsNotNull() {
            addCriterion("clear_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andClearFileNameEqualTo(String value) {
            addCriterion("clear_file_name =", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotEqualTo(String value) {
            addCriterion("clear_file_name <>", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameGreaterThan(String value) {
            addCriterion("clear_file_name >", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("clear_file_name >=", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameLessThan(String value) {
            addCriterion("clear_file_name <", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameLessThanOrEqualTo(String value) {
            addCriterion("clear_file_name <=", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameLike(String value) {
            addCriterion("clear_file_name like", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotLike(String value) {
            addCriterion("clear_file_name not like", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameIn(List<String> values) {
            addCriterion("clear_file_name in", values, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotIn(List<String> values) {
            addCriterion("clear_file_name not in", values, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameBetween(String value1, String value2) {
            addCriterion("clear_file_name between", value1, value2, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotBetween(String value1, String value2) {
            addCriterion("clear_file_name not between", value1, value2, "clearFileName");
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