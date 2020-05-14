package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_invite_log")
public class UserInviteLogDO implements Serializable {
    /**
     * 主键id
     */
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
     * 用户手机号
     */
    private String mobile;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 会员类型
     */
    @Column(name = "member_type")
    private String memberType;

    /**
     * 会员等级
     */
    private String grade;

    /**
     * 会员推荐人id
     */
    @Column(name = "user_inviter_id")
    private String userInviterId;

    /**
     * 会员推荐人姓名
     */
    @Column(name = "user_inviter_name")
    private String userInviterName;

    /**
     * 会员推荐人手机号
     */
    @Column(name = "user_inviter_mobile")
    private String userInviterMobile;

    /**
     * 会员推广时间
     */
    @Column(name = "invite_time")
    private Date inviteTime;

    /**
     * 新增时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 更新时间
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
     * 获取用户手机号
     *
     * @return mobile - 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     *
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取会员类型
     *
     * @return member_type - 会员类型
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * 设置会员类型
     *
     * @param memberType 会员类型
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * 获取会员等级
     *
     * @return grade - 会员等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置会员等级
     *
     * @param grade 会员等级
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * 获取会员推荐人id
     *
     * @return user_inviter_id - 会员推荐人id
     */
    public String getUserInviterId() {
        return userInviterId;
    }

    /**
     * 设置会员推荐人id
     *
     * @param userInviterId 会员推荐人id
     */
    public void setUserInviterId(String userInviterId) {
        this.userInviterId = userInviterId == null ? null : userInviterId.trim();
    }

    /**
     * 获取会员推荐人姓名
     *
     * @return user_inviter_name - 会员推荐人姓名
     */
    public String getUserInviterName() {
        return userInviterName;
    }

    /**
     * 设置会员推荐人姓名
     *
     * @param userInviterName 会员推荐人姓名
     */
    public void setUserInviterName(String userInviterName) {
        this.userInviterName = userInviterName == null ? null : userInviterName.trim();
    }

    /**
     * 获取会员推荐人手机号
     *
     * @return user_inviter_mobile - 会员推荐人手机号
     */
    public String getUserInviterMobile() {
        return userInviterMobile;
    }

    /**
     * 设置会员推荐人手机号
     *
     * @param userInviterMobile 会员推荐人手机号
     */
    public void setUserInviterMobile(String userInviterMobile) {
        this.userInviterMobile = userInviterMobile == null ? null : userInviterMobile.trim();
    }

    /**
     * 获取会员推广时间
     *
     * @return invite_time - 会员推广时间
     */
    public Date getInviteTime() {
        return inviteTime;
    }

    /**
     * 设置会员推广时间
     *
     * @param inviteTime 会员推广时间
     */
    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取更新时间
     *
     * @return raw_update_time - 更新时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param rawUpdateTime 更新时间
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
        sb.append(", mobile=").append(mobile);
        sb.append(", birthday=").append(birthday);
        sb.append(", nickName=").append(nickName);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", memberType=").append(memberType);
        sb.append(", grade=").append(grade);
        sb.append(", userInviterId=").append(userInviterId);
        sb.append(", userInviterName=").append(userInviterName);
        sb.append(", userInviterMobile=").append(userInviterMobile);
        sb.append(", inviteTime=").append(inviteTime);
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
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getUserInviterId() == null ? other.getUserInviterId() == null : this.getUserInviterId().equals(other.getUserInviterId()))
            && (this.getUserInviterName() == null ? other.getUserInviterName() == null : this.getUserInviterName().equals(other.getUserInviterName()))
            && (this.getUserInviterMobile() == null ? other.getUserInviterMobile() == null : this.getUserInviterMobile().equals(other.getUserInviterMobile()))
            && (this.getInviteTime() == null ? other.getInviteTime() == null : this.getInviteTime().equals(other.getInviteTime()))
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
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getUserInviterId() == null) ? 0 : getUserInviterId().hashCode());
        result = prime * result + ((getUserInviterName() == null) ? 0 : getUserInviterName().hashCode());
        result = prime * result + ((getUserInviterMobile() == null) ? 0 : getUserInviterMobile().hashCode());
        result = prime * result + ((getInviteTime() == null) ? 0 : getInviteTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}