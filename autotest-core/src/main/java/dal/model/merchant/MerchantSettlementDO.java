package dal.model.merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "merchant_settlement")
public class MerchantSettlementDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签约商户的id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户简称
     */
    @Column(name = "partner_abbr_name")
    private String partnerAbbrName;

    /**
     * 结算账户类型（对公BUSINESS_ACCOUNT 对私PERSONAL_ACCOUNT）
     */
    @Column(name = "settlement_account_type")
    private String settlementAccountType;

    /**
     * 结算账户开户名
     */
    @Column(name = "settlement_account_name")
    private String settlementAccountName;

    /**
     * 结算账户
     */
    @Column(name = "settlement_account")
    private String settlementAccount;

    /**
     * 结算账户开户银行
     */
    @Column(name = "settlement_account_bank")
    private String settlementAccountBank;

    /**
     * 结算账户开户银行简称
     */
    @Column(name = "settlement_account_bank_code")
    private String settlementAccountBankCode;

    /**
     * 结算账户开户银行支行
     */
    @Column(name = "settlement_account_sub_bank")
    private String settlementAccountSubBank;

    /**
     * 结算账户开户银行支行联行号
     */
    @Column(name = "settlement_account_sub_bank_no")
    private String settlementAccountSubBankNo;

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
     * 获取签约商户的id
     *
     * @return partner_id - 签约商户的id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户的id
     *
     * @param partnerId 签约商户的id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取商户简称
     *
     * @return partner_abbr_name - 商户简称
     */
    public String getPartnerAbbrName() {
        return partnerAbbrName;
    }

    /**
     * 设置商户简称
     *
     * @param partnerAbbrName 商户简称
     */
    public void setPartnerAbbrName(String partnerAbbrName) {
        this.partnerAbbrName = partnerAbbrName == null ? null : partnerAbbrName.trim();
    }

    /**
     * 获取结算账户类型（对公BUSINESS_ACCOUNT 对私PERSONAL_ACCOUNT）
     *
     * @return settlement_account_type - 结算账户类型（对公BUSINESS_ACCOUNT 对私PERSONAL_ACCOUNT）
     */
    public String getSettlementAccountType() {
        return settlementAccountType;
    }

    /**
     * 设置结算账户类型（对公BUSINESS_ACCOUNT 对私PERSONAL_ACCOUNT）
     *
     * @param settlementAccountType 结算账户类型（对公BUSINESS_ACCOUNT 对私PERSONAL_ACCOUNT）
     */
    public void setSettlementAccountType(String settlementAccountType) {
        this.settlementAccountType = settlementAccountType == null ? null : settlementAccountType.trim();
    }

    /**
     * 获取结算账户开户名
     *
     * @return settlement_account_name - 结算账户开户名
     */
    public String getSettlementAccountName() {
        return settlementAccountName;
    }

    /**
     * 设置结算账户开户名
     *
     * @param settlementAccountName 结算账户开户名
     */
    public void setSettlementAccountName(String settlementAccountName) {
        this.settlementAccountName = settlementAccountName == null ? null : settlementAccountName.trim();
    }

    /**
     * 获取结算账户
     *
     * @return settlement_account - 结算账户
     */
    public String getSettlementAccount() {
        return settlementAccount;
    }

    /**
     * 设置结算账户
     *
     * @param settlementAccount 结算账户
     */
    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount == null ? null : settlementAccount.trim();
    }

    /**
     * 获取结算账户开户银行
     *
     * @return settlement_account_bank - 结算账户开户银行
     */
    public String getSettlementAccountBank() {
        return settlementAccountBank;
    }

    /**
     * 设置结算账户开户银行
     *
     * @param settlementAccountBank 结算账户开户银行
     */
    public void setSettlementAccountBank(String settlementAccountBank) {
        this.settlementAccountBank = settlementAccountBank == null ? null : settlementAccountBank.trim();
    }

    /**
     * 获取结算账户开户银行简称
     *
     * @return settlement_account_bank_code - 结算账户开户银行简称
     */
    public String getSettlementAccountBankCode() {
        return settlementAccountBankCode;
    }

    /**
     * 设置结算账户开户银行简称
     *
     * @param settlementAccountBankCode 结算账户开户银行简称
     */
    public void setSettlementAccountBankCode(String settlementAccountBankCode) {
        this.settlementAccountBankCode = settlementAccountBankCode == null ? null : settlementAccountBankCode.trim();
    }

    /**
     * 获取结算账户开户银行支行
     *
     * @return settlement_account_sub_bank - 结算账户开户银行支行
     */
    public String getSettlementAccountSubBank() {
        return settlementAccountSubBank;
    }

    /**
     * 设置结算账户开户银行支行
     *
     * @param settlementAccountSubBank 结算账户开户银行支行
     */
    public void setSettlementAccountSubBank(String settlementAccountSubBank) {
        this.settlementAccountSubBank = settlementAccountSubBank == null ? null : settlementAccountSubBank.trim();
    }

    /**
     * 获取结算账户开户银行支行联行号
     *
     * @return settlement_account_sub_bank_no - 结算账户开户银行支行联行号
     */
    public String getSettlementAccountSubBankNo() {
        return settlementAccountSubBankNo;
    }

    /**
     * 设置结算账户开户银行支行联行号
     *
     * @param settlementAccountSubBankNo 结算账户开户银行支行联行号
     */
    public void setSettlementAccountSubBankNo(String settlementAccountSubBankNo) {
        this.settlementAccountSubBankNo = settlementAccountSubBankNo == null ? null : settlementAccountSubBankNo.trim();
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerAbbrName=").append(partnerAbbrName);
        sb.append(", settlementAccountType=").append(settlementAccountType);
        sb.append(", settlementAccountName=").append(settlementAccountName);
        sb.append(", settlementAccount=").append(settlementAccount);
        sb.append(", settlementAccountBank=").append(settlementAccountBank);
        sb.append(", settlementAccountBankCode=").append(settlementAccountBankCode);
        sb.append(", settlementAccountSubBank=").append(settlementAccountSubBank);
        sb.append(", settlementAccountSubBankNo=").append(settlementAccountSubBankNo);
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
        MerchantSettlementDO other = (MerchantSettlementDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerAbbrName() == null ? other.getPartnerAbbrName() == null : this.getPartnerAbbrName().equals(other.getPartnerAbbrName()))
            && (this.getSettlementAccountType() == null ? other.getSettlementAccountType() == null : this.getSettlementAccountType().equals(other.getSettlementAccountType()))
            && (this.getSettlementAccountName() == null ? other.getSettlementAccountName() == null : this.getSettlementAccountName().equals(other.getSettlementAccountName()))
            && (this.getSettlementAccount() == null ? other.getSettlementAccount() == null : this.getSettlementAccount().equals(other.getSettlementAccount()))
            && (this.getSettlementAccountBank() == null ? other.getSettlementAccountBank() == null : this.getSettlementAccountBank().equals(other.getSettlementAccountBank()))
            && (this.getSettlementAccountBankCode() == null ? other.getSettlementAccountBankCode() == null : this.getSettlementAccountBankCode().equals(other.getSettlementAccountBankCode()))
            && (this.getSettlementAccountSubBank() == null ? other.getSettlementAccountSubBank() == null : this.getSettlementAccountSubBank().equals(other.getSettlementAccountSubBank()))
            && (this.getSettlementAccountSubBankNo() == null ? other.getSettlementAccountSubBankNo() == null : this.getSettlementAccountSubBankNo().equals(other.getSettlementAccountSubBankNo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerAbbrName() == null) ? 0 : getPartnerAbbrName().hashCode());
        result = prime * result + ((getSettlementAccountType() == null) ? 0 : getSettlementAccountType().hashCode());
        result = prime * result + ((getSettlementAccountName() == null) ? 0 : getSettlementAccountName().hashCode());
        result = prime * result + ((getSettlementAccount() == null) ? 0 : getSettlementAccount().hashCode());
        result = prime * result + ((getSettlementAccountBank() == null) ? 0 : getSettlementAccountBank().hashCode());
        result = prime * result + ((getSettlementAccountBankCode() == null) ? 0 : getSettlementAccountBankCode().hashCode());
        result = prime * result + ((getSettlementAccountSubBank() == null) ? 0 : getSettlementAccountSubBank().hashCode());
        result = prime * result + ((getSettlementAccountSubBankNo() == null) ? 0 : getSettlementAccountSubBankNo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}