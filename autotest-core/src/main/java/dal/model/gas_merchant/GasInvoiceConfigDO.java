package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_invoice_config")
public class GasInvoiceConfigDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家编号
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 过期时间,单位:天
     */
    @Column(name = "expire_time")
    private Long expireTime;

    /**
     * 最低开票金额
     */
    @Column(name = "min_invoice_amount")
    private Long minInvoiceAmount;

    /**
     * 小票显示时的说明
     */
    private String remark;

    /**
     * 可开票的油号
     */
    @Column(name = "invoice_oils")
    private String invoiceOils;

    /**
     * 可开票的支付方式
     */
    @Column(name = "invoice_payway")
    private String invoicePayway;

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
     * 获取商家编号
     *
     * @return plat_partner_id - 商家编号
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置商家编号
     *
     * @param platPartnerId 商家编号
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取过期时间,单位:天
     *
     * @return expire_time - 过期时间,单位:天
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * 设置过期时间,单位:天
     *
     * @param expireTime 过期时间,单位:天
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取最低开票金额
     *
     * @return min_invoice_amount - 最低开票金额
     */
    public Long getMinInvoiceAmount() {
        return minInvoiceAmount;
    }

    /**
     * 设置最低开票金额
     *
     * @param minInvoiceAmount 最低开票金额
     */
    public void setMinInvoiceAmount(Long minInvoiceAmount) {
        this.minInvoiceAmount = minInvoiceAmount;
    }

    /**
     * 获取小票显示时的说明
     *
     * @return remark - 小票显示时的说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置小票显示时的说明
     *
     * @param remark 小票显示时的说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取可开票的油号
     *
     * @return invoice_oils - 可开票的油号
     */
    public String getInvoiceOils() {
        return invoiceOils;
    }

    /**
     * 设置可开票的油号
     *
     * @param invoiceOils 可开票的油号
     */
    public void setInvoiceOils(String invoiceOils) {
        this.invoiceOils = invoiceOils == null ? null : invoiceOils.trim();
    }

    /**
     * 获取可开票的支付方式
     *
     * @return invoice_payway - 可开票的支付方式
     */
    public String getInvoicePayway() {
        return invoicePayway;
    }

    /**
     * 设置可开票的支付方式
     *
     * @param invoicePayway 可开票的支付方式
     */
    public void setInvoicePayway(String invoicePayway) {
        this.invoicePayway = invoicePayway == null ? null : invoicePayway.trim();
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", minInvoiceAmount=").append(minInvoiceAmount);
        sb.append(", remark=").append(remark);
        sb.append(", invoiceOils=").append(invoiceOils);
        sb.append(", invoicePayway=").append(invoicePayway);
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
        GasInvoiceConfigDO other = (GasInvoiceConfigDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()))
            && (this.getMinInvoiceAmount() == null ? other.getMinInvoiceAmount() == null : this.getMinInvoiceAmount().equals(other.getMinInvoiceAmount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getInvoiceOils() == null ? other.getInvoiceOils() == null : this.getInvoiceOils().equals(other.getInvoiceOils()))
            && (this.getInvoicePayway() == null ? other.getInvoicePayway() == null : this.getInvoicePayway().equals(other.getInvoicePayway()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        result = prime * result + ((getMinInvoiceAmount() == null) ? 0 : getMinInvoiceAmount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getInvoiceOils() == null) ? 0 : getInvoiceOils().hashCode());
        result = prime * result + ((getInvoicePayway() == null) ? 0 : getInvoicePayway().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}