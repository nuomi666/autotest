package dal.model.rap;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_project")
public class TbProjectDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 版本号 version no.
     */
    private String version;

    /**
     * 项目名称 project name
     */
    private String name;

    /**
     * 创建日期 create date
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 创建人ID, project author id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 项目描述 project introduction
     */
    private String introduction;

    /**
     * 工作区提交模式(类VSS or SVN)，暂时弃用了。 Workspace submit mode, deprecated.
     */
    @Column(name = "workspace_mode")
    private Integer workspaceMode;

    /**
     * 项目阶段，暂时废弃;project stage, temply deprecated.  1-design 2-developing 3-debug
     */
    private Integer stage;

    /**
     * 项目JSON数据，存放当前最新的版本。 project JSON data, saved the newest version of the project
     */
    @Column(name = "project_data")
    private String projectData;

    /**
     * 分组ID group id
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * 路由ID，用于指定与哪些项目共享mock数据; router id, used for specify sharing data with which projects.
     */
    @Column(name = "related_ids")
    private String relatedIds;

    /**
     * 更新时间 update time
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * mock次数 mock num
     */
    @Column(name = "mock_num")
    private Integer mockNum;

    /**
     * 权限控制, 10普通, 0私有
     */
    @Column(name = "access_type")
    private Byte accessType;

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
     * 获取版本号 version no.
     *
     * @return version - 版本号 version no.
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号 version no.
     *
     * @param version 版本号 version no.
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 获取项目名称 project name
     *
     * @return name - 项目名称 project name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置项目名称 project name
     *
     * @param name 项目名称 project name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取创建日期 create date
     *
     * @return create_date - 创建日期 create date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期 create date
     *
     * @param createDate 创建日期 create date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取创建人ID, project author id
     *
     * @return user_id - 创建人ID, project author id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置创建人ID, project author id
     *
     * @param userId 创建人ID, project author id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取项目描述 project introduction
     *
     * @return introduction - 项目描述 project introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置项目描述 project introduction
     *
     * @param introduction 项目描述 project introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 获取工作区提交模式(类VSS or SVN)，暂时弃用了。 Workspace submit mode, deprecated.
     *
     * @return workspace_mode - 工作区提交模式(类VSS or SVN)，暂时弃用了。 Workspace submit mode, deprecated.
     */
    public Integer getWorkspaceMode() {
        return workspaceMode;
    }

    /**
     * 设置工作区提交模式(类VSS or SVN)，暂时弃用了。 Workspace submit mode, deprecated.
     *
     * @param workspaceMode 工作区提交模式(类VSS or SVN)，暂时弃用了。 Workspace submit mode, deprecated.
     */
    public void setWorkspaceMode(Integer workspaceMode) {
        this.workspaceMode = workspaceMode;
    }

    /**
     * 获取项目阶段，暂时废弃;project stage, temply deprecated.  1-design 2-developing 3-debug
     *
     * @return stage - 项目阶段，暂时废弃;project stage, temply deprecated.  1-design 2-developing 3-debug
     */
    public Integer getStage() {
        return stage;
    }

    /**
     * 设置项目阶段，暂时废弃;project stage, temply deprecated.  1-design 2-developing 3-debug
     *
     * @param stage 项目阶段，暂时废弃;project stage, temply deprecated.  1-design 2-developing 3-debug
     */
    public void setStage(Integer stage) {
        this.stage = stage;
    }

    /**
     * 获取项目JSON数据，存放当前最新的版本。 project JSON data, saved the newest version of the project
     *
     * @return project_data - 项目JSON数据，存放当前最新的版本。 project JSON data, saved the newest version of the project
     */
    public String getProjectData() {
        return projectData;
    }

    /**
     * 设置项目JSON数据，存放当前最新的版本。 project JSON data, saved the newest version of the project
     *
     * @param projectData 项目JSON数据，存放当前最新的版本。 project JSON data, saved the newest version of the project
     */
    public void setProjectData(String projectData) {
        this.projectData = projectData == null ? null : projectData.trim();
    }

    /**
     * 获取分组ID group id
     *
     * @return group_id - 分组ID group id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置分组ID group id
     *
     * @param groupId 分组ID group id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取路由ID，用于指定与哪些项目共享mock数据; router id, used for specify sharing data with which projects.
     *
     * @return related_ids - 路由ID，用于指定与哪些项目共享mock数据; router id, used for specify sharing data with which projects.
     */
    public String getRelatedIds() {
        return relatedIds;
    }

    /**
     * 设置路由ID，用于指定与哪些项目共享mock数据; router id, used for specify sharing data with which projects.
     *
     * @param relatedIds 路由ID，用于指定与哪些项目共享mock数据; router id, used for specify sharing data with which projects.
     */
    public void setRelatedIds(String relatedIds) {
        this.relatedIds = relatedIds == null ? null : relatedIds.trim();
    }

    /**
     * 获取更新时间 update time
     *
     * @return update_time - 更新时间 update time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间 update time
     *
     * @param updateTime 更新时间 update time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取mock次数 mock num
     *
     * @return mock_num - mock次数 mock num
     */
    public Integer getMockNum() {
        return mockNum;
    }

    /**
     * 设置mock次数 mock num
     *
     * @param mockNum mock次数 mock num
     */
    public void setMockNum(Integer mockNum) {
        this.mockNum = mockNum;
    }

    /**
     * 获取权限控制, 10普通, 0私有
     *
     * @return access_type - 权限控制, 10普通, 0私有
     */
    public Byte getAccessType() {
        return accessType;
    }

    /**
     * 设置权限控制, 10普通, 0私有
     *
     * @param accessType 权限控制, 10普通, 0私有
     */
    public void setAccessType(Byte accessType) {
        this.accessType = accessType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", name=").append(name);
        sb.append(", createDate=").append(createDate);
        sb.append(", userId=").append(userId);
        sb.append(", introduction=").append(introduction);
        sb.append(", workspaceMode=").append(workspaceMode);
        sb.append(", stage=").append(stage);
        sb.append(", projectData=").append(projectData);
        sb.append(", groupId=").append(groupId);
        sb.append(", relatedIds=").append(relatedIds);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", mockNum=").append(mockNum);
        sb.append(", accessType=").append(accessType);
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
        TbProjectDO other = (TbProjectDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
            && (this.getWorkspaceMode() == null ? other.getWorkspaceMode() == null : this.getWorkspaceMode().equals(other.getWorkspaceMode()))
            && (this.getStage() == null ? other.getStage() == null : this.getStage().equals(other.getStage()))
            && (this.getProjectData() == null ? other.getProjectData() == null : this.getProjectData().equals(other.getProjectData()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getRelatedIds() == null ? other.getRelatedIds() == null : this.getRelatedIds().equals(other.getRelatedIds()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getMockNum() == null ? other.getMockNum() == null : this.getMockNum().equals(other.getMockNum()))
            && (this.getAccessType() == null ? other.getAccessType() == null : this.getAccessType().equals(other.getAccessType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getWorkspaceMode() == null) ? 0 : getWorkspaceMode().hashCode());
        result = prime * result + ((getStage() == null) ? 0 : getStage().hashCode());
        result = prime * result + ((getProjectData() == null) ? 0 : getProjectData().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getRelatedIds() == null) ? 0 : getRelatedIds().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getMockNum() == null) ? 0 : getMockNum().hashCode());
        result = prime * result + ((getAccessType() == null) ? 0 : getAccessType().hashCode());
        return result;
    }
}