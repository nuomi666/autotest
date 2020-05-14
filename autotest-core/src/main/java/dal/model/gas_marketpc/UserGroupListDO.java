package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_group_list")
public class UserGroupListDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分组编号
     */
    @Column(name = "user_group_no")
    private String userGroupNo;

    /**
     * 名单类型
     */
    @Column(name = "list_type")
    private String listType;

    /**
     * 会员姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 标识号（可能是手机号，会员卡号等）
     */
    @Column(name = "symbol_no")
    private String symbolNo;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

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
     * 获取分组编号
     *
     * @return user_group_no - 分组编号
     */
    public String getUserGroupNo() {
        return userGroupNo;
    }

    /**
     * 设置分组编号
     *
     * @param userGroupNo 分组编号
     */
    public void setUserGroupNo(String userGroupNo) {
        this.userGroupNo = userGroupNo == null ? null : userGroupNo.trim();
    }

    /**
     * 获取名单类型
     *
     * @return list_type - 名单类型
     */
    public String getListType() {
        return listType;
    }

    /**
     * 设置名单类型
     *
     * @param listType 名单类型
     */
    public void setListType(String listType) {
        this.listType = listType == null ? null : listType.trim();
    }

    /**
     * 获取会员姓名
     *
     * @return real_name - 会员姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置会员姓名
     *
     * @param realName 会员姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取标识号（可能是手机号，会员卡号等）
     *
     * @return symbol_no - 标识号（可能是手机号，会员卡号等）
     */
    public String getSymbolNo() {
        return symbolNo;
    }

    /**
     * 设置标识号（可能是手机号，会员卡号等）
     *
     * @param symbolNo 标识号（可能是手机号，会员卡号等）
     */
    public void setSymbolNo(String symbolNo) {
        this.symbolNo = symbolNo == null ? null : symbolNo.trim();
    }

    /**
     * @return raw_add_time
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * @param rawAddTime
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * @return raw_update_time
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * @param rawUpdateTime
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
        sb.append(", userGroupNo=").append(userGroupNo);
        sb.append(", listType=").append(listType);
        sb.append(", realName=").append(realName);
        sb.append(", symbolNo=").append(symbolNo);
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
        UserGroupListDO other = (UserGroupListDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserGroupNo() == null ? other.getUserGroupNo() == null : this.getUserGroupNo().equals(other.getUserGroupNo()))
            && (this.getListType() == null ? other.getListType() == null : this.getListType().equals(other.getListType()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getSymbolNo() == null ? other.getSymbolNo() == null : this.getSymbolNo().equals(other.getSymbolNo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserGroupNo() == null) ? 0 : getUserGroupNo().hashCode());
        result = prime * result + ((getListType() == null) ? 0 : getListType().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSymbolNo() == null) ? 0 : getSymbolNo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}