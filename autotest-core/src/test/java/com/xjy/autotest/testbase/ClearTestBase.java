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
import dal.dao.clear.*;
import dal.model.clear.*;
import com.xjy.autotest.config.ClearDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/11/13.
 */
@Service
@Import({
        ClearDataSourceConfig.class
})
public class ClearTestBase {

	@Autowired
	BillBatchStatisticsDAO billBatchStatisticsDAO;

	@Autowired
	BillErrorOrderDAO billErrorOrderDAO;

	@Autowired
	BillReconciliationDetailDAO billReconciliationDetailDAO;

	@Autowired
	BillTaskConfDAO billTaskConfDAO;

	@Autowired
	BillTaskLogDAO billTaskLogDAO;

	@Autowired
	ClearChannelStatisticsDAO clearChannelStatisticsDAO;

	@Autowired
	ClearChannelTaskConfDAO clearChannelTaskConfDAO;

	@Autowired
	ClearChannelTaskLogDAO clearChannelTaskLogDAO;

	@Autowired
	ClearDsgjOrderDAO clearDsgjOrderDAO;

	@Autowired
	ClearDsgjRequestLogDAO clearDsgjRequestLogDAO;

	@Autowired
	ClearDsgjResultLogDAO clearDsgjResultLogDAO;

	@Autowired
	ClearDsgjResultStatisticsDAO clearDsgjResultStatisticsDAO;

	@Autowired
	ClearDsgjTaskConfDAO clearDsgjTaskConfDAO;

	@Autowired
	ClearDsgjTaskLogDAO clearDsgjTaskLogDAO;

	@Autowired
	ClearMerchantOrderDAO clearMerchantOrderDAO;

	@Autowired
	ClearStatisticsDAO clearStatisticsDAO;

	@Autowired
	ClearTransTypeConfDAO clearTransTypeConfDAO;

	@Autowired
	SettlementAccountConfDAO settlementAccountConfDAO;

	@Autowired
	SettlementDsgjTaskLogDAO settlementDsgjTaskLogDAO;

	@Autowired
	SettlementOrderLogDAO settlementOrderLogDAO;

	@Autowired
	SettlementTaskConfDAO settlementTaskConfDAO;

	@Autowired
	SettlementTaskLogDAO settlementTaskLogDAO;

	public BillBatchStatisticsDAO getBillBatchStatisticsDAO() {
		return this.billBatchStatisticsDAO;
	}

	public BillErrorOrderDAO getBillErrorOrderDAO() {
		return this.billErrorOrderDAO;
	}

	public BillReconciliationDetailDAO getBillReconciliationDetailDAO() {
		return this.billReconciliationDetailDAO;
	}

	public BillTaskConfDAO getBillTaskConfDAO() {
		return this.billTaskConfDAO;
	}

	public BillTaskLogDAO getBillTaskLogDAO() {
		return this.billTaskLogDAO;
	}

	public ClearChannelStatisticsDAO getClearChannelStatisticsDAO() {
		return this.clearChannelStatisticsDAO;
	}

	public ClearChannelTaskConfDAO getClearChannelTaskConfDAO() {
		return this.clearChannelTaskConfDAO;
	}

	public ClearChannelTaskLogDAO getClearChannelTaskLogDAO() {
		return this.clearChannelTaskLogDAO;
	}

	public ClearDsgjOrderDAO getClearDsgjOrderDAO() {
		return this.clearDsgjOrderDAO;
	}

	public ClearDsgjRequestLogDAO getClearDsgjRequestLogDAO() {
		return this.clearDsgjRequestLogDAO;
	}

	public ClearDsgjResultLogDAO getClearDsgjResultLogDAO() {
		return this.clearDsgjResultLogDAO;
	}

	public ClearDsgjResultStatisticsDAO getClearDsgjResultStatisticsDAO() {
		return this.clearDsgjResultStatisticsDAO;
	}

	public ClearDsgjTaskConfDAO getClearDsgjTaskConfDAO() {
		return this.clearDsgjTaskConfDAO;
	}

	public ClearDsgjTaskLogDAO getClearDsgjTaskLogDAO() {
		return this.clearDsgjTaskLogDAO;
	}

	public ClearMerchantOrderDAO getClearMerchantOrderDAO() {
		return this.clearMerchantOrderDAO;
	}

	public ClearStatisticsDAO getClearStatisticsDAO() {
		return this.clearStatisticsDAO;
	}

	public ClearTransTypeConfDAO getClearTransTypeConfDAO() {
		return this.clearTransTypeConfDAO;
	}

	public SettlementAccountConfDAO getSettlementAccountConfDAO() {
		return this.settlementAccountConfDAO;
	}

	public SettlementDsgjTaskLogDAO getSettlementDsgjTaskLogDAO() {
		return this.settlementDsgjTaskLogDAO;
	}

	public SettlementOrderLogDAO getSettlementOrderLogDAO() {
		return this.settlementOrderLogDAO;
	}

	public SettlementTaskConfDAO getSettlementTaskConfDAO() {
		return this.settlementTaskConfDAO;
	}

	public SettlementTaskLogDAO getSettlementTaskLogDAO() {
		return this.settlementTaskLogDAO;
	}


	/**
	 * 断言bill_batch_statistics表数据
	 */
	public void assertBillBatchStatistics(BillBatchStatisticsDO expect, BillBatchStatisticsDO billBatchStatisticsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			billBatchStatisticsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != billBatchStatisticsDO.getRawAddTime());
		expect.setRawAddTime(billBatchStatisticsDO.getRawAddTime());
        Assertions.assertTrue(null != billBatchStatisticsDO.getRawUpdateTime());
		expect.setRawUpdateTime(billBatchStatisticsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, billBatchStatisticsDO);
	}

    /**
	 * 插入bill_batch_statistics表数据
	 */
	public void insertBillBatchStatistics(BillBatchStatisticsDO billBatchStatisticsDO) {
		billBatchStatisticsDAO.insert(billBatchStatisticsDO);
	}

    /**
	 * 插入bill_batch_statistics表数据
	 */
	public void insertBillBatchStatistics(
			Long id, 
			String batchNo, 
			String partnerId, 
			String partnerRealName, 
			String platPartnerId, 
			String channelId, 
			String billDate, 
			String channelPartnerId, 
			String tradeType, 
			Integer channelOrderCount, 
			Long channelOrderAmount, 
			Integer errorOrderCount, 
			Long errorOrderAmount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		BillBatchStatisticsDO billBatchStatisticsDO = new BillBatchStatisticsDO();
		billBatchStatisticsDO.setId(id);
		billBatchStatisticsDO.setBatchNo(batchNo);
		billBatchStatisticsDO.setPartnerId(partnerId);
		billBatchStatisticsDO.setPartnerRealName(partnerRealName);
		billBatchStatisticsDO.setPlatPartnerId(platPartnerId);
		billBatchStatisticsDO.setChannelId(channelId);
		billBatchStatisticsDO.setBillDate(billDate);
		billBatchStatisticsDO.setChannelPartnerId(channelPartnerId);
		billBatchStatisticsDO.setTradeType(tradeType);
		billBatchStatisticsDO.setChannelOrderCount(channelOrderCount);
		billBatchStatisticsDO.setChannelOrderAmount(channelOrderAmount);
		billBatchStatisticsDO.setErrorOrderCount(errorOrderCount);
		billBatchStatisticsDO.setErrorOrderAmount(errorOrderAmount);
		billBatchStatisticsDO.setRawAddTime(rawAddTime);
		billBatchStatisticsDO.setRawUpdateTime(rawUpdateTime);
		billBatchStatisticsDAO.insert(billBatchStatisticsDO);
	}

    /**
     * 删除bill_batch_statistics表所有数据
     */
    public void cleanBillBatchStatistics() {
        BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
        exam.createCriteria();
        billBatchStatisticsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除bill_batch_statistics表数据
	 */
	public void cleanBillBatchStatisticsById(Long id) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billBatchStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchNo删除bill_batch_statistics表数据
	 */
	public void cleanBillBatchStatisticsByBatchNo(String batchNo) {
        if (StringUtils.isBlank(batchNo)){
            batchNo = "test_batchNo";
        }
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billBatchStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除bill_batch_statistics表数据
	 */
	public void cleanBillBatchStatisticsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billBatchStatisticsDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除bill_batch_statistics表数据
	*/
	public void cleanBillBatchStatisticsByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		billBatchStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除bill_batch_statistics表数据
	 */
	public void cleanBillBatchStatisticsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		billBatchStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除bill_batch_statistics表数据
	 */
	public void cleanBillBatchStatisticsByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billBatchStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelPartnerId删除bill_batch_statistics表数据
	 */
	public void cleanBillBatchStatisticsByChannelPartnerId(String channelPartnerId) {
        if (StringUtils.isBlank(channelPartnerId)){
            channelPartnerId = "test_channelPartnerId";
        }
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		billBatchStatisticsDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询bill_batch_statistics表数据
	 */
	public List<BillBatchStatisticsDO> findBillBatchStatisticsById(Long id) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return billBatchStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据batchNo查询bill_batch_statistics表数据
	 */
	public List<BillBatchStatisticsDO> findBillBatchStatisticsByBatchNo(String batchNo) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		return billBatchStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询bill_batch_statistics表数据
	 */
	public List<BillBatchStatisticsDO> findBillBatchStatisticsByPartnerId(String partnerId) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return billBatchStatisticsDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询bill_batch_statistics表数据
	*/
	public List<BillBatchStatisticsDO> findBillBatchStatisticsByPartnerRealName(String partnerRealName) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return billBatchStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询bill_batch_statistics表数据
	 */
	public List<BillBatchStatisticsDO> findBillBatchStatisticsByPlatPartnerId(String platPartnerId) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return billBatchStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询bill_batch_statistics表数据
	 */
	public List<BillBatchStatisticsDO> findBillBatchStatisticsByChannelId(String channelId) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return billBatchStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据channelPartnerId查询bill_batch_statistics表数据
	 */
	public List<BillBatchStatisticsDO> findBillBatchStatisticsByChannelPartnerId(String channelPartnerId) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		return billBatchStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新bill_batch_statistics表数据
	 */
	public void updateBillBatchStatisticsById(Long id,BillBatchStatisticsDO billBatchStatisticsDO) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billBatchStatisticsDAO.updateByExample(billBatchStatisticsDO, exam);
	}

    /**
	 * 根据batchNo更新bill_batch_statistics表数据
	 */
	public void updateBillBatchStatisticsByBatchNo(String batchNo,BillBatchStatisticsDO billBatchStatisticsDO) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billBatchStatisticsDAO.updateByExample(billBatchStatisticsDO, exam);
	}

    /**
	 * 根据partnerId更新bill_batch_statistics表数据
	 */
	public void updateBillBatchStatisticsByPartnerId(String partnerId,BillBatchStatisticsDO billBatchStatisticsDO) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billBatchStatisticsDAO.updateByExample(billBatchStatisticsDO, exam);
	}

	/**
	* 根据partnerRealName更新bill_batch_statistics表数据
	*/
	public void updateBillBatchStatisticsByPartnerRealName(String partnerRealName,BillBatchStatisticsDO billBatchStatisticsDO) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		billBatchStatisticsDAO.updateByExample(billBatchStatisticsDO, exam);
	}

    /**
	 * 根据platPartnerId更新bill_batch_statistics表数据
	 */
	public void updateBillBatchStatisticsByPlatPartnerId(String platPartnerId,BillBatchStatisticsDO billBatchStatisticsDO) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		billBatchStatisticsDAO.updateByExample(billBatchStatisticsDO, exam);
	}

    /**
	 * 根据channelId更新bill_batch_statistics表数据
	 */
	public void updateBillBatchStatisticsByChannelId(String channelId,BillBatchStatisticsDO billBatchStatisticsDO) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billBatchStatisticsDAO.updateByExample(billBatchStatisticsDO, exam);
	}

    /**
	 * 根据channelPartnerId更新bill_batch_statistics表数据
	 */
	public void updateBillBatchStatisticsByChannelPartnerId(String channelPartnerId,BillBatchStatisticsDO billBatchStatisticsDO) {
		BillBatchStatisticsDOExample exam = new BillBatchStatisticsDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		billBatchStatisticsDAO.updateByExample(billBatchStatisticsDO, exam);
	}

	/**
	 * 断言bill_error_order表数据
	 */
	public void assertBillErrorOrder(BillErrorOrderDO expect, BillErrorOrderDO billErrorOrderDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			billErrorOrderDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != billErrorOrderDO.getRawAddTime());
		expect.setRawAddTime(billErrorOrderDO.getRawAddTime());
        Assertions.assertTrue(null != billErrorOrderDO.getRawUpdateTime());
		expect.setRawUpdateTime(billErrorOrderDO.getRawUpdateTime());
		Assertions.assertEquals(expect, billErrorOrderDO);
	}

    /**
	 * 插入bill_error_order表数据
	 */
	public void insertBillErrorOrder(BillErrorOrderDO billErrorOrderDO) {
		billErrorOrderDAO.insert(billErrorOrderDO);
	}

    /**
	 * 插入bill_error_order表数据
	 */
	public void insertBillErrorOrder(
			Long id, 
			String batchNo, 
			String partnerId, 
			String platPartnerId, 
			String orderKey, 
			String billStatus, 
			String tradeType, 
			String channelOrderNo, 
			Long channelOrderAmount, 
			String merchantOrderNo, 
			String merchantTradeNo, 
			String platMerchantOrderNo, 
			Long merchantOrderAmount, 
			String solveStatus, 
			String solveComment, 
			String billDate, 
			String channelId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		BillErrorOrderDO billErrorOrderDO = new BillErrorOrderDO();
		billErrorOrderDO.setId(id);
		billErrorOrderDO.setBatchNo(batchNo);
		billErrorOrderDO.setPartnerId(partnerId);
		billErrorOrderDO.setPlatPartnerId(platPartnerId);
		billErrorOrderDO.setOrderKey(orderKey);
		billErrorOrderDO.setBillStatus(billStatus);
		billErrorOrderDO.setTradeType(tradeType);
		billErrorOrderDO.setChannelOrderNo(channelOrderNo);
		billErrorOrderDO.setChannelOrderAmount(channelOrderAmount);
		billErrorOrderDO.setMerchantOrderNo(merchantOrderNo);
		billErrorOrderDO.setMerchantTradeNo(merchantTradeNo);
		billErrorOrderDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		billErrorOrderDO.setMerchantOrderAmount(merchantOrderAmount);
		billErrorOrderDO.setSolveStatus(solveStatus);
		billErrorOrderDO.setSolveComment(solveComment);
		billErrorOrderDO.setBillDate(billDate);
		billErrorOrderDO.setChannelId(channelId);
		billErrorOrderDO.setRawAddTime(rawAddTime);
		billErrorOrderDO.setRawUpdateTime(rawUpdateTime);
		billErrorOrderDAO.insert(billErrorOrderDO);
	}

    /**
     * 删除bill_error_order表所有数据
     */
    public void cleanBillErrorOrder() {
        BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
        exam.createCriteria();
        billErrorOrderDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderById(Long id) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchNo删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByBatchNo(String batchNo) {
        if (StringUtils.isBlank(batchNo)){
            batchNo = "test_batchNo";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelOrderNo删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByChannelOrderNo(String channelOrderNo) {
        if (StringUtils.isBlank(channelOrderNo)){
            channelOrderNo = "test_channelOrderNo";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andChannelOrderNoEqualTo(channelOrderNo);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantTradeNo删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByMerchantTradeNo(String merchantTradeNo) {
        if (StringUtils.isBlank(merchantTradeNo)){
            merchantTradeNo = "test_merchantTradeNo";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		billErrorOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除bill_error_order表数据
	 */
	public void cleanBillErrorOrderByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billErrorOrderDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderById(Long id) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据batchNo查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByBatchNo(String batchNo) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByPartnerId(String partnerId) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByPlatPartnerId(String platPartnerId) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据channelOrderNo查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByChannelOrderNo(String channelOrderNo) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andChannelOrderNoEqualTo(channelOrderNo);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByMerchantOrderNo(String merchantOrderNo) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantTradeNo查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByMerchantTradeNo(String merchantTradeNo) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询bill_error_order表数据
	 */
	public List<BillErrorOrderDO> findBillErrorOrderByChannelId(String channelId) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return billErrorOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新bill_error_order表数据
	 */
	public void updateBillErrorOrderById(Long id,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据batchNo更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByBatchNo(String batchNo,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据partnerId更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByPartnerId(String partnerId,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据platPartnerId更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByPlatPartnerId(String platPartnerId,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据channelOrderNo更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByChannelOrderNo(String channelOrderNo,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andChannelOrderNoEqualTo(channelOrderNo);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByMerchantOrderNo(String merchantOrderNo,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据merchantTradeNo更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByMerchantTradeNo(String merchantTradeNo,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByPlatMerchantOrderNo(String platMerchantOrderNo,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

    /**
	 * 根据channelId更新bill_error_order表数据
	 */
	public void updateBillErrorOrderByChannelId(String channelId,BillErrorOrderDO billErrorOrderDO) {
		BillErrorOrderDOExample exam = new BillErrorOrderDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billErrorOrderDAO.updateByExample(billErrorOrderDO, exam);
	}

	/**
	 * 断言bill_reconciliation_detail表数据
	 */
	public void assertBillReconciliationDetail(BillReconciliationDetailDO expect, BillReconciliationDetailDO billReconciliationDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			billReconciliationDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != billReconciliationDetailDO.getRawAddTime());
		expect.setRawAddTime(billReconciliationDetailDO.getRawAddTime());
        Assertions.assertTrue(null != billReconciliationDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(billReconciliationDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, billReconciliationDetailDO);
	}

    /**
	 * 插入bill_reconciliation_detail表数据
	 */
	public void insertBillReconciliationDetail(BillReconciliationDetailDO billReconciliationDetailDO) {
		billReconciliationDetailDAO.insert(billReconciliationDetailDO);
	}

    /**
	 * 插入bill_reconciliation_detail表数据
	 */
	public void insertBillReconciliationDetail(
			Long id, 
			String batchNo, 
			String billDate, 
			String partnerId, 
			String platPartnerId, 
			String orderKey, 
			String tradeType, 
			String tradeResource, 
			String billStatus, 
			String channelId, 
			String channelOrderNo, 
			String channelTradeNo, 
			String channelTransactionNo, 
			String channelRefundNo, 
			Long channelOrderAmount, 
			Long channelAmount, 
			BigDecimal channelFeeAmount, 
			BigDecimal channelFee, 
			Date channelTradeTime, 
			String channelPartnerId, 
			String channelThirdPartnerId, 
			String channelThirdUserId, 
			String channelTradeMemo, 
			String merchantOrderNo, 
			String platMerchantOrderNo, 
			String merchantTradeNo, 
			String merchantRefundNo, 
			Long merchantOrderAmount, 
			Long merchantAmount, 
			BigDecimal merchantFeeAmount, 
			BigDecimal merchantFee, 
			Date merchantTradeTime, 
			BigDecimal merchantChannelFeeAmount, 
			BigDecimal merchantChannelFee, 
			String merchantMode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (channelTradeTime == null) {
			channelTradeTime = new Date();
		}
		if (merchantTradeTime == null) {
			merchantTradeTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		BillReconciliationDetailDO billReconciliationDetailDO = new BillReconciliationDetailDO();
		billReconciliationDetailDO.setId(id);
		billReconciliationDetailDO.setBatchNo(batchNo);
		billReconciliationDetailDO.setBillDate(billDate);
		billReconciliationDetailDO.setPartnerId(partnerId);
		billReconciliationDetailDO.setPlatPartnerId(platPartnerId);
		billReconciliationDetailDO.setOrderKey(orderKey);
		billReconciliationDetailDO.setTradeType(tradeType);
		billReconciliationDetailDO.setTradeResource(tradeResource);
		billReconciliationDetailDO.setBillStatus(billStatus);
		billReconciliationDetailDO.setChannelId(channelId);
		billReconciliationDetailDO.setChannelOrderNo(channelOrderNo);
		billReconciliationDetailDO.setChannelTradeNo(channelTradeNo);
		billReconciliationDetailDO.setChannelTransactionNo(channelTransactionNo);
		billReconciliationDetailDO.setChannelRefundNo(channelRefundNo);
		billReconciliationDetailDO.setChannelOrderAmount(channelOrderAmount);
		billReconciliationDetailDO.setChannelAmount(channelAmount);
		billReconciliationDetailDO.setChannelFeeAmount(channelFeeAmount);
		billReconciliationDetailDO.setChannelFee(channelFee);
		billReconciliationDetailDO.setChannelTradeTime(channelTradeTime);
		billReconciliationDetailDO.setChannelPartnerId(channelPartnerId);
		billReconciliationDetailDO.setChannelThirdPartnerId(channelThirdPartnerId);
		billReconciliationDetailDO.setChannelThirdUserId(channelThirdUserId);
		billReconciliationDetailDO.setChannelTradeMemo(channelTradeMemo);
		billReconciliationDetailDO.setMerchantOrderNo(merchantOrderNo);
		billReconciliationDetailDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		billReconciliationDetailDO.setMerchantTradeNo(merchantTradeNo);
		billReconciliationDetailDO.setMerchantRefundNo(merchantRefundNo);
		billReconciliationDetailDO.setMerchantOrderAmount(merchantOrderAmount);
		billReconciliationDetailDO.setMerchantAmount(merchantAmount);
		billReconciliationDetailDO.setMerchantFeeAmount(merchantFeeAmount);
		billReconciliationDetailDO.setMerchantFee(merchantFee);
		billReconciliationDetailDO.setMerchantTradeTime(merchantTradeTime);
		billReconciliationDetailDO.setMerchantChannelFeeAmount(merchantChannelFeeAmount);
		billReconciliationDetailDO.setMerchantChannelFee(merchantChannelFee);
		billReconciliationDetailDO.setMerchantMode(merchantMode);
		billReconciliationDetailDO.setRawAddTime(rawAddTime);
		billReconciliationDetailDO.setRawUpdateTime(rawUpdateTime);
		billReconciliationDetailDAO.insert(billReconciliationDetailDO);
	}

    /**
     * 删除bill_reconciliation_detail表所有数据
     */
    public void cleanBillReconciliationDetail() {
        BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
        exam.createCriteria();
        billReconciliationDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailById(Long id) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByBatchNo(String batchNo) {
        if (StringUtils.isBlank(batchNo)){
            batchNo = "test_batchNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelOrderNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelOrderNo(String channelOrderNo) {
        if (StringUtils.isBlank(channelOrderNo)){
            channelOrderNo = "test_channelOrderNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelOrderNoEqualTo(channelOrderNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelTradeNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelTradeNo(String channelTradeNo) {
        if (StringUtils.isBlank(channelTradeNo)){
            channelTradeNo = "test_channelTradeNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelTradeNoEqualTo(channelTradeNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelTransactionNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelTransactionNo(String channelTransactionNo) {
        if (StringUtils.isBlank(channelTransactionNo)){
            channelTransactionNo = "test_channelTransactionNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelTransactionNoEqualTo(channelTransactionNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelRefundNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelRefundNo(String channelRefundNo) {
        if (StringUtils.isBlank(channelRefundNo)){
            channelRefundNo = "test_channelRefundNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelPartnerId删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelPartnerId(String channelPartnerId) {
        if (StringUtils.isBlank(channelPartnerId)){
            channelPartnerId = "test_channelPartnerId";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelThirdPartnerId删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelThirdPartnerId(String channelThirdPartnerId) {
        if (StringUtils.isBlank(channelThirdPartnerId)){
            channelThirdPartnerId = "test_channelThirdPartnerId";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelThirdPartnerIdEqualTo(channelThirdPartnerId);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelThirdUserId删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByChannelThirdUserId(String channelThirdUserId) {
        if (StringUtils.isBlank(channelThirdUserId)){
            channelThirdUserId = "test_channelThirdUserId";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelThirdUserIdEqualTo(channelThirdUserId);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantTradeNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByMerchantTradeNo(String merchantTradeNo) {
        if (StringUtils.isBlank(merchantTradeNo)){
            merchantTradeNo = "test_merchantTradeNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantRefundNo删除bill_reconciliation_detail表数据
	 */
	public void cleanBillReconciliationDetailByMerchantRefundNo(String merchantRefundNo) {
        if (StringUtils.isBlank(merchantRefundNo)){
            merchantRefundNo = "test_merchantRefundNo";
        }
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		billReconciliationDetailDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailById(Long id) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据batchNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByBatchNo(String batchNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByPartnerId(String partnerId) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByPlatPartnerId(String platPartnerId) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelId(String channelId) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelOrderNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelOrderNo(String channelOrderNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelOrderNoEqualTo(channelOrderNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelTradeNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelTradeNo(String channelTradeNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelTradeNoEqualTo(channelTradeNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelTransactionNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelTransactionNo(String channelTransactionNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelTransactionNoEqualTo(channelTransactionNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelRefundNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelRefundNo(String channelRefundNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelPartnerId查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelPartnerId(String channelPartnerId) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelThirdPartnerId查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelThirdPartnerId(String channelThirdPartnerId) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelThirdPartnerIdEqualTo(channelThirdPartnerId);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据channelThirdUserId查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByChannelThirdUserId(String channelThirdUserId) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelThirdUserIdEqualTo(channelThirdUserId);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByMerchantOrderNo(String merchantOrderNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByPlatMerchantOrderNo(String platMerchantOrderNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantTradeNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByMerchantTradeNo(String merchantTradeNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantRefundNo查询bill_reconciliation_detail表数据
	 */
	public List<BillReconciliationDetailDO> findBillReconciliationDetailByMerchantRefundNo(String merchantRefundNo) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		return billReconciliationDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailById(Long id,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据batchNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByBatchNo(String batchNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据partnerId更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByPartnerId(String partnerId,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据platPartnerId更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByPlatPartnerId(String platPartnerId,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelId更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelId(String channelId,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelOrderNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelOrderNo(String channelOrderNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelOrderNoEqualTo(channelOrderNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelTradeNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelTradeNo(String channelTradeNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelTradeNoEqualTo(channelTradeNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelTransactionNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelTransactionNo(String channelTransactionNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelTransactionNoEqualTo(channelTransactionNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelRefundNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelRefundNo(String channelRefundNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelPartnerId更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelPartnerId(String channelPartnerId,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelThirdPartnerId更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelThirdPartnerId(String channelThirdPartnerId,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelThirdPartnerIdEqualTo(channelThirdPartnerId);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据channelThirdUserId更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByChannelThirdUserId(String channelThirdUserId,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andChannelThirdUserIdEqualTo(channelThirdUserId);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByMerchantOrderNo(String merchantOrderNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByPlatMerchantOrderNo(String platMerchantOrderNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据merchantTradeNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByMerchantTradeNo(String merchantTradeNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

    /**
	 * 根据merchantRefundNo更新bill_reconciliation_detail表数据
	 */
	public void updateBillReconciliationDetailByMerchantRefundNo(String merchantRefundNo,BillReconciliationDetailDO billReconciliationDetailDO) {
		BillReconciliationDetailDOExample exam = new BillReconciliationDetailDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		billReconciliationDetailDAO.updateByExample(billReconciliationDetailDO, exam);
	}

	/**
	 * 断言bill_task_conf表数据
	 */
	public void assertBillTaskConf(BillTaskConfDO expect, BillTaskConfDO billTaskConfDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			billTaskConfDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != billTaskConfDO.getRawAddTime());
		expect.setRawAddTime(billTaskConfDO.getRawAddTime());
        Assertions.assertTrue(null != billTaskConfDO.getRawUpdateTime());
		expect.setRawUpdateTime(billTaskConfDO.getRawUpdateTime());
		Assertions.assertEquals(expect, billTaskConfDO);
	}

    /**
	 * 插入bill_task_conf表数据
	 */
	public void insertBillTaskConf(BillTaskConfDO billTaskConfDO) {
		billTaskConfDAO.insert(billTaskConfDO);
	}

    /**
	 * 插入bill_task_conf表数据
	 */
	public void insertBillTaskConf(
			Long id, 
			String partnerId, 
			String partnerRealName, 
			String billChannelTime, 
			String billTime, 
			Integer billCycle, 
			String channelId, 
			String useStatus, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		BillTaskConfDO billTaskConfDO = new BillTaskConfDO();
		billTaskConfDO.setId(id);
		billTaskConfDO.setPartnerId(partnerId);
		billTaskConfDO.setPartnerRealName(partnerRealName);
		billTaskConfDO.setBillChannelTime(billChannelTime);
		billTaskConfDO.setBillTime(billTime);
		billTaskConfDO.setBillCycle(billCycle);
		billTaskConfDO.setChannelId(channelId);
		billTaskConfDO.setUseStatus(useStatus);
		billTaskConfDO.setMemo(memo);
		billTaskConfDO.setRawAddTime(rawAddTime);
		billTaskConfDO.setRawUpdateTime(rawUpdateTime);
		billTaskConfDAO.insert(billTaskConfDO);
	}

    /**
     * 删除bill_task_conf表所有数据
     */
    public void cleanBillTaskConf() {
        BillTaskConfDOExample exam = new BillTaskConfDOExample();
        exam.createCriteria();
        billTaskConfDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除bill_task_conf表数据
	 */
	public void cleanBillTaskConfById(Long id) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billTaskConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除bill_task_conf表数据
	 */
	public void cleanBillTaskConfByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billTaskConfDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除bill_task_conf表数据
	*/
	public void cleanBillTaskConfByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		billTaskConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除bill_task_conf表数据
	 */
	public void cleanBillTaskConfByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billTaskConfDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询bill_task_conf表数据
	 */
	public List<BillTaskConfDO> findBillTaskConfById(Long id) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return billTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询bill_task_conf表数据
	 */
	public List<BillTaskConfDO> findBillTaskConfByPartnerId(String partnerId) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return billTaskConfDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询bill_task_conf表数据
	*/
	public List<BillTaskConfDO> findBillTaskConfByPartnerRealName(String partnerRealName) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return billTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询bill_task_conf表数据
	 */
	public List<BillTaskConfDO> findBillTaskConfByChannelId(String channelId) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return billTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新bill_task_conf表数据
	 */
	public void updateBillTaskConfById(Long id,BillTaskConfDO billTaskConfDO) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billTaskConfDAO.updateByExample(billTaskConfDO, exam);
	}

    /**
	 * 根据partnerId更新bill_task_conf表数据
	 */
	public void updateBillTaskConfByPartnerId(String partnerId,BillTaskConfDO billTaskConfDO) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billTaskConfDAO.updateByExample(billTaskConfDO, exam);
	}

	/**
	* 根据partnerRealName更新bill_task_conf表数据
	*/
	public void updateBillTaskConfByPartnerRealName(String partnerRealName,BillTaskConfDO billTaskConfDO) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		billTaskConfDAO.updateByExample(billTaskConfDO, exam);
	}

    /**
	 * 根据channelId更新bill_task_conf表数据
	 */
	public void updateBillTaskConfByChannelId(String channelId,BillTaskConfDO billTaskConfDO) {
		BillTaskConfDOExample exam = new BillTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billTaskConfDAO.updateByExample(billTaskConfDO, exam);
	}

	/**
	 * 断言bill_task_log表数据
	 */
	public void assertBillTaskLog(BillTaskLogDO expect, BillTaskLogDO billTaskLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			billTaskLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != billTaskLogDO.getRawAddTime());
		expect.setRawAddTime(billTaskLogDO.getRawAddTime());
        Assertions.assertTrue(null != billTaskLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(billTaskLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, billTaskLogDO);
	}

    /**
	 * 插入bill_task_log表数据
	 */
	public void insertBillTaskLog(BillTaskLogDO billTaskLogDO) {
		billTaskLogDAO.insert(billTaskLogDO);
	}

    /**
	 * 插入bill_task_log表数据
	 */
	public void insertBillTaskLog(
			Long id, 
			String batchNo, 
			String partnerId, 
			String partnerRealName, 
			String channelId, 
			String billDate, 
			Date billChannelTime, 
			String channelStatus, 
			String channelComment, 
			Date billTime, 
			String billStatus, 
			String billComment, 
			String billFileStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (billChannelTime == null) {
			billChannelTime = new Date();
		}
		if (billTime == null) {
			billTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		BillTaskLogDO billTaskLogDO = new BillTaskLogDO();
		billTaskLogDO.setId(id);
		billTaskLogDO.setBatchNo(batchNo);
		billTaskLogDO.setPartnerId(partnerId);
		billTaskLogDO.setPartnerRealName(partnerRealName);
		billTaskLogDO.setChannelId(channelId);
		billTaskLogDO.setBillDate(billDate);
		billTaskLogDO.setBillChannelTime(billChannelTime);
		billTaskLogDO.setChannelStatus(channelStatus);
		billTaskLogDO.setChannelComment(channelComment);
		billTaskLogDO.setBillTime(billTime);
		billTaskLogDO.setBillStatus(billStatus);
		billTaskLogDO.setBillComment(billComment);
		billTaskLogDO.setBillFileStatus(billFileStatus);
		billTaskLogDO.setRawAddTime(rawAddTime);
		billTaskLogDO.setRawUpdateTime(rawUpdateTime);
		billTaskLogDAO.insert(billTaskLogDO);
	}

    /**
     * 删除bill_task_log表所有数据
     */
    public void cleanBillTaskLog() {
        BillTaskLogDOExample exam = new BillTaskLogDOExample();
        exam.createCriteria();
        billTaskLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除bill_task_log表数据
	 */
	public void cleanBillTaskLogById(Long id) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchNo删除bill_task_log表数据
	 */
	public void cleanBillTaskLogByBatchNo(String batchNo) {
        if (StringUtils.isBlank(batchNo)){
            batchNo = "test_batchNo";
        }
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除bill_task_log表数据
	 */
	public void cleanBillTaskLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billTaskLogDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除bill_task_log表数据
	*/
	public void cleanBillTaskLogByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		billTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除bill_task_log表数据
	 */
	public void cleanBillTaskLogByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billTaskLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询bill_task_log表数据
	 */
	public List<BillTaskLogDO> findBillTaskLogById(Long id) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return billTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据batchNo查询bill_task_log表数据
	 */
	public List<BillTaskLogDO> findBillTaskLogByBatchNo(String batchNo) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		return billTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询bill_task_log表数据
	 */
	public List<BillTaskLogDO> findBillTaskLogByPartnerId(String partnerId) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return billTaskLogDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询bill_task_log表数据
	*/
	public List<BillTaskLogDO> findBillTaskLogByPartnerRealName(String partnerRealName) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return billTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询bill_task_log表数据
	 */
	public List<BillTaskLogDO> findBillTaskLogByChannelId(String channelId) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return billTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新bill_task_log表数据
	 */
	public void updateBillTaskLogById(Long id,BillTaskLogDO billTaskLogDO) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		billTaskLogDAO.updateByExample(billTaskLogDO, exam);
	}

    /**
	 * 根据batchNo更新bill_task_log表数据
	 */
	public void updateBillTaskLogByBatchNo(String batchNo,BillTaskLogDO billTaskLogDO) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		billTaskLogDAO.updateByExample(billTaskLogDO, exam);
	}

    /**
	 * 根据partnerId更新bill_task_log表数据
	 */
	public void updateBillTaskLogByPartnerId(String partnerId,BillTaskLogDO billTaskLogDO) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		billTaskLogDAO.updateByExample(billTaskLogDO, exam);
	}

	/**
	* 根据partnerRealName更新bill_task_log表数据
	*/
	public void updateBillTaskLogByPartnerRealName(String partnerRealName,BillTaskLogDO billTaskLogDO) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		billTaskLogDAO.updateByExample(billTaskLogDO, exam);
	}

    /**
	 * 根据channelId更新bill_task_log表数据
	 */
	public void updateBillTaskLogByChannelId(String channelId,BillTaskLogDO billTaskLogDO) {
		BillTaskLogDOExample exam = new BillTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		billTaskLogDAO.updateByExample(billTaskLogDO, exam);
	}

	/**
	 * 断言clear_channel_statistics表数据
	 */
	public void assertClearChannelStatistics(ClearChannelStatisticsDO expect, ClearChannelStatisticsDO clearChannelStatisticsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearChannelStatisticsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearChannelStatisticsDO.getRawAddTime());
		expect.setRawAddTime(clearChannelStatisticsDO.getRawAddTime());
        Assertions.assertTrue(null != clearChannelStatisticsDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearChannelStatisticsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearChannelStatisticsDO);
	}

    /**
	 * 插入clear_channel_statistics表数据
	 */
	public void insertClearChannelStatistics(ClearChannelStatisticsDO clearChannelStatisticsDO) {
		clearChannelStatisticsDAO.insert(clearChannelStatisticsDO);
	}

    /**
	 * 插入clear_channel_statistics表数据
	 */
	public void insertClearChannelStatistics(
			Long id, 
			String channelId, 
			Long orderAmount, 
			Long clearAmount, 
			Long partnerFeeAmount, 
			BigDecimal feeAmount, 
			String startDate, 
			String endDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearChannelStatisticsDO clearChannelStatisticsDO = new ClearChannelStatisticsDO();
		clearChannelStatisticsDO.setId(id);
		clearChannelStatisticsDO.setChannelId(channelId);
		clearChannelStatisticsDO.setOrderAmount(orderAmount);
		clearChannelStatisticsDO.setClearAmount(clearAmount);
		clearChannelStatisticsDO.setPartnerFeeAmount(partnerFeeAmount);
		clearChannelStatisticsDO.setFeeAmount(feeAmount);
		clearChannelStatisticsDO.setStartDate(startDate);
		clearChannelStatisticsDO.setEndDate(endDate);
		clearChannelStatisticsDO.setRawAddTime(rawAddTime);
		clearChannelStatisticsDO.setRawUpdateTime(rawUpdateTime);
		clearChannelStatisticsDAO.insert(clearChannelStatisticsDO);
	}

    /**
     * 删除clear_channel_statistics表所有数据
     */
    public void cleanClearChannelStatistics() {
        ClearChannelStatisticsDOExample exam = new ClearChannelStatisticsDOExample();
        exam.createCriteria();
        clearChannelStatisticsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_channel_statistics表数据
	 */
	public void cleanClearChannelStatisticsById(Long id) {
		ClearChannelStatisticsDOExample exam = new ClearChannelStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearChannelStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除clear_channel_statistics表数据
	 */
	public void cleanClearChannelStatisticsByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		ClearChannelStatisticsDOExample exam = new ClearChannelStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearChannelStatisticsDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_channel_statistics表数据
	 */
	public List<ClearChannelStatisticsDO> findClearChannelStatisticsById(Long id) {
		ClearChannelStatisticsDOExample exam = new ClearChannelStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearChannelStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询clear_channel_statistics表数据
	 */
	public List<ClearChannelStatisticsDO> findClearChannelStatisticsByChannelId(String channelId) {
		ClearChannelStatisticsDOExample exam = new ClearChannelStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return clearChannelStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_channel_statistics表数据
	 */
	public void updateClearChannelStatisticsById(Long id,ClearChannelStatisticsDO clearChannelStatisticsDO) {
		ClearChannelStatisticsDOExample exam = new ClearChannelStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearChannelStatisticsDAO.updateByExample(clearChannelStatisticsDO, exam);
	}

    /**
	 * 根据channelId更新clear_channel_statistics表数据
	 */
	public void updateClearChannelStatisticsByChannelId(String channelId,ClearChannelStatisticsDO clearChannelStatisticsDO) {
		ClearChannelStatisticsDOExample exam = new ClearChannelStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearChannelStatisticsDAO.updateByExample(clearChannelStatisticsDO, exam);
	}

	/**
	 * 断言clear_channel_task_conf表数据
	 */
	public void assertClearChannelTaskConf(ClearChannelTaskConfDO expect, ClearChannelTaskConfDO clearChannelTaskConfDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearChannelTaskConfDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearChannelTaskConfDO.getRawAddTime());
		expect.setRawAddTime(clearChannelTaskConfDO.getRawAddTime());
        Assertions.assertTrue(null != clearChannelTaskConfDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearChannelTaskConfDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearChannelTaskConfDO);
	}

    /**
	 * 插入clear_channel_task_conf表数据
	 */
	public void insertClearChannelTaskConf(ClearChannelTaskConfDO clearChannelTaskConfDO) {
		clearChannelTaskConfDAO.insert(clearChannelTaskConfDO);
	}

    /**
	 * 插入clear_channel_task_conf表数据
	 */
	public void insertClearChannelTaskConf(
			Long id, 
			String channelId, 
			String cycle, 
			String useStatus, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearChannelTaskConfDO clearChannelTaskConfDO = new ClearChannelTaskConfDO();
		clearChannelTaskConfDO.setId(id);
		clearChannelTaskConfDO.setChannelId(channelId);
		clearChannelTaskConfDO.setCycle(cycle);
		clearChannelTaskConfDO.setUseStatus(useStatus);
		clearChannelTaskConfDO.setMemo(memo);
		clearChannelTaskConfDO.setRawAddTime(rawAddTime);
		clearChannelTaskConfDO.setRawUpdateTime(rawUpdateTime);
		clearChannelTaskConfDAO.insert(clearChannelTaskConfDO);
	}

    /**
     * 删除clear_channel_task_conf表所有数据
     */
    public void cleanClearChannelTaskConf() {
        ClearChannelTaskConfDOExample exam = new ClearChannelTaskConfDOExample();
        exam.createCriteria();
        clearChannelTaskConfDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_channel_task_conf表数据
	 */
	public void cleanClearChannelTaskConfById(Long id) {
		ClearChannelTaskConfDOExample exam = new ClearChannelTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearChannelTaskConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除clear_channel_task_conf表数据
	 */
	public void cleanClearChannelTaskConfByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		ClearChannelTaskConfDOExample exam = new ClearChannelTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearChannelTaskConfDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_channel_task_conf表数据
	 */
	public List<ClearChannelTaskConfDO> findClearChannelTaskConfById(Long id) {
		ClearChannelTaskConfDOExample exam = new ClearChannelTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearChannelTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询clear_channel_task_conf表数据
	 */
	public List<ClearChannelTaskConfDO> findClearChannelTaskConfByChannelId(String channelId) {
		ClearChannelTaskConfDOExample exam = new ClearChannelTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return clearChannelTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_channel_task_conf表数据
	 */
	public void updateClearChannelTaskConfById(Long id,ClearChannelTaskConfDO clearChannelTaskConfDO) {
		ClearChannelTaskConfDOExample exam = new ClearChannelTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearChannelTaskConfDAO.updateByExample(clearChannelTaskConfDO, exam);
	}

    /**
	 * 根据channelId更新clear_channel_task_conf表数据
	 */
	public void updateClearChannelTaskConfByChannelId(String channelId,ClearChannelTaskConfDO clearChannelTaskConfDO) {
		ClearChannelTaskConfDOExample exam = new ClearChannelTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearChannelTaskConfDAO.updateByExample(clearChannelTaskConfDO, exam);
	}

	/**
	 * 断言clear_channel_task_log表数据
	 */
	public void assertClearChannelTaskLog(ClearChannelTaskLogDO expect, ClearChannelTaskLogDO clearChannelTaskLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearChannelTaskLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearChannelTaskLogDO.getRawAddTime());
		expect.setRawAddTime(clearChannelTaskLogDO.getRawAddTime());
        Assertions.assertTrue(null != clearChannelTaskLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearChannelTaskLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearChannelTaskLogDO);
	}

    /**
	 * 插入clear_channel_task_log表数据
	 */
	public void insertClearChannelTaskLog(ClearChannelTaskLogDO clearChannelTaskLogDO) {
		clearChannelTaskLogDAO.insert(clearChannelTaskLogDO);
	}

    /**
	 * 插入clear_channel_task_log表数据
	 */
	public void insertClearChannelTaskLog(
			Long id, 
			String channelId, 
			String startDate, 
			String endDate, 
			String clearStatus, 
			Date clearTime, 
			String comment, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (clearTime == null) {
			clearTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearChannelTaskLogDO clearChannelTaskLogDO = new ClearChannelTaskLogDO();
		clearChannelTaskLogDO.setId(id);
		clearChannelTaskLogDO.setChannelId(channelId);
		clearChannelTaskLogDO.setStartDate(startDate);
		clearChannelTaskLogDO.setEndDate(endDate);
		clearChannelTaskLogDO.setClearStatus(clearStatus);
		clearChannelTaskLogDO.setClearTime(clearTime);
		clearChannelTaskLogDO.setComment(comment);
		clearChannelTaskLogDO.setRawAddTime(rawAddTime);
		clearChannelTaskLogDO.setRawUpdateTime(rawUpdateTime);
		clearChannelTaskLogDAO.insert(clearChannelTaskLogDO);
	}

    /**
     * 删除clear_channel_task_log表所有数据
     */
    public void cleanClearChannelTaskLog() {
        ClearChannelTaskLogDOExample exam = new ClearChannelTaskLogDOExample();
        exam.createCriteria();
        clearChannelTaskLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_channel_task_log表数据
	 */
	public void cleanClearChannelTaskLogById(Long id) {
		ClearChannelTaskLogDOExample exam = new ClearChannelTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearChannelTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除clear_channel_task_log表数据
	 */
	public void cleanClearChannelTaskLogByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		ClearChannelTaskLogDOExample exam = new ClearChannelTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearChannelTaskLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_channel_task_log表数据
	 */
	public List<ClearChannelTaskLogDO> findClearChannelTaskLogById(Long id) {
		ClearChannelTaskLogDOExample exam = new ClearChannelTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearChannelTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询clear_channel_task_log表数据
	 */
	public List<ClearChannelTaskLogDO> findClearChannelTaskLogByChannelId(String channelId) {
		ClearChannelTaskLogDOExample exam = new ClearChannelTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return clearChannelTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_channel_task_log表数据
	 */
	public void updateClearChannelTaskLogById(Long id,ClearChannelTaskLogDO clearChannelTaskLogDO) {
		ClearChannelTaskLogDOExample exam = new ClearChannelTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearChannelTaskLogDAO.updateByExample(clearChannelTaskLogDO, exam);
	}

    /**
	 * 根据channelId更新clear_channel_task_log表数据
	 */
	public void updateClearChannelTaskLogByChannelId(String channelId,ClearChannelTaskLogDO clearChannelTaskLogDO) {
		ClearChannelTaskLogDOExample exam = new ClearChannelTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearChannelTaskLogDAO.updateByExample(clearChannelTaskLogDO, exam);
	}

	/**
	 * 断言clear_dsgj_order表数据
	 */
	public void assertClearDsgjOrder(ClearDsgjOrderDO expect, ClearDsgjOrderDO clearDsgjOrderDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearDsgjOrderDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearDsgjOrderDO.getRawAddTime());
		expect.setRawAddTime(clearDsgjOrderDO.getRawAddTime());
        Assertions.assertTrue(null != clearDsgjOrderDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearDsgjOrderDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearDsgjOrderDO);
	}

    /**
	 * 插入clear_dsgj_order表数据
	 */
	public void insertClearDsgjOrder(ClearDsgjOrderDO clearDsgjOrderDO) {
		clearDsgjOrderDAO.insert(clearDsgjOrderDO);
	}

    /**
	 * 插入clear_dsgj_order表数据
	 */
	public void insertClearDsgjOrder(
			Long id, 
			String orderKey, 
			String partnerId, 
			String platPartnerId, 
			String tradeType, 
			String tradeResource, 
			String channelTradeNo, 
			String channelRefundNo, 
			Long orderAmount, 
			Long tradeAmount, 
			String merchantOrderNo, 
			String merchantSubOrderNo, 
			String orderRankType, 
			String platMerchantOrderNo, 
			String merchantTradeNo, 
			String merchantRefundNo, 
			BigDecimal merchantFeeAmount, 
			BigDecimal merchantFee, 
			BigDecimal channelFeeAmount, 
			BigDecimal channelFee, 
			Date tradeTime, 
			String clearDate, 
			String clearFileName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (tradeTime == null) {
			tradeTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearDsgjOrderDO clearDsgjOrderDO = new ClearDsgjOrderDO();
		clearDsgjOrderDO.setId(id);
		clearDsgjOrderDO.setOrderKey(orderKey);
		clearDsgjOrderDO.setPartnerId(partnerId);
		clearDsgjOrderDO.setPlatPartnerId(platPartnerId);
		clearDsgjOrderDO.setTradeType(tradeType);
		clearDsgjOrderDO.setTradeResource(tradeResource);
		clearDsgjOrderDO.setChannelTradeNo(channelTradeNo);
		clearDsgjOrderDO.setChannelRefundNo(channelRefundNo);
		clearDsgjOrderDO.setOrderAmount(orderAmount);
		clearDsgjOrderDO.setTradeAmount(tradeAmount);
		clearDsgjOrderDO.setMerchantOrderNo(merchantOrderNo);
		clearDsgjOrderDO.setMerchantSubOrderNo(merchantSubOrderNo);
		clearDsgjOrderDO.setOrderRankType(orderRankType);
		clearDsgjOrderDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		clearDsgjOrderDO.setMerchantTradeNo(merchantTradeNo);
		clearDsgjOrderDO.setMerchantRefundNo(merchantRefundNo);
		clearDsgjOrderDO.setMerchantFeeAmount(merchantFeeAmount);
		clearDsgjOrderDO.setMerchantFee(merchantFee);
		clearDsgjOrderDO.setChannelFeeAmount(channelFeeAmount);
		clearDsgjOrderDO.setChannelFee(channelFee);
		clearDsgjOrderDO.setTradeTime(tradeTime);
		clearDsgjOrderDO.setClearDate(clearDate);
		clearDsgjOrderDO.setClearFileName(clearFileName);
		clearDsgjOrderDO.setRawAddTime(rawAddTime);
		clearDsgjOrderDO.setRawUpdateTime(rawUpdateTime);
		clearDsgjOrderDAO.insert(clearDsgjOrderDO);
	}

    /**
     * 删除clear_dsgj_order表所有数据
     */
    public void cleanClearDsgjOrder() {
        ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
        exam.createCriteria();
        clearDsgjOrderDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderById(Long id) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelTradeNo删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByChannelTradeNo(String channelTradeNo) {
        if (StringUtils.isBlank(channelTradeNo)){
            channelTradeNo = "test_channelTradeNo";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andChannelTradeNoEqualTo(channelTradeNo);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelRefundNo删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByChannelRefundNo(String channelRefundNo) {
        if (StringUtils.isBlank(channelRefundNo)){
            channelRefundNo = "test_channelRefundNo";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantSubOrderNo删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByMerchantSubOrderNo(String merchantSubOrderNo) {
        if (StringUtils.isBlank(merchantSubOrderNo)){
            merchantSubOrderNo = "test_merchantSubOrderNo";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantSubOrderNoEqualTo(merchantSubOrderNo);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantTradeNo删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByMerchantTradeNo(String merchantTradeNo) {
        if (StringUtils.isBlank(merchantTradeNo)){
            merchantTradeNo = "test_merchantTradeNo";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantRefundNo删除clear_dsgj_order表数据
	 */
	public void cleanClearDsgjOrderByMerchantRefundNo(String merchantRefundNo) {
        if (StringUtils.isBlank(merchantRefundNo)){
            merchantRefundNo = "test_merchantRefundNo";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据clearFileName删除clear_dsgj_order表数据
	*/
	public void cleanClearDsgjOrderByClearFileName(String clearFileName) {
        if (StringUtils.isBlank(clearFileName)){
            clearFileName = "test_clearFileName";
        }
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		clearDsgjOrderDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderById(Long id) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByPartnerId(String partnerId) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByPlatPartnerId(String platPartnerId) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据channelTradeNo查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByChannelTradeNo(String channelTradeNo) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andChannelTradeNoEqualTo(channelTradeNo);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据channelRefundNo查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByChannelRefundNo(String channelRefundNo) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByMerchantOrderNo(String merchantOrderNo) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantSubOrderNo查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByMerchantSubOrderNo(String merchantSubOrderNo) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantSubOrderNoEqualTo(merchantSubOrderNo);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantTradeNo查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByMerchantTradeNo(String merchantTradeNo) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantRefundNo查询clear_dsgj_order表数据
	 */
	public List<ClearDsgjOrderDO> findClearDsgjOrderByMerchantRefundNo(String merchantRefundNo) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

	/**
	* 根据clearFileName查询clear_dsgj_order表数据
	*/
	public List<ClearDsgjOrderDO> findClearDsgjOrderByClearFileName(String clearFileName) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		return clearDsgjOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderById(Long id,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据partnerId更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByPartnerId(String partnerId,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByPlatPartnerId(String platPartnerId,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据channelTradeNo更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByChannelTradeNo(String channelTradeNo,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andChannelTradeNoEqualTo(channelTradeNo);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据channelRefundNo更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByChannelRefundNo(String channelRefundNo,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andChannelRefundNoEqualTo(channelRefundNo);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByMerchantOrderNo(String merchantOrderNo,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据merchantSubOrderNo更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByMerchantSubOrderNo(String merchantSubOrderNo,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantSubOrderNoEqualTo(merchantSubOrderNo);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByPlatMerchantOrderNo(String platMerchantOrderNo,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据merchantTradeNo更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByMerchantTradeNo(String merchantTradeNo,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

    /**
	 * 根据merchantRefundNo更新clear_dsgj_order表数据
	 */
	public void updateClearDsgjOrderByMerchantRefundNo(String merchantRefundNo,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

	/**
	* 根据clearFileName更新clear_dsgj_order表数据
	*/
	public void updateClearDsgjOrderByClearFileName(String clearFileName,ClearDsgjOrderDO clearDsgjOrderDO) {
		ClearDsgjOrderDOExample exam = new ClearDsgjOrderDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		clearDsgjOrderDAO.updateByExample(clearDsgjOrderDO, exam);
	}

	/**
	 * 断言clear_dsgj_request_log表数据
	 */
	public void assertClearDsgjRequestLog(ClearDsgjRequestLogDO expect, ClearDsgjRequestLogDO clearDsgjRequestLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearDsgjRequestLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearDsgjRequestLogDO.getRawAddTime());
		expect.setRawAddTime(clearDsgjRequestLogDO.getRawAddTime());
        Assertions.assertTrue(null != clearDsgjRequestLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearDsgjRequestLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearDsgjRequestLogDO);
	}

    /**
	 * 插入clear_dsgj_request_log表数据
	 */
	public void insertClearDsgjRequestLog(ClearDsgjRequestLogDO clearDsgjRequestLogDO) {
		clearDsgjRequestLogDAO.insert(clearDsgjRequestLogDO);
	}

    /**
	 * 插入clear_dsgj_request_log表数据
	 */
	public void insertClearDsgjRequestLog(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String platPartnerRealName, 
			String amountStatus, 
			String clearDate, 
			String clearFileName, 
			Long tradeAmount, 
			Integer tradeCount, 
			Long refundAmount, 
			Integer refundCount, 
			Long clearAmount, 
			Long partnerFeeAmount, 
			Long platShareAmount, 
			Long channelFeeAmount, 
			String comment, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearDsgjRequestLogDO clearDsgjRequestLogDO = new ClearDsgjRequestLogDO();
		clearDsgjRequestLogDO.setId(id);
		clearDsgjRequestLogDO.setPartnerId(partnerId);
		clearDsgjRequestLogDO.setPlatPartnerId(platPartnerId);
		clearDsgjRequestLogDO.setPlatPartnerRealName(platPartnerRealName);
		clearDsgjRequestLogDO.setAmountStatus(amountStatus);
		clearDsgjRequestLogDO.setClearDate(clearDate);
		clearDsgjRequestLogDO.setClearFileName(clearFileName);
		clearDsgjRequestLogDO.setTradeAmount(tradeAmount);
		clearDsgjRequestLogDO.setTradeCount(tradeCount);
		clearDsgjRequestLogDO.setRefundAmount(refundAmount);
		clearDsgjRequestLogDO.setRefundCount(refundCount);
		clearDsgjRequestLogDO.setClearAmount(clearAmount);
		clearDsgjRequestLogDO.setPartnerFeeAmount(partnerFeeAmount);
		clearDsgjRequestLogDO.setPlatShareAmount(platShareAmount);
		clearDsgjRequestLogDO.setChannelFeeAmount(channelFeeAmount);
		clearDsgjRequestLogDO.setComment(comment);
		clearDsgjRequestLogDO.setRawAddTime(rawAddTime);
		clearDsgjRequestLogDO.setRawUpdateTime(rawUpdateTime);
		clearDsgjRequestLogDAO.insert(clearDsgjRequestLogDO);
	}

    /**
     * 删除clear_dsgj_request_log表所有数据
     */
    public void cleanClearDsgjRequestLog() {
        ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
        exam.createCriteria();
        clearDsgjRequestLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_dsgj_request_log表数据
	 */
	public void cleanClearDsgjRequestLogById(Long id) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjRequestLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除clear_dsgj_request_log表数据
	 */
	public void cleanClearDsgjRequestLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearDsgjRequestLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_dsgj_request_log表数据
	 */
	public void cleanClearDsgjRequestLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjRequestLogDAO.deleteByExample(exam);
	}

	/**
	* 根据platPartnerRealName删除clear_dsgj_request_log表数据
	*/
	public void cleanClearDsgjRequestLogByPlatPartnerRealName(String platPartnerRealName) {
        if (StringUtils.isBlank(platPartnerRealName)){
            platPartnerRealName = "test_platPartnerRealName";
        }
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjRequestLogDAO.deleteByExample(exam);
	}

	/**
	* 根据clearFileName删除clear_dsgj_request_log表数据
	*/
	public void cleanClearDsgjRequestLogByClearFileName(String clearFileName) {
        if (StringUtils.isBlank(clearFileName)){
            clearFileName = "test_clearFileName";
        }
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		clearDsgjRequestLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_dsgj_request_log表数据
	 */
	public List<ClearDsgjRequestLogDO> findClearDsgjRequestLogById(Long id) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearDsgjRequestLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询clear_dsgj_request_log表数据
	 */
	public List<ClearDsgjRequestLogDO> findClearDsgjRequestLogByPartnerId(String partnerId) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return clearDsgjRequestLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_dsgj_request_log表数据
	 */
	public List<ClearDsgjRequestLogDO> findClearDsgjRequestLogByPlatPartnerId(String platPartnerId) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearDsgjRequestLogDAO.selectByExample(exam);
	}

	/**
	* 根据platPartnerRealName查询clear_dsgj_request_log表数据
	*/
	public List<ClearDsgjRequestLogDO> findClearDsgjRequestLogByPlatPartnerRealName(String platPartnerRealName) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		return clearDsgjRequestLogDAO.selectByExample(exam);
	}

	/**
	* 根据clearFileName查询clear_dsgj_request_log表数据
	*/
	public List<ClearDsgjRequestLogDO> findClearDsgjRequestLogByClearFileName(String clearFileName) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		return clearDsgjRequestLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_dsgj_request_log表数据
	 */
	public void updateClearDsgjRequestLogById(Long id,ClearDsgjRequestLogDO clearDsgjRequestLogDO) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjRequestLogDAO.updateByExample(clearDsgjRequestLogDO, exam);
	}

    /**
	 * 根据partnerId更新clear_dsgj_request_log表数据
	 */
	public void updateClearDsgjRequestLogByPartnerId(String partnerId,ClearDsgjRequestLogDO clearDsgjRequestLogDO) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearDsgjRequestLogDAO.updateByExample(clearDsgjRequestLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_dsgj_request_log表数据
	 */
	public void updateClearDsgjRequestLogByPlatPartnerId(String platPartnerId,ClearDsgjRequestLogDO clearDsgjRequestLogDO) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjRequestLogDAO.updateByExample(clearDsgjRequestLogDO, exam);
	}

	/**
	* 根据platPartnerRealName更新clear_dsgj_request_log表数据
	*/
	public void updateClearDsgjRequestLogByPlatPartnerRealName(String platPartnerRealName,ClearDsgjRequestLogDO clearDsgjRequestLogDO) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjRequestLogDAO.updateByExample(clearDsgjRequestLogDO, exam);
	}

	/**
	* 根据clearFileName更新clear_dsgj_request_log表数据
	*/
	public void updateClearDsgjRequestLogByClearFileName(String clearFileName,ClearDsgjRequestLogDO clearDsgjRequestLogDO) {
		ClearDsgjRequestLogDOExample exam = new ClearDsgjRequestLogDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		clearDsgjRequestLogDAO.updateByExample(clearDsgjRequestLogDO, exam);
	}

	/**
	 * 断言clear_dsgj_result_log表数据
	 */
	public void assertClearDsgjResultLog(ClearDsgjResultLogDO expect, ClearDsgjResultLogDO clearDsgjResultLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearDsgjResultLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearDsgjResultLogDO.getRawAddTime());
		expect.setRawAddTime(clearDsgjResultLogDO.getRawAddTime());
        Assertions.assertTrue(null != clearDsgjResultLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearDsgjResultLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearDsgjResultLogDO);
	}

    /**
	 * 插入clear_dsgj_result_log表数据
	 */
	public void insertClearDsgjResultLog(ClearDsgjResultLogDO clearDsgjResultLogDO) {
		clearDsgjResultLogDAO.insert(clearDsgjResultLogDO);
	}

    /**
	 * 插入clear_dsgj_result_log表数据
	 */
	public void insertClearDsgjResultLog(
			Long id, 
			String gid, 
			String bizNo, 
			String partnerId, 
			String platPartnerId, 
			String platPartnerRealName, 
			String partnerSettlementAccount, 
			String amountStatus, 
			String transClearAmountStatus, 
			String downFeeAmountStatus, 
			String clearResultFileName, 
			String channelMerchantId, 
			String channelSubMerchantId, 
			String channelSubMerchantName, 
			String clearDate, 
			String batchNo, 
			String clearType, 
			Long tradeAmount, 
			Integer tradeCount, 
			String settlementSubMerchantId, 
			String settlementSubMerchantName, 
			Long clearAmount, 
			Long platCouponAmount, 
			Long advanceAmount, 
			Long platShareAmount, 
			Long feeAmount, 
			String clearStatus, 
			String comment, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearDsgjResultLogDO clearDsgjResultLogDO = new ClearDsgjResultLogDO();
		clearDsgjResultLogDO.setId(id);
		clearDsgjResultLogDO.setGid(gid);
		clearDsgjResultLogDO.setBizNo(bizNo);
		clearDsgjResultLogDO.setPartnerId(partnerId);
		clearDsgjResultLogDO.setPlatPartnerId(platPartnerId);
		clearDsgjResultLogDO.setPlatPartnerRealName(platPartnerRealName);
		clearDsgjResultLogDO.setPartnerSettlementAccount(partnerSettlementAccount);
		clearDsgjResultLogDO.setAmountStatus(amountStatus);
		clearDsgjResultLogDO.setTransClearAmountStatus(transClearAmountStatus);
		clearDsgjResultLogDO.setDownFeeAmountStatus(downFeeAmountStatus);
		clearDsgjResultLogDO.setClearResultFileName(clearResultFileName);
		clearDsgjResultLogDO.setChannelMerchantId(channelMerchantId);
		clearDsgjResultLogDO.setChannelSubMerchantId(channelSubMerchantId);
		clearDsgjResultLogDO.setChannelSubMerchantName(channelSubMerchantName);
		clearDsgjResultLogDO.setClearDate(clearDate);
		clearDsgjResultLogDO.setBatchNo(batchNo);
		clearDsgjResultLogDO.setClearType(clearType);
		clearDsgjResultLogDO.setTradeAmount(tradeAmount);
		clearDsgjResultLogDO.setTradeCount(tradeCount);
		clearDsgjResultLogDO.setSettlementSubMerchantId(settlementSubMerchantId);
		clearDsgjResultLogDO.setSettlementSubMerchantName(settlementSubMerchantName);
		clearDsgjResultLogDO.setClearAmount(clearAmount);
		clearDsgjResultLogDO.setPlatCouponAmount(platCouponAmount);
		clearDsgjResultLogDO.setAdvanceAmount(advanceAmount);
		clearDsgjResultLogDO.setPlatShareAmount(platShareAmount);
		clearDsgjResultLogDO.setFeeAmount(feeAmount);
		clearDsgjResultLogDO.setClearStatus(clearStatus);
		clearDsgjResultLogDO.setComment(comment);
		clearDsgjResultLogDO.setRawAddTime(rawAddTime);
		clearDsgjResultLogDO.setRawUpdateTime(rawUpdateTime);
		clearDsgjResultLogDAO.insert(clearDsgjResultLogDO);
	}

    /**
     * 删除clear_dsgj_result_log表所有数据
     */
    public void cleanClearDsgjResultLog() {
        ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
        exam.createCriteria();
        clearDsgjResultLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogById(Long id) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	* 根据platPartnerRealName删除clear_dsgj_result_log表数据
	*/
	public void cleanClearDsgjResultLogByPlatPartnerRealName(String platPartnerRealName) {
        if (StringUtils.isBlank(platPartnerRealName)){
            platPartnerRealName = "test_platPartnerRealName";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	* 根据clearResultFileName删除clear_dsgj_result_log表数据
	*/
	public void cleanClearDsgjResultLogByClearResultFileName(String clearResultFileName) {
        if (StringUtils.isBlank(clearResultFileName)){
            clearResultFileName = "test_clearResultFileName";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelMerchantId删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogByChannelMerchantId(String channelMerchantId) {
        if (StringUtils.isBlank(channelMerchantId)){
            channelMerchantId = "test_channelMerchantId";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelMerchantIdEqualTo(channelMerchantId);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelSubMerchantId删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogByChannelSubMerchantId(String channelSubMerchantId) {
        if (StringUtils.isBlank(channelSubMerchantId)){
            channelSubMerchantId = "test_channelSubMerchantId";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	* 根据channelSubMerchantName删除clear_dsgj_result_log表数据
	*/
	public void cleanClearDsgjResultLogByChannelSubMerchantName(String channelSubMerchantName) {
        if (StringUtils.isBlank(channelSubMerchantName)){
            channelSubMerchantName = "test_channelSubMerchantName";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelSubMerchantNameEqualTo(channelSubMerchantName);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchNo删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogByBatchNo(String batchNo) {
        if (StringUtils.isBlank(batchNo)){
            batchNo = "test_batchNo";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据settlementSubMerchantId删除clear_dsgj_result_log表数据
	 */
	public void cleanClearDsgjResultLogBySettlementSubMerchantId(String settlementSubMerchantId) {
        if (StringUtils.isBlank(settlementSubMerchantId)){
            settlementSubMerchantId = "test_settlementSubMerchantId";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andSettlementSubMerchantIdEqualTo(settlementSubMerchantId);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

	/**
	* 根据settlementSubMerchantName删除clear_dsgj_result_log表数据
	*/
	public void cleanClearDsgjResultLogBySettlementSubMerchantName(String settlementSubMerchantName) {
        if (StringUtils.isBlank(settlementSubMerchantName)){
            settlementSubMerchantName = "test_settlementSubMerchantName";
        }
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andSettlementSubMerchantNameEqualTo(settlementSubMerchantName);
		clearDsgjResultLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogById(Long id) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByGid(String gid) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByBizNo(String bizNo) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByPartnerId(String partnerId) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByPlatPartnerId(String platPartnerId) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

	/**
	* 根据platPartnerRealName查询clear_dsgj_result_log表数据
	*/
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByPlatPartnerRealName(String platPartnerRealName) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

	/**
	* 根据clearResultFileName查询clear_dsgj_result_log表数据
	*/
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByClearResultFileName(String clearResultFileName) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelMerchantId查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByChannelMerchantId(String channelMerchantId) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelMerchantIdEqualTo(channelMerchantId);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelSubMerchantId查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByChannelSubMerchantId(String channelSubMerchantId) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

	/**
	* 根据channelSubMerchantName查询clear_dsgj_result_log表数据
	*/
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByChannelSubMerchantName(String channelSubMerchantName) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelSubMerchantNameEqualTo(channelSubMerchantName);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据batchNo查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogByBatchNo(String batchNo) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据settlementSubMerchantId查询clear_dsgj_result_log表数据
	 */
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogBySettlementSubMerchantId(String settlementSubMerchantId) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andSettlementSubMerchantIdEqualTo(settlementSubMerchantId);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

	/**
	* 根据settlementSubMerchantName查询clear_dsgj_result_log表数据
	*/
	public List<ClearDsgjResultLogDO> findClearDsgjResultLogBySettlementSubMerchantName(String settlementSubMerchantName) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andSettlementSubMerchantNameEqualTo(settlementSubMerchantName);
		return clearDsgjResultLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogById(Long id,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据gid更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogByGid(String gid,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据bizNo更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogByBizNo(String bizNo,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据partnerId更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogByPartnerId(String partnerId,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogByPlatPartnerId(String platPartnerId,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

	/**
	* 根据platPartnerRealName更新clear_dsgj_result_log表数据
	*/
	public void updateClearDsgjResultLogByPlatPartnerRealName(String platPartnerRealName,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

	/**
	* 根据clearResultFileName更新clear_dsgj_result_log表数据
	*/
	public void updateClearDsgjResultLogByClearResultFileName(String clearResultFileName,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据channelMerchantId更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogByChannelMerchantId(String channelMerchantId,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelMerchantIdEqualTo(channelMerchantId);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据channelSubMerchantId更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogByChannelSubMerchantId(String channelSubMerchantId,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

	/**
	* 根据channelSubMerchantName更新clear_dsgj_result_log表数据
	*/
	public void updateClearDsgjResultLogByChannelSubMerchantName(String channelSubMerchantName,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andChannelSubMerchantNameEqualTo(channelSubMerchantName);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据batchNo更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogByBatchNo(String batchNo,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

    /**
	 * 根据settlementSubMerchantId更新clear_dsgj_result_log表数据
	 */
	public void updateClearDsgjResultLogBySettlementSubMerchantId(String settlementSubMerchantId,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andSettlementSubMerchantIdEqualTo(settlementSubMerchantId);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

	/**
	* 根据settlementSubMerchantName更新clear_dsgj_result_log表数据
	*/
	public void updateClearDsgjResultLogBySettlementSubMerchantName(String settlementSubMerchantName,ClearDsgjResultLogDO clearDsgjResultLogDO) {
		ClearDsgjResultLogDOExample exam = new ClearDsgjResultLogDOExample();
		exam.createCriteria().andSettlementSubMerchantNameEqualTo(settlementSubMerchantName);
		clearDsgjResultLogDAO.updateByExample(clearDsgjResultLogDO, exam);
	}

	/**
	 * 断言clear_dsgj_result_statistics表数据
	 */
	public void assertClearDsgjResultStatistics(ClearDsgjResultStatisticsDO expect, ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearDsgjResultStatisticsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearDsgjResultStatisticsDO.getRawAddTime());
		expect.setRawAddTime(clearDsgjResultStatisticsDO.getRawAddTime());
        Assertions.assertTrue(null != clearDsgjResultStatisticsDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearDsgjResultStatisticsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearDsgjResultStatisticsDO);
	}

    /**
	 * 插入clear_dsgj_result_statistics表数据
	 */
	public void insertClearDsgjResultStatistics(ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO) {
		clearDsgjResultStatisticsDAO.insert(clearDsgjResultStatisticsDO);
	}

    /**
	 * 插入clear_dsgj_result_statistics表数据
	 */
	public void insertClearDsgjResultStatistics(
			Long id, 
			String platPartnerId, 
			String platPartnerRealName, 
			String clearResultFileName, 
			String clearDate, 
			String batchNo, 
			Long tradeAmount, 
			Integer tradeCount, 
			Long orderAmount, 
			Long paymentAmount, 
			Long couponAmount, 
			Long shareAmount, 
			Long advanceAmount, 
			Long feeAmount, 
			String fileStatus, 
			String clearStatus, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			byte[] platFeeAmount, 
			String comment
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO = new ClearDsgjResultStatisticsDO();
		clearDsgjResultStatisticsDO.setId(id);
		clearDsgjResultStatisticsDO.setPlatPartnerId(platPartnerId);
		clearDsgjResultStatisticsDO.setPlatPartnerRealName(platPartnerRealName);
		clearDsgjResultStatisticsDO.setClearResultFileName(clearResultFileName);
		clearDsgjResultStatisticsDO.setClearDate(clearDate);
		clearDsgjResultStatisticsDO.setBatchNo(batchNo);
		clearDsgjResultStatisticsDO.setTradeAmount(tradeAmount);
		clearDsgjResultStatisticsDO.setTradeCount(tradeCount);
		clearDsgjResultStatisticsDO.setOrderAmount(orderAmount);
		clearDsgjResultStatisticsDO.setPaymentAmount(paymentAmount);
		clearDsgjResultStatisticsDO.setCouponAmount(couponAmount);
		clearDsgjResultStatisticsDO.setShareAmount(shareAmount);
		clearDsgjResultStatisticsDO.setAdvanceAmount(advanceAmount);
		clearDsgjResultStatisticsDO.setFeeAmount(feeAmount);
		clearDsgjResultStatisticsDO.setFileStatus(fileStatus);
		clearDsgjResultStatisticsDO.setClearStatus(clearStatus);
		clearDsgjResultStatisticsDO.setRawAddTime(rawAddTime);
		clearDsgjResultStatisticsDO.setRawUpdateTime(rawUpdateTime);
		clearDsgjResultStatisticsDO.setPlatFeeAmount(platFeeAmount);
		clearDsgjResultStatisticsDO.setComment(comment);
		clearDsgjResultStatisticsDAO.insert(clearDsgjResultStatisticsDO);
	}

    /**
     * 删除clear_dsgj_result_statistics表所有数据
     */
    public void cleanClearDsgjResultStatistics() {
        ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
        exam.createCriteria();
        clearDsgjResultStatisticsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_dsgj_result_statistics表数据
	 */
	public void cleanClearDsgjResultStatisticsById(Long id) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjResultStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_dsgj_result_statistics表数据
	 */
	public void cleanClearDsgjResultStatisticsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjResultStatisticsDAO.deleteByExample(exam);
	}

	/**
	* 根据platPartnerRealName删除clear_dsgj_result_statistics表数据
	*/
	public void cleanClearDsgjResultStatisticsByPlatPartnerRealName(String platPartnerRealName) {
        if (StringUtils.isBlank(platPartnerRealName)){
            platPartnerRealName = "test_platPartnerRealName";
        }
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjResultStatisticsDAO.deleteByExample(exam);
	}

	/**
	* 根据clearResultFileName删除clear_dsgj_result_statistics表数据
	*/
	public void cleanClearDsgjResultStatisticsByClearResultFileName(String clearResultFileName) {
        if (StringUtils.isBlank(clearResultFileName)){
            clearResultFileName = "test_clearResultFileName";
        }
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		clearDsgjResultStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchNo删除clear_dsgj_result_statistics表数据
	 */
	public void cleanClearDsgjResultStatisticsByBatchNo(String batchNo) {
        if (StringUtils.isBlank(batchNo)){
            batchNo = "test_batchNo";
        }
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		clearDsgjResultStatisticsDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_dsgj_result_statistics表数据
	 */
	public List<ClearDsgjResultStatisticsDO> findClearDsgjResultStatisticsById(Long id) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearDsgjResultStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_dsgj_result_statistics表数据
	 */
	public List<ClearDsgjResultStatisticsDO> findClearDsgjResultStatisticsByPlatPartnerId(String platPartnerId) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearDsgjResultStatisticsDAO.selectByExample(exam);
	}

	/**
	* 根据platPartnerRealName查询clear_dsgj_result_statistics表数据
	*/
	public List<ClearDsgjResultStatisticsDO> findClearDsgjResultStatisticsByPlatPartnerRealName(String platPartnerRealName) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		return clearDsgjResultStatisticsDAO.selectByExample(exam);
	}

	/**
	* 根据clearResultFileName查询clear_dsgj_result_statistics表数据
	*/
	public List<ClearDsgjResultStatisticsDO> findClearDsgjResultStatisticsByClearResultFileName(String clearResultFileName) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		return clearDsgjResultStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据batchNo查询clear_dsgj_result_statistics表数据
	 */
	public List<ClearDsgjResultStatisticsDO> findClearDsgjResultStatisticsByBatchNo(String batchNo) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		return clearDsgjResultStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_dsgj_result_statistics表数据
	 */
	public void updateClearDsgjResultStatisticsById(Long id,ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjResultStatisticsDAO.updateByExample(clearDsgjResultStatisticsDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_dsgj_result_statistics表数据
	 */
	public void updateClearDsgjResultStatisticsByPlatPartnerId(String platPartnerId,ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjResultStatisticsDAO.updateByExample(clearDsgjResultStatisticsDO, exam);
	}

	/**
	* 根据platPartnerRealName更新clear_dsgj_result_statistics表数据
	*/
	public void updateClearDsgjResultStatisticsByPlatPartnerRealName(String platPartnerRealName,ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjResultStatisticsDAO.updateByExample(clearDsgjResultStatisticsDO, exam);
	}

	/**
	* 根据clearResultFileName更新clear_dsgj_result_statistics表数据
	*/
	public void updateClearDsgjResultStatisticsByClearResultFileName(String clearResultFileName,ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		clearDsgjResultStatisticsDAO.updateByExample(clearDsgjResultStatisticsDO, exam);
	}

    /**
	 * 根据batchNo更新clear_dsgj_result_statistics表数据
	 */
	public void updateClearDsgjResultStatisticsByBatchNo(String batchNo,ClearDsgjResultStatisticsDO clearDsgjResultStatisticsDO) {
		ClearDsgjResultStatisticsDOExample exam = new ClearDsgjResultStatisticsDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		clearDsgjResultStatisticsDAO.updateByExample(clearDsgjResultStatisticsDO, exam);
	}

	/**
	 * 断言clear_dsgj_task_conf表数据
	 */
	public void assertClearDsgjTaskConf(ClearDsgjTaskConfDO expect, ClearDsgjTaskConfDO clearDsgjTaskConfDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearDsgjTaskConfDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearDsgjTaskConfDO.getRawAddTime());
		expect.setRawAddTime(clearDsgjTaskConfDO.getRawAddTime());
        Assertions.assertTrue(null != clearDsgjTaskConfDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearDsgjTaskConfDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearDsgjTaskConfDO);
	}

    /**
	 * 插入clear_dsgj_task_conf表数据
	 */
	public void insertClearDsgjTaskConf(ClearDsgjTaskConfDO clearDsgjTaskConfDO) {
		clearDsgjTaskConfDAO.insert(clearDsgjTaskConfDO);
	}

    /**
	 * 插入clear_dsgj_task_conf表数据
	 */
	public void insertClearDsgjTaskConf(
			Long id, 
			String platPartnerId, 
			String platPartnerRealName, 
			Integer clearCycle, 
			String useClear, 
			String clearTime, 
			String useSettlement, 
			String settlementTime, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearDsgjTaskConfDO clearDsgjTaskConfDO = new ClearDsgjTaskConfDO();
		clearDsgjTaskConfDO.setId(id);
		clearDsgjTaskConfDO.setPlatPartnerId(platPartnerId);
		clearDsgjTaskConfDO.setPlatPartnerRealName(platPartnerRealName);
		clearDsgjTaskConfDO.setClearCycle(clearCycle);
		clearDsgjTaskConfDO.setUseClear(useClear);
		clearDsgjTaskConfDO.setClearTime(clearTime);
		clearDsgjTaskConfDO.setUseSettlement(useSettlement);
		clearDsgjTaskConfDO.setSettlementTime(settlementTime);
		clearDsgjTaskConfDO.setMemo(memo);
		clearDsgjTaskConfDO.setRawAddTime(rawAddTime);
		clearDsgjTaskConfDO.setRawUpdateTime(rawUpdateTime);
		clearDsgjTaskConfDAO.insert(clearDsgjTaskConfDO);
	}

    /**
     * 删除clear_dsgj_task_conf表所有数据
     */
    public void cleanClearDsgjTaskConf() {
        ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
        exam.createCriteria();
        clearDsgjTaskConfDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_dsgj_task_conf表数据
	 */
	public void cleanClearDsgjTaskConfById(Long id) {
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjTaskConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_dsgj_task_conf表数据
	 */
	public void cleanClearDsgjTaskConfByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjTaskConfDAO.deleteByExample(exam);
	}

	/**
	* 根据platPartnerRealName删除clear_dsgj_task_conf表数据
	*/
	public void cleanClearDsgjTaskConfByPlatPartnerRealName(String platPartnerRealName) {
        if (StringUtils.isBlank(platPartnerRealName)){
            platPartnerRealName = "test_platPartnerRealName";
        }
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjTaskConfDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_dsgj_task_conf表数据
	 */
	public List<ClearDsgjTaskConfDO> findClearDsgjTaskConfById(Long id) {
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearDsgjTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_dsgj_task_conf表数据
	 */
	public List<ClearDsgjTaskConfDO> findClearDsgjTaskConfByPlatPartnerId(String platPartnerId) {
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearDsgjTaskConfDAO.selectByExample(exam);
	}

	/**
	* 根据platPartnerRealName查询clear_dsgj_task_conf表数据
	*/
	public List<ClearDsgjTaskConfDO> findClearDsgjTaskConfByPlatPartnerRealName(String platPartnerRealName) {
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		return clearDsgjTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_dsgj_task_conf表数据
	 */
	public void updateClearDsgjTaskConfById(Long id,ClearDsgjTaskConfDO clearDsgjTaskConfDO) {
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjTaskConfDAO.updateByExample(clearDsgjTaskConfDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_dsgj_task_conf表数据
	 */
	public void updateClearDsgjTaskConfByPlatPartnerId(String platPartnerId,ClearDsgjTaskConfDO clearDsgjTaskConfDO) {
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjTaskConfDAO.updateByExample(clearDsgjTaskConfDO, exam);
	}

	/**
	* 根据platPartnerRealName更新clear_dsgj_task_conf表数据
	*/
	public void updateClearDsgjTaskConfByPlatPartnerRealName(String platPartnerRealName,ClearDsgjTaskConfDO clearDsgjTaskConfDO) {
		ClearDsgjTaskConfDOExample exam = new ClearDsgjTaskConfDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjTaskConfDAO.updateByExample(clearDsgjTaskConfDO, exam);
	}

	/**
	 * 断言clear_dsgj_task_log表数据
	 */
	public void assertClearDsgjTaskLog(ClearDsgjTaskLogDO expect, ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearDsgjTaskLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearDsgjTaskLogDO.getRawAddTime());
		expect.setRawAddTime(clearDsgjTaskLogDO.getRawAddTime());
        Assertions.assertTrue(null != clearDsgjTaskLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearDsgjTaskLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearDsgjTaskLogDO);
	}

    /**
	 * 插入clear_dsgj_task_log表数据
	 */
	public void insertClearDsgjTaskLog(ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		clearDsgjTaskLogDAO.insert(clearDsgjTaskLogDO);
	}

    /**
	 * 插入clear_dsgj_task_log表数据
	 */
	public void insertClearDsgjTaskLog(
			Long id, 
			String gid, 
			String bizNo, 
			String platPartnerId, 
			String platPartnerRealName, 
			String clearDate, 
			String clearFileName, 
			String clearResultFileName, 
			String clearStatus, 
			String fileStatus, 
			Date clearTime, 
			Date requestTime, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String comment
	) {
		if (clearTime == null) {
			clearTime = new Date();
		}
		if (requestTime == null) {
			requestTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearDsgjTaskLogDO clearDsgjTaskLogDO = new ClearDsgjTaskLogDO();
		clearDsgjTaskLogDO.setId(id);
		clearDsgjTaskLogDO.setGid(gid);
		clearDsgjTaskLogDO.setBizNo(bizNo);
		clearDsgjTaskLogDO.setPlatPartnerId(platPartnerId);
		clearDsgjTaskLogDO.setPlatPartnerRealName(platPartnerRealName);
		clearDsgjTaskLogDO.setClearDate(clearDate);
		clearDsgjTaskLogDO.setClearFileName(clearFileName);
		clearDsgjTaskLogDO.setClearResultFileName(clearResultFileName);
		clearDsgjTaskLogDO.setClearStatus(clearStatus);
		clearDsgjTaskLogDO.setFileStatus(fileStatus);
		clearDsgjTaskLogDO.setClearTime(clearTime);
		clearDsgjTaskLogDO.setRequestTime(requestTime);
		clearDsgjTaskLogDO.setRawAddTime(rawAddTime);
		clearDsgjTaskLogDO.setRawUpdateTime(rawUpdateTime);
		clearDsgjTaskLogDO.setComment(comment);
		clearDsgjTaskLogDAO.insert(clearDsgjTaskLogDO);
	}

    /**
     * 删除clear_dsgj_task_log表所有数据
     */
    public void cleanClearDsgjTaskLog() {
        ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
        exam.createCriteria();
        clearDsgjTaskLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_dsgj_task_log表数据
	 */
	public void cleanClearDsgjTaskLogById(Long id) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除clear_dsgj_task_log表数据
	 */
	public void cleanClearDsgjTaskLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		clearDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除clear_dsgj_task_log表数据
	 */
	public void cleanClearDsgjTaskLogByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		clearDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_dsgj_task_log表数据
	 */
	public void cleanClearDsgjTaskLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	* 根据platPartnerRealName删除clear_dsgj_task_log表数据
	*/
	public void cleanClearDsgjTaskLogByPlatPartnerRealName(String platPartnerRealName) {
        if (StringUtils.isBlank(platPartnerRealName)){
            platPartnerRealName = "test_platPartnerRealName";
        }
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	* 根据clearFileName删除clear_dsgj_task_log表数据
	*/
	public void cleanClearDsgjTaskLogByClearFileName(String clearFileName) {
        if (StringUtils.isBlank(clearFileName)){
            clearFileName = "test_clearFileName";
        }
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		clearDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	* 根据clearResultFileName删除clear_dsgj_task_log表数据
	*/
	public void cleanClearDsgjTaskLogByClearResultFileName(String clearResultFileName) {
        if (StringUtils.isBlank(clearResultFileName)){
            clearResultFileName = "test_clearResultFileName";
        }
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		clearDsgjTaskLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_dsgj_task_log表数据
	 */
	public List<ClearDsgjTaskLogDO> findClearDsgjTaskLogById(Long id) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询clear_dsgj_task_log表数据
	 */
	public List<ClearDsgjTaskLogDO> findClearDsgjTaskLogByGid(String gid) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return clearDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询clear_dsgj_task_log表数据
	 */
	public List<ClearDsgjTaskLogDO> findClearDsgjTaskLogByBizNo(String bizNo) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return clearDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_dsgj_task_log表数据
	 */
	public List<ClearDsgjTaskLogDO> findClearDsgjTaskLogByPlatPartnerId(String platPartnerId) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearDsgjTaskLogDAO.selectByExample(exam);
	}

	/**
	* 根据platPartnerRealName查询clear_dsgj_task_log表数据
	*/
	public List<ClearDsgjTaskLogDO> findClearDsgjTaskLogByPlatPartnerRealName(String platPartnerRealName) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		return clearDsgjTaskLogDAO.selectByExample(exam);
	}

	/**
	* 根据clearFileName查询clear_dsgj_task_log表数据
	*/
	public List<ClearDsgjTaskLogDO> findClearDsgjTaskLogByClearFileName(String clearFileName) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		return clearDsgjTaskLogDAO.selectByExample(exam);
	}

	/**
	* 根据clearResultFileName查询clear_dsgj_task_log表数据
	*/
	public List<ClearDsgjTaskLogDO> findClearDsgjTaskLogByClearResultFileName(String clearResultFileName) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		return clearDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_dsgj_task_log表数据
	 */
	public void updateClearDsgjTaskLogById(Long id,ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearDsgjTaskLogDAO.updateByExample(clearDsgjTaskLogDO, exam);
	}

    /**
	 * 根据gid更新clear_dsgj_task_log表数据
	 */
	public void updateClearDsgjTaskLogByGid(String gid,ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		clearDsgjTaskLogDAO.updateByExample(clearDsgjTaskLogDO, exam);
	}

    /**
	 * 根据bizNo更新clear_dsgj_task_log表数据
	 */
	public void updateClearDsgjTaskLogByBizNo(String bizNo,ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		clearDsgjTaskLogDAO.updateByExample(clearDsgjTaskLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_dsgj_task_log表数据
	 */
	public void updateClearDsgjTaskLogByPlatPartnerId(String platPartnerId,ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearDsgjTaskLogDAO.updateByExample(clearDsgjTaskLogDO, exam);
	}

	/**
	* 根据platPartnerRealName更新clear_dsgj_task_log表数据
	*/
	public void updateClearDsgjTaskLogByPlatPartnerRealName(String platPartnerRealName,ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		clearDsgjTaskLogDAO.updateByExample(clearDsgjTaskLogDO, exam);
	}

	/**
	* 根据clearFileName更新clear_dsgj_task_log表数据
	*/
	public void updateClearDsgjTaskLogByClearFileName(String clearFileName,ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andClearFileNameEqualTo(clearFileName);
		clearDsgjTaskLogDAO.updateByExample(clearDsgjTaskLogDO, exam);
	}

	/**
	* 根据clearResultFileName更新clear_dsgj_task_log表数据
	*/
	public void updateClearDsgjTaskLogByClearResultFileName(String clearResultFileName,ClearDsgjTaskLogDO clearDsgjTaskLogDO) {
		ClearDsgjTaskLogDOExample exam = new ClearDsgjTaskLogDOExample();
		exam.createCriteria().andClearResultFileNameEqualTo(clearResultFileName);
		clearDsgjTaskLogDAO.updateByExample(clearDsgjTaskLogDO, exam);
	}

	/**
	 * 断言clear_merchant_order表数据
	 */
	public void assertClearMerchantOrder(ClearMerchantOrderDO expect, ClearMerchantOrderDO clearMerchantOrderDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearMerchantOrderDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearMerchantOrderDO.getRawAddTime());
		expect.setRawAddTime(clearMerchantOrderDO.getRawAddTime());
        Assertions.assertTrue(null != clearMerchantOrderDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearMerchantOrderDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearMerchantOrderDO);
	}

    /**
	 * 插入clear_merchant_order表数据
	 */
	public void insertClearMerchantOrder(ClearMerchantOrderDO clearMerchantOrderDO) {
		clearMerchantOrderDAO.insert(clearMerchantOrderDO);
	}

    /**
	 * 插入clear_merchant_order表数据
	 */
	public void insertClearMerchantOrder(
			Long id, 
			String partnerId, 
			String partnerRealName, 
			String channelId, 
			String platPartnerId, 
			String transType, 
			String transTag, 
			String orderType, 
			String merchantOrderNo, 
			String bizNo, 
			String platMerchantOrderNo, 
			String merchantTradeNo, 
			String merchantRefundNo, 
			Long merchantOrderAmount, 
			Long merchantAmount, 
			BigDecimal merchantFeeAmount, 
			BigDecimal merchantFee, 
			String merchantRateType, 
			BigDecimal channelFeeAmount, 
			BigDecimal channelFee, 
			String channelRateType, 
			Date merchantTradeTime, 
			String settlementDate, 
			String tradeResource, 
			String clearStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (merchantTradeTime == null) {
			merchantTradeTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearMerchantOrderDO clearMerchantOrderDO = new ClearMerchantOrderDO();
		clearMerchantOrderDO.setId(id);
		clearMerchantOrderDO.setPartnerId(partnerId);
		clearMerchantOrderDO.setPartnerRealName(partnerRealName);
		clearMerchantOrderDO.setChannelId(channelId);
		clearMerchantOrderDO.setPlatPartnerId(platPartnerId);
		clearMerchantOrderDO.setTransType(transType);
		clearMerchantOrderDO.setTransTag(transTag);
		clearMerchantOrderDO.setOrderType(orderType);
		clearMerchantOrderDO.setMerchantOrderNo(merchantOrderNo);
		clearMerchantOrderDO.setBizNo(bizNo);
		clearMerchantOrderDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		clearMerchantOrderDO.setMerchantTradeNo(merchantTradeNo);
		clearMerchantOrderDO.setMerchantRefundNo(merchantRefundNo);
		clearMerchantOrderDO.setMerchantOrderAmount(merchantOrderAmount);
		clearMerchantOrderDO.setMerchantAmount(merchantAmount);
		clearMerchantOrderDO.setMerchantFeeAmount(merchantFeeAmount);
		clearMerchantOrderDO.setMerchantFee(merchantFee);
		clearMerchantOrderDO.setMerchantRateType(merchantRateType);
		clearMerchantOrderDO.setChannelFeeAmount(channelFeeAmount);
		clearMerchantOrderDO.setChannelFee(channelFee);
		clearMerchantOrderDO.setChannelRateType(channelRateType);
		clearMerchantOrderDO.setMerchantTradeTime(merchantTradeTime);
		clearMerchantOrderDO.setSettlementDate(settlementDate);
		clearMerchantOrderDO.setTradeResource(tradeResource);
		clearMerchantOrderDO.setClearStatus(clearStatus);
		clearMerchantOrderDO.setRawAddTime(rawAddTime);
		clearMerchantOrderDO.setRawUpdateTime(rawUpdateTime);
		clearMerchantOrderDAO.insert(clearMerchantOrderDO);
	}

    /**
     * 删除clear_merchant_order表所有数据
     */
    public void cleanClearMerchantOrder() {
        ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
        exam.createCriteria();
        clearMerchantOrderDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderById(Long id) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除clear_merchant_order表数据
	*/
	public void cleanClearMerchantOrderByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantTradeNo删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByMerchantTradeNo(String merchantTradeNo) {
        if (StringUtils.isBlank(merchantTradeNo)){
            merchantTradeNo = "test_merchantTradeNo";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantRefundNo删除clear_merchant_order表数据
	 */
	public void cleanClearMerchantOrderByMerchantRefundNo(String merchantRefundNo) {
        if (StringUtils.isBlank(merchantRefundNo)){
            merchantRefundNo = "test_merchantRefundNo";
        }
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		clearMerchantOrderDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderById(Long id) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByPartnerId(String partnerId) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询clear_merchant_order表数据
	*/
	public List<ClearMerchantOrderDO> findClearMerchantOrderByPartnerRealName(String partnerRealName) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByChannelId(String channelId) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByPlatPartnerId(String platPartnerId) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByMerchantOrderNo(String merchantOrderNo) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByBizNo(String bizNo) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantTradeNo查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByMerchantTradeNo(String merchantTradeNo) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantRefundNo查询clear_merchant_order表数据
	 */
	public List<ClearMerchantOrderDO> findClearMerchantOrderByMerchantRefundNo(String merchantRefundNo) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		return clearMerchantOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderById(Long id,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据partnerId更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByPartnerId(String partnerId,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

	/**
	* 根据partnerRealName更新clear_merchant_order表数据
	*/
	public void updateClearMerchantOrderByPartnerRealName(String partnerRealName,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据channelId更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByChannelId(String channelId,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByPlatPartnerId(String platPartnerId,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByMerchantOrderNo(String merchantOrderNo,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据bizNo更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByBizNo(String bizNo,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByPlatMerchantOrderNo(String platMerchantOrderNo,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据merchantTradeNo更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByMerchantTradeNo(String merchantTradeNo,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantTradeNoEqualTo(merchantTradeNo);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

    /**
	 * 根据merchantRefundNo更新clear_merchant_order表数据
	 */
	public void updateClearMerchantOrderByMerchantRefundNo(String merchantRefundNo,ClearMerchantOrderDO clearMerchantOrderDO) {
		ClearMerchantOrderDOExample exam = new ClearMerchantOrderDOExample();
		exam.createCriteria().andMerchantRefundNoEqualTo(merchantRefundNo);
		clearMerchantOrderDAO.updateByExample(clearMerchantOrderDO, exam);
	}

	/**
	 * 断言clear_statistics表数据
	 */
	public void assertClearStatistics(ClearStatisticsDO expect, ClearStatisticsDO clearStatisticsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearStatisticsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearStatisticsDO.getRawAddTime());
		expect.setRawAddTime(clearStatisticsDO.getRawAddTime());
        Assertions.assertTrue(null != clearStatisticsDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearStatisticsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearStatisticsDO);
	}

    /**
	 * 插入clear_statistics表数据
	 */
	public void insertClearStatistics(ClearStatisticsDO clearStatisticsDO) {
		clearStatisticsDAO.insert(clearStatisticsDO);
	}

    /**
	 * 插入clear_statistics表数据
	 */
	public void insertClearStatistics(
			Long id, 
			String partnerId, 
			String channelId, 
			String partnerRealName, 
			String platPartnerId, 
			Long orderAmount, 
			Long clearAmount, 
			Long refundAmount, 
			Long refundCount, 
			Long transactionAmount, 
			Long transactionCount, 
			String billInfoStatus, 
			BigDecimal merchantFeeAmount, 
			BigDecimal channelFeeAmount, 
			String settlementDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearStatisticsDO clearStatisticsDO = new ClearStatisticsDO();
		clearStatisticsDO.setId(id);
		clearStatisticsDO.setPartnerId(partnerId);
		clearStatisticsDO.setChannelId(channelId);
		clearStatisticsDO.setPartnerRealName(partnerRealName);
		clearStatisticsDO.setPlatPartnerId(platPartnerId);
		clearStatisticsDO.setOrderAmount(orderAmount);
		clearStatisticsDO.setClearAmount(clearAmount);
		clearStatisticsDO.setRefundAmount(refundAmount);
		clearStatisticsDO.setRefundCount(refundCount);
		clearStatisticsDO.setTransactionAmount(transactionAmount);
		clearStatisticsDO.setTransactionCount(transactionCount);
		clearStatisticsDO.setBillInfoStatus(billInfoStatus);
		clearStatisticsDO.setMerchantFeeAmount(merchantFeeAmount);
		clearStatisticsDO.setChannelFeeAmount(channelFeeAmount);
		clearStatisticsDO.setSettlementDate(settlementDate);
		clearStatisticsDO.setRawAddTime(rawAddTime);
		clearStatisticsDO.setRawUpdateTime(rawUpdateTime);
		clearStatisticsDAO.insert(clearStatisticsDO);
	}

    /**
     * 删除clear_statistics表所有数据
     */
    public void cleanClearStatistics() {
        ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
        exam.createCriteria();
        clearStatisticsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_statistics表数据
	 */
	public void cleanClearStatisticsById(Long id) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearStatisticsDAO.deleteByExample(exam);
	}
	/**
	 * 根据partnerId,settlementDate删除clear_statistics表数据
	 */
	public void cleanClearStatisticsByPartnerIdAndSettlementDate(String partnerId,String settlementDate) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
        if (StringUtils.isBlank(settlementDate)){
            settlementDate = "test_settlementDate";
        }
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andSettlementDateEqualTo(settlementDate);
		clearStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除clear_statistics表数据
	 */
	public void cleanClearStatisticsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除clear_statistics表数据
	 */
	public void cleanClearStatisticsByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearStatisticsDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除clear_statistics表数据
	*/
	public void cleanClearStatisticsByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		clearStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除clear_statistics表数据
	 */
	public void cleanClearStatisticsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearStatisticsDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_statistics表数据
	 */
	public List<ClearStatisticsDO> findClearStatisticsById(Long id) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearStatisticsDAO.selectByExample(exam);
	}

	/**
	 * 根据partnerId,settlementDate查询clear_statistics表数据
	 */
	public List<ClearStatisticsDO> findClearStatisticsByPartnerIdAndSettlementDate(String partnerId,String settlementDate) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andSettlementDateEqualTo(settlementDate);
		return clearStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询clear_statistics表数据
	 */
	public List<ClearStatisticsDO> findClearStatisticsByPartnerId(String partnerId) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return clearStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询clear_statistics表数据
	 */
	public List<ClearStatisticsDO> findClearStatisticsByChannelId(String channelId) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return clearStatisticsDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询clear_statistics表数据
	*/
	public List<ClearStatisticsDO> findClearStatisticsByPartnerRealName(String partnerRealName) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return clearStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询clear_statistics表数据
	 */
	public List<ClearStatisticsDO> findClearStatisticsByPlatPartnerId(String platPartnerId) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return clearStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_statistics表数据
	 */
	public void updateClearStatisticsById(Long id,ClearStatisticsDO clearStatisticsDO) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearStatisticsDAO.updateByExample(clearStatisticsDO, exam);
	}

	/**
	 * 根据partnerId,settlementDate更新clear_statistics表数据
	 */
	public void updateClearStatisticsByPartnerIdAndSettlementDate(String partnerId,String settlementDate,ClearStatisticsDO clearStatisticsDO) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andSettlementDateEqualTo(settlementDate);
		clearStatisticsDAO.updateByExample(clearStatisticsDO, exam);
	}

    /**
	 * 根据partnerId更新clear_statistics表数据
	 */
	public void updateClearStatisticsByPartnerId(String partnerId,ClearStatisticsDO clearStatisticsDO) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearStatisticsDAO.updateByExample(clearStatisticsDO, exam);
	}

    /**
	 * 根据channelId更新clear_statistics表数据
	 */
	public void updateClearStatisticsByChannelId(String channelId,ClearStatisticsDO clearStatisticsDO) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearStatisticsDAO.updateByExample(clearStatisticsDO, exam);
	}

	/**
	* 根据partnerRealName更新clear_statistics表数据
	*/
	public void updateClearStatisticsByPartnerRealName(String partnerRealName,ClearStatisticsDO clearStatisticsDO) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		clearStatisticsDAO.updateByExample(clearStatisticsDO, exam);
	}

    /**
	 * 根据platPartnerId更新clear_statistics表数据
	 */
	public void updateClearStatisticsByPlatPartnerId(String platPartnerId,ClearStatisticsDO clearStatisticsDO) {
		ClearStatisticsDOExample exam = new ClearStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		clearStatisticsDAO.updateByExample(clearStatisticsDO, exam);
	}

	/**
	 * 断言clear_trans_type_conf表数据
	 */
	public void assertClearTransTypeConf(ClearTransTypeConfDO expect, ClearTransTypeConfDO clearTransTypeConfDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			clearTransTypeConfDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != clearTransTypeConfDO.getRawAddTime());
		expect.setRawAddTime(clearTransTypeConfDO.getRawAddTime());
        Assertions.assertTrue(null != clearTransTypeConfDO.getRawUpdateTime());
		expect.setRawUpdateTime(clearTransTypeConfDO.getRawUpdateTime());
		Assertions.assertEquals(expect, clearTransTypeConfDO);
	}

    /**
	 * 插入clear_trans_type_conf表数据
	 */
	public void insertClearTransTypeConf(ClearTransTypeConfDO clearTransTypeConfDO) {
		clearTransTypeConfDAO.insert(clearTransTypeConfDO);
	}

    /**
	 * 插入clear_trans_type_conf表数据
	 */
	public void insertClearTransTypeConf(
			Long id, 
			String partnerId, 
			String channelId, 
			String transType, 
			String transTag, 
			String orderType, 
			String clearConfType, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ClearTransTypeConfDO clearTransTypeConfDO = new ClearTransTypeConfDO();
		clearTransTypeConfDO.setId(id);
		clearTransTypeConfDO.setPartnerId(partnerId);
		clearTransTypeConfDO.setChannelId(channelId);
		clearTransTypeConfDO.setTransType(transType);
		clearTransTypeConfDO.setTransTag(transTag);
		clearTransTypeConfDO.setOrderType(orderType);
		clearTransTypeConfDO.setClearConfType(clearConfType);
		clearTransTypeConfDO.setRawAddTime(rawAddTime);
		clearTransTypeConfDO.setRawUpdateTime(rawUpdateTime);
		clearTransTypeConfDAO.insert(clearTransTypeConfDO);
	}

    /**
     * 删除clear_trans_type_conf表所有数据
     */
    public void cleanClearTransTypeConf() {
        ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
        exam.createCriteria();
        clearTransTypeConfDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除clear_trans_type_conf表数据
	 */
	public void cleanClearTransTypeConfById(Long id) {
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearTransTypeConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除clear_trans_type_conf表数据
	 */
	public void cleanClearTransTypeConfByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearTransTypeConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除clear_trans_type_conf表数据
	 */
	public void cleanClearTransTypeConfByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearTransTypeConfDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询clear_trans_type_conf表数据
	 */
	public List<ClearTransTypeConfDO> findClearTransTypeConfById(Long id) {
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return clearTransTypeConfDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询clear_trans_type_conf表数据
	 */
	public List<ClearTransTypeConfDO> findClearTransTypeConfByPartnerId(String partnerId) {
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return clearTransTypeConfDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询clear_trans_type_conf表数据
	 */
	public List<ClearTransTypeConfDO> findClearTransTypeConfByChannelId(String channelId) {
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return clearTransTypeConfDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新clear_trans_type_conf表数据
	 */
	public void updateClearTransTypeConfById(Long id,ClearTransTypeConfDO clearTransTypeConfDO) {
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		clearTransTypeConfDAO.updateByExample(clearTransTypeConfDO, exam);
	}

    /**
	 * 根据partnerId更新clear_trans_type_conf表数据
	 */
	public void updateClearTransTypeConfByPartnerId(String partnerId,ClearTransTypeConfDO clearTransTypeConfDO) {
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		clearTransTypeConfDAO.updateByExample(clearTransTypeConfDO, exam);
	}

    /**
	 * 根据channelId更新clear_trans_type_conf表数据
	 */
	public void updateClearTransTypeConfByChannelId(String channelId,ClearTransTypeConfDO clearTransTypeConfDO) {
		ClearTransTypeConfDOExample exam = new ClearTransTypeConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		clearTransTypeConfDAO.updateByExample(clearTransTypeConfDO, exam);
	}

	/**
	 * 断言settlement_account_conf表数据
	 */
	public void assertSettlementAccountConf(SettlementAccountConfDO expect, SettlementAccountConfDO settlementAccountConfDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			settlementAccountConfDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != settlementAccountConfDO.getRawAddTime());
		expect.setRawAddTime(settlementAccountConfDO.getRawAddTime());
        Assertions.assertTrue(null != settlementAccountConfDO.getRawUpdateTime());
		expect.setRawUpdateTime(settlementAccountConfDO.getRawUpdateTime());
		Assertions.assertEquals(expect, settlementAccountConfDO);
	}

    /**
	 * 插入settlement_account_conf表数据
	 */
	public void insertSettlementAccountConf(SettlementAccountConfDO settlementAccountConfDO) {
		settlementAccountConfDAO.insert(settlementAccountConfDO);
	}

    /**
	 * 插入settlement_account_conf表数据
	 */
	public void insertSettlementAccountConf(
			Long id, 
			String partnerId, 
			String channelId, 
			String settlementType, 
			String accountNo, 
			String cardNo, 
			String settlementName, 
			Integer rate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SettlementAccountConfDO settlementAccountConfDO = new SettlementAccountConfDO();
		settlementAccountConfDO.setId(id);
		settlementAccountConfDO.setPartnerId(partnerId);
		settlementAccountConfDO.setChannelId(channelId);
		settlementAccountConfDO.setSettlementType(settlementType);
		settlementAccountConfDO.setAccountNo(accountNo);
		settlementAccountConfDO.setCardNo(cardNo);
		settlementAccountConfDO.setSettlementName(settlementName);
		settlementAccountConfDO.setRate(rate);
		settlementAccountConfDO.setRawAddTime(rawAddTime);
		settlementAccountConfDO.setRawUpdateTime(rawUpdateTime);
		settlementAccountConfDAO.insert(settlementAccountConfDO);
	}

    /**
     * 删除settlement_account_conf表所有数据
     */
    public void cleanSettlementAccountConf() {
        SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
        exam.createCriteria();
        settlementAccountConfDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除settlement_account_conf表数据
	 */
	public void cleanSettlementAccountConfById(Long id) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementAccountConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除settlement_account_conf表数据
	 */
	public void cleanSettlementAccountConfByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementAccountConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除settlement_account_conf表数据
	 */
	public void cleanSettlementAccountConfByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementAccountConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除settlement_account_conf表数据
	 */
	public void cleanSettlementAccountConfByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		settlementAccountConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除settlement_account_conf表数据
	 */
	public void cleanSettlementAccountConfByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		settlementAccountConfDAO.deleteByExample(exam);
	}

	/**
	* 根据settlementName删除settlement_account_conf表数据
	*/
	public void cleanSettlementAccountConfBySettlementName(String settlementName) {
        if (StringUtils.isBlank(settlementName)){
            settlementName = "test_settlementName";
        }
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andSettlementNameEqualTo(settlementName);
		settlementAccountConfDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询settlement_account_conf表数据
	 */
	public List<SettlementAccountConfDO> findSettlementAccountConfById(Long id) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return settlementAccountConfDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询settlement_account_conf表数据
	 */
	public List<SettlementAccountConfDO> findSettlementAccountConfByPartnerId(String partnerId) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return settlementAccountConfDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询settlement_account_conf表数据
	 */
	public List<SettlementAccountConfDO> findSettlementAccountConfByChannelId(String channelId) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return settlementAccountConfDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询settlement_account_conf表数据
	 */
	public List<SettlementAccountConfDO> findSettlementAccountConfByAccountNo(String accountNo) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return settlementAccountConfDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询settlement_account_conf表数据
	 */
	public List<SettlementAccountConfDO> findSettlementAccountConfByCardNo(String cardNo) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return settlementAccountConfDAO.selectByExample(exam);
	}

	/**
	* 根据settlementName查询settlement_account_conf表数据
	*/
	public List<SettlementAccountConfDO> findSettlementAccountConfBySettlementName(String settlementName) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andSettlementNameEqualTo(settlementName);
		return settlementAccountConfDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新settlement_account_conf表数据
	 */
	public void updateSettlementAccountConfById(Long id,SettlementAccountConfDO settlementAccountConfDO) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementAccountConfDAO.updateByExample(settlementAccountConfDO, exam);
	}

    /**
	 * 根据partnerId更新settlement_account_conf表数据
	 */
	public void updateSettlementAccountConfByPartnerId(String partnerId,SettlementAccountConfDO settlementAccountConfDO) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementAccountConfDAO.updateByExample(settlementAccountConfDO, exam);
	}

    /**
	 * 根据channelId更新settlement_account_conf表数据
	 */
	public void updateSettlementAccountConfByChannelId(String channelId,SettlementAccountConfDO settlementAccountConfDO) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementAccountConfDAO.updateByExample(settlementAccountConfDO, exam);
	}

    /**
	 * 根据accountNo更新settlement_account_conf表数据
	 */
	public void updateSettlementAccountConfByAccountNo(String accountNo,SettlementAccountConfDO settlementAccountConfDO) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		settlementAccountConfDAO.updateByExample(settlementAccountConfDO, exam);
	}

    /**
	 * 根据cardNo更新settlement_account_conf表数据
	 */
	public void updateSettlementAccountConfByCardNo(String cardNo,SettlementAccountConfDO settlementAccountConfDO) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		settlementAccountConfDAO.updateByExample(settlementAccountConfDO, exam);
	}

	/**
	* 根据settlementName更新settlement_account_conf表数据
	*/
	public void updateSettlementAccountConfBySettlementName(String settlementName,SettlementAccountConfDO settlementAccountConfDO) {
		SettlementAccountConfDOExample exam = new SettlementAccountConfDOExample();
		exam.createCriteria().andSettlementNameEqualTo(settlementName);
		settlementAccountConfDAO.updateByExample(settlementAccountConfDO, exam);
	}

	/**
	 * 断言settlement_dsgj_task_log表数据
	 */
	public void assertSettlementDsgjTaskLog(SettlementDsgjTaskLogDO expect, SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			settlementDsgjTaskLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != settlementDsgjTaskLogDO.getRawAddTime());
		expect.setRawAddTime(settlementDsgjTaskLogDO.getRawAddTime());
        Assertions.assertTrue(null != settlementDsgjTaskLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(settlementDsgjTaskLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, settlementDsgjTaskLogDO);
	}

    /**
	 * 插入settlement_dsgj_task_log表数据
	 */
	public void insertSettlementDsgjTaskLog(SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		settlementDsgjTaskLogDAO.insert(settlementDsgjTaskLogDO);
	}

    /**
	 * 插入settlement_dsgj_task_log表数据
	 */
	public void insertSettlementDsgjTaskLog(
			Long id, 
			String gid, 
			String bizNo, 
			String platPartnerId, 
			String platPartnerRealName, 
			String settlementDate, 
			String fileName, 
			String batchNo, 
			Long totalAmount, 
			Integer totalCount, 
			Long failAmount, 
			Integer failCount, 
			Long remittanceAmount, 
			Integer remittanceCount, 
			String settlementStatus, 
			Date finishTime, 
			String comment, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (finishTime == null) {
			finishTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SettlementDsgjTaskLogDO settlementDsgjTaskLogDO = new SettlementDsgjTaskLogDO();
		settlementDsgjTaskLogDO.setId(id);
		settlementDsgjTaskLogDO.setGid(gid);
		settlementDsgjTaskLogDO.setBizNo(bizNo);
		settlementDsgjTaskLogDO.setPlatPartnerId(platPartnerId);
		settlementDsgjTaskLogDO.setPlatPartnerRealName(platPartnerRealName);
		settlementDsgjTaskLogDO.setSettlementDate(settlementDate);
		settlementDsgjTaskLogDO.setFileName(fileName);
		settlementDsgjTaskLogDO.setBatchNo(batchNo);
		settlementDsgjTaskLogDO.setTotalAmount(totalAmount);
		settlementDsgjTaskLogDO.setTotalCount(totalCount);
		settlementDsgjTaskLogDO.setFailAmount(failAmount);
		settlementDsgjTaskLogDO.setFailCount(failCount);
		settlementDsgjTaskLogDO.setRemittanceAmount(remittanceAmount);
		settlementDsgjTaskLogDO.setRemittanceCount(remittanceCount);
		settlementDsgjTaskLogDO.setSettlementStatus(settlementStatus);
		settlementDsgjTaskLogDO.setFinishTime(finishTime);
		settlementDsgjTaskLogDO.setComment(comment);
		settlementDsgjTaskLogDO.setRawAddTime(rawAddTime);
		settlementDsgjTaskLogDO.setRawUpdateTime(rawUpdateTime);
		settlementDsgjTaskLogDAO.insert(settlementDsgjTaskLogDO);
	}

    /**
     * 删除settlement_dsgj_task_log表所有数据
     */
    public void cleanSettlementDsgjTaskLog() {
        SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
        exam.createCriteria();
        settlementDsgjTaskLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除settlement_dsgj_task_log表数据
	 */
	public void cleanSettlementDsgjTaskLogById(Long id) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除settlement_dsgj_task_log表数据
	 */
	public void cleanSettlementDsgjTaskLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		settlementDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除settlement_dsgj_task_log表数据
	 */
	public void cleanSettlementDsgjTaskLogByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		settlementDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除settlement_dsgj_task_log表数据
	 */
	public void cleanSettlementDsgjTaskLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		settlementDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	* 根据platPartnerRealName删除settlement_dsgj_task_log表数据
	*/
	public void cleanSettlementDsgjTaskLogByPlatPartnerRealName(String platPartnerRealName) {
        if (StringUtils.isBlank(platPartnerRealName)){
            platPartnerRealName = "test_platPartnerRealName";
        }
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		settlementDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	* 根据fileName删除settlement_dsgj_task_log表数据
	*/
	public void cleanSettlementDsgjTaskLogByFileName(String fileName) {
        if (StringUtils.isBlank(fileName)){
            fileName = "test_fileName";
        }
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		settlementDsgjTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchNo删除settlement_dsgj_task_log表数据
	 */
	public void cleanSettlementDsgjTaskLogByBatchNo(String batchNo) {
        if (StringUtils.isBlank(batchNo)){
            batchNo = "test_batchNo";
        }
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		settlementDsgjTaskLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询settlement_dsgj_task_log表数据
	 */
	public List<SettlementDsgjTaskLogDO> findSettlementDsgjTaskLogById(Long id) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return settlementDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询settlement_dsgj_task_log表数据
	 */
	public List<SettlementDsgjTaskLogDO> findSettlementDsgjTaskLogByGid(String gid) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return settlementDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询settlement_dsgj_task_log表数据
	 */
	public List<SettlementDsgjTaskLogDO> findSettlementDsgjTaskLogByBizNo(String bizNo) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return settlementDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询settlement_dsgj_task_log表数据
	 */
	public List<SettlementDsgjTaskLogDO> findSettlementDsgjTaskLogByPlatPartnerId(String platPartnerId) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return settlementDsgjTaskLogDAO.selectByExample(exam);
	}

	/**
	* 根据platPartnerRealName查询settlement_dsgj_task_log表数据
	*/
	public List<SettlementDsgjTaskLogDO> findSettlementDsgjTaskLogByPlatPartnerRealName(String platPartnerRealName) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		return settlementDsgjTaskLogDAO.selectByExample(exam);
	}

	/**
	* 根据fileName查询settlement_dsgj_task_log表数据
	*/
	public List<SettlementDsgjTaskLogDO> findSettlementDsgjTaskLogByFileName(String fileName) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		return settlementDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据batchNo查询settlement_dsgj_task_log表数据
	 */
	public List<SettlementDsgjTaskLogDO> findSettlementDsgjTaskLogByBatchNo(String batchNo) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		return settlementDsgjTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新settlement_dsgj_task_log表数据
	 */
	public void updateSettlementDsgjTaskLogById(Long id,SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementDsgjTaskLogDAO.updateByExample(settlementDsgjTaskLogDO, exam);
	}

    /**
	 * 根据gid更新settlement_dsgj_task_log表数据
	 */
	public void updateSettlementDsgjTaskLogByGid(String gid,SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		settlementDsgjTaskLogDAO.updateByExample(settlementDsgjTaskLogDO, exam);
	}

    /**
	 * 根据bizNo更新settlement_dsgj_task_log表数据
	 */
	public void updateSettlementDsgjTaskLogByBizNo(String bizNo,SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		settlementDsgjTaskLogDAO.updateByExample(settlementDsgjTaskLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新settlement_dsgj_task_log表数据
	 */
	public void updateSettlementDsgjTaskLogByPlatPartnerId(String platPartnerId,SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		settlementDsgjTaskLogDAO.updateByExample(settlementDsgjTaskLogDO, exam);
	}

	/**
	* 根据platPartnerRealName更新settlement_dsgj_task_log表数据
	*/
	public void updateSettlementDsgjTaskLogByPlatPartnerRealName(String platPartnerRealName,SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andPlatPartnerRealNameEqualTo(platPartnerRealName);
		settlementDsgjTaskLogDAO.updateByExample(settlementDsgjTaskLogDO, exam);
	}

	/**
	* 根据fileName更新settlement_dsgj_task_log表数据
	*/
	public void updateSettlementDsgjTaskLogByFileName(String fileName,SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		settlementDsgjTaskLogDAO.updateByExample(settlementDsgjTaskLogDO, exam);
	}

    /**
	 * 根据batchNo更新settlement_dsgj_task_log表数据
	 */
	public void updateSettlementDsgjTaskLogByBatchNo(String batchNo,SettlementDsgjTaskLogDO settlementDsgjTaskLogDO) {
		SettlementDsgjTaskLogDOExample exam = new SettlementDsgjTaskLogDOExample();
		exam.createCriteria().andBatchNoEqualTo(batchNo);
		settlementDsgjTaskLogDAO.updateByExample(settlementDsgjTaskLogDO, exam);
	}

	/**
	 * 断言settlement_order_log表数据
	 */
	public void assertSettlementOrderLog(SettlementOrderLogDO expect, SettlementOrderLogDO settlementOrderLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			settlementOrderLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != settlementOrderLogDO.getRawAddTime());
		expect.setRawAddTime(settlementOrderLogDO.getRawAddTime());
        Assertions.assertTrue(null != settlementOrderLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(settlementOrderLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, settlementOrderLogDO);
	}

    /**
	 * 插入settlement_order_log表数据
	 */
	public void insertSettlementOrderLog(SettlementOrderLogDO settlementOrderLogDO) {
		settlementOrderLogDAO.insert(settlementOrderLogDO);
	}

    /**
	 * 插入settlement_order_log表数据
	 */
	public void insertSettlementOrderLog(
			Long id, 
			String gid, 
			String bizNo, 
			String settlementDate, 
			String partnerId, 
			String channelId, 
			String partnerRealName, 
			String settlementStatus, 
			Date settlementTime, 
			String settlementType, 
			String settlementAccountNo, 
			String settlementCardNo, 
			String settlementName, 
			Long settlementAmount, 
			Date finishTime, 
			String comment, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (settlementTime == null) {
			settlementTime = new Date();
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
		SettlementOrderLogDO settlementOrderLogDO = new SettlementOrderLogDO();
		settlementOrderLogDO.setId(id);
		settlementOrderLogDO.setGid(gid);
		settlementOrderLogDO.setBizNo(bizNo);
		settlementOrderLogDO.setSettlementDate(settlementDate);
		settlementOrderLogDO.setPartnerId(partnerId);
		settlementOrderLogDO.setChannelId(channelId);
		settlementOrderLogDO.setPartnerRealName(partnerRealName);
		settlementOrderLogDO.setSettlementStatus(settlementStatus);
		settlementOrderLogDO.setSettlementTime(settlementTime);
		settlementOrderLogDO.setSettlementType(settlementType);
		settlementOrderLogDO.setSettlementAccountNo(settlementAccountNo);
		settlementOrderLogDO.setSettlementCardNo(settlementCardNo);
		settlementOrderLogDO.setSettlementName(settlementName);
		settlementOrderLogDO.setSettlementAmount(settlementAmount);
		settlementOrderLogDO.setFinishTime(finishTime);
		settlementOrderLogDO.setComment(comment);
		settlementOrderLogDO.setRawAddTime(rawAddTime);
		settlementOrderLogDO.setRawUpdateTime(rawUpdateTime);
		settlementOrderLogDAO.insert(settlementOrderLogDO);
	}

    /**
     * 删除settlement_order_log表所有数据
     */
    public void cleanSettlementOrderLog() {
        SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
        exam.createCriteria();
        settlementOrderLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除settlement_order_log表数据
	 */
	public void cleanSettlementOrderLogById(Long id) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除settlement_order_log表数据
	 */
	public void cleanSettlementOrderLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除settlement_order_log表数据
	 */
	public void cleanSettlementOrderLogByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除settlement_order_log表数据
	 */
	public void cleanSettlementOrderLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除settlement_order_log表数据
	 */
	public void cleanSettlementOrderLogByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除settlement_order_log表数据
	*/
	public void cleanSettlementOrderLogByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据settlementAccountNo删除settlement_order_log表数据
	 */
	public void cleanSettlementOrderLogBySettlementAccountNo(String settlementAccountNo) {
        if (StringUtils.isBlank(settlementAccountNo)){
            settlementAccountNo = "test_settlementAccountNo";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementAccountNoEqualTo(settlementAccountNo);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据settlementCardNo删除settlement_order_log表数据
	 */
	public void cleanSettlementOrderLogBySettlementCardNo(String settlementCardNo) {
        if (StringUtils.isBlank(settlementCardNo)){
            settlementCardNo = "test_settlementCardNo";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementCardNoEqualTo(settlementCardNo);
		settlementOrderLogDAO.deleteByExample(exam);
	}

	/**
	* 根据settlementName删除settlement_order_log表数据
	*/
	public void cleanSettlementOrderLogBySettlementName(String settlementName) {
        if (StringUtils.isBlank(settlementName)){
            settlementName = "test_settlementName";
        }
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementNameEqualTo(settlementName);
		settlementOrderLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询settlement_order_log表数据
	 */
	public List<SettlementOrderLogDO> findSettlementOrderLogById(Long id) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return settlementOrderLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询settlement_order_log表数据
	 */
	public List<SettlementOrderLogDO> findSettlementOrderLogByGid(String gid) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return settlementOrderLogDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询settlement_order_log表数据
	 */
	public List<SettlementOrderLogDO> findSettlementOrderLogByBizNo(String bizNo) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return settlementOrderLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询settlement_order_log表数据
	 */
	public List<SettlementOrderLogDO> findSettlementOrderLogByPartnerId(String partnerId) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return settlementOrderLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询settlement_order_log表数据
	 */
	public List<SettlementOrderLogDO> findSettlementOrderLogByChannelId(String channelId) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return settlementOrderLogDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询settlement_order_log表数据
	*/
	public List<SettlementOrderLogDO> findSettlementOrderLogByPartnerRealName(String partnerRealName) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return settlementOrderLogDAO.selectByExample(exam);
	}

    /**
	 * 根据settlementAccountNo查询settlement_order_log表数据
	 */
	public List<SettlementOrderLogDO> findSettlementOrderLogBySettlementAccountNo(String settlementAccountNo) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementAccountNoEqualTo(settlementAccountNo);
		return settlementOrderLogDAO.selectByExample(exam);
	}

    /**
	 * 根据settlementCardNo查询settlement_order_log表数据
	 */
	public List<SettlementOrderLogDO> findSettlementOrderLogBySettlementCardNo(String settlementCardNo) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementCardNoEqualTo(settlementCardNo);
		return settlementOrderLogDAO.selectByExample(exam);
	}

	/**
	* 根据settlementName查询settlement_order_log表数据
	*/
	public List<SettlementOrderLogDO> findSettlementOrderLogBySettlementName(String settlementName) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementNameEqualTo(settlementName);
		return settlementOrderLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新settlement_order_log表数据
	 */
	public void updateSettlementOrderLogById(Long id,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

    /**
	 * 根据gid更新settlement_order_log表数据
	 */
	public void updateSettlementOrderLogByGid(String gid,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

    /**
	 * 根据bizNo更新settlement_order_log表数据
	 */
	public void updateSettlementOrderLogByBizNo(String bizNo,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

    /**
	 * 根据partnerId更新settlement_order_log表数据
	 */
	public void updateSettlementOrderLogByPartnerId(String partnerId,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

    /**
	 * 根据channelId更新settlement_order_log表数据
	 */
	public void updateSettlementOrderLogByChannelId(String channelId,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

	/**
	* 根据partnerRealName更新settlement_order_log表数据
	*/
	public void updateSettlementOrderLogByPartnerRealName(String partnerRealName,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

    /**
	 * 根据settlementAccountNo更新settlement_order_log表数据
	 */
	public void updateSettlementOrderLogBySettlementAccountNo(String settlementAccountNo,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementAccountNoEqualTo(settlementAccountNo);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

    /**
	 * 根据settlementCardNo更新settlement_order_log表数据
	 */
	public void updateSettlementOrderLogBySettlementCardNo(String settlementCardNo,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementCardNoEqualTo(settlementCardNo);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

	/**
	* 根据settlementName更新settlement_order_log表数据
	*/
	public void updateSettlementOrderLogBySettlementName(String settlementName,SettlementOrderLogDO settlementOrderLogDO) {
		SettlementOrderLogDOExample exam = new SettlementOrderLogDOExample();
		exam.createCriteria().andSettlementNameEqualTo(settlementName);
		settlementOrderLogDAO.updateByExample(settlementOrderLogDO, exam);
	}

	/**
	 * 断言settlement_task_conf表数据
	 */
	public void assertSettlementTaskConf(SettlementTaskConfDO expect, SettlementTaskConfDO settlementTaskConfDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			settlementTaskConfDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != settlementTaskConfDO.getRawAddTime());
		expect.setRawAddTime(settlementTaskConfDO.getRawAddTime());
        Assertions.assertTrue(null != settlementTaskConfDO.getRawUpdateTime());
		expect.setRawUpdateTime(settlementTaskConfDO.getRawUpdateTime());
		Assertions.assertEquals(expect, settlementTaskConfDO);
	}

    /**
	 * 插入settlement_task_conf表数据
	 */
	public void insertSettlementTaskConf(SettlementTaskConfDO settlementTaskConfDO) {
		settlementTaskConfDAO.insert(settlementTaskConfDO);
	}

    /**
	 * 插入settlement_task_conf表数据
	 */
	public void insertSettlementTaskConf(
			Long id, 
			String partnerId, 
			String partnerRealName, 
			Integer settlementCycle, 
			String isClear, 
			String clearTime, 
			String isSettlement, 
			String settlementTime, 
			String settlementType, 
			String channelId, 
			String isUse, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SettlementTaskConfDO settlementTaskConfDO = new SettlementTaskConfDO();
		settlementTaskConfDO.setId(id);
		settlementTaskConfDO.setPartnerId(partnerId);
		settlementTaskConfDO.setPartnerRealName(partnerRealName);
		settlementTaskConfDO.setSettlementCycle(settlementCycle);
		settlementTaskConfDO.setIsClear(isClear);
		settlementTaskConfDO.setClearTime(clearTime);
		settlementTaskConfDO.setIsSettlement(isSettlement);
		settlementTaskConfDO.setSettlementTime(settlementTime);
		settlementTaskConfDO.setSettlementType(settlementType);
		settlementTaskConfDO.setChannelId(channelId);
		settlementTaskConfDO.setIsUse(isUse);
		settlementTaskConfDO.setMemo(memo);
		settlementTaskConfDO.setRawAddTime(rawAddTime);
		settlementTaskConfDO.setRawUpdateTime(rawUpdateTime);
		settlementTaskConfDAO.insert(settlementTaskConfDO);
	}

    /**
     * 删除settlement_task_conf表所有数据
     */
    public void cleanSettlementTaskConf() {
        SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
        exam.createCriteria();
        settlementTaskConfDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除settlement_task_conf表数据
	 */
	public void cleanSettlementTaskConfById(Long id) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementTaskConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除settlement_task_conf表数据
	 */
	public void cleanSettlementTaskConfByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementTaskConfDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除settlement_task_conf表数据
	*/
	public void cleanSettlementTaskConfByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		settlementTaskConfDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除settlement_task_conf表数据
	 */
	public void cleanSettlementTaskConfByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementTaskConfDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询settlement_task_conf表数据
	 */
	public List<SettlementTaskConfDO> findSettlementTaskConfById(Long id) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return settlementTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询settlement_task_conf表数据
	 */
	public List<SettlementTaskConfDO> findSettlementTaskConfByPartnerId(String partnerId) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return settlementTaskConfDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询settlement_task_conf表数据
	*/
	public List<SettlementTaskConfDO> findSettlementTaskConfByPartnerRealName(String partnerRealName) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return settlementTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询settlement_task_conf表数据
	 */
	public List<SettlementTaskConfDO> findSettlementTaskConfByChannelId(String channelId) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return settlementTaskConfDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新settlement_task_conf表数据
	 */
	public void updateSettlementTaskConfById(Long id,SettlementTaskConfDO settlementTaskConfDO) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementTaskConfDAO.updateByExample(settlementTaskConfDO, exam);
	}

    /**
	 * 根据partnerId更新settlement_task_conf表数据
	 */
	public void updateSettlementTaskConfByPartnerId(String partnerId,SettlementTaskConfDO settlementTaskConfDO) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementTaskConfDAO.updateByExample(settlementTaskConfDO, exam);
	}

	/**
	* 根据partnerRealName更新settlement_task_conf表数据
	*/
	public void updateSettlementTaskConfByPartnerRealName(String partnerRealName,SettlementTaskConfDO settlementTaskConfDO) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		settlementTaskConfDAO.updateByExample(settlementTaskConfDO, exam);
	}

    /**
	 * 根据channelId更新settlement_task_conf表数据
	 */
	public void updateSettlementTaskConfByChannelId(String channelId,SettlementTaskConfDO settlementTaskConfDO) {
		SettlementTaskConfDOExample exam = new SettlementTaskConfDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementTaskConfDAO.updateByExample(settlementTaskConfDO, exam);
	}

	/**
	 * 断言settlement_task_log表数据
	 */
	public void assertSettlementTaskLog(SettlementTaskLogDO expect, SettlementTaskLogDO settlementTaskLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			settlementTaskLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != settlementTaskLogDO.getRawAddTime());
		expect.setRawAddTime(settlementTaskLogDO.getRawAddTime());
        Assertions.assertTrue(null != settlementTaskLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(settlementTaskLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, settlementTaskLogDO);
	}

    /**
	 * 插入settlement_task_log表数据
	 */
	public void insertSettlementTaskLog(SettlementTaskLogDO settlementTaskLogDO) {
		settlementTaskLogDAO.insert(settlementTaskLogDO);
	}

    /**
	 * 插入settlement_task_log表数据
	 */
	public void insertSettlementTaskLog(
			Long id, 
			String settlementDate, 
			String partnerId, 
			String channelId, 
			String partnerRealName, 
			String clearStatus, 
			Date clearTime, 
			String clearComment, 
			String settlementStatus, 
			Date settlementTime, 
			String settlementComment, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (clearTime == null) {
			clearTime = new Date();
		}
		if (settlementTime == null) {
			settlementTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SettlementTaskLogDO settlementTaskLogDO = new SettlementTaskLogDO();
		settlementTaskLogDO.setId(id);
		settlementTaskLogDO.setSettlementDate(settlementDate);
		settlementTaskLogDO.setPartnerId(partnerId);
		settlementTaskLogDO.setChannelId(channelId);
		settlementTaskLogDO.setPartnerRealName(partnerRealName);
		settlementTaskLogDO.setClearStatus(clearStatus);
		settlementTaskLogDO.setClearTime(clearTime);
		settlementTaskLogDO.setClearComment(clearComment);
		settlementTaskLogDO.setSettlementStatus(settlementStatus);
		settlementTaskLogDO.setSettlementTime(settlementTime);
		settlementTaskLogDO.setSettlementComment(settlementComment);
		settlementTaskLogDO.setRawAddTime(rawAddTime);
		settlementTaskLogDO.setRawUpdateTime(rawUpdateTime);
		settlementTaskLogDAO.insert(settlementTaskLogDO);
	}

    /**
     * 删除settlement_task_log表所有数据
     */
    public void cleanSettlementTaskLog() {
        SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
        exam.createCriteria();
        settlementTaskLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除settlement_task_log表数据
	 */
	public void cleanSettlementTaskLogById(Long id) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除settlement_task_log表数据
	 */
	public void cleanSettlementTaskLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementTaskLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除settlement_task_log表数据
	 */
	public void cleanSettlementTaskLogByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementTaskLogDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerRealName删除settlement_task_log表数据
	*/
	public void cleanSettlementTaskLogByPartnerRealName(String partnerRealName) {
        if (StringUtils.isBlank(partnerRealName)){
            partnerRealName = "test_partnerRealName";
        }
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		settlementTaskLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询settlement_task_log表数据
	 */
	public List<SettlementTaskLogDO> findSettlementTaskLogById(Long id) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return settlementTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询settlement_task_log表数据
	 */
	public List<SettlementTaskLogDO> findSettlementTaskLogByPartnerId(String partnerId) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return settlementTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询settlement_task_log表数据
	 */
	public List<SettlementTaskLogDO> findSettlementTaskLogByChannelId(String channelId) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return settlementTaskLogDAO.selectByExample(exam);
	}

	/**
	* 根据partnerRealName查询settlement_task_log表数据
	*/
	public List<SettlementTaskLogDO> findSettlementTaskLogByPartnerRealName(String partnerRealName) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		return settlementTaskLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新settlement_task_log表数据
	 */
	public void updateSettlementTaskLogById(Long id,SettlementTaskLogDO settlementTaskLogDO) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settlementTaskLogDAO.updateByExample(settlementTaskLogDO, exam);
	}

    /**
	 * 根据partnerId更新settlement_task_log表数据
	 */
	public void updateSettlementTaskLogByPartnerId(String partnerId,SettlementTaskLogDO settlementTaskLogDO) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settlementTaskLogDAO.updateByExample(settlementTaskLogDO, exam);
	}

    /**
	 * 根据channelId更新settlement_task_log表数据
	 */
	public void updateSettlementTaskLogByChannelId(String channelId,SettlementTaskLogDO settlementTaskLogDO) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settlementTaskLogDAO.updateByExample(settlementTaskLogDO, exam);
	}

	/**
	* 根据partnerRealName更新settlement_task_log表数据
	*/
	public void updateSettlementTaskLogByPartnerRealName(String partnerRealName,SettlementTaskLogDO settlementTaskLogDO) {
		SettlementTaskLogDOExample exam = new SettlementTaskLogDOExample();
		exam.createCriteria().andPartnerRealNameEqualTo(partnerRealName);
		settlementTaskLogDAO.updateByExample(settlementTaskLogDO, exam);
	}
}
