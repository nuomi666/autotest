package dal.model.gas_trade;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tmp_marketpc_points")
public class TmpMarketpcPointsDO implements Serializable {
    /**
     * 事件id
     */
    @Column(name = "event_id")
    private String eventId;

    /**
     * 赠送的积分
     */
    private Integer points;

    private static final long serialVersionUID = 1L;

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
     * 获取赠送的积分
     *
     * @return points - 赠送的积分
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置赠送的积分
     *
     * @param points 赠送的积分
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", eventId=").append(eventId);
        sb.append(", points=").append(points);
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
        TmpMarketpcPointsDO other = (TmpMarketpcPointsDO) that;
        return (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getPoints() == null ? other.getPoints() == null : this.getPoints().equals(other.getPoints()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getPoints() == null) ? 0 : getPoints().hashCode());
        return result;
    }
}