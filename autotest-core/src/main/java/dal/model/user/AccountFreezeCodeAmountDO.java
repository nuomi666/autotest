package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account_freeze_code_amount")
public class AccountFreezeCodeAmountDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号编号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 冻结码
     */
    @Column(name = "freeze_code")
    private String freezeCode;

    /**
     * 冻结总金额
     */
    @Column(name = "freeze_amount")
    private Long freezeAmount;

    /**
     * 解冻总金额
     */
    @Column(name = "unfreeze_amount")
    private Long unfreezeAmount;

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
     * 获取冻结总金额
     *
     * @return freeze_amount - 冻结总金额
     */
    public Long getFreezeAmount() {
        return freezeAmount;
    }

    /**
     * 设置冻结总金额
     *
     * @param freezeAmount 冻结总金额
     */
    public void setFreezeAmount(Long freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    /**
     * 获取解冻总金额
     *
     * @return unfreeze_amount - 解冻总金额
     */
    public Long getUnfreezeAmount() {
        return unfreezeAmount;
    }

    /**
     * 设置解冻总金额
     *
     * @param unfreezeAmount 解冻总金额
     */
    public void setUnfreezeAmount(Long unfreezeAmount) {
        this.unfreezeAmount = unfreezeAmount;
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
        sb.append(", freezeCode=").append(freezeCode);
        sb.append(", freezeAmount=").append(freezeAmount);
        sb.append(", unfreezeAmount=").append(unfreezeAmount);
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
        AccountFreezeCodeAmountDO other = (AccountFreezeCodeAmountDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getFreezeCode() == null ? other.getFreezeCode() == null : this.getFreezeCode().equals(other.getFreezeCode()))
            && (this.getFreezeAmount() == null ? other.getFreezeAmount() == null : this.getFreezeAmount().equals(other.getFreezeAmount()))
            && (this.getUnfreezeAmount() == null ? other.getUnfreezeAmount() == null : this.getUnfreezeAmount().equals(other.getUnfreezeAmount()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getFreezeCode() == null) ? 0 : getFreezeCode().hashCode());
        result = prime * result + ((getFreezeAmount() == null) ? 0 : getFreezeAmount().hashCode());
        result = prime * result + ((getUnfreezeAmount() == null) ? 0 : getUnfreezeAmount().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}