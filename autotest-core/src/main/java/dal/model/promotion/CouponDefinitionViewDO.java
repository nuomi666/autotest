package dal.model.promotion;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "coupon_definition_view")
public class CouponDefinitionViewDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "definition_id")
    private String definitionId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "definition_status")
    private String definitionStatus;

    @Column(name = "inner_name")
    private String innerName;

    private String name;

    @Column(name = "coupon_type")
    private String couponType;

    @Column(name = "definition_json")
    private String definitionJson;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return definition_id
     */
    public String getDefinitionId() {
        return definitionId;
    }

    /**
     * @param definitionId
     */
    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId == null ? null : definitionId.trim();
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
     * @return partner_id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * @param partnerId
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * @return definition_status
     */
    public String getDefinitionStatus() {
        return definitionStatus;
    }

    /**
     * @param definitionStatus
     */
    public void setDefinitionStatus(String definitionStatus) {
        this.definitionStatus = definitionStatus == null ? null : definitionStatus.trim();
    }

    /**
     * @return inner_name
     */
    public String getInnerName() {
        return innerName;
    }

    /**
     * @param innerName
     */
    public void setInnerName(String innerName) {
        this.innerName = innerName == null ? null : innerName.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return coupon_type
     */
    public String getCouponType() {
        return couponType;
    }

    /**
     * @param couponType
     */
    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    /**
     * @return definition_json
     */
    public String getDefinitionJson() {
        return definitionJson;
    }

    /**
     * @param definitionJson
     */
    public void setDefinitionJson(String definitionJson) {
        this.definitionJson = definitionJson == null ? null : definitionJson.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", definitionId=").append(definitionId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", definitionStatus=").append(definitionStatus);
        sb.append(", innerName=").append(innerName);
        sb.append(", name=").append(name);
        sb.append(", couponType=").append(couponType);
        sb.append(", definitionJson=").append(definitionJson);
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
        CouponDefinitionViewDO other = (CouponDefinitionViewDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDefinitionId() == null ? other.getDefinitionId() == null : this.getDefinitionId().equals(other.getDefinitionId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getDefinitionStatus() == null ? other.getDefinitionStatus() == null : this.getDefinitionStatus().equals(other.getDefinitionStatus()))
            && (this.getInnerName() == null ? other.getInnerName() == null : this.getInnerName().equals(other.getInnerName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCouponType() == null ? other.getCouponType() == null : this.getCouponType().equals(other.getCouponType()))
            && (this.getDefinitionJson() == null ? other.getDefinitionJson() == null : this.getDefinitionJson().equals(other.getDefinitionJson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDefinitionId() == null) ? 0 : getDefinitionId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getDefinitionStatus() == null) ? 0 : getDefinitionStatus().hashCode());
        result = prime * result + ((getInnerName() == null) ? 0 : getInnerName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCouponType() == null) ? 0 : getCouponType().hashCode());
        result = prime * result + ((getDefinitionJson() == null) ? 0 : getDefinitionJson().hashCode());
        return result;
    }
}