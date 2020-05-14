package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_dsgj_result_log")
public class ClearDsgjResultLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 全局流水号
     */
    private String gid;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 平台商户名称
     */
    @Column(name = "plat_partner_real_name")
    private String platPartnerRealName;

    /**
     * 签约商结算账户
     */
    @Column(name = "partner_settlement_account")
    private String partnerSettlementAccount;

    /**
     * 资金状态
     */
    @Column(name = "amount_status")
    private String amountStatus;

    /**
     * 转账清分金额资金状态
     */
    @Column(name = "trans_clear_amount_status")
    private String transClearAmountStatus;

    /**
     * 下载手续费资金状态
     */
    @Column(name = "down_fee_amount_status")
    private String downFeeAmountStatus;

    /**
     * 清分结果文件名
     */
    @Column(name = "clear_result_file_name")
    private String clearResultFileName;

    /**
     * 渠道平台账户
     */
    @Column(name = "channel_merchant_id")
    private String channelMerchantId;

    /**
     * 渠道子商户id
     */
    @Column(name = "channel_sub_merchant_id")
    private String channelSubMerchantId;

    /**
     * 渠道子商户名称
     */
    @Column(name = "channel_sub_merchant_name")
    private String channelSubMerchantName;

    /**
     * 清分日期
     */
    @Column(name = "clear_date")
    private String clearDate;

    /**
     * 清分批次号
     */
    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 清分类型
     */
    @Column(name = "clear_type")
    private String clearType;

    /**
     * 交易金额
     */
    @Column(name = "trade_amount")
    private Long tradeAmount;

    /**
     * 交易笔数
     */
    @Column(name = "trade_count")
    private Integer tradeCount;

    /**
     * 子商户结算账户
     */
    @Column(name = "settlement_sub_merchant_id")
    private String settlementSubMerchantId;

    /**
     * 子商户结算商户名称
     */
    @Column(name = "settlement_sub_merchant_name")
    private String settlementSubMerchantName;

    /**
     * 清分金额
     */
    @Column(name = "clear_amount")
    private Long clearAmount;

    /**
     * 平台优惠金额
     */
    @Column(name = "plat_coupon_amount")
    private Long platCouponAmount;

    /**
     * 平台垫付金额
     */
    @Column(name = "advance_amount")
    private Long advanceAmount;

    /**
     * 平台分成金额
     */
    @Column(name = "plat_share_amount")
    private Long platShareAmount;

    /**
     * 手续费金额
     */
    @Column(name = "fee_amount")
    private Long feeAmount;

    /**
     * 清分状态
     */
    @Column(name = "clear_status")
    private String clearStatus;

    /**
     * 备注
     */
    private String comment;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取全局流水号
     *
     * @return gid - 全局流水号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局流水号
     *
     * @param gid 全局流水号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
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
     * 获取签约商户id
     *
     * @return partner_id - 签约商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户id
     *
     * @param partnerId 签约商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商户id
     *
     * @return plat_partner_id - 平台商户id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户id
     *
     * @param platPartnerId 平台商户id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取平台商户名称
     *
     * @return plat_partner_real_name - 平台商户名称
     */
    public String getPlatPartnerRealName() {
        return platPartnerRealName;
    }

    /**
     * 设置平台商户名称
     *
     * @param platPartnerRealName 平台商户名称
     */
    public void setPlatPartnerRealName(String platPartnerRealName) {
        this.platPartnerRealName = platPartnerRealName == null ? null : platPartnerRealName.trim();
    }

    /**
     * 获取签约商结算账户
     *
     * @return partner_settlement_account - 签约商结算账户
     */
    public String getPartnerSettlementAccount() {
        return partnerSettlementAccount;
    }

    /**
     * 设置签约商结算账户
     *
     * @param partnerSettlementAccount 签约商结算账户
     */
    public void setPartnerSettlementAccount(String partnerSettlementAccount) {
        this.partnerSettlementAccount = partnerSettlementAccount == null ? null : partnerSettlementAccount.trim();
    }

    /**
     * 获取资金状态
     *
     * @return amount_status - 资金状态
     */
    public String getAmountStatus() {
        return amountStatus;
    }

    /**
     * 设置资金状态
     *
     * @param amountStatus 资金状态
     */
    public void setAmountStatus(String amountStatus) {
        this.amountStatus = amountStatus == null ? null : amountStatus.trim();
    }

    /**
     * 获取转账清分金额资金状态
     *
     * @return trans_clear_amount_status - 转账清分金额资金状态
     */
    public String getTransClearAmountStatus() {
        return transClearAmountStatus;
    }

    /**
     * 设置转账清分金额资金状态
     *
     * @param transClearAmountStatus 转账清分金额资金状态
     */
    public void setTransClearAmountStatus(String transClearAmountStatus) {
        this.transClearAmountStatus = transClearAmountStatus == null ? null : transClearAmountStatus.trim();
    }

    /**
     * 获取下载手续费资金状态
     *
     * @return down_fee_amount_status - 下载手续费资金状态
     */
    public String getDownFeeAmountStatus() {
        return downFeeAmountStatus;
    }

    /**
     * 设置下载手续费资金状态
     *
     * @param downFeeAmountStatus 下载手续费资金状态
     */
    public void setDownFeeAmountStatus(String downFeeAmountStatus) {
        this.downFeeAmountStatus = downFeeAmountStatus == null ? null : downFeeAmountStatus.trim();
    }

    /**
     * 获取清分结果文件名
     *
     * @return clear_result_file_name - 清分结果文件名
     */
    public String getClearResultFileName() {
        return clearResultFileName;
    }

    /**
     * 设置清分结果文件名
     *
     * @param clearResultFileName 清分结果文件名
     */
    public void setClearResultFileName(String clearResultFileName) {
        this.clearResultFileName = clearResultFileName == null ? null : clearResultFileName.trim();
    }

    /**
     * 获取渠道平台账户
     *
     * @return channel_merchant_id - 渠道平台账户
     */
    public String getChannelMerchantId() {
        return channelMerchantId;
    }

    /**
     * 设置渠道平台账户
     *
     * @param channelMerchantId 渠道平台账户
     */
    public void setChannelMerchantId(String channelMerchantId) {
        this.channelMerchantId = channelMerchantId == null ? null : channelMerchantId.trim();
    }

    /**
     * 获取渠道子商户id
     *
     * @return channel_sub_merchant_id - 渠道子商户id
     */
    public String getChannelSubMerchantId() {
        return channelSubMerchantId;
    }

    /**
     * 设置渠道子商户id
     *
     * @param channelSubMerchantId 渠道子商户id
     */
    public void setChannelSubMerchantId(String channelSubMerchantId) {
        this.channelSubMerchantId = channelSubMerchantId == null ? null : channelSubMerchantId.trim();
    }

    /**
     * 获取渠道子商户名称
     *
     * @return channel_sub_merchant_name - 渠道子商户名称
     */
    public String getChannelSubMerchantName() {
        return channelSubMerchantName;
    }

    /**
     * 设置渠道子商户名称
     *
     * @param channelSubMerchantName 渠道子商户名称
     */
    public void setChannelSubMerchantName(String channelSubMerchantName) {
        this.channelSubMerchantName = channelSubMerchantName == null ? null : channelSubMerchantName.trim();
    }

    /**
     * 获取清分日期
     *
     * @return clear_date - 清分日期
     */
    public String getClearDate() {
        return clearDate;
    }

    /**
     * 设置清分日期
     *
     * @param clearDate 清分日期
     */
    public void setClearDate(String clearDate) {
        this.clearDate = clearDate == null ? null : clearDate.trim();
    }

    /**
     * 获取清分批次号
     *
     * @return batch_no - 清分批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置清分批次号
     *
     * @param batchNo 清分批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * 获取清分类型
     *
     * @return clear_type - 清分类型
     */
    public String getClearType() {
        return clearType;
    }

    /**
     * 设置清分类型
     *
     * @param clearType 清分类型
     */
    public void setClearType(String clearType) {
        this.clearType = clearType == null ? null : clearType.trim();
    }

    /**
     * 获取交易金额
     *
     * @return trade_amount - 交易金额
     */
    public Long getTradeAmount() {
        return tradeAmount;
    }

    /**
     * 设置交易金额
     *
     * @param tradeAmount 交易金额
     */
    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * 获取交易笔数
     *
     * @return trade_count - 交易笔数
     */
    public Integer getTradeCount() {
        return tradeCount;
    }

    /**
     * 设置交易笔数
     *
     * @param tradeCount 交易笔数
     */
    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    /**
     * 获取子商户结算账户
     *
     * @return settlement_sub_merchant_id - 子商户结算账户
     */
    public String getSettlementSubMerchantId() {
        return settlementSubMerchantId;
    }

    /**
     * 设置子商户结算账户
     *
     * @param settlementSubMerchantId 子商户结算账户
     */
    public void setSettlementSubMerchantId(String settlementSubMerchantId) {
        this.settlementSubMerchantId = settlementSubMerchantId == null ? null : settlementSubMerchantId.trim();
    }

    /**
     * 获取子商户结算商户名称
     *
     * @return settlement_sub_merchant_name - 子商户结算商户名称
     */
    public String getSettlementSubMerchantName() {
        return settlementSubMerchantName;
    }

    /**
     * 设置子商户结算商户名称
     *
     * @param settlementSubMerchantName 子商户结算商户名称
     */
    public void setSettlementSubMerchantName(String settlementSubMerchantName) {
        this.settlementSubMerchantName = settlementSubMerchantName == null ? null : settlementSubMerchantName.trim();
    }

    /**
     * 获取清分金额
     *
     * @return clear_amount - 清分金额
     */
    public Long getClearAmount() {
        return clearAmount;
    }

    /**
     * 设置清分金额
     *
     * @param clearAmount 清分金额
     */
    public void setClearAmount(Long clearAmount) {
        this.clearAmount = clearAmount;
    }

    /**
     * 获取平台优惠金额
     *
     * @return plat_coupon_amount - 平台优惠金额
     */
    public Long getPlatCouponAmount() {
        return platCouponAmount;
    }

    /**
     * 设置平台优惠金额
     *
     * @param platCouponAmount 平台优惠金额
     */
    public void setPlatCouponAmount(Long platCouponAmount) {
        this.platCouponAmount = platCouponAmount;
    }

    /**
     * 获取平台垫付金额
     *
     * @return advance_amount - 平台垫付金额
     */
    public Long getAdvanceAmount() {
        return advanceAmount;
    }

    /**
     * 设置平台垫付金额
     *
     * @param advanceAmount 平台垫付金额
     */
    public void setAdvanceAmount(Long advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    /**
     * 获取平台分成金额
     *
     * @return plat_share_amount - 平台分成金额
     */
    public Long getPlatShareAmount() {
        return platShareAmount;
    }

    /**
     * 设置平台分成金额
     *
     * @param platShareAmount 平台分成金额
     */
    public void setPlatShareAmount(Long platShareAmount) {
        this.platShareAmount = platShareAmount;
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
     * 获取清分状态
     *
     * @return clear_status - 清分状态
     */
    public String getClearStatus() {
        return clearStatus;
    }

    /**
     * 设置清分状态
     *
     * @param clearStatus 清分状态
     */
    public void setClearStatus(String clearStatus) {
        this.clearStatus = clearStatus == null ? null : clearStatus.trim();
    }

    /**
     * 获取备注
     *
     * @return comment - 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置备注
     *
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * @return raw_add_time
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * @param rawAddTime
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * @return raw_update_time
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * @param rawUpdateTime
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
        sb.append(", gid=").append(gid);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platPartnerRealName=").append(platPartnerRealName);
        sb.append(", partnerSettlementAccount=").append(partnerSettlementAccount);
        sb.append(", amountStatus=").append(amountStatus);
        sb.append(", transClearAmountStatus=").append(transClearAmountStatus);
        sb.append(", downFeeAmountStatus=").append(downFeeAmountStatus);
        sb.append(", clearResultFileName=").append(clearResultFileName);
        sb.append(", channelMerchantId=").append(channelMerchantId);
        sb.append(", channelSubMerchantId=").append(channelSubMerchantId);
        sb.append(", channelSubMerchantName=").append(channelSubMerchantName);
        sb.append(", clearDate=").append(clearDate);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", clearType=").append(clearType);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", tradeCount=").append(tradeCount);
        sb.append(", settlementSubMerchantId=").append(settlementSubMerchantId);
        sb.append(", settlementSubMerchantName=").append(settlementSubMerchantName);
        sb.append(", clearAmount=").append(clearAmount);
        sb.append(", platCouponAmount=").append(platCouponAmount);
        sb.append(", advanceAmount=").append(advanceAmount);
        sb.append(", platShareAmount=").append(platShareAmount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", clearStatus=").append(clearStatus);
        sb.append(", comment=").append(comment);
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
        ClearDsgjResultLogDO other = (ClearDsgjResultLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatPartnerRealName() == null ? other.getPlatPartnerRealName() == null : this.getPlatPartnerRealName().equals(other.getPlatPartnerRealName()))
            && (this.getPartnerSettlementAccount() == null ? other.getPartnerSettlementAccount() == null : this.getPartnerSettlementAccount().equals(other.getPartnerSettlementAccount()))
            && (this.getAmountStatus() == null ? other.getAmountStatus() == null : this.getAmountStatus().equals(other.getAmountStatus()))
            && (this.getTransClearAmountStatus() == null ? other.getTransClearAmountStatus() == null : this.getTransClearAmountStatus().equals(other.getTransClearAmountStatus()))
            && (this.getDownFeeAmountStatus() == null ? other.getDownFeeAmountStatus() == null : this.getDownFeeAmountStatus().equals(other.getDownFeeAmountStatus()))
            && (this.getClearResultFileName() == null ? other.getClearResultFileName() == null : this.getClearResultFileName().equals(other.getClearResultFileName()))
            && (this.getChannelMerchantId() == null ? other.getChannelMerchantId() == null : this.getChannelMerchantId().equals(other.getChannelMerchantId()))
            && (this.getChannelSubMerchantId() == null ? other.getChannelSubMerchantId() == null : this.getChannelSubMerchantId().equals(other.getChannelSubMerchantId()))
            && (this.getChannelSubMerchantName() == null ? other.getChannelSubMerchantName() == null : this.getChannelSubMerchantName().equals(other.getChannelSubMerchantName()))
            && (this.getClearDate() == null ? other.getClearDate() == null : this.getClearDate().equals(other.getClearDate()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getClearType() == null ? other.getClearType() == null : this.getClearType().equals(other.getClearType()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getTradeCount() == null ? other.getTradeCount() == null : this.getTradeCount().equals(other.getTradeCount()))
            && (this.getSettlementSubMerchantId() == null ? other.getSettlementSubMerchantId() == null : this.getSettlementSubMerchantId().equals(other.getSettlementSubMerchantId()))
            && (this.getSettlementSubMerchantName() == null ? other.getSettlementSubMerchantName() == null : this.getSettlementSubMerchantName().equals(other.getSettlementSubMerchantName()))
            && (this.getClearAmount() == null ? other.getClearAmount() == null : this.getClearAmount().equals(other.getClearAmount()))
            && (this.getPlatCouponAmount() == null ? other.getPlatCouponAmount() == null : this.getPlatCouponAmount().equals(other.getPlatCouponAmount()))
            && (this.getAdvanceAmount() == null ? other.getAdvanceAmount() == null : this.getAdvanceAmount().equals(other.getAdvanceAmount()))
            && (this.getPlatShareAmount() == null ? other.getPlatShareAmount() == null : this.getPlatShareAmount().equals(other.getPlatShareAmount()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getClearStatus() == null ? other.getClearStatus() == null : this.getClearStatus().equals(other.getClearStatus()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerRealName() == null) ? 0 : getPlatPartnerRealName().hashCode());
        result = prime * result + ((getPartnerSettlementAccount() == null) ? 0 : getPartnerSettlementAccount().hashCode());
        result = prime * result + ((getAmountStatus() == null) ? 0 : getAmountStatus().hashCode());
        result = prime * result + ((getTransClearAmountStatus() == null) ? 0 : getTransClearAmountStatus().hashCode());
        result = prime * result + ((getDownFeeAmountStatus() == null) ? 0 : getDownFeeAmountStatus().hashCode());
        result = prime * result + ((getClearResultFileName() == null) ? 0 : getClearResultFileName().hashCode());
        result = prime * result + ((getChannelMerchantId() == null) ? 0 : getChannelMerchantId().hashCode());
        result = prime * result + ((getChannelSubMerchantId() == null) ? 0 : getChannelSubMerchantId().hashCode());
        result = prime * result + ((getChannelSubMerchantName() == null) ? 0 : getChannelSubMerchantName().hashCode());
        result = prime * result + ((getClearDate() == null) ? 0 : getClearDate().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getClearType() == null) ? 0 : getClearType().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getTradeCount() == null) ? 0 : getTradeCount().hashCode());
        result = prime * result + ((getSettlementSubMerchantId() == null) ? 0 : getSettlementSubMerchantId().hashCode());
        result = prime * result + ((getSettlementSubMerchantName() == null) ? 0 : getSettlementSubMerchantName().hashCode());
        result = prime * result + ((getClearAmount() == null) ? 0 : getClearAmount().hashCode());
        result = prime * result + ((getPlatCouponAmount() == null) ? 0 : getPlatCouponAmount().hashCode());
        result = prime * result + ((getAdvanceAmount() == null) ? 0 : getAdvanceAmount().hashCode());
        result = prime * result + ((getPlatShareAmount() == null) ? 0 : getPlatShareAmount().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getClearStatus() == null) ? 0 : getClearStatus().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}