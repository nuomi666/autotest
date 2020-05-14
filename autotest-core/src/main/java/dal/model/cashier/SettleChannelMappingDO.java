package dal.model.cashier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "settle_channel_mapping")
public class SettleChannelMappingDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户名称
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 清算渠道ID
     */
    @Column(name = "settle_channel_id")
    private String settleChannelId;

    /**
     * 清算渠道名称
     */
    @Column(name = "settle_channel_name")
    private String settleChannelName;

    /**
     * 渠道ID
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 渠道名称
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 费率（万分之）
     */
    private Integer rate;

    /**
     * 商户清算渠道开关
     */
    private String state;

    /**
     * 最高限额(分)
     */
    @Column(name = "max_ceiling")
    private Long maxCeiling;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 费率类型
     */
    @Column(name = "rate_type")
    private String rateType;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 删除标示
     */
    @Column(name = "mark_delete")
    private String markDelete;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取商户名称
     *
     * @return partner_name - 商户名称
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商户名称
     *
     * @param partnerName 商户名称
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取清算渠道ID
     *
     * @return settle_channel_id - 清算渠道ID
     */
    public String getSettleChannelId() {
        return settleChannelId;
    }

    /**
     * 设置清算渠道ID
     *
     * @param settleChannelId 清算渠道ID
     */
    public void setSettleChannelId(String settleChannelId) {
        this.settleChannelId = settleChannelId == null ? null : settleChannelId.trim();
    }

    /**
     * 获取清算渠道名称
     *
     * @return settle_channel_name - 清算渠道名称
     */
    public String getSettleChannelName() {
        return settleChannelName;
    }

    /**
     * 设置清算渠道名称
     *
     * @param settleChannelName 清算渠道名称
     */
    public void setSettleChannelName(String settleChannelName) {
        this.settleChannelName = settleChannelName == null ? null : settleChannelName.trim();
    }

    /**
     * 获取渠道ID
     *
     * @return channel_id - 渠道ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道ID
     *
     * @param channelId 渠道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取渠道名称
     *
     * @return channel_name - 渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置渠道名称
     *
     * @param channelName 渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 获取费率（万分之）
     *
     * @return rate - 费率（万分之）
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * 设置费率（万分之）
     *
     * @param rate 费率（万分之）
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**
     * 获取商户清算渠道开关
     *
     * @return state - 商户清算渠道开关
     */
    public String getState() {
        return state;
    }

    /**
     * 设置商户清算渠道开关
     *
     * @param state 商户清算渠道开关
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取最高限额(分)
     *
     * @return max_ceiling - 最高限额(分)
     */
    public Long getMaxCeiling() {
        return maxCeiling;
    }

    /**
     * 设置最高限额(分)
     *
     * @param maxCeiling 最高限额(分)
     */
    public void setMaxCeiling(Long maxCeiling) {
        this.maxCeiling = maxCeiling;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取费率类型
     *
     * @return rate_type - 费率类型
     */
    public String getRateType() {
        return rateType;
    }

    /**
     * 设置费率类型
     *
     * @param rateType 费率类型
     */
    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
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
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    /**
     * 获取删除标示
     *
     * @return mark_delete - 删除标示
     */
    public String getMarkDelete() {
        return markDelete;
    }

    /**
     * 设置删除标示
     *
     * @param markDelete 删除标示
     */
    public void setMarkDelete(String markDelete) {
        this.markDelete = markDelete == null ? null : markDelete.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", settleChannelId=").append(settleChannelId);
        sb.append(", settleChannelName=").append(settleChannelName);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", rate=").append(rate);
        sb.append(", state=").append(state);
        sb.append(", maxCeiling=").append(maxCeiling);
        sb.append(", priority=").append(priority);
        sb.append(", rateType=").append(rateType);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", markDelete=").append(markDelete);
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
        SettleChannelMappingDO other = (SettleChannelMappingDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getSettleChannelId() == null ? other.getSettleChannelId() == null : this.getSettleChannelId().equals(other.getSettleChannelId()))
            && (this.getSettleChannelName() == null ? other.getSettleChannelName() == null : this.getSettleChannelName().equals(other.getSettleChannelName()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getMaxCeiling() == null ? other.getMaxCeiling() == null : this.getMaxCeiling().equals(other.getMaxCeiling()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getRateType() == null ? other.getRateType() == null : this.getRateType().equals(other.getRateType()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getMarkDelete() == null ? other.getMarkDelete() == null : this.getMarkDelete().equals(other.getMarkDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getSettleChannelId() == null) ? 0 : getSettleChannelId().hashCode());
        result = prime * result + ((getSettleChannelName() == null) ? 0 : getSettleChannelName().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getMaxCeiling() == null) ? 0 : getMaxCeiling().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getRateType() == null) ? 0 : getRateType().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getMarkDelete() == null) ? 0 : getMarkDelete().hashCode());
        return result;
    }
}