package dal.model.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantImgDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantImgDOExample() {
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

        public Criteria andBusinessLicenseUrlIsNull() {
            addCriterion("business_license_url is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIsNotNull() {
            addCriterion("business_license_url is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlEqualTo(String value) {
            addCriterion("business_license_url =", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotEqualTo(String value) {
            addCriterion("business_license_url <>", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlGreaterThan(String value) {
            addCriterion("business_license_url >", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_url >=", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLessThan(String value) {
            addCriterion("business_license_url <", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLessThanOrEqualTo(String value) {
            addCriterion("business_license_url <=", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLike(String value) {
            addCriterion("business_license_url like", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotLike(String value) {
            addCriterion("business_license_url not like", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIn(List<String> values) {
            addCriterion("business_license_url in", values, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotIn(List<String> values) {
            addCriterion("business_license_url not in", values, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlBetween(String value1, String value2) {
            addCriterion("business_license_url between", value1, value2, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotBetween(String value1, String value2) {
            addCriterion("business_license_url not between", value1, value2, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlIsNull() {
            addCriterion("organization_code_url is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlIsNotNull() {
            addCriterion("organization_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlEqualTo(String value) {
            addCriterion("organization_code_url =", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlNotEqualTo(String value) {
            addCriterion("organization_code_url <>", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlGreaterThan(String value) {
            addCriterion("organization_code_url >", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("organization_code_url >=", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlLessThan(String value) {
            addCriterion("organization_code_url <", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("organization_code_url <=", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlLike(String value) {
            addCriterion("organization_code_url like", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlNotLike(String value) {
            addCriterion("organization_code_url not like", value, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlIn(List<String> values) {
            addCriterion("organization_code_url in", values, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlNotIn(List<String> values) {
            addCriterion("organization_code_url not in", values, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlBetween(String value1, String value2) {
            addCriterion("organization_code_url between", value1, value2, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeUrlNotBetween(String value1, String value2) {
            addCriterion("organization_code_url not between", value1, value2, "organizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlIsNull() {
            addCriterion("tax_certificate_url is null");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlIsNotNull() {
            addCriterion("tax_certificate_url is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlEqualTo(String value) {
            addCriterion("tax_certificate_url =", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlNotEqualTo(String value) {
            addCriterion("tax_certificate_url <>", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlGreaterThan(String value) {
            addCriterion("tax_certificate_url >", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlGreaterThanOrEqualTo(String value) {
            addCriterion("tax_certificate_url >=", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlLessThan(String value) {
            addCriterion("tax_certificate_url <", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlLessThanOrEqualTo(String value) {
            addCriterion("tax_certificate_url <=", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlLike(String value) {
            addCriterion("tax_certificate_url like", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlNotLike(String value) {
            addCriterion("tax_certificate_url not like", value, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlIn(List<String> values) {
            addCriterion("tax_certificate_url in", values, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlNotIn(List<String> values) {
            addCriterion("tax_certificate_url not in", values, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlBetween(String value1, String value2) {
            addCriterion("tax_certificate_url between", value1, value2, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andTaxCertificateUrlNotBetween(String value1, String value2) {
            addCriterion("tax_certificate_url not between", value1, value2, "taxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlIsNull() {
            addCriterion("bank_settlement_url is null");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlIsNotNull() {
            addCriterion("bank_settlement_url is not null");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlEqualTo(String value) {
            addCriterion("bank_settlement_url =", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlNotEqualTo(String value) {
            addCriterion("bank_settlement_url <>", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlGreaterThan(String value) {
            addCriterion("bank_settlement_url >", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bank_settlement_url >=", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlLessThan(String value) {
            addCriterion("bank_settlement_url <", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlLessThanOrEqualTo(String value) {
            addCriterion("bank_settlement_url <=", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlLike(String value) {
            addCriterion("bank_settlement_url like", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlNotLike(String value) {
            addCriterion("bank_settlement_url not like", value, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlIn(List<String> values) {
            addCriterion("bank_settlement_url in", values, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlNotIn(List<String> values) {
            addCriterion("bank_settlement_url not in", values, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlBetween(String value1, String value2) {
            addCriterion("bank_settlement_url between", value1, value2, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andBankSettlementUrlNotBetween(String value1, String value2) {
            addCriterion("bank_settlement_url not between", value1, value2, "bankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlIsNull() {
            addCriterion("legal_cerificate_front_url is null");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlIsNotNull() {
            addCriterion("legal_cerificate_front_url is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlEqualTo(String value) {
            addCriterion("legal_cerificate_front_url =", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlNotEqualTo(String value) {
            addCriterion("legal_cerificate_front_url <>", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlGreaterThan(String value) {
            addCriterion("legal_cerificate_front_url >", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cerificate_front_url >=", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlLessThan(String value) {
            addCriterion("legal_cerificate_front_url <", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlLessThanOrEqualTo(String value) {
            addCriterion("legal_cerificate_front_url <=", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlLike(String value) {
            addCriterion("legal_cerificate_front_url like", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlNotLike(String value) {
            addCriterion("legal_cerificate_front_url not like", value, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlIn(List<String> values) {
            addCriterion("legal_cerificate_front_url in", values, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlNotIn(List<String> values) {
            addCriterion("legal_cerificate_front_url not in", values, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlBetween(String value1, String value2) {
            addCriterion("legal_cerificate_front_url between", value1, value2, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateFrontUrlNotBetween(String value1, String value2) {
            addCriterion("legal_cerificate_front_url not between", value1, value2, "legalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlIsNull() {
            addCriterion("legal_cerificate_back_url is null");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlIsNotNull() {
            addCriterion("legal_cerificate_back_url is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlEqualTo(String value) {
            addCriterion("legal_cerificate_back_url =", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlNotEqualTo(String value) {
            addCriterion("legal_cerificate_back_url <>", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlGreaterThan(String value) {
            addCriterion("legal_cerificate_back_url >", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cerificate_back_url >=", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlLessThan(String value) {
            addCriterion("legal_cerificate_back_url <", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlLessThanOrEqualTo(String value) {
            addCriterion("legal_cerificate_back_url <=", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlLike(String value) {
            addCriterion("legal_cerificate_back_url like", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlNotLike(String value) {
            addCriterion("legal_cerificate_back_url not like", value, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlIn(List<String> values) {
            addCriterion("legal_cerificate_back_url in", values, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlNotIn(List<String> values) {
            addCriterion("legal_cerificate_back_url not in", values, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlBetween(String value1, String value2) {
            addCriterion("legal_cerificate_back_url between", value1, value2, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCerificateBackUrlNotBetween(String value1, String value2) {
            addCriterion("legal_cerificate_back_url not between", value1, value2, "legalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlIsNull() {
            addCriterion("old_business_license_url is null");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlIsNotNull() {
            addCriterion("old_business_license_url is not null");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlEqualTo(String value) {
            addCriterion("old_business_license_url =", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlNotEqualTo(String value) {
            addCriterion("old_business_license_url <>", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlGreaterThan(String value) {
            addCriterion("old_business_license_url >", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("old_business_license_url >=", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlLessThan(String value) {
            addCriterion("old_business_license_url <", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlLessThanOrEqualTo(String value) {
            addCriterion("old_business_license_url <=", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlLike(String value) {
            addCriterion("old_business_license_url like", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlNotLike(String value) {
            addCriterion("old_business_license_url not like", value, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlIn(List<String> values) {
            addCriterion("old_business_license_url in", values, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlNotIn(List<String> values) {
            addCriterion("old_business_license_url not in", values, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlBetween(String value1, String value2) {
            addCriterion("old_business_license_url between", value1, value2, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldBusinessLicenseUrlNotBetween(String value1, String value2) {
            addCriterion("old_business_license_url not between", value1, value2, "oldBusinessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlIsNull() {
            addCriterion("old_organization_code_url is null");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlIsNotNull() {
            addCriterion("old_organization_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlEqualTo(String value) {
            addCriterion("old_organization_code_url =", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlNotEqualTo(String value) {
            addCriterion("old_organization_code_url <>", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlGreaterThan(String value) {
            addCriterion("old_organization_code_url >", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("old_organization_code_url >=", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlLessThan(String value) {
            addCriterion("old_organization_code_url <", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("old_organization_code_url <=", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlLike(String value) {
            addCriterion("old_organization_code_url like", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlNotLike(String value) {
            addCriterion("old_organization_code_url not like", value, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlIn(List<String> values) {
            addCriterion("old_organization_code_url in", values, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlNotIn(List<String> values) {
            addCriterion("old_organization_code_url not in", values, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlBetween(String value1, String value2) {
            addCriterion("old_organization_code_url between", value1, value2, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldOrganizationCodeUrlNotBetween(String value1, String value2) {
            addCriterion("old_organization_code_url not between", value1, value2, "oldOrganizationCodeUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlIsNull() {
            addCriterion("old_tax_certificate_url is null");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlIsNotNull() {
            addCriterion("old_tax_certificate_url is not null");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlEqualTo(String value) {
            addCriterion("old_tax_certificate_url =", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlNotEqualTo(String value) {
            addCriterion("old_tax_certificate_url <>", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlGreaterThan(String value) {
            addCriterion("old_tax_certificate_url >", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlGreaterThanOrEqualTo(String value) {
            addCriterion("old_tax_certificate_url >=", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlLessThan(String value) {
            addCriterion("old_tax_certificate_url <", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlLessThanOrEqualTo(String value) {
            addCriterion("old_tax_certificate_url <=", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlLike(String value) {
            addCriterion("old_tax_certificate_url like", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlNotLike(String value) {
            addCriterion("old_tax_certificate_url not like", value, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlIn(List<String> values) {
            addCriterion("old_tax_certificate_url in", values, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlNotIn(List<String> values) {
            addCriterion("old_tax_certificate_url not in", values, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlBetween(String value1, String value2) {
            addCriterion("old_tax_certificate_url between", value1, value2, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldTaxCertificateUrlNotBetween(String value1, String value2) {
            addCriterion("old_tax_certificate_url not between", value1, value2, "oldTaxCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlIsNull() {
            addCriterion("old_bank_settlement_url is null");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlIsNotNull() {
            addCriterion("old_bank_settlement_url is not null");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlEqualTo(String value) {
            addCriterion("old_bank_settlement_url =", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlNotEqualTo(String value) {
            addCriterion("old_bank_settlement_url <>", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlGreaterThan(String value) {
            addCriterion("old_bank_settlement_url >", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlGreaterThanOrEqualTo(String value) {
            addCriterion("old_bank_settlement_url >=", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlLessThan(String value) {
            addCriterion("old_bank_settlement_url <", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlLessThanOrEqualTo(String value) {
            addCriterion("old_bank_settlement_url <=", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlLike(String value) {
            addCriterion("old_bank_settlement_url like", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlNotLike(String value) {
            addCriterion("old_bank_settlement_url not like", value, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlIn(List<String> values) {
            addCriterion("old_bank_settlement_url in", values, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlNotIn(List<String> values) {
            addCriterion("old_bank_settlement_url not in", values, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlBetween(String value1, String value2) {
            addCriterion("old_bank_settlement_url between", value1, value2, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldBankSettlementUrlNotBetween(String value1, String value2) {
            addCriterion("old_bank_settlement_url not between", value1, value2, "oldBankSettlementUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlIsNull() {
            addCriterion("old_legal_cerificate_front_url is null");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlIsNotNull() {
            addCriterion("old_legal_cerificate_front_url is not null");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlEqualTo(String value) {
            addCriterion("old_legal_cerificate_front_url =", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlNotEqualTo(String value) {
            addCriterion("old_legal_cerificate_front_url <>", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlGreaterThan(String value) {
            addCriterion("old_legal_cerificate_front_url >", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlGreaterThanOrEqualTo(String value) {
            addCriterion("old_legal_cerificate_front_url >=", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlLessThan(String value) {
            addCriterion("old_legal_cerificate_front_url <", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlLessThanOrEqualTo(String value) {
            addCriterion("old_legal_cerificate_front_url <=", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlLike(String value) {
            addCriterion("old_legal_cerificate_front_url like", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlNotLike(String value) {
            addCriterion("old_legal_cerificate_front_url not like", value, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlIn(List<String> values) {
            addCriterion("old_legal_cerificate_front_url in", values, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlNotIn(List<String> values) {
            addCriterion("old_legal_cerificate_front_url not in", values, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlBetween(String value1, String value2) {
            addCriterion("old_legal_cerificate_front_url between", value1, value2, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateFrontUrlNotBetween(String value1, String value2) {
            addCriterion("old_legal_cerificate_front_url not between", value1, value2, "oldLegalCerificateFrontUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlIsNull() {
            addCriterion("old_legal_cerificate_back_url is null");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlIsNotNull() {
            addCriterion("old_legal_cerificate_back_url is not null");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlEqualTo(String value) {
            addCriterion("old_legal_cerificate_back_url =", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlNotEqualTo(String value) {
            addCriterion("old_legal_cerificate_back_url <>", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlGreaterThan(String value) {
            addCriterion("old_legal_cerificate_back_url >", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("old_legal_cerificate_back_url >=", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlLessThan(String value) {
            addCriterion("old_legal_cerificate_back_url <", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlLessThanOrEqualTo(String value) {
            addCriterion("old_legal_cerificate_back_url <=", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlLike(String value) {
            addCriterion("old_legal_cerificate_back_url like", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlNotLike(String value) {
            addCriterion("old_legal_cerificate_back_url not like", value, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlIn(List<String> values) {
            addCriterion("old_legal_cerificate_back_url in", values, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlNotIn(List<String> values) {
            addCriterion("old_legal_cerificate_back_url not in", values, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlBetween(String value1, String value2) {
            addCriterion("old_legal_cerificate_back_url between", value1, value2, "oldLegalCerificateBackUrl");
            return (Criteria) this;
        }

        public Criteria andOldLegalCerificateBackUrlNotBetween(String value1, String value2) {
            addCriterion("old_legal_cerificate_back_url not between", value1, value2, "oldLegalCerificateBackUrl");
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