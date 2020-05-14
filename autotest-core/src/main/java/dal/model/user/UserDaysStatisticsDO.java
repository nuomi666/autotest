package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_days_statistics")
public class UserDaysStatisticsDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 日期
     */
    private Date days;

    /**
     * 签约商id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 签约商会员余额汇总
     */
    @Column(name = "balance_amount")
    private Long balanceAmount;

    /**
     * 签约商会员冻结余额汇总
     */
    @Column(name = "freeze_amount")
    private Long freezeAmount;

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
     * 获取日期
     *
     * @return days - 日期
     */
    public Date getDays() {
        return days;
    }

    /**
     * 设置日期
     *
     * @param days 日期
     */
    public void setDays(Date days) {
        this.days = days;
    }

    /**
     * 获取签约商id
     *
     * @return partner_id - 签约商id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商id
     *
     * @param partnerId 签约商id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商id
     *
     * @return plat_partner_id - 平台商id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商id
     *
     * @param platPartnerId 平台商id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取签约商会员余额汇总
     *
     * @return balance_amount - 签约商会员余额汇总
     */
    public Long getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * 设置签约商会员余额汇总
     *
     * @param balanceAmount 签约商会员余额汇总
     */
    public void setBalanceAmount(Long balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    /**
     * 获取签约商会员冻结余额汇总
     *
     * @return freeze_amount - 签约商会员冻结余额汇总
     */
    public Long getFreezeAmount() {
        return freezeAmount;
    }

    /**
     * 设置签约商会员冻结余额汇总
     *
     * @param freezeAmount 签约商会员冻结余额汇总
     */
    public void setFreezeAmount(Long freezeAmount) {
        this.freezeAmount = freezeAmount;
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
        sb.append(", days=").append(days);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", balanceAmount=").append(balanceAmount);
        sb.append(", freezeAmount=").append(freezeAmount);
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
        UserDaysStatisticsDO other = (UserDaysStatisticsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getBalanceAmount() == null ? other.getBalanceAmount() == null : this.getBalanceAmount().equals(other.getBalanceAmount()))
            && (this.getFreezeAmount() == null ? other.getFreezeAmount() == null : this.getFreezeAmount().equals(other.getFreezeAmount()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getBalanceAmount() == null) ? 0 : getBalanceAmount().hashCode());
        result = prime * result + ((getFreezeAmount() == null) ? 0 : getFreezeAmount().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}