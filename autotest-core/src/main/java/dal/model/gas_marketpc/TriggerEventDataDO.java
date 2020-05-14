package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "trigger_event_data")
public class TriggerEventDataDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事件路由
     */
    @Column(name = "event_route")
    private String eventRoute;

    /**
     * 属性名称
     */
    @Column(name = "key_name")
    private String keyName;

    /**
     * 属性编码
     */
    @Column(name = "key_code")
    private String keyCode;

    /**
     * 属性来源
     */
    @Column(name = "data_source")
    private String dataSource;

    /**
     * 数据模型名称
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 属性类型
     */
    @Column(name = "key_type")
    private String keyType;

    /**
     * 枚举定义
     */
    private String enums;

    /**
     * 新增时间
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
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取事件路由
     *
     * @return event_route - 事件路由
     */
    public String getEventRoute() {
        return eventRoute;
    }

    /**
     * 设置事件路由
     *
     * @param eventRoute 事件路由
     */
    public void setEventRoute(String eventRoute) {
        this.eventRoute = eventRoute == null ? null : eventRoute.trim();
    }

    /**
     * 获取属性名称
     *
     * @return key_name - 属性名称
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * 设置属性名称
     *
     * @param keyName 属性名称
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    /**
     * 获取属性编码
     *
     * @return key_code - 属性编码
     */
    public String getKeyCode() {
        return keyCode;
    }

    /**
     * 设置属性编码
     *
     * @param keyCode 属性编码
     */
    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode == null ? null : keyCode.trim();
    }

    /**
     * 获取属性来源
     *
     * @return data_source - 属性来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置属性来源
     *
     * @param dataSource 属性来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    /**
     * 获取数据模型名称
     *
     * @return module_name - 数据模型名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置数据模型名称
     *
     * @param moduleName 数据模型名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 获取属性类型
     *
     * @return key_type - 属性类型
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     * 设置属性类型
     *
     * @param keyType 属性类型
     */
    public void setKeyType(String keyType) {
        this.keyType = keyType == null ? null : keyType.trim();
    }

    /**
     * 获取枚举定义
     *
     * @return enums - 枚举定义
     */
    public String getEnums() {
        return enums;
    }

    /**
     * 设置枚举定义
     *
     * @param enums 枚举定义
     */
    public void setEnums(String enums) {
        this.enums = enums == null ? null : enums.trim();
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
        sb.append(", eventRoute=").append(eventRoute);
        sb.append(", keyName=").append(keyName);
        sb.append(", keyCode=").append(keyCode);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", keyType=").append(keyType);
        sb.append(", enums=").append(enums);
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
        TriggerEventDataDO other = (TriggerEventDataDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEventRoute() == null ? other.getEventRoute() == null : this.getEventRoute().equals(other.getEventRoute()))
            && (this.getKeyName() == null ? other.getKeyName() == null : this.getKeyName().equals(other.getKeyName()))
            && (this.getKeyCode() == null ? other.getKeyCode() == null : this.getKeyCode().equals(other.getKeyCode()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getKeyType() == null ? other.getKeyType() == null : this.getKeyType().equals(other.getKeyType()))
            && (this.getEnums() == null ? other.getEnums() == null : this.getEnums().equals(other.getEnums()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventRoute() == null) ? 0 : getEventRoute().hashCode());
        result = prime * result + ((getKeyName() == null) ? 0 : getKeyName().hashCode());
        result = prime * result + ((getKeyCode() == null) ? 0 : getKeyCode().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getKeyType() == null) ? 0 : getKeyType().hashCode());
        result = prime * result + ((getEnums() == null) ? 0 : getEnums().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}