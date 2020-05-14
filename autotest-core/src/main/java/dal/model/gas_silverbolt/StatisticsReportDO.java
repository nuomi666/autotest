package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_report")
public class StatisticsReportDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 统计索引
     */
    @Column(name = "row_key")
    private String rowKey;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户名称
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 报表类型
     */
    @Column(name = "report_type")
    private String reportType;

    /**
     * 分组值
     */
    private String groups;

    /**
     * 分组值md5
     */
    @Column(name = "groups_index")
    private String groupsIndex;

    /**
     * 条件值
     */
    private String conditions;

    /**
     * 条件值md5
     */
    @Column(name = "conditions_index")
    private String conditionsIndex;

    /**
     * 统计时间
     */
    @Column(name = "statistics_time")
    private Date statisticsTime;

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
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取商户名称
     *
     * @return partner_name - 商户名称
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商户名称
     *
     * @param partnerName 商户名称
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取报表类型
     *
     * @return report_type - 报表类型
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * 设置报表类型
     *
     * @param reportType 报表类型
     */
    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
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

    /**
     * 获取分组值md5
     *
     * @return groups_index - 分组值md5
     */
    public String getGroupsIndex() {
        return groupsIndex;
    }

    /**
     * 设置分组值md5
     *
     * @param groupsIndex 分组值md5
     */
    public void setGroupsIndex(String groupsIndex) {
        this.groupsIndex = groupsIndex == null ? null : groupsIndex.trim();
    }

    /**
     * 获取条件值
     *
     * @return conditions - 条件值
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * 设置条件值
     *
     * @param conditions 条件值
     */
    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    /**
     * 获取条件值md5
     *
     * @return conditions_index - 条件值md5
     */
    public String getConditionsIndex() {
        return conditionsIndex;
    }

    /**
     * 设置条件值md5
     *
     * @param conditionsIndex 条件值md5
     */
    public void setConditionsIndex(String conditionsIndex) {
        this.conditionsIndex = conditionsIndex == null ? null : conditionsIndex.trim();
    }

    /**
     * 获取统计时间
     *
     * @return statistics_time - 统计时间
     */
    public Date getStatisticsTime() {
        return statisticsTime;
    }

    /**
     * 设置统计时间
     *
     * @param statisticsTime 统计时间
     */
    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
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
        sb.append(", rowKey=").append(rowKey);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", reportType=").append(reportType);
        sb.append(", groups=").append(groups);
        sb.append(", groupsIndex=").append(groupsIndex);
        sb.append(", conditions=").append(conditions);
        sb.append(", conditionsIndex=").append(conditionsIndex);
        sb.append(", statisticsTime=").append(statisticsTime);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
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
        StatisticsReportDO other = (StatisticsReportDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRowKey() == null ? other.getRowKey() == null : this.getRowKey().equals(other.getRowKey()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getReportType() == null ? other.getReportType() == null : this.getReportType().equals(other.getReportType()))
            && (this.getGroups() == null ? other.getGroups() == null : this.getGroups().equals(other.getGroups()))
            && (this.getGroupsIndex() == null ? other.getGroupsIndex() == null : this.getGroupsIndex().equals(other.getGroupsIndex()))
            && (this.getConditions() == null ? other.getConditions() == null : this.getConditions().equals(other.getConditions()))
            && (this.getConditionsIndex() == null ? other.getConditionsIndex() == null : this.getConditionsIndex().equals(other.getConditionsIndex()))
            && (this.getStatisticsTime() == null ? other.getStatisticsTime() == null : this.getStatisticsTime().equals(other.getStatisticsTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getReportColumn() == null ? other.getReportColumn() == null : this.getReportColumn().equals(other.getReportColumn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRowKey() == null) ? 0 : getRowKey().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getReportType() == null) ? 0 : getReportType().hashCode());
        result = prime * result + ((getGroups() == null) ? 0 : getGroups().hashCode());
        result = prime * result + ((getGroupsIndex() == null) ? 0 : getGroupsIndex().hashCode());
        result = prime * result + ((getConditions() == null) ? 0 : getConditions().hashCode());
        result = prime * result + ((getConditionsIndex() == null) ? 0 : getConditionsIndex().hashCode());
        result = prime * result + ((getStatisticsTime() == null) ? 0 : getStatisticsTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getReportColumn() == null) ? 0 : getReportColumn().hashCode());
        return result;
    }
}