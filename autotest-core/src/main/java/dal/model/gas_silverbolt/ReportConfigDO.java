package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "report_config")
public class ReportConfigDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 报表名称
     */
    @Column(name = "report_name")
    private String reportName;

    /**
     * 报表类型
     */
    @Column(name = "report_code")
    private String reportCode;

    /**
     * 报表粒度
     */
    @Column(name = "report_unit")
    private String reportUnit;

    /**
     * 偏移量毫秒数
     */
    @Column(name = "off_set")
    private Long offSet;

    /**
     * 偏移量表达式
     */
    @Column(name = "off_set_expr")
    private String offSetExpr;

    /**
     * 报表状态
     */
    @Column(name = "report_status")
    private String reportStatus;

    /**
     * 说明
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

    /**
     * 关联统计模型
     */
    @Column(name = "statistic_model")
    private String statisticModel;

    /**
     * 报表字段
     */
    @Column(name = "report_column")
    private String reportColumn;

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
     * 获取报表名称
     *
     * @return report_name - 报表名称
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * 设置报表名称
     *
     * @param reportName 报表名称
     */
    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    /**
     * 获取报表类型
     *
     * @return report_code - 报表类型
     */
    public String getReportCode() {
        return reportCode;
    }

    /**
     * 设置报表类型
     *
     * @param reportCode 报表类型
     */
    public void setReportCode(String reportCode) {
        this.reportCode = reportCode == null ? null : reportCode.trim();
    }

    /**
     * 获取报表粒度
     *
     * @return report_unit - 报表粒度
     */
    public String getReportUnit() {
        return reportUnit;
    }

    /**
     * 设置报表粒度
     *
     * @param reportUnit 报表粒度
     */
    public void setReportUnit(String reportUnit) {
        this.reportUnit = reportUnit == null ? null : reportUnit.trim();
    }

    /**
     * 获取偏移量毫秒数
     *
     * @return off_set - 偏移量毫秒数
     */
    public Long getOffSet() {
        return offSet;
    }

    /**
     * 设置偏移量毫秒数
     *
     * @param offSet 偏移量毫秒数
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
     * 获取报表状态
     *
     * @return report_status - 报表状态
     */
    public String getReportStatus() {
        return reportStatus;
    }

    /**
     * 设置报表状态
     *
     * @param reportStatus 报表状态
     */
    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus == null ? null : reportStatus.trim();
    }

    /**
     * 获取说明
     *
     * @return memo - 说明
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置说明
     *
     * @param memo 说明
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

    /**
     * 获取关联统计模型
     *
     * @return statistic_model - 关联统计模型
     */
    public String getStatisticModel() {
        return statisticModel;
    }

    /**
     * 设置关联统计模型
     *
     * @param statisticModel 关联统计模型
     */
    public void setStatisticModel(String statisticModel) {
        this.statisticModel = statisticModel == null ? null : statisticModel.trim();
    }

    /**
     * 获取报表字段
     *
     * @return report_column - 报表字段
     */
    public String getReportColumn() {
        return reportColumn;
    }

    /**
     * 设置报表字段
     *
     * @param reportColumn 报表字段
     */
    public void setReportColumn(String reportColumn) {
        this.reportColumn = reportColumn == null ? null : reportColumn.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", reportName=").append(reportName);
        sb.append(", reportCode=").append(reportCode);
        sb.append(", reportUnit=").append(reportUnit);
        sb.append(", offSet=").append(offSet);
        sb.append(", offSetExpr=").append(offSetExpr);
        sb.append(", reportStatus=").append(reportStatus);
        sb.append(", memo=").append(memo);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", statisticModel=").append(statisticModel);
        sb.append(", reportColumn=").append(reportColumn);
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
        ReportConfigDO other = (ReportConfigDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReportName() == null ? other.getReportName() == null : this.getReportName().equals(other.getReportName()))
            && (this.getReportCode() == null ? other.getReportCode() == null : this.getReportCode().equals(other.getReportCode()))
            && (this.getReportUnit() == null ? other.getReportUnit() == null : this.getReportUnit().equals(other.getReportUnit()))
            && (this.getOffSet() == null ? other.getOffSet() == null : this.getOffSet().equals(other.getOffSet()))
            && (this.getOffSetExpr() == null ? other.getOffSetExpr() == null : this.getOffSetExpr().equals(other.getOffSetExpr()))
            && (this.getReportStatus() == null ? other.getReportStatus() == null : this.getReportStatus().equals(other.getReportStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getStatisticModel() == null ? other.getStatisticModel() == null : this.getStatisticModel().equals(other.getStatisticModel()))
            && (this.getReportColumn() == null ? other.getReportColumn() == null : this.getReportColumn().equals(other.getReportColumn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReportName() == null) ? 0 : getReportName().hashCode());
        result = prime * result + ((getReportCode() == null) ? 0 : getReportCode().hashCode());
        result = prime * result + ((getReportUnit() == null) ? 0 : getReportUnit().hashCode());
        result = prime * result + ((getOffSet() == null) ? 0 : getOffSet().hashCode());
        result = prime * result + ((getOffSetExpr() == null) ? 0 : getOffSetExpr().hashCode());
        result = prime * result + ((getReportStatus() == null) ? 0 : getReportStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getStatisticModel() == null) ? 0 : getStatisticModel().hashCode());
        result = prime * result + ((getReportColumn() == null) ? 0 : getReportColumn().hashCode());
        return result;
    }
}