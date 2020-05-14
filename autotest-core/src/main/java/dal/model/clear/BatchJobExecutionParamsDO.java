package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "batch_job_execution_params")
public class BatchJobExecutionParamsDO implements Serializable {
    @Column(name = "JOB_EXECUTION_ID")
    private Long jobExecutionId;

    @Column(name = "TYPE_CD")
    private String typeCd;

    @Column(name = "KEY_NAME")
    private String keyName;

    @Column(name = "STRING_VAL")
    private String stringVal;

    @Column(name = "DATE_VAL")
    private Date dateVal;

    @Column(name = "LONG_VAL")
    private Long longVal;

    @Column(name = "DOUBLE_VAL")
    private Double doubleVal;

    @Column(name = "IDENTIFYING")
    private String identifying;

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
     * @return TYPE_CD
     */
    public String getTypeCd() {
        return typeCd;
    }

    /**
     * @param typeCd
     */
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd == null ? null : typeCd.trim();
    }

    /**
     * @return KEY_NAME
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * @param keyName
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    /**
     * @return STRING_VAL
     */
    public String getStringVal() {
        return stringVal;
    }

    /**
     * @param stringVal
     */
    public void setStringVal(String stringVal) {
        this.stringVal = stringVal == null ? null : stringVal.trim();
    }

    /**
     * @return DATE_VAL
     */
    public Date getDateVal() {
        return dateVal;
    }

    /**
     * @param dateVal
     */
    public void setDateVal(Date dateVal) {
        this.dateVal = dateVal;
    }

    /**
     * @return LONG_VAL
     */
    public Long getLongVal() {
        return longVal;
    }

    /**
     * @param longVal
     */
    public void setLongVal(Long longVal) {
        this.longVal = longVal;
    }

    /**
     * @return DOUBLE_VAL
     */
    public Double getDoubleVal() {
        return doubleVal;
    }

    /**
     * @param doubleVal
     */
    public void setDoubleVal(Double doubleVal) {
        this.doubleVal = doubleVal;
    }

    /**
     * @return IDENTIFYING
     */
    public String getIdentifying() {
        return identifying;
    }

    /**
     * @param identifying
     */
    public void setIdentifying(String identifying) {
        this.identifying = identifying == null ? null : identifying.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", jobExecutionId=").append(jobExecutionId);
        sb.append(", typeCd=").append(typeCd);
        sb.append(", keyName=").append(keyName);
        sb.append(", stringVal=").append(stringVal);
        sb.append(", dateVal=").append(dateVal);
        sb.append(", longVal=").append(longVal);
        sb.append(", doubleVal=").append(doubleVal);
        sb.append(", identifying=").append(identifying);
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
        BatchJobExecutionParamsDO other = (BatchJobExecutionParamsDO) that;
        return (this.getJobExecutionId() == null ? other.getJobExecutionId() == null : this.getJobExecutionId().equals(other.getJobExecutionId()))
            && (this.getTypeCd() == null ? other.getTypeCd() == null : this.getTypeCd().equals(other.getTypeCd()))
            && (this.getKeyName() == null ? other.getKeyName() == null : this.getKeyName().equals(other.getKeyName()))
            && (this.getStringVal() == null ? other.getStringVal() == null : this.getStringVal().equals(other.getStringVal()))
            && (this.getDateVal() == null ? other.getDateVal() == null : this.getDateVal().equals(other.getDateVal()))
            && (this.getLongVal() == null ? other.getLongVal() == null : this.getLongVal().equals(other.getLongVal()))
            && (this.getDoubleVal() == null ? other.getDoubleVal() == null : this.getDoubleVal().equals(other.getDoubleVal()))
            && (this.getIdentifying() == null ? other.getIdentifying() == null : this.getIdentifying().equals(other.getIdentifying()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobExecutionId() == null) ? 0 : getJobExecutionId().hashCode());
        result = prime * result + ((getTypeCd() == null) ? 0 : getTypeCd().hashCode());
        result = prime * result + ((getKeyName() == null) ? 0 : getKeyName().hashCode());
        result = prime * result + ((getStringVal() == null) ? 0 : getStringVal().hashCode());
        result = prime * result + ((getDateVal() == null) ? 0 : getDateVal().hashCode());
        result = prime * result + ((getLongVal() == null) ? 0 : getLongVal().hashCode());
        result = prime * result + ((getDoubleVal() == null) ? 0 : getDoubleVal().hashCode());
        result = prime * result + ((getIdentifying() == null) ? 0 : getIdentifying().hashCode());
        return result;
    }
}