package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasMerchantPaywayCopy1DOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasMerchantPaywayCopy1DOExample() {
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

        public Criteria andPaywayCodeIsNull() {
            addCriterion("payway_code is null");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeIsNotNull() {
            addCriterion("payway_code is not null");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeEqualTo(String value) {
            addCriterion("payway_code =", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeNotEqualTo(String value) {
            addCriterion("payway_code <>", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeGreaterThan(String value) {
            addCriterion("payway_code >", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("payway_code >=", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeLessThan(String value) {
            addCriterion("payway_code <", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeLessThanOrEqualTo(String value) {
            addCriterion("payway_code <=", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeLike(String value) {
            addCriterion("payway_code like", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeNotLike(String value) {
            addCriterion("payway_code not like", value, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeIn(List<String> values) {
            addCriterion("payway_code in", values, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeNotIn(List<String> values) {
            addCriterion("payway_code not in", values, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeBetween(String value1, String value2) {
            addCriterion("payway_code between", value1, value2, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayCodeNotBetween(String value1, String value2) {
            addCriterion("payway_code not between", value1, value2, "paywayCode");
            return (Criteria) this;
        }

        public Criteria andPaywayNameIsNull() {
            addCriterion("payway_name is null");
            return (Criteria) this;
        }

        public Criteria andPaywayNameIsNotNull() {
            addCriterion("payway_name is not null");
            return (Criteria) this;
        }

        public Criteria andPaywayNameEqualTo(String value) {
            addCriterion("payway_name =", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameNotEqualTo(String value) {
            addCriterion("payway_name <>", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameGreaterThan(String value) {
            addCriterion("payway_name >", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameGreaterThanOrEqualTo(String value) {
            addCriterion("payway_name >=", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameLessThan(String value) {
            addCriterion("payway_name <", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameLessThanOrEqualTo(String value) {
            addCriterion("payway_name <=", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameLike(String value) {
            addCriterion("payway_name like", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameNotLike(String value) {
            addCriterion("payway_name not like", value, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameIn(List<String> values) {
            addCriterion("payway_name in", values, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameNotIn(List<String> values) {
            addCriterion("payway_name not in", values, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameBetween(String value1, String value2) {
            addCriterion("payway_name between", value1, value2, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayNameNotBetween(String value1, String value2) {
            addCriterion("payway_name not between", value1, value2, "paywayName");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeIsNull() {
            addCriterion("payway_type is null");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeIsNotNull() {
            addCriterion("payway_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeEqualTo(String value) {
            addCriterion("payway_type =", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeNotEqualTo(String value) {
            addCriterion("payway_type <>", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeGreaterThan(String value) {
            addCriterion("payway_type >", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("payway_type >=", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeLessThan(String value) {
            addCriterion("payway_type <", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeLessThanOrEqualTo(String value) {
            addCriterion("payway_type <=", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeLike(String value) {
            addCriterion("payway_type like", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeNotLike(String value) {
            addCriterion("payway_type not like", value, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeIn(List<String> values) {
            addCriterion("payway_type in", values, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeNotIn(List<String> values) {
            addCriterion("payway_type not in", values, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeBetween(String value1, String value2) {
            addCriterion("payway_type between", value1, value2, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayTypeNotBetween(String value1, String value2) {
            addCriterion("payway_type not between", value1, value2, "paywayType");
            return (Criteria) this;
        }

        public Criteria andPaywayIconIsNull() {
            addCriterion("payway_icon is null");
            return (Criteria) this;
        }

        public Criteria andPaywayIconIsNotNull() {
            addCriterion("payway_icon is not null");
            return (Criteria) this;
        }

        public Criteria andPaywayIconEqualTo(String value) {
            addCriterion("payway_icon =", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconNotEqualTo(String value) {
            addCriterion("payway_icon <>", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconGreaterThan(String value) {
            addCriterion("payway_icon >", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconGreaterThanOrEqualTo(String value) {
            addCriterion("payway_icon >=", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconLessThan(String value) {
            addCriterion("payway_icon <", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconLessThanOrEqualTo(String value) {
            addCriterion("payway_icon <=", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconLike(String value) {
            addCriterion("payway_icon like", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconNotLike(String value) {
            addCriterion("payway_icon not like", value, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconIn(List<String> values) {
            addCriterion("payway_icon in", values, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconNotIn(List<String> values) {
            addCriterion("payway_icon not in", values, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconBetween(String value1, String value2) {
            addCriterion("payway_icon between", value1, value2, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywayIconNotBetween(String value1, String value2) {
            addCriterion("payway_icon not between", value1, value2, "paywayIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconIsNull() {
            addCriterion("payway_small_icon is null");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconIsNotNull() {
            addCriterion("payway_small_icon is not null");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconEqualTo(String value) {
            addCriterion("payway_small_icon =", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconNotEqualTo(String value) {
            addCriterion("payway_small_icon <>", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconGreaterThan(String value) {
            addCriterion("payway_small_icon >", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconGreaterThanOrEqualTo(String value) {
            addCriterion("payway_small_icon >=", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconLessThan(String value) {
            addCriterion("payway_small_icon <", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconLessThanOrEqualTo(String value) {
            addCriterion("payway_small_icon <=", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconLike(String value) {
            addCriterion("payway_small_icon like", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconNotLike(String value) {
            addCriterion("payway_small_icon not like", value, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconIn(List<String> values) {
            addCriterion("payway_small_icon in", values, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconNotIn(List<String> values) {
            addCriterion("payway_small_icon not in", values, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconBetween(String value1, String value2) {
            addCriterion("payway_small_icon between", value1, value2, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPaywaySmallIconNotBetween(String value1, String value2) {
            addCriterion("payway_small_icon not between", value1, value2, "paywaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNull() {
            addCriterion("channel_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("channel_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("channel_code =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("channel_code <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("channel_code >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_code >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("channel_code <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("channel_code <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("channel_code like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("channel_code not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("channel_code in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("channel_code not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("channel_code between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("channel_code not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionIsNull() {
            addCriterion("channel_function is null");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionIsNotNull() {
            addCriterion("channel_function is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionEqualTo(String value) {
            addCriterion("channel_function =", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotEqualTo(String value) {
            addCriterion("channel_function <>", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionGreaterThan(String value) {
            addCriterion("channel_function >", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("channel_function >=", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionLessThan(String value) {
            addCriterion("channel_function <", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionLessThanOrEqualTo(String value) {
            addCriterion("channel_function <=", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionLike(String value) {
            addCriterion("channel_function like", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotLike(String value) {
            addCriterion("channel_function not like", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionIn(List<String> values) {
            addCriterion("channel_function in", values, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotIn(List<String> values) {
            addCriterion("channel_function not in", values, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionBetween(String value1, String value2) {
            addCriterion("channel_function between", value1, value2, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotBetween(String value1, String value2) {
            addCriterion("channel_function not between", value1, value2, "channelFunction");
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