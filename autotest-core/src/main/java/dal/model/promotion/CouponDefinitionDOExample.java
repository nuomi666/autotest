package dal.model.promotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponDefinitionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponDefinitionDOExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdIsNull() {
            addCriterion("definition_id is null");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdIsNotNull() {
            addCriterion("definition_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdEqualTo(String value) {
            addCriterion("definition_id =", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotEqualTo(String value) {
            addCriterion("definition_id <>", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdGreaterThan(String value) {
            addCriterion("definition_id >", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("definition_id >=", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdLessThan(String value) {
            addCriterion("definition_id <", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdLessThanOrEqualTo(String value) {
            addCriterion("definition_id <=", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdLike(String value) {
            addCriterion("definition_id like", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotLike(String value) {
            addCriterion("definition_id not like", value, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdIn(List<String> values) {
            addCriterion("definition_id in", values, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotIn(List<String> values) {
            addCriterion("definition_id not in", values, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdBetween(String value1, String value2) {
            addCriterion("definition_id between", value1, value2, "definitionId");
            return (Criteria) this;
        }

        public Criteria andDefinitionIdNotBetween(String value1, String value2) {
            addCriterion("definition_id not between", value1, value2, "definitionId");
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

        public Criteria andDefinitionStatusIsNull() {
            addCriterion("definition_status is null");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusIsNotNull() {
            addCriterion("definition_status is not null");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusEqualTo(String value) {
            addCriterion("definition_status =", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusNotEqualTo(String value) {
            addCriterion("definition_status <>", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusGreaterThan(String value) {
            addCriterion("definition_status >", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusGreaterThanOrEqualTo(String value) {
            addCriterion("definition_status >=", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusLessThan(String value) {
            addCriterion("definition_status <", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusLessThanOrEqualTo(String value) {
            addCriterion("definition_status <=", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusLike(String value) {
            addCriterion("definition_status like", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusNotLike(String value) {
            addCriterion("definition_status not like", value, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusIn(List<String> values) {
            addCriterion("definition_status in", values, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusNotIn(List<String> values) {
            addCriterion("definition_status not in", values, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusBetween(String value1, String value2) {
            addCriterion("definition_status between", value1, value2, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andDefinitionStatusNotBetween(String value1, String value2) {
            addCriterion("definition_status not between", value1, value2, "definitionStatus");
            return (Criteria) this;
        }

        public Criteria andInnerNameIsNull() {
            addCriterion("inner_name is null");
            return (Criteria) this;
        }

        public Criteria andInnerNameIsNotNull() {
            addCriterion("inner_name is not null");
            return (Criteria) this;
        }

        public Criteria andInnerNameEqualTo(String value) {
            addCriterion("inner_name =", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameNotEqualTo(String value) {
            addCriterion("inner_name <>", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameGreaterThan(String value) {
            addCriterion("inner_name >", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("inner_name >=", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameLessThan(String value) {
            addCriterion("inner_name <", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameLessThanOrEqualTo(String value) {
            addCriterion("inner_name <=", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameLike(String value) {
            addCriterion("inner_name like", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameNotLike(String value) {
            addCriterion("inner_name not like", value, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameIn(List<String> values) {
            addCriterion("inner_name in", values, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameNotIn(List<String> values) {
            addCriterion("inner_name not in", values, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameBetween(String value1, String value2) {
            addCriterion("inner_name between", value1, value2, "innerName");
            return (Criteria) this;
        }

        public Criteria andInnerNameNotBetween(String value1, String value2) {
            addCriterion("inner_name not between", value1, value2, "innerName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(String value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(String value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(String value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(String value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(String value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLike(String value) {
            addCriterion("coupon_type like", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotLike(String value) {
            addCriterion("coupon_type not like", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<String> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<String> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(String value1, String value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(String value1, String value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Long value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Long value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Long value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Long value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Long value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Long> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Long> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Long value1, Long value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Long value1, Long value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andTakeCountIsNull() {
            addCriterion("take_count is null");
            return (Criteria) this;
        }

        public Criteria andTakeCountIsNotNull() {
            addCriterion("take_count is not null");
            return (Criteria) this;
        }

        public Criteria andTakeCountEqualTo(Integer value) {
            addCriterion("take_count =", value, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountNotEqualTo(Integer value) {
            addCriterion("take_count <>", value, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountGreaterThan(Integer value) {
            addCriterion("take_count >", value, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("take_count >=", value, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountLessThan(Integer value) {
            addCriterion("take_count <", value, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountLessThanOrEqualTo(Integer value) {
            addCriterion("take_count <=", value, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountIn(List<Integer> values) {
            addCriterion("take_count in", values, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountNotIn(List<Integer> values) {
            addCriterion("take_count not in", values, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountBetween(Integer value1, Integer value2) {
            addCriterion("take_count between", value1, value2, "takeCount");
            return (Criteria) this;
        }

        public Criteria andTakeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("take_count not between", value1, value2, "takeCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNull() {
            addCriterion("apply_count is null");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNotNull() {
            addCriterion("apply_count is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCountEqualTo(Integer value) {
            addCriterion("apply_count =", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotEqualTo(Integer value) {
            addCriterion("apply_count <>", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThan(Integer value) {
            addCriterion("apply_count >", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_count >=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThan(Integer value) {
            addCriterion("apply_count <", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("apply_count <=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountIn(List<Integer> values) {
            addCriterion("apply_count in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotIn(List<Integer> values) {
            addCriterion("apply_count not in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountBetween(Integer value1, Integer value2) {
            addCriterion("apply_count between", value1, value2, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_count not between", value1, value2, "applyCount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIsNull() {
            addCriterion("max_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIsNotNull() {
            addCriterion("max_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountEqualTo(Long value) {
            addCriterion("max_discount_amount =", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotEqualTo(Long value) {
            addCriterion("max_discount_amount <>", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountGreaterThan(Long value) {
            addCriterion("max_discount_amount >", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("max_discount_amount >=", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountLessThan(Long value) {
            addCriterion("max_discount_amount <", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("max_discount_amount <=", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIn(List<Long> values) {
            addCriterion("max_discount_amount in", values, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotIn(List<Long> values) {
            addCriterion("max_discount_amount not in", values, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("max_discount_amount between", value1, value2, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("max_discount_amount not between", value1, value2, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOverlayIsNull() {
            addCriterion("overlay is null");
            return (Criteria) this;
        }

        public Criteria andOverlayIsNotNull() {
            addCriterion("overlay is not null");
            return (Criteria) this;
        }

        public Criteria andOverlayEqualTo(Boolean value) {
            addCriterion("overlay =", value, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayNotEqualTo(Boolean value) {
            addCriterion("overlay <>", value, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayGreaterThan(Boolean value) {
            addCriterion("overlay >", value, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("overlay >=", value, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayLessThan(Boolean value) {
            addCriterion("overlay <", value, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayLessThanOrEqualTo(Boolean value) {
            addCriterion("overlay <=", value, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayIn(List<Boolean> values) {
            addCriterion("overlay in", values, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayNotIn(List<Boolean> values) {
            addCriterion("overlay not in", values, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayBetween(Boolean value1, Boolean value2) {
            addCriterion("overlay between", value1, value2, "overlay");
            return (Criteria) this;
        }

        public Criteria andOverlayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("overlay not between", value1, value2, "overlay");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysIsNull() {
            addCriterion("expire_notify_days is null");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysIsNotNull() {
            addCriterion("expire_notify_days is not null");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysEqualTo(Integer value) {
            addCriterion("expire_notify_days =", value, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysNotEqualTo(Integer value) {
            addCriterion("expire_notify_days <>", value, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysGreaterThan(Integer value) {
            addCriterion("expire_notify_days >", value, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire_notify_days >=", value, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysLessThan(Integer value) {
            addCriterion("expire_notify_days <", value, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysLessThanOrEqualTo(Integer value) {
            addCriterion("expire_notify_days <=", value, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysIn(List<Integer> values) {
            addCriterion("expire_notify_days in", values, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysNotIn(List<Integer> values) {
            addCriterion("expire_notify_days not in", values, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysBetween(Integer value1, Integer value2) {
            addCriterion("expire_notify_days between", value1, value2, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andExpireNotifyDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("expire_notify_days not between", value1, value2, "expireNotifyDays");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonIsNull() {
            addCriterion("definition_json is null");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonIsNotNull() {
            addCriterion("definition_json is not null");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonEqualTo(String value) {
            addCriterion("definition_json =", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonNotEqualTo(String value) {
            addCriterion("definition_json <>", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonGreaterThan(String value) {
            addCriterion("definition_json >", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonGreaterThanOrEqualTo(String value) {
            addCriterion("definition_json >=", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonLessThan(String value) {
            addCriterion("definition_json <", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonLessThanOrEqualTo(String value) {
            addCriterion("definition_json <=", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonLike(String value) {
            addCriterion("definition_json like", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonNotLike(String value) {
            addCriterion("definition_json not like", value, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonIn(List<String> values) {
            addCriterion("definition_json in", values, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonNotIn(List<String> values) {
            addCriterion("definition_json not in", values, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonBetween(String value1, String value2) {
            addCriterion("definition_json between", value1, value2, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andDefinitionJsonNotBetween(String value1, String value2) {
            addCriterion("definition_json not between", value1, value2, "definitionJson");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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