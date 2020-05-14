package dal.model.merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant")
public class MerchantDO implements Serializable {
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
     * 父商户号
     */
    @Column(name = "parent_partner_id")
    private String parentPartnerId;

    /**
     * 外部用户ID
     */
    @Column(name = "out_user_id")
    private String outUserId;

    /**
     * 商户名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 商户类型：普通、平台商、平台商子商户
     */
    @Column(name = "merchant_type")
    private String merchantType;

    /**
     * 商户状态
     */
    private String status;

    /**
     * 功能状态
     */
    @Column(name = "lead_status")
    private String leadStatus;

    /**
     * 公众号的唯一标识
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 公众号刷新令牌
     */
    @Column(name = "app_refresh_token")
    private String appRefreshToken;

    /**
     * 渠道ID
     */
    @Column(name = "channel_id")
    private String channelId;

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
     * 获取父商户号
     *
     * @return parent_partner_id - 父商户号
     */
    public String getParentPartnerId() {
        return parentPartnerId;
    }

    /**
     * 设置父商户号
     *
     * @param parentPartnerId 父商户号
     */
    public void setParentPartnerId(String parentPartnerId) {
        this.parentPartnerId = parentPartnerId == null ? null : parentPartnerId.trim();
    }

    /**
     * 获取外部用户ID
     *
     * @return out_user_id - 外部用户ID
     */
    public String getOutUserId() {
        return outUserId;
    }

    /**
     * 设置外部用户ID
     *
     * @param outUserId 外部用户ID
     */
    public void setOutUserId(String outUserId) {
        this.outUserId = outUserId == null ? null : outUserId.trim();
    }

    /**
     * 获取商户名称
     *
     * @return merchant_name - 商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 设置商户名称
     *
     * @param merchantName 商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * 获取商户类型：普通、平台商、平台商子商户
     *
     * @return merchant_type - 商户类型：普通、平台商、平台商子商户
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * 设置商户类型：普通、平台商、平台商子商户
     *
     * @param merchantType 商户类型：普通、平台商、平台商子商户
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * 获取商户状态
     *
     * @return status - 商户状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置商户状态
     *
     * @param status 商户状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取功能状态
     *
     * @return lead_status - 功能状态
     */
    public String getLeadStatus() {
        return leadStatus;
    }

    /**
     * 设置功能状态
     *
     * @param leadStatus 功能状态
     */
    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus == null ? null : leadStatus.trim();
    }

    /**
     * 获取公众号的唯一标识
     *
     * @return app_id - 公众号的唯一标识
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置公众号的唯一标识
     *
     * @param appId 公众号的唯一标识
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取公众号刷新令牌
     *
     * @return app_refresh_token - 公众号刷新令牌
     */
    public String getAppRefreshToken() {
        return appRefreshToken;
    }

    /**
     * 设置公众号刷新令牌
     *
     * @param appRefreshToken 公众号刷新令牌
     */
    public void setAppRefreshToken(String appRefreshToken) {
        this.appRefreshToken = appRefreshToken == null ? null : appRefreshToken.trim();
    }

    /**
     * 获取渠道ID
     *
     * @return channel_id - 渠道ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道ID
     *
     * @param channelId 渠道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
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
        sb.append(", parentPartnerId=").append(parentPartnerId);
        sb.append(", outUserId=").append(outUserId);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", merchantType=").append(merchantType);
        sb.append(", status=").append(status);
        sb.append(", leadStatus=").append(leadStatus);
        sb.append(", appId=").append(appId);
        sb.append(", appRefreshToken=").append(appRefreshToken);
        sb.append(", channelId=").append(channelId);
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
        MerchantDO other = (MerchantDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getParentPartnerId() == null ? other.getParentPartnerId() == null : this.getParentPartnerId().equals(other.getParentPartnerId()))
            && (this.getOutUserId() == null ? other.getOutUserId() == null : this.getOutUserId().equals(other.getOutUserId()))
            && (this.getMerchantName() == null ? other.getMerchantName() == null : this.getMerchantName().equals(other.getMerchantName()))
            && (this.getMerchantType() == null ? other.getMerchantType() == null : this.getMerchantType().equals(other.getMerchantType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLeadStatus() == null ? other.getLeadStatus() == null : this.getLeadStatus().equals(other.getLeadStatus()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAppRefreshToken() == null ? other.getAppRefreshToken() == null : this.getAppRefreshToken().equals(other.getAppRefreshToken()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getParentPartnerId() == null) ? 0 : getParentPartnerId().hashCode());
        result = prime * result + ((getOutUserId() == null) ? 0 : getOutUserId().hashCode());
        result = prime * result + ((getMerchantName() == null) ? 0 : getMerchantName().hashCode());
        result = prime * result + ((getMerchantType() == null) ? 0 : getMerchantType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLeadStatus() == null) ? 0 : getLeadStatus().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppRefreshToken() == null) ? 0 : getAppRefreshToken().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}