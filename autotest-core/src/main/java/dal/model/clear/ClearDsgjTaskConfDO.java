package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_dsgj_task_conf")
public class ClearDsgjTaskConfDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签约商户
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 签约商户真实姓名
     */
    @Column(name = "plat_partner_real_name")
    private String platPartnerRealName;

    /**
     * 清分周期，单位自然日
     */
    @Column(name = "clear_cycle")
    private Integer clearCycle;

    /**
     * 是否清分Y/N
     */
    @Column(name = "use_clear")
    private String useClear;

    /**
     * 清分执行时间HH:mm:ss
     */
    @Column(name = "clear_time")
    private String clearTime;

    /**
     * 是否结算Y/N
     */
    @Column(name = "use_settlement")
    private String useSettlement;

    /**
     * 结算执行时间“|”分隔，三个时间点HH:mm:ss
     */
    @Column(name = "settlement_time")
    private String settlementTime;

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
     * @return plat_partner_id - 签约商户
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置签约商户
     *
     * @param platPartnerId 签约商户
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取签约商户真实姓名
     *
     * @return plat_partner_real_name - 签约商户真实姓名
     */
    public String getPlatPartnerRealName() {
        return platPartnerRealName;
    }

    /**
     * 设置签约商户真实姓名
     *
     * @param platPartnerRealName 签约商户真实姓名
     */
    public void setPlatPartnerRealName(String platPartnerRealName) {
        this.platPartnerRealName = platPartnerRealName == null ? null : platPartnerRealName.trim();
    }

    /**
     * 获取清分周期，单位自然日
     *
     * @return clear_cycle - 清分周期，单位自然日
     */
    public Integer getClearCycle() {
        return clearCycle;
    }

    /**
     * 设置清分周期，单位自然日
     *
     * @param clearCycle 清分周期，单位自然日
     */
    public void setClearCycle(Integer clearCycle) {
        this.clearCycle = clearCycle;
    }

    /**
     * 获取是否清分Y/N
     *
     * @return use_clear - 是否清分Y/N
     */
    public String getUseClear() {
        return useClear;
    }

    /**
     * 设置是否清分Y/N
     *
     * @param useClear 是否清分Y/N
     */
    public void setUseClear(String useClear) {
        this.useClear = useClear == null ? null : useClear.trim();
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
     * @return use_settlement - 是否结算Y/N
     */
    public String getUseSettlement() {
        return useSettlement;
    }

    /**
     * 设置是否结算Y/N
     *
     * @param useSettlement 是否结算Y/N
     */
    public void setUseSettlement(String useSettlement) {
        this.useSettlement = useSettlement == null ? null : useSettlement.trim();
    }

    /**
     * 获取结算执行时间“|”分隔，三个时间点HH:mm:ss
     *
     * @return settlement_time - 结算执行时间“|”分隔，三个时间点HH:mm:ss
     */
    public String getSettlementTime() {
        return settlementTime;
    }

    /**
     * 设置结算执行时间“|”分隔，三个时间点HH:mm:ss
     *
     * @param settlementTime 结算执行时间“|”分隔，三个时间点HH:mm:ss
     */
    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime == null ? null : settlementTime.trim();
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platPartnerRealName=").append(platPartnerRealName);
        sb.append(", clearCycle=").append(clearCycle);
        sb.append(", useClear=").append(useClear);
        sb.append(", clearTime=").append(clearTime);
        sb.append(", useSettlement=").append(useSettlement);
        sb.append(", settlementTime=").append(settlementTime);
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
        ClearDsgjTaskConfDO other = (ClearDsgjTaskConfDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatPartnerRealName() == null ? other.getPlatPartnerRealName() == null : this.getPlatPartnerRealName().equals(other.getPlatPartnerRealName()))
            && (this.getClearCycle() == null ? other.getClearCycle() == null : this.getClearCycle().equals(other.getClearCycle()))
            && (this.getUseClear() == null ? other.getUseClear() == null : this.getUseClear().equals(other.getUseClear()))
            && (this.getClearTime() == null ? other.getClearTime() == null : this.getClearTime().equals(other.getClearTime()))
            && (this.getUseSettlement() == null ? other.getUseSettlement() == null : this.getUseSettlement().equals(other.getUseSettlement()))
            && (this.getSettlementTime() == null ? other.getSettlementTime() == null : this.getSettlementTime().equals(other.getSettlementTime()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerRealName() == null) ? 0 : getPlatPartnerRealName().hashCode());
        result = prime * result + ((getClearCycle() == null) ? 0 : getClearCycle().hashCode());
        result = prime * result + ((getUseClear() == null) ? 0 : getUseClear().hashCode());
        result = prime * result + ((getClearTime() == null) ? 0 : getClearTime().hashCode());
        result = prime * result + ((getUseSettlement() == null) ? 0 : getUseSettlement().hashCode());
        result = prime * result + ((getSettlementTime() == null) ? 0 : getSettlementTime().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}