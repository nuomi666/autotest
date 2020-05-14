package dal.model.shellmerchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "gas_district")
public class GasDistrictDO implements Serializable {
    /**
     * 县区ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 县区名称
     */
    @Column(name = "district_name")
    private String districtName;

    /**
     * 县区名称首字母缩写
     */
    @Column(name = "district_char")
    private String districtChar;

    /**
     * 城市ID
     */
    @Column(name = "city_id")
    private Long cityId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取县区ID
     *
     * @return id - 县区ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置县区ID
     *
     * @param id 县区ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取县区名称
     *
     * @return district_name - 县区名称
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * 设置县区名称
     *
     * @param districtName 县区名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * 获取县区名称首字母缩写
     *
     * @return district_char - 县区名称首字母缩写
     */
    public String getDistrictChar() {
        return districtChar;
    }

    /**
     * 设置县区名称首字母缩写
     *
     * @param districtChar 县区名称首字母缩写
     */
    public void setDistrictChar(String districtChar) {
        this.districtChar = districtChar == null ? null : districtChar.trim();
    }

    /**
     * 获取城市ID
     *
     * @return city_id - 城市ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市ID
     *
     * @param cityId 城市ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", districtName=").append(districtName);
        sb.append(", districtChar=").append(districtChar);
        sb.append(", cityId=").append(cityId);
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
        GasDistrictDO other = (GasDistrictDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDistrictName() == null ? other.getDistrictName() == null : this.getDistrictName().equals(other.getDistrictName()))
            && (this.getDistrictChar() == null ? other.getDistrictChar() == null : this.getDistrictChar().equals(other.getDistrictChar()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDistrictName() == null) ? 0 : getDistrictName().hashCode());
        result = prime * result + ((getDistrictChar() == null) ? 0 : getDistrictChar().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        return result;
    }
}