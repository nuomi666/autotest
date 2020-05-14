package dal.model.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantSettlementDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantSettlementDOExample() {
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

        public Criteria andPartnerAbbrNameIsNull() {
            addCriterion("partner_abbr_name is null");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameIsNotNull() {
            addCriterion("partner_abbr_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameEqualTo(String value) {
            addCriterion("partner_abbr_name =", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameNotEqualTo(String value) {
            addCriterion("partner_abbr_name <>", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameGreaterThan(String value) {
            addCriterion("partner_abbr_name >", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameGreaterThanOrEqualTo(String value) {
            addCriterion("partner_abbr_name >=", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameLessThan(String value) {
            addCriterion("partner_abbr_name <", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameLessThanOrEqualTo(String value) {
            addCriterion("partner_abbr_name <=", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameLike(String value) {
            addCriterion("partner_abbr_name like", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameNotLike(String value) {
            addCriterion("partner_abbr_name not like", value, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameIn(List<String> values) {
            addCriterion("partner_abbr_name in", values, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameNotIn(List<String> values) {
            addCriterion("partner_abbr_name not in", values, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameBetween(String value1, String value2) {
            addCriterion("partner_abbr_name between", value1, value2, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andPartnerAbbrNameNotBetween(String value1, String value2) {
            addCriterion("partner_abbr_name not between", value1, value2, "partnerAbbrName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeIsNull() {
            addCriterion("settlement_account_type is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeIsNotNull() {
            addCriterion("settlement_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeEqualTo(String value) {
            addCriterion("settlement_account_type =", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeNotEqualTo(String value) {
            addCriterion("settlement_account_type <>", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeGreaterThan(String value) {
            addCriterion("settlement_account_type >", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account_type >=", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeLessThan(String value) {
            addCriterion("settlement_account_type <", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("settlement_account_type <=", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeLike(String value) {
            addCriterion("settlement_account_type like", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeNotLike(String value) {
            addCriterion("settlement_account_type not like", value, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeIn(List<String> values) {
            addCriterion("settlement_account_type in", values, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeNotIn(List<String> values) {
            addCriterion("settlement_account_type not in", values, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeBetween(String value1, String value2) {
            addCriterion("settlement_account_type between", value1, value2, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountTypeNotBetween(String value1, String value2) {
            addCriterion("settlement_account_type not between", value1, value2, "settlementAccountType");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameIsNull() {
            addCriterion("settlement_account_name is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameIsNotNull() {
            addCriterion("settlement_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameEqualTo(String value) {
            addCriterion("settlement_account_name =", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameNotEqualTo(String value) {
            addCriterion("settlement_account_name <>", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameGreaterThan(String value) {
            addCriterion("settlement_account_name >", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account_name >=", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameLessThan(String value) {
            addCriterion("settlement_account_name <", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameLessThanOrEqualTo(String value) {
            addCriterion("settlement_account_name <=", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameLike(String value) {
            addCriterion("settlement_account_name like", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameNotLike(String value) {
            addCriterion("settlement_account_name not like", value, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameIn(List<String> values) {
            addCriterion("settlement_account_name in", values, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameNotIn(List<String> values) {
            addCriterion("settlement_account_name not in", values, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameBetween(String value1, String value2) {
            addCriterion("settlement_account_name between", value1, value2, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNameNotBetween(String value1, String value2) {
            addCriterion("settlement_account_name not between", value1, value2, "settlementAccountName");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountIsNull() {
            addCriterion("settlement_account is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountIsNotNull() {
            addCriterion("settlement_account is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountEqualTo(String value) {
            addCriterion("settlement_account =", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotEqualTo(String value) {
            addCriterion("settlement_account <>", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountGreaterThan(String value) {
            addCriterion("settlement_account >", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account >=", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountLessThan(String value) {
            addCriterion("settlement_account <", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountLessThanOrEqualTo(String value) {
            addCriterion("settlement_account <=", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountLike(String value) {
            addCriterion("settlement_account like", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotLike(String value) {
            addCriterion("settlement_account not like", value, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountIn(List<String> values) {
            addCriterion("settlement_account in", values, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotIn(List<String> values) {
            addCriterion("settlement_account not in", values, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBetween(String value1, String value2) {
            addCriterion("settlement_account between", value1, value2, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountNotBetween(String value1, String value2) {
            addCriterion("settlement_account not between", value1, value2, "settlementAccount");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankIsNull() {
            addCriterion("settlement_account_bank is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankIsNotNull() {
            addCriterion("settlement_account_bank is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankEqualTo(String value) {
            addCriterion("settlement_account_bank =", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankNotEqualTo(String value) {
            addCriterion("settlement_account_bank <>", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankGreaterThan(String value) {
            addCriterion("settlement_account_bank >", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account_bank >=", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankLessThan(String value) {
            addCriterion("settlement_account_bank <", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankLessThanOrEqualTo(String value) {
            addCriterion("settlement_account_bank <=", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankLike(String value) {
            addCriterion("settlement_account_bank like", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankNotLike(String value) {
            addCriterion("settlement_account_bank not like", value, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankIn(List<String> values) {
            addCriterion("settlement_account_bank in", values, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankNotIn(List<String> values) {
            addCriterion("settlement_account_bank not in", values, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankBetween(String value1, String value2) {
            addCriterion("settlement_account_bank between", value1, value2, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankNotBetween(String value1, String value2) {
            addCriterion("settlement_account_bank not between", value1, value2, "settlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeIsNull() {
            addCriterion("settlement_account_bank_code is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeIsNotNull() {
            addCriterion("settlement_account_bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeEqualTo(String value) {
            addCriterion("settlement_account_bank_code =", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeNotEqualTo(String value) {
            addCriterion("settlement_account_bank_code <>", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeGreaterThan(String value) {
            addCriterion("settlement_account_bank_code >", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account_bank_code >=", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeLessThan(String value) {
            addCriterion("settlement_account_bank_code <", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeLessThanOrEqualTo(String value) {
            addCriterion("settlement_account_bank_code <=", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeLike(String value) {
            addCriterion("settlement_account_bank_code like", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeNotLike(String value) {
            addCriterion("settlement_account_bank_code not like", value, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeIn(List<String> values) {
            addCriterion("settlement_account_bank_code in", values, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeNotIn(List<String> values) {
            addCriterion("settlement_account_bank_code not in", values, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeBetween(String value1, String value2) {
            addCriterion("settlement_account_bank_code between", value1, value2, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountBankCodeNotBetween(String value1, String value2) {
            addCriterion("settlement_account_bank_code not between", value1, value2, "settlementAccountBankCode");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankIsNull() {
            addCriterion("settlement_account_sub_bank is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankIsNotNull() {
            addCriterion("settlement_account_sub_bank is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankEqualTo(String value) {
            addCriterion("settlement_account_sub_bank =", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNotEqualTo(String value) {
            addCriterion("settlement_account_sub_bank <>", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankGreaterThan(String value) {
            addCriterion("settlement_account_sub_bank >", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account_sub_bank >=", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankLessThan(String value) {
            addCriterion("settlement_account_sub_bank <", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankLessThanOrEqualTo(String value) {
            addCriterion("settlement_account_sub_bank <=", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankLike(String value) {
            addCriterion("settlement_account_sub_bank like", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNotLike(String value) {
            addCriterion("settlement_account_sub_bank not like", value, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankIn(List<String> values) {
            addCriterion("settlement_account_sub_bank in", values, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNotIn(List<String> values) {
            addCriterion("settlement_account_sub_bank not in", values, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankBetween(String value1, String value2) {
            addCriterion("settlement_account_sub_bank between", value1, value2, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNotBetween(String value1, String value2) {
            addCriterion("settlement_account_sub_bank not between", value1, value2, "settlementAccountSubBank");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoIsNull() {
            addCriterion("settlement_account_sub_bank_no is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoIsNotNull() {
            addCriterion("settlement_account_sub_bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoEqualTo(String value) {
            addCriterion("settlement_account_sub_bank_no =", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoNotEqualTo(String value) {
            addCriterion("settlement_account_sub_bank_no <>", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoGreaterThan(String value) {
            addCriterion("settlement_account_sub_bank_no >", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_account_sub_bank_no >=", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoLessThan(String value) {
            addCriterion("settlement_account_sub_bank_no <", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoLessThanOrEqualTo(String value) {
            addCriterion("settlement_account_sub_bank_no <=", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoLike(String value) {
            addCriterion("settlement_account_sub_bank_no like", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoNotLike(String value) {
            addCriterion("settlement_account_sub_bank_no not like", value, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoIn(List<String> values) {
            addCriterion("settlement_account_sub_bank_no in", values, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoNotIn(List<String> values) {
            addCriterion("settlement_account_sub_bank_no not in", values, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoBetween(String value1, String value2) {
            addCriterion("settlement_account_sub_bank_no between", value1, value2, "settlementAccountSubBankNo");
            return (Criteria) this;
        }

        public Criteria andSettlementAccountSubBankNoNotBetween(String value1, String value2) {
            addCriterion("settlement_account_sub_bank_no not between", value1, value2, "settlementAccountSubBankNo");
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