package dal.model.cashier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "route_strategy")
public class RouteStrategyDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 路由策略ID
     */
    @Column(name = "route_strategy_id")
    private String routeStrategyId;

    /**
     * 路由策略名称
     */
    @Column(name = "route_strategy_name")
    private String routeStrategyName;

    /**
     * 路由算法
     */
    @Column(name = "route_strategy_algs")
    private String routeStrategyAlgs;

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

    /**
     * 删除标示
     */
    @Column(name = "mark_delete")
    private String markDelete;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取路由策略ID
     *
     * @return route_strategy_id - 路由策略ID
     */
    public String getRouteStrategyId() {
        return routeStrategyId;
    }

    /**
     * 设置路由策略ID
     *
     * @param routeStrategyId 路由策略ID
     */
    public void setRouteStrategyId(String routeStrategyId) {
        this.routeStrategyId = routeStrategyId == null ? null : routeStrategyId.trim();
    }

    /**
     * 获取路由策略名称
     *
     * @return route_strategy_name - 路由策略名称
     */
    public String getRouteStrategyName() {
        return routeStrategyName;
    }

    /**
     * 设置路由策略名称
     *
     * @param routeStrategyName 路由策略名称
     */
    public void setRouteStrategyName(String routeStrategyName) {
        this.routeStrategyName = routeStrategyName == null ? null : routeStrategyName.trim();
    }

    /**
     * 获取路由算法
     *
     * @return route_strategy_algs - 路由算法
     */
    public String getRouteStrategyAlgs() {
        return routeStrategyAlgs;
    }

    /**
     * 设置路由算法
     *
     * @param routeStrategyAlgs 路由算法
     */
    public void setRouteStrategyAlgs(String routeStrategyAlgs) {
        this.routeStrategyAlgs = routeStrategyAlgs == null ? null : routeStrategyAlgs.trim();
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

    /**
     * 获取删除标示
     *
     * @return mark_delete - 删除标示
     */
    public String getMarkDelete() {
        return markDelete;
    }

    /**
     * 设置删除标示
     *
     * @param markDelete 删除标示
     */
    public void setMarkDelete(String markDelete) {
        this.markDelete = markDelete == null ? null : markDelete.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", routeStrategyId=").append(routeStrategyId);
        sb.append(", routeStrategyName=").append(routeStrategyName);
        sb.append(", routeStrategyAlgs=").append(routeStrategyAlgs);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", markDelete=").append(markDelete);
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
        RouteStrategyDO other = (RouteStrategyDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRouteStrategyId() == null ? other.getRouteStrategyId() == null : this.getRouteStrategyId().equals(other.getRouteStrategyId()))
            && (this.getRouteStrategyName() == null ? other.getRouteStrategyName() == null : this.getRouteStrategyName().equals(other.getRouteStrategyName()))
            && (this.getRouteStrategyAlgs() == null ? other.getRouteStrategyAlgs() == null : this.getRouteStrategyAlgs().equals(other.getRouteStrategyAlgs()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getMarkDelete() == null ? other.getMarkDelete() == null : this.getMarkDelete().equals(other.getMarkDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRouteStrategyId() == null) ? 0 : getRouteStrategyId().hashCode());
        result = prime * result + ((getRouteStrategyName() == null) ? 0 : getRouteStrategyName().hashCode());
        result = prime * result + ((getRouteStrategyAlgs() == null) ? 0 : getRouteStrategyAlgs().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getMarkDelete() == null) ? 0 : getMarkDelete().hashCode());
        return result;
    }
}