package dal.model.yc_shell_trade;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "test_bill")
public class TestBillDO implements Serializable {
    @Column(name = "bill_date")
    private String billDate;

    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    @Column(name = "merchant_trade_no")
    private String merchantTradeNo;

    @Column(name = "merchant_refund_no")
    private String merchantRefundNo;

    @Column(name = "merchant_amount")
    private String merchantAmount;

    private static final long serialVersionUID = 1L;

    /**
     * @return bill_date
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * @param billDate
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    /**
     * @return plat_merchant_order_no
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * @param platMerchantOrderNo
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
    }

    /**
     * @return merchant_trade_no
     */
    public String getMerchantTradeNo() {
        return merchantTradeNo;
    }

    /**
     * @param merchantTradeNo
     */
    public void setMerchantTradeNo(String merchantTradeNo) {
        this.merchantTradeNo = merchantTradeNo == null ? null : merchantTradeNo.trim();
    }

    /**
     * @return merchant_refund_no
     */
    public String getMerchantRefundNo() {
        return merchantRefundNo;
    }

    /**
     * @param merchantRefundNo
     */
    public void setMerchantRefundNo(String merchantRefundNo) {
        this.merchantRefundNo = merchantRefundNo == null ? null : merchantRefundNo.trim();
    }

    /**
     * @return merchant_amount
     */
    public String getMerchantAmount() {
        return merchantAmount;
    }

    /**
     * @param merchantAmount
     */
    public void setMerchantAmount(String merchantAmount) {
        this.merchantAmount = merchantAmount == null ? null : merchantAmount.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", billDate=").append(billDate);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantTradeNo=").append(merchantTradeNo);
        sb.append(", merchantRefundNo=").append(merchantRefundNo);
        sb.append(", merchantAmount=").append(merchantAmount);
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
        TestBillDO other = (TestBillDO) that;
        return (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantTradeNo() == null ? other.getMerchantTradeNo() == null : this.getMerchantTradeNo().equals(other.getMerchantTradeNo()))
            && (this.getMerchantRefundNo() == null ? other.getMerchantRefundNo() == null : this.getMerchantRefundNo().equals(other.getMerchantRefundNo()))
            && (this.getMerchantAmount() == null ? other.getMerchantAmount() == null : this.getMerchantAmount().equals(other.getMerchantAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantTradeNo() == null) ? 0 : getMerchantTradeNo().hashCode());
        result = prime * result + ((getMerchantRefundNo() == null) ? 0 : getMerchantRefundNo().hashCode());
        result = prime * result + ((getMerchantAmount() == null) ? 0 : getMerchantAmount().hashCode());
        return result;
    }
}