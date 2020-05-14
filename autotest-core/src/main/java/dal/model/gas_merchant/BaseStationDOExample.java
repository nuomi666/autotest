package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseStationDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseStationDOExample() {
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

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("trade_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Date value) {
            addCriterion("trade_time =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Date value) {
            addCriterion("trade_time <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Date value) {
            addCriterion("trade_time >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trade_time >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Date value) {
            addCriterion("trade_time <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("trade_time <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Date> values) {
            addCriterion("trade_time in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Date> values) {
            addCriterion("trade_time not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Date value1, Date value2) {
            addCriterion("trade_time between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("trade_time not between", value1, value2, "tradeTime");
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

        public Criteria andPartnerNameIsNull() {
            addCriterion("partner_name is null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIsNotNull() {
            addCriterion("partner_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameEqualTo(String value) {
            addCriterion("partner_name =", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotEqualTo(String value) {
            addCriterion("partner_name <>", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThan(String value) {
            addCriterion("partner_name >", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("partner_name >=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThan(String value) {
            addCriterion("partner_name <", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThanOrEqualTo(String value) {
            addCriterion("partner_name <=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLike(String value) {
            addCriterion("partner_name like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotLike(String value) {
            addCriterion("partner_name not like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIn(List<String> values) {
            addCriterion("partner_name in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotIn(List<String> values) {
            addCriterion("partner_name not in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameBetween(String value1, String value2) {
            addCriterion("partner_name between", value1, value2, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotBetween(String value1, String value2) {
            addCriterion("partner_name not between", value1, value2, "partnerName");
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

        public Criteria andStationCodeIsNull() {
            addCriterion("station_code is null");
            return (Criteria) this;
        }

        public Criteria andStationCodeIsNotNull() {
            addCriterion("station_code is not null");
            return (Criteria) this;
        }

        public Criteria andStationCodeEqualTo(String value) {
            addCriterion("station_code =", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotEqualTo(String value) {
            addCriterion("station_code <>", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThan(String value) {
            addCriterion("station_code >", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("station_code >=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThan(String value) {
            addCriterion("station_code <", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThanOrEqualTo(String value) {
            addCriterion("station_code <=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLike(String value) {
            addCriterion("station_code like", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotLike(String value) {
            addCriterion("station_code not like", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeIn(List<String> values) {
            addCriterion("station_code in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotIn(List<String> values) {
            addCriterion("station_code not in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeBetween(String value1, String value2) {
            addCriterion("station_code between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotBetween(String value1, String value2) {
            addCriterion("station_code not between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIsNull() {
            addCriterion("terminal_code is null");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIsNotNull() {
            addCriterion("terminal_code is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeEqualTo(String value) {
            addCriterion("terminal_code =", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotEqualTo(String value) {
            addCriterion("terminal_code <>", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeGreaterThan(String value) {
            addCriterion("terminal_code >", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("terminal_code >=", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLessThan(String value) {
            addCriterion("terminal_code <", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLessThanOrEqualTo(String value) {
            addCriterion("terminal_code <=", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLike(String value) {
            addCriterion("terminal_code like", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotLike(String value) {
            addCriterion("terminal_code not like", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIn(List<String> values) {
            addCriterion("terminal_code in", values, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotIn(List<String> values) {
            addCriterion("terminal_code not in", values, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeBetween(String value1, String value2) {
            addCriterion("terminal_code between", value1, value2, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotBetween(String value1, String value2) {
            addCriterion("terminal_code not between", value1, value2, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andStationPIsNull() {
            addCriterion("station_p is null");
            return (Criteria) this;
        }

        public Criteria andStationPIsNotNull() {
            addCriterion("station_p is not null");
            return (Criteria) this;
        }

        public Criteria andStationPEqualTo(Long value) {
            addCriterion("station_p =", value, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPNotEqualTo(Long value) {
            addCriterion("station_p <>", value, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPGreaterThan(Long value) {
            addCriterion("station_p >", value, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPGreaterThanOrEqualTo(Long value) {
            addCriterion("station_p >=", value, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPLessThan(Long value) {
            addCriterion("station_p <", value, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPLessThanOrEqualTo(Long value) {
            addCriterion("station_p <=", value, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPIn(List<Long> values) {
            addCriterion("station_p in", values, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPNotIn(List<Long> values) {
            addCriterion("station_p not in", values, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPBetween(Long value1, Long value2) {
            addCriterion("station_p between", value1, value2, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationPNotBetween(Long value1, Long value2) {
            addCriterion("station_p not between", value1, value2, "stationP");
            return (Criteria) this;
        }

        public Criteria andStationCIsNull() {
            addCriterion("station_c is null");
            return (Criteria) this;
        }

        public Criteria andStationCIsNotNull() {
            addCriterion("station_c is not null");
            return (Criteria) this;
        }

        public Criteria andStationCEqualTo(Long value) {
            addCriterion("station_c =", value, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCNotEqualTo(Long value) {
            addCriterion("station_c <>", value, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCGreaterThan(Long value) {
            addCriterion("station_c >", value, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCGreaterThanOrEqualTo(Long value) {
            addCriterion("station_c >=", value, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCLessThan(Long value) {
            addCriterion("station_c <", value, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCLessThanOrEqualTo(Long value) {
            addCriterion("station_c <=", value, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCIn(List<Long> values) {
            addCriterion("station_c in", values, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCNotIn(List<Long> values) {
            addCriterion("station_c not in", values, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCBetween(Long value1, Long value2) {
            addCriterion("station_c between", value1, value2, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationCNotBetween(Long value1, Long value2) {
            addCriterion("station_c not between", value1, value2, "stationC");
            return (Criteria) this;
        }

        public Criteria andStationDIsNull() {
            addCriterion("station_d is null");
            return (Criteria) this;
        }

        public Criteria andStationDIsNotNull() {
            addCriterion("station_d is not null");
            return (Criteria) this;
        }

        public Criteria andStationDEqualTo(Long value) {
            addCriterion("station_d =", value, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDNotEqualTo(Long value) {
            addCriterion("station_d <>", value, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDGreaterThan(Long value) {
            addCriterion("station_d >", value, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDGreaterThanOrEqualTo(Long value) {
            addCriterion("station_d >=", value, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDLessThan(Long value) {
            addCriterion("station_d <", value, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDLessThanOrEqualTo(Long value) {
            addCriterion("station_d <=", value, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDIn(List<Long> values) {
            addCriterion("station_d in", values, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDNotIn(List<Long> values) {
            addCriterion("station_d not in", values, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDBetween(Long value1, Long value2) {
            addCriterion("station_d between", value1, value2, "stationD");
            return (Criteria) this;
        }

        public Criteria andStationDNotBetween(Long value1, Long value2) {
            addCriterion("station_d not between", value1, value2, "stationD");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStationAddresIsNull() {
            addCriterion("station_addres is null");
            return (Criteria) this;
        }

        public Criteria andStationAddresIsNotNull() {
            addCriterion("station_addres is not null");
            return (Criteria) this;
        }

        public Criteria andStationAddresEqualTo(String value) {
            addCriterion("station_addres =", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresNotEqualTo(String value) {
            addCriterion("station_addres <>", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresGreaterThan(String value) {
            addCriterion("station_addres >", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresGreaterThanOrEqualTo(String value) {
            addCriterion("station_addres >=", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresLessThan(String value) {
            addCriterion("station_addres <", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresLessThanOrEqualTo(String value) {
            addCriterion("station_addres <=", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresLike(String value) {
            addCriterion("station_addres like", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresNotLike(String value) {
            addCriterion("station_addres not like", value, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresIn(List<String> values) {
            addCriterion("station_addres in", values, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresNotIn(List<String> values) {
            addCriterion("station_addres not in", values, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresBetween(String value1, String value2) {
            addCriterion("station_addres between", value1, value2, "stationAddres");
            return (Criteria) this;
        }

        public Criteria andStationAddresNotBetween(String value1, String value2) {
            addCriterion("station_addres not between", value1, value2, "stationAddres");
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