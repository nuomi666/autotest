package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClearDsgjRequestLogDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClearDsgjRequestLogDOExample() {
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

        public Criteria andPlatPartnerRealNameIsNull() {
            addCriterion("plat_partner_real_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameIsNotNull() {
            addCriterion("plat_partner_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameEqualTo(String value) {
            addCriterion("plat_partner_real_name =", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotEqualTo(String value) {
            addCriterion("plat_partner_real_name <>", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameGreaterThan(String value) {
            addCriterion("plat_partner_real_name >", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("plat_partner_real_name >=", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameLessThan(String value) {
            addCriterion("plat_partner_real_name <", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameLessThanOrEqualTo(String value) {
            addCriterion("plat_partner_real_name <=", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameLike(String value) {
            addCriterion("plat_partner_real_name like", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotLike(String value) {
            addCriterion("plat_partner_real_name not like", value, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameIn(List<String> values) {
            addCriterion("plat_partner_real_name in", values, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotIn(List<String> values) {
            addCriterion("plat_partner_real_name not in", values, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameBetween(String value1, String value2) {
            addCriterion("plat_partner_real_name between", value1, value2, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andPlatPartnerRealNameNotBetween(String value1, String value2) {
            addCriterion("plat_partner_real_name not between", value1, value2, "platPartnerRealName");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIsNull() {
            addCriterion("amount_status is null");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIsNotNull() {
            addCriterion("amount_status is not null");
            return (Criteria) this;
        }

        public Criteria andAmountStatusEqualTo(String value) {
            addCriterion("amount_status =", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotEqualTo(String value) {
            addCriterion("amount_status <>", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusGreaterThan(String value) {
            addCriterion("amount_status >", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("amount_status >=", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLessThan(String value) {
            addCriterion("amount_status <", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLessThanOrEqualTo(String value) {
            addCriterion("amount_status <=", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLike(String value) {
            addCriterion("amount_status like", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotLike(String value) {
            addCriterion("amount_status not like", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIn(List<String> values) {
            addCriterion("amount_status in", values, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotIn(List<String> values) {
            addCriterion("amount_status not in", values, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusBetween(String value1, String value2) {
            addCriterion("amount_status between", value1, value2, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotBetween(String value1, String value2) {
            addCriterion("amount_status not between", value1, value2, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andClearDateIsNull() {
            addCriterion("clear_date is null");
            return (Criteria) this;
        }

        public Criteria andClearDateIsNotNull() {
            addCriterion("clear_date is not null");
            return (Criteria) this;
        }

        public Criteria andClearDateEqualTo(String value) {
            addCriterion("clear_date =", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotEqualTo(String value) {
            addCriterion("clear_date <>", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateGreaterThan(String value) {
            addCriterion("clear_date >", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateGreaterThanOrEqualTo(String value) {
            addCriterion("clear_date >=", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLessThan(String value) {
            addCriterion("clear_date <", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLessThanOrEqualTo(String value) {
            addCriterion("clear_date <=", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLike(String value) {
            addCriterion("clear_date like", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotLike(String value) {
            addCriterion("clear_date not like", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateIn(List<String> values) {
            addCriterion("clear_date in", values, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotIn(List<String> values) {
            addCriterion("clear_date not in", values, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateBetween(String value1, String value2) {
            addCriterion("clear_date between", value1, value2, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotBetween(String value1, String value2) {
            addCriterion("clear_date not between", value1, value2, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearFileNameIsNull() {
            addCriterion("clear_file_name is null");
            return (Criteria) this;
        }

        public Criteria andClearFileNameIsNotNull() {
            addCriterion("clear_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andClearFileNameEqualTo(String value) {
            addCriterion("clear_file_name =", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotEqualTo(String value) {
            addCriterion("clear_file_name <>", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameGreaterThan(String value) {
            addCriterion("clear_file_name >", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("clear_file_name >=", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameLessThan(String value) {
            addCriterion("clear_file_name <", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameLessThanOrEqualTo(String value) {
            addCriterion("clear_file_name <=", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameLike(String value) {
            addCriterion("clear_file_name like", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotLike(String value) {
            addCriterion("clear_file_name not like", value, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameIn(List<String> values) {
            addCriterion("clear_file_name in", values, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotIn(List<String> values) {
            addCriterion("clear_file_name not in", values, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameBetween(String value1, String value2) {
            addCriterion("clear_file_name between", value1, value2, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andClearFileNameNotBetween(String value1, String value2) {
            addCriterion("clear_file_name not between", value1, value2, "clearFileName");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(Long value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(Long value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(Long value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(Long value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<Long> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<Long> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(Long value1, Long value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeCountIsNull() {
            addCriterion("trade_count is null");
            return (Criteria) this;
        }

        public Criteria andTradeCountIsNotNull() {
            addCriterion("trade_count is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCountEqualTo(Integer value) {
            addCriterion("trade_count =", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotEqualTo(Integer value) {
            addCriterion("trade_count <>", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThan(Integer value) {
            addCriterion("trade_count >", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_count >=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThan(Integer value) {
            addCriterion("trade_count <", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThanOrEqualTo(Integer value) {
            addCriterion("trade_count <=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountIn(List<Integer> values) {
            addCriterion("trade_count in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotIn(List<Integer> values) {
            addCriterion("trade_count not in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountBetween(Integer value1, Integer value2) {
            addCriterion("trade_count between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_count not between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(Long value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(Long value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(Long value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(Long value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(Long value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<Long> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<Long> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(Long value1, Long value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(Long value1, Long value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNull() {
            addCriterion("refund_count is null");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNotNull() {
            addCriterion("refund_count is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCountEqualTo(Integer value) {
            addCriterion("refund_count =", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotEqualTo(Integer value) {
            addCriterion("refund_count <>", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThan(Integer value) {
            addCriterion("refund_count >", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_count >=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThan(Integer value) {
            addCriterion("refund_count <", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThanOrEqualTo(Integer value) {
            addCriterion("refund_count <=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountIn(List<Integer> values) {
            addCriterion("refund_count in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotIn(List<Integer> values) {
            addCriterion("refund_count not in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountBetween(Integer value1, Integer value2) {
            addCriterion("refund_count between", value1, value2, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_count not between", value1, value2, "refundCount");
            return (Criteria) this;
        }

        public Criteria andClearAmountIsNull() {
            addCriterion("clear_amount is null");
            return (Criteria) this;
        }

        public Criteria andClearAmountIsNotNull() {
            addCriterion("clear_amount is not null");
            return (Criteria) this;
        }

        public Criteria andClearAmountEqualTo(Long value) {
            addCriterion("clear_amount =", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountNotEqualTo(Long value) {
            addCriterion("clear_amount <>", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountGreaterThan(Long value) {
            addCriterion("clear_amount >", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("clear_amount >=", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountLessThan(Long value) {
            addCriterion("clear_amount <", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountLessThanOrEqualTo(Long value) {
            addCriterion("clear_amount <=", value, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountIn(List<Long> values) {
            addCriterion("clear_amount in", values, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountNotIn(List<Long> values) {
            addCriterion("clear_amount not in", values, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountBetween(Long value1, Long value2) {
            addCriterion("clear_amount between", value1, value2, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andClearAmountNotBetween(Long value1, Long value2) {
            addCriterion("clear_amount not between", value1, value2, "clearAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountIsNull() {
            addCriterion("partner_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountIsNotNull() {
            addCriterion("partner_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountEqualTo(Long value) {
            addCriterion("partner_fee_amount =", value, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountNotEqualTo(Long value) {
            addCriterion("partner_fee_amount <>", value, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountGreaterThan(Long value) {
            addCriterion("partner_fee_amount >", value, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("partner_fee_amount >=", value, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountLessThan(Long value) {
            addCriterion("partner_fee_amount <", value, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountLessThanOrEqualTo(Long value) {
            addCriterion("partner_fee_amount <=", value, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountIn(List<Long> values) {
            addCriterion("partner_fee_amount in", values, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountNotIn(List<Long> values) {
            addCriterion("partner_fee_amount not in", values, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountBetween(Long value1, Long value2) {
            addCriterion("partner_fee_amount between", value1, value2, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPartnerFeeAmountNotBetween(Long value1, Long value2) {
            addCriterion("partner_fee_amount not between", value1, value2, "partnerFeeAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountIsNull() {
            addCriterion("plat_share_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountIsNotNull() {
            addCriterion("plat_share_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountEqualTo(Long value) {
            addCriterion("plat_share_amount =", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountNotEqualTo(Long value) {
            addCriterion("plat_share_amount <>", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountGreaterThan(Long value) {
            addCriterion("plat_share_amount >", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("plat_share_amount >=", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountLessThan(Long value) {
            addCriterion("plat_share_amount <", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountLessThanOrEqualTo(Long value) {
            addCriterion("plat_share_amount <=", value, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountIn(List<Long> values) {
            addCriterion("plat_share_amount in", values, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountNotIn(List<Long> values) {
            addCriterion("plat_share_amount not in", values, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountBetween(Long value1, Long value2) {
            addCriterion("plat_share_amount between", value1, value2, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andPlatShareAmountNotBetween(Long value1, Long value2) {
            addCriterion("plat_share_amount not between", value1, value2, "platShareAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIsNull() {
            addCriterion("channel_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIsNotNull() {
            addCriterion("channel_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountEqualTo(Long value) {
            addCriterion("channel_fee_amount =", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotEqualTo(Long value) {
            addCriterion("channel_fee_amount <>", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountGreaterThan(Long value) {
            addCriterion("channel_fee_amount >", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_fee_amount >=", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountLessThan(Long value) {
            addCriterion("channel_fee_amount <", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountLessThanOrEqualTo(Long value) {
            addCriterion("channel_fee_amount <=", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIn(List<Long> values) {
            addCriterion("channel_fee_amount in", values, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotIn(List<Long> values) {
            addCriterion("channel_fee_amount not in", values, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountBetween(Long value1, Long value2) {
            addCriterion("channel_fee_amount between", value1, value2, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotBetween(Long value1, Long value2) {
            addCriterion("channel_fee_amount not between", value1, value2, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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