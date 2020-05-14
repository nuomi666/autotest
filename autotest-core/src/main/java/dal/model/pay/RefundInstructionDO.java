package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "refund_instruction")
public class RefundInstructionDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 退款类型
     */
    @Column(name = "trans_type")
    private String transType;

    /**
     * 支付tag
     */
    @Column(name = "trans_tag")
    private String transTag;

    /**
     * 退款类型
     */
    @Column(name = "refund_type")
    private String refundType;

    /**
     * 退款流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 请求流水号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     *  统一流水id
     */
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
     * 跳转地址
     */
    @Column(name = "redirect_url")
    private String redirectUrl;

    /**
     * 支付流水号
     */
    @Column(name = "payment_biz_no")
    private String paymentBizNo;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 渠道退款流水号
     */
    @Column(name = "channel_refund_no")
    private String channelRefundNo;

    /**
     * 支付会员ID
     */
    @Column(name = "payer_user_id")
    private String payerUserId;

    /**
     * 支付人余额
     */
    @Column(name = "payer_user_balance")
    private Long payerUserBalance;

    /**
     * 收款会员ID
     */
    @Column(name = "payee_user_id")
    private String payeeUserId;

    /**
     * 收款人余额
     */
    @Column(name = "payee_user_balance")
    private Long payeeUserBalance;

    /**
     * 支付资金账号
     */
    @Column(name = "payer_account_no")
    private String payerAccountNo;

    /**
     * 关联支付资金账号
     */
    @Column(name = "relation_account_no")
    private String relationAccountNo;

    /**
     * 收款资金账号
     */
    @Column(name = "payee_account_no")
    private String payeeAccountNo;

    /**
     * 支付金额
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 退款金额
     */
    @Column(name = "refund_amount")
    private Long refundAmount;

    /**
     * 支付账号下账账务流水号
     */
    @Column(name = "payer_acc_biz_no")
    private String payerAccBizNo;

    /**
     * 关联账户账务流水号
     */
    @Column(name = "relation_acc_biz_no")
    private String relationAccBizNo;

    /**
     * 收款账户账务流水号
     */
    @Column(name = "payee_acc_biz_no")
    private String payeeAccBizNo;

    /**
     * 支付账号上账时间
     */
    @Column(name = "payer_trans_date")
    private Date payerTransDate;

    /**
     * 关联账号上账时间
     */
    @Column(name = "relation_trans_date")
    private Date relationTransDate;

    /**
     * 收款账号上账时间
     */
    @Column(name = "payee_trans_date")
    private Date payeeTransDate;

    /**
     * 是否退回优惠券
     */
    @Column(name = "refund_coupon")
    private String refundCoupon;

    /**
     * 优惠券指令id
     */
    @Column(name = "coupon_instruction_id")
    private String couponInstructionId;

    /**
     * 解冻码
     */
    @Column(name = "un_freeze_code")
    private String unFreezeCode;

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
     * 订单补偿
     */
    private String compensate;

    /**
     * 外部数据域（原样返回、仅存储）
     */
    @Column(name = "external_meta_data")
    private String externalMetaData;

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
     * 获取退款类型
     *
     * @return trans_type - 退款类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * 设置退款类型
     *
     * @param transType 退款类型
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
     * 获取退款类型
     *
     * @return refund_type - 退款类型
     */
    public String getRefundType() {
        return refundType;
    }

    /**
     * 设置退款类型
     *
     * @param refundType 退款类型
     */
    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    /**
     * 获取退款流水号
     *
     * @return biz_no - 退款流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置退款流水号
     *
     * @param bizNo 退款流水号
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
     * 获取 统一流水id
     *
     * @return gid -  统一流水id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置 统一流水id
     *
     * @param gid  统一流水id
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
     * 获取跳转地址
     *
     * @return redirect_url - 跳转地址
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * 设置跳转地址
     *
     * @param redirectUrl 跳转地址
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl == null ? null : redirectUrl.trim();
    }

    /**
     * 获取支付流水号
     *
     * @return payment_biz_no - 支付流水号
     */
    public String getPaymentBizNo() {
        return paymentBizNo;
    }

    /**
     * 设置支付流水号
     *
     * @param paymentBizNo 支付流水号
     */
    public void setPaymentBizNo(String paymentBizNo) {
        this.paymentBizNo = paymentBizNo == null ? null : paymentBizNo.trim();
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
     * 获取渠道退款流水号
     *
     * @return channel_refund_no - 渠道退款流水号
     */
    public String getChannelRefundNo() {
        return channelRefundNo;
    }

    /**
     * 设置渠道退款流水号
     *
     * @param channelRefundNo 渠道退款流水号
     */
    public void setChannelRefundNo(String channelRefundNo) {
        this.channelRefundNo = channelRefundNo == null ? null : channelRefundNo.trim();
    }

    /**
     * 获取支付会员ID
     *
     * @return payer_user_id - 支付会员ID
     */
    public String getPayerUserId() {
        return payerUserId;
    }

    /**
     * 设置支付会员ID
     *
     * @param payerUserId 支付会员ID
     */
    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId == null ? null : payerUserId.trim();
    }

    /**
     * 获取支付人余额
     *
     * @return payer_user_balance - 支付人余额
     */
    public Long getPayerUserBalance() {
        return payerUserBalance;
    }

    /**
     * 设置支付人余额
     *
     * @param payerUserBalance 支付人余额
     */
    public void setPayerUserBalance(Long payerUserBalance) {
        this.payerUserBalance = payerUserBalance;
    }

    /**
     * 获取收款会员ID
     *
     * @return payee_user_id - 收款会员ID
     */
    public String getPayeeUserId() {
        return payeeUserId;
    }

    /**
     * 设置收款会员ID
     *
     * @param payeeUserId 收款会员ID
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
     * 获取支付资金账号
     *
     * @return payer_account_no - 支付资金账号
     */
    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    /**
     * 设置支付资金账号
     *
     * @param payerAccountNo 支付资金账号
     */
    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo == null ? null : payerAccountNo.trim();
    }

    /**
     * 获取关联支付资金账号
     *
     * @return relation_account_no - 关联支付资金账号
     */
    public String getRelationAccountNo() {
        return relationAccountNo;
    }

    /**
     * 设置关联支付资金账号
     *
     * @param relationAccountNo 关联支付资金账号
     */
    public void setRelationAccountNo(String relationAccountNo) {
        this.relationAccountNo = relationAccountNo == null ? null : relationAccountNo.trim();
    }

    /**
     * 获取收款资金账号
     *
     * @return payee_account_no - 收款资金账号
     */
    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    /**
     * 设置收款资金账号
     *
     * @param payeeAccountNo 收款资金账号
     */
    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo == null ? null : payeeAccountNo.trim();
    }

    /**
     * 获取支付金额
     *
     * @return pay_amount - 支付金额
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     *
     * @param payAmount 支付金额
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取退款金额
     *
     * @return refund_amount - 退款金额
     */
    public Long getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置退款金额
     *
     * @param refundAmount 退款金额
     */
    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * 获取支付账号下账账务流水号
     *
     * @return payer_acc_biz_no - 支付账号下账账务流水号
     */
    public String getPayerAccBizNo() {
        return payerAccBizNo;
    }

    /**
     * 设置支付账号下账账务流水号
     *
     * @param payerAccBizNo 支付账号下账账务流水号
     */
    public void setPayerAccBizNo(String payerAccBizNo) {
        this.payerAccBizNo = payerAccBizNo == null ? null : payerAccBizNo.trim();
    }

    /**
     * 获取关联账户账务流水号
     *
     * @return relation_acc_biz_no - 关联账户账务流水号
     */
    public String getRelationAccBizNo() {
        return relationAccBizNo;
    }

    /**
     * 设置关联账户账务流水号
     *
     * @param relationAccBizNo 关联账户账务流水号
     */
    public void setRelationAccBizNo(String relationAccBizNo) {
        this.relationAccBizNo = relationAccBizNo == null ? null : relationAccBizNo.trim();
    }

    /**
     * 获取收款账户账务流水号
     *
     * @return payee_acc_biz_no - 收款账户账务流水号
     */
    public String getPayeeAccBizNo() {
        return payeeAccBizNo;
    }

    /**
     * 设置收款账户账务流水号
     *
     * @param payeeAccBizNo 收款账户账务流水号
     */
    public void setPayeeAccBizNo(String payeeAccBizNo) {
        this.payeeAccBizNo = payeeAccBizNo == null ? null : payeeAccBizNo.trim();
    }

    /**
     * 获取支付账号上账时间
     *
     * @return payer_trans_date - 支付账号上账时间
     */
    public Date getPayerTransDate() {
        return payerTransDate;
    }

    /**
     * 设置支付账号上账时间
     *
     * @param payerTransDate 支付账号上账时间
     */
    public void setPayerTransDate(Date payerTransDate) {
        this.payerTransDate = payerTransDate;
    }

    /**
     * 获取关联账号上账时间
     *
     * @return relation_trans_date - 关联账号上账时间
     */
    public Date getRelationTransDate() {
        return relationTransDate;
    }

    /**
     * 设置关联账号上账时间
     *
     * @param relationTransDate 关联账号上账时间
     */
    public void setRelationTransDate(Date relationTransDate) {
        this.relationTransDate = relationTransDate;
    }

    /**
     * 获取收款账号上账时间
     *
     * @return payee_trans_date - 收款账号上账时间
     */
    public Date getPayeeTransDate() {
        return payeeTransDate;
    }

    /**
     * 设置收款账号上账时间
     *
     * @param payeeTransDate 收款账号上账时间
     */
    public void setPayeeTransDate(Date payeeTransDate) {
        this.payeeTransDate = payeeTransDate;
    }

    /**
     * 获取是否退回优惠券
     *
     * @return refund_coupon - 是否退回优惠券
     */
    public String getRefundCoupon() {
        return refundCoupon;
    }

    /**
     * 设置是否退回优惠券
     *
     * @param refundCoupon 是否退回优惠券
     */
    public void setRefundCoupon(String refundCoupon) {
        this.refundCoupon = refundCoupon == null ? null : refundCoupon.trim();
    }

    /**
     * 获取优惠券指令id
     *
     * @return coupon_instruction_id - 优惠券指令id
     */
    public String getCouponInstructionId() {
        return couponInstructionId;
    }

    /**
     * 设置优惠券指令id
     *
     * @param couponInstructionId 优惠券指令id
     */
    public void setCouponInstructionId(String couponInstructionId) {
        this.couponInstructionId = couponInstructionId == null ? null : couponInstructionId.trim();
    }

    /**
     * 获取解冻码
     *
     * @return un_freeze_code - 解冻码
     */
    public String getUnFreezeCode() {
        return unFreezeCode;
    }

    /**
     * 设置解冻码
     *
     * @param unFreezeCode 解冻码
     */
    public void setUnFreezeCode(String unFreezeCode) {
        this.unFreezeCode = unFreezeCode == null ? null : unFreezeCode.trim();
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
     * 获取外部数据域（原样返回、仅存储）
     *
     * @return external_meta_data - 外部数据域（原样返回、仅存储）
     */
    public String getExternalMetaData() {
        return externalMetaData;
    }

    /**
     * 设置外部数据域（原样返回、仅存储）
     *
     * @param externalMetaData 外部数据域（原样返回、仅存储）
     */
    public void setExternalMetaData(String externalMetaData) {
        this.externalMetaData = externalMetaData == null ? null : externalMetaData.trim();
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
        sb.append(", refundType=").append(refundType);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", merchantMode=").append(merchantMode);
        sb.append(", redirectUrl=").append(redirectUrl);
        sb.append(", paymentBizNo=").append(paymentBizNo);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelRefundNo=").append(channelRefundNo);
        sb.append(", payerUserId=").append(payerUserId);
        sb.append(", payerUserBalance=").append(payerUserBalance);
        sb.append(", payeeUserId=").append(payeeUserId);
        sb.append(", payeeUserBalance=").append(payeeUserBalance);
        sb.append(", payerAccountNo=").append(payerAccountNo);
        sb.append(", relationAccountNo=").append(relationAccountNo);
        sb.append(", payeeAccountNo=").append(payeeAccountNo);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", payerAccBizNo=").append(payerAccBizNo);
        sb.append(", relationAccBizNo=").append(relationAccBizNo);
        sb.append(", payeeAccBizNo=").append(payeeAccBizNo);
        sb.append(", payerTransDate=").append(payerTransDate);
        sb.append(", relationTransDate=").append(relationTransDate);
        sb.append(", payeeTransDate=").append(payeeTransDate);
        sb.append(", refundCoupon=").append(refundCoupon);
        sb.append(", couponInstructionId=").append(couponInstructionId);
        sb.append(", unFreezeCode=").append(unFreezeCode);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", code=").append(code);
        sb.append(", runMemo=").append(runMemo);
        sb.append(", receipt=").append(receipt);
        sb.append(", description=").append(description);
        sb.append(", memo=").append(memo);
        sb.append(", compensate=").append(compensate);
        sb.append(", externalMetaData=").append(externalMetaData);
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
        RefundInstructionDO other = (RefundInstructionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransType() == null ? other.getTransType() == null : this.getTransType().equals(other.getTransType()))
            && (this.getTransTag() == null ? other.getTransTag() == null : this.getTransTag().equals(other.getTransTag()))
            && (this.getRefundType() == null ? other.getRefundType() == null : this.getRefundType().equals(other.getRefundType()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMerchantMode() == null ? other.getMerchantMode() == null : this.getMerchantMode().equals(other.getMerchantMode()))
            && (this.getRedirectUrl() == null ? other.getRedirectUrl() == null : this.getRedirectUrl().equals(other.getRedirectUrl()))
            && (this.getPaymentBizNo() == null ? other.getPaymentBizNo() == null : this.getPaymentBizNo().equals(other.getPaymentBizNo()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelRefundNo() == null ? other.getChannelRefundNo() == null : this.getChannelRefundNo().equals(other.getChannelRefundNo()))
            && (this.getPayerUserId() == null ? other.getPayerUserId() == null : this.getPayerUserId().equals(other.getPayerUserId()))
            && (this.getPayerUserBalance() == null ? other.getPayerUserBalance() == null : this.getPayerUserBalance().equals(other.getPayerUserBalance()))
            && (this.getPayeeUserId() == null ? other.getPayeeUserId() == null : this.getPayeeUserId().equals(other.getPayeeUserId()))
            && (this.getPayeeUserBalance() == null ? other.getPayeeUserBalance() == null : this.getPayeeUserBalance().equals(other.getPayeeUserBalance()))
            && (this.getPayerAccountNo() == null ? other.getPayerAccountNo() == null : this.getPayerAccountNo().equals(other.getPayerAccountNo()))
            && (this.getRelationAccountNo() == null ? other.getRelationAccountNo() == null : this.getRelationAccountNo().equals(other.getRelationAccountNo()))
            && (this.getPayeeAccountNo() == null ? other.getPayeeAccountNo() == null : this.getPayeeAccountNo().equals(other.getPayeeAccountNo()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getPayerAccBizNo() == null ? other.getPayerAccBizNo() == null : this.getPayerAccBizNo().equals(other.getPayerAccBizNo()))
            && (this.getRelationAccBizNo() == null ? other.getRelationAccBizNo() == null : this.getRelationAccBizNo().equals(other.getRelationAccBizNo()))
            && (this.getPayeeAccBizNo() == null ? other.getPayeeAccBizNo() == null : this.getPayeeAccBizNo().equals(other.getPayeeAccBizNo()))
            && (this.getPayerTransDate() == null ? other.getPayerTransDate() == null : this.getPayerTransDate().equals(other.getPayerTransDate()))
            && (this.getRelationTransDate() == null ? other.getRelationTransDate() == null : this.getRelationTransDate().equals(other.getRelationTransDate()))
            && (this.getPayeeTransDate() == null ? other.getPayeeTransDate() == null : this.getPayeeTransDate().equals(other.getPayeeTransDate()))
            && (this.getRefundCoupon() == null ? other.getRefundCoupon() == null : this.getRefundCoupon().equals(other.getRefundCoupon()))
            && (this.getCouponInstructionId() == null ? other.getCouponInstructionId() == null : this.getCouponInstructionId().equals(other.getCouponInstructionId()))
            && (this.getUnFreezeCode() == null ? other.getUnFreezeCode() == null : this.getUnFreezeCode().equals(other.getUnFreezeCode()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getRunMemo() == null ? other.getRunMemo() == null : this.getRunMemo().equals(other.getRunMemo()))
            && (this.getReceipt() == null ? other.getReceipt() == null : this.getReceipt().equals(other.getReceipt()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getCompensate() == null ? other.getCompensate() == null : this.getCompensate().equals(other.getCompensate()))
            && (this.getExternalMetaData() == null ? other.getExternalMetaData() == null : this.getExternalMetaData().equals(other.getExternalMetaData()))
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
        result = prime * result + ((getRefundType() == null) ? 0 : getRefundType().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMerchantMode() == null) ? 0 : getMerchantMode().hashCode());
        result = prime * result + ((getRedirectUrl() == null) ? 0 : getRedirectUrl().hashCode());
        result = prime * result + ((getPaymentBizNo() == null) ? 0 : getPaymentBizNo().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelRefundNo() == null) ? 0 : getChannelRefundNo().hashCode());
        result = prime * result + ((getPayerUserId() == null) ? 0 : getPayerUserId().hashCode());
        result = prime * result + ((getPayerUserBalance() == null) ? 0 : getPayerUserBalance().hashCode());
        result = prime * result + ((getPayeeUserId() == null) ? 0 : getPayeeUserId().hashCode());
        result = prime * result + ((getPayeeUserBalance() == null) ? 0 : getPayeeUserBalance().hashCode());
        result = prime * result + ((getPayerAccountNo() == null) ? 0 : getPayerAccountNo().hashCode());
        result = prime * result + ((getRelationAccountNo() == null) ? 0 : getRelationAccountNo().hashCode());
        result = prime * result + ((getPayeeAccountNo() == null) ? 0 : getPayeeAccountNo().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getPayerAccBizNo() == null) ? 0 : getPayerAccBizNo().hashCode());
        result = prime * result + ((getRelationAccBizNo() == null) ? 0 : getRelationAccBizNo().hashCode());
        result = prime * result + ((getPayeeAccBizNo() == null) ? 0 : getPayeeAccBizNo().hashCode());
        result = prime * result + ((getPayerTransDate() == null) ? 0 : getPayerTransDate().hashCode());
        result = prime * result + ((getRelationTransDate() == null) ? 0 : getRelationTransDate().hashCode());
        result = prime * result + ((getPayeeTransDate() == null) ? 0 : getPayeeTransDate().hashCode());
        result = prime * result + ((getRefundCoupon() == null) ? 0 : getRefundCoupon().hashCode());
        result = prime * result + ((getCouponInstructionId() == null) ? 0 : getCouponInstructionId().hashCode());
        result = prime * result + ((getUnFreezeCode() == null) ? 0 : getUnFreezeCode().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRunMemo() == null) ? 0 : getRunMemo().hashCode());
        result = prime * result + ((getReceipt() == null) ? 0 : getReceipt().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCompensate() == null) ? 0 : getCompensate().hashCode());
        result = prime * result + ((getExternalMetaData() == null) ? 0 : getExternalMetaData().hashCode());
        result = prime * result + ((getExtensionContext() == null) ? 0 : getExtensionContext().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}