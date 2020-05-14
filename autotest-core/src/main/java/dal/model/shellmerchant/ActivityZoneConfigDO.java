package dal.model.shellmerchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "activity_zone_config")
public class ActivityZoneConfigDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动专区名称
     */
    @Column(name = "activity_zone_name")
    private String activityZoneName;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 活动摘要
     */
    private String memo;

    /**
     * 活动图片
     */
    @Column(name = "activity_img_url")
    private String activityImgUrl;

    /**
     * 活动专区显示状态状态
     */
    @Column(name = "activity_show_state")
    private String activityShowState;

    /**
     * 内容链接
     */
    @Column(name = "activity_content_url")
    private String activityContentUrl;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

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
     * 获取活动专区名称
     *
     * @return activity_zone_name - 活动专区名称
     */
    public String getActivityZoneName() {
        return activityZoneName;
    }

    /**
     * 设置活动专区名称
     *
     * @param activityZoneName 活动专区名称
     */
    public void setActivityZoneName(String activityZoneName) {
        this.activityZoneName = activityZoneName == null ? null : activityZoneName.trim();
    }

    /**
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取活动摘要
     *
     * @return memo - 活动摘要
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置活动摘要
     *
     * @param memo 活动摘要
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取活动图片
     *
     * @return activity_img_url - 活动图片
     */
    public String getActivityImgUrl() {
        return activityImgUrl;
    }

    /**
     * 设置活动图片
     *
     * @param activityImgUrl 活动图片
     */
    public void setActivityImgUrl(String activityImgUrl) {
        this.activityImgUrl = activityImgUrl == null ? null : activityImgUrl.trim();
    }

    /**
     * 获取活动专区显示状态状态
     *
     * @return activity_show_state - 活动专区显示状态状态
     */
    public String getActivityShowState() {
        return activityShowState;
    }

    /**
     * 设置活动专区显示状态状态
     *
     * @param activityShowState 活动专区显示状态状态
     */
    public void setActivityShowState(String activityShowState) {
        this.activityShowState = activityShowState == null ? null : activityShowState.trim();
    }

    /**
     * 获取内容链接
     *
     * @return activity_content_url - 内容链接
     */
    public String getActivityContentUrl() {
        return activityContentUrl;
    }

    /**
     * 设置内容链接
     *
     * @param activityContentUrl 内容链接
     */
    public void setActivityContentUrl(String activityContentUrl) {
        this.activityContentUrl = activityContentUrl == null ? null : activityContentUrl.trim();
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
        sb.append(", activityZoneName=").append(activityZoneName);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", memo=").append(memo);
        sb.append(", activityImgUrl=").append(activityImgUrl);
        sb.append(", activityShowState=").append(activityShowState);
        sb.append(", activityContentUrl=").append(activityContentUrl);
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
        ActivityZoneConfigDO other = (ActivityZoneConfigDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityZoneName() == null ? other.getActivityZoneName() == null : this.getActivityZoneName().equals(other.getActivityZoneName()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getActivityImgUrl() == null ? other.getActivityImgUrl() == null : this.getActivityImgUrl().equals(other.getActivityImgUrl()))
            && (this.getActivityShowState() == null ? other.getActivityShowState() == null : this.getActivityShowState().equals(other.getActivityShowState()))
            && (this.getActivityContentUrl() == null ? other.getActivityContentUrl() == null : this.getActivityContentUrl().equals(other.getActivityContentUrl()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityZoneName() == null) ? 0 : getActivityZoneName().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getActivityImgUrl() == null) ? 0 : getActivityImgUrl().hashCode());
        result = prime * result + ((getActivityShowState() == null) ? 0 : getActivityShowState().hashCode());
        result = prime * result + ((getActivityContentUrl() == null) ? 0 : getActivityContentUrl().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}