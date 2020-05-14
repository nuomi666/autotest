package dal.model.cashier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelMappingDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChannelMappingDOExample() {
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

        public Criteria andChannelMappingIdIsNull() {
            addCriterion("channel_mapping_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdIsNotNull() {
            addCriterion("channel_mapping_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdEqualTo(String value) {
            addCriterion("channel_mapping_id =", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdNotEqualTo(String value) {
            addCriterion("channel_mapping_id <>", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdGreaterThan(String value) {
            addCriterion("channel_mapping_id >", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_mapping_id >=", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdLessThan(String value) {
            addCriterion("channel_mapping_id <", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdLessThanOrEqualTo(String value) {
            addCriterion("channel_mapping_id <=", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdLike(String value) {
            addCriterion("channel_mapping_id like", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdNotLike(String value) {
            addCriterion("channel_mapping_id not like", value, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdIn(List<String> values) {
            addCriterion("channel_mapping_id in", values, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdNotIn(List<String> values) {
            addCriterion("channel_mapping_id not in", values, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdBetween(String value1, String value2) {
            addCriterion("channel_mapping_id between", value1, value2, "channelMappingId");
            return (Criteria) this;
        }

        public Criteria andChannelMappingIdNotBetween(String value1, String value2) {
            addCriterion("channel_mapping_id not between", value1, value2, "channelMappingId");
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

        public Criteria andPartnerNameIsNull() {
            addCriterion("partner_name is null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIsNotNull() {
            addCriterion("partner_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameEqualTo(String value) {
            addCriterion("partner_name =", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotEqualTo(String value) {
            addCriterion("partner_name <>", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThan(String value) {
            addCriterion("partner_name >", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("partner_name >=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThan(String value) {
            addCriterion("partner_name <", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThanOrEqualTo(String value) {
            addCriterion("partner_name <=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLike(String value) {
            addCriterion("partner_name like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotLike(String value) {
            addCriterion("partner_name not like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIn(List<String> values) {
            addCriterion("partner_name in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotIn(List<String> values) {
            addCriterion("partner_name not in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameBetween(String value1, String value2) {
            addCriterion("partner_name between", value1, value2, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotBetween(String value1, String value2) {
            addCriterion("partner_name not between", value1, value2, "partnerName");
            return (Criteria) this;
        }

        public Criteria andWechatAppidIsNull() {
            addCriterion("wechat_appid is null");
            return (Criteria) this;
        }

        public Criteria andWechatAppidIsNotNull() {
            addCriterion("wechat_appid is not null");
            return (Criteria) this;
        }

        public Criteria andWechatAppidEqualTo(String value) {
            addCriterion("wechat_appid =", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidNotEqualTo(String value) {
            addCriterion("wechat_appid <>", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidGreaterThan(String value) {
            addCriterion("wechat_appid >", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_appid >=", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidLessThan(String value) {
            addCriterion("wechat_appid <", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidLessThanOrEqualTo(String value) {
            addCriterion("wechat_appid <=", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidLike(String value) {
            addCriterion("wechat_appid like", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidNotLike(String value) {
            addCriterion("wechat_appid not like", value, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidIn(List<String> values) {
            addCriterion("wechat_appid in", values, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidNotIn(List<String> values) {
            addCriterion("wechat_appid not in", values, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidBetween(String value1, String value2) {
            addCriterion("wechat_appid between", value1, value2, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppidNotBetween(String value1, String value2) {
            addCriterion("wechat_appid not between", value1, value2, "wechatAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidIsNull() {
            addCriterion("alipay_appid is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidIsNotNull() {
            addCriterion("alipay_appid is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidEqualTo(String value) {
            addCriterion("alipay_appid =", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidNotEqualTo(String value) {
            addCriterion("alipay_appid <>", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidGreaterThan(String value) {
            addCriterion("alipay_appid >", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_appid >=", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidLessThan(String value) {
            addCriterion("alipay_appid <", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidLessThanOrEqualTo(String value) {
            addCriterion("alipay_appid <=", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidLike(String value) {
            addCriterion("alipay_appid like", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidNotLike(String value) {
            addCriterion("alipay_appid not like", value, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidIn(List<String> values) {
            addCriterion("alipay_appid in", values, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidNotIn(List<String> values) {
            addCriterion("alipay_appid not in", values, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidBetween(String value1, String value2) {
            addCriterion("alipay_appid between", value1, value2, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppidNotBetween(String value1, String value2) {
            addCriterion("alipay_appid not between", value1, value2, "alipayAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidIsNull() {
            addCriterion("wechat_app_appid is null");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidIsNotNull() {
            addCriterion("wechat_app_appid is not null");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidEqualTo(String value) {
            addCriterion("wechat_app_appid =", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidNotEqualTo(String value) {
            addCriterion("wechat_app_appid <>", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidGreaterThan(String value) {
            addCriterion("wechat_app_appid >", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_app_appid >=", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidLessThan(String value) {
            addCriterion("wechat_app_appid <", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidLessThanOrEqualTo(String value) {
            addCriterion("wechat_app_appid <=", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidLike(String value) {
            addCriterion("wechat_app_appid like", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidNotLike(String value) {
            addCriterion("wechat_app_appid not like", value, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidIn(List<String> values) {
            addCriterion("wechat_app_appid in", values, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidNotIn(List<String> values) {
            addCriterion("wechat_app_appid not in", values, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidBetween(String value1, String value2) {
            addCriterion("wechat_app_appid between", value1, value2, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andWechatAppAppidNotBetween(String value1, String value2) {
            addCriterion("wechat_app_appid not between", value1, value2, "wechatAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidIsNull() {
            addCriterion("alipay_app_appid is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidIsNotNull() {
            addCriterion("alipay_app_appid is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidEqualTo(String value) {
            addCriterion("alipay_app_appid =", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotEqualTo(String value) {
            addCriterion("alipay_app_appid <>", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidGreaterThan(String value) {
            addCriterion("alipay_app_appid >", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_app_appid >=", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidLessThan(String value) {
            addCriterion("alipay_app_appid <", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidLessThanOrEqualTo(String value) {
            addCriterion("alipay_app_appid <=", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidLike(String value) {
            addCriterion("alipay_app_appid like", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotLike(String value) {
            addCriterion("alipay_app_appid not like", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidIn(List<String> values) {
            addCriterion("alipay_app_appid in", values, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotIn(List<String> values) {
            addCriterion("alipay_app_appid not in", values, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidBetween(String value1, String value2) {
            addCriterion("alipay_app_appid between", value1, value2, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotBetween(String value1, String value2) {
            addCriterion("alipay_app_appid not between", value1, value2, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andSubChannelPartnerIdIsNull() {
            addCriterion("sub_channel_partner_id is null");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdIsNotNull() {
            addCriterion("sub_channel_partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdEqualTo(String value) {
            addCriterion("sub_channel_partner_id =", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdNotEqualTo(String value) {
            addCriterion("sub_channel_partner_id <>", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdGreaterThan(String value) {
            addCriterion("sub_channel_partner_id >", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_channel_partner_id >=", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdLessThan(String value) {
            addCriterion("sub_channel_partner_id <", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("sub_channel_partner_id <=", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdLike(String value) {
            addCriterion("sub_channel_partner_id like", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdNotLike(String value) {
            addCriterion("sub_channel_partner_id not like", value, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdIn(List<String> values) {
            addCriterion("sub_channel_partner_id in", values, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdNotIn(List<String> values) {
            addCriterion("sub_channel_partner_id not in", values, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdBetween(String value1, String value2) {
            addCriterion("sub_channel_partner_id between", value1, value2, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSubChannelPartnerIdNotBetween(String value1, String value2) {
            addCriterion("sub_channel_partner_id not between", value1, value2, "subChannelPartnerId");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNull() {
            addCriterion("public_key is null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNotNull() {
            addCriterion("public_key is not null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyEqualTo(String value) {
            addCriterion("public_key =", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotEqualTo(String value) {
            addCriterion("public_key <>", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThan(String value) {
            addCriterion("public_key >", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("public_key >=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThan(String value) {
            addCriterion("public_key <", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("public_key <=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLike(String value) {
            addCriterion("public_key like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotLike(String value) {
            addCriterion("public_key not like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIn(List<String> values) {
            addCriterion("public_key in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotIn(List<String> values) {
            addCriterion("public_key not in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyBetween(String value1, String value2) {
            addCriterion("public_key between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotBetween(String value1, String value2) {
            addCriterion("public_key not between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyIsNull() {
            addCriterion("system_public_key is null");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyIsNotNull() {
            addCriterion("system_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyEqualTo(String value) {
            addCriterion("system_public_key =", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyNotEqualTo(String value) {
            addCriterion("system_public_key <>", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyGreaterThan(String value) {
            addCriterion("system_public_key >", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("system_public_key >=", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyLessThan(String value) {
            addCriterion("system_public_key <", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("system_public_key <=", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyLike(String value) {
            addCriterion("system_public_key like", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyNotLike(String value) {
            addCriterion("system_public_key not like", value, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyIn(List<String> values) {
            addCriterion("system_public_key in", values, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyNotIn(List<String> values) {
            addCriterion("system_public_key not in", values, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyBetween(String value1, String value2) {
            addCriterion("system_public_key between", value1, value2, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andSystemPublicKeyNotBetween(String value1, String value2) {
            addCriterion("system_public_key not between", value1, value2, "systemPublicKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNull() {
            addCriterion("private_key is null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNotNull() {
            addCriterion("private_key is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyEqualTo(String value) {
            addCriterion("private_key =", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotEqualTo(String value) {
            addCriterion("private_key <>", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThan(String value) {
            addCriterion("private_key >", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("private_key >=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThan(String value) {
            addCriterion("private_key <", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("private_key <=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLike(String value) {
            addCriterion("private_key like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotLike(String value) {
            addCriterion("private_key not like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIn(List<String> values) {
            addCriterion("private_key in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotIn(List<String> values) {
            addCriterion("private_key not in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyBetween(String value1, String value2) {
            addCriterion("private_key between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("private_key not between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("return_url is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("return_url is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("return_url =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("return_url <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("return_url >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("return_url >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("return_url <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("return_url <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("return_url like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("return_url not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("return_url in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("return_url not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("return_url between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("return_url not between", value1, value2, "returnUrl");
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

        public Criteria andMarkDeleteIsNull() {
            addCriterion("mark_delete is null");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteIsNotNull() {
            addCriterion("mark_delete is not null");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteEqualTo(String value) {
            addCriterion("mark_delete =", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotEqualTo(String value) {
            addCriterion("mark_delete <>", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteGreaterThan(String value) {
            addCriterion("mark_delete >", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("mark_delete >=", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteLessThan(String value) {
            addCriterion("mark_delete <", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteLessThanOrEqualTo(String value) {
            addCriterion("mark_delete <=", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteLike(String value) {
            addCriterion("mark_delete like", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotLike(String value) {
            addCriterion("mark_delete not like", value, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteIn(List<String> values) {
            addCriterion("mark_delete in", values, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotIn(List<String> values) {
            addCriterion("mark_delete not in", values, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteBetween(String value1, String value2) {
            addCriterion("mark_delete between", value1, value2, "markDelete");
            return (Criteria) this;
        }

        public Criteria andMarkDeleteNotBetween(String value1, String value2) {
            addCriterion("mark_delete not between", value1, value2, "markDelete");
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