package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_goods")
public class GasMerchantGoodsDO implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品编码
     */
    @Column(name = "goods_code")
    private String goodsCode;

    /**
     * 商品类型
     */
    @Column(name = "goods_type")
    private String goodsType;

    @Column(name = "goods_group_type")
    private String goodsGroupType;

    /**
     * 商品组别ID
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 增值税率
     */
    @Column(name = "tax_goods_rate")
    private Double taxGoodsRate;

    /**
     * 增值税类别编码
     */
    @Column(name = "tax_goods_code")
    private String taxGoodsCode;

    /**
     * 货物/劳务名称
     */
    @Column(name = "tax_goods_name")
    private String taxGoodsName;

    /**
     * 商户序号
     */
    @Column(name = "order_no")
    private Integer orderNo;

    /**
     * 商品状态
     */
    private String status;

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
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取商品编码
     *
     * @return goods_code - 商品编码
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * 设置商品编码
     *
     * @param goodsCode 商品编码
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    /**
     * 获取商品类型
     *
     * @return goods_type - 商品类型
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * 设置商品类型
     *
     * @param goodsType 商品类型
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    /**
     * @return goods_group_type
     */
    public String getGoodsGroupType() {
        return goodsGroupType;
    }

    /**
     * @param goodsGroupType
     */
    public void setGoodsGroupType(String goodsGroupType) {
        this.goodsGroupType = goodsGroupType == null ? null : goodsGroupType.trim();
    }

    /**
     * 获取商品组别ID
     *
     * @return group_id - 商品组别ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置商品组别ID
     *
     * @param groupId 商品组别ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取增值税率
     *
     * @return tax_goods_rate - 增值税率
     */
    public Double getTaxGoodsRate() {
        return taxGoodsRate;
    }

    /**
     * 设置增值税率
     *
     * @param taxGoodsRate 增值税率
     */
    public void setTaxGoodsRate(Double taxGoodsRate) {
        this.taxGoodsRate = taxGoodsRate;
    }

    /**
     * 获取增值税类别编码
     *
     * @return tax_goods_code - 增值税类别编码
     */
    public String getTaxGoodsCode() {
        return taxGoodsCode;
    }

    /**
     * 设置增值税类别编码
     *
     * @param taxGoodsCode 增值税类别编码
     */
    public void setTaxGoodsCode(String taxGoodsCode) {
        this.taxGoodsCode = taxGoodsCode == null ? null : taxGoodsCode.trim();
    }

    /**
     * 获取货物/劳务名称
     *
     * @return tax_goods_name - 货物/劳务名称
     */
    public String getTaxGoodsName() {
        return taxGoodsName;
    }

    /**
     * 设置货物/劳务名称
     *
     * @param taxGoodsName 货物/劳务名称
     */
    public void setTaxGoodsName(String taxGoodsName) {
        this.taxGoodsName = taxGoodsName == null ? null : taxGoodsName.trim();
    }

    /**
     * 获取商户序号
     *
     * @return order_no - 商户序号
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 设置商户序号
     *
     * @param orderNo 商户序号
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取商品状态
     *
     * @return status - 商品状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置商品状态
     *
     * @param status 商品状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsCode=").append(goodsCode);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", goodsGroupType=").append(goodsGroupType);
        sb.append(", groupId=").append(groupId);
        sb.append(", taxGoodsRate=").append(taxGoodsRate);
        sb.append(", taxGoodsCode=").append(taxGoodsCode);
        sb.append(", taxGoodsName=").append(taxGoodsName);
        sb.append(", orderNo=").append(orderNo);
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
        GasMerchantGoodsDO other = (GasMerchantGoodsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsCode() == null ? other.getGoodsCode() == null : this.getGoodsCode().equals(other.getGoodsCode()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()))
            && (this.getGoodsGroupType() == null ? other.getGoodsGroupType() == null : this.getGoodsGroupType().equals(other.getGoodsGroupType()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getTaxGoodsRate() == null ? other.getTaxGoodsRate() == null : this.getTaxGoodsRate().equals(other.getTaxGoodsRate()))
            && (this.getTaxGoodsCode() == null ? other.getTaxGoodsCode() == null : this.getTaxGoodsCode().equals(other.getTaxGoodsCode()))
            && (this.getTaxGoodsName() == null ? other.getTaxGoodsName() == null : this.getTaxGoodsName().equals(other.getTaxGoodsName()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
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
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsCode() == null) ? 0 : getGoodsCode().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        result = prime * result + ((getGoodsGroupType() == null) ? 0 : getGoodsGroupType().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getTaxGoodsRate() == null) ? 0 : getTaxGoodsRate().hashCode());
        result = prime * result + ((getTaxGoodsCode() == null) ? 0 : getTaxGoodsCode().hashCode());
        result = prime * result + ((getTaxGoodsName() == null) ? 0 : getTaxGoodsName().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}