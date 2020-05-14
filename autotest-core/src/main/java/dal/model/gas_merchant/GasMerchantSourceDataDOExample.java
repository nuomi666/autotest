package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasMerchantSourceDataDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasMerchantSourceDataDOExample() {
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

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(String value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(String value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(String value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLike(String value) {
            addCriterion("source_type like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotLike(String value) {
            addCriterion("source_type not like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<String> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<String> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceKeyIsNull() {
            addCriterion("source_key is null");
            return (Criteria) this;
        }

        public Criteria andSourceKeyIsNotNull() {
            addCriterion("source_key is not null");
            return (Criteria) this;
        }

        public Criteria andSourceKeyEqualTo(String value) {
            addCriterion("source_key =", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyNotEqualTo(String value) {
            addCriterion("source_key <>", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyGreaterThan(String value) {
            addCriterion("source_key >", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyGreaterThanOrEqualTo(String value) {
            addCriterion("source_key >=", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyLessThan(String value) {
            addCriterion("source_key <", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyLessThanOrEqualTo(String value) {
            addCriterion("source_key <=", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyLike(String value) {
            addCriterion("source_key like", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyNotLike(String value) {
            addCriterion("source_key not like", value, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyIn(List<String> values) {
            addCriterion("source_key in", values, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyNotIn(List<String> values) {
            addCriterion("source_key not in", values, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyBetween(String value1, String value2) {
            addCriterion("source_key between", value1, value2, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andSourceKeyNotBetween(String value1, String value2) {
            addCriterion("source_key not between", value1, value2, "sourceKey");
            return (Criteria) this;
        }

        public Criteria andAuthorizedIsNull() {
            addCriterion("authorized is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizedIsNotNull() {
            addCriterion("authorized is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizedEqualTo(Byte value) {
            addCriterion("authorized =", value, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedNotEqualTo(Byte value) {
            addCriterion("authorized <>", value, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGreaterThan(Byte value) {
            addCriterion("authorized >", value, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGreaterThanOrEqualTo(Byte value) {
            addCriterion("authorized >=", value, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedLessThan(Byte value) {
            addCriterion("authorized <", value, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedLessThanOrEqualTo(Byte value) {
            addCriterion("authorized <=", value, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedIn(List<Byte> values) {
            addCriterion("authorized in", values, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedNotIn(List<Byte> values) {
            addCriterion("authorized not in", values, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedBetween(Byte value1, Byte value2) {
            addCriterion("authorized between", value1, value2, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizedNotBetween(Byte value1, Byte value2) {
            addCriterion("authorized not between", value1, value2, "authorized");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenIsNull() {
            addCriterion("authorizer_refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenIsNotNull() {
            addCriterion("authorizer_refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenEqualTo(String value) {
            addCriterion("authorizer_refresh_token =", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenNotEqualTo(String value) {
            addCriterion("authorizer_refresh_token <>", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenGreaterThan(String value) {
            addCriterion("authorizer_refresh_token >", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("authorizer_refresh_token >=", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenLessThan(String value) {
            addCriterion("authorizer_refresh_token <", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("authorizer_refresh_token <=", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenLike(String value) {
            addCriterion("authorizer_refresh_token like", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenNotLike(String value) {
            addCriterion("authorizer_refresh_token not like", value, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenIn(List<String> values) {
            addCriterion("authorizer_refresh_token in", values, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenNotIn(List<String> values) {
            addCriterion("authorizer_refresh_token not in", values, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenBetween(String value1, String value2) {
            addCriterion("authorizer_refresh_token between", value1, value2, "authorizerRefreshToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("authorizer_refresh_token not between", value1, value2, "authorizerRefreshToken");
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

        public Criteria andAuthorizerAccessTokenIsNull() {
            addCriterion("authorizer_access_token is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenIsNotNull() {
            addCriterion("authorizer_access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenEqualTo(String value) {
            addCriterion("authorizer_access_token =", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenNotEqualTo(String value) {
            addCriterion("authorizer_access_token <>", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenGreaterThan(String value) {
            addCriterion("authorizer_access_token >", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("authorizer_access_token >=", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenLessThan(String value) {
            addCriterion("authorizer_access_token <", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("authorizer_access_token <=", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenLike(String value) {
            addCriterion("authorizer_access_token like", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenNotLike(String value) {
            addCriterion("authorizer_access_token not like", value, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenIn(List<String> values) {
            addCriterion("authorizer_access_token in", values, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenNotIn(List<String> values) {
            addCriterion("authorizer_access_token not in", values, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenBetween(String value1, String value2) {
            addCriterion("authorizer_access_token between", value1, value2, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenNotBetween(String value1, String value2) {
            addCriterion("authorizer_access_token not between", value1, value2, "authorizerAccessToken");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeIsNull() {
            addCriterion("authorizer_access_token_time is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeIsNotNull() {
            addCriterion("authorizer_access_token_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeEqualTo(Date value) {
            addCriterion("authorizer_access_token_time =", value, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeNotEqualTo(Date value) {
            addCriterion("authorizer_access_token_time <>", value, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeGreaterThan(Date value) {
            addCriterion("authorizer_access_token_time >", value, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("authorizer_access_token_time >=", value, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeLessThan(Date value) {
            addCriterion("authorizer_access_token_time <", value, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeLessThanOrEqualTo(Date value) {
            addCriterion("authorizer_access_token_time <=", value, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeIn(List<Date> values) {
            addCriterion("authorizer_access_token_time in", values, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeNotIn(List<Date> values) {
            addCriterion("authorizer_access_token_time not in", values, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeBetween(Date value1, Date value2) {
            addCriterion("authorizer_access_token_time between", value1, value2, "authorizerAccessTokenTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAccessTokenTimeNotBetween(Date value1, Date value2) {
            addCriterion("authorizer_access_token_time not between", value1, value2, "authorizerAccessTokenTime");
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