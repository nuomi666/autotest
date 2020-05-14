package dal.model.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantAuthDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantAuthDOExample() {
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

        public Criteria andBusinessCategoryIsNull() {
            addCriterion("business_category is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryIsNotNull() {
            addCriterion("business_category is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryEqualTo(String value) {
            addCriterion("business_category =", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryNotEqualTo(String value) {
            addCriterion("business_category <>", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryGreaterThan(String value) {
            addCriterion("business_category >", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("business_category >=", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryLessThan(String value) {
            addCriterion("business_category <", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryLessThanOrEqualTo(String value) {
            addCriterion("business_category <=", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryLike(String value) {
            addCriterion("business_category like", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryNotLike(String value) {
            addCriterion("business_category not like", value, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryIn(List<String> values) {
            addCriterion("business_category in", values, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryNotIn(List<String> values) {
            addCriterion("business_category not in", values, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryBetween(String value1, String value2) {
            addCriterion("business_category between", value1, value2, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andBusinessCategoryNotBetween(String value1, String value2) {
            addCriterion("business_category not between", value1, value2, "businessCategory");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlIsNull() {
            addCriterion("store_entrance_pics_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlIsNotNull() {
            addCriterion("store_entrance_pics_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlEqualTo(String value) {
            addCriterion("store_entrance_pics_url =", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlNotEqualTo(String value) {
            addCriterion("store_entrance_pics_url <>", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlGreaterThan(String value) {
            addCriterion("store_entrance_pics_url >", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_entrance_pics_url >=", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlLessThan(String value) {
            addCriterion("store_entrance_pics_url <", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlLessThanOrEqualTo(String value) {
            addCriterion("store_entrance_pics_url <=", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlLike(String value) {
            addCriterion("store_entrance_pics_url like", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlNotLike(String value) {
            addCriterion("store_entrance_pics_url not like", value, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlIn(List<String> values) {
            addCriterion("store_entrance_pics_url in", values, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlNotIn(List<String> values) {
            addCriterion("store_entrance_pics_url not in", values, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlBetween(String value1, String value2) {
            addCriterion("store_entrance_pics_url between", value1, value2, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreEntrancePicsUrlNotBetween(String value1, String value2) {
            addCriterion("store_entrance_pics_url not between", value1, value2, "storeEntrancePicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlIsNull() {
            addCriterion("store_indoor_pics_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlIsNotNull() {
            addCriterion("store_indoor_pics_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlEqualTo(String value) {
            addCriterion("store_indoor_pics_url =", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlNotEqualTo(String value) {
            addCriterion("store_indoor_pics_url <>", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlGreaterThan(String value) {
            addCriterion("store_indoor_pics_url >", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_indoor_pics_url >=", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlLessThan(String value) {
            addCriterion("store_indoor_pics_url <", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlLessThanOrEqualTo(String value) {
            addCriterion("store_indoor_pics_url <=", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlLike(String value) {
            addCriterion("store_indoor_pics_url like", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlNotLike(String value) {
            addCriterion("store_indoor_pics_url not like", value, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlIn(List<String> values) {
            addCriterion("store_indoor_pics_url in", values, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlNotIn(List<String> values) {
            addCriterion("store_indoor_pics_url not in", values, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlBetween(String value1, String value2) {
            addCriterion("store_indoor_pics_url between", value1, value2, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andStoreIndoorPicsUrlNotBetween(String value1, String value2) {
            addCriterion("store_indoor_pics_url not between", value1, value2, "storeIndoorPicsUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlIsNull() {
            addCriterion("qualifications_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlIsNotNull() {
            addCriterion("qualifications_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlEqualTo(String value) {
            addCriterion("qualifications_pic_url =", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlNotEqualTo(String value) {
            addCriterion("qualifications_pic_url <>", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlGreaterThan(String value) {
            addCriterion("qualifications_pic_url >", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("qualifications_pic_url >=", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlLessThan(String value) {
            addCriterion("qualifications_pic_url <", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlLessThanOrEqualTo(String value) {
            addCriterion("qualifications_pic_url <=", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlLike(String value) {
            addCriterion("qualifications_pic_url like", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlNotLike(String value) {
            addCriterion("qualifications_pic_url not like", value, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlIn(List<String> values) {
            addCriterion("qualifications_pic_url in", values, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlNotIn(List<String> values) {
            addCriterion("qualifications_pic_url not in", values, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlBetween(String value1, String value2) {
            addCriterion("qualifications_pic_url between", value1, value2, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andQualificationsPicUrlNotBetween(String value1, String value2) {
            addCriterion("qualifications_pic_url not between", value1, value2, "qualificationsPicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlIsNull() {
            addCriterion("business_addition_pics_url is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlIsNotNull() {
            addCriterion("business_addition_pics_url is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlEqualTo(String value) {
            addCriterion("business_addition_pics_url =", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlNotEqualTo(String value) {
            addCriterion("business_addition_pics_url <>", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlGreaterThan(String value) {
            addCriterion("business_addition_pics_url >", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("business_addition_pics_url >=", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlLessThan(String value) {
            addCriterion("business_addition_pics_url <", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlLessThanOrEqualTo(String value) {
            addCriterion("business_addition_pics_url <=", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlLike(String value) {
            addCriterion("business_addition_pics_url like", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlNotLike(String value) {
            addCriterion("business_addition_pics_url not like", value, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlIn(List<String> values) {
            addCriterion("business_addition_pics_url in", values, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlNotIn(List<String> values) {
            addCriterion("business_addition_pics_url not in", values, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlBetween(String value1, String value2) {
            addCriterion("business_addition_pics_url between", value1, value2, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessAdditionPicsUrlNotBetween(String value1, String value2) {
            addCriterion("business_addition_pics_url not between", value1, value2, "businessAdditionPicsUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlIsNull() {
            addCriterion("business_license_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlIsNotNull() {
            addCriterion("business_license_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlEqualTo(String value) {
            addCriterion("business_license_pic_url =", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlNotEqualTo(String value) {
            addCriterion("business_license_pic_url <>", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlGreaterThan(String value) {
            addCriterion("business_license_pic_url >", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_pic_url >=", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlLessThan(String value) {
            addCriterion("business_license_pic_url <", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlLessThanOrEqualTo(String value) {
            addCriterion("business_license_pic_url <=", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlLike(String value) {
            addCriterion("business_license_pic_url like", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlNotLike(String value) {
            addCriterion("business_license_pic_url not like", value, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlIn(List<String> values) {
            addCriterion("business_license_pic_url in", values, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlNotIn(List<String> values) {
            addCriterion("business_license_pic_url not in", values, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlBetween(String value1, String value2) {
            addCriterion("business_license_pic_url between", value1, value2, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicUrlNotBetween(String value1, String value2) {
            addCriterion("business_license_pic_url not between", value1, value2, "businessLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIsNull() {
            addCriterion("business_time is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIsNotNull() {
            addCriterion("business_time is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEqualTo(String value) {
            addCriterion("business_time =", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotEqualTo(String value) {
            addCriterion("business_time <>", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThan(String value) {
            addCriterion("business_time >", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThanOrEqualTo(String value) {
            addCriterion("business_time >=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThan(String value) {
            addCriterion("business_time <", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThanOrEqualTo(String value) {
            addCriterion("business_time <=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLike(String value) {
            addCriterion("business_time like", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotLike(String value) {
            addCriterion("business_time not like", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIn(List<String> values) {
            addCriterion("business_time in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotIn(List<String> values) {
            addCriterion("business_time not in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeBetween(String value1, String value2) {
            addCriterion("business_time between", value1, value2, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotBetween(String value1, String value2) {
            addCriterion("business_time not between", value1, value2, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlIsNull() {
            addCriterion("account_opening_license_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlIsNotNull() {
            addCriterion("account_opening_license_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlEqualTo(String value) {
            addCriterion("account_opening_license_pic_url =", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlNotEqualTo(String value) {
            addCriterion("account_opening_license_pic_url <>", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlGreaterThan(String value) {
            addCriterion("account_opening_license_pic_url >", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("account_opening_license_pic_url >=", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlLessThan(String value) {
            addCriterion("account_opening_license_pic_url <", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlLessThanOrEqualTo(String value) {
            addCriterion("account_opening_license_pic_url <=", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlLike(String value) {
            addCriterion("account_opening_license_pic_url like", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlNotLike(String value) {
            addCriterion("account_opening_license_pic_url not like", value, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlIn(List<String> values) {
            addCriterion("account_opening_license_pic_url in", values, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlNotIn(List<String> values) {
            addCriterion("account_opening_license_pic_url not in", values, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlBetween(String value1, String value2) {
            addCriterion("account_opening_license_pic_url between", value1, value2, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andAccountOpeningLicensePicUrlNotBetween(String value1, String value2) {
            addCriterion("account_opening_license_pic_url not between", value1, value2, "accountOpeningLicensePicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("legal_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("legal_name =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("legal_name <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("legal_name >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_name >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("legal_name <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("legal_name <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("legal_name like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("legal_name not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("legal_name in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("legal_name not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("legal_name between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("legal_name not between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIsNull() {
            addCriterion("legal_cert_type is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIsNotNull() {
            addCriterion("legal_cert_type is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeEqualTo(String value) {
            addCriterion("legal_cert_type =", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotEqualTo(String value) {
            addCriterion("legal_cert_type <>", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeGreaterThan(String value) {
            addCriterion("legal_cert_type >", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_type >=", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLessThan(String value) {
            addCriterion("legal_cert_type <", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_type <=", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLike(String value) {
            addCriterion("legal_cert_type like", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotLike(String value) {
            addCriterion("legal_cert_type not like", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIn(List<String> values) {
            addCriterion("legal_cert_type in", values, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotIn(List<String> values) {
            addCriterion("legal_cert_type not in", values, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeBetween(String value1, String value2) {
            addCriterion("legal_cert_type between", value1, value2, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotBetween(String value1, String value2) {
            addCriterion("legal_cert_type not between", value1, value2, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoIsNull() {
            addCriterion("legal_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoIsNotNull() {
            addCriterion("legal_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoEqualTo(String value) {
            addCriterion("legal_cert_no =", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotEqualTo(String value) {
            addCriterion("legal_cert_no <>", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoGreaterThan(String value) {
            addCriterion("legal_cert_no >", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_no >=", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoLessThan(String value) {
            addCriterion("legal_cert_no <", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_no <=", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoLike(String value) {
            addCriterion("legal_cert_no like", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotLike(String value) {
            addCriterion("legal_cert_no not like", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoIn(List<String> values) {
            addCriterion("legal_cert_no in", values, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotIn(List<String> values) {
            addCriterion("legal_cert_no not in", values, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoBetween(String value1, String value2) {
            addCriterion("legal_cert_no between", value1, value2, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotBetween(String value1, String value2) {
            addCriterion("legal_cert_no not between", value1, value2, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeIsNull() {
            addCriterion("legal_cert_valid_time is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeIsNotNull() {
            addCriterion("legal_cert_valid_time is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeEqualTo(String value) {
            addCriterion("legal_cert_valid_time =", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeNotEqualTo(String value) {
            addCriterion("legal_cert_valid_time <>", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeGreaterThan(String value) {
            addCriterion("legal_cert_valid_time >", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_valid_time >=", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeLessThan(String value) {
            addCriterion("legal_cert_valid_time <", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_valid_time <=", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeLike(String value) {
            addCriterion("legal_cert_valid_time like", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeNotLike(String value) {
            addCriterion("legal_cert_valid_time not like", value, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeIn(List<String> values) {
            addCriterion("legal_cert_valid_time in", values, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeNotIn(List<String> values) {
            addCriterion("legal_cert_valid_time not in", values, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeBetween(String value1, String value2) {
            addCriterion("legal_cert_valid_time between", value1, value2, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertValidTimeNotBetween(String value1, String value2) {
            addCriterion("legal_cert_valid_time not between", value1, value2, "legalCertValidTime");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlIsNull() {
            addCriterion("legal_cert_front_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlIsNotNull() {
            addCriterion("legal_cert_front_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlEqualTo(String value) {
            addCriterion("legal_cert_front_pic_url =", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlNotEqualTo(String value) {
            addCriterion("legal_cert_front_pic_url <>", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlGreaterThan(String value) {
            addCriterion("legal_cert_front_pic_url >", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_front_pic_url >=", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlLessThan(String value) {
            addCriterion("legal_cert_front_pic_url <", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_front_pic_url <=", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlLike(String value) {
            addCriterion("legal_cert_front_pic_url like", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlNotLike(String value) {
            addCriterion("legal_cert_front_pic_url not like", value, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlIn(List<String> values) {
            addCriterion("legal_cert_front_pic_url in", values, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlNotIn(List<String> values) {
            addCriterion("legal_cert_front_pic_url not in", values, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlBetween(String value1, String value2) {
            addCriterion("legal_cert_front_pic_url between", value1, value2, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertFrontPicUrlNotBetween(String value1, String value2) {
            addCriterion("legal_cert_front_pic_url not between", value1, value2, "legalCertFrontPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlIsNull() {
            addCriterion("legal_cert_back_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlIsNotNull() {
            addCriterion("legal_cert_back_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlEqualTo(String value) {
            addCriterion("legal_cert_back_pic_url =", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlNotEqualTo(String value) {
            addCriterion("legal_cert_back_pic_url <>", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlGreaterThan(String value) {
            addCriterion("legal_cert_back_pic_url >", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_back_pic_url >=", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlLessThan(String value) {
            addCriterion("legal_cert_back_pic_url <", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_back_pic_url <=", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlLike(String value) {
            addCriterion("legal_cert_back_pic_url like", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlNotLike(String value) {
            addCriterion("legal_cert_back_pic_url not like", value, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlIn(List<String> values) {
            addCriterion("legal_cert_back_pic_url in", values, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlNotIn(List<String> values) {
            addCriterion("legal_cert_back_pic_url not in", values, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlBetween(String value1, String value2) {
            addCriterion("legal_cert_back_pic_url between", value1, value2, "legalCertBackPicUrl");
            return (Criteria) this;
        }

        public Criteria andLegalCertBackPicUrlNotBetween(String value1, String value2) {
            addCriterion("legal_cert_back_pic_url not between", value1, value2, "legalCertBackPicUrl");
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