package dal.model.clear;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_channel_statistics")
public class ClearChannelStatisticsDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 订单金额，分
     */
    @Column(name = "order_amount")
    private Long orderAmount;

    /**
     * 结算金额，分
     */
    @Column(name = "clear_amount")
    private Long clearAmount;

    /**
     * 商户手续费，分
     */
    @Column(name = "partner_fee_amount")
    private Long partnerFeeAmount;

    /**
     * 渠道手续费金额，单位元
     */
    @Column(name = "fee_amount")
    private BigDecimal feeAmount;

    /**
     * 开始账期yyyyMMdd
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * 结算账期yyyyMMdd
     */
    @Column(name = "end_date")
    private String endDate;

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
     * 获取渠道id
     *
     * @return channel_id - 渠道id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道id
     *
     * @param channelId 渠道id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取订单金额，分
     *
     * @return order_amount - 订单金额，分
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单金额，分
     *
     * @param orderAmount 订单金额，分
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取结算金额，分
     *
     * @return clear_amount - 结算金额，分
     */
    public Long getClearAmount() {
        return clearAmount;
    }

    /**
     * 设置结算金额，分
     *
     * @param clearAmount 结算金额，分
     */
    public void setClearAmount(Long clearAmount) {
        this.clearAmount = clearAmount;
    }

    /**
     * 获取商户手续费，分
     *
     * @return partner_fee_amount - 商户手续费，分
     */
    public Long getPartnerFeeAmount() {
        return partnerFeeAmount;
    }

    /**
     * 设置商户手续费，分
     *
     * @param partnerFeeAmount 商户手续费，分
     */
    public void setPartnerFeeAmount(Long partnerFeeAmount) {
        this.partnerFeeAmount = partnerFeeAmount;
    }

    /**
     * 获取渠道手续费金额，单位元
     *
     * @return fee_amount - 渠道手续费金额，单位元
     */
    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    /**
     * 设置渠道手续费金额，单位元
     *
     * @param feeAmount 渠道手续费金额，单位元
     */
    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    /**
     * 获取开始账期yyyyMMdd
     *
     * @return start_date - 开始账期yyyyMMdd
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置开始账期yyyyMMdd
     *
     * @param startDate 开始账期yyyyMMdd
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * 获取结算账期yyyyMMdd
     *
     * @return end_date - 结算账期yyyyMMdd
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置结算账期yyyyMMdd
     *
     * @param endDate 结算账期yyyyMMdd
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
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
        sb.append(", channelId=").append(channelId);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", clearAmount=").append(clearAmount);
        sb.append(", partnerFeeAmount=").append(partnerFeeAmount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
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
        ClearChannelStatisticsDO other = (ClearChannelStatisticsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getClearAmount() == null ? other.getClearAmount() == null : this.getClearAmount().equals(other.getClearAmount()))
            && (this.getPartnerFeeAmount() == null ? other.getPartnerFeeAmount() == null : this.getPartnerFeeAmount().equals(other.getPartnerFeeAmount()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getClearAmount() == null) ? 0 : getClearAmount().hashCode());
        result = prime * result + ((getPartnerFeeAmount() == null) ? 0 : getPartnerFeeAmount().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}