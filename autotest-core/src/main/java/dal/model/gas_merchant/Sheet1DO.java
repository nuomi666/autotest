package dal.model.gas_merchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sheet1")
public class Sheet1DO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "m_id")
    private String mId;

    @Column(name = "s_name")
    private String sName;

    @Column(name = "s_id")
    private String sId;

    @Column(name = "s_code")
    private String sCode;

    @Column(name = "o_name")
    private String oName;

    @Column(name = "o_id")
    private String oId;

    @Column(name = "tatal_amount")
    private String tatalAmount;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return m_name
     */
    public String getmName() {
        return mName;
    }

    /**
     * @param mName
     */
    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    /**
     * @return m_id
     */
    public String getmId() {
        return mId;
    }

    /**
     * @param mId
     */
    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    /**
     * @return s_name
     */
    public String getsName() {
        return sName;
    }

    /**
     * @param sName
     */
    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    /**
     * @return s_id
     */
    public String getsId() {
        return sId;
    }

    /**
     * @param sId
     */
    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    /**
     * @return s_code
     */
    public String getsCode() {
        return sCode;
    }

    /**
     * @param sCode
     */
    public void setsCode(String sCode) {
        this.sCode = sCode == null ? null : sCode.trim();
    }

    /**
     * @return o_name
     */
    public String getoName() {
        return oName;
    }

    /**
     * @param oName
     */
    public void setoName(String oName) {
        this.oName = oName == null ? null : oName.trim();
    }

    /**
     * @return o_id
     */
    public String getoId() {
        return oId;
    }

    /**
     * @param oId
     */
    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    /**
     * @return tatal_amount
     */
    public String getTatalAmount() {
        return tatalAmount;
    }

    /**
     * @param tatalAmount
     */
    public void setTatalAmount(String tatalAmount) {
        this.tatalAmount = tatalAmount == null ? null : tatalAmount.trim();
    }

    /**
     * @return start_time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * @return end_time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", mName=").append(mName);
        sb.append(", mId=").append(mId);
        sb.append(", sName=").append(sName);
        sb.append(", sId=").append(sId);
        sb.append(", sCode=").append(sCode);
        sb.append(", oName=").append(oName);
        sb.append(", oId=").append(oId);
        sb.append(", tatalAmount=").append(tatalAmount);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
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
        Sheet1DO other = (Sheet1DO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getmName() == null ? other.getmName() == null : this.getmName().equals(other.getmName()))
            && (this.getmId() == null ? other.getmId() == null : this.getmId().equals(other.getmId()))
            && (this.getsName() == null ? other.getsName() == null : this.getsName().equals(other.getsName()))
            && (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getsCode() == null ? other.getsCode() == null : this.getsCode().equals(other.getsCode()))
            && (this.getoName() == null ? other.getoName() == null : this.getoName().equals(other.getoName()))
            && (this.getoId() == null ? other.getoId() == null : this.getoId().equals(other.getoId()))
            && (this.getTatalAmount() == null ? other.getTatalAmount() == null : this.getTatalAmount().equals(other.getTatalAmount()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getmName() == null) ? 0 : getmName().hashCode());
        result = prime * result + ((getmId() == null) ? 0 : getmId().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getsCode() == null) ? 0 : getsCode().hashCode());
        result = prime * result + ((getoName() == null) ? 0 : getoName().hashCode());
        result = prime * result + ((getoId() == null) ? 0 : getoId().hashCode());
        result = prime * result + ((getTatalAmount() == null) ? 0 : getTatalAmount().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        return result;
    }
}