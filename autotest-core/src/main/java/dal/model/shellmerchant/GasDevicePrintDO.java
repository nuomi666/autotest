package dal.model.shellmerchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_device_print")
public class GasDevicePrintDO implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 小票ID
     */
    @Column(name = "print_id")
    private String printId;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 油站编号
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 终端类型
     */
    @Column(name = "device_type")
    private String deviceType;

    /**
     * 打印类型
     */
    @Column(name = "print_type")
    private String printType;

    /**
     * 打印小票标题
     */
    @Column(name = "print_title")
    private String printTitle;

    /**
     * 小票打印间隔时间
     */
    @Column(name = "print_sleep")
    private Integer printSleep;

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
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取小票ID
     *
     * @return print_id - 小票ID
     */
    public String getPrintId() {
        return printId;
    }

    /**
     * 设置小票ID
     *
     * @param printId 小票ID
     */
    public void setPrintId(String printId) {
        this.printId = printId == null ? null : printId.trim();
    }

    /**
     * 获取商户号
     *
     * @return partner_id - 商户号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户号
     *
     * @param partnerId 商户号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取油站编号
     *
     * @return station_id - 油站编号
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站编号
     *
     * @param stationId 油站编号
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取终端类型
     *
     * @return device_type - 终端类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置终端类型
     *
     * @param deviceType 终端类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    /**
     * 获取打印类型
     *
     * @return print_type - 打印类型
     */
    public String getPrintType() {
        return printType;
    }

    /**
     * 设置打印类型
     *
     * @param printType 打印类型
     */
    public void setPrintType(String printType) {
        this.printType = printType == null ? null : printType.trim();
    }

    /**
     * 获取打印小票标题
     *
     * @return print_title - 打印小票标题
     */
    public String getPrintTitle() {
        return printTitle;
    }

    /**
     * 设置打印小票标题
     *
     * @param printTitle 打印小票标题
     */
    public void setPrintTitle(String printTitle) {
        this.printTitle = printTitle == null ? null : printTitle.trim();
    }

    /**
     * 获取小票打印间隔时间
     *
     * @return print_sleep - 小票打印间隔时间
     */
    public Integer getPrintSleep() {
        return printSleep;
    }

    /**
     * 设置小票打印间隔时间
     *
     * @param printSleep 小票打印间隔时间
     */
    public void setPrintSleep(Integer printSleep) {
        this.printSleep = printSleep;
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
        sb.append(", printId=").append(printId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", stationId=").append(stationId);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", printType=").append(printType);
        sb.append(", printTitle=").append(printTitle);
        sb.append(", printSleep=").append(printSleep);
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
        GasDevicePrintDO other = (GasDevicePrintDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrintId() == null ? other.getPrintId() == null : this.getPrintId().equals(other.getPrintId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getDeviceType() == null ? other.getDeviceType() == null : this.getDeviceType().equals(other.getDeviceType()))
            && (this.getPrintType() == null ? other.getPrintType() == null : this.getPrintType().equals(other.getPrintType()))
            && (this.getPrintTitle() == null ? other.getPrintTitle() == null : this.getPrintTitle().equals(other.getPrintTitle()))
            && (this.getPrintSleep() == null ? other.getPrintSleep() == null : this.getPrintSleep().equals(other.getPrintSleep()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrintId() == null) ? 0 : getPrintId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getDeviceType() == null) ? 0 : getDeviceType().hashCode());
        result = prime * result + ((getPrintType() == null) ? 0 : getPrintType().hashCode());
        result = prime * result + ((getPrintTitle() == null) ? 0 : getPrintTitle().hashCode());
        result = prime * result + ((getPrintSleep() == null) ? 0 : getPrintSleep().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}