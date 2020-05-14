package dal.model.yc_shell_trade;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "test_order_silver")
public class TestOrderSilverDO implements Serializable {
    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "biz_no")
    private String bizNo;

    @Column(name = "pay_no")
    private String payNo;

    @Column(name = "pay_amount")
    private String payAmount;

    private String days;

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
     * @return days
     */
    public String getDays() {
        return days;
    }

    /**
     * @param days
     */
    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
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
        sb.append(", days=").append(days);
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
        TestOrderSilverDO other = (TestOrderSilverDO) that;
        return (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        return result;
    }
}