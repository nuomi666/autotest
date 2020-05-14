package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "deposit_instruction")
public class DepositInstructionDO implements Serializable {
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
     * 收款（充值）会员ID
     */
    @Column(name = "payee_user_id")
    private String payeeUserId;

    /**
     * 收款人余额
     */
    @Column(name = "payee_user_balance")
    private Long payeeUserBalance;

    /**
     * 收款（充值）资金账号
     */
    @Column(name = "payee_account_no")
    private String payeeAccountNo;

    /**
     * 联动资金账号
     */
    @Column(name = "link_account_no")
    private String linkAccountNo;

    /**
     * 关联支付资金账号Tag
     */
    @Column(name = "relation_user_tag")
    private String relationUserTag;

    /**
     * 收款（充值）资金账号Tag
     */
    @Column(name = "payee_user_tag")
    private String payeeUserTag;

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
     * 渠道手续费
     */
    @Column(name = "channel_fee")
    private Long channelFee;

    @Column(name = "partner_fee")
    private Long partnerFee;

    /**
     * 金额
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 实际充值金额
     */
    @Column(name = "real_pay_amount")
    private Long realPayAmount;

    /**
     * 优惠金额
     */
    @Column(name = "discount_amount")
    private Long discountAmount;

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
     * 支付方式
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 预支付信息
     */
    @Column(name = "pay_info")
    private String payInfo;

    /**
     * 网关支付流水号
     */
    @Column(name = "payment_biz_no")
    private String paymentBizNo;

    /**
     * 账务流水号
     */
    @Column(name = "acc_biz_no")
    private String accBizNo;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 支付人信息 userId/openId
     */
    @Column(name = "payer_id")
    private String payerId;

    /**
     * 充值退款状态
     */
    @Column(name = "order_refund_status")
    private String orderRefundStatus;

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
     * 订单补偿
     */
    private String compensate;

    /**
     * 自定义分润信息
     */
    @Column(name = "profit_info")
    private String profitInfo;

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
     * 获取收款（充值）会员ID
     *
     * @return payee_user_id - 收款（充值）会员ID
     */
    public String getPayeeUserId() {
        return payeeUserId;
    }

    /**
     * 设置收款（充值）会员ID
     *
     * @param payeeUserId 收款（充值）会员ID
     */
    public void setPayeeUserId(String payeeUserId) {
        this.payeeUserId = payeeUserId == null ? null : payeeUserId.trim();
    }

    /**
     * 获取收款人余额
     *
     * @return payee_user_balance - 收款人余额
     */
    public Long getPayeeUserBalance() {
        return payeeUserBalance;
    }

    /**
     * 设置收款人余额
     *
     * @param payeeUserBalance 收款人余额
     */
    public void setPayeeUserBalance(Long payeeUserBalance) {
        this.payeeUserBalance = payeeUserBalance;
    }

    /**
     * 获取收款（充值）资金账号
     *
     * @return payee_account_no - 收款（充值）资金账号
     */
    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    /**
     * 设置收款（充值）资金账号
     *
     * @param payeeAccountNo 收款（充值）资金账号
     */
    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo == null ? null : payeeAccountNo.trim();
    }

    /**
     * 获取联动资金账号
     *
     * @return link_account_no - 联动资金账号
     */
    public String getLinkAccountNo() {
        return linkAccountNo;
    }

    /**
     * 设置联动资金账号
     *
     * @param linkAccountNo 联动资金账号
     */
    public void setLinkAccountNo(String linkAccountNo) {
        this.linkAccountNo = linkAccountNo == null ? null : linkAccountNo.trim();
    }

    /**
     * 获取关联支付资金账号Tag
     *
     * @return relation_user_tag - 关联支付资金账号Tag
     */
    public String getRelationUserTag() {
        return relationUserTag;
    }

    /**
     * 设置关联支付资金账号Tag
     *
     * @param relationUserTag 关联支付资金账号Tag
     */
    public void setRelationUserTag(String relationUserTag) {
        this.relationUserTag = relationUserTag == null ? null : relationUserTag.trim();
    }

    /**
     * 获取收款（充值）资金账号Tag
     *
     * @return payee_user_tag - 收款（充值）资金账号Tag
     */
    public String getPayeeUserTag() {
        return payeeUserTag;
    }

    /**
     * 设置收款（充值）资金账号Tag
     *
     * @param payeeUserTag 收款（充值）资金账号Tag
     */
    public void setPayeeUserTag(String payeeUserTag) {
        this.payeeUserTag = payeeUserTag == null ? null : payeeUserTag.trim();
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
     * 获取渠道手续费
     *
     * @return channel_fee - 渠道手续费
     */
    public Long getChannelFee() {
        return channelFee;
    }

    /**
     * 设置渠道手续费
     *
     * @param channelFee 渠道手续费
     */
    public void setChannelFee(Long channelFee) {
        this.channelFee = channelFee;
    }

    /**
     * @return partner_fee
     */
    public Long getPartnerFee() {
        return partnerFee;
    }

    /**
     * @param partnerFee
     */
    public void setPartnerFee(Long partnerFee) {
        this.partnerFee = partnerFee;
    }

    /**
     * 获取金额
     *
     * @return pay_amount - 金额
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置金额
     *
     * @param payAmount 金额
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取实际充值金额
     *
     * @return real_pay_amount - 实际充值金额
     */
    public Long getRealPayAmount() {
        return realPayAmount;
    }

    /**
     * 设置实际充值金额
     *
     * @param realPayAmount 实际充值金额
     */
    public void setRealPayAmount(Long realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    /**
     * 获取优惠金额
     *
     * @return discount_amount - 优惠金额
     */
    public Long getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 设置优惠金额
     *
     * @param discountAmount 优惠金额
     */
    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
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
     * 获取支付方式
     *
     * @return pay_type - 支付方式
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付方式
     *
     * @param payType 支付方式
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 获取预支付信息
     *
     * @return pay_info - 预支付信息
     */
    public String getPayInfo() {
        return payInfo;
    }

    /**
     * 设置预支付信息
     *
     * @param payInfo 预支付信息
     */
    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo == null ? null : payInfo.trim();
    }

    /**
     * 获取网关支付流水号
     *
     * @return payment_biz_no - 网关支付流水号
     */
    public String getPaymentBizNo() {
        return paymentBizNo;
    }

    /**
     * 设置网关支付流水号
     *
     * @param paymentBizNo 网关支付流水号
     */
    public void setPaymentBizNo(String paymentBizNo) {
        this.paymentBizNo = paymentBizNo == null ? null : paymentBizNo.trim();
    }

    /**
     * 获取账务流水号
     *
     * @return acc_biz_no - 账务流水号
     */
    public String getAccBizNo() {
        return accBizNo;
    }

    /**
     * 设置账务流水号
     *
     * @param accBizNo 账务流水号
     */
    public void setAccBizNo(String accBizNo) {
        this.accBizNo = accBizNo == null ? null : accBizNo.trim();
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
     * 获取支付人信息 userId/openId
     *
     * @return payer_id - 支付人信息 userId/openId
     */
    public String getPayerId() {
        return payerId;
    }

    /**
     * 设置支付人信息 userId/openId
     *
     * @param payerId 支付人信息 userId/openId
     */
    public void setPayerId(String payerId) {
        this.payerId = payerId == null ? null : payerId.trim();
    }

    /**
     * 获取充值退款状态
     *
     * @return order_refund_status - 充值退款状态
     */
    public String getOrderRefundStatus() {
        return orderRefundStatus;
    }

    /**
     * 设置充值退款状态
     *
     * @param orderRefundStatus 充值退款状态
     */
    public void setOrderRefundStatus(String orderRefundStatus) {
        this.orderRefundStatus = orderRefundStatus == null ? null : orderRefundStatus.trim();
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
     * 获取订单补偿
     *
     * @return compensate - 订单补偿
     */
    public String getCompensate() {
        return compensate;
    }

    /**
     * 设置订单补偿
     *
     * @param compensate 订单补偿
     */
    public void setCompensate(String compensate) {
        this.compensate = compensate == null ? null : compensate.trim();
    }

    /**
     * 获取自定义分润信息
     *
     * @return profit_info - 自定义分润信息
     */
    public String getProfitInfo() {
        return profitInfo;
    }

    /**
     * 设置自定义分润信息
     *
     * @param profitInfo 自定义分润信息
     */
    public void setProfitInfo(String profitInfo) {
        this.profitInfo = profitInfo == null ? null : profitInfo.trim();
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
        sb.append(", transType=").append(transType);
        sb.append(", transTag=").append(transTag);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantMode=").append(merchantMode);
        sb.append(", payeeUserId=").append(payeeUserId);
        sb.append(", payeeUserBalance=").append(payeeUserBalance);
        sb.append(", payeeAccountNo=").append(payeeAccountNo);
        sb.append(", linkAccountNo=").append(linkAccountNo);
        sb.append(", relationUserTag=").append(relationUserTag);
        sb.append(", payeeUserTag=").append(payeeUserTag);
        sb.append(", partnerRate=").append(partnerRate);
        sb.append(", channelRate=").append(channelRate);
        sb.append(", channelFee=").append(channelFee);
        sb.append(", partnerFee=").append(partnerFee);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", realPayAmount=").append(realPayAmount);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", transDate=").append(transDate);
        sb.append(", accountDay=").append(accountDay);
        sb.append(", channelBizNo=").append(channelBizNo);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", payChannelId=").append(payChannelId);
        sb.append(", payType=").append(payType);
        sb.append(", payInfo=").append(payInfo);
        sb.append(", paymentBizNo=").append(paymentBizNo);
        sb.append(", accBizNo=").append(accBizNo);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", payerId=").append(payerId);
        sb.append(", orderRefundStatus=").append(orderRefundStatus);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", code=").append(code);
        sb.append(", runMemo=").append(runMemo);
        sb.append(", receipt=").append(receipt);
        sb.append(", description=").append(description);
        sb.append(", memo=").append(memo);
        sb.append(", compensate=").append(compensate);
        sb.append(", profitInfo=").append(profitInfo);
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
        DepositInstructionDO other = (DepositInstructionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransType() == null ? other.getTransType() == null : this.getTransType().equals(other.getTransType()))
            && (this.getTransTag() == null ? other.getTransTag() == null : this.getTransTag().equals(other.getTransTag()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantMode() == null ? other.getMerchantMode() == null : this.getMerchantMode().equals(other.getMerchantMode()))
            && (this.getPayeeUserId() == null ? other.getPayeeUserId() == null : this.getPayeeUserId().equals(other.getPayeeUserId()))
            && (this.getPayeeUserBalance() == null ? other.getPayeeUserBalance() == null : this.getPayeeUserBalance().equals(other.getPayeeUserBalance()))
            && (this.getPayeeAccountNo() == null ? other.getPayeeAccountNo() == null : this.getPayeeAccountNo().equals(other.getPayeeAccountNo()))
            && (this.getLinkAccountNo() == null ? other.getLinkAccountNo() == null : this.getLinkAccountNo().equals(other.getLinkAccountNo()))
            && (this.getRelationUserTag() == null ? other.getRelationUserTag() == null : this.getRelationUserTag().equals(other.getRelationUserTag()))
            && (this.getPayeeUserTag() == null ? other.getPayeeUserTag() == null : this.getPayeeUserTag().equals(other.getPayeeUserTag()))
            && (this.getPartnerRate() == null ? other.getPartnerRate() == null : this.getPartnerRate().equals(other.getPartnerRate()))
            && (this.getChannelRate() == null ? other.getChannelRate() == null : this.getChannelRate().equals(other.getChannelRate()))
            && (this.getChannelFee() == null ? other.getChannelFee() == null : this.getChannelFee().equals(other.getChannelFee()))
            && (this.getPartnerFee() == null ? other.getPartnerFee() == null : this.getPartnerFee().equals(other.getPartnerFee()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getRealPayAmount() == null ? other.getRealPayAmount() == null : this.getRealPayAmount().equals(other.getRealPayAmount()))
            && (this.getDiscountAmount() == null ? other.getDiscountAmount() == null : this.getDiscountAmount().equals(other.getDiscountAmount()))
            && (this.getTransDate() == null ? other.getTransDate() == null : this.getTransDate().equals(other.getTransDate()))
            && (this.getAccountDay() == null ? other.getAccountDay() == null : this.getAccountDay().equals(other.getAccountDay()))
            && (this.getChannelBizNo() == null ? other.getChannelBizNo() == null : this.getChannelBizNo().equals(other.getChannelBizNo()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getPayChannelId() == null ? other.getPayChannelId() == null : this.getPayChannelId().equals(other.getPayChannelId()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayInfo() == null ? other.getPayInfo() == null : this.getPayInfo().equals(other.getPayInfo()))
            && (this.getPaymentBizNo() == null ? other.getPaymentBizNo() == null : this.getPaymentBizNo().equals(other.getPaymentBizNo()))
            && (this.getAccBizNo() == null ? other.getAccBizNo() == null : this.getAccBizNo().equals(other.getAccBizNo()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getPayerId() == null ? other.getPayerId() == null : this.getPayerId().equals(other.getPayerId()))
            && (this.getOrderRefundStatus() == null ? other.getOrderRefundStatus() == null : this.getOrderRefundStatus().equals(other.getOrderRefundStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getRunMemo() == null ? other.getRunMemo() == null : this.getRunMemo().equals(other.getRunMemo()))
            && (this.getReceipt() == null ? other.getReceipt() == null : this.getReceipt().equals(other.getReceipt()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getCompensate() == null ? other.getCompensate() == null : this.getCompensate().equals(other.getCompensate()))
            && (this.getProfitInfo() == null ? other.getProfitInfo() == null : this.getProfitInfo().equals(other.getProfitInfo()))
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
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantMode() == null) ? 0 : getMerchantMode().hashCode());
        result = prime * result + ((getPayeeUserId() == null) ? 0 : getPayeeUserId().hashCode());
        result = prime * result + ((getPayeeUserBalance() == null) ? 0 : getPayeeUserBalance().hashCode());
        result = prime * result + ((getPayeeAccountNo() == null) ? 0 : getPayeeAccountNo().hashCode());
        result = prime * result + ((getLinkAccountNo() == null) ? 0 : getLinkAccountNo().hashCode());
        result = prime * result + ((getRelationUserTag() == null) ? 0 : getRelationUserTag().hashCode());
        result = prime * result + ((getPayeeUserTag() == null) ? 0 : getPayeeUserTag().hashCode());
        result = prime * result + ((getPartnerRate() == null) ? 0 : getPartnerRate().hashCode());
        result = prime * result + ((getChannelRate() == null) ? 0 : getChannelRate().hashCode());
        result = prime * result + ((getChannelFee() == null) ? 0 : getChannelFee().hashCode());
        result = prime * result + ((getPartnerFee() == null) ? 0 : getPartnerFee().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getRealPayAmount() == null) ? 0 : getRealPayAmount().hashCode());
        result = prime * result + ((getDiscountAmount() == null) ? 0 : getDiscountAmount().hashCode());
        result = prime * result + ((getTransDate() == null) ? 0 : getTransDate().hashCode());
        result = prime * result + ((getAccountDay() == null) ? 0 : getAccountDay().hashCode());
        result = prime * result + ((getChannelBizNo() == null) ? 0 : getChannelBizNo().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getPayChannelId() == null) ? 0 : getPayChannelId().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayInfo() == null) ? 0 : getPayInfo().hashCode());
        result = prime * result + ((getPaymentBizNo() == null) ? 0 : getPaymentBizNo().hashCode());
        result = prime * result + ((getAccBizNo() == null) ? 0 : getAccBizNo().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getPayerId() == null) ? 0 : getPayerId().hashCode());
        result = prime * result + ((getOrderRefundStatus() == null) ? 0 : getOrderRefundStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRunMemo() == null) ? 0 : getRunMemo().hashCode());
        result = prime * result + ((getReceipt() == null) ? 0 : getReceipt().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCompensate() == null) ? 0 : getCompensate().hashCode());
        result = prime * result + ((getProfitInfo() == null) ? 0 : getProfitInfo().hashCode());
        result = prime * result + ((getExternalmetadata() == null) ? 0 : getExternalmetadata().hashCode());
        result = prime * result + ((getExtensionContext() == null) ? 0 : getExtensionContext().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}