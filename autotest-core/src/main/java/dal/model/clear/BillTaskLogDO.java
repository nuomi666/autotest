package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bill_task_log")
public class BillTaskLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 批次号
     */
    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 签约商户真实姓名
     */
    @Column(name = "partner_real_name")
    private String partnerRealName;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 账期yyyyMMdd
     */
    @Column(name = "bill_date")
    private String billDate;

    /**
     * 对账渠道数据获取时间
     */
    @Column(name = "bill_channel_time")
    private Date billChannelTime;

    /**
     * 渠道数据获取状态：INIT,SUCCESS,FAIL
     */
    @Column(name = "channel_status")
    private String channelStatus;

    /**
     * 渠道处理信息
     */
    @Column(name = "channel_comment")
    private String channelComment;

    /**
     * 对账单生成时间
     */
    @Column(name = "bill_time")
    private Date billTime;

    /**
     * 对账单生成状态：INIT,SUCCESS,FAIL
     */
    @Column(name = "bill_status")
    private String billStatus;

    /**
     * 对账处理信息
     */
    @Column(name = "bill_comment")
    private String billComment;

    /**
     * 对账单文件生成状态
     */
    @Column(name = "bill_file_status")
    private String billFileStatus;

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
     * 获取批次号
     *
     * @return batch_no - 批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置批次号
     *
     * @param batchNo 批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
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
     * 获取签约商户真实姓名
     *
     * @return partner_real_name - 签约商户真实姓名
     */
    public String getPartnerRealName() {
        return partnerRealName;
    }

    /**
     * 设置签约商户真实姓名
     *
     * @param partnerRealName 签约商户真实姓名
     */
    public void setPartnerRealName(String partnerRealName) {
        this.partnerRealName = partnerRealName == null ? null : partnerRealName.trim();
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
     * 获取账期yyyyMMdd
     *
     * @return bill_date - 账期yyyyMMdd
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * 设置账期yyyyMMdd
     *
     * @param billDate 账期yyyyMMdd
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    /**
     * 获取对账渠道数据获取时间
     *
     * @return bill_channel_time - 对账渠道数据获取时间
     */
    public Date getBillChannelTime() {
        return billChannelTime;
    }

    /**
     * 设置对账渠道数据获取时间
     *
     * @param billChannelTime 对账渠道数据获取时间
     */
    public void setBillChannelTime(Date billChannelTime) {
        this.billChannelTime = billChannelTime;
    }

    /**
     * 获取渠道数据获取状态：INIT,SUCCESS,FAIL
     *
     * @return channel_status - 渠道数据获取状态：INIT,SUCCESS,FAIL
     */
    public String getChannelStatus() {
        return channelStatus;
    }

    /**
     * 设置渠道数据获取状态：INIT,SUCCESS,FAIL
     *
     * @param channelStatus 渠道数据获取状态：INIT,SUCCESS,FAIL
     */
    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus == null ? null : channelStatus.trim();
    }

    /**
     * 获取渠道处理信息
     *
     * @return channel_comment - 渠道处理信息
     */
    public String getChannelComment() {
        return channelComment;
    }

    /**
     * 设置渠道处理信息
     *
     * @param channelComment 渠道处理信息
     */
    public void setChannelComment(String channelComment) {
        this.channelComment = channelComment == null ? null : channelComment.trim();
    }

    /**
     * 获取对账单生成时间
     *
     * @return bill_time - 对账单生成时间
     */
    public Date getBillTime() {
        return billTime;
    }

    /**
     * 设置对账单生成时间
     *
     * @param billTime 对账单生成时间
     */
    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    /**
     * 获取对账单生成状态：INIT,SUCCESS,FAIL
     *
     * @return bill_status - 对账单生成状态：INIT,SUCCESS,FAIL
     */
    public String getBillStatus() {
        return billStatus;
    }

    /**
     * 设置对账单生成状态：INIT,SUCCESS,FAIL
     *
     * @param billStatus 对账单生成状态：INIT,SUCCESS,FAIL
     */
    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    /**
     * 获取对账处理信息
     *
     * @return bill_comment - 对账处理信息
     */
    public String getBillComment() {
        return billComment;
    }

    /**
     * 设置对账处理信息
     *
     * @param billComment 对账处理信息
     */
    public void setBillComment(String billComment) {
        this.billComment = billComment == null ? null : billComment.trim();
    }

    /**
     * 获取对账单文件生成状态
     *
     * @return bill_file_status - 对账单文件生成状态
     */
    public String getBillFileStatus() {
        return billFileStatus;
    }

    /**
     * 设置对账单文件生成状态
     *
     * @param billFileStatus 对账单文件生成状态
     */
    public void setBillFileStatus(String billFileStatus) {
        this.billFileStatus = billFileStatus == null ? null : billFileStatus.trim();
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
        sb.append(", batchNo=").append(batchNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerRealName=").append(partnerRealName);
        sb.append(", channelId=").append(channelId);
        sb.append(", billDate=").append(billDate);
        sb.append(", billChannelTime=").append(billChannelTime);
        sb.append(", channelStatus=").append(channelStatus);
        sb.append(", channelComment=").append(channelComment);
        sb.append(", billTime=").append(billTime);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", billComment=").append(billComment);
        sb.append(", billFileStatus=").append(billFileStatus);
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
        BillTaskLogDO other = (BillTaskLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getBillChannelTime() == null ? other.getBillChannelTime() == null : this.getBillChannelTime().equals(other.getBillChannelTime()))
            && (this.getChannelStatus() == null ? other.getChannelStatus() == null : this.getChannelStatus().equals(other.getChannelStatus()))
            && (this.getChannelComment() == null ? other.getChannelComment() == null : this.getChannelComment().equals(other.getChannelComment()))
            && (this.getBillTime() == null ? other.getBillTime() == null : this.getBillTime().equals(other.getBillTime()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getBillComment() == null ? other.getBillComment() == null : this.getBillComment().equals(other.getBillComment()))
            && (this.getBillFileStatus() == null ? other.getBillFileStatus() == null : this.getBillFileStatus().equals(other.getBillFileStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerRealName() == null) ? 0 : getPartnerRealName().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getBillChannelTime() == null) ? 0 : getBillChannelTime().hashCode());
        result = prime * result + ((getChannelStatus() == null) ? 0 : getChannelStatus().hashCode());
        result = prime * result + ((getChannelComment() == null) ? 0 : getChannelComment().hashCode());
        result = prime * result + ((getBillTime() == null) ? 0 : getBillTime().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getBillComment() == null) ? 0 : getBillComment().hashCode());
        result = prime * result + ((getBillFileStatus() == null) ? 0 : getBillFileStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}