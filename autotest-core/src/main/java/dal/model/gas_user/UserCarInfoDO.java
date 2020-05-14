package dal.model.gas_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_car_info")
public class UserCarInfoDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 清洁算会员id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 车牌号
     */
    @Column(name = "car_number")
    private String carNumber;

    /**
     * 车型
     */
    @Column(name = "car_type")
    private String carType;

    /**
     * 专车认证图片
     */
    @Column(name = "authenticate_img")
    private String authenticateImg;

    /**
     * 审核状态
     */
    @Column(name = "audit_status")
    private String auditStatus;

    /**
     * 申请成为专车用户时间
     */
    @Column(name = "apply_date")
    private Date applyDate;

    /**
     * 专车审核通过时间
     */
    @Column(name = "audit_date")
    private Date auditDate;

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
     * 获取清洁算会员id
     *
     * @return user_id - 清洁算会员id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置清洁算会员id
     *
     * @param userId 清洁算会员id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取车牌号
     *
     * @return car_number - 车牌号
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * 设置车牌号
     *
     * @param carNumber 车牌号
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    /**
     * 获取车型
     *
     * @return car_type - 车型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置车型
     *
     * @param carType 车型
     */
    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    /**
     * 获取专车认证图片
     *
     * @return authenticate_img - 专车认证图片
     */
    public String getAuthenticateImg() {
        return authenticateImg;
    }

    /**
     * 设置专车认证图片
     *
     * @param authenticateImg 专车认证图片
     */
    public void setAuthenticateImg(String authenticateImg) {
        this.authenticateImg = authenticateImg == null ? null : authenticateImg.trim();
    }

    /**
     * 获取审核状态
     *
     * @return audit_status - 审核状态
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态
     *
     * @param auditStatus 审核状态
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * 获取申请成为专车用户时间
     *
     * @return apply_date - 申请成为专车用户时间
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请成为专车用户时间
     *
     * @param applyDate 申请成为专车用户时间
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取专车审核通过时间
     *
     * @return audit_date - 专车审核通过时间
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置专车审核通过时间
     *
     * @param auditDate 专车审核通过时间
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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
        sb.append(", carNumber=").append(carNumber);
        sb.append(", carType=").append(carType);
        sb.append(", authenticateImg=").append(authenticateImg);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", auditDate=").append(auditDate);
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
        UserCarInfoDO other = (UserCarInfoDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCarNumber() == null ? other.getCarNumber() == null : this.getCarNumber().equals(other.getCarNumber()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getAuthenticateImg() == null ? other.getAuthenticateImg() == null : this.getAuthenticateImg().equals(other.getAuthenticateImg()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getAuditDate() == null ? other.getAuditDate() == null : this.getAuditDate().equals(other.getAuditDate()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCarNumber() == null) ? 0 : getCarNumber().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getAuthenticateImg() == null) ? 0 : getAuthenticateImg().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getAuditDate() == null) ? 0 : getAuditDate().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}