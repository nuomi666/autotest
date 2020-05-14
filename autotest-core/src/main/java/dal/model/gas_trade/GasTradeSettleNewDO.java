package dal.model.gas_trade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_trade_settle_new")
public class GasTradeSettleNewDO implements Serializable {
    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 优惠id
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 活动名
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 优惠名称
     */
    @Column(name = "trade_pay_type")
    private String tradePayType;

    /**
     * 优惠类别 如活动优惠,优惠券优惠
     */
    @Column(name = "pay_model")
    private String payModel;

    /**
     * 优惠类型 如油品优惠,非油品优惠
     */
    @Column(name = "request_no")
    private String requestNo;

    /**
     * 优惠规则
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 优惠金额
     */
    private String status;

    /**
     * 优惠金111额
     */
    private String state;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    private static final long serialVersionUID = 1L;

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
     * @return trade_type - 优惠id
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * 设置优惠id
     *
     * @param tradeType 优惠id
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    /**
     * 获取活动名
     *
     * @return partner_id - 活动名
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置活动名
     *
     * @param partnerId 活动名
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取优惠名称
     *
     * @return trade_pay_type - 优惠名称
     */
    public String getTradePayType() {
        return tradePayType;
    }

    /**
     * 设置优惠名称
     *
     * @param tradePayType 优惠名称
     */
    public void setTradePayType(String tradePayType) {
        this.tradePayType = tradePayType == null ? null : tradePayType.trim();
    }

    /**
     * 获取优惠类别 如活动优惠,优惠券优惠
     *
     * @return pay_model - 优惠类别 如活动优惠,优惠券优惠
     */
    public String getPayModel() {
        return payModel;
    }

    /**
     * 设置优惠类别 如活动优惠,优惠券优惠
     *
     * @param payModel 优惠类别 如活动优惠,优惠券优惠
     */
    public void setPayModel(String payModel) {
        this.payModel = payModel == null ? null : payModel.trim();
    }

    /**
     * 获取优惠类型 如油品优惠,非油品优惠
     *
     * @return request_no - 优惠类型 如油品优惠,非油品优惠
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * 设置优惠类型 如油品优惠,非油品优惠
     *
     * @param requestNo 优惠类型 如油品优惠,非油品优惠
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    /**
     * 获取优惠规则
     *
     * @return pay_amount - 优惠规则
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置优惠规则
     *
     * @param payAmount 优惠规则
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取优惠金额
     *
     * @return status - 优惠金额
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置优惠金额
     *
     * @param status 优惠金额
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取优惠金111额
     *
     * @return state - 优惠金111额
     */
    public String getState() {
        return state;
    }

    /**
     * 设置优惠金111额
     *
     * @param state 优惠金111额
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", bizNo=").append(bizNo);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", tradePayType=").append(tradePayType);
        sb.append(", payModel=").append(payModel);
        sb.append(", requestNo=").append(requestNo);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", finishTime=").append(finishTime);
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
        GasTradeSettleNewDO other = (GasTradeSettleNewDO) that;
        return (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getTradePayType() == null ? other.getTradePayType() == null : this.getTradePayType().equals(other.getTradePayType()))
            && (this.getPayModel() == null ? other.getPayModel() == null : this.getPayModel().equals(other.getPayModel()))
            && (this.getRequestNo() == null ? other.getRequestNo() == null : this.getRequestNo().equals(other.getRequestNo()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getTradePayType() == null) ? 0 : getTradePayType().hashCode());
        result = prime * result + ((getPayModel() == null) ? 0 : getPayModel().hashCode());
        result = prime * result + ((getRequestNo() == null) ? 0 : getRequestNo().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        return result;
    }
}