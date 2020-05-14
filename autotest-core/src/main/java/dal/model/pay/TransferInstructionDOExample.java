package dal.model.pay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferInstructionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransferInstructionDOExample() {
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

        public Criteria andTransferTypeIsNull() {
            addCriterion("transfer_type is null");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIsNotNull() {
            addCriterion("transfer_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransferTypeEqualTo(String value) {
            addCriterion("transfer_type =", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotEqualTo(String value) {
            addCriterion("transfer_type <>", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeGreaterThan(String value) {
            addCriterion("transfer_type >", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_type >=", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLessThan(String value) {
            addCriterion("transfer_type <", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLessThanOrEqualTo(String value) {
            addCriterion("transfer_type <=", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLike(String value) {
            addCriterion("transfer_type like", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotLike(String value) {
            addCriterion("transfer_type not like", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIn(List<String> values) {
            addCriterion("transfer_type in", values, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotIn(List<String> values) {
            addCriterion("transfer_type not in", values, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeBetween(String value1, String value2) {
            addCriterion("transfer_type between", value1, value2, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotBetween(String value1, String value2) {
            addCriterion("transfer_type not between", value1, value2, "transferType");
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

        public Criteria andPayeeFreezeAmountIsNull() {
            addCriterion("payee_freeze_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountIsNotNull() {
            addCriterion("payee_freeze_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountEqualTo(Long value) {
            addCriterion("payee_freeze_amount =", value, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountNotEqualTo(Long value) {
            addCriterion("payee_freeze_amount <>", value, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountGreaterThan(Long value) {
            addCriterion("payee_freeze_amount >", value, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("payee_freeze_amount >=", value, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountLessThan(Long value) {
            addCriterion("payee_freeze_amount <", value, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountLessThanOrEqualTo(Long value) {
            addCriterion("payee_freeze_amount <=", value, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountIn(List<Long> values) {
            addCriterion("payee_freeze_amount in", values, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountNotIn(List<Long> values) {
            addCriterion("payee_freeze_amount not in", values, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountBetween(Long value1, Long value2) {
            addCriterion("payee_freeze_amount between", value1, value2, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeAmountNotBetween(Long value1, Long value2) {
            addCriterion("payee_freeze_amount not between", value1, value2, "payeeFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeIsNull() {
            addCriterion("payee_freeze_code is null");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeIsNotNull() {
            addCriterion("payee_freeze_code is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeEqualTo(String value) {
            addCriterion("payee_freeze_code =", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeNotEqualTo(String value) {
            addCriterion("payee_freeze_code <>", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeGreaterThan(String value) {
            addCriterion("payee_freeze_code >", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("payee_freeze_code >=", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeLessThan(String value) {
            addCriterion("payee_freeze_code <", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeLessThanOrEqualTo(String value) {
            addCriterion("payee_freeze_code <=", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeLike(String value) {
            addCriterion("payee_freeze_code like", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeNotLike(String value) {
            addCriterion("payee_freeze_code not like", value, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeIn(List<String> values) {
            addCriterion("payee_freeze_code in", values, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeNotIn(List<String> values) {
            addCriterion("payee_freeze_code not in", values, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeBetween(String value1, String value2) {
            addCriterion("payee_freeze_code between", value1, value2, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeFreezeCodeNotBetween(String value1, String value2) {
            addCriterion("payee_freeze_code not between", value1, value2, "payeeFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceIsNull() {
            addCriterion("payee_balance is null");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceIsNotNull() {
            addCriterion("payee_balance is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceEqualTo(Long value) {
            addCriterion("payee_balance =", value, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceNotEqualTo(Long value) {
            addCriterion("payee_balance <>", value, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceGreaterThan(Long value) {
            addCriterion("payee_balance >", value, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("payee_balance >=", value, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceLessThan(Long value) {
            addCriterion("payee_balance <", value, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceLessThanOrEqualTo(Long value) {
            addCriterion("payee_balance <=", value, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceIn(List<Long> values) {
            addCriterion("payee_balance in", values, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceNotIn(List<Long> values) {
            addCriterion("payee_balance not in", values, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceBetween(Long value1, Long value2) {
            addCriterion("payee_balance between", value1, value2, "payeeBalance");
            return (Criteria) this;
        }

        public Criteria andPayeeBalanceNotBetween(Long value1, Long value2) {
            addCriterion("payee_balance not between", value1, value2, "payeeBalance");
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

        public Criteria andPayerUserTagIsNull() {
            addCriterion("payer_user_tag is null");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagIsNotNull() {
            addCriterion("payer_user_tag is not null");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagEqualTo(String value) {
            addCriterion("payer_user_tag =", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagNotEqualTo(String value) {
            addCriterion("payer_user_tag <>", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagGreaterThan(String value) {
            addCriterion("payer_user_tag >", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagGreaterThanOrEqualTo(String value) {
            addCriterion("payer_user_tag >=", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagLessThan(String value) {
            addCriterion("payer_user_tag <", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagLessThanOrEqualTo(String value) {
            addCriterion("payer_user_tag <=", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagLike(String value) {
            addCriterion("payer_user_tag like", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagNotLike(String value) {
            addCriterion("payer_user_tag not like", value, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagIn(List<String> values) {
            addCriterion("payer_user_tag in", values, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagNotIn(List<String> values) {
            addCriterion("payer_user_tag not in", values, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagBetween(String value1, String value2) {
            addCriterion("payer_user_tag between", value1, value2, "payerUserTag");
            return (Criteria) this;
        }

        public Criteria andPayerUserTagNotBetween(String value1, String value2) {
            addCriterion("payer_user_tag not between", value1, value2, "payerUserTag");
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

        public Criteria andPayerUnfreezeAmountIsNull() {
            addCriterion("payer_unfreeze_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountIsNotNull() {
            addCriterion("payer_unfreeze_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountEqualTo(Long value) {
            addCriterion("payer_unfreeze_amount =", value, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountNotEqualTo(Long value) {
            addCriterion("payer_unfreeze_amount <>", value, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountGreaterThan(Long value) {
            addCriterion("payer_unfreeze_amount >", value, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("payer_unfreeze_amount >=", value, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountLessThan(Long value) {
            addCriterion("payer_unfreeze_amount <", value, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountLessThanOrEqualTo(Long value) {
            addCriterion("payer_unfreeze_amount <=", value, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountIn(List<Long> values) {
            addCriterion("payer_unfreeze_amount in", values, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountNotIn(List<Long> values) {
            addCriterion("payer_unfreeze_amount not in", values, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountBetween(Long value1, Long value2) {
            addCriterion("payer_unfreeze_amount between", value1, value2, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerUnfreezeAmountNotBetween(Long value1, Long value2) {
            addCriterion("payer_unfreeze_amount not between", value1, value2, "payerUnfreezeAmount");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeIsNull() {
            addCriterion("payer_freeze_code is null");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeIsNotNull() {
            addCriterion("payer_freeze_code is not null");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeEqualTo(String value) {
            addCriterion("payer_freeze_code =", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeNotEqualTo(String value) {
            addCriterion("payer_freeze_code <>", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeGreaterThan(String value) {
            addCriterion("payer_freeze_code >", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("payer_freeze_code >=", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeLessThan(String value) {
            addCriterion("payer_freeze_code <", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeLessThanOrEqualTo(String value) {
            addCriterion("payer_freeze_code <=", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeLike(String value) {
            addCriterion("payer_freeze_code like", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeNotLike(String value) {
            addCriterion("payer_freeze_code not like", value, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeIn(List<String> values) {
            addCriterion("payer_freeze_code in", values, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeNotIn(List<String> values) {
            addCriterion("payer_freeze_code not in", values, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeBetween(String value1, String value2) {
            addCriterion("payer_freeze_code between", value1, value2, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerFreezeCodeNotBetween(String value1, String value2) {
            addCriterion("payer_freeze_code not between", value1, value2, "payerFreezeCode");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceIsNull() {
            addCriterion("payer_balance is null");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceIsNotNull() {
            addCriterion("payer_balance is not null");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceEqualTo(Long value) {
            addCriterion("payer_balance =", value, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceNotEqualTo(Long value) {
            addCriterion("payer_balance <>", value, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceGreaterThan(Long value) {
            addCriterion("payer_balance >", value, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("payer_balance >=", value, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceLessThan(Long value) {
            addCriterion("payer_balance <", value, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceLessThanOrEqualTo(Long value) {
            addCriterion("payer_balance <=", value, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceIn(List<Long> values) {
            addCriterion("payer_balance in", values, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceNotIn(List<Long> values) {
            addCriterion("payer_balance not in", values, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceBetween(Long value1, Long value2) {
            addCriterion("payer_balance between", value1, value2, "payerBalance");
            return (Criteria) this;
        }

        public Criteria andPayerBalanceNotBetween(Long value1, Long value2) {
            addCriterion("payer_balance not between", value1, value2, "payerBalance");
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

        public Criteria andDelayIsNull() {
            addCriterion("delay is null");
            return (Criteria) this;
        }

        public Criteria andDelayIsNotNull() {
            addCriterion("delay is not null");
            return (Criteria) this;
        }

        public Criteria andDelayEqualTo(Integer value) {
            addCriterion("delay =", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotEqualTo(Integer value) {
            addCriterion("delay <>", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayGreaterThan(Integer value) {
            addCriterion("delay >", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("delay >=", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayLessThan(Integer value) {
            addCriterion("delay <", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayLessThanOrEqualTo(Integer value) {
            addCriterion("delay <=", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayIn(List<Integer> values) {
            addCriterion("delay in", values, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotIn(List<Integer> values) {
            addCriterion("delay not in", values, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayBetween(Integer value1, Integer value2) {
            addCriterion("delay between", value1, value2, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("delay not between", value1, value2, "delay");
            return (Criteria) this;
        }

        public Criteria andBatchDetailIsNull() {
            addCriterion("batch_detail is null");
            return (Criteria) this;
        }

        public Criteria andBatchDetailIsNotNull() {
            addCriterion("batch_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBatchDetailEqualTo(String value) {
            addCriterion("batch_detail =", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailNotEqualTo(String value) {
            addCriterion("batch_detail <>", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailGreaterThan(String value) {
            addCriterion("batch_detail >", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailGreaterThanOrEqualTo(String value) {
            addCriterion("batch_detail >=", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailLessThan(String value) {
            addCriterion("batch_detail <", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailLessThanOrEqualTo(String value) {
            addCriterion("batch_detail <=", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailLike(String value) {
            addCriterion("batch_detail like", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailNotLike(String value) {
            addCriterion("batch_detail not like", value, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailIn(List<String> values) {
            addCriterion("batch_detail in", values, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailNotIn(List<String> values) {
            addCriterion("batch_detail not in", values, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailBetween(String value1, String value2) {
            addCriterion("batch_detail between", value1, value2, "batchDetail");
            return (Criteria) this;
        }

        public Criteria andBatchDetailNotBetween(String value1, String value2) {
            addCriterion("batch_detail not between", value1, value2, "batchDetail");
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