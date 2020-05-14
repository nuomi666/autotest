package dal.model.shellmerchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_goods_price_plan")
public class GasMerchantGoodsPricePlanDO implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 计划ID
     */
    @Column(name = "plan_id")
    private String planId;

    /**
     * 价格名称
     */
    @Column(name = "price_name")
    private String priceName;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 生效时间
     */
    @Column(name = "effect_time")
    private Date effectTime;

    /**
     * 删除标识(Y: 正常, N: 删除)
     */
    @Column(name = "delete_flag")
    private String deleteFlag;

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

    /**
     * 商品名称
     */
    @Column(name = "goods_info")
    private String goodsInfo;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取计划ID
     *
     * @return plan_id - 计划ID
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * 设置计划ID
     *
     * @param planId 计划ID
     */
    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    /**
     * 获取价格名称
     *
     * @return price_name - 价格名称
     */
    public String getPriceName() {
        return priceName;
    }

    /**
     * 设置价格名称
     *
     * @param priceName 价格名称
     */
    public void setPriceName(String priceName) {
        this.priceName = priceName == null ? null : priceName.trim();
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
     * 获取生效时间
     *
     * @return effect_time - 生效时间
     */
    public Date getEffectTime() {
        return effectTime;
    }

    /**
     * 设置生效时间
     *
     * @param effectTime 生效时间
     */
    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    /**
     * 获取删除标识(Y: 正常, N: 删除)
     *
     * @return delete_flag - 删除标识(Y: 正常, N: 删除)
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标识(Y: 正常, N: 删除)
     *
     * @param deleteFlag 删除标识(Y: 正常, N: 删除)
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
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
     * 获取商品名称
     *
     * @return goods_info - 商品名称
     */
    public String getGoodsInfo() {
        return goodsInfo;
    }

    /**
     * 设置商品名称
     *
     * @param goodsInfo 商品名称
     */
    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo == null ? null : goodsInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", planId=").append(planId);
        sb.append(", priceName=").append(priceName);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", effectTime=").append(effectTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", goodsInfo=").append(goodsInfo);
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
        GasMerchantGoodsPricePlanDO other = (GasMerchantGoodsPricePlanDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getPriceName() == null ? other.getPriceName() == null : this.getPriceName().equals(other.getPriceName()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getEffectTime() == null ? other.getEffectTime() == null : this.getEffectTime().equals(other.getEffectTime()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getGoodsInfo() == null ? other.getGoodsInfo() == null : this.getGoodsInfo().equals(other.getGoodsInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getPriceName() == null) ? 0 : getPriceName().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getEffectTime() == null) ? 0 : getEffectTime().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getGoodsInfo() == null) ? 0 : getGoodsInfo().hashCode());
        return result;
    }
}