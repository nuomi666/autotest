//package com.xjy.autotest.testbase;
//
//import java.util.List;
//import java.util.Date;
//import com.xjy.autotest.base.AutoTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import org.junit.jupiter.api.Assertions;
//import org.junit.platform.commons.util.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.context.annotation.Import;
//import com.xyb.adk.common.util.money.Money;
//import java.math.BigDecimal;
//import dal.dao.gas_trade.*;
//import dal.model.gas_trade.*;
//import com.xjy.autotest.config.Gas_tradeDataSourceConfig;
//
///**
// * @author autotest
// * Created on 2019/08/02.
// */
//@Service
//@Import({
//        Gas_tradeDataSourceConfig.class
//})
//public class Gas_tradeTestBase extends AutoTestBase{
//
//	@Autowired
//	DayAmountDAO dayAmountDAO;
//
//	@Autowired
//	GasTradeDepositBackDAO gasTradeDepositBackDAO;
//
//	@Autowired
//	GasTradeDepositDAO gasTradeDepositDAO;
//
//	@Autowired
//	GasTradeFavourDAO gasTradeFavourDAO;
//
//	@Autowired
//	GasTradeGiveDAO gasTradeGiveDAO;
//
//	@Autowired
//	GasTradeGoodsDAO gasTradeGoodsDAO;
//
//	@Autowired
//	GasTradeNotifyTaskDAO gasTradeNotifyTaskDAO;
//
//	@Autowired
//	GasTradeNotifyTaskWashDAO gasTradeNotifyTaskWashDAO;
//
//	@Autowired
//	GasTradeOilDAO gasTradeOilDAO;
//
//	@Autowired
//	GasTradePaymentDAO gasTradePaymentDAO;
//
//	@Autowired
//	GasTradePointsRedeemDAO gasTradePointsRedeemDAO;
//
//	@Autowired
//	GasTradeRefundDAO gasTradeRefundDAO;
//
//	@Autowired
//	GasTradeReviseDAO gasTradeReviseDAO;
//
//	@Autowired
//	GasTradeReviseRefundDAO gasTradeReviseRefundDAO;
//
//	@Autowired
//	Sheet1DAO sheet1DAO;
//
//	public DayAmountDAO getDayAmountDAO() {
//		return this.dayAmountDAO;
//	}
//
//	public GasTradeDepositBackDAO getGasTradeDepositBackDAO() {
//		return this.gasTradeDepositBackDAO;
//	}
//
//	public GasTradeDepositDAO getGasTradeDepositDAO() {
//		return this.gasTradeDepositDAO;
//	}
//
//	public GasTradeFavourDAO getGasTradeFavourDAO() {
//		return this.gasTradeFavourDAO;
//	}
//
//	public GasTradeGiveDAO getGasTradeGiveDAO() {
//		return this.gasTradeGiveDAO;
//	}
//
//	public GasTradeGoodsDAO getGasTradeGoodsDAO() {
//		return this.gasTradeGoodsDAO;
//	}
//
//	public GasTradeNotifyTaskDAO getGasTradeNotifyTaskDAO() {
//		return this.gasTradeNotifyTaskDAO;
//	}
//
//	public GasTradeNotifyTaskWashDAO getGasTradeNotifyTaskWashDAO() {
//		return this.gasTradeNotifyTaskWashDAO;
//	}
//
//	public GasTradeOilDAO getGasTradeOilDAO() {
//		return this.gasTradeOilDAO;
//	}
//
//	public GasTradePaymentDAO getGasTradePaymentDAO() {
//		return this.gasTradePaymentDAO;
//	}
//
//	public GasTradePointsRedeemDAO getGasTradePointsRedeemDAO() {
//		return this.gasTradePointsRedeemDAO;
//	}
//
//	public GasTradeRefundDAO getGasTradeRefundDAO() {
//		return this.gasTradeRefundDAO;
//	}
//
//	public GasTradeReviseDAO getGasTradeReviseDAO() {
//		return this.gasTradeReviseDAO;
//	}
//
//	public GasTradeReviseRefundDAO getGasTradeReviseRefundDAO() {
//		return this.gasTradeReviseRefundDAO;
//	}
//
//	public Sheet1DAO getSheet1DAO() {
//		return this.sheet1DAO;
//	}
//
//
//    /**
//	 * 断言day_amount表
//	 */
//	public void dayAmountAssert(
//	        DayAmountDO dayAmountDO,
//			Integer id,
//			String day,
//			String amount
//	) {
//        assertEquals(id, dayAmountDO.getId());
//        assertEquals(day, dayAmountDO.getDay());
//        assertEquals(amount, dayAmountDO.getAmount());
//	}
//
//	/**
//	 * 断言day_amount表数据
//	 */
//	public void assertDayAmount(DayAmountDO expect, DayAmountDO dayAmountDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			dayAmountDO.setId(expect.getId());
//		}
//		Assertions.assertEquals(expect, dayAmountDO);
//	}
//
//    /**
//	 * 插入day_amount表数据
//	 */
//	public void insertDayAmount(DayAmountDO dayAmountDO) {
//		dayAmountDAO.insert(dayAmountDO);
//	}
//
//    /**
//	 * 插入day_amount表数据
//	 */
//	public void insertDayAmount(
//			Integer id,
//			String day,
//			String amount
//	) {
//		DayAmountDO dayAmountDO = new DayAmountDO();
//		dayAmountDO.setId(id);
//		dayAmountDO.setDay(day);
//		dayAmountDO.setAmount(amount);
//		dayAmountDAO.insert(dayAmountDO);
//	}
//
//    /**
//     * 删除day_amount表所有数据
//     */
//    public void cleanDayAmount() {
//        DayAmountDOExample exam = new DayAmountDOExample();
//        exam.createCriteria();
//        dayAmountDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除day_amount表数据
//	 */
//	public void cleanDayAmountById(Integer id) {
//		DayAmountDOExample exam = new DayAmountDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		dayAmountDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询day_amount表所有数据
//     */
//    public List<DayAmountDO> findDayAmountAll() {
//        DayAmountDOExample exam = new DayAmountDOExample();
//        exam.createCriteria();
//		return dayAmountDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询day_amount表数据
//	 */
//	public List<DayAmountDO> findDayAmountById(Integer id) {
//		DayAmountDOExample exam = new DayAmountDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return dayAmountDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新day_amount表数据
//	 */
//	public void updateDayAmountById(Integer id,DayAmountDO dayAmountDO) {
//		DayAmountDOExample exam = new DayAmountDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		dayAmountDAO.updateByExample(dayAmountDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_deposit_back表
//	 */
//	public void gasTradeDepositBackAssert(
//	        GasTradeDepositBackDO gasTradeDepositBackDO,
//			long id,
//			String tradeType,
//			String bizNo,
//			String depositNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			String carNumber,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			Integer expireTime,
//			Date finishTime,
//			Date clearTime,
//			String extensionContext,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeDepositBackDO.getId());
//        assertEquals(tradeType, gasTradeDepositBackDO.getTradeType());
//        assertEquals(bizNo, gasTradeDepositBackDO.getBizNo());
//        assertEquals(depositNo, gasTradeDepositBackDO.getDepositNo());
//        assertEquals(reqId, gasTradeDepositBackDO.getReqId());
//        assertEquals(gid, gasTradeDepositBackDO.getGid());
//        assertEquals(partnerId, gasTradeDepositBackDO.getPartnerId());
//        assertEquals(partnerName, gasTradeDepositBackDO.getPartnerName());
//        assertEquals(stationId, gasTradeDepositBackDO.getStationId());
//        assertEquals(stationCode, gasTradeDepositBackDO.getStationCode());
//        assertEquals(stationName, gasTradeDepositBackDO.getStationName());
//        assertEquals(operateId, gasTradeDepositBackDO.getOperateId());
//        assertEquals(operateName, gasTradeDepositBackDO.getOperateName());
//        assertEquals(terminalType, gasTradeDepositBackDO.getTerminalType());
//        assertEquals(terminalCode, gasTradeDepositBackDO.getTerminalCode());
//        assertEquals(userId, gasTradeDepositBackDO.getUserId());
//        assertEquals(realName, gasTradeDepositBackDO.getRealName());
//        assertEquals(nickName, gasTradeDepositBackDO.getNickName());
//        assertEquals(memberType, gasTradeDepositBackDO.getMemberType());
//        assertEquals(mobile, gasTradeDepositBackDO.getMobile());
//        assertEquals(cardNo, gasTradeDepositBackDO.getCardNo());
//        assertEquals(cardType, gasTradeDepositBackDO.getCardType());
//        assertEquals(cardBizType, gasTradeDepositBackDO.getCardBizType());
//        assertEquals(carNumber, gasTradeDepositBackDO.getCarNumber());
//        assertEquals(balance, gasTradeDepositBackDO.getBalance());
//        assertEquals(requestNo, gasTradeDepositBackDO.getRequestNo());
//        assertEquals(payNo, gasTradeDepositBackDO.getPayNo());
//        assertEquals(tradePayType, gasTradeDepositBackDO.getTradePayType());
//        assertEquals(payModel, gasTradeDepositBackDO.getPayModel());
//        assertEquals(amount, gasTradeDepositBackDO.getAmount());
//        assertEquals(payAmount, gasTradeDepositBackDO.getPayAmount());
//        assertEquals(feeAmount, gasTradeDepositBackDO.getFeeAmount());
//        assertEquals(settlementAmount, gasTradeDepositBackDO.getSettlementAmount());
//        assertEquals(memo, gasTradeDepositBackDO.getMemo());
//        assertEquals(status, gasTradeDepositBackDO.getStatus());
//        assertEquals(state, gasTradeDepositBackDO.getState());
//        assertEquals(code, gasTradeDepositBackDO.getCode());
//        assertEquals(description, gasTradeDepositBackDO.getDescription());
//        assertEquals(runMemo, gasTradeDepositBackDO.getRunMemo());
//        assertEquals(expireTime, gasTradeDepositBackDO.getExpireTime());
//        assertEquals(finishTime, gasTradeDepositBackDO.getFinishTime());
//        assertEquals(clearTime, gasTradeDepositBackDO.getClearTime());
//        assertEquals(extensionContext, gasTradeDepositBackDO.getExtensionContext());
//        assertEquals(rawAddTime, gasTradeDepositBackDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeDepositBackDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_deposit_back表数据
//	 */
//	public void assertGasTradeDepositBack(GasTradeDepositBackDO expect, GasTradeDepositBackDO gasTradeDepositBackDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeDepositBackDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeDepositBackDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeDepositBackDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeDepositBackDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeDepositBackDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeDepositBackDO);
//	}
//
//    /**
//	 * 插入gas_trade_deposit_back表数据
//	 */
//	public void insertGasTradeDepositBack(GasTradeDepositBackDO gasTradeDepositBackDO) {
//		gasTradeDepositBackDAO.insert(gasTradeDepositBackDO);
//	}
//
//    /**
//	 * 插入gas_trade_deposit_back表数据
//	 */
//	public void insertGasTradeDepositBack(
//			long id,
//			String tradeType,
//			String bizNo,
//			String depositNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			String carNumber,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			Integer expireTime,
//			Date finishTime,
//			Date clearTime,
//			String extensionContext,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (finishTime == null) {
//			finishTime = new Date();
//		}
//		if (clearTime == null) {
//			clearTime = new Date();
//		}
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeDepositBackDO gasTradeDepositBackDO = new GasTradeDepositBackDO();
//		gasTradeDepositBackDO.setId(id);
//		gasTradeDepositBackDO.setTradeType(tradeType);
//		gasTradeDepositBackDO.setBizNo(bizNo);
//		gasTradeDepositBackDO.setDepositNo(depositNo);
//		gasTradeDepositBackDO.setReqId(reqId);
//		gasTradeDepositBackDO.setGid(gid);
//		gasTradeDepositBackDO.setPartnerId(partnerId);
//		gasTradeDepositBackDO.setPartnerName(partnerName);
//		gasTradeDepositBackDO.setStationId(stationId);
//		gasTradeDepositBackDO.setStationCode(stationCode);
//		gasTradeDepositBackDO.setStationName(stationName);
//		gasTradeDepositBackDO.setOperateId(operateId);
//		gasTradeDepositBackDO.setOperateName(operateName);
//		gasTradeDepositBackDO.setTerminalType(terminalType);
//		gasTradeDepositBackDO.setTerminalCode(terminalCode);
//		gasTradeDepositBackDO.setUserId(userId);
//		gasTradeDepositBackDO.setRealName(realName);
//		gasTradeDepositBackDO.setNickName(nickName);
//		gasTradeDepositBackDO.setMemberType(memberType);
//		gasTradeDepositBackDO.setMobile(mobile);
//		gasTradeDepositBackDO.setCardNo(cardNo);
//		gasTradeDepositBackDO.setCardType(cardType);
//		gasTradeDepositBackDO.setCardBizType(cardBizType);
//		gasTradeDepositBackDO.setCarNumber(carNumber);
//		gasTradeDepositBackDO.setBalance(balance);
//		gasTradeDepositBackDO.setRequestNo(requestNo);
//		gasTradeDepositBackDO.setPayNo(payNo);
//		gasTradeDepositBackDO.setTradePayType(tradePayType);
//		gasTradeDepositBackDO.setPayModel(payModel);
//		gasTradeDepositBackDO.setAmount(amount);
//		gasTradeDepositBackDO.setPayAmount(payAmount);
//		gasTradeDepositBackDO.setFeeAmount(feeAmount);
//		gasTradeDepositBackDO.setSettlementAmount(settlementAmount);
//		gasTradeDepositBackDO.setMemo(memo);
//		gasTradeDepositBackDO.setStatus(status);
//		gasTradeDepositBackDO.setState(state);
//		gasTradeDepositBackDO.setCode(code);
//		gasTradeDepositBackDO.setDescription(description);
//		gasTradeDepositBackDO.setRunMemo(runMemo);
//		gasTradeDepositBackDO.setExpireTime(expireTime);
//		gasTradeDepositBackDO.setFinishTime(finishTime);
//		gasTradeDepositBackDO.setClearTime(clearTime);
//		gasTradeDepositBackDO.setExtensionContext(extensionContext);
//		gasTradeDepositBackDO.setRawAddTime(rawAddTime);
//		gasTradeDepositBackDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeDepositBackDAO.insert(gasTradeDepositBackDO);
//	}
//
//    /**
//     * 删除gas_trade_deposit_back表所有数据
//     */
//    public void cleanGasTradeDepositBack() {
//        GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//        exam.createCriteria();
//        gasTradeDepositBackDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackById(long id) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据depositNo删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByDepositNo(String depositNo) {
//        if (StringUtils.isBlank(depositNo)){
//            depositNo = "test_depositNo";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andDepositNoEqualTo(depositNo);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据reqId删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByReqId(String reqId) {
//        if (StringUtils.isBlank(reqId)){
//            reqId = "test_reqId";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据gid删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByGid(String gid) {
//        if (StringUtils.isBlank(gid)){
//            gid = "test_gid";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据partnerId删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByPartnerId(String partnerId) {
//        if (StringUtils.isBlank(partnerId)){
//            partnerId = "test_partnerId";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据partnerName删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByPartnerName(String partnerName) {
//        if (StringUtils.isBlank(partnerName)){
//            partnerName = "test_partnerName";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据stationId删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByStationId(String stationId) {
//        if (StringUtils.isBlank(stationId)){
//            stationId = "test_stationId";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationCode删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByStationCode(String stationCode) {
//        if (StringUtils.isBlank(stationCode)){
//            stationCode = "test_stationCode";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationName删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByStationName(String stationName) {
//        if (StringUtils.isBlank(stationName)){
//            stationName = "test_stationName";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据operateId删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByOperateId(String operateId) {
//        if (StringUtils.isBlank(operateId)){
//            operateId = "test_operateId";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据operateName删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByOperateName(String operateName) {
//        if (StringUtils.isBlank(operateName)){
//            operateName = "test_operateName";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByTerminalCode(String terminalCode) {
//        if (StringUtils.isBlank(terminalCode)){
//            terminalCode = "test_terminalCode";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据userId删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByUserId(String userId) {
//        if (StringUtils.isBlank(userId)){
//            userId = "test_userId";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据realName删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByRealName(String realName) {
//        if (StringUtils.isBlank(realName)){
//            realName = "test_realName";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据nickName删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByNickName(String nickName) {
//        if (StringUtils.isBlank(nickName)){
//            nickName = "test_nickName";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据mobile删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByMobile(String mobile) {
//        if (StringUtils.isBlank(mobile)){
//            mobile = "test_mobile";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据cardNo删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByCardNo(String cardNo) {
//        if (StringUtils.isBlank(cardNo)){
//            cardNo = "test_cardNo";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据carNumber删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByCarNumber(String carNumber) {
//        if (StringUtils.isBlank(carNumber)){
//            carNumber = "test_carNumber";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据requestNo删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByRequestNo(String requestNo) {
//        if (StringUtils.isBlank(requestNo)){
//            requestNo = "test_requestNo";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据payNo删除gas_trade_deposit_back表数据
//	 */
//	public void cleanGasTradeDepositBackByPayNo(String payNo) {
//        if (StringUtils.isBlank(payNo)){
//            payNo = "test_payNo";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_deposit_back表数据
//	*/
//	public void cleanGasTradeDepositBackByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeDepositBackDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_deposit_back表所有数据
//     */
//    public List<GasTradeDepositBackDO> findGasTradeDepositBackAll() {
//        GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//        exam.createCriteria();
//		return gasTradeDepositBackDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackById(long id) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByBizNo(String bizNo) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据depositNo查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByDepositNo(String depositNo) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andDepositNoEqualTo(depositNo);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据reqId查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByReqId(String reqId) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据gid查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByGid(String gid) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据partnerId查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByPartnerId(String partnerId) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据partnerName查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByPartnerName(String partnerName) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据stationId查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByStationId(String stationId) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationCode查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByStationCode(String stationCode) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationName查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByStationName(String stationName) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据operateId查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByOperateId(String operateId) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据operateName查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByOperateName(String operateName) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByTerminalCode(String terminalCode) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据userId查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByUserId(String userId) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据realName查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByRealName(String realName) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据nickName查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByNickName(String nickName) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据mobile查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByMobile(String mobile) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据cardNo查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByCardNo(String cardNo) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据carNumber查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByCarNumber(String carNumber) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据requestNo查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByRequestNo(String requestNo) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据payNo查询gas_trade_deposit_back表数据
//	 */
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByPayNo(String payNo) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_deposit_back表数据
//	*/
//	public List<GasTradeDepositBackDO> findGasTradeDepositBackByCode(String code) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradeDepositBackDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackById(long id,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByBizNo(String bizNo,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据depositNo更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByDepositNo(String depositNo,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andDepositNoEqualTo(depositNo);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据reqId更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByReqId(String reqId,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据gid更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByGid(String gid,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据partnerId更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByPartnerId(String partnerId,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据partnerName更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByPartnerName(String partnerName,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据stationId更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByStationId(String stationId,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据stationCode更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByStationCode(String stationCode,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据stationName更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByStationName(String stationName,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据operateId更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByOperateId(String operateId,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据operateName更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByOperateName(String operateName,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据terminalCode更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByTerminalCode(String terminalCode,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据userId更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByUserId(String userId,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据realName更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByRealName(String realName,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据nickName更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByNickName(String nickName,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据mobile更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByMobile(String mobile,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据cardNo更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByCardNo(String cardNo,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据requestNo更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByRequestNo(String requestNo,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 根据payNo更新gas_trade_deposit_back表数据
//	 */
//	public void updateGasTradeDepositBackByPayNo(String payNo,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_deposit_back表数据
//	*/
//	public void updateGasTradeDepositBackByCode(String code,GasTradeDepositBackDO gasTradeDepositBackDO) {
//		GasTradeDepositBackDOExample exam = new GasTradeDepositBackDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeDepositBackDAO.updateByExample(gasTradeDepositBackDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_deposit表
//	 */
//	public void gasTradeDepositAssert(
//	        GasTradeDepositDO gasTradeDepositDO,
//			long id,
//			String tradeType,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			String carNumber,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long favourAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String extensionContext,
//			Integer expireTime,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeDepositDO.getId());
//        assertEquals(tradeType, gasTradeDepositDO.getTradeType());
//        assertEquals(bizNo, gasTradeDepositDO.getBizNo());
//        assertEquals(reqId, gasTradeDepositDO.getReqId());
//        assertEquals(gid, gasTradeDepositDO.getGid());
//        assertEquals(partnerId, gasTradeDepositDO.getPartnerId());
//        assertEquals(partnerName, gasTradeDepositDO.getPartnerName());
//        assertEquals(stationId, gasTradeDepositDO.getStationId());
//        assertEquals(stationCode, gasTradeDepositDO.getStationCode());
//        assertEquals(stationName, gasTradeDepositDO.getStationName());
//        assertEquals(operateId, gasTradeDepositDO.getOperateId());
//        assertEquals(operateName, gasTradeDepositDO.getOperateName());
//        assertEquals(terminalType, gasTradeDepositDO.getTerminalType());
//        assertEquals(terminalCode, gasTradeDepositDO.getTerminalCode());
//        assertEquals(userId, gasTradeDepositDO.getUserId());
//        assertEquals(realName, gasTradeDepositDO.getRealName());
//        assertEquals(nickName, gasTradeDepositDO.getNickName());
//        assertEquals(memberType, gasTradeDepositDO.getMemberType());
//        assertEquals(mobile, gasTradeDepositDO.getMobile());
//        assertEquals(cardNo, gasTradeDepositDO.getCardNo());
//        assertEquals(cardType, gasTradeDepositDO.getCardType());
//        assertEquals(cardBizType, gasTradeDepositDO.getCardBizType());
//        assertEquals(carNumber, gasTradeDepositDO.getCarNumber());
//        assertEquals(balance, gasTradeDepositDO.getBalance());
//        assertEquals(requestNo, gasTradeDepositDO.getRequestNo());
//        assertEquals(payNo, gasTradeDepositDO.getPayNo());
//        assertEquals(tradePayType, gasTradeDepositDO.getTradePayType());
//        assertEquals(payModel, gasTradeDepositDO.getPayModel());
//        assertEquals(amount, gasTradeDepositDO.getAmount());
//        assertEquals(payAmount, gasTradeDepositDO.getPayAmount());
//        assertEquals(favourAmount, gasTradeDepositDO.getFavourAmount());
//        assertEquals(feeAmount, gasTradeDepositDO.getFeeAmount());
//        assertEquals(settlementAmount, gasTradeDepositDO.getSettlementAmount());
//        assertEquals(memo, gasTradeDepositDO.getMemo());
//        assertEquals(status, gasTradeDepositDO.getStatus());
//        assertEquals(state, gasTradeDepositDO.getState());
//        assertEquals(code, gasTradeDepositDO.getCode());
//        assertEquals(description, gasTradeDepositDO.getDescription());
//        assertEquals(runMemo, gasTradeDepositDO.getRunMemo());
//        assertEquals(extensionContext, gasTradeDepositDO.getExtensionContext());
//        assertEquals(expireTime, gasTradeDepositDO.getExpireTime());
//        assertEquals(finishTime, gasTradeDepositDO.getFinishTime());
//        assertEquals(clearTime, gasTradeDepositDO.getClearTime());
//        assertEquals(rawAddTime, gasTradeDepositDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeDepositDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_deposit表数据
//	 */
//	public void assertGasTradeDeposit(GasTradeDepositDO expect, GasTradeDepositDO gasTradeDepositDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeDepositDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeDepositDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeDepositDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeDepositDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeDepositDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeDepositDO);
//	}
//
//    /**
//	 * 插入gas_trade_deposit表数据
//	 */
//	public void insertGasTradeDeposit(GasTradeDepositDO gasTradeDepositDO) {
//		gasTradeDepositDAO.insert(gasTradeDepositDO);
//	}
//
//    /**
//	 * 插入gas_trade_deposit表数据
//	 */
//	public void insertGasTradeDeposit(
//			long id,
//			String tradeType,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			String carNumber,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long favourAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String extensionContext,
//			Integer expireTime,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (finishTime == null) {
//			finishTime = new Date();
//		}
//		if (clearTime == null) {
//			clearTime = new Date();
//		}
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeDepositDO gasTradeDepositDO = new GasTradeDepositDO();
//		gasTradeDepositDO.setId(id);
//		gasTradeDepositDO.setTradeType(tradeType);
//		gasTradeDepositDO.setBizNo(bizNo);
//		gasTradeDepositDO.setReqId(reqId);
//		gasTradeDepositDO.setGid(gid);
//		gasTradeDepositDO.setPartnerId(partnerId);
//		gasTradeDepositDO.setPartnerName(partnerName);
//		gasTradeDepositDO.setStationId(stationId);
//		gasTradeDepositDO.setStationCode(stationCode);
//		gasTradeDepositDO.setStationName(stationName);
//		gasTradeDepositDO.setOperateId(operateId);
//		gasTradeDepositDO.setOperateName(operateName);
//		gasTradeDepositDO.setTerminalType(terminalType);
//		gasTradeDepositDO.setTerminalCode(terminalCode);
//		gasTradeDepositDO.setUserId(userId);
//		gasTradeDepositDO.setRealName(realName);
//		gasTradeDepositDO.setNickName(nickName);
//		gasTradeDepositDO.setMemberType(memberType);
//		gasTradeDepositDO.setMobile(mobile);
//		gasTradeDepositDO.setCardNo(cardNo);
//		gasTradeDepositDO.setCardType(cardType);
//		gasTradeDepositDO.setCardBizType(cardBizType);
//		gasTradeDepositDO.setCarNumber(carNumber);
//		gasTradeDepositDO.setBalance(balance);
//		gasTradeDepositDO.setRequestNo(requestNo);
//		gasTradeDepositDO.setPayNo(payNo);
//		gasTradeDepositDO.setTradePayType(tradePayType);
//		gasTradeDepositDO.setPayModel(payModel);
//		gasTradeDepositDO.setAmount(amount);
//		gasTradeDepositDO.setPayAmount(payAmount);
//		gasTradeDepositDO.setFavourAmount(favourAmount);
//		gasTradeDepositDO.setFeeAmount(feeAmount);
//		gasTradeDepositDO.setSettlementAmount(settlementAmount);
//		gasTradeDepositDO.setMemo(memo);
//		gasTradeDepositDO.setStatus(status);
//		gasTradeDepositDO.setState(state);
//		gasTradeDepositDO.setCode(code);
//		gasTradeDepositDO.setDescription(description);
//		gasTradeDepositDO.setRunMemo(runMemo);
//		gasTradeDepositDO.setExtensionContext(extensionContext);
//		gasTradeDepositDO.setExpireTime(expireTime);
//		gasTradeDepositDO.setFinishTime(finishTime);
//		gasTradeDepositDO.setClearTime(clearTime);
//		gasTradeDepositDO.setRawAddTime(rawAddTime);
//		gasTradeDepositDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeDepositDAO.insert(gasTradeDepositDO);
//	}
//
//    /**
//     * 删除gas_trade_deposit表所有数据
//     */
//    public void cleanGasTradeDeposit() {
//        GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//        exam.createCriteria();
//        gasTradeDepositDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositById(long id) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据reqId删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByReqId(String reqId) {
//        if (StringUtils.isBlank(reqId)){
//            reqId = "test_reqId";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据gid删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByGid(String gid) {
//        if (StringUtils.isBlank(gid)){
//            gid = "test_gid";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据partnerId删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByPartnerId(String partnerId) {
//        if (StringUtils.isBlank(partnerId)){
//            partnerId = "test_partnerId";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据partnerName删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByPartnerName(String partnerName) {
//        if (StringUtils.isBlank(partnerName)){
//            partnerName = "test_partnerName";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据stationId删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByStationId(String stationId) {
//        if (StringUtils.isBlank(stationId)){
//            stationId = "test_stationId";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationCode删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByStationCode(String stationCode) {
//        if (StringUtils.isBlank(stationCode)){
//            stationCode = "test_stationCode";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationName删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByStationName(String stationName) {
//        if (StringUtils.isBlank(stationName)){
//            stationName = "test_stationName";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据operateId删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByOperateId(String operateId) {
//        if (StringUtils.isBlank(operateId)){
//            operateId = "test_operateId";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据operateName删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByOperateName(String operateName) {
//        if (StringUtils.isBlank(operateName)){
//            operateName = "test_operateName";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByTerminalCode(String terminalCode) {
//        if (StringUtils.isBlank(terminalCode)){
//            terminalCode = "test_terminalCode";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据userId删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByUserId(String userId) {
//        if (StringUtils.isBlank(userId)){
//            userId = "test_userId";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据realName删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByRealName(String realName) {
//        if (StringUtils.isBlank(realName)){
//            realName = "test_realName";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据nickName删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByNickName(String nickName) {
//        if (StringUtils.isBlank(nickName)){
//            nickName = "test_nickName";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据mobile删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByMobile(String mobile) {
//        if (StringUtils.isBlank(mobile)){
//            mobile = "test_mobile";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据cardNo删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByCardNo(String cardNo) {
//        if (StringUtils.isBlank(cardNo)){
//            cardNo = "test_cardNo";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据carNumber删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByCarNumber(String carNumber) {
//        if (StringUtils.isBlank(carNumber)){
//            carNumber = "test_carNumber";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据requestNo删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByRequestNo(String requestNo) {
//        if (StringUtils.isBlank(requestNo)){
//            requestNo = "test_requestNo";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据payNo删除gas_trade_deposit表数据
//	 */
//	public void cleanGasTradeDepositByPayNo(String payNo) {
//        if (StringUtils.isBlank(payNo)){
//            payNo = "test_payNo";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_deposit表数据
//	*/
//	public void cleanGasTradeDepositByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeDepositDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_deposit表所有数据
//     */
//    public List<GasTradeDepositDO> findGasTradeDepositAll() {
//        GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//        exam.createCriteria();
//		return gasTradeDepositDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositById(long id) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByBizNo(String bizNo) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据reqId查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByReqId(String reqId) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据gid查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByGid(String gid) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据partnerId查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByPartnerId(String partnerId) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据partnerName查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByPartnerName(String partnerName) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据stationId查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByStationId(String stationId) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationCode查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByStationCode(String stationCode) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationName查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByStationName(String stationName) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据operateId查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByOperateId(String operateId) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据operateName查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByOperateName(String operateName) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByTerminalCode(String terminalCode) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据userId查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByUserId(String userId) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据realName查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByRealName(String realName) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据nickName查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByNickName(String nickName) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据mobile查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByMobile(String mobile) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据cardNo查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByCardNo(String cardNo) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据carNumber查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByCarNumber(String carNumber) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据requestNo查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByRequestNo(String requestNo) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据payNo查询gas_trade_deposit表数据
//	 */
//	public List<GasTradeDepositDO> findGasTradeDepositByPayNo(String payNo) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_deposit表数据
//	*/
//	public List<GasTradeDepositDO> findGasTradeDepositByCode(String code) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradeDepositDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositById(long id,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByBizNo(String bizNo,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据reqId更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByReqId(String reqId,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据gid更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByGid(String gid,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据partnerId更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByPartnerId(String partnerId,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据partnerName更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByPartnerName(String partnerName,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据stationId更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByStationId(String stationId,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据stationCode更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByStationCode(String stationCode,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据stationName更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByStationName(String stationName,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据operateId更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByOperateId(String operateId,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据operateName更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByOperateName(String operateName,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据terminalCode更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByTerminalCode(String terminalCode,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据userId更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByUserId(String userId,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据realName更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByRealName(String realName,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据nickName更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByNickName(String nickName,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据mobile更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByMobile(String mobile,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据cardNo更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByCardNo(String cardNo,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据requestNo更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByRequestNo(String requestNo,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 根据payNo更新gas_trade_deposit表数据
//	 */
//	public void updateGasTradeDepositByPayNo(String payNo,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_deposit表数据
//	*/
//	public void updateGasTradeDepositByCode(String code,GasTradeDepositDO gasTradeDepositDO) {
//		GasTradeDepositDOExample exam = new GasTradeDepositDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeDepositDAO.updateByExample(gasTradeDepositDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_favour表
//	 */
//	public void gasTradeFavourAssert(
//	        GasTradeFavourDO gasTradeFavourDO,
//			long id,
//			String bizNo,
//			String favourId,
//			String favourDefinitionId,
//			String campaignName,
//			String favourName,
//			String favourCategory,
//			String favourType,
//			String favourRule,
//			long favourAmount,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeFavourDO.getId());
//        assertEquals(bizNo, gasTradeFavourDO.getBizNo());
//        assertEquals(favourId, gasTradeFavourDO.getFavourId());
//        assertEquals(favourDefinitionId, gasTradeFavourDO.getFavourDefinitionId());
//        assertEquals(campaignName, gasTradeFavourDO.getCampaignName());
//        assertEquals(favourName, gasTradeFavourDO.getFavourName());
//        assertEquals(favourCategory, gasTradeFavourDO.getFavourCategory());
//        assertEquals(favourType, gasTradeFavourDO.getFavourType());
//        assertEquals(favourRule, gasTradeFavourDO.getFavourRule());
//        assertEquals(favourAmount, gasTradeFavourDO.getFavourAmount());
//        assertEquals(rawAddTime, gasTradeFavourDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeFavourDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_favour表数据
//	 */
//	public void assertGasTradeFavour(GasTradeFavourDO expect, GasTradeFavourDO gasTradeFavourDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeFavourDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeFavourDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeFavourDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeFavourDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeFavourDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeFavourDO);
//	}
//
//    /**
//	 * 插入gas_trade_favour表数据
//	 */
//	public void insertGasTradeFavour(GasTradeFavourDO gasTradeFavourDO) {
//		gasTradeFavourDAO.insert(gasTradeFavourDO);
//	}
//
//    /**
//	 * 插入gas_trade_favour表数据
//	 */
//	public void insertGasTradeFavour(
//			long id,
//			String bizNo,
//			String favourId,
//			String favourDefinitionId,
//			String campaignName,
//			String favourName,
//			String favourCategory,
//			String favourType,
//			String favourRule,
//			long favourAmount,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeFavourDO gasTradeFavourDO = new GasTradeFavourDO();
//		gasTradeFavourDO.setId(id);
//		gasTradeFavourDO.setBizNo(bizNo);
//		gasTradeFavourDO.setFavourId(favourId);
//		gasTradeFavourDO.setFavourDefinitionId(favourDefinitionId);
//		gasTradeFavourDO.setCampaignName(campaignName);
//		gasTradeFavourDO.setFavourName(favourName);
//		gasTradeFavourDO.setFavourCategory(favourCategory);
//		gasTradeFavourDO.setFavourType(favourType);
//		gasTradeFavourDO.setFavourRule(favourRule);
//		gasTradeFavourDO.setFavourAmount(favourAmount);
//		gasTradeFavourDO.setRawAddTime(rawAddTime);
//		gasTradeFavourDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeFavourDAO.insert(gasTradeFavourDO);
//	}
//
//    /**
//     * 删除gas_trade_favour表所有数据
//     */
//    public void cleanGasTradeFavour() {
//        GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//        exam.createCriteria();
//        gasTradeFavourDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_favour表数据
//	 */
//	public void cleanGasTradeFavourById(long id) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeFavourDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_favour表数据
//	 */
//	public void cleanGasTradeFavourByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeFavourDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据favourId删除gas_trade_favour表数据
//	 */
//	public void cleanGasTradeFavourByFavourId(String favourId) {
//        if (StringUtils.isBlank(favourId)){
//            favourId = "test_favourId";
//        }
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourIdEqualTo(favourId);
//		gasTradeFavourDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据favourDefinitionId删除gas_trade_favour表数据
//	 */
//	public void cleanGasTradeFavourByFavourDefinitionId(String favourDefinitionId) {
//        if (StringUtils.isBlank(favourDefinitionId)){
//            favourDefinitionId = "test_favourDefinitionId";
//        }
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourDefinitionIdEqualTo(favourDefinitionId);
//		gasTradeFavourDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据campaignName删除gas_trade_favour表数据
//	*/
//	public void cleanGasTradeFavourByCampaignName(String campaignName) {
//        if (StringUtils.isBlank(campaignName)){
//            campaignName = "test_campaignName";
//        }
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andCampaignNameEqualTo(campaignName);
//		gasTradeFavourDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据favourName删除gas_trade_favour表数据
//	*/
//	public void cleanGasTradeFavourByFavourName(String favourName) {
//        if (StringUtils.isBlank(favourName)){
//            favourName = "test_favourName";
//        }
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourNameEqualTo(favourName);
//		gasTradeFavourDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_favour表所有数据
//     */
//    public List<GasTradeFavourDO> findGasTradeFavourAll() {
//        GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//        exam.createCriteria();
//		return gasTradeFavourDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_favour表数据
//	 */
//	public List<GasTradeFavourDO> findGasTradeFavourById(long id) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeFavourDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_favour表数据
//	 */
//	public List<GasTradeFavourDO> findGasTradeFavourByBizNo(String bizNo) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeFavourDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据favourId查询gas_trade_favour表数据
//	 */
//	public List<GasTradeFavourDO> findGasTradeFavourByFavourId(String favourId) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourIdEqualTo(favourId);
//		return gasTradeFavourDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据favourDefinitionId查询gas_trade_favour表数据
//	 */
//	public List<GasTradeFavourDO> findGasTradeFavourByFavourDefinitionId(String favourDefinitionId) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourDefinitionIdEqualTo(favourDefinitionId);
//		return gasTradeFavourDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据campaignName查询gas_trade_favour表数据
//	*/
//	public List<GasTradeFavourDO> findGasTradeFavourByCampaignName(String campaignName) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andCampaignNameEqualTo(campaignName);
//		return gasTradeFavourDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据favourName查询gas_trade_favour表数据
//	*/
//	public List<GasTradeFavourDO> findGasTradeFavourByFavourName(String favourName) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourNameEqualTo(favourName);
//		return gasTradeFavourDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_favour表数据
//	 */
//	public void updateGasTradeFavourById(long id,GasTradeFavourDO gasTradeFavourDO) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_favour表数据
//	 */
//	public void updateGasTradeFavourByBizNo(String bizNo,GasTradeFavourDO gasTradeFavourDO) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
//	}
//
//    /**
//	 * 根据favourId更新gas_trade_favour表数据
//	 */
//	public void updateGasTradeFavourByFavourId(String favourId,GasTradeFavourDO gasTradeFavourDO) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourIdEqualTo(favourId);
//		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
//	}
//
//    /**
//	 * 根据favourDefinitionId更新gas_trade_favour表数据
//	 */
//	public void updateGasTradeFavourByFavourDefinitionId(String favourDefinitionId,GasTradeFavourDO gasTradeFavourDO) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourDefinitionIdEqualTo(favourDefinitionId);
//		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
//	}
//
//	/**
//	* 根据campaignName更新gas_trade_favour表数据
//	*/
//	public void updateGasTradeFavourByCampaignName(String campaignName,GasTradeFavourDO gasTradeFavourDO) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andCampaignNameEqualTo(campaignName);
//		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
//	}
//
//	/**
//	* 根据favourName更新gas_trade_favour表数据
//	*/
//	public void updateGasTradeFavourByFavourName(String favourName,GasTradeFavourDO gasTradeFavourDO) {
//		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
//		exam.createCriteria().andFavourNameEqualTo(favourName);
//		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_give表
//	 */
//	public void gasTradeGiveAssert(
//	        GasTradeGiveDO gasTradeGiveDO,
//			long id,
//			String bizNo,
//			String tradeType,
//			String campaignName,
//			String giveId,
//			String giveDefinitionId,
//			String giveName,
//			String giveType,
//			String giveContent,
//			String giveIndex,
//			long giveAmount,
//			Integer giveNum,
//			String giveObj,
//			String userId,
//			String realName,
//			String nickName,
//			String mobile,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeGiveDO.getId());
//        assertEquals(bizNo, gasTradeGiveDO.getBizNo());
//        assertEquals(tradeType, gasTradeGiveDO.getTradeType());
//        assertEquals(campaignName, gasTradeGiveDO.getCampaignName());
//        assertEquals(giveId, gasTradeGiveDO.getGiveId());
//        assertEquals(giveDefinitionId, gasTradeGiveDO.getGiveDefinitionId());
//        assertEquals(giveName, gasTradeGiveDO.getGiveName());
//        assertEquals(giveType, gasTradeGiveDO.getGiveType());
//        assertEquals(giveContent, gasTradeGiveDO.getGiveContent());
//        assertEquals(giveIndex, gasTradeGiveDO.getGiveIndex());
//        assertEquals(giveAmount, gasTradeGiveDO.getGiveAmount());
//        assertEquals(giveNum, gasTradeGiveDO.getGiveNum());
//        assertEquals(giveObj, gasTradeGiveDO.getGiveObj());
//        assertEquals(userId, gasTradeGiveDO.getUserId());
//        assertEquals(realName, gasTradeGiveDO.getRealName());
//        assertEquals(nickName, gasTradeGiveDO.getNickName());
//        assertEquals(mobile, gasTradeGiveDO.getMobile());
//        assertEquals(rawAddTime, gasTradeGiveDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeGiveDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_give表数据
//	 */
//	public void assertGasTradeGive(GasTradeGiveDO expect, GasTradeGiveDO gasTradeGiveDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeGiveDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeGiveDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeGiveDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeGiveDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeGiveDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeGiveDO);
//	}
//
//    /**
//	 * 插入gas_trade_give表数据
//	 */
//	public void insertGasTradeGive(GasTradeGiveDO gasTradeGiveDO) {
//		gasTradeGiveDAO.insert(gasTradeGiveDO);
//	}
//
//    /**
//	 * 插入gas_trade_give表数据
//	 */
//	public void insertGasTradeGive(
//			long id,
//			String bizNo,
//			String tradeType,
//			String campaignName,
//			String giveId,
//			String giveDefinitionId,
//			String giveName,
//			String giveType,
//			String giveContent,
//			String giveIndex,
//			long giveAmount,
//			Integer giveNum,
//			String giveObj,
//			String userId,
//			String realName,
//			String nickName,
//			String mobile,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeGiveDO gasTradeGiveDO = new GasTradeGiveDO();
//		gasTradeGiveDO.setId(id);
//		gasTradeGiveDO.setBizNo(bizNo);
//		gasTradeGiveDO.setTradeType(tradeType);
//		gasTradeGiveDO.setCampaignName(campaignName);
//		gasTradeGiveDO.setGiveId(giveId);
//		gasTradeGiveDO.setGiveDefinitionId(giveDefinitionId);
//		gasTradeGiveDO.setGiveName(giveName);
//		gasTradeGiveDO.setGiveType(giveType);
//		gasTradeGiveDO.setGiveContent(giveContent);
//		gasTradeGiveDO.setGiveIndex(giveIndex);
//		gasTradeGiveDO.setGiveAmount(giveAmount);
//		gasTradeGiveDO.setGiveNum(giveNum);
//		gasTradeGiveDO.setGiveObj(giveObj);
//		gasTradeGiveDO.setUserId(userId);
//		gasTradeGiveDO.setRealName(realName);
//		gasTradeGiveDO.setNickName(nickName);
//		gasTradeGiveDO.setMobile(mobile);
//		gasTradeGiveDO.setRawAddTime(rawAddTime);
//		gasTradeGiveDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeGiveDAO.insert(gasTradeGiveDO);
//	}
//
//    /**
//     * 删除gas_trade_give表所有数据
//     */
//    public void cleanGasTradeGive() {
//        GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//        exam.createCriteria();
//        gasTradeGiveDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_give表数据
//	 */
//	public void cleanGasTradeGiveById(long id) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_give表数据
//	 */
//	public void cleanGasTradeGiveByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据campaignName删除gas_trade_give表数据
//	*/
//	public void cleanGasTradeGiveByCampaignName(String campaignName) {
//        if (StringUtils.isBlank(campaignName)){
//            campaignName = "test_campaignName";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andCampaignNameEqualTo(campaignName);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据giveId删除gas_trade_give表数据
//	 */
//	public void cleanGasTradeGiveByGiveId(String giveId) {
//        if (StringUtils.isBlank(giveId)){
//            giveId = "test_giveId";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveIdEqualTo(giveId);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据giveDefinitionId删除gas_trade_give表数据
//	 */
//	public void cleanGasTradeGiveByGiveDefinitionId(String giveDefinitionId) {
//        if (StringUtils.isBlank(giveDefinitionId)){
//            giveDefinitionId = "test_giveDefinitionId";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveDefinitionIdEqualTo(giveDefinitionId);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据giveName删除gas_trade_give表数据
//	*/
//	public void cleanGasTradeGiveByGiveName(String giveName) {
//        if (StringUtils.isBlank(giveName)){
//            giveName = "test_giveName";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveNameEqualTo(giveName);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据userId删除gas_trade_give表数据
//	 */
//	public void cleanGasTradeGiveByUserId(String userId) {
//        if (StringUtils.isBlank(userId)){
//            userId = "test_userId";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据realName删除gas_trade_give表数据
//	*/
//	public void cleanGasTradeGiveByRealName(String realName) {
//        if (StringUtils.isBlank(realName)){
//            realName = "test_realName";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据nickName删除gas_trade_give表数据
//	*/
//	public void cleanGasTradeGiveByNickName(String nickName) {
//        if (StringUtils.isBlank(nickName)){
//            nickName = "test_nickName";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据mobile删除gas_trade_give表数据
//	 */
//	public void cleanGasTradeGiveByMobile(String mobile) {
//        if (StringUtils.isBlank(mobile)){
//            mobile = "test_mobile";
//        }
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeGiveDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_give表所有数据
//     */
//    public List<GasTradeGiveDO> findGasTradeGiveAll() {
//        GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//        exam.createCriteria();
//		return gasTradeGiveDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_give表数据
//	 */
//	public List<GasTradeGiveDO> findGasTradeGiveById(long id) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_give表数据
//	 */
//	public List<GasTradeGiveDO> findGasTradeGiveByBizNo(String bizNo) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据campaignName查询gas_trade_give表数据
//	*/
//	public List<GasTradeGiveDO> findGasTradeGiveByCampaignName(String campaignName) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andCampaignNameEqualTo(campaignName);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据giveId查询gas_trade_give表数据
//	 */
//	public List<GasTradeGiveDO> findGasTradeGiveByGiveId(String giveId) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveIdEqualTo(giveId);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据giveDefinitionId查询gas_trade_give表数据
//	 */
//	public List<GasTradeGiveDO> findGasTradeGiveByGiveDefinitionId(String giveDefinitionId) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveDefinitionIdEqualTo(giveDefinitionId);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据giveName查询gas_trade_give表数据
//	*/
//	public List<GasTradeGiveDO> findGasTradeGiveByGiveName(String giveName) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveNameEqualTo(giveName);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据userId查询gas_trade_give表数据
//	 */
//	public List<GasTradeGiveDO> findGasTradeGiveByUserId(String userId) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据realName查询gas_trade_give表数据
//	*/
//	public List<GasTradeGiveDO> findGasTradeGiveByRealName(String realName) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据nickName查询gas_trade_give表数据
//	*/
//	public List<GasTradeGiveDO> findGasTradeGiveByNickName(String nickName) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据mobile查询gas_trade_give表数据
//	 */
//	public List<GasTradeGiveDO> findGasTradeGiveByMobile(String mobile) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		return gasTradeGiveDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_give表数据
//	 */
//	public void updateGasTradeGiveById(long id,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_give表数据
//	 */
//	public void updateGasTradeGiveByBizNo(String bizNo,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//	/**
//	* 根据campaignName更新gas_trade_give表数据
//	*/
//	public void updateGasTradeGiveByCampaignName(String campaignName,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andCampaignNameEqualTo(campaignName);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//    /**
//	 * 根据giveId更新gas_trade_give表数据
//	 */
//	public void updateGasTradeGiveByGiveId(String giveId,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveIdEqualTo(giveId);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//    /**
//	 * 根据giveDefinitionId更新gas_trade_give表数据
//	 */
//	public void updateGasTradeGiveByGiveDefinitionId(String giveDefinitionId,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveDefinitionIdEqualTo(giveDefinitionId);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//	/**
//	* 根据giveName更新gas_trade_give表数据
//	*/
//	public void updateGasTradeGiveByGiveName(String giveName,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andGiveNameEqualTo(giveName);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//    /**
//	 * 根据userId更新gas_trade_give表数据
//	 */
//	public void updateGasTradeGiveByUserId(String userId,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//	/**
//	* 根据realName更新gas_trade_give表数据
//	*/
//	public void updateGasTradeGiveByRealName(String realName,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//	/**
//	* 根据nickName更新gas_trade_give表数据
//	*/
//	public void updateGasTradeGiveByNickName(String nickName,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//    /**
//	 * 根据mobile更新gas_trade_give表数据
//	 */
//	public void updateGasTradeGiveByMobile(String mobile,GasTradeGiveDO gasTradeGiveDO) {
//		GasTradeGiveDOExample exam = new GasTradeGiveDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeGiveDAO.updateByExample(gasTradeGiveDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_goods表
//	 */
//	public void gasTradeGoodsAssert(
//	        GasTradeGoodsDO gasTradeGoodsDO,
//			long id,
//			String bizNo,
//			String tradeNo,
//			String goodsType,
//			String code,
//			String goodsName,
//			long price,
//			Integer piece,
//			long amount,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeGoodsDO.getId());
//        assertEquals(bizNo, gasTradeGoodsDO.getBizNo());
//        assertEquals(tradeNo, gasTradeGoodsDO.getTradeNo());
//        assertEquals(goodsType, gasTradeGoodsDO.getGoodsType());
//        assertEquals(code, gasTradeGoodsDO.getCode());
//        assertEquals(goodsName, gasTradeGoodsDO.getGoodsName());
//        assertEquals(price, gasTradeGoodsDO.getPrice());
//        assertEquals(piece, gasTradeGoodsDO.getPiece());
//        assertEquals(amount, gasTradeGoodsDO.getAmount());
//        assertEquals(rawAddTime, gasTradeGoodsDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeGoodsDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_goods表数据
//	 */
//	public void assertGasTradeGoods(GasTradeGoodsDO expect, GasTradeGoodsDO gasTradeGoodsDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeGoodsDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeGoodsDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeGoodsDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeGoodsDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeGoodsDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeGoodsDO);
//	}
//
//    /**
//	 * 插入gas_trade_goods表数据
//	 */
//	public void insertGasTradeGoods(GasTradeGoodsDO gasTradeGoodsDO) {
//		gasTradeGoodsDAO.insert(gasTradeGoodsDO);
//	}
//
//    /**
//	 * 插入gas_trade_goods表数据
//	 */
//	public void insertGasTradeGoods(
//			long id,
//			String bizNo,
//			String tradeNo,
//			String goodsType,
//			String code,
//			String goodsName,
//			long price,
//			Integer piece,
//			long amount,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeGoodsDO gasTradeGoodsDO = new GasTradeGoodsDO();
//		gasTradeGoodsDO.setId(id);
//		gasTradeGoodsDO.setBizNo(bizNo);
//		gasTradeGoodsDO.setTradeNo(tradeNo);
//		gasTradeGoodsDO.setGoodsType(goodsType);
//		gasTradeGoodsDO.setCode(code);
//		gasTradeGoodsDO.setGoodsName(goodsName);
//		gasTradeGoodsDO.setPrice(price);
//		gasTradeGoodsDO.setPiece(piece);
//		gasTradeGoodsDO.setAmount(amount);
//		gasTradeGoodsDO.setRawAddTime(rawAddTime);
//		gasTradeGoodsDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeGoodsDAO.insert(gasTradeGoodsDO);
//	}
//
//    /**
//     * 删除gas_trade_goods表所有数据
//     */
//    public void cleanGasTradeGoods() {
//        GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//        exam.createCriteria();
//        gasTradeGoodsDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_goods表数据
//	 */
//	public void cleanGasTradeGoodsById(long id) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeGoodsDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_goods表数据
//	 */
//	public void cleanGasTradeGoodsByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeGoodsDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据tradeNo删除gas_trade_goods表数据
//	 */
//	public void cleanGasTradeGoodsByTradeNo(String tradeNo) {
//        if (StringUtils.isBlank(tradeNo)){
//            tradeNo = "test_tradeNo";
//        }
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeGoodsDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_goods表数据
//	*/
//	public void cleanGasTradeGoodsByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeGoodsDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据goodsName删除gas_trade_goods表数据
//	*/
//	public void cleanGasTradeGoodsByGoodsName(String goodsName) {
//        if (StringUtils.isBlank(goodsName)){
//            goodsName = "test_goodsName";
//        }
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andGoodsNameEqualTo(goodsName);
//		gasTradeGoodsDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_goods表所有数据
//     */
//    public List<GasTradeGoodsDO> findGasTradeGoodsAll() {
//        GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//        exam.createCriteria();
//		return gasTradeGoodsDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_goods表数据
//	 */
//	public List<GasTradeGoodsDO> findGasTradeGoodsById(long id) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeGoodsDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_goods表数据
//	 */
//	public List<GasTradeGoodsDO> findGasTradeGoodsByBizNo(String bizNo) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeGoodsDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据tradeNo查询gas_trade_goods表数据
//	 */
//	public List<GasTradeGoodsDO> findGasTradeGoodsByTradeNo(String tradeNo) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		return gasTradeGoodsDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_goods表数据
//	*/
//	public List<GasTradeGoodsDO> findGasTradeGoodsByCode(String code) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradeGoodsDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据goodsName查询gas_trade_goods表数据
//	*/
//	public List<GasTradeGoodsDO> findGasTradeGoodsByGoodsName(String goodsName) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andGoodsNameEqualTo(goodsName);
//		return gasTradeGoodsDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_goods表数据
//	 */
//	public void updateGasTradeGoodsById(long id,GasTradeGoodsDO gasTradeGoodsDO) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_goods表数据
//	 */
//	public void updateGasTradeGoodsByBizNo(String bizNo,GasTradeGoodsDO gasTradeGoodsDO) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
//	}
//
//    /**
//	 * 根据tradeNo更新gas_trade_goods表数据
//	 */
//	public void updateGasTradeGoodsByTradeNo(String tradeNo,GasTradeGoodsDO gasTradeGoodsDO) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_goods表数据
//	*/
//	public void updateGasTradeGoodsByCode(String code,GasTradeGoodsDO gasTradeGoodsDO) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
//	}
//
//	/**
//	* 根据goodsName更新gas_trade_goods表数据
//	*/
//	public void updateGasTradeGoodsByGoodsName(String goodsName,GasTradeGoodsDO gasTradeGoodsDO) {
//		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
//		exam.createCriteria().andGoodsNameEqualTo(goodsName);
//		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_notify_task表
//	 */
//	public void gasTradeNotifyTaskAssert(
//	        GasTradeNotifyTaskDO gasTradeNotifyTaskDO,
//			long id,
//			String bizNo,
//			String notifyCategory,
//			String notifyType,
//			String status,
//			Integer retryCount,
//			Integer maxRetryCount,
//			String detail,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeNotifyTaskDO.getId());
//        assertEquals(bizNo, gasTradeNotifyTaskDO.getBizNo());
//        assertEquals(notifyCategory, gasTradeNotifyTaskDO.getNotifyCategory());
//        assertEquals(notifyType, gasTradeNotifyTaskDO.getNotifyType());
//        assertEquals(status, gasTradeNotifyTaskDO.getStatus());
//        assertEquals(retryCount, gasTradeNotifyTaskDO.getRetryCount());
//        assertEquals(maxRetryCount, gasTradeNotifyTaskDO.getMaxRetryCount());
//        assertEquals(detail, gasTradeNotifyTaskDO.getDetail());
//        assertEquals(rawAddTime, gasTradeNotifyTaskDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeNotifyTaskDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_notify_task表数据
//	 */
//	public void assertGasTradeNotifyTask(GasTradeNotifyTaskDO expect, GasTradeNotifyTaskDO gasTradeNotifyTaskDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeNotifyTaskDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeNotifyTaskDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeNotifyTaskDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeNotifyTaskDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeNotifyTaskDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeNotifyTaskDO);
//	}
//
//    /**
//	 * 插入gas_trade_notify_task表数据
//	 */
//	public void insertGasTradeNotifyTask(GasTradeNotifyTaskDO gasTradeNotifyTaskDO) {
//		gasTradeNotifyTaskDAO.insert(gasTradeNotifyTaskDO);
//	}
//
//    /**
//	 * 插入gas_trade_notify_task表数据
//	 */
//	public void insertGasTradeNotifyTask(
//			long id,
//			String bizNo,
//			String notifyCategory,
//			String notifyType,
//			String status,
//			Integer retryCount,
//			Integer maxRetryCount,
//			String detail,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeNotifyTaskDO gasTradeNotifyTaskDO = new GasTradeNotifyTaskDO();
//		gasTradeNotifyTaskDO.setId(id);
//		gasTradeNotifyTaskDO.setBizNo(bizNo);
//		gasTradeNotifyTaskDO.setNotifyCategory(notifyCategory);
//		gasTradeNotifyTaskDO.setNotifyType(notifyType);
//		gasTradeNotifyTaskDO.setStatus(status);
//		gasTradeNotifyTaskDO.setRetryCount(retryCount);
//		gasTradeNotifyTaskDO.setMaxRetryCount(maxRetryCount);
//		gasTradeNotifyTaskDO.setDetail(detail);
//		gasTradeNotifyTaskDO.setRawAddTime(rawAddTime);
//		gasTradeNotifyTaskDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeNotifyTaskDAO.insert(gasTradeNotifyTaskDO);
//	}
//
//    /**
//     * 删除gas_trade_notify_task表所有数据
//     */
//    public void cleanGasTradeNotifyTask() {
//        GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//        exam.createCriteria();
//        gasTradeNotifyTaskDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_notify_task表数据
//	 */
//	public void cleanGasTradeNotifyTaskById(long id) {
//		GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeNotifyTaskDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_notify_task表数据
//	 */
//	public void cleanGasTradeNotifyTaskByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeNotifyTaskDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_notify_task表所有数据
//     */
//    public List<GasTradeNotifyTaskDO> findGasTradeNotifyTaskAll() {
//        GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//        exam.createCriteria();
//		return gasTradeNotifyTaskDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_notify_task表数据
//	 */
//	public List<GasTradeNotifyTaskDO> findGasTradeNotifyTaskById(long id) {
//		GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeNotifyTaskDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_notify_task表数据
//	 */
//	public List<GasTradeNotifyTaskDO> findGasTradeNotifyTaskByBizNo(String bizNo) {
//		GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeNotifyTaskDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_notify_task表数据
//	 */
//	public void updateGasTradeNotifyTaskById(long id,GasTradeNotifyTaskDO gasTradeNotifyTaskDO) {
//		GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeNotifyTaskDAO.updateByExample(gasTradeNotifyTaskDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_notify_task表数据
//	 */
//	public void updateGasTradeNotifyTaskByBizNo(String bizNo,GasTradeNotifyTaskDO gasTradeNotifyTaskDO) {
//		GasTradeNotifyTaskDOExample exam = new GasTradeNotifyTaskDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeNotifyTaskDAO.updateByExample(gasTradeNotifyTaskDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_notify_task_wash表
//	 */
//	public void gasTradeNotifyTaskWashAssert(
//	        GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO,
//			long id,
//			String bizNo,
//			String notifyCategory,
//			String notifyType,
//			String status,
//			Integer retryCount,
//			Integer maxRetryCount,
//			String detail,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeNotifyTaskWashDO.getId());
//        assertEquals(bizNo, gasTradeNotifyTaskWashDO.getBizNo());
//        assertEquals(notifyCategory, gasTradeNotifyTaskWashDO.getNotifyCategory());
//        assertEquals(notifyType, gasTradeNotifyTaskWashDO.getNotifyType());
//        assertEquals(status, gasTradeNotifyTaskWashDO.getStatus());
//        assertEquals(retryCount, gasTradeNotifyTaskWashDO.getRetryCount());
//        assertEquals(maxRetryCount, gasTradeNotifyTaskWashDO.getMaxRetryCount());
//        assertEquals(detail, gasTradeNotifyTaskWashDO.getDetail());
//        assertEquals(rawAddTime, gasTradeNotifyTaskWashDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeNotifyTaskWashDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_notify_task_wash表数据
//	 */
//	public void assertGasTradeNotifyTaskWash(GasTradeNotifyTaskWashDO expect, GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeNotifyTaskWashDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeNotifyTaskWashDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeNotifyTaskWashDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeNotifyTaskWashDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeNotifyTaskWashDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeNotifyTaskWashDO);
//	}
//
//    /**
//	 * 插入gas_trade_notify_task_wash表数据
//	 */
//	public void insertGasTradeNotifyTaskWash(GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
//		gasTradeNotifyTaskWashDAO.insert(gasTradeNotifyTaskWashDO);
//	}
//
//    /**
//	 * 插入gas_trade_notify_task_wash表数据
//	 */
//	public void insertGasTradeNotifyTaskWash(
//			long id,
//			String bizNo,
//			String notifyCategory,
//			String notifyType,
//			String status,
//			Integer retryCount,
//			Integer maxRetryCount,
//			String detail,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO = new GasTradeNotifyTaskWashDO();
//		gasTradeNotifyTaskWashDO.setId(id);
//		gasTradeNotifyTaskWashDO.setBizNo(bizNo);
//		gasTradeNotifyTaskWashDO.setNotifyCategory(notifyCategory);
//		gasTradeNotifyTaskWashDO.setNotifyType(notifyType);
//		gasTradeNotifyTaskWashDO.setStatus(status);
//		gasTradeNotifyTaskWashDO.setRetryCount(retryCount);
//		gasTradeNotifyTaskWashDO.setMaxRetryCount(maxRetryCount);
//		gasTradeNotifyTaskWashDO.setDetail(detail);
//		gasTradeNotifyTaskWashDO.setRawAddTime(rawAddTime);
//		gasTradeNotifyTaskWashDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeNotifyTaskWashDAO.insert(gasTradeNotifyTaskWashDO);
//	}
//
//    /**
//     * 删除gas_trade_notify_task_wash表所有数据
//     */
//    public void cleanGasTradeNotifyTaskWash() {
//        GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//        exam.createCriteria();
//        gasTradeNotifyTaskWashDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_notify_task_wash表数据
//	 */
//	public void cleanGasTradeNotifyTaskWashById(long id) {
//		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeNotifyTaskWashDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_notify_task_wash表数据
//	 */
//	public void cleanGasTradeNotifyTaskWashByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeNotifyTaskWashDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_notify_task_wash表所有数据
//     */
//    public List<GasTradeNotifyTaskWashDO> findGasTradeNotifyTaskWashAll() {
//        GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//        exam.createCriteria();
//		return gasTradeNotifyTaskWashDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_notify_task_wash表数据
//	 */
//	public List<GasTradeNotifyTaskWashDO> findGasTradeNotifyTaskWashById(long id) {
//		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeNotifyTaskWashDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_notify_task_wash表数据
//	 */
//	public List<GasTradeNotifyTaskWashDO> findGasTradeNotifyTaskWashByBizNo(String bizNo) {
//		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeNotifyTaskWashDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_notify_task_wash表数据
//	 */
//	public void updateGasTradeNotifyTaskWashById(long id,GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
//		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeNotifyTaskWashDAO.updateByExample(gasTradeNotifyTaskWashDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_notify_task_wash表数据
//	 */
//	public void updateGasTradeNotifyTaskWashByBizNo(String bizNo,GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
//		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeNotifyTaskWashDAO.updateByExample(gasTradeNotifyTaskWashDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_oil表
//	 */
//	public void gasTradeOilAssert(
//	        GasTradeOilDO gasTradeOilDO,
//			long id,
//			String bizNo,
//			String tradeNo,
//			String oilType,
//			String code,
//			String oilName,
//			long price,
//			Double liter,
//			String oilGun,
//			long amount,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeOilDO.getId());
//        assertEquals(bizNo, gasTradeOilDO.getBizNo());
//        assertEquals(tradeNo, gasTradeOilDO.getTradeNo());
//        assertEquals(oilType, gasTradeOilDO.getOilType());
//        assertEquals(code, gasTradeOilDO.getCode());
//        assertEquals(oilName, gasTradeOilDO.getOilName());
//        assertEquals(price, gasTradeOilDO.getPrice());
//        assertEquals(liter, gasTradeOilDO.getLiter());
//        assertEquals(oilGun, gasTradeOilDO.getOilGun());
//        assertEquals(amount, gasTradeOilDO.getAmount());
//        assertEquals(rawAddTime, gasTradeOilDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeOilDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_oil表数据
//	 */
//	public void assertGasTradeOil(GasTradeOilDO expect, GasTradeOilDO gasTradeOilDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeOilDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeOilDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeOilDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeOilDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeOilDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeOilDO);
//	}
//
//    /**
//	 * 插入gas_trade_oil表数据
//	 */
//	public void insertGasTradeOil(GasTradeOilDO gasTradeOilDO) {
//		gasTradeOilDAO.insert(gasTradeOilDO);
//	}
//
//    /**
//	 * 插入gas_trade_oil表数据
//	 */
//	public void insertGasTradeOil(
//			long id,
//			String bizNo,
//			String tradeNo,
//			String oilType,
//			String code,
//			String oilName,
//			long price,
//			Double liter,
//			String oilGun,
//			long amount,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeOilDO gasTradeOilDO = new GasTradeOilDO();
//		gasTradeOilDO.setId(id);
//		gasTradeOilDO.setBizNo(bizNo);
//		gasTradeOilDO.setTradeNo(tradeNo);
//		gasTradeOilDO.setOilType(oilType);
//		gasTradeOilDO.setCode(code);
//		gasTradeOilDO.setOilName(oilName);
//		gasTradeOilDO.setPrice(price);
//		gasTradeOilDO.setLiter(liter);
//		gasTradeOilDO.setOilGun(oilGun);
//		gasTradeOilDO.setAmount(amount);
//		gasTradeOilDO.setRawAddTime(rawAddTime);
//		gasTradeOilDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeOilDAO.insert(gasTradeOilDO);
//	}
//
//    /**
//     * 删除gas_trade_oil表所有数据
//     */
//    public void cleanGasTradeOil() {
//        GasTradeOilDOExample exam = new GasTradeOilDOExample();
//        exam.createCriteria();
//        gasTradeOilDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_oil表数据
//	 */
//	public void cleanGasTradeOilById(long id) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeOilDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_oil表数据
//	 */
//	public void cleanGasTradeOilByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeOilDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据tradeNo删除gas_trade_oil表数据
//	 */
//	public void cleanGasTradeOilByTradeNo(String tradeNo) {
//        if (StringUtils.isBlank(tradeNo)){
//            tradeNo = "test_tradeNo";
//        }
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeOilDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_oil表数据
//	*/
//	public void cleanGasTradeOilByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeOilDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据oilName删除gas_trade_oil表数据
//	*/
//	public void cleanGasTradeOilByOilName(String oilName) {
//        if (StringUtils.isBlank(oilName)){
//            oilName = "test_oilName";
//        }
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andOilNameEqualTo(oilName);
//		gasTradeOilDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_oil表所有数据
//     */
//    public List<GasTradeOilDO> findGasTradeOilAll() {
//        GasTradeOilDOExample exam = new GasTradeOilDOExample();
//        exam.createCriteria();
//		return gasTradeOilDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_oil表数据
//	 */
//	public List<GasTradeOilDO> findGasTradeOilById(long id) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeOilDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_oil表数据
//	 */
//	public List<GasTradeOilDO> findGasTradeOilByBizNo(String bizNo) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeOilDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据tradeNo查询gas_trade_oil表数据
//	 */
//	public List<GasTradeOilDO> findGasTradeOilByTradeNo(String tradeNo) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		return gasTradeOilDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_oil表数据
//	*/
//	public List<GasTradeOilDO> findGasTradeOilByCode(String code) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradeOilDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据oilName查询gas_trade_oil表数据
//	*/
//	public List<GasTradeOilDO> findGasTradeOilByOilName(String oilName) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andOilNameEqualTo(oilName);
//		return gasTradeOilDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_oil表数据
//	 */
//	public void updateGasTradeOilById(long id,GasTradeOilDO gasTradeOilDO) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_oil表数据
//	 */
//	public void updateGasTradeOilByBizNo(String bizNo,GasTradeOilDO gasTradeOilDO) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
//	}
//
//    /**
//	 * 根据tradeNo更新gas_trade_oil表数据
//	 */
//	public void updateGasTradeOilByTradeNo(String tradeNo,GasTradeOilDO gasTradeOilDO) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_oil表数据
//	*/
//	public void updateGasTradeOilByCode(String code,GasTradeOilDO gasTradeOilDO) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
//	}
//
//	/**
//	* 根据oilName更新gas_trade_oil表数据
//	*/
//	public void updateGasTradeOilByOilName(String oilName,GasTradeOilDO gasTradeOilDO) {
//		GasTradeOilDOExample exam = new GasTradeOilDOExample();
//		exam.createCriteria().andOilNameEqualTo(oilName);
//		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_payment表
//	 */
//	public void gasTradePaymentAssert(
//	        GasTradePaymentDO gasTradePaymentDO,
//			long id,
//			String tradeType,
//			String orderType,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			String carNumber,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long favourAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			Integer expireTime,
//			String extensionContext,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradePaymentDO.getId());
//        assertEquals(tradeType, gasTradePaymentDO.getTradeType());
//        assertEquals(orderType, gasTradePaymentDO.getOrderType());
//        assertEquals(bizNo, gasTradePaymentDO.getBizNo());
//        assertEquals(reqId, gasTradePaymentDO.getReqId());
//        assertEquals(gid, gasTradePaymentDO.getGid());
//        assertEquals(partnerId, gasTradePaymentDO.getPartnerId());
//        assertEquals(partnerName, gasTradePaymentDO.getPartnerName());
//        assertEquals(stationId, gasTradePaymentDO.getStationId());
//        assertEquals(stationCode, gasTradePaymentDO.getStationCode());
//        assertEquals(stationName, gasTradePaymentDO.getStationName());
//        assertEquals(operateId, gasTradePaymentDO.getOperateId());
//        assertEquals(operateName, gasTradePaymentDO.getOperateName());
//        assertEquals(terminalType, gasTradePaymentDO.getTerminalType());
//        assertEquals(terminalCode, gasTradePaymentDO.getTerminalCode());
//        assertEquals(userId, gasTradePaymentDO.getUserId());
//        assertEquals(realName, gasTradePaymentDO.getRealName());
//        assertEquals(nickName, gasTradePaymentDO.getNickName());
//        assertEquals(memberType, gasTradePaymentDO.getMemberType());
//        assertEquals(mobile, gasTradePaymentDO.getMobile());
//        assertEquals(cardNo, gasTradePaymentDO.getCardNo());
//        assertEquals(cardType, gasTradePaymentDO.getCardType());
//        assertEquals(cardBizType, gasTradePaymentDO.getCardBizType());
//        assertEquals(carNumber, gasTradePaymentDO.getCarNumber());
//        assertEquals(balance, gasTradePaymentDO.getBalance());
//        assertEquals(requestNo, gasTradePaymentDO.getRequestNo());
//        assertEquals(payNo, gasTradePaymentDO.getPayNo());
//        assertEquals(tradePayType, gasTradePaymentDO.getTradePayType());
//        assertEquals(payModel, gasTradePaymentDO.getPayModel());
//        assertEquals(amount, gasTradePaymentDO.getAmount());
//        assertEquals(payAmount, gasTradePaymentDO.getPayAmount());
//        assertEquals(favourAmount, gasTradePaymentDO.getFavourAmount());
//        assertEquals(feeAmount, gasTradePaymentDO.getFeeAmount());
//        assertEquals(settlementAmount, gasTradePaymentDO.getSettlementAmount());
//        assertEquals(memo, gasTradePaymentDO.getMemo());
//        assertEquals(status, gasTradePaymentDO.getStatus());
//        assertEquals(state, gasTradePaymentDO.getState());
//        assertEquals(code, gasTradePaymentDO.getCode());
//        assertEquals(description, gasTradePaymentDO.getDescription());
//        assertEquals(runMemo, gasTradePaymentDO.getRunMemo());
//        assertEquals(expireTime, gasTradePaymentDO.getExpireTime());
//        assertEquals(extensionContext, gasTradePaymentDO.getExtensionContext());
//        assertEquals(finishTime, gasTradePaymentDO.getFinishTime());
//        assertEquals(clearTime, gasTradePaymentDO.getClearTime());
//        assertEquals(rawAddTime, gasTradePaymentDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradePaymentDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_payment表数据
//	 */
//	public void assertGasTradePayment(GasTradePaymentDO expect, GasTradePaymentDO gasTradePaymentDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradePaymentDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradePaymentDO.getRawAddTime());
//		expect.setRawAddTime(gasTradePaymentDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradePaymentDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradePaymentDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradePaymentDO);
//	}
//
//    /**
//	 * 插入gas_trade_payment表数据
//	 */
//	public void insertGasTradePayment(GasTradePaymentDO gasTradePaymentDO) {
//		gasTradePaymentDAO.insert(gasTradePaymentDO);
//	}
//
//    /**
//	 * 插入gas_trade_payment表数据
//	 */
//	public void insertGasTradePayment(
//			long id,
//			String tradeType,
//			String orderType,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			String carNumber,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long favourAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			Integer expireTime,
//			String extensionContext,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (finishTime == null) {
//			finishTime = new Date();
//		}
//		if (clearTime == null) {
//			clearTime = new Date();
//		}
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradePaymentDO gasTradePaymentDO = new GasTradePaymentDO();
//		gasTradePaymentDO.setId(id);
//		gasTradePaymentDO.setTradeType(tradeType);
//		gasTradePaymentDO.setOrderType(orderType);
//		gasTradePaymentDO.setBizNo(bizNo);
//		gasTradePaymentDO.setReqId(reqId);
//		gasTradePaymentDO.setGid(gid);
//		gasTradePaymentDO.setPartnerId(partnerId);
//		gasTradePaymentDO.setPartnerName(partnerName);
//		gasTradePaymentDO.setStationId(stationId);
//		gasTradePaymentDO.setStationCode(stationCode);
//		gasTradePaymentDO.setStationName(stationName);
//		gasTradePaymentDO.setOperateId(operateId);
//		gasTradePaymentDO.setOperateName(operateName);
//		gasTradePaymentDO.setTerminalType(terminalType);
//		gasTradePaymentDO.setTerminalCode(terminalCode);
//		gasTradePaymentDO.setUserId(userId);
//		gasTradePaymentDO.setRealName(realName);
//		gasTradePaymentDO.setNickName(nickName);
//		gasTradePaymentDO.setMemberType(memberType);
//		gasTradePaymentDO.setMobile(mobile);
//		gasTradePaymentDO.setCardNo(cardNo);
//		gasTradePaymentDO.setCardType(cardType);
//		gasTradePaymentDO.setCardBizType(cardBizType);
//		gasTradePaymentDO.setCarNumber(carNumber);
//		gasTradePaymentDO.setBalance(balance);
//		gasTradePaymentDO.setRequestNo(requestNo);
//		gasTradePaymentDO.setPayNo(payNo);
//		gasTradePaymentDO.setTradePayType(tradePayType);
//		gasTradePaymentDO.setPayModel(payModel);
//		gasTradePaymentDO.setAmount(amount);
//		gasTradePaymentDO.setPayAmount(payAmount);
//		gasTradePaymentDO.setFavourAmount(favourAmount);
//		gasTradePaymentDO.setFeeAmount(feeAmount);
//		gasTradePaymentDO.setSettlementAmount(settlementAmount);
//		gasTradePaymentDO.setMemo(memo);
//		gasTradePaymentDO.setStatus(status);
//		gasTradePaymentDO.setState(state);
//		gasTradePaymentDO.setCode(code);
//		gasTradePaymentDO.setDescription(description);
//		gasTradePaymentDO.setRunMemo(runMemo);
//		gasTradePaymentDO.setExpireTime(expireTime);
//		gasTradePaymentDO.setExtensionContext(extensionContext);
//		gasTradePaymentDO.setFinishTime(finishTime);
//		gasTradePaymentDO.setClearTime(clearTime);
//		gasTradePaymentDO.setRawAddTime(rawAddTime);
//		gasTradePaymentDO.setRawUpdateTime(rawUpdateTime);
//		gasTradePaymentDAO.insert(gasTradePaymentDO);
//	}
//
//    /**
//     * 删除gas_trade_payment表所有数据
//     */
//    public void cleanGasTradePayment() {
//        GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//        exam.createCriteria();
//        gasTradePaymentDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentById(long id) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据reqId删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByReqId(String reqId) {
//        if (StringUtils.isBlank(reqId)){
//            reqId = "test_reqId";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据gid删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByGid(String gid) {
//        if (StringUtils.isBlank(gid)){
//            gid = "test_gid";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据partnerId删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByPartnerId(String partnerId) {
//        if (StringUtils.isBlank(partnerId)){
//            partnerId = "test_partnerId";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据partnerName删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByPartnerName(String partnerName) {
//        if (StringUtils.isBlank(partnerName)){
//            partnerName = "test_partnerName";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据stationId删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByStationId(String stationId) {
//        if (StringUtils.isBlank(stationId)){
//            stationId = "test_stationId";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationCode删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByStationCode(String stationCode) {
//        if (StringUtils.isBlank(stationCode)){
//            stationCode = "test_stationCode";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationName删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByStationName(String stationName) {
//        if (StringUtils.isBlank(stationName)){
//            stationName = "test_stationName";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据operateId删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByOperateId(String operateId) {
//        if (StringUtils.isBlank(operateId)){
//            operateId = "test_operateId";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据operateName删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByOperateName(String operateName) {
//        if (StringUtils.isBlank(operateName)){
//            operateName = "test_operateName";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByTerminalCode(String terminalCode) {
//        if (StringUtils.isBlank(terminalCode)){
//            terminalCode = "test_terminalCode";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据userId删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByUserId(String userId) {
//        if (StringUtils.isBlank(userId)){
//            userId = "test_userId";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据realName删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByRealName(String realName) {
//        if (StringUtils.isBlank(realName)){
//            realName = "test_realName";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据nickName删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByNickName(String nickName) {
//        if (StringUtils.isBlank(nickName)){
//            nickName = "test_nickName";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据mobile删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByMobile(String mobile) {
//        if (StringUtils.isBlank(mobile)){
//            mobile = "test_mobile";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据cardNo删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByCardNo(String cardNo) {
//        if (StringUtils.isBlank(cardNo)){
//            cardNo = "test_cardNo";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据carNumber删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByCarNumber(String carNumber) {
//        if (StringUtils.isBlank(carNumber)){
//            carNumber = "test_carNumber";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据requestNo删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByRequestNo(String requestNo) {
//        if (StringUtils.isBlank(requestNo)){
//            requestNo = "test_requestNo";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据payNo删除gas_trade_payment表数据
//	 */
//	public void cleanGasTradePaymentByPayNo(String payNo) {
//        if (StringUtils.isBlank(payNo)){
//            payNo = "test_payNo";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_payment表数据
//	*/
//	public void cleanGasTradePaymentByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradePaymentDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_payment表所有数据
//     */
//    public List<GasTradePaymentDO> findGasTradePaymentAll() {
//        GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//        exam.createCriteria();
//		return gasTradePaymentDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentById(long id) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByBizNo(String bizNo) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据reqId查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByReqId(String reqId) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据gid查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByGid(String gid) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据partnerId查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByPartnerId(String partnerId) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据partnerName查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByPartnerName(String partnerName) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据stationId查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByStationId(String stationId) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationCode查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByStationCode(String stationCode) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationName查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByStationName(String stationName) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据operateId查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByOperateId(String operateId) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据operateName查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByOperateName(String operateName) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByTerminalCode(String terminalCode) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据userId查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByUserId(String userId) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据realName查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByRealName(String realName) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据nickName查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByNickName(String nickName) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据mobile查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByMobile(String mobile) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据cardNo查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByCardNo(String cardNo) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据carNumber查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByCarNumber(String carNumber) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据requestNo查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByRequestNo(String requestNo) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据payNo查询gas_trade_payment表数据
//	 */
//	public List<GasTradePaymentDO> findGasTradePaymentByPayNo(String payNo) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_payment表数据
//	*/
//	public List<GasTradePaymentDO> findGasTradePaymentByCode(String code) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradePaymentDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentById(long id,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByBizNo(String bizNo,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据reqId更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByReqId(String reqId,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据gid更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByGid(String gid,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据partnerId更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByPartnerId(String partnerId,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据partnerName更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByPartnerName(String partnerName,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据stationId更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByStationId(String stationId,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据stationCode更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByStationCode(String stationCode,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据stationName更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByStationName(String stationName,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据operateId更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByOperateId(String operateId,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据operateName更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByOperateName(String operateName,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据terminalCode更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByTerminalCode(String terminalCode,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据userId更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByUserId(String userId,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据realName更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByRealName(String realName,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据nickName更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByNickName(String nickName,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据mobile更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByMobile(String mobile,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据cardNo更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByCardNo(String cardNo,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据requestNo更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByRequestNo(String requestNo,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 根据payNo更新gas_trade_payment表数据
//	 */
//	public void updateGasTradePaymentByPayNo(String payNo,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_payment表数据
//	*/
//	public void updateGasTradePaymentByCode(String code,GasTradePaymentDO gasTradePaymentDO) {
//		GasTradePaymentDOExample exam = new GasTradePaymentDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradePaymentDAO.updateByExample(gasTradePaymentDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_points_redeem表
//	 */
//	public void gasTradePointsRedeemAssert(
//	        GasTradePointsRedeemDO gasTradePointsRedeemDO,
//			long id,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String goodsId,
//			String goodsType,
//			String goodsName,
//			String goodsImg,
//			String couponBizType,
//			String couponType,
//			Integer goodsNum,
//			String gainStyle,
//			String gainAdr,
//			String points,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String extensionContext,
//			Date finishTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradePointsRedeemDO.getId());
//        assertEquals(bizNo, gasTradePointsRedeemDO.getBizNo());
//        assertEquals(reqId, gasTradePointsRedeemDO.getReqId());
//        assertEquals(gid, gasTradePointsRedeemDO.getGid());
//        assertEquals(partnerId, gasTradePointsRedeemDO.getPartnerId());
//        assertEquals(partnerName, gasTradePointsRedeemDO.getPartnerName());
//        assertEquals(stationId, gasTradePointsRedeemDO.getStationId());
//        assertEquals(stationCode, gasTradePointsRedeemDO.getStationCode());
//        assertEquals(stationName, gasTradePointsRedeemDO.getStationName());
//        assertEquals(operateId, gasTradePointsRedeemDO.getOperateId());
//        assertEquals(operateName, gasTradePointsRedeemDO.getOperateName());
//        assertEquals(terminalType, gasTradePointsRedeemDO.getTerminalType());
//        assertEquals(terminalCode, gasTradePointsRedeemDO.getTerminalCode());
//        assertEquals(userId, gasTradePointsRedeemDO.getUserId());
//        assertEquals(realName, gasTradePointsRedeemDO.getRealName());
//        assertEquals(nickName, gasTradePointsRedeemDO.getNickName());
//        assertEquals(memberType, gasTradePointsRedeemDO.getMemberType());
//        assertEquals(mobile, gasTradePointsRedeemDO.getMobile());
//        assertEquals(goodsId, gasTradePointsRedeemDO.getGoodsId());
//        assertEquals(goodsType, gasTradePointsRedeemDO.getGoodsType());
//        assertEquals(goodsName, gasTradePointsRedeemDO.getGoodsName());
//        assertEquals(goodsImg, gasTradePointsRedeemDO.getGoodsImg());
//        assertEquals(couponBizType, gasTradePointsRedeemDO.getCouponBizType());
//        assertEquals(couponType, gasTradePointsRedeemDO.getCouponType());
//        assertEquals(goodsNum, gasTradePointsRedeemDO.getGoodsNum());
//        assertEquals(gainStyle, gasTradePointsRedeemDO.getGainStyle());
//        assertEquals(gainAdr, gasTradePointsRedeemDO.getGainAdr());
//        assertEquals(points, gasTradePointsRedeemDO.getPoints());
//        assertEquals(status, gasTradePointsRedeemDO.getStatus());
//        assertEquals(state, gasTradePointsRedeemDO.getState());
//        assertEquals(code, gasTradePointsRedeemDO.getCode());
//        assertEquals(description, gasTradePointsRedeemDO.getDescription());
//        assertEquals(runMemo, gasTradePointsRedeemDO.getRunMemo());
//        assertEquals(extensionContext, gasTradePointsRedeemDO.getExtensionContext());
//        assertEquals(finishTime, gasTradePointsRedeemDO.getFinishTime());
//        assertEquals(rawAddTime, gasTradePointsRedeemDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradePointsRedeemDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_points_redeem表数据
//	 */
//	public void assertGasTradePointsRedeem(GasTradePointsRedeemDO expect, GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradePointsRedeemDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradePointsRedeemDO.getRawAddTime());
//		expect.setRawAddTime(gasTradePointsRedeemDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradePointsRedeemDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradePointsRedeemDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradePointsRedeemDO);
//	}
//
//    /**
//	 * 插入gas_trade_points_redeem表数据
//	 */
//	public void insertGasTradePointsRedeem(GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		gasTradePointsRedeemDAO.insert(gasTradePointsRedeemDO);
//	}
//
//    /**
//	 * 插入gas_trade_points_redeem表数据
//	 */
//	public void insertGasTradePointsRedeem(
//			long id,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String goodsId,
//			String goodsType,
//			String goodsName,
//			String goodsImg,
//			String couponBizType,
//			String couponType,
//			Integer goodsNum,
//			String gainStyle,
//			String gainAdr,
//			String points,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String extensionContext,
//			Date finishTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (finishTime == null) {
//			finishTime = new Date();
//		}
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradePointsRedeemDO gasTradePointsRedeemDO = new GasTradePointsRedeemDO();
//		gasTradePointsRedeemDO.setId(id);
//		gasTradePointsRedeemDO.setBizNo(bizNo);
//		gasTradePointsRedeemDO.setReqId(reqId);
//		gasTradePointsRedeemDO.setGid(gid);
//		gasTradePointsRedeemDO.setPartnerId(partnerId);
//		gasTradePointsRedeemDO.setPartnerName(partnerName);
//		gasTradePointsRedeemDO.setStationId(stationId);
//		gasTradePointsRedeemDO.setStationCode(stationCode);
//		gasTradePointsRedeemDO.setStationName(stationName);
//		gasTradePointsRedeemDO.setOperateId(operateId);
//		gasTradePointsRedeemDO.setOperateName(operateName);
//		gasTradePointsRedeemDO.setTerminalType(terminalType);
//		gasTradePointsRedeemDO.setTerminalCode(terminalCode);
//		gasTradePointsRedeemDO.setUserId(userId);
//		gasTradePointsRedeemDO.setRealName(realName);
//		gasTradePointsRedeemDO.setNickName(nickName);
//		gasTradePointsRedeemDO.setMemberType(memberType);
//		gasTradePointsRedeemDO.setMobile(mobile);
//		gasTradePointsRedeemDO.setGoodsId(goodsId);
//		gasTradePointsRedeemDO.setGoodsType(goodsType);
//		gasTradePointsRedeemDO.setGoodsName(goodsName);
//		gasTradePointsRedeemDO.setGoodsImg(goodsImg);
//		gasTradePointsRedeemDO.setCouponBizType(couponBizType);
//		gasTradePointsRedeemDO.setCouponType(couponType);
//		gasTradePointsRedeemDO.setGoodsNum(goodsNum);
//		gasTradePointsRedeemDO.setGainStyle(gainStyle);
//		gasTradePointsRedeemDO.setGainAdr(gainAdr);
//		gasTradePointsRedeemDO.setPoints(points);
//		gasTradePointsRedeemDO.setStatus(status);
//		gasTradePointsRedeemDO.setState(state);
//		gasTradePointsRedeemDO.setCode(code);
//		gasTradePointsRedeemDO.setDescription(description);
//		gasTradePointsRedeemDO.setRunMemo(runMemo);
//		gasTradePointsRedeemDO.setExtensionContext(extensionContext);
//		gasTradePointsRedeemDO.setFinishTime(finishTime);
//		gasTradePointsRedeemDO.setRawAddTime(rawAddTime);
//		gasTradePointsRedeemDO.setRawUpdateTime(rawUpdateTime);
//		gasTradePointsRedeemDAO.insert(gasTradePointsRedeemDO);
//	}
//
//    /**
//     * 删除gas_trade_points_redeem表所有数据
//     */
//    public void cleanGasTradePointsRedeem() {
//        GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//        exam.createCriteria();
//        gasTradePointsRedeemDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemById(long id) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据reqId删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByReqId(String reqId) {
//        if (StringUtils.isBlank(reqId)){
//            reqId = "test_reqId";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据gid删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByGid(String gid) {
//        if (StringUtils.isBlank(gid)){
//            gid = "test_gid";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据partnerId删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByPartnerId(String partnerId) {
//        if (StringUtils.isBlank(partnerId)){
//            partnerId = "test_partnerId";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据partnerName删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByPartnerName(String partnerName) {
//        if (StringUtils.isBlank(partnerName)){
//            partnerName = "test_partnerName";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据stationId删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByStationId(String stationId) {
//        if (StringUtils.isBlank(stationId)){
//            stationId = "test_stationId";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationCode删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByStationCode(String stationCode) {
//        if (StringUtils.isBlank(stationCode)){
//            stationCode = "test_stationCode";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationName删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByStationName(String stationName) {
//        if (StringUtils.isBlank(stationName)){
//            stationName = "test_stationName";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据operateId删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByOperateId(String operateId) {
//        if (StringUtils.isBlank(operateId)){
//            operateId = "test_operateId";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据operateName删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByOperateName(String operateName) {
//        if (StringUtils.isBlank(operateName)){
//            operateName = "test_operateName";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByTerminalCode(String terminalCode) {
//        if (StringUtils.isBlank(terminalCode)){
//            terminalCode = "test_terminalCode";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据userId删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByUserId(String userId) {
//        if (StringUtils.isBlank(userId)){
//            userId = "test_userId";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据realName删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByRealName(String realName) {
//        if (StringUtils.isBlank(realName)){
//            realName = "test_realName";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据nickName删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByNickName(String nickName) {
//        if (StringUtils.isBlank(nickName)){
//            nickName = "test_nickName";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据mobile删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByMobile(String mobile) {
//        if (StringUtils.isBlank(mobile)){
//            mobile = "test_mobile";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据goodsId删除gas_trade_points_redeem表数据
//	 */
//	public void cleanGasTradePointsRedeemByGoodsId(String goodsId) {
//        if (StringUtils.isBlank(goodsId)){
//            goodsId = "test_goodsId";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGoodsIdEqualTo(goodsId);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据goodsName删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByGoodsName(String goodsName) {
//        if (StringUtils.isBlank(goodsName)){
//            goodsName = "test_goodsName";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGoodsNameEqualTo(goodsName);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_points_redeem表数据
//	*/
//	public void cleanGasTradePointsRedeemByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradePointsRedeemDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_points_redeem表所有数据
//     */
//    public List<GasTradePointsRedeemDO> findGasTradePointsRedeemAll() {
//        GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//        exam.createCriteria();
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemById(long id) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByBizNo(String bizNo) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据reqId查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByReqId(String reqId) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据gid查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByGid(String gid) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据partnerId查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByPartnerId(String partnerId) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据partnerName查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByPartnerName(String partnerName) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据stationId查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByStationId(String stationId) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationCode查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByStationCode(String stationCode) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationName查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByStationName(String stationName) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据operateId查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByOperateId(String operateId) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据operateName查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByOperateName(String operateName) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByTerminalCode(String terminalCode) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据userId查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByUserId(String userId) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据realName查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByRealName(String realName) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据nickName查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByNickName(String nickName) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据mobile查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByMobile(String mobile) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据goodsId查询gas_trade_points_redeem表数据
//	 */
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByGoodsId(String goodsId) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGoodsIdEqualTo(goodsId);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据goodsName查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByGoodsName(String goodsName) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGoodsNameEqualTo(goodsName);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_points_redeem表数据
//	*/
//	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByCode(String code) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradePointsRedeemDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemById(long id,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByBizNo(String bizNo,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据reqId更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByReqId(String reqId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据gid更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByGid(String gid,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据partnerId更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByPartnerId(String partnerId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据partnerName更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByPartnerName(String partnerName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据stationId更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByStationId(String stationId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据stationCode更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByStationCode(String stationCode,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据stationName更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByStationName(String stationName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据operateId更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByOperateId(String operateId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据operateName更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByOperateName(String operateName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据terminalCode更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByTerminalCode(String terminalCode,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据userId更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByUserId(String userId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据realName更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByRealName(String realName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据nickName更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByNickName(String nickName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据mobile更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByMobile(String mobile,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 根据goodsId更新gas_trade_points_redeem表数据
//	 */
//	public void updateGasTradePointsRedeemByGoodsId(String goodsId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGoodsIdEqualTo(goodsId);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据goodsName更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByGoodsName(String goodsName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andGoodsNameEqualTo(goodsName);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_points_redeem表数据
//	*/
//	public void updateGasTradePointsRedeemByCode(String code,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
//		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_refund表
//	 */
//	public void gasTradeRefundAssert(
//	        GasTradeRefundDO gasTradeRefundDO,
//			long id,
//			String tradeType,
//			String bizNo,
//			String tradeNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			long balance,
//			String carNumber,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			Integer expireTime,
//			String extensionContext,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeRefundDO.getId());
//        assertEquals(tradeType, gasTradeRefundDO.getTradeType());
//        assertEquals(bizNo, gasTradeRefundDO.getBizNo());
//        assertEquals(tradeNo, gasTradeRefundDO.getTradeNo());
//        assertEquals(reqId, gasTradeRefundDO.getReqId());
//        assertEquals(gid, gasTradeRefundDO.getGid());
//        assertEquals(partnerId, gasTradeRefundDO.getPartnerId());
//        assertEquals(partnerName, gasTradeRefundDO.getPartnerName());
//        assertEquals(stationId, gasTradeRefundDO.getStationId());
//        assertEquals(stationCode, gasTradeRefundDO.getStationCode());
//        assertEquals(stationName, gasTradeRefundDO.getStationName());
//        assertEquals(operateId, gasTradeRefundDO.getOperateId());
//        assertEquals(operateName, gasTradeRefundDO.getOperateName());
//        assertEquals(terminalType, gasTradeRefundDO.getTerminalType());
//        assertEquals(terminalCode, gasTradeRefundDO.getTerminalCode());
//        assertEquals(userId, gasTradeRefundDO.getUserId());
//        assertEquals(realName, gasTradeRefundDO.getRealName());
//        assertEquals(nickName, gasTradeRefundDO.getNickName());
//        assertEquals(memberType, gasTradeRefundDO.getMemberType());
//        assertEquals(mobile, gasTradeRefundDO.getMobile());
//        assertEquals(cardNo, gasTradeRefundDO.getCardNo());
//        assertEquals(cardType, gasTradeRefundDO.getCardType());
//        assertEquals(cardBizType, gasTradeRefundDO.getCardBizType());
//        assertEquals(balance, gasTradeRefundDO.getBalance());
//        assertEquals(carNumber, gasTradeRefundDO.getCarNumber());
//        assertEquals(requestNo, gasTradeRefundDO.getRequestNo());
//        assertEquals(payNo, gasTradeRefundDO.getPayNo());
//        assertEquals(tradePayType, gasTradeRefundDO.getTradePayType());
//        assertEquals(payModel, gasTradeRefundDO.getPayModel());
//        assertEquals(amount, gasTradeRefundDO.getAmount());
//        assertEquals(payAmount, gasTradeRefundDO.getPayAmount());
//        assertEquals(feeAmount, gasTradeRefundDO.getFeeAmount());
//        assertEquals(settlementAmount, gasTradeRefundDO.getSettlementAmount());
//        assertEquals(memo, gasTradeRefundDO.getMemo());
//        assertEquals(status, gasTradeRefundDO.getStatus());
//        assertEquals(state, gasTradeRefundDO.getState());
//        assertEquals(code, gasTradeRefundDO.getCode());
//        assertEquals(description, gasTradeRefundDO.getDescription());
//        assertEquals(runMemo, gasTradeRefundDO.getRunMemo());
//        assertEquals(expireTime, gasTradeRefundDO.getExpireTime());
//        assertEquals(extensionContext, gasTradeRefundDO.getExtensionContext());
//        assertEquals(finishTime, gasTradeRefundDO.getFinishTime());
//        assertEquals(clearTime, gasTradeRefundDO.getClearTime());
//        assertEquals(rawAddTime, gasTradeRefundDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeRefundDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_refund表数据
//	 */
//	public void assertGasTradeRefund(GasTradeRefundDO expect, GasTradeRefundDO gasTradeRefundDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeRefundDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeRefundDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeRefundDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeRefundDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeRefundDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeRefundDO);
//	}
//
//    /**
//	 * 插入gas_trade_refund表数据
//	 */
//	public void insertGasTradeRefund(GasTradeRefundDO gasTradeRefundDO) {
//		gasTradeRefundDAO.insert(gasTradeRefundDO);
//	}
//
//    /**
//	 * 插入gas_trade_refund表数据
//	 */
//	public void insertGasTradeRefund(
//			long id,
//			String tradeType,
//			String bizNo,
//			String tradeNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String stationId,
//			String stationCode,
//			String stationName,
//			String operateId,
//			String operateName,
//			String terminalType,
//			String terminalCode,
//			String userId,
//			String realName,
//			String nickName,
//			String memberType,
//			String mobile,
//			String cardNo,
//			String cardType,
//			String cardBizType,
//			long balance,
//			String carNumber,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long feeAmount,
//			long settlementAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			Integer expireTime,
//			String extensionContext,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (finishTime == null) {
//			finishTime = new Date();
//		}
//		if (clearTime == null) {
//			clearTime = new Date();
//		}
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeRefundDO gasTradeRefundDO = new GasTradeRefundDO();
//		gasTradeRefundDO.setId(id);
//		gasTradeRefundDO.setTradeType(tradeType);
//		gasTradeRefundDO.setBizNo(bizNo);
//		gasTradeRefundDO.setTradeNo(tradeNo);
//		gasTradeRefundDO.setReqId(reqId);
//		gasTradeRefundDO.setGid(gid);
//		gasTradeRefundDO.setPartnerId(partnerId);
//		gasTradeRefundDO.setPartnerName(partnerName);
//		gasTradeRefundDO.setStationId(stationId);
//		gasTradeRefundDO.setStationCode(stationCode);
//		gasTradeRefundDO.setStationName(stationName);
//		gasTradeRefundDO.setOperateId(operateId);
//		gasTradeRefundDO.setOperateName(operateName);
//		gasTradeRefundDO.setTerminalType(terminalType);
//		gasTradeRefundDO.setTerminalCode(terminalCode);
//		gasTradeRefundDO.setUserId(userId);
//		gasTradeRefundDO.setRealName(realName);
//		gasTradeRefundDO.setNickName(nickName);
//		gasTradeRefundDO.setMemberType(memberType);
//		gasTradeRefundDO.setMobile(mobile);
//		gasTradeRefundDO.setCardNo(cardNo);
//		gasTradeRefundDO.setCardType(cardType);
//		gasTradeRefundDO.setCardBizType(cardBizType);
//		gasTradeRefundDO.setBalance(balance);
//		gasTradeRefundDO.setCarNumber(carNumber);
//		gasTradeRefundDO.setRequestNo(requestNo);
//		gasTradeRefundDO.setPayNo(payNo);
//		gasTradeRefundDO.setTradePayType(tradePayType);
//		gasTradeRefundDO.setPayModel(payModel);
//		gasTradeRefundDO.setAmount(amount);
//		gasTradeRefundDO.setPayAmount(payAmount);
//		gasTradeRefundDO.setFeeAmount(feeAmount);
//		gasTradeRefundDO.setSettlementAmount(settlementAmount);
//		gasTradeRefundDO.setMemo(memo);
//		gasTradeRefundDO.setStatus(status);
//		gasTradeRefundDO.setState(state);
//		gasTradeRefundDO.setCode(code);
//		gasTradeRefundDO.setDescription(description);
//		gasTradeRefundDO.setRunMemo(runMemo);
//		gasTradeRefundDO.setExpireTime(expireTime);
//		gasTradeRefundDO.setExtensionContext(extensionContext);
//		gasTradeRefundDO.setFinishTime(finishTime);
//		gasTradeRefundDO.setClearTime(clearTime);
//		gasTradeRefundDO.setRawAddTime(rawAddTime);
//		gasTradeRefundDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeRefundDAO.insert(gasTradeRefundDO);
//	}
//
//    /**
//     * 删除gas_trade_refund表所有数据
//     */
//    public void cleanGasTradeRefund() {
//        GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//        exam.createCriteria();
//        gasTradeRefundDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundById(long id) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据tradeNo删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByTradeNo(String tradeNo) {
//        if (StringUtils.isBlank(tradeNo)){
//            tradeNo = "test_tradeNo";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据reqId删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByReqId(String reqId) {
//        if (StringUtils.isBlank(reqId)){
//            reqId = "test_reqId";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据gid删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByGid(String gid) {
//        if (StringUtils.isBlank(gid)){
//            gid = "test_gid";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据partnerId删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByPartnerId(String partnerId) {
//        if (StringUtils.isBlank(partnerId)){
//            partnerId = "test_partnerId";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据partnerName删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByPartnerName(String partnerName) {
//        if (StringUtils.isBlank(partnerName)){
//            partnerName = "test_partnerName";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据stationId删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByStationId(String stationId) {
//        if (StringUtils.isBlank(stationId)){
//            stationId = "test_stationId";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationCode删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByStationCode(String stationCode) {
//        if (StringUtils.isBlank(stationCode)){
//            stationCode = "test_stationCode";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据stationName删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByStationName(String stationName) {
//        if (StringUtils.isBlank(stationName)){
//            stationName = "test_stationName";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据operateId删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByOperateId(String operateId) {
//        if (StringUtils.isBlank(operateId)){
//            operateId = "test_operateId";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据operateName删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByOperateName(String operateName) {
//        if (StringUtils.isBlank(operateName)){
//            operateName = "test_operateName";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByTerminalCode(String terminalCode) {
//        if (StringUtils.isBlank(terminalCode)){
//            terminalCode = "test_terminalCode";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据userId删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByUserId(String userId) {
//        if (StringUtils.isBlank(userId)){
//            userId = "test_userId";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据realName删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByRealName(String realName) {
//        if (StringUtils.isBlank(realName)){
//            realName = "test_realName";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据nickName删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByNickName(String nickName) {
//        if (StringUtils.isBlank(nickName)){
//            nickName = "test_nickName";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据mobile删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByMobile(String mobile) {
//        if (StringUtils.isBlank(mobile)){
//            mobile = "test_mobile";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据cardNo删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByCardNo(String cardNo) {
//        if (StringUtils.isBlank(cardNo)){
//            cardNo = "test_cardNo";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据carNumber删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByCarNumber(String carNumber) {
//        if (StringUtils.isBlank(carNumber)){
//            carNumber = "test_carNumber";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据requestNo删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByRequestNo(String requestNo) {
//        if (StringUtils.isBlank(requestNo)){
//            requestNo = "test_requestNo";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据payNo删除gas_trade_refund表数据
//	 */
//	public void cleanGasTradeRefundByPayNo(String payNo) {
//        if (StringUtils.isBlank(payNo)){
//            payNo = "test_payNo";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_refund表数据
//	*/
//	public void cleanGasTradeRefundByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeRefundDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_refund表所有数据
//     */
//    public List<GasTradeRefundDO> findGasTradeRefundAll() {
//        GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//        exam.createCriteria();
//		return gasTradeRefundDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundById(long id) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByBizNo(String bizNo) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据tradeNo查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByTradeNo(String tradeNo) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据reqId查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByReqId(String reqId) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据gid查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByGid(String gid) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据partnerId查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByPartnerId(String partnerId) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据partnerName查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByPartnerName(String partnerName) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据stationId查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByStationId(String stationId) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationCode查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByStationCode(String stationCode) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据stationName查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByStationName(String stationName) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据operateId查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByOperateId(String operateId) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据operateName查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByOperateName(String operateName) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据terminalCode查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByTerminalCode(String terminalCode) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据userId查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByUserId(String userId) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据realName查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByRealName(String realName) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据nickName查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByNickName(String nickName) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据mobile查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByMobile(String mobile) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据cardNo查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByCardNo(String cardNo) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据carNumber查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByCarNumber(String carNumber) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCarNumberEqualTo(carNumber);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据requestNo查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByRequestNo(String requestNo) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据payNo查询gas_trade_refund表数据
//	 */
//	public List<GasTradeRefundDO> findGasTradeRefundByPayNo(String payNo) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_refund表数据
//	*/
//	public List<GasTradeRefundDO> findGasTradeRefundByCode(String code) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradeRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundById(long id,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByBizNo(String bizNo,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据tradeNo更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByTradeNo(String tradeNo,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据reqId更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByReqId(String reqId,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据gid更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByGid(String gid,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据partnerId更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByPartnerId(String partnerId,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据partnerName更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByPartnerName(String partnerName,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据stationId更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByStationId(String stationId,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationIdEqualTo(stationId);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据stationCode更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByStationCode(String stationCode,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationCodeEqualTo(stationCode);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据stationName更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByStationName(String stationName,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andStationNameEqualTo(stationName);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据operateId更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByOperateId(String operateId,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andOperateIdEqualTo(operateId);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据operateName更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByOperateName(String operateName,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andOperateNameEqualTo(operateName);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据terminalCode更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByTerminalCode(String terminalCode,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据userId更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByUserId(String userId,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andUserIdEqualTo(userId);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据realName更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByRealName(String realName,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andRealNameEqualTo(realName);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据nickName更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByNickName(String nickName,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andNickNameEqualTo(nickName);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据mobile更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByMobile(String mobile,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andMobileEqualTo(mobile);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据cardNo更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByCardNo(String cardNo,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCardNoEqualTo(cardNo);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据requestNo更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByRequestNo(String requestNo,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 根据payNo更新gas_trade_refund表数据
//	 */
//	public void updateGasTradeRefundByPayNo(String payNo,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_refund表数据
//	*/
//	public void updateGasTradeRefundByCode(String code,GasTradeRefundDO gasTradeRefundDO) {
//		GasTradeRefundDOExample exam = new GasTradeRefundDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeRefundDAO.updateByExample(gasTradeRefundDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_revise表
//	 */
//	public void gasTradeReviseAssert(
//	        GasTradeReviseDO gasTradeReviseDO,
//			long id,
//			String tradeType,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long favourAmount,
//			long feeAmount,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String reviseType,
//			String reviseReason,
//			String bizStatus,
//			String advanceStatus,
//			String handleType,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeReviseDO.getId());
//        assertEquals(tradeType, gasTradeReviseDO.getTradeType());
//        assertEquals(bizNo, gasTradeReviseDO.getBizNo());
//        assertEquals(reqId, gasTradeReviseDO.getReqId());
//        assertEquals(gid, gasTradeReviseDO.getGid());
//        assertEquals(partnerId, gasTradeReviseDO.getPartnerId());
//        assertEquals(partnerName, gasTradeReviseDO.getPartnerName());
//        assertEquals(balance, gasTradeReviseDO.getBalance());
//        assertEquals(requestNo, gasTradeReviseDO.getRequestNo());
//        assertEquals(payNo, gasTradeReviseDO.getPayNo());
//        assertEquals(tradePayType, gasTradeReviseDO.getTradePayType());
//        assertEquals(payModel, gasTradeReviseDO.getPayModel());
//        assertEquals(amount, gasTradeReviseDO.getAmount());
//        assertEquals(payAmount, gasTradeReviseDO.getPayAmount());
//        assertEquals(favourAmount, gasTradeReviseDO.getFavourAmount());
//        assertEquals(feeAmount, gasTradeReviseDO.getFeeAmount());
//        assertEquals(status, gasTradeReviseDO.getStatus());
//        assertEquals(state, gasTradeReviseDO.getState());
//        assertEquals(code, gasTradeReviseDO.getCode());
//        assertEquals(description, gasTradeReviseDO.getDescription());
//        assertEquals(runMemo, gasTradeReviseDO.getRunMemo());
//        assertEquals(reviseType, gasTradeReviseDO.getReviseType());
//        assertEquals(reviseReason, gasTradeReviseDO.getReviseReason());
//        assertEquals(bizStatus, gasTradeReviseDO.getBizStatus());
//        assertEquals(advanceStatus, gasTradeReviseDO.getAdvanceStatus());
//        assertEquals(handleType, gasTradeReviseDO.getHandleType());
//        assertEquals(clearTime, gasTradeReviseDO.getClearTime());
//        assertEquals(rawAddTime, gasTradeReviseDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeReviseDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_revise表数据
//	 */
//	public void assertGasTradeRevise(GasTradeReviseDO expect, GasTradeReviseDO gasTradeReviseDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeReviseDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeReviseDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeReviseDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeReviseDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeReviseDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeReviseDO);
//	}
//
//    /**
//	 * 插入gas_trade_revise表数据
//	 */
//	public void insertGasTradeRevise(GasTradeReviseDO gasTradeReviseDO) {
//		gasTradeReviseDAO.insert(gasTradeReviseDO);
//	}
//
//    /**
//	 * 插入gas_trade_revise表数据
//	 */
//	public void insertGasTradeRevise(
//			long id,
//			String tradeType,
//			String bizNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			long balance,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			long favourAmount,
//			long feeAmount,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String reviseType,
//			String reviseReason,
//			String bizStatus,
//			String advanceStatus,
//			String handleType,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (clearTime == null) {
//			clearTime = new Date();
//		}
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeReviseDO gasTradeReviseDO = new GasTradeReviseDO();
//		gasTradeReviseDO.setId(id);
//		gasTradeReviseDO.setTradeType(tradeType);
//		gasTradeReviseDO.setBizNo(bizNo);
//		gasTradeReviseDO.setReqId(reqId);
//		gasTradeReviseDO.setGid(gid);
//		gasTradeReviseDO.setPartnerId(partnerId);
//		gasTradeReviseDO.setPartnerName(partnerName);
//		gasTradeReviseDO.setBalance(balance);
//		gasTradeReviseDO.setRequestNo(requestNo);
//		gasTradeReviseDO.setPayNo(payNo);
//		gasTradeReviseDO.setTradePayType(tradePayType);
//		gasTradeReviseDO.setPayModel(payModel);
//		gasTradeReviseDO.setAmount(amount);
//		gasTradeReviseDO.setPayAmount(payAmount);
//		gasTradeReviseDO.setFavourAmount(favourAmount);
//		gasTradeReviseDO.setFeeAmount(feeAmount);
//		gasTradeReviseDO.setStatus(status);
//		gasTradeReviseDO.setState(state);
//		gasTradeReviseDO.setCode(code);
//		gasTradeReviseDO.setDescription(description);
//		gasTradeReviseDO.setRunMemo(runMemo);
//		gasTradeReviseDO.setReviseType(reviseType);
//		gasTradeReviseDO.setReviseReason(reviseReason);
//		gasTradeReviseDO.setBizStatus(bizStatus);
//		gasTradeReviseDO.setAdvanceStatus(advanceStatus);
//		gasTradeReviseDO.setHandleType(handleType);
//		gasTradeReviseDO.setClearTime(clearTime);
//		gasTradeReviseDO.setRawAddTime(rawAddTime);
//		gasTradeReviseDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeReviseDAO.insert(gasTradeReviseDO);
//	}
//
//    /**
//     * 删除gas_trade_revise表所有数据
//     */
//    public void cleanGasTradeRevise() {
//        GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//        exam.createCriteria();
//        gasTradeReviseDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_revise表数据
//	 */
//	public void cleanGasTradeReviseById(long id) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_revise表数据
//	 */
//	public void cleanGasTradeReviseByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据reqId删除gas_trade_revise表数据
//	 */
//	public void cleanGasTradeReviseByReqId(String reqId) {
//        if (StringUtils.isBlank(reqId)){
//            reqId = "test_reqId";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据gid删除gas_trade_revise表数据
//	 */
//	public void cleanGasTradeReviseByGid(String gid) {
//        if (StringUtils.isBlank(gid)){
//            gid = "test_gid";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据partnerId删除gas_trade_revise表数据
//	 */
//	public void cleanGasTradeReviseByPartnerId(String partnerId) {
//        if (StringUtils.isBlank(partnerId)){
//            partnerId = "test_partnerId";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据partnerName删除gas_trade_revise表数据
//	*/
//	public void cleanGasTradeReviseByPartnerName(String partnerName) {
//        if (StringUtils.isBlank(partnerName)){
//            partnerName = "test_partnerName";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据requestNo删除gas_trade_revise表数据
//	 */
//	public void cleanGasTradeReviseByRequestNo(String requestNo) {
//        if (StringUtils.isBlank(requestNo)){
//            requestNo = "test_requestNo";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据payNo删除gas_trade_revise表数据
//	 */
//	public void cleanGasTradeReviseByPayNo(String payNo) {
//        if (StringUtils.isBlank(payNo)){
//            payNo = "test_payNo";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_revise表数据
//	*/
//	public void cleanGasTradeReviseByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeReviseDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_revise表所有数据
//     */
//    public List<GasTradeReviseDO> findGasTradeReviseAll() {
//        GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//        exam.createCriteria();
//		return gasTradeReviseDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_revise表数据
//	 */
//	public List<GasTradeReviseDO> findGasTradeReviseById(long id) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_revise表数据
//	 */
//	public List<GasTradeReviseDO> findGasTradeReviseByBizNo(String bizNo) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据reqId查询gas_trade_revise表数据
//	 */
//	public List<GasTradeReviseDO> findGasTradeReviseByReqId(String reqId) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据gid查询gas_trade_revise表数据
//	 */
//	public List<GasTradeReviseDO> findGasTradeReviseByGid(String gid) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据partnerId查询gas_trade_revise表数据
//	 */
//	public List<GasTradeReviseDO> findGasTradeReviseByPartnerId(String partnerId) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据partnerName查询gas_trade_revise表数据
//	*/
//	public List<GasTradeReviseDO> findGasTradeReviseByPartnerName(String partnerName) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据requestNo查询gas_trade_revise表数据
//	 */
//	public List<GasTradeReviseDO> findGasTradeReviseByRequestNo(String requestNo) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据payNo查询gas_trade_revise表数据
//	 */
//	public List<GasTradeReviseDO> findGasTradeReviseByPayNo(String payNo) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_revise表数据
//	*/
//	public List<GasTradeReviseDO> findGasTradeReviseByCode(String code) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradeReviseDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_revise表数据
//	 */
//	public void updateGasTradeReviseById(long id,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_revise表数据
//	 */
//	public void updateGasTradeReviseByBizNo(String bizNo,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//    /**
//	 * 根据reqId更新gas_trade_revise表数据
//	 */
//	public void updateGasTradeReviseByReqId(String reqId,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//    /**
//	 * 根据gid更新gas_trade_revise表数据
//	 */
//	public void updateGasTradeReviseByGid(String gid,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//    /**
//	 * 根据partnerId更新gas_trade_revise表数据
//	 */
//	public void updateGasTradeReviseByPartnerId(String partnerId,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//	/**
//	* 根据partnerName更新gas_trade_revise表数据
//	*/
//	public void updateGasTradeReviseByPartnerName(String partnerName,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//    /**
//	 * 根据requestNo更新gas_trade_revise表数据
//	 */
//	public void updateGasTradeReviseByRequestNo(String requestNo,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//    /**
//	 * 根据payNo更新gas_trade_revise表数据
//	 */
//	public void updateGasTradeReviseByPayNo(String payNo,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_revise表数据
//	*/
//	public void updateGasTradeReviseByCode(String code,GasTradeReviseDO gasTradeReviseDO) {
//		GasTradeReviseDOExample exam = new GasTradeReviseDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeReviseDAO.updateByExample(gasTradeReviseDO, exam);
//	}
//
//    /**
//	 * 断言gas_trade_revise_refund表
//	 */
//	public void gasTradeReviseRefundAssert(
//	        GasTradeReviseRefundDO gasTradeReviseRefundDO,
//			long id,
//			String tradeType,
//			String bizNo,
//			String tradeNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String extensionContext,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//        assertEquals(id, gasTradeReviseRefundDO.getId());
//        assertEquals(tradeType, gasTradeReviseRefundDO.getTradeType());
//        assertEquals(bizNo, gasTradeReviseRefundDO.getBizNo());
//        assertEquals(tradeNo, gasTradeReviseRefundDO.getTradeNo());
//        assertEquals(reqId, gasTradeReviseRefundDO.getReqId());
//        assertEquals(gid, gasTradeReviseRefundDO.getGid());
//        assertEquals(partnerId, gasTradeReviseRefundDO.getPartnerId());
//        assertEquals(partnerName, gasTradeReviseRefundDO.getPartnerName());
//        assertEquals(requestNo, gasTradeReviseRefundDO.getRequestNo());
//        assertEquals(payNo, gasTradeReviseRefundDO.getPayNo());
//        assertEquals(tradePayType, gasTradeReviseRefundDO.getTradePayType());
//        assertEquals(payModel, gasTradeReviseRefundDO.getPayModel());
//        assertEquals(amount, gasTradeReviseRefundDO.getAmount());
//        assertEquals(payAmount, gasTradeReviseRefundDO.getPayAmount());
//        assertEquals(memo, gasTradeReviseRefundDO.getMemo());
//        assertEquals(status, gasTradeReviseRefundDO.getStatus());
//        assertEquals(state, gasTradeReviseRefundDO.getState());
//        assertEquals(code, gasTradeReviseRefundDO.getCode());
//        assertEquals(description, gasTradeReviseRefundDO.getDescription());
//        assertEquals(runMemo, gasTradeReviseRefundDO.getRunMemo());
//        assertEquals(extensionContext, gasTradeReviseRefundDO.getExtensionContext());
//        assertEquals(finishTime, gasTradeReviseRefundDO.getFinishTime());
//        assertEquals(clearTime, gasTradeReviseRefundDO.getClearTime());
//        assertEquals(rawAddTime, gasTradeReviseRefundDO.getRawAddTime());
//        assertEquals(rawUpdateTime, gasTradeReviseRefundDO.getRawUpdateTime());
//	}
//
//	/**
//	 * 断言gas_trade_revise_refund表数据
//	 */
//	public void assertGasTradeReviseRefund(GasTradeReviseRefundDO expect, GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			gasTradeReviseRefundDO.setId(expect.getId());
//		}
//		Assertions.assertTrue(null != gasTradeReviseRefundDO.getRawAddTime());
//		expect.setRawAddTime(gasTradeReviseRefundDO.getRawAddTime());
//        Assertions.assertTrue(null != gasTradeReviseRefundDO.getRawUpdateTime());
//		expect.setRawUpdateTime(gasTradeReviseRefundDO.getRawUpdateTime());
//		Assertions.assertEquals(expect, gasTradeReviseRefundDO);
//	}
//
//    /**
//	 * 插入gas_trade_revise_refund表数据
//	 */
//	public void insertGasTradeReviseRefund(GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		gasTradeReviseRefundDAO.insert(gasTradeReviseRefundDO);
//	}
//
//    /**
//	 * 插入gas_trade_revise_refund表数据
//	 */
//	public void insertGasTradeReviseRefund(
//			long id,
//			String tradeType,
//			String bizNo,
//			String tradeNo,
//			String reqId,
//			String gid,
//			String partnerId,
//			String partnerName,
//			String requestNo,
//			String payNo,
//			String tradePayType,
//			String payModel,
//			long amount,
//			long payAmount,
//			String memo,
//			String status,
//			String state,
//			String code,
//			String description,
//			String runMemo,
//			String extensionContext,
//			Date finishTime,
//			Date clearTime,
//			Date rawAddTime,
//			Date rawUpdateTime
//	) {
//		if (finishTime == null) {
//			finishTime = new Date();
//		}
//		if (clearTime == null) {
//			clearTime = new Date();
//		}
//		if (rawAddTime == null) {
//			rawAddTime = new Date();
//		}
//		if (rawUpdateTime == null) {
//			rawUpdateTime = new Date();
//		}
//		GasTradeReviseRefundDO gasTradeReviseRefundDO = new GasTradeReviseRefundDO();
//		gasTradeReviseRefundDO.setId(id);
//		gasTradeReviseRefundDO.setTradeType(tradeType);
//		gasTradeReviseRefundDO.setBizNo(bizNo);
//		gasTradeReviseRefundDO.setTradeNo(tradeNo);
//		gasTradeReviseRefundDO.setReqId(reqId);
//		gasTradeReviseRefundDO.setGid(gid);
//		gasTradeReviseRefundDO.setPartnerId(partnerId);
//		gasTradeReviseRefundDO.setPartnerName(partnerName);
//		gasTradeReviseRefundDO.setRequestNo(requestNo);
//		gasTradeReviseRefundDO.setPayNo(payNo);
//		gasTradeReviseRefundDO.setTradePayType(tradePayType);
//		gasTradeReviseRefundDO.setPayModel(payModel);
//		gasTradeReviseRefundDO.setAmount(amount);
//		gasTradeReviseRefundDO.setPayAmount(payAmount);
//		gasTradeReviseRefundDO.setMemo(memo);
//		gasTradeReviseRefundDO.setStatus(status);
//		gasTradeReviseRefundDO.setState(state);
//		gasTradeReviseRefundDO.setCode(code);
//		gasTradeReviseRefundDO.setDescription(description);
//		gasTradeReviseRefundDO.setRunMemo(runMemo);
//		gasTradeReviseRefundDO.setExtensionContext(extensionContext);
//		gasTradeReviseRefundDO.setFinishTime(finishTime);
//		gasTradeReviseRefundDO.setClearTime(clearTime);
//		gasTradeReviseRefundDO.setRawAddTime(rawAddTime);
//		gasTradeReviseRefundDO.setRawUpdateTime(rawUpdateTime);
//		gasTradeReviseRefundDAO.insert(gasTradeReviseRefundDO);
//	}
//
//    /**
//     * 删除gas_trade_revise_refund表所有数据
//     */
//    public void cleanGasTradeReviseRefund() {
//        GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//        exam.createCriteria();
//        gasTradeReviseRefundDAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundById(long id) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据bizNo删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundByBizNo(String bizNo) {
//        if (StringUtils.isBlank(bizNo)){
//            bizNo = "test_bizNo";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据tradeNo删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundByTradeNo(String tradeNo) {
//        if (StringUtils.isBlank(tradeNo)){
//            tradeNo = "test_tradeNo";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据reqId删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundByReqId(String reqId) {
//        if (StringUtils.isBlank(reqId)){
//            reqId = "test_reqId";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据gid删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundByGid(String gid) {
//        if (StringUtils.isBlank(gid)){
//            gid = "test_gid";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据partnerId删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundByPartnerId(String partnerId) {
//        if (StringUtils.isBlank(partnerId)){
//            partnerId = "test_partnerId";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据partnerName删除gas_trade_revise_refund表数据
//	*/
//	public void cleanGasTradeReviseRefundByPartnerName(String partnerName) {
//        if (StringUtils.isBlank(partnerName)){
//            partnerName = "test_partnerName";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据requestNo删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundByRequestNo(String requestNo) {
//        if (StringUtils.isBlank(requestNo)){
//            requestNo = "test_requestNo";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据payNo删除gas_trade_revise_refund表数据
//	 */
//	public void cleanGasTradeReviseRefundByPayNo(String payNo) {
//        if (StringUtils.isBlank(payNo)){
//            payNo = "test_payNo";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据code删除gas_trade_revise_refund表数据
//	*/
//	public void cleanGasTradeReviseRefundByCode(String code) {
//        if (StringUtils.isBlank(code)){
//            code = "test_code";
//        }
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeReviseRefundDAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询gas_trade_revise_refund表所有数据
//     */
//    public List<GasTradeReviseRefundDO> findGasTradeReviseRefundAll() {
//        GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//        exam.createCriteria();
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundById(long id) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据bizNo查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByBizNo(String bizNo) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据tradeNo查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByTradeNo(String tradeNo) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据reqId查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByReqId(String reqId) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据gid查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByGid(String gid) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据partnerId查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByPartnerId(String partnerId) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据partnerName查询gas_trade_revise_refund表数据
//	*/
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByPartnerName(String partnerName) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据requestNo查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByRequestNo(String requestNo) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据payNo查询gas_trade_revise_refund表数据
//	 */
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByPayNo(String payNo) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据code查询gas_trade_revise_refund表数据
//	*/
//	public List<GasTradeReviseRefundDO> findGasTradeReviseRefundByCode(String code) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		return gasTradeReviseRefundDAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundById(long id,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 根据bizNo更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundByBizNo(String bizNo,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andBizNoEqualTo(bizNo);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 根据tradeNo更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundByTradeNo(String tradeNo,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andTradeNoEqualTo(tradeNo);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 根据reqId更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundByReqId(String reqId,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andReqIdEqualTo(reqId);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 根据gid更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundByGid(String gid,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andGidEqualTo(gid);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 根据partnerId更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundByPartnerId(String partnerId,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPartnerIdEqualTo(partnerId);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//	/**
//	* 根据partnerName更新gas_trade_revise_refund表数据
//	*/
//	public void updateGasTradeReviseRefundByPartnerName(String partnerName,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPartnerNameEqualTo(partnerName);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 根据requestNo更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundByRequestNo(String requestNo,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andRequestNoEqualTo(requestNo);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 根据payNo更新gas_trade_revise_refund表数据
//	 */
//	public void updateGasTradeReviseRefundByPayNo(String payNo,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andPayNoEqualTo(payNo);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//	/**
//	* 根据code更新gas_trade_revise_refund表数据
//	*/
//	public void updateGasTradeReviseRefundByCode(String code,GasTradeReviseRefundDO gasTradeReviseRefundDO) {
//		GasTradeReviseRefundDOExample exam = new GasTradeReviseRefundDOExample();
//		exam.createCriteria().andCodeEqualTo(code);
//		gasTradeReviseRefundDAO.updateByExample(gasTradeReviseRefundDO, exam);
//	}
//
//    /**
//	 * 断言sheet1表
//	 */
//	public void sheet1Assert(
//	        Sheet1DO sheet1DO,
//			Integer id,
//			String mName,
//			String mId,
//			String sName,
//			String sId,
//			String sCode,
//			String oName,
//			String oId,
//			String tatalAmount,
//			String startTime,
//			String endTime
//	) {
//        assertEquals(id, sheet1DO.getId());
//        assertEquals(mName, sheet1DO.getmName());
//        assertEquals(mId, sheet1DO.getmId());
//        assertEquals(sName, sheet1DO.getsName());
//        assertEquals(sId, sheet1DO.getsId());
//        assertEquals(sCode, sheet1DO.getsCode());
//        assertEquals(oName, sheet1DO.getoName());
//        assertEquals(oId, sheet1DO.getoId());
//        assertEquals(tatalAmount, sheet1DO.getTatalAmount());
//        assertEquals(startTime, sheet1DO.getStartTime());
//        assertEquals(endTime, sheet1DO.getEndTime());
//	}
//
//	/**
//	 * 断言sheet1表数据
//	 */
//	public void assertSheet1(Sheet1DO expect, Sheet1DO sheet1DO) {
//		if (null == expect.getId() || 0L == expect.getId()) {
//			sheet1DO.setId(expect.getId());
//		}
//		Assertions.assertEquals(expect, sheet1DO);
//	}
//
//    /**
//	 * 插入sheet1表数据
//	 */
//	public void insertSheet1(Sheet1DO sheet1DO) {
//		sheet1DAO.insert(sheet1DO);
//	}
//
//    /**
//	 * 插入sheet1表数据
//	 */
//	public void insertSheet1(
//			Integer id,
//			String mName,
//			String mId,
//			String sName,
//			String sId,
//			String sCode,
//			String oName,
//			String oId,
//			String tatalAmount,
//			String startTime,
//			String endTime
//	) {
//		Sheet1DO sheet1DO = new Sheet1DO();
//		sheet1DO.setId(id);
//		sheet1DO.setmName(mName);
//		sheet1DO.setmId(mId);
//		sheet1DO.setsName(sName);
//		sheet1DO.setsId(sId);
//		sheet1DO.setsCode(sCode);
//		sheet1DO.setoName(oName);
//		sheet1DO.setoId(oId);
//		sheet1DO.setTatalAmount(tatalAmount);
//		sheet1DO.setStartTime(startTime);
//		sheet1DO.setEndTime(endTime);
//		sheet1DAO.insert(sheet1DO);
//	}
//
//    /**
//     * 删除sheet1表所有数据
//     */
//    public void cleanSheet1() {
//        Sheet1DOExample exam = new Sheet1DOExample();
//        exam.createCriteria();
//        sheet1DAO.deleteByExample(exam);
//    }
//
//
//	/**
//	 * 根据id删除sheet1表数据
//	 */
//	public void cleanSheet1ById(Integer id) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据mName删除sheet1表数据
//	*/
//	public void cleanSheet1ByMName(String mName) {
//        if (StringUtils.isBlank(mName)){
//            mName = "test_mName";
//        }
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andMNameEqualTo(mName);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据mId删除sheet1表数据
//	 */
//	public void cleanSheet1ByMId(String mId) {
//        if (StringUtils.isBlank(mId)){
//            mId = "test_mId";
//        }
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andMIdEqualTo(mId);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据sName删除sheet1表数据
//	*/
//	public void cleanSheet1BySName(String sName) {
//        if (StringUtils.isBlank(sName)){
//            sName = "test_sName";
//        }
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSNameEqualTo(sName);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据sId删除sheet1表数据
//	 */
//	public void cleanSheet1BySId(String sId) {
//        if (StringUtils.isBlank(sId)){
//            sId = "test_sId";
//        }
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSIdEqualTo(sId);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据sCode删除sheet1表数据
//	*/
//	public void cleanSheet1BySCode(String sCode) {
//        if (StringUtils.isBlank(sCode)){
//            sCode = "test_sCode";
//        }
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSCodeEqualTo(sCode);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//	/**
//	* 根据oName删除sheet1表数据
//	*/
//	public void cleanSheet1ByOName(String oName) {
//        if (StringUtils.isBlank(oName)){
//            oName = "test_oName";
//        }
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andONameEqualTo(oName);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//	/**
//	 * 根据oId删除sheet1表数据
//	 */
//	public void cleanSheet1ByOId(String oId) {
//        if (StringUtils.isBlank(oId)){
//            oId = "test_oId";
//        }
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andOIdEqualTo(oId);
//		sheet1DAO.deleteByExample(exam);
//	}
//
//    /**
//     * 查询sheet1表所有数据
//     */
//    public List<Sheet1DO> findSheet1All() {
//        Sheet1DOExample exam = new Sheet1DOExample();
//        exam.createCriteria();
//		return sheet1DAO.selectByExample(exam);
//    }
//
//    /**
//	 * 根据id查询sheet1表数据
//	 */
//	public List<Sheet1DO> findSheet1ById(Integer id) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据mName查询sheet1表数据
//	*/
//	public List<Sheet1DO> findSheet1ByMName(String mName) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andMNameEqualTo(mName);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据mId查询sheet1表数据
//	 */
//	public List<Sheet1DO> findSheet1ByMId(String mId) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andMIdEqualTo(mId);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据sName查询sheet1表数据
//	*/
//	public List<Sheet1DO> findSheet1BySName(String sName) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSNameEqualTo(sName);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据sId查询sheet1表数据
//	 */
//	public List<Sheet1DO> findSheet1BySId(String sId) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSIdEqualTo(sId);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据sCode查询sheet1表数据
//	*/
//	public List<Sheet1DO> findSheet1BySCode(String sCode) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSCodeEqualTo(sCode);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//	/**
//	* 根据oName查询sheet1表数据
//	*/
//	public List<Sheet1DO> findSheet1ByOName(String oName) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andONameEqualTo(oName);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据oId查询sheet1表数据
//	 */
//	public List<Sheet1DO> findSheet1ByOId(String oId) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andOIdEqualTo(oId);
//		return sheet1DAO.selectByExample(exam);
//	}
//
//    /**
//	 * 根据id更新sheet1表数据
//	 */
//	public void updateSheet1ById(Integer id,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andIdEqualTo(id);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//
//	/**
//	* 根据mName更新sheet1表数据
//	*/
//	public void updateSheet1ByMName(String mName,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andMNameEqualTo(mName);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//
//    /**
//	 * 根据mId更新sheet1表数据
//	 */
//	public void updateSheet1ByMId(String mId,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andMIdEqualTo(mId);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//
//	/**
//	* 根据sName更新sheet1表数据
//	*/
//	public void updateSheet1BySName(String sName,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSNameEqualTo(sName);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//
//    /**
//	 * 根据sId更新sheet1表数据
//	 */
//	public void updateSheet1BySId(String sId,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSIdEqualTo(sId);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//
//	/**
//	* 根据sCode更新sheet1表数据
//	*/
//	public void updateSheet1BySCode(String sCode,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andSCodeEqualTo(sCode);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//
//	/**
//	* 根据oName更新sheet1表数据
//	*/
//	public void updateSheet1ByOName(String oName,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andONameEqualTo(oName);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//
//    /**
//	 * 根据oId更新sheet1表数据
//	 */
//	public void updateSheet1ByOId(String oId,Sheet1DO sheet1DO) {
//		Sheet1DOExample exam = new Sheet1DOExample();
//		exam.createCriteria().andOIdEqualTo(oId);
//		sheet1DAO.updateByExample(sheet1DO, exam);
//	}
//}
