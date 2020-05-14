package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "distributed_lock")
public class DistributedLockDO implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 策略
     */
    private String policy;

    /**
     * 模式
     */
    @Column(name = "lock_module")
    private String lockModule;

    /**
     * 锁名称
     */
    @Column(name = "lock_name")
    private String lockName;

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
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取策略
     *
     * @return policy - 策略
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * 设置策略
     *
     * @param policy 策略
     */
    public void setPolicy(String policy) {
        this.policy = policy == null ? null : policy.trim();
    }

    /**
     * 获取模式
     *
     * @return lock_module - 模式
     */
    public String getLockModule() {
        return lockModule;
    }

    /**
     * 设置模式
     *
     * @param lockModule 模式
     */
    public void setLockModule(String lockModule) {
        this.lockModule = lockModule == null ? null : lockModule.trim();
    }

    /**
     * 获取锁名称
     *
     * @return lock_name - 锁名称
     */
    public String getLockName() {
        return lockName;
    }

    /**
     * 设置锁名称
     *
     * @param lockName 锁名称
     */
    public void setLockName(String lockName) {
        this.lockName = lockName == null ? null : lockName.trim();
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
        sb.append(", policy=").append(policy);
        sb.append(", lockModule=").append(lockModule);
        sb.append(", lockName=").append(lockName);
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
        DistributedLockDO other = (DistributedLockDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPolicy() == null ? other.getPolicy() == null : this.getPolicy().equals(other.getPolicy()))
            && (this.getLockModule() == null ? other.getLockModule() == null : this.getLockModule().equals(other.getLockModule()))
            && (this.getLockName() == null ? other.getLockName() == null : this.getLockName().equals(other.getLockName()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPolicy() == null) ? 0 : getPolicy().hashCode());
        result = prime * result + ((getLockModule() == null) ? 0 : getLockModule().hashCode());
        result = prime * result + ((getLockName() == null) ? 0 : getLockName().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}