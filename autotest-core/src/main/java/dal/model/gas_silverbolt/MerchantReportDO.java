package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_report")
public class MerchantReportDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 商户报表配置ID
     */
    @Column(name = "report_id")
    private Long reportId;

    /**
     * 报表配置id
     */
    @Column(name = "report_code")
    private String reportCode;

    /**
     * 报表角色
     */
    @Column(name = "report_rule")
    private String reportRule;

    /**
     * 角色名称
     */
    @Column(name = "rule_name")
    private String ruleName;

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
     * 获取商户报表配置ID
     *
     * @return report_id - 商户报表配置ID
     */
    public Long getReportId() {
        return reportId;
    }

    /**
     * 设置商户报表配置ID
     *
     * @param reportId 商户报表配置ID
     */
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    /**
     * 获取报表配置id
     *
     * @return report_code - 报表配置id
     */
    public String getReportCode() {
        return reportCode;
    }

    /**
     * 设置报表配置id
     *
     * @param reportCode 报表配置id
     */
    public void setReportCode(String reportCode) {
        this.reportCode = reportCode == null ? null : reportCode.trim();
    }

    /**
     * 获取报表角色
     *
     * @return report_rule - 报表角色
     */
    public String getReportRule() {
        return reportRule;
    }

    /**
     * 设置报表角色
     *
     * @param reportRule 报表角色
     */
    public void setReportRule(String reportRule) {
        this.reportRule = reportRule == null ? null : reportRule.trim();
    }

    /**
     * 获取角色名称
     *
     * @return rule_name - 角色名称
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * 设置角色名称
     *
     * @param ruleName 角色名称
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", reportId=").append(reportId);
        sb.append(", reportCode=").append(reportCode);
        sb.append(", reportRule=").append(reportRule);
        sb.append(", ruleName=").append(ruleName);
        sb.append(", reportStatus=").append(reportStatus);
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
        MerchantReportDO other = (MerchantReportDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getReportId() == null ? other.getReportId() == null : this.getReportId().equals(other.getReportId()))
            && (this.getReportCode() == null ? other.getReportCode() == null : this.getReportCode().equals(other.getReportCode()))
            && (this.getReportRule() == null ? other.getReportRule() == null : this.getReportRule().equals(other.getReportRule()))
            && (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
            && (this.getReportStatus() == null ? other.getReportStatus() == null : this.getReportStatus().equals(other.getReportStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getReportId() == null) ? 0 : getReportId().hashCode());
        result = prime * result + ((getReportCode() == null) ? 0 : getReportCode().hashCode());
        result = prime * result + ((getReportRule() == null) ? 0 : getReportRule().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getReportStatus() == null) ? 0 : getReportStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}