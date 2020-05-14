package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_card_rule")
public class GasMerchantCardRuleDO implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 开始卡号
     */
    @Column(name = "range_start")
    private Integer rangeStart;

    /**
     * 结束卡号
     */
    @Column(name = "range_end")
    private Integer rangeEnd;

    /**
     * 剔除特殊卡号
     */
    @Column(name = "exclude_card_no")
    private String excludeCardNo;

    /**
     * 剔除特殊数字
     */
    @Column(name = "exclude_number")
    private String excludeNumber;

    /**
     * 有效卡号数量
     */
    @Column(name = "valid_count")
    private Integer validCount;

    /**
     * 操作员账号
     */
    @Column(name = "operator_account")
    private String operatorAccount;

    /**
     * 备注
     */
    private String memo;

    /**
     * 新增时间
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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return partner_id - 商家ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商家ID
     *
     * @param partnerId 商家ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * @return plat_partner_id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * @param platPartnerId
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取开始卡号
     *
     * @return range_start - 开始卡号
     */
    public Integer getRangeStart() {
        return rangeStart;
    }

    /**
     * 设置开始卡号
     *
     * @param rangeStart 开始卡号
     */
    public void setRangeStart(Integer rangeStart) {
        this.rangeStart = rangeStart;
    }

    /**
     * 获取结束卡号
     *
     * @return range_end - 结束卡号
     */
    public Integer getRangeEnd() {
        return rangeEnd;
    }

    /**
     * 设置结束卡号
     *
     * @param rangeEnd 结束卡号
     */
    public void setRangeEnd(Integer rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    /**
     * 获取剔除特殊卡号
     *
     * @return exclude_card_no - 剔除特殊卡号
     */
    public String getExcludeCardNo() {
        return excludeCardNo;
    }

    /**
     * 设置剔除特殊卡号
     *
     * @param excludeCardNo 剔除特殊卡号
     */
    public void setExcludeCardNo(String excludeCardNo) {
        this.excludeCardNo = excludeCardNo == null ? null : excludeCardNo.trim();
    }

    /**
     * 获取剔除特殊数字
     *
     * @return exclude_number - 剔除特殊数字
     */
    public String getExcludeNumber() {
        return excludeNumber;
    }

    /**
     * 设置剔除特殊数字
     *
     * @param excludeNumber 剔除特殊数字
     */
    public void setExcludeNumber(String excludeNumber) {
        this.excludeNumber = excludeNumber == null ? null : excludeNumber.trim();
    }

    /**
     * 获取有效卡号数量
     *
     * @return valid_count - 有效卡号数量
     */
    public Integer getValidCount() {
        return validCount;
    }

    /**
     * 设置有效卡号数量
     *
     * @param validCount 有效卡号数量
     */
    public void setValidCount(Integer validCount) {
        this.validCount = validCount;
    }

    /**
     * 获取操作员账号
     *
     * @return operator_account - 操作员账号
     */
    public String getOperatorAccount() {
        return operatorAccount;
    }

    /**
     * 设置操作员账号
     *
     * @param operatorAccount 操作员账号
     */
    public void setOperatorAccount(String operatorAccount) {
        this.operatorAccount = operatorAccount == null ? null : operatorAccount.trim();
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
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", rangeStart=").append(rangeStart);
        sb.append(", rangeEnd=").append(rangeEnd);
        sb.append(", excludeCardNo=").append(excludeCardNo);
        sb.append(", excludeNumber=").append(excludeNumber);
        sb.append(", validCount=").append(validCount);
        sb.append(", operatorAccount=").append(operatorAccount);
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
        GasMerchantCardRuleDO other = (GasMerchantCardRuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getRangeStart() == null ? other.getRangeStart() == null : this.getRangeStart().equals(other.getRangeStart()))
            && (this.getRangeEnd() == null ? other.getRangeEnd() == null : this.getRangeEnd().equals(other.getRangeEnd()))
            && (this.getExcludeCardNo() == null ? other.getExcludeCardNo() == null : this.getExcludeCardNo().equals(other.getExcludeCardNo()))
            && (this.getExcludeNumber() == null ? other.getExcludeNumber() == null : this.getExcludeNumber().equals(other.getExcludeNumber()))
            && (this.getValidCount() == null ? other.getValidCount() == null : this.getValidCount().equals(other.getValidCount()))
            && (this.getOperatorAccount() == null ? other.getOperatorAccount() == null : this.getOperatorAccount().equals(other.getOperatorAccount()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getRangeStart() == null) ? 0 : getRangeStart().hashCode());
        result = prime * result + ((getRangeEnd() == null) ? 0 : getRangeEnd().hashCode());
        result = prime * result + ((getExcludeCardNo() == null) ? 0 : getExcludeCardNo().hashCode());
        result = prime * result + ((getExcludeNumber() == null) ? 0 : getExcludeNumber().hashCode());
        result = prime * result + ((getValidCount() == null) ? 0 : getValidCount().hashCode());
        result = prime * result + ((getOperatorAccount() == null) ? 0 : getOperatorAccount().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}