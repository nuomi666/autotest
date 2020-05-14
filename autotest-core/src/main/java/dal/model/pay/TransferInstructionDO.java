package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "transfer_instruction")
public class TransferInstructionDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易类型
     */
    @Column(name = "trans_type")
    private String transType;

    /**
     * 交易tag
     */
    @Column(name = "trans_tag")
    private String transTag;

    /**
     * 转账类型
     */
    @Column(name = "transfer_type")
    private String transferType;

    /**
     * 支付流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 请求流水号
     */
    @Column(name = "req_id")
    private String reqId;

    private String gid;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 平台商户号
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 平台商户订单号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 商户模式
     */
    @Column(name = "merchant_mode")
    private String merchantMode;

    /**
     * 收款人会员ID
     */
    @Column(name = "payee_user_id")
    private String payeeUserId;

    /**
     * 收款方[会员tag]
     */
    @Column(name = "payee_user_tag")
    private String payeeUserTag;

    /**
     * 收款方资金账号
     */
    @Column(name = "payee_account_no")
    private String payeeAccountNo;

    /**
     * 收款方冻结金额
     */
    @Column(name = "payee_freeze_amount")
    private Long payeeFreezeAmount;

    /**
     * 收款方冻结码
     */
    @Column(name = "payee_freeze_code")
    private String payeeFreezeCode;

    /**
     * 收款方余额
     */
    @Column(name = "payee_balance")
    private Long payeeBalance;

    /**
     * 付款方会员id
     */
    @Column(name = "payer_user_id")
    private String payerUserId;

    /**
     * 付款方[会员tag]
     */
    @Column(name = "payer_user_tag")
    private String payerUserTag;

    /**
     * 付款方资金账号
     */
    @Column(name = "payer_account_no")
    private String payerAccountNo;

    /**
     * 付款方解冻金额
     */
    @Column(name = "payer_unfreeze_amount")
    private Long payerUnfreezeAmount;

    /**
     * 付款方解冻码
     */
    @Column(name = "payer_freeze_code")
    private String payerFreezeCode;

    /**
     * 付款方余额
     */
    @Column(name = "payer_balance")
    private Long payerBalance;

    /**
     * 转账金额
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 资金流水号
     */
    @Column(name = "acc_biz_no")
    private String accBizNo;

    /**
     * 上账时间
     */
    @Column(name = "trans_date")
    private Date transDate;

    /**
     * 资金结算账期
     */
    @Column(name = "account_day")
    private String accountDay;

    /**
     * 延时时间
     */
    private Integer delay;

    /**
     * 批量转账详细，json格式记录
     */
    @Column(name = "batch_detail")
    private String batchDetail;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 支付节点状态
     */
    private String state;

    /**
     * 结果码
     */
    private String code;

    /**
     * 运行时描述
     */
    @Column(name = "run_memo")
    private String runMemo;

    /**
     * 是否回执
     */
    private String receipt;

    /**
     * 支付描述
     */
    private String description;

    /**
     * 运行时描述
     */
    private String memo;

    /**
     * 外部数据域（原样返回、仅存储）
     */
    @Column(name = "externalMetaData")
    private String externalmetadata;

    /**
     * 扩展上下文
     */
    @Column(name = "extension_context")
    private String extensionContext;

    /**
     * 入库时间
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
     * @return trans_type - 交易类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * 设置交易类型
     *
     * @param transType 交易类型
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * 获取交易tag
     *
     * @return trans_tag - 交易tag
     */
    public String getTransTag() {
        return transTag;
    }

    /**
     * 设置交易tag
     *
     * @param transTag 交易tag
     */
    public void setTransTag(String transTag) {
        this.transTag = transTag == null ? null : transTag.trim();
    }

    /**
     * 获取转账类型
     *
     * @return transfer_type - 转账类型
     */
    public String getTransferType() {
        return transferType;
    }

    /**
     * 设置转账类型
     *
     * @param transferType 转账类型
     */
    public void setTransferType(String transferType) {
        this.transferType = transferType == null ? null : transferType.trim();
    }

    /**
     * 获取支付流水号
     *
     * @return biz_no - 支付流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置支付流水号
     *
     * @param bizNo 支付流水号
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
     * 获取商户号
     *
     * @return partner_id - 商户号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户号
     *
     * @param partnerId 商户号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取商户订单号
     *
     * @return merchant_order_no - 商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置商户订单号
     *
     * @param merchantOrderNo 商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /**
     * 获取平台商户号
     *
     * @return plat_partner_id - 平台商户号
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户号
     *
     * @param platPartnerId 平台商户号
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取平台商户订单号
     *
     * @return plat_merchant_order_no - 平台商户订单号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台商户订单号
     *
     * @param platMerchantOrderNo 平台商户订单号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
    }

    /**
     * 获取商户模式
     *
     * @return merchant_mode - 商户模式
     */
    public String getMerchantMode() {
        return merchantMode;
    }

    /**
     * 设置商户模式
     *
     * @param merchantMode 商户模式
     */
    public void setMerchantMode(String merchantMode) {
        this.merchantMode = merchantMode == null ? null : merchantMode.trim();
    }

    /**
     * 获取收款人会员ID
     *
     * @return payee_user_id - 收款人会员ID
     */
    public String getPayeeUserId() {
        return payeeUserId;
    }

    /**
     * 设置收款人会员ID
     *
     * @param payeeUserId 收款人会员ID
     */
    public void setPayeeUserId(String payeeUserId) {
        this.payeeUserId = payeeUserId == null ? null : payeeUserId.trim();
    }

    /**
     * 获取收款方[会员tag]
     *
     * @return payee_user_tag - 收款方[会员tag]
     */
    public String getPayeeUserTag() {
        return payeeUserTag;
    }

    /**
     * 设置收款方[会员tag]
     *
     * @param payeeUserTag 收款方[会员tag]
     */
    public void setPayeeUserTag(String payeeUserTag) {
        this.payeeUserTag = payeeUserTag == null ? null : payeeUserTag.trim();
    }

    /**
     * 获取收款方资金账号
     *
     * @return payee_account_no - 收款方资金账号
     */
    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    /**
     * 设置收款方资金账号
     *
     * @param payeeAccountNo 收款方资金账号
     */
    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo == null ? null : payeeAccountNo.trim();
    }

    /**
     * 获取收款方冻结金额
     *
     * @return payee_freeze_amount - 收款方冻结金额
     */
    public Long getPayeeFreezeAmount() {
        return payeeFreezeAmount;
    }

    /**
     * 设置收款方冻结金额
     *
     * @param payeeFreezeAmount 收款方冻结金额
     */
    public void setPayeeFreezeAmount(Long payeeFreezeAmount) {
        this.payeeFreezeAmount = payeeFreezeAmount;
    }

    /**
     * 获取收款方冻结码
     *
     * @return payee_freeze_code - 收款方冻结码
     */
    public String getPayeeFreezeCode() {
        return payeeFreezeCode;
    }

    /**
     * 设置收款方冻结码
     *
     * @param payeeFreezeCode 收款方冻结码
     */
    public void setPayeeFreezeCode(String payeeFreezeCode) {
        this.payeeFreezeCode = payeeFreezeCode == null ? null : payeeFreezeCode.trim();
    }

    /**
     * 获取收款方余额
     *
     * @return payee_balance - 收款方余额
     */
    public Long getPayeeBalance() {
        return payeeBalance;
    }

    /**
     * 设置收款方余额
     *
     * @param payeeBalance 收款方余额
     */
    public void setPayeeBalance(Long payeeBalance) {
        this.payeeBalance = payeeBalance;
    }

    /**
     * 获取付款方会员id
     *
     * @return payer_user_id - 付款方会员id
     */
    public String getPayerUserId() {
        return payerUserId;
    }

    /**
     * 设置付款方会员id
     *
     * @param payerUserId 付款方会员id
     */
    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId == null ? null : payerUserId.trim();
    }

    /**
     * 获取付款方[会员tag]
     *
     * @return payer_user_tag - 付款方[会员tag]
     */
    public String getPayerUserTag() {
        return payerUserTag;
    }

    /**
     * 设置付款方[会员tag]
     *
     * @param payerUserTag 付款方[会员tag]
     */
    public void setPayerUserTag(String payerUserTag) {
        this.payerUserTag = payerUserTag == null ? null : payerUserTag.trim();
    }

    /**
     * 获取付款方资金账号
     *
     * @return payer_account_no - 付款方资金账号
     */
    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    /**
     * 设置付款方资金账号
     *
     * @param payerAccountNo 付款方资金账号
     */
    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo == null ? null : payerAccountNo.trim();
    }

    /**
     * 获取付款方解冻金额
     *
     * @return payer_unfreeze_amount - 付款方解冻金额
     */
    public Long getPayerUnfreezeAmount() {
        return payerUnfreezeAmount;
    }

    /**
     * 设置付款方解冻金额
     *
     * @param payerUnfreezeAmount 付款方解冻金额
     */
    public void setPayerUnfreezeAmount(Long payerUnfreezeAmount) {
        this.payerUnfreezeAmount = payerUnfreezeAmount;
    }

    /**
     * 获取付款方解冻码
     *
     * @return payer_freeze_code - 付款方解冻码
     */
    public String getPayerFreezeCode() {
        return payerFreezeCode;
    }

    /**
     * 设置付款方解冻码
     *
     * @param payerFreezeCode 付款方解冻码
     */
    public void setPayerFreezeCode(String payerFreezeCode) {
        this.payerFreezeCode = payerFreezeCode == null ? null : payerFreezeCode.trim();
    }

    /**
     * 获取付款方余额
     *
     * @return payer_balance - 付款方余额
     */
    public Long getPayerBalance() {
        return payerBalance;
    }

    /**
     * 设置付款方余额
     *
     * @param payerBalance 付款方余额
     */
    public void setPayerBalance(Long payerBalance) {
        this.payerBalance = payerBalance;
    }

    /**
     * 获取转账金额
     *
     * @return pay_amount - 转账金额
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置转账金额
     *
     * @param payAmount 转账金额
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取资金流水号
     *
     * @return acc_biz_no - 资金流水号
     */
    public String getAccBizNo() {
        return accBizNo;
    }

    /**
     * 设置资金流水号
     *
     * @param accBizNo 资金流水号
     */
    public void setAccBizNo(String accBizNo) {
        this.accBizNo = accBizNo == null ? null : accBizNo.trim();
    }

    /**
     * 获取上账时间
     *
     * @return trans_date - 上账时间
     */
    public Date getTransDate() {
        return transDate;
    }

    /**
     * 设置上账时间
     *
     * @param transDate 上账时间
     */
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    /**
     * 获取资金结算账期
     *
     * @return account_day - 资金结算账期
     */
    public String getAccountDay() {
        return accountDay;
    }

    /**
     * 设置资金结算账期
     *
     * @param accountDay 资金结算账期
     */
    public void setAccountDay(String accountDay) {
        this.accountDay = accountDay == null ? null : accountDay.trim();
    }

    /**
     * 获取延时时间
     *
     * @return delay - 延时时间
     */
    public Integer getDelay() {
        return delay;
    }

    /**
     * 设置延时时间
     *
     * @param delay 延时时间
     */
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * 获取批量转账详细，json格式记录
     *
     * @return batch_detail - 批量转账详细，json格式记录
     */
    public String getBatchDetail() {
        return batchDetail;
    }

    /**
     * 设置批量转账详细，json格式记录
     *
     * @param batchDetail 批量转账详细，json格式记录
     */
    public void setBatchDetail(String batchDetail) {
        this.batchDetail = batchDetail == null ? null : batchDetail.trim();
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

    /**
     * 获取支付状态
     *
     * @return status - 支付状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置支付状态
     *
     * @param status 支付状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取支付节点状态
     *
     * @return state - 支付节点状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置支付节点状态
     *
     * @param state 支付节点状态
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
     * 获取是否回执
     *
     * @return receipt - 是否回执
     */
    public String getReceipt() {
        return receipt;
    }

    /**
     * 设置是否回执
     *
     * @param receipt 是否回执
     */
    public void setReceipt(String receipt) {
        this.receipt = receipt == null ? null : receipt.trim();
    }

    /**
     * 获取支付描述
     *
     * @return description - 支付描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置支付描述
     *
     * @param description 支付描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取运行时描述
     *
     * @return memo - 运行时描述
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置运行时描述
     *
     * @param memo 运行时描述
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取外部数据域（原样返回、仅存储）
     *
     * @return externalMetaData - 外部数据域（原样返回、仅存储）
     */
    public String getExternalmetadata() {
        return externalmetadata;
    }

    /**
     * 设置外部数据域（原样返回、仅存储）
     *
     * @param externalmetadata 外部数据域（原样返回、仅存储）
     */
    public void setExternalmetadata(String externalmetadata) {
        this.externalmetadata = externalmetadata == null ? null : externalmetadata.trim();
    }

    /**
     * 获取扩展上下文
     *
     * @return extension_context - 扩展上下文
     */
    public String getExtensionContext() {
        return extensionContext;
    }

    /**
     * 设置扩展上下文
     *
     * @param extensionContext 扩展上下文
     */
    public void setExtensionContext(String extensionContext) {
        this.extensionContext = extensionContext == null ? null : extensionContext.trim();
    }

    /**
     * 获取入库时间
     *
     * @return raw_add_time - 入库时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置入库时间
     *
     * @param rawAddTime 入库时间
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
        sb.append(", transType=").append(transType);
        sb.append(", transTag=").append(transTag);
        sb.append(", transferType=").append(transferType);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantMode=").append(merchantMode);
        sb.append(", payeeUserId=").append(payeeUserId);
        sb.append(", payeeUserTag=").append(payeeUserTag);
        sb.append(", payeeAccountNo=").append(payeeAccountNo);
        sb.append(", payeeFreezeAmount=").append(payeeFreezeAmount);
        sb.append(", payeeFreezeCode=").append(payeeFreezeCode);
        sb.append(", payeeBalance=").append(payeeBalance);
        sb.append(", payerUserId=").append(payerUserId);
        sb.append(", payerUserTag=").append(payerUserTag);
        sb.append(", payerAccountNo=").append(payerAccountNo);
        sb.append(", payerUnfreezeAmount=").append(payerUnfreezeAmount);
        sb.append(", payerFreezeCode=").append(payerFreezeCode);
        sb.append(", payerBalance=").append(payerBalance);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", accBizNo=").append(accBizNo);
        sb.append(", transDate=").append(transDate);
        sb.append(", accountDay=").append(accountDay);
        sb.append(", delay=").append(delay);
        sb.append(", batchDetail=").append(batchDetail);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", code=").append(code);
        sb.append(", runMemo=").append(runMemo);
        sb.append(", receipt=").append(receipt);
        sb.append(", description=").append(description);
        sb.append(", memo=").append(memo);
        sb.append(", externalmetadata=").append(externalmetadata);
        sb.append(", extensionContext=").append(extensionContext);
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
        TransferInstructionDO other = (TransferInstructionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransType() == null ? other.getTransType() == null : this.getTransType().equals(other.getTransType()))
            && (this.getTransTag() == null ? other.getTransTag() == null : this.getTransTag().equals(other.getTransTag()))
            && (this.getTransferType() == null ? other.getTransferType() == null : this.getTransferType().equals(other.getTransferType()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantMode() == null ? other.getMerchantMode() == null : this.getMerchantMode().equals(other.getMerchantMode()))
            && (this.getPayeeUserId() == null ? other.getPayeeUserId() == null : this.getPayeeUserId().equals(other.getPayeeUserId()))
            && (this.getPayeeUserTag() == null ? other.getPayeeUserTag() == null : this.getPayeeUserTag().equals(other.getPayeeUserTag()))
            && (this.getPayeeAccountNo() == null ? other.getPayeeAccountNo() == null : this.getPayeeAccountNo().equals(other.getPayeeAccountNo()))
            && (this.getPayeeFreezeAmount() == null ? other.getPayeeFreezeAmount() == null : this.getPayeeFreezeAmount().equals(other.getPayeeFreezeAmount()))
            && (this.getPayeeFreezeCode() == null ? other.getPayeeFreezeCode() == null : this.getPayeeFreezeCode().equals(other.getPayeeFreezeCode()))
            && (this.getPayeeBalance() == null ? other.getPayeeBalance() == null : this.getPayeeBalance().equals(other.getPayeeBalance()))
            && (this.getPayerUserId() == null ? other.getPayerUserId() == null : this.getPayerUserId().equals(other.getPayerUserId()))
            && (this.getPayerUserTag() == null ? other.getPayerUserTag() == null : this.getPayerUserTag().equals(other.getPayerUserTag()))
            && (this.getPayerAccountNo() == null ? other.getPayerAccountNo() == null : this.getPayerAccountNo().equals(other.getPayerAccountNo()))
            && (this.getPayerUnfreezeAmount() == null ? other.getPayerUnfreezeAmount() == null : this.getPayerUnfreezeAmount().equals(other.getPayerUnfreezeAmount()))
            && (this.getPayerFreezeCode() == null ? other.getPayerFreezeCode() == null : this.getPayerFreezeCode().equals(other.getPayerFreezeCode()))
            && (this.getPayerBalance() == null ? other.getPayerBalance() == null : this.getPayerBalance().equals(other.getPayerBalance()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getAccBizNo() == null ? other.getAccBizNo() == null : this.getAccBizNo().equals(other.getAccBizNo()))
            && (this.getTransDate() == null ? other.getTransDate() == null : this.getTransDate().equals(other.getTransDate()))
            && (this.getAccountDay() == null ? other.getAccountDay() == null : this.getAccountDay().equals(other.getAccountDay()))
            && (this.getDelay() == null ? other.getDelay() == null : this.getDelay().equals(other.getDelay()))
            && (this.getBatchDetail() == null ? other.getBatchDetail() == null : this.getBatchDetail().equals(other.getBatchDetail()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getRunMemo() == null ? other.getRunMemo() == null : this.getRunMemo().equals(other.getRunMemo()))
            && (this.getReceipt() == null ? other.getReceipt() == null : this.getReceipt().equals(other.getReceipt()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getExternalmetadata() == null ? other.getExternalmetadata() == null : this.getExternalmetadata().equals(other.getExternalmetadata()))
            && (this.getExtensionContext() == null ? other.getExtensionContext() == null : this.getExtensionContext().equals(other.getExtensionContext()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTransType() == null) ? 0 : getTransType().hashCode());
        result = prime * result + ((getTransTag() == null) ? 0 : getTransTag().hashCode());
        result = prime * result + ((getTransferType() == null) ? 0 : getTransferType().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantMode() == null) ? 0 : getMerchantMode().hashCode());
        result = prime * result + ((getPayeeUserId() == null) ? 0 : getPayeeUserId().hashCode());
        result = prime * result + ((getPayeeUserTag() == null) ? 0 : getPayeeUserTag().hashCode());
        result = prime * result + ((getPayeeAccountNo() == null) ? 0 : getPayeeAccountNo().hashCode());
        result = prime * result + ((getPayeeFreezeAmount() == null) ? 0 : getPayeeFreezeAmount().hashCode());
        result = prime * result + ((getPayeeFreezeCode() == null) ? 0 : getPayeeFreezeCode().hashCode());
        result = prime * result + ((getPayeeBalance() == null) ? 0 : getPayeeBalance().hashCode());
        result = prime * result + ((getPayerUserId() == null) ? 0 : getPayerUserId().hashCode());
        result = prime * result + ((getPayerUserTag() == null) ? 0 : getPayerUserTag().hashCode());
        result = prime * result + ((getPayerAccountNo() == null) ? 0 : getPayerAccountNo().hashCode());
        result = prime * result + ((getPayerUnfreezeAmount() == null) ? 0 : getPayerUnfreezeAmount().hashCode());
        result = prime * result + ((getPayerFreezeCode() == null) ? 0 : getPayerFreezeCode().hashCode());
        result = prime * result + ((getPayerBalance() == null) ? 0 : getPayerBalance().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getAccBizNo() == null) ? 0 : getAccBizNo().hashCode());
        result = prime * result + ((getTransDate() == null) ? 0 : getTransDate().hashCode());
        result = prime * result + ((getAccountDay() == null) ? 0 : getAccountDay().hashCode());
        result = prime * result + ((getDelay() == null) ? 0 : getDelay().hashCode());
        result = prime * result + ((getBatchDetail() == null) ? 0 : getBatchDetail().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRunMemo() == null) ? 0 : getRunMemo().hashCode());
        result = prime * result + ((getReceipt() == null) ? 0 : getReceipt().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getExternalmetadata() == null) ? 0 : getExternalmetadata().hashCode());
        result = prime * result + ((getExtensionContext() == null) ? 0 : getExtensionContext().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}