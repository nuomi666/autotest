package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "luck_draw_prize")
public class LuckDrawPrizeDO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 奖品名称
     */
    @Column(name = "prize_name")
    private String prizeName;

    /**
     * 活动编号
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 平台商id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 奖品类型
     */
    @Column(name = "prize_type")
    private String prizeType;

    /**
     * 库存次数
     */
    @Column(name = "stock_num")
    private Integer stockNum;

    /**
     * 使用库存
     */
    @Column(name = "use_num")
    private Integer useNum;

    /**
     * 抽奖概率
     */
    private String rate;

    /**
     * 奖品明细
     */
    @Column(name = "prize_detail")
    private String prizeDetail;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

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
     * 获取奖品名称
     *
     * @return prize_name - 奖品名称
     */
    public String getPrizeName() {
        return prizeName;
    }

    /**
     * 设置奖品名称
     *
     * @param prizeName 奖品名称
     */
    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
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
     * 获取平台商id
     *
     * @return plat_partner_id - 平台商id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商id
     *
     * @param platPartnerId 平台商id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
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
     * 获取奖品类型
     *
     * @return prize_type - 奖品类型
     */
    public String getPrizeType() {
        return prizeType;
    }

    /**
     * 设置奖品类型
     *
     * @param prizeType 奖品类型
     */
    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType == null ? null : prizeType.trim();
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
     * 获取使用库存
     *
     * @return use_num - 使用库存
     */
    public Integer getUseNum() {
        return useNum;
    }

    /**
     * 设置使用库存
     *
     * @param useNum 使用库存
     */
    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    /**
     * 获取抽奖概率
     *
     * @return rate - 抽奖概率
     */
    public String getRate() {
        return rate;
    }

    /**
     * 设置抽奖概率
     *
     * @param rate 抽奖概率
     */
    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    /**
     * 获取奖品明细
     *
     * @return prize_detail - 奖品明细
     */
    public String getPrizeDetail() {
        return prizeDetail;
    }

    /**
     * 设置奖品明细
     *
     * @param prizeDetail 奖品明细
     */
    public void setPrizeDetail(String prizeDetail) {
        this.prizeDetail = prizeDetail == null ? null : prizeDetail.trim();
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
        sb.append(", prizeName=").append(prizeName);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", prizeType=").append(prizeType);
        sb.append(", stockNum=").append(stockNum);
        sb.append(", useNum=").append(useNum);
        sb.append(", rate=").append(rate);
        sb.append(", prizeDetail=").append(prizeDetail);
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
        LuckDrawPrizeDO other = (LuckDrawPrizeDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPrizeType() == null ? other.getPrizeType() == null : this.getPrizeType().equals(other.getPrizeType()))
            && (this.getStockNum() == null ? other.getStockNum() == null : this.getStockNum().equals(other.getStockNum()))
            && (this.getUseNum() == null ? other.getUseNum() == null : this.getUseNum().equals(other.getUseNum()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getPrizeDetail() == null ? other.getPrizeDetail() == null : this.getPrizeDetail().equals(other.getPrizeDetail()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPrizeType() == null) ? 0 : getPrizeType().hashCode());
        result = prime * result + ((getStockNum() == null) ? 0 : getStockNum().hashCode());
        result = prime * result + ((getUseNum() == null) ? 0 : getUseNum().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getPrizeDetail() == null) ? 0 : getPrizeDetail().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}