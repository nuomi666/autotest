package dal.model.cashier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "settle_channel")
public class SettleChannelDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 清算渠道ID
     */
    @Column(name = "settle_channel_id")
    private String settleChannelId;

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
     * 支付渠道ID
     */
    @Column(name = "pay_channel_id")
    private String payChannelId;

    /**
     * 清算渠道名称
     */
    @Column(name = "settle_channel_name")
    private String settleChannelName;

    /**
     * 清算渠道开关
     */
    private String state;

    /**
     * 费率类型
     */
    @Column(name = "rate_type")
    private String rateType;

    /**
     * 费率（万分之）
     */
    private Integer rate;

    /**
     * 同步时延
     */
    @Column(name = "syn_time_delay")
    private Integer synTimeDelay;

    /**
     * 同步tps
     */
    @Column(name = "syn_tps")
    private Integer synTps;

    /**
     * 异步时延
     */
    @Column(name = "asyn_time_delay")
    private Integer asynTimeDelay;

    /**
     * 重试类型
     */
    @Column(name = "retry_type")
    private String retryType;

    /**
     * 扩展字段
     */
    @Column(name = "metaDatas")
    private String metadatas;

    /**
     * 最高限额(分)
     */
    @Column(name = "max_ceiling")
    private Long maxCeiling;

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
     * 获取支付渠道ID
     *
     * @return pay_channel_id - 支付渠道ID
     */
    public String getPayChannelId() {
        return payChannelId;
    }

    /**
     * 设置支付渠道ID
     *
     * @param payChannelId 支付渠道ID
     */
    public void setPayChannelId(String payChannelId) {
        this.payChannelId = payChannelId == null ? null : payChannelId.trim();
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
     * 获取清算渠道开关
     *
     * @return state - 清算渠道开关
     */
    public String getState() {
        return state;
    }

    /**
     * 设置清算渠道开关
     *
     * @param state 清算渠道开关
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
     * 获取同步时延
     *
     * @return syn_time_delay - 同步时延
     */
    public Integer getSynTimeDelay() {
        return synTimeDelay;
    }

    /**
     * 设置同步时延
     *
     * @param synTimeDelay 同步时延
     */
    public void setSynTimeDelay(Integer synTimeDelay) {
        this.synTimeDelay = synTimeDelay;
    }

    /**
     * 获取同步tps
     *
     * @return syn_tps - 同步tps
     */
    public Integer getSynTps() {
        return synTps;
    }

    /**
     * 设置同步tps
     *
     * @param synTps 同步tps
     */
    public void setSynTps(Integer synTps) {
        this.synTps = synTps;
    }

    /**
     * 获取异步时延
     *
     * @return asyn_time_delay - 异步时延
     */
    public Integer getAsynTimeDelay() {
        return asynTimeDelay;
    }

    /**
     * 设置异步时延
     *
     * @param asynTimeDelay 异步时延
     */
    public void setAsynTimeDelay(Integer asynTimeDelay) {
        this.asynTimeDelay = asynTimeDelay;
    }

    /**
     * 获取重试类型
     *
     * @return retry_type - 重试类型
     */
    public String getRetryType() {
        return retryType;
    }

    /**
     * 设置重试类型
     *
     * @param retryType 重试类型
     */
    public void setRetryType(String retryType) {
        this.retryType = retryType == null ? null : retryType.trim();
    }

    /**
     * 获取扩展字段
     *
     * @return metaDatas - 扩展字段
     */
    public String getMetadatas() {
        return metadatas;
    }

    /**
     * 设置扩展字段
     *
     * @param metadatas 扩展字段
     */
    public void setMetadatas(String metadatas) {
        this.metadatas = metadatas == null ? null : metadatas.trim();
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
        sb.append(", settleChannelId=").append(settleChannelId);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", payChannelId=").append(payChannelId);
        sb.append(", settleChannelName=").append(settleChannelName);
        sb.append(", state=").append(state);
        sb.append(", rateType=").append(rateType);
        sb.append(", rate=").append(rate);
        sb.append(", synTimeDelay=").append(synTimeDelay);
        sb.append(", synTps=").append(synTps);
        sb.append(", asynTimeDelay=").append(asynTimeDelay);
        sb.append(", retryType=").append(retryType);
        sb.append(", metadatas=").append(metadatas);
        sb.append(", maxCeiling=").append(maxCeiling);
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
        SettleChannelDO other = (SettleChannelDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSettleChannelId() == null ? other.getSettleChannelId() == null : this.getSettleChannelId().equals(other.getSettleChannelId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
            && (this.getPayChannelId() == null ? other.getPayChannelId() == null : this.getPayChannelId().equals(other.getPayChannelId()))
            && (this.getSettleChannelName() == null ? other.getSettleChannelName() == null : this.getSettleChannelName().equals(other.getSettleChannelName()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getRateType() == null ? other.getRateType() == null : this.getRateType().equals(other.getRateType()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getSynTimeDelay() == null ? other.getSynTimeDelay() == null : this.getSynTimeDelay().equals(other.getSynTimeDelay()))
            && (this.getSynTps() == null ? other.getSynTps() == null : this.getSynTps().equals(other.getSynTps()))
            && (this.getAsynTimeDelay() == null ? other.getAsynTimeDelay() == null : this.getAsynTimeDelay().equals(other.getAsynTimeDelay()))
            && (this.getRetryType() == null ? other.getRetryType() == null : this.getRetryType().equals(other.getRetryType()))
            && (this.getMetadatas() == null ? other.getMetadatas() == null : this.getMetadatas().equals(other.getMetadatas()))
            && (this.getMaxCeiling() == null ? other.getMaxCeiling() == null : this.getMaxCeiling().equals(other.getMaxCeiling()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getMarkDelete() == null ? other.getMarkDelete() == null : this.getMarkDelete().equals(other.getMarkDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSettleChannelId() == null) ? 0 : getSettleChannelId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getPayChannelId() == null) ? 0 : getPayChannelId().hashCode());
        result = prime * result + ((getSettleChannelName() == null) ? 0 : getSettleChannelName().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRateType() == null) ? 0 : getRateType().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getSynTimeDelay() == null) ? 0 : getSynTimeDelay().hashCode());
        result = prime * result + ((getSynTps() == null) ? 0 : getSynTps().hashCode());
        result = prime * result + ((getAsynTimeDelay() == null) ? 0 : getAsynTimeDelay().hashCode());
        result = prime * result + ((getRetryType() == null) ? 0 : getRetryType().hashCode());
        result = prime * result + ((getMetadatas() == null) ? 0 : getMetadatas().hashCode());
        result = prime * result + ((getMaxCeiling() == null) ? 0 : getMaxCeiling().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getMarkDelete() == null) ? 0 : getMarkDelete().hashCode());
        return result;
    }
}