package dal.model.gas_marketpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GivePointsDetailDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GivePointsDetailDOExample() {
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

        public Criteria andEventIdIsNull() {
            addCriterion("event_id is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("event_id is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(String value) {
            addCriterion("event_id =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(String value) {
            addCriterion("event_id <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(String value) {
            addCriterion("event_id >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(String value) {
            addCriterion("event_id >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(String value) {
            addCriterion("event_id <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(String value) {
            addCriterion("event_id <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLike(String value) {
            addCriterion("event_id like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotLike(String value) {
            addCriterion("event_id not like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<String> values) {
            addCriterion("event_id in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<String> values) {
            addCriterion("event_id not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(String value1, String value2) {
            addCriterion("event_id between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(String value1, String value2) {
            addCriterion("event_id not between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoIsNull() {
            addCriterion("give_biz_no is null");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoIsNotNull() {
            addCriterion("give_biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoEqualTo(String value) {
            addCriterion("give_biz_no =", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoNotEqualTo(String value) {
            addCriterion("give_biz_no <>", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoGreaterThan(String value) {
            addCriterion("give_biz_no >", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("give_biz_no >=", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoLessThan(String value) {
            addCriterion("give_biz_no <", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoLessThanOrEqualTo(String value) {
            addCriterion("give_biz_no <=", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoLike(String value) {
            addCriterion("give_biz_no like", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoNotLike(String value) {
            addCriterion("give_biz_no not like", value, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoIn(List<String> values) {
            addCriterion("give_biz_no in", values, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoNotIn(List<String> values) {
            addCriterion("give_biz_no not in", values, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoBetween(String value1, String value2) {
            addCriterion("give_biz_no between", value1, value2, "giveBizNo");
            return (Criteria) this;
        }

        public Criteria andGiveBizNoNotBetween(String value1, String value2) {
            addCriterion("give_biz_no not between", value1, value2, "giveBizNo");
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

        public Criteria andCampaignTypeIsNull() {
            addCriterion("campaign_type is null");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeIsNotNull() {
            addCriterion("campaign_type is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeEqualTo(String value) {
            addCriterion("campaign_type =", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeNotEqualTo(String value) {
            addCriterion("campaign_type <>", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeGreaterThan(String value) {
            addCriterion("campaign_type >", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_type >=", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeLessThan(String value) {
            addCriterion("campaign_type <", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeLessThanOrEqualTo(String value) {
            addCriterion("campaign_type <=", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeLike(String value) {
            addCriterion("campaign_type like", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeNotLike(String value) {
            addCriterion("campaign_type not like", value, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeIn(List<String> values) {
            addCriterion("campaign_type in", values, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeNotIn(List<String> values) {
            addCriterion("campaign_type not in", values, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeBetween(String value1, String value2) {
            addCriterion("campaign_type between", value1, value2, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignTypeNotBetween(String value1, String value2) {
            addCriterion("campaign_type not between", value1, value2, "campaignType");
            return (Criteria) this;
        }

        public Criteria andCampaignNameIsNull() {
            addCriterion("campaign_name is null");
            return (Criteria) this;
        }

        public Criteria andCampaignNameIsNotNull() {
            addCriterion("campaign_name is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignNameEqualTo(String value) {
            addCriterion("campaign_name =", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotEqualTo(String value) {
            addCriterion("campaign_name <>", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameGreaterThan(String value) {
            addCriterion("campaign_name >", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_name >=", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameLessThan(String value) {
            addCriterion("campaign_name <", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameLessThanOrEqualTo(String value) {
            addCriterion("campaign_name <=", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameLike(String value) {
            addCriterion("campaign_name like", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotLike(String value) {
            addCriterion("campaign_name not like", value, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameIn(List<String> values) {
            addCriterion("campaign_name in", values, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotIn(List<String> values) {
            addCriterion("campaign_name not in", values, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameBetween(String value1, String value2) {
            addCriterion("campaign_name between", value1, value2, "campaignName");
            return (Criteria) this;
        }

        public Criteria andCampaignNameNotBetween(String value1, String value2) {
            addCriterion("campaign_name not between", value1, value2, "campaignName");
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

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(Long value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(Long value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(Long value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(Long value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<Long> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<Long> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(Long value1, Long value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAccountTagIsNull() {
            addCriterion("account_tag is null");
            return (Criteria) this;
        }

        public Criteria andAccountTagIsNotNull() {
            addCriterion("account_tag is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTagEqualTo(String value) {
            addCriterion("account_tag =", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagNotEqualTo(String value) {
            addCriterion("account_tag <>", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagGreaterThan(String value) {
            addCriterion("account_tag >", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagGreaterThanOrEqualTo(String value) {
            addCriterion("account_tag >=", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagLessThan(String value) {
            addCriterion("account_tag <", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagLessThanOrEqualTo(String value) {
            addCriterion("account_tag <=", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagLike(String value) {
            addCriterion("account_tag like", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagNotLike(String value) {
            addCriterion("account_tag not like", value, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagIn(List<String> values) {
            addCriterion("account_tag in", values, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagNotIn(List<String> values) {
            addCriterion("account_tag not in", values, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagBetween(String value1, String value2) {
            addCriterion("account_tag between", value1, value2, "accountTag");
            return (Criteria) this;
        }

        public Criteria andAccountTagNotBetween(String value1, String value2) {
            addCriterion("account_tag not between", value1, value2, "accountTag");
            return (Criteria) this;
        }

        public Criteria andMarketUserIsNull() {
            addCriterion("market_user is null");
            return (Criteria) this;
        }

        public Criteria andMarketUserIsNotNull() {
            addCriterion("market_user is not null");
            return (Criteria) this;
        }

        public Criteria andMarketUserEqualTo(String value) {
            addCriterion("market_user =", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserNotEqualTo(String value) {
            addCriterion("market_user <>", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserGreaterThan(String value) {
            addCriterion("market_user >", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserGreaterThanOrEqualTo(String value) {
            addCriterion("market_user >=", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserLessThan(String value) {
            addCriterion("market_user <", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserLessThanOrEqualTo(String value) {
            addCriterion("market_user <=", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserLike(String value) {
            addCriterion("market_user like", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserNotLike(String value) {
            addCriterion("market_user not like", value, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserIn(List<String> values) {
            addCriterion("market_user in", values, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserNotIn(List<String> values) {
            addCriterion("market_user not in", values, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserBetween(String value1, String value2) {
            addCriterion("market_user between", value1, value2, "marketUser");
            return (Criteria) this;
        }

        public Criteria andMarketUserNotBetween(String value1, String value2) {
            addCriterion("market_user not between", value1, value2, "marketUser");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoIsNull() {
            addCriterion("point_scheme_no is null");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoIsNotNull() {
            addCriterion("point_scheme_no is not null");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoEqualTo(String value) {
            addCriterion("point_scheme_no =", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoNotEqualTo(String value) {
            addCriterion("point_scheme_no <>", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoGreaterThan(String value) {
            addCriterion("point_scheme_no >", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoGreaterThanOrEqualTo(String value) {
            addCriterion("point_scheme_no >=", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoLessThan(String value) {
            addCriterion("point_scheme_no <", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoLessThanOrEqualTo(String value) {
            addCriterion("point_scheme_no <=", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoLike(String value) {
            addCriterion("point_scheme_no like", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoNotLike(String value) {
            addCriterion("point_scheme_no not like", value, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoIn(List<String> values) {
            addCriterion("point_scheme_no in", values, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoNotIn(List<String> values) {
            addCriterion("point_scheme_no not in", values, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoBetween(String value1, String value2) {
            addCriterion("point_scheme_no between", value1, value2, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointSchemeNoNotBetween(String value1, String value2) {
            addCriterion("point_scheme_no not between", value1, value2, "pointSchemeNo");
            return (Criteria) this;
        }

        public Criteria andPointDetailsIsNull() {
            addCriterion("point_details is null");
            return (Criteria) this;
        }

        public Criteria andPointDetailsIsNotNull() {
            addCriterion("point_details is not null");
            return (Criteria) this;
        }

        public Criteria andPointDetailsEqualTo(String value) {
            addCriterion("point_details =", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsNotEqualTo(String value) {
            addCriterion("point_details <>", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsGreaterThan(String value) {
            addCriterion("point_details >", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("point_details >=", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsLessThan(String value) {
            addCriterion("point_details <", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsLessThanOrEqualTo(String value) {
            addCriterion("point_details <=", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsLike(String value) {
            addCriterion("point_details like", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsNotLike(String value) {
            addCriterion("point_details not like", value, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsIn(List<String> values) {
            addCriterion("point_details in", values, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsNotIn(List<String> values) {
            addCriterion("point_details not in", values, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsBetween(String value1, String value2) {
            addCriterion("point_details between", value1, value2, "pointDetails");
            return (Criteria) this;
        }

        public Criteria andPointDetailsNotBetween(String value1, String value2) {
            addCriterion("point_details not between", value1, value2, "pointDetails");
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

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(Long value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(Long value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(Long value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(Long value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(Long value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(Long value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<Long> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<Long> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(Long value1, Long value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(Long value1, Long value2) {
            addCriterion("points not between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(String value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(String value) {
            addCriterion("station_id <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(String value) {
            addCriterion("station_id >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("station_id >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(String value) {
            addCriterion("station_id <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(String value) {
            addCriterion("station_id <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLike(String value) {
            addCriterion("station_id like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotLike(String value) {
            addCriterion("station_id not like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<String> values) {
            addCriterion("station_id in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<String> values) {
            addCriterion("station_id not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(String value1, String value2) {
            addCriterion("station_id between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(String value1, String value2) {
            addCriterion("station_id not between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIsNull() {
            addCriterion("terminal_type is null");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIsNotNull() {
            addCriterion("terminal_type is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeEqualTo(String value) {
            addCriterion("terminal_type =", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotEqualTo(String value) {
            addCriterion("terminal_type <>", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeGreaterThan(String value) {
            addCriterion("terminal_type >", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("terminal_type >=", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLessThan(String value) {
            addCriterion("terminal_type <", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLessThanOrEqualTo(String value) {
            addCriterion("terminal_type <=", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLike(String value) {
            addCriterion("terminal_type like", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotLike(String value) {
            addCriterion("terminal_type not like", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIn(List<String> values) {
            addCriterion("terminal_type in", values, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotIn(List<String> values) {
            addCriterion("terminal_type not in", values, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeBetween(String value1, String value2) {
            addCriterion("terminal_type between", value1, value2, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotBetween(String value1, String value2) {
            addCriterion("terminal_type not between", value1, value2, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIsNull() {
            addCriterion("terminal_code is null");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIsNotNull() {
            addCriterion("terminal_code is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeEqualTo(String value) {
            addCriterion("terminal_code =", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotEqualTo(String value) {
            addCriterion("terminal_code <>", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeGreaterThan(String value) {
            addCriterion("terminal_code >", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("terminal_code >=", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLessThan(String value) {
            addCriterion("terminal_code <", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLessThanOrEqualTo(String value) {
            addCriterion("terminal_code <=", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLike(String value) {
            addCriterion("terminal_code like", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotLike(String value) {
            addCriterion("terminal_code not like", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIn(List<String> values) {
            addCriterion("terminal_code in", values, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotIn(List<String> values) {
            addCriterion("terminal_code not in", values, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeBetween(String value1, String value2) {
            addCriterion("terminal_code between", value1, value2, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotBetween(String value1, String value2) {
            addCriterion("terminal_code not between", value1, value2, "terminalCode");
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

        public Criteria andGroupNoIsNull() {
            addCriterion("group_no is null");
            return (Criteria) this;
        }

        public Criteria andGroupNoIsNotNull() {
            addCriterion("group_no is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNoEqualTo(String value) {
            addCriterion("group_no =", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotEqualTo(String value) {
            addCriterion("group_no <>", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoGreaterThan(String value) {
            addCriterion("group_no >", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("group_no >=", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLessThan(String value) {
            addCriterion("group_no <", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLessThanOrEqualTo(String value) {
            addCriterion("group_no <=", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLike(String value) {
            addCriterion("group_no like", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotLike(String value) {
            addCriterion("group_no not like", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoIn(List<String> values) {
            addCriterion("group_no in", values, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotIn(List<String> values) {
            addCriterion("group_no not in", values, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoBetween(String value1, String value2) {
            addCriterion("group_no between", value1, value2, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotBetween(String value1, String value2) {
            addCriterion("group_no not between", value1, value2, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdIsNull() {
            addCriterion("partake_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdIsNotNull() {
            addCriterion("partake_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdEqualTo(String value) {
            addCriterion("partake_user_id =", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdNotEqualTo(String value) {
            addCriterion("partake_user_id <>", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdGreaterThan(String value) {
            addCriterion("partake_user_id >", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("partake_user_id >=", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdLessThan(String value) {
            addCriterion("partake_user_id <", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdLessThanOrEqualTo(String value) {
            addCriterion("partake_user_id <=", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdLike(String value) {
            addCriterion("partake_user_id like", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdNotLike(String value) {
            addCriterion("partake_user_id not like", value, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdIn(List<String> values) {
            addCriterion("partake_user_id in", values, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdNotIn(List<String> values) {
            addCriterion("partake_user_id not in", values, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdBetween(String value1, String value2) {
            addCriterion("partake_user_id between", value1, value2, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIdNotBetween(String value1, String value2) {
            addCriterion("partake_user_id not between", value1, value2, "partakeUserId");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIsNull() {
            addCriterion("partake_user is null");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIsNotNull() {
            addCriterion("partake_user is not null");
            return (Criteria) this;
        }

        public Criteria andPartakeUserEqualTo(String value) {
            addCriterion("partake_user =", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserNotEqualTo(String value) {
            addCriterion("partake_user <>", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserGreaterThan(String value) {
            addCriterion("partake_user >", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserGreaterThanOrEqualTo(String value) {
            addCriterion("partake_user >=", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserLessThan(String value) {
            addCriterion("partake_user <", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserLessThanOrEqualTo(String value) {
            addCriterion("partake_user <=", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserLike(String value) {
            addCriterion("partake_user like", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserNotLike(String value) {
            addCriterion("partake_user not like", value, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserIn(List<String> values) {
            addCriterion("partake_user in", values, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserNotIn(List<String> values) {
            addCriterion("partake_user not in", values, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserBetween(String value1, String value2) {
            addCriterion("partake_user between", value1, value2, "partakeUser");
            return (Criteria) this;
        }

        public Criteria andPartakeUserNotBetween(String value1, String value2) {
            addCriterion("partake_user not between", value1, value2, "partakeUser");
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