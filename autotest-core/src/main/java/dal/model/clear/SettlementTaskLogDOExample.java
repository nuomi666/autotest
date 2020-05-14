package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SettlementTaskLogDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettlementTaskLogDOExample() {
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

        public Criteria andClearTimeIsNull() {
            addCriterion("clear_time is null");
            return (Criteria) this;
        }

        public Criteria andClearTimeIsNotNull() {
            addCriterion("clear_time is not null");
            return (Criteria) this;
        }

        public Criteria andClearTimeEqualTo(Date value) {
            addCriterion("clear_time =", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotEqualTo(Date value) {
            addCriterion("clear_time <>", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThan(Date value) {
            addCriterion("clear_time >", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("clear_time >=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThan(Date value) {
            addCriterion("clear_time <", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThanOrEqualTo(Date value) {
            addCriterion("clear_time <=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeIn(List<Date> values) {
            addCriterion("clear_time in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotIn(List<Date> values) {
            addCriterion("clear_time not in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeBetween(Date value1, Date value2) {
            addCriterion("clear_time between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotBetween(Date value1, Date value2) {
            addCriterion("clear_time not between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearCommentIsNull() {
            addCriterion("clear_comment is null");
            return (Criteria) this;
        }

        public Criteria andClearCommentIsNotNull() {
            addCriterion("clear_comment is not null");
            return (Criteria) this;
        }

        public Criteria andClearCommentEqualTo(String value) {
            addCriterion("clear_comment =", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentNotEqualTo(String value) {
            addCriterion("clear_comment <>", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentGreaterThan(String value) {
            addCriterion("clear_comment >", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentGreaterThanOrEqualTo(String value) {
            addCriterion("clear_comment >=", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentLessThan(String value) {
            addCriterion("clear_comment <", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentLessThanOrEqualTo(String value) {
            addCriterion("clear_comment <=", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentLike(String value) {
            addCriterion("clear_comment like", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentNotLike(String value) {
            addCriterion("clear_comment not like", value, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentIn(List<String> values) {
            addCriterion("clear_comment in", values, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentNotIn(List<String> values) {
            addCriterion("clear_comment not in", values, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentBetween(String value1, String value2) {
            addCriterion("clear_comment between", value1, value2, "clearComment");
            return (Criteria) this;
        }

        public Criteria andClearCommentNotBetween(String value1, String value2) {
            addCriterion("clear_comment not between", value1, value2, "clearComment");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIsNull() {
            addCriterion("settlement_status is null");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIsNotNull() {
            addCriterion("settlement_status is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusEqualTo(String value) {
            addCriterion("settlement_status =", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotEqualTo(String value) {
            addCriterion("settlement_status <>", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusGreaterThan(String value) {
            addCriterion("settlement_status >", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_status >=", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusLessThan(String value) {
            addCriterion("settlement_status <", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusLessThanOrEqualTo(String value) {
            addCriterion("settlement_status <=", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusLike(String value) {
            addCriterion("settlement_status like", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotLike(String value) {
            addCriterion("settlement_status not like", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIn(List<String> values) {
            addCriterion("settlement_status in", values, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotIn(List<String> values) {
            addCriterion("settlement_status not in", values, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusBetween(String value1, String value2) {
            addCriterion("settlement_status between", value1, value2, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotBetween(String value1, String value2) {
            addCriterion("settlement_status not between", value1, value2, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNull() {
            addCriterion("settlement_time is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNotNull() {
            addCriterion("settlement_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeEqualTo(Date value) {
            addCriterion("settlement_time =", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotEqualTo(Date value) {
            addCriterion("settlement_time <>", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThan(Date value) {
            addCriterion("settlement_time >", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settlement_time >=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThan(Date value) {
            addCriterion("settlement_time <", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThanOrEqualTo(Date value) {
            addCriterion("settlement_time <=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIn(List<Date> values) {
            addCriterion("settlement_time in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotIn(List<Date> values) {
            addCriterion("settlement_time not in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeBetween(Date value1, Date value2) {
            addCriterion("settlement_time between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotBetween(Date value1, Date value2) {
            addCriterion("settlement_time not between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentIsNull() {
            addCriterion("settlement_comment is null");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentIsNotNull() {
            addCriterion("settlement_comment is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentEqualTo(String value) {
            addCriterion("settlement_comment =", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentNotEqualTo(String value) {
            addCriterion("settlement_comment <>", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentGreaterThan(String value) {
            addCriterion("settlement_comment >", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_comment >=", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentLessThan(String value) {
            addCriterion("settlement_comment <", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentLessThanOrEqualTo(String value) {
            addCriterion("settlement_comment <=", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentLike(String value) {
            addCriterion("settlement_comment like", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentNotLike(String value) {
            addCriterion("settlement_comment not like", value, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentIn(List<String> values) {
            addCriterion("settlement_comment in", values, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentNotIn(List<String> values) {
            addCriterion("settlement_comment not in", values, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentBetween(String value1, String value2) {
            addCriterion("settlement_comment between", value1, value2, "settlementComment");
            return (Criteria) this;
        }

        public Criteria andSettlementCommentNotBetween(String value1, String value2) {
            addCriterion("settlement_comment not between", value1, value2, "settlementComment");
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