package dal.model.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantChannelTransLogDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantChannelTransLogDOExample() {
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

        public Criteria andChannelTransIdIsNull() {
            addCriterion("channel_trans_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdIsNotNull() {
            addCriterion("channel_trans_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdEqualTo(String value) {
            addCriterion("channel_trans_id =", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdNotEqualTo(String value) {
            addCriterion("channel_trans_id <>", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdGreaterThan(String value) {
            addCriterion("channel_trans_id >", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_trans_id >=", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdLessThan(String value) {
            addCriterion("channel_trans_id <", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdLessThanOrEqualTo(String value) {
            addCriterion("channel_trans_id <=", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdLike(String value) {
            addCriterion("channel_trans_id like", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdNotLike(String value) {
            addCriterion("channel_trans_id not like", value, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdIn(List<String> values) {
            addCriterion("channel_trans_id in", values, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdNotIn(List<String> values) {
            addCriterion("channel_trans_id not in", values, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdBetween(String value1, String value2) {
            addCriterion("channel_trans_id between", value1, value2, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelTransIdNotBetween(String value1, String value2) {
            addCriterion("channel_trans_id not between", value1, value2, "channelTransId");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
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

        public Criteria andSettlementAccountIsNull() {
            addCriterion("settlement_account is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountIsNotNull() {
            addCriterion("settlement_account is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountEqualTo(String value) {
            addCriterion("settlement_account =", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotEqualTo(String value) {
            addCriterion("settlement_account <>", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountGreaterThan(String value) {
            addCriterion("settlement_account >", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account >=", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountLessThan(String value) {
            addCriterion("settlement_account <", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountLessThanOrEqualTo(String value) {
            addCriterion("settlement_account <=", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountLike(String value) {
            addCriterion("settlement_account like", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotLike(String value) {
            addCriterion("settlement_account not like", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountIn(List<String> values) {
            addCriterion("settlement_account in", values, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotIn(List<String> values) {
            addCriterion("settlement_account not in", values, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBetween(String value1, String value2) {
            addCriterion("settlement_account between", value1, value2, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotBetween(String value1, String value2) {
            addCriterion("settlement_account not between", value1, value2, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeIsNull() {
            addCriterion("handling_fee is null");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeIsNotNull() {
            addCriterion("handling_fee is not null");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeEqualTo(Long value) {
            addCriterion("handling_fee =", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeNotEqualTo(Long value) {
            addCriterion("handling_fee <>", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeGreaterThan(Long value) {
            addCriterion("handling_fee >", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("handling_fee >=", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeLessThan(Long value) {
            addCriterion("handling_fee <", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeLessThanOrEqualTo(Long value) {
            addCriterion("handling_fee <=", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeIn(List<Long> values) {
            addCriterion("handling_fee in", values, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeNotIn(List<Long> values) {
            addCriterion("handling_fee not in", values, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeBetween(Long value1, Long value2) {
            addCriterion("handling_fee between", value1, value2, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeNotBetween(Long value1, Long value2) {
            addCriterion("handling_fee not between", value1, value2, "handlingFee");
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

        public Criteria andTradeStatusIsNull() {
            addCriterion("trade_status is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("trade_status =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("trade_status <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("trade_status >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trade_status >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("trade_status <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("trade_status <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("trade_status like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("trade_status not like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("trade_status in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("trade_status not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("trade_status between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("trade_status not between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionIsNull() {
            addCriterion("trans_description is null");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionIsNotNull() {
            addCriterion("trans_description is not null");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionEqualTo(String value) {
            addCriterion("trans_description =", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionNotEqualTo(String value) {
            addCriterion("trans_description <>", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionGreaterThan(String value) {
            addCriterion("trans_description >", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("trans_description >=", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionLessThan(String value) {
            addCriterion("trans_description <", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionLessThanOrEqualTo(String value) {
            addCriterion("trans_description <=", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionLike(String value) {
            addCriterion("trans_description like", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionNotLike(String value) {
            addCriterion("trans_description not like", value, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionIn(List<String> values) {
            addCriterion("trans_description in", values, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionNotIn(List<String> values) {
            addCriterion("trans_description not in", values, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionBetween(String value1, String value2) {
            addCriterion("trans_description between", value1, value2, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransDescriptionNotBetween(String value1, String value2) {
            addCriterion("trans_description not between", value1, value2, "transDescription");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeIsNull() {
            addCriterion("trans_amount_type is null");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeIsNotNull() {
            addCriterion("trans_amount_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeEqualTo(String value) {
            addCriterion("trans_amount_type =", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeNotEqualTo(String value) {
            addCriterion("trans_amount_type <>", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeGreaterThan(String value) {
            addCriterion("trans_amount_type >", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trans_amount_type >=", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeLessThan(String value) {
            addCriterion("trans_amount_type <", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeLessThanOrEqualTo(String value) {
            addCriterion("trans_amount_type <=", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeLike(String value) {
            addCriterion("trans_amount_type like", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeNotLike(String value) {
            addCriterion("trans_amount_type not like", value, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeIn(List<String> values) {
            addCriterion("trans_amount_type in", values, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeNotIn(List<String> values) {
            addCriterion("trans_amount_type not in", values, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeBetween(String value1, String value2) {
            addCriterion("trans_amount_type between", value1, value2, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andTransAmountTypeNotBetween(String value1, String value2) {
            addCriterion("trans_amount_type not between", value1, value2, "transAmountType");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeIsNull() {
            addCriterion("channel_processing_time is null");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeIsNotNull() {
            addCriterion("channel_processing_time is not null");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeEqualTo(String value) {
            addCriterion("channel_processing_time =", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeNotEqualTo(String value) {
            addCriterion("channel_processing_time <>", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeGreaterThan(String value) {
            addCriterion("channel_processing_time >", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_processing_time >=", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeLessThan(String value) {
            addCriterion("channel_processing_time <", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeLessThanOrEqualTo(String value) {
            addCriterion("channel_processing_time <=", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeLike(String value) {
            addCriterion("channel_processing_time like", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeNotLike(String value) {
            addCriterion("channel_processing_time not like", value, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeIn(List<String> values) {
            addCriterion("channel_processing_time in", values, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeNotIn(List<String> values) {
            addCriterion("channel_processing_time not in", values, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeBetween(String value1, String value2) {
            addCriterion("channel_processing_time between", value1, value2, "channelProcessingTime");
            return (Criteria) this;
        }

        public Criteria andChannelProcessingTimeNotBetween(String value1, String value2) {
            addCriterion("channel_processing_time not between", value1, value2, "channelProcessingTime");
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