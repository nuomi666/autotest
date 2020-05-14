package dal.model.shellmerchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_mall_exchange_goods")
public class GasMallExchangeGoodsDO implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商品类型
     */
    @Column(name = "goods_type")
    private String goodsType;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品描述
     */
    @Column(name = "goods_description")
    private String goodsDescription;

    /**
     * 商品图片
     */
    @Column(name = "goods_img")
    private String goodsImg;

    /**
     * 上架时间
     */
    @Column(name = "for_sale_time")
    private Date forSaleTime;

    /**
     * 下架时间
     */
    @Column(name = "invalid_time")
    private Date invalidTime;

    /**
     * 兑换积分
     */
    @Column(name = "exchange_point")
    private Integer exchangePoint;

    /**
     * 库存数据
     */
    @Column(name = "store_num")
    private Integer storeNum;

    /**
     * 冻结库存数据
     */
    @Column(name = "freeze_store_num")
    private Integer freezeStoreNum;

    /**
     * 每人兑换次数
     */
    @Column(name = "one_exchange_times")
    private Integer oneExchangeTimes;

    /**
     * 提取方式
     */
    @Column(name = "gain_style")
    private String gainStyle;

    /**
     * 提取油站
     */
    @Column(name = "gain_station")
    private String gainStation;

    /**
     * 已兑换数量
     */
    @Column(name = "exchanged_count")
    private Integer exchangedCount;

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
     * 获取商品ID
     *
     * @return goods_id - 商品ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品ID
     *
     * @param goodsId 商品ID
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
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
     * 获取商品描述
     *
     * @return goods_description - 商品描述
     */
    public String getGoodsDescription() {
        return goodsDescription;
    }

    /**
     * 设置商品描述
     *
     * @param goodsDescription 商品描述
     */
    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    /**
     * 获取商品图片
     *
     * @return goods_img - 商品图片
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 设置商品图片
     *
     * @param goodsImg 商品图片
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    /**
     * 获取上架时间
     *
     * @return for_sale_time - 上架时间
     */
    public Date getForSaleTime() {
        return forSaleTime;
    }

    /**
     * 设置上架时间
     *
     * @param forSaleTime 上架时间
     */
    public void setForSaleTime(Date forSaleTime) {
        this.forSaleTime = forSaleTime;
    }

    /**
     * 获取下架时间
     *
     * @return invalid_time - 下架时间
     */
    public Date getInvalidTime() {
        return invalidTime;
    }

    /**
     * 设置下架时间
     *
     * @param invalidTime 下架时间
     */
    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    /**
     * 获取兑换积分
     *
     * @return exchange_point - 兑换积分
     */
    public Integer getExchangePoint() {
        return exchangePoint;
    }

    /**
     * 设置兑换积分
     *
     * @param exchangePoint 兑换积分
     */
    public void setExchangePoint(Integer exchangePoint) {
        this.exchangePoint = exchangePoint;
    }

    /**
     * 获取库存数据
     *
     * @return store_num - 库存数据
     */
    public Integer getStoreNum() {
        return storeNum;
    }

    /**
     * 设置库存数据
     *
     * @param storeNum 库存数据
     */
    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    /**
     * 获取冻结库存数据
     *
     * @return freeze_store_num - 冻结库存数据
     */
    public Integer getFreezeStoreNum() {
        return freezeStoreNum;
    }

    /**
     * 设置冻结库存数据
     *
     * @param freezeStoreNum 冻结库存数据
     */
    public void setFreezeStoreNum(Integer freezeStoreNum) {
        this.freezeStoreNum = freezeStoreNum;
    }

    /**
     * 获取每人兑换次数
     *
     * @return one_exchange_times - 每人兑换次数
     */
    public Integer getOneExchangeTimes() {
        return oneExchangeTimes;
    }

    /**
     * 设置每人兑换次数
     *
     * @param oneExchangeTimes 每人兑换次数
     */
    public void setOneExchangeTimes(Integer oneExchangeTimes) {
        this.oneExchangeTimes = oneExchangeTimes;
    }

    /**
     * 获取提取方式
     *
     * @return gain_style - 提取方式
     */
    public String getGainStyle() {
        return gainStyle;
    }

    /**
     * 设置提取方式
     *
     * @param gainStyle 提取方式
     */
    public void setGainStyle(String gainStyle) {
        this.gainStyle = gainStyle == null ? null : gainStyle.trim();
    }

    /**
     * 获取提取油站
     *
     * @return gain_station - 提取油站
     */
    public String getGainStation() {
        return gainStation;
    }

    /**
     * 设置提取油站
     *
     * @param gainStation 提取油站
     */
    public void setGainStation(String gainStation) {
        this.gainStation = gainStation == null ? null : gainStation.trim();
    }

    /**
     * 获取已兑换数量
     *
     * @return exchanged_count - 已兑换数量
     */
    public Integer getExchangedCount() {
        return exchangedCount;
    }

    /**
     * 设置已兑换数量
     *
     * @param exchangedCount 已兑换数量
     */
    public void setExchangedCount(Integer exchangedCount) {
        this.exchangedCount = exchangedCount;
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
        sb.append(", goodsId=").append(goodsId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsDescription=").append(goodsDescription);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", forSaleTime=").append(forSaleTime);
        sb.append(", invalidTime=").append(invalidTime);
        sb.append(", exchangePoint=").append(exchangePoint);
        sb.append(", storeNum=").append(storeNum);
        sb.append(", freezeStoreNum=").append(freezeStoreNum);
        sb.append(", oneExchangeTimes=").append(oneExchangeTimes);
        sb.append(", gainStyle=").append(gainStyle);
        sb.append(", gainStation=").append(gainStation);
        sb.append(", exchangedCount=").append(exchangedCount);
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
        GasMallExchangeGoodsDO other = (GasMallExchangeGoodsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsDescription() == null ? other.getGoodsDescription() == null : this.getGoodsDescription().equals(other.getGoodsDescription()))
            && (this.getGoodsImg() == null ? other.getGoodsImg() == null : this.getGoodsImg().equals(other.getGoodsImg()))
            && (this.getForSaleTime() == null ? other.getForSaleTime() == null : this.getForSaleTime().equals(other.getForSaleTime()))
            && (this.getInvalidTime() == null ? other.getInvalidTime() == null : this.getInvalidTime().equals(other.getInvalidTime()))
            && (this.getExchangePoint() == null ? other.getExchangePoint() == null : this.getExchangePoint().equals(other.getExchangePoint()))
            && (this.getStoreNum() == null ? other.getStoreNum() == null : this.getStoreNum().equals(other.getStoreNum()))
            && (this.getFreezeStoreNum() == null ? other.getFreezeStoreNum() == null : this.getFreezeStoreNum().equals(other.getFreezeStoreNum()))
            && (this.getOneExchangeTimes() == null ? other.getOneExchangeTimes() == null : this.getOneExchangeTimes().equals(other.getOneExchangeTimes()))
            && (this.getGainStyle() == null ? other.getGainStyle() == null : this.getGainStyle().equals(other.getGainStyle()))
            && (this.getGainStation() == null ? other.getGainStation() == null : this.getGainStation().equals(other.getGainStation()))
            && (this.getExchangedCount() == null ? other.getExchangedCount() == null : this.getExchangedCount().equals(other.getExchangedCount()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsDescription() == null) ? 0 : getGoodsDescription().hashCode());
        result = prime * result + ((getGoodsImg() == null) ? 0 : getGoodsImg().hashCode());
        result = prime * result + ((getForSaleTime() == null) ? 0 : getForSaleTime().hashCode());
        result = prime * result + ((getInvalidTime() == null) ? 0 : getInvalidTime().hashCode());
        result = prime * result + ((getExchangePoint() == null) ? 0 : getExchangePoint().hashCode());
        result = prime * result + ((getStoreNum() == null) ? 0 : getStoreNum().hashCode());
        result = prime * result + ((getFreezeStoreNum() == null) ? 0 : getFreezeStoreNum().hashCode());
        result = prime * result + ((getOneExchangeTimes() == null) ? 0 : getOneExchangeTimes().hashCode());
        result = prime * result + ((getGainStyle() == null) ? 0 : getGainStyle().hashCode());
        result = prime * result + ((getGainStation() == null) ? 0 : getGainStation().hashCode());
        result = prime * result + ((getExchangedCount() == null) ? 0 : getExchangedCount().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}