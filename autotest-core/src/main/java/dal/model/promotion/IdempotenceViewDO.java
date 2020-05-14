package dal.model.promotion;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "idempotence_view")
public class IdempotenceViewDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "aggregate_identifier")
    private String aggregateIdentifier;

    private String gid;

    @Column(name = "req_id")
    private String reqId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return aggregate_identifier
     */
    public String getAggregateIdentifier() {
        return aggregateIdentifier;
    }

    /**
     * @param aggregateIdentifier
     */
    public void setAggregateIdentifier(String aggregateIdentifier) {
        this.aggregateIdentifier = aggregateIdentifier == null ? null : aggregateIdentifier.trim();
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
     * @return plat_partner_id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * @param platPartnerId
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
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
     * @return partner_id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * @param partnerId
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * @return merchant_order_no
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * @param merchantOrderNo
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", aggregateIdentifier=").append(aggregateIdentifier);
        sb.append(", gid=").append(gid);
        sb.append(", reqId=").append(reqId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
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
        IdempotenceViewDO other = (IdempotenceViewDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAggregateIdentifier() == null ? other.getAggregateIdentifier() == null : this.getAggregateIdentifier().equals(other.getAggregateIdentifier()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAggregateIdentifier() == null) ? 0 : getAggregateIdentifier().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        return result;
    }
}