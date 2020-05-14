package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "data_clean_task")
public class DataCleanTaskDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 任务名字
     */
    @Column(name = "task_name")
    private String taskName;

    /**
     * 需清洗的表名
     */
    @Column(name = "t_name")
    private String tName;

    /**
     * 时间分片字断
     */
    @Column(name = "time_slice")
    private String timeSlice;

    /**
     * 每次抓取数据间隔天数
     */
    @Column(name = "interval_day")
    private Integer intervalDay;

    /**
     * 批次执行后，延迟执行下一批，单位:s(秒)
     */
    @Column(name = "interval_delay")
    private Integer intervalDelay;

    /**
     * 清洗结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 上次清洗结束时间
     */
    @Column(name = "last_time")
    private Date lastTime;

    /**
     * 状态，true 打开，false 关闭
     */
    private String status;

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
     * 获取任务名字
     *
     * @return task_name - 任务名字
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名字
     *
     * @param taskName 任务名字
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 获取需清洗的表名
     *
     * @return t_name - 需清洗的表名
     */
    public String gettName() {
        return tName;
    }

    /**
     * 设置需清洗的表名
     *
     * @param tName 需清洗的表名
     */
    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    /**
     * 获取时间分片字断
     *
     * @return time_slice - 时间分片字断
     */
    public String getTimeSlice() {
        return timeSlice;
    }

    /**
     * 设置时间分片字断
     *
     * @param timeSlice 时间分片字断
     */
    public void setTimeSlice(String timeSlice) {
        this.timeSlice = timeSlice == null ? null : timeSlice.trim();
    }

    /**
     * 获取每次抓取数据间隔天数
     *
     * @return interval_day - 每次抓取数据间隔天数
     */
    public Integer getIntervalDay() {
        return intervalDay;
    }

    /**
     * 设置每次抓取数据间隔天数
     *
     * @param intervalDay 每次抓取数据间隔天数
     */
    public void setIntervalDay(Integer intervalDay) {
        this.intervalDay = intervalDay;
    }

    /**
     * 获取批次执行后，延迟执行下一批，单位:s(秒)
     *
     * @return interval_delay - 批次执行后，延迟执行下一批，单位:s(秒)
     */
    public Integer getIntervalDelay() {
        return intervalDelay;
    }

    /**
     * 设置批次执行后，延迟执行下一批，单位:s(秒)
     *
     * @param intervalDelay 批次执行后，延迟执行下一批，单位:s(秒)
     */
    public void setIntervalDelay(Integer intervalDelay) {
        this.intervalDelay = intervalDelay;
    }

    /**
     * 获取清洗结束时间
     *
     * @return end_time - 清洗结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置清洗结束时间
     *
     * @param endTime 清洗结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取上次清洗结束时间
     *
     * @return last_time - 上次清洗结束时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 设置上次清洗结束时间
     *
     * @param lastTime 上次清洗结束时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取状态，true 打开，false 关闭
     *
     * @return status - 状态，true 打开，false 关闭
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态，true 打开，false 关闭
     *
     * @param status 状态，true 打开，false 关闭
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", taskName=").append(taskName);
        sb.append(", tName=").append(tName);
        sb.append(", timeSlice=").append(timeSlice);
        sb.append(", intervalDay=").append(intervalDay);
        sb.append(", intervalDelay=").append(intervalDelay);
        sb.append(", endTime=").append(endTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", status=").append(status);
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
        DataCleanTaskDO other = (DataCleanTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.gettName() == null ? other.gettName() == null : this.gettName().equals(other.gettName()))
            && (this.getTimeSlice() == null ? other.getTimeSlice() == null : this.getTimeSlice().equals(other.getTimeSlice()))
            && (this.getIntervalDay() == null ? other.getIntervalDay() == null : this.getIntervalDay().equals(other.getIntervalDay()))
            && (this.getIntervalDelay() == null ? other.getIntervalDelay() == null : this.getIntervalDelay().equals(other.getIntervalDelay()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getLastTime() == null ? other.getLastTime() == null : this.getLastTime().equals(other.getLastTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((gettName() == null) ? 0 : gettName().hashCode());
        result = prime * result + ((getTimeSlice() == null) ? 0 : getTimeSlice().hashCode());
        result = prime * result + ((getIntervalDay() == null) ? 0 : getIntervalDay().hashCode());
        result = prime * result + ((getIntervalDelay() == null) ? 0 : getIntervalDelay().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getLastTime() == null) ? 0 : getLastTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}