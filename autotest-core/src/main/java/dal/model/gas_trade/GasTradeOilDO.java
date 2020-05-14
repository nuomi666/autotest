package dal.model.gas_trade;

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
     * 油品流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 交易流水号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 油品类型
     */
    @Column(name = "oil_type")
    private String oilType;

    /**
     * 油品编码
     */
    private String code;

    /**
     * 油品名称
     */
    @Column(name = "oil_name")
    private String oilName;

    /**
     * 油品单价
     */
    private Long price;

    /**
     * 油品升数
     */
    private Double liter;

    /**
     * 油枪
     */
    @Column(name = "oil_gun")
    private String oilGun;

    /**
     * 油品金额
     */
    private Long amount;

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
     * 获取油品流水号
     *
     * @return biz_no - 油品流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置油品流水号
     *
     * @param bizNo 油品流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
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
     * @return code - 油品编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置油品编码
     *
     * @param code 油品编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
     * 获取油品单价
     *
     * @return price - 油品单价
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置油品单价
     *
     * @param price 油品单价
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取油品升数
     *
     * @return liter - 油品升数
     */
    public Double getLiter() {
        return liter;
    }

    /**
     * 设置油品升数
     *
     * @param liter 油品升数
     */
    public void setLiter(Double liter) {
        this.liter = liter;
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
     * @return amount - 油品金额
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置油品金额
     *
     * @param amount 油品金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
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
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", oilType=").append(oilType);
        sb.append(", code=").append(code);
        sb.append(", oilName=").append(oilName);
        sb.append(", price=").append(price);
        sb.append(", liter=").append(liter);
        sb.append(", oilGun=").append(oilGun);
        sb.append(", amount=").append(amount);
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
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getOilType() == null ? other.getOilType() == null : this.getOilType().equals(other.getOilType()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getOilName() == null ? other.getOilName() == null : this.getOilName().equals(other.getOilName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getLiter() == null ? other.getLiter() == null : this.getLiter().equals(other.getLiter()))
            && (this.getOilGun() == null ? other.getOilGun() == null : this.getOilGun().equals(other.getOilGun()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getOilType() == null) ? 0 : getOilType().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getOilName() == null) ? 0 : getOilName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getLiter() == null) ? 0 : getLiter().hashCode());
        result = prime * result + ((getOilGun() == null) ? 0 : getOilGun().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}