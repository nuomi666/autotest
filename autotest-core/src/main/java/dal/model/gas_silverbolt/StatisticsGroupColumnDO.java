package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_group_column")
public class StatisticsGroupColumnDO implements Serializable {
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
     * 字段名称
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 字段编码
     */
    @Column(name = "column_code")
    private String columnCode;

    /**
     * 排序字段
     */
    @Column(name = "order_by_code")
    private String orderByCode;

    /**
     * 字段类型
     */
    @Column(name = "column_type")
    private String columnType;

    /**
     * 过滤
     */
    @Column(name = "must_filter")
    private String mustFilter;

    /**
     * 分组小记
     */
    private String subtotal;

    /**
     * 横向排列
     */
    private String across;

    /**
     * 分组周期
     */
    private String cycle;

    /**
     * 展示值
     */
    @Column(name = "show_value")
    private String showValue;

    /**
     * 描述
     */
    private String memo;

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
     * 获取字段名称
     *
     * @return column_name - 字段名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置字段名称
     *
     * @param columnName 字段名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 获取字段编码
     *
     * @return column_code - 字段编码
     */
    public String getColumnCode() {
        return columnCode;
    }

    /**
     * 设置字段编码
     *
     * @param columnCode 字段编码
     */
    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode == null ? null : columnCode.trim();
    }

    /**
     * 获取排序字段
     *
     * @return order_by_code - 排序字段
     */
    public String getOrderByCode() {
        return orderByCode;
    }

    /**
     * 设置排序字段
     *
     * @param orderByCode 排序字段
     */
    public void setOrderByCode(String orderByCode) {
        this.orderByCode = orderByCode == null ? null : orderByCode.trim();
    }

    /**
     * 获取字段类型
     *
     * @return column_type - 字段类型
     */
    public String getColumnType() {
        return columnType;
    }

    /**
     * 设置字段类型
     *
     * @param columnType 字段类型
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType == null ? null : columnType.trim();
    }

    /**
     * 获取过滤
     *
     * @return must_filter - 过滤
     */
    public String getMustFilter() {
        return mustFilter;
    }

    /**
     * 设置过滤
     *
     * @param mustFilter 过滤
     */
    public void setMustFilter(String mustFilter) {
        this.mustFilter = mustFilter == null ? null : mustFilter.trim();
    }

    /**
     * 获取分组小记
     *
     * @return subtotal - 分组小记
     */
    public String getSubtotal() {
        return subtotal;
    }

    /**
     * 设置分组小记
     *
     * @param subtotal 分组小记
     */
    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal == null ? null : subtotal.trim();
    }

    /**
     * 获取横向排列
     *
     * @return across - 横向排列
     */
    public String getAcross() {
        return across;
    }

    /**
     * 设置横向排列
     *
     * @param across 横向排列
     */
    public void setAcross(String across) {
        this.across = across == null ? null : across.trim();
    }

    /**
     * 获取分组周期
     *
     * @return cycle - 分组周期
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * 设置分组周期
     *
     * @param cycle 分组周期
     */
    public void setCycle(String cycle) {
        this.cycle = cycle == null ? null : cycle.trim();
    }

    /**
     * 获取展示值
     *
     * @return show_value - 展示值
     */
    public String getShowValue() {
        return showValue;
    }

    /**
     * 设置展示值
     *
     * @param showValue 展示值
     */
    public void setShowValue(String showValue) {
        this.showValue = showValue == null ? null : showValue.trim();
    }

    /**
     * 获取描述
     *
     * @return memo - 描述
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置描述
     *
     * @param memo 描述
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
        sb.append(", columnName=").append(columnName);
        sb.append(", columnCode=").append(columnCode);
        sb.append(", orderByCode=").append(orderByCode);
        sb.append(", columnType=").append(columnType);
        sb.append(", mustFilter=").append(mustFilter);
        sb.append(", subtotal=").append(subtotal);
        sb.append(", across=").append(across);
        sb.append(", cycle=").append(cycle);
        sb.append(", showValue=").append(showValue);
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
        StatisticsGroupColumnDO other = (StatisticsGroupColumnDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPoolsName() == null ? other.getPoolsName() == null : this.getPoolsName().equals(other.getPoolsName()))
            && (this.getPoolsCode() == null ? other.getPoolsCode() == null : this.getPoolsCode().equals(other.getPoolsCode()))
            && (this.getColumnName() == null ? other.getColumnName() == null : this.getColumnName().equals(other.getColumnName()))
            && (this.getColumnCode() == null ? other.getColumnCode() == null : this.getColumnCode().equals(other.getColumnCode()))
            && (this.getOrderByCode() == null ? other.getOrderByCode() == null : this.getOrderByCode().equals(other.getOrderByCode()))
            && (this.getColumnType() == null ? other.getColumnType() == null : this.getColumnType().equals(other.getColumnType()))
            && (this.getMustFilter() == null ? other.getMustFilter() == null : this.getMustFilter().equals(other.getMustFilter()))
            && (this.getSubtotal() == null ? other.getSubtotal() == null : this.getSubtotal().equals(other.getSubtotal()))
            && (this.getAcross() == null ? other.getAcross() == null : this.getAcross().equals(other.getAcross()))
            && (this.getCycle() == null ? other.getCycle() == null : this.getCycle().equals(other.getCycle()))
            && (this.getShowValue() == null ? other.getShowValue() == null : this.getShowValue().equals(other.getShowValue()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
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
        result = prime * result + ((getColumnName() == null) ? 0 : getColumnName().hashCode());
        result = prime * result + ((getColumnCode() == null) ? 0 : getColumnCode().hashCode());
        result = prime * result + ((getOrderByCode() == null) ? 0 : getOrderByCode().hashCode());
        result = prime * result + ((getColumnType() == null) ? 0 : getColumnType().hashCode());
        result = prime * result + ((getMustFilter() == null) ? 0 : getMustFilter().hashCode());
        result = prime * result + ((getSubtotal() == null) ? 0 : getSubtotal().hashCode());
        result = prime * result + ((getAcross() == null) ? 0 : getAcross().hashCode());
        result = prime * result + ((getCycle() == null) ? 0 : getCycle().hashCode());
        result = prime * result + ((getShowValue() == null) ? 0 : getShowValue().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}