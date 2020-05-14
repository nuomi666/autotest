package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account")
public class AccountDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 账号编号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 绑定账号编号
     */
    @Column(name = "band_account_no")
    private String bandAccountNo;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 账户余额,单位分
     */
    private Long balance;

    /**
     * 冻结金额，单位分
     */
    @Column(name = "freeze_balance")
    private Long freezeBalance;

    /**
     * 信用额度，单位分
     */
    @Column(name = "credit_amount")
    private Long creditAmount;

    /**
     * 总收入金额，单位分
     */
    @Column(name = "his_in_amount")
    private Long hisInAmount;

    /**
     * 总支出金额，单位分
     */
    @Column(name = "his_out_amount")
    private Long hisOutAmount;

    /**
     * 账户状态：ACTIVE（激活）/FREEZE(冻结)
     */
    private String status;

    /**
     * 账号类型
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 支付模型
     */
    @Column(name = "pay_model")
    private String payModel;

    /**
     * 标签
     */
    private String tag;

    /**
     * 账号备注
     */
    private String memo;

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
     * 获取平台商户id
     *
     * @return plat_partner_id - 平台商户id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户id
     *
     * @param platPartnerId 平台商户id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取签约商户id
     *
     * @return partner_id - 签约商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户id
     *
     * @param partnerId 签约商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取账号编号
     *
     * @return account_no - 账号编号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置账号编号
     *
     * @param accountNo 账号编号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取绑定账号编号
     *
     * @return band_account_no - 绑定账号编号
     */
    public String getBandAccountNo() {
        return bandAccountNo;
    }

    /**
     * 设置绑定账号编号
     *
     * @param bandAccountNo 绑定账号编号
     */
    public void setBandAccountNo(String bandAccountNo) {
        this.bandAccountNo = bandAccountNo == null ? null : bandAccountNo.trim();
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
     * 获取账户余额,单位分
     *
     * @return balance - 账户余额,单位分
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 设置账户余额,单位分
     *
     * @param balance 账户余额,单位分
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 获取冻结金额，单位分
     *
     * @return freeze_balance - 冻结金额，单位分
     */
    public Long getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 设置冻结金额，单位分
     *
     * @param freezeBalance 冻结金额，单位分
     */
    public void setFreezeBalance(Long freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * 获取信用额度，单位分
     *
     * @return credit_amount - 信用额度，单位分
     */
    public Long getCreditAmount() {
        return creditAmount;
    }

    /**
     * 设置信用额度，单位分
     *
     * @param creditAmount 信用额度，单位分
     */
    public void setCreditAmount(Long creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * 获取总收入金额，单位分
     *
     * @return his_in_amount - 总收入金额，单位分
     */
    public Long getHisInAmount() {
        return hisInAmount;
    }

    /**
     * 设置总收入金额，单位分
     *
     * @param hisInAmount 总收入金额，单位分
     */
    public void setHisInAmount(Long hisInAmount) {
        this.hisInAmount = hisInAmount;
    }

    /**
     * 获取总支出金额，单位分
     *
     * @return his_out_amount - 总支出金额，单位分
     */
    public Long getHisOutAmount() {
        return hisOutAmount;
    }

    /**
     * 设置总支出金额，单位分
     *
     * @param hisOutAmount 总支出金额，单位分
     */
    public void setHisOutAmount(Long hisOutAmount) {
        this.hisOutAmount = hisOutAmount;
    }

    /**
     * 获取账户状态：ACTIVE（激活）/FREEZE(冻结)
     *
     * @return status - 账户状态：ACTIVE（激活）/FREEZE(冻结)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置账户状态：ACTIVE（激活）/FREEZE(冻结)
     *
     * @param status 账户状态：ACTIVE（激活）/FREEZE(冻结)
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取账号类型
     *
     * @return account_type - 账号类型
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置账号类型
     *
     * @param accountType 账号类型
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * 获取支付模型
     *
     * @return pay_model - 支付模型
     */
    public String getPayModel() {
        return payModel;
    }

    /**
     * 设置支付模型
     *
     * @param payModel 支付模型
     */
    public void setPayModel(String payModel) {
        this.payModel = payModel == null ? null : payModel.trim();
    }

    /**
     * 获取标签
     *
     * @return tag - 标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置标签
     *
     * @param tag 标签
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * 获取账号备注
     *
     * @return memo - 账号备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置账号备注
     *
     * @param memo 账号备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", bandAccountNo=").append(bandAccountNo);
        sb.append(", userId=").append(userId);
        sb.append(", balance=").append(balance);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", creditAmount=").append(creditAmount);
        sb.append(", hisInAmount=").append(hisInAmount);
        sb.append(", hisOutAmount=").append(hisOutAmount);
        sb.append(", status=").append(status);
        sb.append(", accountType=").append(accountType);
        sb.append(", payModel=").append(payModel);
        sb.append(", tag=").append(tag);
        sb.append(", memo=").append(memo);
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
        AccountDO other = (AccountDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getBandAccountNo() == null ? other.getBandAccountNo() == null : this.getBandAccountNo().equals(other.getBandAccountNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getFreezeBalance() == null ? other.getFreezeBalance() == null : this.getFreezeBalance().equals(other.getFreezeBalance()))
            && (this.getCreditAmount() == null ? other.getCreditAmount() == null : this.getCreditAmount().equals(other.getCreditAmount()))
            && (this.getHisInAmount() == null ? other.getHisInAmount() == null : this.getHisInAmount().equals(other.getHisInAmount()))
            && (this.getHisOutAmount() == null ? other.getHisOutAmount() == null : this.getHisOutAmount().equals(other.getHisOutAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getPayModel() == null ? other.getPayModel() == null : this.getPayModel().equals(other.getPayModel()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getBandAccountNo() == null) ? 0 : getBandAccountNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getFreezeBalance() == null) ? 0 : getFreezeBalance().hashCode());
        result = prime * result + ((getCreditAmount() == null) ? 0 : getCreditAmount().hashCode());
        result = prime * result + ((getHisInAmount() == null) ? 0 : getHisInAmount().hashCode());
        result = prime * result + ((getHisOutAmount() == null) ? 0 : getHisOutAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getPayModel() == null) ? 0 : getPayModel().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}