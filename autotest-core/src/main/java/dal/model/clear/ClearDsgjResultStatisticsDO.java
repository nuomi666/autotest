package dal.model.clear;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_dsgj_result_statistics")
public class ClearDsgjResultStatisticsDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 清分结果文件名
     */
    @Column(name = "clear_result_file_name")
    private String clearResultFileName;

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
     * 总交易净额
     */
    @Column(name = "trade_amount")
    private Long tradeAmount;

    /**
     * 交易笔总数
     */
    @Column(name = "trade_count")
    private Integer tradeCount;

    /**
     * 原始订单金额
     */
    @Column(name = "order_amount")
    private Long orderAmount;

    /**
     * 原始支付总金额
     */
    @Column(name = "payment_amount")
    private Long paymentAmount;

    /**
     * 平台优惠金额
     */
    @Column(name = "coupon_amount")
    private Long couponAmount;

    /**
     * 平台分成金额
     */
    @Column(name = "share_amount")
    private Long shareAmount;

    /**
     * 平台垫付金额
     */
    @Column(name = "advance_amount")
    private Long advanceAmount;

    /**
     * 手续费金额
     */
    @Column(name = "fee_amount")
    private Long feeAmount;

    /**
     * 文件状态
     */
    @Column(name = "file_status")
    private String fileStatus;

    /**
     * 清分状态
     */
    @Column(name = "clear_status")
    private String clearStatus;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 平台承担手续费
     */
    @Column(name = "plat_fee_amount")
    private byte[] platFeeAmount;

    /**
     * 备注
     */
    private String comment;

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
     * 获取总交易净额
     *
     * @return trade_amount - 总交易净额
     */
    public Long getTradeAmount() {
        return tradeAmount;
    }

    /**
     * 设置总交易净额
     *
     * @param tradeAmount 总交易净额
     */
    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * 获取交易笔总数
     *
     * @return trade_count - 交易笔总数
     */
    public Integer getTradeCount() {
        return tradeCount;
    }

    /**
     * 设置交易笔总数
     *
     * @param tradeCount 交易笔总数
     */
    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    /**
     * 获取原始订单金额
     *
     * @return order_amount - 原始订单金额
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置原始订单金额
     *
     * @param orderAmount 原始订单金额
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取原始支付总金额
     *
     * @return payment_amount - 原始支付总金额
     */
    public Long getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * 设置原始支付总金额
     *
     * @param paymentAmount 原始支付总金额
     */
    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * 获取平台优惠金额
     *
     * @return coupon_amount - 平台优惠金额
     */
    public Long getCouponAmount() {
        return couponAmount;
    }

    /**
     * 设置平台优惠金额
     *
     * @param couponAmount 平台优惠金额
     */
    public void setCouponAmount(Long couponAmount) {
        this.couponAmount = couponAmount;
    }

    /**
     * 获取平台分成金额
     *
     * @return share_amount - 平台分成金额
     */
    public Long getShareAmount() {
        return shareAmount;
    }

    /**
     * 设置平台分成金额
     *
     * @param shareAmount 平台分成金额
     */
    public void setShareAmount(Long shareAmount) {
        this.shareAmount = shareAmount;
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
     * 获取文件状态
     *
     * @return file_status - 文件状态
     */
    public String getFileStatus() {
        return fileStatus;
    }

    /**
     * 设置文件状态
     *
     * @param fileStatus 文件状态
     */
    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus == null ? null : fileStatus.trim();
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

    /**
     * 获取平台承担手续费
     *
     * @return plat_fee_amount - 平台承担手续费
     */
    public byte[] getPlatFeeAmount() {
        return platFeeAmount;
    }

    /**
     * 设置平台承担手续费
     *
     * @param platFeeAmount 平台承担手续费
     */
    public void setPlatFeeAmount(byte[] platFeeAmount) {
        this.platFeeAmount = platFeeAmount;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platPartnerRealName=").append(platPartnerRealName);
        sb.append(", clearResultFileName=").append(clearResultFileName);
        sb.append(", clearDate=").append(clearDate);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", tradeCount=").append(tradeCount);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", shareAmount=").append(shareAmount);
        sb.append(", advanceAmount=").append(advanceAmount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", fileStatus=").append(fileStatus);
        sb.append(", clearStatus=").append(clearStatus);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", platFeeAmount=").append(platFeeAmount);
        sb.append(", comment=").append(comment);
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
        ClearDsgjResultStatisticsDO other = (ClearDsgjResultStatisticsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatPartnerRealName() == null ? other.getPlatPartnerRealName() == null : this.getPlatPartnerRealName().equals(other.getPlatPartnerRealName()))
            && (this.getClearResultFileName() == null ? other.getClearResultFileName() == null : this.getClearResultFileName().equals(other.getClearResultFileName()))
            && (this.getClearDate() == null ? other.getClearDate() == null : this.getClearDate().equals(other.getClearDate()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getTradeCount() == null ? other.getTradeCount() == null : this.getTradeCount().equals(other.getTradeCount()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getPaymentAmount() == null ? other.getPaymentAmount() == null : this.getPaymentAmount().equals(other.getPaymentAmount()))
            && (this.getCouponAmount() == null ? other.getCouponAmount() == null : this.getCouponAmount().equals(other.getCouponAmount()))
            && (this.getShareAmount() == null ? other.getShareAmount() == null : this.getShareAmount().equals(other.getShareAmount()))
            && (this.getAdvanceAmount() == null ? other.getAdvanceAmount() == null : this.getAdvanceAmount().equals(other.getAdvanceAmount()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getFileStatus() == null ? other.getFileStatus() == null : this.getFileStatus().equals(other.getFileStatus()))
            && (this.getClearStatus() == null ? other.getClearStatus() == null : this.getClearStatus().equals(other.getClearStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (Arrays.equals(this.getPlatFeeAmount(), other.getPlatFeeAmount()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerRealName() == null) ? 0 : getPlatPartnerRealName().hashCode());
        result = prime * result + ((getClearResultFileName() == null) ? 0 : getClearResultFileName().hashCode());
        result = prime * result + ((getClearDate() == null) ? 0 : getClearDate().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getTradeCount() == null) ? 0 : getTradeCount().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getPaymentAmount() == null) ? 0 : getPaymentAmount().hashCode());
        result = prime * result + ((getCouponAmount() == null) ? 0 : getCouponAmount().hashCode());
        result = prime * result + ((getShareAmount() == null) ? 0 : getShareAmount().hashCode());
        result = prime * result + ((getAdvanceAmount() == null) ? 0 : getAdvanceAmount().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getFileStatus() == null) ? 0 : getFileStatus().hashCode());
        result = prime * result + ((getClearStatus() == null) ? 0 : getClearStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + (Arrays.hashCode(getPlatFeeAmount()));
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        return result;
    }
}