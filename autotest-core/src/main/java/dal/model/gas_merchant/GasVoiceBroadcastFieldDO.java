package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_voice_broadcast_field")
public class GasVoiceBroadcastFieldDO implements Serializable {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 播报类型
     */
    @Column(name = "broadcast_type")
    private String broadcastType;

    /**
     * 字段编码
     */
    @Column(name = "field_code")
    private String fieldCode;

    /**
     * 字段名称
     */
    @Column(name = "field_name")
    private String fieldName;

    /**
     * 前缀描述
     */
    @Column(name = "pre_value")
    private String preValue;

    /**
     * 默认值
     */
    @Column(name = "default_value")
    private String defaultValue;

    /**
     * 后缀描述
     */
    @Column(name = "suffix_value")
    private String suffixValue;

    /**
     * 是否必选
     */
    private String required;

    /**
     * 新增时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键Id
     *
     * @return id - 主键Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键Id
     *
     * @param id 主键Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取播报类型
     *
     * @return broadcast_type - 播报类型
     */
    public String getBroadcastType() {
        return broadcastType;
    }

    /**
     * 设置播报类型
     *
     * @param broadcastType 播报类型
     */
    public void setBroadcastType(String broadcastType) {
        this.broadcastType = broadcastType == null ? null : broadcastType.trim();
    }

    /**
     * 获取字段编码
     *
     * @return field_code - 字段编码
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * 设置字段编码
     *
     * @param fieldCode 字段编码
     */
    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }

    /**
     * 获取字段名称
     *
     * @return field_name - 字段名称
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段名称
     *
     * @param fieldName 字段名称
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     * 获取前缀描述
     *
     * @return pre_value - 前缀描述
     */
    public String getPreValue() {
        return preValue;
    }

    /**
     * 设置前缀描述
     *
     * @param preValue 前缀描述
     */
    public void setPreValue(String preValue) {
        this.preValue = preValue == null ? null : preValue.trim();
    }

    /**
     * 获取默认值
     *
     * @return default_value - 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置默认值
     *
     * @param defaultValue 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 获取后缀描述
     *
     * @return suffix_value - 后缀描述
     */
    public String getSuffixValue() {
        return suffixValue;
    }

    /**
     * 设置后缀描述
     *
     * @param suffixValue 后缀描述
     */
    public void setSuffixValue(String suffixValue) {
        this.suffixValue = suffixValue == null ? null : suffixValue.trim();
    }

    /**
     * 获取是否必选
     *
     * @return required - 是否必选
     */
    public String getRequired() {
        return required;
    }

    /**
     * 设置是否必选
     *
     * @param required 是否必选
     */
    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
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
        sb.append(", broadcastType=").append(broadcastType);
        sb.append(", fieldCode=").append(fieldCode);
        sb.append(", fieldName=").append(fieldName);
        sb.append(", preValue=").append(preValue);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append(", suffixValue=").append(suffixValue);
        sb.append(", required=").append(required);
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
        GasVoiceBroadcastFieldDO other = (GasVoiceBroadcastFieldDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBroadcastType() == null ? other.getBroadcastType() == null : this.getBroadcastType().equals(other.getBroadcastType()))
            && (this.getFieldCode() == null ? other.getFieldCode() == null : this.getFieldCode().equals(other.getFieldCode()))
            && (this.getFieldName() == null ? other.getFieldName() == null : this.getFieldName().equals(other.getFieldName()))
            && (this.getPreValue() == null ? other.getPreValue() == null : this.getPreValue().equals(other.getPreValue()))
            && (this.getDefaultValue() == null ? other.getDefaultValue() == null : this.getDefaultValue().equals(other.getDefaultValue()))
            && (this.getSuffixValue() == null ? other.getSuffixValue() == null : this.getSuffixValue().equals(other.getSuffixValue()))
            && (this.getRequired() == null ? other.getRequired() == null : this.getRequired().equals(other.getRequired()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBroadcastType() == null) ? 0 : getBroadcastType().hashCode());
        result = prime * result + ((getFieldCode() == null) ? 0 : getFieldCode().hashCode());
        result = prime * result + ((getFieldName() == null) ? 0 : getFieldName().hashCode());
        result = prime * result + ((getPreValue() == null) ? 0 : getPreValue().hashCode());
        result = prime * result + ((getDefaultValue() == null) ? 0 : getDefaultValue().hashCode());
        result = prime * result + ((getSuffixValue() == null) ? 0 : getSuffixValue().hashCode());
        result = prime * result + ((getRequired() == null) ? 0 : getRequired().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}