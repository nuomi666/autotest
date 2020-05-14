package dal.model.shellmerchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_device")
public class GasMerchantDeviceDO implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 终端类型
     */
    @Column(name = "device_type")
    private String deviceType;

    /**
     * 终端编号
     */
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 登录状态
     */
    @Column(name = "login_status")
    private String loginStatus;

    /**
     * 登录用户ID
     */
    @Column(name = "login_user_id")
    private String loginUserId;

    /**
     * 新增时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 更新时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return partner_id - 商家ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商家ID
     *
     * @param partnerId 商家ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取终端类型
     *
     * @return device_type - 终端类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置终端类型
     *
     * @param deviceType 终端类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    /**
     * 获取终端编号
     *
     * @return device_code - 终端编号
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 设置终端编号
     *
     * @param deviceCode 终端编号
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    /**
     * 获取登录状态
     *
     * @return login_status - 登录状态
     */
    public String getLoginStatus() {
        return loginStatus;
    }

    /**
     * 设置登录状态
     *
     * @param loginStatus 登录状态
     */
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus == null ? null : loginStatus.trim();
    }

    /**
     * 获取登录用户ID
     *
     * @return login_user_id - 登录用户ID
     */
    public String getLoginUserId() {
        return loginUserId;
    }

    /**
     * 设置登录用户ID
     *
     * @param loginUserId 登录用户ID
     */
    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId == null ? null : loginUserId.trim();
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取更新时间
     *
     * @return raw_update_time - 更新时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param rawUpdateTime 更新时间
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
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", loginStatus=").append(loginStatus);
        sb.append(", loginUserId=").append(loginUserId);
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
        GasMerchantDeviceDO other = (GasMerchantDeviceDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getDeviceType() == null ? other.getDeviceType() == null : this.getDeviceType().equals(other.getDeviceType()))
            && (this.getDeviceCode() == null ? other.getDeviceCode() == null : this.getDeviceCode().equals(other.getDeviceCode()))
            && (this.getLoginStatus() == null ? other.getLoginStatus() == null : this.getLoginStatus().equals(other.getLoginStatus()))
            && (this.getLoginUserId() == null ? other.getLoginUserId() == null : this.getLoginUserId().equals(other.getLoginUserId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getDeviceType() == null) ? 0 : getDeviceType().hashCode());
        result = prime * result + ((getDeviceCode() == null) ? 0 : getDeviceCode().hashCode());
        result = prime * result + ((getLoginStatus() == null) ? 0 : getLoginStatus().hashCode());
        result = prime * result + ((getLoginUserId() == null) ? 0 : getLoginUserId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}