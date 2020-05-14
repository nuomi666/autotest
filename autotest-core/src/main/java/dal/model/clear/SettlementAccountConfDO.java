package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "settlement_account_conf")
public class SettlementAccountConfDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 结算方式
     */
    @Column(name = "settlement_type")
    private String settlementType;

    /**
     * 结算账号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 结算卡号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 结算名称
     */
    @Column(name = "settlement_name")
    private String settlementName;

    /**
     * 结算百分比
     */
    private Integer rate;

    /**
     * 创建时间
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
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
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
     * 获取结算账号
     *
     * @return account_no - 结算账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置结算账号
     *
     * @param accountNo 结算账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取结算卡号
     *
     * @return card_no - 结算卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置结算卡号
     *
     * @param cardNo 结算卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取结算名称
     *
     * @return settlement_name - 结算名称
     */
    public String getSettlementName() {
        return settlementName;
    }

    /**
     * 设置结算名称
     *
     * @param settlementName 结算名称
     */
    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName == null ? null : settlementName.trim();
    }

    /**
     * 获取结算百分比
     *
     * @return rate - 结算百分比
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * 设置结算百分比
     *
     * @param rate 结算百分比
     */
    public void setRate(Integer rate) {
        this.rate = rate;
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", channelId=").append(channelId);
        sb.append(", settlementType=").append(settlementType);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", settlementName=").append(settlementName);
        sb.append(", rate=").append(rate);
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
        SettlementAccountConfDO other = (SettlementAccountConfDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getSettlementType() == null ? other.getSettlementType() == null : this.getSettlementType().equals(other.getSettlementType()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getSettlementName() == null ? other.getSettlementName() == null : this.getSettlementName().equals(other.getSettlementName()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getSettlementType() == null) ? 0 : getSettlementType().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getSettlementName() == null) ? 0 : getSettlementName().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}