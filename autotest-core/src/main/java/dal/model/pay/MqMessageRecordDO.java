package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mq_message_record")
public class MqMessageRecordDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 支付类型
     */
    @Column(name = "trans_type")
    private String transType;

    /**
     * 支付tag
     */
    @Column(name = "trans_tag")
    private String transTag;

    /**
     * mq事件
     */
    private String event;

    /**
     * mq主题
     */
    private String topic;

    /**
     * mq接收系统
     */
    @Column(name = "to_system")
    private String toSystem;

    private String gid;

    @Column(name = "req_id")
    private String reqId;

    /**
     * mq推送map数据json
     */
    @Column(name = "mq_data")
    private String mqData;

    private String status;

    /**
     * 描述
     */
    private String description;

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
     * 获取交易流水号
     *
     * @return biz_no - 交易流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置交易流水号
     *
     * @param bizNo 交易流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取支付类型
     *
     * @return trans_type - 支付类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * 设置支付类型
     *
     * @param transType 支付类型
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * 获取支付tag
     *
     * @return trans_tag - 支付tag
     */
    public String getTransTag() {
        return transTag;
    }

    /**
     * 设置支付tag
     *
     * @param transTag 支付tag
     */
    public void setTransTag(String transTag) {
        this.transTag = transTag == null ? null : transTag.trim();
    }

    /**
     * 获取mq事件
     *
     * @return event - mq事件
     */
    public String getEvent() {
        return event;
    }

    /**
     * 设置mq事件
     *
     * @param event mq事件
     */
    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    /**
     * 获取mq主题
     *
     * @return topic - mq主题
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 设置mq主题
     *
     * @param topic mq主题
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * 获取mq接收系统
     *
     * @return to_system - mq接收系统
     */
    public String getToSystem() {
        return toSystem;
    }

    /**
     * 设置mq接收系统
     *
     * @param toSystem mq接收系统
     */
    public void setToSystem(String toSystem) {
        this.toSystem = toSystem == null ? null : toSystem.trim();
    }

    /**
     * @return gid
     */
    public String getGid() {
        return gid;
    }

    /**
     * @param gid
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * @return req_id
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * @param reqId
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取mq推送map数据json
     *
     * @return mq_data - mq推送map数据json
     */
    public String getMqData() {
        return mqData;
    }

    /**
     * 设置mq推送map数据json
     *
     * @param mqData mq推送map数据json
     */
    public void setMqData(String mqData) {
        this.mqData = mqData == null ? null : mqData.trim();
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
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        sb.append(", transType=").append(transType);
        sb.append(", transTag=").append(transTag);
        sb.append(", event=").append(event);
        sb.append(", topic=").append(topic);
        sb.append(", toSystem=").append(toSystem);
        sb.append(", gid=").append(gid);
        sb.append(", reqId=").append(reqId);
        sb.append(", mqData=").append(mqData);
        sb.append(", status=").append(status);
        sb.append(", description=").append(description);
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
        MqMessageRecordDO other = (MqMessageRecordDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getTransType() == null ? other.getTransType() == null : this.getTransType().equals(other.getTransType()))
            && (this.getTransTag() == null ? other.getTransTag() == null : this.getTransTag().equals(other.getTransTag()))
            && (this.getEvent() == null ? other.getEvent() == null : this.getEvent().equals(other.getEvent()))
            && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
            && (this.getToSystem() == null ? other.getToSystem() == null : this.getToSystem().equals(other.getToSystem()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getMqData() == null ? other.getMqData() == null : this.getMqData().equals(other.getMqData()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getTransType() == null) ? 0 : getTransType().hashCode());
        result = prime * result + ((getTransTag() == null) ? 0 : getTransTag().hashCode());
        result = prime * result + ((getEvent() == null) ? 0 : getEvent().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getToSystem() == null) ? 0 : getToSystem().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getMqData() == null) ? 0 : getMqData().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}