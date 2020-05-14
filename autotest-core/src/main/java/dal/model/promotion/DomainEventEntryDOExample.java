package dal.model.promotion;

import java.util.ArrayList;
import java.util.List;

public class DomainEventEntryDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DomainEventEntryDOExample() {
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

        public Criteria andGlobalIndexIsNull() {
            addCriterion("global_index is null");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexIsNotNull() {
            addCriterion("global_index is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexEqualTo(Long value) {
            addCriterion("global_index =", value, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexNotEqualTo(Long value) {
            addCriterion("global_index <>", value, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexGreaterThan(Long value) {
            addCriterion("global_index >", value, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("global_index >=", value, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexLessThan(Long value) {
            addCriterion("global_index <", value, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexLessThanOrEqualTo(Long value) {
            addCriterion("global_index <=", value, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexIn(List<Long> values) {
            addCriterion("global_index in", values, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexNotIn(List<Long> values) {
            addCriterion("global_index not in", values, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexBetween(Long value1, Long value2) {
            addCriterion("global_index between", value1, value2, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andGlobalIndexNotBetween(Long value1, Long value2) {
            addCriterion("global_index not between", value1, value2, "globalIndex");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierIsNull() {
            addCriterion("aggregate_identifier is null");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierIsNotNull() {
            addCriterion("aggregate_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierEqualTo(String value) {
            addCriterion("aggregate_identifier =", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierNotEqualTo(String value) {
            addCriterion("aggregate_identifier <>", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierGreaterThan(String value) {
            addCriterion("aggregate_identifier >", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("aggregate_identifier >=", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierLessThan(String value) {
            addCriterion("aggregate_identifier <", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierLessThanOrEqualTo(String value) {
            addCriterion("aggregate_identifier <=", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierLike(String value) {
            addCriterion("aggregate_identifier like", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierNotLike(String value) {
            addCriterion("aggregate_identifier not like", value, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierIn(List<String> values) {
            addCriterion("aggregate_identifier in", values, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierNotIn(List<String> values) {
            addCriterion("aggregate_identifier not in", values, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierBetween(String value1, String value2) {
            addCriterion("aggregate_identifier between", value1, value2, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andAggregateIdentifierNotBetween(String value1, String value2) {
            addCriterion("aggregate_identifier not between", value1, value2, "aggregateIdentifier");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberIsNull() {
            addCriterion("sequence_number is null");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberIsNotNull() {
            addCriterion("sequence_number is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberEqualTo(Long value) {
            addCriterion("sequence_number =", value, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberNotEqualTo(Long value) {
            addCriterion("sequence_number <>", value, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberGreaterThan(Long value) {
            addCriterion("sequence_number >", value, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("sequence_number >=", value, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberLessThan(Long value) {
            addCriterion("sequence_number <", value, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberLessThanOrEqualTo(Long value) {
            addCriterion("sequence_number <=", value, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberIn(List<Long> values) {
            addCriterion("sequence_number in", values, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberNotIn(List<Long> values) {
            addCriterion("sequence_number not in", values, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberBetween(Long value1, Long value2) {
            addCriterion("sequence_number between", value1, value2, "sequenceNumber");
            return (Criteria) this;
        }

        public Criteria andSequenceNumberNotBetween(Long value1, Long value2) {
            addCriterion("sequence_number not between", value1, value2, "sequenceNumber");
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

        public Criteria andEventIdentifierIsNull() {
            addCriterion("event_identifier is null");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierIsNotNull() {
            addCriterion("event_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierEqualTo(String value) {
            addCriterion("event_identifier =", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierNotEqualTo(String value) {
            addCriterion("event_identifier <>", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierGreaterThan(String value) {
            addCriterion("event_identifier >", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("event_identifier >=", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierLessThan(String value) {
            addCriterion("event_identifier <", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierLessThanOrEqualTo(String value) {
            addCriterion("event_identifier <=", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierLike(String value) {
            addCriterion("event_identifier like", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierNotLike(String value) {
            addCriterion("event_identifier not like", value, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierIn(List<String> values) {
            addCriterion("event_identifier in", values, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierNotIn(List<String> values) {
            addCriterion("event_identifier not in", values, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierBetween(String value1, String value2) {
            addCriterion("event_identifier between", value1, value2, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andEventIdentifierNotBetween(String value1, String value2) {
            addCriterion("event_identifier not between", value1, value2, "eventIdentifier");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionIsNull() {
            addCriterion("payload_revision is null");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionIsNotNull() {
            addCriterion("payload_revision is not null");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionEqualTo(String value) {
            addCriterion("payload_revision =", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionNotEqualTo(String value) {
            addCriterion("payload_revision <>", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionGreaterThan(String value) {
            addCriterion("payload_revision >", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("payload_revision >=", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionLessThan(String value) {
            addCriterion("payload_revision <", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionLessThanOrEqualTo(String value) {
            addCriterion("payload_revision <=", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionLike(String value) {
            addCriterion("payload_revision like", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionNotLike(String value) {
            addCriterion("payload_revision not like", value, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionIn(List<String> values) {
            addCriterion("payload_revision in", values, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionNotIn(List<String> values) {
            addCriterion("payload_revision not in", values, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionBetween(String value1, String value2) {
            addCriterion("payload_revision between", value1, value2, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadRevisionNotBetween(String value1, String value2) {
            addCriterion("payload_revision not between", value1, value2, "payloadRevision");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeIsNull() {
            addCriterion("payload_type is null");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeIsNotNull() {
            addCriterion("payload_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeEqualTo(String value) {
            addCriterion("payload_type =", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeNotEqualTo(String value) {
            addCriterion("payload_type <>", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeGreaterThan(String value) {
            addCriterion("payload_type >", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeGreaterThanOrEqualTo(String value) {
            addCriterion("payload_type >=", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeLessThan(String value) {
            addCriterion("payload_type <", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeLessThanOrEqualTo(String value) {
            addCriterion("payload_type <=", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeLike(String value) {
            addCriterion("payload_type like", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeNotLike(String value) {
            addCriterion("payload_type not like", value, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeIn(List<String> values) {
            addCriterion("payload_type in", values, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeNotIn(List<String> values) {
            addCriterion("payload_type not in", values, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeBetween(String value1, String value2) {
            addCriterion("payload_type between", value1, value2, "payloadType");
            return (Criteria) this;
        }

        public Criteria andPayloadTypeNotBetween(String value1, String value2) {
            addCriterion("payload_type not between", value1, value2, "payloadType");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(String value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(String value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(String value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(String value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(String value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLike(String value) {
            addCriterion("timestamp like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotLike(String value) {
            addCriterion("timestamp not like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<String> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<String> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(String value1, String value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(String value1, String value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
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