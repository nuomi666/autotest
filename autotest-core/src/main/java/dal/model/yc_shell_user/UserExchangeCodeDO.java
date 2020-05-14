package dal.model.yc_shell_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_exchange_code")
public class UserExchangeCodeDO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 任务编号
     */
    @Column(name = "task_id")
    private String taskId;

    /**
     * 兑换码
     */
    private String code;

    /**
     * 面值
     */
    @Column(name = "face_amount")
    private Long faceAmount;

    /**
     * 验证码
     */
    @Column(name = "verify_code")
    private String verifyCode;

    /**
     * 卡业务类型
     */
    @Column(name = "card_biz_type")
    private String cardBizType;

    /**
     * 兑换码状态
     */
    private String state;

    /**
     * 入库时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商户号
     *
     * @return partner_id - 商户号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户号
     *
     * @param partnerId 商户号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取任务编号
     *
     * @return task_id - 任务编号
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置任务编号
     *
     * @param taskId 任务编号
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * 获取兑换码
     *
     * @return code - 兑换码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置兑换码
     *
     * @param code 兑换码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取面值
     *
     * @return face_amount - 面值
     */
    public Long getFaceAmount() {
        return faceAmount;
    }

    /**
     * 设置面值
     *
     * @param faceAmount 面值
     */
    public void setFaceAmount(Long faceAmount) {
        this.faceAmount = faceAmount;
    }

    /**
     * 获取验证码
     *
     * @return verify_code - 验证码
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * 设置验证码
     *
     * @param verifyCode 验证码
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    /**
     * 获取卡业务类型
     *
     * @return card_biz_type - 卡业务类型
     */
    public String getCardBizType() {
        return cardBizType;
    }

    /**
     * 设置卡业务类型
     *
     * @param cardBizType 卡业务类型
     */
    public void setCardBizType(String cardBizType) {
        this.cardBizType = cardBizType == null ? null : cardBizType.trim();
    }

    /**
     * 获取兑换码状态
     *
     * @return state - 兑换码状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置兑换码状态
     *
     * @param state 兑换码状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取入库时间
     *
     * @return raw_add_time - 入库时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置入库时间
     *
     * @param rawAddTime 入库时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
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
        sb.append(", taskId=").append(taskId);
        sb.append(", code=").append(code);
        sb.append(", faceAmount=").append(faceAmount);
        sb.append(", verifyCode=").append(verifyCode);
        sb.append(", cardBizType=").append(cardBizType);
        sb.append(", state=").append(state);
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
        UserExchangeCodeDO other = (UserExchangeCodeDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getFaceAmount() == null ? other.getFaceAmount() == null : this.getFaceAmount().equals(other.getFaceAmount()))
            && (this.getVerifyCode() == null ? other.getVerifyCode() == null : this.getVerifyCode().equals(other.getVerifyCode()))
            && (this.getCardBizType() == null ? other.getCardBizType() == null : this.getCardBizType().equals(other.getCardBizType()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getFaceAmount() == null) ? 0 : getFaceAmount().hashCode());
        result = prime * result + ((getVerifyCode() == null) ? 0 : getVerifyCode().hashCode());
        result = prime * result + ((getCardBizType() == null) ? 0 : getCardBizType().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}