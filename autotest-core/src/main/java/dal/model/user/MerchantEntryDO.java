package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_entry")
public class MerchantEntryDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 请求流水号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 统一流水id
     */
    private String gid;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商户号
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 清结算结算账号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 通道ID
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 渠道方平台商户号
     */
    @Column(name = "channel_plat_merchant_id")
    private String channelPlatMerchantId;

    /**
     * 渠道进件子商户性质(ENTERPRISE_LEGAL_PERSON-企业法人,OTHER_LEGAL_PERSON-其他法人,INDIVIDUAL_BUSINESS-个体工商户,NATURAL_PERSON-自然人)
     */
    @Column(name = "sub_merchant_property")
    private String subMerchantProperty;

    /**
     * 进件子商户号
     */
    @Column(name = "sub_merchant_id")
    private String subMerchantId;

    /**
     * 渠道方进件子商户号
     */
    @Column(name = "channel_sub_merchant_id")
    private String channelSubMerchantId;

    /**
     * 签约状态
     */
    @Column(name = "signed_status")
    private String signedStatus;

    /**
     * 真实信息认证状态
     */
    @Column(name = "certify_status")
    private String certifyStatus;

    /**
     * 渠道方进件子商户附属账户
     */
    @Column(name = "channel_sub_merchant_account")
    private String channelSubMerchantAccount;

    /**
     * 外部数据域
     */
    @Column(name = "external_meta_data")
    private String externalMetaData;

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
     * 获取请求流水号
     *
     * @return req_id - 请求流水号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求流水号
     *
     * @param reqId 请求流水号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取统一流水id
     *
     * @return gid - 统一流水id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置统一流水id
     *
     * @param gid 统一流水id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
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
     * 获取平台商户号
     *
     * @return plat_partner_id - 平台商户号
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户号
     *
     * @param platPartnerId 平台商户号
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取清结算结算账号
     *
     * @return account_no - 清结算结算账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置清结算结算账号
     *
     * @param accountNo 清结算结算账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取通道ID
     *
     * @return channel_id - 通道ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置通道ID
     *
     * @param channelId 通道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取渠道方平台商户号
     *
     * @return channel_plat_merchant_id - 渠道方平台商户号
     */
    public String getChannelPlatMerchantId() {
        return channelPlatMerchantId;
    }

    /**
     * 设置渠道方平台商户号
     *
     * @param channelPlatMerchantId 渠道方平台商户号
     */
    public void setChannelPlatMerchantId(String channelPlatMerchantId) {
        this.channelPlatMerchantId = channelPlatMerchantId == null ? null : channelPlatMerchantId.trim();
    }

    /**
     * 获取渠道进件子商户性质(ENTERPRISE_LEGAL_PERSON-企业法人,OTHER_LEGAL_PERSON-其他法人,INDIVIDUAL_BUSINESS-个体工商户,NATURAL_PERSON-自然人)
     *
     * @return sub_merchant_property - 渠道进件子商户性质(ENTERPRISE_LEGAL_PERSON-企业法人,OTHER_LEGAL_PERSON-其他法人,INDIVIDUAL_BUSINESS-个体工商户,NATURAL_PERSON-自然人)
     */
    public String getSubMerchantProperty() {
        return subMerchantProperty;
    }

    /**
     * 设置渠道进件子商户性质(ENTERPRISE_LEGAL_PERSON-企业法人,OTHER_LEGAL_PERSON-其他法人,INDIVIDUAL_BUSINESS-个体工商户,NATURAL_PERSON-自然人)
     *
     * @param subMerchantProperty 渠道进件子商户性质(ENTERPRISE_LEGAL_PERSON-企业法人,OTHER_LEGAL_PERSON-其他法人,INDIVIDUAL_BUSINESS-个体工商户,NATURAL_PERSON-自然人)
     */
    public void setSubMerchantProperty(String subMerchantProperty) {
        this.subMerchantProperty = subMerchantProperty == null ? null : subMerchantProperty.trim();
    }

    /**
     * 获取进件子商户号
     *
     * @return sub_merchant_id - 进件子商户号
     */
    public String getSubMerchantId() {
        return subMerchantId;
    }

    /**
     * 设置进件子商户号
     *
     * @param subMerchantId 进件子商户号
     */
    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId == null ? null : subMerchantId.trim();
    }

    /**
     * 获取渠道方进件子商户号
     *
     * @return channel_sub_merchant_id - 渠道方进件子商户号
     */
    public String getChannelSubMerchantId() {
        return channelSubMerchantId;
    }

    /**
     * 设置渠道方进件子商户号
     *
     * @param channelSubMerchantId 渠道方进件子商户号
     */
    public void setChannelSubMerchantId(String channelSubMerchantId) {
        this.channelSubMerchantId = channelSubMerchantId == null ? null : channelSubMerchantId.trim();
    }

    /**
     * 获取签约状态
     *
     * @return signed_status - 签约状态
     */
    public String getSignedStatus() {
        return signedStatus;
    }

    /**
     * 设置签约状态
     *
     * @param signedStatus 签约状态
     */
    public void setSignedStatus(String signedStatus) {
        this.signedStatus = signedStatus == null ? null : signedStatus.trim();
    }

    /**
     * 获取真实信息认证状态
     *
     * @return certify_status - 真实信息认证状态
     */
    public String getCertifyStatus() {
        return certifyStatus;
    }

    /**
     * 设置真实信息认证状态
     *
     * @param certifyStatus 真实信息认证状态
     */
    public void setCertifyStatus(String certifyStatus) {
        this.certifyStatus = certifyStatus == null ? null : certifyStatus.trim();
    }

    /**
     * 获取渠道方进件子商户附属账户
     *
     * @return channel_sub_merchant_account - 渠道方进件子商户附属账户
     */
    public String getChannelSubMerchantAccount() {
        return channelSubMerchantAccount;
    }

    /**
     * 设置渠道方进件子商户附属账户
     *
     * @param channelSubMerchantAccount 渠道方进件子商户附属账户
     */
    public void setChannelSubMerchantAccount(String channelSubMerchantAccount) {
        this.channelSubMerchantAccount = channelSubMerchantAccount == null ? null : channelSubMerchantAccount.trim();
    }

    /**
     * 获取外部数据域
     *
     * @return external_meta_data - 外部数据域
     */
    public String getExternalMetaData() {
        return externalMetaData;
    }

    /**
     * 设置外部数据域
     *
     * @param externalMetaData 外部数据域
     */
    public void setExternalMetaData(String externalMetaData) {
        this.externalMetaData = externalMetaData == null ? null : externalMetaData.trim();
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
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelPlatMerchantId=").append(channelPlatMerchantId);
        sb.append(", subMerchantProperty=").append(subMerchantProperty);
        sb.append(", subMerchantId=").append(subMerchantId);
        sb.append(", channelSubMerchantId=").append(channelSubMerchantId);
        sb.append(", signedStatus=").append(signedStatus);
        sb.append(", certifyStatus=").append(certifyStatus);
        sb.append(", channelSubMerchantAccount=").append(channelSubMerchantAccount);
        sb.append(", externalMetaData=").append(externalMetaData);
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
        MerchantEntryDO other = (MerchantEntryDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelPlatMerchantId() == null ? other.getChannelPlatMerchantId() == null : this.getChannelPlatMerchantId().equals(other.getChannelPlatMerchantId()))
            && (this.getSubMerchantProperty() == null ? other.getSubMerchantProperty() == null : this.getSubMerchantProperty().equals(other.getSubMerchantProperty()))
            && (this.getSubMerchantId() == null ? other.getSubMerchantId() == null : this.getSubMerchantId().equals(other.getSubMerchantId()))
            && (this.getChannelSubMerchantId() == null ? other.getChannelSubMerchantId() == null : this.getChannelSubMerchantId().equals(other.getChannelSubMerchantId()))
            && (this.getSignedStatus() == null ? other.getSignedStatus() == null : this.getSignedStatus().equals(other.getSignedStatus()))
            && (this.getCertifyStatus() == null ? other.getCertifyStatus() == null : this.getCertifyStatus().equals(other.getCertifyStatus()))
            && (this.getChannelSubMerchantAccount() == null ? other.getChannelSubMerchantAccount() == null : this.getChannelSubMerchantAccount().equals(other.getChannelSubMerchantAccount()))
            && (this.getExternalMetaData() == null ? other.getExternalMetaData() == null : this.getExternalMetaData().equals(other.getExternalMetaData()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelPlatMerchantId() == null) ? 0 : getChannelPlatMerchantId().hashCode());
        result = prime * result + ((getSubMerchantProperty() == null) ? 0 : getSubMerchantProperty().hashCode());
        result = prime * result + ((getSubMerchantId() == null) ? 0 : getSubMerchantId().hashCode());
        result = prime * result + ((getChannelSubMerchantId() == null) ? 0 : getChannelSubMerchantId().hashCode());
        result = prime * result + ((getSignedStatus() == null) ? 0 : getSignedStatus().hashCode());
        result = prime * result + ((getCertifyStatus() == null) ? 0 : getCertifyStatus().hashCode());
        result = prime * result + ((getChannelSubMerchantAccount() == null) ? 0 : getChannelSubMerchantAccount().hashCode());
        result = prime * result + ((getExternalMetaData() == null) ? 0 : getExternalMetaData().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}