package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "promotion")
public class PromotionDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 规则名字
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 触发事件路由
     */
    @Column(name = "action_event")
    private String actionEvent;

    /**
     * 促销方式，如：优惠金额/赠送礼品/抽奖
     */
    @Column(name = "promotion_way")
    private String promotionWay;

    /**
     * 促销方式分类
     */
    @Column(name = "discount_type")
    private String discountType;

    /**
     * 描述
     */
    private String description;

    /**
     * 规则集编码
     */
    @Column(name = "rule_set_code")
    private String ruleSetCode;

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
     * 获取规则名字
     *
     * @return campaign_no - 规则名字
     */
    public String getCampaignNo() {
        return campaignNo;
    }

    /**
     * 设置规则名字
     *
     * @param campaignNo 规则名字
     */
    public void setCampaignNo(String campaignNo) {
        this.campaignNo = campaignNo == null ? null : campaignNo.trim();
    }

    /**
     * 获取触发事件路由
     *
     * @return action_event - 触发事件路由
     */
    public String getActionEvent() {
        return actionEvent;
    }

    /**
     * 设置触发事件路由
     *
     * @param actionEvent 触发事件路由
     */
    public void setActionEvent(String actionEvent) {
        this.actionEvent = actionEvent == null ? null : actionEvent.trim();
    }

    /**
     * 获取促销方式，如：优惠金额/赠送礼品/抽奖
     *
     * @return promotion_way - 促销方式，如：优惠金额/赠送礼品/抽奖
     */
    public String getPromotionWay() {
        return promotionWay;
    }

    /**
     * 设置促销方式，如：优惠金额/赠送礼品/抽奖
     *
     * @param promotionWay 促销方式，如：优惠金额/赠送礼品/抽奖
     */
    public void setPromotionWay(String promotionWay) {
        this.promotionWay = promotionWay == null ? null : promotionWay.trim();
    }

    /**
     * 获取促销方式分类
     *
     * @return discount_type - 促销方式分类
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * 设置促销方式分类
     *
     * @param discountType 促销方式分类
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType == null ? null : discountType.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取规则集编码
     *
     * @return rule_set_code - 规则集编码
     */
    public String getRuleSetCode() {
        return ruleSetCode;
    }

    /**
     * 设置规则集编码
     *
     * @param ruleSetCode 规则集编码
     */
    public void setRuleSetCode(String ruleSetCode) {
        this.ruleSetCode = ruleSetCode == null ? null : ruleSetCode.trim();
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
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", actionEvent=").append(actionEvent);
        sb.append(", promotionWay=").append(promotionWay);
        sb.append(", discountType=").append(discountType);
        sb.append(", description=").append(description);
        sb.append(", ruleSetCode=").append(ruleSetCode);
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
        PromotionDO other = (PromotionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getActionEvent() == null ? other.getActionEvent() == null : this.getActionEvent().equals(other.getActionEvent()))
            && (this.getPromotionWay() == null ? other.getPromotionWay() == null : this.getPromotionWay().equals(other.getPromotionWay()))
            && (this.getDiscountType() == null ? other.getDiscountType() == null : this.getDiscountType().equals(other.getDiscountType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRuleSetCode() == null ? other.getRuleSetCode() == null : this.getRuleSetCode().equals(other.getRuleSetCode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getActionEvent() == null) ? 0 : getActionEvent().hashCode());
        result = prime * result + ((getPromotionWay() == null) ? 0 : getPromotionWay().hashCode());
        result = prime * result + ((getDiscountType() == null) ? 0 : getDiscountType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRuleSetCode() == null) ? 0 : getRuleSetCode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}