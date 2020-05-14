package dal.model.promotion;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.*;

@Table(name = "snapshot_event_entry")
public class SnapshotEventEntryDO implements Serializable {
    @Id
    @Column(name = "aggregate_identifier")
    private String aggregateIdentifier;

    @Id
    @Column(name = "sequence_number")
    private Long sequenceNumber;

    private String type;

    @Column(name = "event_identifier")
    private String eventIdentifier;

    @Column(name = "payload_revision")
    private String payloadRevision;

    @Column(name = "payload_type")
    private String payloadType;

    private String timestamp;

    @Column(name = "meta_data")
    private byte[] metaData;

    private byte[] payload;

    private static final long serialVersionUID = 1L;

    /**
     * @return aggregate_identifier
     */
    public String getAggregateIdentifier() {
        return aggregateIdentifier;
    }

    /**
     * @param aggregateIdentifier
     */
    public void setAggregateIdentifier(String aggregateIdentifier) {
        this.aggregateIdentifier = aggregateIdentifier == null ? null : aggregateIdentifier.trim();
    }

    /**
     * @return sequence_number
     */
    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * @param sequenceNumber
     */
    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return event_identifier
     */
    public String getEventIdentifier() {
        return eventIdentifier;
    }

    /**
     * @param eventIdentifier
     */
    public void setEventIdentifier(String eventIdentifier) {
        this.eventIdentifier = eventIdentifier == null ? null : eventIdentifier.trim();
    }

    /**
     * @return payload_revision
     */
    public String getPayloadRevision() {
        return payloadRevision;
    }

    /**
     * @param payloadRevision
     */
    public void setPayloadRevision(String payloadRevision) {
        this.payloadRevision = payloadRevision == null ? null : payloadRevision.trim();
    }

    /**
     * @return payload_type
     */
    public String getPayloadType() {
        return payloadType;
    }

    /**
     * @param payloadType
     */
    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType == null ? null : payloadType.trim();
    }

    /**
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
    }

    /**
     * @return meta_data
     */
    public byte[] getMetaData() {
        return metaData;
    }

    /**
     * @param metaData
     */
    public void setMetaData(byte[] metaData) {
        this.metaData = metaData;
    }

    /**
     * @return payload
     */
    public byte[] getPayload() {
        return payload;
    }

    /**
     * @param payload
     */
    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", aggregateIdentifier=").append(aggregateIdentifier);
        sb.append(", sequenceNumber=").append(sequenceNumber);
        sb.append(", type=").append(type);
        sb.append(", eventIdentifier=").append(eventIdentifier);
        sb.append(", payloadRevision=").append(payloadRevision);
        sb.append(", payloadType=").append(payloadType);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", metaData=").append(metaData);
        sb.append(", payload=").append(payload);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SnapshotEventEntryDO other = (SnapshotEventEntryDO) that;
        return (this.getAggregateIdentifier() == null ? other.getAggregateIdentifier() == null : this.getAggregateIdentifier().equals(other.getAggregateIdentifier()))
            && (this.getSequenceNumber() == null ? other.getSequenceNumber() == null : this.getSequenceNumber().equals(other.getSequenceNumber()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getEventIdentifier() == null ? other.getEventIdentifier() == null : this.getEventIdentifier().equals(other.getEventIdentifier()))
            && (this.getPayloadRevision() == null ? other.getPayloadRevision() == null : this.getPayloadRevision().equals(other.getPayloadRevision()))
            && (this.getPayloadType() == null ? other.getPayloadType() == null : this.getPayloadType().equals(other.getPayloadType()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (Arrays.equals(this.getMetaData(), other.getMetaData()))
            && (Arrays.equals(this.getPayload(), other.getPayload()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAggregateIdentifier() == null) ? 0 : getAggregateIdentifier().hashCode());
        result = prime * result + ((getSequenceNumber() == null) ? 0 : getSequenceNumber().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getEventIdentifier() == null) ? 0 : getEventIdentifier().hashCode());
        result = prime * result + ((getPayloadRevision() == null) ? 0 : getPayloadRevision().hashCode());
        result = prime * result + ((getPayloadType() == null) ? 0 : getPayloadType().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + (Arrays.hashCode(getMetaData()));
        result = prime * result + (Arrays.hashCode(getPayload()));
        return result;
    }
}