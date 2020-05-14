package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "batch_step_execution")
public class BatchStepExecutionDO implements Serializable {
    @Id
    @Column(name = "STEP_EXECUTION_ID")
    private Long stepExecutionId;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "STEP_NAME")
    private String stepName;

    @Column(name = "JOB_EXECUTION_ID")
    private Long jobExecutionId;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMMIT_COUNT")
    private Long commitCount;

    @Column(name = "READ_COUNT")
    private Long readCount;

    @Column(name = "FILTER_COUNT")
    private Long filterCount;

    @Column(name = "WRITE_COUNT")
    private Long writeCount;

    @Column(name = "READ_SKIP_COUNT")
    private Long readSkipCount;

    @Column(name = "WRITE_SKIP_COUNT")
    private Long writeSkipCount;

    @Column(name = "PROCESS_SKIP_COUNT")
    private Long processSkipCount;

    @Column(name = "ROLLBACK_COUNT")
    private Long rollbackCount;

    @Column(name = "EXIT_CODE")
    private String exitCode;

    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;

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
     * @return VERSION
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return STEP_NAME
     */
    public String getStepName() {
        return stepName;
    }

    /**
     * @param stepName
     */
    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

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
     * @return START_TIME
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return END_TIME
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return COMMIT_COUNT
     */
    public Long getCommitCount() {
        return commitCount;
    }

    /**
     * @param commitCount
     */
    public void setCommitCount(Long commitCount) {
        this.commitCount = commitCount;
    }

    /**
     * @return READ_COUNT
     */
    public Long getReadCount() {
        return readCount;
    }

    /**
     * @param readCount
     */
    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    /**
     * @return FILTER_COUNT
     */
    public Long getFilterCount() {
        return filterCount;
    }

    /**
     * @param filterCount
     */
    public void setFilterCount(Long filterCount) {
        this.filterCount = filterCount;
    }

    /**
     * @return WRITE_COUNT
     */
    public Long getWriteCount() {
        return writeCount;
    }

    /**
     * @param writeCount
     */
    public void setWriteCount(Long writeCount) {
        this.writeCount = writeCount;
    }

    /**
     * @return READ_SKIP_COUNT
     */
    public Long getReadSkipCount() {
        return readSkipCount;
    }

    /**
     * @param readSkipCount
     */
    public void setReadSkipCount(Long readSkipCount) {
        this.readSkipCount = readSkipCount;
    }

    /**
     * @return WRITE_SKIP_COUNT
     */
    public Long getWriteSkipCount() {
        return writeSkipCount;
    }

    /**
     * @param writeSkipCount
     */
    public void setWriteSkipCount(Long writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }

    /**
     * @return PROCESS_SKIP_COUNT
     */
    public Long getProcessSkipCount() {
        return processSkipCount;
    }

    /**
     * @param processSkipCount
     */
    public void setProcessSkipCount(Long processSkipCount) {
        this.processSkipCount = processSkipCount;
    }

    /**
     * @return ROLLBACK_COUNT
     */
    public Long getRollbackCount() {
        return rollbackCount;
    }

    /**
     * @param rollbackCount
     */
    public void setRollbackCount(Long rollbackCount) {
        this.rollbackCount = rollbackCount;
    }

    /**
     * @return EXIT_CODE
     */
    public String getExitCode() {
        return exitCode;
    }

    /**
     * @param exitCode
     */
    public void setExitCode(String exitCode) {
        this.exitCode = exitCode == null ? null : exitCode.trim();
    }

    /**
     * @return EXIT_MESSAGE
     */
    public String getExitMessage() {
        return exitMessage;
    }

    /**
     * @param exitMessage
     */
    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage == null ? null : exitMessage.trim();
    }

    /**
     * @return LAST_UPDATED
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", stepExecutionId=").append(stepExecutionId);
        sb.append(", version=").append(version);
        sb.append(", stepName=").append(stepName);
        sb.append(", jobExecutionId=").append(jobExecutionId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", commitCount=").append(commitCount);
        sb.append(", readCount=").append(readCount);
        sb.append(", filterCount=").append(filterCount);
        sb.append(", writeCount=").append(writeCount);
        sb.append(", readSkipCount=").append(readSkipCount);
        sb.append(", writeSkipCount=").append(writeSkipCount);
        sb.append(", processSkipCount=").append(processSkipCount);
        sb.append(", rollbackCount=").append(rollbackCount);
        sb.append(", exitCode=").append(exitCode);
        sb.append(", exitMessage=").append(exitMessage);
        sb.append(", lastUpdated=").append(lastUpdated);
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
        BatchStepExecutionDO other = (BatchStepExecutionDO) that;
        return (this.getStepExecutionId() == null ? other.getStepExecutionId() == null : this.getStepExecutionId().equals(other.getStepExecutionId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getStepName() == null ? other.getStepName() == null : this.getStepName().equals(other.getStepName()))
            && (this.getJobExecutionId() == null ? other.getJobExecutionId() == null : this.getJobExecutionId().equals(other.getJobExecutionId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCommitCount() == null ? other.getCommitCount() == null : this.getCommitCount().equals(other.getCommitCount()))
            && (this.getReadCount() == null ? other.getReadCount() == null : this.getReadCount().equals(other.getReadCount()))
            && (this.getFilterCount() == null ? other.getFilterCount() == null : this.getFilterCount().equals(other.getFilterCount()))
            && (this.getWriteCount() == null ? other.getWriteCount() == null : this.getWriteCount().equals(other.getWriteCount()))
            && (this.getReadSkipCount() == null ? other.getReadSkipCount() == null : this.getReadSkipCount().equals(other.getReadSkipCount()))
            && (this.getWriteSkipCount() == null ? other.getWriteSkipCount() == null : this.getWriteSkipCount().equals(other.getWriteSkipCount()))
            && (this.getProcessSkipCount() == null ? other.getProcessSkipCount() == null : this.getProcessSkipCount().equals(other.getProcessSkipCount()))
            && (this.getRollbackCount() == null ? other.getRollbackCount() == null : this.getRollbackCount().equals(other.getRollbackCount()))
            && (this.getExitCode() == null ? other.getExitCode() == null : this.getExitCode().equals(other.getExitCode()))
            && (this.getExitMessage() == null ? other.getExitMessage() == null : this.getExitMessage().equals(other.getExitMessage()))
            && (this.getLastUpdated() == null ? other.getLastUpdated() == null : this.getLastUpdated().equals(other.getLastUpdated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStepExecutionId() == null) ? 0 : getStepExecutionId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getStepName() == null) ? 0 : getStepName().hashCode());
        result = prime * result + ((getJobExecutionId() == null) ? 0 : getJobExecutionId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCommitCount() == null) ? 0 : getCommitCount().hashCode());
        result = prime * result + ((getReadCount() == null) ? 0 : getReadCount().hashCode());
        result = prime * result + ((getFilterCount() == null) ? 0 : getFilterCount().hashCode());
        result = prime * result + ((getWriteCount() == null) ? 0 : getWriteCount().hashCode());
        result = prime * result + ((getReadSkipCount() == null) ? 0 : getReadSkipCount().hashCode());
        result = prime * result + ((getWriteSkipCount() == null) ? 0 : getWriteSkipCount().hashCode());
        result = prime * result + ((getProcessSkipCount() == null) ? 0 : getProcessSkipCount().hashCode());
        result = prime * result + ((getRollbackCount() == null) ? 0 : getRollbackCount().hashCode());
        result = prime * result + ((getExitCode() == null) ? 0 : getExitCode().hashCode());
        result = prime * result + ((getExitMessage() == null) ? 0 : getExitMessage().hashCode());
        result = prime * result + ((getLastUpdated() == null) ? 0 : getLastUpdated().hashCode());
        return result;
    }
}