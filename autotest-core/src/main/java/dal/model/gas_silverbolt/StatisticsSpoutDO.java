package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_spout")
public class StatisticsSpoutDO implements Serializable {
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
     * 扫描表
     */
    @Column(name = "scan_table")
    private String scanTable;

    /**
     * 扫描字段
     */
    @Column(name = "scan_file")
    private String scanFile;

    /**
     * 字段类型
     */
    @Column(name = "scan_type")
    private String scanType;

    /**
     * 扫描步长
     */
    private Long step;

    /**
     * 过滤条件
     */
    private String filter;

    /**
     * 扫描字段
     */
    @Column(name = "scan_column")
    private String scanColumn;

    /**
     * 数据源说明
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
     * 获取扫描表
     *
     * @return scan_table - 扫描表
     */
    public String getScanTable() {
        return scanTable;
    }

    /**
     * 设置扫描表
     *
     * @param scanTable 扫描表
     */
    public void setScanTable(String scanTable) {
        this.scanTable = scanTable == null ? null : scanTable.trim();
    }

    /**
     * 获取扫描字段
     *
     * @return scan_file - 扫描字段
     */
    public String getScanFile() {
        return scanFile;
    }

    /**
     * 设置扫描字段
     *
     * @param scanFile 扫描字段
     */
    public void setScanFile(String scanFile) {
        this.scanFile = scanFile == null ? null : scanFile.trim();
    }

    /**
     * 获取字段类型
     *
     * @return scan_type - 字段类型
     */
    public String getScanType() {
        return scanType;
    }

    /**
     * 设置字段类型
     *
     * @param scanType 字段类型
     */
    public void setScanType(String scanType) {
        this.scanType = scanType == null ? null : scanType.trim();
    }

    /**
     * 获取扫描步长
     *
     * @return step - 扫描步长
     */
    public Long getStep() {
        return step;
    }

    /**
     * 设置扫描步长
     *
     * @param step 扫描步长
     */
    public void setStep(Long step) {
        this.step = step;
    }

    /**
     * 获取过滤条件
     *
     * @return filter - 过滤条件
     */
    public String getFilter() {
        return filter;
    }

    /**
     * 设置过滤条件
     *
     * @param filter 过滤条件
     */
    public void setFilter(String filter) {
        this.filter = filter == null ? null : filter.trim();
    }

    /**
     * 获取扫描字段
     *
     * @return scan_column - 扫描字段
     */
    public String getScanColumn() {
        return scanColumn;
    }

    /**
     * 设置扫描字段
     *
     * @param scanColumn 扫描字段
     */
    public void setScanColumn(String scanColumn) {
        this.scanColumn = scanColumn == null ? null : scanColumn.trim();
    }

    /**
     * 获取数据源说明
     *
     * @return memo - 数据源说明
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置数据源说明
     *
     * @param memo 数据源说明
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
        sb.append(", scanTable=").append(scanTable);
        sb.append(", scanFile=").append(scanFile);
        sb.append(", scanType=").append(scanType);
        sb.append(", step=").append(step);
        sb.append(", filter=").append(filter);
        sb.append(", scanColumn=").append(scanColumn);
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
        StatisticsSpoutDO other = (StatisticsSpoutDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpoutName() == null ? other.getSpoutName() == null : this.getSpoutName().equals(other.getSpoutName()))
            && (this.getScanTable() == null ? other.getScanTable() == null : this.getScanTable().equals(other.getScanTable()))
            && (this.getScanFile() == null ? other.getScanFile() == null : this.getScanFile().equals(other.getScanFile()))
            && (this.getScanType() == null ? other.getScanType() == null : this.getScanType().equals(other.getScanType()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getFilter() == null ? other.getFilter() == null : this.getFilter().equals(other.getFilter()))
            && (this.getScanColumn() == null ? other.getScanColumn() == null : this.getScanColumn().equals(other.getScanColumn()))
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
        result = prime * result + ((getScanTable() == null) ? 0 : getScanTable().hashCode());
        result = prime * result + ((getScanFile() == null) ? 0 : getScanFile().hashCode());
        result = prime * result + ((getScanType() == null) ? 0 : getScanType().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getFilter() == null) ? 0 : getFilter().hashCode());
        result = prime * result + ((getScanColumn() == null) ? 0 : getScanColumn().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}