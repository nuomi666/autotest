package dal.model.pay;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "batch_step_execution_context")
public class BatchStepExecutionContextDO implements Serializable {
    @Id
    @Column(name = "STEP_EXECUTION_ID")
    private Long stepExecutionId;

    @Column(name = "SHORT_CONTEXT")
    private String shortContext;

    @Column(name = "SERIALIZED_CONTEXT")
    private String serializedContext;

    private static final long serialVersionUID = 1L;

    /**
     * @return STEP_EXECUTION_ID
     */
    public Long getStepExecutionId() {
        return stepExecutionId;
    }

    /**
     * @param stepExecutionId
     */
    public void setStepExecutionId(Long stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
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
        sb.append(", stepExecutionId=").append(stepExecutionId);
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
        BatchStepExecutionContextDO other = (BatchStepExecutionContextDO) that;
        return (this.getStepExecutionId() == null ? other.getStepExecutionId() == null : this.getStepExecutionId().equals(other.getStepExecutionId()))
            && (this.getShortContext() == null ? other.getShortContext() == null : this.getShortContext().equals(other.getShortContext()))
            && (this.getSerializedContext() == null ? other.getSerializedContext() == null : this.getSerializedContext().equals(other.getSerializedContext()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStepExecutionId() == null) ? 0 : getStepExecutionId().hashCode());
        result = prime * result + ((getShortContext() == null) ? 0 : getShortContext().hashCode());
        result = prime * result + ((getSerializedContext() == null) ? 0 : getSerializedContext().hashCode());
        return result;
    }
}