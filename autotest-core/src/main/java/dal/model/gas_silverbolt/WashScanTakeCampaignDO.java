package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wash_scan_take_campaign")
public class WashScanTakeCampaignDO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动编号
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 活动状态
     */
    private String status;

    /**
     * 每人限领次数
     */
    @Column(name = "one_take_num")
    private Integer oneTakeNum;

    /**
     * 库存次数
     */
    @Column(name = "stock_num")
    private Integer stockNum;

    /**
     * 赠送类型
     */
    @Column(name = "promotion_way")
    private String promotionWay;

    /**
     * 活动链接
     */
    @Column(name = "campaign_url")
    private String campaignUrl;

    /**
     * 生效开始时间
     */
    @Column(name = "valid_start_time")
    private Date validStartTime;

    /**
     * 生效结束时间
     */
    @Column(name = "valid_end_time")
    private Date validEndTime;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 赠送明细
     */
    @Column(name = "give_detail")
    private String giveDetail;

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
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取活动编号
     *
     * @return campaign_no - 活动编号
     */
    public String getCampaignNo() {
        return campaignNo;
    }

    /**
     * 设置活动编号
     *
     * @param campaignNo 活动编号
     */
    public void setCampaignNo(String campaignNo) {
        this.campaignNo = campaignNo == null ? null : campaignNo.trim();
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
     * 获取活动状态
     *
     * @return status - 活动状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置活动状态
     *
     * @param status 活动状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取每人限领次数
     *
     * @return one_take_num - 每人限领次数
     */
    public Integer getOneTakeNum() {
        return oneTakeNum;
    }

    /**
     * 设置每人限领次数
     *
     * @param oneTakeNum 每人限领次数
     */
    public void setOneTakeNum(Integer oneTakeNum) {
        this.oneTakeNum = oneTakeNum;
    }

    /**
     * 获取库存次数
     *
     * @return stock_num - 库存次数
     */
    public Integer getStockNum() {
        return stockNum;
    }

    /**
     * 设置库存次数
     *
     * @param stockNum 库存次数
     */
    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    /**
     * 获取赠送类型
     *
     * @return promotion_way - 赠送类型
     */
    public String getPromotionWay() {
        return promotionWay;
    }

    /**
     * 设置赠送类型
     *
     * @param promotionWay 赠送类型
     */
    public void setPromotionWay(String promotionWay) {
        this.promotionWay = promotionWay == null ? null : promotionWay.trim();
    }

    /**
     * 获取活动链接
     *
     * @return campaign_url - 活动链接
     */
    public String getCampaignUrl() {
        return campaignUrl;
    }

    /**
     * 设置活动链接
     *
     * @param campaignUrl 活动链接
     */
    public void setCampaignUrl(String campaignUrl) {
        this.campaignUrl = campaignUrl == null ? null : campaignUrl.trim();
    }

    /**
     * 获取生效开始时间
     *
     * @return valid_start_time - 生效开始时间
     */
    public Date getValidStartTime() {
        return validStartTime;
    }

    /**
     * 设置生效开始时间
     *
     * @param validStartTime 生效开始时间
     */
    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    /**
     * 获取生效结束时间
     *
     * @return valid_end_time - 生效结束时间
     */
    public Date getValidEndTime() {
        return validEndTime;
    }

    /**
     * 设置生效结束时间
     *
     * @param validEndTime 生效结束时间
     */
    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
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

    /**
     * 获取赠送明细
     *
     * @return give_detail - 赠送明细
     */
    public String getGiveDetail() {
        return giveDetail;
    }

    /**
     * 设置赠送明细
     *
     * @param giveDetail 赠送明细
     */
    public void setGiveDetail(String giveDetail) {
        this.giveDetail = giveDetail == null ? null : giveDetail.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", status=").append(status);
        sb.append(", oneTakeNum=").append(oneTakeNum);
        sb.append(", stockNum=").append(stockNum);
        sb.append(", promotionWay=").append(promotionWay);
        sb.append(", campaignUrl=").append(campaignUrl);
        sb.append(", validStartTime=").append(validStartTime);
        sb.append(", validEndTime=").append(validEndTime);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", giveDetail=").append(giveDetail);
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
        WashScanTakeCampaignDO other = (WashScanTakeCampaignDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOneTakeNum() == null ? other.getOneTakeNum() == null : this.getOneTakeNum().equals(other.getOneTakeNum()))
            && (this.getStockNum() == null ? other.getStockNum() == null : this.getStockNum().equals(other.getStockNum()))
            && (this.getPromotionWay() == null ? other.getPromotionWay() == null : this.getPromotionWay().equals(other.getPromotionWay()))
            && (this.getCampaignUrl() == null ? other.getCampaignUrl() == null : this.getCampaignUrl().equals(other.getCampaignUrl()))
            && (this.getValidStartTime() == null ? other.getValidStartTime() == null : this.getValidStartTime().equals(other.getValidStartTime()))
            && (this.getValidEndTime() == null ? other.getValidEndTime() == null : this.getValidEndTime().equals(other.getValidEndTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getGiveDetail() == null ? other.getGiveDetail() == null : this.getGiveDetail().equals(other.getGiveDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOneTakeNum() == null) ? 0 : getOneTakeNum().hashCode());
        result = prime * result + ((getStockNum() == null) ? 0 : getStockNum().hashCode());
        result = prime * result + ((getPromotionWay() == null) ? 0 : getPromotionWay().hashCode());
        result = prime * result + ((getCampaignUrl() == null) ? 0 : getCampaignUrl().hashCode());
        result = prime * result + ((getValidStartTime() == null) ? 0 : getValidStartTime().hashCode());
        result = prime * result + ((getValidEndTime() == null) ? 0 : getValidEndTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getGiveDetail() == null) ? 0 : getGiveDetail().hashCode());
        return result;
    }
}