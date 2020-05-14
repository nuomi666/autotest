package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillTaskLogDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillTaskLogDOExample() {
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

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
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

        public Criteria andPartnerRealNameIsNull() {
            addCriterion("partner_real_name is null");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameIsNotNull() {
            addCriterion("partner_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameEqualTo(String value) {
            addCriterion("partner_real_name =", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotEqualTo(String value) {
            addCriterion("partner_real_name <>", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameGreaterThan(String value) {
            addCriterion("partner_real_name >", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("partner_real_name >=", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameLessThan(String value) {
            addCriterion("partner_real_name <", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameLessThanOrEqualTo(String value) {
            addCriterion("partner_real_name <=", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameLike(String value) {
            addCriterion("partner_real_name like", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotLike(String value) {
            addCriterion("partner_real_name not like", value, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameIn(List<String> values) {
            addCriterion("partner_real_name in", values, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotIn(List<String> values) {
            addCriterion("partner_real_name not in", values, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameBetween(String value1, String value2) {
            addCriterion("partner_real_name between", value1, value2, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andPartnerRealNameNotBetween(String value1, String value2) {
            addCriterion("partner_real_name not between", value1, value2, "partnerRealName");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNull() {
            addCriterion("bill_date is null");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNotNull() {
            addCriterion("bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andBillDateEqualTo(String value) {
            addCriterion("bill_date =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(String value) {
            addCriterion("bill_date <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(String value) {
            addCriterion("bill_date >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(String value) {
            addCriterion("bill_date >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(String value) {
            addCriterion("bill_date <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(String value) {
            addCriterion("bill_date <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLike(String value) {
            addCriterion("bill_date like", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotLike(String value) {
            addCriterion("bill_date not like", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<String> values) {
            addCriterion("bill_date in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<String> values) {
            addCriterion("bill_date not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(String value1, String value2) {
            addCriterion("bill_date between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(String value1, String value2) {
            addCriterion("bill_date not between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeIsNull() {
            addCriterion("bill_channel_time is null");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeIsNotNull() {
            addCriterion("bill_channel_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeEqualTo(Date value) {
            addCriterion("bill_channel_time =", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeNotEqualTo(Date value) {
            addCriterion("bill_channel_time <>", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeGreaterThan(Date value) {
            addCriterion("bill_channel_time >", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_channel_time >=", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeLessThan(Date value) {
            addCriterion("bill_channel_time <", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_channel_time <=", value, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeIn(List<Date> values) {
            addCriterion("bill_channel_time in", values, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeNotIn(List<Date> values) {
            addCriterion("bill_channel_time not in", values, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeBetween(Date value1, Date value2) {
            addCriterion("bill_channel_time between", value1, value2, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andBillChannelTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_channel_time not between", value1, value2, "billChannelTime");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNull() {
            addCriterion("channel_status is null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNotNull() {
            addCriterion("channel_status is not null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusEqualTo(String value) {
            addCriterion("channel_status =", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotEqualTo(String value) {
            addCriterion("channel_status <>", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThan(String value) {
            addCriterion("channel_status >", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThanOrEqualTo(String value) {
            addCriterion("channel_status >=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThan(String value) {
            addCriterion("channel_status <", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThanOrEqualTo(String value) {
            addCriterion("channel_status <=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLike(String value) {
            addCriterion("channel_status like", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotLike(String value) {
            addCriterion("channel_status not like", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIn(List<String> values) {
            addCriterion("channel_status in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotIn(List<String> values) {
            addCriterion("channel_status not in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusBetween(String value1, String value2) {
            addCriterion("channel_status between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotBetween(String value1, String value2) {
            addCriterion("channel_status not between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelCommentIsNull() {
            addCriterion("channel_comment is null");
            return (Criteria) this;
        }

        public Criteria andChannelCommentIsNotNull() {
            addCriterion("channel_comment is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCommentEqualTo(String value) {
            addCriterion("channel_comment =", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentNotEqualTo(String value) {
            addCriterion("channel_comment <>", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentGreaterThan(String value) {
            addCriterion("channel_comment >", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentGreaterThanOrEqualTo(String value) {
            addCriterion("channel_comment >=", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentLessThan(String value) {
            addCriterion("channel_comment <", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentLessThanOrEqualTo(String value) {
            addCriterion("channel_comment <=", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentLike(String value) {
            addCriterion("channel_comment like", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentNotLike(String value) {
            addCriterion("channel_comment not like", value, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentIn(List<String> values) {
            addCriterion("channel_comment in", values, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentNotIn(List<String> values) {
            addCriterion("channel_comment not in", values, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentBetween(String value1, String value2) {
            addCriterion("channel_comment between", value1, value2, "channelComment");
            return (Criteria) this;
        }

        public Criteria andChannelCommentNotBetween(String value1, String value2) {
            addCriterion("channel_comment not between", value1, value2, "channelComment");
            return (Criteria) this;
        }

        public Criteria andBillTimeIsNull() {
            addCriterion("bill_time is null");
            return (Criteria) this;
        }

        public Criteria andBillTimeIsNotNull() {
            addCriterion("bill_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillTimeEqualTo(Date value) {
            addCriterion("bill_time =", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeNotEqualTo(Date value) {
            addCriterion("bill_time <>", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeGreaterThan(Date value) {
            addCriterion("bill_time >", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_time >=", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeLessThan(Date value) {
            addCriterion("bill_time <", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_time <=", value, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeIn(List<Date> values) {
            addCriterion("bill_time in", values, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeNotIn(List<Date> values) {
            addCriterion("bill_time not in", values, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeBetween(Date value1, Date value2) {
            addCriterion("bill_time between", value1, value2, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_time not between", value1, value2, "billTime");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(String value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(String value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(String value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(String value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLike(String value) {
            addCriterion("bill_status like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotLike(String value) {
            addCriterion("bill_status not like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<String> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<String> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(String value1, String value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(String value1, String value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillCommentIsNull() {
            addCriterion("bill_comment is null");
            return (Criteria) this;
        }

        public Criteria andBillCommentIsNotNull() {
            addCriterion("bill_comment is not null");
            return (Criteria) this;
        }

        public Criteria andBillCommentEqualTo(String value) {
            addCriterion("bill_comment =", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentNotEqualTo(String value) {
            addCriterion("bill_comment <>", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentGreaterThan(String value) {
            addCriterion("bill_comment >", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentGreaterThanOrEqualTo(String value) {
            addCriterion("bill_comment >=", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentLessThan(String value) {
            addCriterion("bill_comment <", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentLessThanOrEqualTo(String value) {
            addCriterion("bill_comment <=", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentLike(String value) {
            addCriterion("bill_comment like", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentNotLike(String value) {
            addCriterion("bill_comment not like", value, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentIn(List<String> values) {
            addCriterion("bill_comment in", values, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentNotIn(List<String> values) {
            addCriterion("bill_comment not in", values, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentBetween(String value1, String value2) {
            addCriterion("bill_comment between", value1, value2, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillCommentNotBetween(String value1, String value2) {
            addCriterion("bill_comment not between", value1, value2, "billComment");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusIsNull() {
            addCriterion("bill_file_status is null");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusIsNotNull() {
            addCriterion("bill_file_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusEqualTo(String value) {
            addCriterion("bill_file_status =", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusNotEqualTo(String value) {
            addCriterion("bill_file_status <>", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusGreaterThan(String value) {
            addCriterion("bill_file_status >", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bill_file_status >=", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusLessThan(String value) {
            addCriterion("bill_file_status <", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusLessThanOrEqualTo(String value) {
            addCriterion("bill_file_status <=", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusLike(String value) {
            addCriterion("bill_file_status like", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusNotLike(String value) {
            addCriterion("bill_file_status not like", value, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusIn(List<String> values) {
            addCriterion("bill_file_status in", values, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusNotIn(List<String> values) {
            addCriterion("bill_file_status not in", values, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusBetween(String value1, String value2) {
            addCriterion("bill_file_status between", value1, value2, "billFileStatus");
            return (Criteria) this;
        }

        public Criteria andBillFileStatusNotBetween(String value1, String value2) {
            addCriterion("bill_file_status not between", value1, value2, "billFileStatus");
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