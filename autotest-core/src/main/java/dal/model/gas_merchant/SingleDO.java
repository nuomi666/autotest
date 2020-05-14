package dal.model.gas_merchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "single")
public class SingleDO implements Serializable {
    private String name;

    @Column(name = "userName")
    private String username;

    private String p;

    @Column(name = "p_name")
    private String pName;

    private String c;

    @Column(name = "c_name")
    private String cName;

    private String d;

    @Column(name = "d_nname")
    private String dNname;

    private String addres;

    private String temp;

    private String type;

    private String num;

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
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return p
     */
    public String getP() {
        return p;
    }

    /**
     * @param p
     */
    public void setP(String p) {
        this.p = p == null ? null : p.trim();
    }

    /**
     * @return p_name
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * @return c
     */
    public String getC() {
        return c;
    }

    /**
     * @param c
     */
    public void setC(String c) {
        this.c = c == null ? null : c.trim();
    }

    /**
     * @return c_name
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    /**
     * @return d
     */
    public String getD() {
        return d;
    }

    /**
     * @param d
     */
    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }

    /**
     * @return d_nname
     */
    public String getdNname() {
        return dNname;
    }

    /**
     * @param dNname
     */
    public void setdNname(String dNname) {
        this.dNname = dNname == null ? null : dNname.trim();
    }

    /**
     * @return addres
     */
    public String getAddres() {
        return addres;
    }

    /**
     * @param addres
     */
    public void setAddres(String addres) {
        this.addres = addres == null ? null : addres.trim();
    }

    /**
     * @return temp
     */
    public String getTemp() {
        return temp;
    }

    /**
     * @param temp
     */
    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", name=").append(name);
        sb.append(", username=").append(username);
        sb.append(", p=").append(p);
        sb.append(", pName=").append(pName);
        sb.append(", c=").append(c);
        sb.append(", cName=").append(cName);
        sb.append(", d=").append(d);
        sb.append(", dNname=").append(dNname);
        sb.append(", addres=").append(addres);
        sb.append(", temp=").append(temp);
        sb.append(", type=").append(type);
        sb.append(", num=").append(num);
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
        SingleDO other = (SingleDO) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getP() == null ? other.getP() == null : this.getP().equals(other.getP()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()))
            && (this.getC() == null ? other.getC() == null : this.getC().equals(other.getC()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.getD() == null ? other.getD() == null : this.getD().equals(other.getD()))
            && (this.getdNname() == null ? other.getdNname() == null : this.getdNname().equals(other.getdNname()))
            && (this.getAddres() == null ? other.getAddres() == null : this.getAddres().equals(other.getAddres()))
            && (this.getTemp() == null ? other.getTemp() == null : this.getTemp().equals(other.getTemp()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getP() == null) ? 0 : getP().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        result = prime * result + ((getC() == null) ? 0 : getC().hashCode());
        result = prime * result + ((getcName() == null) ? 0 : getcName().hashCode());
        result = prime * result + ((getD() == null) ? 0 : getD().hashCode());
        result = prime * result + ((getdNname() == null) ? 0 : getdNname().hashCode());
        result = prime * result + ((getAddres() == null) ? 0 : getAddres().hashCode());
        result = prime * result + ((getTemp() == null) ? 0 : getTemp().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        return result;
    }
}