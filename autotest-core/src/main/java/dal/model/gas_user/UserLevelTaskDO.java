package dal.model.gas_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_level_task")
public class UserLevelTaskDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 等级更新类型
     */
    @Column(name = "level_update_type")
    private String levelUpdateType;

    /**
     * 周期类型
     */
    @Column(name = "use_time_unit")
    private String useTimeUnit;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 执行状态
     */
    @Column(name = "execution_status")
    private String executionStatus;

    /**
     * 备注
     */
    private String memo;

    /**
     * sql搜索会员下标
     */
    private Integer subscript;

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
     * 获取等级更新类型
     *
     * @return level_update_type - 等级更新类型
     */
    public String getLevelUpdateType() {
        return levelUpdateType;
    }

    /**
     * 设置等级更新类型
     *
     * @param levelUpdateType 等级更新类型
     */
    public void setLevelUpdateType(String levelUpdateType) {
        this.levelUpdateType = levelUpdateType == null ? null : levelUpdateType.trim();
    }

    /**
     * 获取周期类型
     *
     * @return use_time_unit - 周期类型
     */
    public String getUseTimeUnit() {
        return useTimeUnit;
    }

    /**
     * 设置周期类型
     *
     * @param useTimeUnit 周期类型
     */
    public void setUseTimeUnit(String useTimeUnit) {
        this.useTimeUnit = useTimeUnit == null ? null : useTimeUnit.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取执行状态
     *
     * @return execution_status - 执行状态
     */
    public String getExecutionStatus() {
        return executionStatus;
    }

    /**
     * 设置执行状态
     *
     * @param executionStatus 执行状态
     */
    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus == null ? null : executionStatus.trim();
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
     * 获取sql搜索会员下标
     *
     * @return subscript - sql搜索会员下标
     */
    public Integer getSubscript() {
        return subscript;
    }

    /**
     * 设置sql搜索会员下标
     *
     * @param subscript sql搜索会员下标
     */
    public void setSubscript(Integer subscript) {
        this.subscript = subscript;
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", levelUpdateType=").append(levelUpdateType);
        sb.append(", useTimeUnit=").append(useTimeUnit);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", executionStatus=").append(executionStatus);
        sb.append(", memo=").append(memo);
        sb.append(", subscript=").append(subscript);
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
        UserLevelTaskDO other = (UserLevelTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getLevelUpdateType() == null ? other.getLevelUpdateType() == null : this.getLevelUpdateType().equals(other.getLevelUpdateType()))
            && (this.getUseTimeUnit() == null ? other.getUseTimeUnit() == null : this.getUseTimeUnit().equals(other.getUseTimeUnit()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getExecutionStatus() == null ? other.getExecutionStatus() == null : this.getExecutionStatus().equals(other.getExecutionStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getSubscript() == null ? other.getSubscript() == null : this.getSubscript().equals(other.getSubscript()))
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
        result = prime * result + ((getLevelUpdateType() == null) ? 0 : getLevelUpdateType().hashCode());
        result = prime * result + ((getUseTimeUnit() == null) ? 0 : getUseTimeUnit().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getExecutionStatus() == null) ? 0 : getExecutionStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getSubscript() == null) ? 0 : getSubscript().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}