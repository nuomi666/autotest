package dal.model.gas_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class UserDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 清洁算会员id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 生日(冗余，用于查询；格式:MM-dd，如10-01)
     */
    @Column(name = "short_birthday")
    private String shortBirthday;

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
     * 头像地址
     */
    @Column(name = "head_img_url")
    private String headImgUrl;

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
     * 是否进行过支付
     */
    private String payed;

    /**
     * 会员等级
     */
    private String grade;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 推广来源
     */
    private String source;

    /**
     * 推荐人id
     */
    @Column(name = "recommend_id")
    private String recommendId;

    /**
     * 推荐人手机号
     */
    @Column(name = "recommend_mobile")
    private String recommendMobile;

    /**
     * 是否完善资料
     */
    private String identifier;

    /**
     * 引入来源
     */
    @Column(name = "import_source")
    private String importSource;

    /**
     * 分组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 分组编码
     */
    @Column(name = "group_code")
    private String groupCode;

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
     * 获取清洁算会员id
     *
     * @return user_id - 清洁算会员id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置清洁算会员id
     *
     * @param userId 清洁算会员id
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
     * 获取平台商ID
     *
     * @return plat_partner_id - 平台商ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商ID
     *
     * @param platPartnerId 平台商ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
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
     * 获取生日(冗余，用于查询；格式:MM-dd，如10-01)
     *
     * @return short_birthday - 生日(冗余，用于查询；格式:MM-dd，如10-01)
     */
    public String getShortBirthday() {
        return shortBirthday;
    }

    /**
     * 设置生日(冗余，用于查询；格式:MM-dd，如10-01)
     *
     * @param shortBirthday 生日(冗余，用于查询；格式:MM-dd，如10-01)
     */
    public void setShortBirthday(String shortBirthday) {
        this.shortBirthday = shortBirthday == null ? null : shortBirthday.trim();
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
     * 获取头像地址
     *
     * @return head_img_url - 头像地址
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 设置头像地址
     *
     * @param headImgUrl 头像地址
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
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
     * 获取是否进行过支付
     *
     * @return payed - 是否进行过支付
     */
    public String getPayed() {
        return payed;
    }

    /**
     * 设置是否进行过支付
     *
     * @param payed 是否进行过支付
     */
    public void setPayed(String payed) {
        this.payed = payed == null ? null : payed.trim();
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

    /**
     * 获取推广来源
     *
     * @return source - 推广来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置推广来源
     *
     * @param source 推广来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取推荐人id
     *
     * @return recommend_id - 推荐人id
     */
    public String getRecommendId() {
        return recommendId;
    }

    /**
     * 设置推荐人id
     *
     * @param recommendId 推荐人id
     */
    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId == null ? null : recommendId.trim();
    }

    /**
     * 获取推荐人手机号
     *
     * @return recommend_mobile - 推荐人手机号
     */
    public String getRecommendMobile() {
        return recommendMobile;
    }

    /**
     * 设置推荐人手机号
     *
     * @param recommendMobile 推荐人手机号
     */
    public void setRecommendMobile(String recommendMobile) {
        this.recommendMobile = recommendMobile == null ? null : recommendMobile.trim();
    }

    /**
     * 获取是否完善资料
     *
     * @return identifier - 是否完善资料
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 设置是否完善资料
     *
     * @param identifier 是否完善资料
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * 获取引入来源
     *
     * @return import_source - 引入来源
     */
    public String getImportSource() {
        return importSource;
    }

    /**
     * 设置引入来源
     *
     * @param importSource 引入来源
     */
    public void setImportSource(String importSource) {
        this.importSource = importSource == null ? null : importSource.trim();
    }

    /**
     * 获取分组名称
     *
     * @return group_name - 分组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置分组名称
     *
     * @param groupName 分组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 获取分组编码
     *
     * @return group_code - 分组编码
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * 设置分组编码
     *
     * @param groupCode 分组编码
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", mobile=").append(mobile);
        sb.append(", birthday=").append(birthday);
        sb.append(", shortBirthday=").append(shortBirthday);
        sb.append(", nickName=").append(nickName);
        sb.append(", realName=").append(realName);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", sex=").append(sex);
        sb.append(", memberType=").append(memberType);
        sb.append(", payed=").append(payed);
        sb.append(", grade=").append(grade);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", source=").append(source);
        sb.append(", recommendId=").append(recommendId);
        sb.append(", recommendMobile=").append(recommendMobile);
        sb.append(", identifier=").append(identifier);
        sb.append(", importSource=").append(importSource);
        sb.append(", groupName=").append(groupName);
        sb.append(", groupCode=").append(groupCode);
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
        UserDO other = (UserDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getShortBirthday() == null ? other.getShortBirthday() == null : this.getShortBirthday().equals(other.getShortBirthday()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getHeadImgUrl() == null ? other.getHeadImgUrl() == null : this.getHeadImgUrl().equals(other.getHeadImgUrl()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
            && (this.getPayed() == null ? other.getPayed() == null : this.getPayed().equals(other.getPayed()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getRecommendId() == null ? other.getRecommendId() == null : this.getRecommendId().equals(other.getRecommendId()))
            && (this.getRecommendMobile() == null ? other.getRecommendMobile() == null : this.getRecommendMobile().equals(other.getRecommendMobile()))
            && (this.getIdentifier() == null ? other.getIdentifier() == null : this.getIdentifier().equals(other.getIdentifier()))
            && (this.getImportSource() == null ? other.getImportSource() == null : this.getImportSource().equals(other.getImportSource()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getShortBirthday() == null) ? 0 : getShortBirthday().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getHeadImgUrl() == null) ? 0 : getHeadImgUrl().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getPayed() == null) ? 0 : getPayed().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getRecommendId() == null) ? 0 : getRecommendId().hashCode());
        result = prime * result + ((getRecommendMobile() == null) ? 0 : getRecommendMobile().hashCode());
        result = prime * result + ((getIdentifier() == null) ? 0 : getIdentifier().hashCode());
        result = prime * result + ((getImportSource() == null) ? 0 : getImportSource().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        return result;
    }
}