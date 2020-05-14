package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wash_luck_draw_campaign")
public class WashLuckDrawCampaignDO implements Serializable {
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
     * 页面标题
     */
    private String title;

    /**
     * 活动描述
     */
    private String description;

    /**
     * 活动状态
     */
    private String status;

    /**
     * 抽奖类型
     */
    @Column(name = "luck_draw_type")
    private String luckDrawType;

    /**
     * 活动生命周期
     */
    @Column(name = "life_cycle")
    private String lifeCycle;

    /**
     * 活动链接
     */
    @Column(name = "campaign_url")
    private String campaignUrl;

    /**
     * 活动开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 活动结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

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
     * 获取页面标题
     *
     * @return title - 页面标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置页面标题
     *
     * @param title 页面标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取活动描述
     *
     * @return description - 活动描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置活动描述
     *
     * @param description 活动描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * 获取抽奖类型
     *
     * @return luck_draw_type - 抽奖类型
     */
    public String getLuckDrawType() {
        return luckDrawType;
    }

    /**
     * 设置抽奖类型
     *
     * @param luckDrawType 抽奖类型
     */
    public void setLuckDrawType(String luckDrawType) {
        this.luckDrawType = luckDrawType == null ? null : luckDrawType.trim();
    }

    /**
     * 获取活动生命周期
     *
     * @return life_cycle - 活动生命周期
     */
    public String getLifeCycle() {
        return lifeCycle;
    }

    /**
     * 设置活动生命周期
     *
     * @param lifeCycle 活动生命周期
     */
    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle == null ? null : lifeCycle.trim();
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
     * 获取活动开始时间
     *
     * @return start_time - 活动开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置活动开始时间
     *
     * @param startTime 活动开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取活动结束时间
     *
     * @return end_time - 活动结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置活动结束时间
     *
     * @param endTime 活动结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        sb.append(", name=").append(name);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", status=").append(status);
        sb.append(", luckDrawType=").append(luckDrawType);
        sb.append(", lifeCycle=").append(lifeCycle);
        sb.append(", campaignUrl=").append(campaignUrl);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
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
        WashLuckDrawCampaignDO other = (WashLuckDrawCampaignDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLuckDrawType() == null ? other.getLuckDrawType() == null : this.getLuckDrawType().equals(other.getLuckDrawType()))
            && (this.getLifeCycle() == null ? other.getLifeCycle() == null : this.getLifeCycle().equals(other.getLifeCycle()))
            && (this.getCampaignUrl() == null ? other.getCampaignUrl() == null : this.getCampaignUrl().equals(other.getCampaignUrl()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLuckDrawType() == null) ? 0 : getLuckDrawType().hashCode());
        result = prime * result + ((getLifeCycle() == null) ? 0 : getLifeCycle().hashCode());
        result = prime * result + ((getCampaignUrl() == null) ? 0 : getCampaignUrl().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}