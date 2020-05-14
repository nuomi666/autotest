package dal.model.shellmerchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "gas_city")
public class GasCityDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 城市名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 城市名称首字母缩写
     */
    @Column(name = "city_char")
    private String cityChar;

    /**
     * 省份ID
     */
    @Column(name = "province_id")
    private Long provinceId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取城市名称
     *
     * @return city_name - 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市名称
     *
     * @param cityName 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 获取城市名称首字母缩写
     *
     * @return city_char - 城市名称首字母缩写
     */
    public String getCityChar() {
        return cityChar;
    }

    /**
     * 设置城市名称首字母缩写
     *
     * @param cityChar 城市名称首字母缩写
     */
    public void setCityChar(String cityChar) {
        this.cityChar = cityChar == null ? null : cityChar.trim();
    }

    /**
     * 获取省份ID
     *
     * @return province_id - 省份ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份ID
     *
     * @param provinceId 省份ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", cityName=").append(cityName);
        sb.append(", cityChar=").append(cityChar);
        sb.append(", provinceId=").append(provinceId);
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
        GasCityDO other = (GasCityDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getCityChar() == null ? other.getCityChar() == null : this.getCityChar().equals(other.getCityChar()))
            && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getCityChar() == null) ? 0 : getCityChar().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        return result;
    }
}