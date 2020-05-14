package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WashScanTakeCampaignDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WashScanTakeCampaignDOExample() {
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

        public Criteria andOneTakeNumIsNull() {
            addCriterion("one_take_num is null");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumIsNotNull() {
            addCriterion("one_take_num is not null");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumEqualTo(Integer value) {
            addCriterion("one_take_num =", value, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumNotEqualTo(Integer value) {
            addCriterion("one_take_num <>", value, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumGreaterThan(Integer value) {
            addCriterion("one_take_num >", value, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("one_take_num >=", value, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumLessThan(Integer value) {
            addCriterion("one_take_num <", value, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumLessThanOrEqualTo(Integer value) {
            addCriterion("one_take_num <=", value, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumIn(List<Integer> values) {
            addCriterion("one_take_num in", values, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumNotIn(List<Integer> values) {
            addCriterion("one_take_num not in", values, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumBetween(Integer value1, Integer value2) {
            addCriterion("one_take_num between", value1, value2, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andOneTakeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("one_take_num not between", value1, value2, "oneTakeNum");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNull() {
            addCriterion("stock_num is null");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNotNull() {
            addCriterion("stock_num is not null");
            return (Criteria) this;
        }

        public Criteria andStockNumEqualTo(Integer value) {
            addCriterion("stock_num =", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotEqualTo(Integer value) {
            addCriterion("stock_num <>", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThan(Integer value) {
            addCriterion("stock_num >", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_num >=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThan(Integer value) {
            addCriterion("stock_num <", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThanOrEqualTo(Integer value) {
            addCriterion("stock_num <=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumIn(List<Integer> values) {
            addCriterion("stock_num in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotIn(List<Integer> values) {
            addCriterion("stock_num not in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumBetween(Integer value1, Integer value2) {
            addCriterion("stock_num between", value1, value2, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_num not between", value1, value2, "stockNum");
            return (Criteria) this;
        }

        public Criteria andPromotionWayIsNull() {
            addCriterion("promotion_way is null");
            return (Criteria) this;
        }

        public Criteria andPromotionWayIsNotNull() {
            addCriterion("promotion_way is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionWayEqualTo(String value) {
            addCriterion("promotion_way =", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayNotEqualTo(String value) {
            addCriterion("promotion_way <>", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayGreaterThan(String value) {
            addCriterion("promotion_way >", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_way >=", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayLessThan(String value) {
            addCriterion("promotion_way <", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayLessThanOrEqualTo(String value) {
            addCriterion("promotion_way <=", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayLike(String value) {
            addCriterion("promotion_way like", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayNotLike(String value) {
            addCriterion("promotion_way not like", value, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayIn(List<String> values) {
            addCriterion("promotion_way in", values, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayNotIn(List<String> values) {
            addCriterion("promotion_way not in", values, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayBetween(String value1, String value2) {
            addCriterion("promotion_way between", value1, value2, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andPromotionWayNotBetween(String value1, String value2) {
            addCriterion("promotion_way not between", value1, value2, "promotionWay");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlIsNull() {
            addCriterion("campaign_url is null");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlIsNotNull() {
            addCriterion("campaign_url is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlEqualTo(String value) {
            addCriterion("campaign_url =", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlNotEqualTo(String value) {
            addCriterion("campaign_url <>", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlGreaterThan(String value) {
            addCriterion("campaign_url >", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_url >=", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlLessThan(String value) {
            addCriterion("campaign_url <", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlLessThanOrEqualTo(String value) {
            addCriterion("campaign_url <=", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlLike(String value) {
            addCriterion("campaign_url like", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlNotLike(String value) {
            addCriterion("campaign_url not like", value, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlIn(List<String> values) {
            addCriterion("campaign_url in", values, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlNotIn(List<String> values) {
            addCriterion("campaign_url not in", values, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlBetween(String value1, String value2) {
            addCriterion("campaign_url between", value1, value2, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andCampaignUrlNotBetween(String value1, String value2) {
            addCriterion("campaign_url not between", value1, value2, "campaignUrl");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeIsNull() {
            addCriterion("valid_start_time is null");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeIsNotNull() {
            addCriterion("valid_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeEqualTo(Date value) {
            addCriterion("valid_start_time =", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeNotEqualTo(Date value) {
            addCriterion("valid_start_time <>", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeGreaterThan(Date value) {
            addCriterion("valid_start_time >", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_start_time >=", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeLessThan(Date value) {
            addCriterion("valid_start_time <", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("valid_start_time <=", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeIn(List<Date> values) {
            addCriterion("valid_start_time in", values, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeNotIn(List<Date> values) {
            addCriterion("valid_start_time not in", values, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeBetween(Date value1, Date value2) {
            addCriterion("valid_start_time between", value1, value2, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("valid_start_time not between", value1, value2, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIsNull() {
            addCriterion("valid_end_time is null");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIsNotNull() {
            addCriterion("valid_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeEqualTo(Date value) {
            addCriterion("valid_end_time =", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotEqualTo(Date value) {
            addCriterion("valid_end_time <>", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeGreaterThan(Date value) {
            addCriterion("valid_end_time >", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_end_time >=", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeLessThan(Date value) {
            addCriterion("valid_end_time <", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("valid_end_time <=", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIn(List<Date> values) {
            addCriterion("valid_end_time in", values, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotIn(List<Date> values) {
            addCriterion("valid_end_time not in", values, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeBetween(Date value1, Date value2) {
            addCriterion("valid_end_time between", value1, value2, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("valid_end_time not between", value1, value2, "validEndTime");
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