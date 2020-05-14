package dal.model.yc_shell_trade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wash_redeem_coupon_cnt2")
public class WashRedeemCouponCnt2DO implements Serializable {
    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 会员ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 优惠券定义ID
     */
    @Column(name = "definition_id")
    private String definitionId;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 优惠券ID
     */
    @Column(name = "coupon_id")
    private String couponId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取业务流水号
     *
     * @return biz_no - 业务流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务流水号
     *
     * @param bizNo 业务流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取会员ID
     *
     * @return user_id - 会员ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置会员ID
     *
     * @param userId 会员ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取优惠券ID
     *
     * @return coupon_id - 优惠券ID
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * 设置优惠券ID
     *
     * @param couponId 优惠券ID
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", bizNo=").append(bizNo);
        sb.append(", userId=").append(userId);
        sb.append(", definitionId=").append(definitionId);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", couponId=").append(couponId);
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
        WashRedeemCouponCnt2DO other = (WashRedeemCouponCnt2DO) that;
        return (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDefinitionId() == null ? other.getDefinitionId() == null : this.getDefinitionId().equals(other.getDefinitionId()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDefinitionId() == null) ? 0 : getDefinitionId().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        return result;
    }
}