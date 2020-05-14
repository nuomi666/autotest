package dal.model.merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_lock")
public class SysLockDO implements Serializable {
    /**
     * 无意义主键。
     */
    @Id
    private Long identity;

    /**
     * 锁归属模块。
     */
    private String module;

    /**
     * 使用策略，默认为标准.
     */
    private String policy;

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
     * 最后变更时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取无意义主键。
     *
     * @return identity - 无意义主键。
     */
    public Long getIdentity() {
        return identity;
    }

    /**
     * 设置无意义主键。
     *
     * @param identity 无意义主键。
     */
    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    /**
     * 获取锁归属模块。
     *
     * @return module - 锁归属模块。
     */
    public String getModule() {
        return module;
    }

    /**
     * 设置锁归属模块。
     *
     * @param module 锁归属模块。
     */
    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    /**
     * 获取使用策略，默认为标准.
     *
     * @return policy - 使用策略，默认为标准.
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * 设置使用策略，默认为标准.
     *
     * @param policy 使用策略，默认为标准.
     */
    public void setPolicy(String policy) {
        this.policy = policy == null ? null : policy.trim();
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
     * 获取最后变更时间
     *
     * @return raw_update_time - 最后变更时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置最后变更时间
     *
     * @param rawUpdateTime 最后变更时间
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", identity=").append(identity);
        sb.append(", module=").append(module);
        sb.append(", policy=").append(policy);
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
        SysLockDO other = (SysLockDO) that;
        return (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getModule() == null ? other.getModule() == null : this.getModule().equals(other.getModule()))
            && (this.getPolicy() == null ? other.getPolicy() == null : this.getPolicy().equals(other.getPolicy()))
            && (this.getLockName() == null ? other.getLockName() == null : this.getLockName().equals(other.getLockName()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getPolicy() == null) ? 0 : getPolicy().hashCode());
        result = prime * result + ((getLockName() == null) ? 0 : getLockName().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}