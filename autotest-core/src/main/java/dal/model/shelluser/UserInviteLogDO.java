package dal.model.shelluser;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_invite_log")
public class UserInviteLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 会员推荐人id
     */
    @Column(name = "user_invite_id")
    private String userInviteId;

    /**
     * 会员推荐人姓名
     */
    @Column(name = "user_invite_name")
    private String userInviteName;

    /**
     * 推荐人手机号
     */
    @Column(name = "user_invite_mobile")
    private String userInviteMobile;

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
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取会员推荐人id
     *
     * @return user_invite_id - 会员推荐人id
     */
    public String getUserInviteId() {
        return userInviteId;
    }

    /**
     * 设置会员推荐人id
     *
     * @param userInviteId 会员推荐人id
     */
    public void setUserInviteId(String userInviteId) {
        this.userInviteId = userInviteId == null ? null : userInviteId.trim();
    }

    /**
     * 获取会员推荐人姓名
     *
     * @return user_invite_name - 会员推荐人姓名
     */
    public String getUserInviteName() {
        return userInviteName;
    }

    /**
     * 设置会员推荐人姓名
     *
     * @param userInviteName 会员推荐人姓名
     */
    public void setUserInviteName(String userInviteName) {
        this.userInviteName = userInviteName == null ? null : userInviteName.trim();
    }

    /**
     * 获取推荐人手机号
     *
     * @return user_invite_mobile - 推荐人手机号
     */
    public String getUserInviteMobile() {
        return userInviteMobile;
    }

    /**
     * 设置推荐人手机号
     *
     * @param userInviteMobile 推荐人手机号
     */
    public void setUserInviteMobile(String userInviteMobile) {
        this.userInviteMobile = userInviteMobile == null ? null : userInviteMobile.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", nickName=").append(nickName);
        sb.append(", userInviteId=").append(userInviteId);
        sb.append(", userInviteName=").append(userInviteName);
        sb.append(", userInviteMobile=").append(userInviteMobile);
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
        UserInviteLogDO other = (UserInviteLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getUserInviteId() == null ? other.getUserInviteId() == null : this.getUserInviteId().equals(other.getUserInviteId()))
            && (this.getUserInviteName() == null ? other.getUserInviteName() == null : this.getUserInviteName().equals(other.getUserInviteName()))
            && (this.getUserInviteMobile() == null ? other.getUserInviteMobile() == null : this.getUserInviteMobile().equals(other.getUserInviteMobile()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getUserInviteId() == null) ? 0 : getUserInviteId().hashCode());
        result = prime * result + ((getUserInviteName() == null) ? 0 : getUserInviteName().hashCode());
        result = prime * result + ((getUserInviteMobile() == null) ? 0 : getUserInviteMobile().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}