package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_payway_dict")
public class GasPaywayDictDO implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 支付方式类型
     */
    @Column(name = "payway_type")
    private String paywayType;

    /**
     * 支付方式编码
     */
    @Column(name = "payway_code")
    private String paywayCode;

    /**
     * 支付方式名称
     */
    @Column(name = "payway_name")
    private String paywayName;

    /**
     * 支付方式图标
     */
    @Column(name = "payway_icon")
    private String paywayIcon;

    /**
     * 支付方式小图标
     */
    @Column(name = "payway_small_icon")
    private String paywaySmallIcon;

    /**
     * 渠道配置编码
     */
    @Column(name = "channel_code")
    private String channelCode;

    /**
     * 渠道调用方法
     */
    @Column(name = "channel_function")
    private String channelFunction;

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
     * 获取支付方式类型
     *
     * @return payway_type - 支付方式类型
     */
    public String getPaywayType() {
        return paywayType;
    }

    /**
     * 设置支付方式类型
     *
     * @param paywayType 支付方式类型
     */
    public void setPaywayType(String paywayType) {
        this.paywayType = paywayType == null ? null : paywayType.trim();
    }

    /**
     * 获取支付方式编码
     *
     * @return payway_code - 支付方式编码
     */
    public String getPaywayCode() {
        return paywayCode;
    }

    /**
     * 设置支付方式编码
     *
     * @param paywayCode 支付方式编码
     */
    public void setPaywayCode(String paywayCode) {
        this.paywayCode = paywayCode == null ? null : paywayCode.trim();
    }

    /**
     * 获取支付方式名称
     *
     * @return payway_name - 支付方式名称
     */
    public String getPaywayName() {
        return paywayName;
    }

    /**
     * 设置支付方式名称
     *
     * @param paywayName 支付方式名称
     */
    public void setPaywayName(String paywayName) {
        this.paywayName = paywayName == null ? null : paywayName.trim();
    }

    /**
     * 获取支付方式图标
     *
     * @return payway_icon - 支付方式图标
     */
    public String getPaywayIcon() {
        return paywayIcon;
    }

    /**
     * 设置支付方式图标
     *
     * @param paywayIcon 支付方式图标
     */
    public void setPaywayIcon(String paywayIcon) {
        this.paywayIcon = paywayIcon == null ? null : paywayIcon.trim();
    }

    /**
     * 获取支付方式小图标
     *
     * @return payway_small_icon - 支付方式小图标
     */
    public String getPaywaySmallIcon() {
        return paywaySmallIcon;
    }

    /**
     * 设置支付方式小图标
     *
     * @param paywaySmallIcon 支付方式小图标
     */
    public void setPaywaySmallIcon(String paywaySmallIcon) {
        this.paywaySmallIcon = paywaySmallIcon == null ? null : paywaySmallIcon.trim();
    }

    /**
     * 获取渠道配置编码
     *
     * @return channel_code - 渠道配置编码
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 设置渠道配置编码
     *
     * @param channelCode 渠道配置编码
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * 获取渠道调用方法
     *
     * @return channel_function - 渠道调用方法
     */
    public String getChannelFunction() {
        return channelFunction;
    }

    /**
     * 设置渠道调用方法
     *
     * @param channelFunction 渠道调用方法
     */
    public void setChannelFunction(String channelFunction) {
        this.channelFunction = channelFunction == null ? null : channelFunction.trim();
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
        sb.append(", paywayType=").append(paywayType);
        sb.append(", paywayCode=").append(paywayCode);
        sb.append(", paywayName=").append(paywayName);
        sb.append(", paywayIcon=").append(paywayIcon);
        sb.append(", paywaySmallIcon=").append(paywaySmallIcon);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", channelFunction=").append(channelFunction);
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
        GasPaywayDictDO other = (GasPaywayDictDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPaywayType() == null ? other.getPaywayType() == null : this.getPaywayType().equals(other.getPaywayType()))
            && (this.getPaywayCode() == null ? other.getPaywayCode() == null : this.getPaywayCode().equals(other.getPaywayCode()))
            && (this.getPaywayName() == null ? other.getPaywayName() == null : this.getPaywayName().equals(other.getPaywayName()))
            && (this.getPaywayIcon() == null ? other.getPaywayIcon() == null : this.getPaywayIcon().equals(other.getPaywayIcon()))
            && (this.getPaywaySmallIcon() == null ? other.getPaywaySmallIcon() == null : this.getPaywaySmallIcon().equals(other.getPaywaySmallIcon()))
            && (this.getChannelCode() == null ? other.getChannelCode() == null : this.getChannelCode().equals(other.getChannelCode()))
            && (this.getChannelFunction() == null ? other.getChannelFunction() == null : this.getChannelFunction().equals(other.getChannelFunction()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPaywayType() == null) ? 0 : getPaywayType().hashCode());
        result = prime * result + ((getPaywayCode() == null) ? 0 : getPaywayCode().hashCode());
        result = prime * result + ((getPaywayName() == null) ? 0 : getPaywayName().hashCode());
        result = prime * result + ((getPaywayIcon() == null) ? 0 : getPaywayIcon().hashCode());
        result = prime * result + ((getPaywaySmallIcon() == null) ? 0 : getPaywaySmallIcon().hashCode());
        result = prime * result + ((getChannelCode() == null) ? 0 : getChannelCode().hashCode());
        result = prime * result + ((getChannelFunction() == null) ? 0 : getChannelFunction().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}