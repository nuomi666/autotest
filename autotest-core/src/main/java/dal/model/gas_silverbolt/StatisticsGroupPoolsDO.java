package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_group_pools")
public class StatisticsGroupPoolsDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分组池名称
     */
    @Column(name = "pools_name")
    private String poolsName;

    /**
     * 分组池编码
     */
    @Column(name = "pools_code")
    private String poolsCode;

    /**
     * 分组池分组sql
     */
    @Column(name = "group_sql")
    private String groupSql;

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
     * 获取序列id
     *
     * @return id - 序列id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置序列id
     *
     * @param id 序列id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分组池名称
     *
     * @return pools_name - 分组池名称
     */
    public String getPoolsName() {
        return poolsName;
    }

    /**
     * 设置分组池名称
     *
     * @param poolsName 分组池名称
     */
    public void setPoolsName(String poolsName) {
        this.poolsName = poolsName == null ? null : poolsName.trim();
    }

    /**
     * 获取分组池编码
     *
     * @return pools_code - 分组池编码
     */
    public String getPoolsCode() {
        return poolsCode;
    }

    /**
     * 设置分组池编码
     *
     * @param poolsCode 分组池编码
     */
    public void setPoolsCode(String poolsCode) {
        this.poolsCode = poolsCode == null ? null : poolsCode.trim();
    }

    /**
     * 获取分组池分组sql
     *
     * @return group_sql - 分组池分组sql
     */
    public String getGroupSql() {
        return groupSql;
    }

    /**
     * 设置分组池分组sql
     *
     * @param groupSql 分组池分组sql
     */
    public void setGroupSql(String groupSql) {
        this.groupSql = groupSql == null ? null : groupSql.trim();
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
        sb.append(", poolsName=").append(poolsName);
        sb.append(", poolsCode=").append(poolsCode);
        sb.append(", groupSql=").append(groupSql);
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
        StatisticsGroupPoolsDO other = (StatisticsGroupPoolsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPoolsName() == null ? other.getPoolsName() == null : this.getPoolsName().equals(other.getPoolsName()))
            && (this.getPoolsCode() == null ? other.getPoolsCode() == null : this.getPoolsCode().equals(other.getPoolsCode()))
            && (this.getGroupSql() == null ? other.getGroupSql() == null : this.getGroupSql().equals(other.getGroupSql()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPoolsName() == null) ? 0 : getPoolsName().hashCode());
        result = prime * result + ((getPoolsCode() == null) ? 0 : getPoolsCode().hashCode());
        result = prime * result + ((getGroupSql() == null) ? 0 : getGroupSql().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}