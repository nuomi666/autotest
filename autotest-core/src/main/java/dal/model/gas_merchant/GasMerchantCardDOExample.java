package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasMerchantCardDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasMerchantCardDOExample() {
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

        public Criteria andCardObjectIdIsNull() {
            addCriterion("card_object_id is null");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdIsNotNull() {
            addCriterion("card_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdEqualTo(String value) {
            addCriterion("card_object_id =", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdNotEqualTo(String value) {
            addCriterion("card_object_id <>", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdGreaterThan(String value) {
            addCriterion("card_object_id >", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_object_id >=", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdLessThan(String value) {
            addCriterion("card_object_id <", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdLessThanOrEqualTo(String value) {
            addCriterion("card_object_id <=", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdLike(String value) {
            addCriterion("card_object_id like", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdNotLike(String value) {
            addCriterion("card_object_id not like", value, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdIn(List<String> values) {
            addCriterion("card_object_id in", values, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdNotIn(List<String> values) {
            addCriterion("card_object_id not in", values, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdBetween(String value1, String value2) {
            addCriterion("card_object_id between", value1, value2, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardObjectIdNotBetween(String value1, String value2) {
            addCriterion("card_object_id not between", value1, value2, "cardObjectId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andParentCardNoIsNull() {
            addCriterion("parent_card_no is null");
            return (Criteria) this;
        }

        public Criteria andParentCardNoIsNotNull() {
            addCriterion("parent_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andParentCardNoEqualTo(String value) {
            addCriterion("parent_card_no =", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoNotEqualTo(String value) {
            addCriterion("parent_card_no <>", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoGreaterThan(String value) {
            addCriterion("parent_card_no >", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("parent_card_no >=", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoLessThan(String value) {
            addCriterion("parent_card_no <", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoLessThanOrEqualTo(String value) {
            addCriterion("parent_card_no <=", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoLike(String value) {
            addCriterion("parent_card_no like", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoNotLike(String value) {
            addCriterion("parent_card_no not like", value, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoIn(List<String> values) {
            addCriterion("parent_card_no in", values, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoNotIn(List<String> values) {
            addCriterion("parent_card_no not in", values, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoBetween(String value1, String value2) {
            addCriterion("parent_card_no between", value1, value2, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andParentCardNoNotBetween(String value1, String value2) {
            addCriterion("parent_card_no not between", value1, value2, "parentCardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoIsNull() {
            addCriterion("internal_no is null");
            return (Criteria) this;
        }

        public Criteria andInternalNoIsNotNull() {
            addCriterion("internal_no is not null");
            return (Criteria) this;
        }

        public Criteria andInternalNoEqualTo(String value) {
            addCriterion("internal_no =", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoNotEqualTo(String value) {
            addCriterion("internal_no <>", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoGreaterThan(String value) {
            addCriterion("internal_no >", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoGreaterThanOrEqualTo(String value) {
            addCriterion("internal_no >=", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoLessThan(String value) {
            addCriterion("internal_no <", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoLessThanOrEqualTo(String value) {
            addCriterion("internal_no <=", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoLike(String value) {
            addCriterion("internal_no like", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoNotLike(String value) {
            addCriterion("internal_no not like", value, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoIn(List<String> values) {
            addCriterion("internal_no in", values, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoNotIn(List<String> values) {
            addCriterion("internal_no not in", values, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoBetween(String value1, String value2) {
            addCriterion("internal_no between", value1, value2, "internalNo");
            return (Criteria) this;
        }

        public Criteria andInternalNoNotBetween(String value1, String value2) {
            addCriterion("internal_no not between", value1, value2, "internalNo");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdIsNull() {
            addCriterion("card_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdIsNotNull() {
            addCriterion("card_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdEqualTo(Long value) {
            addCriterion("card_rule_id =", value, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdNotEqualTo(Long value) {
            addCriterion("card_rule_id <>", value, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdGreaterThan(Long value) {
            addCriterion("card_rule_id >", value, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("card_rule_id >=", value, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdLessThan(Long value) {
            addCriterion("card_rule_id <", value, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("card_rule_id <=", value, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdIn(List<Long> values) {
            addCriterion("card_rule_id in", values, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdNotIn(List<Long> values) {
            addCriterion("card_rule_id not in", values, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdBetween(Long value1, Long value2) {
            addCriterion("card_rule_id between", value1, value2, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andCardRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("card_rule_id not between", value1, value2, "cardRuleId");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountIsNull() {
            addCriterion("operator_account is null");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountIsNotNull() {
            addCriterion("operator_account is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountEqualTo(String value) {
            addCriterion("operator_account =", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNotEqualTo(String value) {
            addCriterion("operator_account <>", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountGreaterThan(String value) {
            addCriterion("operator_account >", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("operator_account >=", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountLessThan(String value) {
            addCriterion("operator_account <", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountLessThanOrEqualTo(String value) {
            addCriterion("operator_account <=", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountLike(String value) {
            addCriterion("operator_account like", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNotLike(String value) {
            addCriterion("operator_account not like", value, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountIn(List<String> values) {
            addCriterion("operator_account in", values, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNotIn(List<String> values) {
            addCriterion("operator_account not in", values, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountBetween(String value1, String value2) {
            addCriterion("operator_account between", value1, value2, "operatorAccount");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNotBetween(String value1, String value2) {
            addCriterion("operator_account not between", value1, value2, "operatorAccount");
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