package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_persona")
public class UserPersonaDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "persona_name")
    private String personaName;

    /**
     * 模型编码
     */
    @Column(name = "persona_code")
    private String personaCode;

    /**
     * 统计起始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 统计结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 运行状态
     */
    private String status;

    /**
     * 计算状态
     */
    @Column(name = "calculate_status")
    private String calculateStatus;

    /**
     * 扫描数据次数
     */
    @Column(name = "scan_count")
    private Integer scanCount;

    /**
     * 扫描数据大小
     */
    @Column(name = "scan_size")
    private Integer scanSize;

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
     * 过滤条件
     */
    @Column(name = "filed_condition")
    private String filedCondition;

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
     * 获取名称
     *
     * @return persona_name - 名称
     */
    public String getPersonaName() {
        return personaName;
    }

    /**
     * 设置名称
     *
     * @param personaName 名称
     */
    public void setPersonaName(String personaName) {
        this.personaName = personaName == null ? null : personaName.trim();
    }

    /**
     * 获取模型编码
     *
     * @return persona_code - 模型编码
     */
    public String getPersonaCode() {
        return personaCode;
    }

    /**
     * 设置模型编码
     *
     * @param personaCode 模型编码
     */
    public void setPersonaCode(String personaCode) {
        this.personaCode = personaCode == null ? null : personaCode.trim();
    }

    /**
     * 获取统计起始时间
     *
     * @return start_time - 统计起始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置统计起始时间
     *
     * @param startTime 统计起始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取统计结束时间
     *
     * @return end_time - 统计结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置统计结束时间
     *
     * @param endTime 统计结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取运行状态
     *
     * @return status - 运行状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置运行状态
     *
     * @param status 运行状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 获取扫描数据次数
     *
     * @return scan_count - 扫描数据次数
     */
    public Integer getScanCount() {
        return scanCount;
    }

    /**
     * 设置扫描数据次数
     *
     * @param scanCount 扫描数据次数
     */
    public void setScanCount(Integer scanCount) {
        this.scanCount = scanCount;
    }

    /**
     * 获取扫描数据大小
     *
     * @return scan_size - 扫描数据大小
     */
    public Integer getScanSize() {
        return scanSize;
    }

    /**
     * 设置扫描数据大小
     *
     * @param scanSize 扫描数据大小
     */
    public void setScanSize(Integer scanSize) {
        this.scanSize = scanSize;
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
     * 获取过滤条件
     *
     * @return filed_condition - 过滤条件
     */
    public String getFiledCondition() {
        return filedCondition;
    }

    /**
     * 设置过滤条件
     *
     * @param filedCondition 过滤条件
     */
    public void setFiledCondition(String filedCondition) {
        this.filedCondition = filedCondition == null ? null : filedCondition.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", personaName=").append(personaName);
        sb.append(", personaCode=").append(personaCode);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", calculateStatus=").append(calculateStatus);
        sb.append(", scanCount=").append(scanCount);
        sb.append(", scanSize=").append(scanSize);
        sb.append(", memo=").append(memo);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", filedCondition=").append(filedCondition);
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
        UserPersonaDO other = (UserPersonaDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonaName() == null ? other.getPersonaName() == null : this.getPersonaName().equals(other.getPersonaName()))
            && (this.getPersonaCode() == null ? other.getPersonaCode() == null : this.getPersonaCode().equals(other.getPersonaCode()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCalculateStatus() == null ? other.getCalculateStatus() == null : this.getCalculateStatus().equals(other.getCalculateStatus()))
            && (this.getScanCount() == null ? other.getScanCount() == null : this.getScanCount().equals(other.getScanCount()))
            && (this.getScanSize() == null ? other.getScanSize() == null : this.getScanSize().equals(other.getScanSize()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getFiledCondition() == null ? other.getFiledCondition() == null : this.getFiledCondition().equals(other.getFiledCondition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonaName() == null) ? 0 : getPersonaName().hashCode());
        result = prime * result + ((getPersonaCode() == null) ? 0 : getPersonaCode().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCalculateStatus() == null) ? 0 : getCalculateStatus().hashCode());
        result = prime * result + ((getScanCount() == null) ? 0 : getScanCount().hashCode());
        result = prime * result + ((getScanSize() == null) ? 0 : getScanSize().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getFiledCondition() == null) ? 0 : getFiledCondition().hashCode());
        return result;
    }
}