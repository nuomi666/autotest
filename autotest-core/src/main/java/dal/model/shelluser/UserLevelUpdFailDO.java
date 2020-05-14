package dal.model.shelluser;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_level_upd_fail")
public class UserLevelUpdFailDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 会员id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 商户会员最大id
     */
    @Column(name = "max_id")
    private Long maxId;

    /**
     * 批次最小id
     */
    @Column(name = "batch_min_id")
    private Long batchMinId;

    /**
     * 批次最大id
     */
    @Column(name = "batch_max_id")
    private Long batchMaxId;

    /**
     * 失败类型
     */
    @Column(name = "fail_type")
    private String failType;

    /**
     * 失败次数
     */
    @Column(name = "fail_num")
    private Integer failNum;

    /**
     * 执行状态
     */
    private String status;

    /**
     * 失败信息
     */
    private String memo;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取会员id
     *
     * @return user_id - 会员id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置会员id
     *
     * @param userId 会员id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取商户会员最大id
     *
     * @return max_id - 商户会员最大id
     */
    public Long getMaxId() {
        return maxId;
    }

    /**
     * 设置商户会员最大id
     *
     * @param maxId 商户会员最大id
     */
    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    /**
     * 获取批次最小id
     *
     * @return batch_min_id - 批次最小id
     */
    public Long getBatchMinId() {
        return batchMinId;
    }

    /**
     * 设置批次最小id
     *
     * @param batchMinId 批次最小id
     */
    public void setBatchMinId(Long batchMinId) {
        this.batchMinId = batchMinId;
    }

    /**
     * 获取批次最大id
     *
     * @return batch_max_id - 批次最大id
     */
    public Long getBatchMaxId() {
        return batchMaxId;
    }

    /**
     * 设置批次最大id
     *
     * @param batchMaxId 批次最大id
     */
    public void setBatchMaxId(Long batchMaxId) {
        this.batchMaxId = batchMaxId;
    }

    /**
     * 获取失败类型
     *
     * @return fail_type - 失败类型
     */
    public String getFailType() {
        return failType;
    }

    /**
     * 设置失败类型
     *
     * @param failType 失败类型
     */
    public void setFailType(String failType) {
        this.failType = failType == null ? null : failType.trim();
    }

    /**
     * 获取失败次数
     *
     * @return fail_num - 失败次数
     */
    public Integer getFailNum() {
        return failNum;
    }

    /**
     * 设置失败次数
     *
     * @param failNum 失败次数
     */
    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    /**
     * 获取执行状态
     *
     * @return status - 执行状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置执行状态
     *
     * @param status 执行状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取失败信息
     *
     * @return memo - 失败信息
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置失败信息
     *
     * @param memo 失败信息
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * @return raw_add_time
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * @param rawAddTime
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * @return raw_update_time
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * @param rawUpdateTime
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", userId=").append(userId);
        sb.append(", maxId=").append(maxId);
        sb.append(", batchMinId=").append(batchMinId);
        sb.append(", batchMaxId=").append(batchMaxId);
        sb.append(", failType=").append(failType);
        sb.append(", failNum=").append(failNum);
        sb.append(", status=").append(status);
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
        UserLevelUpdFailDO other = (UserLevelUpdFailDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMaxId() == null ? other.getMaxId() == null : this.getMaxId().equals(other.getMaxId()))
            && (this.getBatchMinId() == null ? other.getBatchMinId() == null : this.getBatchMinId().equals(other.getBatchMinId()))
            && (this.getBatchMaxId() == null ? other.getBatchMaxId() == null : this.getBatchMaxId().equals(other.getBatchMaxId()))
            && (this.getFailType() == null ? other.getFailType() == null : this.getFailType().equals(other.getFailType()))
            && (this.getFailNum() == null ? other.getFailNum() == null : this.getFailNum().equals(other.getFailNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMaxId() == null) ? 0 : getMaxId().hashCode());
        result = prime * result + ((getBatchMinId() == null) ? 0 : getBatchMinId().hashCode());
        result = prime * result + ((getBatchMaxId() == null) ? 0 : getBatchMaxId().hashCode());
        result = prime * result + ((getFailType() == null) ? 0 : getFailType().hashCode());
        result = prime * result + ((getFailNum() == null) ? 0 : getFailNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}