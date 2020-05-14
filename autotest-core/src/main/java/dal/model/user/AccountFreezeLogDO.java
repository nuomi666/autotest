package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account_freeze_log")
public class AccountFreezeLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号编号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 外部订单号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 冻结操作：FREEZE(冻结)/UNFREEZE(解冻)
     */
    @Column(name = "freeze_type")
    private String freezeType;

    /**
     * 冻结码
     */
    @Column(name = "freeze_code")
    private String freezeCode;

    /**
     * 冻结/解冻金额，单位分
     */
    private Long amount;

    /**
     * 冻结/解冻后冻结余额，单位分
     */
    @Column(name = "freeze_balance")
    private Long freezeBalance;

    /**
     * 账号备注
     */
    private String memo;

    /**
     * 全局流水号
     */
    private String gid;

    /**
     * 签约商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商户订单号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 账期时间格式yyyy-MM-dd
     */
    @Column(name = "bill_date")
    private String billDate;

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
     * 获取外部订单号
     *
     * @return req_id - 外部订单号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置外部订单号
     *
     * @param reqId 外部订单号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取冻结操作：FREEZE(冻结)/UNFREEZE(解冻)
     *
     * @return freeze_type - 冻结操作：FREEZE(冻结)/UNFREEZE(解冻)
     */
    public String getFreezeType() {
        return freezeType;
    }

    /**
     * 设置冻结操作：FREEZE(冻结)/UNFREEZE(解冻)
     *
     * @param freezeType 冻结操作：FREEZE(冻结)/UNFREEZE(解冻)
     */
    public void setFreezeType(String freezeType) {
        this.freezeType = freezeType == null ? null : freezeType.trim();
    }

    /**
     * 获取冻结码
     *
     * @return freeze_code - 冻结码
     */
    public String getFreezeCode() {
        return freezeCode;
    }

    /**
     * 设置冻结码
     *
     * @param freezeCode 冻结码
     */
    public void setFreezeCode(String freezeCode) {
        this.freezeCode = freezeCode == null ? null : freezeCode.trim();
    }

    /**
     * 获取冻结/解冻金额，单位分
     *
     * @return amount - 冻结/解冻金额，单位分
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置冻结/解冻金额，单位分
     *
     * @param amount 冻结/解冻金额，单位分
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取冻结/解冻后冻结余额，单位分
     *
     * @return freeze_balance - 冻结/解冻后冻结余额，单位分
     */
    public Long getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 设置冻结/解冻后冻结余额，单位分
     *
     * @param freezeBalance 冻结/解冻后冻结余额，单位分
     */
    public void setFreezeBalance(Long freezeBalance) {
        this.freezeBalance = freezeBalance;
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
     * 获取全局流水号
     *
     * @return gid - 全局流水号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局流水号
     *
     * @param gid 全局流水号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取签约商户订单号
     *
     * @return merchant_order_no - 签约商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置签约商户订单号
     *
     * @param merchantOrderNo 签约商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
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
     * 获取平台商户订单号
     *
     * @return plat_merchant_order_no - 平台商户订单号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台商户订单号
     *
     * @param platMerchantOrderNo 平台商户订单号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
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
     * 获取账期时间格式yyyy-MM-dd
     *
     * @return bill_date - 账期时间格式yyyy-MM-dd
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * 设置账期时间格式yyyy-MM-dd
     *
     * @param billDate 账期时间格式yyyy-MM-dd
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
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
        sb.append(", accountNo=").append(accountNo);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", reqId=").append(reqId);
        sb.append(", freezeType=").append(freezeType);
        sb.append(", freezeCode=").append(freezeCode);
        sb.append(", amount=").append(amount);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", memo=").append(memo);
        sb.append(", gid=").append(gid);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", billDate=").append(billDate);
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
        AccountFreezeLogDO other = (AccountFreezeLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getFreezeType() == null ? other.getFreezeType() == null : this.getFreezeType().equals(other.getFreezeType()))
            && (this.getFreezeCode() == null ? other.getFreezeCode() == null : this.getFreezeCode().equals(other.getFreezeCode()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getFreezeBalance() == null ? other.getFreezeBalance() == null : this.getFreezeBalance().equals(other.getFreezeBalance()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getFreezeType() == null) ? 0 : getFreezeType().hashCode());
        result = prime * result + ((getFreezeCode() == null) ? 0 : getFreezeCode().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getFreezeBalance() == null) ? 0 : getFreezeBalance().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}