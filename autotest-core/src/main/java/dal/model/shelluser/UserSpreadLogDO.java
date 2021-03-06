package dal.model.shelluser;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_spread_log")
public class UserSpreadLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 油站id
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 油站编码
     */
    @Column(name = "station_code")
    private String stationCode;

    /**
     * 油站名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 员工id
     */
    @Column(name = "operator_id")
    private String operatorId;

    /**
     * 员工名称
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 员工手机号
     */
    @Column(name = "operator_mobile")
    private String operatorMobile;

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
     * 获取会员id
     *
     * @return user_id - 会员id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置会员id
     *
     * @param userId 会员id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取油站id
     *
     * @return station_id - 油站id
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站id
     *
     * @param stationId 油站id
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取油站编码
     *
     * @return station_code - 油站编码
     */
    public String getStationCode() {
        return stationCode;
    }

    /**
     * 设置油站编码
     *
     * @param stationCode 油站编码
     */
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    /**
     * 获取油站名称
     *
     * @return station_name - 油站名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置油站名称
     *
     * @param stationName 油站名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * 获取员工id
     *
     * @return operator_id - 员工id
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置员工id
     *
     * @param operatorId 员工id
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * 获取员工名称
     *
     * @return operator_name - 员工名称
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置员工名称
     *
     * @param operatorName 员工名称
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 获取员工手机号
     *
     * @return operator_mobile - 员工手机号
     */
    public String getOperatorMobile() {
        return operatorMobile;
    }

    /**
     * 设置员工手机号
     *
     * @param operatorMobile 员工手机号
     */
    public void setOperatorMobile(String operatorMobile) {
        this.operatorMobile = operatorMobile == null ? null : operatorMobile.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", nickName=").append(nickName);
        sb.append(", stationId=").append(stationId);
        sb.append(", stationCode=").append(stationCode);
        sb.append(", stationName=").append(stationName);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", operatorMobile=").append(operatorMobile);
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
        UserSpreadLogDO other = (UserSpreadLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationCode() == null ? other.getStationCode() == null : this.getStationCode().equals(other.getStationCode()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getOperatorName() == null ? other.getOperatorName() == null : this.getOperatorName().equals(other.getOperatorName()))
            && (this.getOperatorMobile() == null ? other.getOperatorMobile() == null : this.getOperatorMobile().equals(other.getOperatorMobile()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationCode() == null) ? 0 : getStationCode().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());
        result = prime * result + ((getOperatorMobile() == null) ? 0 : getOperatorMobile().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}