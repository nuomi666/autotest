package dal.model.gas_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "point_change_message_task")
public class PointChangeMessageTaskDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 会员ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 积分变动时间
     */
    @Column(name = "use_time_unit")
    private Date useTimeUnit;

    /**
     * 消息详情
     */
    @Column(name = "message_details")
    private String messageDetails;

    /**
     * 执行状态
     */
    @Column(name = "message_status")
    private String messageStatus;

    /**
     * 备注
     */
    private String memo;

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
     * 获取商户ID
     *
     * @return partner_id - 商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户ID
     *
     * @param partnerId 商户ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取会员ID
     *
     * @return user_id - 会员ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置会员ID
     *
     * @param userId 会员ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取积分变动时间
     *
     * @return use_time_unit - 积分变动时间
     */
    public Date getUseTimeUnit() {
        return useTimeUnit;
    }

    /**
     * 设置积分变动时间
     *
     * @param useTimeUnit 积分变动时间
     */
    public void setUseTimeUnit(Date useTimeUnit) {
        this.useTimeUnit = useTimeUnit;
    }

    /**
     * 获取消息详情
     *
     * @return message_details - 消息详情
     */
    public String getMessageDetails() {
        return messageDetails;
    }

    /**
     * 设置消息详情
     *
     * @param messageDetails 消息详情
     */
    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails == null ? null : messageDetails.trim();
    }

    /**
     * 获取执行状态
     *
     * @return message_status - 执行状态
     */
    public String getMessageStatus() {
        return messageStatus;
    }

    /**
     * 设置执行状态
     *
     * @param messageStatus 执行状态
     */
    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus == null ? null : messageStatus.trim();
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", userId=").append(userId);
        sb.append(", useTimeUnit=").append(useTimeUnit);
        sb.append(", messageDetails=").append(messageDetails);
        sb.append(", messageStatus=").append(messageStatus);
        sb.append(", memo=").append(memo);
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
        PointChangeMessageTaskDO other = (PointChangeMessageTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUseTimeUnit() == null ? other.getUseTimeUnit() == null : this.getUseTimeUnit().equals(other.getUseTimeUnit()))
            && (this.getMessageDetails() == null ? other.getMessageDetails() == null : this.getMessageDetails().equals(other.getMessageDetails()))
            && (this.getMessageStatus() == null ? other.getMessageStatus() == null : this.getMessageStatus().equals(other.getMessageStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUseTimeUnit() == null) ? 0 : getUseTimeUnit().hashCode());
        result = prime * result + ((getMessageDetails() == null) ? 0 : getMessageDetails().hashCode());
        result = prime * result + ((getMessageStatus() == null) ? 0 : getMessageStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}