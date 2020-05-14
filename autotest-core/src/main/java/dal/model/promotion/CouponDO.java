package dal.model.promotion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "coupon")
public class CouponDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coupon_id")
    private String couponId;

    @Column(name = "inner_name")
    private String innerName;

    private String name;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "instruction_id")
    private String instructionId;

    @Column(name = "definition_id")
    private String definitionId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "coupon_type")
    private String couponType;

    private String status;

    /**
     * 金额数据
     */
    @Column(name = "amount_data")
    private String amountData;

    /**
     * 折扣金额
     */
    @Column(name = "discount_amount")
    private Long discountAmount;

    /**
     * 最大优惠金额
     */
    @Column(name = "max_discount_amount")
    private Long maxDiscountAmount;

    /**
     * json
     */
    @Column(name = "definition_json")
    private String definitionJson;

    @Column(name = "taken_time")
    private Date takenTime;

    @Column(name = "applied_time")
    private Date appliedTime;

    @Column(name = "valid_start_time")
    private Date validStartTime;

    @Column(name = "valid_end_time")
    private Date validEndTime;

    /**
     * 可使用时间
     */
    @Column(name = "can_apply_time")
    private Date canApplyTime;

    /**
     * 过期通知时间
     */
    @Column(name = "expire_notify_time")
    private Date expireNotifyTime;

    /**
     * 来源产品
     */
    private String product;

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
     * @return coupon_id
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * @param couponId
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
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
     * @return instruction_id
     */
    public String getInstructionId() {
        return instructionId;
    }

    /**
     * @param instructionId
     */
    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId == null ? null : instructionId.trim();
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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 获取金额数据
     *
     * @return amount_data - 金额数据
     */
    public String getAmountData() {
        return amountData;
    }

    /**
     * 设置金额数据
     *
     * @param amountData 金额数据
     */
    public void setAmountData(String amountData) {
        this.amountData = amountData == null ? null : amountData.trim();
    }

    /**
     * 获取折扣金额
     *
     * @return discount_amount - 折扣金额
     */
    public Long getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 设置折扣金额
     *
     * @param discountAmount 折扣金额
     */
    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
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
     * 获取json
     *
     * @return definition_json - json
     */
    public String getDefinitionJson() {
        return definitionJson;
    }

    /**
     * 设置json
     *
     * @param definitionJson json
     */
    public void setDefinitionJson(String definitionJson) {
        this.definitionJson = definitionJson == null ? null : definitionJson.trim();
    }

    /**
     * @return taken_time
     */
    public Date getTakenTime() {
        return takenTime;
    }

    /**
     * @param takenTime
     */
    public void setTakenTime(Date takenTime) {
        this.takenTime = takenTime;
    }

    /**
     * @return applied_time
     */
    public Date getAppliedTime() {
        return appliedTime;
    }

    /**
     * @param appliedTime
     */
    public void setAppliedTime(Date appliedTime) {
        this.appliedTime = appliedTime;
    }

    /**
     * @return valid_start_time
     */
    public Date getValidStartTime() {
        return validStartTime;
    }

    /**
     * @param validStartTime
     */
    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    /**
     * @return valid_end_time
     */
    public Date getValidEndTime() {
        return validEndTime;
    }

    /**
     * @param validEndTime
     */
    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    /**
     * 获取可使用时间
     *
     * @return can_apply_time - 可使用时间
     */
    public Date getCanApplyTime() {
        return canApplyTime;
    }

    /**
     * 设置可使用时间
     *
     * @param canApplyTime 可使用时间
     */
    public void setCanApplyTime(Date canApplyTime) {
        this.canApplyTime = canApplyTime;
    }

    /**
     * 获取过期通知时间
     *
     * @return expire_notify_time - 过期通知时间
     */
    public Date getExpireNotifyTime() {
        return expireNotifyTime;
    }

    /**
     * 设置过期通知时间
     *
     * @param expireNotifyTime 过期通知时间
     */
    public void setExpireNotifyTime(Date expireNotifyTime) {
        this.expireNotifyTime = expireNotifyTime;
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
        sb.append(", couponId=").append(couponId);
        sb.append(", innerName=").append(innerName);
        sb.append(", name=").append(name);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", instructionId=").append(instructionId);
        sb.append(", definitionId=").append(definitionId);
        sb.append(", userId=").append(userId);
        sb.append(", couponType=").append(couponType);
        sb.append(", status=").append(status);
        sb.append(", amountData=").append(amountData);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", maxDiscountAmount=").append(maxDiscountAmount);
        sb.append(", definitionJson=").append(definitionJson);
        sb.append(", takenTime=").append(takenTime);
        sb.append(", appliedTime=").append(appliedTime);
        sb.append(", validStartTime=").append(validStartTime);
        sb.append(", validEndTime=").append(validEndTime);
        sb.append(", canApplyTime=").append(canApplyTime);
        sb.append(", expireNotifyTime=").append(expireNotifyTime);
        sb.append(", product=").append(product);
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
        CouponDO other = (CouponDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getInnerName() == null ? other.getInnerName() == null : this.getInnerName().equals(other.getInnerName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getInstructionId() == null ? other.getInstructionId() == null : this.getInstructionId().equals(other.getInstructionId()))
            && (this.getDefinitionId() == null ? other.getDefinitionId() == null : this.getDefinitionId().equals(other.getDefinitionId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCouponType() == null ? other.getCouponType() == null : this.getCouponType().equals(other.getCouponType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAmountData() == null ? other.getAmountData() == null : this.getAmountData().equals(other.getAmountData()))
            && (this.getDiscountAmount() == null ? other.getDiscountAmount() == null : this.getDiscountAmount().equals(other.getDiscountAmount()))
            && (this.getMaxDiscountAmount() == null ? other.getMaxDiscountAmount() == null : this.getMaxDiscountAmount().equals(other.getMaxDiscountAmount()))
            && (this.getDefinitionJson() == null ? other.getDefinitionJson() == null : this.getDefinitionJson().equals(other.getDefinitionJson()))
            && (this.getTakenTime() == null ? other.getTakenTime() == null : this.getTakenTime().equals(other.getTakenTime()))
            && (this.getAppliedTime() == null ? other.getAppliedTime() == null : this.getAppliedTime().equals(other.getAppliedTime()))
            && (this.getValidStartTime() == null ? other.getValidStartTime() == null : this.getValidStartTime().equals(other.getValidStartTime()))
            && (this.getValidEndTime() == null ? other.getValidEndTime() == null : this.getValidEndTime().equals(other.getValidEndTime()))
            && (this.getCanApplyTime() == null ? other.getCanApplyTime() == null : this.getCanApplyTime().equals(other.getCanApplyTime()))
            && (this.getExpireNotifyTime() == null ? other.getExpireNotifyTime() == null : this.getExpireNotifyTime().equals(other.getExpireNotifyTime()))
            && (this.getProduct() == null ? other.getProduct() == null : this.getProduct().equals(other.getProduct()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getInnerName() == null) ? 0 : getInnerName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getInstructionId() == null) ? 0 : getInstructionId().hashCode());
        result = prime * result + ((getDefinitionId() == null) ? 0 : getDefinitionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCouponType() == null) ? 0 : getCouponType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAmountData() == null) ? 0 : getAmountData().hashCode());
        result = prime * result + ((getDiscountAmount() == null) ? 0 : getDiscountAmount().hashCode());
        result = prime * result + ((getMaxDiscountAmount() == null) ? 0 : getMaxDiscountAmount().hashCode());
        result = prime * result + ((getDefinitionJson() == null) ? 0 : getDefinitionJson().hashCode());
        result = prime * result + ((getTakenTime() == null) ? 0 : getTakenTime().hashCode());
        result = prime * result + ((getAppliedTime() == null) ? 0 : getAppliedTime().hashCode());
        result = prime * result + ((getValidStartTime() == null) ? 0 : getValidStartTime().hashCode());
        result = prime * result + ((getValidEndTime() == null) ? 0 : getValidEndTime().hashCode());
        result = prime * result + ((getCanApplyTime() == null) ? 0 : getCanApplyTime().hashCode());
        result = prime * result + ((getExpireNotifyTime() == null) ? 0 : getExpireNotifyTime().hashCode());
        result = prime * result + ((getProduct() == null) ? 0 : getProduct().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}