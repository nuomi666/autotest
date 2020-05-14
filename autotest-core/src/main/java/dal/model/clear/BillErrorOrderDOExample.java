package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillErrorOrderDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillErrorOrderDOExample() {
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

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
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

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(String value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(String value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(String value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(String value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLike(String value) {
            addCriterion("bill_status like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotLike(String value) {
            addCriterion("bill_status not like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<String> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<String> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(String value1, String value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(String value1, String value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
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

        public Criteria andChannelOrderNoIsNull() {
            addCriterion("channel_order_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoIsNotNull() {
            addCriterion("channel_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoEqualTo(String value) {
            addCriterion("channel_order_no =", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotEqualTo(String value) {
            addCriterion("channel_order_no <>", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoGreaterThan(String value) {
            addCriterion("channel_order_no >", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_order_no >=", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLessThan(String value) {
            addCriterion("channel_order_no <", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLessThanOrEqualTo(String value) {
            addCriterion("channel_order_no <=", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLike(String value) {
            addCriterion("channel_order_no like", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotLike(String value) {
            addCriterion("channel_order_no not like", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoIn(List<String> values) {
            addCriterion("channel_order_no in", values, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotIn(List<String> values) {
            addCriterion("channel_order_no not in", values, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoBetween(String value1, String value2) {
            addCriterion("channel_order_no between", value1, value2, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotBetween(String value1, String value2) {
            addCriterion("channel_order_no not between", value1, value2, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountIsNull() {
            addCriterion("channel_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountIsNotNull() {
            addCriterion("channel_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountEqualTo(Long value) {
            addCriterion("channel_order_amount =", value, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountNotEqualTo(Long value) {
            addCriterion("channel_order_amount <>", value, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountGreaterThan(Long value) {
            addCriterion("channel_order_amount >", value, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_order_amount >=", value, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountLessThan(Long value) {
            addCriterion("channel_order_amount <", value, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("channel_order_amount <=", value, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountIn(List<Long> values) {
            addCriterion("channel_order_amount in", values, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountNotIn(List<Long> values) {
            addCriterion("channel_order_amount not in", values, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountBetween(Long value1, Long value2) {
            addCriterion("channel_order_amount between", value1, value2, "channelOrderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("channel_order_amount not between", value1, value2, "channelOrderAmount");
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

        public Criteria andMerchantOrderAmountIsNull() {
            addCriterion("merchant_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountIsNotNull() {
            addCriterion("merchant_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountEqualTo(Long value) {
            addCriterion("merchant_order_amount =", value, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountNotEqualTo(Long value) {
            addCriterion("merchant_order_amount <>", value, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountGreaterThan(Long value) {
            addCriterion("merchant_order_amount >", value, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("merchant_order_amount >=", value, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountLessThan(Long value) {
            addCriterion("merchant_order_amount <", value, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("merchant_order_amount <=", value, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountIn(List<Long> values) {
            addCriterion("merchant_order_amount in", values, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountNotIn(List<Long> values) {
            addCriterion("merchant_order_amount not in", values, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountBetween(Long value1, Long value2) {
            addCriterion("merchant_order_amount between", value1, value2, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("merchant_order_amount not between", value1, value2, "merchantOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSolveStatusIsNull() {
            addCriterion("solve_status is null");
            return (Criteria) this;
        }

        public Criteria andSolveStatusIsNotNull() {
            addCriterion("solve_status is not null");
            return (Criteria) this;
        }

        public Criteria andSolveStatusEqualTo(String value) {
            addCriterion("solve_status =", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusNotEqualTo(String value) {
            addCriterion("solve_status <>", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusGreaterThan(String value) {
            addCriterion("solve_status >", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("solve_status >=", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusLessThan(String value) {
            addCriterion("solve_status <", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusLessThanOrEqualTo(String value) {
            addCriterion("solve_status <=", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusLike(String value) {
            addCriterion("solve_status like", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusNotLike(String value) {
            addCriterion("solve_status not like", value, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusIn(List<String> values) {
            addCriterion("solve_status in", values, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusNotIn(List<String> values) {
            addCriterion("solve_status not in", values, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusBetween(String value1, String value2) {
            addCriterion("solve_status between", value1, value2, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveStatusNotBetween(String value1, String value2) {
            addCriterion("solve_status not between", value1, value2, "solveStatus");
            return (Criteria) this;
        }

        public Criteria andSolveCommentIsNull() {
            addCriterion("solve_comment is null");
            return (Criteria) this;
        }

        public Criteria andSolveCommentIsNotNull() {
            addCriterion("solve_comment is not null");
            return (Criteria) this;
        }

        public Criteria andSolveCommentEqualTo(String value) {
            addCriterion("solve_comment =", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentNotEqualTo(String value) {
            addCriterion("solve_comment <>", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentGreaterThan(String value) {
            addCriterion("solve_comment >", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentGreaterThanOrEqualTo(String value) {
            addCriterion("solve_comment >=", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentLessThan(String value) {
            addCriterion("solve_comment <", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentLessThanOrEqualTo(String value) {
            addCriterion("solve_comment <=", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentLike(String value) {
            addCriterion("solve_comment like", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentNotLike(String value) {
            addCriterion("solve_comment not like", value, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentIn(List<String> values) {
            addCriterion("solve_comment in", values, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentNotIn(List<String> values) {
            addCriterion("solve_comment not in", values, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentBetween(String value1, String value2) {
            addCriterion("solve_comment between", value1, value2, "solveComment");
            return (Criteria) this;
        }

        public Criteria andSolveCommentNotBetween(String value1, String value2) {
            addCriterion("solve_comment not between", value1, value2, "solveComment");
            return (Criteria) this;
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

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
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