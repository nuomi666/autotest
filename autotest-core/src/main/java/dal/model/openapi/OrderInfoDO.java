package dal.model.openapi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "order_info")
public class OrderInfoDO implements Serializable {
    @Id
    private Long identity;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 服务名
     */
    private String service;

    /**
     * 服务版本号
     */
    private String version;

    /**
     * 重定向服务回调商户地址
     */
    @Column(name = "return_url")
    private String returnUrl;

    /**
     * 异步通知地址
     */
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 全局id
     */
    private String gid;

    /**
     * 请求号
     */
    @Column(name = "req_id")
    private String reqId;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    /**
     * 请求参数内容
     */
    @Column(name = "request_data")
    private String requestData;

    private static final long serialVersionUID = 1L;

    /**
     * @return identity
     */
    public Long getIdentity() {
        return identity;
    }

    /**
     * @param identity
     */
    public void setIdentity(Long identity) {
        this.identity = identity;
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
     * 获取商户号
     *
     * @return partner_id - 商户号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户号
     *
     * @param partnerId 商户号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取服务名
     *
     * @return service - 服务名
     */
    public String getService() {
        return service;
    }

    /**
     * 设置服务名
     *
     * @param service 服务名
     */
    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    /**
     * 获取服务版本号
     *
     * @return version - 服务版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置服务版本号
     *
     * @param version 服务版本号
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 获取重定向服务回调商户地址
     *
     * @return return_url - 重定向服务回调商户地址
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * 设置重定向服务回调商户地址
     *
     * @param returnUrl 重定向服务回调商户地址
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    /**
     * 获取异步通知地址
     *
     * @return notify_url - 异步通知地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置异步通知地址
     *
     * @param notifyUrl 异步通知地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * 获取全局id
     *
     * @return gid - 全局id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局id
     *
     * @param gid 全局id
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
     * 获取请求参数内容
     *
     * @return request_data - 请求参数内容
     */
    public String getRequestData() {
        return requestData;
    }

    /**
     * 设置请求参数内容
     *
     * @param requestData 请求参数内容
     */
    public void setRequestData(String requestData) {
        this.requestData = requestData == null ? null : requestData.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", identity=").append(identity);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", service=").append(service);
        sb.append(", version=").append(version);
        sb.append(", returnUrl=").append(returnUrl);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", gid=").append(gid);
        sb.append(", reqId=").append(reqId);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append(", requestData=").append(requestData);
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
        OrderInfoDO other = (OrderInfoDO) that;
        return (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getService() == null ? other.getService() == null : this.getService().equals(other.getService()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getReturnUrl() == null ? other.getReturnUrl() == null : this.getReturnUrl().equals(other.getReturnUrl()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()))
            && (this.getRequestData() == null ? other.getRequestData() == null : this.getRequestData().equals(other.getRequestData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getService() == null) ? 0 : getService().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getReturnUrl() == null) ? 0 : getReturnUrl().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        result = prime * result + ((getRequestData() == null) ? 0 : getRequestData().hashCode());
        return result;
    }
}