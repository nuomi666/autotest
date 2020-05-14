package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "settlement_dsgj_task_log")
public class SettlementDsgjTaskLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 平台唯一流水
     */
    private String gid;

    /**
     * 业务编号
     */
    @Column(name = "biz_no")
    private String bizNo;

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
     * 结算日期
     */
    @Column(name = "settlement_date")
    private String settlementDate;

    /**
     * 结算批次文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 结算批次
     */
    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 结算总金额
     */
    @Column(name = "total_amount")
    private Long totalAmount;

    /**
     * 结算总笔数
     */
    @Column(name = "total_count")
    private Integer totalCount;

    /**
     * 失败总金额
     */
    @Column(name = "fail_amount")
    private Long failAmount;

    /**
     * 失败总笔数
     */
    @Column(name = "fail_count")
    private Integer failCount;

    /**
     * 退汇总结金额
     */
    @Column(name = "remittance_amount")
    private Long remittanceAmount;

    /**
     * 退汇总笔数
     */
    @Column(name = "remittance_count")
    private Integer remittanceCount;

    /**
     * 结算状态
     */
    @Column(name = "settlement_status")
    private String settlementStatus;

    /**
     * 结算结算时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 解散备注
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
     * 获取平台唯一流水
     *
     * @return gid - 平台唯一流水
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置平台唯一流水
     *
     * @param gid 平台唯一流水
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取业务编号
     *
     * @return biz_no - 业务编号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务编号
     *
     * @param bizNo 业务编号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
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
     * 获取结算日期
     *
     * @return settlement_date - 结算日期
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * 设置结算日期
     *
     * @param settlementDate 结算日期
     */
    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate == null ? null : settlementDate.trim();
    }

    /**
     * 获取结算批次文件名
     *
     * @return file_name - 结算批次文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置结算批次文件名
     *
     * @param fileName 结算批次文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 获取结算批次
     *
     * @return batch_no - 结算批次
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置结算批次
     *
     * @param batchNo 结算批次
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * 获取结算总金额
     *
     * @return total_amount - 结算总金额
     */
    public Long getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置结算总金额
     *
     * @param totalAmount 结算总金额
     */
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取结算总笔数
     *
     * @return total_count - 结算总笔数
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置结算总笔数
     *
     * @param totalCount 结算总笔数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取失败总金额
     *
     * @return fail_amount - 失败总金额
     */
    public Long getFailAmount() {
        return failAmount;
    }

    /**
     * 设置失败总金额
     *
     * @param failAmount 失败总金额
     */
    public void setFailAmount(Long failAmount) {
        this.failAmount = failAmount;
    }

    /**
     * 获取失败总笔数
     *
     * @return fail_count - 失败总笔数
     */
    public Integer getFailCount() {
        return failCount;
    }

    /**
     * 设置失败总笔数
     *
     * @param failCount 失败总笔数
     */
    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    /**
     * 获取退汇总结金额
     *
     * @return remittance_amount - 退汇总结金额
     */
    public Long getRemittanceAmount() {
        return remittanceAmount;
    }

    /**
     * 设置退汇总结金额
     *
     * @param remittanceAmount 退汇总结金额
     */
    public void setRemittanceAmount(Long remittanceAmount) {
        this.remittanceAmount = remittanceAmount;
    }

    /**
     * 获取退汇总笔数
     *
     * @return remittance_count - 退汇总笔数
     */
    public Integer getRemittanceCount() {
        return remittanceCount;
    }

    /**
     * 设置退汇总笔数
     *
     * @param remittanceCount 退汇总笔数
     */
    public void setRemittanceCount(Integer remittanceCount) {
        this.remittanceCount = remittanceCount;
    }

    /**
     * 获取结算状态
     *
     * @return settlement_status - 结算状态
     */
    public String getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * 设置结算状态
     *
     * @param settlementStatus 结算状态
     */
    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus == null ? null : settlementStatus.trim();
    }

    /**
     * 获取结算结算时间
     *
     * @return finish_time - 结算结算时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置结算结算时间
     *
     * @param finishTime 结算结算时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取解散备注
     *
     * @return comment - 解散备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置解散备注
     *
     * @param comment 解散备注
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platPartnerRealName=").append(platPartnerRealName);
        sb.append(", settlementDate=").append(settlementDate);
        sb.append(", fileName=").append(fileName);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", totalCount=").append(totalCount);
        sb.append(", failAmount=").append(failAmount);
        sb.append(", failCount=").append(failCount);
        sb.append(", remittanceAmount=").append(remittanceAmount);
        sb.append(", remittanceCount=").append(remittanceCount);
        sb.append(", settlementStatus=").append(settlementStatus);
        sb.append(", finishTime=").append(finishTime);
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
        SettlementDsgjTaskLogDO other = (SettlementDsgjTaskLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatPartnerRealName() == null ? other.getPlatPartnerRealName() == null : this.getPlatPartnerRealName().equals(other.getPlatPartnerRealName()))
            && (this.getSettlementDate() == null ? other.getSettlementDate() == null : this.getSettlementDate().equals(other.getSettlementDate()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getTotalCount() == null ? other.getTotalCount() == null : this.getTotalCount().equals(other.getTotalCount()))
            && (this.getFailAmount() == null ? other.getFailAmount() == null : this.getFailAmount().equals(other.getFailAmount()))
            && (this.getFailCount() == null ? other.getFailCount() == null : this.getFailCount().equals(other.getFailCount()))
            && (this.getRemittanceAmount() == null ? other.getRemittanceAmount() == null : this.getRemittanceAmount().equals(other.getRemittanceAmount()))
            && (this.getRemittanceCount() == null ? other.getRemittanceCount() == null : this.getRemittanceCount().equals(other.getRemittanceCount()))
            && (this.getSettlementStatus() == null ? other.getSettlementStatus() == null : this.getSettlementStatus().equals(other.getSettlementStatus()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
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
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerRealName() == null) ? 0 : getPlatPartnerRealName().hashCode());
        result = prime * result + ((getSettlementDate() == null) ? 0 : getSettlementDate().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getTotalCount() == null) ? 0 : getTotalCount().hashCode());
        result = prime * result + ((getFailAmount() == null) ? 0 : getFailAmount().hashCode());
        result = prime * result + ((getFailCount() == null) ? 0 : getFailCount().hashCode());
        result = prime * result + ((getRemittanceAmount() == null) ? 0 : getRemittanceAmount().hashCode());
        result = prime * result + ((getRemittanceCount() == null) ? 0 : getRemittanceCount().hashCode());
        result = prime * result + ((getSettlementStatus() == null) ? 0 : getSettlementStatus().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}