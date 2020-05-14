package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_motorcade")
public class GasMerchantMotorcadeDO implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 签约商ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户名称
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 商户简称
     */
    @Column(name = "motorcade_id")
    private String motorcadeId;

    /**
     * 手机号
     */
    @Column(name = "motorcade_name")
    private String motorcadeName;

    /**
     * 商家邮箱
     */
    @Column(name = "motorcade_phone")
    private String motorcadePhone;

    /**
     * 车队账户
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 车队账户
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 余额
     */
    private Long balance;

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
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取签约商ID
     *
     * @return partner_id - 签约商ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商ID
     *
     * @param partnerId 签约商ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取商户名称
     *
     * @return partner_name - 商户名称
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商户名称
     *
     * @param partnerName 商户名称
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取商户简称
     *
     * @return motorcade_id - 商户简称
     */
    public String getMotorcadeId() {
        return motorcadeId;
    }

    /**
     * 设置商户简称
     *
     * @param motorcadeId 商户简称
     */
    public void setMotorcadeId(String motorcadeId) {
        this.motorcadeId = motorcadeId == null ? null : motorcadeId.trim();
    }

    /**
     * 获取手机号
     *
     * @return motorcade_name - 手机号
     */
    public String getMotorcadeName() {
        return motorcadeName;
    }

    /**
     * 设置手机号
     *
     * @param motorcadeName 手机号
     */
    public void setMotorcadeName(String motorcadeName) {
        this.motorcadeName = motorcadeName == null ? null : motorcadeName.trim();
    }

    /**
     * 获取商家邮箱
     *
     * @return motorcade_phone - 商家邮箱
     */
    public String getMotorcadePhone() {
        return motorcadePhone;
    }

    /**
     * 设置商家邮箱
     *
     * @param motorcadePhone 商家邮箱
     */
    public void setMotorcadePhone(String motorcadePhone) {
        this.motorcadePhone = motorcadePhone == null ? null : motorcadePhone.trim();
    }

    /**
     * 获取车队账户
     *
     * @return user_id - 车队账户
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置车队账户
     *
     * @param userId 车队账户
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取车队账户
     *
     * @return account_no - 车队账户
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置车队账户
     *
     * @param accountNo 车队账户
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", motorcadeId=").append(motorcadeId);
        sb.append(", motorcadeName=").append(motorcadeName);
        sb.append(", motorcadePhone=").append(motorcadePhone);
        sb.append(", userId=").append(userId);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", balance=").append(balance);
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
        GasMerchantMotorcadeDO other = (GasMerchantMotorcadeDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getMotorcadeId() == null ? other.getMotorcadeId() == null : this.getMotorcadeId().equals(other.getMotorcadeId()))
            && (this.getMotorcadeName() == null ? other.getMotorcadeName() == null : this.getMotorcadeName().equals(other.getMotorcadeName()))
            && (this.getMotorcadePhone() == null ? other.getMotorcadePhone() == null : this.getMotorcadePhone().equals(other.getMotorcadePhone()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getMotorcadeId() == null) ? 0 : getMotorcadeId().hashCode());
        result = prime * result + ((getMotorcadeName() == null) ? 0 : getMotorcadeName().hashCode());
        result = prime * result + ((getMotorcadePhone() == null) ? 0 : getMotorcadePhone().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}