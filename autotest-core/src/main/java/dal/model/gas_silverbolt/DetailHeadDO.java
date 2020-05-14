package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "detail_head")
public class DetailHeadDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模型ID
     */
    @Column(name = "model_id")
    private String modelId;

    /**
     * 表头名称
     */
    @Column(name = "head_name")
    private String headName;

    /**
     * 表头编码
     */
    @Column(name = "head_code")
    private String headCode;

    /**
     * 数据列
     */
    @Column(name = "head_column")
    private String headColumn;

    /**
     * 表头值类型
     */
    @Column(name = "filed_type")
    private String filedType;

    /**
     * 是否允许筛选
     */
    private String filter;

    /**
     * 筛选规则
     */
    @Column(name = "filter_head_config")
    private String filterHeadConfig;

    /**
     * 是否掩码
     */
    private String mask;

    /**
     * 是否合计
     */
    @Column(name = "sum_value")
    private String sumValue;

    /**
     * 是否允许排序
     */
    @Column(name = "order_by")
    private String orderBy;

    /**
     * 是否允许展示
     */
    @Column(name = "on_show")
    private String onShow;

    /**
     * 表头说明
     */
    @Column(name = "head_memo")
    private String headMemo;

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
     * 获取表头名称
     *
     * @return head_name - 表头名称
     */
    public String getHeadName() {
        return headName;
    }

    /**
     * 设置表头名称
     *
     * @param headName 表头名称
     */
    public void setHeadName(String headName) {
        this.headName = headName == null ? null : headName.trim();
    }

    /**
     * 获取表头编码
     *
     * @return head_code - 表头编码
     */
    public String getHeadCode() {
        return headCode;
    }

    /**
     * 设置表头编码
     *
     * @param headCode 表头编码
     */
    public void setHeadCode(String headCode) {
        this.headCode = headCode == null ? null : headCode.trim();
    }

    /**
     * 获取数据列
     *
     * @return head_column - 数据列
     */
    public String getHeadColumn() {
        return headColumn;
    }

    /**
     * 设置数据列
     *
     * @param headColumn 数据列
     */
    public void setHeadColumn(String headColumn) {
        this.headColumn = headColumn == null ? null : headColumn.trim();
    }

    /**
     * 获取表头值类型
     *
     * @return filed_type - 表头值类型
     */
    public String getFiledType() {
        return filedType;
    }

    /**
     * 设置表头值类型
     *
     * @param filedType 表头值类型
     */
    public void setFiledType(String filedType) {
        this.filedType = filedType == null ? null : filedType.trim();
    }

    /**
     * 获取是否允许筛选
     *
     * @return filter - 是否允许筛选
     */
    public String getFilter() {
        return filter;
    }

    /**
     * 设置是否允许筛选
     *
     * @param filter 是否允许筛选
     */
    public void setFilter(String filter) {
        this.filter = filter == null ? null : filter.trim();
    }

    /**
     * 获取筛选规则
     *
     * @return filter_head_config - 筛选规则
     */
    public String getFilterHeadConfig() {
        return filterHeadConfig;
    }

    /**
     * 设置筛选规则
     *
     * @param filterHeadConfig 筛选规则
     */
    public void setFilterHeadConfig(String filterHeadConfig) {
        this.filterHeadConfig = filterHeadConfig == null ? null : filterHeadConfig.trim();
    }

    /**
     * 获取是否掩码
     *
     * @return mask - 是否掩码
     */
    public String getMask() {
        return mask;
    }

    /**
     * 设置是否掩码
     *
     * @param mask 是否掩码
     */
    public void setMask(String mask) {
        this.mask = mask == null ? null : mask.trim();
    }

    /**
     * 获取是否合计
     *
     * @return sum_value - 是否合计
     */
    public String getSumValue() {
        return sumValue;
    }

    /**
     * 设置是否合计
     *
     * @param sumValue 是否合计
     */
    public void setSumValue(String sumValue) {
        this.sumValue = sumValue == null ? null : sumValue.trim();
    }

    /**
     * 获取是否允许排序
     *
     * @return order_by - 是否允许排序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置是否允许排序
     *
     * @param orderBy 是否允许排序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy == null ? null : orderBy.trim();
    }

    /**
     * 获取是否允许展示
     *
     * @return on_show - 是否允许展示
     */
    public String getOnShow() {
        return onShow;
    }

    /**
     * 设置是否允许展示
     *
     * @param onShow 是否允许展示
     */
    public void setOnShow(String onShow) {
        this.onShow = onShow == null ? null : onShow.trim();
    }

    /**
     * 获取表头说明
     *
     * @return head_memo - 表头说明
     */
    public String getHeadMemo() {
        return headMemo;
    }

    /**
     * 设置表头说明
     *
     * @param headMemo 表头说明
     */
    public void setHeadMemo(String headMemo) {
        this.headMemo = headMemo == null ? null : headMemo.trim();
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
        sb.append(", modelId=").append(modelId);
        sb.append(", headName=").append(headName);
        sb.append(", headCode=").append(headCode);
        sb.append(", headColumn=").append(headColumn);
        sb.append(", filedType=").append(filedType);
        sb.append(", filter=").append(filter);
        sb.append(", filterHeadConfig=").append(filterHeadConfig);
        sb.append(", mask=").append(mask);
        sb.append(", sumValue=").append(sumValue);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", onShow=").append(onShow);
        sb.append(", headMemo=").append(headMemo);
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
        DetailHeadDO other = (DetailHeadDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getHeadName() == null ? other.getHeadName() == null : this.getHeadName().equals(other.getHeadName()))
            && (this.getHeadCode() == null ? other.getHeadCode() == null : this.getHeadCode().equals(other.getHeadCode()))
            && (this.getHeadColumn() == null ? other.getHeadColumn() == null : this.getHeadColumn().equals(other.getHeadColumn()))
            && (this.getFiledType() == null ? other.getFiledType() == null : this.getFiledType().equals(other.getFiledType()))
            && (this.getFilter() == null ? other.getFilter() == null : this.getFilter().equals(other.getFilter()))
            && (this.getFilterHeadConfig() == null ? other.getFilterHeadConfig() == null : this.getFilterHeadConfig().equals(other.getFilterHeadConfig()))
            && (this.getMask() == null ? other.getMask() == null : this.getMask().equals(other.getMask()))
            && (this.getSumValue() == null ? other.getSumValue() == null : this.getSumValue().equals(other.getSumValue()))
            && (this.getOrderBy() == null ? other.getOrderBy() == null : this.getOrderBy().equals(other.getOrderBy()))
            && (this.getOnShow() == null ? other.getOnShow() == null : this.getOnShow().equals(other.getOnShow()))
            && (this.getHeadMemo() == null ? other.getHeadMemo() == null : this.getHeadMemo().equals(other.getHeadMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getHeadName() == null) ? 0 : getHeadName().hashCode());
        result = prime * result + ((getHeadCode() == null) ? 0 : getHeadCode().hashCode());
        result = prime * result + ((getHeadColumn() == null) ? 0 : getHeadColumn().hashCode());
        result = prime * result + ((getFiledType() == null) ? 0 : getFiledType().hashCode());
        result = prime * result + ((getFilter() == null) ? 0 : getFilter().hashCode());
        result = prime * result + ((getFilterHeadConfig() == null) ? 0 : getFilterHeadConfig().hashCode());
        result = prime * result + ((getMask() == null) ? 0 : getMask().hashCode());
        result = prime * result + ((getSumValue() == null) ? 0 : getSumValue().hashCode());
        result = prime * result + ((getOrderBy() == null) ? 0 : getOrderBy().hashCode());
        result = prime * result + ((getOnShow() == null) ? 0 : getOnShow().hashCode());
        result = prime * result + ((getHeadMemo() == null) ? 0 : getHeadMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}