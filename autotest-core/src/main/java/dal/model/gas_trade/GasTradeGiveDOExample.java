package dal.model.gas_trade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasTradeGiveDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasTradeGiveDOExample() {
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

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
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

        public Criteria andGiveIdIsNull() {
            addCriterion("give_id is null");
            return (Criteria) this;
        }

        public Criteria andGiveIdIsNotNull() {
            addCriterion("give_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiveIdEqualTo(String value) {
            addCriterion("give_id =", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdNotEqualTo(String value) {
            addCriterion("give_id <>", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdGreaterThan(String value) {
            addCriterion("give_id >", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdGreaterThanOrEqualTo(String value) {
            addCriterion("give_id >=", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdLessThan(String value) {
            addCriterion("give_id <", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdLessThanOrEqualTo(String value) {
            addCriterion("give_id <=", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdLike(String value) {
            addCriterion("give_id like", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdNotLike(String value) {
            addCriterion("give_id not like", value, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdIn(List<String> values) {
            addCriterion("give_id in", values, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdNotIn(List<String> values) {
            addCriterion("give_id not in", values, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdBetween(String value1, String value2) {
            addCriterion("give_id between", value1, value2, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveIdNotBetween(String value1, String value2) {
            addCriterion("give_id not between", value1, value2, "giveId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdIsNull() {
            addCriterion("give_definition_id is null");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdIsNotNull() {
            addCriterion("give_definition_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdEqualTo(String value) {
            addCriterion("give_definition_id =", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdNotEqualTo(String value) {
            addCriterion("give_definition_id <>", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdGreaterThan(String value) {
            addCriterion("give_definition_id >", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("give_definition_id >=", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdLessThan(String value) {
            addCriterion("give_definition_id <", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdLessThanOrEqualTo(String value) {
            addCriterion("give_definition_id <=", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdLike(String value) {
            addCriterion("give_definition_id like", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdNotLike(String value) {
            addCriterion("give_definition_id not like", value, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdIn(List<String> values) {
            addCriterion("give_definition_id in", values, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdNotIn(List<String> values) {
            addCriterion("give_definition_id not in", values, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdBetween(String value1, String value2) {
            addCriterion("give_definition_id between", value1, value2, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveDefinitionIdNotBetween(String value1, String value2) {
            addCriterion("give_definition_id not between", value1, value2, "giveDefinitionId");
            return (Criteria) this;
        }

        public Criteria andGiveNameIsNull() {
            addCriterion("give_name is null");
            return (Criteria) this;
        }

        public Criteria andGiveNameIsNotNull() {
            addCriterion("give_name is not null");
            return (Criteria) this;
        }

        public Criteria andGiveNameEqualTo(String value) {
            addCriterion("give_name =", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameNotEqualTo(String value) {
            addCriterion("give_name <>", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameGreaterThan(String value) {
            addCriterion("give_name >", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("give_name >=", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameLessThan(String value) {
            addCriterion("give_name <", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameLessThanOrEqualTo(String value) {
            addCriterion("give_name <=", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameLike(String value) {
            addCriterion("give_name like", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameNotLike(String value) {
            addCriterion("give_name not like", value, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameIn(List<String> values) {
            addCriterion("give_name in", values, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameNotIn(List<String> values) {
            addCriterion("give_name not in", values, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameBetween(String value1, String value2) {
            addCriterion("give_name between", value1, value2, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveNameNotBetween(String value1, String value2) {
            addCriterion("give_name not between", value1, value2, "giveName");
            return (Criteria) this;
        }

        public Criteria andGiveTypeIsNull() {
            addCriterion("give_type is null");
            return (Criteria) this;
        }

        public Criteria andGiveTypeIsNotNull() {
            addCriterion("give_type is not null");
            return (Criteria) this;
        }

        public Criteria andGiveTypeEqualTo(String value) {
            addCriterion("give_type =", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeNotEqualTo(String value) {
            addCriterion("give_type <>", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeGreaterThan(String value) {
            addCriterion("give_type >", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("give_type >=", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeLessThan(String value) {
            addCriterion("give_type <", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeLessThanOrEqualTo(String value) {
            addCriterion("give_type <=", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeLike(String value) {
            addCriterion("give_type like", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeNotLike(String value) {
            addCriterion("give_type not like", value, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeIn(List<String> values) {
            addCriterion("give_type in", values, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeNotIn(List<String> values) {
            addCriterion("give_type not in", values, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeBetween(String value1, String value2) {
            addCriterion("give_type between", value1, value2, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveTypeNotBetween(String value1, String value2) {
            addCriterion("give_type not between", value1, value2, "giveType");
            return (Criteria) this;
        }

        public Criteria andGiveContentIsNull() {
            addCriterion("give_content is null");
            return (Criteria) this;
        }

        public Criteria andGiveContentIsNotNull() {
            addCriterion("give_content is not null");
            return (Criteria) this;
        }

        public Criteria andGiveContentEqualTo(String value) {
            addCriterion("give_content =", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotEqualTo(String value) {
            addCriterion("give_content <>", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentGreaterThan(String value) {
            addCriterion("give_content >", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentGreaterThanOrEqualTo(String value) {
            addCriterion("give_content >=", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentLessThan(String value) {
            addCriterion("give_content <", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentLessThanOrEqualTo(String value) {
            addCriterion("give_content <=", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentLike(String value) {
            addCriterion("give_content like", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotLike(String value) {
            addCriterion("give_content not like", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentIn(List<String> values) {
            addCriterion("give_content in", values, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotIn(List<String> values) {
            addCriterion("give_content not in", values, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentBetween(String value1, String value2) {
            addCriterion("give_content between", value1, value2, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotBetween(String value1, String value2) {
            addCriterion("give_content not between", value1, value2, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveIndexIsNull() {
            addCriterion("give_index is null");
            return (Criteria) this;
        }

        public Criteria andGiveIndexIsNotNull() {
            addCriterion("give_index is not null");
            return (Criteria) this;
        }

        public Criteria andGiveIndexEqualTo(String value) {
            addCriterion("give_index =", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexNotEqualTo(String value) {
            addCriterion("give_index <>", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexGreaterThan(String value) {
            addCriterion("give_index >", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexGreaterThanOrEqualTo(String value) {
            addCriterion("give_index >=", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexLessThan(String value) {
            addCriterion("give_index <", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexLessThanOrEqualTo(String value) {
            addCriterion("give_index <=", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexLike(String value) {
            addCriterion("give_index like", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexNotLike(String value) {
            addCriterion("give_index not like", value, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexIn(List<String> values) {
            addCriterion("give_index in", values, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexNotIn(List<String> values) {
            addCriterion("give_index not in", values, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexBetween(String value1, String value2) {
            addCriterion("give_index between", value1, value2, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveIndexNotBetween(String value1, String value2) {
            addCriterion("give_index not between", value1, value2, "giveIndex");
            return (Criteria) this;
        }

        public Criteria andGiveAmountIsNull() {
            addCriterion("give_amount is null");
            return (Criteria) this;
        }

        public Criteria andGiveAmountIsNotNull() {
            addCriterion("give_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGiveAmountEqualTo(Long value) {
            addCriterion("give_amount =", value, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountNotEqualTo(Long value) {
            addCriterion("give_amount <>", value, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountGreaterThan(Long value) {
            addCriterion("give_amount >", value, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("give_amount >=", value, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountLessThan(Long value) {
            addCriterion("give_amount <", value, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountLessThanOrEqualTo(Long value) {
            addCriterion("give_amount <=", value, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountIn(List<Long> values) {
            addCriterion("give_amount in", values, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountNotIn(List<Long> values) {
            addCriterion("give_amount not in", values, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountBetween(Long value1, Long value2) {
            addCriterion("give_amount between", value1, value2, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveAmountNotBetween(Long value1, Long value2) {
            addCriterion("give_amount not between", value1, value2, "giveAmount");
            return (Criteria) this;
        }

        public Criteria andGiveNumIsNull() {
            addCriterion("give_num is null");
            return (Criteria) this;
        }

        public Criteria andGiveNumIsNotNull() {
            addCriterion("give_num is not null");
            return (Criteria) this;
        }

        public Criteria andGiveNumEqualTo(Integer value) {
            addCriterion("give_num =", value, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumNotEqualTo(Integer value) {
            addCriterion("give_num <>", value, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumGreaterThan(Integer value) {
            addCriterion("give_num >", value, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("give_num >=", value, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumLessThan(Integer value) {
            addCriterion("give_num <", value, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumLessThanOrEqualTo(Integer value) {
            addCriterion("give_num <=", value, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumIn(List<Integer> values) {
            addCriterion("give_num in", values, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumNotIn(List<Integer> values) {
            addCriterion("give_num not in", values, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumBetween(Integer value1, Integer value2) {
            addCriterion("give_num between", value1, value2, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveNumNotBetween(Integer value1, Integer value2) {
            addCriterion("give_num not between", value1, value2, "giveNum");
            return (Criteria) this;
        }

        public Criteria andGiveObjIsNull() {
            addCriterion("give_obj is null");
            return (Criteria) this;
        }

        public Criteria andGiveObjIsNotNull() {
            addCriterion("give_obj is not null");
            return (Criteria) this;
        }

        public Criteria andGiveObjEqualTo(String value) {
            addCriterion("give_obj =", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjNotEqualTo(String value) {
            addCriterion("give_obj <>", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjGreaterThan(String value) {
            addCriterion("give_obj >", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjGreaterThanOrEqualTo(String value) {
            addCriterion("give_obj >=", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjLessThan(String value) {
            addCriterion("give_obj <", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjLessThanOrEqualTo(String value) {
            addCriterion("give_obj <=", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjLike(String value) {
            addCriterion("give_obj like", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjNotLike(String value) {
            addCriterion("give_obj not like", value, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjIn(List<String> values) {
            addCriterion("give_obj in", values, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjNotIn(List<String> values) {
            addCriterion("give_obj not in", values, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjBetween(String value1, String value2) {
            addCriterion("give_obj between", value1, value2, "giveObj");
            return (Criteria) this;
        }

        public Criteria andGiveObjNotBetween(String value1, String value2) {
            addCriterion("give_obj not between", value1, value2, "giveObj");
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

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
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