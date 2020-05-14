package dal.model.merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_info")
public class MerchantInfoDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签约商户的id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 行业线
     */
    @Column(name = "industry_line")
    private String industryLine;

    /**
     * 外部商户id
     */
    @Column(name = "out_partner_id")
    private String outPartnerId;

    /**
     * 商户全称
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 商户简称
     */
    @Column(name = "partner_abbr_name")
    private String partnerAbbrName;

    /**
     * 商户注册地址
     */
    @Column(name = "partner_register_address")
    private String partnerRegisterAddress;

    /**
     * 注册来源INSIDE（站内）/OUTSIDE_INTO（外部引用）
     */
    @Column(name = "register_from")
    private String registerFrom;

    /**
     * 商户类型PLATFORM(平台商)PARTNER(签约商)
     */
    @Column(name = "partner_type")
    private String partnerType;

    /**
     * 商户状态ACTIVE(正常)FREEZE(冻结)
     */
    @Column(name = "partner_status")
    private String partnerStatus;

    /**
     * 签名key
     */
    @Column(name = "security_code")
    private String securityCode;

    /**
     * 签名类型(MD5)
     */
    @Column(name = "digest_type")
    private String digestType;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 商户拥有权限的api服务(数据库存储为json格式，如：["deposit","withdraw","quickPay"])
     */
    @Column(name = "own_service")
    private String ownService;

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
     * 获取行业线
     *
     * @return industry_line - 行业线
     */
    public String getIndustryLine() {
        return industryLine;
    }

    /**
     * 设置行业线
     *
     * @param industryLine 行业线
     */
    public void setIndustryLine(String industryLine) {
        this.industryLine = industryLine == null ? null : industryLine.trim();
    }

    /**
     * 获取外部商户id
     *
     * @return out_partner_id - 外部商户id
     */
    public String getOutPartnerId() {
        return outPartnerId;
    }

    /**
     * 设置外部商户id
     *
     * @param outPartnerId 外部商户id
     */
    public void setOutPartnerId(String outPartnerId) {
        this.outPartnerId = outPartnerId == null ? null : outPartnerId.trim();
    }

    /**
     * 获取商户全称
     *
     * @return partner_name - 商户全称
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商户全称
     *
     * @param partnerName 商户全称
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取商户简称
     *
     * @return partner_abbr_name - 商户简称
     */
    public String getPartnerAbbrName() {
        return partnerAbbrName;
    }

    /**
     * 设置商户简称
     *
     * @param partnerAbbrName 商户简称
     */
    public void setPartnerAbbrName(String partnerAbbrName) {
        this.partnerAbbrName = partnerAbbrName == null ? null : partnerAbbrName.trim();
    }

    /**
     * 获取商户注册地址
     *
     * @return partner_register_address - 商户注册地址
     */
    public String getPartnerRegisterAddress() {
        return partnerRegisterAddress;
    }

    /**
     * 设置商户注册地址
     *
     * @param partnerRegisterAddress 商户注册地址
     */
    public void setPartnerRegisterAddress(String partnerRegisterAddress) {
        this.partnerRegisterAddress = partnerRegisterAddress == null ? null : partnerRegisterAddress.trim();
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
     * 获取商户类型PLATFORM(平台商)PARTNER(签约商)
     *
     * @return partner_type - 商户类型PLATFORM(平台商)PARTNER(签约商)
     */
    public String getPartnerType() {
        return partnerType;
    }

    /**
     * 设置商户类型PLATFORM(平台商)PARTNER(签约商)
     *
     * @param partnerType 商户类型PLATFORM(平台商)PARTNER(签约商)
     */
    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType == null ? null : partnerType.trim();
    }

    /**
     * 获取商户状态ACTIVE(正常)FREEZE(冻结)
     *
     * @return partner_status - 商户状态ACTIVE(正常)FREEZE(冻结)
     */
    public String getPartnerStatus() {
        return partnerStatus;
    }

    /**
     * 设置商户状态ACTIVE(正常)FREEZE(冻结)
     *
     * @param partnerStatus 商户状态ACTIVE(正常)FREEZE(冻结)
     */
    public void setPartnerStatus(String partnerStatus) {
        this.partnerStatus = partnerStatus == null ? null : partnerStatus.trim();
    }

    /**
     * 获取签名key
     *
     * @return security_code - 签名key
     */
    public String getSecurityCode() {
        return securityCode;
    }

    /**
     * 设置签名key
     *
     * @param securityCode 签名key
     */
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode == null ? null : securityCode.trim();
    }

    /**
     * 获取签名类型(MD5)
     *
     * @return digest_type - 签名类型(MD5)
     */
    public String getDigestType() {
        return digestType;
    }

    /**
     * 设置签名类型(MD5)
     *
     * @param digestType 签名类型(MD5)
     */
    public void setDigestType(String digestType) {
        this.digestType = digestType == null ? null : digestType.trim();
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
     * 获取商户拥有权限的api服务(数据库存储为json格式，如：["deposit","withdraw","quickPay"])
     *
     * @return own_service - 商户拥有权限的api服务(数据库存储为json格式，如：["deposit","withdraw","quickPay"])
     */
    public String getOwnService() {
        return ownService;
    }

    /**
     * 设置商户拥有权限的api服务(数据库存储为json格式，如：["deposit","withdraw","quickPay"])
     *
     * @param ownService 商户拥有权限的api服务(数据库存储为json格式，如：["deposit","withdraw","quickPay"])
     */
    public void setOwnService(String ownService) {
        this.ownService = ownService == null ? null : ownService.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", industryLine=").append(industryLine);
        sb.append(", outPartnerId=").append(outPartnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", partnerAbbrName=").append(partnerAbbrName);
        sb.append(", partnerRegisterAddress=").append(partnerRegisterAddress);
        sb.append(", registerFrom=").append(registerFrom);
        sb.append(", partnerType=").append(partnerType);
        sb.append(", partnerStatus=").append(partnerStatus);
        sb.append(", securityCode=").append(securityCode);
        sb.append(", digestType=").append(digestType);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", ownService=").append(ownService);
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
        MerchantInfoDO other = (MerchantInfoDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getIndustryLine() == null ? other.getIndustryLine() == null : this.getIndustryLine().equals(other.getIndustryLine()))
            && (this.getOutPartnerId() == null ? other.getOutPartnerId() == null : this.getOutPartnerId().equals(other.getOutPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getPartnerAbbrName() == null ? other.getPartnerAbbrName() == null : this.getPartnerAbbrName().equals(other.getPartnerAbbrName()))
            && (this.getPartnerRegisterAddress() == null ? other.getPartnerRegisterAddress() == null : this.getPartnerRegisterAddress().equals(other.getPartnerRegisterAddress()))
            && (this.getRegisterFrom() == null ? other.getRegisterFrom() == null : this.getRegisterFrom().equals(other.getRegisterFrom()))
            && (this.getPartnerType() == null ? other.getPartnerType() == null : this.getPartnerType().equals(other.getPartnerType()))
            && (this.getPartnerStatus() == null ? other.getPartnerStatus() == null : this.getPartnerStatus().equals(other.getPartnerStatus()))
            && (this.getSecurityCode() == null ? other.getSecurityCode() == null : this.getSecurityCode().equals(other.getSecurityCode()))
            && (this.getDigestType() == null ? other.getDigestType() == null : this.getDigestType().equals(other.getDigestType()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getOwnService() == null ? other.getOwnService() == null : this.getOwnService().equals(other.getOwnService()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getIndustryLine() == null) ? 0 : getIndustryLine().hashCode());
        result = prime * result + ((getOutPartnerId() == null) ? 0 : getOutPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getPartnerAbbrName() == null) ? 0 : getPartnerAbbrName().hashCode());
        result = prime * result + ((getPartnerRegisterAddress() == null) ? 0 : getPartnerRegisterAddress().hashCode());
        result = prime * result + ((getRegisterFrom() == null) ? 0 : getRegisterFrom().hashCode());
        result = prime * result + ((getPartnerType() == null) ? 0 : getPartnerType().hashCode());
        result = prime * result + ((getPartnerStatus() == null) ? 0 : getPartnerStatus().hashCode());
        result = prime * result + ((getSecurityCode() == null) ? 0 : getSecurityCode().hashCode());
        result = prime * result + ((getDigestType() == null) ? 0 : getDigestType().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getOwnService() == null) ? 0 : getOwnService().hashCode());
        return result;
    }
}