package dal.model.yc_shell_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_exchange_code_task")
public class UserExchangeCodeTaskDO implements Serializable {
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
     * 任务id
     */
    @Column(name = "task_id")
    private String taskId;

    /**
     * 绑定卡业务类型
     */
    @Column(name = "card_biz_type")
    private String cardBizType;

    /**
     * 活动名称
     */
    @Column(name = "task_name")
    private String taskName;

    /**
     * 任务状态
     */
    private String state;

    /**
     * 创建数量
     */
    @Column(name = "create_num")
    private Integer createNum;

    /**
     * 兑换数量
     */
    @Column(name = "exchange_num")
    private Integer exchangeNum;

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
     * 图片文件路径
     */
    @Column(name = "pic_path")
    private String picPath;

    /**
     * 兑换码文件地址
     */
    @Column(name = "file_path")
    private String filePath;

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
     * 获取任务id
     *
     * @return task_id - 任务id
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置任务id
     *
     * @param taskId 任务id
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * 获取绑定卡业务类型
     *
     * @return card_biz_type - 绑定卡业务类型
     */
    public String getCardBizType() {
        return cardBizType;
    }

    /**
     * 设置绑定卡业务类型
     *
     * @param cardBizType 绑定卡业务类型
     */
    public void setCardBizType(String cardBizType) {
        this.cardBizType = cardBizType == null ? null : cardBizType.trim();
    }

    /**
     * 获取活动名称
     *
     * @return task_name - 活动名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置活动名称
     *
     * @param taskName 活动名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 获取任务状态
     *
     * @return state - 任务状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置任务状态
     *
     * @param state 任务状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取创建数量
     *
     * @return create_num - 创建数量
     */
    public Integer getCreateNum() {
        return createNum;
    }

    /**
     * 设置创建数量
     *
     * @param createNum 创建数量
     */
    public void setCreateNum(Integer createNum) {
        this.createNum = createNum;
    }

    /**
     * 获取兑换数量
     *
     * @return exchange_num - 兑换数量
     */
    public Integer getExchangeNum() {
        return exchangeNum;
    }

    /**
     * 设置兑换数量
     *
     * @param exchangeNum 兑换数量
     */
    public void setExchangeNum(Integer exchangeNum) {
        this.exchangeNum = exchangeNum;
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
     * 获取图片文件路径
     *
     * @return pic_path - 图片文件路径
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * 设置图片文件路径
     *
     * @param picPath 图片文件路径
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    /**
     * 获取兑换码文件地址
     *
     * @return file_path - 兑换码文件地址
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置兑换码文件地址
     *
     * @param filePath 兑换码文件地址
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
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
        sb.append(", cardBizType=").append(cardBizType);
        sb.append(", taskName=").append(taskName);
        sb.append(", state=").append(state);
        sb.append(", createNum=").append(createNum);
        sb.append(", exchangeNum=").append(exchangeNum);
        sb.append(", faceAmount=").append(faceAmount);
        sb.append(", verifyCode=").append(verifyCode);
        sb.append(", picPath=").append(picPath);
        sb.append(", filePath=").append(filePath);
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
        UserExchangeCodeTaskDO other = (UserExchangeCodeTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getCardBizType() == null ? other.getCardBizType() == null : this.getCardBizType().equals(other.getCardBizType()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateNum() == null ? other.getCreateNum() == null : this.getCreateNum().equals(other.getCreateNum()))
            && (this.getExchangeNum() == null ? other.getExchangeNum() == null : this.getExchangeNum().equals(other.getExchangeNum()))
            && (this.getFaceAmount() == null ? other.getFaceAmount() == null : this.getFaceAmount().equals(other.getFaceAmount()))
            && (this.getVerifyCode() == null ? other.getVerifyCode() == null : this.getVerifyCode().equals(other.getVerifyCode()))
            && (this.getPicPath() == null ? other.getPicPath() == null : this.getPicPath().equals(other.getPicPath()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
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
        result = prime * result + ((getCardBizType() == null) ? 0 : getCardBizType().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateNum() == null) ? 0 : getCreateNum().hashCode());
        result = prime * result + ((getExchangeNum() == null) ? 0 : getExchangeNum().hashCode());
        result = prime * result + ((getFaceAmount() == null) ? 0 : getFaceAmount().hashCode());
        result = prime * result + ((getVerifyCode() == null) ? 0 : getVerifyCode().hashCode());
        result = prime * result + ((getPicPath() == null) ? 0 : getPicPath().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}