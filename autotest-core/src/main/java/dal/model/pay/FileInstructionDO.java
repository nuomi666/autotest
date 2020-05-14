package dal.model.pay;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "file_instruction")
public class FileInstructionDO implements Serializable {
    /**
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 充值流水号
     */
    @Column(name = "biz_no")
    private String bizNo;

    /**
     * 请求流水号
     */
    @Column(name = "req_id")
    private String reqId;

    private String gid;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 平台商户号
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 平台商户订单号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 系统编码
     */
    @Column(name = "sys_code")
    private String sysCode;

    /**
     * 业务方批次号
     */
    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 文件操作类型
     */
    private String type;

    /**
     * 文件路径
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 内部流水号
     */
    @Column(name = "serial_no")
    private String serialNo;

    /**
     * 操作时间
     */
    @Column(name = "operate_date")
    private Date operateDate;

    /**
     * 参数json
     */
    private String params;

    /**
     * 结果（可为二进制字符串文件，可为json）
     */
    private String result;

    private String remittance;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 支付节点状态
     */
    private String state;

    /**
     * 结果码
     */
    private String code;

    /**
     * 运行时描述
     */
    @Column(name = "run_memo")
    private String runMemo;

    /**
     * 是否回执
     */
    private String receipt;

    /**
     * 支付描述
     */
    private String description;

    /**
     * 运行时描述
     */
    private String memo;

    /**
     * 外部数据域（原样返回、仅存储）
     */
    @Column(name = "externalMetaData")
    private String externalmetadata;

    /**
     * 扩展上下文
     */
    @Column(name = "extension_context")
    private String extensionContext;

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
     * 获取充值流水号
     *
     * @return biz_no - 充值流水号
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 设置充值流水号
     *
     * @param bizNo 充值流水号
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 获取请求流水号
     *
     * @return req_id - 请求流水号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求流水号
     *
     * @param reqId 请求流水号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
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
     * 获取平台商户号
     *
     * @return plat_partner_id - 平台商户号
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户号
     *
     * @param platPartnerId 平台商户号
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取平台商户订单号
     *
     * @return plat_merchant_order_no - 平台商户订单号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台商户订单号
     *
     * @param platMerchantOrderNo 平台商户订单号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
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
     * 获取系统编码
     *
     * @return sys_code - 系统编码
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * 设置系统编码
     *
     * @param sysCode 系统编码
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode == null ? null : sysCode.trim();
    }

    /**
     * 获取业务方批次号
     *
     * @return batch_no - 业务方批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置业务方批次号
     *
     * @param batchNo 业务方批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * 获取文件操作类型
     *
     * @return type - 文件操作类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置文件操作类型
     *
     * @param type 文件操作类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取文件路径
     *
     * @return file_path - 文件路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置文件路径
     *
     * @param filePath 文件路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * 获取内部流水号
     *
     * @return serial_no - 内部流水号
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 设置内部流水号
     *
     * @param serialNo 内部流水号
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    /**
     * 获取操作时间
     *
     * @return operate_date - 操作时间
     */
    public Date getOperateDate() {
        return operateDate;
    }

    /**
     * 设置操作时间
     *
     * @param operateDate 操作时间
     */
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * 获取参数json
     *
     * @return params - 参数json
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置参数json
     *
     * @param params 参数json
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * 获取结果（可为二进制字符串文件，可为json）
     *
     * @return result - 结果（可为二进制字符串文件，可为json）
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置结果（可为二进制字符串文件，可为json）
     *
     * @param result 结果（可为二进制字符串文件，可为json）
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * @return remittance
     */
    public String getRemittance() {
        return remittance;
    }

    /**
     * @param remittance
     */
    public void setRemittance(String remittance) {
        this.remittance = remittance == null ? null : remittance.trim();
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取支付状态
     *
     * @return status - 支付状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置支付状态
     *
     * @param status 支付状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取支付节点状态
     *
     * @return state - 支付节点状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置支付节点状态
     *
     * @param state 支付节点状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取结果码
     *
     * @return code - 结果码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置结果码
     *
     * @param code 结果码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取运行时描述
     *
     * @return run_memo - 运行时描述
     */
    public String getRunMemo() {
        return runMemo;
    }

    /**
     * 设置运行时描述
     *
     * @param runMemo 运行时描述
     */
    public void setRunMemo(String runMemo) {
        this.runMemo = runMemo == null ? null : runMemo.trim();
    }

    /**
     * 获取是否回执
     *
     * @return receipt - 是否回执
     */
    public String getReceipt() {
        return receipt;
    }

    /**
     * 设置是否回执
     *
     * @param receipt 是否回执
     */
    public void setReceipt(String receipt) {
        this.receipt = receipt == null ? null : receipt.trim();
    }

    /**
     * 获取支付描述
     *
     * @return description - 支付描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置支付描述
     *
     * @param description 支付描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取运行时描述
     *
     * @return memo - 运行时描述
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置运行时描述
     *
     * @param memo 运行时描述
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取外部数据域（原样返回、仅存储）
     *
     * @return externalMetaData - 外部数据域（原样返回、仅存储）
     */
    public String getExternalmetadata() {
        return externalmetadata;
    }

    /**
     * 设置外部数据域（原样返回、仅存储）
     *
     * @param externalmetadata 外部数据域（原样返回、仅存储）
     */
    public void setExternalmetadata(String externalmetadata) {
        this.externalmetadata = externalmetadata == null ? null : externalmetadata.trim();
    }

    /**
     * 获取扩展上下文
     *
     * @return extension_context - 扩展上下文
     */
    public String getExtensionContext() {
        return extensionContext;
    }

    /**
     * 设置扩展上下文
     *
     * @param extensionContext 扩展上下文
     */
    public void setExtensionContext(String extensionContext) {
        this.extensionContext = extensionContext == null ? null : extensionContext.trim();
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
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", fileName=").append(fileName);
        sb.append(", sysCode=").append(sysCode);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", type=").append(type);
        sb.append(", filePath=").append(filePath);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", operateDate=").append(operateDate);
        sb.append(", params=").append(params);
        sb.append(", result=").append(result);
        sb.append(", remittance=").append(remittance);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", status=").append(status);
        sb.append(", state=").append(state);
        sb.append(", code=").append(code);
        sb.append(", runMemo=").append(runMemo);
        sb.append(", receipt=").append(receipt);
        sb.append(", description=").append(description);
        sb.append(", memo=").append(memo);
        sb.append(", externalmetadata=").append(externalmetadata);
        sb.append(", extensionContext=").append(extensionContext);
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
        FileInstructionDO other = (FileInstructionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizNo() == null ? other.getBizNo() == null : this.getBizNo().equals(other.getBizNo()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getSysCode() == null ? other.getSysCode() == null : this.getSysCode().equals(other.getSysCode()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getOperateDate() == null ? other.getOperateDate() == null : this.getOperateDate().equals(other.getOperateDate()))
            && (this.getParams() == null ? other.getParams() == null : this.getParams().equals(other.getParams()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getRemittance() == null ? other.getRemittance() == null : this.getRemittance().equals(other.getRemittance()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getRunMemo() == null ? other.getRunMemo() == null : this.getRunMemo().equals(other.getRunMemo()))
            && (this.getReceipt() == null ? other.getReceipt() == null : this.getReceipt().equals(other.getReceipt()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getExternalmetadata() == null ? other.getExternalmetadata() == null : this.getExternalmetadata().equals(other.getExternalmetadata()))
            && (this.getExtensionContext() == null ? other.getExtensionContext() == null : this.getExtensionContext().equals(other.getExtensionContext()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizNo() == null) ? 0 : getBizNo().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getSysCode() == null) ? 0 : getSysCode().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getOperateDate() == null) ? 0 : getOperateDate().hashCode());
        result = prime * result + ((getParams() == null) ? 0 : getParams().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getRemittance() == null) ? 0 : getRemittance().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRunMemo() == null) ? 0 : getRunMemo().hashCode());
        result = prime * result + ((getReceipt() == null) ? 0 : getReceipt().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getExternalmetadata() == null) ? 0 : getExternalmetadata().hashCode());
        result = prime * result + ((getExtensionContext() == null) ? 0 : getExtensionContext().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}