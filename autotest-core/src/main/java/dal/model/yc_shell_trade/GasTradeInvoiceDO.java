package dal.model.yc_shell_trade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_trade_invoice")
public class GasTradeInvoiceDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 交易流水号
     */
    @Column(name = "trade_no")
    private String tradeNo;

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
     * 商户姓名
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 油站ID
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 油站编码
     */
    @Column(name = "station_code")
    private String stationCode;

    /**
     * 油站名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 操作员ID
     */
    @Column(name = "operate_id")
    private String operateId;

    /**
     * 操作员姓名
     */
    @Column(name = "operate_name")
    private String operateName;

    /**
     * 会员ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 发票类型
     */
    @Column(name = "invoice_type")
    private String invoiceType;

    /**
     * 开票日期
     */
    @Column(name = "invoice_date")
    private Date invoiceDate;

    /**
     * 发票代码
     */
    @Column(name = "invoice_code")
    private String invoiceCode;

    /**
     * 发票号码
     */
    @Column(name = "invoice_no")
    private String invoiceNo;

    /**
     * 发票抬头类型
     */
    @Column(name = "invoice_title_type")
    private String invoiceTitleType;

    /**
     * 发票抬头
     */
    @Column(name = "invoice_title")
    private String invoiceTitle;

    /**
     * 发票内容
     */
    @Column(name = "invoice_content")
    private String invoiceContent;

    /**
     * 发票金额
     */
    @Column(name = "invoice_amount")
    private Long invoiceAmount;

    /**
     * 发票下载地址
     */
    @Column(name = "invoice_url")
    private String invoiceUrl;

    /**
     * 发票文件地址
     */
    @Column(name = "invoice_file")
    private String invoiceFile;

    /**
     * 电子邮箱
     */
    @Column(name = "email_addr")
    private String emailAddr;

    /**
     * 税号，纳税人识别号
     */
    @Column(name = "tax_no")
    private String taxNo;

    /**
     * 企业/个人地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 开户银行
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 银行账户
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * 商品编码
     */
    @Column(name = "goods_code")
    private String goodsCode;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品数量
     */
    @Column(name = "goods_quantity")
    private BigDecimal goodsQuantity;

    /**
     * 商品价格
     */
    @Column(name = "goods_price")
    private Long goodsPrice;

    /**
     * 开票企业名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 开票企业税号
     */
    @Column(name = "company_tax_no")
    private String companyTaxNo;

    /**
     * 开票企业地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 开票企业电话
     */
    @Column(name = "company_mobile")
    private String companyMobile;

    /**
     * 开票企业开票人
     */
    @Column(name = "company_tax_drawer")
    private String companyTaxDrawer;

    /**
     * 开票企业复核人
     */
    @Column(name = "company_tax_reviewer")
    private String companyTaxReviewer;

    /**
     * 商品增值税率
     */
    @Column(name = "tax_goods_rate")
    private Double taxGoodsRate;

    /**
     * 商品增值税类别编码
     */
    @Column(name = "tax_goods_code")
    private String taxGoodsCode;

    /**
     * 商品货物/劳务名称
     */
    @Column(name = "tax_goods_name")
    private String taxGoodsName;

    /**
     * 状态
     */
    private String status;

    /**
     * 发票状态
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
     * 获取交易流水号
     *
     * @return trade_no - 交易流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易流水号
     *
     * @param tradeNo 交易流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
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
     * 获取商户姓名
     *
     * @return partner_name - 商户姓名
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商户姓名
     *
     * @param partnerName 商户姓名
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取油站ID
     *
     * @return station_id - 油站ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站ID
     *
     * @param stationId 油站ID
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取油站编码
     *
     * @return station_code - 油站编码
     */
    public String getStationCode() {
        return stationCode;
    }

    /**
     * 设置油站编码
     *
     * @param stationCode 油站编码
     */
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    /**
     * 获取油站名称
     *
     * @return station_name - 油站名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置油站名称
     *
     * @param stationName 油站名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * 获取操作员ID
     *
     * @return operate_id - 操作员ID
     */
    public String getOperateId() {
        return operateId;
    }

    /**
     * 设置操作员ID
     *
     * @param operateId 操作员ID
     */
    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    /**
     * 获取操作员姓名
     *
     * @return operate_name - 操作员姓名
     */
    public String getOperateName() {
        return operateName;
    }

    /**
     * 设置操作员姓名
     *
     * @param operateName 操作员姓名
     */
    public void setOperateName(String operateName) {
        this.operateName = operateName == null ? null : operateName.trim();
    }

    /**
     * 获取会员ID
     *
     * @return user_id - 会员ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置会员ID
     *
     * @param userId 会员ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取发票类型
     *
     * @return invoice_type - 发票类型
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * 设置发票类型
     *
     * @param invoiceType 发票类型
     */
    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    /**
     * 获取开票日期
     *
     * @return invoice_date - 开票日期
     */
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * 设置开票日期
     *
     * @param invoiceDate 开票日期
     */
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * 获取发票代码
     *
     * @return invoice_code - 发票代码
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 设置发票代码
     *
     * @param invoiceCode 发票代码
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    /**
     * 获取发票号码
     *
     * @return invoice_no - 发票号码
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * 设置发票号码
     *
     * @param invoiceNo 发票号码
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    /**
     * 获取发票抬头类型
     *
     * @return invoice_title_type - 发票抬头类型
     */
    public String getInvoiceTitleType() {
        return invoiceTitleType;
    }

    /**
     * 设置发票抬头类型
     *
     * @param invoiceTitleType 发票抬头类型
     */
    public void setInvoiceTitleType(String invoiceTitleType) {
        this.invoiceTitleType = invoiceTitleType == null ? null : invoiceTitleType.trim();
    }

    /**
     * 获取发票抬头
     *
     * @return invoice_title - 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 设置发票抬头
     *
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    /**
     * 获取发票内容
     *
     * @return invoice_content - 发票内容
     */
    public String getInvoiceContent() {
        return invoiceContent;
    }

    /**
     * 设置发票内容
     *
     * @param invoiceContent 发票内容
     */
    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent == null ? null : invoiceContent.trim();
    }

    /**
     * 获取发票金额
     *
     * @return invoice_amount - 发票金额
     */
    public Long getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * 设置发票金额
     *
     * @param invoiceAmount 发票金额
     */
    public void setInvoiceAmount(Long invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * 获取发票下载地址
     *
     * @return invoice_url - 发票下载地址
     */
    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    /**
     * 设置发票下载地址
     *
     * @param invoiceUrl 发票下载地址
     */
    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl == null ? null : invoiceUrl.trim();
    }

    /**
     * 获取发票文件地址
     *
     * @return invoice_file - 发票文件地址
     */
    public String getInvoiceFile() {
        return invoiceFile;
    }

    /**
     * 设置发票文件地址
     *
     * @param invoiceFile 发票文件地址
     */
    public void setInvoiceFile(String invoiceFile) {
        this.invoiceFile = invoiceFile == null ? null : invoiceFile.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return email_addr - 电子邮箱
     */
    public String getEmailAddr() {
        return emailAddr;
    }

    /**
     * 设置电子邮箱
     *
     * @param emailAddr 电子邮箱
     */
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr == null ? null : emailAddr.trim();
    }

    /**
     * 获取税号，纳税人识别号
     *
     * @return tax_no - 税号，纳税人识别号
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * 设置税号，纳税人识别号
     *
     * @param taxNo 税号，纳税人识别号
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    /**
     * 获取企业/个人地址
     *
     * @return address - 企业/个人地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置企业/个人地址
     *
     * @param address 企业/个人地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取开户银行
     *
     * @return bank_name - 开户银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户银行
     *
     * @param bankName 开户银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取银行账户
     *
     * @return bank_account - 银行账户
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账户
     *
     * @param bankAccount 银行账户
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 获取商品编码
     *
     * @return goods_code - 商品编码
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * 设置商品编码
     *
     * @param goodsCode 商品编码
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取商品数量
     *
     * @return goods_quantity - 商品数量
     */
    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    /**
     * 设置商品数量
     *
     * @param goodsQuantity 商品数量
     */
    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    /**
     * 获取商品价格
     *
     * @return goods_price - 商品价格
     */
    public Long getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 设置商品价格
     *
     * @param goodsPrice 商品价格
     */
    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 获取开票企业名称
     *
     * @return company_name - 开票企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置开票企业名称
     *
     * @param companyName 开票企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取开票企业税号
     *
     * @return company_tax_no - 开票企业税号
     */
    public String getCompanyTaxNo() {
        return companyTaxNo;
    }

    /**
     * 设置开票企业税号
     *
     * @param companyTaxNo 开票企业税号
     */
    public void setCompanyTaxNo(String companyTaxNo) {
        this.companyTaxNo = companyTaxNo == null ? null : companyTaxNo.trim();
    }

    /**
     * 获取开票企业地址
     *
     * @return company_address - 开票企业地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置开票企业地址
     *
     * @param companyAddress 开票企业地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * 获取开票企业电话
     *
     * @return company_mobile - 开票企业电话
     */
    public String getCompanyMobile() {
        return companyMobile;
    }

    /**
     * 设置开票企业电话
     *
     * @param companyMobile 开票企业电话
     */
    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile == null ? null : companyMobile.trim();
    }

    /**
     * 获取开票企业开票人
     *
     * @return company_tax_drawer - 开票企业开票人
     */
    public String getCompanyTaxDrawer() {
        return companyTaxDrawer;
    }

    /**
     * 设置开票企业开票人
     *
     * @param companyTaxDrawer 开票企业开票人
     */
    public void setCompanyTaxDrawer(String companyTaxDrawer) {
        this.companyTaxDrawer = companyTaxDrawer == null ? null : companyTaxDrawer.trim();
    }

    /**
     * 获取开票企业复核人
     *
     * @return company_tax_reviewer - 开票企业复核人
     */
    public String getCompanyTaxReviewer() {
        return companyTaxReviewer;
    }

    /**
     * 设置开票企业复核人
     *
     * @param companyTaxReviewer 开票企业复核人
     */
    public void setCompanyTaxReviewer(String companyTaxReviewer) {
        this.companyTaxReviewer = companyTaxReviewer == null ? null : companyTaxReviewer.trim();
    }

    /**
     * 获取商品增值税率
     *
     * @return tax_goods_rate - 商品增值税率
     */
    public Double getTaxGoodsRate() {
        return taxGoodsRate;
    }

    /**
     * 设置商品增值税率
     *
     * @param taxGoodsRate 商品增值税率
     */
    public void setTaxGoodsRate(Double taxGoodsRate) {
        this.taxGoodsRate = taxGoodsRate;
    }

    /**
     * 获取商品增值税类别编码
     *
     * @return tax_goods_code - 商品增值税类别编码
     */
    public String getTaxGoodsCode() {
        return taxGoodsCode;
    }

    /**
     * 设置商品增值税类别编码
     *
     * @param taxGoodsCode 商品增值税类别编码
     */
    public void setTaxGoodsCode(String taxGoodsCode) {
        this.taxGoodsCode = taxGoodsCode == null ? null : taxGoodsCode.trim();
    }

    /**
     * 获取商品货物/劳务名称
     *
     * @return tax_goods_name - 商品货物/劳务名称
     */
    public String getTaxGoodsName() {
        return taxGoodsName;
    }

    /**
     * 设置商品货物/劳务名称
     *
     * @param taxGoodsName 商品货物/劳务名称
     */
    public void setTaxGoodsName(String taxGoodsName) {
        this.taxGoodsName = taxGoodsName == null ? null : taxGoodsName.trim();
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
     * 获取发票状态
     *
     * @return state - 发票状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置发票状态
     *
     * @param state 发票状态
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
        sb.append(", bizNo=").append(bizNo);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", stationId=").append(stationId);
        sb.append(", stationCode=").append(stationCode);
        sb.append(", stationName=").append(stationName);
        sb.append(", operateId=").append(operateId);
        sb.append(", operateName=").append(operateName);
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", mobile=").append(mobile);
        sb.append(", invoiceType=").append(invoiceType);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", invoiceCode=").append(invoiceCode);
        sb.append(", invoiceNo=").append(invoiceNo);
        sb.append(", invoiceTitleType=").append(invoiceTitleType);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", invoiceContent=").append(invoiceContent);
        sb.append(", invoiceAmount=").append(invoiceAmount);
        sb.append(", invoiceUrl=").append(invoiceUrl);
        sb.append(", invoiceFile=").append(invoiceFile);
        sb.append(", emailAddr=").append(emailAddr);
        sb.append(", taxNo=").append(taxNo);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", goodsCode=").append(goodsCode);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsQuantity=").append(goodsQuantity);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyTaxNo=").append(companyTaxNo);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", companyMobile=").append(companyMobile);
        sb.append(", companyTaxDrawer=").append(companyTaxDrawer);
        sb.append(", companyTaxReviewer=").append(companyTaxReviewer);
        sb.append(", taxGoodsRate=").append(taxGoodsRate);
        sb.append(", taxGoodsCode=").append(taxGoodsCode);
        sb.append(", taxGoodsName=").append(taxGoodsName);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
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
        GasTradeInvoiceDO other = (GasTradeInvoiceDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationCode() == null ? other.getStationCode() == null : this.getStationCode().equals(other.getStationCode()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getOperateId() == null ? other.getOperateId() == null : this.getOperateId().equals(other.getOperateId()))
            && (this.getOperateName() == null ? other.getOperateName() == null : this.getOperateName().equals(other.getOperateName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getInvoiceType() == null ? other.getInvoiceType() == null : this.getInvoiceType().equals(other.getInvoiceType()))
            && (this.getInvoiceDate() == null ? other.getInvoiceDate() == null : this.getInvoiceDate().equals(other.getInvoiceDate()))
            && (this.getInvoiceCode() == null ? other.getInvoiceCode() == null : this.getInvoiceCode().equals(other.getInvoiceCode()))
            && (this.getInvoiceNo() == null ? other.getInvoiceNo() == null : this.getInvoiceNo().equals(other.getInvoiceNo()))
            && (this.getInvoiceTitleType() == null ? other.getInvoiceTitleType() == null : this.getInvoiceTitleType().equals(other.getInvoiceTitleType()))
            && (this.getInvoiceTitle() == null ? other.getInvoiceTitle() == null : this.getInvoiceTitle().equals(other.getInvoiceTitle()))
            && (this.getInvoiceContent() == null ? other.getInvoiceContent() == null : this.getInvoiceContent().equals(other.getInvoiceContent()))
            && (this.getInvoiceAmount() == null ? other.getInvoiceAmount() == null : this.getInvoiceAmount().equals(other.getInvoiceAmount()))
            && (this.getInvoiceUrl() == null ? other.getInvoiceUrl() == null : this.getInvoiceUrl().equals(other.getInvoiceUrl()))
            && (this.getInvoiceFile() == null ? other.getInvoiceFile() == null : this.getInvoiceFile().equals(other.getInvoiceFile()))
            && (this.getEmailAddr() == null ? other.getEmailAddr() == null : this.getEmailAddr().equals(other.getEmailAddr()))
            && (this.getTaxNo() == null ? other.getTaxNo() == null : this.getTaxNo().equals(other.getTaxNo()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getGoodsCode() == null ? other.getGoodsCode() == null : this.getGoodsCode().equals(other.getGoodsCode()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsQuantity() == null ? other.getGoodsQuantity() == null : this.getGoodsQuantity().equals(other.getGoodsQuantity()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyTaxNo() == null ? other.getCompanyTaxNo() == null : this.getCompanyTaxNo().equals(other.getCompanyTaxNo()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getCompanyMobile() == null ? other.getCompanyMobile() == null : this.getCompanyMobile().equals(other.getCompanyMobile()))
            && (this.getCompanyTaxDrawer() == null ? other.getCompanyTaxDrawer() == null : this.getCompanyTaxDrawer().equals(other.getCompanyTaxDrawer()))
            && (this.getCompanyTaxReviewer() == null ? other.getCompanyTaxReviewer() == null : this.getCompanyTaxReviewer().equals(other.getCompanyTaxReviewer()))
            && (this.getTaxGoodsRate() == null ? other.getTaxGoodsRate() == null : this.getTaxGoodsRate().equals(other.getTaxGoodsRate()))
            && (this.getTaxGoodsCode() == null ? other.getTaxGoodsCode() == null : this.getTaxGoodsCode().equals(other.getTaxGoodsCode()))
            && (this.getTaxGoodsName() == null ? other.getTaxGoodsName() == null : this.getTaxGoodsName().equals(other.getTaxGoodsName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationCode() == null) ? 0 : getStationCode().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getOperateId() == null) ? 0 : getOperateId().hashCode());
        result = prime * result + ((getOperateName() == null) ? 0 : getOperateName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getInvoiceType() == null) ? 0 : getInvoiceType().hashCode());
        result = prime * result + ((getInvoiceDate() == null) ? 0 : getInvoiceDate().hashCode());
        result = prime * result + ((getInvoiceCode() == null) ? 0 : getInvoiceCode().hashCode());
        result = prime * result + ((getInvoiceNo() == null) ? 0 : getInvoiceNo().hashCode());
        result = prime * result + ((getInvoiceTitleType() == null) ? 0 : getInvoiceTitleType().hashCode());
        result = prime * result + ((getInvoiceTitle() == null) ? 0 : getInvoiceTitle().hashCode());
        result = prime * result + ((getInvoiceContent() == null) ? 0 : getInvoiceContent().hashCode());
        result = prime * result + ((getInvoiceAmount() == null) ? 0 : getInvoiceAmount().hashCode());
        result = prime * result + ((getInvoiceUrl() == null) ? 0 : getInvoiceUrl().hashCode());
        result = prime * result + ((getInvoiceFile() == null) ? 0 : getInvoiceFile().hashCode());
        result = prime * result + ((getEmailAddr() == null) ? 0 : getEmailAddr().hashCode());
        result = prime * result + ((getTaxNo() == null) ? 0 : getTaxNo().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getGoodsCode() == null) ? 0 : getGoodsCode().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsQuantity() == null) ? 0 : getGoodsQuantity().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyTaxNo() == null) ? 0 : getCompanyTaxNo().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getCompanyMobile() == null) ? 0 : getCompanyMobile().hashCode());
        result = prime * result + ((getCompanyTaxDrawer() == null) ? 0 : getCompanyTaxDrawer().hashCode());
        result = prime * result + ((getCompanyTaxReviewer() == null) ? 0 : getCompanyTaxReviewer().hashCode());
        result = prime * result + ((getTaxGoodsRate() == null) ? 0 : getTaxGoodsRate().hashCode());
        result = prime * result + ((getTaxGoodsCode() == null) ? 0 : getTaxGoodsCode().hashCode());
        result = prime * result + ((getTaxGoodsName() == null) ? 0 : getTaxGoodsName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}