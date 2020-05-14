package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_source_data")
public class GasMerchantSourceDataDO implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家编号
     */
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 来源
     */
    @Column(name = "source_type")
    private String sourceType;

    /**
     * 来源标识
     */
    @Column(name = "source_key")
    private String sourceKey;

    /**
     * 是否授权第三方
     */
    private Byte authorized;

    /**
     * 刷新令牌
     */
    @Column(name = "authorizer_refresh_token")
    private String authorizerRefreshToken;

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

    @Column(name = "authorizer_access_token")
    private String authorizerAccessToken;

    @Column(name = "authorizer_access_token_time")
    private Date authorizerAccessTokenTime;

    /**
     * 公众号信息
     */
    @Column(name = "source_info")
    private String sourceInfo;

    /**
     * 权限集
     */
    @Column(name = "func_info")
    private String funcInfo;

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
     * 获取商家编号
     *
     * @return partner_id - 商家编号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商家编号
     *
     * @param partnerId 商家编号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * @return plat_partner_id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * @param platPartnerId
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取来源
     *
     * @return source_type - 来源
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置来源
     *
     * @param sourceType 来源
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 获取来源标识
     *
     * @return source_key - 来源标识
     */
    public String getSourceKey() {
        return sourceKey;
    }

    /**
     * 设置来源标识
     *
     * @param sourceKey 来源标识
     */
    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey == null ? null : sourceKey.trim();
    }

    /**
     * 获取是否授权第三方
     *
     * @return authorized - 是否授权第三方
     */
    public Byte getAuthorized() {
        return authorized;
    }

    /**
     * 设置是否授权第三方
     *
     * @param authorized 是否授权第三方
     */
    public void setAuthorized(Byte authorized) {
        this.authorized = authorized;
    }

    /**
     * 获取刷新令牌
     *
     * @return authorizer_refresh_token - 刷新令牌
     */
    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    /**
     * 设置刷新令牌
     *
     * @param authorizerRefreshToken 刷新令牌
     */
    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken == null ? null : authorizerRefreshToken.trim();
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

    /**
     * @return authorizer_access_token
     */
    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    /**
     * @param authorizerAccessToken
     */
    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken == null ? null : authorizerAccessToken.trim();
    }

    /**
     * @return authorizer_access_token_time
     */
    public Date getAuthorizerAccessTokenTime() {
        return authorizerAccessTokenTime;
    }

    /**
     * @param authorizerAccessTokenTime
     */
    public void setAuthorizerAccessTokenTime(Date authorizerAccessTokenTime) {
        this.authorizerAccessTokenTime = authorizerAccessTokenTime;
    }

    /**
     * 获取公众号信息
     *
     * @return source_info - 公众号信息
     */
    public String getSourceInfo() {
        return sourceInfo;
    }

    /**
     * 设置公众号信息
     *
     * @param sourceInfo 公众号信息
     */
    public void setSourceInfo(String sourceInfo) {
        this.sourceInfo = sourceInfo == null ? null : sourceInfo.trim();
    }

    /**
     * 获取权限集
     *
     * @return func_info - 权限集
     */
    public String getFuncInfo() {
        return funcInfo;
    }

    /**
     * 设置权限集
     *
     * @param funcInfo 权限集
     */
    public void setFuncInfo(String funcInfo) {
        this.funcInfo = funcInfo == null ? null : funcInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", sourceKey=").append(sourceKey);
        sb.append(", authorized=").append(authorized);
        sb.append(", authorizerRefreshToken=").append(authorizerRefreshToken);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", authorizerAccessToken=").append(authorizerAccessToken);
        sb.append(", authorizerAccessTokenTime=").append(authorizerAccessTokenTime);
        sb.append(", sourceInfo=").append(sourceInfo);
        sb.append(", funcInfo=").append(funcInfo);
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
        GasMerchantSourceDataDO other = (GasMerchantSourceDataDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getSourceKey() == null ? other.getSourceKey() == null : this.getSourceKey().equals(other.getSourceKey()))
            && (this.getAuthorized() == null ? other.getAuthorized() == null : this.getAuthorized().equals(other.getAuthorized()))
            && (this.getAuthorizerRefreshToken() == null ? other.getAuthorizerRefreshToken() == null : this.getAuthorizerRefreshToken().equals(other.getAuthorizerRefreshToken()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getAuthorizerAccessToken() == null ? other.getAuthorizerAccessToken() == null : this.getAuthorizerAccessToken().equals(other.getAuthorizerAccessToken()))
            && (this.getAuthorizerAccessTokenTime() == null ? other.getAuthorizerAccessTokenTime() == null : this.getAuthorizerAccessTokenTime().equals(other.getAuthorizerAccessTokenTime()))
            && (this.getSourceInfo() == null ? other.getSourceInfo() == null : this.getSourceInfo().equals(other.getSourceInfo()))
            && (this.getFuncInfo() == null ? other.getFuncInfo() == null : this.getFuncInfo().equals(other.getFuncInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getSourceKey() == null) ? 0 : getSourceKey().hashCode());
        result = prime * result + ((getAuthorized() == null) ? 0 : getAuthorized().hashCode());
        result = prime * result + ((getAuthorizerRefreshToken() == null) ? 0 : getAuthorizerRefreshToken().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getAuthorizerAccessToken() == null) ? 0 : getAuthorizerAccessToken().hashCode());
        result = prime * result + ((getAuthorizerAccessTokenTime() == null) ? 0 : getAuthorizerAccessTokenTime().hashCode());
        result = prime * result + ((getSourceInfo() == null) ? 0 : getSourceInfo().hashCode());
        result = prime * result + ((getFuncInfo() == null) ? 0 : getFuncInfo().hashCode());
        return result;
    }
}