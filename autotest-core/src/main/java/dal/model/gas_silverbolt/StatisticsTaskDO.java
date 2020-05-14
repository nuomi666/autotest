package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_task")
public class StatisticsTaskDO implements Serializable {
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
     * 是否允许扫描
     */
    @Column(name = "data_scan")
    private String dataScan;

    /**
     * 起始值
     */
    @Column(name = "start_index")
    private String startIndex;

    /**
     * 结束值
     */
    @Column(name = "end_index")
    private String endIndex;

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
     * 获取是否允许扫描
     *
     * @return data_scan - 是否允许扫描
     */
    public String getDataScan() {
        return dataScan;
    }

    /**
     * 设置是否允许扫描
     *
     * @param dataScan 是否允许扫描
     */
    public void setDataScan(String dataScan) {
        this.dataScan = dataScan == null ? null : dataScan.trim();
    }

    /**
     * 获取起始值
     *
     * @return start_index - 起始值
     */
    public String getStartIndex() {
        return startIndex;
    }

    /**
     * 设置起始值
     *
     * @param startIndex 起始值
     */
    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex == null ? null : startIndex.trim();
    }

    /**
     * 获取结束值
     *
     * @return end_index - 结束值
     */
    public String getEndIndex() {
        return endIndex;
    }

    /**
     * 设置结束值
     *
     * @param endIndex 结束值
     */
    public void setEndIndex(String endIndex) {
        this.endIndex = endIndex == null ? null : endIndex.trim();
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
        sb.append(", spoutName=").append(spoutName);
        sb.append(", modelName=").append(modelName);
        sb.append(", dataScan=").append(dataScan);
        sb.append(", startIndex=").append(startIndex);
        sb.append(", endIndex=").append(endIndex);
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
        StatisticsTaskDO other = (StatisticsTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpoutName() == null ? other.getSpoutName() == null : this.getSpoutName().equals(other.getSpoutName()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getDataScan() == null ? other.getDataScan() == null : this.getDataScan().equals(other.getDataScan()))
            && (this.getStartIndex() == null ? other.getStartIndex() == null : this.getStartIndex().equals(other.getStartIndex()))
            && (this.getEndIndex() == null ? other.getEndIndex() == null : this.getEndIndex().equals(other.getEndIndex()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpoutName() == null) ? 0 : getSpoutName().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getDataScan() == null) ? 0 : getDataScan().hashCode());
        result = prime * result + ((getStartIndex() == null) ? 0 : getStartIndex().hashCode());
        result = prime * result + ((getEndIndex() == null) ? 0 : getEndIndex().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}