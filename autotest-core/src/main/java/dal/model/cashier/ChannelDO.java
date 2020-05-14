package dal.model.cashier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "channel")
public class ChannelDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 渠道配置
     */
    @Column(name = "channel_config")
    private String channelConfig;

    /**
     * 渠道状态
     */
    private String state;

    /**
     * 渠道类型
     */
    @Column(name = "channel_type")
    private String channelType;

    /**
     * 商户手续费类型
     */
    @Column(name = "merchant_rate_type")
    private String merchantRateType;

    /**
     * 商户手续费计算规则
     */
    @Column(name = "merchant_rate_rule")
    private String merchantRateRule;

    /**
     * 商户手续费保留位数(小数位数)
     */
    @Column(name = "merchant_rate_decimal")
    private Integer merchantRateDecimal;

    /**
     * 渠道手续费类型
     */
    @Column(name = "channel_rate_type")
    private String channelRateType;

    /**
     * 渠道手续费计算规则
     */
    @Column(name = "channel_rate_rule")
    private String channelRateRule;

    /**
     * 渠道手续费保留位数(小数位数)
     */
    @Column(name = "channel_rate_decimal")
    private Integer channelRateDecimal;

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
     * 获取渠道配置
     *
     * @return channel_config - 渠道配置
     */
    public String getChannelConfig() {
        return channelConfig;
    }

    /**
     * 设置渠道配置
     *
     * @param channelConfig 渠道配置
     */
    public void setChannelConfig(String channelConfig) {
        this.channelConfig = channelConfig == null ? null : channelConfig.trim();
    }

    /**
     * 获取渠道状态
     *
     * @return state - 渠道状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置渠道状态
     *
     * @param state 渠道状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取渠道类型
     *
     * @return channel_type - 渠道类型
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * 设置渠道类型
     *
     * @param channelType 渠道类型
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    /**
     * 获取商户手续费类型
     *
     * @return merchant_rate_type - 商户手续费类型
     */
    public String getMerchantRateType() {
        return merchantRateType;
    }

    /**
     * 设置商户手续费类型
     *
     * @param merchantRateType 商户手续费类型
     */
    public void setMerchantRateType(String merchantRateType) {
        this.merchantRateType = merchantRateType == null ? null : merchantRateType.trim();
    }

    /**
     * 获取商户手续费计算规则
     *
     * @return merchant_rate_rule - 商户手续费计算规则
     */
    public String getMerchantRateRule() {
        return merchantRateRule;
    }

    /**
     * 设置商户手续费计算规则
     *
     * @param merchantRateRule 商户手续费计算规则
     */
    public void setMerchantRateRule(String merchantRateRule) {
        this.merchantRateRule = merchantRateRule == null ? null : merchantRateRule.trim();
    }

    /**
     * 获取商户手续费保留位数(小数位数)
     *
     * @return merchant_rate_decimal - 商户手续费保留位数(小数位数)
     */
    public Integer getMerchantRateDecimal() {
        return merchantRateDecimal;
    }

    /**
     * 设置商户手续费保留位数(小数位数)
     *
     * @param merchantRateDecimal 商户手续费保留位数(小数位数)
     */
    public void setMerchantRateDecimal(Integer merchantRateDecimal) {
        this.merchantRateDecimal = merchantRateDecimal;
    }

    /**
     * 获取渠道手续费类型
     *
     * @return channel_rate_type - 渠道手续费类型
     */
    public String getChannelRateType() {
        return channelRateType;
    }

    /**
     * 设置渠道手续费类型
     *
     * @param channelRateType 渠道手续费类型
     */
    public void setChannelRateType(String channelRateType) {
        this.channelRateType = channelRateType == null ? null : channelRateType.trim();
    }

    /**
     * 获取渠道手续费计算规则
     *
     * @return channel_rate_rule - 渠道手续费计算规则
     */
    public String getChannelRateRule() {
        return channelRateRule;
    }

    /**
     * 设置渠道手续费计算规则
     *
     * @param channelRateRule 渠道手续费计算规则
     */
    public void setChannelRateRule(String channelRateRule) {
        this.channelRateRule = channelRateRule == null ? null : channelRateRule.trim();
    }

    /**
     * 获取渠道手续费保留位数(小数位数)
     *
     * @return channel_rate_decimal - 渠道手续费保留位数(小数位数)
     */
    public Integer getChannelRateDecimal() {
        return channelRateDecimal;
    }

    /**
     * 设置渠道手续费保留位数(小数位数)
     *
     * @param channelRateDecimal 渠道手续费保留位数(小数位数)
     */
    public void setChannelRateDecimal(Integer channelRateDecimal) {
        this.channelRateDecimal = channelRateDecimal;
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
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", channelConfig=").append(channelConfig);
        sb.append(", state=").append(state);
        sb.append(", channelType=").append(channelType);
        sb.append(", merchantRateType=").append(merchantRateType);
        sb.append(", merchantRateRule=").append(merchantRateRule);
        sb.append(", merchantRateDecimal=").append(merchantRateDecimal);
        sb.append(", channelRateType=").append(channelRateType);
        sb.append(", channelRateRule=").append(channelRateRule);
        sb.append(", channelRateDecimal=").append(channelRateDecimal);
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
        ChannelDO other = (ChannelDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
            && (this.getChannelConfig() == null ? other.getChannelConfig() == null : this.getChannelConfig().equals(other.getChannelConfig()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getChannelType() == null ? other.getChannelType() == null : this.getChannelType().equals(other.getChannelType()))
            && (this.getMerchantRateType() == null ? other.getMerchantRateType() == null : this.getMerchantRateType().equals(other.getMerchantRateType()))
            && (this.getMerchantRateRule() == null ? other.getMerchantRateRule() == null : this.getMerchantRateRule().equals(other.getMerchantRateRule()))
            && (this.getMerchantRateDecimal() == null ? other.getMerchantRateDecimal() == null : this.getMerchantRateDecimal().equals(other.getMerchantRateDecimal()))
            && (this.getChannelRateType() == null ? other.getChannelRateType() == null : this.getChannelRateType().equals(other.getChannelRateType()))
            && (this.getChannelRateRule() == null ? other.getChannelRateRule() == null : this.getChannelRateRule().equals(other.getChannelRateRule()))
            && (this.getChannelRateDecimal() == null ? other.getChannelRateDecimal() == null : this.getChannelRateDecimal().equals(other.getChannelRateDecimal()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getMarkDelete() == null ? other.getMarkDelete() == null : this.getMarkDelete().equals(other.getMarkDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getChannelConfig() == null) ? 0 : getChannelConfig().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getChannelType() == null) ? 0 : getChannelType().hashCode());
        result = prime * result + ((getMerchantRateType() == null) ? 0 : getMerchantRateType().hashCode());
        result = prime * result + ((getMerchantRateRule() == null) ? 0 : getMerchantRateRule().hashCode());
        result = prime * result + ((getMerchantRateDecimal() == null) ? 0 : getMerchantRateDecimal().hashCode());
        result = prime * result + ((getChannelRateType() == null) ? 0 : getChannelRateType().hashCode());
        result = prime * result + ((getChannelRateRule() == null) ? 0 : getChannelRateRule().hashCode());
        result = prime * result + ((getChannelRateDecimal() == null) ? 0 : getChannelRateDecimal().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getMarkDelete() == null) ? 0 : getMarkDelete().hashCode());
        return result;
    }
}