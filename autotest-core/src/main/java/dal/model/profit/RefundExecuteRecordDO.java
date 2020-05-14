package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "refund_execute_record")
public class RefundExecuteRecordDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易单号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 退还号
     */
    @Column(name = "refund_no")
    private String refundNo;

    /**
     * 支付人
     */
    private String payer;

    /**
     * 收款人
     */
    private String payee;

    /**
     * 执行顺序
     */
    private Integer sequence;

    /**
     * 执行（交易）金额，分
     */
    private Long amount;

    /**
     * 执行状态
     */
    private String state;

    /**
     * 备注
     */
    private String memo;

    /**
     * 调用转账服务请求号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 调用转账服务回话号
     */
    private String gid;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 外部商户号
     */
    @Column(name = "merch_order_no")
    private String merchOrderNo;

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
     * 获取退还号
     *
     * @return refund_no - 退还号
     */
    public String getRefundNo() {
        return refundNo;
    }

    /**
     * 设置退还号
     *
     * @param refundNo 退还号
     */
    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo == null ? null : refundNo.trim();
    }

    /**
     * 获取支付人
     *
     * @return payer - 支付人
     */
    public String getPayer() {
        return payer;
    }

    /**
     * 设置支付人
     *
     * @param payer 支付人
     */
    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    /**
     * 获取收款人
     *
     * @return payee - 收款人
     */
    public String getPayee() {
        return payee;
    }

    /**
     * 设置收款人
     *
     * @param payee 收款人
     */
    public void setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
    }

    /**
     * 获取执行顺序
     *
     * @return sequence - 执行顺序
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置执行顺序
     *
     * @param sequence 执行顺序
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 获取执行（交易）金额，分
     *
     * @return amount - 执行（交易）金额，分
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置执行（交易）金额，分
     *
     * @param amount 执行（交易）金额，分
     */
    public void setAmount(Long amount) {
        this.amount = amount;
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
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取调用转账服务请求号
     *
     * @return req_id - 调用转账服务请求号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置调用转账服务请求号
     *
     * @param reqId 调用转账服务请求号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取调用转账服务回话号
     *
     * @return gid - 调用转账服务回话号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置调用转账服务回话号
     *
     * @param gid 调用转账服务回话号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取商户ID
     *
     * @return partner_id - 商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户ID
     *
     * @param partnerId 商户ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取外部商户号
     *
     * @return merch_order_no - 外部商户号
     */
    public String getMerchOrderNo() {
        return merchOrderNo;
    }

    /**
     * 设置外部商户号
     *
     * @param merchOrderNo 外部商户号
     */
    public void setMerchOrderNo(String merchOrderNo) {
        this.merchOrderNo = merchOrderNo == null ? null : merchOrderNo.trim();
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
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", refundNo=").append(refundNo);
        sb.append(", payer=").append(payer);
        sb.append(", payee=").append(payee);
        sb.append(", sequence=").append(sequence);
        sb.append(", amount=").append(amount);
        sb.append(", state=").append(state);
        sb.append(", memo=").append(memo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchOrderNo=").append(merchOrderNo);
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
        RefundExecuteRecordDO other = (RefundExecuteRecordDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getRefundNo() == null ? other.getRefundNo() == null : this.getRefundNo().equals(other.getRefundNo()))
            && (this.getPayer() == null ? other.getPayer() == null : this.getPayer().equals(other.getPayer()))
            && (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchOrderNo() == null ? other.getMerchOrderNo() == null : this.getMerchOrderNo().equals(other.getMerchOrderNo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getRefundNo() == null) ? 0 : getRefundNo().hashCode());
        result = prime * result + ((getPayer() == null) ? 0 : getPayer().hashCode());
        result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchOrderNo() == null) ? 0 : getMerchOrderNo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}