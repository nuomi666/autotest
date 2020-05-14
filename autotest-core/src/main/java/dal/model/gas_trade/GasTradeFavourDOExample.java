package dal.model.gas_trade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasTradeFavourDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasTradeFavourDOExample() {
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

        public Criteria andFavourIdIsNull() {
            addCriterion("favour_id is null");
            return (Criteria) this;
        }

        public Criteria andFavourIdIsNotNull() {
            addCriterion("favour_id is not null");
            return (Criteria) this;
        }

        public Criteria andFavourIdEqualTo(String value) {
            addCriterion("favour_id =", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdNotEqualTo(String value) {
            addCriterion("favour_id <>", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdGreaterThan(String value) {
            addCriterion("favour_id >", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdGreaterThanOrEqualTo(String value) {
            addCriterion("favour_id >=", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdLessThan(String value) {
            addCriterion("favour_id <", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdLessThanOrEqualTo(String value) {
            addCriterion("favour_id <=", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdLike(String value) {
            addCriterion("favour_id like", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdNotLike(String value) {
            addCriterion("favour_id not like", value, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdIn(List<String> values) {
            addCriterion("favour_id in", values, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdNotIn(List<String> values) {
            addCriterion("favour_id not in", values, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdBetween(String value1, String value2) {
            addCriterion("favour_id between", value1, value2, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourIdNotBetween(String value1, String value2) {
            addCriterion("favour_id not between", value1, value2, "favourId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdIsNull() {
            addCriterion("favour_definition_id is null");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdIsNotNull() {
            addCriterion("favour_definition_id is not null");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdEqualTo(String value) {
            addCriterion("favour_definition_id =", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdNotEqualTo(String value) {
            addCriterion("favour_definition_id <>", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdGreaterThan(String value) {
            addCriterion("favour_definition_id >", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("favour_definition_id >=", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdLessThan(String value) {
            addCriterion("favour_definition_id <", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdLessThanOrEqualTo(String value) {
            addCriterion("favour_definition_id <=", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdLike(String value) {
            addCriterion("favour_definition_id like", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdNotLike(String value) {
            addCriterion("favour_definition_id not like", value, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdIn(List<String> values) {
            addCriterion("favour_definition_id in", values, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdNotIn(List<String> values) {
            addCriterion("favour_definition_id not in", values, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdBetween(String value1, String value2) {
            addCriterion("favour_definition_id between", value1, value2, "favourDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFavourDefinitionIdNotBetween(String value1, String value2) {
            addCriterion("favour_definition_id not between", value1, value2, "favourDefinitionId");
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

        public Criteria andFavourNameIsNull() {
            addCriterion("favour_name is null");
            return (Criteria) this;
        }

        public Criteria andFavourNameIsNotNull() {
            addCriterion("favour_name is not null");
            return (Criteria) this;
        }

        public Criteria andFavourNameEqualTo(String value) {
            addCriterion("favour_name =", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameNotEqualTo(String value) {
            addCriterion("favour_name <>", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameGreaterThan(String value) {
            addCriterion("favour_name >", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameGreaterThanOrEqualTo(String value) {
            addCriterion("favour_name >=", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameLessThan(String value) {
            addCriterion("favour_name <", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameLessThanOrEqualTo(String value) {
            addCriterion("favour_name <=", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameLike(String value) {
            addCriterion("favour_name like", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameNotLike(String value) {
            addCriterion("favour_name not like", value, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameIn(List<String> values) {
            addCriterion("favour_name in", values, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameNotIn(List<String> values) {
            addCriterion("favour_name not in", values, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameBetween(String value1, String value2) {
            addCriterion("favour_name between", value1, value2, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourNameNotBetween(String value1, String value2) {
            addCriterion("favour_name not between", value1, value2, "favourName");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryIsNull() {
            addCriterion("favour_category is null");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryIsNotNull() {
            addCriterion("favour_category is not null");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryEqualTo(String value) {
            addCriterion("favour_category =", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryNotEqualTo(String value) {
            addCriterion("favour_category <>", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryGreaterThan(String value) {
            addCriterion("favour_category >", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("favour_category >=", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryLessThan(String value) {
            addCriterion("favour_category <", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryLessThanOrEqualTo(String value) {
            addCriterion("favour_category <=", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryLike(String value) {
            addCriterion("favour_category like", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryNotLike(String value) {
            addCriterion("favour_category not like", value, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryIn(List<String> values) {
            addCriterion("favour_category in", values, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryNotIn(List<String> values) {
            addCriterion("favour_category not in", values, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryBetween(String value1, String value2) {
            addCriterion("favour_category between", value1, value2, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourCategoryNotBetween(String value1, String value2) {
            addCriterion("favour_category not between", value1, value2, "favourCategory");
            return (Criteria) this;
        }

        public Criteria andFavourTypeIsNull() {
            addCriterion("favour_type is null");
            return (Criteria) this;
        }

        public Criteria andFavourTypeIsNotNull() {
            addCriterion("favour_type is not null");
            return (Criteria) this;
        }

        public Criteria andFavourTypeEqualTo(String value) {
            addCriterion("favour_type =", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeNotEqualTo(String value) {
            addCriterion("favour_type <>", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeGreaterThan(String value) {
            addCriterion("favour_type >", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeGreaterThanOrEqualTo(String value) {
            addCriterion("favour_type >=", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeLessThan(String value) {
            addCriterion("favour_type <", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeLessThanOrEqualTo(String value) {
            addCriterion("favour_type <=", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeLike(String value) {
            addCriterion("favour_type like", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeNotLike(String value) {
            addCriterion("favour_type not like", value, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeIn(List<String> values) {
            addCriterion("favour_type in", values, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeNotIn(List<String> values) {
            addCriterion("favour_type not in", values, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeBetween(String value1, String value2) {
            addCriterion("favour_type between", value1, value2, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourTypeNotBetween(String value1, String value2) {
            addCriterion("favour_type not between", value1, value2, "favourType");
            return (Criteria) this;
        }

        public Criteria andFavourRuleIsNull() {
            addCriterion("favour_rule is null");
            return (Criteria) this;
        }

        public Criteria andFavourRuleIsNotNull() {
            addCriterion("favour_rule is not null");
            return (Criteria) this;
        }

        public Criteria andFavourRuleEqualTo(String value) {
            addCriterion("favour_rule =", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleNotEqualTo(String value) {
            addCriterion("favour_rule <>", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleGreaterThan(String value) {
            addCriterion("favour_rule >", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleGreaterThanOrEqualTo(String value) {
            addCriterion("favour_rule >=", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleLessThan(String value) {
            addCriterion("favour_rule <", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleLessThanOrEqualTo(String value) {
            addCriterion("favour_rule <=", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleLike(String value) {
            addCriterion("favour_rule like", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleNotLike(String value) {
            addCriterion("favour_rule not like", value, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleIn(List<String> values) {
            addCriterion("favour_rule in", values, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleNotIn(List<String> values) {
            addCriterion("favour_rule not in", values, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleBetween(String value1, String value2) {
            addCriterion("favour_rule between", value1, value2, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourRuleNotBetween(String value1, String value2) {
            addCriterion("favour_rule not between", value1, value2, "favourRule");
            return (Criteria) this;
        }

        public Criteria andFavourAmountIsNull() {
            addCriterion("favour_amount is null");
            return (Criteria) this;
        }

        public Criteria andFavourAmountIsNotNull() {
            addCriterion("favour_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFavourAmountEqualTo(Long value) {
            addCriterion("favour_amount =", value, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountNotEqualTo(Long value) {
            addCriterion("favour_amount <>", value, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountGreaterThan(Long value) {
            addCriterion("favour_amount >", value, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("favour_amount >=", value, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountLessThan(Long value) {
            addCriterion("favour_amount <", value, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountLessThanOrEqualTo(Long value) {
            addCriterion("favour_amount <=", value, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountIn(List<Long> values) {
            addCriterion("favour_amount in", values, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountNotIn(List<Long> values) {
            addCriterion("favour_amount not in", values, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountBetween(Long value1, Long value2) {
            addCriterion("favour_amount between", value1, value2, "favourAmount");
            return (Criteria) this;
        }

        public Criteria andFavourAmountNotBetween(Long value1, Long value2) {
            addCriterion("favour_amount not between", value1, value2, "favourAmount");
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