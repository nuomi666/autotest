package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillTaskConfDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillTaskConfDOExample() {
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

        public Criteria andBillChannelTimeIsNull() {
            addCriterion("bill_channel_time is null");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeIsNotNull() {
            addCriterion("bill_channel_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeEqualTo(String value) {
            addCriterion("bill_channel_time =", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeNotEqualTo(String value) {
            addCriterion("bill_channel_time <>", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeGreaterThan(String value) {
            addCriterion("bill_channel_time >", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_channel_time >=", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeLessThan(String value) {
            addCriterion("bill_channel_time <", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeLessThanOrEqualTo(String value) {
            addCriterion("bill_channel_time <=", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeLike(String value) {
            addCriterion("bill_channel_time like", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeNotLike(String value) {
            addCriterion("bill_channel_time not like", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeIn(List<String> values) {
            addCriterion("bill_channel_time in", values, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeNotIn(List<String> values) {
            addCriterion("bill_channel_time not in", values, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeBetween(String value1, String value2) {
            addCriterion("bill_channel_time between", value1, value2, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeNotBetween(String value1, String value2) {
            addCriterion("bill_channel_time not between", value1, value2, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeIsNull() {
            addCriterion("bill_time is null");
            return (Criteria) this;
        }

        public Criteria andBillTimeIsNotNull() {
            addCriterion("bill_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillTimeEqualTo(String value) {
            addCriterion("bill_time =", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeNotEqualTo(String value) {
            addCriterion("bill_time <>", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeGreaterThan(String value) {
            addCriterion("bill_time >", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_time >=", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeLessThan(String value) {
            addCriterion("bill_time <", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeLessThanOrEqualTo(String value) {
            addCriterion("bill_time <=", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeLike(String value) {
            addCriterion("bill_time like", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeNotLike(String value) {
            addCriterion("bill_time not like", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeIn(List<String> values) {
            addCriterion("bill_time in", values, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeNotIn(List<String> values) {
            addCriterion("bill_time not in", values, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeBetween(String value1, String value2) {
            addCriterion("bill_time between", value1, value2, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeNotBetween(String value1, String value2) {
            addCriterion("bill_time not between", value1, value2, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillCycleIsNull() {
            addCriterion("bill_cycle is null");
            return (Criteria) this;
        }

        public Criteria andBillCycleIsNotNull() {
            addCriterion("bill_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andBillCycleEqualTo(Integer value) {
            addCriterion("bill_cycle =", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleNotEqualTo(Integer value) {
            addCriterion("bill_cycle <>", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleGreaterThan(Integer value) {
            addCriterion("bill_cycle >", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_cycle >=", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleLessThan(Integer value) {
            addCriterion("bill_cycle <", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleLessThanOrEqualTo(Integer value) {
            addCriterion("bill_cycle <=", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleIn(List<Integer> values) {
            addCriterion("bill_cycle in", values, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleNotIn(List<Integer> values) {
            addCriterion("bill_cycle not in", values, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleBetween(Integer value1, Integer value2) {
            addCriterion("bill_cycle between", value1, value2, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_cycle not between", value1, value2, "billCycle");
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

        public Criteria andUseStatusIsNull() {
            addCriterion("use_status is null");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNotNull() {
            addCriterion("use_status is not null");
            return (Criteria) this;
        }

        public Criteria andUseStatusEqualTo(String value) {
            addCriterion("use_status =", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotEqualTo(String value) {
            addCriterion("use_status <>", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThan(String value) {
            addCriterion("use_status >", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("use_status >=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThan(String value) {
            addCriterion("use_status <", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThanOrEqualTo(String value) {
            addCriterion("use_status <=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLike(String value) {
            addCriterion("use_status like", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotLike(String value) {
            addCriterion("use_status not like", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusIn(List<String> values) {
            addCriterion("use_status in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotIn(List<String> values) {
            addCriterion("use_status not in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusBetween(String value1, String value2) {
            addCriterion("use_status between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotBetween(String value1, String value2) {
            addCriterion("use_status not between", value1, value2, "useStatus");
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