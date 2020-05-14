package dal.model.clear;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "batch_job_execution_context")
public class BatchJobExecutionContextDO implements Serializable {
    @Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long jobExecutionId;

    @Column(name = "SHORT_CONTEXT")
    private String shortContext;

    @Column(name = "SERIALIZED_CONTEXT")
    private String serializedContext;

    private static final long serialVersionUID = 1L;

    /**
     * @return JOB_EXECUTION_ID
     */
    public Long getJobExecutionId() {
        return jobExecutionId;
    }

    /**
     * @param jobExecutionId
     */
    public void setJobExecutionId(Long jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    /**
     * @return SHORT_CONTEXT
     */
    public String getShortContext() {
        return shortContext;
    }

    /**
     * @param shortContext
     */
    public void setShortContext(String shortContext) {
        this.shortContext = shortContext == null ? null : shortContext.trim();
    }

    /**
     * @return SERIALIZED_CONTEXT
     */
    public String getSerializedContext() {
        return serializedContext;
    }

    /**
     * @param serializedContext
     */
    public void setSerializedContext(String serializedContext) {
        this.serializedContext = serializedContext == null ? null : serializedContext.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", jobExecutionId=").append(jobExecutionId);
        sb.append(", shortContext=").append(shortContext);
        sb.append(", serializedContext=").append(serializedContext);
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
        BatchJobExecutionContextDO other = (BatchJobExecutionContextDO) that;
        return (this.getJobExecutionId() == null ? other.getJobExecutionId() == null : this.getJobExecutionId().equals(other.getJobExecutionId()))
            && (this.getShortContext() == null ? other.getShortContext() == null : this.getShortContext().equals(other.getShortContext()))
            && (this.getSerializedContext() == null ? other.getSerializedContext() == null : this.getSerializedContext().equals(other.getSerializedContext()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobExecutionId() == null) ? 0 : getJobExecutionId().hashCode());
        result = prime * result + ((getShortContext() == null) ? 0 : getShortContext().hashCode());
        result = prime * result + ((getSerializedContext() == null) ? 0 : getSerializedContext().hashCode());
        return result;
    }
}