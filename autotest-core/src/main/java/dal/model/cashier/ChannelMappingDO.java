package dal.model.cashier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "channel_mapping")
public class ChannelMappingDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 渠道映射ID
     */
    @Column(name = "channel_mapping_id")
    private String channelMappingId;

    /**
     * 渠道ID
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 渠道名称
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户名称
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 微信appid
     */
    @Column(name = "wechat_appid")
    private String wechatAppid;

    /**
     * 支付宝appid
     */
    @Column(name = "alipay_appid")
    private String alipayAppid;

    /**
     * 微信应用APPID
     */
    @Column(name = "wechat_app_appid")
    private String wechatAppAppid;

    /**
     * 支付宝应用APPID
     */
    @Column(name = "alipay_app_appid")
    private String alipayAppAppid;

    /**
     * 密码
     */
    private String password;

    /**
     * 渠道商户号
     */
    @Column(name = "channel_partner_id")
    private String channelPartnerId;

    /**
     * 渠道二级商户号
     */
    @Column(name = "sub_channel_partner_id")
    private String subChannelPartnerId;

    /**
     * 签名
     */
    private String sign;

    /**
     * 公钥
     */
    @Column(name = "public_key")
    private String publicKey;

    /**
     * 系统公钥
     */
    @Column(name = "system_public_key")
    private String systemPublicKey;

    /**
     * 私钥
     */
    @Column(name = "private_key")
    private String privateKey;

    /**
     * 异步通知地址
     */
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 支付成功跳转地址
     */
    @Column(name = "return_url")
    private String returnUrl;

    /**
     * 商户渠道开关
     */
    private String state;

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

    /**
     * 删除标示
     */
    @Column(name = "mark_delete")
    private String markDelete;

    /**
     * 证书
     */
    private String cert;

    /**
     * 支持的支付渠道
     */
    @Column(name = "available_pay_channel")
    private String availablePayChannel;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取渠道映射ID
     *
     * @return channel_mapping_id - 渠道映射ID
     */
    public String getChannelMappingId() {
        return channelMappingId;
    }

    /**
     * 设置渠道映射ID
     *
     * @param channelMappingId 渠道映射ID
     */
    public void setChannelMappingId(String channelMappingId) {
        this.channelMappingId = channelMappingId == null ? null : channelMappingId.trim();
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
     * 获取渠道名称
     *
     * @return channel_name - 渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置渠道名称
     *
     * @param channelName 渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 获取商户ID
     *
     * @return partner_id - 商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户ID
     *
     * @param partnerId 商户ID
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
     * 获取微信appid
     *
     * @return wechat_appid - 微信appid
     */
    public String getWechatAppid() {
        return wechatAppid;
    }

    /**
     * 设置微信appid
     *
     * @param wechatAppid 微信appid
     */
    public void setWechatAppid(String wechatAppid) {
        this.wechatAppid = wechatAppid == null ? null : wechatAppid.trim();
    }

    /**
     * 获取支付宝appid
     *
     * @return alipay_appid - 支付宝appid
     */
    public String getAlipayAppid() {
        return alipayAppid;
    }

    /**
     * 设置支付宝appid
     *
     * @param alipayAppid 支付宝appid
     */
    public void setAlipayAppid(String alipayAppid) {
        this.alipayAppid = alipayAppid == null ? null : alipayAppid.trim();
    }

    /**
     * 获取微信应用APPID
     *
     * @return wechat_app_appid - 微信应用APPID
     */
    public String getWechatAppAppid() {
        return wechatAppAppid;
    }

    /**
     * 设置微信应用APPID
     *
     * @param wechatAppAppid 微信应用APPID
     */
    public void setWechatAppAppid(String wechatAppAppid) {
        this.wechatAppAppid = wechatAppAppid == null ? null : wechatAppAppid.trim();
    }

    /**
     * 获取支付宝应用APPID
     *
     * @return alipay_app_appid - 支付宝应用APPID
     */
    public String getAlipayAppAppid() {
        return alipayAppAppid;
    }

    /**
     * 设置支付宝应用APPID
     *
     * @param alipayAppAppid 支付宝应用APPID
     */
    public void setAlipayAppAppid(String alipayAppAppid) {
        this.alipayAppAppid = alipayAppAppid == null ? null : alipayAppAppid.trim();
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
     * 获取渠道商户号
     *
     * @return channel_partner_id - 渠道商户号
     */
    public String getChannelPartnerId() {
        return channelPartnerId;
    }

    /**
     * 设置渠道商户号
     *
     * @param channelPartnerId 渠道商户号
     */
    public void setChannelPartnerId(String channelPartnerId) {
        this.channelPartnerId = channelPartnerId == null ? null : channelPartnerId.trim();
    }

    /**
     * 获取渠道二级商户号
     *
     * @return sub_channel_partner_id - 渠道二级商户号
     */
    public String getSubChannelPartnerId() {
        return subChannelPartnerId;
    }

    /**
     * 设置渠道二级商户号
     *
     * @param subChannelPartnerId 渠道二级商户号
     */
    public void setSubChannelPartnerId(String subChannelPartnerId) {
        this.subChannelPartnerId = subChannelPartnerId == null ? null : subChannelPartnerId.trim();
    }

    /**
     * 获取签名
     *
     * @return sign - 签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置签名
     *
     * @param sign 签名
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * 获取公钥
     *
     * @return public_key - 公钥
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * 设置公钥
     *
     * @param publicKey 公钥
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    /**
     * 获取系统公钥
     *
     * @return system_public_key - 系统公钥
     */
    public String getSystemPublicKey() {
        return systemPublicKey;
    }

    /**
     * 设置系统公钥
     *
     * @param systemPublicKey 系统公钥
     */
    public void setSystemPublicKey(String systemPublicKey) {
        this.systemPublicKey = systemPublicKey == null ? null : systemPublicKey.trim();
    }

    /**
     * 获取私钥
     *
     * @return private_key - 私钥
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * 设置私钥
     *
     * @param privateKey 私钥
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    /**
     * 获取异步通知地址
     *
     * @return notify_url - 异步通知地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置异步通知地址
     *
     * @param notifyUrl 异步通知地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * 获取支付成功跳转地址
     *
     * @return return_url - 支付成功跳转地址
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * 设置支付成功跳转地址
     *
     * @param returnUrl 支付成功跳转地址
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    /**
     * 获取商户渠道开关
     *
     * @return state - 商户渠道开关
     */
    public String getState() {
        return state;
    }

    /**
     * 设置商户渠道开关
     *
     * @param state 商户渠道开关
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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

    /**
     * 获取删除标示
     *
     * @return mark_delete - 删除标示
     */
    public String getMarkDelete() {
        return markDelete;
    }

    /**
     * 设置删除标示
     *
     * @param markDelete 删除标示
     */
    public void setMarkDelete(String markDelete) {
        this.markDelete = markDelete == null ? null : markDelete.trim();
    }

    /**
     * 获取证书
     *
     * @return cert - 证书
     */
    public String getCert() {
        return cert;
    }

    /**
     * 设置证书
     *
     * @param cert 证书
     */
    public void setCert(String cert) {
        this.cert = cert == null ? null : cert.trim();
    }

    /**
     * 获取支持的支付渠道
     *
     * @return available_pay_channel - 支持的支付渠道
     */
    public String getAvailablePayChannel() {
        return availablePayChannel;
    }

    /**
     * 设置支持的支付渠道
     *
     * @param availablePayChannel 支持的支付渠道
     */
    public void setAvailablePayChannel(String availablePayChannel) {
        this.availablePayChannel = availablePayChannel == null ? null : availablePayChannel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", channelMappingId=").append(channelMappingId);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", wechatAppid=").append(wechatAppid);
        sb.append(", alipayAppid=").append(alipayAppid);
        sb.append(", wechatAppAppid=").append(wechatAppAppid);
        sb.append(", alipayAppAppid=").append(alipayAppAppid);
        sb.append(", password=").append(password);
        sb.append(", channelPartnerId=").append(channelPartnerId);
        sb.append(", subChannelPartnerId=").append(subChannelPartnerId);
        sb.append(", sign=").append(sign);
        sb.append(", publicKey=").append(publicKey);
        sb.append(", systemPublicKey=").append(systemPublicKey);
        sb.append(", privateKey=").append(privateKey);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", returnUrl=").append(returnUrl);
        sb.append(", state=").append(state);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", markDelete=").append(markDelete);
        sb.append(", cert=").append(cert);
        sb.append(", availablePayChannel=").append(availablePayChannel);
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
        ChannelMappingDO other = (ChannelMappingDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChannelMappingId() == null ? other.getChannelMappingId() == null : this.getChannelMappingId().equals(other.getChannelMappingId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getWechatAppid() == null ? other.getWechatAppid() == null : this.getWechatAppid().equals(other.getWechatAppid()))
            && (this.getAlipayAppid() == null ? other.getAlipayAppid() == null : this.getAlipayAppid().equals(other.getAlipayAppid()))
            && (this.getWechatAppAppid() == null ? other.getWechatAppAppid() == null : this.getWechatAppAppid().equals(other.getWechatAppAppid()))
            && (this.getAlipayAppAppid() == null ? other.getAlipayAppAppid() == null : this.getAlipayAppAppid().equals(other.getAlipayAppAppid()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getChannelPartnerId() == null ? other.getChannelPartnerId() == null : this.getChannelPartnerId().equals(other.getChannelPartnerId()))
            && (this.getSubChannelPartnerId() == null ? other.getSubChannelPartnerId() == null : this.getSubChannelPartnerId().equals(other.getSubChannelPartnerId()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getPublicKey() == null ? other.getPublicKey() == null : this.getPublicKey().equals(other.getPublicKey()))
            && (this.getSystemPublicKey() == null ? other.getSystemPublicKey() == null : this.getSystemPublicKey().equals(other.getSystemPublicKey()))
            && (this.getPrivateKey() == null ? other.getPrivateKey() == null : this.getPrivateKey().equals(other.getPrivateKey()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getReturnUrl() == null ? other.getReturnUrl() == null : this.getReturnUrl().equals(other.getReturnUrl()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getMarkDelete() == null ? other.getMarkDelete() == null : this.getMarkDelete().equals(other.getMarkDelete()))
            && (this.getCert() == null ? other.getCert() == null : this.getCert().equals(other.getCert()))
            && (this.getAvailablePayChannel() == null ? other.getAvailablePayChannel() == null : this.getAvailablePayChannel().equals(other.getAvailablePayChannel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelMappingId() == null) ? 0 : getChannelMappingId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getWechatAppid() == null) ? 0 : getWechatAppid().hashCode());
        result = prime * result + ((getAlipayAppid() == null) ? 0 : getAlipayAppid().hashCode());
        result = prime * result + ((getWechatAppAppid() == null) ? 0 : getWechatAppAppid().hashCode());
        result = prime * result + ((getAlipayAppAppid() == null) ? 0 : getAlipayAppAppid().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getChannelPartnerId() == null) ? 0 : getChannelPartnerId().hashCode());
        result = prime * result + ((getSubChannelPartnerId() == null) ? 0 : getSubChannelPartnerId().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getPublicKey() == null) ? 0 : getPublicKey().hashCode());
        result = prime * result + ((getSystemPublicKey() == null) ? 0 : getSystemPublicKey().hashCode());
        result = prime * result + ((getPrivateKey() == null) ? 0 : getPrivateKey().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getReturnUrl() == null) ? 0 : getReturnUrl().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getMarkDelete() == null) ? 0 : getMarkDelete().hashCode());
        result = prime * result + ((getCert() == null) ? 0 : getCert().hashCode());
        result = prime * result + ((getAvailablePayChannel() == null) ? 0 : getAvailablePayChannel().hashCode());
        return result;
    }
}