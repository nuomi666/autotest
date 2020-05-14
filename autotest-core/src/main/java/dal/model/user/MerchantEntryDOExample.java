package dal.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantEntryDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantEntryDOExample() {
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

        public Criteria andAccountNoIsNull() {
            addCriterion("account_no is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("account_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("account_no =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("account_no <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("account_no >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("account_no >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("account_no <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("account_no <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("account_no like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("account_no not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("account_no in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("account_no not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("account_no between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("account_no not between", value1, value2, "accountNo");
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

        public Criteria andChannelPlatMerchantIdIsNull() {
            addCriterion("channel_plat_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdIsNotNull() {
            addCriterion("channel_plat_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdEqualTo(String value) {
            addCriterion("channel_plat_merchant_id =", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdNotEqualTo(String value) {
            addCriterion("channel_plat_merchant_id <>", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdGreaterThan(String value) {
            addCriterion("channel_plat_merchant_id >", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_plat_merchant_id >=", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdLessThan(String value) {
            addCriterion("channel_plat_merchant_id <", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("channel_plat_merchant_id <=", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdLike(String value) {
            addCriterion("channel_plat_merchant_id like", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdNotLike(String value) {
            addCriterion("channel_plat_merchant_id not like", value, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdIn(List<String> values) {
            addCriterion("channel_plat_merchant_id in", values, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdNotIn(List<String> values) {
            addCriterion("channel_plat_merchant_id not in", values, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdBetween(String value1, String value2) {
            addCriterion("channel_plat_merchant_id between", value1, value2, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andChannelPlatMerchantIdNotBetween(String value1, String value2) {
            addCriterion("channel_plat_merchant_id not between", value1, value2, "channelPlatMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyIsNull() {
            addCriterion("sub_merchant_property is null");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyIsNotNull() {
            addCriterion("sub_merchant_property is not null");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyEqualTo(String value) {
            addCriterion("sub_merchant_property =", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyNotEqualTo(String value) {
            addCriterion("sub_merchant_property <>", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyGreaterThan(String value) {
            addCriterion("sub_merchant_property >", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("sub_merchant_property >=", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyLessThan(String value) {
            addCriterion("sub_merchant_property <", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyLessThanOrEqualTo(String value) {
            addCriterion("sub_merchant_property <=", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyLike(String value) {
            addCriterion("sub_merchant_property like", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyNotLike(String value) {
            addCriterion("sub_merchant_property not like", value, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyIn(List<String> values) {
            addCriterion("sub_merchant_property in", values, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyNotIn(List<String> values) {
            addCriterion("sub_merchant_property not in", values, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyBetween(String value1, String value2) {
            addCriterion("sub_merchant_property between", value1, value2, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantPropertyNotBetween(String value1, String value2) {
            addCriterion("sub_merchant_property not between", value1, value2, "subMerchantProperty");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdIsNull() {
            addCriterion("sub_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdIsNotNull() {
            addCriterion("sub_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdEqualTo(String value) {
            addCriterion("sub_merchant_id =", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdNotEqualTo(String value) {
            addCriterion("sub_merchant_id <>", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdGreaterThan(String value) {
            addCriterion("sub_merchant_id >", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_merchant_id >=", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdLessThan(String value) {
            addCriterion("sub_merchant_id <", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("sub_merchant_id <=", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdLike(String value) {
            addCriterion("sub_merchant_id like", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdNotLike(String value) {
            addCriterion("sub_merchant_id not like", value, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdIn(List<String> values) {
            addCriterion("sub_merchant_id in", values, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdNotIn(List<String> values) {
            addCriterion("sub_merchant_id not in", values, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdBetween(String value1, String value2) {
            addCriterion("sub_merchant_id between", value1, value2, "subMerchantId");
            return (Criteria) this;
        }

        public Criteria andSubMerchantIdNotBetween(String value1, String value2) {
            addCriterion("sub_merchant_id not between", value1, value2, "subMerchantId");
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

        public Criteria andSignedStatusIsNull() {
            addCriterion("signed_status is null");
            return (Criteria) this;
        }

        public Criteria andSignedStatusIsNotNull() {
            addCriterion("signed_status is not null");
            return (Criteria) this;
        }

        public Criteria andSignedStatusEqualTo(String value) {
            addCriterion("signed_status =", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusNotEqualTo(String value) {
            addCriterion("signed_status <>", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusGreaterThan(String value) {
            addCriterion("signed_status >", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusGreaterThanOrEqualTo(String value) {
            addCriterion("signed_status >=", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusLessThan(String value) {
            addCriterion("signed_status <", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusLessThanOrEqualTo(String value) {
            addCriterion("signed_status <=", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusLike(String value) {
            addCriterion("signed_status like", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusNotLike(String value) {
            addCriterion("signed_status not like", value, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusIn(List<String> values) {
            addCriterion("signed_status in", values, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusNotIn(List<String> values) {
            addCriterion("signed_status not in", values, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusBetween(String value1, String value2) {
            addCriterion("signed_status between", value1, value2, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andSignedStatusNotBetween(String value1, String value2) {
            addCriterion("signed_status not between", value1, value2, "signedStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusIsNull() {
            addCriterion("certify_status is null");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusIsNotNull() {
            addCriterion("certify_status is not null");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusEqualTo(String value) {
            addCriterion("certify_status =", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusNotEqualTo(String value) {
            addCriterion("certify_status <>", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusGreaterThan(String value) {
            addCriterion("certify_status >", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("certify_status >=", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusLessThan(String value) {
            addCriterion("certify_status <", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusLessThanOrEqualTo(String value) {
            addCriterion("certify_status <=", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusLike(String value) {
            addCriterion("certify_status like", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusNotLike(String value) {
            addCriterion("certify_status not like", value, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusIn(List<String> values) {
            addCriterion("certify_status in", values, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusNotIn(List<String> values) {
            addCriterion("certify_status not in", values, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusBetween(String value1, String value2) {
            addCriterion("certify_status between", value1, value2, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andCertifyStatusNotBetween(String value1, String value2) {
            addCriterion("certify_status not between", value1, value2, "certifyStatus");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountIsNull() {
            addCriterion("channel_sub_merchant_account is null");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountIsNotNull() {
            addCriterion("channel_sub_merchant_account is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountEqualTo(String value) {
            addCriterion("channel_sub_merchant_account =", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountNotEqualTo(String value) {
            addCriterion("channel_sub_merchant_account <>", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountGreaterThan(String value) {
            addCriterion("channel_sub_merchant_account >", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountGreaterThanOrEqualTo(String value) {
            addCriterion("channel_sub_merchant_account >=", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountLessThan(String value) {
            addCriterion("channel_sub_merchant_account <", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountLessThanOrEqualTo(String value) {
            addCriterion("channel_sub_merchant_account <=", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountLike(String value) {
            addCriterion("channel_sub_merchant_account like", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountNotLike(String value) {
            addCriterion("channel_sub_merchant_account not like", value, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountIn(List<String> values) {
            addCriterion("channel_sub_merchant_account in", values, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountNotIn(List<String> values) {
            addCriterion("channel_sub_merchant_account not in", values, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountBetween(String value1, String value2) {
            addCriterion("channel_sub_merchant_account between", value1, value2, "channelSubMerchantAccount");
            return (Criteria) this;
        }

        public Criteria andChannelSubMerchantAccountNotBetween(String value1, String value2) {
            addCriterion("channel_sub_merchant_account not between", value1, value2, "channelSubMerchantAccount");
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