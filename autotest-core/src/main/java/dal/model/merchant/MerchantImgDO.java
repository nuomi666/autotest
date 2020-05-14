package dal.model.merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_img")
public class MerchantImgDO implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户号(与清结算userid保持一致)
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 营业执照图片url
     */
    @Column(name = "business_license_url")
    private String businessLicenseUrl;

    /**
     * 组织机构代码证图片url
     */
    @Column(name = "organization_code_url")
    private String organizationCodeUrl;

    /**
     * 税务登记证图片url
     */
    @Column(name = "tax_certificate_url")
    private String taxCertificateUrl;

    /**
     * 对公户开户许可证图片url
     */
    @Column(name = "bank_settlement_url")
    private String bankSettlementUrl;

    /**
     * 企业法人证件-正面图片url
     */
    @Column(name = "legal_cerificate_front_url")
    private String legalCerificateFrontUrl;

    /**
     * 企业法人证件-反面图片url
     */
    @Column(name = "legal_cerificate_back_url")
    private String legalCerificateBackUrl;

    /**
     * 以前上传的营业执照图片url
     */
    @Column(name = "old_business_license_url")
    private String oldBusinessLicenseUrl;

    /**
     * 以前上传的组织机构代码证图片url
     */
    @Column(name = "old_organization_code_url")
    private String oldOrganizationCodeUrl;

    /**
     * 以前上传的税务登记证图片url
     */
    @Column(name = "old_tax_certificate_url")
    private String oldTaxCertificateUrl;

    /**
     * 以前上传的对公户开户许可证图片url
     */
    @Column(name = "old_bank_settlement_url")
    private String oldBankSettlementUrl;

    /**
     * 以前上传的企业法人证件-正面图片url
     */
    @Column(name = "old_legal_cerificate_front_url")
    private String oldLegalCerificateFrontUrl;

    /**
     * 以前上传的企业法人证件-反面图片url
     */
    @Column(name = "old_legal_cerificate_back_url")
    private String oldLegalCerificateBackUrl;

    private String status;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商户号(与清结算userid保持一致)
     *
     * @return partner_id - 商户号(与清结算userid保持一致)
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户号(与清结算userid保持一致)
     *
     * @param partnerId 商户号(与清结算userid保持一致)
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取营业执照图片url
     *
     * @return business_license_url - 营业执照图片url
     */
    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    /**
     * 设置营业执照图片url
     *
     * @param businessLicenseUrl 营业执照图片url
     */
    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl == null ? null : businessLicenseUrl.trim();
    }

    /**
     * 获取组织机构代码证图片url
     *
     * @return organization_code_url - 组织机构代码证图片url
     */
    public String getOrganizationCodeUrl() {
        return organizationCodeUrl;
    }

    /**
     * 设置组织机构代码证图片url
     *
     * @param organizationCodeUrl 组织机构代码证图片url
     */
    public void setOrganizationCodeUrl(String organizationCodeUrl) {
        this.organizationCodeUrl = organizationCodeUrl == null ? null : organizationCodeUrl.trim();
    }

    /**
     * 获取税务登记证图片url
     *
     * @return tax_certificate_url - 税务登记证图片url
     */
    public String getTaxCertificateUrl() {
        return taxCertificateUrl;
    }

    /**
     * 设置税务登记证图片url
     *
     * @param taxCertificateUrl 税务登记证图片url
     */
    public void setTaxCertificateUrl(String taxCertificateUrl) {
        this.taxCertificateUrl = taxCertificateUrl == null ? null : taxCertificateUrl.trim();
    }

    /**
     * 获取对公户开户许可证图片url
     *
     * @return bank_settlement_url - 对公户开户许可证图片url
     */
    public String getBankSettlementUrl() {
        return bankSettlementUrl;
    }

    /**
     * 设置对公户开户许可证图片url
     *
     * @param bankSettlementUrl 对公户开户许可证图片url
     */
    public void setBankSettlementUrl(String bankSettlementUrl) {
        this.bankSettlementUrl = bankSettlementUrl == null ? null : bankSettlementUrl.trim();
    }

    /**
     * 获取企业法人证件-正面图片url
     *
     * @return legal_cerificate_front_url - 企业法人证件-正面图片url
     */
    public String getLegalCerificateFrontUrl() {
        return legalCerificateFrontUrl;
    }

    /**
     * 设置企业法人证件-正面图片url
     *
     * @param legalCerificateFrontUrl 企业法人证件-正面图片url
     */
    public void setLegalCerificateFrontUrl(String legalCerificateFrontUrl) {
        this.legalCerificateFrontUrl = legalCerificateFrontUrl == null ? null : legalCerificateFrontUrl.trim();
    }

    /**
     * 获取企业法人证件-反面图片url
     *
     * @return legal_cerificate_back_url - 企业法人证件-反面图片url
     */
    public String getLegalCerificateBackUrl() {
        return legalCerificateBackUrl;
    }

    /**
     * 设置企业法人证件-反面图片url
     *
     * @param legalCerificateBackUrl 企业法人证件-反面图片url
     */
    public void setLegalCerificateBackUrl(String legalCerificateBackUrl) {
        this.legalCerificateBackUrl = legalCerificateBackUrl == null ? null : legalCerificateBackUrl.trim();
    }

    /**
     * 获取以前上传的营业执照图片url
     *
     * @return old_business_license_url - 以前上传的营业执照图片url
     */
    public String getOldBusinessLicenseUrl() {
        return oldBusinessLicenseUrl;
    }

    /**
     * 设置以前上传的营业执照图片url
     *
     * @param oldBusinessLicenseUrl 以前上传的营业执照图片url
     */
    public void setOldBusinessLicenseUrl(String oldBusinessLicenseUrl) {
        this.oldBusinessLicenseUrl = oldBusinessLicenseUrl == null ? null : oldBusinessLicenseUrl.trim();
    }

    /**
     * 获取以前上传的组织机构代码证图片url
     *
     * @return old_organization_code_url - 以前上传的组织机构代码证图片url
     */
    public String getOldOrganizationCodeUrl() {
        return oldOrganizationCodeUrl;
    }

    /**
     * 设置以前上传的组织机构代码证图片url
     *
     * @param oldOrganizationCodeUrl 以前上传的组织机构代码证图片url
     */
    public void setOldOrganizationCodeUrl(String oldOrganizationCodeUrl) {
        this.oldOrganizationCodeUrl = oldOrganizationCodeUrl == null ? null : oldOrganizationCodeUrl.trim();
    }

    /**
     * 获取以前上传的税务登记证图片url
     *
     * @return old_tax_certificate_url - 以前上传的税务登记证图片url
     */
    public String getOldTaxCertificateUrl() {
        return oldTaxCertificateUrl;
    }

    /**
     * 设置以前上传的税务登记证图片url
     *
     * @param oldTaxCertificateUrl 以前上传的税务登记证图片url
     */
    public void setOldTaxCertificateUrl(String oldTaxCertificateUrl) {
        this.oldTaxCertificateUrl = oldTaxCertificateUrl == null ? null : oldTaxCertificateUrl.trim();
    }

    /**
     * 获取以前上传的对公户开户许可证图片url
     *
     * @return old_bank_settlement_url - 以前上传的对公户开户许可证图片url
     */
    public String getOldBankSettlementUrl() {
        return oldBankSettlementUrl;
    }

    /**
     * 设置以前上传的对公户开户许可证图片url
     *
     * @param oldBankSettlementUrl 以前上传的对公户开户许可证图片url
     */
    public void setOldBankSettlementUrl(String oldBankSettlementUrl) {
        this.oldBankSettlementUrl = oldBankSettlementUrl == null ? null : oldBankSettlementUrl.trim();
    }

    /**
     * 获取以前上传的企业法人证件-正面图片url
     *
     * @return old_legal_cerificate_front_url - 以前上传的企业法人证件-正面图片url
     */
    public String getOldLegalCerificateFrontUrl() {
        return oldLegalCerificateFrontUrl;
    }

    /**
     * 设置以前上传的企业法人证件-正面图片url
     *
     * @param oldLegalCerificateFrontUrl 以前上传的企业法人证件-正面图片url
     */
    public void setOldLegalCerificateFrontUrl(String oldLegalCerificateFrontUrl) {
        this.oldLegalCerificateFrontUrl = oldLegalCerificateFrontUrl == null ? null : oldLegalCerificateFrontUrl.trim();
    }

    /**
     * 获取以前上传的企业法人证件-反面图片url
     *
     * @return old_legal_cerificate_back_url - 以前上传的企业法人证件-反面图片url
     */
    public String getOldLegalCerificateBackUrl() {
        return oldLegalCerificateBackUrl;
    }

    /**
     * 设置以前上传的企业法人证件-反面图片url
     *
     * @param oldLegalCerificateBackUrl 以前上传的企业法人证件-反面图片url
     */
    public void setOldLegalCerificateBackUrl(String oldLegalCerificateBackUrl) {
        this.oldLegalCerificateBackUrl = oldLegalCerificateBackUrl == null ? null : oldLegalCerificateBackUrl.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取创建时间
     *
     * @return raw_add_time - 创建时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置创建时间
     *
     * @param rawAddTime 创建时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
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
        sb.append(", businessLicenseUrl=").append(businessLicenseUrl);
        sb.append(", organizationCodeUrl=").append(organizationCodeUrl);
        sb.append(", taxCertificateUrl=").append(taxCertificateUrl);
        sb.append(", bankSettlementUrl=").append(bankSettlementUrl);
        sb.append(", legalCerificateFrontUrl=").append(legalCerificateFrontUrl);
        sb.append(", legalCerificateBackUrl=").append(legalCerificateBackUrl);
        sb.append(", oldBusinessLicenseUrl=").append(oldBusinessLicenseUrl);
        sb.append(", oldOrganizationCodeUrl=").append(oldOrganizationCodeUrl);
        sb.append(", oldTaxCertificateUrl=").append(oldTaxCertificateUrl);
        sb.append(", oldBankSettlementUrl=").append(oldBankSettlementUrl);
        sb.append(", oldLegalCerificateFrontUrl=").append(oldLegalCerificateFrontUrl);
        sb.append(", oldLegalCerificateBackUrl=").append(oldLegalCerificateBackUrl);
        sb.append(", status=").append(status);
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
        MerchantImgDO other = (MerchantImgDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getBusinessLicenseUrl() == null ? other.getBusinessLicenseUrl() == null : this.getBusinessLicenseUrl().equals(other.getBusinessLicenseUrl()))
            && (this.getOrganizationCodeUrl() == null ? other.getOrganizationCodeUrl() == null : this.getOrganizationCodeUrl().equals(other.getOrganizationCodeUrl()))
            && (this.getTaxCertificateUrl() == null ? other.getTaxCertificateUrl() == null : this.getTaxCertificateUrl().equals(other.getTaxCertificateUrl()))
            && (this.getBankSettlementUrl() == null ? other.getBankSettlementUrl() == null : this.getBankSettlementUrl().equals(other.getBankSettlementUrl()))
            && (this.getLegalCerificateFrontUrl() == null ? other.getLegalCerificateFrontUrl() == null : this.getLegalCerificateFrontUrl().equals(other.getLegalCerificateFrontUrl()))
            && (this.getLegalCerificateBackUrl() == null ? other.getLegalCerificateBackUrl() == null : this.getLegalCerificateBackUrl().equals(other.getLegalCerificateBackUrl()))
            && (this.getOldBusinessLicenseUrl() == null ? other.getOldBusinessLicenseUrl() == null : this.getOldBusinessLicenseUrl().equals(other.getOldBusinessLicenseUrl()))
            && (this.getOldOrganizationCodeUrl() == null ? other.getOldOrganizationCodeUrl() == null : this.getOldOrganizationCodeUrl().equals(other.getOldOrganizationCodeUrl()))
            && (this.getOldTaxCertificateUrl() == null ? other.getOldTaxCertificateUrl() == null : this.getOldTaxCertificateUrl().equals(other.getOldTaxCertificateUrl()))
            && (this.getOldBankSettlementUrl() == null ? other.getOldBankSettlementUrl() == null : this.getOldBankSettlementUrl().equals(other.getOldBankSettlementUrl()))
            && (this.getOldLegalCerificateFrontUrl() == null ? other.getOldLegalCerificateFrontUrl() == null : this.getOldLegalCerificateFrontUrl().equals(other.getOldLegalCerificateFrontUrl()))
            && (this.getOldLegalCerificateBackUrl() == null ? other.getOldLegalCerificateBackUrl() == null : this.getOldLegalCerificateBackUrl().equals(other.getOldLegalCerificateBackUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getBusinessLicenseUrl() == null) ? 0 : getBusinessLicenseUrl().hashCode());
        result = prime * result + ((getOrganizationCodeUrl() == null) ? 0 : getOrganizationCodeUrl().hashCode());
        result = prime * result + ((getTaxCertificateUrl() == null) ? 0 : getTaxCertificateUrl().hashCode());
        result = prime * result + ((getBankSettlementUrl() == null) ? 0 : getBankSettlementUrl().hashCode());
        result = prime * result + ((getLegalCerificateFrontUrl() == null) ? 0 : getLegalCerificateFrontUrl().hashCode());
        result = prime * result + ((getLegalCerificateBackUrl() == null) ? 0 : getLegalCerificateBackUrl().hashCode());
        result = prime * result + ((getOldBusinessLicenseUrl() == null) ? 0 : getOldBusinessLicenseUrl().hashCode());
        result = prime * result + ((getOldOrganizationCodeUrl() == null) ? 0 : getOldOrganizationCodeUrl().hashCode());
        result = prime * result + ((getOldTaxCertificateUrl() == null) ? 0 : getOldTaxCertificateUrl().hashCode());
        result = prime * result + ((getOldBankSettlementUrl() == null) ? 0 : getOldBankSettlementUrl().hashCode());
        result = prime * result + ((getOldLegalCerificateFrontUrl() == null) ? 0 : getOldLegalCerificateFrontUrl().hashCode());
        result = prime * result + ((getOldLegalCerificateBackUrl() == null) ? 0 : getOldLegalCerificateBackUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}