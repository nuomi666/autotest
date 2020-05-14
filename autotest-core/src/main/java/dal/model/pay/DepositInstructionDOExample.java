package dal.model.pay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepositInstructionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepositInstructionDOExample() {
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

        public Criteria andLinkAccountNoIsNull() {
            addCriterion("link_account_no is null");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoIsNotNull() {
            addCriterion("link_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoEqualTo(String value) {
            addCriterion("link_account_no =", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoNotEqualTo(String value) {
            addCriterion("link_account_no <>", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoGreaterThan(String value) {
            addCriterion("link_account_no >", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("link_account_no >=", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoLessThan(String value) {
            addCriterion("link_account_no <", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoLessThanOrEqualTo(String value) {
            addCriterion("link_account_no <=", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoLike(String value) {
            addCriterion("link_account_no like", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoNotLike(String value) {
            addCriterion("link_account_no not like", value, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoIn(List<String> values) {
            addCriterion("link_account_no in", values, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoNotIn(List<String> values) {
            addCriterion("link_account_no not in", values, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoBetween(String value1, String value2) {
            addCriterion("link_account_no between", value1, value2, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andLinkAccountNoNotBetween(String value1, String value2) {
            addCriterion("link_account_no not between", value1, value2, "linkAccountNo");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagIsNull() {
            addCriterion("relation_user_tag is null");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagIsNotNull() {
            addCriterion("relation_user_tag is not null");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagEqualTo(String value) {
            addCriterion("relation_user_tag =", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagNotEqualTo(String value) {
            addCriterion("relation_user_tag <>", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagGreaterThan(String value) {
            addCriterion("relation_user_tag >", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagGreaterThanOrEqualTo(String value) {
            addCriterion("relation_user_tag >=", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagLessThan(String value) {
            addCriterion("relation_user_tag <", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagLessThanOrEqualTo(String value) {
            addCriterion("relation_user_tag <=", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagLike(String value) {
            addCriterion("relation_user_tag like", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagNotLike(String value) {
            addCriterion("relation_user_tag not like", value, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagIn(List<String> values) {
            addCriterion("relation_user_tag in", values, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagNotIn(List<String> values) {
            addCriterion("relation_user_tag not in", values, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagBetween(String value1, String value2) {
            addCriterion("relation_user_tag between", value1, value2, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andRelationUserTagNotBetween(String value1, String value2) {
            addCriterion("relation_user_tag not between", value1, value2, "relationUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagIsNull() {
            addCriterion("payee_user_tag is null");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagIsNotNull() {
            addCriterion("payee_user_tag is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagEqualTo(String value) {
            addCriterion("payee_user_tag =", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagNotEqualTo(String value) {
            addCriterion("payee_user_tag <>", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagGreaterThan(String value) {
            addCriterion("payee_user_tag >", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagGreaterThanOrEqualTo(String value) {
            addCriterion("payee_user_tag >=", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagLessThan(String value) {
            addCriterion("payee_user_tag <", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagLessThanOrEqualTo(String value) {
            addCriterion("payee_user_tag <=", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagLike(String value) {
            addCriterion("payee_user_tag like", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagNotLike(String value) {
            addCriterion("payee_user_tag not like", value, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagIn(List<String> values) {
            addCriterion("payee_user_tag in", values, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagNotIn(List<String> values) {
            addCriterion("payee_user_tag not in", values, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagBetween(String value1, String value2) {
            addCriterion("payee_user_tag between", value1, value2, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPayeeUserTagNotBetween(String value1, String value2) {
            addCriterion("payee_user_tag not between", value1, value2, "payeeUserTag");
            return (Criteria) this;
        }

        public Criteria andPartnerRateIsNull() {
            addCriterion("partner_rate is null");
            return (Criteria) this;
        }

        public Criteria andPartnerRateIsNotNull() {
            addCriterion("partner_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerRateEqualTo(Integer value) {
            addCriterion("partner_rate =", value, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateNotEqualTo(Integer value) {
            addCriterion("partner_rate <>", value, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateGreaterThan(Integer value) {
            addCriterion("partner_rate >", value, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("partner_rate >=", value, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateLessThan(Integer value) {
            addCriterion("partner_rate <", value, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateLessThanOrEqualTo(Integer value) {
            addCriterion("partner_rate <=", value, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateIn(List<Integer> values) {
            addCriterion("partner_rate in", values, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateNotIn(List<Integer> values) {
            addCriterion("partner_rate not in", values, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateBetween(Integer value1, Integer value2) {
            addCriterion("partner_rate between", value1, value2, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andPartnerRateNotBetween(Integer value1, Integer value2) {
            addCriterion("partner_rate not between", value1, value2, "partnerRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateIsNull() {
            addCriterion("channel_rate is null");
            return (Criteria) this;
        }

        public Criteria andChannelRateIsNotNull() {
            addCriterion("channel_rate is not null");
            return (Criteria) this;
        }

        public Criteria andChannelRateEqualTo(Integer value) {
            addCriterion("channel_rate =", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateNotEqualTo(Integer value) {
            addCriterion("channel_rate <>", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateGreaterThan(Integer value) {
            addCriterion("channel_rate >", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_rate >=", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateLessThan(Integer value) {
            addCriterion("channel_rate <", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateLessThanOrEqualTo(Integer value) {
            addCriterion("channel_rate <=", value, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateIn(List<Integer> values) {
            addCriterion("channel_rate in", values, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateNotIn(List<Integer> values) {
            addCriterion("channel_rate not in", values, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateBetween(Integer value1, Integer value2) {
            addCriterion("channel_rate between", value1, value2, "channelRate");
            return (Criteria) this;
        }

        public Criteria andChannelRateNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_rate not between", value1, value2, "channelRate");
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

        public Criteria andChannelFeeEqualTo(Long value) {
            addCriterion("channel_fee =", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeNotEqualTo(Long value) {
            addCriterion("channel_fee <>", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeGreaterThan(Long value) {
            addCriterion("channel_fee >", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_fee >=", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeLessThan(Long value) {
            addCriterion("channel_fee <", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeLessThanOrEqualTo(Long value) {
            addCriterion("channel_fee <=", value, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeIn(List<Long> values) {
            addCriterion("channel_fee in", values, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeNotIn(List<Long> values) {
            addCriterion("channel_fee not in", values, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeBetween(Long value1, Long value2) {
            addCriterion("channel_fee between", value1, value2, "channelFee");
            return (Criteria) this;
        }

        public Criteria andChannelFeeNotBetween(Long value1, Long value2) {
            addCriterion("channel_fee not between", value1, value2, "channelFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeIsNull() {
            addCriterion("partner_fee is null");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeIsNotNull() {
            addCriterion("partner_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeEqualTo(Long value) {
            addCriterion("partner_fee =", value, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeNotEqualTo(Long value) {
            addCriterion("partner_fee <>", value, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeGreaterThan(Long value) {
            addCriterion("partner_fee >", value, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("partner_fee >=", value, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeLessThan(Long value) {
            addCriterion("partner_fee <", value, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeLessThanOrEqualTo(Long value) {
            addCriterion("partner_fee <=", value, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeIn(List<Long> values) {
            addCriterion("partner_fee in", values, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeNotIn(List<Long> values) {
            addCriterion("partner_fee not in", values, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeBetween(Long value1, Long value2) {
            addCriterion("partner_fee between", value1, value2, "partnerFee");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeNotBetween(Long value1, Long value2) {
            addCriterion("partner_fee not between", value1, value2, "partnerFee");
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

        public Criteria andRealPayAmountIsNull() {
            addCriterion("real_pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountIsNotNull() {
            addCriterion("real_pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountEqualTo(Long value) {
            addCriterion("real_pay_amount =", value, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountNotEqualTo(Long value) {
            addCriterion("real_pay_amount <>", value, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountGreaterThan(Long value) {
            addCriterion("real_pay_amount >", value, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("real_pay_amount >=", value, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountLessThan(Long value) {
            addCriterion("real_pay_amount <", value, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountLessThanOrEqualTo(Long value) {
            addCriterion("real_pay_amount <=", value, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountIn(List<Long> values) {
            addCriterion("real_pay_amount in", values, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountNotIn(List<Long> values) {
            addCriterion("real_pay_amount not in", values, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountBetween(Long value1, Long value2) {
            addCriterion("real_pay_amount between", value1, value2, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andRealPayAmountNotBetween(Long value1, Long value2) {
            addCriterion("real_pay_amount not between", value1, value2, "realPayAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNull() {
            addCriterion("discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(Long value) {
            addCriterion("discount_amount =", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(Long value) {
            addCriterion("discount_amount <>", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(Long value) {
            addCriterion("discount_amount >", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("discount_amount >=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(Long value) {
            addCriterion("discount_amount <", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("discount_amount <=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<Long> values) {
            addCriterion("discount_amount in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<Long> values) {
            addCriterion("discount_amount not in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("discount_amount between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("discount_amount not between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andTransDateIsNull() {
            addCriterion("trans_date is null");
            return (Criteria) this;
        }

        public Criteria andTransDateIsNotNull() {
            addCriterion("trans_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransDateEqualTo(Date value) {
            addCriterion("trans_date =", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotEqualTo(Date value) {
            addCriterion("trans_date <>", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateGreaterThan(Date value) {
            addCriterion("trans_date >", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateGreaterThanOrEqualTo(Date value) {
            addCriterion("trans_date >=", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateLessThan(Date value) {
            addCriterion("trans_date <", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateLessThanOrEqualTo(Date value) {
            addCriterion("trans_date <=", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateIn(List<Date> values) {
            addCriterion("trans_date in", values, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotIn(List<Date> values) {
            addCriterion("trans_date not in", values, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateBetween(Date value1, Date value2) {
            addCriterion("trans_date between", value1, value2, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotBetween(Date value1, Date value2) {
            addCriterion("trans_date not between", value1, value2, "transDate");
            return (Criteria) this;
        }

        public Criteria andAccountDayIsNull() {
            addCriterion("account_day is null");
            return (Criteria) this;
        }

        public Criteria andAccountDayIsNotNull() {
            addCriterion("account_day is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDayEqualTo(String value) {
            addCriterion("account_day =", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayNotEqualTo(String value) {
            addCriterion("account_day <>", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayGreaterThan(String value) {
            addCriterion("account_day >", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayGreaterThanOrEqualTo(String value) {
            addCriterion("account_day >=", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayLessThan(String value) {
            addCriterion("account_day <", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayLessThanOrEqualTo(String value) {
            addCriterion("account_day <=", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayLike(String value) {
            addCriterion("account_day like", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayNotLike(String value) {
            addCriterion("account_day not like", value, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayIn(List<String> values) {
            addCriterion("account_day in", values, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayNotIn(List<String> values) {
            addCriterion("account_day not in", values, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayBetween(String value1, String value2) {
            addCriterion("account_day between", value1, value2, "accountDay");
            return (Criteria) this;
        }

        public Criteria andAccountDayNotBetween(String value1, String value2) {
            addCriterion("account_day not between", value1, value2, "accountDay");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoIsNull() {
            addCriterion("channel_biz_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoIsNotNull() {
            addCriterion("channel_biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoEqualTo(String value) {
            addCriterion("channel_biz_no =", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoNotEqualTo(String value) {
            addCriterion("channel_biz_no <>", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoGreaterThan(String value) {
            addCriterion("channel_biz_no >", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_biz_no >=", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoLessThan(String value) {
            addCriterion("channel_biz_no <", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoLessThanOrEqualTo(String value) {
            addCriterion("channel_biz_no <=", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoLike(String value) {
            addCriterion("channel_biz_no like", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoNotLike(String value) {
            addCriterion("channel_biz_no not like", value, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoIn(List<String> values) {
            addCriterion("channel_biz_no in", values, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoNotIn(List<String> values) {
            addCriterion("channel_biz_no not in", values, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoBetween(String value1, String value2) {
            addCriterion("channel_biz_no between", value1, value2, "channelBizNo");
            return (Criteria) this;
        }

        public Criteria andChannelBizNoNotBetween(String value1, String value2) {
            addCriterion("channel_biz_no not between", value1, value2, "channelBizNo");
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

        public Criteria andChannelNameIsNull() {
            addCriterion("channel_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("channel_name =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("channel_name <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("channel_name >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_name >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("channel_name <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("channel_name <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("channel_name like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("channel_name not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("channel_name in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("channel_name not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("channel_name between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("channel_name not between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNull() {
            addCriterion("pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNotNull() {
            addCriterion("pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelEqualTo(String value) {
            addCriterion("pay_channel =", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotEqualTo(String value) {
            addCriterion("pay_channel <>", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThan(String value) {
            addCriterion("pay_channel >", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThanOrEqualTo(String value) {
            addCriterion("pay_channel >=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThan(String value) {
            addCriterion("pay_channel <", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThanOrEqualTo(String value) {
            addCriterion("pay_channel <=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLike(String value) {
            addCriterion("pay_channel like", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotLike(String value) {
            addCriterion("pay_channel not like", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelIn(List<String> values) {
            addCriterion("pay_channel in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotIn(List<String> values) {
            addCriterion("pay_channel not in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelBetween(String value1, String value2) {
            addCriterion("pay_channel between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotBetween(String value1, String value2) {
            addCriterion("pay_channel not between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdIsNull() {
            addCriterion("pay_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdIsNotNull() {
            addCriterion("pay_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdEqualTo(String value) {
            addCriterion("pay_channel_id =", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdNotEqualTo(String value) {
            addCriterion("pay_channel_id <>", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdGreaterThan(String value) {
            addCriterion("pay_channel_id >", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_channel_id >=", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdLessThan(String value) {
            addCriterion("pay_channel_id <", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdLessThanOrEqualTo(String value) {
            addCriterion("pay_channel_id <=", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdLike(String value) {
            addCriterion("pay_channel_id like", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdNotLike(String value) {
            addCriterion("pay_channel_id not like", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdIn(List<String> values) {
            addCriterion("pay_channel_id in", values, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdNotIn(List<String> values) {
            addCriterion("pay_channel_id not in", values, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdBetween(String value1, String value2) {
            addCriterion("pay_channel_id between", value1, value2, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdNotBetween(String value1, String value2) {
            addCriterion("pay_channel_id not between", value1, value2, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayInfoIsNull() {
            addCriterion("pay_info is null");
            return (Criteria) this;
        }

        public Criteria andPayInfoIsNotNull() {
            addCriterion("pay_info is not null");
            return (Criteria) this;
        }

        public Criteria andPayInfoEqualTo(String value) {
            addCriterion("pay_info =", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoNotEqualTo(String value) {
            addCriterion("pay_info <>", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoGreaterThan(String value) {
            addCriterion("pay_info >", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_info >=", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoLessThan(String value) {
            addCriterion("pay_info <", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoLessThanOrEqualTo(String value) {
            addCriterion("pay_info <=", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoLike(String value) {
            addCriterion("pay_info like", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoNotLike(String value) {
            addCriterion("pay_info not like", value, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoIn(List<String> values) {
            addCriterion("pay_info in", values, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoNotIn(List<String> values) {
            addCriterion("pay_info not in", values, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoBetween(String value1, String value2) {
            addCriterion("pay_info between", value1, value2, "payInfo");
            return (Criteria) this;
        }

        public Criteria andPayInfoNotBetween(String value1, String value2) {
            addCriterion("pay_info not between", value1, value2, "payInfo");
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

        public Criteria andAccBizNoIsNull() {
            addCriterion("acc_biz_no is null");
            return (Criteria) this;
        }

        public Criteria andAccBizNoIsNotNull() {
            addCriterion("acc_biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccBizNoEqualTo(String value) {
            addCriterion("acc_biz_no =", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoNotEqualTo(String value) {
            addCriterion("acc_biz_no <>", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoGreaterThan(String value) {
            addCriterion("acc_biz_no >", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("acc_biz_no >=", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoLessThan(String value) {
            addCriterion("acc_biz_no <", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoLessThanOrEqualTo(String value) {
            addCriterion("acc_biz_no <=", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoLike(String value) {
            addCriterion("acc_biz_no like", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoNotLike(String value) {
            addCriterion("acc_biz_no not like", value, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoIn(List<String> values) {
            addCriterion("acc_biz_no in", values, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoNotIn(List<String> values) {
            addCriterion("acc_biz_no not in", values, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoBetween(String value1, String value2) {
            addCriterion("acc_biz_no between", value1, value2, "accBizNo");
            return (Criteria) this;
        }

        public Criteria andAccBizNoNotBetween(String value1, String value2) {
            addCriterion("acc_biz_no not between", value1, value2, "accBizNo");
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

        public Criteria andPayerIdIsNull() {
            addCriterion("payer_id is null");
            return (Criteria) this;
        }

        public Criteria andPayerIdIsNotNull() {
            addCriterion("payer_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayerIdEqualTo(String value) {
            addCriterion("payer_id =", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotEqualTo(String value) {
            addCriterion("payer_id <>", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThan(String value) {
            addCriterion("payer_id >", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThanOrEqualTo(String value) {
            addCriterion("payer_id >=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThan(String value) {
            addCriterion("payer_id <", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThanOrEqualTo(String value) {
            addCriterion("payer_id <=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLike(String value) {
            addCriterion("payer_id like", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotLike(String value) {
            addCriterion("payer_id not like", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdIn(List<String> values) {
            addCriterion("payer_id in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotIn(List<String> values) {
            addCriterion("payer_id not in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdBetween(String value1, String value2) {
            addCriterion("payer_id between", value1, value2, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotBetween(String value1, String value2) {
            addCriterion("payer_id not between", value1, value2, "payerId");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusIsNull() {
            addCriterion("order_refund_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusIsNotNull() {
            addCriterion("order_refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusEqualTo(String value) {
            addCriterion("order_refund_status =", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusNotEqualTo(String value) {
            addCriterion("order_refund_status <>", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusGreaterThan(String value) {
            addCriterion("order_refund_status >", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_refund_status >=", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusLessThan(String value) {
            addCriterion("order_refund_status <", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusLessThanOrEqualTo(String value) {
            addCriterion("order_refund_status <=", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusLike(String value) {
            addCriterion("order_refund_status like", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusNotLike(String value) {
            addCriterion("order_refund_status not like", value, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusIn(List<String> values) {
            addCriterion("order_refund_status in", values, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusNotIn(List<String> values) {
            addCriterion("order_refund_status not in", values, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusBetween(String value1, String value2) {
            addCriterion("order_refund_status between", value1, value2, "orderRefundStatus");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStatusNotBetween(String value1, String value2) {
            addCriterion("order_refund_status not between", value1, value2, "orderRefundStatus");
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

        public Criteria andProfitInfoIsNull() {
            addCriterion("profit_info is null");
            return (Criteria) this;
        }

        public Criteria andProfitInfoIsNotNull() {
            addCriterion("profit_info is not null");
            return (Criteria) this;
        }

        public Criteria andProfitInfoEqualTo(String value) {
            addCriterion("profit_info =", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotEqualTo(String value) {
            addCriterion("profit_info <>", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoGreaterThan(String value) {
            addCriterion("profit_info >", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoGreaterThanOrEqualTo(String value) {
            addCriterion("profit_info >=", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoLessThan(String value) {
            addCriterion("profit_info <", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoLessThanOrEqualTo(String value) {
            addCriterion("profit_info <=", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoLike(String value) {
            addCriterion("profit_info like", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotLike(String value) {
            addCriterion("profit_info not like", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoIn(List<String> values) {
            addCriterion("profit_info in", values, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotIn(List<String> values) {
            addCriterion("profit_info not in", values, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoBetween(String value1, String value2) {
            addCriterion("profit_info between", value1, value2, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotBetween(String value1, String value2) {
            addCriterion("profit_info not between", value1, value2, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataIsNull() {
            addCriterion("externalMetaData is null");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataIsNotNull() {
            addCriterion("externalMetaData is not null");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataEqualTo(String value) {
            addCriterion("externalMetaData =", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataNotEqualTo(String value) {
            addCriterion("externalMetaData <>", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataGreaterThan(String value) {
            addCriterion("externalMetaData >", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataGreaterThanOrEqualTo(String value) {
            addCriterion("externalMetaData >=", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataLessThan(String value) {
            addCriterion("externalMetaData <", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataLessThanOrEqualTo(String value) {
            addCriterion("externalMetaData <=", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataLike(String value) {
            addCriterion("externalMetaData like", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataNotLike(String value) {
            addCriterion("externalMetaData not like", value, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataIn(List<String> values) {
            addCriterion("externalMetaData in", values, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataNotIn(List<String> values) {
            addCriterion("externalMetaData not in", values, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataBetween(String value1, String value2) {
            addCriterion("externalMetaData between", value1, value2, "externalmetadata");
            return (Criteria) this;
        }

        public Criteria andExternalmetadataNotBetween(String value1, String value2) {
            addCriterion("externalMetaData not between", value1, value2, "externalmetadata");
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