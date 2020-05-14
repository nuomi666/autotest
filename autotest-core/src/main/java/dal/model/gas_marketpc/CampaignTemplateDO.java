package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "campaign_template")
public class CampaignTemplateDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动模板名称
     */
    @Column(name = "template_name")
    private String templateName;

    /**
     * 模板方案类型
     */
    @Column(name = "template_type")
    private String templateType;

    /**
     * 活动模板编号
     */
    @Column(name = "template_no")
    private String templateNo;

    /**
     * 描述
     */
    private String description;

    /**
     * 活动图片
     */
    @Column(name = "cover_photo")
    private String coverPhoto;

    /**
     * 活动模板状态
     */
    private String status;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 活动规则
     */
    @Column(name = "campaign_template_rules")
    private String campaignTemplateRules;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取活动模板名称
     *
     * @return template_name - 活动模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置活动模板名称
     *
     * @param templateName 活动模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     * 获取模板方案类型
     *
     * @return template_type - 模板方案类型
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 设置模板方案类型
     *
     * @param templateType 模板方案类型
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }

    /**
     * 获取活动模板编号
     *
     * @return template_no - 活动模板编号
     */
    public String getTemplateNo() {
        return templateNo;
    }

    /**
     * 设置活动模板编号
     *
     * @param templateNo 活动模板编号
     */
    public void setTemplateNo(String templateNo) {
        this.templateNo = templateNo == null ? null : templateNo.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取活动图片
     *
     * @return cover_photo - 活动图片
     */
    public String getCoverPhoto() {
        return coverPhoto;
    }

    /**
     * 设置活动图片
     *
     * @param coverPhoto 活动图片
     */
    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto == null ? null : coverPhoto.trim();
    }

    /**
     * 获取活动模板状态
     *
     * @return status - 活动模板状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置活动模板状态
     *
     * @param status 活动模板状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 获取活动规则
     *
     * @return campaign_template_rules - 活动规则
     */
    public String getCampaignTemplateRules() {
        return campaignTemplateRules;
    }

    /**
     * 设置活动规则
     *
     * @param campaignTemplateRules 活动规则
     */
    public void setCampaignTemplateRules(String campaignTemplateRules) {
        this.campaignTemplateRules = campaignTemplateRules == null ? null : campaignTemplateRules.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", templateName=").append(templateName);
        sb.append(", templateType=").append(templateType);
        sb.append(", templateNo=").append(templateNo);
        sb.append(", description=").append(description);
        sb.append(", coverPhoto=").append(coverPhoto);
        sb.append(", status=").append(status);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", campaignTemplateRules=").append(campaignTemplateRules);
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
        CampaignTemplateDO other = (CampaignTemplateDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTemplateName() == null ? other.getTemplateName() == null : this.getTemplateName().equals(other.getTemplateName()))
            && (this.getTemplateType() == null ? other.getTemplateType() == null : this.getTemplateType().equals(other.getTemplateType()))
            && (this.getTemplateNo() == null ? other.getTemplateNo() == null : this.getTemplateNo().equals(other.getTemplateNo()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCoverPhoto() == null ? other.getCoverPhoto() == null : this.getCoverPhoto().equals(other.getCoverPhoto()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getCampaignTemplateRules() == null ? other.getCampaignTemplateRules() == null : this.getCampaignTemplateRules().equals(other.getCampaignTemplateRules()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTemplateName() == null) ? 0 : getTemplateName().hashCode());
        result = prime * result + ((getTemplateType() == null) ? 0 : getTemplateType().hashCode());
        result = prime * result + ((getTemplateNo() == null) ? 0 : getTemplateNo().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCoverPhoto() == null) ? 0 : getCoverPhoto().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getCampaignTemplateRules() == null) ? 0 : getCampaignTemplateRules().hashCode());
        return result;
    }
}