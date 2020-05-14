package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "base_station")
public class BaseStationDO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 油站名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 新增时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 跑量时间
     */
    @Column(name = "trade_time")
    private Date tradeTime;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商家名称
     */
    @Column(name = "partner_name")
    private String partnerName;

    /**
     * 油站名称
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 油站code
     */
    @Column(name = "station_code")
    private String stationCode;

    /**
     * 设备编号
     */
    @Column(name = "terminal_code")
    private String terminalCode;

    /**
     * 油站省市
     */
    @Column(name = "station_p")
    private Long stationP;

    /**
     * 油站城市
     */
    @Column(name = "station_c")
    private Long stationC;

    /**
     * 油站区域
     */
    @Column(name = "station_d")
    private Long stationD;

    /**
     * 油站引入类型
     */
    private String type;

    /**
     * 油站地址
     */
    @Column(name = "station_addres")
    private String stationAddres;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取油站名称
     *
     * @return station_name - 油站名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置油站名称
     *
     * @param stationName 油站名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * 获取新增时间
     *
     * @return add_time - 新增时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置新增时间
     *
     * @param addTime 新增时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取跑量时间
     *
     * @return trade_time - 跑量时间
     */
    public Date getTradeTime() {
        return tradeTime;
    }

    /**
     * 设置跑量时间
     *
     * @param tradeTime 跑量时间
     */
    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取商家名称
     *
     * @return partner_name - 商家名称
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置商家名称
     *
     * @param partnerName 商家名称
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 获取油站名称
     *
     * @return station_id - 油站名称
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站名称
     *
     * @param stationId 油站名称
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取油站code
     *
     * @return station_code - 油站code
     */
    public String getStationCode() {
        return stationCode;
    }

    /**
     * 设置油站code
     *
     * @param stationCode 油站code
     */
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    /**
     * 获取设备编号
     *
     * @return terminal_code - 设备编号
     */
    public String getTerminalCode() {
        return terminalCode;
    }

    /**
     * 设置设备编号
     *
     * @param terminalCode 设备编号
     */
    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode == null ? null : terminalCode.trim();
    }

    /**
     * 获取油站省市
     *
     * @return station_p - 油站省市
     */
    public Long getStationP() {
        return stationP;
    }

    /**
     * 设置油站省市
     *
     * @param stationP 油站省市
     */
    public void setStationP(Long stationP) {
        this.stationP = stationP;
    }

    /**
     * 获取油站城市
     *
     * @return station_c - 油站城市
     */
    public Long getStationC() {
        return stationC;
    }

    /**
     * 设置油站城市
     *
     * @param stationC 油站城市
     */
    public void setStationC(Long stationC) {
        this.stationC = stationC;
    }

    /**
     * 获取油站区域
     *
     * @return station_d - 油站区域
     */
    public Long getStationD() {
        return stationD;
    }

    /**
     * 设置油站区域
     *
     * @param stationD 油站区域
     */
    public void setStationD(Long stationD) {
        this.stationD = stationD;
    }

    /**
     * 获取油站引入类型
     *
     * @return type - 油站引入类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置油站引入类型
     *
     * @param type 油站引入类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取油站地址
     *
     * @return station_addres - 油站地址
     */
    public String getStationAddres() {
        return stationAddres;
    }

    /**
     * 设置油站地址
     *
     * @param stationAddres 油站地址
     */
    public void setStationAddres(String stationAddres) {
        this.stationAddres = stationAddres == null ? null : stationAddres.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", stationName=").append(stationName);
        sb.append(", addTime=").append(addTime);
        sb.append(", tradeTime=").append(tradeTime);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", stationId=").append(stationId);
        sb.append(", stationCode=").append(stationCode);
        sb.append(", terminalCode=").append(terminalCode);
        sb.append(", stationP=").append(stationP);
        sb.append(", stationC=").append(stationC);
        sb.append(", stationD=").append(stationD);
        sb.append(", type=").append(type);
        sb.append(", stationAddres=").append(stationAddres);
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
        BaseStationDO other = (BaseStationDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getTradeTime() == null ? other.getTradeTime() == null : this.getTradeTime().equals(other.getTradeTime()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationCode() == null ? other.getStationCode() == null : this.getStationCode().equals(other.getStationCode()))
            && (this.getTerminalCode() == null ? other.getTerminalCode() == null : this.getTerminalCode().equals(other.getTerminalCode()))
            && (this.getStationP() == null ? other.getStationP() == null : this.getStationP().equals(other.getStationP()))
            && (this.getStationC() == null ? other.getStationC() == null : this.getStationC().equals(other.getStationC()))
            && (this.getStationD() == null ? other.getStationD() == null : this.getStationD().equals(other.getStationD()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStationAddres() == null ? other.getStationAddres() == null : this.getStationAddres().equals(other.getStationAddres()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getTradeTime() == null) ? 0 : getTradeTime().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationCode() == null) ? 0 : getStationCode().hashCode());
        result = prime * result + ((getTerminalCode() == null) ? 0 : getTerminalCode().hashCode());
        result = prime * result + ((getStationP() == null) ? 0 : getStationP().hashCode());
        result = prime * result + ((getStationC() == null) ? 0 : getStationC().hashCode());
        result = prime * result + ((getStationD() == null) ? 0 : getStationD().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStationAddres() == null) ? 0 : getStationAddres().hashCode());
        return result;
    }
}