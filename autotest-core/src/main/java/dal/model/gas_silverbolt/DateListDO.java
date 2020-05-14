package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "date_list")
public class DateListDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 日期
     */
    private Date dates;

    /**
     * 年份
     */
    private Integer year;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 天
     */
    private Integer days;

    /**
     * 周
     */
    private Integer week;

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
     * 获取日期
     *
     * @return dates - 日期
     */
    public Date getDates() {
        return dates;
    }

    /**
     * 设置日期
     *
     * @param dates 日期
     */
    public void setDates(Date dates) {
        this.dates = dates;
    }

    /**
     * 获取年份
     *
     * @return year - 年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取月份
     *
     * @return month - 月份
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 设置月份
     *
     * @param month 月份
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 获取天
     *
     * @return days - 天
     */
    public Integer getDays() {
        return days;
    }

    /**
     * 设置天
     *
     * @param days 天
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * 获取周
     *
     * @return week - 周
     */
    public Integer getWeek() {
        return week;
    }

    /**
     * 设置周
     *
     * @param week 周
     */
    public void setWeek(Integer week) {
        this.week = week;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", dates=").append(dates);
        sb.append(", year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", days=").append(days);
        sb.append(", week=").append(week);
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
        DateListDO other = (DateListDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDates() == null ? other.getDates() == null : this.getDates().equals(other.getDates()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getWeek() == null ? other.getWeek() == null : this.getWeek().equals(other.getWeek()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDates() == null) ? 0 : getDates().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getWeek() == null) ? 0 : getWeek().hashCode());
        return result;
    }
}