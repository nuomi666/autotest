package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "statistics_group_program")
public class StatisticsGroupProgramDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 操作员ID
     */
    @Column(name = "operate_id")
    private String operateId;

    /**
     * 方案名称
     */
    @Column(name = "program_name")
    private String programName;

    /**
     * 方案编码
     */
    @Column(name = "program_code")
    private String programCode;

    /**
     * 方案类型
     */
    @Column(name = "program_type")
    private String programType;

    /**
     * 展示层级
     */
    @Column(name = "grade_type")
    private String gradeType;

    /**
     * 分组池编码
     */
    @Column(name = "pools_code")
    private String poolsCode;

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
     * 分组配置
     */
    @Column(name = "group_config")
    private String groupConfig;

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
     * 获取操作员ID
     *
     * @return operate_id - 操作员ID
     */
    public String getOperateId() {
        return operateId;
    }

    /**
     * 设置操作员ID
     *
     * @param operateId 操作员ID
     */
    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    /**
     * 获取方案名称
     *
     * @return program_name - 方案名称
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * 设置方案名称
     *
     * @param programName 方案名称
     */
    public void setProgramName(String programName) {
        this.programName = programName == null ? null : programName.trim();
    }

    /**
     * 获取方案编码
     *
     * @return program_code - 方案编码
     */
    public String getProgramCode() {
        return programCode;
    }

    /**
     * 设置方案编码
     *
     * @param programCode 方案编码
     */
    public void setProgramCode(String programCode) {
        this.programCode = programCode == null ? null : programCode.trim();
    }

    /**
     * 获取方案类型
     *
     * @return program_type - 方案类型
     */
    public String getProgramType() {
        return programType;
    }

    /**
     * 设置方案类型
     *
     * @param programType 方案类型
     */
    public void setProgramType(String programType) {
        this.programType = programType == null ? null : programType.trim();
    }

    /**
     * 获取展示层级
     *
     * @return grade_type - 展示层级
     */
    public String getGradeType() {
        return gradeType;
    }

    /**
     * 设置展示层级
     *
     * @param gradeType 展示层级
     */
    public void setGradeType(String gradeType) {
        this.gradeType = gradeType == null ? null : gradeType.trim();
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
     * 获取分组配置
     *
     * @return group_config - 分组配置
     */
    public String getGroupConfig() {
        return groupConfig;
    }

    /**
     * 设置分组配置
     *
     * @param groupConfig 分组配置
     */
    public void setGroupConfig(String groupConfig) {
        this.groupConfig = groupConfig == null ? null : groupConfig.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", operateId=").append(operateId);
        sb.append(", programName=").append(programName);
        sb.append(", programCode=").append(programCode);
        sb.append(", programType=").append(programType);
        sb.append(", gradeType=").append(gradeType);
        sb.append(", poolsCode=").append(poolsCode);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", groupConfig=").append(groupConfig);
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
        StatisticsGroupProgramDO other = (StatisticsGroupProgramDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOperateId() == null ? other.getOperateId() == null : this.getOperateId().equals(other.getOperateId()))
            && (this.getProgramName() == null ? other.getProgramName() == null : this.getProgramName().equals(other.getProgramName()))
            && (this.getProgramCode() == null ? other.getProgramCode() == null : this.getProgramCode().equals(other.getProgramCode()))
            && (this.getProgramType() == null ? other.getProgramType() == null : this.getProgramType().equals(other.getProgramType()))
            && (this.getGradeType() == null ? other.getGradeType() == null : this.getGradeType().equals(other.getGradeType()))
            && (this.getPoolsCode() == null ? other.getPoolsCode() == null : this.getPoolsCode().equals(other.getPoolsCode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getGroupConfig() == null ? other.getGroupConfig() == null : this.getGroupConfig().equals(other.getGroupConfig()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOperateId() == null) ? 0 : getOperateId().hashCode());
        result = prime * result + ((getProgramName() == null) ? 0 : getProgramName().hashCode());
        result = prime * result + ((getProgramCode() == null) ? 0 : getProgramCode().hashCode());
        result = prime * result + ((getProgramType() == null) ? 0 : getProgramType().hashCode());
        result = prime * result + ((getGradeType() == null) ? 0 : getGradeType().hashCode());
        result = prime * result + ((getPoolsCode() == null) ? 0 : getPoolsCode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getGroupConfig() == null) ? 0 : getGroupConfig().hashCode());
        return result;
    }
}