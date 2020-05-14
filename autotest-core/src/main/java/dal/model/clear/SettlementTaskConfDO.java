package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "settlement_task_conf")
public class SettlementTaskConfDO implements Serializable {
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
     * 清结算周期，单位自然日
     */
    @Column(name = "settlement_cycle")
    private Integer settlementCycle;

    /**
     * 是否清分Y/N
     */
    @Column(name = "is_clear")
    private String isClear;

    /**
     * 清分执行时间HH:mm:ss
     */
    @Column(name = "clear_time")
    private String clearTime;

    /**
     * 是否结算Y/N
     */
    @Column(name = "is_settlement")
    private String isSettlement;

    /**
     * 结算执行时HH:mm:ss
     */
    @Column(name = "settlement_time")
    private String settlementTime;

    /**
     * 结算方式
     */
    @Column(name = "settlement_type")
    private String settlementType;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 是否使用Y/N
     */
    @Column(name = "is_use")
    private String isUse;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
     */
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
     * 获取清结算周期，单位自然日
     *
     * @return settlement_cycle - 清结算周期，单位自然日
     */
    public Integer getSettlementCycle() {
        return settlementCycle;
    }

    /**
     * 设置清结算周期，单位自然日
     *
     * @param settlementCycle 清结算周期，单位自然日
     */
    public void setSettlementCycle(Integer settlementCycle) {
        this.settlementCycle = settlementCycle;
    }

    /**
     * 获取是否清分Y/N
     *
     * @return is_clear - 是否清分Y/N
     */
    public String getIsClear() {
        return isClear;
    }

    /**
     * 设置是否清分Y/N
     *
     * @param isClear 是否清分Y/N
     */
    public void setIsClear(String isClear) {
        this.isClear = isClear == null ? null : isClear.trim();
    }

    /**
     * 获取清分执行时间HH:mm:ss
     *
     * @return clear_time - 清分执行时间HH:mm:ss
     */
    public String getClearTime() {
        return clearTime;
    }

    /**
     * 设置清分执行时间HH:mm:ss
     *
     * @param clearTime 清分执行时间HH:mm:ss
     */
    public void setClearTime(String clearTime) {
        this.clearTime = clearTime == null ? null : clearTime.trim();
    }

    /**
     * 获取是否结算Y/N
     *
     * @return is_settlement - 是否结算Y/N
     */
    public String getIsSettlement() {
        return isSettlement;
    }

    /**
     * 设置是否结算Y/N
     *
     * @param isSettlement 是否结算Y/N
     */
    public void setIsSettlement(String isSettlement) {
        this.isSettlement = isSettlement == null ? null : isSettlement.trim();
    }

    /**
     * 获取结算执行时HH:mm:ss
     *
     * @return settlement_time - 结算执行时HH:mm:ss
     */
    public String getSettlementTime() {
        return settlementTime;
    }

    /**
     * 设置结算执行时HH:mm:ss
     *
     * @param settlementTime 结算执行时HH:mm:ss
     */
    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime == null ? null : settlementTime.trim();
    }

    /**
     * 获取结算方式
     *
     * @return settlement_type - 结算方式
     */
    public String getSettlementType() {
        return settlementType;
    }

    /**
     * 设置结算方式
     *
     * @param settlementType 结算方式
     */
    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType == null ? null : settlementType.trim();
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
     * 获取是否使用Y/N
     *
     * @return is_use - 是否使用Y/N
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * 设置是否使用Y/N
     *
     * @param isUse 是否使用Y/N
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
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
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
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
        sb.append(", settlementCycle=").append(settlementCycle);
        sb.append(", isClear=").append(isClear);
        sb.append(", clearTime=").append(clearTime);
        sb.append(", isSettlement=").append(isSettlement);
        sb.append(", settlementTime=").append(settlementTime);
        sb.append(", settlementType=").append(settlementType);
        sb.append(", channelId=").append(channelId);
        sb.append(", isUse=").append(isUse);
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
        SettlementTaskConfDO other = (SettlementTaskConfDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerRealName() == null ? other.getPartnerRealName() == null : this.getPartnerRealName().equals(other.getPartnerRealName()))
            && (this.getSettlementCycle() == null ? other.getSettlementCycle() == null : this.getSettlementCycle().equals(other.getSettlementCycle()))
            && (this.getIsClear() == null ? other.getIsClear() == null : this.getIsClear().equals(other.getIsClear()))
            && (this.getClearTime() == null ? other.getClearTime() == null : this.getClearTime().equals(other.getClearTime()))
            && (this.getIsSettlement() == null ? other.getIsSettlement() == null : this.getIsSettlement().equals(other.getIsSettlement()))
            && (this.getSettlementTime() == null ? other.getSettlementTime() == null : this.getSettlementTime().equals(other.getSettlementTime()))
            && (this.getSettlementType() == null ? other.getSettlementType() == null : this.getSettlementType().equals(other.getSettlementType()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getIsUse() == null ? other.getIsUse() == null : this.getIsUse().equals(other.getIsUse()))
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
        result = prime * result + ((getSettlementCycle() == null) ? 0 : getSettlementCycle().hashCode());
        result = prime * result + ((getIsClear() == null) ? 0 : getIsClear().hashCode());
        result = prime * result + ((getClearTime() == null) ? 0 : getClearTime().hashCode());
        result = prime * result + ((getIsSettlement() == null) ? 0 : getIsSettlement().hashCode());
        result = prime * result + ((getSettlementTime() == null) ? 0 : getSettlementTime().hashCode());
        result = prime * result + ((getSettlementType() == null) ? 0 : getSettlementType().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getIsUse() == null) ? 0 : getIsUse().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}