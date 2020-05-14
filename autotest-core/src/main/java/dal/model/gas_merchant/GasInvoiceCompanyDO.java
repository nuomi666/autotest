package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_invoice_company")
public class GasInvoiceCompanyDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家编号
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 油站id
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 开票企业名称
     */
    @Column(name = "tax_company")
    private String taxCompany;

    /**
     * 纳税人识别号
     */
    @Column(name = "tax_code")
    private String taxCode;

    /**
     * 开票企业地址
     */
    @Column(name = "tax_address")
    private String taxAddress;

    /**
     * 开票企业电话
     */
    @Column(name = "tax_mobile")
    private String taxMobile;

    /**
     * 开票人
     */
    @Column(name = "tax_drawer")
    private String taxDrawer;

    /**
     * 开票企业银行账号
     */
    @Column(name = "tax_bank_no")
    private String taxBankNo;

    /**
     * 复核人
     */
    @Column(name = "tax_reviewer")
    private String taxReviewer;

    /**
     * 收款人
     */
    @Column(name = "tax_payee")
    private String taxPayee;

    /**
     * 商户(油站)APPID
     */
    @Column(name = "tax_app_id")
    private String taxAppId;

    /**
     * 加密秘钥
     */
    @Column(name = "tax_key")
    private String taxKey;

    /**
     * 证书地址
     */
    @Column(name = "tax_cert_path")
    private String taxCertPath;

    /**
     * 证书密码
     */
    @Column(name = "tax_cert_pwd")
    private String taxCertPwd;

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
     * 获取商家编号
     *
     * @return plat_partner_id - 商家编号
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置商家编号
     *
     * @param platPartnerId 商家编号
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
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
     * 获取开票企业名称
     *
     * @return tax_company - 开票企业名称
     */
    public String getTaxCompany() {
        return taxCompany;
    }

    /**
     * 设置开票企业名称
     *
     * @param taxCompany 开票企业名称
     */
    public void setTaxCompany(String taxCompany) {
        this.taxCompany = taxCompany == null ? null : taxCompany.trim();
    }

    /**
     * 获取纳税人识别号
     *
     * @return tax_code - 纳税人识别号
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * 设置纳税人识别号
     *
     * @param taxCode 纳税人识别号
     */
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode == null ? null : taxCode.trim();
    }

    /**
     * 获取开票企业地址
     *
     * @return tax_address - 开票企业地址
     */
    public String getTaxAddress() {
        return taxAddress;
    }

    /**
     * 设置开票企业地址
     *
     * @param taxAddress 开票企业地址
     */
    public void setTaxAddress(String taxAddress) {
        this.taxAddress = taxAddress == null ? null : taxAddress.trim();
    }

    /**
     * 获取开票企业电话
     *
     * @return tax_mobile - 开票企业电话
     */
    public String getTaxMobile() {
        return taxMobile;
    }

    /**
     * 设置开票企业电话
     *
     * @param taxMobile 开票企业电话
     */
    public void setTaxMobile(String taxMobile) {
        this.taxMobile = taxMobile == null ? null : taxMobile.trim();
    }

    /**
     * 获取开票人
     *
     * @return tax_drawer - 开票人
     */
    public String getTaxDrawer() {
        return taxDrawer;
    }

    /**
     * 设置开票人
     *
     * @param taxDrawer 开票人
     */
    public void setTaxDrawer(String taxDrawer) {
        this.taxDrawer = taxDrawer == null ? null : taxDrawer.trim();
    }

    /**
     * 获取开票企业银行账号
     *
     * @return tax_bank_no - 开票企业银行账号
     */
    public String getTaxBankNo() {
        return taxBankNo;
    }

    /**
     * 设置开票企业银行账号
     *
     * @param taxBankNo 开票企业银行账号
     */
    public void setTaxBankNo(String taxBankNo) {
        this.taxBankNo = taxBankNo == null ? null : taxBankNo.trim();
    }

    /**
     * 获取复核人
     *
     * @return tax_reviewer - 复核人
     */
    public String getTaxReviewer() {
        return taxReviewer;
    }

    /**
     * 设置复核人
     *
     * @param taxReviewer 复核人
     */
    public void setTaxReviewer(String taxReviewer) {
        this.taxReviewer = taxReviewer == null ? null : taxReviewer.trim();
    }

    /**
     * 获取收款人
     *
     * @return tax_payee - 收款人
     */
    public String getTaxPayee() {
        return taxPayee;
    }

    /**
     * 设置收款人
     *
     * @param taxPayee 收款人
     */
    public void setTaxPayee(String taxPayee) {
        this.taxPayee = taxPayee == null ? null : taxPayee.trim();
    }

    /**
     * 获取商户(油站)APPID
     *
     * @return tax_app_id - 商户(油站)APPID
     */
    public String getTaxAppId() {
        return taxAppId;
    }

    /**
     * 设置商户(油站)APPID
     *
     * @param taxAppId 商户(油站)APPID
     */
    public void setTaxAppId(String taxAppId) {
        this.taxAppId = taxAppId == null ? null : taxAppId.trim();
    }

    /**
     * 获取加密秘钥
     *
     * @return tax_key - 加密秘钥
     */
    public String getTaxKey() {
        return taxKey;
    }

    /**
     * 设置加密秘钥
     *
     * @param taxKey 加密秘钥
     */
    public void setTaxKey(String taxKey) {
        this.taxKey = taxKey == null ? null : taxKey.trim();
    }

    /**
     * 获取证书地址
     *
     * @return tax_cert_path - 证书地址
     */
    public String getTaxCertPath() {
        return taxCertPath;
    }

    /**
     * 设置证书地址
     *
     * @param taxCertPath 证书地址
     */
    public void setTaxCertPath(String taxCertPath) {
        this.taxCertPath = taxCertPath == null ? null : taxCertPath.trim();
    }

    /**
     * 获取证书密码
     *
     * @return tax_cert_pwd - 证书密码
     */
    public String getTaxCertPwd() {
        return taxCertPwd;
    }

    /**
     * 设置证书密码
     *
     * @param taxCertPwd 证书密码
     */
    public void setTaxCertPwd(String taxCertPwd) {
        this.taxCertPwd = taxCertPwd == null ? null : taxCertPwd.trim();
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
        sb.append(", stationId=").append(stationId);
        sb.append(", taxCompany=").append(taxCompany);
        sb.append(", taxCode=").append(taxCode);
        sb.append(", taxAddress=").append(taxAddress);
        sb.append(", taxMobile=").append(taxMobile);
        sb.append(", taxDrawer=").append(taxDrawer);
        sb.append(", taxBankNo=").append(taxBankNo);
        sb.append(", taxReviewer=").append(taxReviewer);
        sb.append(", taxPayee=").append(taxPayee);
        sb.append(", taxAppId=").append(taxAppId);
        sb.append(", taxKey=").append(taxKey);
        sb.append(", taxCertPath=").append(taxCertPath);
        sb.append(", taxCertPwd=").append(taxCertPwd);
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
        GasInvoiceCompanyDO other = (GasInvoiceCompanyDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getTaxCompany() == null ? other.getTaxCompany() == null : this.getTaxCompany().equals(other.getTaxCompany()))
            && (this.getTaxCode() == null ? other.getTaxCode() == null : this.getTaxCode().equals(other.getTaxCode()))
            && (this.getTaxAddress() == null ? other.getTaxAddress() == null : this.getTaxAddress().equals(other.getTaxAddress()))
            && (this.getTaxMobile() == null ? other.getTaxMobile() == null : this.getTaxMobile().equals(other.getTaxMobile()))
            && (this.getTaxDrawer() == null ? other.getTaxDrawer() == null : this.getTaxDrawer().equals(other.getTaxDrawer()))
            && (this.getTaxBankNo() == null ? other.getTaxBankNo() == null : this.getTaxBankNo().equals(other.getTaxBankNo()))
            && (this.getTaxReviewer() == null ? other.getTaxReviewer() == null : this.getTaxReviewer().equals(other.getTaxReviewer()))
            && (this.getTaxPayee() == null ? other.getTaxPayee() == null : this.getTaxPayee().equals(other.getTaxPayee()))
            && (this.getTaxAppId() == null ? other.getTaxAppId() == null : this.getTaxAppId().equals(other.getTaxAppId()))
            && (this.getTaxKey() == null ? other.getTaxKey() == null : this.getTaxKey().equals(other.getTaxKey()))
            && (this.getTaxCertPath() == null ? other.getTaxCertPath() == null : this.getTaxCertPath().equals(other.getTaxCertPath()))
            && (this.getTaxCertPwd() == null ? other.getTaxCertPwd() == null : this.getTaxCertPwd().equals(other.getTaxCertPwd()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getTaxCompany() == null) ? 0 : getTaxCompany().hashCode());
        result = prime * result + ((getTaxCode() == null) ? 0 : getTaxCode().hashCode());
        result = prime * result + ((getTaxAddress() == null) ? 0 : getTaxAddress().hashCode());
        result = prime * result + ((getTaxMobile() == null) ? 0 : getTaxMobile().hashCode());
        result = prime * result + ((getTaxDrawer() == null) ? 0 : getTaxDrawer().hashCode());
        result = prime * result + ((getTaxBankNo() == null) ? 0 : getTaxBankNo().hashCode());
        result = prime * result + ((getTaxReviewer() == null) ? 0 : getTaxReviewer().hashCode());
        result = prime * result + ((getTaxPayee() == null) ? 0 : getTaxPayee().hashCode());
        result = prime * result + ((getTaxAppId() == null) ? 0 : getTaxAppId().hashCode());
        result = prime * result + ((getTaxKey() == null) ? 0 : getTaxKey().hashCode());
        result = prime * result + ((getTaxCertPath() == null) ? 0 : getTaxCertPath().hashCode());
        result = prime * result + ((getTaxCertPwd() == null) ? 0 : getTaxCertPwd().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}