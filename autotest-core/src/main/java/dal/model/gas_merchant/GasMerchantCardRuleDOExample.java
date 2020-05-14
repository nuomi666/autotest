package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasMerchantCardRuleDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasMerchantCardRuleDOExample() {
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

        public Criteria andRangeStartIsNull() {
            addCriterion("range_start is null");
            return (Criteria) this;
        }

        public Criteria andRangeStartIsNotNull() {
            addCriterion("range_start is not null");
            return (Criteria) this;
        }

        public Criteria andRangeStartEqualTo(Integer value) {
            addCriterion("range_start =", value, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartNotEqualTo(Integer value) {
            addCriterion("range_start <>", value, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartGreaterThan(Integer value) {
            addCriterion("range_start >", value, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("range_start >=", value, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartLessThan(Integer value) {
            addCriterion("range_start <", value, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartLessThanOrEqualTo(Integer value) {
            addCriterion("range_start <=", value, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartIn(List<Integer> values) {
            addCriterion("range_start in", values, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartNotIn(List<Integer> values) {
            addCriterion("range_start not in", values, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartBetween(Integer value1, Integer value2) {
            addCriterion("range_start between", value1, value2, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeStartNotBetween(Integer value1, Integer value2) {
            addCriterion("range_start not between", value1, value2, "rangeStart");
            return (Criteria) this;
        }

        public Criteria andRangeEndIsNull() {
            addCriterion("range_end is null");
            return (Criteria) this;
        }

        public Criteria andRangeEndIsNotNull() {
            addCriterion("range_end is not null");
            return (Criteria) this;
        }

        public Criteria andRangeEndEqualTo(Integer value) {
            addCriterion("range_end =", value, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndNotEqualTo(Integer value) {
            addCriterion("range_end <>", value, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndGreaterThan(Integer value) {
            addCriterion("range_end >", value, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("range_end >=", value, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndLessThan(Integer value) {
            addCriterion("range_end <", value, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndLessThanOrEqualTo(Integer value) {
            addCriterion("range_end <=", value, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndIn(List<Integer> values) {
            addCriterion("range_end in", values, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndNotIn(List<Integer> values) {
            addCriterion("range_end not in", values, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndBetween(Integer value1, Integer value2) {
            addCriterion("range_end between", value1, value2, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andRangeEndNotBetween(Integer value1, Integer value2) {
            addCriterion("range_end not between", value1, value2, "rangeEnd");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoIsNull() {
            addCriterion("exclude_card_no is null");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoIsNotNull() {
            addCriterion("exclude_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoEqualTo(String value) {
            addCriterion("exclude_card_no =", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoNotEqualTo(String value) {
            addCriterion("exclude_card_no <>", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoGreaterThan(String value) {
            addCriterion("exclude_card_no >", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("exclude_card_no >=", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoLessThan(String value) {
            addCriterion("exclude_card_no <", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoLessThanOrEqualTo(String value) {
            addCriterion("exclude_card_no <=", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoLike(String value) {
            addCriterion("exclude_card_no like", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoNotLike(String value) {
            addCriterion("exclude_card_no not like", value, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoIn(List<String> values) {
            addCriterion("exclude_card_no in", values, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoNotIn(List<String> values) {
            addCriterion("exclude_card_no not in", values, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoBetween(String value1, String value2) {
            addCriterion("exclude_card_no between", value1, value2, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeCardNoNotBetween(String value1, String value2) {
            addCriterion("exclude_card_no not between", value1, value2, "excludeCardNo");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberIsNull() {
            addCriterion("exclude_number is null");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberIsNotNull() {
            addCriterion("exclude_number is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberEqualTo(String value) {
            addCriterion("exclude_number =", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberNotEqualTo(String value) {
            addCriterion("exclude_number <>", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberGreaterThan(String value) {
            addCriterion("exclude_number >", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("exclude_number >=", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberLessThan(String value) {
            addCriterion("exclude_number <", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberLessThanOrEqualTo(String value) {
            addCriterion("exclude_number <=", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberLike(String value) {
            addCriterion("exclude_number like", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberNotLike(String value) {
            addCriterion("exclude_number not like", value, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberIn(List<String> values) {
            addCriterion("exclude_number in", values, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberNotIn(List<String> values) {
            addCriterion("exclude_number not in", values, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberBetween(String value1, String value2) {
            addCriterion("exclude_number between", value1, value2, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andExcludeNumberNotBetween(String value1, String value2) {
            addCriterion("exclude_number not between", value1, value2, "excludeNumber");
            return (Criteria) this;
        }

        public Criteria andValidCountIsNull() {
            addCriterion("valid_count is null");
            return (Criteria) this;
        }

        public Criteria andValidCountIsNotNull() {
            addCriterion("valid_count is not null");
            return (Criteria) this;
        }

        public Criteria andValidCountEqualTo(Integer value) {
            addCriterion("valid_count =", value, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountNotEqualTo(Integer value) {
            addCriterion("valid_count <>", value, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountGreaterThan(Integer value) {
            addCriterion("valid_count >", value, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("valid_count >=", value, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountLessThan(Integer value) {
            addCriterion("valid_count <", value, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountLessThanOrEqualTo(Integer value) {
            addCriterion("valid_count <=", value, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountIn(List<Integer> values) {
            addCriterion("valid_count in", values, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountNotIn(List<Integer> values) {
            addCriterion("valid_count not in", values, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountBetween(Integer value1, Integer value2) {
            addCriterion("valid_count between", value1, value2, "validCount");
            return (Criteria) this;
        }

        public Criteria andValidCountNotBetween(Integer value1, Integer value2) {
            addCriterion("valid_count not between", value1, value2, "validCount");
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