package dal.model.gas_trade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_trade_give")
public class GasTradeGiveDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 交易类型
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 活动名称
     */
    @Column(name = "campaign_name")
    private String campaignName;

    /**
     * 赠送id
     */
    @Column(name = "give_id")
    private String giveId;

    /**
     * 赠送定义ID
     */
    @Column(name = "give_definition_id")
    private String giveDefinitionId;

    /**
     * 赠送名称
     */
    @Column(name = "give_name")
    private String giveName;

    /**
     * 赠送类型
     */
    @Column(name = "give_type")
    private String giveType;

    /**
     * 赠送内容
     */
    @Column(name = "give_content")
    private String giveContent;

    /**
     * 赠送标识
     */
    @Column(name = "give_index")
    private String giveIndex;

    /**
     * 赠送金额
     */
    @Column(name = "give_amount")
    private Long giveAmount;

    /**
     * 赠送数量
     */
    @Column(name = "give_num")
    private Integer giveNum;

    /**
     * 赠送对象
     */
    @Column(name = "give_obj")
    private String giveObj;

    /**
     * 会员ID
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
     * 手机号
     */
    private String mobile;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 完成时间
     */
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
     * 获取交易类型
     *
     * @return trade_type - 交易类型
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * 设置交易类型
     *
     * @param tradeType 交易类型
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
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
     * 获取赠送id
     *
     * @return give_id - 赠送id
     */
    public String getGiveId() {
        return giveId;
    }

    /**
     * 设置赠送id
     *
     * @param giveId 赠送id
     */
    public void setGiveId(String giveId) {
        this.giveId = giveId == null ? null : giveId.trim();
    }

    /**
     * 获取赠送定义ID
     *
     * @return give_definition_id - 赠送定义ID
     */
    public String getGiveDefinitionId() {
        return giveDefinitionId;
    }

    /**
     * 设置赠送定义ID
     *
     * @param giveDefinitionId 赠送定义ID
     */
    public void setGiveDefinitionId(String giveDefinitionId) {
        this.giveDefinitionId = giveDefinitionId == null ? null : giveDefinitionId.trim();
    }

    /**
     * 获取赠送名称
     *
     * @return give_name - 赠送名称
     */
    public String getGiveName() {
        return giveName;
    }

    /**
     * 设置赠送名称
     *
     * @param giveName 赠送名称
     */
    public void setGiveName(String giveName) {
        this.giveName = giveName == null ? null : giveName.trim();
    }

    /**
     * 获取赠送类型
     *
     * @return give_type - 赠送类型
     */
    public String getGiveType() {
        return giveType;
    }

    /**
     * 设置赠送类型
     *
     * @param giveType 赠送类型
     */
    public void setGiveType(String giveType) {
        this.giveType = giveType == null ? null : giveType.trim();
    }

    /**
     * 获取赠送内容
     *
     * @return give_content - 赠送内容
     */
    public String getGiveContent() {
        return giveContent;
    }

    /**
     * 设置赠送内容
     *
     * @param giveContent 赠送内容
     */
    public void setGiveContent(String giveContent) {
        this.giveContent = giveContent == null ? null : giveContent.trim();
    }

    /**
     * 获取赠送标识
     *
     * @return give_index - 赠送标识
     */
    public String getGiveIndex() {
        return giveIndex;
    }

    /**
     * 设置赠送标识
     *
     * @param giveIndex 赠送标识
     */
    public void setGiveIndex(String giveIndex) {
        this.giveIndex = giveIndex == null ? null : giveIndex.trim();
    }

    /**
     * 获取赠送金额
     *
     * @return give_amount - 赠送金额
     */
    public Long getGiveAmount() {
        return giveAmount;
    }

    /**
     * 设置赠送金额
     *
     * @param giveAmount 赠送金额
     */
    public void setGiveAmount(Long giveAmount) {
        this.giveAmount = giveAmount;
    }

    /**
     * 获取赠送数量
     *
     * @return give_num - 赠送数量
     */
    public Integer getGiveNum() {
        return giveNum;
    }

    /**
     * 设置赠送数量
     *
     * @param giveNum 赠送数量
     */
    public void setGiveNum(Integer giveNum) {
        this.giveNum = giveNum;
    }

    /**
     * 获取赠送对象
     *
     * @return give_obj - 赠送对象
     */
    public String getGiveObj() {
        return giveObj;
    }

    /**
     * 设置赠送对象
     *
     * @param giveObj 赠送对象
     */
    public void setGiveObj(String giveObj) {
        this.giveObj = giveObj == null ? null : giveObj.trim();
    }

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
     * 获取完成时间
     *
     * @return raw_update_time - 完成时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置完成时间
     *
     * @param rawUpdateTime 完成时间
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
        sb.append(", bizNo=").append(bizNo);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", campaignName=").append(campaignName);
        sb.append(", giveId=").append(giveId);
        sb.append(", giveDefinitionId=").append(giveDefinitionId);
        sb.append(", giveName=").append(giveName);
        sb.append(", giveType=").append(giveType);
        sb.append(", giveContent=").append(giveContent);
        sb.append(", giveIndex=").append(giveIndex);
        sb.append(", giveAmount=").append(giveAmount);
        sb.append(", giveNum=").append(giveNum);
        sb.append(", giveObj=").append(giveObj);
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", mobile=").append(mobile);
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
        GasTradeGiveDO other = (GasTradeGiveDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getCampaignName() == null ? other.getCampaignName() == null : this.getCampaignName().equals(other.getCampaignName()))
            && (this.getGiveId() == null ? other.getGiveId() == null : this.getGiveId().equals(other.getGiveId()))
            && (this.getGiveDefinitionId() == null ? other.getGiveDefinitionId() == null : this.getGiveDefinitionId().equals(other.getGiveDefinitionId()))
            && (this.getGiveName() == null ? other.getGiveName() == null : this.getGiveName().equals(other.getGiveName()))
            && (this.getGiveType() == null ? other.getGiveType() == null : this.getGiveType().equals(other.getGiveType()))
            && (this.getGiveContent() == null ? other.getGiveContent() == null : this.getGiveContent().equals(other.getGiveContent()))
            && (this.getGiveIndex() == null ? other.getGiveIndex() == null : this.getGiveIndex().equals(other.getGiveIndex()))
            && (this.getGiveAmount() == null ? other.getGiveAmount() == null : this.getGiveAmount().equals(other.getGiveAmount()))
            && (this.getGiveNum() == null ? other.getGiveNum() == null : this.getGiveNum().equals(other.getGiveNum()))
            && (this.getGiveObj() == null ? other.getGiveObj() == null : this.getGiveObj().equals(other.getGiveObj()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getCampaignName() == null) ? 0 : getCampaignName().hashCode());
        result = prime * result + ((getGiveId() == null) ? 0 : getGiveId().hashCode());
        result = prime * result + ((getGiveDefinitionId() == null) ? 0 : getGiveDefinitionId().hashCode());
        result = prime * result + ((getGiveName() == null) ? 0 : getGiveName().hashCode());
        result = prime * result + ((getGiveType() == null) ? 0 : getGiveType().hashCode());
        result = prime * result + ((getGiveContent() == null) ? 0 : getGiveContent().hashCode());
        result = prime * result + ((getGiveIndex() == null) ? 0 : getGiveIndex().hashCode());
        result = prime * result + ((getGiveAmount() == null) ? 0 : getGiveAmount().hashCode());
        result = prime * result + ((getGiveNum() == null) ? 0 : getGiveNum().hashCode());
        result = prime * result + ((getGiveObj() == null) ? 0 : getGiveObj().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}