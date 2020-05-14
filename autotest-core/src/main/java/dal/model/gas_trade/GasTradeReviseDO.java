package dal.model.gas_trade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_trade_revise")
public class GasTradeReviseDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易类型
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 请求流水号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 会话流水号
     */
    private String gid;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户名称
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 账户余额
     */
    private Long balance;

    /**
     * 请求单号
     */
    @Column(name = "request_no")
    private String requestNo;

    /**
     * 支付流水号
     */
    @Column(name = "pay_no")
    private String payNo;

    /**
     * 支付方式
     */
    @Column(name = "trade_pay_type")
    private String tradePayType;

    /**
     * 支付模式
     */
    @Column(name = "pay_model")
    private String payModel;

    /**
     * 交易金额/充值金额
     */
    private Long amount;

    /**
     * 支付金额/充值支付金额
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 优惠金额/充值赠送金额
     */
    @Column(name = "favour_amount")
    private Long favourAmount;

    /**
     * 手续费金额
     */
    @Column(name = "fee_amount")
    private Long feeAmount;

    /**
     * 状态
     */
    private String status;

    /**
     * 节点状态
     */
    private String state;

    /**
     * 结果码
     */
    private String code;

    /**
     * 结果描述
     */
    private String description;

    /**
     * 运行时描述
     */
    @Column(name = "run_memo")
    private String runMemo;

    /**
     * 差错类型
     */
    @Column(name = "revise_type")
    private String reviseType;

    /**
     * 差错原因
     */
    @Column(name = "revise_reason")
    private String reviseReason;

    /**
     * 业务状态
     */
    @Column(name = "biz_status")
    private String bizStatus;

    /**
     * 推送状态
     */
    @Column(name = "advance_status")
    private String advanceStatus;

    /**
     * 处理方式
     */
    @Column(name = "handle_type")
    private String handleType;

    /**
     * 清结算时间
     */
    @Column(name = "clear_time")
    private Date clearTime;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 完成时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序列
     *
     * @return id - 自增序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增序列
     *
     * @param id 自增序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取交易类型
     *
     * @return trade_type - 交易类型
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * 设置交易类型
     *
     * @param tradeType 交易类型
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

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
     * 获取请求流水号
     *
     * @return req_id - 请求流水号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求流水号
     *
     * @param reqId 请求流水号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取会话流水号
     *
     * @return gid - 会话流水号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置会话流水号
     *
     * @param gid 会话流水号
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
     * 获取商户名称
     *
     * @return partner_name - 商户名称
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商户名称
     *
     * @param partnerName 商户名称
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取账户余额
     *
     * @return balance - 账户余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 设置账户余额
     *
     * @param balance 账户余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 获取请求单号
     *
     * @return request_no - 请求单号
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * 设置请求单号
     *
     * @param requestNo 请求单号
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    /**
     * 获取支付流水号
     *
     * @return pay_no - 支付流水号
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * 设置支付流水号
     *
     * @param payNo 支付流水号
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    /**
     * 获取支付方式
     *
     * @return trade_pay_type - 支付方式
     */
    public String getTradePayType() {
        return tradePayType;
    }

    /**
     * 设置支付方式
     *
     * @param tradePayType 支付方式
     */
    public void setTradePayType(String tradePayType) {
        this.tradePayType = tradePayType == null ? null : tradePayType.trim();
    }

    /**
     * 获取支付模式
     *
     * @return pay_model - 支付模式
     */
    public String getPayModel() {
        return payModel;
    }

    /**
     * 设置支付模式
     *
     * @param payModel 支付模式
     */
    public void setPayModel(String payModel) {
        this.payModel = payModel == null ? null : payModel.trim();
    }

    /**
     * 获取交易金额/充值金额
     *
     * @return amount - 交易金额/充值金额
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置交易金额/充值金额
     *
     * @param amount 交易金额/充值金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取支付金额/充值支付金额
     *
     * @return pay_amount - 支付金额/充值支付金额
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额/充值支付金额
     *
     * @param payAmount 支付金额/充值支付金额
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取优惠金额/充值赠送金额
     *
     * @return favour_amount - 优惠金额/充值赠送金额
     */
    public Long getFavourAmount() {
        return favourAmount;
    }

    /**
     * 设置优惠金额/充值赠送金额
     *
     * @param favourAmount 优惠金额/充值赠送金额
     */
    public void setFavourAmount(Long favourAmount) {
        this.favourAmount = favourAmount;
    }

    /**
     * 获取手续费金额
     *
     * @return fee_amount - 手续费金额
     */
    public Long getFeeAmount() {
        return feeAmount;
    }

    /**
     * 设置手续费金额
     *
     * @param feeAmount 手续费金额
     */
    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取节点状态
     *
     * @return state - 节点状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置节点状态
     *
     * @param state 节点状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取结果码
     *
     * @return code - 结果码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置结果码
     *
     * @param code 结果码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取结果描述
     *
     * @return description - 结果描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置结果描述
     *
     * @param description 结果描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取运行时描述
     *
     * @return run_memo - 运行时描述
     */
    public String getRunMemo() {
        return runMemo;
    }

    /**
     * 设置运行时描述
     *
     * @param runMemo 运行时描述
     */
    public void setRunMemo(String runMemo) {
        this.runMemo = runMemo == null ? null : runMemo.trim();
    }

    /**
     * 获取差错类型
     *
     * @return revise_type - 差错类型
     */
    public String getReviseType() {
        return reviseType;
    }

    /**
     * 设置差错类型
     *
     * @param reviseType 差错类型
     */
    public void setReviseType(String reviseType) {
        this.reviseType = reviseType == null ? null : reviseType.trim();
    }

    /**
     * 获取差错原因
     *
     * @return revise_reason - 差错原因
     */
    public String getReviseReason() {
        return reviseReason;
    }

    /**
     * 设置差错原因
     *
     * @param reviseReason 差错原因
     */
    public void setReviseReason(String reviseReason) {
        this.reviseReason = reviseReason == null ? null : reviseReason.trim();
    }

    /**
     * 获取业务状态
     *
     * @return biz_status - 业务状态
     */
    public String getBizStatus() {
        return bizStatus;
    }

    /**
     * 设置业务状态
     *
     * @param bizStatus 业务状态
     */
    public void setBizStatus(String bizStatus) {
        this.bizStatus = bizStatus == null ? null : bizStatus.trim();
    }

    /**
     * 获取推送状态
     *
     * @return advance_status - 推送状态
     */
    public String getAdvanceStatus() {
        return advanceStatus;
    }

    /**
     * 设置推送状态
     *
     * @param advanceStatus 推送状态
     */
    public void setAdvanceStatus(String advanceStatus) {
        this.advanceStatus = advanceStatus == null ? null : advanceStatus.trim();
    }

    /**
     * 获取处理方式
     *
     * @return handle_type - 处理方式
     */
    public String getHandleType() {
        return handleType;
    }

    /**
     * 设置处理方式
     *
     * @param handleType 处理方式
     */
    public void setHandleType(String handleType) {
        this.handleType = handleType == null ? null : handleType.trim();
    }

    /**
     * 获取清结算时间
     *
     * @return clear_time - 清结算时间
     */
    public Date getClearTime() {
        return clearTime;
    }

    /**
     * 设置清结算时间
     *
     * @param clearTime 清结算时间
     */
    public void setClearTime(Date clearTime) {
        this.clearTime = clearTime;
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
     * 获取完成时间
     *
     * @return raw_update_time - 完成时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置完成时间
     *
     * @param rawUpdateTime 完成时间
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
        sb.append(", tradeType=").append(tradeType);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", balance=").append(balance);
        sb.append(", requestNo=").append(requestNo);
        sb.append(", payNo=").append(payNo);
        sb.append(", tradePayType=").append(tradePayType);
        sb.append(", payModel=").append(payModel);
        sb.append(", amount=").append(amount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", favourAmount=").append(favourAmount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
        sb.append(", runMemo=").append(runMemo);
        sb.append(", reviseType=").append(reviseType);
        sb.append(", reviseReason=").append(reviseReason);
        sb.append(", bizStatus=").append(bizStatus);
        sb.append(", advanceStatus=").append(advanceStatus);
        sb.append(", handleType=").append(handleType);
        sb.append(", clearTime=").append(clearTime);
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
        GasTradeReviseDO other = (GasTradeReviseDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getRequestNo() == null ? other.getRequestNo() == null : this.getRequestNo().equals(other.getRequestNo()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getTradePayType() == null ? other.getTradePayType() == null : this.getTradePayType().equals(other.getTradePayType()))
            && (this.getPayModel() == null ? other.getPayModel() == null : this.getPayModel().equals(other.getPayModel()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getFavourAmount() == null ? other.getFavourAmount() == null : this.getFavourAmount().equals(other.getFavourAmount()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRunMemo() == null ? other.getRunMemo() == null : this.getRunMemo().equals(other.getRunMemo()))
            && (this.getReviseType() == null ? other.getReviseType() == null : this.getReviseType().equals(other.getReviseType()))
            && (this.getReviseReason() == null ? other.getReviseReason() == null : this.getReviseReason().equals(other.getReviseReason()))
            && (this.getBizStatus() == null ? other.getBizStatus() == null : this.getBizStatus().equals(other.getBizStatus()))
            && (this.getAdvanceStatus() == null ? other.getAdvanceStatus() == null : this.getAdvanceStatus().equals(other.getAdvanceStatus()))
            && (this.getHandleType() == null ? other.getHandleType() == null : this.getHandleType().equals(other.getHandleType()))
            && (this.getClearTime() == null ? other.getClearTime() == null : this.getClearTime().equals(other.getClearTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getRequestNo() == null) ? 0 : getRequestNo().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getTradePayType() == null) ? 0 : getTradePayType().hashCode());
        result = prime * result + ((getPayModel() == null) ? 0 : getPayModel().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getFavourAmount() == null) ? 0 : getFavourAmount().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRunMemo() == null) ? 0 : getRunMemo().hashCode());
        result = prime * result + ((getReviseType() == null) ? 0 : getReviseType().hashCode());
        result = prime * result + ((getReviseReason() == null) ? 0 : getReviseReason().hashCode());
        result = prime * result + ((getBizStatus() == null) ? 0 : getBizStatus().hashCode());
        result = prime * result + ((getAdvanceStatus() == null) ? 0 : getAdvanceStatus().hashCode());
        result = prime * result + ((getHandleType() == null) ? 0 : getHandleType().hashCode());
        result = prime * result + ((getClearTime() == null) ? 0 : getClearTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}