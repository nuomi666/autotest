package dal.model.promotion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "coupon_transfer_log")
public class CouponTransferLogDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会话号
     */
    private String gid;

    /**
     * 请求号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 指令id
     */
    @Column(name = "instruction_id")
    private String instructionId;

    /**
     * 签约商id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 赠送人user_id
     */
    @Column(name = "donor_user_id")
    private String donorUserId;

    /**
     * 领取人user_id
     */
    @Column(name = "receive_user_id")
    private String receiveUserId;

    /**
     * 旧本券id
     */
    @Column(name = "old_coupon_id")
    private String oldCouponId;

    /**
     * 新的券id
     */
    @Column(name = "new_coupon_id")
    private String newCouponId;

    /**
     * 优惠券定义ID
     */
    @Column(name = "definition_id")
    private String definitionId;

    /**
     * 券金额
     */
    @Column(name = "amount_data")
    private String amountData;

    /**
     * 券类型
     */
    @Column(name = "coupon_type")
    private String couponType;

    /**
     * 券外部名称
     */
    private String name;

    /**
     * 券内部名称
     */
    @Column(name = "inner_name")
    private String innerName;

    /**
     * 券领取时间
     */
    @Column(name = "taken_time")
    private Date takenTime;

    /**
     * 可使用时间
     */
    @Column(name = "can_apply_time")
    private Date canApplyTime;

    /**
     * 有效期截止日期
     */
    @Column(name = "valid_end_time")
    private Date validEndTime;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

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
     * 获取会话号
     *
     * @return gid - 会话号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置会话号
     *
     * @param gid 会话号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取请求号
     *
     * @return req_id - 请求号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求号
     *
     * @param reqId 请求号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取指令id
     *
     * @return instruction_id - 指令id
     */
    public String getInstructionId() {
        return instructionId;
    }

    /**
     * 设置指令id
     *
     * @param instructionId 指令id
     */
    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId == null ? null : instructionId.trim();
    }

    /**
     * 获取签约商id
     *
     * @return partner_id - 签约商id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商id
     *
     * @param partnerId 签约商id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商id
     *
     * @return plat_partner_id - 平台商id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商id
     *
     * @param platPartnerId 平台商id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取赠送人user_id
     *
     * @return donor_user_id - 赠送人user_id
     */
    public String getDonorUserId() {
        return donorUserId;
    }

    /**
     * 设置赠送人user_id
     *
     * @param donorUserId 赠送人user_id
     */
    public void setDonorUserId(String donorUserId) {
        this.donorUserId = donorUserId == null ? null : donorUserId.trim();
    }

    /**
     * 获取领取人user_id
     *
     * @return receive_user_id - 领取人user_id
     */
    public String getReceiveUserId() {
        return receiveUserId;
    }

    /**
     * 设置领取人user_id
     *
     * @param receiveUserId 领取人user_id
     */
    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId == null ? null : receiveUserId.trim();
    }

    /**
     * 获取旧本券id
     *
     * @return old_coupon_id - 旧本券id
     */
    public String getOldCouponId() {
        return oldCouponId;
    }

    /**
     * 设置旧本券id
     *
     * @param oldCouponId 旧本券id
     */
    public void setOldCouponId(String oldCouponId) {
        this.oldCouponId = oldCouponId == null ? null : oldCouponId.trim();
    }

    /**
     * 获取新的券id
     *
     * @return new_coupon_id - 新的券id
     */
    public String getNewCouponId() {
        return newCouponId;
    }

    /**
     * 设置新的券id
     *
     * @param newCouponId 新的券id
     */
    public void setNewCouponId(String newCouponId) {
        this.newCouponId = newCouponId == null ? null : newCouponId.trim();
    }

    /**
     * 获取优惠券定义ID
     *
     * @return definition_id - 优惠券定义ID
     */
    public String getDefinitionId() {
        return definitionId;
    }

    /**
     * 设置优惠券定义ID
     *
     * @param definitionId 优惠券定义ID
     */
    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId == null ? null : definitionId.trim();
    }

    /**
     * 获取券金额
     *
     * @return amount_data - 券金额
     */
    public String getAmountData() {
        return amountData;
    }

    /**
     * 设置券金额
     *
     * @param amountData 券金额
     */
    public void setAmountData(String amountData) {
        this.amountData = amountData == null ? null : amountData.trim();
    }

    /**
     * 获取券类型
     *
     * @return coupon_type - 券类型
     */
    public String getCouponType() {
        return couponType;
    }

    /**
     * 设置券类型
     *
     * @param couponType 券类型
     */
    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    /**
     * 获取券外部名称
     *
     * @return name - 券外部名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置券外部名称
     *
     * @param name 券外部名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取券内部名称
     *
     * @return inner_name - 券内部名称
     */
    public String getInnerName() {
        return innerName;
    }

    /**
     * 设置券内部名称
     *
     * @param innerName 券内部名称
     */
    public void setInnerName(String innerName) {
        this.innerName = innerName == null ? null : innerName.trim();
    }

    /**
     * 获取券领取时间
     *
     * @return taken_time - 券领取时间
     */
    public Date getTakenTime() {
        return takenTime;
    }

    /**
     * 设置券领取时间
     *
     * @param takenTime 券领取时间
     */
    public void setTakenTime(Date takenTime) {
        this.takenTime = takenTime;
    }

    /**
     * 获取可使用时间
     *
     * @return can_apply_time - 可使用时间
     */
    public Date getCanApplyTime() {
        return canApplyTime;
    }

    /**
     * 设置可使用时间
     *
     * @param canApplyTime 可使用时间
     */
    public void setCanApplyTime(Date canApplyTime) {
        this.canApplyTime = canApplyTime;
    }

    /**
     * 获取有效期截止日期
     *
     * @return valid_end_time - 有效期截止日期
     */
    public Date getValidEndTime() {
        return validEndTime;
    }

    /**
     * 设置有效期截止日期
     *
     * @param validEndTime 有效期截止日期
     */
    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
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
        sb.append(", gid=").append(gid);
        sb.append(", reqId=").append(reqId);
        sb.append(", instructionId=").append(instructionId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", donorUserId=").append(donorUserId);
        sb.append(", receiveUserId=").append(receiveUserId);
        sb.append(", oldCouponId=").append(oldCouponId);
        sb.append(", newCouponId=").append(newCouponId);
        sb.append(", definitionId=").append(definitionId);
        sb.append(", amountData=").append(amountData);
        sb.append(", couponType=").append(couponType);
        sb.append(", name=").append(name);
        sb.append(", innerName=").append(innerName);
        sb.append(", takenTime=").append(takenTime);
        sb.append(", canApplyTime=").append(canApplyTime);
        sb.append(", validEndTime=").append(validEndTime);
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
        CouponTransferLogDO other = (CouponTransferLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getInstructionId() == null ? other.getInstructionId() == null : this.getInstructionId().equals(other.getInstructionId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getDonorUserId() == null ? other.getDonorUserId() == null : this.getDonorUserId().equals(other.getDonorUserId()))
            && (this.getReceiveUserId() == null ? other.getReceiveUserId() == null : this.getReceiveUserId().equals(other.getReceiveUserId()))
            && (this.getOldCouponId() == null ? other.getOldCouponId() == null : this.getOldCouponId().equals(other.getOldCouponId()))
            && (this.getNewCouponId() == null ? other.getNewCouponId() == null : this.getNewCouponId().equals(other.getNewCouponId()))
            && (this.getDefinitionId() == null ? other.getDefinitionId() == null : this.getDefinitionId().equals(other.getDefinitionId()))
            && (this.getAmountData() == null ? other.getAmountData() == null : this.getAmountData().equals(other.getAmountData()))
            && (this.getCouponType() == null ? other.getCouponType() == null : this.getCouponType().equals(other.getCouponType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getInnerName() == null ? other.getInnerName() == null : this.getInnerName().equals(other.getInnerName()))
            && (this.getTakenTime() == null ? other.getTakenTime() == null : this.getTakenTime().equals(other.getTakenTime()))
            && (this.getCanApplyTime() == null ? other.getCanApplyTime() == null : this.getCanApplyTime().equals(other.getCanApplyTime()))
            && (this.getValidEndTime() == null ? other.getValidEndTime() == null : this.getValidEndTime().equals(other.getValidEndTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getInstructionId() == null) ? 0 : getInstructionId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getDonorUserId() == null) ? 0 : getDonorUserId().hashCode());
        result = prime * result + ((getReceiveUserId() == null) ? 0 : getReceiveUserId().hashCode());
        result = prime * result + ((getOldCouponId() == null) ? 0 : getOldCouponId().hashCode());
        result = prime * result + ((getNewCouponId() == null) ? 0 : getNewCouponId().hashCode());
        result = prime * result + ((getDefinitionId() == null) ? 0 : getDefinitionId().hashCode());
        result = prime * result + ((getAmountData() == null) ? 0 : getAmountData().hashCode());
        result = prime * result + ((getCouponType() == null) ? 0 : getCouponType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getInnerName() == null) ? 0 : getInnerName().hashCode());
        result = prime * result + ((getTakenTime() == null) ? 0 : getTakenTime().hashCode());
        result = prime * result + ((getCanApplyTime() == null) ? 0 : getCanApplyTime().hashCode());
        result = prime * result + ((getValidEndTime() == null) ? 0 : getValidEndTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}