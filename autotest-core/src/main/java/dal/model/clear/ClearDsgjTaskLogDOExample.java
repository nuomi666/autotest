package dal.model.clear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClearDsgjTaskLogDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClearDsgjTaskLogDOExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(String value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(String value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(String value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(String value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(String value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(String value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLike(String value) {
            addCriterion("gid like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotLike(String value) {
            addCriterion("gid not like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<String> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<String> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(String value1, String value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(String value1, String value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andBizNoIsNull() {
            addCriterion("biz_no is null");
            return (Criteria) this;
        }

        public Criteria andBizNoIsNotNull() {
            addCriterion("biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andBizNoEqualTo(String value) {
            addCriterion("biz_no =", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotEqualTo(String value) {
            addCriterion("biz_no <>", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoGreaterThan(String value) {
            addCriterion("biz_no >", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("biz_no >=", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLessThan(String value) {
            addCriterion("biz_no <", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLessThanOrEqualTo(String value) {
            addCriterion("biz_no <=", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLike(String value) {
            addCriterion("biz_no like", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotLike(String value) {
            addCriterion("biz_no not like", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoIn(List<String> values) {
            addCriterion("biz_no in", values, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotIn(List<String> values) {
            addCriterion("biz_no not in", values, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoBetween(String value1, String value2) {
            addCriterion("biz_no between", value1, value2, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotBetween(String value1, String value2) {
            addCriterion("biz_no not between", value1, value2, "bizNo");
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

        public Criteria andClearResultFileNameIsNull() {
            addCriterion("clear_result_file_name is null");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameIsNotNull() {
            addCriterion("clear_result_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameEqualTo(String value) {
            addCriterion("clear_result_file_name =", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotEqualTo(String value) {
            addCriterion("clear_result_file_name <>", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameGreaterThan(String value) {
            addCriterion("clear_result_file_name >", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("clear_result_file_name >=", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameLessThan(String value) {
            addCriterion("clear_result_file_name <", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameLessThanOrEqualTo(String value) {
            addCriterion("clear_result_file_name <=", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameLike(String value) {
            addCriterion("clear_result_file_name like", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotLike(String value) {
            addCriterion("clear_result_file_name not like", value, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameIn(List<String> values) {
            addCriterion("clear_result_file_name in", values, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotIn(List<String> values) {
            addCriterion("clear_result_file_name not in", values, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameBetween(String value1, String value2) {
            addCriterion("clear_result_file_name between", value1, value2, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearResultFileNameNotBetween(String value1, String value2) {
            addCriterion("clear_result_file_name not between", value1, value2, "clearResultFileName");
            return (Criteria) this;
        }

        public Criteria andClearStatusIsNull() {
            addCriterion("clear_status is null");
            return (Criteria) this;
        }

        public Criteria andClearStatusIsNotNull() {
            addCriterion("clear_status is not null");
            return (Criteria) this;
        }

        public Criteria andClearStatusEqualTo(String value) {
            addCriterion("clear_status =", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotEqualTo(String value) {
            addCriterion("clear_status <>", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusGreaterThan(String value) {
            addCriterion("clear_status >", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusGreaterThanOrEqualTo(String value) {
            addCriterion("clear_status >=", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusLessThan(String value) {
            addCriterion("clear_status <", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusLessThanOrEqualTo(String value) {
            addCriterion("clear_status <=", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusLike(String value) {
            addCriterion("clear_status like", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotLike(String value) {
            addCriterion("clear_status not like", value, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusIn(List<String> values) {
            addCriterion("clear_status in", values, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotIn(List<String> values) {
            addCriterion("clear_status not in", values, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusBetween(String value1, String value2) {
            addCriterion("clear_status between", value1, value2, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andClearStatusNotBetween(String value1, String value2) {
            addCriterion("clear_status not between", value1, value2, "clearStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusIsNull() {
            addCriterion("file_status is null");
            return (Criteria) this;
        }

        public Criteria andFileStatusIsNotNull() {
            addCriterion("file_status is not null");
            return (Criteria) this;
        }

        public Criteria andFileStatusEqualTo(String value) {
            addCriterion("file_status =", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotEqualTo(String value) {
            addCriterion("file_status <>", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusGreaterThan(String value) {
            addCriterion("file_status >", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusGreaterThanOrEqualTo(String value) {
            addCriterion("file_status >=", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusLessThan(String value) {
            addCriterion("file_status <", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusLessThanOrEqualTo(String value) {
            addCriterion("file_status <=", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusLike(String value) {
            addCriterion("file_status like", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotLike(String value) {
            addCriterion("file_status not like", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusIn(List<String> values) {
            addCriterion("file_status in", values, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotIn(List<String> values) {
            addCriterion("file_status not in", values, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusBetween(String value1, String value2) {
            addCriterion("file_status between", value1, value2, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotBetween(String value1, String value2) {
            addCriterion("file_status not between", value1, value2, "fileStatus");
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

        public Criteria andClearTimeEqualTo(Date value) {
            addCriterion("clear_time =", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotEqualTo(Date value) {
            addCriterion("clear_time <>", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThan(Date value) {
            addCriterion("clear_time >", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("clear_time >=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThan(Date value) {
            addCriterion("clear_time <", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThanOrEqualTo(Date value) {
            addCriterion("clear_time <=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeIn(List<Date> values) {
            addCriterion("clear_time in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotIn(List<Date> values) {
            addCriterion("clear_time not in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeBetween(Date value1, Date value2) {
            addCriterion("clear_time between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotBetween(Date value1, Date value2) {
            addCriterion("clear_time not between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("request_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("request_time =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("request_time <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("request_time >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("request_time >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("request_time <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("request_time <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("request_time in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("request_time not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("request_time between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("request_time not between", value1, value2, "requestTime");
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