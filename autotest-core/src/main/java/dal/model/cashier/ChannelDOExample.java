package dal.model.cashier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChannelDOExample() {
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

        public Criteria andChannelConfigIsNull() {
            addCriterion("channel_config is null");
            return (Criteria) this;
        }

        public Criteria andChannelConfigIsNotNull() {
            addCriterion("channel_config is not null");
            return (Criteria) this;
        }

        public Criteria andChannelConfigEqualTo(String value) {
            addCriterion("channel_config =", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigNotEqualTo(String value) {
            addCriterion("channel_config <>", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigGreaterThan(String value) {
            addCriterion("channel_config >", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigGreaterThanOrEqualTo(String value) {
            addCriterion("channel_config >=", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigLessThan(String value) {
            addCriterion("channel_config <", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigLessThanOrEqualTo(String value) {
            addCriterion("channel_config <=", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigLike(String value) {
            addCriterion("channel_config like", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigNotLike(String value) {
            addCriterion("channel_config not like", value, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigIn(List<String> values) {
            addCriterion("channel_config in", values, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigNotIn(List<String> values) {
            addCriterion("channel_config not in", values, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigBetween(String value1, String value2) {
            addCriterion("channel_config between", value1, value2, "channelConfig");
            return (Criteria) this;
        }

        public Criteria andChannelConfigNotBetween(String value1, String value2) {
            addCriterion("channel_config not between", value1, value2, "channelConfig");
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

        public Criteria andChannelTypeIsNull() {
            addCriterion("channel_type is null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIsNotNull() {
            addCriterion("channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeEqualTo(String value) {
            addCriterion("channel_type =", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotEqualTo(String value) {
            addCriterion("channel_type <>", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThan(String value) {
            addCriterion("channel_type >", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_type >=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThan(String value) {
            addCriterion("channel_type <", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThanOrEqualTo(String value) {
            addCriterion("channel_type <=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLike(String value) {
            addCriterion("channel_type like", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotLike(String value) {
            addCriterion("channel_type not like", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIn(List<String> values) {
            addCriterion("channel_type in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotIn(List<String> values) {
            addCriterion("channel_type not in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeBetween(String value1, String value2) {
            addCriterion("channel_type between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotBetween(String value1, String value2) {
            addCriterion("channel_type not between", value1, value2, "channelType");
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

        public Criteria andMerchantRateRuleIsNull() {
            addCriterion("merchant_rate_rule is null");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleIsNotNull() {
            addCriterion("merchant_rate_rule is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleEqualTo(String value) {
            addCriterion("merchant_rate_rule =", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleNotEqualTo(String value) {
            addCriterion("merchant_rate_rule <>", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleGreaterThan(String value) {
            addCriterion("merchant_rate_rule >", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_rate_rule >=", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleLessThan(String value) {
            addCriterion("merchant_rate_rule <", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleLessThanOrEqualTo(String value) {
            addCriterion("merchant_rate_rule <=", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleLike(String value) {
            addCriterion("merchant_rate_rule like", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleNotLike(String value) {
            addCriterion("merchant_rate_rule not like", value, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleIn(List<String> values) {
            addCriterion("merchant_rate_rule in", values, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleNotIn(List<String> values) {
            addCriterion("merchant_rate_rule not in", values, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleBetween(String value1, String value2) {
            addCriterion("merchant_rate_rule between", value1, value2, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateRuleNotBetween(String value1, String value2) {
            addCriterion("merchant_rate_rule not between", value1, value2, "merchantRateRule");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalIsNull() {
            addCriterion("merchant_rate_decimal is null");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalIsNotNull() {
            addCriterion("merchant_rate_decimal is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalEqualTo(Integer value) {
            addCriterion("merchant_rate_decimal =", value, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalNotEqualTo(Integer value) {
            addCriterion("merchant_rate_decimal <>", value, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalGreaterThan(Integer value) {
            addCriterion("merchant_rate_decimal >", value, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_rate_decimal >=", value, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalLessThan(Integer value) {
            addCriterion("merchant_rate_decimal <", value, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_rate_decimal <=", value, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalIn(List<Integer> values) {
            addCriterion("merchant_rate_decimal in", values, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalNotIn(List<Integer> values) {
            addCriterion("merchant_rate_decimal not in", values, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalBetween(Integer value1, Integer value2) {
            addCriterion("merchant_rate_decimal between", value1, value2, "merchantRateDecimal");
            return (Criteria) this;
        }

        public Criteria andMerchantRateDecimalNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_rate_decimal not between", value1, value2, "merchantRateDecimal");
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

        public Criteria andChannelRateRuleIsNull() {
            addCriterion("channel_rate_rule is null");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleIsNotNull() {
            addCriterion("channel_rate_rule is not null");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleEqualTo(String value) {
            addCriterion("channel_rate_rule =", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleNotEqualTo(String value) {
            addCriterion("channel_rate_rule <>", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleGreaterThan(String value) {
            addCriterion("channel_rate_rule >", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleGreaterThanOrEqualTo(String value) {
            addCriterion("channel_rate_rule >=", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleLessThan(String value) {
            addCriterion("channel_rate_rule <", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleLessThanOrEqualTo(String value) {
            addCriterion("channel_rate_rule <=", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleLike(String value) {
            addCriterion("channel_rate_rule like", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleNotLike(String value) {
            addCriterion("channel_rate_rule not like", value, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleIn(List<String> values) {
            addCriterion("channel_rate_rule in", values, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleNotIn(List<String> values) {
            addCriterion("channel_rate_rule not in", values, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleBetween(String value1, String value2) {
            addCriterion("channel_rate_rule between", value1, value2, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateRuleNotBetween(String value1, String value2) {
            addCriterion("channel_rate_rule not between", value1, value2, "channelRateRule");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalIsNull() {
            addCriterion("channel_rate_decimal is null");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalIsNotNull() {
            addCriterion("channel_rate_decimal is not null");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalEqualTo(Integer value) {
            addCriterion("channel_rate_decimal =", value, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalNotEqualTo(Integer value) {
            addCriterion("channel_rate_decimal <>", value, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalGreaterThan(Integer value) {
            addCriterion("channel_rate_decimal >", value, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_rate_decimal >=", value, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalLessThan(Integer value) {
            addCriterion("channel_rate_decimal <", value, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalLessThanOrEqualTo(Integer value) {
            addCriterion("channel_rate_decimal <=", value, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalIn(List<Integer> values) {
            addCriterion("channel_rate_decimal in", values, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalNotIn(List<Integer> values) {
            addCriterion("channel_rate_decimal not in", values, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalBetween(Integer value1, Integer value2) {
            addCriterion("channel_rate_decimal between", value1, value2, "channelRateDecimal");
            return (Criteria) this;
        }

        public Criteria andChannelRateDecimalNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_rate_decimal not between", value1, value2, "channelRateDecimal");
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