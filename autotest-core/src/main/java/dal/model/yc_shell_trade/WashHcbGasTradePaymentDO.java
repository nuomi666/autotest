package dal.model.yc_shell_trade;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wash_hcb_gas_trade_payment")
public class WashHcbGasTradePaymentDO implements Serializable {
    @Column(name = "biz_no")
    private String bizNo;

    @Column(name = "req_id")
    private String reqId;

    private String gid;

    private Long amount;

    @Column(name = "pay_amount")
    private Long payAmount;

    @Column(name = "favour_amount")
    private Long favourAmount;

    @Column(name = "fee_amount")
    private Long feeAmount;

    @Column(name = "settlement_amount")
    private Long settlementAmount;

    @Column(name = "request_no")
    private String requestNo;

    @Column(name = "pay_no")
    private String payNo;

    private static final long serialVersionUID = 1L;

    /**
     * @return biz_no
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * @param bizNo
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * @return req_id
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * @param reqId
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * @return gid
     */
    public String getGid() {
        return gid;
    }

    /**
     * @param gid
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * @return amount
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return pay_amount
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * @param payAmount
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * @return favour_amount
     */
    public Long getFavourAmount() {
        return favourAmount;
    }

    /**
     * @param favourAmount
     */
    public void setFavourAmount(Long favourAmount) {
        this.favourAmount = favourAmount;
    }

    /**
     * @return fee_amount
     */
    public Long getFeeAmount() {
        return feeAmount;
    }

    /**
     * @param feeAmount
     */
    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    /**
     * @return settlement_amount
     */
    public Long getSettlementAmount() {
        return settlementAmount;
    }

    /**
     * @param settlementAmount
     */
    public void setSettlementAmount(Long settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    /**
     * @return request_no
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * @param requestNo
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    /**
     * @return pay_no
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * @param payNo
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", bizNo=").append(bizNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", amount=").append(amount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", favourAmount=").append(favourAmount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", settlementAmount=").append(settlementAmount);
        sb.append(", requestNo=").append(requestNo);
        sb.append(", payNo=").append(payNo);
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
        WashHcbGasTradePaymentDO other = (WashHcbGasTradePaymentDO) that;
        return (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getFavourAmount() == null ? other.getFavourAmount() == null : this.getFavourAmount().equals(other.getFavourAmount()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getSettlementAmount() == null ? other.getSettlementAmount() == null : this.getSettlementAmount().equals(other.getSettlementAmount()))
            && (this.getRequestNo() == null ? other.getRequestNo() == null : this.getRequestNo().equals(other.getRequestNo()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getFavourAmount() == null) ? 0 : getFavourAmount().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getSettlementAmount() == null) ? 0 : getSettlementAmount().hashCode());
        result = prime * result + ((getRequestNo() == null) ? 0 : getRequestNo().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        return result;
    }
}