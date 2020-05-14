package dal.model.gas_merchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "station_channal")
public class StationChannalDO implements Serializable {
    private String 渠道名称;

    private String 交易总金额;

    private String 收益;

    private String 油站数量;

    private static final long serialVersionUID = 1L;

    /**
     * @return 渠道名称
     */
    public String get渠道名称() {
        return 渠道名称;
    }

    /**
     * @param 渠道名称
     */
    public void set渠道名称(String 渠道名称) {
        this.渠道名称 = 渠道名称 == null ? null : 渠道名称.trim();
    }

    /**
     * @return 交易总金额
     */
    public String get交易总金额() {
        return 交易总金额;
    }

    /**
     * @param 交易总金额
     */
    public void set交易总金额(String 交易总金额) {
        this.交易总金额 = 交易总金额 == null ? null : 交易总金额.trim();
    }

    /**
     * @return 收益
     */
    public String get收益() {
        return 收益;
    }

    /**
     * @param 收益
     */
    public void set收益(String 收益) {
        this.收益 = 收益 == null ? null : 收益.trim();
    }

    /**
     * @return 油站数量
     */
    public String get油站数量() {
        return 油站数量;
    }

    /**
     * @param 油站数量
     */
    public void set油站数量(String 油站数量) {
        this.油站数量 = 油站数量 == null ? null : 油站数量.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", 渠道名称=").append(渠道名称);
        sb.append(", 交易总金额=").append(交易总金额);
        sb.append(", 收益=").append(收益);
        sb.append(", 油站数量=").append(油站数量);
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
        StationChannalDO other = (StationChannalDO) that;
        return (this.get渠道名称() == null ? other.get渠道名称() == null : this.get渠道名称().equals(other.get渠道名称()))
            && (this.get交易总金额() == null ? other.get交易总金额() == null : this.get交易总金额().equals(other.get交易总金额()))
            && (this.get收益() == null ? other.get收益() == null : this.get收益().equals(other.get收益()))
            && (this.get油站数量() == null ? other.get油站数量() == null : this.get油站数量().equals(other.get油站数量()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((get渠道名称() == null) ? 0 : get渠道名称().hashCode());
        result = prime * result + ((get交易总金额() == null) ? 0 : get交易总金额().hashCode());
        result = prime * result + ((get收益() == null) ? 0 : get收益().hashCode());
        result = prime * result + ((get油站数量() == null) ? 0 : get油站数量().hashCode());
        return result;
    }
}