package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WashSalesCampaignDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WashSalesCampaignDOExample() {
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

        public Criteria andCampaignNoIsNull() {
            addCriterion("campaign_no is null");
            return (Criteria) this;
        }

        public Criteria andCampaignNoIsNotNull() {
            addCriterion("campaign_no is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignNoEqualTo(String value) {
            addCriterion("campaign_no =", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotEqualTo(String value) {
            addCriterion("campaign_no <>", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoGreaterThan(String value) {
            addCriterion("campaign_no >", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_no >=", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLessThan(String value) {
            addCriterion("campaign_no <", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLessThanOrEqualTo(String value) {
            addCriterion("campaign_no <=", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLike(String value) {
            addCriterion("campaign_no like", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotLike(String value) {
            addCriterion("campaign_no not like", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoIn(List<String> values) {
            addCriterion("campaign_no in", values, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotIn(List<String> values) {
            addCriterion("campaign_no not in", values, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoBetween(String value1, String value2) {
            addCriterion("campaign_no between", value1, value2, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotBetween(String value1, String value2) {
            addCriterion("campaign_no not between", value1, value2, "campaignNo");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andLifeCycleIsNull() {
            addCriterion("life_cycle is null");
            return (Criteria) this;
        }

        public Criteria andLifeCycleIsNotNull() {
            addCriterion("life_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andLifeCycleEqualTo(String value) {
            addCriterion("life_cycle =", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleNotEqualTo(String value) {
            addCriterion("life_cycle <>", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleGreaterThan(String value) {
            addCriterion("life_cycle >", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleGreaterThanOrEqualTo(String value) {
            addCriterion("life_cycle >=", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleLessThan(String value) {
            addCriterion("life_cycle <", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleLessThanOrEqualTo(String value) {
            addCriterion("life_cycle <=", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleLike(String value) {
            addCriterion("life_cycle like", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleNotLike(String value) {
            addCriterion("life_cycle not like", value, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleIn(List<String> values) {
            addCriterion("life_cycle in", values, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleNotIn(List<String> values) {
            addCriterion("life_cycle not in", values, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleBetween(String value1, String value2) {
            addCriterion("life_cycle between", value1, value2, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andLifeCycleNotBetween(String value1, String value2) {
            addCriterion("life_cycle not between", value1, value2, "lifeCycle");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitIsNull() {
            addCriterion("use_time_unit is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitIsNotNull() {
            addCriterion("use_time_unit is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitEqualTo(String value) {
            addCriterion("use_time_unit =", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotEqualTo(String value) {
            addCriterion("use_time_unit <>", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitGreaterThan(String value) {
            addCriterion("use_time_unit >", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitGreaterThanOrEqualTo(String value) {
            addCriterion("use_time_unit >=", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitLessThan(String value) {
            addCriterion("use_time_unit <", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitLessThanOrEqualTo(String value) {
            addCriterion("use_time_unit <=", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitLike(String value) {
            addCriterion("use_time_unit like", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotLike(String value) {
            addCriterion("use_time_unit not like", value, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitIn(List<String> values) {
            addCriterion("use_time_unit in", values, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotIn(List<String> values) {
            addCriterion("use_time_unit not in", values, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitBetween(String value1, String value2) {
            addCriterion("use_time_unit between", value1, value2, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andUseTimeUnitNotBetween(String value1, String value2) {
            addCriterion("use_time_unit not between", value1, value2, "useTimeUnit");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(String value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(String value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(String value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(String value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(String value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(String value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLike(String value) {
            addCriterion("days like", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotLike(String value) {
            addCriterion("days not like", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<String> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<String> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(String value1, String value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(String value1, String value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andTimeSlotIsNull() {
            addCriterion("time_slot is null");
            return (Criteria) this;
        }

        public Criteria andTimeSlotIsNotNull() {
            addCriterion("time_slot is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSlotEqualTo(String value) {
            addCriterion("time_slot =", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotNotEqualTo(String value) {
            addCriterion("time_slot <>", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotGreaterThan(String value) {
            addCriterion("time_slot >", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotGreaterThanOrEqualTo(String value) {
            addCriterion("time_slot >=", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotLessThan(String value) {
            addCriterion("time_slot <", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotLessThanOrEqualTo(String value) {
            addCriterion("time_slot <=", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotLike(String value) {
            addCriterion("time_slot like", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotNotLike(String value) {
            addCriterion("time_slot not like", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotIn(List<String> values) {
            addCriterion("time_slot in", values, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotNotIn(List<String> values) {
            addCriterion("time_slot not in", values, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotBetween(String value1, String value2) {
            addCriterion("time_slot between", value1, value2, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotNotBetween(String value1, String value2) {
            addCriterion("time_slot not between", value1, value2, "timeSlot");
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

        public Criteria andEventRoutesIsNull() {
            addCriterion("event_routes is null");
            return (Criteria) this;
        }

        public Criteria andEventRoutesIsNotNull() {
            addCriterion("event_routes is not null");
            return (Criteria) this;
        }

        public Criteria andEventRoutesEqualTo(String value) {
            addCriterion("event_routes =", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesNotEqualTo(String value) {
            addCriterion("event_routes <>", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesGreaterThan(String value) {
            addCriterion("event_routes >", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesGreaterThanOrEqualTo(String value) {
            addCriterion("event_routes >=", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesLessThan(String value) {
            addCriterion("event_routes <", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesLessThanOrEqualTo(String value) {
            addCriterion("event_routes <=", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesLike(String value) {
            addCriterion("event_routes like", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesNotLike(String value) {
            addCriterion("event_routes not like", value, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesIn(List<String> values) {
            addCriterion("event_routes in", values, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesNotIn(List<String> values) {
            addCriterion("event_routes not in", values, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesBetween(String value1, String value2) {
            addCriterion("event_routes between", value1, value2, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andEventRoutesNotBetween(String value1, String value2) {
            addCriterion("event_routes not between", value1, value2, "eventRoutes");
            return (Criteria) this;
        }

        public Criteria andLimitStationIsNull() {
            addCriterion("limit_station is null");
            return (Criteria) this;
        }

        public Criteria andLimitStationIsNotNull() {
            addCriterion("limit_station is not null");
            return (Criteria) this;
        }

        public Criteria andLimitStationEqualTo(Byte value) {
            addCriterion("limit_station =", value, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationNotEqualTo(Byte value) {
            addCriterion("limit_station <>", value, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationGreaterThan(Byte value) {
            addCriterion("limit_station >", value, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationGreaterThanOrEqualTo(Byte value) {
            addCriterion("limit_station >=", value, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationLessThan(Byte value) {
            addCriterion("limit_station <", value, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationLessThanOrEqualTo(Byte value) {
            addCriterion("limit_station <=", value, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationIn(List<Byte> values) {
            addCriterion("limit_station in", values, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationNotIn(List<Byte> values) {
            addCriterion("limit_station not in", values, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationBetween(Byte value1, Byte value2) {
            addCriterion("limit_station between", value1, value2, "limitStation");
            return (Criteria) this;
        }

        public Criteria andLimitStationNotBetween(Byte value1, Byte value2) {
            addCriterion("limit_station not between", value1, value2, "limitStation");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
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