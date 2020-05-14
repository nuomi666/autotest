package dal.model.merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_auth")
public class MerchantAuthDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签约商户的id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户简称
     */
    @Column(name = "partner_abbr_name")
    private String partnerAbbrName;

    /**
     * 经营类目
     */
    @Column(name = "business_category")
    private String businessCategory;

    /**
     * 门店地址
     */
    @Column(name = "store_address")
    private String storeAddress;

    /**
     * 门头照图片地址（多张）
     */
    @Column(name = "store_entrance_pics_url")
    private String storeEntrancePicsUrl;

    /**
     * 门店经营照图片地址
     */
    @Column(name = "store_indoor_pics_url")
    private String storeIndoorPicsUrl;

    /**
     * 特殊资质图片地址
     */
    @Column(name = "qualifications_pic_url")
    private String qualificationsPicUrl;

    /**
     * 补充材料照片地址（多张）
     */
    @Column(name = "business_addition_pics_url")
    private String businessAdditionPicsUrl;

    /**
     * 营业执照号
     */
    @Column(name = "business_license")
    private String businessLicense;

    /**
     * 营业执照图片地址
     */
    @Column(name = "business_license_pic_url")
    private String businessLicensePicUrl;

    /**
     * 营业期限
     */
    @Column(name = "business_time")
    private String businessTime;

    /**
     * 经营范围
     */
    @Column(name = "business_scope")
    private String businessScope;

    /**
     * 开户许可证图片地址
     */
    @Column(name = "account_opening_license_pic_url")
    private String accountOpeningLicensePicUrl;

    /**
     * 法人姓名
     */
    @Column(name = "legal_name")
    private String legalName;

    /**
     * 法人证件类型
     */
    @Column(name = "legal_cert_type")
    private String legalCertType;

    /**
     * 法人证件号码
     */
    @Column(name = "legal_cert_no")
    private String legalCertNo;

    /**
     * 法人证件有效期
     */
    @Column(name = "legal_cert_valid_time")
    private String legalCertValidTime;

    /**
     * 法人证件正面图片地址
     */
    @Column(name = "legal_cert_front_pic_url")
    private String legalCertFrontPicUrl;

    /**
     * 法人证件背面图片地址
     */
    @Column(name = "legal_cert_back_pic_url")
    private String legalCertBackPicUrl;

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
     * 获取经营类目
     *
     * @return business_category - 经营类目
     */
    public String getBusinessCategory() {
        return businessCategory;
    }

    /**
     * 设置经营类目
     *
     * @param businessCategory 经营类目
     */
    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory == null ? null : businessCategory.trim();
    }

    /**
     * 获取门店地址
     *
     * @return store_address - 门店地址
     */
    public String getStoreAddress() {
        return storeAddress;
    }

    /**
     * 设置门店地址
     *
     * @param storeAddress 门店地址
     */
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    /**
     * 获取门头照图片地址（多张）
     *
     * @return store_entrance_pics_url - 门头照图片地址（多张）
     */
    public String getStoreEntrancePicsUrl() {
        return storeEntrancePicsUrl;
    }

    /**
     * 设置门头照图片地址（多张）
     *
     * @param storeEntrancePicsUrl 门头照图片地址（多张）
     */
    public void setStoreEntrancePicsUrl(String storeEntrancePicsUrl) {
        this.storeEntrancePicsUrl = storeEntrancePicsUrl == null ? null : storeEntrancePicsUrl.trim();
    }

    /**
     * 获取门店经营照图片地址
     *
     * @return store_indoor_pics_url - 门店经营照图片地址
     */
    public String getStoreIndoorPicsUrl() {
        return storeIndoorPicsUrl;
    }

    /**
     * 设置门店经营照图片地址
     *
     * @param storeIndoorPicsUrl 门店经营照图片地址
     */
    public void setStoreIndoorPicsUrl(String storeIndoorPicsUrl) {
        this.storeIndoorPicsUrl = storeIndoorPicsUrl == null ? null : storeIndoorPicsUrl.trim();
    }

    /**
     * 获取特殊资质图片地址
     *
     * @return qualifications_pic_url - 特殊资质图片地址
     */
    public String getQualificationsPicUrl() {
        return qualificationsPicUrl;
    }

    /**
     * 设置特殊资质图片地址
     *
     * @param qualificationsPicUrl 特殊资质图片地址
     */
    public void setQualificationsPicUrl(String qualificationsPicUrl) {
        this.qualificationsPicUrl = qualificationsPicUrl == null ? null : qualificationsPicUrl.trim();
    }

    /**
     * 获取补充材料照片地址（多张）
     *
     * @return business_addition_pics_url - 补充材料照片地址（多张）
     */
    public String getBusinessAdditionPicsUrl() {
        return businessAdditionPicsUrl;
    }

    /**
     * 设置补充材料照片地址（多张）
     *
     * @param businessAdditionPicsUrl 补充材料照片地址（多张）
     */
    public void setBusinessAdditionPicsUrl(String businessAdditionPicsUrl) {
        this.businessAdditionPicsUrl = businessAdditionPicsUrl == null ? null : businessAdditionPicsUrl.trim();
    }

    /**
     * 获取营业执照号
     *
     * @return business_license - 营业执照号
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置营业执照号
     *
     * @param businessLicense 营业执照号
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * 获取营业执照图片地址
     *
     * @return business_license_pic_url - 营业执照图片地址
     */
    public String getBusinessLicensePicUrl() {
        return businessLicensePicUrl;
    }

    /**
     * 设置营业执照图片地址
     *
     * @param businessLicensePicUrl 营业执照图片地址
     */
    public void setBusinessLicensePicUrl(String businessLicensePicUrl) {
        this.businessLicensePicUrl = businessLicensePicUrl == null ? null : businessLicensePicUrl.trim();
    }

    /**
     * 获取营业期限
     *
     * @return business_time - 营业期限
     */
    public String getBusinessTime() {
        return businessTime;
    }

    /**
     * 设置营业期限
     *
     * @param businessTime 营业期限
     */
    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime == null ? null : businessTime.trim();
    }

    /**
     * 获取经营范围
     *
     * @return business_scope - 经营范围
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * 设置经营范围
     *
     * @param businessScope 经营范围
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * 获取开户许可证图片地址
     *
     * @return account_opening_license_pic_url - 开户许可证图片地址
     */
    public String getAccountOpeningLicensePicUrl() {
        return accountOpeningLicensePicUrl;
    }

    /**
     * 设置开户许可证图片地址
     *
     * @param accountOpeningLicensePicUrl 开户许可证图片地址
     */
    public void setAccountOpeningLicensePicUrl(String accountOpeningLicensePicUrl) {
        this.accountOpeningLicensePicUrl = accountOpeningLicensePicUrl == null ? null : accountOpeningLicensePicUrl.trim();
    }

    /**
     * 获取法人姓名
     *
     * @return legal_name - 法人姓名
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * 设置法人姓名
     *
     * @param legalName 法人姓名
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    /**
     * 获取法人证件类型
     *
     * @return legal_cert_type - 法人证件类型
     */
    public String getLegalCertType() {
        return legalCertType;
    }

    /**
     * 设置法人证件类型
     *
     * @param legalCertType 法人证件类型
     */
    public void setLegalCertType(String legalCertType) {
        this.legalCertType = legalCertType == null ? null : legalCertType.trim();
    }

    /**
     * 获取法人证件号码
     *
     * @return legal_cert_no - 法人证件号码
     */
    public String getLegalCertNo() {
        return legalCertNo;
    }

    /**
     * 设置法人证件号码
     *
     * @param legalCertNo 法人证件号码
     */
    public void setLegalCertNo(String legalCertNo) {
        this.legalCertNo = legalCertNo == null ? null : legalCertNo.trim();
    }

    /**
     * 获取法人证件有效期
     *
     * @return legal_cert_valid_time - 法人证件有效期
     */
    public String getLegalCertValidTime() {
        return legalCertValidTime;
    }

    /**
     * 设置法人证件有效期
     *
     * @param legalCertValidTime 法人证件有效期
     */
    public void setLegalCertValidTime(String legalCertValidTime) {
        this.legalCertValidTime = legalCertValidTime == null ? null : legalCertValidTime.trim();
    }

    /**
     * 获取法人证件正面图片地址
     *
     * @return legal_cert_front_pic_url - 法人证件正面图片地址
     */
    public String getLegalCertFrontPicUrl() {
        return legalCertFrontPicUrl;
    }

    /**
     * 设置法人证件正面图片地址
     *
     * @param legalCertFrontPicUrl 法人证件正面图片地址
     */
    public void setLegalCertFrontPicUrl(String legalCertFrontPicUrl) {
        this.legalCertFrontPicUrl = legalCertFrontPicUrl == null ? null : legalCertFrontPicUrl.trim();
    }

    /**
     * 获取法人证件背面图片地址
     *
     * @return legal_cert_back_pic_url - 法人证件背面图片地址
     */
    public String getLegalCertBackPicUrl() {
        return legalCertBackPicUrl;
    }

    /**
     * 设置法人证件背面图片地址
     *
     * @param legalCertBackPicUrl 法人证件背面图片地址
     */
    public void setLegalCertBackPicUrl(String legalCertBackPicUrl) {
        this.legalCertBackPicUrl = legalCertBackPicUrl == null ? null : legalCertBackPicUrl.trim();
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerAbbrName=").append(partnerAbbrName);
        sb.append(", businessCategory=").append(businessCategory);
        sb.append(", storeAddress=").append(storeAddress);
        sb.append(", storeEntrancePicsUrl=").append(storeEntrancePicsUrl);
        sb.append(", storeIndoorPicsUrl=").append(storeIndoorPicsUrl);
        sb.append(", qualificationsPicUrl=").append(qualificationsPicUrl);
        sb.append(", businessAdditionPicsUrl=").append(businessAdditionPicsUrl);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", businessLicensePicUrl=").append(businessLicensePicUrl);
        sb.append(", businessTime=").append(businessTime);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", accountOpeningLicensePicUrl=").append(accountOpeningLicensePicUrl);
        sb.append(", legalName=").append(legalName);
        sb.append(", legalCertType=").append(legalCertType);
        sb.append(", legalCertNo=").append(legalCertNo);
        sb.append(", legalCertValidTime=").append(legalCertValidTime);
        sb.append(", legalCertFrontPicUrl=").append(legalCertFrontPicUrl);
        sb.append(", legalCertBackPicUrl=").append(legalCertBackPicUrl);
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
        MerchantAuthDO other = (MerchantAuthDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerAbbrName() == null ? other.getPartnerAbbrName() == null : this.getPartnerAbbrName().equals(other.getPartnerAbbrName()))
            && (this.getBusinessCategory() == null ? other.getBusinessCategory() == null : this.getBusinessCategory().equals(other.getBusinessCategory()))
            && (this.getStoreAddress() == null ? other.getStoreAddress() == null : this.getStoreAddress().equals(other.getStoreAddress()))
            && (this.getStoreEntrancePicsUrl() == null ? other.getStoreEntrancePicsUrl() == null : this.getStoreEntrancePicsUrl().equals(other.getStoreEntrancePicsUrl()))
            && (this.getStoreIndoorPicsUrl() == null ? other.getStoreIndoorPicsUrl() == null : this.getStoreIndoorPicsUrl().equals(other.getStoreIndoorPicsUrl()))
            && (this.getQualificationsPicUrl() == null ? other.getQualificationsPicUrl() == null : this.getQualificationsPicUrl().equals(other.getQualificationsPicUrl()))
            && (this.getBusinessAdditionPicsUrl() == null ? other.getBusinessAdditionPicsUrl() == null : this.getBusinessAdditionPicsUrl().equals(other.getBusinessAdditionPicsUrl()))
            && (this.getBusinessLicense() == null ? other.getBusinessLicense() == null : this.getBusinessLicense().equals(other.getBusinessLicense()))
            && (this.getBusinessLicensePicUrl() == null ? other.getBusinessLicensePicUrl() == null : this.getBusinessLicensePicUrl().equals(other.getBusinessLicensePicUrl()))
            && (this.getBusinessTime() == null ? other.getBusinessTime() == null : this.getBusinessTime().equals(other.getBusinessTime()))
            && (this.getBusinessScope() == null ? other.getBusinessScope() == null : this.getBusinessScope().equals(other.getBusinessScope()))
            && (this.getAccountOpeningLicensePicUrl() == null ? other.getAccountOpeningLicensePicUrl() == null : this.getAccountOpeningLicensePicUrl().equals(other.getAccountOpeningLicensePicUrl()))
            && (this.getLegalName() == null ? other.getLegalName() == null : this.getLegalName().equals(other.getLegalName()))
            && (this.getLegalCertType() == null ? other.getLegalCertType() == null : this.getLegalCertType().equals(other.getLegalCertType()))
            && (this.getLegalCertNo() == null ? other.getLegalCertNo() == null : this.getLegalCertNo().equals(other.getLegalCertNo()))
            && (this.getLegalCertValidTime() == null ? other.getLegalCertValidTime() == null : this.getLegalCertValidTime().equals(other.getLegalCertValidTime()))
            && (this.getLegalCertFrontPicUrl() == null ? other.getLegalCertFrontPicUrl() == null : this.getLegalCertFrontPicUrl().equals(other.getLegalCertFrontPicUrl()))
            && (this.getLegalCertBackPicUrl() == null ? other.getLegalCertBackPicUrl() == null : this.getLegalCertBackPicUrl().equals(other.getLegalCertBackPicUrl()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerAbbrName() == null) ? 0 : getPartnerAbbrName().hashCode());
        result = prime * result + ((getBusinessCategory() == null) ? 0 : getBusinessCategory().hashCode());
        result = prime * result + ((getStoreAddress() == null) ? 0 : getStoreAddress().hashCode());
        result = prime * result + ((getStoreEntrancePicsUrl() == null) ? 0 : getStoreEntrancePicsUrl().hashCode());
        result = prime * result + ((getStoreIndoorPicsUrl() == null) ? 0 : getStoreIndoorPicsUrl().hashCode());
        result = prime * result + ((getQualificationsPicUrl() == null) ? 0 : getQualificationsPicUrl().hashCode());
        result = prime * result + ((getBusinessAdditionPicsUrl() == null) ? 0 : getBusinessAdditionPicsUrl().hashCode());
        result = prime * result + ((getBusinessLicense() == null) ? 0 : getBusinessLicense().hashCode());
        result = prime * result + ((getBusinessLicensePicUrl() == null) ? 0 : getBusinessLicensePicUrl().hashCode());
        result = prime * result + ((getBusinessTime() == null) ? 0 : getBusinessTime().hashCode());
        result = prime * result + ((getBusinessScope() == null) ? 0 : getBusinessScope().hashCode());
        result = prime * result + ((getAccountOpeningLicensePicUrl() == null) ? 0 : getAccountOpeningLicensePicUrl().hashCode());
        result = prime * result + ((getLegalName() == null) ? 0 : getLegalName().hashCode());
        result = prime * result + ((getLegalCertType() == null) ? 0 : getLegalCertType().hashCode());
        result = prime * result + ((getLegalCertNo() == null) ? 0 : getLegalCertNo().hashCode());
        result = prime * result + ((getLegalCertValidTime() == null) ? 0 : getLegalCertValidTime().hashCode());
        result = prime * result + ((getLegalCertFrontPicUrl() == null) ? 0 : getLegalCertFrontPicUrl().hashCode());
        result = prime * result + ((getLegalCertBackPicUrl() == null) ? 0 : getLegalCertBackPicUrl().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}