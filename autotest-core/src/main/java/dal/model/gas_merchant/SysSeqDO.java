package dal.model.gas_merchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_seq")
public class SysSeqDO implements Serializable {
    /**
     * 自增序列。
     */
    @Id
    private Long identity;

    /**
     * 序列名称，便于以后清理。
     */
    @Column(name = "seq_name")
    private String seqName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序列。
     *
     * @return identity - 自增序列。
     */
    public Long getIdentity() {
        return identity;
    }

    /**
     * 设置自增序列。
     *
     * @param identity 自增序列。
     */
    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    /**
     * 获取序列名称，便于以后清理。
     *
     * @return seq_name - 序列名称，便于以后清理。
     */
    public String getSeqName() {
        return seqName;
    }

    /**
     * 设置序列名称，便于以后清理。
     *
     * @param seqName 序列名称，便于以后清理。
     */
    public void setSeqName(String seqName) {
        this.seqName = seqName == null ? null : seqName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", identity=").append(identity);
        sb.append(", seqName=").append(seqName);
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
        SysSeqDO other = (SysSeqDO) that;
        return (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getSeqName() == null ? other.getSeqName() == null : this.getSeqName().equals(other.getSeqName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getSeqName() == null) ? 0 : getSeqName().hashCode());
        return result;
    }
}