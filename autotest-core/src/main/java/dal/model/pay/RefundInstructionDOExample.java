package dal.model.pay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefundInstructionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RefundInstructionDOExample() {
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

        public Criteria andRefundTypeIsNull() {
            addCriterion("refund_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundTypeIsNotNull() {
            addCriterion("refund_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTypeEqualTo(String value) {
            addCriterion("refund_type =", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotEqualTo(String value) {
            addCriterion("refund_type <>", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeGreaterThan(String value) {
            addCriterion("refund_type >", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_type >=", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLessThan(String value) {
            addCriterion("refund_type <", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_type <=", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLike(String value) {
            addCriterion("refund_type like", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotLike(String value) {
            addCriterion("refund_type not like", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeIn(List<String> values) {
            addCriterion("refund_type in", values, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotIn(List<String> values) {
            addCriterion("refund_type not in", values, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeBetween(String value1, String value2) {
            addCriterion("refund_type between", value1, value2, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotBetween(String value1, String value2) {
            addCriterion("refund_type not between", value1, value2, "refundType");
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

        public Criteria andReqIdIsNull() {
            addCriterion("req_id is null");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNotNull() {
            addCriterion("req_id is not null");
            return (Criteria) this;
        }

        public Criteria andReqIdEqualTo(String value) {
            addCriterion("req_id =", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotEqualTo(String value) {
            addCriterion("req_id <>", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThan(String value) {
            addCriterion("req_id >", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThanOrEqualTo(String value) {
            addCriterion("req_id >=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThan(String value) {
            addCriterion("req_id <", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThanOrEqualTo(String value) {
            addCriterion("req_id <=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLike(String value) {
            addCriterion("req_id like", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotLike(String value) {
            addCriterion("req_id not like", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdIn(List<String> values) {
            addCriterion("req_id in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotIn(List<String> values) {
            addCriterion("req_id not in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdBetween(String value1, String value2) {
            addCriterion("req_id between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotBetween(String value1, String value2) {
            addCriterion("req_id not between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(String value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(String value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(String value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(String value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(String value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(String value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLike(String value) {
            addCriterion("gid like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotLike(String value) {
            addCriterion("gid not like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<String> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<String> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(String value1, String value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(String value1, String value2) {
            addCriterion("gid not between", value1, value2, "gid");
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

        public Criteria andRedirectUrlIsNull() {
            addCriterion("redirect_url is null");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlIsNotNull() {
            addCriterion("redirect_url is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlEqualTo(String value) {
            addCriterion("redirect_url =", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotEqualTo(String value) {
            addCriterion("redirect_url <>", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlGreaterThan(String value) {
            addCriterion("redirect_url >", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("redirect_url >=", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlLessThan(String value) {
            addCriterion("redirect_url <", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlLessThanOrEqualTo(String value) {
            addCriterion("redirect_url <=", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlLike(String value) {
            addCriterion("redirect_url like", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotLike(String value) {
            addCriterion("redirect_url not like", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlIn(List<String> values) {
            addCriterion("redirect_url in", values, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotIn(List<String> values) {
            addCriterion("redirect_url not in", values, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlBetween(String value1, String value2) {
            addCriterion("redirect_url between", value1, value2, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotBetween(String value1, String value2) {
            addCriterion("redirect_url not between", value1, value2, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoIsNull() {
            addCriterion("payment_biz_no is null");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoIsNotNull() {
            addCriterion("payment_biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoEqualTo(String value) {
            addCriterion("payment_biz_no =", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoNotEqualTo(String value) {
            addCriterion("payment_biz_no <>", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoGreaterThan(String value) {
            addCriterion("payment_biz_no >", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("payment_biz_no >=", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoLessThan(String value) {
            addCriterion("payment_biz_no <", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoLessThanOrEqualTo(String value) {
            addCriterion("payment_biz_no <=", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoLike(String value) {
            addCriterion("payment_biz_no like", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoNotLike(String value) {
            addCriterion("payment_biz_no not like", value, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoIn(List<String> values) {
            addCriterion("payment_biz_no in", values, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoNotIn(List<String> values) {
            addCriterion("payment_biz_no not in", values, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoBetween(String value1, String value2) {
            addCriterion("payment_biz_no between", value1, value2, "paymentBizNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBizNoNotBetween(String value1, String value2) {
            addCriterion("payment_biz_no not between", value1, value2, "paymentBizNo");
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

        public Criteria andPayerUserIdIsNull() {
            addCriterion("payer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdIsNotNull() {
            addCriterion("payer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdEqualTo(String value) {
            addCriterion("payer_user_id =", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdNotEqualTo(String value) {
            addCriterion("payer_user_id <>", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdGreaterThan(String value) {
            addCriterion("payer_user_id >", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("payer_user_id >=", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdLessThan(String value) {
            addCriterion("payer_user_id <", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdLessThanOrEqualTo(String value) {
            addCriterion("payer_user_id <=", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdLike(String value) {
            addCriterion("payer_user_id like", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdNotLike(String value) {
            addCriterion("payer_user_id not like", value, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdIn(List<String> values) {
            addCriterion("payer_user_id in", values, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdNotIn(List<String> values) {
            addCriterion("payer_user_id not in", values, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdBetween(String value1, String value2) {
            addCriterion("payer_user_id between", value1, value2, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserIdNotBetween(String value1, String value2) {
            addCriterion("payer_user_id not between", value1, value2, "payerUserId");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceIsNull() {
            addCriterion("payer_user_balance is null");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceIsNotNull() {
            addCriterion("payer_user_balance is not null");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceEqualTo(Long value) {
            addCriterion("payer_user_balance =", value, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceNotEqualTo(Long value) {
            addCriterion("payer_user_balance <>", value, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceGreaterThan(Long value) {
            addCriterion("payer_user_balance >", value, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("payer_user_balance >=", value, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceLessThan(Long value) {
            addCriterion("payer_user_balance <", value, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceLessThanOrEqualTo(Long value) {
            addCriterion("payer_user_balance <=", value, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceIn(List<Long> values) {
            addCriterion("payer_user_balance in", values, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceNotIn(List<Long> values) {
            addCriterion("payer_user_balance not in", values, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceBetween(Long value1, Long value2) {
            addCriterion("payer_user_balance between", value1, value2, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerUserBalanceNotBetween(Long value1, Long value2) {
            addCriterion("payer_user_balance not between", value1, value2, "payerUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdIsNull() {
            addCriterion("payee_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdIsNotNull() {
            addCriterion("payee_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdEqualTo(String value) {
            addCriterion("payee_user_id =", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdNotEqualTo(String value) {
            addCriterion("payee_user_id <>", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdGreaterThan(String value) {
            addCriterion("payee_user_id >", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("payee_user_id >=", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdLessThan(String value) {
            addCriterion("payee_user_id <", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdLessThanOrEqualTo(String value) {
            addCriterion("payee_user_id <=", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdLike(String value) {
            addCriterion("payee_user_id like", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdNotLike(String value) {
            addCriterion("payee_user_id not like", value, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdIn(List<String> values) {
            addCriterion("payee_user_id in", values, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdNotIn(List<String> values) {
            addCriterion("payee_user_id not in", values, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdBetween(String value1, String value2) {
            addCriterion("payee_user_id between", value1, value2, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserIdNotBetween(String value1, String value2) {
            addCriterion("payee_user_id not between", value1, value2, "payeeUserId");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceIsNull() {
            addCriterion("payee_user_balance is null");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceIsNotNull() {
            addCriterion("payee_user_balance is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceEqualTo(Long value) {
            addCriterion("payee_user_balance =", value, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceNotEqualTo(Long value) {
            addCriterion("payee_user_balance <>", value, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceGreaterThan(Long value) {
            addCriterion("payee_user_balance >", value, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("payee_user_balance >=", value, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceLessThan(Long value) {
            addCriterion("payee_user_balance <", value, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceLessThanOrEqualTo(Long value) {
            addCriterion("payee_user_balance <=", value, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceIn(List<Long> values) {
            addCriterion("payee_user_balance in", values, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceNotIn(List<Long> values) {
            addCriterion("payee_user_balance not in", values, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceBetween(Long value1, Long value2) {
            addCriterion("payee_user_balance between", value1, value2, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeUserBalanceNotBetween(Long value1, Long value2) {
            addCriterion("payee_user_balance not between", value1, value2, "payeeUserBalance");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoIsNull() {
            addCriterion("payer_account_no is null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoIsNotNull() {
            addCriterion("payer_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoEqualTo(String value) {
            addCriterion("payer_account_no =", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotEqualTo(String value) {
            addCriterion("payer_account_no <>", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoGreaterThan(String value) {
            addCriterion("payer_account_no >", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("payer_account_no >=", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoLessThan(String value) {
            addCriterion("payer_account_no <", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoLessThanOrEqualTo(String value) {
            addCriterion("payer_account_no <=", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoLike(String value) {
            addCriterion("payer_account_no like", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotLike(String value) {
            addCriterion("payer_account_no not like", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoIn(List<String> values) {
            addCriterion("payer_account_no in", values, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotIn(List<String> values) {
            addCriterion("payer_account_no not in", values, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoBetween(String value1, String value2) {
            addCriterion("payer_account_no between", value1, value2, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotBetween(String value1, String value2) {
            addCriterion("payer_account_no not between", value1, value2, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoIsNull() {
            addCriterion("relation_account_no is null");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoIsNotNull() {
            addCriterion("relation_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoEqualTo(String value) {
            addCriterion("relation_account_no =", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoNotEqualTo(String value) {
            addCriterion("relation_account_no <>", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoGreaterThan(String value) {
            addCriterion("relation_account_no >", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("relation_account_no >=", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoLessThan(String value) {
            addCriterion("relation_account_no <", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoLessThanOrEqualTo(String value) {
            addCriterion("relation_account_no <=", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoLike(String value) {
            addCriterion("relation_account_no like", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoNotLike(String value) {
            addCriterion("relation_account_no not like", value, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoIn(List<String> values) {
            addCriterion("relation_account_no in", values, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoNotIn(List<String> values) {
            addCriterion("relation_account_no not in", values, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoBetween(String value1, String value2) {
            addCriterion("relation_account_no between", value1, value2, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccountNoNotBetween(String value1, String value2) {
            addCriterion("relation_account_no not between", value1, value2, "relationAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoIsNull() {
            addCriterion("payee_account_no is null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoIsNotNull() {
            addCriterion("payee_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoEqualTo(String value) {
            addCriterion("payee_account_no =", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotEqualTo(String value) {
            addCriterion("payee_account_no <>", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoGreaterThan(String value) {
            addCriterion("payee_account_no >", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("payee_account_no >=", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoLessThan(String value) {
            addCriterion("payee_account_no <", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("payee_account_no <=", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoLike(String value) {
            addCriterion("payee_account_no like", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotLike(String value) {
            addCriterion("payee_account_no not like", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoIn(List<String> values) {
            addCriterion("payee_account_no in", values, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotIn(List<String> values) {
            addCriterion("payee_account_no not in", values, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoBetween(String value1, String value2) {
            addCriterion("payee_account_no between", value1, value2, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("payee_account_no not between", value1, value2, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Long value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Long value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Long value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Long value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Long value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Long> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Long> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Long value1, Long value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Long value1, Long value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(Long value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(Long value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(Long value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(Long value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(Long value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<Long> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<Long> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(Long value1, Long value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(Long value1, Long value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoIsNull() {
            addCriterion("payer_acc_biz_no is null");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoIsNotNull() {
            addCriterion("payer_acc_biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoEqualTo(String value) {
            addCriterion("payer_acc_biz_no =", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoNotEqualTo(String value) {
            addCriterion("payer_acc_biz_no <>", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoGreaterThan(String value) {
            addCriterion("payer_acc_biz_no >", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("payer_acc_biz_no >=", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoLessThan(String value) {
            addCriterion("payer_acc_biz_no <", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoLessThanOrEqualTo(String value) {
            addCriterion("payer_acc_biz_no <=", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoLike(String value) {
            addCriterion("payer_acc_biz_no like", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoNotLike(String value) {
            addCriterion("payer_acc_biz_no not like", value, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoIn(List<String> values) {
            addCriterion("payer_acc_biz_no in", values, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoNotIn(List<String> values) {
            addCriterion("payer_acc_biz_no not in", values, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoBetween(String value1, String value2) {
            addCriterion("payer_acc_biz_no between", value1, value2, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccBizNoNotBetween(String value1, String value2) {
            addCriterion("payer_acc_biz_no not between", value1, value2, "payerAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoIsNull() {
            addCriterion("relation_acc_biz_no is null");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoIsNotNull() {
            addCriterion("relation_acc_biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoEqualTo(String value) {
            addCriterion("relation_acc_biz_no =", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoNotEqualTo(String value) {
            addCriterion("relation_acc_biz_no <>", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoGreaterThan(String value) {
            addCriterion("relation_acc_biz_no >", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("relation_acc_biz_no >=", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoLessThan(String value) {
            addCriterion("relation_acc_biz_no <", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoLessThanOrEqualTo(String value) {
            addCriterion("relation_acc_biz_no <=", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoLike(String value) {
            addCriterion("relation_acc_biz_no like", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoNotLike(String value) {
            addCriterion("relation_acc_biz_no not like", value, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoIn(List<String> values) {
            addCriterion("relation_acc_biz_no in", values, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoNotIn(List<String> values) {
            addCriterion("relation_acc_biz_no not in", values, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoBetween(String value1, String value2) {
            addCriterion("relation_acc_biz_no between", value1, value2, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andRelationAccBizNoNotBetween(String value1, String value2) {
            addCriterion("relation_acc_biz_no not between", value1, value2, "relationAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoIsNull() {
            addCriterion("payee_acc_biz_no is null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoIsNotNull() {
            addCriterion("payee_acc_biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoEqualTo(String value) {
            addCriterion("payee_acc_biz_no =", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoNotEqualTo(String value) {
            addCriterion("payee_acc_biz_no <>", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoGreaterThan(String value) {
            addCriterion("payee_acc_biz_no >", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("payee_acc_biz_no >=", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoLessThan(String value) {
            addCriterion("payee_acc_biz_no <", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoLessThanOrEqualTo(String value) {
            addCriterion("payee_acc_biz_no <=", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoLike(String value) {
            addCriterion("payee_acc_biz_no like", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoNotLike(String value) {
            addCriterion("payee_acc_biz_no not like", value, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoIn(List<String> values) {
            addCriterion("payee_acc_biz_no in", values, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoNotIn(List<String> values) {
            addCriterion("payee_acc_biz_no not in", values, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoBetween(String value1, String value2) {
            addCriterion("payee_acc_biz_no between", value1, value2, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBizNoNotBetween(String value1, String value2) {
            addCriterion("payee_acc_biz_no not between", value1, value2, "payeeAccBizNo");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateIsNull() {
            addCriterion("payer_trans_date is null");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateIsNotNull() {
            addCriterion("payer_trans_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateEqualTo(Date value) {
            addCriterion("payer_trans_date =", value, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateNotEqualTo(Date value) {
            addCriterion("payer_trans_date <>", value, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateGreaterThan(Date value) {
            addCriterion("payer_trans_date >", value, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateGreaterThanOrEqualTo(Date value) {
            addCriterion("payer_trans_date >=", value, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateLessThan(Date value) {
            addCriterion("payer_trans_date <", value, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateLessThanOrEqualTo(Date value) {
            addCriterion("payer_trans_date <=", value, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateIn(List<Date> values) {
            addCriterion("payer_trans_date in", values, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateNotIn(List<Date> values) {
            addCriterion("payer_trans_date not in", values, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateBetween(Date value1, Date value2) {
            addCriterion("payer_trans_date between", value1, value2, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andPayerTransDateNotBetween(Date value1, Date value2) {
            addCriterion("payer_trans_date not between", value1, value2, "payerTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateIsNull() {
            addCriterion("relation_trans_date is null");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateIsNotNull() {
            addCriterion("relation_trans_date is not null");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateEqualTo(Date value) {
            addCriterion("relation_trans_date =", value, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateNotEqualTo(Date value) {
            addCriterion("relation_trans_date <>", value, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateGreaterThan(Date value) {
            addCriterion("relation_trans_date >", value, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateGreaterThanOrEqualTo(Date value) {
            addCriterion("relation_trans_date >=", value, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateLessThan(Date value) {
            addCriterion("relation_trans_date <", value, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateLessThanOrEqualTo(Date value) {
            addCriterion("relation_trans_date <=", value, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateIn(List<Date> values) {
            addCriterion("relation_trans_date in", values, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateNotIn(List<Date> values) {
            addCriterion("relation_trans_date not in", values, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateBetween(Date value1, Date value2) {
            addCriterion("relation_trans_date between", value1, value2, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andRelationTransDateNotBetween(Date value1, Date value2) {
            addCriterion("relation_trans_date not between", value1, value2, "relationTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateIsNull() {
            addCriterion("payee_trans_date is null");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateIsNotNull() {
            addCriterion("payee_trans_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateEqualTo(Date value) {
            addCriterion("payee_trans_date =", value, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateNotEqualTo(Date value) {
            addCriterion("payee_trans_date <>", value, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateGreaterThan(Date value) {
            addCriterion("payee_trans_date >", value, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateGreaterThanOrEqualTo(Date value) {
            addCriterion("payee_trans_date >=", value, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateLessThan(Date value) {
            addCriterion("payee_trans_date <", value, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateLessThanOrEqualTo(Date value) {
            addCriterion("payee_trans_date <=", value, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateIn(List<Date> values) {
            addCriterion("payee_trans_date in", values, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateNotIn(List<Date> values) {
            addCriterion("payee_trans_date not in", values, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateBetween(Date value1, Date value2) {
            addCriterion("payee_trans_date between", value1, value2, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andPayeeTransDateNotBetween(Date value1, Date value2) {
            addCriterion("payee_trans_date not between", value1, value2, "payeeTransDate");
            return (Criteria) this;
        }

        public Criteria andRefundCouponIsNull() {
            addCriterion("refund_coupon is null");
            return (Criteria) this;
        }

        public Criteria andRefundCouponIsNotNull() {
            addCriterion("refund_coupon is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCouponEqualTo(String value) {
            addCriterion("refund_coupon =", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponNotEqualTo(String value) {
            addCriterion("refund_coupon <>", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponGreaterThan(String value) {
            addCriterion("refund_coupon >", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponGreaterThanOrEqualTo(String value) {
            addCriterion("refund_coupon >=", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponLessThan(String value) {
            addCriterion("refund_coupon <", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponLessThanOrEqualTo(String value) {
            addCriterion("refund_coupon <=", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponLike(String value) {
            addCriterion("refund_coupon like", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponNotLike(String value) {
            addCriterion("refund_coupon not like", value, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponIn(List<String> values) {
            addCriterion("refund_coupon in", values, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponNotIn(List<String> values) {
            addCriterion("refund_coupon not in", values, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponBetween(String value1, String value2) {
            addCriterion("refund_coupon between", value1, value2, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andRefundCouponNotBetween(String value1, String value2) {
            addCriterion("refund_coupon not between", value1, value2, "refundCoupon");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdIsNull() {
            addCriterion("coupon_instruction_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdIsNotNull() {
            addCriterion("coupon_instruction_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdEqualTo(String value) {
            addCriterion("coupon_instruction_id =", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdNotEqualTo(String value) {
            addCriterion("coupon_instruction_id <>", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdGreaterThan(String value) {
            addCriterion("coupon_instruction_id >", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_instruction_id >=", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdLessThan(String value) {
            addCriterion("coupon_instruction_id <", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdLessThanOrEqualTo(String value) {
            addCriterion("coupon_instruction_id <=", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdLike(String value) {
            addCriterion("coupon_instruction_id like", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdNotLike(String value) {
            addCriterion("coupon_instruction_id not like", value, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdIn(List<String> values) {
            addCriterion("coupon_instruction_id in", values, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdNotIn(List<String> values) {
            addCriterion("coupon_instruction_id not in", values, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdBetween(String value1, String value2) {
            addCriterion("coupon_instruction_id between", value1, value2, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andCouponInstructionIdNotBetween(String value1, String value2) {
            addCriterion("coupon_instruction_id not between", value1, value2, "couponInstructionId");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeIsNull() {
            addCriterion("un_freeze_code is null");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeIsNotNull() {
            addCriterion("un_freeze_code is not null");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeEqualTo(String value) {
            addCriterion("un_freeze_code =", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeNotEqualTo(String value) {
            addCriterion("un_freeze_code <>", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeGreaterThan(String value) {
            addCriterion("un_freeze_code >", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("un_freeze_code >=", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeLessThan(String value) {
            addCriterion("un_freeze_code <", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeLessThanOrEqualTo(String value) {
            addCriterion("un_freeze_code <=", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeLike(String value) {
            addCriterion("un_freeze_code like", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeNotLike(String value) {
            addCriterion("un_freeze_code not like", value, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeIn(List<String> values) {
            addCriterion("un_freeze_code in", values, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeNotIn(List<String> values) {
            addCriterion("un_freeze_code not in", values, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeBetween(String value1, String value2) {
            addCriterion("un_freeze_code between", value1, value2, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andUnFreezeCodeNotBetween(String value1, String value2) {
            addCriterion("un_freeze_code not between", value1, value2, "unFreezeCode");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andRunMemoIsNull() {
            addCriterion("run_memo is null");
            return (Criteria) this;
        }

        public Criteria andRunMemoIsNotNull() {
            addCriterion("run_memo is not null");
            return (Criteria) this;
        }

        public Criteria andRunMemoEqualTo(String value) {
            addCriterion("run_memo =", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoNotEqualTo(String value) {
            addCriterion("run_memo <>", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoGreaterThan(String value) {
            addCriterion("run_memo >", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoGreaterThanOrEqualTo(String value) {
            addCriterion("run_memo >=", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoLessThan(String value) {
            addCriterion("run_memo <", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoLessThanOrEqualTo(String value) {
            addCriterion("run_memo <=", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoLike(String value) {
            addCriterion("run_memo like", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoNotLike(String value) {
            addCriterion("run_memo not like", value, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoIn(List<String> values) {
            addCriterion("run_memo in", values, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoNotIn(List<String> values) {
            addCriterion("run_memo not in", values, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoBetween(String value1, String value2) {
            addCriterion("run_memo between", value1, value2, "runMemo");
            return (Criteria) this;
        }

        public Criteria andRunMemoNotBetween(String value1, String value2) {
            addCriterion("run_memo not between", value1, value2, "runMemo");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNull() {
            addCriterion("receipt is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNotNull() {
            addCriterion("receipt is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptEqualTo(String value) {
            addCriterion("receipt =", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotEqualTo(String value) {
            addCriterion("receipt <>", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThan(String value) {
            addCriterion("receipt >", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThanOrEqualTo(String value) {
            addCriterion("receipt >=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThan(String value) {
            addCriterion("receipt <", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThanOrEqualTo(String value) {
            addCriterion("receipt <=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLike(String value) {
            addCriterion("receipt like", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotLike(String value) {
            addCriterion("receipt not like", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptIn(List<String> values) {
            addCriterion("receipt in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotIn(List<String> values) {
            addCriterion("receipt not in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptBetween(String value1, String value2) {
            addCriterion("receipt between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotBetween(String value1, String value2) {
            addCriterion("receipt not between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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

        public Criteria andCompensateIsNull() {
            addCriterion("compensate is null");
            return (Criteria) this;
        }

        public Criteria andCompensateIsNotNull() {
            addCriterion("compensate is not null");
            return (Criteria) this;
        }

        public Criteria andCompensateEqualTo(String value) {
            addCriterion("compensate =", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateNotEqualTo(String value) {
            addCriterion("compensate <>", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateGreaterThan(String value) {
            addCriterion("compensate >", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateGreaterThanOrEqualTo(String value) {
            addCriterion("compensate >=", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateLessThan(String value) {
            addCriterion("compensate <", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateLessThanOrEqualTo(String value) {
            addCriterion("compensate <=", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateLike(String value) {
            addCriterion("compensate like", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateNotLike(String value) {
            addCriterion("compensate not like", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateIn(List<String> values) {
            addCriterion("compensate in", values, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateNotIn(List<String> values) {
            addCriterion("compensate not in", values, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateBetween(String value1, String value2) {
            addCriterion("compensate between", value1, value2, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateNotBetween(String value1, String value2) {
            addCriterion("compensate not between", value1, value2, "compensate");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataIsNull() {
            addCriterion("external_meta_data is null");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataIsNotNull() {
            addCriterion("external_meta_data is not null");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataEqualTo(String value) {
            addCriterion("external_meta_data =", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataNotEqualTo(String value) {
            addCriterion("external_meta_data <>", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataGreaterThan(String value) {
            addCriterion("external_meta_data >", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataGreaterThanOrEqualTo(String value) {
            addCriterion("external_meta_data >=", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataLessThan(String value) {
            addCriterion("external_meta_data <", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataLessThanOrEqualTo(String value) {
            addCriterion("external_meta_data <=", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataLike(String value) {
            addCriterion("external_meta_data like", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataNotLike(String value) {
            addCriterion("external_meta_data not like", value, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataIn(List<String> values) {
            addCriterion("external_meta_data in", values, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataNotIn(List<String> values) {
            addCriterion("external_meta_data not in", values, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataBetween(String value1, String value2) {
            addCriterion("external_meta_data between", value1, value2, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExternalMetaDataNotBetween(String value1, String value2) {
            addCriterion("external_meta_data not between", value1, value2, "externalMetaData");
            return (Criteria) this;
        }

        public Criteria andExtensionContextIsNull() {
            addCriterion("extension_context is null");
            return (Criteria) this;
        }

        public Criteria andExtensionContextIsNotNull() {
            addCriterion("extension_context is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionContextEqualTo(String value) {
            addCriterion("extension_context =", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextNotEqualTo(String value) {
            addCriterion("extension_context <>", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextGreaterThan(String value) {
            addCriterion("extension_context >", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextGreaterThanOrEqualTo(String value) {
            addCriterion("extension_context >=", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextLessThan(String value) {
            addCriterion("extension_context <", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextLessThanOrEqualTo(String value) {
            addCriterion("extension_context <=", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextLike(String value) {
            addCriterion("extension_context like", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextNotLike(String value) {
            addCriterion("extension_context not like", value, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextIn(List<String> values) {
            addCriterion("extension_context in", values, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextNotIn(List<String> values) {
            addCriterion("extension_context not in", values, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextBetween(String value1, String value2) {
            addCriterion("extension_context between", value1, value2, "extensionContext");
            return (Criteria) this;
        }

        public Criteria andExtensionContextNotBetween(String value1, String value2) {
            addCriterion("extension_context not between", value1, value2, "extensionContext");
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