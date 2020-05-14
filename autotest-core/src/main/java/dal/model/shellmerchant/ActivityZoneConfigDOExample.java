package dal.model.shellmerchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityZoneConfigDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityZoneConfigDOExample() {
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

        public Criteria andActivityZoneNameIsNull() {
            addCriterion("activity_zone_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameIsNotNull() {
            addCriterion("activity_zone_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameEqualTo(String value) {
            addCriterion("activity_zone_name =", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameNotEqualTo(String value) {
            addCriterion("activity_zone_name <>", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameGreaterThan(String value) {
            addCriterion("activity_zone_name >", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_zone_name >=", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameLessThan(String value) {
            addCriterion("activity_zone_name <", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameLessThanOrEqualTo(String value) {
            addCriterion("activity_zone_name <=", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameLike(String value) {
            addCriterion("activity_zone_name like", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameNotLike(String value) {
            addCriterion("activity_zone_name not like", value, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameIn(List<String> values) {
            addCriterion("activity_zone_name in", values, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameNotIn(List<String> values) {
            addCriterion("activity_zone_name not in", values, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameBetween(String value1, String value2) {
            addCriterion("activity_zone_name between", value1, value2, "activityZoneName");
            return (Criteria) this;
        }

        public Criteria andActivityZoneNameNotBetween(String value1, String value2) {
            addCriterion("activity_zone_name not between", value1, value2, "activityZoneName");
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

        public Criteria andActivityImgUrlIsNull() {
            addCriterion("activity_img_url is null");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlIsNotNull() {
            addCriterion("activity_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlEqualTo(String value) {
            addCriterion("activity_img_url =", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotEqualTo(String value) {
            addCriterion("activity_img_url <>", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlGreaterThan(String value) {
            addCriterion("activity_img_url >", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("activity_img_url >=", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlLessThan(String value) {
            addCriterion("activity_img_url <", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlLessThanOrEqualTo(String value) {
            addCriterion("activity_img_url <=", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlLike(String value) {
            addCriterion("activity_img_url like", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotLike(String value) {
            addCriterion("activity_img_url not like", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlIn(List<String> values) {
            addCriterion("activity_img_url in", values, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotIn(List<String> values) {
            addCriterion("activity_img_url not in", values, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlBetween(String value1, String value2) {
            addCriterion("activity_img_url between", value1, value2, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotBetween(String value1, String value2) {
            addCriterion("activity_img_url not between", value1, value2, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateIsNull() {
            addCriterion("activity_show_state is null");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateIsNotNull() {
            addCriterion("activity_show_state is not null");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateEqualTo(String value) {
            addCriterion("activity_show_state =", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateNotEqualTo(String value) {
            addCriterion("activity_show_state <>", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateGreaterThan(String value) {
            addCriterion("activity_show_state >", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateGreaterThanOrEqualTo(String value) {
            addCriterion("activity_show_state >=", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateLessThan(String value) {
            addCriterion("activity_show_state <", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateLessThanOrEqualTo(String value) {
            addCriterion("activity_show_state <=", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateLike(String value) {
            addCriterion("activity_show_state like", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateNotLike(String value) {
            addCriterion("activity_show_state not like", value, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateIn(List<String> values) {
            addCriterion("activity_show_state in", values, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateNotIn(List<String> values) {
            addCriterion("activity_show_state not in", values, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateBetween(String value1, String value2) {
            addCriterion("activity_show_state between", value1, value2, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityShowStateNotBetween(String value1, String value2) {
            addCriterion("activity_show_state not between", value1, value2, "activityShowState");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlIsNull() {
            addCriterion("activity_content_url is null");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlIsNotNull() {
            addCriterion("activity_content_url is not null");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlEqualTo(String value) {
            addCriterion("activity_content_url =", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlNotEqualTo(String value) {
            addCriterion("activity_content_url <>", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlGreaterThan(String value) {
            addCriterion("activity_content_url >", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlGreaterThanOrEqualTo(String value) {
            addCriterion("activity_content_url >=", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlLessThan(String value) {
            addCriterion("activity_content_url <", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlLessThanOrEqualTo(String value) {
            addCriterion("activity_content_url <=", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlLike(String value) {
            addCriterion("activity_content_url like", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlNotLike(String value) {
            addCriterion("activity_content_url not like", value, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlIn(List<String> values) {
            addCriterion("activity_content_url in", values, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlNotIn(List<String> values) {
            addCriterion("activity_content_url not in", values, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlBetween(String value1, String value2) {
            addCriterion("activity_content_url between", value1, value2, "activityContentUrl");
            return (Criteria) this;
        }

        public Criteria andActivityContentUrlNotBetween(String value1, String value2) {
            addCriterion("activity_content_url not between", value1, value2, "activityContentUrl");
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