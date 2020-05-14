package dal.model.gas_merchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_unique_key")
public class UserUniqueKeyDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 唯一标识类型
     */
    @Column(name = "uk_type")
    private String ukType;

    /**
     * 唯一标识
     */
    @Column(name = "unique_key")
    private String uniqueKey;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取唯一标识类型
     *
     * @return uk_type - 唯一标识类型
     */
    public String getUkType() {
        return ukType;
    }

    /**
     * 设置唯一标识类型
     *
     * @param ukType 唯一标识类型
     */
    public void setUkType(String ukType) {
        this.ukType = ukType == null ? null : ukType.trim();
    }

    /**
     * 获取唯一标识
     *
     * @return unique_key - 唯一标识
     */
    public String getUniqueKey() {
        return uniqueKey;
    }

    /**
     * 设置唯一标识
     *
     * @param uniqueKey 唯一标识
     */
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", ukType=").append(ukType);
        sb.append(", uniqueKey=").append(uniqueKey);
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
        UserUniqueKeyDO other = (UserUniqueKeyDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUkType() == null ? other.getUkType() == null : this.getUkType().equals(other.getUkType()))
            && (this.getUniqueKey() == null ? other.getUniqueKey() == null : this.getUniqueKey().equals(other.getUniqueKey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUkType() == null) ? 0 : getUkType().hashCode());
        result = prime * result + ((getUniqueKey() == null) ? 0 : getUniqueKey().hashCode());
        return result;
    }
}