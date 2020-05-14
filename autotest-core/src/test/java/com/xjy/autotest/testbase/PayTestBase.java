package com.xjy.autotest.testbase;

import java.util.List;
import java.util.Date;
import com.xjy.autotest.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Import;
import com.xyb.adk.common.util.money.Money;
import java.math.BigDecimal;
import dal.dao.pay.*;
import dal.model.pay.*;
import com.xjy.autotest.config.PayDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/09/29.
 */
@Service
@Import({
        PayDataSourceConfig.class
})
public class PayTestBase {

	@Autowired
	DepositInstructionDAO depositInstructionDAO;

	@Autowired
	MqMessageRecordDAO mqMessageRecordDAO;

	@Autowired
	PayNotifyTaskDAO payNotifyTaskDAO;

	@Autowired
	PaymentInstructionDAO paymentInstructionDAO;

	@Autowired
	RefundInstructionDAO refundInstructionDAO;

	@Autowired
	TransOrderRecordDAO transOrderRecordDAO;

	@Autowired
	TransferInstructionDAO transferInstructionDAO;

	@Autowired
	WithdrawInstructionDAO withdrawInstructionDAO;

	public DepositInstructionDAO getDepositInstructionDAO() {
		return this.depositInstructionDAO;
	}

	public MqMessageRecordDAO getMqMessageRecordDAO() {
		return this.mqMessageRecordDAO;
	}

	public PayNotifyTaskDAO getPayNotifyTaskDAO() {
		return this.payNotifyTaskDAO;
	}

	public PaymentInstructionDAO getPaymentInstructionDAO() {
		return this.paymentInstructionDAO;
	}

	public RefundInstructionDAO getRefundInstructionDAO() {
		return this.refundInstructionDAO;
	}

	public TransOrderRecordDAO getTransOrderRecordDAO() {
		return this.transOrderRecordDAO;
	}

	public TransferInstructionDAO getTransferInstructionDAO() {
		return this.transferInstructionDAO;
	}

	public WithdrawInstructionDAO getWithdrawInstructionDAO() {
		return this.withdrawInstructionDAO;
	}


	/**
	 * 断言deposit_instruction表数据
	 */
	public void assertDepositInstruction(DepositInstructionDO expect, DepositInstructionDO depositInstructionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			depositInstructionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != depositInstructionDO.getRawAddTime());
		expect.setRawAddTime(depositInstructionDO.getRawAddTime());
        Assertions.assertTrue(null != depositInstructionDO.getRawUpdateTime());
		expect.setRawUpdateTime(depositInstructionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, depositInstructionDO);
	}

    /**
	 * 插入deposit_instruction表数据
	 */
	public void insertDepositInstruction(DepositInstructionDO depositInstructionDO) {
		depositInstructionDAO.insert(depositInstructionDO);
	}

    /**
	 * 插入deposit_instruction表数据
	 */
	public void insertDepositInstruction(
			Long id, 
			String transType, 
			String transTag, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String merchantMode, 
			String payeeUserId, 
			Long payeeUserBalance, 
			String payeeAccountNo, 
			String linkAccountNo, 
			String relationUserTag, 
			String payeeUserTag, 
			Integer partnerRate, 
			Integer channelRate, 
			Long channelFee, 
			Long partnerFee, 
			Long payAmount, 
			Long realPayAmount, 
			Long discountAmount, 
			Date transDate, 
			String accountDay, 
			String channelBizNo, 
			String channelId, 
			String channelName, 
			String payChannel, 
			String payChannelId, 
			String payType, 
			String payInfo, 
			String paymentBizNo, 
			String accBizNo, 
			Date finishTime, 
			String payerId, 
			String orderRefundStatus, 
			String status, 
			String state, 
			String code, 
			String runMemo, 
			String receipt, 
			String description, 
			String memo, 
			String compensate, 
			String profitInfo, 
			String externalmetadata, 
			String extensionContext, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (transDate == null) {
			transDate = new Date();
		}
		if (finishTime == null) {
			finishTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		DepositInstructionDO depositInstructionDO = new DepositInstructionDO();
		depositInstructionDO.setId(id);
		depositInstructionDO.setTransType(transType);
		depositInstructionDO.setTransTag(transTag);
		depositInstructionDO.setBizNo(bizNo);
		depositInstructionDO.setReqId(reqId);
		depositInstructionDO.setGid(gid);
		depositInstructionDO.setPartnerId(partnerId);
		depositInstructionDO.setMerchantOrderNo(merchantOrderNo);
		depositInstructionDO.setPlatPartnerId(platPartnerId);
		depositInstructionDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		depositInstructionDO.setMerchantMode(merchantMode);
		depositInstructionDO.setPayeeUserId(payeeUserId);
		depositInstructionDO.setPayeeUserBalance(payeeUserBalance);
		depositInstructionDO.setPayeeAccountNo(payeeAccountNo);
		depositInstructionDO.setLinkAccountNo(linkAccountNo);
		depositInstructionDO.setRelationUserTag(relationUserTag);
		depositInstructionDO.setPayeeUserTag(payeeUserTag);
		depositInstructionDO.setPartnerRate(partnerRate);
		depositInstructionDO.setChannelRate(channelRate);
		depositInstructionDO.setChannelFee(channelFee);
		depositInstructionDO.setPartnerFee(partnerFee);
		depositInstructionDO.setPayAmount(payAmount);
		depositInstructionDO.setRealPayAmount(realPayAmount);
		depositInstructionDO.setDiscountAmount(discountAmount);
		depositInstructionDO.setTransDate(transDate);
		depositInstructionDO.setAccountDay(accountDay);
		depositInstructionDO.setChannelBizNo(channelBizNo);
		depositInstructionDO.setChannelId(channelId);
		depositInstructionDO.setChannelName(channelName);
		depositInstructionDO.setPayChannel(payChannel);
		depositInstructionDO.setPayChannelId(payChannelId);
		depositInstructionDO.setPayType(payType);
		depositInstructionDO.setPayInfo(payInfo);
		depositInstructionDO.setPaymentBizNo(paymentBizNo);
		depositInstructionDO.setAccBizNo(accBizNo);
		depositInstructionDO.setFinishTime(finishTime);
		depositInstructionDO.setPayerId(payerId);
		depositInstructionDO.setOrderRefundStatus(orderRefundStatus);
		depositInstructionDO.setStatus(status);
		depositInstructionDO.setState(state);
		depositInstructionDO.setCode(code);
		depositInstructionDO.setRunMemo(runMemo);
		depositInstructionDO.setReceipt(receipt);
		depositInstructionDO.setDescription(description);
		depositInstructionDO.setMemo(memo);
		depositInstructionDO.setCompensate(compensate);
		depositInstructionDO.setProfitInfo(profitInfo);
		depositInstructionDO.setExternalmetadata(externalmetadata);
		depositInstructionDO.setExtensionContext(extensionContext);
		depositInstructionDO.setRawAddTime(rawAddTime);
		depositInstructionDO.setRawUpdateTime(rawUpdateTime);
		depositInstructionDAO.insert(depositInstructionDO);
	}

    /**
     * 删除deposit_instruction表所有数据
     */
    public void cleanDepositInstruction() {
        DepositInstructionDOExample exam = new DepositInstructionDOExample();
        exam.createCriteria();
        depositInstructionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionById(Long id) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeUserId删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPayeeUserId(String payeeUserId) {
        if (StringUtils.isBlank(payeeUserId)){
            payeeUserId = "test_payeeUserId";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeAccountNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPayeeAccountNo(String payeeAccountNo) {
        if (StringUtils.isBlank(payeeAccountNo)){
            payeeAccountNo = "test_payeeAccountNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据linkAccountNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByLinkAccountNo(String linkAccountNo) {
        if (StringUtils.isBlank(linkAccountNo)){
            linkAccountNo = "test_linkAccountNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andLinkAccountNoEqualTo(linkAccountNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelBizNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByChannelBizNo(String channelBizNo) {
        if (StringUtils.isBlank(channelBizNo)){
            channelBizNo = "test_channelBizNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据channelName删除deposit_instruction表数据
	*/
	public void cleanDepositInstructionByChannelName(String channelName) {
        if (StringUtils.isBlank(channelName)){
            channelName = "test_channelName";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payChannelId删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPayChannelId(String payChannelId) {
        if (StringUtils.isBlank(payChannelId)){
            payChannelId = "test_payChannelId";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据paymentBizNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPaymentBizNo(String paymentBizNo) {
        if (StringUtils.isBlank(paymentBizNo)){
            paymentBizNo = "test_paymentBizNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据accBizNo删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByAccBizNo(String accBizNo) {
        if (StringUtils.isBlank(accBizNo)){
            accBizNo = "test_accBizNo";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerId删除deposit_instruction表数据
	 */
	public void cleanDepositInstructionByPayerId(String payerId) {
        if (StringUtils.isBlank(payerId)){
            payerId = "test_payerId";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayerIdEqualTo(payerId);
		depositInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除deposit_instruction表数据
	*/
	public void cleanDepositInstructionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		depositInstructionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionById(Long id) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByBizNo(String bizNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByReqId(String reqId) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByGid(String gid) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPartnerId(String partnerId) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByMerchantOrderNo(String merchantOrderNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPlatPartnerId(String platPartnerId) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeUserId查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPayeeUserId(String payeeUserId) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeAccountNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPayeeAccountNo(String payeeAccountNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据linkAccountNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByLinkAccountNo(String linkAccountNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andLinkAccountNoEqualTo(linkAccountNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelBizNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByChannelBizNo(String channelBizNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByChannelId(String channelId) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return depositInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据channelName查询deposit_instruction表数据
	*/
	public List<DepositInstructionDO> findDepositInstructionByChannelName(String channelName) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payChannelId查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPayChannelId(String payChannelId) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据paymentBizNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPaymentBizNo(String paymentBizNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据accBizNo查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByAccBizNo(String accBizNo) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerId查询deposit_instruction表数据
	 */
	public List<DepositInstructionDO> findDepositInstructionByPayerId(String payerId) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayerIdEqualTo(payerId);
		return depositInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询deposit_instruction表数据
	*/
	public List<DepositInstructionDO> findDepositInstructionByCode(String code) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return depositInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新deposit_instruction表数据
	 */
	public void updateDepositInstructionById(Long id,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据bizNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByBizNo(String bizNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据reqId更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByReqId(String reqId,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据gid更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByGid(String gid,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据partnerId更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPartnerId(String partnerId,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByMerchantOrderNo(String merchantOrderNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据platPartnerId更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPlatPartnerId(String platPartnerId,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPlatMerchantOrderNo(String platMerchantOrderNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据payeeUserId更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPayeeUserId(String payeeUserId,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据payeeAccountNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPayeeAccountNo(String payeeAccountNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据linkAccountNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByLinkAccountNo(String linkAccountNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andLinkAccountNoEqualTo(linkAccountNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据channelBizNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByChannelBizNo(String channelBizNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据channelId更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByChannelId(String channelId,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

	/**
	* 根据channelName更新deposit_instruction表数据
	*/
	public void updateDepositInstructionByChannelName(String channelName,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据payChannelId更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPayChannelId(String payChannelId,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据paymentBizNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPaymentBizNo(String paymentBizNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据accBizNo更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByAccBizNo(String accBizNo,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

    /**
	 * 根据payerId更新deposit_instruction表数据
	 */
	public void updateDepositInstructionByPayerId(String payerId,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andPayerIdEqualTo(payerId);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

	/**
	* 根据code更新deposit_instruction表数据
	*/
	public void updateDepositInstructionByCode(String code,DepositInstructionDO depositInstructionDO) {
		DepositInstructionDOExample exam = new DepositInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		depositInstructionDAO.updateByExample(depositInstructionDO, exam);
	}

	/**
	 * 断言mq_message_record表数据
	 */
	public void assertMqMessageRecord(MqMessageRecordDO expect, MqMessageRecordDO mqMessageRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			mqMessageRecordDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != mqMessageRecordDO.getRawAddTime());
		expect.setRawAddTime(mqMessageRecordDO.getRawAddTime());
        Assertions.assertTrue(null != mqMessageRecordDO.getRawUpdateTime());
		expect.setRawUpdateTime(mqMessageRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, mqMessageRecordDO);
	}

    /**
	 * 插入mq_message_record表数据
	 */
	public void insertMqMessageRecord(MqMessageRecordDO mqMessageRecordDO) {
		mqMessageRecordDAO.insert(mqMessageRecordDO);
	}

    /**
	 * 插入mq_message_record表数据
	 */
	public void insertMqMessageRecord(
			Long id, 
			String bizNo, 
			String transType, 
			String transTag, 
			String event, 
			String topic, 
			String toSystem, 
			String gid, 
			String reqId, 
			String mqData, 
			String status, 
			String description, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MqMessageRecordDO mqMessageRecordDO = new MqMessageRecordDO();
		mqMessageRecordDO.setId(id);
		mqMessageRecordDO.setBizNo(bizNo);
		mqMessageRecordDO.setTransType(transType);
		mqMessageRecordDO.setTransTag(transTag);
		mqMessageRecordDO.setEvent(event);
		mqMessageRecordDO.setTopic(topic);
		mqMessageRecordDO.setToSystem(toSystem);
		mqMessageRecordDO.setGid(gid);
		mqMessageRecordDO.setReqId(reqId);
		mqMessageRecordDO.setMqData(mqData);
		mqMessageRecordDO.setStatus(status);
		mqMessageRecordDO.setDescription(description);
		mqMessageRecordDO.setRawAddTime(rawAddTime);
		mqMessageRecordDO.setRawUpdateTime(rawUpdateTime);
		mqMessageRecordDAO.insert(mqMessageRecordDO);
	}

    /**
     * 删除mq_message_record表所有数据
     */
    public void cleanMqMessageRecord() {
        MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
        exam.createCriteria();
        mqMessageRecordDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除mq_message_record表数据
	 */
	public void cleanMqMessageRecordById(Long id) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		mqMessageRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除mq_message_record表数据
	 */
	public void cleanMqMessageRecordByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		mqMessageRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除mq_message_record表数据
	 */
	public void cleanMqMessageRecordByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		mqMessageRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除mq_message_record表数据
	 */
	public void cleanMqMessageRecordByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		mqMessageRecordDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询mq_message_record表数据
	 */
	public List<MqMessageRecordDO> findMqMessageRecordById(Long id) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return mqMessageRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询mq_message_record表数据
	 */
	public List<MqMessageRecordDO> findMqMessageRecordByBizNo(String bizNo) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return mqMessageRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询mq_message_record表数据
	 */
	public List<MqMessageRecordDO> findMqMessageRecordByGid(String gid) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return mqMessageRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询mq_message_record表数据
	 */
	public List<MqMessageRecordDO> findMqMessageRecordByReqId(String reqId) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return mqMessageRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新mq_message_record表数据
	 */
	public void updateMqMessageRecordById(Long id,MqMessageRecordDO mqMessageRecordDO) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		mqMessageRecordDAO.updateByExample(mqMessageRecordDO, exam);
	}

    /**
	 * 根据bizNo更新mq_message_record表数据
	 */
	public void updateMqMessageRecordByBizNo(String bizNo,MqMessageRecordDO mqMessageRecordDO) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		mqMessageRecordDAO.updateByExample(mqMessageRecordDO, exam);
	}

    /**
	 * 根据gid更新mq_message_record表数据
	 */
	public void updateMqMessageRecordByGid(String gid,MqMessageRecordDO mqMessageRecordDO) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		mqMessageRecordDAO.updateByExample(mqMessageRecordDO, exam);
	}

    /**
	 * 根据reqId更新mq_message_record表数据
	 */
	public void updateMqMessageRecordByReqId(String reqId,MqMessageRecordDO mqMessageRecordDO) {
		MqMessageRecordDOExample exam = new MqMessageRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		mqMessageRecordDAO.updateByExample(mqMessageRecordDO, exam);
	}

	/**
	 * 断言pay_notify_task表数据
	 */
	public void assertPayNotifyTask(PayNotifyTaskDO expect, PayNotifyTaskDO payNotifyTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			payNotifyTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != payNotifyTaskDO.getRawAddTime());
		expect.setRawAddTime(payNotifyTaskDO.getRawAddTime());
        Assertions.assertTrue(null != payNotifyTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(payNotifyTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, payNotifyTaskDO);
	}

    /**
	 * 插入pay_notify_task表数据
	 */
	public void insertPayNotifyTask(PayNotifyTaskDO payNotifyTaskDO) {
		payNotifyTaskDAO.insert(payNotifyTaskDO);
	}

    /**
	 * 插入pay_notify_task表数据
	 */
	public void insertPayNotifyTask(
			Long id, 
			String bizNo, 
			String notifyCategory, 
			String notifyType, 
			String notifyGroup, 
			String notifyVersion, 
			String notifyUrl, 
			String status, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String detail, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PayNotifyTaskDO payNotifyTaskDO = new PayNotifyTaskDO();
		payNotifyTaskDO.setId(id);
		payNotifyTaskDO.setBizNo(bizNo);
		payNotifyTaskDO.setNotifyCategory(notifyCategory);
		payNotifyTaskDO.setNotifyType(notifyType);
		payNotifyTaskDO.setNotifyGroup(notifyGroup);
		payNotifyTaskDO.setNotifyVersion(notifyVersion);
		payNotifyTaskDO.setNotifyUrl(notifyUrl);
		payNotifyTaskDO.setStatus(status);
		payNotifyTaskDO.setRetryCount(retryCount);
		payNotifyTaskDO.setMaxRetryCount(maxRetryCount);
		payNotifyTaskDO.setDetail(detail);
		payNotifyTaskDO.setRawAddTime(rawAddTime);
		payNotifyTaskDO.setRawUpdateTime(rawUpdateTime);
		payNotifyTaskDAO.insert(payNotifyTaskDO);
	}

    /**
     * 删除pay_notify_task表所有数据
     */
    public void cleanPayNotifyTask() {
        PayNotifyTaskDOExample exam = new PayNotifyTaskDOExample();
        exam.createCriteria();
        payNotifyTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除pay_notify_task表数据
	 */
	public void cleanPayNotifyTaskById(Long id) {
		PayNotifyTaskDOExample exam = new PayNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		payNotifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除pay_notify_task表数据
	 */
	public void cleanPayNotifyTaskByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		PayNotifyTaskDOExample exam = new PayNotifyTaskDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		payNotifyTaskDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询pay_notify_task表数据
	 */
	public List<PayNotifyTaskDO> findPayNotifyTaskById(Long id) {
		PayNotifyTaskDOExample exam = new PayNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return payNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询pay_notify_task表数据
	 */
	public List<PayNotifyTaskDO> findPayNotifyTaskByBizNo(String bizNo) {
		PayNotifyTaskDOExample exam = new PayNotifyTaskDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return payNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新pay_notify_task表数据
	 */
	public void updatePayNotifyTaskById(Long id,PayNotifyTaskDO payNotifyTaskDO) {
		PayNotifyTaskDOExample exam = new PayNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		payNotifyTaskDAO.updateByExample(payNotifyTaskDO, exam);
	}

    /**
	 * 根据bizNo更新pay_notify_task表数据
	 */
	public void updatePayNotifyTaskByBizNo(String bizNo,PayNotifyTaskDO payNotifyTaskDO) {
		PayNotifyTaskDOExample exam = new PayNotifyTaskDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		payNotifyTaskDAO.updateByExample(payNotifyTaskDO, exam);
	}

	/**
	 * 断言payment_instruction表数据
	 */
	public void assertPaymentInstruction(PaymentInstructionDO expect, PaymentInstructionDO paymentInstructionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			paymentInstructionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != paymentInstructionDO.getRawAddTime());
		expect.setRawAddTime(paymentInstructionDO.getRawAddTime());
        Assertions.assertTrue(null != paymentInstructionDO.getRawUpdateTime());
		expect.setRawUpdateTime(paymentInstructionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, paymentInstructionDO);
	}

    /**
	 * 插入payment_instruction表数据
	 */
	public void insertPaymentInstruction(PaymentInstructionDO paymentInstructionDO) {
		paymentInstructionDAO.insert(paymentInstructionDO);
	}

    /**
	 * 插入payment_instruction表数据
	 */
	public void insertPaymentInstruction(
			Long id, 
			String transType, 
			String transTag, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String merchantMode, 
			String redirectUrl, 
			String payerUserId, 
			String payeeUserId, 
			String payerAccountNo, 
			String relationAccountNo, 
			String payeeAccountNo, 
			String payerUserTag, 
			String relationUserTag, 
			String payeeUserTag, 
			Integer partnerRate, 
			Integer channelRate, 
			Long channelFee, 
			Long partnerFee, 
			Long payAmount, 
			Long realPayAmount, 
			Long discountAmount, 
			Long payerBalance, 
			Long relationBalance, 
			Long payeeBalance, 
			String channelBizNo, 
			String channelId, 
			String channelName, 
			String payChannel, 
			String payChannelId, 
			String payType, 
			String payInfo, 
			String payerAccBizNo, 
			String relationAccBizNo, 
			String payeeAccBizNo, 
			Date payerTransDate, 
			Date relationTransDate, 
			Date payeeTransDate, 
			String paymentBizNo, 
			String accountDay, 
			Date finishTime, 
			String payerId, 
			String orderRefundStatus, 
			String status, 
			String state, 
			String code, 
			String runMemo, 
			String receipt, 
			String description, 
			String memo, 
			String compensate, 
			String profitInfo, 
			String externalmetadata, 
			String extensionContext, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (payerTransDate == null) {
			payerTransDate = new Date();
		}
		if (relationTransDate == null) {
			relationTransDate = new Date();
		}
		if (payeeTransDate == null) {
			payeeTransDate = new Date();
		}
		if (finishTime == null) {
			finishTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PaymentInstructionDO paymentInstructionDO = new PaymentInstructionDO();
		paymentInstructionDO.setId(id);
		paymentInstructionDO.setTransType(transType);
		paymentInstructionDO.setTransTag(transTag);
		paymentInstructionDO.setBizNo(bizNo);
		paymentInstructionDO.setReqId(reqId);
		paymentInstructionDO.setGid(gid);
		paymentInstructionDO.setPartnerId(partnerId);
		paymentInstructionDO.setMerchantOrderNo(merchantOrderNo);
		paymentInstructionDO.setPlatPartnerId(platPartnerId);
		paymentInstructionDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		paymentInstructionDO.setMerchantMode(merchantMode);
		paymentInstructionDO.setRedirectUrl(redirectUrl);
		paymentInstructionDO.setPayerUserId(payerUserId);
		paymentInstructionDO.setPayeeUserId(payeeUserId);
		paymentInstructionDO.setPayerAccountNo(payerAccountNo);
		paymentInstructionDO.setRelationAccountNo(relationAccountNo);
		paymentInstructionDO.setPayeeAccountNo(payeeAccountNo);
		paymentInstructionDO.setPayerUserTag(payerUserTag);
		paymentInstructionDO.setRelationUserTag(relationUserTag);
		paymentInstructionDO.setPayeeUserTag(payeeUserTag);
		paymentInstructionDO.setPartnerRate(partnerRate);
		paymentInstructionDO.setChannelRate(channelRate);
		paymentInstructionDO.setChannelFee(channelFee);
		paymentInstructionDO.setPartnerFee(partnerFee);
		paymentInstructionDO.setPayAmount(payAmount);
		paymentInstructionDO.setRealPayAmount(realPayAmount);
		paymentInstructionDO.setDiscountAmount(discountAmount);
		paymentInstructionDO.setPayerBalance(payerBalance);
		paymentInstructionDO.setRelationBalance(relationBalance);
		paymentInstructionDO.setPayeeBalance(payeeBalance);
		paymentInstructionDO.setChannelBizNo(channelBizNo);
		paymentInstructionDO.setChannelId(channelId);
		paymentInstructionDO.setChannelName(channelName);
		paymentInstructionDO.setPayChannel(payChannel);
		paymentInstructionDO.setPayChannelId(payChannelId);
		paymentInstructionDO.setPayType(payType);
		paymentInstructionDO.setPayInfo(payInfo);
		paymentInstructionDO.setPayerAccBizNo(payerAccBizNo);
		paymentInstructionDO.setRelationAccBizNo(relationAccBizNo);
		paymentInstructionDO.setPayeeAccBizNo(payeeAccBizNo);
		paymentInstructionDO.setPayerTransDate(payerTransDate);
		paymentInstructionDO.setRelationTransDate(relationTransDate);
		paymentInstructionDO.setPayeeTransDate(payeeTransDate);
		paymentInstructionDO.setPaymentBizNo(paymentBizNo);
		paymentInstructionDO.setAccountDay(accountDay);
		paymentInstructionDO.setFinishTime(finishTime);
		paymentInstructionDO.setPayerId(payerId);
		paymentInstructionDO.setOrderRefundStatus(orderRefundStatus);
		paymentInstructionDO.setStatus(status);
		paymentInstructionDO.setState(state);
		paymentInstructionDO.setCode(code);
		paymentInstructionDO.setRunMemo(runMemo);
		paymentInstructionDO.setReceipt(receipt);
		paymentInstructionDO.setDescription(description);
		paymentInstructionDO.setMemo(memo);
		paymentInstructionDO.setCompensate(compensate);
		paymentInstructionDO.setProfitInfo(profitInfo);
		paymentInstructionDO.setExternalmetadata(externalmetadata);
		paymentInstructionDO.setExtensionContext(extensionContext);
		paymentInstructionDO.setRawAddTime(rawAddTime);
		paymentInstructionDO.setRawUpdateTime(rawUpdateTime);
		paymentInstructionDAO.insert(paymentInstructionDO);
	}

    /**
     * 删除payment_instruction表所有数据
     */
    public void cleanPaymentInstruction() {
        PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
        exam.createCriteria();
        paymentInstructionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionById(Long id) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerUserId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayerUserId(String payerUserId) {
        if (StringUtils.isBlank(payerUserId)){
            payerUserId = "test_payerUserId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeUserId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayeeUserId(String payeeUserId) {
        if (StringUtils.isBlank(payeeUserId)){
            payeeUserId = "test_payeeUserId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerAccountNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayerAccountNo(String payerAccountNo) {
        if (StringUtils.isBlank(payerAccountNo)){
            payerAccountNo = "test_payerAccountNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据relationAccountNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByRelationAccountNo(String relationAccountNo) {
        if (StringUtils.isBlank(relationAccountNo)){
            relationAccountNo = "test_relationAccountNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andRelationAccountNoEqualTo(relationAccountNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeAccountNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayeeAccountNo(String payeeAccountNo) {
        if (StringUtils.isBlank(payeeAccountNo)){
            payeeAccountNo = "test_payeeAccountNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelBizNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByChannelBizNo(String channelBizNo) {
        if (StringUtils.isBlank(channelBizNo)){
            channelBizNo = "test_channelBizNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据channelName删除payment_instruction表数据
	*/
	public void cleanPaymentInstructionByChannelName(String channelName) {
        if (StringUtils.isBlank(channelName)){
            channelName = "test_channelName";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payChannelId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayChannelId(String payChannelId) {
        if (StringUtils.isBlank(payChannelId)){
            payChannelId = "test_payChannelId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerAccBizNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayerAccBizNo(String payerAccBizNo) {
        if (StringUtils.isBlank(payerAccBizNo)){
            payerAccBizNo = "test_payerAccBizNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerAccBizNoEqualTo(payerAccBizNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据relationAccBizNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByRelationAccBizNo(String relationAccBizNo) {
        if (StringUtils.isBlank(relationAccBizNo)){
            relationAccBizNo = "test_relationAccBizNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andRelationAccBizNoEqualTo(relationAccBizNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeAccBizNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayeeAccBizNo(String payeeAccBizNo) {
        if (StringUtils.isBlank(payeeAccBizNo)){
            payeeAccBizNo = "test_payeeAccBizNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeAccBizNoEqualTo(payeeAccBizNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据paymentBizNo删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPaymentBizNo(String paymentBizNo) {
        if (StringUtils.isBlank(paymentBizNo)){
            paymentBizNo = "test_paymentBizNo";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerId删除payment_instruction表数据
	 */
	public void cleanPaymentInstructionByPayerId(String payerId) {
        if (StringUtils.isBlank(payerId)){
            payerId = "test_payerId";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerIdEqualTo(payerId);
		paymentInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除payment_instruction表数据
	*/
	public void cleanPaymentInstructionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		paymentInstructionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionById(Long id) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByBizNo(String bizNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByReqId(String reqId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByGid(String gid) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPartnerId(String partnerId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByMerchantOrderNo(String merchantOrderNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPlatPartnerId(String platPartnerId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerUserId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayerUserId(String payerUserId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeUserId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayeeUserId(String payeeUserId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerAccountNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayerAccountNo(String payerAccountNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据relationAccountNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByRelationAccountNo(String relationAccountNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andRelationAccountNoEqualTo(relationAccountNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeAccountNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayeeAccountNo(String payeeAccountNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelBizNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByChannelBizNo(String channelBizNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByChannelId(String channelId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return paymentInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据channelName查询payment_instruction表数据
	*/
	public List<PaymentInstructionDO> findPaymentInstructionByChannelName(String channelName) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payChannelId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayChannelId(String payChannelId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerAccBizNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayerAccBizNo(String payerAccBizNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerAccBizNoEqualTo(payerAccBizNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据relationAccBizNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByRelationAccBizNo(String relationAccBizNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andRelationAccBizNoEqualTo(relationAccBizNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeAccBizNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayeeAccBizNo(String payeeAccBizNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeAccBizNoEqualTo(payeeAccBizNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据paymentBizNo查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPaymentBizNo(String paymentBizNo) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerId查询payment_instruction表数据
	 */
	public List<PaymentInstructionDO> findPaymentInstructionByPayerId(String payerId) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerIdEqualTo(payerId);
		return paymentInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询payment_instruction表数据
	*/
	public List<PaymentInstructionDO> findPaymentInstructionByCode(String code) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return paymentInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新payment_instruction表数据
	 */
	public void updatePaymentInstructionById(Long id,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据bizNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByBizNo(String bizNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据reqId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByReqId(String reqId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据gid更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByGid(String gid,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据partnerId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPartnerId(String partnerId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByMerchantOrderNo(String merchantOrderNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据platPartnerId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPlatPartnerId(String platPartnerId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPlatMerchantOrderNo(String platMerchantOrderNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payerUserId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayerUserId(String payerUserId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payeeUserId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayeeUserId(String payeeUserId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payerAccountNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayerAccountNo(String payerAccountNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据relationAccountNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByRelationAccountNo(String relationAccountNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andRelationAccountNoEqualTo(relationAccountNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payeeAccountNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayeeAccountNo(String payeeAccountNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据channelBizNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByChannelBizNo(String channelBizNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据channelId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByChannelId(String channelId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

	/**
	* 根据channelName更新payment_instruction表数据
	*/
	public void updatePaymentInstructionByChannelName(String channelName,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payChannelId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayChannelId(String payChannelId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payerAccBizNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayerAccBizNo(String payerAccBizNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerAccBizNoEqualTo(payerAccBizNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据relationAccBizNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByRelationAccBizNo(String relationAccBizNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andRelationAccBizNoEqualTo(relationAccBizNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payeeAccBizNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayeeAccBizNo(String payeeAccBizNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayeeAccBizNoEqualTo(payeeAccBizNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据paymentBizNo更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPaymentBizNo(String paymentBizNo,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

    /**
	 * 根据payerId更新payment_instruction表数据
	 */
	public void updatePaymentInstructionByPayerId(String payerId,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andPayerIdEqualTo(payerId);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

	/**
	* 根据code更新payment_instruction表数据
	*/
	public void updatePaymentInstructionByCode(String code,PaymentInstructionDO paymentInstructionDO) {
		PaymentInstructionDOExample exam = new PaymentInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		paymentInstructionDAO.updateByExample(paymentInstructionDO, exam);
	}

	/**
	 * 断言refund_instruction表数据
	 */
	public void assertRefundInstruction(RefundInstructionDO expect, RefundInstructionDO refundInstructionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			refundInstructionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != refundInstructionDO.getRawAddTime());
		expect.setRawAddTime(refundInstructionDO.getRawAddTime());
        Assertions.assertTrue(null != refundInstructionDO.getRawUpdateTime());
		expect.setRawUpdateTime(refundInstructionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, refundInstructionDO);
	}

    /**
	 * 插入refund_instruction表数据
	 */
	public void insertRefundInstruction(RefundInstructionDO refundInstructionDO) {
		refundInstructionDAO.insert(refundInstructionDO);
	}

    /**
	 * 插入refund_instruction表数据
	 */
	public void insertRefundInstruction(
			Long id, 
			String transType, 
			String transTag, 
			String refundType, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String merchantMode, 
			String redirectUrl, 
			String paymentBizNo, 
			String channelId, 
			String channelRefundNo, 
			String payerUserId, 
			Long payerUserBalance, 
			String payeeUserId, 
			Long payeeUserBalance, 
			String payerAccountNo, 
			String relationAccountNo, 
			String payeeAccountNo, 
			Long payAmount, 
			Long refundAmount, 
			String payerAccBizNo, 
			String relationAccBizNo, 
			String payeeAccBizNo, 
			Date payerTransDate, 
			Date relationTransDate, 
			Date payeeTransDate, 
			String refundCoupon, 
			String couponInstructionId, 
			String unFreezeCode, 
			Date finishTime, 
			String status, 
			String state, 
			String code, 
			String runMemo, 
			String receipt, 
			String description, 
			String memo, 
			String compensate, 
			String externalMetaData, 
			String extensionContext, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (payerTransDate == null) {
			payerTransDate = new Date();
		}
		if (relationTransDate == null) {
			relationTransDate = new Date();
		}
		if (payeeTransDate == null) {
			payeeTransDate = new Date();
		}
		if (finishTime == null) {
			finishTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		RefundInstructionDO refundInstructionDO = new RefundInstructionDO();
		refundInstructionDO.setId(id);
		refundInstructionDO.setTransType(transType);
		refundInstructionDO.setTransTag(transTag);
		refundInstructionDO.setRefundType(refundType);
		refundInstructionDO.setBizNo(bizNo);
		refundInstructionDO.setReqId(reqId);
		refundInstructionDO.setGid(gid);
		refundInstructionDO.setPartnerId(partnerId);
		refundInstructionDO.setMerchantOrderNo(merchantOrderNo);
		refundInstructionDO.setPlatPartnerId(platPartnerId);
		refundInstructionDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		refundInstructionDO.setMerchantMode(merchantMode);
		refundInstructionDO.setRedirectUrl(redirectUrl);
		refundInstructionDO.setPaymentBizNo(paymentBizNo);
		refundInstructionDO.setChannelId(channelId);
		refundInstructionDO.setChannelRefundNo(channelRefundNo);
		refundInstructionDO.setPayerUserId(payerUserId);
		refundInstructionDO.setPayerUserBalance(payerUserBalance);
		refundInstructionDO.setPayeeUserId(payeeUserId);
		refundInstructionDO.setPayeeUserBalance(payeeUserBalance);
		refundInstructionDO.setPayerAccountNo(payerAccountNo);
		refundInstructionDO.setRelationAccountNo(relationAccountNo);
		refundInstructionDO.setPayeeAccountNo(payeeAccountNo);
		refundInstructionDO.setPayAmount(payAmount);
		refundInstructionDO.setRefundAmount(refundAmount);
		refundInstructionDO.setPayerAccBizNo(payerAccBizNo);
		refundInstructionDO.setRelationAccBizNo(relationAccBizNo);
		refundInstructionDO.setPayeeAccBizNo(payeeAccBizNo);
		refundInstructionDO.setPayerTransDate(payerTransDate);
		refundInstructionDO.setRelationTransDate(relationTransDate);
		refundInstructionDO.setPayeeTransDate(payeeTransDate);
		refundInstructionDO.setRefundCoupon(refundCoupon);
		refundInstructionDO.setCouponInstructionId(couponInstructionId);
		refundInstructionDO.setUnFreezeCode(unFreezeCode);
		refundInstructionDO.setFinishTime(finishTime);
		refundInstructionDO.setStatus(status);
		refundInstructionDO.setState(state);
		refundInstructionDO.setCode(code);
		refundInstructionDO.setRunMemo(runMemo);
		refundInstructionDO.setReceipt(receipt);
		refundInstructionDO.setDescription(description);
		refundInstructionDO.setMemo(memo);
		refundInstructionDO.setCompensate(compensate);
		refundInstructionDO.setExternalMetaData(externalMetaData);
		refundInstructionDO.setExtensionContext(extensionContext);
		refundInstructionDO.setRawAddTime(rawAddTime);
		refundInstructionDO.setRawUpdateTime(rawUpdateTime);
		refundInstructionDAO.insert(refundInstructionDO);
	}

    /**
     * 删除refund_instruction表所有数据
     */
    public void cleanRefundInstruction() {
        RefundInstructionDOExample exam = new RefundInstructionDOExample();
        exam.createCriteria();
        refundInstructionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除refund_instruction表数据
	 */
	public void cleanRefundInstructionById(Long id) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据paymentBizNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPaymentBizNo(String paymentBizNo) {
        if (StringUtils.isBlank(paymentBizNo)){
            paymentBizNo = "test_paymentBizNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelRefundNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByChannelRefundNo(String channelRefundNo) {
        if (StringUtils.isBlank(channelRefundNo)){
            channelRefundNo = "test_channelRefundNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerUserId删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPayerUserId(String payerUserId) {
        if (StringUtils.isBlank(payerUserId)){
            payerUserId = "test_payerUserId";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeUserId删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPayeeUserId(String payeeUserId) {
        if (StringUtils.isBlank(payeeUserId)){
            payeeUserId = "test_payeeUserId";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerAccountNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPayerAccountNo(String payerAccountNo) {
        if (StringUtils.isBlank(payerAccountNo)){
            payerAccountNo = "test_payerAccountNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据relationAccountNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByRelationAccountNo(String relationAccountNo) {
        if (StringUtils.isBlank(relationAccountNo)){
            relationAccountNo = "test_relationAccountNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andRelationAccountNoEqualTo(relationAccountNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeAccountNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPayeeAccountNo(String payeeAccountNo) {
        if (StringUtils.isBlank(payeeAccountNo)){
            payeeAccountNo = "test_payeeAccountNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerAccBizNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPayerAccBizNo(String payerAccBizNo) {
        if (StringUtils.isBlank(payerAccBizNo)){
            payerAccBizNo = "test_payerAccBizNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerAccBizNoEqualTo(payerAccBizNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据relationAccBizNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByRelationAccBizNo(String relationAccBizNo) {
        if (StringUtils.isBlank(relationAccBizNo)){
            relationAccBizNo = "test_relationAccBizNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andRelationAccBizNoEqualTo(relationAccBizNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeAccBizNo删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByPayeeAccBizNo(String payeeAccBizNo) {
        if (StringUtils.isBlank(payeeAccBizNo)){
            payeeAccBizNo = "test_payeeAccBizNo";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeAccBizNoEqualTo(payeeAccBizNo);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据couponInstructionId删除refund_instruction表数据
	 */
	public void cleanRefundInstructionByCouponInstructionId(String couponInstructionId) {
        if (StringUtils.isBlank(couponInstructionId)){
            couponInstructionId = "test_couponInstructionId";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andCouponInstructionIdEqualTo(couponInstructionId);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据unFreezeCode删除refund_instruction表数据
	*/
	public void cleanRefundInstructionByUnFreezeCode(String unFreezeCode) {
        if (StringUtils.isBlank(unFreezeCode)){
            unFreezeCode = "test_unFreezeCode";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andUnFreezeCodeEqualTo(unFreezeCode);
		refundInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除refund_instruction表数据
	*/
	public void cleanRefundInstructionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		refundInstructionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionById(Long id) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByBizNo(String bizNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByReqId(String reqId) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByGid(String gid) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPartnerId(String partnerId) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByMerchantOrderNo(String merchantOrderNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPlatPartnerId(String platPartnerId) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据paymentBizNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPaymentBizNo(String paymentBizNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByChannelId(String channelId) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelRefundNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByChannelRefundNo(String channelRefundNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerUserId查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPayerUserId(String payerUserId) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeUserId查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPayeeUserId(String payeeUserId) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerAccountNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPayerAccountNo(String payerAccountNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据relationAccountNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByRelationAccountNo(String relationAccountNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andRelationAccountNoEqualTo(relationAccountNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeAccountNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPayeeAccountNo(String payeeAccountNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerAccBizNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPayerAccBizNo(String payerAccBizNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerAccBizNoEqualTo(payerAccBizNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据relationAccBizNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByRelationAccBizNo(String relationAccBizNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andRelationAccBizNoEqualTo(relationAccBizNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeAccBizNo查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByPayeeAccBizNo(String payeeAccBizNo) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeAccBizNoEqualTo(payeeAccBizNo);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据couponInstructionId查询refund_instruction表数据
	 */
	public List<RefundInstructionDO> findRefundInstructionByCouponInstructionId(String couponInstructionId) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andCouponInstructionIdEqualTo(couponInstructionId);
		return refundInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据unFreezeCode查询refund_instruction表数据
	*/
	public List<RefundInstructionDO> findRefundInstructionByUnFreezeCode(String unFreezeCode) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andUnFreezeCodeEqualTo(unFreezeCode);
		return refundInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询refund_instruction表数据
	*/
	public List<RefundInstructionDO> findRefundInstructionByCode(String code) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return refundInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新refund_instruction表数据
	 */
	public void updateRefundInstructionById(Long id,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据bizNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByBizNo(String bizNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据reqId更新refund_instruction表数据
	 */
	public void updateRefundInstructionByReqId(String reqId,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据gid更新refund_instruction表数据
	 */
	public void updateRefundInstructionByGid(String gid,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据partnerId更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPartnerId(String partnerId,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByMerchantOrderNo(String merchantOrderNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据platPartnerId更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPlatPartnerId(String platPartnerId,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPlatMerchantOrderNo(String platMerchantOrderNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据paymentBizNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPaymentBizNo(String paymentBizNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPaymentBizNoEqualTo(paymentBizNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据channelId更新refund_instruction表数据
	 */
	public void updateRefundInstructionByChannelId(String channelId,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据channelRefundNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByChannelRefundNo(String channelRefundNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据payerUserId更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPayerUserId(String payerUserId,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据payeeUserId更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPayeeUserId(String payeeUserId,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据payerAccountNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPayerAccountNo(String payerAccountNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据relationAccountNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByRelationAccountNo(String relationAccountNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andRelationAccountNoEqualTo(relationAccountNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据payeeAccountNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPayeeAccountNo(String payeeAccountNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据payerAccBizNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPayerAccBizNo(String payerAccBizNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayerAccBizNoEqualTo(payerAccBizNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据relationAccBizNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByRelationAccBizNo(String relationAccBizNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andRelationAccBizNoEqualTo(relationAccBizNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据payeeAccBizNo更新refund_instruction表数据
	 */
	public void updateRefundInstructionByPayeeAccBizNo(String payeeAccBizNo,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andPayeeAccBizNoEqualTo(payeeAccBizNo);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

    /**
	 * 根据couponInstructionId更新refund_instruction表数据
	 */
	public void updateRefundInstructionByCouponInstructionId(String couponInstructionId,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andCouponInstructionIdEqualTo(couponInstructionId);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

	/**
	* 根据unFreezeCode更新refund_instruction表数据
	*/
	public void updateRefundInstructionByUnFreezeCode(String unFreezeCode,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andUnFreezeCodeEqualTo(unFreezeCode);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

	/**
	* 根据code更新refund_instruction表数据
	*/
	public void updateRefundInstructionByCode(String code,RefundInstructionDO refundInstructionDO) {
		RefundInstructionDOExample exam = new RefundInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		refundInstructionDAO.updateByExample(refundInstructionDO, exam);
	}

	/**
	 * 断言trans_order_record表数据
	 */
	public void assertTransOrderRecord(TransOrderRecordDO expect, TransOrderRecordDO transOrderRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			transOrderRecordDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != transOrderRecordDO.getRawAddTime());
		expect.setRawAddTime(transOrderRecordDO.getRawAddTime());
        Assertions.assertTrue(null != transOrderRecordDO.getRawUpdateTime());
		expect.setRawUpdateTime(transOrderRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, transOrderRecordDO);
	}

    /**
	 * 插入trans_order_record表数据
	 */
	public void insertTransOrderRecord(TransOrderRecordDO transOrderRecordDO) {
		transOrderRecordDAO.insert(transOrderRecordDO);
	}

    /**
	 * 插入trans_order_record表数据
	 */
	public void insertTransOrderRecord(
			Long id, 
			String transType, 
			String transTag, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		TransOrderRecordDO transOrderRecordDO = new TransOrderRecordDO();
		transOrderRecordDO.setId(id);
		transOrderRecordDO.setTransType(transType);
		transOrderRecordDO.setTransTag(transTag);
		transOrderRecordDO.setBizNo(bizNo);
		transOrderRecordDO.setReqId(reqId);
		transOrderRecordDO.setGid(gid);
		transOrderRecordDO.setPartnerId(partnerId);
		transOrderRecordDO.setMerchantOrderNo(merchantOrderNo);
		transOrderRecordDO.setPlatPartnerId(platPartnerId);
		transOrderRecordDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		transOrderRecordDO.setRawAddTime(rawAddTime);
		transOrderRecordDO.setRawUpdateTime(rawUpdateTime);
		transOrderRecordDAO.insert(transOrderRecordDO);
	}

    /**
     * 删除trans_order_record表所有数据
     */
    public void cleanTransOrderRecord() {
        TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
        exam.createCriteria();
        transOrderRecordDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordById(Long id) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		transOrderRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		transOrderRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		transOrderRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		transOrderRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		transOrderRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		transOrderRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		transOrderRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除trans_order_record表数据
	 */
	public void cleanTransOrderRecordByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		transOrderRecordDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordById(Long id) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordByBizNo(String bizNo) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordByReqId(String reqId) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordByGid(String gid) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordByPartnerId(String partnerId) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordByMerchantOrderNo(String merchantOrderNo) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordByPlatPartnerId(String platPartnerId) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询trans_order_record表数据
	 */
	public List<TransOrderRecordDO> findTransOrderRecordByPlatMerchantOrderNo(String platMerchantOrderNo) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return transOrderRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新trans_order_record表数据
	 */
	public void updateTransOrderRecordById(Long id,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

    /**
	 * 根据bizNo更新trans_order_record表数据
	 */
	public void updateTransOrderRecordByBizNo(String bizNo,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

    /**
	 * 根据reqId更新trans_order_record表数据
	 */
	public void updateTransOrderRecordByReqId(String reqId,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

    /**
	 * 根据gid更新trans_order_record表数据
	 */
	public void updateTransOrderRecordByGid(String gid,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

    /**
	 * 根据partnerId更新trans_order_record表数据
	 */
	public void updateTransOrderRecordByPartnerId(String partnerId,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新trans_order_record表数据
	 */
	public void updateTransOrderRecordByMerchantOrderNo(String merchantOrderNo,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

    /**
	 * 根据platPartnerId更新trans_order_record表数据
	 */
	public void updateTransOrderRecordByPlatPartnerId(String platPartnerId,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新trans_order_record表数据
	 */
	public void updateTransOrderRecordByPlatMerchantOrderNo(String platMerchantOrderNo,TransOrderRecordDO transOrderRecordDO) {
		TransOrderRecordDOExample exam = new TransOrderRecordDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		transOrderRecordDAO.updateByExample(transOrderRecordDO, exam);
	}

	/**
	 * 断言transfer_instruction表数据
	 */
	public void assertTransferInstruction(TransferInstructionDO expect, TransferInstructionDO transferInstructionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			transferInstructionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != transferInstructionDO.getRawAddTime());
		expect.setRawAddTime(transferInstructionDO.getRawAddTime());
        Assertions.assertTrue(null != transferInstructionDO.getRawUpdateTime());
		expect.setRawUpdateTime(transferInstructionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, transferInstructionDO);
	}

    /**
	 * 插入transfer_instruction表数据
	 */
	public void insertTransferInstruction(TransferInstructionDO transferInstructionDO) {
		transferInstructionDAO.insert(transferInstructionDO);
	}

    /**
	 * 插入transfer_instruction表数据
	 */
	public void insertTransferInstruction(
			Long id, 
			String transType, 
			String transTag, 
			String transferType, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String merchantMode, 
			String payeeUserId, 
			String payeeUserTag, 
			String payeeAccountNo, 
			Long payeeFreezeAmount, 
			String payeeFreezeCode, 
			Long payeeBalance, 
			String payerUserId, 
			String payerUserTag, 
			String payerAccountNo, 
			Long payerUnfreezeAmount, 
			String payerFreezeCode, 
			Long payerBalance, 
			Long payAmount, 
			String accBizNo, 
			Date transDate, 
			String accountDay, 
			Integer delay, 
			String batchDetail, 
			Date finishTime, 
			String status, 
			String state, 
			String code, 
			String runMemo, 
			String receipt, 
			String description, 
			String memo, 
			String externalmetadata, 
			String extensionContext, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (transDate == null) {
			transDate = new Date();
		}
		if (finishTime == null) {
			finishTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		TransferInstructionDO transferInstructionDO = new TransferInstructionDO();
		transferInstructionDO.setId(id);
		transferInstructionDO.setTransType(transType);
		transferInstructionDO.setTransTag(transTag);
		transferInstructionDO.setTransferType(transferType);
		transferInstructionDO.setBizNo(bizNo);
		transferInstructionDO.setReqId(reqId);
		transferInstructionDO.setGid(gid);
		transferInstructionDO.setPartnerId(partnerId);
		transferInstructionDO.setMerchantOrderNo(merchantOrderNo);
		transferInstructionDO.setPlatPartnerId(platPartnerId);
		transferInstructionDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		transferInstructionDO.setMerchantMode(merchantMode);
		transferInstructionDO.setPayeeUserId(payeeUserId);
		transferInstructionDO.setPayeeUserTag(payeeUserTag);
		transferInstructionDO.setPayeeAccountNo(payeeAccountNo);
		transferInstructionDO.setPayeeFreezeAmount(payeeFreezeAmount);
		transferInstructionDO.setPayeeFreezeCode(payeeFreezeCode);
		transferInstructionDO.setPayeeBalance(payeeBalance);
		transferInstructionDO.setPayerUserId(payerUserId);
		transferInstructionDO.setPayerUserTag(payerUserTag);
		transferInstructionDO.setPayerAccountNo(payerAccountNo);
		transferInstructionDO.setPayerUnfreezeAmount(payerUnfreezeAmount);
		transferInstructionDO.setPayerFreezeCode(payerFreezeCode);
		transferInstructionDO.setPayerBalance(payerBalance);
		transferInstructionDO.setPayAmount(payAmount);
		transferInstructionDO.setAccBizNo(accBizNo);
		transferInstructionDO.setTransDate(transDate);
		transferInstructionDO.setAccountDay(accountDay);
		transferInstructionDO.setDelay(delay);
		transferInstructionDO.setBatchDetail(batchDetail);
		transferInstructionDO.setFinishTime(finishTime);
		transferInstructionDO.setStatus(status);
		transferInstructionDO.setState(state);
		transferInstructionDO.setCode(code);
		transferInstructionDO.setRunMemo(runMemo);
		transferInstructionDO.setReceipt(receipt);
		transferInstructionDO.setDescription(description);
		transferInstructionDO.setMemo(memo);
		transferInstructionDO.setExternalmetadata(externalmetadata);
		transferInstructionDO.setExtensionContext(extensionContext);
		transferInstructionDO.setRawAddTime(rawAddTime);
		transferInstructionDO.setRawUpdateTime(rawUpdateTime);
		transferInstructionDAO.insert(transferInstructionDO);
	}

    /**
     * 删除transfer_instruction表所有数据
     */
    public void cleanTransferInstruction() {
        TransferInstructionDOExample exam = new TransferInstructionDOExample();
        exam.createCriteria();
        transferInstructionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionById(Long id) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeUserId删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByPayeeUserId(String payeeUserId) {
        if (StringUtils.isBlank(payeeUserId)){
            payeeUserId = "test_payeeUserId";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payeeAccountNo删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByPayeeAccountNo(String payeeAccountNo) {
        if (StringUtils.isBlank(payeeAccountNo)){
            payeeAccountNo = "test_payeeAccountNo";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据payeeFreezeCode删除transfer_instruction表数据
	*/
	public void cleanTransferInstructionByPayeeFreezeCode(String payeeFreezeCode) {
        if (StringUtils.isBlank(payeeFreezeCode)){
            payeeFreezeCode = "test_payeeFreezeCode";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeFreezeCodeEqualTo(payeeFreezeCode);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerUserId删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByPayerUserId(String payerUserId) {
        if (StringUtils.isBlank(payerUserId)){
            payerUserId = "test_payerUserId";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payerAccountNo删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByPayerAccountNo(String payerAccountNo) {
        if (StringUtils.isBlank(payerAccountNo)){
            payerAccountNo = "test_payerAccountNo";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据payerFreezeCode删除transfer_instruction表数据
	*/
	public void cleanTransferInstructionByPayerFreezeCode(String payerFreezeCode) {
        if (StringUtils.isBlank(payerFreezeCode)){
            payerFreezeCode = "test_payerFreezeCode";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerFreezeCodeEqualTo(payerFreezeCode);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据accBizNo删除transfer_instruction表数据
	 */
	public void cleanTransferInstructionByAccBizNo(String accBizNo) {
        if (StringUtils.isBlank(accBizNo)){
            accBizNo = "test_accBizNo";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		transferInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除transfer_instruction表数据
	*/
	public void cleanTransferInstructionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		transferInstructionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionById(Long id) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByBizNo(String bizNo) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByReqId(String reqId) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByGid(String gid) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByPartnerId(String partnerId) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByMerchantOrderNo(String merchantOrderNo) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByPlatPartnerId(String platPartnerId) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeUserId查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByPayeeUserId(String payeeUserId) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payeeAccountNo查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByPayeeAccountNo(String payeeAccountNo) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		return transferInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据payeeFreezeCode查询transfer_instruction表数据
	*/
	public List<TransferInstructionDO> findTransferInstructionByPayeeFreezeCode(String payeeFreezeCode) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeFreezeCodeEqualTo(payeeFreezeCode);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerUserId查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByPayerUserId(String payerUserId) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payerAccountNo查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByPayerAccountNo(String payerAccountNo) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		return transferInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据payerFreezeCode查询transfer_instruction表数据
	*/
	public List<TransferInstructionDO> findTransferInstructionByPayerFreezeCode(String payerFreezeCode) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerFreezeCodeEqualTo(payerFreezeCode);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据accBizNo查询transfer_instruction表数据
	 */
	public List<TransferInstructionDO> findTransferInstructionByAccBizNo(String accBizNo) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		return transferInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询transfer_instruction表数据
	*/
	public List<TransferInstructionDO> findTransferInstructionByCode(String code) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return transferInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新transfer_instruction表数据
	 */
	public void updateTransferInstructionById(Long id,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据bizNo更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByBizNo(String bizNo,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据reqId更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByReqId(String reqId,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据gid更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByGid(String gid,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据partnerId更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByPartnerId(String partnerId,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByMerchantOrderNo(String merchantOrderNo,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据platPartnerId更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByPlatPartnerId(String platPartnerId,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByPlatMerchantOrderNo(String platMerchantOrderNo,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据payeeUserId更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByPayeeUserId(String payeeUserId,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeUserIdEqualTo(payeeUserId);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据payeeAccountNo更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByPayeeAccountNo(String payeeAccountNo,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeAccountNoEqualTo(payeeAccountNo);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

	/**
	* 根据payeeFreezeCode更新transfer_instruction表数据
	*/
	public void updateTransferInstructionByPayeeFreezeCode(String payeeFreezeCode,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayeeFreezeCodeEqualTo(payeeFreezeCode);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据payerUserId更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByPayerUserId(String payerUserId,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerUserIdEqualTo(payerUserId);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据payerAccountNo更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByPayerAccountNo(String payerAccountNo,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerAccountNoEqualTo(payerAccountNo);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

	/**
	* 根据payerFreezeCode更新transfer_instruction表数据
	*/
	public void updateTransferInstructionByPayerFreezeCode(String payerFreezeCode,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andPayerFreezeCodeEqualTo(payerFreezeCode);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

    /**
	 * 根据accBizNo更新transfer_instruction表数据
	 */
	public void updateTransferInstructionByAccBizNo(String accBizNo,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

	/**
	* 根据code更新transfer_instruction表数据
	*/
	public void updateTransferInstructionByCode(String code,TransferInstructionDO transferInstructionDO) {
		TransferInstructionDOExample exam = new TransferInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		transferInstructionDAO.updateByExample(transferInstructionDO, exam);
	}

	/**
	 * 断言withdraw_instruction表数据
	 */
	public void assertWithdrawInstruction(WithdrawInstructionDO expect, WithdrawInstructionDO withdrawInstructionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			withdrawInstructionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != withdrawInstructionDO.getRawAddTime());
		expect.setRawAddTime(withdrawInstructionDO.getRawAddTime());
        Assertions.assertTrue(null != withdrawInstructionDO.getRawUpdateTime());
		expect.setRawUpdateTime(withdrawInstructionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, withdrawInstructionDO);
	}

    /**
	 * 插入withdraw_instruction表数据
	 */
	public void insertWithdrawInstruction(WithdrawInstructionDO withdrawInstructionDO) {
		withdrawInstructionDAO.insert(withdrawInstructionDO);
	}

    /**
	 * 插入withdraw_instruction表数据
	 */
	public void insertWithdrawInstruction(
			Long id, 
			String transType, 
			String transTag, 
			String withdrawType, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String merchantMode, 
			String bankCard, 
			String userId, 
			String accountNo, 
			String userTag, 
			String freezeCode, 
			Long amount, 
			Long balance, 
			String accBizNo, 
			String freezeReqId, 
			String unfreezeReqId, 
			String remittanceUpBalanceReqId, 
			Integer partnerRate, 
			Integer channelRate, 
			String channelBizNo, 
			String channelId, 
			String channelName, 
			String payChannel, 
			String payChannelId, 
			String gwBizNo, 
			String fileInfo, 
			String fileSerial, 
			String fileName, 
			Date applyTime, 
			Date settleTime, 
			String bankWithdrawSerial, 
			Date finishTime, 
			String status, 
			String state, 
			String code, 
			String runMemo, 
			String receipt, 
			String description, 
			String memo, 
			String externalmetadata, 
			String extensionContext, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (applyTime == null) {
			applyTime = new Date();
		}
		if (settleTime == null) {
			settleTime = new Date();
		}
		if (finishTime == null) {
			finishTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		WithdrawInstructionDO withdrawInstructionDO = new WithdrawInstructionDO();
		withdrawInstructionDO.setId(id);
		withdrawInstructionDO.setTransType(transType);
		withdrawInstructionDO.setTransTag(transTag);
		withdrawInstructionDO.setWithdrawType(withdrawType);
		withdrawInstructionDO.setBizNo(bizNo);
		withdrawInstructionDO.setReqId(reqId);
		withdrawInstructionDO.setGid(gid);
		withdrawInstructionDO.setPartnerId(partnerId);
		withdrawInstructionDO.setMerchantOrderNo(merchantOrderNo);
		withdrawInstructionDO.setPlatPartnerId(platPartnerId);
		withdrawInstructionDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		withdrawInstructionDO.setMerchantMode(merchantMode);
		withdrawInstructionDO.setBankCard(bankCard);
		withdrawInstructionDO.setUserId(userId);
		withdrawInstructionDO.setAccountNo(accountNo);
		withdrawInstructionDO.setUserTag(userTag);
		withdrawInstructionDO.setFreezeCode(freezeCode);
		withdrawInstructionDO.setAmount(amount);
		withdrawInstructionDO.setBalance(balance);
		withdrawInstructionDO.setAccBizNo(accBizNo);
		withdrawInstructionDO.setFreezeReqId(freezeReqId);
		withdrawInstructionDO.setUnfreezeReqId(unfreezeReqId);
		withdrawInstructionDO.setRemittanceUpBalanceReqId(remittanceUpBalanceReqId);
		withdrawInstructionDO.setPartnerRate(partnerRate);
		withdrawInstructionDO.setChannelRate(channelRate);
		withdrawInstructionDO.setChannelBizNo(channelBizNo);
		withdrawInstructionDO.setChannelId(channelId);
		withdrawInstructionDO.setChannelName(channelName);
		withdrawInstructionDO.setPayChannel(payChannel);
		withdrawInstructionDO.setPayChannelId(payChannelId);
		withdrawInstructionDO.setGwBizNo(gwBizNo);
		withdrawInstructionDO.setFileInfo(fileInfo);
		withdrawInstructionDO.setFileSerial(fileSerial);
		withdrawInstructionDO.setFileName(fileName);
		withdrawInstructionDO.setApplyTime(applyTime);
		withdrawInstructionDO.setSettleTime(settleTime);
		withdrawInstructionDO.setBankWithdrawSerial(bankWithdrawSerial);
		withdrawInstructionDO.setFinishTime(finishTime);
		withdrawInstructionDO.setStatus(status);
		withdrawInstructionDO.setState(state);
		withdrawInstructionDO.setCode(code);
		withdrawInstructionDO.setRunMemo(runMemo);
		withdrawInstructionDO.setReceipt(receipt);
		withdrawInstructionDO.setDescription(description);
		withdrawInstructionDO.setMemo(memo);
		withdrawInstructionDO.setExternalmetadata(externalmetadata);
		withdrawInstructionDO.setExtensionContext(extensionContext);
		withdrawInstructionDO.setRawAddTime(rawAddTime);
		withdrawInstructionDO.setRawUpdateTime(rawUpdateTime);
		withdrawInstructionDAO.insert(withdrawInstructionDO);
	}

    /**
     * 删除withdraw_instruction表所有数据
     */
    public void cleanWithdrawInstruction() {
        WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
        exam.createCriteria();
        withdrawInstructionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionById(Long id) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据freezeCode删除withdraw_instruction表数据
	*/
	public void cleanWithdrawInstructionByFreezeCode(String freezeCode) {
        if (StringUtils.isBlank(freezeCode)){
            freezeCode = "test_freezeCode";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据accBizNo删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByAccBizNo(String accBizNo) {
        if (StringUtils.isBlank(accBizNo)){
            accBizNo = "test_accBizNo";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据freezeReqId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByFreezeReqId(String freezeReqId) {
        if (StringUtils.isBlank(freezeReqId)){
            freezeReqId = "test_freezeReqId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFreezeReqIdEqualTo(freezeReqId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据unfreezeReqId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByUnfreezeReqId(String unfreezeReqId) {
        if (StringUtils.isBlank(unfreezeReqId)){
            unfreezeReqId = "test_unfreezeReqId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andUnfreezeReqIdEqualTo(unfreezeReqId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据remittanceUpBalanceReqId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByRemittanceUpBalanceReqId(String remittanceUpBalanceReqId) {
        if (StringUtils.isBlank(remittanceUpBalanceReqId)){
            remittanceUpBalanceReqId = "test_remittanceUpBalanceReqId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andRemittanceUpBalanceReqIdEqualTo(remittanceUpBalanceReqId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelBizNo删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByChannelBizNo(String channelBizNo) {
        if (StringUtils.isBlank(channelBizNo)){
            channelBizNo = "test_channelBizNo";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据channelName删除withdraw_instruction表数据
	*/
	public void cleanWithdrawInstructionByChannelName(String channelName) {
        if (StringUtils.isBlank(channelName)){
            channelName = "test_channelName";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据payChannelId删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByPayChannelId(String payChannelId) {
        if (StringUtils.isBlank(payChannelId)){
            payChannelId = "test_payChannelId";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gwBizNo删除withdraw_instruction表数据
	 */
	public void cleanWithdrawInstructionByGwBizNo(String gwBizNo) {
        if (StringUtils.isBlank(gwBizNo)){
            gwBizNo = "test_gwBizNo";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andGwBizNoEqualTo(gwBizNo);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据fileName删除withdraw_instruction表数据
	*/
	public void cleanWithdrawInstructionByFileName(String fileName) {
        if (StringUtils.isBlank(fileName)){
            fileName = "test_fileName";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		withdrawInstructionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除withdraw_instruction表数据
	*/
	public void cleanWithdrawInstructionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		withdrawInstructionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionById(Long id) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByBizNo(String bizNo) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByReqId(String reqId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByGid(String gid) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByPartnerId(String partnerId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByMerchantOrderNo(String merchantOrderNo) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByPlatPartnerId(String platPartnerId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByUserId(String userId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByAccountNo(String accountNo) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return withdrawInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据freezeCode查询withdraw_instruction表数据
	*/
	public List<WithdrawInstructionDO> findWithdrawInstructionByFreezeCode(String freezeCode) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据accBizNo查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByAccBizNo(String accBizNo) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据freezeReqId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByFreezeReqId(String freezeReqId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFreezeReqIdEqualTo(freezeReqId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据unfreezeReqId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByUnfreezeReqId(String unfreezeReqId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andUnfreezeReqIdEqualTo(unfreezeReqId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据remittanceUpBalanceReqId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByRemittanceUpBalanceReqId(String remittanceUpBalanceReqId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andRemittanceUpBalanceReqIdEqualTo(remittanceUpBalanceReqId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelBizNo查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByChannelBizNo(String channelBizNo) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByChannelId(String channelId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据channelName查询withdraw_instruction表数据
	*/
	public List<WithdrawInstructionDO> findWithdrawInstructionByChannelName(String channelName) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据payChannelId查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByPayChannelId(String payChannelId) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gwBizNo查询withdraw_instruction表数据
	 */
	public List<WithdrawInstructionDO> findWithdrawInstructionByGwBizNo(String gwBizNo) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andGwBizNoEqualTo(gwBizNo);
		return withdrawInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据fileName查询withdraw_instruction表数据
	*/
	public List<WithdrawInstructionDO> findWithdrawInstructionByFileName(String fileName) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		return withdrawInstructionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询withdraw_instruction表数据
	*/
	public List<WithdrawInstructionDO> findWithdrawInstructionByCode(String code) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return withdrawInstructionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionById(Long id,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据bizNo更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByBizNo(String bizNo,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据reqId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByReqId(String reqId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据gid更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByGid(String gid,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据partnerId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByPartnerId(String partnerId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByMerchantOrderNo(String merchantOrderNo,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据platPartnerId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByPlatPartnerId(String platPartnerId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByPlatMerchantOrderNo(String platMerchantOrderNo,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据userId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByUserId(String userId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据accountNo更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByAccountNo(String accountNo,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

	/**
	* 根据freezeCode更新withdraw_instruction表数据
	*/
	public void updateWithdrawInstructionByFreezeCode(String freezeCode,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据accBizNo更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByAccBizNo(String accBizNo,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andAccBizNoEqualTo(accBizNo);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据freezeReqId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByFreezeReqId(String freezeReqId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFreezeReqIdEqualTo(freezeReqId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据unfreezeReqId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByUnfreezeReqId(String unfreezeReqId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andUnfreezeReqIdEqualTo(unfreezeReqId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据remittanceUpBalanceReqId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByRemittanceUpBalanceReqId(String remittanceUpBalanceReqId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andRemittanceUpBalanceReqIdEqualTo(remittanceUpBalanceReqId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据channelBizNo更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByChannelBizNo(String channelBizNo,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelBizNoEqualTo(channelBizNo);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据channelId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByChannelId(String channelId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

	/**
	* 根据channelName更新withdraw_instruction表数据
	*/
	public void updateWithdrawInstructionByChannelName(String channelName,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据payChannelId更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByPayChannelId(String payChannelId,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

    /**
	 * 根据gwBizNo更新withdraw_instruction表数据
	 */
	public void updateWithdrawInstructionByGwBizNo(String gwBizNo,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andGwBizNoEqualTo(gwBizNo);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

	/**
	* 根据fileName更新withdraw_instruction表数据
	*/
	public void updateWithdrawInstructionByFileName(String fileName,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}

	/**
	* 根据code更新withdraw_instruction表数据
	*/
	public void updateWithdrawInstructionByCode(String code,WithdrawInstructionDO withdrawInstructionDO) {
		WithdrawInstructionDOExample exam = new WithdrawInstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		withdrawInstructionDAO.updateByExample(withdrawInstructionDO, exam);
	}
}
