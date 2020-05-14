package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_extend_info")
public class MerchantExtendInfoDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 会员评级规则
     */
    @Column(name = "evaluate_grade_rule")
    private String evaluateGradeRule;

    /**
     * 一笔交易最大优惠金额
     */
    @Column(name = "max_discount_amount")
    private Long maxDiscountAmount;

    /**
     * 一笔交易最多可以使用多少张优惠券
     */
    @Column(name = "max_use_coupon")
    private Integer maxUseCoupon;

    /**
     * 一笔交易最多可以赠送多少张优惠券
     */
    @Column(name = "max_give_coupon")
    private Integer maxGiveCoupon;

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
     * 获取会员评级规则
     *
     * @return evaluate_grade_rule - 会员评级规则
     */
    public String getEvaluateGradeRule() {
        return evaluateGradeRule;
    }

    /**
     * 设置会员评级规则
     *
     * @param evaluateGradeRule 会员评级规则
     */
    public void setEvaluateGradeRule(String evaluateGradeRule) {
        this.evaluateGradeRule = evaluateGradeRule == null ? null : evaluateGradeRule.trim();
    }

    /**
     * 获取一笔交易最大优惠金额
     *
     * @return max_discount_amount - 一笔交易最大优惠金额
     */
    public Long getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    /**
     * 设置一笔交易最大优惠金额
     *
     * @param maxDiscountAmount 一笔交易最大优惠金额
     */
    public void setMaxDiscountAmount(Long maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    /**
     * 获取一笔交易最多可以使用多少张优惠券
     *
     * @return max_use_coupon - 一笔交易最多可以使用多少张优惠券
     */
    public Integer getMaxUseCoupon() {
        return maxUseCoupon;
    }

    /**
     * 设置一笔交易最多可以使用多少张优惠券
     *
     * @param maxUseCoupon 一笔交易最多可以使用多少张优惠券
     */
    public void setMaxUseCoupon(Integer maxUseCoupon) {
        this.maxUseCoupon = maxUseCoupon;
    }

    /**
     * 获取一笔交易最多可以赠送多少张优惠券
     *
     * @return max_give_coupon - 一笔交易最多可以赠送多少张优惠券
     */
    public Integer getMaxGiveCoupon() {
        return maxGiveCoupon;
    }

    /**
     * 设置一笔交易最多可以赠送多少张优惠券
     *
     * @param maxGiveCoupon 一笔交易最多可以赠送多少张优惠券
     */
    public void setMaxGiveCoupon(Integer maxGiveCoupon) {
        this.maxGiveCoupon = maxGiveCoupon;
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
        sb.append(", evaluateGradeRule=").append(evaluateGradeRule);
        sb.append(", maxDiscountAmount=").append(maxDiscountAmount);
        sb.append(", maxUseCoupon=").append(maxUseCoupon);
        sb.append(", maxGiveCoupon=").append(maxGiveCoupon);
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
        MerchantExtendInfoDO other = (MerchantExtendInfoDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getEvaluateGradeRule() == null ? other.getEvaluateGradeRule() == null : this.getEvaluateGradeRule().equals(other.getEvaluateGradeRule()))
            && (this.getMaxDiscountAmount() == null ? other.getMaxDiscountAmount() == null : this.getMaxDiscountAmount().equals(other.getMaxDiscountAmount()))
            && (this.getMaxUseCoupon() == null ? other.getMaxUseCoupon() == null : this.getMaxUseCoupon().equals(other.getMaxUseCoupon()))
            && (this.getMaxGiveCoupon() == null ? other.getMaxGiveCoupon() == null : this.getMaxGiveCoupon().equals(other.getMaxGiveCoupon()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getEvaluateGradeRule() == null) ? 0 : getEvaluateGradeRule().hashCode());
        result = prime * result + ((getMaxDiscountAmount() == null) ? 0 : getMaxDiscountAmount().hashCode());
        result = prime * result + ((getMaxUseCoupon() == null) ? 0 : getMaxUseCoupon().hashCode());
        result = prime * result + ((getMaxGiveCoupon() == null) ? 0 : getMaxGiveCoupon().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}