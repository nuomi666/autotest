package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_trade_favour")
public class GasTradeFavourDO implements Serializable {
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
     * 交易流水号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户姓名
     */
    @Column(name = "partner_name")
    private String partnerName;

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
     * 设备类型
     */
    @Column(name = "terminal_type")
    private String terminalType;

    /**
     * 设备编码
     */
    @Column(name = "terminal_code")
    private String terminalCode;

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
     * 会员类型
     */
    @Column(name = "member_type")
    private String memberType;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 卡号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 支付方式
     */
    @Column(name = "trade_pay_type")
    private String tradePayType;

    /**
     * 支付模式
     */
    @Column(name = "pay_model")
    private String payModel;

    /**
     * 优惠定义id
     */
    @Column(name = "favour_definition_id")
    private String favourDefinitionId;

    /**
     * 优惠id
     */
    @Column(name = "favour_id")
    private String favourId;

    /**
     * 优惠名称
     */
    @Column(name = "favour_name")
    private String favourName;

    /**
     * 优惠类别 如活动优惠,优惠券优惠
     */
    @Column(name = "favour_category")
    private String favourCategory;

    /**
     * 优惠类型 如油品优惠,非油品优惠
     */
    @Column(name = "favour_type")
    private String favourType;

    /**
     * 优惠规则
     */
    @Column(name = "favour_rule")
    private String favourRule;

    /**
     * 促销方式
     */
    @Column(name = "promotion_way")
    private String promotionWay;

    /**
     * 优惠金额
     */
    @Column(name = "favour_amount")
    private Long favourAmount;

    /**
     * 状态
     */
    private String status;

    /**
     * 节点状态
     */
    private String state;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

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
     * 获取交易流水号
     *
     * @return trade_no - 交易流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易流水号
     *
     * @param tradeNo 交易流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取商户ID
     *
     * @return partner_id - 商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户ID
     *
     * @param partnerId 商户ID
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
     * 获取设备类型
     *
     * @return terminal_type - 设备类型
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 设置设备类型
     *
     * @param terminalType 设备类型
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
    }

    /**
     * 获取设备编码
     *
     * @return terminal_code - 设备编码
     */
    public String getTerminalCode() {
        return terminalCode;
    }

    /**
     * 设置设备编码
     *
     * @param terminalCode 设备编码
     */
    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode == null ? null : terminalCode.trim();
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
     * 获取卡号
     *
     * @return card_no - 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置卡号
     *
     * @param cardNo 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取支付方式
     *
     * @return trade_pay_type - 支付方式
     */
    public String getTradePayType() {
        return tradePayType;
    }

    /**
     * 设置支付方式
     *
     * @param tradePayType 支付方式
     */
    public void setTradePayType(String tradePayType) {
        this.tradePayType = tradePayType == null ? null : tradePayType.trim();
    }

    /**
     * 获取支付模式
     *
     * @return pay_model - 支付模式
     */
    public String getPayModel() {
        return payModel;
    }

    /**
     * 设置支付模式
     *
     * @param payModel 支付模式
     */
    public void setPayModel(String payModel) {
        this.payModel = payModel == null ? null : payModel.trim();
    }

    /**
     * 获取优惠定义id
     *
     * @return favour_definition_id - 优惠定义id
     */
    public String getFavourDefinitionId() {
        return favourDefinitionId;
    }

    /**
     * 设置优惠定义id
     *
     * @param favourDefinitionId 优惠定义id
     */
    public void setFavourDefinitionId(String favourDefinitionId) {
        this.favourDefinitionId = favourDefinitionId == null ? null : favourDefinitionId.trim();
    }

    /**
     * 获取优惠id
     *
     * @return favour_id - 优惠id
     */
    public String getFavourId() {
        return favourId;
    }

    /**
     * 设置优惠id
     *
     * @param favourId 优惠id
     */
    public void setFavourId(String favourId) {
        this.favourId = favourId == null ? null : favourId.trim();
    }

    /**
     * 获取优惠名称
     *
     * @return favour_name - 优惠名称
     */
    public String getFavourName() {
        return favourName;
    }

    /**
     * 设置优惠名称
     *
     * @param favourName 优惠名称
     */
    public void setFavourName(String favourName) {
        this.favourName = favourName == null ? null : favourName.trim();
    }

    /**
     * 获取优惠类别 如活动优惠,优惠券优惠
     *
     * @return favour_category - 优惠类别 如活动优惠,优惠券优惠
     */
    public String getFavourCategory() {
        return favourCategory;
    }

    /**
     * 设置优惠类别 如活动优惠,优惠券优惠
     *
     * @param favourCategory 优惠类别 如活动优惠,优惠券优惠
     */
    public void setFavourCategory(String favourCategory) {
        this.favourCategory = favourCategory == null ? null : favourCategory.trim();
    }

    /**
     * 获取优惠类型 如油品优惠,非油品优惠
     *
     * @return favour_type - 优惠类型 如油品优惠,非油品优惠
     */
    public String getFavourType() {
        return favourType;
    }

    /**
     * 设置优惠类型 如油品优惠,非油品优惠
     *
     * @param favourType 优惠类型 如油品优惠,非油品优惠
     */
    public void setFavourType(String favourType) {
        this.favourType = favourType == null ? null : favourType.trim();
    }

    /**
     * 获取优惠规则
     *
     * @return favour_rule - 优惠规则
     */
    public String getFavourRule() {
        return favourRule;
    }

    /**
     * 设置优惠规则
     *
     * @param favourRule 优惠规则
     */
    public void setFavourRule(String favourRule) {
        this.favourRule = favourRule == null ? null : favourRule.trim();
    }

    /**
     * 获取促销方式
     *
     * @return promotion_way - 促销方式
     */
    public String getPromotionWay() {
        return promotionWay;
    }

    /**
     * 设置促销方式
     *
     * @param promotionWay 促销方式
     */
    public void setPromotionWay(String promotionWay) {
        this.promotionWay = promotionWay == null ? null : promotionWay.trim();
    }

    /**
     * 获取优惠金额
     *
     * @return favour_amount - 优惠金额
     */
    public Long getFavourAmount() {
        return favourAmount;
    }

    /**
     * 设置优惠金额
     *
     * @param favourAmount 优惠金额
     */
    public void setFavourAmount(Long favourAmount) {
        this.favourAmount = favourAmount;
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
     * 获取节点状态
     *
     * @return state - 节点状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置节点状态
     *
     * @param state 节点状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取订单创建时间
     *
     * @return create_time - 订单创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", stationId=").append(stationId);
        sb.append(", stationCode=").append(stationCode);
        sb.append(", stationName=").append(stationName);
        sb.append(", operateId=").append(operateId);
        sb.append(", operateName=").append(operateName);
        sb.append(", terminalType=").append(terminalType);
        sb.append(", terminalCode=").append(terminalCode);
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", memberType=").append(memberType);
        sb.append(", mobile=").append(mobile);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", tradePayType=").append(tradePayType);
        sb.append(", payModel=").append(payModel);
        sb.append(", favourDefinitionId=").append(favourDefinitionId);
        sb.append(", favourId=").append(favourId);
        sb.append(", favourName=").append(favourName);
        sb.append(", favourCategory=").append(favourCategory);
        sb.append(", favourType=").append(favourType);
        sb.append(", favourRule=").append(favourRule);
        sb.append(", promotionWay=").append(promotionWay);
        sb.append(", favourAmount=").append(favourAmount);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", finishTime=").append(finishTime);
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
        GasTradeFavourDO other = (GasTradeFavourDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationCode() == null ? other.getStationCode() == null : this.getStationCode().equals(other.getStationCode()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getOperateId() == null ? other.getOperateId() == null : this.getOperateId().equals(other.getOperateId()))
            && (this.getOperateName() == null ? other.getOperateName() == null : this.getOperateName().equals(other.getOperateName()))
            && (this.getTerminalType() == null ? other.getTerminalType() == null : this.getTerminalType().equals(other.getTerminalType()))
            && (this.getTerminalCode() == null ? other.getTerminalCode() == null : this.getTerminalCode().equals(other.getTerminalCode()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getTradePayType() == null ? other.getTradePayType() == null : this.getTradePayType().equals(other.getTradePayType()))
            && (this.getPayModel() == null ? other.getPayModel() == null : this.getPayModel().equals(other.getPayModel()))
            && (this.getFavourDefinitionId() == null ? other.getFavourDefinitionId() == null : this.getFavourDefinitionId().equals(other.getFavourDefinitionId()))
            && (this.getFavourId() == null ? other.getFavourId() == null : this.getFavourId().equals(other.getFavourId()))
            && (this.getFavourName() == null ? other.getFavourName() == null : this.getFavourName().equals(other.getFavourName()))
            && (this.getFavourCategory() == null ? other.getFavourCategory() == null : this.getFavourCategory().equals(other.getFavourCategory()))
            && (this.getFavourType() == null ? other.getFavourType() == null : this.getFavourType().equals(other.getFavourType()))
            && (this.getFavourRule() == null ? other.getFavourRule() == null : this.getFavourRule().equals(other.getFavourRule()))
            && (this.getPromotionWay() == null ? other.getPromotionWay() == null : this.getPromotionWay().equals(other.getPromotionWay()))
            && (this.getFavourAmount() == null ? other.getFavourAmount() == null : this.getFavourAmount().equals(other.getFavourAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
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
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationCode() == null) ? 0 : getStationCode().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getOperateId() == null) ? 0 : getOperateId().hashCode());
        result = prime * result + ((getOperateName() == null) ? 0 : getOperateName().hashCode());
        result = prime * result + ((getTerminalType() == null) ? 0 : getTerminalType().hashCode());
        result = prime * result + ((getTerminalCode() == null) ? 0 : getTerminalCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getTradePayType() == null) ? 0 : getTradePayType().hashCode());
        result = prime * result + ((getPayModel() == null) ? 0 : getPayModel().hashCode());
        result = prime * result + ((getFavourDefinitionId() == null) ? 0 : getFavourDefinitionId().hashCode());
        result = prime * result + ((getFavourId() == null) ? 0 : getFavourId().hashCode());
        result = prime * result + ((getFavourName() == null) ? 0 : getFavourName().hashCode());
        result = prime * result + ((getFavourCategory() == null) ? 0 : getFavourCategory().hashCode());
        result = prime * result + ((getFavourType() == null) ? 0 : getFavourType().hashCode());
        result = prime * result + ((getFavourRule() == null) ? 0 : getFavourRule().hashCode());
        result = prime * result + ((getPromotionWay() == null) ? 0 : getPromotionWay().hashCode());
        result = prime * result + ((getFavourAmount() == null) ? 0 : getFavourAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}