package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "group_script")
public class GroupScriptDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 字段编码
     */
    @Column(name = "column_code")
    private String columnCode;

    /**
     * 标题
     */
    private String title;

    /**
     * 级联等级
     */
    @Column(name = "cascade_level")
    private Integer cascadeLevel;

    /**
     * 脚本作用
     */
    @Column(name = "script_function")
    private String scriptFunction;

    /**
     * 脚本类型
     */
    @Column(name = "script_type")
    private String scriptType;

    /**
     * 脚本
     */
    private String script;

    /**
     * 描述
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
     * 获取字段编码
     *
     * @return column_code - 字段编码
     */
    public String getColumnCode() {
        return columnCode;
    }

    /**
     * 设置字段编码
     *
     * @param columnCode 字段编码
     */
    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode == null ? null : columnCode.trim();
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取级联等级
     *
     * @return cascade_level - 级联等级
     */
    public Integer getCascadeLevel() {
        return cascadeLevel;
    }

    /**
     * 设置级联等级
     *
     * @param cascadeLevel 级联等级
     */
    public void setCascadeLevel(Integer cascadeLevel) {
        this.cascadeLevel = cascadeLevel;
    }

    /**
     * 获取脚本作用
     *
     * @return script_function - 脚本作用
     */
    public String getScriptFunction() {
        return scriptFunction;
    }

    /**
     * 设置脚本作用
     *
     * @param scriptFunction 脚本作用
     */
    public void setScriptFunction(String scriptFunction) {
        this.scriptFunction = scriptFunction == null ? null : scriptFunction.trim();
    }

    /**
     * 获取脚本类型
     *
     * @return script_type - 脚本类型
     */
    public String getScriptType() {
        return scriptType;
    }

    /**
     * 设置脚本类型
     *
     * @param scriptType 脚本类型
     */
    public void setScriptType(String scriptType) {
        this.scriptType = scriptType == null ? null : scriptType.trim();
    }

    /**
     * 获取脚本
     *
     * @return script - 脚本
     */
    public String getScript() {
        return script;
    }

    /**
     * 设置脚本
     *
     * @param script 脚本
     */
    public void setScript(String script) {
        this.script = script == null ? null : script.trim();
    }

    /**
     * 获取描述
     *
     * @return memo - 描述
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置描述
     *
     * @param memo 描述
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
        sb.append(", columnCode=").append(columnCode);
        sb.append(", title=").append(title);
        sb.append(", cascadeLevel=").append(cascadeLevel);
        sb.append(", scriptFunction=").append(scriptFunction);
        sb.append(", scriptType=").append(scriptType);
        sb.append(", script=").append(script);
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
        GroupScriptDO other = (GroupScriptDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getColumnCode() == null ? other.getColumnCode() == null : this.getColumnCode().equals(other.getColumnCode()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCascadeLevel() == null ? other.getCascadeLevel() == null : this.getCascadeLevel().equals(other.getCascadeLevel()))
            && (this.getScriptFunction() == null ? other.getScriptFunction() == null : this.getScriptFunction().equals(other.getScriptFunction()))
            && (this.getScriptType() == null ? other.getScriptType() == null : this.getScriptType().equals(other.getScriptType()))
            && (this.getScript() == null ? other.getScript() == null : this.getScript().equals(other.getScript()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getColumnCode() == null) ? 0 : getColumnCode().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCascadeLevel() == null) ? 0 : getCascadeLevel().hashCode());
        result = prime * result + ((getScriptFunction() == null) ? 0 : getScriptFunction().hashCode());
        result = prime * result + ((getScriptType() == null) ? 0 : getScriptType().hashCode());
        result = prime * result + ((getScript() == null) ? 0 : getScript().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}