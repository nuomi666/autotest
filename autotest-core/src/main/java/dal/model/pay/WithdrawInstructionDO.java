package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "withdraw_instruction")
public class WithdrawInstructionDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 支付类型
     */
    @Column(name = "trans_type")
    private String transType;

    /**
     * 支付tag
     */
    @Column(name = "trans_tag")
    private String transTag;

    /**
     * 提现类别
     */
    @Column(name = "withdraw_type")
    private String withdrawType;

    /**
     * 充值流水号
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
     * 银行卡号
     */
    @Column(name = "bank_card")
    private String bankCard;

    /**
     * 下账（提现）资金账号userId
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 下账（提现）资金账号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 下账资金账号Tag
     */
    @Column(name = "user_tag")
    private String userTag;

    /**
     * 账户冻结码
     */
    @Column(name = "freeze_code")
    private String freezeCode;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 账务请求号
     */
    @Column(name = "acc_biz_no")
    private String accBizNo;

    /**
     * 冻结请求号
     */
    @Column(name = "freeze_req_id")
    private String freezeReqId;

    /**
     * 解冻请求号
     */
    @Column(name = "unfreeze_req_id")
    private String unfreezeReqId;

    /**
     * 退汇上账请求号
     */
    @Column(name = "remittance_up_balance_req_id")
    private String remittanceUpBalanceReqId;

    /**
     * 商户费率
     */
    @Column(name = "partner_rate")
    private Integer partnerRate;

    /**
     * 渠道费率
     */
    @Column(name = "channel_rate")
    private Integer channelRate;

    /**
     * 渠道流水号
     */
    @Column(name = "channel_biz_no")
    private String channelBizNo;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 渠道名称
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 支付渠道
     */
    @Column(name = "pay_channel")
    private String payChannel;

    /**
     * 支付渠道Id
     */
    @Column(name = "pay_channel_id")
    private String payChannelId;

    /**
     * 网关请求号
     */
    @Column(name = "gw_biz_no")
    private String gwBizNo;

    /**
     * 提现文件信息
     */
    @Column(name = "file_info")
    private String fileInfo;

    /**
     * 提现文件流水号
     */
    @Column(name = "file_serial")
    private String fileSerial;

    /**
     * 提现文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 申请时间
     */
    @Column(name = "apply_time")
    private Date applyTime;

    /**
     * 结算（提现）时间
     */
    @Column(name = "settle_time")
    private Date settleTime;

    /**
     * 银行提现流水号
     */
    @Column(name = "bank_withdraw_serial")
    private String bankWithdrawSerial;

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
     * 获取支付类型
     *
     * @return trans_type - 支付类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * 设置支付类型
     *
     * @param transType 支付类型
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * 获取支付tag
     *
     * @return trans_tag - 支付tag
     */
    public String getTransTag() {
        return transTag;
    }

    /**
     * 设置支付tag
     *
     * @param transTag 支付tag
     */
    public void setTransTag(String transTag) {
        this.transTag = transTag == null ? null : transTag.trim();
    }

    /**
     * 获取提现类别
     *
     * @return withdraw_type - 提现类别
     */
    public String getWithdrawType() {
        return withdrawType;
    }

    /**
     * 设置提现类别
     *
     * @param withdrawType 提现类别
     */
    public void setWithdrawType(String withdrawType) {
        this.withdrawType = withdrawType == null ? null : withdrawType.trim();
    }

    /**
     * 获取充值流水号
     *
     * @return biz_no - 充值流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置充值流水号
     *
     * @param bizNo 充值流水号
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
     * 获取银行卡号
     *
     * @return bank_card - 银行卡号
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 设置银行卡号
     *
     * @param bankCard 银行卡号
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    /**
     * 获取下账（提现）资金账号userId
     *
     * @return user_id - 下账（提现）资金账号userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置下账（提现）资金账号userId
     *
     * @param userId 下账（提现）资金账号userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取下账（提现）资金账号
     *
     * @return account_no - 下账（提现）资金账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置下账（提现）资金账号
     *
     * @param accountNo 下账（提现）资金账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取下账资金账号Tag
     *
     * @return user_tag - 下账资金账号Tag
     */
    public String getUserTag() {
        return userTag;
    }

    /**
     * 设置下账资金账号Tag
     *
     * @param userTag 下账资金账号Tag
     */
    public void setUserTag(String userTag) {
        this.userTag = userTag == null ? null : userTag.trim();
    }

    /**
     * 获取账户冻结码
     *
     * @return freeze_code - 账户冻结码
     */
    public String getFreezeCode() {
        return freezeCode;
    }

    /**
     * 设置账户冻结码
     *
     * @param freezeCode 账户冻结码
     */
    public void setFreezeCode(String freezeCode) {
        this.freezeCode = freezeCode == null ? null : freezeCode.trim();
    }

    /**
     * 获取金额
     *
     * @return amount - 金额
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置金额
     *
     * @param amount 金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 获取账务请求号
     *
     * @return acc_biz_no - 账务请求号
     */
    public String getAccBizNo() {
        return accBizNo;
    }

    /**
     * 设置账务请求号
     *
     * @param accBizNo 账务请求号
     */
    public void setAccBizNo(String accBizNo) {
        this.accBizNo = accBizNo == null ? null : accBizNo.trim();
    }

    /**
     * 获取冻结请求号
     *
     * @return freeze_req_id - 冻结请求号
     */
    public String getFreezeReqId() {
        return freezeReqId;
    }

    /**
     * 设置冻结请求号
     *
     * @param freezeReqId 冻结请求号
     */
    public void setFreezeReqId(String freezeReqId) {
        this.freezeReqId = freezeReqId == null ? null : freezeReqId.trim();
    }

    /**
     * 获取解冻请求号
     *
     * @return unfreeze_req_id - 解冻请求号
     */
    public String getUnfreezeReqId() {
        return unfreezeReqId;
    }

    /**
     * 设置解冻请求号
     *
     * @param unfreezeReqId 解冻请求号
     */
    public void setUnfreezeReqId(String unfreezeReqId) {
        this.unfreezeReqId = unfreezeReqId == null ? null : unfreezeReqId.trim();
    }

    /**
     * 获取退汇上账请求号
     *
     * @return remittance_up_balance_req_id - 退汇上账请求号
     */
    public String getRemittanceUpBalanceReqId() {
        return remittanceUpBalanceReqId;
    }

    /**
     * 设置退汇上账请求号
     *
     * @param remittanceUpBalanceReqId 退汇上账请求号
     */
    public void setRemittanceUpBalanceReqId(String remittanceUpBalanceReqId) {
        this.remittanceUpBalanceReqId = remittanceUpBalanceReqId == null ? null : remittanceUpBalanceReqId.trim();
    }

    /**
     * 获取商户费率
     *
     * @return partner_rate - 商户费率
     */
    public Integer getPartnerRate() {
        return partnerRate;
    }

    /**
     * 设置商户费率
     *
     * @param partnerRate 商户费率
     */
    public void setPartnerRate(Integer partnerRate) {
        this.partnerRate = partnerRate;
    }

    /**
     * 获取渠道费率
     *
     * @return channel_rate - 渠道费率
     */
    public Integer getChannelRate() {
        return channelRate;
    }

    /**
     * 设置渠道费率
     *
     * @param channelRate 渠道费率
     */
    public void setChannelRate(Integer channelRate) {
        this.channelRate = channelRate;
    }

    /**
     * 获取渠道流水号
     *
     * @return channel_biz_no - 渠道流水号
     */
    public String getChannelBizNo() {
        return channelBizNo;
    }

    /**
     * 设置渠道流水号
     *
     * @param channelBizNo 渠道流水号
     */
    public void setChannelBizNo(String channelBizNo) {
        this.channelBizNo = channelBizNo == null ? null : channelBizNo.trim();
    }

    /**
     * 获取渠道id
     *
     * @return channel_id - 渠道id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道id
     *
     * @param channelId 渠道id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取渠道名称
     *
     * @return channel_name - 渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置渠道名称
     *
     * @param channelName 渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 获取支付渠道
     *
     * @return pay_channel - 支付渠道
     */
    public String getPayChannel() {
        return payChannel;
    }

    /**
     * 设置支付渠道
     *
     * @param payChannel 支付渠道
     */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    /**
     * 获取支付渠道Id
     *
     * @return pay_channel_id - 支付渠道Id
     */
    public String getPayChannelId() {
        return payChannelId;
    }

    /**
     * 设置支付渠道Id
     *
     * @param payChannelId 支付渠道Id
     */
    public void setPayChannelId(String payChannelId) {
        this.payChannelId = payChannelId == null ? null : payChannelId.trim();
    }

    /**
     * 获取网关请求号
     *
     * @return gw_biz_no - 网关请求号
     */
    public String getGwBizNo() {
        return gwBizNo;
    }

    /**
     * 设置网关请求号
     *
     * @param gwBizNo 网关请求号
     */
    public void setGwBizNo(String gwBizNo) {
        this.gwBizNo = gwBizNo == null ? null : gwBizNo.trim();
    }

    /**
     * 获取提现文件信息
     *
     * @return file_info - 提现文件信息
     */
    public String getFileInfo() {
        return fileInfo;
    }

    /**
     * 设置提现文件信息
     *
     * @param fileInfo 提现文件信息
     */
    public void setFileInfo(String fileInfo) {
        this.fileInfo = fileInfo == null ? null : fileInfo.trim();
    }

    /**
     * 获取提现文件流水号
     *
     * @return file_serial - 提现文件流水号
     */
    public String getFileSerial() {
        return fileSerial;
    }

    /**
     * 设置提现文件流水号
     *
     * @param fileSerial 提现文件流水号
     */
    public void setFileSerial(String fileSerial) {
        this.fileSerial = fileSerial == null ? null : fileSerial.trim();
    }

    /**
     * 获取提现文件名
     *
     * @return file_name - 提现文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置提现文件名
     *
     * @param fileName 提现文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取结算（提现）时间
     *
     * @return settle_time - 结算（提现）时间
     */
    public Date getSettleTime() {
        return settleTime;
    }

    /**
     * 设置结算（提现）时间
     *
     * @param settleTime 结算（提现）时间
     */
    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    /**
     * 获取银行提现流水号
     *
     * @return bank_withdraw_serial - 银行提现流水号
     */
    public String getBankWithdrawSerial() {
        return bankWithdrawSerial;
    }

    /**
     * 设置银行提现流水号
     *
     * @param bankWithdrawSerial 银行提现流水号
     */
    public void setBankWithdrawSerial(String bankWithdrawSerial) {
        this.bankWithdrawSerial = bankWithdrawSerial == null ? null : bankWithdrawSerial.trim();
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
        sb.append(", withdrawType=").append(withdrawType);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantMode=").append(merchantMode);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", userId=").append(userId);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", userTag=").append(userTag);
        sb.append(", freezeCode=").append(freezeCode);
        sb.append(", amount=").append(amount);
        sb.append(", balance=").append(balance);
        sb.append(", accBizNo=").append(accBizNo);
        sb.append(", freezeReqId=").append(freezeReqId);
        sb.append(", unfreezeReqId=").append(unfreezeReqId);
        sb.append(", remittanceUpBalanceReqId=").append(remittanceUpBalanceReqId);
        sb.append(", partnerRate=").append(partnerRate);
        sb.append(", channelRate=").append(channelRate);
        sb.append(", channelBizNo=").append(channelBizNo);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", payChannelId=").append(payChannelId);
        sb.append(", gwBizNo=").append(gwBizNo);
        sb.append(", fileInfo=").append(fileInfo);
        sb.append(", fileSerial=").append(fileSerial);
        sb.append(", fileName=").append(fileName);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", settleTime=").append(settleTime);
        sb.append(", bankWithdrawSerial=").append(bankWithdrawSerial);
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
        WithdrawInstructionDO other = (WithdrawInstructionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransType() == null ? other.getTransType() == null : this.getTransType().equals(other.getTransType()))
            && (this.getTransTag() == null ? other.getTransTag() == null : this.getTransTag().equals(other.getTransTag()))
            && (this.getWithdrawType() == null ? other.getWithdrawType() == null : this.getWithdrawType().equals(other.getWithdrawType()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantMode() == null ? other.getMerchantMode() == null : this.getMerchantMode().equals(other.getMerchantMode()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getUserTag() == null ? other.getUserTag() == null : this.getUserTag().equals(other.getUserTag()))
            && (this.getFreezeCode() == null ? other.getFreezeCode() == null : this.getFreezeCode().equals(other.getFreezeCode()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getAccBizNo() == null ? other.getAccBizNo() == null : this.getAccBizNo().equals(other.getAccBizNo()))
            && (this.getFreezeReqId() == null ? other.getFreezeReqId() == null : this.getFreezeReqId().equals(other.getFreezeReqId()))
            && (this.getUnfreezeReqId() == null ? other.getUnfreezeReqId() == null : this.getUnfreezeReqId().equals(other.getUnfreezeReqId()))
            && (this.getRemittanceUpBalanceReqId() == null ? other.getRemittanceUpBalanceReqId() == null : this.getRemittanceUpBalanceReqId().equals(other.getRemittanceUpBalanceReqId()))
            && (this.getPartnerRate() == null ? other.getPartnerRate() == null : this.getPartnerRate().equals(other.getPartnerRate()))
            && (this.getChannelRate() == null ? other.getChannelRate() == null : this.getChannelRate().equals(other.getChannelRate()))
            && (this.getChannelBizNo() == null ? other.getChannelBizNo() == null : this.getChannelBizNo().equals(other.getChannelBizNo()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getPayChannelId() == null ? other.getPayChannelId() == null : this.getPayChannelId().equals(other.getPayChannelId()))
            && (this.getGwBizNo() == null ? other.getGwBizNo() == null : this.getGwBizNo().equals(other.getGwBizNo()))
            && (this.getFileInfo() == null ? other.getFileInfo() == null : this.getFileInfo().equals(other.getFileInfo()))
            && (this.getFileSerial() == null ? other.getFileSerial() == null : this.getFileSerial().equals(other.getFileSerial()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getSettleTime() == null ? other.getSettleTime() == null : this.getSettleTime().equals(other.getSettleTime()))
            && (this.getBankWithdrawSerial() == null ? other.getBankWithdrawSerial() == null : this.getBankWithdrawSerial().equals(other.getBankWithdrawSerial()))
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
        result = prime * result + ((getWithdrawType() == null) ? 0 : getWithdrawType().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantMode() == null) ? 0 : getMerchantMode().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getUserTag() == null) ? 0 : getUserTag().hashCode());
        result = prime * result + ((getFreezeCode() == null) ? 0 : getFreezeCode().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getAccBizNo() == null) ? 0 : getAccBizNo().hashCode());
        result = prime * result + ((getFreezeReqId() == null) ? 0 : getFreezeReqId().hashCode());
        result = prime * result + ((getUnfreezeReqId() == null) ? 0 : getUnfreezeReqId().hashCode());
        result = prime * result + ((getRemittanceUpBalanceReqId() == null) ? 0 : getRemittanceUpBalanceReqId().hashCode());
        result = prime * result + ((getPartnerRate() == null) ? 0 : getPartnerRate().hashCode());
        result = prime * result + ((getChannelRate() == null) ? 0 : getChannelRate().hashCode());
        result = prime * result + ((getChannelBizNo() == null) ? 0 : getChannelBizNo().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getPayChannelId() == null) ? 0 : getPayChannelId().hashCode());
        result = prime * result + ((getGwBizNo() == null) ? 0 : getGwBizNo().hashCode());
        result = prime * result + ((getFileInfo() == null) ? 0 : getFileInfo().hashCode());
        result = prime * result + ((getFileSerial() == null) ? 0 : getFileSerial().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getSettleTime() == null) ? 0 : getSettleTime().hashCode());
        result = prime * result + ((getBankWithdrawSerial() == null) ? 0 : getBankWithdrawSerial().hashCode());
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