package dal.model.gas_user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_group")
public class UserGroupDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分组编号
     */
    @Column(name = "user_group_no")
    private String userGroupNo;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组类型
     */
    @Column(name = "user_group_type")
    private String userGroupType;

    /**
     * 组内名单数
     */
    @Column(name = "total_list")
    private Integer totalList;

    /**
     * 备注
     */
    private String memo;

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
     * 获取平台商ID
     *
     * @return plat_partner_id - 平台商ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商ID
     *
     * @param platPartnerId 平台商ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取分组名称
     *
     * @return name - 分组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分组名称
     *
     * @param name 分组名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取分组类型
     *
     * @return user_group_type - 分组类型
     */
    public String getUserGroupType() {
        return userGroupType;
    }

    /**
     * 设置分组类型
     *
     * @param userGroupType 分组类型
     */
    public void setUserGroupType(String userGroupType) {
        this.userGroupType = userGroupType == null ? null : userGroupType.trim();
    }

    /**
     * 获取组内名单数
     *
     * @return total_list - 组内名单数
     */
    public Integer getTotalList() {
        return totalList;
    }

    /**
     * 设置组内名单数
     *
     * @param totalList 组内名单数
     */
    public void setTotalList(Integer totalList) {
        this.totalList = totalList;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", name=").append(name);
        sb.append(", userGroupType=").append(userGroupType);
        sb.append(", totalList=").append(totalList);
        sb.append(", memo=").append(memo);
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
        UserGroupDO other = (UserGroupDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserGroupNo() == null ? other.getUserGroupNo() == null : this.getUserGroupNo().equals(other.getUserGroupNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUserGroupType() == null ? other.getUserGroupType() == null : this.getUserGroupType().equals(other.getUserGroupType()))
            && (this.getTotalList() == null ? other.getTotalList() == null : this.getTotalList().equals(other.getTotalList()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserGroupNo() == null) ? 0 : getUserGroupNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUserGroupType() == null) ? 0 : getUserGroupType().hashCode());
        result = prime * result + ((getTotalList() == null) ? 0 : getTotalList().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}