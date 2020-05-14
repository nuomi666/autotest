package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_station_voice_broadcast")
public class GasStationVoiceBroadcastDO implements Serializable {
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
     * 播报类型
     */
    @Column(name = "broadcast_type")
    private String broadcastType;

    /**
     * 播报字段
     */
    @Column(name = "field_codes")
    private String fieldCodes;

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
     * 获取播报类型
     *
     * @return broadcast_type - 播报类型
     */
    public String getBroadcastType() {
        return broadcastType;
    }

    /**
     * 设置播报类型
     *
     * @param broadcastType 播报类型
     */
    public void setBroadcastType(String broadcastType) {
        this.broadcastType = broadcastType == null ? null : broadcastType.trim();
    }

    /**
     * 获取播报字段
     *
     * @return field_codes - 播报字段
     */
    public String getFieldCodes() {
        return fieldCodes;
    }

    /**
     * 设置播报字段
     *
     * @param fieldCodes 播报字段
     */
    public void setFieldCodes(String fieldCodes) {
        this.fieldCodes = fieldCodes == null ? null : fieldCodes.trim();
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
        sb.append(", broadcastType=").append(broadcastType);
        sb.append(", fieldCodes=").append(fieldCodes);
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
        GasStationVoiceBroadcastDO other = (GasStationVoiceBroadcastDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getBroadcastType() == null ? other.getBroadcastType() == null : this.getBroadcastType().equals(other.getBroadcastType()))
            && (this.getFieldCodes() == null ? other.getFieldCodes() == null : this.getFieldCodes().equals(other.getFieldCodes()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getBroadcastType() == null) ? 0 : getBroadcastType().hashCode());
        result = prime * result + ((getFieldCodes() == null) ? 0 : getFieldCodes().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}