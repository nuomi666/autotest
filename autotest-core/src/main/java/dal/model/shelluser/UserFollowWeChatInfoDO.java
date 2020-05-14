package dal.model.shelluser;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_follow_we_chat_info")
public class UserFollowWeChatInfoDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 微信openid
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 绑定状态
     */
    @Column(name = "bind_status")
    private String bindStatus;

    /**
     * 目前是否关了注微信公众号
     */
    private String follow;

    /**
     * 首次关注公众号时间
     */
    @Column(name = "first_follow_time")
    private Date firstFollowTime;

    /**
     * 上一次关注公众号的时间/如果是已取消关注，则是取消关注时间
     */
    @Column(name = "last_follow_time")
    private Date lastFollowTime;

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
     * 获取微信openid
     *
     * @return open_id - 微信openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信openid
     *
     * @param openId 微信openid
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
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
     * 获取绑定状态
     *
     * @return bind_status - 绑定状态
     */
    public String getBindStatus() {
        return bindStatus;
    }

    /**
     * 设置绑定状态
     *
     * @param bindStatus 绑定状态
     */
    public void setBindStatus(String bindStatus) {
        this.bindStatus = bindStatus == null ? null : bindStatus.trim();
    }

    /**
     * 获取目前是否关了注微信公众号
     *
     * @return follow - 目前是否关了注微信公众号
     */
    public String getFollow() {
        return follow;
    }

    /**
     * 设置目前是否关了注微信公众号
     *
     * @param follow 目前是否关了注微信公众号
     */
    public void setFollow(String follow) {
        this.follow = follow == null ? null : follow.trim();
    }

    /**
     * 获取首次关注公众号时间
     *
     * @return first_follow_time - 首次关注公众号时间
     */
    public Date getFirstFollowTime() {
        return firstFollowTime;
    }

    /**
     * 设置首次关注公众号时间
     *
     * @param firstFollowTime 首次关注公众号时间
     */
    public void setFirstFollowTime(Date firstFollowTime) {
        this.firstFollowTime = firstFollowTime;
    }

    /**
     * 获取上一次关注公众号的时间/如果是已取消关注，则是取消关注时间
     *
     * @return last_follow_time - 上一次关注公众号的时间/如果是已取消关注，则是取消关注时间
     */
    public Date getLastFollowTime() {
        return lastFollowTime;
    }

    /**
     * 设置上一次关注公众号的时间/如果是已取消关注，则是取消关注时间
     *
     * @param lastFollowTime 上一次关注公众号的时间/如果是已取消关注，则是取消关注时间
     */
    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
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
        sb.append(", openId=").append(openId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", bindStatus=").append(bindStatus);
        sb.append(", follow=").append(follow);
        sb.append(", firstFollowTime=").append(firstFollowTime);
        sb.append(", lastFollowTime=").append(lastFollowTime);
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
        UserFollowWeChatInfoDO other = (UserFollowWeChatInfoDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getBindStatus() == null ? other.getBindStatus() == null : this.getBindStatus().equals(other.getBindStatus()))
            && (this.getFollow() == null ? other.getFollow() == null : this.getFollow().equals(other.getFollow()))
            && (this.getFirstFollowTime() == null ? other.getFirstFollowTime() == null : this.getFirstFollowTime().equals(other.getFirstFollowTime()))
            && (this.getLastFollowTime() == null ? other.getLastFollowTime() == null : this.getLastFollowTime().equals(other.getLastFollowTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getBindStatus() == null) ? 0 : getBindStatus().hashCode());
        result = prime * result + ((getFollow() == null) ? 0 : getFollow().hashCode());
        result = prime * result + ((getFirstFollowTime() == null) ? 0 : getFirstFollowTime().hashCode());
        result = prime * result + ((getLastFollowTime() == null) ? 0 : getLastFollowTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}