package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "point_scheme")
public class PointSchemeDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 积分方案编号
     */
    @Column(name = "point_scheme_no")
    private String pointSchemeNo;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 规则方案类型
     */
    @Column(name = "point_scheme_type")
    private String pointSchemeType;

    /**
     * 积分规则
     */
    @Column(name = "point_rules")
    private String pointRules;

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
     * 获取积分方案编号
     *
     * @return point_scheme_no - 积分方案编号
     */
    public String getPointSchemeNo() {
        return pointSchemeNo;
    }

    /**
     * 设置积分方案编号
     *
     * @param pointSchemeNo 积分方案编号
     */
    public void setPointSchemeNo(String pointSchemeNo) {
        this.pointSchemeNo = pointSchemeNo == null ? null : pointSchemeNo.trim();
    }

    /**
     * 获取商户ID
     *
     * @return partner_id - 商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户ID
     *
     * @param partnerId 商户ID
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
     * 获取规则方案类型
     *
     * @return point_scheme_type - 规则方案类型
     */
    public String getPointSchemeType() {
        return pointSchemeType;
    }

    /**
     * 设置规则方案类型
     *
     * @param pointSchemeType 规则方案类型
     */
    public void setPointSchemeType(String pointSchemeType) {
        this.pointSchemeType = pointSchemeType == null ? null : pointSchemeType.trim();
    }

    /**
     * 获取积分规则
     *
     * @return point_rules - 积分规则
     */
    public String getPointRules() {
        return pointRules;
    }

    /**
     * 设置积分规则
     *
     * @param pointRules 积分规则
     */
    public void setPointRules(String pointRules) {
        this.pointRules = pointRules == null ? null : pointRules.trim();
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
        sb.append(", pointSchemeNo=").append(pointSchemeNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", pointSchemeType=").append(pointSchemeType);
        sb.append(", pointRules=").append(pointRules);
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
        PointSchemeDO other = (PointSchemeDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPointSchemeNo() == null ? other.getPointSchemeNo() == null : this.getPointSchemeNo().equals(other.getPointSchemeNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPointSchemeType() == null ? other.getPointSchemeType() == null : this.getPointSchemeType().equals(other.getPointSchemeType()))
            && (this.getPointRules() == null ? other.getPointRules() == null : this.getPointRules().equals(other.getPointRules()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPointSchemeNo() == null) ? 0 : getPointSchemeNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPointSchemeType() == null) ? 0 : getPointSchemeType().hashCode());
        result = prime * result + ((getPointRules() == null) ? 0 : getPointRules().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}