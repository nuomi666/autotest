package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bill_task_conf")
public class BillTaskConfDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签约商户
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 签约商户真实姓名
     */
    @Column(name = "partner_real_name")
    private String partnerRealName;

    /**
     * 对账渠道数据获取执行时间
     */
    @Column(name = "bill_channel_time")
    private String billChannelTime;

    /**
     * 对账单生成执行时分秒格式HH:mm:ss
     */
    @Column(name = "bill_time")
    private String billTime;

    /**
     * 对账单生成周期，单位自然日
     */
    @Column(name = "bill_cycle")
    private Integer billCycle;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 启动状态Y/N
     */
    @Column(name = "use_status")
    private String useStatus;

    /**
     * 备注
     */
    private String memo;

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
     * 获取签约商户
     *
     * @return partner_id - 签约商户
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户
     *
     * @param partnerId 签约商户
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
     * 获取对账渠道数据获取执行时间
     *
     * @return bill_channel_time - 对账渠道数据获取执行时间
     */
    public String getBillChannelTime() {
        return billChannelTime;
    }

    /**
     * 设置对账渠道数据获取执行时间
     *
     * @param billChannelTime 对账渠道数据获取执行时间
     */
    public void setBillChannelTime(String billChannelTime) {
        this.billChannelTime = billChannelTime == null ? null : billChannelTime.trim();
    }

    /**
     * 获取对账单生成执行时分秒格式HH:mm:ss
     *
     * @return bill_time - 对账单生成执行时分秒格式HH:mm:ss
     */
    public String getBillTime() {
        return billTime;
    }

    /**
     * 设置对账单生成执行时分秒格式HH:mm:ss
     *
     * @param billTime 对账单生成执行时分秒格式HH:mm:ss
     */
    public void setBillTime(String billTime) {
        this.billTime = billTime == null ? null : billTime.trim();
    }

    /**
     * 获取对账单生成周期，单位自然日
     *
     * @return bill_cycle - 对账单生成周期，单位自然日
     */
    public Integer getBillCycle() {
        return billCycle;
    }

    /**
     * 设置对账单生成周期，单位自然日
     *
     * @param billCycle 对账单生成周期，单位自然日
     */
    public void setBillCycle(Integer billCycle) {
        this.billCycle = billCycle;
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
     * 获取启动状态Y/N
     *
     * @return use_status - 启动状态Y/N
     */
    public String getUseStatus() {
        return useStatus;
    }

    /**
     * 设置启动状态Y/N
     *
     * @param useStatus 启动状态Y/N
     */
    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus == null ? null : useStatus.trim();
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerRealName=").append(partnerRealName);
        sb.append(", billChannelTime=").append(billChannelTime);
        sb.append(", billTime=").append(billTime);
        sb.append(", billCycle=").append(billCycle);
        sb.append(", channelId=").append(channelId);
        sb.append(", useStatus=").append(useStatus);
        sb.append(", memo=").append(memo);
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
        BillTaskConfDO other = (BillTaskConfDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getBillChannelTime() == null ? other.getBillChannelTime() == null : this.getBillChannelTime().equals(other.getBillChannelTime()))
            && (this.getBillTime() == null ? other.getBillTime() == null : this.getBillTime().equals(other.getBillTime()))
            && (this.getBillCycle() == null ? other.getBillCycle() == null : this.getBillCycle().equals(other.getBillCycle()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getUseStatus() == null ? other.getUseStatus() == null : this.getUseStatus().equals(other.getUseStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerRealName() == null) ? 0 : getPartnerRealName().hashCode());
        result = prime * result + ((getBillChannelTime() == null) ? 0 : getBillChannelTime().hashCode());
        result = prime * result + ((getBillTime() == null) ? 0 : getBillTime().hashCode());
        result = prime * result + ((getBillCycle() == null) ? 0 : getBillCycle().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getUseStatus() == null) ? 0 : getUseStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}