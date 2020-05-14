package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_ticket_print")
public class GasTicketPrintDO implements Serializable {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 油站ID
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 打印类型
     */
    @Column(name = "print_type")
    private String printType;

    /**
     * 打印张数
     */
    @Column(name = "print_num")
    private Integer printNum;

    /**
     * 间隔时间
     */
    @Column(name = "print_sleep")
    private Integer printSleep;

    /**
     * 备注内容
     */
    private String memo;

    /**
     * 新增时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键Id
     *
     * @return id - 主键Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键Id
     *
     * @param id 主键Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取油站ID
     *
     * @return station_id - 油站ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站ID
     *
     * @param stationId 油站ID
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
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
     * 获取打印张数
     *
     * @return print_num - 打印张数
     */
    public Integer getPrintNum() {
        return printNum;
    }

    /**
     * 设置打印张数
     *
     * @param printNum 打印张数
     */
    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }

    /**
     * 获取间隔时间
     *
     * @return print_sleep - 间隔时间
     */
    public Integer getPrintSleep() {
        return printSleep;
    }

    /**
     * 设置间隔时间
     *
     * @param printSleep 间隔时间
     */
    public void setPrintSleep(Integer printSleep) {
        this.printSleep = printSleep;
    }

    /**
     * 获取备注内容
     *
     * @return memo - 备注内容
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注内容
     *
     * @param memo 备注内容
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
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
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
        sb.append(", stationId=").append(stationId);
        sb.append(", printType=").append(printType);
        sb.append(", printNum=").append(printNum);
        sb.append(", printSleep=").append(printSleep);
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
        GasTicketPrintDO other = (GasTicketPrintDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getPrintType() == null ? other.getPrintType() == null : this.getPrintType().equals(other.getPrintType()))
            && (this.getPrintNum() == null ? other.getPrintNum() == null : this.getPrintNum().equals(other.getPrintNum()))
            && (this.getPrintSleep() == null ? other.getPrintSleep() == null : this.getPrintSleep().equals(other.getPrintSleep()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getPrintType() == null) ? 0 : getPrintType().hashCode());
        result = prime * result + ((getPrintNum() == null) ? 0 : getPrintNum().hashCode());
        result = prime * result + ((getPrintSleep() == null) ? 0 : getPrintSleep().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}