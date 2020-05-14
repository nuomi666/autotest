package dal.model.promotion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "coupon_definition")
public class CouponDefinitionDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "definition_id")
    private String definitionId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "definition_status")
    private String definitionStatus;

    @Column(name = "inner_name")
    private String innerName;

    private String name;

    @Column(name = "coupon_type")
    private String couponType;

    /**
     * 券总数
     */
    private Long quantity;

    @Column(name = "take_count")
    private Integer takeCount;

    @Column(name = "apply_count")
    private Integer applyCount;

    /**
     * 最大优惠金额
     */
    @Column(name = "max_discount_amount")
    private Long maxDiscountAmount;

    private Boolean overlay;

    /**
     * 过期通知天数
     */
    @Column(name = "expire_notify_days")
    private Integer expireNotifyDays;

    /**
     * 来源产品
     */
    private String product;

    @Column(name = "definition_json")
    private String definitionJson;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private String memo;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return definition_id
     */
    public String getDefinitionId() {
        return definitionId;
    }

    /**
     * @param definitionId
     */
    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId == null ? null : definitionId.trim();
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
     * @return partner_id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * @param partnerId
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * @return definition_status
     */
    public String getDefinitionStatus() {
        return definitionStatus;
    }

    /**
     * @param definitionStatus
     */
    public void setDefinitionStatus(String definitionStatus) {
        this.definitionStatus = definitionStatus == null ? null : definitionStatus.trim();
    }

    /**
     * @return inner_name
     */
    public String getInnerName() {
        return innerName;
    }

    /**
     * @param innerName
     */
    public void setInnerName(String innerName) {
        this.innerName = innerName == null ? null : innerName.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return coupon_type
     */
    public String getCouponType() {
        return couponType;
    }

    /**
     * @param couponType
     */
    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    /**
     * 获取券总数
     *
     * @return quantity - 券总数
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * 设置券总数
     *
     * @param quantity 券总数
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * @return take_count
     */
    public Integer getTakeCount() {
        return takeCount;
    }

    /**
     * @param takeCount
     */
    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    /**
     * @return apply_count
     */
    public Integer getApplyCount() {
        return applyCount;
    }

    /**
     * @param applyCount
     */
    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    /**
     * 获取最大优惠金额
     *
     * @return max_discount_amount - 最大优惠金额
     */
    public Long getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    /**
     * 设置最大优惠金额
     *
     * @param maxDiscountAmount 最大优惠金额
     */
    public void setMaxDiscountAmount(Long maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    /**
     * @return overlay
     */
    public Boolean getOverlay() {
        return overlay;
    }

    /**
     * @param overlay
     */
    public void setOverlay(Boolean overlay) {
        this.overlay = overlay;
    }

    /**
     * 获取过期通知天数
     *
     * @return expire_notify_days - 过期通知天数
     */
    public Integer getExpireNotifyDays() {
        return expireNotifyDays;
    }

    /**
     * 设置过期通知天数
     *
     * @param expireNotifyDays 过期通知天数
     */
    public void setExpireNotifyDays(Integer expireNotifyDays) {
        this.expireNotifyDays = expireNotifyDays;
    }

    /**
     * 获取来源产品
     *
     * @return product - 来源产品
     */
    public String getProduct() {
        return product;
    }

    /**
     * 设置来源产品
     *
     * @param product 来源产品
     */
    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    /**
     * @return definition_json
     */
    public String getDefinitionJson() {
        return definitionJson;
    }

    /**
     * @param definitionJson
     */
    public void setDefinitionJson(String definitionJson) {
        this.definitionJson = definitionJson == null ? null : definitionJson.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        sb.append(", definitionId=").append(definitionId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", definitionStatus=").append(definitionStatus);
        sb.append(", innerName=").append(innerName);
        sb.append(", name=").append(name);
        sb.append(", couponType=").append(couponType);
        sb.append(", quantity=").append(quantity);
        sb.append(", takeCount=").append(takeCount);
        sb.append(", applyCount=").append(applyCount);
        sb.append(", maxDiscountAmount=").append(maxDiscountAmount);
        sb.append(", overlay=").append(overlay);
        sb.append(", expireNotifyDays=").append(expireNotifyDays);
        sb.append(", product=").append(product);
        sb.append(", definitionJson=").append(definitionJson);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", memo=").append(memo);
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
        CouponDefinitionDO other = (CouponDefinitionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDefinitionId() == null ? other.getDefinitionId() == null : this.getDefinitionId().equals(other.getDefinitionId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getDefinitionStatus() == null ? other.getDefinitionStatus() == null : this.getDefinitionStatus().equals(other.getDefinitionStatus()))
            && (this.getInnerName() == null ? other.getInnerName() == null : this.getInnerName().equals(other.getInnerName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCouponType() == null ? other.getCouponType() == null : this.getCouponType().equals(other.getCouponType()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getTakeCount() == null ? other.getTakeCount() == null : this.getTakeCount().equals(other.getTakeCount()))
            && (this.getApplyCount() == null ? other.getApplyCount() == null : this.getApplyCount().equals(other.getApplyCount()))
            && (this.getMaxDiscountAmount() == null ? other.getMaxDiscountAmount() == null : this.getMaxDiscountAmount().equals(other.getMaxDiscountAmount()))
            && (this.getOverlay() == null ? other.getOverlay() == null : this.getOverlay().equals(other.getOverlay()))
            && (this.getExpireNotifyDays() == null ? other.getExpireNotifyDays() == null : this.getExpireNotifyDays().equals(other.getExpireNotifyDays()))
            && (this.getProduct() == null ? other.getProduct() == null : this.getProduct().equals(other.getProduct()))
            && (this.getDefinitionJson() == null ? other.getDefinitionJson() == null : this.getDefinitionJson().equals(other.getDefinitionJson()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDefinitionId() == null) ? 0 : getDefinitionId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getDefinitionStatus() == null) ? 0 : getDefinitionStatus().hashCode());
        result = prime * result + ((getInnerName() == null) ? 0 : getInnerName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCouponType() == null) ? 0 : getCouponType().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getTakeCount() == null) ? 0 : getTakeCount().hashCode());
        result = prime * result + ((getApplyCount() == null) ? 0 : getApplyCount().hashCode());
        result = prime * result + ((getMaxDiscountAmount() == null) ? 0 : getMaxDiscountAmount().hashCode());
        result = prime * result + ((getOverlay() == null) ? 0 : getOverlay().hashCode());
        result = prime * result + ((getExpireNotifyDays() == null) ? 0 : getExpireNotifyDays().hashCode());
        result = prime * result + ((getProduct() == null) ? 0 : getProduct().hashCode());
        result = prime * result + ((getDefinitionJson() == null) ? 0 : getDefinitionJson().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}