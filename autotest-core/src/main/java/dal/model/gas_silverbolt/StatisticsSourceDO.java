package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_source")
public class StatisticsSourceDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 表名
     */
    @Column(name = "source_table")
    private String sourceTable;

    /**
     * 主键字段
     */
    @Column(name = "id_filed")
    private String idFiled;

    /**
     * 时间统计字段
     */
    @Column(name = "time_filed")
    private String timeFiled;

    /**
     * 统计字段
     */
    @Column(name = "table_column")
    private String tableColumn;

    /**
     * 统计步长
     */
    private Long step;

    /**
     * 起始数
     */
    @Column(name = "start_size")
    private Long startSize;

    /**
     * 结束数
     */
    @Column(name = "end_size")
    private Long endSize;

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
     * 获取表名
     *
     * @return source_table - 表名
     */
    public String getSourceTable() {
        return sourceTable;
    }

    /**
     * 设置表名
     *
     * @param sourceTable 表名
     */
    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable == null ? null : sourceTable.trim();
    }

    /**
     * 获取主键字段
     *
     * @return id_filed - 主键字段
     */
    public String getIdFiled() {
        return idFiled;
    }

    /**
     * 设置主键字段
     *
     * @param idFiled 主键字段
     */
    public void setIdFiled(String idFiled) {
        this.idFiled = idFiled == null ? null : idFiled.trim();
    }

    /**
     * 获取时间统计字段
     *
     * @return time_filed - 时间统计字段
     */
    public String getTimeFiled() {
        return timeFiled;
    }

    /**
     * 设置时间统计字段
     *
     * @param timeFiled 时间统计字段
     */
    public void setTimeFiled(String timeFiled) {
        this.timeFiled = timeFiled == null ? null : timeFiled.trim();
    }

    /**
     * 获取统计字段
     *
     * @return table_column - 统计字段
     */
    public String getTableColumn() {
        return tableColumn;
    }

    /**
     * 设置统计字段
     *
     * @param tableColumn 统计字段
     */
    public void setTableColumn(String tableColumn) {
        this.tableColumn = tableColumn == null ? null : tableColumn.trim();
    }

    /**
     * 获取统计步长
     *
     * @return step - 统计步长
     */
    public Long getStep() {
        return step;
    }

    /**
     * 设置统计步长
     *
     * @param step 统计步长
     */
    public void setStep(Long step) {
        this.step = step;
    }

    /**
     * 获取起始数
     *
     * @return start_size - 起始数
     */
    public Long getStartSize() {
        return startSize;
    }

    /**
     * 设置起始数
     *
     * @param startSize 起始数
     */
    public void setStartSize(Long startSize) {
        this.startSize = startSize;
    }

    /**
     * 获取结束数
     *
     * @return end_size - 结束数
     */
    public Long getEndSize() {
        return endSize;
    }

    /**
     * 设置结束数
     *
     * @param endSize 结束数
     */
    public void setEndSize(Long endSize) {
        this.endSize = endSize;
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
        sb.append(", sourceTable=").append(sourceTable);
        sb.append(", idFiled=").append(idFiled);
        sb.append(", timeFiled=").append(timeFiled);
        sb.append(", tableColumn=").append(tableColumn);
        sb.append(", step=").append(step);
        sb.append(", startSize=").append(startSize);
        sb.append(", endSize=").append(endSize);
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
        StatisticsSourceDO other = (StatisticsSourceDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSourceTable() == null ? other.getSourceTable() == null : this.getSourceTable().equals(other.getSourceTable()))
            && (this.getIdFiled() == null ? other.getIdFiled() == null : this.getIdFiled().equals(other.getIdFiled()))
            && (this.getTimeFiled() == null ? other.getTimeFiled() == null : this.getTimeFiled().equals(other.getTimeFiled()))
            && (this.getTableColumn() == null ? other.getTableColumn() == null : this.getTableColumn().equals(other.getTableColumn()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getStartSize() == null ? other.getStartSize() == null : this.getStartSize().equals(other.getStartSize()))
            && (this.getEndSize() == null ? other.getEndSize() == null : this.getEndSize().equals(other.getEndSize()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSourceTable() == null) ? 0 : getSourceTable().hashCode());
        result = prime * result + ((getIdFiled() == null) ? 0 : getIdFiled().hashCode());
        result = prime * result + ((getTimeFiled() == null) ? 0 : getTimeFiled().hashCode());
        result = prime * result + ((getTableColumn() == null) ? 0 : getTableColumn().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getStartSize() == null) ? 0 : getStartSize().hashCode());
        result = prime * result + ((getEndSize() == null) ? 0 : getEndSize().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}