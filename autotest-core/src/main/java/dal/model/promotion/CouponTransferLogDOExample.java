package dal.model.promotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponTransferLogDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponTransferLogDOExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(String value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(String value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(String value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(String value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(String value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(String value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLike(String value) {
            addCriterion("gid like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotLike(String value) {
            addCriterion("gid not like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<String> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<String> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(String value1, String value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(String value1, String value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNull() {
            addCriterion("req_id is null");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNotNull() {
            addCriterion("req_id is not null");
            return (Criteria) this;
        }

        public Criteria andReqIdEqualTo(String value) {
            addCriterion("req_id =", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotEqualTo(String value) {
            addCriterion("req_id <>", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThan(String value) {
            addCriterion("req_id >", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThanOrEqualTo(String value) {
            addCriterion("req_id >=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThan(String value) {
            addCriterion("req_id <", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThanOrEqualTo(String value) {
            addCriterion("req_id <=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLike(String value) {
            addCriterion("req_id like", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotLike(String value) {
            addCriterion("req_id not like", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdIn(List<String> values) {
            addCriterion("req_id in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotIn(List<String> values) {
            addCriterion("req_id not in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdBetween(String value1, String value2) {
            addCriterion("req_id between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotBetween(String value1, String value2) {
            addCriterion("req_id not between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdIsNull() {
            addCriterion("instruction_id is null");
            return (Criteria) this;
        }

        public Criteria andInstructionIdIsNotNull() {
            addCriterion("instruction_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstructionIdEqualTo(String value) {
            addCriterion("instruction_id =", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdNotEqualTo(String value) {
            addCriterion("instruction_id <>", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdGreaterThan(String value) {
            addCriterion("instruction_id >", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdGreaterThanOrEqualTo(String value) {
            addCriterion("instruction_id >=", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdLessThan(String value) {
            addCriterion("instruction_id <", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdLessThanOrEqualTo(String value) {
            addCriterion("instruction_id <=", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdLike(String value) {
            addCriterion("instruction_id like", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdNotLike(String value) {
            addCriterion("instruction_id not like", value, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdIn(List<String> values) {
            addCriterion("instruction_id in", values, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdNotIn(List<String> values) {
            addCriterion("instruction_id not in", values, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdBetween(String value1, String value2) {
            addCriterion("instruction_id between", value1, value2, "instructionId");
            return (Criteria) this;
        }

        public Criteria andInstructionIdNotBetween(String value1, String value2) {
            addCriterion("instruction_id not between", value1, value2, "instructionId");
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

        public Criteria andDonorUserIdIsNull() {
            addCriterion("donor_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdIsNotNull() {
            addCriterion("donor_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdEqualTo(String value) {
            addCriterion("donor_user_id =", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdNotEqualTo(String value) {
            addCriterion("donor_user_id <>", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdGreaterThan(String value) {
            addCriterion("donor_user_id >", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("donor_user_id >=", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdLessThan(String value) {
            addCriterion("donor_user_id <", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdLessThanOrEqualTo(String value) {
            addCriterion("donor_user_id <=", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdLike(String value) {
            addCriterion("donor_user_id like", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdNotLike(String value) {
            addCriterion("donor_user_id not like", value, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdIn(List<String> values) {
            addCriterion("donor_user_id in", values, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdNotIn(List<String> values) {
            addCriterion("donor_user_id not in", values, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdBetween(String value1, String value2) {
            addCriterion("donor_user_id between", value1, value2, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andDonorUserIdNotBetween(String value1, String value2) {
            addCriterion("donor_user_id not between", value1, value2, "donorUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNull() {
            addCriterion("receive_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNotNull() {
            addCriterion("receive_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdEqualTo(String value) {
            addCriterion("receive_user_id =", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotEqualTo(String value) {
            addCriterion("receive_user_id <>", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThan(String value) {
            addCriterion("receive_user_id >", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("receive_user_id >=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThan(String value) {
            addCriterion("receive_user_id <", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThanOrEqualTo(String value) {
            addCriterion("receive_user_id <=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLike(String value) {
            addCriterion("receive_user_id like", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotLike(String value) {
            addCriterion("receive_user_id not like", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIn(List<String> values) {
            addCriterion("receive_user_id in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotIn(List<String> values) {
            addCriterion("receive_user_id not in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdBetween(String value1, String value2) {
            addCriterion("receive_user_id between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotBetween(String value1, String value2) {
            addCriterion("receive_user_id not between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdIsNull() {
            addCriterion("old_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdIsNotNull() {
            addCriterion("old_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdEqualTo(String value) {
            addCriterion("old_coupon_id =", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdNotEqualTo(String value) {
            addCriterion("old_coupon_id <>", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdGreaterThan(String value) {
            addCriterion("old_coupon_id >", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("old_coupon_id >=", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdLessThan(String value) {
            addCriterion("old_coupon_id <", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdLessThanOrEqualTo(String value) {
            addCriterion("old_coupon_id <=", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdLike(String value) {
            addCriterion("old_coupon_id like", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdNotLike(String value) {
            addCriterion("old_coupon_id not like", value, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdIn(List<String> values) {
            addCriterion("old_coupon_id in", values, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdNotIn(List<String> values) {
            addCriterion("old_coupon_id not in", values, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdBetween(String value1, String value2) {
            addCriterion("old_coupon_id between", value1, value2, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andOldCouponIdNotBetween(String value1, String value2) {
            addCriterion("old_coupon_id not between", value1, value2, "oldCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdIsNull() {
            addCriterion("new_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdIsNotNull() {
            addCriterion("new_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdEqualTo(String value) {
            addCriterion("new_coupon_id =", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdNotEqualTo(String value) {
            addCriterion("new_coupon_id <>", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdGreaterThan(String value) {
            addCriterion("new_coupon_id >", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("new_coupon_id >=", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdLessThan(String value) {
            addCriterion("new_coupon_id <", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdLessThanOrEqualTo(String value) {
            addCriterion("new_coupon_id <=", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdLike(String value) {
            addCriterion("new_coupon_id like", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdNotLike(String value) {
            addCriterion("new_coupon_id not like", value, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdIn(List<String> values) {
            addCriterion("new_coupon_id in", values, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdNotIn(List<String> values) {
            addCriterion("new_coupon_id not in", values, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdBetween(String value1, String value2) {
            addCriterion("new_coupon_id between", value1, value2, "newCouponId");
            return (Criteria) this;
        }

        public Criteria andNewCouponIdNotBetween(String value1, String value2) {
            addCriterion("new_coupon_id not between", value1, value2, "newCouponId");
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

        public Criteria andAmountDataIsNull() {
            addCriterion("amount_data is null");
            return (Criteria) this;
        }

        public Criteria andAmountDataIsNotNull() {
            addCriterion("amount_data is not null");
            return (Criteria) this;
        }

        public Criteria andAmountDataEqualTo(String value) {
            addCriterion("amount_data =", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataNotEqualTo(String value) {
            addCriterion("amount_data <>", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataGreaterThan(String value) {
            addCriterion("amount_data >", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataGreaterThanOrEqualTo(String value) {
            addCriterion("amount_data >=", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataLessThan(String value) {
            addCriterion("amount_data <", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataLessThanOrEqualTo(String value) {
            addCriterion("amount_data <=", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataLike(String value) {
            addCriterion("amount_data like", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataNotLike(String value) {
            addCriterion("amount_data not like", value, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataIn(List<String> values) {
            addCriterion("amount_data in", values, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataNotIn(List<String> values) {
            addCriterion("amount_data not in", values, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataBetween(String value1, String value2) {
            addCriterion("amount_data between", value1, value2, "amountData");
            return (Criteria) this;
        }

        public Criteria andAmountDataNotBetween(String value1, String value2) {
            addCriterion("amount_data not between", value1, value2, "amountData");
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

        public Criteria andTakenTimeIsNull() {
            addCriterion("taken_time is null");
            return (Criteria) this;
        }

        public Criteria andTakenTimeIsNotNull() {
            addCriterion("taken_time is not null");
            return (Criteria) this;
        }

        public Criteria andTakenTimeEqualTo(Date value) {
            addCriterion("taken_time =", value, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeNotEqualTo(Date value) {
            addCriterion("taken_time <>", value, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeGreaterThan(Date value) {
            addCriterion("taken_time >", value, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("taken_time >=", value, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeLessThan(Date value) {
            addCriterion("taken_time <", value, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeLessThanOrEqualTo(Date value) {
            addCriterion("taken_time <=", value, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeIn(List<Date> values) {
            addCriterion("taken_time in", values, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeNotIn(List<Date> values) {
            addCriterion("taken_time not in", values, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeBetween(Date value1, Date value2) {
            addCriterion("taken_time between", value1, value2, "takenTime");
            return (Criteria) this;
        }

        public Criteria andTakenTimeNotBetween(Date value1, Date value2) {
            addCriterion("taken_time not between", value1, value2, "takenTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeIsNull() {
            addCriterion("can_apply_time is null");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeIsNotNull() {
            addCriterion("can_apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeEqualTo(Date value) {
            addCriterion("can_apply_time =", value, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeNotEqualTo(Date value) {
            addCriterion("can_apply_time <>", value, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeGreaterThan(Date value) {
            addCriterion("can_apply_time >", value, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("can_apply_time >=", value, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeLessThan(Date value) {
            addCriterion("can_apply_time <", value, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("can_apply_time <=", value, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeIn(List<Date> values) {
            addCriterion("can_apply_time in", values, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeNotIn(List<Date> values) {
            addCriterion("can_apply_time not in", values, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeBetween(Date value1, Date value2) {
            addCriterion("can_apply_time between", value1, value2, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andCanApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("can_apply_time not between", value1, value2, "canApplyTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIsNull() {
            addCriterion("valid_end_time is null");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIsNotNull() {
            addCriterion("valid_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeEqualTo(Date value) {
            addCriterion("valid_end_time =", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotEqualTo(Date value) {
            addCriterion("valid_end_time <>", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeGreaterThan(Date value) {
            addCriterion("valid_end_time >", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_end_time >=", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeLessThan(Date value) {
            addCriterion("valid_end_time <", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("valid_end_time <=", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIn(List<Date> values) {
            addCriterion("valid_end_time in", values, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotIn(List<Date> values) {
            addCriterion("valid_end_time not in", values, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeBetween(Date value1, Date value2) {
            addCriterion("valid_end_time between", value1, value2, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("valid_end_time not between", value1, value2, "validEndTime");
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