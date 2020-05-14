package dal.model.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantInfoDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantInfoDOExample() {
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

        public Criteria andIndustryLineIsNull() {
            addCriterion("industry_line is null");
            return (Criteria) this;
        }

        public Criteria andIndustryLineIsNotNull() {
            addCriterion("industry_line is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryLineEqualTo(String value) {
            addCriterion("industry_line =", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineNotEqualTo(String value) {
            addCriterion("industry_line <>", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineGreaterThan(String value) {
            addCriterion("industry_line >", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineGreaterThanOrEqualTo(String value) {
            addCriterion("industry_line >=", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineLessThan(String value) {
            addCriterion("industry_line <", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineLessThanOrEqualTo(String value) {
            addCriterion("industry_line <=", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineLike(String value) {
            addCriterion("industry_line like", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineNotLike(String value) {
            addCriterion("industry_line not like", value, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineIn(List<String> values) {
            addCriterion("industry_line in", values, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineNotIn(List<String> values) {
            addCriterion("industry_line not in", values, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineBetween(String value1, String value2) {
            addCriterion("industry_line between", value1, value2, "industryLine");
            return (Criteria) this;
        }

        public Criteria andIndustryLineNotBetween(String value1, String value2) {
            addCriterion("industry_line not between", value1, value2, "industryLine");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdIsNull() {
            addCriterion("out_partner_id is null");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdIsNotNull() {
            addCriterion("out_partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdEqualTo(String value) {
            addCriterion("out_partner_id =", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdNotEqualTo(String value) {
            addCriterion("out_partner_id <>", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdGreaterThan(String value) {
            addCriterion("out_partner_id >", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_partner_id >=", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdLessThan(String value) {
            addCriterion("out_partner_id <", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("out_partner_id <=", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdLike(String value) {
            addCriterion("out_partner_id like", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdNotLike(String value) {
            addCriterion("out_partner_id not like", value, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdIn(List<String> values) {
            addCriterion("out_partner_id in", values, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdNotIn(List<String> values) {
            addCriterion("out_partner_id not in", values, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdBetween(String value1, String value2) {
            addCriterion("out_partner_id between", value1, value2, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andOutPartnerIdNotBetween(String value1, String value2) {
            addCriterion("out_partner_id not between", value1, value2, "outPartnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIsNull() {
            addCriterion("partner_name is null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIsNotNull() {
            addCriterion("partner_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameEqualTo(String value) {
            addCriterion("partner_name =", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotEqualTo(String value) {
            addCriterion("partner_name <>", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThan(String value) {
            addCriterion("partner_name >", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("partner_name >=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThan(String value) {
            addCriterion("partner_name <", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThanOrEqualTo(String value) {
            addCriterion("partner_name <=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLike(String value) {
            addCriterion("partner_name like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotLike(String value) {
            addCriterion("partner_name not like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIn(List<String> values) {
            addCriterion("partner_name in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotIn(List<String> values) {
            addCriterion("partner_name not in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameBetween(String value1, String value2) {
            addCriterion("partner_name between", value1, value2, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotBetween(String value1, String value2) {
            addCriterion("partner_name not between", value1, value2, "partnerName");
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

        public Criteria andPartnerRegisterAddressIsNull() {
            addCriterion("partner_register_address is null");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressIsNotNull() {
            addCriterion("partner_register_address is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressEqualTo(String value) {
            addCriterion("partner_register_address =", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressNotEqualTo(String value) {
            addCriterion("partner_register_address <>", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressGreaterThan(String value) {
            addCriterion("partner_register_address >", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressGreaterThanOrEqualTo(String value) {
            addCriterion("partner_register_address >=", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressLessThan(String value) {
            addCriterion("partner_register_address <", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressLessThanOrEqualTo(String value) {
            addCriterion("partner_register_address <=", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressLike(String value) {
            addCriterion("partner_register_address like", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressNotLike(String value) {
            addCriterion("partner_register_address not like", value, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressIn(List<String> values) {
            addCriterion("partner_register_address in", values, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressNotIn(List<String> values) {
            addCriterion("partner_register_address not in", values, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressBetween(String value1, String value2) {
            addCriterion("partner_register_address between", value1, value2, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andPartnerRegisterAddressNotBetween(String value1, String value2) {
            addCriterion("partner_register_address not between", value1, value2, "partnerRegisterAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterFromIsNull() {
            addCriterion("register_from is null");
            return (Criteria) this;
        }

        public Criteria andRegisterFromIsNotNull() {
            addCriterion("register_from is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterFromEqualTo(String value) {
            addCriterion("register_from =", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromNotEqualTo(String value) {
            addCriterion("register_from <>", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromGreaterThan(String value) {
            addCriterion("register_from >", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromGreaterThanOrEqualTo(String value) {
            addCriterion("register_from >=", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromLessThan(String value) {
            addCriterion("register_from <", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromLessThanOrEqualTo(String value) {
            addCriterion("register_from <=", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromLike(String value) {
            addCriterion("register_from like", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromNotLike(String value) {
            addCriterion("register_from not like", value, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromIn(List<String> values) {
            addCriterion("register_from in", values, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromNotIn(List<String> values) {
            addCriterion("register_from not in", values, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromBetween(String value1, String value2) {
            addCriterion("register_from between", value1, value2, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andRegisterFromNotBetween(String value1, String value2) {
            addCriterion("register_from not between", value1, value2, "registerFrom");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeIsNull() {
            addCriterion("partner_type is null");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeIsNotNull() {
            addCriterion("partner_type is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeEqualTo(String value) {
            addCriterion("partner_type =", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotEqualTo(String value) {
            addCriterion("partner_type <>", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeGreaterThan(String value) {
            addCriterion("partner_type >", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("partner_type >=", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeLessThan(String value) {
            addCriterion("partner_type <", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeLessThanOrEqualTo(String value) {
            addCriterion("partner_type <=", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeLike(String value) {
            addCriterion("partner_type like", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotLike(String value) {
            addCriterion("partner_type not like", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeIn(List<String> values) {
            addCriterion("partner_type in", values, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotIn(List<String> values) {
            addCriterion("partner_type not in", values, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeBetween(String value1, String value2) {
            addCriterion("partner_type between", value1, value2, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotBetween(String value1, String value2) {
            addCriterion("partner_type not between", value1, value2, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusIsNull() {
            addCriterion("partner_status is null");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusIsNotNull() {
            addCriterion("partner_status is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusEqualTo(String value) {
            addCriterion("partner_status =", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusNotEqualTo(String value) {
            addCriterion("partner_status <>", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusGreaterThan(String value) {
            addCriterion("partner_status >", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("partner_status >=", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusLessThan(String value) {
            addCriterion("partner_status <", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusLessThanOrEqualTo(String value) {
            addCriterion("partner_status <=", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusLike(String value) {
            addCriterion("partner_status like", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusNotLike(String value) {
            addCriterion("partner_status not like", value, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusIn(List<String> values) {
            addCriterion("partner_status in", values, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusNotIn(List<String> values) {
            addCriterion("partner_status not in", values, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusBetween(String value1, String value2) {
            addCriterion("partner_status between", value1, value2, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andPartnerStatusNotBetween(String value1, String value2) {
            addCriterion("partner_status not between", value1, value2, "partnerStatus");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeIsNull() {
            addCriterion("security_code is null");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeIsNotNull() {
            addCriterion("security_code is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeEqualTo(String value) {
            addCriterion("security_code =", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeNotEqualTo(String value) {
            addCriterion("security_code <>", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeGreaterThan(String value) {
            addCriterion("security_code >", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("security_code >=", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeLessThan(String value) {
            addCriterion("security_code <", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeLessThanOrEqualTo(String value) {
            addCriterion("security_code <=", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeLike(String value) {
            addCriterion("security_code like", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeNotLike(String value) {
            addCriterion("security_code not like", value, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeIn(List<String> values) {
            addCriterion("security_code in", values, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeNotIn(List<String> values) {
            addCriterion("security_code not in", values, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeBetween(String value1, String value2) {
            addCriterion("security_code between", value1, value2, "securityCode");
            return (Criteria) this;
        }

        public Criteria andSecurityCodeNotBetween(String value1, String value2) {
            addCriterion("security_code not between", value1, value2, "securityCode");
            return (Criteria) this;
        }

        public Criteria andDigestTypeIsNull() {
            addCriterion("digest_type is null");
            return (Criteria) this;
        }

        public Criteria andDigestTypeIsNotNull() {
            addCriterion("digest_type is not null");
            return (Criteria) this;
        }

        public Criteria andDigestTypeEqualTo(String value) {
            addCriterion("digest_type =", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeNotEqualTo(String value) {
            addCriterion("digest_type <>", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeGreaterThan(String value) {
            addCriterion("digest_type >", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("digest_type >=", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeLessThan(String value) {
            addCriterion("digest_type <", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeLessThanOrEqualTo(String value) {
            addCriterion("digest_type <=", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeLike(String value) {
            addCriterion("digest_type like", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeNotLike(String value) {
            addCriterion("digest_type not like", value, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeIn(List<String> values) {
            addCriterion("digest_type in", values, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeNotIn(List<String> values) {
            addCriterion("digest_type not in", values, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeBetween(String value1, String value2) {
            addCriterion("digest_type between", value1, value2, "digestType");
            return (Criteria) this;
        }

        public Criteria andDigestTypeNotBetween(String value1, String value2) {
            addCriterion("digest_type not between", value1, value2, "digestType");
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