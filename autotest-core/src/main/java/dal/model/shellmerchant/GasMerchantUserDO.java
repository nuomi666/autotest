package dal.model.shellmerchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_user")
public class GasMerchantUserDO implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号
     */
    @Column(name = "mobile_no")
    private String mobileNo;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 终端与商户用户与user_type组成唯一约束
     */
    @Column(name = "uq_key")
    private String uqKey;

    /**
     * 登录错误次数
     */
    @Column(name = "login_error_count")
    private Integer loginErrorCount;

    /**
     * 登录错误次数限制
     */
    @Column(name = "login_error_limit")
    private Integer loginErrorLimit;

    /**
     * 上次登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 上次成功登录时间
     */
    @Column(name = "last_login_success_time")
    private Date lastLoginSuccessTime;

    /**
     * 上次成功登出时间
     */
    @Column(name = "last_logout_success_time")
    private Date lastLogoutSuccessTime;

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
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取商户号
     *
     * @return partner_id - 商户号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户号
     *
     * @param partnerId 商户号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile_no - 手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号
     *
     * @param mobileNo 手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * 获取登录账号
     *
     * @return account - 登录账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置登录账号
     *
     * @param account 登录账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取用户状态
     *
     * @return status - 用户状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置用户状态
     *
     * @param status 用户状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取终端与商户用户与user_type组成唯一约束
     *
     * @return uq_key - 终端与商户用户与user_type组成唯一约束
     */
    public String getUqKey() {
        return uqKey;
    }

    /**
     * 设置终端与商户用户与user_type组成唯一约束
     *
     * @param uqKey 终端与商户用户与user_type组成唯一约束
     */
    public void setUqKey(String uqKey) {
        this.uqKey = uqKey == null ? null : uqKey.trim();
    }

    /**
     * 获取登录错误次数
     *
     * @return login_error_count - 登录错误次数
     */
    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    /**
     * 设置登录错误次数
     *
     * @param loginErrorCount 登录错误次数
     */
    public void setLoginErrorCount(Integer loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    /**
     * 获取登录错误次数限制
     *
     * @return login_error_limit - 登录错误次数限制
     */
    public Integer getLoginErrorLimit() {
        return loginErrorLimit;
    }

    /**
     * 设置登录错误次数限制
     *
     * @param loginErrorLimit 登录错误次数限制
     */
    public void setLoginErrorLimit(Integer loginErrorLimit) {
        this.loginErrorLimit = loginErrorLimit;
    }

    /**
     * 获取上次登录时间
     *
     * @return last_login_time - 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取上次成功登录时间
     *
     * @return last_login_success_time - 上次成功登录时间
     */
    public Date getLastLoginSuccessTime() {
        return lastLoginSuccessTime;
    }

    /**
     * 设置上次成功登录时间
     *
     * @param lastLoginSuccessTime 上次成功登录时间
     */
    public void setLastLoginSuccessTime(Date lastLoginSuccessTime) {
        this.lastLoginSuccessTime = lastLoginSuccessTime;
    }

    /**
     * 获取上次成功登出时间
     *
     * @return last_logout_success_time - 上次成功登出时间
     */
    public Date getLastLogoutSuccessTime() {
        return lastLogoutSuccessTime;
    }

    /**
     * 设置上次成功登出时间
     *
     * @param lastLogoutSuccessTime 上次成功登出时间
     */
    public void setLastLogoutSuccessTime(Date lastLogoutSuccessTime) {
        this.lastLogoutSuccessTime = lastLogoutSuccessTime;
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
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", userType=").append(userType);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", userName=").append(userName);
        sb.append(", mobileNo=").append(mobileNo);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", status=").append(status);
        sb.append(", uqKey=").append(uqKey);
        sb.append(", loginErrorCount=").append(loginErrorCount);
        sb.append(", loginErrorLimit=").append(loginErrorLimit);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastLoginSuccessTime=").append(lastLoginSuccessTime);
        sb.append(", lastLogoutSuccessTime=").append(lastLogoutSuccessTime);
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
        GasMerchantUserDO other = (GasMerchantUserDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getMobileNo() == null ? other.getMobileNo() == null : this.getMobileNo().equals(other.getMobileNo()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUqKey() == null ? other.getUqKey() == null : this.getUqKey().equals(other.getUqKey()))
            && (this.getLoginErrorCount() == null ? other.getLoginErrorCount() == null : this.getLoginErrorCount().equals(other.getLoginErrorCount()))
            && (this.getLoginErrorLimit() == null ? other.getLoginErrorLimit() == null : this.getLoginErrorLimit().equals(other.getLoginErrorLimit()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getLastLoginSuccessTime() == null ? other.getLastLoginSuccessTime() == null : this.getLastLoginSuccessTime().equals(other.getLastLoginSuccessTime()))
            && (this.getLastLogoutSuccessTime() == null ? other.getLastLogoutSuccessTime() == null : this.getLastLogoutSuccessTime().equals(other.getLastLogoutSuccessTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getMobileNo() == null) ? 0 : getMobileNo().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUqKey() == null) ? 0 : getUqKey().hashCode());
        result = prime * result + ((getLoginErrorCount() == null) ? 0 : getLoginErrorCount().hashCode());
        result = prime * result + ((getLoginErrorLimit() == null) ? 0 : getLoginErrorLimit().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getLastLoginSuccessTime() == null) ? 0 : getLastLoginSuccessTime().hashCode());
        result = prime * result + ((getLastLogoutSuccessTime() == null) ? 0 : getLastLogoutSuccessTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}