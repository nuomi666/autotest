package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "personas_condition")
public class PersonasConditionDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 条件类型
     */
    @Column(name = "condition_type")
    private String conditionType;

    /**
     * 条件名称
     */
    @Column(name = "condition_name")
    private String conditionName;

    /**
     * 条件编码
     */
    @Column(name = "condition_code")
    private String conditionCode;

    /**
     * 条件字段
     */
    @Column(name = "condition_column")
    private String conditionColumn;

    /**
     * 字段类型
     */
    @Column(name = "filed_type")
    private String filedType;

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
     * 获取条件类型
     *
     * @return condition_type - 条件类型
     */
    public String getConditionType() {
        return conditionType;
    }

    /**
     * 设置条件类型
     *
     * @param conditionType 条件类型
     */
    public void setConditionType(String conditionType) {
        this.conditionType = conditionType == null ? null : conditionType.trim();
    }

    /**
     * 获取条件名称
     *
     * @return condition_name - 条件名称
     */
    public String getConditionName() {
        return conditionName;
    }

    /**
     * 设置条件名称
     *
     * @param conditionName 条件名称
     */
    public void setConditionName(String conditionName) {
        this.conditionName = conditionName == null ? null : conditionName.trim();
    }

    /**
     * 获取条件编码
     *
     * @return condition_code - 条件编码
     */
    public String getConditionCode() {
        return conditionCode;
    }

    /**
     * 设置条件编码
     *
     * @param conditionCode 条件编码
     */
    public void setConditionCode(String conditionCode) {
        this.conditionCode = conditionCode == null ? null : conditionCode.trim();
    }

    /**
     * 获取条件字段
     *
     * @return condition_column - 条件字段
     */
    public String getConditionColumn() {
        return conditionColumn;
    }

    /**
     * 设置条件字段
     *
     * @param conditionColumn 条件字段
     */
    public void setConditionColumn(String conditionColumn) {
        this.conditionColumn = conditionColumn == null ? null : conditionColumn.trim();
    }

    /**
     * 获取字段类型
     *
     * @return filed_type - 字段类型
     */
    public String getFiledType() {
        return filedType;
    }

    /**
     * 设置字段类型
     *
     * @param filedType 字段类型
     */
    public void setFiledType(String filedType) {
        this.filedType = filedType == null ? null : filedType.trim();
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
        sb.append(", conditionType=").append(conditionType);
        sb.append(", conditionName=").append(conditionName);
        sb.append(", conditionCode=").append(conditionCode);
        sb.append(", conditionColumn=").append(conditionColumn);
        sb.append(", filedType=").append(filedType);
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
        PersonasConditionDO other = (PersonasConditionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getConditionType() == null ? other.getConditionType() == null : this.getConditionType().equals(other.getConditionType()))
            && (this.getConditionName() == null ? other.getConditionName() == null : this.getConditionName().equals(other.getConditionName()))
            && (this.getConditionCode() == null ? other.getConditionCode() == null : this.getConditionCode().equals(other.getConditionCode()))
            && (this.getConditionColumn() == null ? other.getConditionColumn() == null : this.getConditionColumn().equals(other.getConditionColumn()))
            && (this.getFiledType() == null ? other.getFiledType() == null : this.getFiledType().equals(other.getFiledType()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getConditionType() == null) ? 0 : getConditionType().hashCode());
        result = prime * result + ((getConditionName() == null) ? 0 : getConditionName().hashCode());
        result = prime * result + ((getConditionCode() == null) ? 0 : getConditionCode().hashCode());
        result = prime * result + ((getConditionColumn() == null) ? 0 : getConditionColumn().hashCode());
        result = prime * result + ((getFiledType() == null) ? 0 : getFiledType().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}