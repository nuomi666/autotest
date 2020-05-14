package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "persona_task")
public class PersonaTaskDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模型ID
     */
    @Column(name = "persona_id")
    private Long personaId;

    /**
     * 会话ID
     */
    private String gid;

    /**
     * 构建方式
     */
    @Column(name = "generate_type")
    private String generateType;

    /**
     * mq-topic
     */
    private String topic;

    /**
     * mq-event
     */
    private String event;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件地址
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 总人数
     */
    @Column(name = "persona_count")
    private Long personaCount;

    /**
     * 序列值
     */
    @Column(name = "persona_index")
    private Long personaIndex;

    /**
     * 状态
     */
    private String status;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 创建时间
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
     * 获取模型ID
     *
     * @return persona_id - 模型ID
     */
    public Long getPersonaId() {
        return personaId;
    }

    /**
     * 设置模型ID
     *
     * @param personaId 模型ID
     */
    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    /**
     * 获取会话ID
     *
     * @return gid - 会话ID
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置会话ID
     *
     * @param gid 会话ID
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取构建方式
     *
     * @return generate_type - 构建方式
     */
    public String getGenerateType() {
        return generateType;
    }

    /**
     * 设置构建方式
     *
     * @param generateType 构建方式
     */
    public void setGenerateType(String generateType) {
        this.generateType = generateType == null ? null : generateType.trim();
    }

    /**
     * 获取mq-topic
     *
     * @return topic - mq-topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 设置mq-topic
     *
     * @param topic mq-topic
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * 获取mq-event
     *
     * @return event - mq-event
     */
    public String getEvent() {
        return event;
    }

    /**
     * 设置mq-event
     *
     * @param event mq-event
     */
    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    /**
     * 获取文件名
     *
     * @return file_name - 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名
     *
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 获取文件地址
     *
     * @return file_path - 文件地址
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置文件地址
     *
     * @param filePath 文件地址
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * 获取总人数
     *
     * @return persona_count - 总人数
     */
    public Long getPersonaCount() {
        return personaCount;
    }

    /**
     * 设置总人数
     *
     * @param personaCount 总人数
     */
    public void setPersonaCount(Long personaCount) {
        this.personaCount = personaCount;
    }

    /**
     * 获取序列值
     *
     * @return persona_index - 序列值
     */
    public Long getPersonaIndex() {
        return personaIndex;
    }

    /**
     * 设置序列值
     *
     * @param personaIndex 序列值
     */
    public void setPersonaIndex(Long personaIndex) {
        this.personaIndex = personaIndex;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取描述信息
     *
     * @return message - 描述信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置描述信息
     *
     * @param message 描述信息
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 获取创建时间
     *
     * @return raw_add_time - 创建时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置创建时间
     *
     * @param rawAddTime 创建时间
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
        sb.append(", personaId=").append(personaId);
        sb.append(", gid=").append(gid);
        sb.append(", generateType=").append(generateType);
        sb.append(", topic=").append(topic);
        sb.append(", event=").append(event);
        sb.append(", fileName=").append(fileName);
        sb.append(", filePath=").append(filePath);
        sb.append(", personaCount=").append(personaCount);
        sb.append(", personaIndex=").append(personaIndex);
        sb.append(", status=").append(status);
        sb.append(", message=").append(message);
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
        PersonaTaskDO other = (PersonaTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonaId() == null ? other.getPersonaId() == null : this.getPersonaId().equals(other.getPersonaId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getGenerateType() == null ? other.getGenerateType() == null : this.getGenerateType().equals(other.getGenerateType()))
            && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
            && (this.getEvent() == null ? other.getEvent() == null : this.getEvent().equals(other.getEvent()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getPersonaCount() == null ? other.getPersonaCount() == null : this.getPersonaCount().equals(other.getPersonaCount()))
            && (this.getPersonaIndex() == null ? other.getPersonaIndex() == null : this.getPersonaIndex().equals(other.getPersonaIndex()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonaId() == null) ? 0 : getPersonaId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getGenerateType() == null) ? 0 : getGenerateType().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getEvent() == null) ? 0 : getEvent().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getPersonaCount() == null) ? 0 : getPersonaCount().hashCode());
        result = prime * result + ((getPersonaIndex() == null) ? 0 : getPersonaIndex().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}