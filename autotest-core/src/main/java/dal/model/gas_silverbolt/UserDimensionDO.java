package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_dimension")
public class UserDimensionDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 维度类型
     */
    @Column(name = "dimension_type")
    private String dimensionType;

    /**
     * 维度名称
     */
    @Column(name = "dimension_name")
    private String dimensionName;

    /**
     * 维度编码
     */
    @Column(name = "dimension_code")
    private String dimensionCode;

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
     * 获取维度类型
     *
     * @return dimension_type - 维度类型
     */
    public String getDimensionType() {
        return dimensionType;
    }

    /**
     * 设置维度类型
     *
     * @param dimensionType 维度类型
     */
    public void setDimensionType(String dimensionType) {
        this.dimensionType = dimensionType == null ? null : dimensionType.trim();
    }

    /**
     * 获取维度名称
     *
     * @return dimension_name - 维度名称
     */
    public String getDimensionName() {
        return dimensionName;
    }

    /**
     * 设置维度名称
     *
     * @param dimensionName 维度名称
     */
    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName == null ? null : dimensionName.trim();
    }

    /**
     * 获取维度编码
     *
     * @return dimension_code - 维度编码
     */
    public String getDimensionCode() {
        return dimensionCode;
    }

    /**
     * 设置维度编码
     *
     * @param dimensionCode 维度编码
     */
    public void setDimensionCode(String dimensionCode) {
        this.dimensionCode = dimensionCode == null ? null : dimensionCode.trim();
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
        sb.append(", dimensionType=").append(dimensionType);
        sb.append(", dimensionName=").append(dimensionName);
        sb.append(", dimensionCode=").append(dimensionCode);
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
        UserDimensionDO other = (UserDimensionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDimensionType() == null ? other.getDimensionType() == null : this.getDimensionType().equals(other.getDimensionType()))
            && (this.getDimensionName() == null ? other.getDimensionName() == null : this.getDimensionName().equals(other.getDimensionName()))
            && (this.getDimensionCode() == null ? other.getDimensionCode() == null : this.getDimensionCode().equals(other.getDimensionCode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDimensionType() == null) ? 0 : getDimensionType().hashCode());
        result = prime * result + ((getDimensionName() == null) ? 0 : getDimensionName().hashCode());
        result = prime * result + ((getDimensionCode() == null) ? 0 : getDimensionCode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}