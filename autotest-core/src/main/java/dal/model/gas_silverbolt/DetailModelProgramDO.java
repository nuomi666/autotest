package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "detail_model_program")
public class DetailModelProgramDO implements Serializable {
    /**
     * 序列id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 方案名称
     */
    @Column(name = "program_name")
    private String programName;

    /**
     * 方案编号
     */
    @Column(name = "program_no")
    private String programNo;

    /**
     * 模型编码
     */
    @Column(name = "model_code")
    private String modelCode;

    /**
     * 方案类型
     */
    @Column(name = "program_type")
    private String programType;

    /**
     * 操作员
     */
    @Column(name = "operate_id")
    private String operateId;

    /**
     * 方案描述
     */
    @Column(name = "program_memo")
    private String programMemo;

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
     * 筛选条件
     */
    @Column(name = "detail_head_filter")
    private String detailHeadFilter;

    /**
     * 排序条件
     */
    @Column(name = "detail_head_order_by")
    private String detailHeadOrderBy;

    /**
     * 表头信息
     */
    @Column(name = "detail_head_show")
    private String detailHeadShow;

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
     * 获取方案编号
     *
     * @return program_no - 方案编号
     */
    public String getProgramNo() {
        return programNo;
    }

    /**
     * 设置方案编号
     *
     * @param programNo 方案编号
     */
    public void setProgramNo(String programNo) {
        this.programNo = programNo == null ? null : programNo.trim();
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
     * 获取操作员
     *
     * @return operate_id - 操作员
     */
    public String getOperateId() {
        return operateId;
    }

    /**
     * 设置操作员
     *
     * @param operateId 操作员
     */
    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    /**
     * 获取方案描述
     *
     * @return program_memo - 方案描述
     */
    public String getProgramMemo() {
        return programMemo;
    }

    /**
     * 设置方案描述
     *
     * @param programMemo 方案描述
     */
    public void setProgramMemo(String programMemo) {
        this.programMemo = programMemo == null ? null : programMemo.trim();
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
     * 获取筛选条件
     *
     * @return detail_head_filter - 筛选条件
     */
    public String getDetailHeadFilter() {
        return detailHeadFilter;
    }

    /**
     * 设置筛选条件
     *
     * @param detailHeadFilter 筛选条件
     */
    public void setDetailHeadFilter(String detailHeadFilter) {
        this.detailHeadFilter = detailHeadFilter == null ? null : detailHeadFilter.trim();
    }

    /**
     * 获取排序条件
     *
     * @return detail_head_order_by - 排序条件
     */
    public String getDetailHeadOrderBy() {
        return detailHeadOrderBy;
    }

    /**
     * 设置排序条件
     *
     * @param detailHeadOrderBy 排序条件
     */
    public void setDetailHeadOrderBy(String detailHeadOrderBy) {
        this.detailHeadOrderBy = detailHeadOrderBy == null ? null : detailHeadOrderBy.trim();
    }

    /**
     * 获取表头信息
     *
     * @return detail_head_show - 表头信息
     */
    public String getDetailHeadShow() {
        return detailHeadShow;
    }

    /**
     * 设置表头信息
     *
     * @param detailHeadShow 表头信息
     */
    public void setDetailHeadShow(String detailHeadShow) {
        this.detailHeadShow = detailHeadShow == null ? null : detailHeadShow.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", programName=").append(programName);
        sb.append(", programNo=").append(programNo);
        sb.append(", modelCode=").append(modelCode);
        sb.append(", programType=").append(programType);
        sb.append(", operateId=").append(operateId);
        sb.append(", programMemo=").append(programMemo);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", detailHeadFilter=").append(detailHeadFilter);
        sb.append(", detailHeadOrderBy=").append(detailHeadOrderBy);
        sb.append(", detailHeadShow=").append(detailHeadShow);
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
        DetailModelProgramDO other = (DetailModelProgramDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProgramName() == null ? other.getProgramName() == null : this.getProgramName().equals(other.getProgramName()))
            && (this.getProgramNo() == null ? other.getProgramNo() == null : this.getProgramNo().equals(other.getProgramNo()))
            && (this.getModelCode() == null ? other.getModelCode() == null : this.getModelCode().equals(other.getModelCode()))
            && (this.getProgramType() == null ? other.getProgramType() == null : this.getProgramType().equals(other.getProgramType()))
            && (this.getOperateId() == null ? other.getOperateId() == null : this.getOperateId().equals(other.getOperateId()))
            && (this.getProgramMemo() == null ? other.getProgramMemo() == null : this.getProgramMemo().equals(other.getProgramMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getDetailHeadFilter() == null ? other.getDetailHeadFilter() == null : this.getDetailHeadFilter().equals(other.getDetailHeadFilter()))
            && (this.getDetailHeadOrderBy() == null ? other.getDetailHeadOrderBy() == null : this.getDetailHeadOrderBy().equals(other.getDetailHeadOrderBy()))
            && (this.getDetailHeadShow() == null ? other.getDetailHeadShow() == null : this.getDetailHeadShow().equals(other.getDetailHeadShow()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProgramName() == null) ? 0 : getProgramName().hashCode());
        result = prime * result + ((getProgramNo() == null) ? 0 : getProgramNo().hashCode());
        result = prime * result + ((getModelCode() == null) ? 0 : getModelCode().hashCode());
        result = prime * result + ((getProgramType() == null) ? 0 : getProgramType().hashCode());
        result = prime * result + ((getOperateId() == null) ? 0 : getOperateId().hashCode());
        result = prime * result + ((getProgramMemo() == null) ? 0 : getProgramMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getDetailHeadFilter() == null) ? 0 : getDetailHeadFilter().hashCode());
        result = prime * result + ((getDetailHeadOrderBy() == null) ? 0 : getDetailHeadOrderBy().hashCode());
        result = prime * result + ((getDetailHeadShow() == null) ? 0 : getDetailHeadShow().hashCode());
        return result;
    }
}