package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_card")
public class GasMerchantCardDO implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 卡主体
     */
    @Column(name = "card_object_id")
    private String cardObjectId;

    /**
     * 卡类型
     */
    @Column(name = "card_type")
    private String cardType;

    /**
     * 卡类别
     */
    private String tag;

    /**
     * 母卡号
     */
    @Column(name = "parent_card_no")
    private String parentCardNo;

    /**
     * 卡面号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 内卡号
     */
    @Column(name = "internal_no")
    private String internalNo;

    /**
     * 制卡规则ID
     */
    @Column(name = "card_rule_id")
    private Long cardRuleId;

    /**
     * 操作员账号
     */
    @Column(name = "operator_account")
    private String operatorAccount;

    /**
     * 新增时间
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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return partner_id - 商家ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商家ID
     *
     * @param partnerId 商家ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * @return plat_partner_id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * @param platPartnerId
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取卡主体
     *
     * @return card_object_id - 卡主体
     */
    public String getCardObjectId() {
        return cardObjectId;
    }

    /**
     * 设置卡主体
     *
     * @param cardObjectId 卡主体
     */
    public void setCardObjectId(String cardObjectId) {
        this.cardObjectId = cardObjectId == null ? null : cardObjectId.trim();
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
     * 获取卡类别
     *
     * @return tag - 卡类别
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置卡类别
     *
     * @param tag 卡类别
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * 获取母卡号
     *
     * @return parent_card_no - 母卡号
     */
    public String getParentCardNo() {
        return parentCardNo;
    }

    /**
     * 设置母卡号
     *
     * @param parentCardNo 母卡号
     */
    public void setParentCardNo(String parentCardNo) {
        this.parentCardNo = parentCardNo == null ? null : parentCardNo.trim();
    }

    /**
     * 获取卡面号
     *
     * @return card_no - 卡面号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置卡面号
     *
     * @param cardNo 卡面号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取内卡号
     *
     * @return internal_no - 内卡号
     */
    public String getInternalNo() {
        return internalNo;
    }

    /**
     * 设置内卡号
     *
     * @param internalNo 内卡号
     */
    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo == null ? null : internalNo.trim();
    }

    /**
     * 获取制卡规则ID
     *
     * @return card_rule_id - 制卡规则ID
     */
    public Long getCardRuleId() {
        return cardRuleId;
    }

    /**
     * 设置制卡规则ID
     *
     * @param cardRuleId 制卡规则ID
     */
    public void setCardRuleId(Long cardRuleId) {
        this.cardRuleId = cardRuleId;
    }

    /**
     * 获取操作员账号
     *
     * @return operator_account - 操作员账号
     */
    public String getOperatorAccount() {
        return operatorAccount;
    }

    /**
     * 设置操作员账号
     *
     * @param operatorAccount 操作员账号
     */
    public void setOperatorAccount(String operatorAccount) {
        this.operatorAccount = operatorAccount == null ? null : operatorAccount.trim();
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", cardObjectId=").append(cardObjectId);
        sb.append(", cardType=").append(cardType);
        sb.append(", tag=").append(tag);
        sb.append(", parentCardNo=").append(parentCardNo);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", internalNo=").append(internalNo);
        sb.append(", cardRuleId=").append(cardRuleId);
        sb.append(", operatorAccount=").append(operatorAccount);
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
        GasMerchantCardDO other = (GasMerchantCardDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getCardObjectId() == null ? other.getCardObjectId() == null : this.getCardObjectId().equals(other.getCardObjectId()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getParentCardNo() == null ? other.getParentCardNo() == null : this.getParentCardNo().equals(other.getParentCardNo()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getInternalNo() == null ? other.getInternalNo() == null : this.getInternalNo().equals(other.getInternalNo()))
            && (this.getCardRuleId() == null ? other.getCardRuleId() == null : this.getCardRuleId().equals(other.getCardRuleId()))
            && (this.getOperatorAccount() == null ? other.getOperatorAccount() == null : this.getOperatorAccount().equals(other.getOperatorAccount()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getCardObjectId() == null) ? 0 : getCardObjectId().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getParentCardNo() == null) ? 0 : getParentCardNo().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getInternalNo() == null) ? 0 : getInternalNo().hashCode());
        result = prime * result + ((getCardRuleId() == null) ? 0 : getCardRuleId().hashCode());
        result = prime * result + ((getOperatorAccount() == null) ? 0 : getOperatorAccount().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}