package dal.model.clear;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillReconciliationDetailDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillReconciliationDetailDOExample() {
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

        public Criteria andChannelTransactionNoIsNull() {
            addCriterion("channel_transaction_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoIsNotNull() {
            addCriterion("channel_transaction_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoEqualTo(String value) {
            addCriterion("channel_transaction_no =", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoNotEqualTo(String value) {
            addCriterion("channel_transaction_no <>", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoGreaterThan(String value) {
            addCriterion("channel_transaction_no >", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_transaction_no >=", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoLessThan(String value) {
            addCriterion("channel_transaction_no <", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoLessThanOrEqualTo(String value) {
            addCriterion("channel_transaction_no <=", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoLike(String value) {
            addCriterion("channel_transaction_no like", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoNotLike(String value) {
            addCriterion("channel_transaction_no not like", value, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoIn(List<String> values) {
            addCriterion("channel_transaction_no in", values, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoNotIn(List<String> values) {
            addCriterion("channel_transaction_no not in", values, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoBetween(String value1, String value2) {
            addCriterion("channel_transaction_no between", value1, value2, "channelTransactionNo");
            return (Criteria) this;
        }

        public Criteria andChannelTransactionNoNotBetween(String value1, String value2) {
            addCriterion("channel_transaction_no not between", value1, value2, "channelTransactionNo");
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

        public Criteria andChannelAmountIsNull() {
            addCriterion("channel_amount is null");
            return (Criteria) this;
        }

        public Criteria andChannelAmountIsNotNull() {
            addCriterion("channel_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChannelAmountEqualTo(Long value) {
            addCriterion("channel_amount =", value, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountNotEqualTo(Long value) {
            addCriterion("channel_amount <>", value, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountGreaterThan(Long value) {
            addCriterion("channel_amount >", value, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_amount >=", value, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountLessThan(Long value) {
            addCriterion("channel_amount <", value, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountLessThanOrEqualTo(Long value) {
            addCriterion("channel_amount <=", value, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountIn(List<Long> values) {
            addCriterion("channel_amount in", values, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountNotIn(List<Long> values) {
            addCriterion("channel_amount not in", values, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountBetween(Long value1, Long value2) {
            addCriterion("channel_amount between", value1, value2, "channelAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAmountNotBetween(Long value1, Long value2) {
            addCriterion("channel_amount not between", value1, value2, "channelAmount");
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

        public Criteria andChannelTradeTimeIsNull() {
            addCriterion("channel_trade_time is null");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeIsNotNull() {
            addCriterion("channel_trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeEqualTo(Date value) {
            addCriterion("channel_trade_time =", value, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeNotEqualTo(Date value) {
            addCriterion("channel_trade_time <>", value, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeGreaterThan(Date value) {
            addCriterion("channel_trade_time >", value, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("channel_trade_time >=", value, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeLessThan(Date value) {
            addCriterion("channel_trade_time <", value, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("channel_trade_time <=", value, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeIn(List<Date> values) {
            addCriterion("channel_trade_time in", values, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeNotIn(List<Date> values) {
            addCriterion("channel_trade_time not in", values, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeBetween(Date value1, Date value2) {
            addCriterion("channel_trade_time between", value1, value2, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("channel_trade_time not between", value1, value2, "channelTradeTime");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdIsNull() {
            addCriterion("channel_partner_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdIsNotNull() {
            addCriterion("channel_partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdEqualTo(String value) {
            addCriterion("channel_partner_id =", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdNotEqualTo(String value) {
            addCriterion("channel_partner_id <>", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdGreaterThan(String value) {
            addCriterion("channel_partner_id >", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_partner_id >=", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdLessThan(String value) {
            addCriterion("channel_partner_id <", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("channel_partner_id <=", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdLike(String value) {
            addCriterion("channel_partner_id like", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdNotLike(String value) {
            addCriterion("channel_partner_id not like", value, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdIn(List<String> values) {
            addCriterion("channel_partner_id in", values, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdNotIn(List<String> values) {
            addCriterion("channel_partner_id not in", values, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdBetween(String value1, String value2) {
            addCriterion("channel_partner_id between", value1, value2, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelPartnerIdNotBetween(String value1, String value2) {
            addCriterion("channel_partner_id not between", value1, value2, "channelPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdIsNull() {
            addCriterion("channel_third_partner_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdIsNotNull() {
            addCriterion("channel_third_partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdEqualTo(String value) {
            addCriterion("channel_third_partner_id =", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdNotEqualTo(String value) {
            addCriterion("channel_third_partner_id <>", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdGreaterThan(String value) {
            addCriterion("channel_third_partner_id >", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_third_partner_id >=", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdLessThan(String value) {
            addCriterion("channel_third_partner_id <", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("channel_third_partner_id <=", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdLike(String value) {
            addCriterion("channel_third_partner_id like", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdNotLike(String value) {
            addCriterion("channel_third_partner_id not like", value, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdIn(List<String> values) {
            addCriterion("channel_third_partner_id in", values, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdNotIn(List<String> values) {
            addCriterion("channel_third_partner_id not in", values, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdBetween(String value1, String value2) {
            addCriterion("channel_third_partner_id between", value1, value2, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdPartnerIdNotBetween(String value1, String value2) {
            addCriterion("channel_third_partner_id not between", value1, value2, "channelThirdPartnerId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdIsNull() {
            addCriterion("channel_third_user_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdIsNotNull() {
            addCriterion("channel_third_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdEqualTo(String value) {
            addCriterion("channel_third_user_id =", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdNotEqualTo(String value) {
            addCriterion("channel_third_user_id <>", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdGreaterThan(String value) {
            addCriterion("channel_third_user_id >", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_third_user_id >=", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdLessThan(String value) {
            addCriterion("channel_third_user_id <", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdLessThanOrEqualTo(String value) {
            addCriterion("channel_third_user_id <=", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdLike(String value) {
            addCriterion("channel_third_user_id like", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdNotLike(String value) {
            addCriterion("channel_third_user_id not like", value, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdIn(List<String> values) {
            addCriterion("channel_third_user_id in", values, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdNotIn(List<String> values) {
            addCriterion("channel_third_user_id not in", values, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdBetween(String value1, String value2) {
            addCriterion("channel_third_user_id between", value1, value2, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelThirdUserIdNotBetween(String value1, String value2) {
            addCriterion("channel_third_user_id not between", value1, value2, "channelThirdUserId");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoIsNull() {
            addCriterion("channel_trade_memo is null");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoIsNotNull() {
            addCriterion("channel_trade_memo is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoEqualTo(String value) {
            addCriterion("channel_trade_memo =", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoNotEqualTo(String value) {
            addCriterion("channel_trade_memo <>", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoGreaterThan(String value) {
            addCriterion("channel_trade_memo >", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_trade_memo >=", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoLessThan(String value) {
            addCriterion("channel_trade_memo <", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoLessThanOrEqualTo(String value) {
            addCriterion("channel_trade_memo <=", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoLike(String value) {
            addCriterion("channel_trade_memo like", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoNotLike(String value) {
            addCriterion("channel_trade_memo not like", value, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoIn(List<String> values) {
            addCriterion("channel_trade_memo in", values, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoNotIn(List<String> values) {
            addCriterion("channel_trade_memo not in", values, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoBetween(String value1, String value2) {
            addCriterion("channel_trade_memo between", value1, value2, "channelTradeMemo");
            return (Criteria) this;
        }

        public Criteria andChannelTradeMemoNotBetween(String value1, String value2) {
            addCriterion("channel_trade_memo not between", value1, value2, "channelTradeMemo");
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

        public Criteria andMerchantAmountIsNull() {
            addCriterion("merchant_amount is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountIsNotNull() {
            addCriterion("merchant_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountEqualTo(Long value) {
            addCriterion("merchant_amount =", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountNotEqualTo(Long value) {
            addCriterion("merchant_amount <>", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountGreaterThan(Long value) {
            addCriterion("merchant_amount >", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("merchant_amount >=", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountLessThan(Long value) {
            addCriterion("merchant_amount <", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountLessThanOrEqualTo(Long value) {
            addCriterion("merchant_amount <=", value, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountIn(List<Long> values) {
            addCriterion("merchant_amount in", values, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountNotIn(List<Long> values) {
            addCriterion("merchant_amount not in", values, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountBetween(Long value1, Long value2) {
            addCriterion("merchant_amount between", value1, value2, "merchantAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantAmountNotBetween(Long value1, Long value2) {
            addCriterion("merchant_amount not between", value1, value2, "merchantAmount");
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

        public Criteria andMerchantTradeTimeIsNull() {
            addCriterion("merchant_trade_time is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeIsNotNull() {
            addCriterion("merchant_trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeEqualTo(Date value) {
            addCriterion("merchant_trade_time =", value, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeNotEqualTo(Date value) {
            addCriterion("merchant_trade_time <>", value, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeGreaterThan(Date value) {
            addCriterion("merchant_trade_time >", value, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("merchant_trade_time >=", value, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeLessThan(Date value) {
            addCriterion("merchant_trade_time <", value, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("merchant_trade_time <=", value, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeIn(List<Date> values) {
            addCriterion("merchant_trade_time in", values, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeNotIn(List<Date> values) {
            addCriterion("merchant_trade_time not in", values, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeBetween(Date value1, Date value2) {
            addCriterion("merchant_trade_time between", value1, value2, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("merchant_trade_time not between", value1, value2, "merchantTradeTime");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountIsNull() {
            addCriterion("merchant_channel_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountIsNotNull() {
            addCriterion("merchant_channel_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee_amount =", value, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountNotEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee_amount <>", value, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountGreaterThan(BigDecimal value) {
            addCriterion("merchant_channel_fee_amount >", value, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee_amount >=", value, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountLessThan(BigDecimal value) {
            addCriterion("merchant_channel_fee_amount <", value, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee_amount <=", value, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountIn(List<BigDecimal> values) {
            addCriterion("merchant_channel_fee_amount in", values, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountNotIn(List<BigDecimal> values) {
            addCriterion("merchant_channel_fee_amount not in", values, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_channel_fee_amount between", value1, value2, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_channel_fee_amount not between", value1, value2, "merchantChannelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeIsNull() {
            addCriterion("merchant_channel_fee is null");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeIsNotNull() {
            addCriterion("merchant_channel_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee =", value, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeNotEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee <>", value, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeGreaterThan(BigDecimal value) {
            addCriterion("merchant_channel_fee >", value, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee >=", value, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeLessThan(BigDecimal value) {
            addCriterion("merchant_channel_fee <", value, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("merchant_channel_fee <=", value, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeIn(List<BigDecimal> values) {
            addCriterion("merchant_channel_fee in", values, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeNotIn(List<BigDecimal> values) {
            addCriterion("merchant_channel_fee not in", values, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_channel_fee between", value1, value2, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantChannelFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("merchant_channel_fee not between", value1, value2, "merchantChannelFee");
            return (Criteria) this;
        }

        public Criteria andMerchantModeIsNull() {
            addCriterion("merchant_mode is null");
            return (Criteria) this;
        }

        public Criteria andMerchantModeIsNotNull() {
            addCriterion("merchant_mode is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantModeEqualTo(String value) {
            addCriterion("merchant_mode =", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeNotEqualTo(String value) {
            addCriterion("merchant_mode <>", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeGreaterThan(String value) {
            addCriterion("merchant_mode >", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_mode >=", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeLessThan(String value) {
            addCriterion("merchant_mode <", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeLessThanOrEqualTo(String value) {
            addCriterion("merchant_mode <=", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeLike(String value) {
            addCriterion("merchant_mode like", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeNotLike(String value) {
            addCriterion("merchant_mode not like", value, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeIn(List<String> values) {
            addCriterion("merchant_mode in", values, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeNotIn(List<String> values) {
            addCriterion("merchant_mode not in", values, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeBetween(String value1, String value2) {
            addCriterion("merchant_mode between", value1, value2, "merchantMode");
            return (Criteria) this;
        }

        public Criteria andMerchantModeNotBetween(String value1, String value2) {
            addCriterion("merchant_mode not between", value1, value2, "merchantMode");
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