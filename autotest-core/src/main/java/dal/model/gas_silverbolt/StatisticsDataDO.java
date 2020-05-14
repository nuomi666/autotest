package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_data")
public class StatisticsDataDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 数据源
     */
    @Column(name = "spout_name")
    private String spoutName;

    /**
     * 模型名称
     */
    @Column(name = "model_name")
    private String modelName;

    /**
     * 统计索引
     */
    @Column(name = "row_key")
    private String rowKey;

    /**
     * 统计粒度
     */
    @Column(name = "time_unit")
    private Date timeUnit;

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

    /**
     * 统计数据
     */
    @Column(name = "statistic_data")
    private String statisticData;

    /**
     * 分组值
     */
    private String groups;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序列
     *
     * @return id - 自增序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增序列
     *
     * @param id 自增序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取数据源
     *
     * @return spout_name - 数据源
     */
    public String getSpoutName() {
        return spoutName;
    }

    /**
     * 设置数据源
     *
     * @param spoutName 数据源
     */
    public void setSpoutName(String spoutName) {
        this.spoutName = spoutName == null ? null : spoutName.trim();
    }

    /**
     * 获取模型名称
     *
     * @return model_name - 模型名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置模型名称
     *
     * @param modelName 模型名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * 获取统计索引
     *
     * @return row_key - 统计索引
     */
    public String getRowKey() {
        return rowKey;
    }

    /**
     * 设置统计索引
     *
     * @param rowKey 统计索引
     */
    public void setRowKey(String rowKey) {
        this.rowKey = rowKey == null ? null : rowKey.trim();
    }

    /**
     * 获取统计粒度
     *
     * @return time_unit - 统计粒度
     */
    public Date getTimeUnit() {
        return timeUnit;
    }

    /**
     * 设置统计粒度
     *
     * @param timeUnit 统计粒度
     */
    public void setTimeUnit(Date timeUnit) {
        this.timeUnit = timeUnit;
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

    /**
     * 获取统计数据
     *
     * @return statistic_data - 统计数据
     */
    public String getStatisticData() {
        return statisticData;
    }

    /**
     * 设置统计数据
     *
     * @param statisticData 统计数据
     */
    public void setStatisticData(String statisticData) {
        this.statisticData = statisticData == null ? null : statisticData.trim();
    }

    /**
     * 获取分组值
     *
     * @return groups - 分组值
     */
    public String getGroups() {
        return groups;
    }

    /**
     * 设置分组值
     *
     * @param groups 分组值
     */
    public void setGroups(String groups) {
        this.groups = groups == null ? null : groups.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", spoutName=").append(spoutName);
        sb.append(", modelName=").append(modelName);
        sb.append(", rowKey=").append(rowKey);
        sb.append(", timeUnit=").append(timeUnit);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", statisticData=").append(statisticData);
        sb.append(", groups=").append(groups);
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
        StatisticsDataDO other = (StatisticsDataDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpoutName() == null ? other.getSpoutName() == null : this.getSpoutName().equals(other.getSpoutName()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getRowKey() == null ? other.getRowKey() == null : this.getRowKey().equals(other.getRowKey()))
            && (this.getTimeUnit() == null ? other.getTimeUnit() == null : this.getTimeUnit().equals(other.getTimeUnit()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getStatisticData() == null ? other.getStatisticData() == null : this.getStatisticData().equals(other.getStatisticData()))
            && (this.getGroups() == null ? other.getGroups() == null : this.getGroups().equals(other.getGroups()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpoutName() == null) ? 0 : getSpoutName().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getRowKey() == null) ? 0 : getRowKey().hashCode());
        result = prime * result + ((getTimeUnit() == null) ? 0 : getTimeUnit().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getStatisticData() == null) ? 0 : getStatisticData().hashCode());
        result = prime * result + ((getGroups() == null) ? 0 : getGroups().hashCode());
        return result;
    }
}