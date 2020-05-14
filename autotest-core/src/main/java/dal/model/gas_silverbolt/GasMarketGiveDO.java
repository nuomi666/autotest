package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_market_give")
public class GasMarketGiveDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 全局id
     */
    private String gid;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户姓名
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 来源类型
     */
    @Column(name = "source_type")
    private String sourceType;

    /**
     * 赠送类型,优惠券、储值金、积分
     */
    @Column(name = "give_type")
    private String giveType;

    /**
     * 赠送对象类型
     */
    @Column(name = "give_person_type")
    private String givePersonType;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 活动编号
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 活动名称
     */
    @Column(name = "campaign_name")
    private String campaignName;

    /**
     * 触发的规则id
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 优惠券/商品定义/奖品池/id
     */
    @Column(name = "definition_id")
    private String definitionId;

    /**
     * 优惠券/商品/奖品名称
     */
    @Column(name = "definition_name")
    private String definitionName;

    /**
     * 赠送金额
     */
    @Column(name = "favour_amount")
    private Long favourAmount;

    /**
     * 赠送数量
     */
    @Column(name = "give_num")
    private Long giveNum;

    /**
     * 赠送时间
     */
    @Column(name = "give_time")
    private Date giveTime;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 会员类型
     */
    @Column(name = "member_type")
    private String memberType;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 油站ID
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 油站编码
     */
    @Column(name = "station_code")
    private String stationCode;

    /**
     * 油站名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 操作员ID
     */
    @Column(name = "operate_id")
    private String operateId;

    /**
     * 操作员姓名
     */
    @Column(name = "operate_name")
    private String operateName;

    /**
     * 终端类型
     */
    @Column(name = "terminal_type")
    private String terminalType;

    /**
     * 终端编码
     */
    @Column(name = "terminal_code")
    private String terminalCode;

    /**
     * 备注
     */
    private String memo;

    /**
     * 状态
     */
    private String status;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序列
     *
     * @return id - 自增序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增序列
     *
     * @param id 自增序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取全局id
     *
     * @return gid - 全局id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局id
     *
     * @param gid 全局id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
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
     * 获取商户姓名
     *
     * @return partner_name - 商户姓名
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商户姓名
     *
     * @param partnerName 商户姓名
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取来源类型
     *
     * @return source_type - 来源类型
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置来源类型
     *
     * @param sourceType 来源类型
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 获取赠送类型,优惠券、储值金、积分
     *
     * @return give_type - 赠送类型,优惠券、储值金、积分
     */
    public String getGiveType() {
        return giveType;
    }

    /**
     * 设置赠送类型,优惠券、储值金、积分
     *
     * @param giveType 赠送类型,优惠券、储值金、积分
     */
    public void setGiveType(String giveType) {
        this.giveType = giveType == null ? null : giveType.trim();
    }

    /**
     * 获取赠送对象类型
     *
     * @return give_person_type - 赠送对象类型
     */
    public String getGivePersonType() {
        return givePersonType;
    }

    /**
     * 设置赠送对象类型
     *
     * @param givePersonType 赠送对象类型
     */
    public void setGivePersonType(String givePersonType) {
        this.givePersonType = givePersonType == null ? null : givePersonType.trim();
    }

    /**
     * 获取业务流水号
     *
     * @return biz_no - 业务流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务流水号
     *
     * @param bizNo 业务流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取活动编号
     *
     * @return campaign_no - 活动编号
     */
    public String getCampaignNo() {
        return campaignNo;
    }

    /**
     * 设置活动编号
     *
     * @param campaignNo 活动编号
     */
    public void setCampaignNo(String campaignNo) {
        this.campaignNo = campaignNo == null ? null : campaignNo.trim();
    }

    /**
     * 获取活动名称
     *
     * @return campaign_name - 活动名称
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * 设置活动名称
     *
     * @param campaignName 活动名称
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName == null ? null : campaignName.trim();
    }

    /**
     * 获取触发的规则id
     *
     * @return rule_id - 触发的规则id
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置触发的规则id
     *
     * @param ruleId 触发的规则id
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取优惠券/商品定义/奖品池/id
     *
     * @return definition_id - 优惠券/商品定义/奖品池/id
     */
    public String getDefinitionId() {
        return definitionId;
    }

    /**
     * 设置优惠券/商品定义/奖品池/id
     *
     * @param definitionId 优惠券/商品定义/奖品池/id
     */
    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId == null ? null : definitionId.trim();
    }

    /**
     * 获取优惠券/商品/奖品名称
     *
     * @return definition_name - 优惠券/商品/奖品名称
     */
    public String getDefinitionName() {
        return definitionName;
    }

    /**
     * 设置优惠券/商品/奖品名称
     *
     * @param definitionName 优惠券/商品/奖品名称
     */
    public void setDefinitionName(String definitionName) {
        this.definitionName = definitionName == null ? null : definitionName.trim();
    }

    /**
     * 获取赠送金额
     *
     * @return favour_amount - 赠送金额
     */
    public Long getFavourAmount() {
        return favourAmount;
    }

    /**
     * 设置赠送金额
     *
     * @param favourAmount 赠送金额
     */
    public void setFavourAmount(Long favourAmount) {
        this.favourAmount = favourAmount;
    }

    /**
     * 获取赠送数量
     *
     * @return give_num - 赠送数量
     */
    public Long getGiveNum() {
        return giveNum;
    }

    /**
     * 设置赠送数量
     *
     * @param giveNum 赠送数量
     */
    public void setGiveNum(Long giveNum) {
        this.giveNum = giveNum;
    }

    /**
     * 获取赠送时间
     *
     * @return give_time - 赠送时间
     */
    public Date getGiveTime() {
        return giveTime;
    }

    /**
     * 设置赠送时间
     *
     * @param giveTime 赠送时间
     */
    public void setGiveTime(Date giveTime) {
        this.giveTime = giveTime;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 获取油站ID
     *
     * @return station_id - 油站ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站ID
     *
     * @param stationId 油站ID
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取油站编码
     *
     * @return station_code - 油站编码
     */
    public String getStationCode() {
        return stationCode;
    }

    /**
     * 设置油站编码
     *
     * @param stationCode 油站编码
     */
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    /**
     * 获取油站名称
     *
     * @return station_name - 油站名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置油站名称
     *
     * @param stationName 油站名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * 获取操作员ID
     *
     * @return operate_id - 操作员ID
     */
    public String getOperateId() {
        return operateId;
    }

    /**
     * 设置操作员ID
     *
     * @param operateId 操作员ID
     */
    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    /**
     * 获取操作员姓名
     *
     * @return operate_name - 操作员姓名
     */
    public String getOperateName() {
        return operateName;
    }

    /**
     * 设置操作员姓名
     *
     * @param operateName 操作员姓名
     */
    public void setOperateName(String operateName) {
        this.operateName = operateName == null ? null : operateName.trim();
    }

    /**
     * 获取终端类型
     *
     * @return terminal_type - 终端类型
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 设置终端类型
     *
     * @param terminalType 终端类型
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
    }

    /**
     * 获取终端编码
     *
     * @return terminal_code - 终端编码
     */
    public String getTerminalCode() {
        return terminalCode;
    }

    /**
     * 设置终端编码
     *
     * @param terminalCode 终端编码
     */
    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode == null ? null : terminalCode.trim();
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", giveType=").append(giveType);
        sb.append(", givePersonType=").append(givePersonType);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", campaignName=").append(campaignName);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", definitionId=").append(definitionId);
        sb.append(", definitionName=").append(definitionName);
        sb.append(", favourAmount=").append(favourAmount);
        sb.append(", giveNum=").append(giveNum);
        sb.append(", giveTime=").append(giveTime);
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", memberType=").append(memberType);
        sb.append(", mobile=").append(mobile);
        sb.append(", stationId=").append(stationId);
        sb.append(", stationCode=").append(stationCode);
        sb.append(", stationName=").append(stationName);
        sb.append(", operateId=").append(operateId);
        sb.append(", operateName=").append(operateName);
        sb.append(", terminalType=").append(terminalType);
        sb.append(", terminalCode=").append(terminalCode);
        sb.append(", memo=").append(memo);
        sb.append(", status=").append(status);
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
        GasMarketGiveDO other = (GasMarketGiveDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getGiveType() == null ? other.getGiveType() == null : this.getGiveType().equals(other.getGiveType()))
            && (this.getGivePersonType() == null ? other.getGivePersonType() == null : this.getGivePersonType().equals(other.getGivePersonType()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getCampaignName() == null ? other.getCampaignName() == null : this.getCampaignName().equals(other.getCampaignName()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getDefinitionId() == null ? other.getDefinitionId() == null : this.getDefinitionId().equals(other.getDefinitionId()))
            && (this.getDefinitionName() == null ? other.getDefinitionName() == null : this.getDefinitionName().equals(other.getDefinitionName()))
            && (this.getFavourAmount() == null ? other.getFavourAmount() == null : this.getFavourAmount().equals(other.getFavourAmount()))
            && (this.getGiveNum() == null ? other.getGiveNum() == null : this.getGiveNum().equals(other.getGiveNum()))
            && (this.getGiveTime() == null ? other.getGiveTime() == null : this.getGiveTime().equals(other.getGiveTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationCode() == null ? other.getStationCode() == null : this.getStationCode().equals(other.getStationCode()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getOperateId() == null ? other.getOperateId() == null : this.getOperateId().equals(other.getOperateId()))
            && (this.getOperateName() == null ? other.getOperateName() == null : this.getOperateName().equals(other.getOperateName()))
            && (this.getTerminalType() == null ? other.getTerminalType() == null : this.getTerminalType().equals(other.getTerminalType()))
            && (this.getTerminalCode() == null ? other.getTerminalCode() == null : this.getTerminalCode().equals(other.getTerminalCode()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getGiveType() == null) ? 0 : getGiveType().hashCode());
        result = prime * result + ((getGivePersonType() == null) ? 0 : getGivePersonType().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getCampaignName() == null) ? 0 : getCampaignName().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getDefinitionId() == null) ? 0 : getDefinitionId().hashCode());
        result = prime * result + ((getDefinitionName() == null) ? 0 : getDefinitionName().hashCode());
        result = prime * result + ((getFavourAmount() == null) ? 0 : getFavourAmount().hashCode());
        result = prime * result + ((getGiveNum() == null) ? 0 : getGiveNum().hashCode());
        result = prime * result + ((getGiveTime() == null) ? 0 : getGiveTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationCode() == null) ? 0 : getStationCode().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getOperateId() == null) ? 0 : getOperateId().hashCode());
        result = prime * result + ((getOperateName() == null) ? 0 : getOperateName().hashCode());
        result = prime * result + ((getTerminalType() == null) ? 0 : getTerminalType().hashCode());
        result = prime * result + ((getTerminalCode() == null) ? 0 : getTerminalCode().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}