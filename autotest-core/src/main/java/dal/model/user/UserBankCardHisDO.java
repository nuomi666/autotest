package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_bank_card_his")
public class UserBankCardHisDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 统一流水id
     */
    private String gid;

    /**
     * 请求流水号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 通道ID
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 银行卡号
     */
    @Column(name = "bank_card_no")
    private String bankCardNo;

    /**
     * 开户人姓名
     */
    @Column(name = "bank_card_name")
    private String bankCardName;

    /**
     * 开户人证件类型
     */
    @Column(name = "cert_type")
    private String certType;

    /**
     * 开户人证件号
     */
    @Column(name = "cert_no")
    private String certNo;

    /**
     * 开户省
     */
    private String province;

    /**
     * 开户市
     */
    private String city;

    /**
     * 开户详细地址
     */
    private String address;

    /**
     * 银行账户类型
     */
    @Column(name = "bank_account_type")
    private String bankAccountType;

    /**
     * 银行卡类型
     */
    @Column(name = "bank_card_type")
    private String bankCardType;

    /**
     * 银行简称
     */
    @Column(name = "bank_code")
    private String bankCode;

    /**
     * 联行号
     */
    @Column(name = "bank_key")
    private String bankKey;

    /**
     * 银行卡签约id
     */
    @Column(name = "bank_bind_id")
    private String bankBindId;

    /**
     * 银行卡绑定时间
     */
    @Column(name = "bind_card_time")
    private Date bindCardTime;

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
     * 获取流水号
     *
     * @return biz_no - 流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置流水号
     *
     * @param bizNo 流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取统一流水id
     *
     * @return gid - 统一流水id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置统一流水id
     *
     * @param gid 统一流水id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取请求流水号
     *
     * @return req_id - 请求流水号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求流水号
     *
     * @param reqId 请求流水号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取通道ID
     *
     * @return channel_id - 通道ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置通道ID
     *
     * @param channelId 通道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
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
     * 获取银行卡号
     *
     * @return bank_card_no - 银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankCardNo 银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * 获取开户人姓名
     *
     * @return bank_card_name - 开户人姓名
     */
    public String getBankCardName() {
        return bankCardName;
    }

    /**
     * 设置开户人姓名
     *
     * @param bankCardName 开户人姓名
     */
    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName == null ? null : bankCardName.trim();
    }

    /**
     * 获取开户人证件类型
     *
     * @return cert_type - 开户人证件类型
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置开户人证件类型
     *
     * @param certType 开户人证件类型
     */
    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    /**
     * 获取开户人证件号
     *
     * @return cert_no - 开户人证件号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 设置开户人证件号
     *
     * @param certNo 开户人证件号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * 获取开户省
     *
     * @return province - 开户省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置开户省
     *
     * @param province 开户省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取开户市
     *
     * @return city - 开户市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置开户市
     *
     * @param city 开户市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取开户详细地址
     *
     * @return address - 开户详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置开户详细地址
     *
     * @param address 开户详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取银行账户类型
     *
     * @return bank_account_type - 银行账户类型
     */
    public String getBankAccountType() {
        return bankAccountType;
    }

    /**
     * 设置银行账户类型
     *
     * @param bankAccountType 银行账户类型
     */
    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType == null ? null : bankAccountType.trim();
    }

    /**
     * 获取银行卡类型
     *
     * @return bank_card_type - 银行卡类型
     */
    public String getBankCardType() {
        return bankCardType;
    }

    /**
     * 设置银行卡类型
     *
     * @param bankCardType 银行卡类型
     */
    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType == null ? null : bankCardType.trim();
    }

    /**
     * 获取银行简称
     *
     * @return bank_code - 银行简称
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置银行简称
     *
     * @param bankCode 银行简称
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * 获取联行号
     *
     * @return bank_key - 联行号
     */
    public String getBankKey() {
        return bankKey;
    }

    /**
     * 设置联行号
     *
     * @param bankKey 联行号
     */
    public void setBankKey(String bankKey) {
        this.bankKey = bankKey == null ? null : bankKey.trim();
    }

    /**
     * 获取银行卡签约id
     *
     * @return bank_bind_id - 银行卡签约id
     */
    public String getBankBindId() {
        return bankBindId;
    }

    /**
     * 设置银行卡签约id
     *
     * @param bankBindId 银行卡签约id
     */
    public void setBankBindId(String bankBindId) {
        this.bankBindId = bankBindId == null ? null : bankBindId.trim();
    }

    /**
     * 获取银行卡绑定时间
     *
     * @return bind_card_time - 银行卡绑定时间
     */
    public Date getBindCardTime() {
        return bindCardTime;
    }

    /**
     * 设置银行卡绑定时间
     *
     * @param bindCardTime 银行卡绑定时间
     */
    public void setBindCardTime(Date bindCardTime) {
        this.bindCardTime = bindCardTime;
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
        sb.append(", bizNo=").append(bizNo);
        sb.append(", gid=").append(gid);
        sb.append(", reqId=").append(reqId);
        sb.append(", channelId=").append(channelId);
        sb.append(", userId=").append(userId);
        sb.append(", bankCardNo=").append(bankCardNo);
        sb.append(", bankCardName=").append(bankCardName);
        sb.append(", certType=").append(certType);
        sb.append(", certNo=").append(certNo);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", address=").append(address);
        sb.append(", bankAccountType=").append(bankAccountType);
        sb.append(", bankCardType=").append(bankCardType);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", bankKey=").append(bankKey);
        sb.append(", bankBindId=").append(bankBindId);
        sb.append(", bindCardTime=").append(bindCardTime);
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
        UserBankCardHisDO other = (UserBankCardHisDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBankCardNo() == null ? other.getBankCardNo() == null : this.getBankCardNo().equals(other.getBankCardNo()))
            && (this.getBankCardName() == null ? other.getBankCardName() == null : this.getBankCardName().equals(other.getBankCardName()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getBankAccountType() == null ? other.getBankAccountType() == null : this.getBankAccountType().equals(other.getBankAccountType()))
            && (this.getBankCardType() == null ? other.getBankCardType() == null : this.getBankCardType().equals(other.getBankCardType()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getBankKey() == null ? other.getBankKey() == null : this.getBankKey().equals(other.getBankKey()))
            && (this.getBankBindId() == null ? other.getBankBindId() == null : this.getBankBindId().equals(other.getBankBindId()))
            && (this.getBindCardTime() == null ? other.getBindCardTime() == null : this.getBindCardTime().equals(other.getBindCardTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBankCardNo() == null) ? 0 : getBankCardNo().hashCode());
        result = prime * result + ((getBankCardName() == null) ? 0 : getBankCardName().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getBankAccountType() == null) ? 0 : getBankAccountType().hashCode());
        result = prime * result + ((getBankCardType() == null) ? 0 : getBankCardType().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getBankKey() == null) ? 0 : getBankKey().hashCode());
        result = prime * result + ((getBankBindId() == null) ? 0 : getBankBindId().hashCode());
        result = prime * result + ((getBindCardTime() == null) ? 0 : getBindCardTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}