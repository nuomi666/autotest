package dal.model.yc_shell_trade;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tmp_has_consume_user")
public class TmpHasConsumeUserDO implements Serializable {
    /**
     * 会员ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 消费次数
     */
    @Column(name = "consume_times")
    private Integer consumeTimes;

    private static final long serialVersionUID = 1L;

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
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取消费次数
     *
     * @return consume_times - 消费次数
     */
    public Integer getConsumeTimes() {
        return consumeTimes;
    }

    /**
     * 设置消费次数
     *
     * @param consumeTimes 消费次数
     */
    public void setConsumeTimes(Integer consumeTimes) {
        this.consumeTimes = consumeTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", userId=").append(userId);
        sb.append(", mobile=").append(mobile);
        sb.append(", consumeTimes=").append(consumeTimes);
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
        TmpHasConsumeUserDO other = (TmpHasConsumeUserDO) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getConsumeTimes() == null ? other.getConsumeTimes() == null : this.getConsumeTimes().equals(other.getConsumeTimes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getConsumeTimes() == null) ? 0 : getConsumeTimes().hashCode());
        return result;
    }
}