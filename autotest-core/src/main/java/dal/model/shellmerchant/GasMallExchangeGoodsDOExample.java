package dal.model.shellmerchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasMallExchangeGoodsDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasMallExchangeGoodsDOExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIsNull() {
            addCriterion("goods_description is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIsNotNull() {
            addCriterion("goods_description is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionEqualTo(String value) {
            addCriterion("goods_description =", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotEqualTo(String value) {
            addCriterion("goods_description <>", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionGreaterThan(String value) {
            addCriterion("goods_description >", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("goods_description >=", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLessThan(String value) {
            addCriterion("goods_description <", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLessThanOrEqualTo(String value) {
            addCriterion("goods_description <=", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLike(String value) {
            addCriterion("goods_description like", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotLike(String value) {
            addCriterion("goods_description not like", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIn(List<String> values) {
            addCriterion("goods_description in", values, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotIn(List<String> values) {
            addCriterion("goods_description not in", values, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionBetween(String value1, String value2) {
            addCriterion("goods_description between", value1, value2, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotBetween(String value1, String value2) {
            addCriterion("goods_description not between", value1, value2, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNull() {
            addCriterion("goods_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNotNull() {
            addCriterion("goods_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgEqualTo(String value) {
            addCriterion("goods_img =", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotEqualTo(String value) {
            addCriterion("goods_img <>", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThan(String value) {
            addCriterion("goods_img >", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_img >=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThan(String value) {
            addCriterion("goods_img <", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThanOrEqualTo(String value) {
            addCriterion("goods_img <=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLike(String value) {
            addCriterion("goods_img like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotLike(String value) {
            addCriterion("goods_img not like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIn(List<String> values) {
            addCriterion("goods_img in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotIn(List<String> values) {
            addCriterion("goods_img not in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgBetween(String value1, String value2) {
            addCriterion("goods_img between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotBetween(String value1, String value2) {
            addCriterion("goods_img not between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeIsNull() {
            addCriterion("for_sale_time is null");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeIsNotNull() {
            addCriterion("for_sale_time is not null");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeEqualTo(Date value) {
            addCriterion("for_sale_time =", value, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeNotEqualTo(Date value) {
            addCriterion("for_sale_time <>", value, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeGreaterThan(Date value) {
            addCriterion("for_sale_time >", value, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("for_sale_time >=", value, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeLessThan(Date value) {
            addCriterion("for_sale_time <", value, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeLessThanOrEqualTo(Date value) {
            addCriterion("for_sale_time <=", value, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeIn(List<Date> values) {
            addCriterion("for_sale_time in", values, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeNotIn(List<Date> values) {
            addCriterion("for_sale_time not in", values, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeBetween(Date value1, Date value2) {
            addCriterion("for_sale_time between", value1, value2, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andForSaleTimeNotBetween(Date value1, Date value2) {
            addCriterion("for_sale_time not between", value1, value2, "forSaleTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNull() {
            addCriterion("invalid_time is null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNotNull() {
            addCriterion("invalid_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeEqualTo(Date value) {
            addCriterion("invalid_time =", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotEqualTo(Date value) {
            addCriterion("invalid_time <>", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThan(Date value) {
            addCriterion("invalid_time >", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invalid_time >=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThan(Date value) {
            addCriterion("invalid_time <", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThanOrEqualTo(Date value) {
            addCriterion("invalid_time <=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIn(List<Date> values) {
            addCriterion("invalid_time in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotIn(List<Date> values) {
            addCriterion("invalid_time not in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeBetween(Date value1, Date value2) {
            addCriterion("invalid_time between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotBetween(Date value1, Date value2) {
            addCriterion("invalid_time not between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andExchangePointIsNull() {
            addCriterion("exchange_point is null");
            return (Criteria) this;
        }

        public Criteria andExchangePointIsNotNull() {
            addCriterion("exchange_point is not null");
            return (Criteria) this;
        }

        public Criteria andExchangePointEqualTo(Integer value) {
            addCriterion("exchange_point =", value, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointNotEqualTo(Integer value) {
            addCriterion("exchange_point <>", value, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointGreaterThan(Integer value) {
            addCriterion("exchange_point >", value, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchange_point >=", value, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointLessThan(Integer value) {
            addCriterion("exchange_point <", value, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointLessThanOrEqualTo(Integer value) {
            addCriterion("exchange_point <=", value, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointIn(List<Integer> values) {
            addCriterion("exchange_point in", values, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointNotIn(List<Integer> values) {
            addCriterion("exchange_point not in", values, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointBetween(Integer value1, Integer value2) {
            addCriterion("exchange_point between", value1, value2, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andExchangePointNotBetween(Integer value1, Integer value2) {
            addCriterion("exchange_point not between", value1, value2, "exchangePoint");
            return (Criteria) this;
        }

        public Criteria andStoreNumIsNull() {
            addCriterion("store_num is null");
            return (Criteria) this;
        }

        public Criteria andStoreNumIsNotNull() {
            addCriterion("store_num is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNumEqualTo(Integer value) {
            addCriterion("store_num =", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumNotEqualTo(Integer value) {
            addCriterion("store_num <>", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumGreaterThan(Integer value) {
            addCriterion("store_num >", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_num >=", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumLessThan(Integer value) {
            addCriterion("store_num <", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumLessThanOrEqualTo(Integer value) {
            addCriterion("store_num <=", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumIn(List<Integer> values) {
            addCriterion("store_num in", values, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumNotIn(List<Integer> values) {
            addCriterion("store_num not in", values, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumBetween(Integer value1, Integer value2) {
            addCriterion("store_num between", value1, value2, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumNotBetween(Integer value1, Integer value2) {
            addCriterion("store_num not between", value1, value2, "storeNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumIsNull() {
            addCriterion("freeze_store_num is null");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumIsNotNull() {
            addCriterion("freeze_store_num is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumEqualTo(Integer value) {
            addCriterion("freeze_store_num =", value, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumNotEqualTo(Integer value) {
            addCriterion("freeze_store_num <>", value, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumGreaterThan(Integer value) {
            addCriterion("freeze_store_num >", value, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeze_store_num >=", value, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumLessThan(Integer value) {
            addCriterion("freeze_store_num <", value, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumLessThanOrEqualTo(Integer value) {
            addCriterion("freeze_store_num <=", value, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumIn(List<Integer> values) {
            addCriterion("freeze_store_num in", values, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumNotIn(List<Integer> values) {
            addCriterion("freeze_store_num not in", values, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumBetween(Integer value1, Integer value2) {
            addCriterion("freeze_store_num between", value1, value2, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andFreezeStoreNumNotBetween(Integer value1, Integer value2) {
            addCriterion("freeze_store_num not between", value1, value2, "freezeStoreNum");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesIsNull() {
            addCriterion("one_exchange_times is null");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesIsNotNull() {
            addCriterion("one_exchange_times is not null");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesEqualTo(Integer value) {
            addCriterion("one_exchange_times =", value, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesNotEqualTo(Integer value) {
            addCriterion("one_exchange_times <>", value, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesGreaterThan(Integer value) {
            addCriterion("one_exchange_times >", value, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("one_exchange_times >=", value, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesLessThan(Integer value) {
            addCriterion("one_exchange_times <", value, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesLessThanOrEqualTo(Integer value) {
            addCriterion("one_exchange_times <=", value, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesIn(List<Integer> values) {
            addCriterion("one_exchange_times in", values, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesNotIn(List<Integer> values) {
            addCriterion("one_exchange_times not in", values, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesBetween(Integer value1, Integer value2) {
            addCriterion("one_exchange_times between", value1, value2, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andOneExchangeTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("one_exchange_times not between", value1, value2, "oneExchangeTimes");
            return (Criteria) this;
        }

        public Criteria andGainStyleIsNull() {
            addCriterion("gain_style is null");
            return (Criteria) this;
        }

        public Criteria andGainStyleIsNotNull() {
            addCriterion("gain_style is not null");
            return (Criteria) this;
        }

        public Criteria andGainStyleEqualTo(String value) {
            addCriterion("gain_style =", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleNotEqualTo(String value) {
            addCriterion("gain_style <>", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleGreaterThan(String value) {
            addCriterion("gain_style >", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleGreaterThanOrEqualTo(String value) {
            addCriterion("gain_style >=", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleLessThan(String value) {
            addCriterion("gain_style <", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleLessThanOrEqualTo(String value) {
            addCriterion("gain_style <=", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleLike(String value) {
            addCriterion("gain_style like", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleNotLike(String value) {
            addCriterion("gain_style not like", value, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleIn(List<String> values) {
            addCriterion("gain_style in", values, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleNotIn(List<String> values) {
            addCriterion("gain_style not in", values, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleBetween(String value1, String value2) {
            addCriterion("gain_style between", value1, value2, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStyleNotBetween(String value1, String value2) {
            addCriterion("gain_style not between", value1, value2, "gainStyle");
            return (Criteria) this;
        }

        public Criteria andGainStationIsNull() {
            addCriterion("gain_station is null");
            return (Criteria) this;
        }

        public Criteria andGainStationIsNotNull() {
            addCriterion("gain_station is not null");
            return (Criteria) this;
        }

        public Criteria andGainStationEqualTo(String value) {
            addCriterion("gain_station =", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationNotEqualTo(String value) {
            addCriterion("gain_station <>", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationGreaterThan(String value) {
            addCriterion("gain_station >", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationGreaterThanOrEqualTo(String value) {
            addCriterion("gain_station >=", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationLessThan(String value) {
            addCriterion("gain_station <", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationLessThanOrEqualTo(String value) {
            addCriterion("gain_station <=", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationLike(String value) {
            addCriterion("gain_station like", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationNotLike(String value) {
            addCriterion("gain_station not like", value, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationIn(List<String> values) {
            addCriterion("gain_station in", values, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationNotIn(List<String> values) {
            addCriterion("gain_station not in", values, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationBetween(String value1, String value2) {
            addCriterion("gain_station between", value1, value2, "gainStation");
            return (Criteria) this;
        }

        public Criteria andGainStationNotBetween(String value1, String value2) {
            addCriterion("gain_station not between", value1, value2, "gainStation");
            return (Criteria) this;
        }

        public Criteria andExchangedCountIsNull() {
            addCriterion("exchanged_count is null");
            return (Criteria) this;
        }

        public Criteria andExchangedCountIsNotNull() {
            addCriterion("exchanged_count is not null");
            return (Criteria) this;
        }

        public Criteria andExchangedCountEqualTo(Integer value) {
            addCriterion("exchanged_count =", value, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountNotEqualTo(Integer value) {
            addCriterion("exchanged_count <>", value, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountGreaterThan(Integer value) {
            addCriterion("exchanged_count >", value, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchanged_count >=", value, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountLessThan(Integer value) {
            addCriterion("exchanged_count <", value, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountLessThanOrEqualTo(Integer value) {
            addCriterion("exchanged_count <=", value, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountIn(List<Integer> values) {
            addCriterion("exchanged_count in", values, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountNotIn(List<Integer> values) {
            addCriterion("exchanged_count not in", values, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountBetween(Integer value1, Integer value2) {
            addCriterion("exchanged_count between", value1, value2, "exchangedCount");
            return (Criteria) this;
        }

        public Criteria andExchangedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("exchanged_count not between", value1, value2, "exchangedCount");
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