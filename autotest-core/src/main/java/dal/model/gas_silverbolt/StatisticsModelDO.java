package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_model")
public class StatisticsModelDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 数据源名
     */
    @Column(name = "spout_name")
    private String spoutName;

    /**
     * 模型名称
     */
    @Column(name = "model_name")
    private String modelName;

    /**
     * 模型类型
     */
    @Column(name = "model_type")
    private String modelType;

    /**
     * 偏移量
     */
    @Column(name = "off_set")
    private Long offSet;

    /**
     * 偏移量表达式
     */
    @Column(name = "off_set_expr")
    private String offSetExpr;

    /**
     * 时间字段
     */
    @Column(name = "time_filed")
    private String timeFiled;

    /**
     * 窗口类型
     */
    @Column(name = "window_type")
    private String windowType;

    /**
     * 窗口单位
     */
    @Column(name = "window_unit")
    private String windowUnit;

    /**
     * 窗口长度
     */
    @Column(name = "window_length")
    private Integer windowLength;

    /**
     * 模型状态
     */
    private String status;

    /**
     * 开关
     */
    private String enable;

    /**
     * 计算状态
     */
    @Column(name = "calculate_status")
    private String calculateStatus;

    /**
     * 聚合函数
     */
    private String aggregates;

    /**
     * 统计条件
     */
    private String conditions;

    /**
     * 统计分组
     */
    private String groups;

    /**
     * 去重分组
     */
    private String distincts;

    /**
     * 模型说明
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
     * 获取数据源名
     *
     * @return spout_name - 数据源名
     */
    public String getSpoutName() {
        return spoutName;
    }

    /**
     * 设置数据源名
     *
     * @param spoutName 数据源名
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
     * 获取模型类型
     *
     * @return model_type - 模型类型
     */
    public String getModelType() {
        return modelType;
    }

    /**
     * 设置模型类型
     *
     * @param modelType 模型类型
     */
    public void setModelType(String modelType) {
        this.modelType = modelType == null ? null : modelType.trim();
    }

    /**
     * 获取偏移量
     *
     * @return off_set - 偏移量
     */
    public Long getOffSet() {
        return offSet;
    }

    /**
     * 设置偏移量
     *
     * @param offSet 偏移量
     */
    public void setOffSet(Long offSet) {
        this.offSet = offSet;
    }

    /**
     * 获取偏移量表达式
     *
     * @return off_set_expr - 偏移量表达式
     */
    public String getOffSetExpr() {
        return offSetExpr;
    }

    /**
     * 设置偏移量表达式
     *
     * @param offSetExpr 偏移量表达式
     */
    public void setOffSetExpr(String offSetExpr) {
        this.offSetExpr = offSetExpr == null ? null : offSetExpr.trim();
    }

    /**
     * 获取时间字段
     *
     * @return time_filed - 时间字段
     */
    public String getTimeFiled() {
        return timeFiled;
    }

    /**
     * 设置时间字段
     *
     * @param timeFiled 时间字段
     */
    public void setTimeFiled(String timeFiled) {
        this.timeFiled = timeFiled == null ? null : timeFiled.trim();
    }

    /**
     * 获取窗口类型
     *
     * @return window_type - 窗口类型
     */
    public String getWindowType() {
        return windowType;
    }

    /**
     * 设置窗口类型
     *
     * @param windowType 窗口类型
     */
    public void setWindowType(String windowType) {
        this.windowType = windowType == null ? null : windowType.trim();
    }

    /**
     * 获取窗口单位
     *
     * @return window_unit - 窗口单位
     */
    public String getWindowUnit() {
        return windowUnit;
    }

    /**
     * 设置窗口单位
     *
     * @param windowUnit 窗口单位
     */
    public void setWindowUnit(String windowUnit) {
        this.windowUnit = windowUnit == null ? null : windowUnit.trim();
    }

    /**
     * 获取窗口长度
     *
     * @return window_length - 窗口长度
     */
    public Integer getWindowLength() {
        return windowLength;
    }

    /**
     * 设置窗口长度
     *
     * @param windowLength 窗口长度
     */
    public void setWindowLength(Integer windowLength) {
        this.windowLength = windowLength;
    }

    /**
     * 获取模型状态
     *
     * @return status - 模型状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置模型状态
     *
     * @param status 模型状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取开关
     *
     * @return enable - 开关
     */
    public String getEnable() {
        return enable;
    }

    /**
     * 设置开关
     *
     * @param enable 开关
     */
    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    /**
     * 获取计算状态
     *
     * @return calculate_status - 计算状态
     */
    public String getCalculateStatus() {
        return calculateStatus;
    }

    /**
     * 设置计算状态
     *
     * @param calculateStatus 计算状态
     */
    public void setCalculateStatus(String calculateStatus) {
        this.calculateStatus = calculateStatus == null ? null : calculateStatus.trim();
    }

    /**
     * 获取聚合函数
     *
     * @return aggregates - 聚合函数
     */
    public String getAggregates() {
        return aggregates;
    }

    /**
     * 设置聚合函数
     *
     * @param aggregates 聚合函数
     */
    public void setAggregates(String aggregates) {
        this.aggregates = aggregates == null ? null : aggregates.trim();
    }

    /**
     * 获取统计条件
     *
     * @return conditions - 统计条件
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * 设置统计条件
     *
     * @param conditions 统计条件
     */
    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    /**
     * 获取统计分组
     *
     * @return groups - 统计分组
     */
    public String getGroups() {
        return groups;
    }

    /**
     * 设置统计分组
     *
     * @param groups 统计分组
     */
    public void setGroups(String groups) {
        this.groups = groups == null ? null : groups.trim();
    }

    /**
     * 获取去重分组
     *
     * @return distincts - 去重分组
     */
    public String getDistincts() {
        return distincts;
    }

    /**
     * 设置去重分组
     *
     * @param distincts 去重分组
     */
    public void setDistincts(String distincts) {
        this.distincts = distincts == null ? null : distincts.trim();
    }

    /**
     * 获取模型说明
     *
     * @return memo - 模型说明
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置模型说明
     *
     * @param memo 模型说明
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
        sb.append(", spoutName=").append(spoutName);
        sb.append(", modelName=").append(modelName);
        sb.append(", modelType=").append(modelType);
        sb.append(", offSet=").append(offSet);
        sb.append(", offSetExpr=").append(offSetExpr);
        sb.append(", timeFiled=").append(timeFiled);
        sb.append(", windowType=").append(windowType);
        sb.append(", windowUnit=").append(windowUnit);
        sb.append(", windowLength=").append(windowLength);
        sb.append(", status=").append(status);
        sb.append(", enable=").append(enable);
        sb.append(", calculateStatus=").append(calculateStatus);
        sb.append(", aggregates=").append(aggregates);
        sb.append(", conditions=").append(conditions);
        sb.append(", groups=").append(groups);
        sb.append(", distincts=").append(distincts);
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
        StatisticsModelDO other = (StatisticsModelDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpoutName() == null ? other.getSpoutName() == null : this.getSpoutName().equals(other.getSpoutName()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelType() == null ? other.getModelType() == null : this.getModelType().equals(other.getModelType()))
            && (this.getOffSet() == null ? other.getOffSet() == null : this.getOffSet().equals(other.getOffSet()))
            && (this.getOffSetExpr() == null ? other.getOffSetExpr() == null : this.getOffSetExpr().equals(other.getOffSetExpr()))
            && (this.getTimeFiled() == null ? other.getTimeFiled() == null : this.getTimeFiled().equals(other.getTimeFiled()))
            && (this.getWindowType() == null ? other.getWindowType() == null : this.getWindowType().equals(other.getWindowType()))
            && (this.getWindowUnit() == null ? other.getWindowUnit() == null : this.getWindowUnit().equals(other.getWindowUnit()))
            && (this.getWindowLength() == null ? other.getWindowLength() == null : this.getWindowLength().equals(other.getWindowLength()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getCalculateStatus() == null ? other.getCalculateStatus() == null : this.getCalculateStatus().equals(other.getCalculateStatus()))
            && (this.getAggregates() == null ? other.getAggregates() == null : this.getAggregates().equals(other.getAggregates()))
            && (this.getConditions() == null ? other.getConditions() == null : this.getConditions().equals(other.getConditions()))
            && (this.getGroups() == null ? other.getGroups() == null : this.getGroups().equals(other.getGroups()))
            && (this.getDistincts() == null ? other.getDistincts() == null : this.getDistincts().equals(other.getDistincts()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
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
        result = prime * result + ((getModelType() == null) ? 0 : getModelType().hashCode());
        result = prime * result + ((getOffSet() == null) ? 0 : getOffSet().hashCode());
        result = prime * result + ((getOffSetExpr() == null) ? 0 : getOffSetExpr().hashCode());
        result = prime * result + ((getTimeFiled() == null) ? 0 : getTimeFiled().hashCode());
        result = prime * result + ((getWindowType() == null) ? 0 : getWindowType().hashCode());
        result = prime * result + ((getWindowUnit() == null) ? 0 : getWindowUnit().hashCode());
        result = prime * result + ((getWindowLength() == null) ? 0 : getWindowLength().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getCalculateStatus() == null) ? 0 : getCalculateStatus().hashCode());
        result = prime * result + ((getAggregates() == null) ? 0 : getAggregates().hashCode());
        result = prime * result + ((getConditions() == null) ? 0 : getConditions().hashCode());
        result = prime * result + ((getGroups() == null) ? 0 : getGroups().hashCode());
        result = prime * result + ((getDistincts() == null) ? 0 : getDistincts().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}