package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_user")
public class GasUserDO implements Serializable {
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
     * 身份证号码
     */
    @Column(name = "cert_no")
    private String certNo;

    /**
     * 账户标签
     */
    @Column(name = "account_tag")
    private String accountTag;

    /**
     * 头像地址
     */
    @Column(name = "head_img_url")
    private String headImgUrl;

    /**
     * 车牌号
     */
    @Column(name = "car_number")
    private String carNumber;

    /**
     * 车型
     */
    @Column(name = "car_type")
    private String carType;

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
     * 分组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 分组编码
     */
    @Column(name = "group_code")
    private String groupCode;

    /**
     * 推广来源
     */
    @Column(name = "recommend_source")
    private String recommendSource;

    /**
     * 推荐人id
     */
    @Column(name = "recommend_id")
    private String recommendId;

    /**
     * 推荐人所属油站id
     */
    @Column(name = "recommend_station_id")
    private String recommendStationId;

    /**
     * 推荐人所属油站名称
     */
    @Column(name = "recommend_station_name")
    private String recommendStationName;

    /**
     * 推荐人所属油站编码
     */
    @Column(name = "recommend_station_code")
    private String recommendStationCode;

    /**
     * 推荐人手机号
     */
    @Column(name = "recommend_mobile")
    private String recommendMobile;

    /**
     * 推荐人姓名
     */
    @Column(name = "recommend_name")
    private String recommendName;

    /**
     * 会员创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 会员更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
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
     * 获取身份证号码
     *
     * @return cert_no - 身份证号码
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 设置身份证号码
     *
     * @param certNo 身份证号码
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * 获取账户标签
     *
     * @return account_tag - 账户标签
     */
    public String getAccountTag() {
        return accountTag;
    }

    /**
     * 设置账户标签
     *
     * @param accountTag 账户标签
     */
    public void setAccountTag(String accountTag) {
        this.accountTag = accountTag == null ? null : accountTag.trim();
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
     * 获取车牌号
     *
     * @return car_number - 车牌号
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * 设置车牌号
     *
     * @param carNumber 车牌号
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    /**
     * 获取车型
     *
     * @return car_type - 车型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置车型
     *
     * @param carType 车型
     */
    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
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

    /**
     * 获取推广来源
     *
     * @return recommend_source - 推广来源
     */
    public String getRecommendSource() {
        return recommendSource;
    }

    /**
     * 设置推广来源
     *
     * @param recommendSource 推广来源
     */
    public void setRecommendSource(String recommendSource) {
        this.recommendSource = recommendSource == null ? null : recommendSource.trim();
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
     * 获取推荐人所属油站id
     *
     * @return recommend_station_id - 推荐人所属油站id
     */
    public String getRecommendStationId() {
        return recommendStationId;
    }

    /**
     * 设置推荐人所属油站id
     *
     * @param recommendStationId 推荐人所属油站id
     */
    public void setRecommendStationId(String recommendStationId) {
        this.recommendStationId = recommendStationId == null ? null : recommendStationId.trim();
    }

    /**
     * 获取推荐人所属油站名称
     *
     * @return recommend_station_name - 推荐人所属油站名称
     */
    public String getRecommendStationName() {
        return recommendStationName;
    }

    /**
     * 设置推荐人所属油站名称
     *
     * @param recommendStationName 推荐人所属油站名称
     */
    public void setRecommendStationName(String recommendStationName) {
        this.recommendStationName = recommendStationName == null ? null : recommendStationName.trim();
    }

    /**
     * 获取推荐人所属油站编码
     *
     * @return recommend_station_code - 推荐人所属油站编码
     */
    public String getRecommendStationCode() {
        return recommendStationCode;
    }

    /**
     * 设置推荐人所属油站编码
     *
     * @param recommendStationCode 推荐人所属油站编码
     */
    public void setRecommendStationCode(String recommendStationCode) {
        this.recommendStationCode = recommendStationCode == null ? null : recommendStationCode.trim();
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
     * 获取推荐人姓名
     *
     * @return recommend_name - 推荐人姓名
     */
    public String getRecommendName() {
        return recommendName;
    }

    /**
     * 设置推荐人姓名
     *
     * @param recommendName 推荐人姓名
     */
    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName == null ? null : recommendName.trim();
    }

    /**
     * 获取会员创建时间
     *
     * @return create_time - 会员创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置会员创建时间
     *
     * @param createTime 会员创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取会员更新时间
     *
     * @return update_time - 会员更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置会员更新时间
     *
     * @param updateTime 会员更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建时间
     *
     * @return raw_add_time - 创建时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置创建时间
     *
     * @param rawAddTime 创建时间
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
        sb.append(", userId=").append(userId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", mobile=").append(mobile);
        sb.append(", birthday=").append(birthday);
        sb.append(", shortBirthday=").append(shortBirthday);
        sb.append(", nickName=").append(nickName);
        sb.append(", realName=").append(realName);
        sb.append(", certNo=").append(certNo);
        sb.append(", accountTag=").append(accountTag);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", carNumber=").append(carNumber);
        sb.append(", carType=").append(carType);
        sb.append(", sex=").append(sex);
        sb.append(", memberType=").append(memberType);
        sb.append(", grade=").append(grade);
        sb.append(", groupName=").append(groupName);
        sb.append(", groupCode=").append(groupCode);
        sb.append(", recommendSource=").append(recommendSource);
        sb.append(", recommendId=").append(recommendId);
        sb.append(", recommendStationId=").append(recommendStationId);
        sb.append(", recommendStationName=").append(recommendStationName);
        sb.append(", recommendStationCode=").append(recommendStationCode);
        sb.append(", recommendMobile=").append(recommendMobile);
        sb.append(", recommendName=").append(recommendName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        GasUserDO other = (GasUserDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getShortBirthday() == null ? other.getShortBirthday() == null : this.getShortBirthday().equals(other.getShortBirthday()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
            && (this.getAccountTag() == null ? other.getAccountTag() == null : this.getAccountTag().equals(other.getAccountTag()))
            && (this.getHeadImgUrl() == null ? other.getHeadImgUrl() == null : this.getHeadImgUrl().equals(other.getHeadImgUrl()))
            && (this.getCarNumber() == null ? other.getCarNumber() == null : this.getCarNumber().equals(other.getCarNumber()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getRecommendSource() == null ? other.getRecommendSource() == null : this.getRecommendSource().equals(other.getRecommendSource()))
            && (this.getRecommendId() == null ? other.getRecommendId() == null : this.getRecommendId().equals(other.getRecommendId()))
            && (this.getRecommendStationId() == null ? other.getRecommendStationId() == null : this.getRecommendStationId().equals(other.getRecommendStationId()))
            && (this.getRecommendStationName() == null ? other.getRecommendStationName() == null : this.getRecommendStationName().equals(other.getRecommendStationName()))
            && (this.getRecommendStationCode() == null ? other.getRecommendStationCode() == null : this.getRecommendStationCode().equals(other.getRecommendStationCode()))
            && (this.getRecommendMobile() == null ? other.getRecommendMobile() == null : this.getRecommendMobile().equals(other.getRecommendMobile()))
            && (this.getRecommendName() == null ? other.getRecommendName() == null : this.getRecommendName().equals(other.getRecommendName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
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
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getShortBirthday() == null) ? 0 : getShortBirthday().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getAccountTag() == null) ? 0 : getAccountTag().hashCode());
        result = prime * result + ((getHeadImgUrl() == null) ? 0 : getHeadImgUrl().hashCode());
        result = prime * result + ((getCarNumber() == null) ? 0 : getCarNumber().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getRecommendSource() == null) ? 0 : getRecommendSource().hashCode());
        result = prime * result + ((getRecommendId() == null) ? 0 : getRecommendId().hashCode());
        result = prime * result + ((getRecommendStationId() == null) ? 0 : getRecommendStationId().hashCode());
        result = prime * result + ((getRecommendStationName() == null) ? 0 : getRecommendStationName().hashCode());
        result = prime * result + ((getRecommendStationCode() == null) ? 0 : getRecommendStationCode().hashCode());
        result = prime * result + ((getRecommendMobile() == null) ? 0 : getRecommendMobile().hashCode());
        result = prime * result + ((getRecommendName() == null) ? 0 : getRecommendName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}