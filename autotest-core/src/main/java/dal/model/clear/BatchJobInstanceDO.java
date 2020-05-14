package dal.model.clear;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "batch_job_instance")
public class BatchJobInstanceDO implements Serializable {
    @Id
    @Column(name = "JOB_INSTANCE_ID")
    private Long jobInstanceId;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "JOB_KEY")
    private String jobKey;

    private static final long serialVersionUID = 1L;

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
     * @return JOB_NAME
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     * @return JOB_KEY
     */
    public String getJobKey() {
        return jobKey;
    }

    /**
     * @param jobKey
     */
    public void setJobKey(String jobKey) {
        this.jobKey = jobKey == null ? null : jobKey.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", jobInstanceId=").append(jobInstanceId);
        sb.append(", version=").append(version);
        sb.append(", jobName=").append(jobName);
        sb.append(", jobKey=").append(jobKey);
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
        BatchJobInstanceDO other = (BatchJobInstanceDO) that;
        return (this.getJobInstanceId() == null ? other.getJobInstanceId() == null : this.getJobInstanceId().equals(other.getJobInstanceId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getJobKey() == null ? other.getJobKey() == null : this.getJobKey().equals(other.getJobKey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobInstanceId() == null) ? 0 : getJobInstanceId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getJobKey() == null) ? 0 : getJobKey().hashCode());
        return result;
    }
}