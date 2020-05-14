package dal.model.shelluser;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_integral_reset_task")
public class UserIntegralResetTaskDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 积分清零类型
     */
    @Column(name = "integral_reset_type")
    private String integralResetType;

    /**
     * 周期类型
     */
    @Column(name = "use_time_unit")
    private String useTimeUnit;

    /**
     * 清零时间
     */
    @Column(name = "reset_time")
    private Date resetTime;

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
     * 获取积分清零类型
     *
     * @return integral_reset_type - 积分清零类型
     */
    public String getIntegralResetType() {
        return integralResetType;
    }

    /**
     * 设置积分清零类型
     *
     * @param integralResetType 积分清零类型
     */
    public void setIntegralResetType(String integralResetType) {
        this.integralResetType = integralResetType == null ? null : integralResetType.trim();
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
     * 获取清零时间
     *
     * @return reset_time - 清零时间
     */
    public Date getResetTime() {
        return resetTime;
    }

    /**
     * 设置清零时间
     *
     * @param resetTime 清零时间
     */
    public void setResetTime(Date resetTime) {
        this.resetTime = resetTime;
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
        sb.append(", integralResetType=").append(integralResetType);
        sb.append(", useTimeUnit=").append(useTimeUnit);
        sb.append(", resetTime=").append(resetTime);
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
        UserIntegralResetTaskDO other = (UserIntegralResetTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getIntegralResetType() == null ? other.getIntegralResetType() == null : this.getIntegralResetType().equals(other.getIntegralResetType()))
            && (this.getUseTimeUnit() == null ? other.getUseTimeUnit() == null : this.getUseTimeUnit().equals(other.getUseTimeUnit()))
            && (this.getResetTime() == null ? other.getResetTime() == null : this.getResetTime().equals(other.getResetTime()))
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
        result = prime * result + ((getIntegralResetType() == null) ? 0 : getIntegralResetType().hashCode());
        result = prime * result + ((getUseTimeUnit() == null) ? 0 : getUseTimeUnit().hashCode());
        result = prime * result + ((getResetTime() == null) ? 0 : getResetTime().hashCode());
        result = prime * result + ((getExecutionStatus() == null) ? 0 : getExecutionStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getSubscript() == null) ? 0 : getSubscript().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}