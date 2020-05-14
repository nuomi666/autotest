package dal.model.promotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PointsDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PointsDOExample() {
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

        public Criteria andPointIdIsNull() {
            addCriterion("point_id is null");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNotNull() {
            addCriterion("point_id is not null");
            return (Criteria) this;
        }

        public Criteria andPointIdEqualTo(String value) {
            addCriterion("point_id =", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotEqualTo(String value) {
            addCriterion("point_id <>", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThan(String value) {
            addCriterion("point_id >", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThanOrEqualTo(String value) {
            addCriterion("point_id >=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThan(String value) {
            addCriterion("point_id <", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThanOrEqualTo(String value) {
            addCriterion("point_id <=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLike(String value) {
            addCriterion("point_id like", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotLike(String value) {
            addCriterion("point_id not like", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdIn(List<String> values) {
            addCriterion("point_id in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotIn(List<String> values) {
            addCriterion("point_id not in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdBetween(String value1, String value2) {
            addCriterion("point_id between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotBetween(String value1, String value2) {
            addCriterion("point_id not between", value1, value2, "pointId");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(Long value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(Long value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(Long value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(Long value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(Long value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(Long value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<Long> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<Long> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(Long value1, Long value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(Long value1, Long value2) {
            addCriterion("points not between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsIsNull() {
            addCriterion("history_subtract_points is null");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsIsNotNull() {
            addCriterion("history_subtract_points is not null");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsEqualTo(Long value) {
            addCriterion("history_subtract_points =", value, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsNotEqualTo(Long value) {
            addCriterion("history_subtract_points <>", value, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsGreaterThan(Long value) {
            addCriterion("history_subtract_points >", value, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsGreaterThanOrEqualTo(Long value) {
            addCriterion("history_subtract_points >=", value, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsLessThan(Long value) {
            addCriterion("history_subtract_points <", value, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsLessThanOrEqualTo(Long value) {
            addCriterion("history_subtract_points <=", value, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsIn(List<Long> values) {
            addCriterion("history_subtract_points in", values, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsNotIn(List<Long> values) {
            addCriterion("history_subtract_points not in", values, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsBetween(Long value1, Long value2) {
            addCriterion("history_subtract_points between", value1, value2, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistorySubtractPointsNotBetween(Long value1, Long value2) {
            addCriterion("history_subtract_points not between", value1, value2, "historySubtractPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsIsNull() {
            addCriterion("history_add_points is null");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsIsNotNull() {
            addCriterion("history_add_points is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsEqualTo(Long value) {
            addCriterion("history_add_points =", value, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsNotEqualTo(Long value) {
            addCriterion("history_add_points <>", value, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsGreaterThan(Long value) {
            addCriterion("history_add_points >", value, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsGreaterThanOrEqualTo(Long value) {
            addCriterion("history_add_points >=", value, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsLessThan(Long value) {
            addCriterion("history_add_points <", value, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsLessThanOrEqualTo(Long value) {
            addCriterion("history_add_points <=", value, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsIn(List<Long> values) {
            addCriterion("history_add_points in", values, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsNotIn(List<Long> values) {
            addCriterion("history_add_points not in", values, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsBetween(Long value1, Long value2) {
            addCriterion("history_add_points between", value1, value2, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andHistoryAddPointsNotBetween(Long value1, Long value2) {
            addCriterion("history_add_points not between", value1, value2, "historyAddPoints");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeIsNull() {
            addCriterion("last_clear_time is null");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeIsNotNull() {
            addCriterion("last_clear_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeEqualTo(Date value) {
            addCriterion("last_clear_time =", value, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeNotEqualTo(Date value) {
            addCriterion("last_clear_time <>", value, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeGreaterThan(Date value) {
            addCriterion("last_clear_time >", value, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_clear_time >=", value, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeLessThan(Date value) {
            addCriterion("last_clear_time <", value, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_clear_time <=", value, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeIn(List<Date> values) {
            addCriterion("last_clear_time in", values, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeNotIn(List<Date> values) {
            addCriterion("last_clear_time not in", values, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeBetween(Date value1, Date value2) {
            addCriterion("last_clear_time between", value1, value2, "lastClearTime");
            return (Criteria) this;
        }

        public Criteria andLastClearTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_clear_time not between", value1, value2, "lastClearTime");
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