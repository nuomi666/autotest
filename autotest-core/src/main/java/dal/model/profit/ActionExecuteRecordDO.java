package dal.model.profit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "action_execute_record")
public class ActionExecuteRecordDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 执行记录ID
     */
    @Column(name = "task_record_id")
    private Long taskRecordId;

    /**
     * 请求转账服务订单号
     */
    @Column(name = "out_order_no")
    private String outOrderNo;

    /**
     * 来源
     */
    private String source;

    /**
     * 去向
     */
    private String termini;

    /**
     * 执行顺序
     */
    private Integer sequence;

    /**
     * 执行（分润）金额，分
     */
    private Long amount;

    /**
     * 执行状态
     */
    private String state;

    /**
     * 备注
     */
    private String memo;

    /**
     * 调用转账服务请求号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 调用转账服务回话号
     */
    private String gid;

    /**
     * 商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 外部商户号
     */
    @Column(name = "merch_order_no")
    private String merchOrderNo;

    /**
     * 新增时间
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
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取执行记录ID
     *
     * @return task_record_id - 执行记录ID
     */
    public Long getTaskRecordId() {
        return taskRecordId;
    }

    /**
     * 设置执行记录ID
     *
     * @param taskRecordId 执行记录ID
     */
    public void setTaskRecordId(Long taskRecordId) {
        this.taskRecordId = taskRecordId;
    }

    /**
     * 获取请求转账服务订单号
     *
     * @return out_order_no - 请求转账服务订单号
     */
    public String getOutOrderNo() {
        return outOrderNo;
    }

    /**
     * 设置请求转账服务订单号
     *
     * @param outOrderNo 请求转账服务订单号
     */
    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo == null ? null : outOrderNo.trim();
    }

    /**
     * 获取来源
     *
     * @return source - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取去向
     *
     * @return termini - 去向
     */
    public String getTermini() {
        return termini;
    }

    /**
     * 设置去向
     *
     * @param termini 去向
     */
    public void setTermini(String termini) {
        this.termini = termini == null ? null : termini.trim();
    }

    /**
     * 获取执行顺序
     *
     * @return sequence - 执行顺序
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置执行顺序
     *
     * @param sequence 执行顺序
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 获取执行（分润）金额，分
     *
     * @return amount - 执行（分润）金额，分
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置执行（分润）金额，分
     *
     * @param amount 执行（分润）金额，分
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取执行状态
     *
     * @return state - 执行状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置执行状态
     *
     * @param state 执行状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
     * 获取调用转账服务请求号
     *
     * @return req_id - 调用转账服务请求号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置调用转账服务请求号
     *
     * @param reqId 调用转账服务请求号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取调用转账服务回话号
     *
     * @return gid - 调用转账服务回话号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置调用转账服务回话号
     *
     * @param gid 调用转账服务回话号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取商户ID
     *
     * @return partner_id - 商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户ID
     *
     * @param partnerId 商户ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取外部商户号
     *
     * @return merch_order_no - 外部商户号
     */
    public String getMerchOrderNo() {
        return merchOrderNo;
    }

    /**
     * 设置外部商户号
     *
     * @param merchOrderNo 外部商户号
     */
    public void setMerchOrderNo(String merchOrderNo) {
        this.merchOrderNo = merchOrderNo == null ? null : merchOrderNo.trim();
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
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
        sb.append(", taskRecordId=").append(taskRecordId);
        sb.append(", outOrderNo=").append(outOrderNo);
        sb.append(", source=").append(source);
        sb.append(", termini=").append(termini);
        sb.append(", sequence=").append(sequence);
        sb.append(", amount=").append(amount);
        sb.append(", state=").append(state);
        sb.append(", memo=").append(memo);
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchOrderNo=").append(merchOrderNo);
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
        ActionExecuteRecordDO other = (ActionExecuteRecordDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskRecordId() == null ? other.getTaskRecordId() == null : this.getTaskRecordId().equals(other.getTaskRecordId()))
            && (this.getOutOrderNo() == null ? other.getOutOrderNo() == null : this.getOutOrderNo().equals(other.getOutOrderNo()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getTermini() == null ? other.getTermini() == null : this.getTermini().equals(other.getTermini()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchOrderNo() == null ? other.getMerchOrderNo() == null : this.getMerchOrderNo().equals(other.getMerchOrderNo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskRecordId() == null) ? 0 : getTaskRecordId().hashCode());
        result = prime * result + ((getOutOrderNo() == null) ? 0 : getOutOrderNo().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getTermini() == null) ? 0 : getTermini().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchOrderNo() == null) ? 0 : getMerchOrderNo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}