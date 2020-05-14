package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "profit_refund")
public class ProfitRefundDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 退款单号（返回参数）
     */
    @Column(name = "refund_no")
    private String refundNo;

    /**
     * 对应分润单号
     */
    @Column(name = "profit_order_no")
    private String profitOrderNo;

    /**
     * 交易单号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 执行状态
     */
    private String state;

    /**
     * 签约商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 签约外部商户号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 平台商户ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 平台外部商户号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 请求号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 回话号
     */
    private String gid;

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
     * 获取退款单号（返回参数）
     *
     * @return refund_no - 退款单号（返回参数）
     */
    public String getRefundNo() {
        return refundNo;
    }

    /**
     * 设置退款单号（返回参数）
     *
     * @param refundNo 退款单号（返回参数）
     */
    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo == null ? null : refundNo.trim();
    }

    /**
     * 获取对应分润单号
     *
     * @return profit_order_no - 对应分润单号
     */
    public String getProfitOrderNo() {
        return profitOrderNo;
    }

    /**
     * 设置对应分润单号
     *
     * @param profitOrderNo 对应分润单号
     */
    public void setProfitOrderNo(String profitOrderNo) {
        this.profitOrderNo = profitOrderNo == null ? null : profitOrderNo.trim();
    }

    /**
     * 获取交易单号
     *
     * @return trade_no - 交易单号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易单号
     *
     * @param tradeNo 交易单号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取执行状态
     *
     * @return state - 执行状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置执行状态
     *
     * @param state 执行状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取签约商户ID
     *
     * @return partner_id - 签约商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户ID
     *
     * @param partnerId 签约商户ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取签约外部商户号
     *
     * @return merchant_order_no - 签约外部商户号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置签约外部商户号
     *
     * @param merchantOrderNo 签约外部商户号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /**
     * 获取平台商户ID
     *
     * @return plat_partner_id - 平台商户ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户ID
     *
     * @param platPartnerId 平台商户ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取平台外部商户号
     *
     * @return plat_merchant_order_no - 平台外部商户号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台外部商户号
     *
     * @param platMerchantOrderNo 平台外部商户号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
    }

    /**
     * 获取请求号
     *
     * @return req_id - 请求号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求号
     *
     * @param reqId 请求号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取回话号
     *
     * @return gid - 回话号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置回话号
     *
     * @param gid 回话号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
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
        sb.append(", refundNo=").append(refundNo);
        sb.append(", profitOrderNo=").append(profitOrderNo);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", state=").append(state);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
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
        ProfitRefundDO other = (ProfitRefundDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRefundNo() == null ? other.getRefundNo() == null : this.getRefundNo().equals(other.getRefundNo()))
            && (this.getProfitOrderNo() == null ? other.getProfitOrderNo() == null : this.getProfitOrderNo().equals(other.getProfitOrderNo()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRefundNo() == null) ? 0 : getRefundNo().hashCode());
        result = prime * result + ((getProfitOrderNo() == null) ? 0 : getProfitOrderNo().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}