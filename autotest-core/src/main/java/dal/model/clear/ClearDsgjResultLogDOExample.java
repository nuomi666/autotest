package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClearDsgjResultLogDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClearDsgjResultLogDOExample() {
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

        public Criteria andPlatPartnerRealNameIsNull() {
            addCriterion("plat_partner_real_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameIsNotNull() {
            addCriterion("plat_partner_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameEqualTo(String value) {
            addCriterion("plat_partner_real_name =", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotEqualTo(String value) {
            addCriterion("plat_partner_real_name <>", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameGreaterThan(String value) {
            addCriterion("plat_partner_real_name >", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("plat_partner_real_name >=", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameLessThan(String value) {
            addCriterion("plat_partner_real_name <", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameLessThanOrEqualTo(String value) {
            addCriterion("plat_partner_real_name <=", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameLike(String value) {
            addCriterion("plat_partner_real_name like", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotLike(String value) {
            addCriterion("plat_partner_real_name not like", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameIn(List<String> values) {
            addCriterion("plat_partner_real_name in", values, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotIn(List<String> values) {
            addCriterion("plat_partner_real_name not in", values, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameBetween(String value1, String value2) {
            addCriterion("plat_partner_real_name between", value1, value2, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotBetween(String value1, String value2) {
            addCriterion("plat_partner_real_name not between", value1, value2, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountIsNull() {
            addCriterion("partner_settlement_account is null");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountIsNotNull() {
            addCriterion("partner_settlement_account is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountEqualTo(String value) {
            addCriterion("partner_settlement_account =", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountNotEqualTo(String value) {
            addCriterion("partner_settlement_account <>", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountGreaterThan(String value) {
            addCriterion("partner_settlement_account >", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountGreaterThanOrEqualTo(String value) {
            addCriterion("partner_settlement_account >=", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountLessThan(String value) {
            addCriterion("partner_settlement_account <", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountLessThanOrEqualTo(String value) {
            addCriterion("partner_settlement_account <=", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountLike(String value) {
            addCriterion("partner_settlement_account like", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountNotLike(String value) {
            addCriterion("partner_settlement_account not like", value, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountIn(List<String> values) {
            addCriterion("partner_settlement_account in", values, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountNotIn(List<String> values) {
            addCriterion("partner_settlement_account not in", values, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountBetween(String value1, String value2) {
            addCriterion("partner_settlement_account between", value1, value2, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerSettlementAccountNotBetween(String value1, String value2) {
            addCriterion("partner_settlement_account not between", value1, value2, "partnerSettlementAccount");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIsNull() {
            addCriterion("amount_status is null");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIsNotNull() {
            addCriterion("amount_status is not null");
            return (Criteria) this;
        }

        public Criteria andAmountStatusEqualTo(String value) {
            addCriterion("amount_status =", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotEqualTo(String value) {
            addCriterion("amount_status <>", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusGreaterThan(String value) {
            addCriterion("amount_status >", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("amount_status >=", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLessThan(String value) {
            addCriterion("amount_status <", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLessThanOrEqualTo(String value) {
            addCriterion("amount_status <=", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLike(String value) {
            addCriterion("amount_status like", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotLike(String value) {
            addCriterion("amount_status not like", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIn(List<String> values) {
            addCriterion("amount_status in", values, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotIn(List<String> values) {
            addCriterion("amount_status not in", values, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusBetween(String value1, String value2) {
            addCriterion("amount_status between", value1, value2, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotBetween(String value1, String value2) {
            addCriterion("amount_status not between", value1, value2, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusIsNull() {
            addCriterion("trans_clear_amount_status is null");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusIsNotNull() {
            addCriterion("trans_clear_amount_status is not null");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusEqualTo(String value) {
            addCriterion("trans_clear_amount_status =", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusNotEqualTo(String value) {
            addCriterion("trans_clear_amount_status <>", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusGreaterThan(String value) {
            addCriterion("trans_clear_amount_status >", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trans_clear_amount_status >=", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusLessThan(String value) {
            addCriterion("trans_clear_amount_status <", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusLessThanOrEqualTo(String value) {
            addCriterion("trans_clear_amount_status <=", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusLike(String value) {
            addCriterion("trans_clear_amount_status like", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusNotLike(String value) {
            addCriterion("trans_clear_amount_status not like", value, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusIn(List<String> values) {
            addCriterion("trans_clear_amount_status in", values, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusNotIn(List<String> values) {
            addCriterion("trans_clear_amount_status not in", values, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusBetween(String value1, String value2) {
            addCriterion("trans_clear_amount_status between", value1, value2, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andTransClearAmountStatusNotBetween(String value1, String value2) {
            addCriterion("trans_clear_amount_status not between", value1, value2, "transClearAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusIsNull() {
            addCriterion("down_fee_amount_status is null");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusIsNotNull() {
            addCriterion("down_fee_amount_status is not null");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusEqualTo(String value) {
            addCriterion("down_fee_amount_status =", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusNotEqualTo(String value) {
            addCriterion("down_fee_amount_status <>", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusGreaterThan(String value) {
            addCriterion("down_fee_amount_status >", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("down_fee_amount_status >=", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusLessThan(String value) {
            addCriterion("down_fee_amount_status <", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusLessThanOrEqualTo(String value) {
            addCriterion("down_fee_amount_status <=", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusLike(String value) {
            addCriterion("down_fee_amount_status like", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusNotLike(String value) {
            addCriterion("down_fee_amount_status not like", value, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusIn(List<String> values) {
            addCriterion("down_fee_amount_status in", values, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusNotIn(List<String> values) {
            addCriterion("down_fee_amount_status not in", values, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusBetween(String value1, String value2) {
            addCriterion("down_fee_amount_status between", value1, value2, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andDownFeeAmountStatusNotBetween(String value1, String value2) {
            addCriterion("down_fee_amount_status not between", value1, value2, "downFeeAmountStatus");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameIsNull() {
            addCriterion("clear_result_file_name is null");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameIsNotNull() {
            addCriterion("clear_result_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameEqualTo(String value) {
            addCriterion("clear_result_file_name =", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotEqualTo(String value) {
            addCriterion("clear_result_file_name <>", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameGreaterThan(String value) {
            addCriterion("clear_result_file_name >", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("clear_result_file_name >=", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameLessThan(String value) {
            addCriterion("clear_result_file_name <", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameLessThanOrEqualTo(String value) {
            addCriterion("clear_result_file_name <=", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameLike(String value) {
            addCriterion("clear_result_file_name like", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotLike(String value) {
            addCriterion("clear_result_file_name not like", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameIn(List<String> values) {
            addCriterion("clear_result_file_name in", values, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotIn(List<String> values) {
            addCriterion("clear_result_file_name not in", values, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameBetween(String value1, String value2) {
            addCriterion("clear_result_file_name between", value1, value2, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotBetween(String value1, String value2) {
            addCriterion("clear_result_file_name not between", value1, value2, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdIsNull() {
            addCriterion("channel_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdIsNotNull() {
            addCriterion("channel_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdEqualTo(String value) {
            addCriterion("channel_merchant_id =", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdNotEqualTo(String value) {
            addCriterion("channel_merchant_id <>", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdGreaterThan(String value) {
            addCriterion("channel_merchant_id >", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_merchant_id >=", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdLessThan(String value) {
            addCriterion("channel_merchant_id <", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("channel_merchant_id <=", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdLike(String value) {
            addCriterion("channel_merchant_id like", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdNotLike(String value) {
            addCriterion("channel_merchant_id not like", value, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdIn(List<String> values) {
            addCriterion("channel_merchant_id in", values, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdNotIn(List<String> values) {
            addCriterion("channel_merchant_id not in", values, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdBetween(String value1, String value2) {
            addCriterion("channel_merchant_id between", value1, value2, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchantIdNotBetween(String value1, String value2) {
            addCriterion("channel_merchant_id not between", value1, value2, "channelMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdIsNull() {
            addCriterion("channel_sub_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdIsNotNull() {
            addCriterion("channel_sub_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdEqualTo(String value) {
            addCriterion("channel_sub_merchant_id =", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdNotEqualTo(String value) {
            addCriterion("channel_sub_merchant_id <>", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdGreaterThan(String value) {
            addCriterion("channel_sub_merchant_id >", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_sub_merchant_id >=", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdLessThan(String value) {
            addCriterion("channel_sub_merchant_id <", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("channel_sub_merchant_id <=", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdLike(String value) {
            addCriterion("channel_sub_merchant_id like", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdNotLike(String value) {
            addCriterion("channel_sub_merchant_id not like", value, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdIn(List<String> values) {
            addCriterion("channel_sub_merchant_id in", values, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdNotIn(List<String> values) {
            addCriterion("channel_sub_merchant_id not in", values, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdBetween(String value1, String value2) {
            addCriterion("channel_sub_merchant_id between", value1, value2, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantIdNotBetween(String value1, String value2) {
            addCriterion("channel_sub_merchant_id not between", value1, value2, "channelSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameIsNull() {
            addCriterion("channel_sub_merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameIsNotNull() {
            addCriterion("channel_sub_merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameEqualTo(String value) {
            addCriterion("channel_sub_merchant_name =", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameNotEqualTo(String value) {
            addCriterion("channel_sub_merchant_name <>", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameGreaterThan(String value) {
            addCriterion("channel_sub_merchant_name >", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_sub_merchant_name >=", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameLessThan(String value) {
            addCriterion("channel_sub_merchant_name <", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("channel_sub_merchant_name <=", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameLike(String value) {
            addCriterion("channel_sub_merchant_name like", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameNotLike(String value) {
            addCriterion("channel_sub_merchant_name not like", value, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameIn(List<String> values) {
            addCriterion("channel_sub_merchant_name in", values, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameNotIn(List<String> values) {
            addCriterion("channel_sub_merchant_name not in", values, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameBetween(String value1, String value2) {
            addCriterion("channel_sub_merchant_name between", value1, value2, "channelSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantNameNotBetween(String value1, String value2) {
            addCriterion("channel_sub_merchant_name not between", value1, value2, "channelSubMerchantName");
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

        public Criteria andClearTypeIsNull() {
            addCriterion("clear_type is null");
            return (Criteria) this;
        }

        public Criteria andClearTypeIsNotNull() {
            addCriterion("clear_type is not null");
            return (Criteria) this;
        }

        public Criteria andClearTypeEqualTo(String value) {
            addCriterion("clear_type =", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeNotEqualTo(String value) {
            addCriterion("clear_type <>", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeGreaterThan(String value) {
            addCriterion("clear_type >", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeGreaterThanOrEqualTo(String value) {
            addCriterion("clear_type >=", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeLessThan(String value) {
            addCriterion("clear_type <", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeLessThanOrEqualTo(String value) {
            addCriterion("clear_type <=", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeLike(String value) {
            addCriterion("clear_type like", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeNotLike(String value) {
            addCriterion("clear_type not like", value, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeIn(List<String> values) {
            addCriterion("clear_type in", values, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeNotIn(List<String> values) {
            addCriterion("clear_type not in", values, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeBetween(String value1, String value2) {
            addCriterion("clear_type between", value1, value2, "clearType");
            return (Criteria) this;
        }

        public Criteria andClearTypeNotBetween(String value1, String value2) {
            addCriterion("clear_type not between", value1, value2, "clearType");
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

        public Criteria andTradeCountIsNull() {
            addCriterion("trade_count is null");
            return (Criteria) this;
        }

        public Criteria andTradeCountIsNotNull() {
            addCriterion("trade_count is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCountEqualTo(Integer value) {
            addCriterion("trade_count =", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotEqualTo(Integer value) {
            addCriterion("trade_count <>", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThan(Integer value) {
            addCriterion("trade_count >", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_count >=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThan(Integer value) {
            addCriterion("trade_count <", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThanOrEqualTo(Integer value) {
            addCriterion("trade_count <=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountIn(List<Integer> values) {
            addCriterion("trade_count in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotIn(List<Integer> values) {
            addCriterion("trade_count not in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountBetween(Integer value1, Integer value2) {
            addCriterion("trade_count between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_count not between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdIsNull() {
            addCriterion("settlement_sub_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdIsNotNull() {
            addCriterion("settlement_sub_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdEqualTo(String value) {
            addCriterion("settlement_sub_merchant_id =", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdNotEqualTo(String value) {
            addCriterion("settlement_sub_merchant_id <>", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdGreaterThan(String value) {
            addCriterion("settlement_sub_merchant_id >", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_sub_merchant_id >=", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdLessThan(String value) {
            addCriterion("settlement_sub_merchant_id <", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("settlement_sub_merchant_id <=", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdLike(String value) {
            addCriterion("settlement_sub_merchant_id like", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdNotLike(String value) {
            addCriterion("settlement_sub_merchant_id not like", value, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdIn(List<String> values) {
            addCriterion("settlement_sub_merchant_id in", values, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdNotIn(List<String> values) {
            addCriterion("settlement_sub_merchant_id not in", values, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdBetween(String value1, String value2) {
            addCriterion("settlement_sub_merchant_id between", value1, value2, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantIdNotBetween(String value1, String value2) {
            addCriterion("settlement_sub_merchant_id not between", value1, value2, "settlementSubMerchantId");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameIsNull() {
            addCriterion("settlement_sub_merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameIsNotNull() {
            addCriterion("settlement_sub_merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameEqualTo(String value) {
            addCriterion("settlement_sub_merchant_name =", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameNotEqualTo(String value) {
            addCriterion("settlement_sub_merchant_name <>", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameGreaterThan(String value) {
            addCriterion("settlement_sub_merchant_name >", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_sub_merchant_name >=", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameLessThan(String value) {
            addCriterion("settlement_sub_merchant_name <", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("settlement_sub_merchant_name <=", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameLike(String value) {
            addCriterion("settlement_sub_merchant_name like", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameNotLike(String value) {
            addCriterion("settlement_sub_merchant_name not like", value, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameIn(List<String> values) {
            addCriterion("settlement_sub_merchant_name in", values, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameNotIn(List<String> values) {
            addCriterion("settlement_sub_merchant_name not in", values, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameBetween(String value1, String value2) {
            addCriterion("settlement_sub_merchant_name between", value1, value2, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andSettlementSubMerchantNameNotBetween(String value1, String value2) {
            addCriterion("settlement_sub_merchant_name not between", value1, value2, "settlementSubMerchantName");
            return (Criteria) this;
        }

        public Criteria andClearAmountIsNull() {
            addCriterion("clear_amount is null");
            return (Criteria) this;
        }

        public Criteria andClearAmountIsNotNull() {
            addCriterion("clear_amount is not null");
            return (Criteria) this;
        }

        public Criteria andClearAmountEqualTo(Long value) {
            addCriterion("clear_amount =", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountNotEqualTo(Long value) {
            addCriterion("clear_amount <>", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountGreaterThan(Long value) {
            addCriterion("clear_amount >", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("clear_amount >=", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountLessThan(Long value) {
            addCriterion("clear_amount <", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountLessThanOrEqualTo(Long value) {
            addCriterion("clear_amount <=", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountIn(List<Long> values) {
            addCriterion("clear_amount in", values, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountNotIn(List<Long> values) {
            addCriterion("clear_amount not in", values, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountBetween(Long value1, Long value2) {
            addCriterion("clear_amount between", value1, value2, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountNotBetween(Long value1, Long value2) {
            addCriterion("clear_amount not between", value1, value2, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountIsNull() {
            addCriterion("plat_coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountIsNotNull() {
            addCriterion("plat_coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountEqualTo(Long value) {
            addCriterion("plat_coupon_amount =", value, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountNotEqualTo(Long value) {
            addCriterion("plat_coupon_amount <>", value, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountGreaterThan(Long value) {
            addCriterion("plat_coupon_amount >", value, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("plat_coupon_amount >=", value, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountLessThan(Long value) {
            addCriterion("plat_coupon_amount <", value, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountLessThanOrEqualTo(Long value) {
            addCriterion("plat_coupon_amount <=", value, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountIn(List<Long> values) {
            addCriterion("plat_coupon_amount in", values, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountNotIn(List<Long> values) {
            addCriterion("plat_coupon_amount not in", values, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountBetween(Long value1, Long value2) {
            addCriterion("plat_coupon_amount between", value1, value2, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andPlatCouponAmountNotBetween(Long value1, Long value2) {
            addCriterion("plat_coupon_amount not between", value1, value2, "platCouponAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountIsNull() {
            addCriterion("advance_amount is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountIsNotNull() {
            addCriterion("advance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountEqualTo(Long value) {
            addCriterion("advance_amount =", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountNotEqualTo(Long value) {
            addCriterion("advance_amount <>", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountGreaterThan(Long value) {
            addCriterion("advance_amount >", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("advance_amount >=", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountLessThan(Long value) {
            addCriterion("advance_amount <", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountLessThanOrEqualTo(Long value) {
            addCriterion("advance_amount <=", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountIn(List<Long> values) {
            addCriterion("advance_amount in", values, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountNotIn(List<Long> values) {
            addCriterion("advance_amount not in", values, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountBetween(Long value1, Long value2) {
            addCriterion("advance_amount between", value1, value2, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountNotBetween(Long value1, Long value2) {
            addCriterion("advance_amount not between", value1, value2, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountIsNull() {
            addCriterion("plat_share_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountIsNotNull() {
            addCriterion("plat_share_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountEqualTo(Long value) {
            addCriterion("plat_share_amount =", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountNotEqualTo(Long value) {
            addCriterion("plat_share_amount <>", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountGreaterThan(Long value) {
            addCriterion("plat_share_amount >", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("plat_share_amount >=", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountLessThan(Long value) {
            addCriterion("plat_share_amount <", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountLessThanOrEqualTo(Long value) {
            addCriterion("plat_share_amount <=", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountIn(List<Long> values) {
            addCriterion("plat_share_amount in", values, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountNotIn(List<Long> values) {
            addCriterion("plat_share_amount not in", values, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountBetween(Long value1, Long value2) {
            addCriterion("plat_share_amount between", value1, value2, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountNotBetween(Long value1, Long value2) {
            addCriterion("plat_share_amount not between", value1, value2, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNull() {
            addCriterion("fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNotNull() {
            addCriterion("fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountEqualTo(Long value) {
            addCriterion("fee_amount =", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotEqualTo(Long value) {
            addCriterion("fee_amount <>", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThan(Long value) {
            addCriterion("fee_amount >", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("fee_amount >=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThan(Long value) {
            addCriterion("fee_amount <", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThanOrEqualTo(Long value) {
            addCriterion("fee_amount <=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIn(List<Long> values) {
            addCriterion("fee_amount in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotIn(List<Long> values) {
            addCriterion("fee_amount not in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountBetween(Long value1, Long value2) {
            addCriterion("fee_amount between", value1, value2, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotBetween(Long value1, Long value2) {
            addCriterion("fee_amount not between", value1, value2, "feeAmount");
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

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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