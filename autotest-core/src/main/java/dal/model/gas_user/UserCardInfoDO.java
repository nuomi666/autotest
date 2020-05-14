package dal.model.gas_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_card_info")
public class UserCardInfoDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 清洁算会员id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 卡号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 实体卡内码
     */
    @Column(name = "internal_no")
    private String internalNo;

    /**
     * 车队卡主卡资金账号
     */
    @Column(name = "parent_card_account_no")
    private String parentCardAccountNo;

    /**
     * 卡类型
     */
    @Column(name = "card_type")
    private String cardType;

    /**
     * 卡的业务类型
     */
    private String tag;

    /**
     * 清洁算资金账号tag
     */
    @Column(name = "account_tag")
    private String accountTag;

    /**
     * 资金账号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 卡状态
     */
    private String status;

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
     * 获取清洁算会员id
     *
     * @return user_id - 清洁算会员id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置清洁算会员id
     *
     * @param userId 清洁算会员id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 获取平台商ID
     *
     * @return plat_partner_id - 平台商ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商ID
     *
     * @param platPartnerId 平台商ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取卡号
     *
     * @return card_no - 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置卡号
     *
     * @param cardNo 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取实体卡内码
     *
     * @return internal_no - 实体卡内码
     */
    public String getInternalNo() {
        return internalNo;
    }

    /**
     * 设置实体卡内码
     *
     * @param internalNo 实体卡内码
     */
    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo == null ? null : internalNo.trim();
    }

    /**
     * 获取车队卡主卡资金账号
     *
     * @return parent_card_account_no - 车队卡主卡资金账号
     */
    public String getParentCardAccountNo() {
        return parentCardAccountNo;
    }

    /**
     * 设置车队卡主卡资金账号
     *
     * @param parentCardAccountNo 车队卡主卡资金账号
     */
    public void setParentCardAccountNo(String parentCardAccountNo) {
        this.parentCardAccountNo = parentCardAccountNo == null ? null : parentCardAccountNo.trim();
    }

    /**
     * 获取卡类型
     *
     * @return card_type - 卡类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 设置卡类型
     *
     * @param cardType 卡类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 获取卡的业务类型
     *
     * @return tag - 卡的业务类型
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置卡的业务类型
     *
     * @param tag 卡的业务类型
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * 获取清洁算资金账号tag
     *
     * @return account_tag - 清洁算资金账号tag
     */
    public String getAccountTag() {
        return accountTag;
    }

    /**
     * 设置清洁算资金账号tag
     *
     * @param accountTag 清洁算资金账号tag
     */
    public void setAccountTag(String accountTag) {
        this.accountTag = accountTag == null ? null : accountTag.trim();
    }

    /**
     * 获取资金账号
     *
     * @return account_no - 资金账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置资金账号
     *
     * @param accountNo 资金账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取卡状态
     *
     * @return status - 卡状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置卡状态
     *
     * @param status 卡状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", internalNo=").append(internalNo);
        sb.append(", parentCardAccountNo=").append(parentCardAccountNo);
        sb.append(", cardType=").append(cardType);
        sb.append(", tag=").append(tag);
        sb.append(", accountTag=").append(accountTag);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", status=").append(status);
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
        UserCardInfoDO other = (UserCardInfoDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getInternalNo() == null ? other.getInternalNo() == null : this.getInternalNo().equals(other.getInternalNo()))
            && (this.getParentCardAccountNo() == null ? other.getParentCardAccountNo() == null : this.getParentCardAccountNo().equals(other.getParentCardAccountNo()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getAccountTag() == null ? other.getAccountTag() == null : this.getAccountTag().equals(other.getAccountTag()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getInternalNo() == null) ? 0 : getInternalNo().hashCode());
        result = prime * result + ((getParentCardAccountNo() == null) ? 0 : getParentCardAccountNo().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getAccountTag() == null) ? 0 : getAccountTag().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}