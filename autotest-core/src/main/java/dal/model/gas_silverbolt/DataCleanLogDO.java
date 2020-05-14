package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "data_clean_log")
public class DataCleanLogDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 清洗的表名
     */
    @Column(name = "t_name")
    private String tName;

    /**
     * 清洗时间
     */
    @Column(name = "clean_time")
    private String cleanTime;

    /**
     * 清洗数量
     */
    @Column(name = "clean_tatol")
    private Integer cleanTatol;

    /**
     * 错误原因
     */
    @Column(name = "err_msg")
    private String errMsg;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

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
     * 获取清洗的表名
     *
     * @return t_name - 清洗的表名
     */
    public String gettName() {
        return tName;
    }

    /**
     * 设置清洗的表名
     *
     * @param tName 清洗的表名
     */
    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    /**
     * 获取清洗时间
     *
     * @return clean_time - 清洗时间
     */
    public String getCleanTime() {
        return cleanTime;
    }

    /**
     * 设置清洗时间
     *
     * @param cleanTime 清洗时间
     */
    public void setCleanTime(String cleanTime) {
        this.cleanTime = cleanTime == null ? null : cleanTime.trim();
    }

    /**
     * 获取清洗数量
     *
     * @return clean_tatol - 清洗数量
     */
    public Integer getCleanTatol() {
        return cleanTatol;
    }

    /**
     * 设置清洗数量
     *
     * @param cleanTatol 清洗数量
     */
    public void setCleanTatol(Integer cleanTatol) {
        this.cleanTatol = cleanTatol;
    }

    /**
     * 获取错误原因
     *
     * @return err_msg - 错误原因
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 设置错误原因
     *
     * @param errMsg 错误原因
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", tName=").append(tName);
        sb.append(", cleanTime=").append(cleanTime);
        sb.append(", cleanTatol=").append(cleanTatol);
        sb.append(", errMsg=").append(errMsg);
        sb.append(", rawAddTime=").append(rawAddTime);
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
        DataCleanLogDO other = (DataCleanLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.gettName() == null ? other.gettName() == null : this.gettName().equals(other.gettName()))
            && (this.getCleanTime() == null ? other.getCleanTime() == null : this.getCleanTime().equals(other.getCleanTime()))
            && (this.getCleanTatol() == null ? other.getCleanTatol() == null : this.getCleanTatol().equals(other.getCleanTatol()))
            && (this.getErrMsg() == null ? other.getErrMsg() == null : this.getErrMsg().equals(other.getErrMsg()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((gettName() == null) ? 0 : gettName().hashCode());
        result = prime * result + ((getCleanTime() == null) ? 0 : getCleanTime().hashCode());
        result = prime * result + ((getCleanTatol() == null) ? 0 : getCleanTatol().hashCode());
        result = prime * result + ((getErrMsg() == null) ? 0 : getErrMsg().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        return result;
    }
}