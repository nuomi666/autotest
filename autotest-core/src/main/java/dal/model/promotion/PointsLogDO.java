package dal.model.promotion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "points_log")
public class PointsLogDO implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 积分ID
     */
    @Column(name = "point_id")
    private String pointId;

    /**
     * 会话号
     */
    private String gid;

    /**
     * 请求号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 平台商户ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 平台商订单号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 签约商户ID
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 积分
     */
    private Long points;

    /**
     * 指令ID
     */
    @Column(name = "instruction_id")
    private String instructionId;

    /**
     * 操作类型 ADD（增加），CLEAR（清空），SUBTRACT(减少)
     */
    private String type;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取积分ID
     *
     * @return point_id - 积分ID
     */
    public String getPointId() {
        return pointId;
    }

    /**
     * 设置积分ID
     *
     * @param pointId 积分ID
     */
    public void setPointId(String pointId) {
        this.pointId = pointId == null ? null : pointId.trim();
    }

    /**
     * 获取会话号
     *
     * @return gid - 会话号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置会话号
     *
     * @param gid 会话号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取请求号
     *
     * @return req_id - 请求号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求号
     *
     * @param reqId 请求号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取平台商户ID
     *
     * @return plat_partner_id - 平台商户ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户ID
     *
     * @param platPartnerId 平台商户ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取平台商订单号
     *
     * @return plat_merchant_order_no - 平台商订单号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台商订单号
     *
     * @param platMerchantOrderNo 平台商订单号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
    }

    /**
     * 获取签约商户ID
     *
     * @return partner_id - 签约商户ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户ID
     *
     * @param partnerId 签约商户ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取商户订单号
     *
     * @return merchant_order_no - 商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置商户订单号
     *
     * @param merchantOrderNo 商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取积分
     *
     * @return points - 积分
     */
    public Long getPoints() {
        return points;
    }

    /**
     * 设置积分
     *
     * @param points 积分
     */
    public void setPoints(Long points) {
        this.points = points;
    }

    /**
     * 获取指令ID
     *
     * @return instruction_id - 指令ID
     */
    public String getInstructionId() {
        return instructionId;
    }

    /**
     * 设置指令ID
     *
     * @param instructionId 指令ID
     */
    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId == null ? null : instructionId.trim();
    }

    /**
     * 获取操作类型 ADD（增加），CLEAR（清空），SUBTRACT(减少)
     *
     * @return type - 操作类型 ADD（增加），CLEAR（清空），SUBTRACT(减少)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置操作类型 ADD（增加），CLEAR（清空），SUBTRACT(减少)
     *
     * @param type 操作类型 ADD（增加），CLEAR（清空），SUBTRACT(减少)
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
        sb.append(", pointId=").append(pointId);
        sb.append(", gid=").append(gid);
        sb.append(", reqId=").append(reqId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", userId=").append(userId);
        sb.append(", points=").append(points);
        sb.append(", instructionId=").append(instructionId);
        sb.append(", type=").append(type);
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
        PointsLogDO other = (PointsLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPointId() == null ? other.getPointId() == null : this.getPointId().equals(other.getPointId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPoints() == null ? other.getPoints() == null : this.getPoints().equals(other.getPoints()))
            && (this.getInstructionId() == null ? other.getInstructionId() == null : this.getInstructionId().equals(other.getInstructionId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPointId() == null) ? 0 : getPointId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPoints() == null) ? 0 : getPoints().hashCode());
        result = prime * result + ((getInstructionId() == null) ? 0 : getInstructionId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}