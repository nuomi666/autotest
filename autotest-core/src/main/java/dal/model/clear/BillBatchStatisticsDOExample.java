package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillBatchStatisticsDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillBatchStatisticsDOExample() {
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

        public Criteria andPartnerRealNameIsNull() {
            addCriterion("partner_real_name is null");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameIsNotNull() {
            addCriterion("partner_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameEqualTo(String value) {
            addCriterion("partner_real_name =", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotEqualTo(String value) {
            addCriterion("partner_real_name <>", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameGreaterThan(String value) {
            addCriterion("partner_real_name >", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("partner_real_name >=", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameLessThan(String value) {
            addCriterion("partner_real_name <", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameLessThanOrEqualTo(String value) {
            addCriterion("partner_real_name <=", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameLike(String value) {
            addCriterion("partner_real_name like", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotLike(String value) {
            addCriterion("partner_real_name not like", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameIn(List<String> values) {
            addCriterion("partner_real_name in", values, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotIn(List<String> values) {
            addCriterion("partner_real_name not in", values, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameBetween(String value1, String value2) {
            addCriterion("partner_real_name between", value1, value2, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotBetween(String value1, String value2) {
            addCriterion("partner_real_name not between", value1, value2, "partnerRealName");
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

        public Criteria andChannelOrderCountIsNull() {
            addCriterion("channel_order_count is null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountIsNotNull() {
            addCriterion("channel_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountEqualTo(Integer value) {
            addCriterion("channel_order_count =", value, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountNotEqualTo(Integer value) {
            addCriterion("channel_order_count <>", value, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountGreaterThan(Integer value) {
            addCriterion("channel_order_count >", value, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_order_count >=", value, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountLessThan(Integer value) {
            addCriterion("channel_order_count <", value, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("channel_order_count <=", value, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountIn(List<Integer> values) {
            addCriterion("channel_order_count in", values, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountNotIn(List<Integer> values) {
            addCriterion("channel_order_count not in", values, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("channel_order_count between", value1, value2, "channelOrderCount");
            return (Criteria) this;
        }

        public Criteria andChannelOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_order_count not between", value1, value2, "channelOrderCount");
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

        public Criteria andErrorOrderCountIsNull() {
            addCriterion("error_order_count is null");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountIsNotNull() {
            addCriterion("error_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountEqualTo(Integer value) {
            addCriterion("error_order_count =", value, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountNotEqualTo(Integer value) {
            addCriterion("error_order_count <>", value, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountGreaterThan(Integer value) {
            addCriterion("error_order_count >", value, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_order_count >=", value, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountLessThan(Integer value) {
            addCriterion("error_order_count <", value, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("error_order_count <=", value, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountIn(List<Integer> values) {
            addCriterion("error_order_count in", values, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountNotIn(List<Integer> values) {
            addCriterion("error_order_count not in", values, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("error_order_count between", value1, value2, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("error_order_count not between", value1, value2, "errorOrderCount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountIsNull() {
            addCriterion("error_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountIsNotNull() {
            addCriterion("error_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountEqualTo(Long value) {
            addCriterion("error_order_amount =", value, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountNotEqualTo(Long value) {
            addCriterion("error_order_amount <>", value, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountGreaterThan(Long value) {
            addCriterion("error_order_amount >", value, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("error_order_amount >=", value, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountLessThan(Long value) {
            addCriterion("error_order_amount <", value, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("error_order_amount <=", value, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountIn(List<Long> values) {
            addCriterion("error_order_amount in", values, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountNotIn(List<Long> values) {
            addCriterion("error_order_amount not in", values, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountBetween(Long value1, Long value2) {
            addCriterion("error_order_amount between", value1, value2, "errorOrderAmount");
            return (Criteria) this;
        }

        public Criteria andErrorOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("error_order_amount not between", value1, value2, "errorOrderAmount");
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