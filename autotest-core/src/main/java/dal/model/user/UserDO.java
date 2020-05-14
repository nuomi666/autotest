package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class UserDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 外部商户用户ID
     */
    @Column(name = "merchant_user_id")
    private String merchantUserId;

    /**
     * 父级用户id
     */
    @Column(name = "parent_user_id")
    private String parentUserId;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 支付密码
     */
    @Column(name = "pay_password")
    private String payPassword;

    /**
     * 注册来源INSIDE（站内）/OUTSIDE_INTO（外部引用）
     */
    @Column(name = "register_from")
    private String registerFrom;

    /**
     * 用户类型：PERSONAL（个人）/ENTERPRISE(企业)/INDIVIDUAL(个体户)
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 用户状态
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 认证状态
     */
    @Column(name = "certify_status")
    private String certifyStatus;

    /**
     * 用户真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 证件类型
     */
    @Column(name = "cert_type")
    private String certType;

    /**
     * 证件号
     */
    @Column(name = "cert_no")
    private String certNo;

    /**
     * 注册ip
     */
    @Column(name = "register_ip")
    private String registerIp;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区/县
     */
    private String district;

    /**
     * 地址
     */
    private String address;

    /**
     * 固定电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮编
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * 备注
     */
    private String memo;

    /**
     * 客户Id
     */
    @Column(name = "customer_id")
    private String customerId;

    /**
     * 签约商户的id
     */
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "merchant_mode")
    private String merchantMode;

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
     * 获取外部商户用户ID
     *
     * @return merchant_user_id - 外部商户用户ID
     */
    public String getMerchantUserId() {
        return merchantUserId;
    }

    /**
     * 设置外部商户用户ID
     *
     * @param merchantUserId 外部商户用户ID
     */
    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId == null ? null : merchantUserId.trim();
    }

    /**
     * 获取父级用户id
     *
     * @return parent_user_id - 父级用户id
     */
    public String getParentUserId() {
        return parentUserId;
    }

    /**
     * 设置父级用户id
     *
     * @param parentUserId 父级用户id
     */
    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId == null ? null : parentUserId.trim();
    }

    /**
     * 获取平台商户id
     *
     * @return plat_partner_id - 平台商户id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户id
     *
     * @param platPartnerId 平台商户id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取支付密码
     *
     * @return pay_password - 支付密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 设置支付密码
     *
     * @param payPassword 支付密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    /**
     * 获取注册来源INSIDE（站内）/OUTSIDE_INTO（外部引用）
     *
     * @return register_from - 注册来源INSIDE（站内）/OUTSIDE_INTO（外部引用）
     */
    public String getRegisterFrom() {
        return registerFrom;
    }

    /**
     * 设置注册来源INSIDE（站内）/OUTSIDE_INTO（外部引用）
     *
     * @param registerFrom 注册来源INSIDE（站内）/OUTSIDE_INTO（外部引用）
     */
    public void setRegisterFrom(String registerFrom) {
        this.registerFrom = registerFrom == null ? null : registerFrom.trim();
    }

    /**
     * 获取用户类型：PERSONAL（个人）/ENTERPRISE(企业)/INDIVIDUAL(个体户)
     *
     * @return user_type - 用户类型：PERSONAL（个人）/ENTERPRISE(企业)/INDIVIDUAL(个体户)
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型：PERSONAL（个人）/ENTERPRISE(企业)/INDIVIDUAL(个体户)
     *
     * @param userType 用户类型：PERSONAL（个人）/ENTERPRISE(企业)/INDIVIDUAL(个体户)
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取用户状态
     *
     * @return user_status - 用户状态
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态
     *
     * @param userStatus 用户状态
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    /**
     * 获取认证状态
     *
     * @return certify_status - 认证状态
     */
    public String getCertifyStatus() {
        return certifyStatus;
    }

    /**
     * 设置认证状态
     *
     * @param certifyStatus 认证状态
     */
    public void setCertifyStatus(String certifyStatus) {
        this.certifyStatus = certifyStatus == null ? null : certifyStatus.trim();
    }

    /**
     * 获取用户真实姓名
     *
     * @return real_name - 用户真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置用户真实姓名
     *
     * @param realName 用户真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取证件类型
     *
     * @return cert_type - 证件类型
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置证件类型
     *
     * @param certType 证件类型
     */
    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    /**
     * 获取证件号
     *
     * @return cert_no - 证件号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 设置证件号
     *
     * @param certNo 证件号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * 获取注册ip
     *
     * @return register_ip - 注册ip
     */
    public String getRegisterIp() {
        return registerIp;
    }

    /**
     * 设置注册ip
     *
     * @param registerIp 注册ip
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp == null ? null : registerIp.trim();
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取区/县
     *
     * @return district - 区/县
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区/县
     *
     * @param district 区/县
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取固定电话
     *
     * @return phone - 固定电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置固定电话
     *
     * @param phone 固定电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取邮编
     *
     * @return zip_code - 邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮编
     *
     * @param zipCode 邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
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
     * 获取客户Id
     *
     * @return customer_id - 客户Id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户Id
     *
     * @param customerId 客户Id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * 获取签约商户的id
     *
     * @return partner_id - 签约商户的id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户的id
     *
     * @param partnerId 签约商户的id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * @return merchant_mode
     */
    public String getMerchantMode() {
        return merchantMode;
    }

    /**
     * @param merchantMode
     */
    public void setMerchantMode(String merchantMode) {
        this.merchantMode = merchantMode == null ? null : merchantMode.trim();
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
        sb.append(", merchantUserId=").append(merchantUserId);
        sb.append(", parentUserId=").append(parentUserId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", userName=").append(userName);
        sb.append(", payPassword=").append(payPassword);
        sb.append(", registerFrom=").append(registerFrom);
        sb.append(", userType=").append(userType);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", certifyStatus=").append(certifyStatus);
        sb.append(", realName=").append(realName);
        sb.append(", certType=").append(certType);
        sb.append(", certNo=").append(certNo);
        sb.append(", registerIp=").append(registerIp);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", mobile=").append(mobile);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", memo=").append(memo);
        sb.append(", customerId=").append(customerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantMode=").append(merchantMode);
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
        UserDO other = (UserDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMerchantUserId() == null ? other.getMerchantUserId() == null : this.getMerchantUserId().equals(other.getMerchantUserId()))
            && (this.getParentUserId() == null ? other.getParentUserId() == null : this.getParentUserId().equals(other.getParentUserId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPayPassword() == null ? other.getPayPassword() == null : this.getPayPassword().equals(other.getPayPassword()))
            && (this.getRegisterFrom() == null ? other.getRegisterFrom() == null : this.getRegisterFrom().equals(other.getRegisterFrom()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getCertifyStatus() == null ? other.getCertifyStatus() == null : this.getCertifyStatus().equals(other.getCertifyStatus()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
            && (this.getRegisterIp() == null ? other.getRegisterIp() == null : this.getRegisterIp().equals(other.getRegisterIp()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getZipCode() == null ? other.getZipCode() == null : this.getZipCode().equals(other.getZipCode()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantMode() == null ? other.getMerchantMode() == null : this.getMerchantMode().equals(other.getMerchantMode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMerchantUserId() == null) ? 0 : getMerchantUserId().hashCode());
        result = prime * result + ((getParentUserId() == null) ? 0 : getParentUserId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPayPassword() == null) ? 0 : getPayPassword().hashCode());
        result = prime * result + ((getRegisterFrom() == null) ? 0 : getRegisterFrom().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getCertifyStatus() == null) ? 0 : getCertifyStatus().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getRegisterIp() == null) ? 0 : getRegisterIp().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getZipCode() == null) ? 0 : getZipCode().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantMode() == null) ? 0 : getMerchantMode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}