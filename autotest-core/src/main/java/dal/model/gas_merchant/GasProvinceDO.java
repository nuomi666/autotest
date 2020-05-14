package dal.model.gas_merchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "gas_province")
public class GasProvinceDO implements Serializable {
    /**
     * 省份ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 省份名称
     */
    @Column(name = "province_name")
    private String provinceName;

    /**
     * 省份简称
     */
    @Column(name = "province_short")
    private String provinceShort;

    /**
     * 省份名称首字母缩写
     */
    @Column(name = "province_char")
    private String provinceChar;

    private static final long serialVersionUID = 1L;

    /**
     * 获取省份ID
     *
     * @return id - 省份ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置省份ID
     *
     * @param id 省份ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取省份名称
     *
     * @return province_name - 省份名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置省份名称
     *
     * @param provinceName 省份名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * 获取省份简称
     *
     * @return province_short - 省份简称
     */
    public String getProvinceShort() {
        return provinceShort;
    }

    /**
     * 设置省份简称
     *
     * @param provinceShort 省份简称
     */
    public void setProvinceShort(String provinceShort) {
        this.provinceShort = provinceShort == null ? null : provinceShort.trim();
    }

    /**
     * 获取省份名称首字母缩写
     *
     * @return province_char - 省份名称首字母缩写
     */
    public String getProvinceChar() {
        return provinceChar;
    }

    /**
     * 设置省份名称首字母缩写
     *
     * @param provinceChar 省份名称首字母缩写
     */
    public void setProvinceChar(String provinceChar) {
        this.provinceChar = provinceChar == null ? null : provinceChar.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", provinceShort=").append(provinceShort);
        sb.append(", provinceChar=").append(provinceChar);
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
        GasProvinceDO other = (GasProvinceDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProvinceName() == null ? other.getProvinceName() == null : this.getProvinceName().equals(other.getProvinceName()))
            && (this.getProvinceShort() == null ? other.getProvinceShort() == null : this.getProvinceShort().equals(other.getProvinceShort()))
            && (this.getProvinceChar() == null ? other.getProvinceChar() == null : this.getProvinceChar().equals(other.getProvinceChar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());
        result = prime * result + ((getProvinceShort() == null) ? 0 : getProvinceShort().hashCode());
        result = prime * result + ((getProvinceChar() == null) ? 0 : getProvinceChar().hashCode());
        return result;
    }
}