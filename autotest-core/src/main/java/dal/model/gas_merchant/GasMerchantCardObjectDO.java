package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_card_object")
public class GasMerchantCardObjectDO implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 主体ID
     */
    @Column(name = "object_id")
    private String objectId;

    /**
     * 商家ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

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
     * 主体名称
     */
    @Column(name = "object_name")
    private String objectName;

    /**
     * 主体公司
     */
    @Column(name = "object_company")
    private String objectCompany;

    /**
     * 状态
     */
    private String status;

    /**
     * 有效期起
     */
    @Column(name = "valid_start")
    private Date validStart;

    /**
     * 有效期止
     */
    @Column(name = "valid_end")
    private Date validEnd;

    /**
     * 说明
     */
    private String memo;

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
     * 获取主体ID
     *
     * @return object_id - 主体ID
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * 设置主体ID
     *
     * @param objectId 主体ID
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
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
     * 获取主体名称
     *
     * @return object_name - 主体名称
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * 设置主体名称
     *
     * @param objectName 主体名称
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    /**
     * 获取主体公司
     *
     * @return object_company - 主体公司
     */
    public String getObjectCompany() {
        return objectCompany;
    }

    /**
     * 设置主体公司
     *
     * @param objectCompany 主体公司
     */
    public void setObjectCompany(String objectCompany) {
        this.objectCompany = objectCompany == null ? null : objectCompany.trim();
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
     * 获取有效期起
     *
     * @return valid_start - 有效期起
     */
    public Date getValidStart() {
        return validStart;
    }

    /**
     * 设置有效期起
     *
     * @param validStart 有效期起
     */
    public void setValidStart(Date validStart) {
        this.validStart = validStart;
    }

    /**
     * 获取有效期止
     *
     * @return valid_end - 有效期止
     */
    public Date getValidEnd() {
        return validEnd;
    }

    /**
     * 设置有效期止
     *
     * @param validEnd 有效期止
     */
    public void setValidEnd(Date validEnd) {
        this.validEnd = validEnd;
    }

    /**
     * 获取说明
     *
     * @return memo - 说明
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置说明
     *
     * @param memo 说明
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        sb.append(", objectId=").append(objectId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", cardType=").append(cardType);
        sb.append(", tag=").append(tag);
        sb.append(", objectName=").append(objectName);
        sb.append(", objectCompany=").append(objectCompany);
        sb.append(", status=").append(status);
        sb.append(", validStart=").append(validStart);
        sb.append(", validEnd=").append(validEnd);
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
        GasMerchantCardObjectDO other = (GasMerchantCardObjectDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getObjectName() == null ? other.getObjectName() == null : this.getObjectName().equals(other.getObjectName()))
            && (this.getObjectCompany() == null ? other.getObjectCompany() == null : this.getObjectCompany().equals(other.getObjectCompany()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getValidStart() == null ? other.getValidStart() == null : this.getValidStart().equals(other.getValidStart()))
            && (this.getValidEnd() == null ? other.getValidEnd() == null : this.getValidEnd().equals(other.getValidEnd()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getObjectName() == null) ? 0 : getObjectName().hashCode());
        result = prime * result + ((getObjectCompany() == null) ? 0 : getObjectCompany().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getValidStart() == null) ? 0 : getValidStart().hashCode());
        result = prime * result + ((getValidEnd() == null) ? 0 : getValidEnd().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}