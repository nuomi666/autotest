package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "detail_model")
public class DetailModelDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模型名称
     */
    @Column(name = "model_name")
    private String modelName;

    /**
     * 模型ID
     */
    @Column(name = "model_id")
    private String modelId;

    /**
     * 模型编码
     */
    @Column(name = "model_code")
    private String modelCode;

    /**
     * 数据源
     */
    @Column(name = "spout_name")
    private String spoutName;

    /**
     * 报表状态
     */
    private String status;

    /**
     * 说明
     */
    private String memo;

    /**
     * 默认筛选规则
     */
    @Column(name = "head_default_filter")
    private String headDefaultFilter;

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
     * 获取模型名称
     *
     * @return model_name - 模型名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置模型名称
     *
     * @param modelName 模型名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * 获取模型ID
     *
     * @return model_id - 模型ID
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * 设置模型ID
     *
     * @param modelId 模型ID
     */
    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    /**
     * 获取模型编码
     *
     * @return model_code - 模型编码
     */
    public String getModelCode() {
        return modelCode;
    }

    /**
     * 设置模型编码
     *
     * @param modelCode 模型编码
     */
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    /**
     * 获取数据源
     *
     * @return spout_name - 数据源
     */
    public String getSpoutName() {
        return spoutName;
    }

    /**
     * 设置数据源
     *
     * @param spoutName 数据源
     */
    public void setSpoutName(String spoutName) {
        this.spoutName = spoutName == null ? null : spoutName.trim();
    }

    /**
     * 获取报表状态
     *
     * @return status - 报表状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置报表状态
     *
     * @param status 报表状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 获取默认筛选规则
     *
     * @return head_default_filter - 默认筛选规则
     */
    public String getHeadDefaultFilter() {
        return headDefaultFilter;
    }

    /**
     * 设置默认筛选规则
     *
     * @param headDefaultFilter 默认筛选规则
     */
    public void setHeadDefaultFilter(String headDefaultFilter) {
        this.headDefaultFilter = headDefaultFilter == null ? null : headDefaultFilter.trim();
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
        sb.append(", modelName=").append(modelName);
        sb.append(", modelId=").append(modelId);
        sb.append(", modelCode=").append(modelCode);
        sb.append(", spoutName=").append(spoutName);
        sb.append(", status=").append(status);
        sb.append(", memo=").append(memo);
        sb.append(", headDefaultFilter=").append(headDefaultFilter);
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
        DetailModelDO other = (DetailModelDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelCode() == null ? other.getModelCode() == null : this.getModelCode().equals(other.getModelCode()))
            && (this.getSpoutName() == null ? other.getSpoutName() == null : this.getSpoutName().equals(other.getSpoutName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getHeadDefaultFilter() == null ? other.getHeadDefaultFilter() == null : this.getHeadDefaultFilter().equals(other.getHeadDefaultFilter()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelCode() == null) ? 0 : getModelCode().hashCode());
        result = prime * result + ((getSpoutName() == null) ? 0 : getSpoutName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getHeadDefaultFilter() == null) ? 0 : getHeadDefaultFilter().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}