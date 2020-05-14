package dal.model.cashier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_channel")
public class PayChannelDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 支付渠道ID
     */
    @Column(name = "pay_channel_id")
    private String payChannelId;

    /**
     * 支付方式
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 状态
     */
    private String state;

    /**
     * 支付渠道
     */
    @Column(name = "pay_channel")
    private String payChannel;

    /**
     * 支付渠道类型PayChannelTypeEnum
     */
    @Column(name = "pay_channel_type")
    private String payChannelType;

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
     * 获取支付方式
     *
     * @return pay_type - 支付方式
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付方式
     *
     * @param payType 支付方式
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取支付渠道
     *
     * @return pay_channel - 支付渠道
     */
    public String getPayChannel() {
        return payChannel;
    }

    /**
     * 设置支付渠道
     *
     * @param payChannel 支付渠道
     */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    /**
     * 获取支付渠道类型PayChannelTypeEnum
     *
     * @return pay_channel_type - 支付渠道类型PayChannelTypeEnum
     */
    public String getPayChannelType() {
        return payChannelType;
    }

    /**
     * 设置支付渠道类型PayChannelTypeEnum
     *
     * @param payChannelType 支付渠道类型PayChannelTypeEnum
     */
    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType == null ? null : payChannelType.trim();
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
        sb.append(", payChannelId=").append(payChannelId);
        sb.append(", payType=").append(payType);
        sb.append(", state=").append(state);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", payChannelType=").append(payChannelType);
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
        PayChannelDO other = (PayChannelDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPayChannelId() == null ? other.getPayChannelId() == null : this.getPayChannelId().equals(other.getPayChannelId()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getPayChannelType() == null ? other.getPayChannelType() == null : this.getPayChannelType().equals(other.getPayChannelType()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getMarkDelete() == null ? other.getMarkDelete() == null : this.getMarkDelete().equals(other.getMarkDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPayChannelId() == null) ? 0 : getPayChannelId().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getPayChannelType() == null) ? 0 : getPayChannelType().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getMarkDelete() == null) ? 0 : getMarkDelete().hashCode());
        return result;
    }
}