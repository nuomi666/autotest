package dal.model.clear;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clear_dsgj_task_log")
public class ClearDsgjTaskLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 渠道id
     */
    private String gid;

    /**
     * 业务流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 平台商户名称
     */
    @Column(name = "plat_partner_real_name")
    private String platPartnerRealName;

    /**
     * 清分日期
     */
    @Column(name = "clear_date")
    private String clearDate;

    /**
     * 清分文件名
     */
    @Column(name = "clear_file_name")
    private String clearFileName;

    /**
     * 清分结果文件名
     */
    @Column(name = "clear_result_file_name")
    private String clearResultFileName;

    /**
     * 清分状态：INIT,SUCCESS,FAIL
     */
    @Column(name = "clear_status")
    private String clearStatus;

    /**
     * 清分文件状态
     */
    @Column(name = "file_status")
    private String fileStatus;

    /**
     * 清分时间
     */
    @Column(name = "clear_time")
    private Date clearTime;

    /**
     * 清分文件上传请求时间
     */
    @Column(name = "request_time")
    private Date requestTime;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 清分备注
     */
    private String comment;

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
     * 获取渠道id
     *
     * @return gid - 渠道id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置渠道id
     *
     * @param gid 渠道id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
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
     * 获取平台商户id
     *
     * @return plat_partner_id - 平台商户id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户id
     *
     * @param platPartnerId 平台商户id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取平台商户名称
     *
     * @return plat_partner_real_name - 平台商户名称
     */
    public String getPlatPartnerRealName() {
        return platPartnerRealName;
    }

    /**
     * 设置平台商户名称
     *
     * @param platPartnerRealName 平台商户名称
     */
    public void setPlatPartnerRealName(String platPartnerRealName) {
        this.platPartnerRealName = platPartnerRealName == null ? null : platPartnerRealName.trim();
    }

    /**
     * 获取清分日期
     *
     * @return clear_date - 清分日期
     */
    public String getClearDate() {
        return clearDate;
    }

    /**
     * 设置清分日期
     *
     * @param clearDate 清分日期
     */
    public void setClearDate(String clearDate) {
        this.clearDate = clearDate == null ? null : clearDate.trim();
    }

    /**
     * 获取清分文件名
     *
     * @return clear_file_name - 清分文件名
     */
    public String getClearFileName() {
        return clearFileName;
    }

    /**
     * 设置清分文件名
     *
     * @param clearFileName 清分文件名
     */
    public void setClearFileName(String clearFileName) {
        this.clearFileName = clearFileName == null ? null : clearFileName.trim();
    }

    /**
     * 获取清分结果文件名
     *
     * @return clear_result_file_name - 清分结果文件名
     */
    public String getClearResultFileName() {
        return clearResultFileName;
    }

    /**
     * 设置清分结果文件名
     *
     * @param clearResultFileName 清分结果文件名
     */
    public void setClearResultFileName(String clearResultFileName) {
        this.clearResultFileName = clearResultFileName == null ? null : clearResultFileName.trim();
    }

    /**
     * 获取清分状态：INIT,SUCCESS,FAIL
     *
     * @return clear_status - 清分状态：INIT,SUCCESS,FAIL
     */
    public String getClearStatus() {
        return clearStatus;
    }

    /**
     * 设置清分状态：INIT,SUCCESS,FAIL
     *
     * @param clearStatus 清分状态：INIT,SUCCESS,FAIL
     */
    public void setClearStatus(String clearStatus) {
        this.clearStatus = clearStatus == null ? null : clearStatus.trim();
    }

    /**
     * 获取清分文件状态
     *
     * @return file_status - 清分文件状态
     */
    public String getFileStatus() {
        return fileStatus;
    }

    /**
     * 设置清分文件状态
     *
     * @param fileStatus 清分文件状态
     */
    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus == null ? null : fileStatus.trim();
    }

    /**
     * 获取清分时间
     *
     * @return clear_time - 清分时间
     */
    public Date getClearTime() {
        return clearTime;
    }

    /**
     * 设置清分时间
     *
     * @param clearTime 清分时间
     */
    public void setClearTime(Date clearTime) {
        this.clearTime = clearTime;
    }

    /**
     * 获取清分文件上传请求时间
     *
     * @return request_time - 清分文件上传请求时间
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * 设置清分文件上传请求时间
     *
     * @param requestTime 清分文件上传请求时间
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
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

    /**
     * 获取清分备注
     *
     * @return comment - 清分备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置清分备注
     *
     * @param comment 清分备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", gid=").append(gid);
        sb.append(", bizNo=").append(bizNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platPartnerRealName=").append(platPartnerRealName);
        sb.append(", clearDate=").append(clearDate);
        sb.append(", clearFileName=").append(clearFileName);
        sb.append(", clearResultFileName=").append(clearResultFileName);
        sb.append(", clearStatus=").append(clearStatus);
        sb.append(", fileStatus=").append(fileStatus);
        sb.append(", clearTime=").append(clearTime);
        sb.append(", requestTime=").append(requestTime);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", comment=").append(comment);
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
        ClearDsgjTaskLogDO other = (ClearDsgjTaskLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatPartnerRealName() == null ? other.getPlatPartnerRealName() == null : this.getPlatPartnerRealName().equals(other.getPlatPartnerRealName()))
            && (this.getClearDate() == null ? other.getClearDate() == null : this.getClearDate().equals(other.getClearDate()))
            && (this.getClearFileName() == null ? other.getClearFileName() == null : this.getClearFileName().equals(other.getClearFileName()))
            && (this.getClearResultFileName() == null ? other.getClearResultFileName() == null : this.getClearResultFileName().equals(other.getClearResultFileName()))
            && (this.getClearStatus() == null ? other.getClearStatus() == null : this.getClearStatus().equals(other.getClearStatus()))
            && (this.getFileStatus() == null ? other.getFileStatus() == null : this.getFileStatus().equals(other.getFileStatus()))
            && (this.getClearTime() == null ? other.getClearTime() == null : this.getClearTime().equals(other.getClearTime()))
            && (this.getRequestTime() == null ? other.getRequestTime() == null : this.getRequestTime().equals(other.getRequestTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerRealName() == null) ? 0 : getPlatPartnerRealName().hashCode());
        result = prime * result + ((getClearDate() == null) ? 0 : getClearDate().hashCode());
        result = prime * result + ((getClearFileName() == null) ? 0 : getClearFileName().hashCode());
        result = prime * result + ((getClearResultFileName() == null) ? 0 : getClearResultFileName().hashCode());
        result = prime * result + ((getClearStatus() == null) ? 0 : getClearStatus().hashCode());
        result = prime * result + ((getFileStatus() == null) ? 0 : getFileStatus().hashCode());
        result = prime * result + ((getClearTime() == null) ? 0 : getClearTime().hashCode());
        result = prime * result + ((getRequestTime() == null) ? 0 : getRequestTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        return result;
    }
}