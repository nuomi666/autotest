package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasWechatTokenDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasWechatTokenDOExample() {
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

        public Criteria andComponentAccessTokenIsNull() {
            addCriterion("component_access_token is null");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenIsNotNull() {
            addCriterion("component_access_token is not null");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenEqualTo(String value) {
            addCriterion("component_access_token =", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotEqualTo(String value) {
            addCriterion("component_access_token <>", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenGreaterThan(String value) {
            addCriterion("component_access_token >", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("component_access_token >=", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenLessThan(String value) {
            addCriterion("component_access_token <", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("component_access_token <=", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenLike(String value) {
            addCriterion("component_access_token like", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotLike(String value) {
            addCriterion("component_access_token not like", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenIn(List<String> values) {
            addCriterion("component_access_token in", values, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotIn(List<String> values) {
            addCriterion("component_access_token not in", values, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenBetween(String value1, String value2) {
            addCriterion("component_access_token between", value1, value2, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotBetween(String value1, String value2) {
            addCriterion("component_access_token not between", value1, value2, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketIsNull() {
            addCriterion("component_verify_ticket is null");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketIsNotNull() {
            addCriterion("component_verify_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketEqualTo(String value) {
            addCriterion("component_verify_ticket =", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketNotEqualTo(String value) {
            addCriterion("component_verify_ticket <>", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketGreaterThan(String value) {
            addCriterion("component_verify_ticket >", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketGreaterThanOrEqualTo(String value) {
            addCriterion("component_verify_ticket >=", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketLessThan(String value) {
            addCriterion("component_verify_ticket <", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketLessThanOrEqualTo(String value) {
            addCriterion("component_verify_ticket <=", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketLike(String value) {
            addCriterion("component_verify_ticket like", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketNotLike(String value) {
            addCriterion("component_verify_ticket not like", value, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketIn(List<String> values) {
            addCriterion("component_verify_ticket in", values, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketNotIn(List<String> values) {
            addCriterion("component_verify_ticket not in", values, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketBetween(String value1, String value2) {
            addCriterion("component_verify_ticket between", value1, value2, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andComponentVerifyTicketNotBetween(String value1, String value2) {
            addCriterion("component_verify_ticket not between", value1, value2, "componentVerifyTicket");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeIsNull() {
            addCriterion("token_add_time is null");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeIsNotNull() {
            addCriterion("token_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeEqualTo(Date value) {
            addCriterion("token_add_time =", value, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeNotEqualTo(Date value) {
            addCriterion("token_add_time <>", value, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeGreaterThan(Date value) {
            addCriterion("token_add_time >", value, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("token_add_time >=", value, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeLessThan(Date value) {
            addCriterion("token_add_time <", value, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("token_add_time <=", value, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeIn(List<Date> values) {
            addCriterion("token_add_time in", values, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeNotIn(List<Date> values) {
            addCriterion("token_add_time not in", values, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeBetween(Date value1, Date value2) {
            addCriterion("token_add_time between", value1, value2, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTokenAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("token_add_time not between", value1, value2, "tokenAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeIsNull() {
            addCriterion("ticket_add_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeIsNotNull() {
            addCriterion("ticket_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeEqualTo(Date value) {
            addCriterion("ticket_add_time =", value, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeNotEqualTo(Date value) {
            addCriterion("ticket_add_time <>", value, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeGreaterThan(Date value) {
            addCriterion("ticket_add_time >", value, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_add_time >=", value, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeLessThan(Date value) {
            addCriterion("ticket_add_time <", value, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_add_time <=", value, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeIn(List<Date> values) {
            addCriterion("ticket_add_time in", values, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeNotIn(List<Date> values) {
            addCriterion("ticket_add_time not in", values, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_add_time between", value1, value2, "ticketAddTime");
            return (Criteria) this;
        }

        public Criteria andTicketAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_add_time not between", value1, value2, "ticketAddTime");
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