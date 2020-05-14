package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "batch_job_execution")
public class BatchJobExecutionDO implements Serializable {
    @Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long jobExecutionId;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "JOB_INSTANCE_ID")
    private Long jobInstanceId;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EXIT_CODE")
    private String exitCode;

    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;

    @Column(name = "JOB_CONFIGURATION_LOCATION")
    private String jobConfigurationLocation;

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
     * @return JOB_INSTANCE_ID
     */
    public Long getJobInstanceId() {
        return jobInstanceId;
    }

    /**
     * @param jobInstanceId
     */
    public void setJobInstanceId(Long jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    /**
     * @return JOB_CONFIGURATION_LOCATION
     */
    public String getJobConfigurationLocation() {
        return jobConfigurationLocation;
    }

    /**
     * @param jobConfigurationLocation
     */
    public void setJobConfigurationLocation(String jobConfigurationLocation) {
        this.jobConfigurationLocation = jobConfigurationLocation == null ? null : jobConfigurationLocation.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", jobExecutionId=").append(jobExecutionId);
        sb.append(", version=").append(version);
        sb.append(", jobInstanceId=").append(jobInstanceId);
        sb.append(", createTime=").append(createTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", exitCode=").append(exitCode);
        sb.append(", exitMessage=").append(exitMessage);
        sb.append(", lastUpdated=").append(lastUpdated);
        sb.append(", jobConfigurationLocation=").append(jobConfigurationLocation);
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
        BatchJobExecutionDO other = (BatchJobExecutionDO) that;
        return (this.getJobExecutionId() == null ? other.getJobExecutionId() == null : this.getJobExecutionId().equals(other.getJobExecutionId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getJobInstanceId() == null ? other.getJobInstanceId() == null : this.getJobInstanceId().equals(other.getJobInstanceId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getExitCode() == null ? other.getExitCode() == null : this.getExitCode().equals(other.getExitCode()))
            && (this.getExitMessage() == null ? other.getExitMessage() == null : this.getExitMessage().equals(other.getExitMessage()))
            && (this.getLastUpdated() == null ? other.getLastUpdated() == null : this.getLastUpdated().equals(other.getLastUpdated()))
            && (this.getJobConfigurationLocation() == null ? other.getJobConfigurationLocation() == null : this.getJobConfigurationLocation().equals(other.getJobConfigurationLocation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobExecutionId() == null) ? 0 : getJobExecutionId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getJobInstanceId() == null) ? 0 : getJobInstanceId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getExitCode() == null) ? 0 : getExitCode().hashCode());
        result = prime * result + ((getExitMessage() == null) ? 0 : getExitMessage().hashCode());
        result = prime * result + ((getLastUpdated() == null) ? 0 : getLastUpdated().hashCode());
        result = prime * result + ((getJobConfigurationLocation() == null) ? 0 : getJobConfigurationLocation().hashCode());
        return result;
    }
}