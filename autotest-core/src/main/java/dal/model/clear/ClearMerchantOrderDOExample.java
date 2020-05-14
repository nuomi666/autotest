package dal.model.clear;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClearMerchantOrderDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClearMerchantOrderDOExample() {
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

        public Criteria andTransTypeIsNull() {
            addCriterion("trans_type is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("trans_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(String value) {
            addCriterion("trans_type =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(String value) {
            addCriterion("trans_type <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(String value) {
            addCriterion("trans_type >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trans_type >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(String value) {
            addCriterion("trans_type <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(String value) {
            addCriterion("trans_type <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLike(String value) {
            addCriterion("trans_type like", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotLike(String value) {
            addCriterion("trans_type not like", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<String> values) {
            addCriterion("trans_type in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<String> values) {
            addCriterion("trans_type not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(String value1, String value2) {
            addCriterion("trans_type between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(String value1, String value2) {
            addCriterion("trans_type not between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTagIsNull() {
            addCriterion("trans_tag is null");
            return (Criteria) this;
        }

        public Criteria andTransTagIsNotNull() {
            addCriterion("trans_tag is not null");
            return (Criteria) this;
        }

        public Criteria andTransTagEqualTo(String value) {
            addCriterion("trans_tag =", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagNotEqualTo(String value) {
            addCriterion("trans_tag <>", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagGreaterThan(String value) {
            addCriterion("trans_tag >", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagGreaterThanOrEqualTo(String value) {
            addCriterion("trans_tag >=", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagLessThan(String value) {
            addCriterion("trans_tag <", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagLessThanOrEqualTo(String value) {
            addCriterion("trans_tag <=", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagLike(String value) {
            addCriterion("trans_tag like", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagNotLike(String value) {
            addCriterion("trans_tag not like", value, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagIn(List<String> values) {
            addCriterion("trans_tag in", values, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagNotIn(List<String> values) {
            addCriterion("trans_tag not in", values, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagBetween(String value1, String value2) {
            addCriterion("trans_tag between", value1, value2, "transTag");
            return (Criteria) this;
        }

        public Criteria andTransTagNotBetween(String value1, String value2) {
            addCriterion("trans_tag not between", value1, value2, "transTag");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
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

        public Criteria andBizNoIsNull() {
            addCriterion("biz_no is null");
            return (Criteria) this;
        }

        public Criteria andBizNoIsNotNull() {
            addCriterion("biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andBizNoEqualTo(String value) {
            addCriterion("biz_no =", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotEqualTo(String value) {
            addCriterion("biz_no <>", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoGreaterThan(String value) {
            addCriterion("biz_no >", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("biz_no >=", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLessThan(String value) {
            addCriterion("biz_no <", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLessThanOrEqualTo(String value) {
            addCriterion("biz_no <=", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLike(String value) {
            addCriterion("biz_no like", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotLike(String value) {
            addCriterion("biz_no not like", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoIn(List<String> values) {
            addCriterion("biz_no in", values, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotIn(List<String> values) {
            addCriterion("biz_no not in", values, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoBetween(String value1, String value2) {
            addCriterion("biz_no between", value1, value2, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotBetween(String value1, String value2) {
            addCriterion("biz_no not between", value1, value2, "bizNo");
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

        public Criteria andMerchantRateTypeIsNull() {
            addCriterion("merchant_rate_type is null");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeIsNotNull() {
            addCriterion("merchant_rate_type is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeEqualTo(String value) {
            addCriterion("merchant_rate_type =", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeNotEqualTo(String value) {
            addCriterion("merchant_rate_type <>", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeGreaterThan(String value) {
            addCriterion("merchant_rate_type >", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_rate_type >=", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeLessThan(String value) {
            addCriterion("merchant_rate_type <", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeLessThanOrEqualTo(String value) {
            addCriterion("merchant_rate_type <=", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeLike(String value) {
            addCriterion("merchant_rate_type like", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeNotLike(String value) {
            addCriterion("merchant_rate_type not like", value, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeIn(List<String> values) {
            addCriterion("merchant_rate_type in", values, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeNotIn(List<String> values) {
            addCriterion("merchant_rate_type not in", values, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeBetween(String value1, String value2) {
            addCriterion("merchant_rate_type between", value1, value2, "merchantRateType");
            return (Criteria) this;
        }

        public Criteria andMerchantRateTypeNotBetween(String value1, String value2) {
            addCriterion("merchant_rate_type not between", value1, value2, "merchantRateType");
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

        public Criteria andChannelRateTypeIsNull() {
            addCriterion("channel_rate_type is null");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeIsNotNull() {
            addCriterion("channel_rate_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeEqualTo(String value) {
            addCriterion("channel_rate_type =", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeNotEqualTo(String value) {
            addCriterion("channel_rate_type <>", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeGreaterThan(String value) {
            addCriterion("channel_rate_type >", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_rate_type >=", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeLessThan(String value) {
            addCriterion("channel_rate_type <", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeLessThanOrEqualTo(String value) {
            addCriterion("channel_rate_type <=", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeLike(String value) {
            addCriterion("channel_rate_type like", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeNotLike(String value) {
            addCriterion("channel_rate_type not like", value, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeIn(List<String> values) {
            addCriterion("channel_rate_type in", values, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeNotIn(List<String> values) {
            addCriterion("channel_rate_type not in", values, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeBetween(String value1, String value2) {
            addCriterion("channel_rate_type between", value1, value2, "channelRateType");
            return (Criteria) this;
        }

        public Criteria andChannelRateTypeNotBetween(String value1, String value2) {
            addCriterion("channel_rate_type not between", value1, value2, "channelRateType");
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

        public Criteria andSettlementDateIsNull() {
            addCriterion("settlement_date is null");
            return (Criteria) this;
        }

        public Criteria andSettlementDateIsNotNull() {
            addCriterion("settlement_date is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementDateEqualTo(String value) {
            addCriterion("settlement_date =", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateNotEqualTo(String value) {
            addCriterion("settlement_date <>", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateGreaterThan(String value) {
            addCriterion("settlement_date >", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_date >=", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateLessThan(String value) {
            addCriterion("settlement_date <", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateLessThanOrEqualTo(String value) {
            addCriterion("settlement_date <=", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateLike(String value) {
            addCriterion("settlement_date like", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateNotLike(String value) {
            addCriterion("settlement_date not like", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateIn(List<String> values) {
            addCriterion("settlement_date in", values, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateNotIn(List<String> values) {
            addCriterion("settlement_date not in", values, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateBetween(String value1, String value2) {
            addCriterion("settlement_date between", value1, value2, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andSettlementDateNotBetween(String value1, String value2) {
            addCriterion("settlement_date not between", value1, value2, "settlementDate");
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

        public Criteria andClearStatusIsNull() {
            addCriterion("clear_status is null");
            return (Criteria) this;
        }

        public Criteria andClearStatusIsNotNull() {
            addCriterion("clear_status is not null");
            return (Criteria) this;
        }

        public Criteria andClearStatusEqualTo(String value) {
            addCriterion("clear_status =", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotEqualTo(String value) {
            addCriterion("clear_status <>", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusGreaterThan(String value) {
            addCriterion("clear_status >", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusGreaterThanOrEqualTo(String value) {
            addCriterion("clear_status >=", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusLessThan(String value) {
            addCriterion("clear_status <", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusLessThanOrEqualTo(String value) {
            addCriterion("clear_status <=", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusLike(String value) {
            addCriterion("clear_status like", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotLike(String value) {
            addCriterion("clear_status not like", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusIn(List<String> values) {
            addCriterion("clear_status in", values, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotIn(List<String> values) {
            addCriterion("clear_status not in", values, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusBetween(String value1, String value2) {
            addCriterion("clear_status between", value1, value2, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotBetween(String value1, String value2) {
            addCriterion("clear_status not between", value1, value2, "clearStatus");
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