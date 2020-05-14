package dal.model.yc_shell_trade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_trade_favour")
public class GasTradeFavourDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 优惠id
     */
    @Column(name = "favour_id")
    private String favourId;

    /**
     * 优惠定义ID
     */
    @Column(name = "favour_definition_id")
    private String favourDefinitionId;

    /**
     * 活动名
     */
    @Column(name = "campaign_name")
    private String campaignName;

    /**
     * 优惠名称
     */
    @Column(name = "favour_name")
    private String favourName;

    /**
     * 优惠类别 如活动优惠,优惠券优惠
     */
    @Column(name = "favour_category")
    private String favourCategory;

    /**
     * 优惠类型 如油品优惠,非油品优惠
     */
    @Column(name = "favour_type")
    private String favourType;

    /**
     * 优惠规则
     */
    @Column(name = "favour_rule")
    private String favourRule;

    /**
     * 优惠金额
     */
    @Column(name = "favour_amount")
    private Long favourAmount;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 完成时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序列
     *
     * @return id - 自增序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增序列
     *
     * @param id 自增序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取业务流水号
     *
     * @return biz_no - 业务流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务流水号
     *
     * @param bizNo 业务流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取优惠id
     *
     * @return favour_id - 优惠id
     */
    public String getFavourId() {
        return favourId;
    }

    /**
     * 设置优惠id
     *
     * @param favourId 优惠id
     */
    public void setFavourId(String favourId) {
        this.favourId = favourId == null ? null : favourId.trim();
    }

    /**
     * 获取优惠定义ID
     *
     * @return favour_definition_id - 优惠定义ID
     */
    public String getFavourDefinitionId() {
        return favourDefinitionId;
    }

    /**
     * 设置优惠定义ID
     *
     * @param favourDefinitionId 优惠定义ID
     */
    public void setFavourDefinitionId(String favourDefinitionId) {
        this.favourDefinitionId = favourDefinitionId == null ? null : favourDefinitionId.trim();
    }

    /**
     * 获取活动名
     *
     * @return campaign_name - 活动名
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * 设置活动名
     *
     * @param campaignName 活动名
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName == null ? null : campaignName.trim();
    }

    /**
     * 获取优惠名称
     *
     * @return favour_name - 优惠名称
     */
    public String getFavourName() {
        return favourName;
    }

    /**
     * 设置优惠名称
     *
     * @param favourName 优惠名称
     */
    public void setFavourName(String favourName) {
        this.favourName = favourName == null ? null : favourName.trim();
    }

    /**
     * 获取优惠类别 如活动优惠,优惠券优惠
     *
     * @return favour_category - 优惠类别 如活动优惠,优惠券优惠
     */
    public String getFavourCategory() {
        return favourCategory;
    }

    /**
     * 设置优惠类别 如活动优惠,优惠券优惠
     *
     * @param favourCategory 优惠类别 如活动优惠,优惠券优惠
     */
    public void setFavourCategory(String favourCategory) {
        this.favourCategory = favourCategory == null ? null : favourCategory.trim();
    }

    /**
     * 获取优惠类型 如油品优惠,非油品优惠
     *
     * @return favour_type - 优惠类型 如油品优惠,非油品优惠
     */
    public String getFavourType() {
        return favourType;
    }

    /**
     * 设置优惠类型 如油品优惠,非油品优惠
     *
     * @param favourType 优惠类型 如油品优惠,非油品优惠
     */
    public void setFavourType(String favourType) {
        this.favourType = favourType == null ? null : favourType.trim();
    }

    /**
     * 获取优惠规则
     *
     * @return favour_rule - 优惠规则
     */
    public String getFavourRule() {
        return favourRule;
    }

    /**
     * 设置优惠规则
     *
     * @param favourRule 优惠规则
     */
    public void setFavourRule(String favourRule) {
        this.favourRule = favourRule == null ? null : favourRule.trim();
    }

    /**
     * 获取优惠金额
     *
     * @return favour_amount - 优惠金额
     */
    public Long getFavourAmount() {
        return favourAmount;
    }

    /**
     * 设置优惠金额
     *
     * @param favourAmount 优惠金额
     */
    public void setFavourAmount(Long favourAmount) {
        this.favourAmount = favourAmount;
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
     * 获取完成时间
     *
     * @return raw_update_time - 完成时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置完成时间
     *
     * @param rawUpdateTime 完成时间
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
        sb.append(", bizNo=").append(bizNo);
        sb.append(", favourId=").append(favourId);
        sb.append(", favourDefinitionId=").append(favourDefinitionId);
        sb.append(", campaignName=").append(campaignName);
        sb.append(", favourName=").append(favourName);
        sb.append(", favourCategory=").append(favourCategory);
        sb.append(", favourType=").append(favourType);
        sb.append(", favourRule=").append(favourRule);
        sb.append(", favourAmount=").append(favourAmount);
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
        GasTradeFavourDO other = (GasTradeFavourDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getFavourId() == null ? other.getFavourId() == null : this.getFavourId().equals(other.getFavourId()))
            && (this.getFavourDefinitionId() == null ? other.getFavourDefinitionId() == null : this.getFavourDefinitionId().equals(other.getFavourDefinitionId()))
            && (this.getCampaignName() == null ? other.getCampaignName() == null : this.getCampaignName().equals(other.getCampaignName()))
            && (this.getFavourName() == null ? other.getFavourName() == null : this.getFavourName().equals(other.getFavourName()))
            && (this.getFavourCategory() == null ? other.getFavourCategory() == null : this.getFavourCategory().equals(other.getFavourCategory()))
            && (this.getFavourType() == null ? other.getFavourType() == null : this.getFavourType().equals(other.getFavourType()))
            && (this.getFavourRule() == null ? other.getFavourRule() == null : this.getFavourRule().equals(other.getFavourRule()))
            && (this.getFavourAmount() == null ? other.getFavourAmount() == null : this.getFavourAmount().equals(other.getFavourAmount()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getFavourId() == null) ? 0 : getFavourId().hashCode());
        result = prime * result + ((getFavourDefinitionId() == null) ? 0 : getFavourDefinitionId().hashCode());
        result = prime * result + ((getCampaignName() == null) ? 0 : getCampaignName().hashCode());
        result = prime * result + ((getFavourName() == null) ? 0 : getFavourName().hashCode());
        result = prime * result + ((getFavourCategory() == null) ? 0 : getFavourCategory().hashCode());
        result = prime * result + ((getFavourType() == null) ? 0 : getFavourType().hashCode());
        result = prime * result + ((getFavourRule() == null) ? 0 : getFavourRule().hashCode());
        result = prime * result + ((getFavourAmount() == null) ? 0 : getFavourAmount().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}