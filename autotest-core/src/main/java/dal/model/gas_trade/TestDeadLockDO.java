package dal.model.gas_trade;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "test_dead_lock")
public class TestDeadLockDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String a1;

    private String a2;

    private String a3;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return a1
     */
    public String getA1() {
        return a1;
    }

    /**
     * @param a1
     */
    public void setA1(String a1) {
        this.a1 = a1 == null ? null : a1.trim();
    }

    /**
     * @return a2
     */
    public String getA2() {
        return a2;
    }

    /**
     * @param a2
     */
    public void setA2(String a2) {
        this.a2 = a2 == null ? null : a2.trim();
    }

    /**
     * @return a3
     */
    public String getA3() {
        return a3;
    }

    /**
     * @param a3
     */
    public void setA3(String a3) {
        this.a3 = a3 == null ? null : a3.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", a1=").append(a1);
        sb.append(", a2=").append(a2);
        sb.append(", a3=").append(a3);
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
        TestDeadLockDO other = (TestDeadLockDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getA1() == null ? other.getA1() == null : this.getA1().equals(other.getA1()))
            && (this.getA2() == null ? other.getA2() == null : this.getA2().equals(other.getA2()))
            && (this.getA3() == null ? other.getA3() == null : this.getA3().equals(other.getA3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getA1() == null) ? 0 : getA1().hashCode());
        result = prime * result + ((getA2() == null) ? 0 : getA2().hashCode());
        result = prime * result + ((getA3() == null) ? 0 : getA3().hashCode());
        return result;
    }
}