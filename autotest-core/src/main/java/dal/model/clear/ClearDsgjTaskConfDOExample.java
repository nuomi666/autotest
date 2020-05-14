package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClearDsgjTaskConfDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClearDsgjTaskConfDOExample() {
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

        public Criteria andClearCycleIsNull() {
            addCriterion("clear_cycle is null");
            return (Criteria) this;
        }

        public Criteria andClearCycleIsNotNull() {
            addCriterion("clear_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andClearCycleEqualTo(Integer value) {
            addCriterion("clear_cycle =", value, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleNotEqualTo(Integer value) {
            addCriterion("clear_cycle <>", value, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleGreaterThan(Integer value) {
            addCriterion("clear_cycle >", value, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("clear_cycle >=", value, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleLessThan(Integer value) {
            addCriterion("clear_cycle <", value, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleLessThanOrEqualTo(Integer value) {
            addCriterion("clear_cycle <=", value, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleIn(List<Integer> values) {
            addCriterion("clear_cycle in", values, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleNotIn(List<Integer> values) {
            addCriterion("clear_cycle not in", values, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleBetween(Integer value1, Integer value2) {
            addCriterion("clear_cycle between", value1, value2, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andClearCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("clear_cycle not between", value1, value2, "clearCycle");
            return (Criteria) this;
        }

        public Criteria andUseClearIsNull() {
            addCriterion("use_clear is null");
            return (Criteria) this;
        }

        public Criteria andUseClearIsNotNull() {
            addCriterion("use_clear is not null");
            return (Criteria) this;
        }

        public Criteria andUseClearEqualTo(String value) {
            addCriterion("use_clear =", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearNotEqualTo(String value) {
            addCriterion("use_clear <>", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearGreaterThan(String value) {
            addCriterion("use_clear >", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearGreaterThanOrEqualTo(String value) {
            addCriterion("use_clear >=", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearLessThan(String value) {
            addCriterion("use_clear <", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearLessThanOrEqualTo(String value) {
            addCriterion("use_clear <=", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearLike(String value) {
            addCriterion("use_clear like", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearNotLike(String value) {
            addCriterion("use_clear not like", value, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearIn(List<String> values) {
            addCriterion("use_clear in", values, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearNotIn(List<String> values) {
            addCriterion("use_clear not in", values, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearBetween(String value1, String value2) {
            addCriterion("use_clear between", value1, value2, "useClear");
            return (Criteria) this;
        }

        public Criteria andUseClearNotBetween(String value1, String value2) {
            addCriterion("use_clear not between", value1, value2, "useClear");
            return (Criteria) this;
        }

        public Criteria andClearTimeIsNull() {
            addCriterion("clear_time is null");
            return (Criteria) this;
        }

        public Criteria andClearTimeIsNotNull() {
            addCriterion("clear_time is not null");
            return (Criteria) this;
        }

        public Criteria andClearTimeEqualTo(String value) {
            addCriterion("clear_time =", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotEqualTo(String value) {
            addCriterion("clear_time <>", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThan(String value) {
            addCriterion("clear_time >", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThanOrEqualTo(String value) {
            addCriterion("clear_time >=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThan(String value) {
            addCriterion("clear_time <", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThanOrEqualTo(String value) {
            addCriterion("clear_time <=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLike(String value) {
            addCriterion("clear_time like", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotLike(String value) {
            addCriterion("clear_time not like", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeIn(List<String> values) {
            addCriterion("clear_time in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotIn(List<String> values) {
            addCriterion("clear_time not in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeBetween(String value1, String value2) {
            addCriterion("clear_time between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotBetween(String value1, String value2) {
            addCriterion("clear_time not between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andUseSettlementIsNull() {
            addCriterion("use_settlement is null");
            return (Criteria) this;
        }

        public Criteria andUseSettlementIsNotNull() {
            addCriterion("use_settlement is not null");
            return (Criteria) this;
        }

        public Criteria andUseSettlementEqualTo(String value) {
            addCriterion("use_settlement =", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementNotEqualTo(String value) {
            addCriterion("use_settlement <>", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementGreaterThan(String value) {
            addCriterion("use_settlement >", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementGreaterThanOrEqualTo(String value) {
            addCriterion("use_settlement >=", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementLessThan(String value) {
            addCriterion("use_settlement <", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementLessThanOrEqualTo(String value) {
            addCriterion("use_settlement <=", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementLike(String value) {
            addCriterion("use_settlement like", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementNotLike(String value) {
            addCriterion("use_settlement not like", value, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementIn(List<String> values) {
            addCriterion("use_settlement in", values, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementNotIn(List<String> values) {
            addCriterion("use_settlement not in", values, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementBetween(String value1, String value2) {
            addCriterion("use_settlement between", value1, value2, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andUseSettlementNotBetween(String value1, String value2) {
            addCriterion("use_settlement not between", value1, value2, "useSettlement");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNull() {
            addCriterion("settlement_time is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNotNull() {
            addCriterion("settlement_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeEqualTo(String value) {
            addCriterion("settlement_time =", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotEqualTo(String value) {
            addCriterion("settlement_time <>", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThan(String value) {
            addCriterion("settlement_time >", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_time >=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThan(String value) {
            addCriterion("settlement_time <", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThanOrEqualTo(String value) {
            addCriterion("settlement_time <=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLike(String value) {
            addCriterion("settlement_time like", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotLike(String value) {
            addCriterion("settlement_time not like", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIn(List<String> values) {
            addCriterion("settlement_time in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotIn(List<String> values) {
            addCriterion("settlement_time not in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeBetween(String value1, String value2) {
            addCriterion("settlement_time between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotBetween(String value1, String value2) {
            addCriterion("settlement_time not between", value1, value2, "settlementTime");
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