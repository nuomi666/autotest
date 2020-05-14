package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_trade_oil")
public class GasTradeOilDO implements Serializable {
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
     * 身份证号码
     */
    @Column(name = "cert_no")
    private String certNo;

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
     * 会员等级
     */
    @Column(name = "user_grade")
    private String userGrade;

    /**
     * 会员分组编码
     */
    @Column(name = "group_code")
    private String groupCode;

    /**
     * 会员分组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 卡号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 车牌号
     */
    @Column(name = "car_number")
    private String carNumber;

    /**
     * 油品类型
     */
    @Column(name = "oil_type")
    private String oilType;

    /**
     * 油品编码
     */
    @Column(name = "oil_code")
    private String oilCode;

    /**
     * 油品名称
     */
    @Column(name = "oil_name")
    private String oilName;

    /**
     * 油品挂牌价
     */
    @Column(name = "listed_price")
    private Long listedPrice;

    /**
     * 油品单价
     */
    @Column(name = "oil_price")
    private Long oilPrice;

    /**
     * 油品升数
     */
    @Column(name = "oil_liter")
    private Double oilLiter;

    /**
     * 油枪
     */
    @Column(name = "oil_gun")
    private String oilGun;

    /**
     * 油品金额
     */
    @Column(name = "oil_amount")
    private Long oilAmount;

    /**
     * 油品优惠金额
     */
    @Column(name = "oil_favour_amount")
    private Long oilFavourAmount;

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
     * 获取会员等级
     *
     * @return user_grade - 会员等级
     */
    public String getUserGrade() {
        return userGrade;
    }

    /**
     * 设置会员等级
     *
     * @param userGrade 会员等级
     */
    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade == null ? null : userGrade.trim();
    }

    /**
     * 获取会员分组编码
     *
     * @return group_code - 会员分组编码
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * 设置会员分组编码
     *
     * @param groupCode 会员分组编码
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    /**
     * 获取会员分组名称
     *
     * @return group_name - 会员分组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置会员分组名称
     *
     * @param groupName 会员分组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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
     * 获取油品类型
     *
     * @return oil_type - 油品类型
     */
    public String getOilType() {
        return oilType;
    }

    /**
     * 设置油品类型
     *
     * @param oilType 油品类型
     */
    public void setOilType(String oilType) {
        this.oilType = oilType == null ? null : oilType.trim();
    }

    /**
     * 获取油品编码
     *
     * @return oil_code - 油品编码
     */
    public String getOilCode() {
        return oilCode;
    }

    /**
     * 设置油品编码
     *
     * @param oilCode 油品编码
     */
    public void setOilCode(String oilCode) {
        this.oilCode = oilCode == null ? null : oilCode.trim();
    }

    /**
     * 获取油品名称
     *
     * @return oil_name - 油品名称
     */
    public String getOilName() {
        return oilName;
    }

    /**
     * 设置油品名称
     *
     * @param oilName 油品名称
     */
    public void setOilName(String oilName) {
        this.oilName = oilName == null ? null : oilName.trim();
    }

    /**
     * 获取油品挂牌价
     *
     * @return listed_price - 油品挂牌价
     */
    public Long getListedPrice() {
        return listedPrice;
    }

    /**
     * 设置油品挂牌价
     *
     * @param listedPrice 油品挂牌价
     */
    public void setListedPrice(Long listedPrice) {
        this.listedPrice = listedPrice;
    }

    /**
     * 获取油品单价
     *
     * @return oil_price - 油品单价
     */
    public Long getOilPrice() {
        return oilPrice;
    }

    /**
     * 设置油品单价
     *
     * @param oilPrice 油品单价
     */
    public void setOilPrice(Long oilPrice) {
        this.oilPrice = oilPrice;
    }

    /**
     * 获取油品升数
     *
     * @return oil_liter - 油品升数
     */
    public Double getOilLiter() {
        return oilLiter;
    }

    /**
     * 设置油品升数
     *
     * @param oilLiter 油品升数
     */
    public void setOilLiter(Double oilLiter) {
        this.oilLiter = oilLiter;
    }

    /**
     * 获取油枪
     *
     * @return oil_gun - 油枪
     */
    public String getOilGun() {
        return oilGun;
    }

    /**
     * 设置油枪
     *
     * @param oilGun 油枪
     */
    public void setOilGun(String oilGun) {
        this.oilGun = oilGun == null ? null : oilGun.trim();
    }

    /**
     * 获取油品金额
     *
     * @return oil_amount - 油品金额
     */
    public Long getOilAmount() {
        return oilAmount;
    }

    /**
     * 设置油品金额
     *
     * @param oilAmount 油品金额
     */
    public void setOilAmount(Long oilAmount) {
        this.oilAmount = oilAmount;
    }

    /**
     * 获取油品优惠金额
     *
     * @return oil_favour_amount - 油品优惠金额
     */
    public Long getOilFavourAmount() {
        return oilFavourAmount;
    }

    /**
     * 设置油品优惠金额
     *
     * @param oilFavourAmount 油品优惠金额
     */
    public void setOilFavourAmount(Long oilFavourAmount) {
        this.oilFavourAmount = oilFavourAmount;
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
        sb.append(", certNo=").append(certNo);
        sb.append(", nickName=").append(nickName);
        sb.append(", memberType=").append(memberType);
        sb.append(", mobile=").append(mobile);
        sb.append(", userGrade=").append(userGrade);
        sb.append(", groupCode=").append(groupCode);
        sb.append(", groupName=").append(groupName);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", carNumber=").append(carNumber);
        sb.append(", oilType=").append(oilType);
        sb.append(", oilCode=").append(oilCode);
        sb.append(", oilName=").append(oilName);
        sb.append(", listedPrice=").append(listedPrice);
        sb.append(", oilPrice=").append(oilPrice);
        sb.append(", oilLiter=").append(oilLiter);
        sb.append(", oilGun=").append(oilGun);
        sb.append(", oilAmount=").append(oilAmount);
        sb.append(", oilFavourAmount=").append(oilFavourAmount);
        sb.append(", tradePayType=").append(tradePayType);
        sb.append(", payModel=").append(payModel);
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
        GasTradeOilDO other = (GasTradeOilDO) that;
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
            && (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getUserGrade() == null ? other.getUserGrade() == null : this.getUserGrade().equals(other.getUserGrade()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getCarNumber() == null ? other.getCarNumber() == null : this.getCarNumber().equals(other.getCarNumber()))
            && (this.getOilType() == null ? other.getOilType() == null : this.getOilType().equals(other.getOilType()))
            && (this.getOilCode() == null ? other.getOilCode() == null : this.getOilCode().equals(other.getOilCode()))
            && (this.getOilName() == null ? other.getOilName() == null : this.getOilName().equals(other.getOilName()))
            && (this.getListedPrice() == null ? other.getListedPrice() == null : this.getListedPrice().equals(other.getListedPrice()))
            && (this.getOilPrice() == null ? other.getOilPrice() == null : this.getOilPrice().equals(other.getOilPrice()))
            && (this.getOilLiter() == null ? other.getOilLiter() == null : this.getOilLiter().equals(other.getOilLiter()))
            && (this.getOilGun() == null ? other.getOilGun() == null : this.getOilGun().equals(other.getOilGun()))
            && (this.getOilAmount() == null ? other.getOilAmount() == null : this.getOilAmount().equals(other.getOilAmount()))
            && (this.getOilFavourAmount() == null ? other.getOilFavourAmount() == null : this.getOilFavourAmount().equals(other.getOilFavourAmount()))
            && (this.getTradePayType() == null ? other.getTradePayType() == null : this.getTradePayType().equals(other.getTradePayType()))
            && (this.getPayModel() == null ? other.getPayModel() == null : this.getPayModel().equals(other.getPayModel()))
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
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getUserGrade() == null) ? 0 : getUserGrade().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getCarNumber() == null) ? 0 : getCarNumber().hashCode());
        result = prime * result + ((getOilType() == null) ? 0 : getOilType().hashCode());
        result = prime * result + ((getOilCode() == null) ? 0 : getOilCode().hashCode());
        result = prime * result + ((getOilName() == null) ? 0 : getOilName().hashCode());
        result = prime * result + ((getListedPrice() == null) ? 0 : getListedPrice().hashCode());
        result = prime * result + ((getOilPrice() == null) ? 0 : getOilPrice().hashCode());
        result = prime * result + ((getOilLiter() == null) ? 0 : getOilLiter().hashCode());
        result = prime * result + ((getOilGun() == null) ? 0 : getOilGun().hashCode());
        result = prime * result + ((getOilAmount() == null) ? 0 : getOilAmount().hashCode());
        result = prime * result + ((getOilFavourAmount() == null) ? 0 : getOilFavourAmount().hashCode());
        result = prime * result + ((getTradePayType() == null) ? 0 : getTradePayType().hashCode());
        result = prime * result + ((getPayModel() == null) ? 0 : getPayModel().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}