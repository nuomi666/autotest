package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_action_event")
public class UserActionEventDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事件id
     */
    @Column(name = "event_id")
    private String eventId;

    /**
     * 全局id
     */
    private String gid;

    /**
     * 行为事件
     */
    @Column(name = "action_event")
    private String actionEvent;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 交易时用户的资金账号的标签
     */
    @Column(name = "account_tag")
    private String accountTag;

    /**
     * 事件触发时间(交易发生时间)
     */
    @Column(name = "event_time")
    private Date eventTime;

    /**
     * 处理状态
     */
    private String status;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 活动执行上下文
     */
    private String context;

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
     * 获取事件id
     *
     * @return event_id - 事件id
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * 设置事件id
     *
     * @param eventId 事件id
     */
    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    /**
     * 获取全局id
     *
     * @return gid - 全局id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局id
     *
     * @param gid 全局id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取行为事件
     *
     * @return action_event - 行为事件
     */
    public String getActionEvent() {
        return actionEvent;
    }

    /**
     * 设置行为事件
     *
     * @param actionEvent 行为事件
     */
    public void setActionEvent(String actionEvent) {
        this.actionEvent = actionEvent == null ? null : actionEvent.trim();
    }

    /**
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商ID
     *
     * @return plat_partner_id - 平台商ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商ID
     *
     * @param platPartnerId 平台商ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取交易时用户的资金账号的标签
     *
     * @return account_tag - 交易时用户的资金账号的标签
     */
    public String getAccountTag() {
        return accountTag;
    }

    /**
     * 设置交易时用户的资金账号的标签
     *
     * @param accountTag 交易时用户的资金账号的标签
     */
    public void setAccountTag(String accountTag) {
        this.accountTag = accountTag == null ? null : accountTag.trim();
    }

    /**
     * 获取事件触发时间(交易发生时间)
     *
     * @return event_time - 事件触发时间(交易发生时间)
     */
    public Date getEventTime() {
        return eventTime;
    }

    /**
     * 设置事件触发时间(交易发生时间)
     *
     * @param eventTime 事件触发时间(交易发生时间)
     */
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * 获取处理状态
     *
     * @return status - 处理状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置处理状态
     *
     * @param status 处理状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    /**
     * 获取活动执行上下文
     *
     * @return context - 活动执行上下文
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置活动执行上下文
     *
     * @param context 活动执行上下文
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", eventId=").append(eventId);
        sb.append(", gid=").append(gid);
        sb.append(", actionEvent=").append(actionEvent);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", userId=").append(userId);
        sb.append(", accountTag=").append(accountTag);
        sb.append(", eventTime=").append(eventTime);
        sb.append(", status=").append(status);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", context=").append(context);
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
        UserActionEventDO other = (UserActionEventDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getActionEvent() == null ? other.getActionEvent() == null : this.getActionEvent().equals(other.getActionEvent()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAccountTag() == null ? other.getAccountTag() == null : this.getAccountTag().equals(other.getAccountTag()))
            && (this.getEventTime() == null ? other.getEventTime() == null : this.getEventTime().equals(other.getEventTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getActionEvent() == null) ? 0 : getActionEvent().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAccountTag() == null) ? 0 : getAccountTag().hashCode());
        result = prime * result + ((getEventTime() == null) ? 0 : getEventTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        return result;
    }
}