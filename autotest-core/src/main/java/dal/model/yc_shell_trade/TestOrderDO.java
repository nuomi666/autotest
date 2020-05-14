package dal.model.yc_shell_trade;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "test_order")
public class TestOrderDO implements Serializable {
    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "biz_no")
    private String bizNo;

    @Column(name = "pay_no")
    private String payNo;

    @Column(name = "pay_amount")
    private String payAmount;

    @Column(name = "clear_time")
    private String clearTime;

    @Column(name = "raw_add_time")
    private String rawAddTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return trade_type
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

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

    /**
     * @return pay_amount
     */
    public String getPayAmount() {
        return payAmount;
    }

    /**
     * @param payAmount
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount == null ? null : payAmount.trim();
    }

    /**
     * @return clear_time
     */
    public String getClearTime() {
        return clearTime;
    }

    /**
     * @param clearTime
     */
    public void setClearTime(String clearTime) {
        this.clearTime = clearTime == null ? null : clearTime.trim();
    }

    /**
     * @return raw_add_time
     */
    public String getRawAddTime() {
        return rawAddTime;
    }

    /**
     * @param rawAddTime
     */
    public void setRawAddTime(String rawAddTime) {
        this.rawAddTime = rawAddTime == null ? null : rawAddTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", tradeType=").append(tradeType);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", payNo=").append(payNo);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", clearTime=").append(clearTime);
        sb.append(", rawAddTime=").append(rawAddTime);
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
        TestOrderDO other = (TestOrderDO) that;
        return (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getClearTime() == null ? other.getClearTime() == null : this.getClearTime().equals(other.getClearTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getClearTime() == null) ? 0 : getClearTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        return result;
    }
}