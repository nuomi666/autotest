package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_channel_task_log")
public class ClearChannelTaskLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 开始账期yyyyMMdd
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * 结束账期yyyyMMdd
     */
    @Column(name = "end_date")
    private String endDate;

    /**
     * 清分状态：INIT,SUCCESS,FAIL
     */
    @Column(name = "clear_status")
    private String clearStatus;

    /**
     * 清分时间
     */
    @Column(name = "clear_time")
    private Date clearTime;

    /**
     * 清分备注
     */
    private String comment;

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
     * 获取渠道id
     *
     * @return channel_id - 渠道id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道id
     *
     * @param channelId 渠道id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取开始账期yyyyMMdd
     *
     * @return start_date - 开始账期yyyyMMdd
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置开始账期yyyyMMdd
     *
     * @param startDate 开始账期yyyyMMdd
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * 获取结束账期yyyyMMdd
     *
     * @return end_date - 结束账期yyyyMMdd
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置结束账期yyyyMMdd
     *
     * @param endDate 结束账期yyyyMMdd
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * 获取清分状态：INIT,SUCCESS,FAIL
     *
     * @return clear_status - 清分状态：INIT,SUCCESS,FAIL
     */
    public String getClearStatus() {
        return clearStatus;
    }

    /**
     * 设置清分状态：INIT,SUCCESS,FAIL
     *
     * @param clearStatus 清分状态：INIT,SUCCESS,FAIL
     */
    public void setClearStatus(String clearStatus) {
        this.clearStatus = clearStatus == null ? null : clearStatus.trim();
    }

    /**
     * 获取清分时间
     *
     * @return clear_time - 清分时间
     */
    public Date getClearTime() {
        return clearTime;
    }

    /**
     * 设置清分时间
     *
     * @param clearTime 清分时间
     */
    public void setClearTime(Date clearTime) {
        this.clearTime = clearTime;
    }

    /**
     * 获取清分备注
     *
     * @return comment - 清分备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置清分备注
     *
     * @param comment 清分备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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
        sb.append(", channelId=").append(channelId);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", clearStatus=").append(clearStatus);
        sb.append(", clearTime=").append(clearTime);
        sb.append(", comment=").append(comment);
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
        ClearChannelTaskLogDO other = (ClearChannelTaskLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getClearStatus() == null ? other.getClearStatus() == null : this.getClearStatus().equals(other.getClearStatus()))
            && (this.getClearTime() == null ? other.getClearTime() == null : this.getClearTime().equals(other.getClearTime()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getClearStatus() == null) ? 0 : getClearStatus().hashCode());
        result = prime * result + ((getClearTime() == null) ? 0 : getClearTime().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}