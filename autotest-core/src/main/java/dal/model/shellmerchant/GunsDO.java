package dal.model.shellmerchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "guns")
public class GunsDO implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String id2;

    private String code;

    private String code2;

    private String name;

    private String gun;

    private String gun2;

    private String oil;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return id2
     */
    public String getId2() {
        return id2;
    }

    /**
     * @param id2
     */
    public void setId2(String id2) {
        this.id2 = id2 == null ? null : id2.trim();
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return code2
     */
    public String getCode2() {
        return code2;
    }

    /**
     * @param code2
     */
    public void setCode2(String code2) {
        this.code2 = code2 == null ? null : code2.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return gun
     */
    public String getGun() {
        return gun;
    }

    /**
     * @param gun
     */
    public void setGun(String gun) {
        this.gun = gun == null ? null : gun.trim();
    }

    /**
     * @return gun2
     */
    public String getGun2() {
        return gun2;
    }

    /**
     * @param gun2
     */
    public void setGun2(String gun2) {
        this.gun2 = gun2 == null ? null : gun2.trim();
    }

    /**
     * @return oil
     */
    public String getOil() {
        return oil;
    }

    /**
     * @param oil
     */
    public void setOil(String oil) {
        this.oil = oil == null ? null : oil.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", id2=").append(id2);
        sb.append(", code=").append(code);
        sb.append(", code2=").append(code2);
        sb.append(", name=").append(name);
        sb.append(", gun=").append(gun);
        sb.append(", gun2=").append(gun2);
        sb.append(", oil=").append(oil);
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
        GunsDO other = (GunsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getId2() == null ? other.getId2() == null : this.getId2().equals(other.getId2()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCode2() == null ? other.getCode2() == null : this.getCode2().equals(other.getCode2()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGun() == null ? other.getGun() == null : this.getGun().equals(other.getGun()))
            && (this.getGun2() == null ? other.getGun2() == null : this.getGun2().equals(other.getGun2()))
            && (this.getOil() == null ? other.getOil() == null : this.getOil().equals(other.getOil()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getId2() == null) ? 0 : getId2().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getCode2() == null) ? 0 : getCode2().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGun() == null) ? 0 : getGun().hashCode());
        result = prime * result + ((getGun2() == null) ? 0 : getGun2().hashCode());
        result = prime * result + ((getOil() == null) ? 0 : getOil().hashCode());
        return result;
    }
}