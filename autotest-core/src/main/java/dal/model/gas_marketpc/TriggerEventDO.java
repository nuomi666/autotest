package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "trigger_event")
public class TriggerEventDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事件名称
     */
    @Column(name = "event_name")
    private String eventName;

    /**
     * 事件编码
     */
    @Column(name = "event_route")
    private String eventRoute;

    /**
     * 事件归属
     */
    @Column(name = "event_scope")
    private String eventScope;

    /**
     * 事件状态
     */
    @Column(name = "event_status")
    private String eventStatus;

    /**
     * 触发事件条件
     */
    @Column(name = "event_description")
    private String eventDescription;

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
     * 获取事件名称
     *
     * @return event_name - 事件名称
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * 设置事件名称
     *
     * @param eventName 事件名称
     */
    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    /**
     * 获取事件编码
     *
     * @return event_route - 事件编码
     */
    public String getEventRoute() {
        return eventRoute;
    }

    /**
     * 设置事件编码
     *
     * @param eventRoute 事件编码
     */
    public void setEventRoute(String eventRoute) {
        this.eventRoute = eventRoute == null ? null : eventRoute.trim();
    }

    /**
     * 获取事件归属
     *
     * @return event_scope - 事件归属
     */
    public String getEventScope() {
        return eventScope;
    }

    /**
     * 设置事件归属
     *
     * @param eventScope 事件归属
     */
    public void setEventScope(String eventScope) {
        this.eventScope = eventScope == null ? null : eventScope.trim();
    }

    /**
     * 获取事件状态
     *
     * @return event_status - 事件状态
     */
    public String getEventStatus() {
        return eventStatus;
    }

    /**
     * 设置事件状态
     *
     * @param eventStatus 事件状态
     */
    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus == null ? null : eventStatus.trim();
    }

    /**
     * 获取触发事件条件
     *
     * @return event_description - 触发事件条件
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * 设置触发事件条件
     *
     * @param eventDescription 触发事件条件
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription == null ? null : eventDescription.trim();
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
        sb.append(", eventName=").append(eventName);
        sb.append(", eventRoute=").append(eventRoute);
        sb.append(", eventScope=").append(eventScope);
        sb.append(", eventStatus=").append(eventStatus);
        sb.append(", eventDescription=").append(eventDescription);
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
        TriggerEventDO other = (TriggerEventDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEventName() == null ? other.getEventName() == null : this.getEventName().equals(other.getEventName()))
            && (this.getEventRoute() == null ? other.getEventRoute() == null : this.getEventRoute().equals(other.getEventRoute()))
            && (this.getEventScope() == null ? other.getEventScope() == null : this.getEventScope().equals(other.getEventScope()))
            && (this.getEventStatus() == null ? other.getEventStatus() == null : this.getEventStatus().equals(other.getEventStatus()))
            && (this.getEventDescription() == null ? other.getEventDescription() == null : this.getEventDescription().equals(other.getEventDescription()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventName() == null) ? 0 : getEventName().hashCode());
        result = prime * result + ((getEventRoute() == null) ? 0 : getEventRoute().hashCode());
        result = prime * result + ((getEventScope() == null) ? 0 : getEventScope().hashCode());
        result = prime * result + ((getEventStatus() == null) ? 0 : getEventStatus().hashCode());
        result = prime * result + ((getEventDescription() == null) ? 0 : getEventDescription().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}