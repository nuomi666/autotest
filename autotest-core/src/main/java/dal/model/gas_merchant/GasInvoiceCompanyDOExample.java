package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasInvoiceCompanyDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasInvoiceCompanyDOExample() {
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

        public Criteria andTaxCompanyIsNull() {
            addCriterion("tax_company is null");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyIsNotNull() {
            addCriterion("tax_company is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyEqualTo(String value) {
            addCriterion("tax_company =", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyNotEqualTo(String value) {
            addCriterion("tax_company <>", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyGreaterThan(String value) {
            addCriterion("tax_company >", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("tax_company >=", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyLessThan(String value) {
            addCriterion("tax_company <", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyLessThanOrEqualTo(String value) {
            addCriterion("tax_company <=", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyLike(String value) {
            addCriterion("tax_company like", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyNotLike(String value) {
            addCriterion("tax_company not like", value, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyIn(List<String> values) {
            addCriterion("tax_company in", values, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyNotIn(List<String> values) {
            addCriterion("tax_company not in", values, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyBetween(String value1, String value2) {
            addCriterion("tax_company between", value1, value2, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCompanyNotBetween(String value1, String value2) {
            addCriterion("tax_company not between", value1, value2, "taxCompany");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIsNull() {
            addCriterion("tax_code is null");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIsNotNull() {
            addCriterion("tax_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCodeEqualTo(String value) {
            addCriterion("tax_code =", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotEqualTo(String value) {
            addCriterion("tax_code <>", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeGreaterThan(String value) {
            addCriterion("tax_code >", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tax_code >=", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLessThan(String value) {
            addCriterion("tax_code <", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLessThanOrEqualTo(String value) {
            addCriterion("tax_code <=", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLike(String value) {
            addCriterion("tax_code like", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotLike(String value) {
            addCriterion("tax_code not like", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIn(List<String> values) {
            addCriterion("tax_code in", values, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotIn(List<String> values) {
            addCriterion("tax_code not in", values, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeBetween(String value1, String value2) {
            addCriterion("tax_code between", value1, value2, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotBetween(String value1, String value2) {
            addCriterion("tax_code not between", value1, value2, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxAddressIsNull() {
            addCriterion("tax_address is null");
            return (Criteria) this;
        }

        public Criteria andTaxAddressIsNotNull() {
            addCriterion("tax_address is not null");
            return (Criteria) this;
        }

        public Criteria andTaxAddressEqualTo(String value) {
            addCriterion("tax_address =", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressNotEqualTo(String value) {
            addCriterion("tax_address <>", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressGreaterThan(String value) {
            addCriterion("tax_address >", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressGreaterThanOrEqualTo(String value) {
            addCriterion("tax_address >=", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressLessThan(String value) {
            addCriterion("tax_address <", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressLessThanOrEqualTo(String value) {
            addCriterion("tax_address <=", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressLike(String value) {
            addCriterion("tax_address like", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressNotLike(String value) {
            addCriterion("tax_address not like", value, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressIn(List<String> values) {
            addCriterion("tax_address in", values, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressNotIn(List<String> values) {
            addCriterion("tax_address not in", values, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressBetween(String value1, String value2) {
            addCriterion("tax_address between", value1, value2, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxAddressNotBetween(String value1, String value2) {
            addCriterion("tax_address not between", value1, value2, "taxAddress");
            return (Criteria) this;
        }

        public Criteria andTaxMobileIsNull() {
            addCriterion("tax_mobile is null");
            return (Criteria) this;
        }

        public Criteria andTaxMobileIsNotNull() {
            addCriterion("tax_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andTaxMobileEqualTo(String value) {
            addCriterion("tax_mobile =", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileNotEqualTo(String value) {
            addCriterion("tax_mobile <>", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileGreaterThan(String value) {
            addCriterion("tax_mobile >", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileGreaterThanOrEqualTo(String value) {
            addCriterion("tax_mobile >=", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileLessThan(String value) {
            addCriterion("tax_mobile <", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileLessThanOrEqualTo(String value) {
            addCriterion("tax_mobile <=", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileLike(String value) {
            addCriterion("tax_mobile like", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileNotLike(String value) {
            addCriterion("tax_mobile not like", value, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileIn(List<String> values) {
            addCriterion("tax_mobile in", values, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileNotIn(List<String> values) {
            addCriterion("tax_mobile not in", values, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileBetween(String value1, String value2) {
            addCriterion("tax_mobile between", value1, value2, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxMobileNotBetween(String value1, String value2) {
            addCriterion("tax_mobile not between", value1, value2, "taxMobile");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerIsNull() {
            addCriterion("tax_drawer is null");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerIsNotNull() {
            addCriterion("tax_drawer is not null");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerEqualTo(String value) {
            addCriterion("tax_drawer =", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerNotEqualTo(String value) {
            addCriterion("tax_drawer <>", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerGreaterThan(String value) {
            addCriterion("tax_drawer >", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerGreaterThanOrEqualTo(String value) {
            addCriterion("tax_drawer >=", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerLessThan(String value) {
            addCriterion("tax_drawer <", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerLessThanOrEqualTo(String value) {
            addCriterion("tax_drawer <=", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerLike(String value) {
            addCriterion("tax_drawer like", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerNotLike(String value) {
            addCriterion("tax_drawer not like", value, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerIn(List<String> values) {
            addCriterion("tax_drawer in", values, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerNotIn(List<String> values) {
            addCriterion("tax_drawer not in", values, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerBetween(String value1, String value2) {
            addCriterion("tax_drawer between", value1, value2, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxDrawerNotBetween(String value1, String value2) {
            addCriterion("tax_drawer not between", value1, value2, "taxDrawer");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoIsNull() {
            addCriterion("tax_bank_no is null");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoIsNotNull() {
            addCriterion("tax_bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoEqualTo(String value) {
            addCriterion("tax_bank_no =", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoNotEqualTo(String value) {
            addCriterion("tax_bank_no <>", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoGreaterThan(String value) {
            addCriterion("tax_bank_no >", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("tax_bank_no >=", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoLessThan(String value) {
            addCriterion("tax_bank_no <", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoLessThanOrEqualTo(String value) {
            addCriterion("tax_bank_no <=", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoLike(String value) {
            addCriterion("tax_bank_no like", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoNotLike(String value) {
            addCriterion("tax_bank_no not like", value, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoIn(List<String> values) {
            addCriterion("tax_bank_no in", values, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoNotIn(List<String> values) {
            addCriterion("tax_bank_no not in", values, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoBetween(String value1, String value2) {
            addCriterion("tax_bank_no between", value1, value2, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxBankNoNotBetween(String value1, String value2) {
            addCriterion("tax_bank_no not between", value1, value2, "taxBankNo");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerIsNull() {
            addCriterion("tax_reviewer is null");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerIsNotNull() {
            addCriterion("tax_reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerEqualTo(String value) {
            addCriterion("tax_reviewer =", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerNotEqualTo(String value) {
            addCriterion("tax_reviewer <>", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerGreaterThan(String value) {
            addCriterion("tax_reviewer >", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("tax_reviewer >=", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerLessThan(String value) {
            addCriterion("tax_reviewer <", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerLessThanOrEqualTo(String value) {
            addCriterion("tax_reviewer <=", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerLike(String value) {
            addCriterion("tax_reviewer like", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerNotLike(String value) {
            addCriterion("tax_reviewer not like", value, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerIn(List<String> values) {
            addCriterion("tax_reviewer in", values, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerNotIn(List<String> values) {
            addCriterion("tax_reviewer not in", values, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerBetween(String value1, String value2) {
            addCriterion("tax_reviewer between", value1, value2, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxReviewerNotBetween(String value1, String value2) {
            addCriterion("tax_reviewer not between", value1, value2, "taxReviewer");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeIsNull() {
            addCriterion("tax_payee is null");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeIsNotNull() {
            addCriterion("tax_payee is not null");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeEqualTo(String value) {
            addCriterion("tax_payee =", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeNotEqualTo(String value) {
            addCriterion("tax_payee <>", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeGreaterThan(String value) {
            addCriterion("tax_payee >", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("tax_payee >=", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeLessThan(String value) {
            addCriterion("tax_payee <", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeLessThanOrEqualTo(String value) {
            addCriterion("tax_payee <=", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeLike(String value) {
            addCriterion("tax_payee like", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeNotLike(String value) {
            addCriterion("tax_payee not like", value, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeIn(List<String> values) {
            addCriterion("tax_payee in", values, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeNotIn(List<String> values) {
            addCriterion("tax_payee not in", values, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeBetween(String value1, String value2) {
            addCriterion("tax_payee between", value1, value2, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxPayeeNotBetween(String value1, String value2) {
            addCriterion("tax_payee not between", value1, value2, "taxPayee");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdIsNull() {
            addCriterion("tax_app_id is null");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdIsNotNull() {
            addCriterion("tax_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdEqualTo(String value) {
            addCriterion("tax_app_id =", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdNotEqualTo(String value) {
            addCriterion("tax_app_id <>", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdGreaterThan(String value) {
            addCriterion("tax_app_id >", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("tax_app_id >=", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdLessThan(String value) {
            addCriterion("tax_app_id <", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdLessThanOrEqualTo(String value) {
            addCriterion("tax_app_id <=", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdLike(String value) {
            addCriterion("tax_app_id like", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdNotLike(String value) {
            addCriterion("tax_app_id not like", value, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdIn(List<String> values) {
            addCriterion("tax_app_id in", values, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdNotIn(List<String> values) {
            addCriterion("tax_app_id not in", values, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdBetween(String value1, String value2) {
            addCriterion("tax_app_id between", value1, value2, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxAppIdNotBetween(String value1, String value2) {
            addCriterion("tax_app_id not between", value1, value2, "taxAppId");
            return (Criteria) this;
        }

        public Criteria andTaxKeyIsNull() {
            addCriterion("tax_key is null");
            return (Criteria) this;
        }

        public Criteria andTaxKeyIsNotNull() {
            addCriterion("tax_key is not null");
            return (Criteria) this;
        }

        public Criteria andTaxKeyEqualTo(String value) {
            addCriterion("tax_key =", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyNotEqualTo(String value) {
            addCriterion("tax_key <>", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyGreaterThan(String value) {
            addCriterion("tax_key >", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyGreaterThanOrEqualTo(String value) {
            addCriterion("tax_key >=", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyLessThan(String value) {
            addCriterion("tax_key <", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyLessThanOrEqualTo(String value) {
            addCriterion("tax_key <=", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyLike(String value) {
            addCriterion("tax_key like", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyNotLike(String value) {
            addCriterion("tax_key not like", value, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyIn(List<String> values) {
            addCriterion("tax_key in", values, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyNotIn(List<String> values) {
            addCriterion("tax_key not in", values, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyBetween(String value1, String value2) {
            addCriterion("tax_key between", value1, value2, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxKeyNotBetween(String value1, String value2) {
            addCriterion("tax_key not between", value1, value2, "taxKey");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathIsNull() {
            addCriterion("tax_cert_path is null");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathIsNotNull() {
            addCriterion("tax_cert_path is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathEqualTo(String value) {
            addCriterion("tax_cert_path =", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathNotEqualTo(String value) {
            addCriterion("tax_cert_path <>", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathGreaterThan(String value) {
            addCriterion("tax_cert_path >", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathGreaterThanOrEqualTo(String value) {
            addCriterion("tax_cert_path >=", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathLessThan(String value) {
            addCriterion("tax_cert_path <", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathLessThanOrEqualTo(String value) {
            addCriterion("tax_cert_path <=", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathLike(String value) {
            addCriterion("tax_cert_path like", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathNotLike(String value) {
            addCriterion("tax_cert_path not like", value, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathIn(List<String> values) {
            addCriterion("tax_cert_path in", values, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathNotIn(List<String> values) {
            addCriterion("tax_cert_path not in", values, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathBetween(String value1, String value2) {
            addCriterion("tax_cert_path between", value1, value2, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPathNotBetween(String value1, String value2) {
            addCriterion("tax_cert_path not between", value1, value2, "taxCertPath");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdIsNull() {
            addCriterion("tax_cert_pwd is null");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdIsNotNull() {
            addCriterion("tax_cert_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdEqualTo(String value) {
            addCriterion("tax_cert_pwd =", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdNotEqualTo(String value) {
            addCriterion("tax_cert_pwd <>", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdGreaterThan(String value) {
            addCriterion("tax_cert_pwd >", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdGreaterThanOrEqualTo(String value) {
            addCriterion("tax_cert_pwd >=", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdLessThan(String value) {
            addCriterion("tax_cert_pwd <", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdLessThanOrEqualTo(String value) {
            addCriterion("tax_cert_pwd <=", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdLike(String value) {
            addCriterion("tax_cert_pwd like", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdNotLike(String value) {
            addCriterion("tax_cert_pwd not like", value, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdIn(List<String> values) {
            addCriterion("tax_cert_pwd in", values, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdNotIn(List<String> values) {
            addCriterion("tax_cert_pwd not in", values, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdBetween(String value1, String value2) {
            addCriterion("tax_cert_pwd between", value1, value2, "taxCertPwd");
            return (Criteria) this;
        }

        public Criteria andTaxCertPwdNotBetween(String value1, String value2) {
            addCriterion("tax_cert_pwd not between", value1, value2, "taxCertPwd");
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