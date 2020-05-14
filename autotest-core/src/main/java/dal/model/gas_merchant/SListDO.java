package dal.model.gas_merchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "s_list")
public class SListDO implements Serializable {
    private String name;

    private String name1;

    private String c1;

    private String c2;

    private String c3;

    private String c4;

    private String c5;

    private String c6;

    private String c7;

    private String c8;

    private String c9;

    private String c10;

    private static final long serialVersionUID = 1L;

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
     * @return name1
     */
    public String getName1() {
        return name1;
    }

    /**
     * @param name1
     */
    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    /**
     * @return c1
     */
    public String getC1() {
        return c1;
    }

    /**
     * @param c1
     */
    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    /**
     * @return c2
     */
    public String getC2() {
        return c2;
    }

    /**
     * @param c2
     */
    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

    /**
     * @return c3
     */
    public String getC3() {
        return c3;
    }

    /**
     * @param c3
     */
    public void setC3(String c3) {
        this.c3 = c3 == null ? null : c3.trim();
    }

    /**
     * @return c4
     */
    public String getC4() {
        return c4;
    }

    /**
     * @param c4
     */
    public void setC4(String c4) {
        this.c4 = c4 == null ? null : c4.trim();
    }

    /**
     * @return c5
     */
    public String getC5() {
        return c5;
    }

    /**
     * @param c5
     */
    public void setC5(String c5) {
        this.c5 = c5 == null ? null : c5.trim();
    }

    /**
     * @return c6
     */
    public String getC6() {
        return c6;
    }

    /**
     * @param c6
     */
    public void setC6(String c6) {
        this.c6 = c6 == null ? null : c6.trim();
    }

    /**
     * @return c7
     */
    public String getC7() {
        return c7;
    }

    /**
     * @param c7
     */
    public void setC7(String c7) {
        this.c7 = c7 == null ? null : c7.trim();
    }

    /**
     * @return c8
     */
    public String getC8() {
        return c8;
    }

    /**
     * @param c8
     */
    public void setC8(String c8) {
        this.c8 = c8 == null ? null : c8.trim();
    }

    /**
     * @return c9
     */
    public String getC9() {
        return c9;
    }

    /**
     * @param c9
     */
    public void setC9(String c9) {
        this.c9 = c9 == null ? null : c9.trim();
    }

    /**
     * @return c10
     */
    public String getC10() {
        return c10;
    }

    /**
     * @param c10
     */
    public void setC10(String c10) {
        this.c10 = c10 == null ? null : c10.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", name=").append(name);
        sb.append(", name1=").append(name1);
        sb.append(", c1=").append(c1);
        sb.append(", c2=").append(c2);
        sb.append(", c3=").append(c3);
        sb.append(", c4=").append(c4);
        sb.append(", c5=").append(c5);
        sb.append(", c6=").append(c6);
        sb.append(", c7=").append(c7);
        sb.append(", c8=").append(c8);
        sb.append(", c9=").append(c9);
        sb.append(", c10=").append(c10);
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
        SListDO other = (SListDO) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getName1() == null ? other.getName1() == null : this.getName1().equals(other.getName1()))
            && (this.getC1() == null ? other.getC1() == null : this.getC1().equals(other.getC1()))
            && (this.getC2() == null ? other.getC2() == null : this.getC2().equals(other.getC2()))
            && (this.getC3() == null ? other.getC3() == null : this.getC3().equals(other.getC3()))
            && (this.getC4() == null ? other.getC4() == null : this.getC4().equals(other.getC4()))
            && (this.getC5() == null ? other.getC5() == null : this.getC5().equals(other.getC5()))
            && (this.getC6() == null ? other.getC6() == null : this.getC6().equals(other.getC6()))
            && (this.getC7() == null ? other.getC7() == null : this.getC7().equals(other.getC7()))
            && (this.getC8() == null ? other.getC8() == null : this.getC8().equals(other.getC8()))
            && (this.getC9() == null ? other.getC9() == null : this.getC9().equals(other.getC9()))
            && (this.getC10() == null ? other.getC10() == null : this.getC10().equals(other.getC10()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getName1() == null) ? 0 : getName1().hashCode());
        result = prime * result + ((getC1() == null) ? 0 : getC1().hashCode());
        result = prime * result + ((getC2() == null) ? 0 : getC2().hashCode());
        result = prime * result + ((getC3() == null) ? 0 : getC3().hashCode());
        result = prime * result + ((getC4() == null) ? 0 : getC4().hashCode());
        result = prime * result + ((getC5() == null) ? 0 : getC5().hashCode());
        result = prime * result + ((getC6() == null) ? 0 : getC6().hashCode());
        result = prime * result + ((getC7() == null) ? 0 : getC7().hashCode());
        result = prime * result + ((getC8() == null) ? 0 : getC8().hashCode());
        result = prime * result + ((getC9() == null) ? 0 : getC9().hashCode());
        result = prime * result + ((getC10() == null) ? 0 : getC10().hashCode());
        return result;
    }
}