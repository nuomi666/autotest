package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant")
public class GasMerchantDO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家id
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
    @Column(name = "short_name")
    private String shortName;

    /**
     * 手机号
     */
    @Column(name = "mobile_no")
    private String mobileNo;

    /**
     * 商家邮箱
     */
    private String email;

    /**
     * 清结算账户
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 营销账户
     */
    @Column(name = "market_account_no")
    private String marketAccountNo;

    /**
     * 商家状态
     */
    private String status;

    /**
     * 头像
     */
    @Column(name = "head_img_url")
    private String headImgUrl;

    /**
     * 查询深度
     */
    @Column(name = "query_depth")
    private Date queryDepth;

    /**
     * 收款模式
     */
    @Column(name = "collection_model")
    private String collectionModel;

    /**
     * 商户创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 商户更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 入库时间
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
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商家id
     *
     * @return partner_id - 商家id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商家id
     *
     * @param partnerId 商家id
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
     * @return short_name - 商户简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置商户简称
     *
     * @param shortName 商户简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
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
     * 获取商家邮箱
     *
     * @return email - 商家邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置商家邮箱
     *
     * @param email 商家邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取清结算账户
     *
     * @return account_no - 清结算账户
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置清结算账户
     *
     * @param accountNo 清结算账户
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取营销账户
     *
     * @return market_account_no - 营销账户
     */
    public String getMarketAccountNo() {
        return marketAccountNo;
    }

    /**
     * 设置营销账户
     *
     * @param marketAccountNo 营销账户
     */
    public void setMarketAccountNo(String marketAccountNo) {
        this.marketAccountNo = marketAccountNo == null ? null : marketAccountNo.trim();
    }

    /**
     * 获取商家状态
     *
     * @return status - 商家状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置商家状态
     *
     * @param status 商家状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取头像
     *
     * @return head_img_url - 头像
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 设置头像
     *
     * @param headImgUrl 头像
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    /**
     * 获取查询深度
     *
     * @return query_depth - 查询深度
     */
    public Date getQueryDepth() {
        return queryDepth;
    }

    /**
     * 设置查询深度
     *
     * @param queryDepth 查询深度
     */
    public void setQueryDepth(Date queryDepth) {
        this.queryDepth = queryDepth;
    }

    /**
     * 获取收款模式
     *
     * @return collection_model - 收款模式
     */
    public String getCollectionModel() {
        return collectionModel;
    }

    /**
     * 设置收款模式
     *
     * @param collectionModel 收款模式
     */
    public void setCollectionModel(String collectionModel) {
        this.collectionModel = collectionModel == null ? null : collectionModel.trim();
    }

    /**
     * 获取商户创建时间
     *
     * @return create_time - 商户创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置商户创建时间
     *
     * @param createTime 商户创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取商户更新时间
     *
     * @return update_time - 商户更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置商户更新时间
     *
     * @param updateTime 商户更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取入库时间
     *
     * @return raw_add_time - 入库时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置入库时间
     *
     * @param rawAddTime 入库时间
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", shortName=").append(shortName);
        sb.append(", mobileNo=").append(mobileNo);
        sb.append(", email=").append(email);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", marketAccountNo=").append(marketAccountNo);
        sb.append(", status=").append(status);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", queryDepth=").append(queryDepth);
        sb.append(", collectionModel=").append(collectionModel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        GasMerchantDO other = (GasMerchantDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getShortName() == null ? other.getShortName() == null : this.getShortName().equals(other.getShortName()))
            && (this.getMobileNo() == null ? other.getMobileNo() == null : this.getMobileNo().equals(other.getMobileNo()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getMarketAccountNo() == null ? other.getMarketAccountNo() == null : this.getMarketAccountNo().equals(other.getMarketAccountNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHeadImgUrl() == null ? other.getHeadImgUrl() == null : this.getHeadImgUrl().equals(other.getHeadImgUrl()))
            && (this.getQueryDepth() == null ? other.getQueryDepth() == null : this.getQueryDepth().equals(other.getQueryDepth()))
            && (this.getCollectionModel() == null ? other.getCollectionModel() == null : this.getCollectionModel().equals(other.getCollectionModel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getShortName() == null) ? 0 : getShortName().hashCode());
        result = prime * result + ((getMobileNo() == null) ? 0 : getMobileNo().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getMarketAccountNo() == null) ? 0 : getMarketAccountNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHeadImgUrl() == null) ? 0 : getHeadImgUrl().hashCode());
        result = prime * result + ((getQueryDepth() == null) ? 0 : getQueryDepth().hashCode());
        result = prime * result + ((getCollectionModel() == null) ? 0 : getCollectionModel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}