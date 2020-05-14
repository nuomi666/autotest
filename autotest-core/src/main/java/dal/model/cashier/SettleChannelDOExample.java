package dal.model.cashier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SettleChannelDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettleChannelDOExample() {
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

        public Criteria andSettleChannelIdIsNull() {
            addCriterion("settle_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdIsNotNull() {
            addCriterion("settle_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdEqualTo(String value) {
            addCriterion("settle_channel_id =", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdNotEqualTo(String value) {
            addCriterion("settle_channel_id <>", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdGreaterThan(String value) {
            addCriterion("settle_channel_id >", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("settle_channel_id >=", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdLessThan(String value) {
            addCriterion("settle_channel_id <", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdLessThanOrEqualTo(String value) {
            addCriterion("settle_channel_id <=", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdLike(String value) {
            addCriterion("settle_channel_id like", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdNotLike(String value) {
            addCriterion("settle_channel_id not like", value, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdIn(List<String> values) {
            addCriterion("settle_channel_id in", values, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdNotIn(List<String> values) {
            addCriterion("settle_channel_id not in", values, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdBetween(String value1, String value2) {
            addCriterion("settle_channel_id between", value1, value2, "settleChannelId");
            return (Criteria) this;
        }

        public Criteria andSettleChannelIdNotBetween(String value1, String value2) {
            addCriterion("settle_channel_id not between", value1, value2, "settleChannelId");
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

        public Criteria andSettleChannelNameIsNull() {
            addCriterion("settle_channel_name is null");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameIsNotNull() {
            addCriterion("settle_channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameEqualTo(String value) {
            addCriterion("settle_channel_name =", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameNotEqualTo(String value) {
            addCriterion("settle_channel_name <>", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameGreaterThan(String value) {
            addCriterion("settle_channel_name >", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("settle_channel_name >=", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameLessThan(String value) {
            addCriterion("settle_channel_name <", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameLessThanOrEqualTo(String value) {
            addCriterion("settle_channel_name <=", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameLike(String value) {
            addCriterion("settle_channel_name like", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameNotLike(String value) {
            addCriterion("settle_channel_name not like", value, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameIn(List<String> values) {
            addCriterion("settle_channel_name in", values, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameNotIn(List<String> values) {
            addCriterion("settle_channel_name not in", values, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameBetween(String value1, String value2) {
            addCriterion("settle_channel_name between", value1, value2, "settleChannelName");
            return (Criteria) this;
        }

        public Criteria andSettleChannelNameNotBetween(String value1, String value2) {
            addCriterion("settle_channel_name not between", value1, value2, "settleChannelName");
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

        public Criteria andRateTypeIsNull() {
            addCriterion("rate_type is null");
            return (Criteria) this;
        }

        public Criteria andRateTypeIsNotNull() {
            addCriterion("rate_type is not null");
            return (Criteria) this;
        }

        public Criteria andRateTypeEqualTo(String value) {
            addCriterion("rate_type =", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotEqualTo(String value) {
            addCriterion("rate_type <>", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeGreaterThan(String value) {
            addCriterion("rate_type >", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rate_type >=", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeLessThan(String value) {
            addCriterion("rate_type <", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeLessThanOrEqualTo(String value) {
            addCriterion("rate_type <=", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeLike(String value) {
            addCriterion("rate_type like", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotLike(String value) {
            addCriterion("rate_type not like", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeIn(List<String> values) {
            addCriterion("rate_type in", values, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotIn(List<String> values) {
            addCriterion("rate_type not in", values, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeBetween(String value1, String value2) {
            addCriterion("rate_type between", value1, value2, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotBetween(String value1, String value2) {
            addCriterion("rate_type not between", value1, value2, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Integer value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Integer value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Integer value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Integer value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Integer value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Integer> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Integer> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Integer value1, Integer value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Integer value1, Integer value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayIsNull() {
            addCriterion("syn_time_delay is null");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayIsNotNull() {
            addCriterion("syn_time_delay is not null");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayEqualTo(Integer value) {
            addCriterion("syn_time_delay =", value, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayNotEqualTo(Integer value) {
            addCriterion("syn_time_delay <>", value, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayGreaterThan(Integer value) {
            addCriterion("syn_time_delay >", value, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("syn_time_delay >=", value, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayLessThan(Integer value) {
            addCriterion("syn_time_delay <", value, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayLessThanOrEqualTo(Integer value) {
            addCriterion("syn_time_delay <=", value, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayIn(List<Integer> values) {
            addCriterion("syn_time_delay in", values, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayNotIn(List<Integer> values) {
            addCriterion("syn_time_delay not in", values, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayBetween(Integer value1, Integer value2) {
            addCriterion("syn_time_delay between", value1, value2, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTimeDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("syn_time_delay not between", value1, value2, "synTimeDelay");
            return (Criteria) this;
        }

        public Criteria andSynTpsIsNull() {
            addCriterion("syn_tps is null");
            return (Criteria) this;
        }

        public Criteria andSynTpsIsNotNull() {
            addCriterion("syn_tps is not null");
            return (Criteria) this;
        }

        public Criteria andSynTpsEqualTo(Integer value) {
            addCriterion("syn_tps =", value, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsNotEqualTo(Integer value) {
            addCriterion("syn_tps <>", value, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsGreaterThan(Integer value) {
            addCriterion("syn_tps >", value, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsGreaterThanOrEqualTo(Integer value) {
            addCriterion("syn_tps >=", value, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsLessThan(Integer value) {
            addCriterion("syn_tps <", value, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsLessThanOrEqualTo(Integer value) {
            addCriterion("syn_tps <=", value, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsIn(List<Integer> values) {
            addCriterion("syn_tps in", values, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsNotIn(List<Integer> values) {
            addCriterion("syn_tps not in", values, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsBetween(Integer value1, Integer value2) {
            addCriterion("syn_tps between", value1, value2, "synTps");
            return (Criteria) this;
        }

        public Criteria andSynTpsNotBetween(Integer value1, Integer value2) {
            addCriterion("syn_tps not between", value1, value2, "synTps");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayIsNull() {
            addCriterion("asyn_time_delay is null");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayIsNotNull() {
            addCriterion("asyn_time_delay is not null");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayEqualTo(Integer value) {
            addCriterion("asyn_time_delay =", value, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayNotEqualTo(Integer value) {
            addCriterion("asyn_time_delay <>", value, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayGreaterThan(Integer value) {
            addCriterion("asyn_time_delay >", value, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("asyn_time_delay >=", value, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayLessThan(Integer value) {
            addCriterion("asyn_time_delay <", value, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayLessThanOrEqualTo(Integer value) {
            addCriterion("asyn_time_delay <=", value, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayIn(List<Integer> values) {
            addCriterion("asyn_time_delay in", values, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayNotIn(List<Integer> values) {
            addCriterion("asyn_time_delay not in", values, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayBetween(Integer value1, Integer value2) {
            addCriterion("asyn_time_delay between", value1, value2, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andAsynTimeDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("asyn_time_delay not between", value1, value2, "asynTimeDelay");
            return (Criteria) this;
        }

        public Criteria andRetryTypeIsNull() {
            addCriterion("retry_type is null");
            return (Criteria) this;
        }

        public Criteria andRetryTypeIsNotNull() {
            addCriterion("retry_type is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTypeEqualTo(String value) {
            addCriterion("retry_type =", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeNotEqualTo(String value) {
            addCriterion("retry_type <>", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeGreaterThan(String value) {
            addCriterion("retry_type >", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("retry_type >=", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeLessThan(String value) {
            addCriterion("retry_type <", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeLessThanOrEqualTo(String value) {
            addCriterion("retry_type <=", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeLike(String value) {
            addCriterion("retry_type like", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeNotLike(String value) {
            addCriterion("retry_type not like", value, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeIn(List<String> values) {
            addCriterion("retry_type in", values, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeNotIn(List<String> values) {
            addCriterion("retry_type not in", values, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeBetween(String value1, String value2) {
            addCriterion("retry_type between", value1, value2, "retryType");
            return (Criteria) this;
        }

        public Criteria andRetryTypeNotBetween(String value1, String value2) {
            addCriterion("retry_type not between", value1, value2, "retryType");
            return (Criteria) this;
        }

        public Criteria andMetadatasIsNull() {
            addCriterion("metaDatas is null");
            return (Criteria) this;
        }

        public Criteria andMetadatasIsNotNull() {
            addCriterion("metaDatas is not null");
            return (Criteria) this;
        }

        public Criteria andMetadatasEqualTo(String value) {
            addCriterion("metaDatas =", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasNotEqualTo(String value) {
            addCriterion("metaDatas <>", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasGreaterThan(String value) {
            addCriterion("metaDatas >", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasGreaterThanOrEqualTo(String value) {
            addCriterion("metaDatas >=", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasLessThan(String value) {
            addCriterion("metaDatas <", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasLessThanOrEqualTo(String value) {
            addCriterion("metaDatas <=", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasLike(String value) {
            addCriterion("metaDatas like", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasNotLike(String value) {
            addCriterion("metaDatas not like", value, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasIn(List<String> values) {
            addCriterion("metaDatas in", values, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasNotIn(List<String> values) {
            addCriterion("metaDatas not in", values, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasBetween(String value1, String value2) {
            addCriterion("metaDatas between", value1, value2, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMetadatasNotBetween(String value1, String value2) {
            addCriterion("metaDatas not between", value1, value2, "metadatas");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingIsNull() {
            addCriterion("max_ceiling is null");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingIsNotNull() {
            addCriterion("max_ceiling is not null");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingEqualTo(Long value) {
            addCriterion("max_ceiling =", value, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingNotEqualTo(Long value) {
            addCriterion("max_ceiling <>", value, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingGreaterThan(Long value) {
            addCriterion("max_ceiling >", value, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingGreaterThanOrEqualTo(Long value) {
            addCriterion("max_ceiling >=", value, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingLessThan(Long value) {
            addCriterion("max_ceiling <", value, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingLessThanOrEqualTo(Long value) {
            addCriterion("max_ceiling <=", value, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingIn(List<Long> values) {
            addCriterion("max_ceiling in", values, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingNotIn(List<Long> values) {
            addCriterion("max_ceiling not in", values, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingBetween(Long value1, Long value2) {
            addCriterion("max_ceiling between", value1, value2, "maxCeiling");
            return (Criteria) this;
        }

        public Criteria andMaxCeilingNotBetween(Long value1, Long value2) {
            addCriterion("max_ceiling not between", value1, value2, "maxCeiling");
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