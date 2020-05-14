package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_column")
public class StatisticsColumnDO implements Serializable {
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
     * 字段类型
     */
    @Column(name = "column_type")
    private String columnType;

    /**
     * 合计
     */
    @Column(name = "sum_vertical")
    private String sumVertical;

    /**
     * 统计模型
     */
    @Column(name = "statistics_model")
    private String statisticsModel;

    /**
     * 统计值
     */
    @Column(name = "statistics_code")
    private String statisticsCode;

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
     * 获取合计
     *
     * @return sum_vertical - 合计
     */
    public String getSumVertical() {
        return sumVertical;
    }

    /**
     * 设置合计
     *
     * @param sumVertical 合计
     */
    public void setSumVertical(String sumVertical) {
        this.sumVertical = sumVertical == null ? null : sumVertical.trim();
    }

    /**
     * 获取统计模型
     *
     * @return statistics_model - 统计模型
     */
    public String getStatisticsModel() {
        return statisticsModel;
    }

    /**
     * 设置统计模型
     *
     * @param statisticsModel 统计模型
     */
    public void setStatisticsModel(String statisticsModel) {
        this.statisticsModel = statisticsModel == null ? null : statisticsModel.trim();
    }

    /**
     * 获取统计值
     *
     * @return statistics_code - 统计值
     */
    public String getStatisticsCode() {
        return statisticsCode;
    }

    /**
     * 设置统计值
     *
     * @param statisticsCode 统计值
     */
    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode == null ? null : statisticsCode.trim();
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
        sb.append(", columnType=").append(columnType);
        sb.append(", sumVertical=").append(sumVertical);
        sb.append(", statisticsModel=").append(statisticsModel);
        sb.append(", statisticsCode=").append(statisticsCode);
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
        StatisticsColumnDO other = (StatisticsColumnDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPoolsName() == null ? other.getPoolsName() == null : this.getPoolsName().equals(other.getPoolsName()))
            && (this.getPoolsCode() == null ? other.getPoolsCode() == null : this.getPoolsCode().equals(other.getPoolsCode()))
            && (this.getColumnName() == null ? other.getColumnName() == null : this.getColumnName().equals(other.getColumnName()))
            && (this.getColumnCode() == null ? other.getColumnCode() == null : this.getColumnCode().equals(other.getColumnCode()))
            && (this.getColumnType() == null ? other.getColumnType() == null : this.getColumnType().equals(other.getColumnType()))
            && (this.getSumVertical() == null ? other.getSumVertical() == null : this.getSumVertical().equals(other.getSumVertical()))
            && (this.getStatisticsModel() == null ? other.getStatisticsModel() == null : this.getStatisticsModel().equals(other.getStatisticsModel()))
            && (this.getStatisticsCode() == null ? other.getStatisticsCode() == null : this.getStatisticsCode().equals(other.getStatisticsCode()))
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
        result = prime * result + ((getColumnType() == null) ? 0 : getColumnType().hashCode());
        result = prime * result + ((getSumVertical() == null) ? 0 : getSumVertical().hashCode());
        result = prime * result + ((getStatisticsModel() == null) ? 0 : getStatisticsModel().hashCode());
        result = prime * result + ((getStatisticsCode() == null) ? 0 : getStatisticsCode().hashCode());
        result = prime * result + ((getShowValue() == null) ? 0 : getShowValue().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}