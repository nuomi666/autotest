package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_notify_task")
public class PayNotifyTaskDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 通知模式-dubbo,http
     */
    @Column(name = "notify_category")
    private String notifyCategory;

    /**
     * 通知类型-根据业务定义的通知l类型
     */
    @Column(name = "notify_type")
    private String notifyType;

    @Column(name = "notify_group")
    private String notifyGroup;

    @Column(name = "notify_version")
    private String notifyVersion;

    @Column(name = "notify_url")
    private String notifyUrl;

    private String status;

    /**
     * 重试次数
     */
    @Column(name = "retry_count")
    private Integer retryCount;

    /**
     * 最大重试次数
     */
    @Column(name = "max_retry_count")
    private Integer maxRetryCount;

    /**
     * 描述
     */
    private String detail;

    /**
     * 入库时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 更新时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序列
     *
     * @return id - 自增序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增序列
     *
     * @param id 自增序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取业务流水号
     *
     * @return biz_no - 业务流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置业务流水号
     *
     * @param bizNo 业务流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取通知模式-dubbo,http
     *
     * @return notify_category - 通知模式-dubbo,http
     */
    public String getNotifyCategory() {
        return notifyCategory;
    }

    /**
     * 设置通知模式-dubbo,http
     *
     * @param notifyCategory 通知模式-dubbo,http
     */
    public void setNotifyCategory(String notifyCategory) {
        this.notifyCategory = notifyCategory == null ? null : notifyCategory.trim();
    }

    /**
     * 获取通知类型-根据业务定义的通知l类型
     *
     * @return notify_type - 通知类型-根据业务定义的通知l类型
     */
    public String getNotifyType() {
        return notifyType;
    }

    /**
     * 设置通知类型-根据业务定义的通知l类型
     *
     * @param notifyType 通知类型-根据业务定义的通知l类型
     */
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType == null ? null : notifyType.trim();
    }

    /**
     * @return notify_group
     */
    public String getNotifyGroup() {
        return notifyGroup;
    }

    /**
     * @param notifyGroup
     */
    public void setNotifyGroup(String notifyGroup) {
        this.notifyGroup = notifyGroup == null ? null : notifyGroup.trim();
    }

    /**
     * @return notify_version
     */
    public String getNotifyVersion() {
        return notifyVersion;
    }

    /**
     * @param notifyVersion
     */
    public void setNotifyVersion(String notifyVersion) {
        this.notifyVersion = notifyVersion == null ? null : notifyVersion.trim();
    }

    /**
     * @return notify_url
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * @param notifyUrl
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取重试次数
     *
     * @return retry_count - 重试次数
     */
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * 设置重试次数
     *
     * @param retryCount 重试次数
     */
    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * 获取最大重试次数
     *
     * @return max_retry_count - 最大重试次数
     */
    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    /**
     * 设置最大重试次数
     *
     * @param maxRetryCount 最大重试次数
     */
    public void setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    /**
     * 获取描述
     *
     * @return detail - 描述
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置描述
     *
     * @param detail 描述
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * 获取入库时间
     *
     * @return raw_add_time - 入库时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置入库时间
     *
     * @param rawAddTime 入库时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取更新时间
     *
     * @return raw_update_time - 更新时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param rawUpdateTime 更新时间
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
        sb.append(", bizNo=").append(bizNo);
        sb.append(", notifyCategory=").append(notifyCategory);
        sb.append(", notifyType=").append(notifyType);
        sb.append(", notifyGroup=").append(notifyGroup);
        sb.append(", notifyVersion=").append(notifyVersion);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", status=").append(status);
        sb.append(", retryCount=").append(retryCount);
        sb.append(", maxRetryCount=").append(maxRetryCount);
        sb.append(", detail=").append(detail);
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
        PayNotifyTaskDO other = (PayNotifyTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getNotifyCategory() == null ? other.getNotifyCategory() == null : this.getNotifyCategory().equals(other.getNotifyCategory()))
            && (this.getNotifyType() == null ? other.getNotifyType() == null : this.getNotifyType().equals(other.getNotifyType()))
            && (this.getNotifyGroup() == null ? other.getNotifyGroup() == null : this.getNotifyGroup().equals(other.getNotifyGroup()))
            && (this.getNotifyVersion() == null ? other.getNotifyVersion() == null : this.getNotifyVersion().equals(other.getNotifyVersion()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRetryCount() == null ? other.getRetryCount() == null : this.getRetryCount().equals(other.getRetryCount()))
            && (this.getMaxRetryCount() == null ? other.getMaxRetryCount() == null : this.getMaxRetryCount().equals(other.getMaxRetryCount()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getNotifyCategory() == null) ? 0 : getNotifyCategory().hashCode());
        result = prime * result + ((getNotifyType() == null) ? 0 : getNotifyType().hashCode());
        result = prime * result + ((getNotifyGroup() == null) ? 0 : getNotifyGroup().hashCode());
        result = prime * result + ((getNotifyVersion() == null) ? 0 : getNotifyVersion().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRetryCount() == null) ? 0 : getRetryCount().hashCode());
        result = prime * result + ((getMaxRetryCount() == null) ? 0 : getMaxRetryCount().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}