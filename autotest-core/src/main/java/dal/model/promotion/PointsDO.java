package dal.model.promotion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "points")
public class PointsDO implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 积分ID
     */
    @Column(name = "point_id")
    private String pointId;

    /**
     * 平台商户ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 签约商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 积分
     */
    private Long points;

    /**
     * 历史累减积分
     */
    @Column(name = "history_subtract_points")
    private Long historySubtractPoints;

    /**
     * 历史累加积分
     */
    @Column(name = "history_add_points")
    private Long historyAddPoints;

    /**
     * 上次清零时间
     */
    @Column(name = "last_clear_time")
    private Date lastClearTime;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取积分ID
     *
     * @return point_id - 积分ID
     */
    public String getPointId() {
        return pointId;
    }

    /**
     * 设置积分ID
     *
     * @param pointId 积分ID
     */
    public void setPointId(String pointId) {
        this.pointId = pointId == null ? null : pointId.trim();
    }

    /**
     * 获取平台商户ID
     *
     * @return plat_partner_id - 平台商户ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户ID
     *
     * @param platPartnerId 平台商户ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取签约商户ID
     *
     * @return partner_id - 签约商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户ID
     *
     * @param partnerId 签约商户ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取积分
     *
     * @return points - 积分
     */
    public Long getPoints() {
        return points;
    }

    /**
     * 设置积分
     *
     * @param points 积分
     */
    public void setPoints(Long points) {
        this.points = points;
    }

    /**
     * 获取历史累减积分
     *
     * @return history_subtract_points - 历史累减积分
     */
    public Long getHistorySubtractPoints() {
        return historySubtractPoints;
    }

    /**
     * 设置历史累减积分
     *
     * @param historySubtractPoints 历史累减积分
     */
    public void setHistorySubtractPoints(Long historySubtractPoints) {
        this.historySubtractPoints = historySubtractPoints;
    }

    /**
     * 获取历史累加积分
     *
     * @return history_add_points - 历史累加积分
     */
    public Long getHistoryAddPoints() {
        return historyAddPoints;
    }

    /**
     * 设置历史累加积分
     *
     * @param historyAddPoints 历史累加积分
     */
    public void setHistoryAddPoints(Long historyAddPoints) {
        this.historyAddPoints = historyAddPoints;
    }

    /**
     * 获取上次清零时间
     *
     * @return last_clear_time - 上次清零时间
     */
    public Date getLastClearTime() {
        return lastClearTime;
    }

    /**
     * 设置上次清零时间
     *
     * @param lastClearTime 上次清零时间
     */
    public void setLastClearTime(Date lastClearTime) {
        this.lastClearTime = lastClearTime;
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
        sb.append(", pointId=").append(pointId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", userId=").append(userId);
        sb.append(", points=").append(points);
        sb.append(", historySubtractPoints=").append(historySubtractPoints);
        sb.append(", historyAddPoints=").append(historyAddPoints);
        sb.append(", lastClearTime=").append(lastClearTime);
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
        PointsDO other = (PointsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPointId() == null ? other.getPointId() == null : this.getPointId().equals(other.getPointId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPoints() == null ? other.getPoints() == null : this.getPoints().equals(other.getPoints()))
            && (this.getHistorySubtractPoints() == null ? other.getHistorySubtractPoints() == null : this.getHistorySubtractPoints().equals(other.getHistorySubtractPoints()))
            && (this.getHistoryAddPoints() == null ? other.getHistoryAddPoints() == null : this.getHistoryAddPoints().equals(other.getHistoryAddPoints()))
            && (this.getLastClearTime() == null ? other.getLastClearTime() == null : this.getLastClearTime().equals(other.getLastClearTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPointId() == null) ? 0 : getPointId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPoints() == null) ? 0 : getPoints().hashCode());
        result = prime * result + ((getHistorySubtractPoints() == null) ? 0 : getHistorySubtractPoints().hashCode());
        result = prime * result + ((getHistoryAddPoints() == null) ? 0 : getHistoryAddPoints().hashCode());
        result = prime * result + ((getLastClearTime() == null) ? 0 : getLastClearTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}