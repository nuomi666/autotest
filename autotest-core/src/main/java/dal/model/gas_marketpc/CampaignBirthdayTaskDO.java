package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "campaign_birthday_task")
public class CampaignBirthdayTaskDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 执行时间
     */
    @Column(name = "execute_time")
    private String executeTime;

    /**
     * 生日(MM-dd,如09-09)
     */
    @Column(name = "short_birthday")
    private String shortBirthday;

    /**
     * 满足条件的用户的总数
     */
    private Long total;

    /**
     * 执行状态
     */
    private String status;

    /**
     * gid
     */
    private String gid;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取执行时间
     *
     * @return execute_time - 执行时间
     */
    public String getExecuteTime() {
        return executeTime;
    }

    /**
     * 设置执行时间
     *
     * @param executeTime 执行时间
     */
    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime == null ? null : executeTime.trim();
    }

    /**
     * 获取生日(MM-dd,如09-09)
     *
     * @return short_birthday - 生日(MM-dd,如09-09)
     */
    public String getShortBirthday() {
        return shortBirthday;
    }

    /**
     * 设置生日(MM-dd,如09-09)
     *
     * @param shortBirthday 生日(MM-dd,如09-09)
     */
    public void setShortBirthday(String shortBirthday) {
        this.shortBirthday = shortBirthday == null ? null : shortBirthday.trim();
    }

    /**
     * 获取满足条件的用户的总数
     *
     * @return total - 满足条件的用户的总数
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置满足条件的用户的总数
     *
     * @param total 满足条件的用户的总数
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取执行状态
     *
     * @return status - 执行状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置执行状态
     *
     * @param status 执行状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取gid
     *
     * @return gid - gid
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置gid
     *
     * @param gid gid
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * @return raw_add_time
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * @param rawAddTime
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * @return raw_update_time
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * @param rawUpdateTime
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", executeTime=").append(executeTime);
        sb.append(", shortBirthday=").append(shortBirthday);
        sb.append(", total=").append(total);
        sb.append(", status=").append(status);
        sb.append(", gid=").append(gid);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
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
        CampaignBirthdayTaskDO other = (CampaignBirthdayTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExecuteTime() == null ? other.getExecuteTime() == null : this.getExecuteTime().equals(other.getExecuteTime()))
            && (this.getShortBirthday() == null ? other.getShortBirthday() == null : this.getShortBirthday().equals(other.getShortBirthday()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExecuteTime() == null) ? 0 : getExecuteTime().hashCode());
        result = prime * result + ((getShortBirthday() == null) ? 0 : getShortBirthday().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}