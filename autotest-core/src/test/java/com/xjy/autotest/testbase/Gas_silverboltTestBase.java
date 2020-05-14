package com.xjy.autotest.testbase;

import java.util.List;
import java.util.Date;
import com.xjy.autotest.base.AutoTestBase;
import com.xjy.autotest.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Import;
import com.xyb.adk.common.util.money.Money;
import java.math.BigDecimal;
import dal.dao.gas_silverbolt.*;
import dal.model.gas_silverbolt.*;
import com.xjy.autotest.config.Gas_silverboltDataSourceConfig;

/**
 * @author autotest
 * Created on 2020/04/13.
 */
@Service
@Import({
        Gas_silverboltDataSourceConfig.class
})
public class Gas_silverboltTestBase extends AutoTestBase{

	@Autowired
	DataCleanLogDAO dataCleanLogDAO;

	@Autowired
	DataCleanTaskDAO dataCleanTaskDAO;

	@Autowired
	DateListDAO dateListDAO;

	@Autowired
	DetailHeadDAO detailHeadDAO;

	@Autowired
	DetailModelDAO detailModelDAO;

	@Autowired
	DetailModelProgramDAO detailModelProgramDAO;

	@Autowired
	DistinctDetailDAO distinctDetailDAO;

	@Autowired
	DistributedLockDAO distributedLockDAO;

	@Autowired
	FileDownloadDAO fileDownloadDAO;

	@Autowired
	GasAccountChangeDAO gasAccountChangeDAO;

	@Autowired
	GasCampaignDefinitionDAO gasCampaignDefinitionDAO;

	@Autowired
	GasCouponDefinitionDAO gasCouponDefinitionDAO;

	@Autowired
	GasGoodsDAO gasGoodsDAO;

	@Autowired
	GasGradeUserDAO gasGradeUserDAO;

	@Autowired
	GasMarketCampaignDetailDAO gasMarketCampaignDetailDAO;

	@Autowired
	GasMarketGiveDAO gasMarketGiveDAO;

	@Autowired
	GasMarketPreciseDetailDAO gasMarketPreciseDetailDAO;

	@Autowired
	GasMerchantDAO gasMerchantDAO;

	@Autowired
	GasMerchantGoodsDAO gasMerchantGoodsDAO;

	@Autowired
	GasMerchantPayWayDAO gasMerchantPayWayDAO;

	@Autowired
	GasMerchantStationDAO gasMerchantStationDAO;

	@Autowired
	GasMerchantUserDAO gasMerchantUserDAO;

	@Autowired
	GasMerchantUserStationDAO gasMerchantUserStationDAO;

	@Autowired
	GasPaywayDictDAO gasPaywayDictDAO;

	@Autowired
	GasPointsChangeDAO gasPointsChangeDAO;

	@Autowired
	GasTerminalLoginDAO gasTerminalLoginDAO;

	@Autowired
	GasTradeFavourDAO gasTradeFavourDAO;

	@Autowired
	GasTradeGoodsDAO gasTradeGoodsDAO;

	@Autowired
	GasTradeOilDAO gasTradeOilDAO;

	@Autowired
	GasTradeOrderDAO gasTradeOrderDAO;

	@Autowired
	GasTradePointsRedeemDAO gasTradePointsRedeemDAO;

	@Autowired
	GasUserDAO gasUserDAO;

	@Autowired
	GasUserGroupDAO gasUserGroupDAO;

	@Autowired
	GroupScriptDAO groupScriptDAO;

	@Autowired
	MerchantReportDAO merchantReportDAO;

	@Autowired
	NotifyTaskDAO notifyTaskDAO;

	@Autowired
	PersonaTaskDAO personaTaskDAO;

	@Autowired
	PersonasConditionDAO personasConditionDAO;

	@Autowired
	ReportConfigDAO reportConfigDAO;

	@Autowired
	ReportExportTaskDAO reportExportTaskDAO;

	@Autowired
	StatisticsColumnDAO statisticsColumnDAO;

	@Autowired
	StatisticsDataDAO statisticsDataDAO;

	@Autowired
	StatisticsGroupColumnDAO statisticsGroupColumnDAO;

	@Autowired
	StatisticsGroupPoolsDAO statisticsGroupPoolsDAO;

	@Autowired
	StatisticsGroupProgramDAO statisticsGroupProgramDAO;

	@Autowired
	StatisticsModelDAO statisticsModelDAO;

	@Autowired
	StatisticsReportDAO statisticsReportDAO;

	@Autowired
	StatisticsSpoutDAO statisticsSpoutDAO;

	@Autowired
	StatisticsTaskDAO statisticsTaskDAO;

	@Autowired
	TempUserCarDAO tempUserCarDAO;

	@Autowired
	UserDimensionDAO userDimensionDAO;

	@Autowired
	UserInviteLogDAO userInviteLogDAO;

	@Autowired
	UserPersonaDAO userPersonaDAO;

	@Autowired
	UserPersonaNotifyTaskDAO userPersonaNotifyTaskDAO;

	@Autowired
	UserSpreadLogDAO userSpreadLogDAO;

	@Autowired
	WashCouponDAO washCouponDAO;

	@Autowired
	WashLuckDrawCampaignDAO washLuckDrawCampaignDAO;

	@Autowired
	WashPreciseGiveDAO washPreciseGiveDAO;

	@Autowired
	WashRecommendGasUserDAO washRecommendGasUserDAO;

	@Autowired
	WashSalesCampaignDAO washSalesCampaignDAO;

	@Autowired
	WashScanTakeCampaignDAO washScanTakeCampaignDAO;

	public DataCleanLogDAO getDataCleanLogDAO() {
		return this.dataCleanLogDAO;
	}

	public DataCleanTaskDAO getDataCleanTaskDAO() {
		return this.dataCleanTaskDAO;
	}

	public DateListDAO getDateListDAO() {
		return this.dateListDAO;
	}

	public DetailHeadDAO getDetailHeadDAO() {
		return this.detailHeadDAO;
	}

	public DetailModelDAO getDetailModelDAO() {
		return this.detailModelDAO;
	}

	public DetailModelProgramDAO getDetailModelProgramDAO() {
		return this.detailModelProgramDAO;
	}

	public DistinctDetailDAO getDistinctDetailDAO() {
		return this.distinctDetailDAO;
	}

	public DistributedLockDAO getDistributedLockDAO() {
		return this.distributedLockDAO;
	}

	public FileDownloadDAO getFileDownloadDAO() {
		return this.fileDownloadDAO;
	}

	public GasAccountChangeDAO getGasAccountChangeDAO() {
		return this.gasAccountChangeDAO;
	}

	public GasCampaignDefinitionDAO getGasCampaignDefinitionDAO() {
		return this.gasCampaignDefinitionDAO;
	}

	public GasCouponDefinitionDAO getGasCouponDefinitionDAO() {
		return this.gasCouponDefinitionDAO;
	}

	public GasGoodsDAO getGasGoodsDAO() {
		return this.gasGoodsDAO;
	}

	public GasGradeUserDAO getGasGradeUserDAO() {
		return this.gasGradeUserDAO;
	}

	public GasMarketCampaignDetailDAO getGasMarketCampaignDetailDAO() {
		return this.gasMarketCampaignDetailDAO;
	}

	public GasMarketGiveDAO getGasMarketGiveDAO() {
		return this.gasMarketGiveDAO;
	}

	public GasMarketPreciseDetailDAO getGasMarketPreciseDetailDAO() {
		return this.gasMarketPreciseDetailDAO;
	}

	public GasMerchantDAO getGasMerchantDAO() {
		return this.gasMerchantDAO;
	}

	public GasMerchantGoodsDAO getGasMerchantGoodsDAO() {
		return this.gasMerchantGoodsDAO;
	}

	public GasMerchantPayWayDAO getGasMerchantPayWayDAO() {
		return this.gasMerchantPayWayDAO;
	}

	public GasMerchantStationDAO getGasMerchantStationDAO() {
		return this.gasMerchantStationDAO;
	}

	public GasMerchantUserDAO getGasMerchantUserDAO() {
		return this.gasMerchantUserDAO;
	}

	public GasMerchantUserStationDAO getGasMerchantUserStationDAO() {
		return this.gasMerchantUserStationDAO;
	}

	public GasPaywayDictDAO getGasPaywayDictDAO() {
		return this.gasPaywayDictDAO;
	}

	public GasPointsChangeDAO getGasPointsChangeDAO() {
		return this.gasPointsChangeDAO;
	}

	public GasTerminalLoginDAO getGasTerminalLoginDAO() {
		return this.gasTerminalLoginDAO;
	}

	public GasTradeFavourDAO getGasTradeFavourDAO() {
		return this.gasTradeFavourDAO;
	}

	public GasTradeGoodsDAO getGasTradeGoodsDAO() {
		return this.gasTradeGoodsDAO;
	}

	public GasTradeOilDAO getGasTradeOilDAO() {
		return this.gasTradeOilDAO;
	}

	public GasTradeOrderDAO getGasTradeOrderDAO() {
		return this.gasTradeOrderDAO;
	}

	public GasTradePointsRedeemDAO getGasTradePointsRedeemDAO() {
		return this.gasTradePointsRedeemDAO;
	}

	public GasUserDAO getGasUserDAO() {
		return this.gasUserDAO;
	}

	public GasUserGroupDAO getGasUserGroupDAO() {
		return this.gasUserGroupDAO;
	}

	public GroupScriptDAO getGroupScriptDAO() {
		return this.groupScriptDAO;
	}

	public MerchantReportDAO getMerchantReportDAO() {
		return this.merchantReportDAO;
	}

	public NotifyTaskDAO getNotifyTaskDAO() {
		return this.notifyTaskDAO;
	}

	public PersonaTaskDAO getPersonaTaskDAO() {
		return this.personaTaskDAO;
	}

	public PersonasConditionDAO getPersonasConditionDAO() {
		return this.personasConditionDAO;
	}

	public ReportConfigDAO getReportConfigDAO() {
		return this.reportConfigDAO;
	}

	public ReportExportTaskDAO getReportExportTaskDAO() {
		return this.reportExportTaskDAO;
	}

	public StatisticsColumnDAO getStatisticsColumnDAO() {
		return this.statisticsColumnDAO;
	}

	public StatisticsDataDAO getStatisticsDataDAO() {
		return this.statisticsDataDAO;
	}

	public StatisticsGroupColumnDAO getStatisticsGroupColumnDAO() {
		return this.statisticsGroupColumnDAO;
	}

	public StatisticsGroupPoolsDAO getStatisticsGroupPoolsDAO() {
		return this.statisticsGroupPoolsDAO;
	}

	public StatisticsGroupProgramDAO getStatisticsGroupProgramDAO() {
		return this.statisticsGroupProgramDAO;
	}

	public StatisticsModelDAO getStatisticsModelDAO() {
		return this.statisticsModelDAO;
	}

	public StatisticsReportDAO getStatisticsReportDAO() {
		return this.statisticsReportDAO;
	}

	public StatisticsSpoutDAO getStatisticsSpoutDAO() {
		return this.statisticsSpoutDAO;
	}

	public StatisticsTaskDAO getStatisticsTaskDAO() {
		return this.statisticsTaskDAO;
	}

	public TempUserCarDAO getTempUserCarDAO() {
		return this.tempUserCarDAO;
	}

	public UserDimensionDAO getUserDimensionDAO() {
		return this.userDimensionDAO;
	}

	public UserInviteLogDAO getUserInviteLogDAO() {
		return this.userInviteLogDAO;
	}

	public UserPersonaDAO getUserPersonaDAO() {
		return this.userPersonaDAO;
	}

	public UserPersonaNotifyTaskDAO getUserPersonaNotifyTaskDAO() {
		return this.userPersonaNotifyTaskDAO;
	}

	public UserSpreadLogDAO getUserSpreadLogDAO() {
		return this.userSpreadLogDAO;
	}

	public WashCouponDAO getWashCouponDAO() {
		return this.washCouponDAO;
	}

	public WashLuckDrawCampaignDAO getWashLuckDrawCampaignDAO() {
		return this.washLuckDrawCampaignDAO;
	}

	public WashPreciseGiveDAO getWashPreciseGiveDAO() {
		return this.washPreciseGiveDAO;
	}

	public WashRecommendGasUserDAO getWashRecommendGasUserDAO() {
		return this.washRecommendGasUserDAO;
	}

	public WashSalesCampaignDAO getWashSalesCampaignDAO() {
		return this.washSalesCampaignDAO;
	}

	public WashScanTakeCampaignDAO getWashScanTakeCampaignDAO() {
		return this.washScanTakeCampaignDAO;
	}


    /**
	 * 断言data_clean_log表
	 */
	public void dataCleanLogAssert(
	        DataCleanLogDO dataCleanLogDO,
			Long id, 
			String tName, 
			String cleanTime, 
			Integer cleanTatol, 
			String errMsg, 
			Date rawAddTime
	) {
        assertEquals(id, dataCleanLogDO.getId());
        assertEquals(tName, dataCleanLogDO.gettName());
        assertEquals(cleanTime, dataCleanLogDO.getCleanTime());
        assertEquals(cleanTatol, dataCleanLogDO.getCleanTatol());
        assertEquals(errMsg, dataCleanLogDO.getErrMsg());
        assertEquals(rawAddTime, dataCleanLogDO.getRawAddTime());
	}

	/**
	 * 断言data_clean_log表数据
	 */
	public void assertDataCleanLog(DataCleanLogDO expect, DataCleanLogDO dataCleanLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			dataCleanLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != dataCleanLogDO.getRawAddTime());
		expect.setRawAddTime(dataCleanLogDO.getRawAddTime());
		Assertions.assertEquals(expect, dataCleanLogDO);
	}

    /**
	 * 插入data_clean_log表数据
	 */
	public void insertDataCleanLog(DataCleanLogDO dataCleanLogDO) {
		dataCleanLogDAO.insert(dataCleanLogDO);
	}

    /**
	 * 插入data_clean_log表数据
	 */
	public void insertDataCleanLog(
			Long id, 
			String tName, 
			String cleanTime, 
			Integer cleanTatol, 
			String errMsg, 
			Date rawAddTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		DataCleanLogDO dataCleanLogDO = new DataCleanLogDO();
		dataCleanLogDO.setId(id);
		dataCleanLogDO.settName(tName);
		dataCleanLogDO.setCleanTime(cleanTime);
		dataCleanLogDO.setCleanTatol(cleanTatol);
		dataCleanLogDO.setErrMsg(errMsg);
		dataCleanLogDO.setRawAddTime(rawAddTime);
		dataCleanLogDAO.insert(dataCleanLogDO);
	}

    /**
     * 删除data_clean_log表所有数据
     */
    public void cleanDataCleanLog() {
        DataCleanLogDOExample exam = new DataCleanLogDOExample();
        exam.createCriteria();
        dataCleanLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除data_clean_log表数据
	 */
	public void cleanDataCleanLogById(Long id) {
		DataCleanLogDOExample exam = new DataCleanLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dataCleanLogDAO.deleteByExample(exam);
	}

	/**
	* 根据tName删除data_clean_log表数据
	*/
	public void cleanDataCleanLogByTName(String tName) {
        if (StringUtils.isBlank(tName)){
            tName = "test_tName";
        }
		DataCleanLogDOExample exam = new DataCleanLogDOExample();
		exam.createCriteria().andTNameEqualTo(tName);
		dataCleanLogDAO.deleteByExample(exam);
	}

    /**
     * 查询data_clean_log表所有数据
     */
    public List<DataCleanLogDO> findDataCleanLogAll() {
        DataCleanLogDOExample exam = new DataCleanLogDOExample();
        exam.createCriteria();
		return dataCleanLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询data_clean_log表数据
	 */
	public List<DataCleanLogDO> findDataCleanLogById(Long id) {
		DataCleanLogDOExample exam = new DataCleanLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return dataCleanLogDAO.selectByExample(exam);
	}

	/**
	* 根据tName查询data_clean_log表数据
	*/
	public List<DataCleanLogDO> findDataCleanLogByTName(String tName) {
		DataCleanLogDOExample exam = new DataCleanLogDOExample();
		exam.createCriteria().andTNameEqualTo(tName);
		return dataCleanLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新data_clean_log表数据
	 */
	public void updateDataCleanLogById(Long id,DataCleanLogDO dataCleanLogDO) {
		DataCleanLogDOExample exam = new DataCleanLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dataCleanLogDAO.updateByExample(dataCleanLogDO, exam);
	}

	/**
	* 根据tName更新data_clean_log表数据
	*/
	public void updateDataCleanLogByTName(String tName,DataCleanLogDO dataCleanLogDO) {
		DataCleanLogDOExample exam = new DataCleanLogDOExample();
		exam.createCriteria().andTNameEqualTo(tName);
		dataCleanLogDAO.updateByExample(dataCleanLogDO, exam);
	}

    /**
	 * 断言data_clean_task表
	 */
	public void dataCleanTaskAssert(
	        DataCleanTaskDO dataCleanTaskDO,
			Long id, 
			String taskName, 
			String tName, 
			String timeSlice, 
			Integer intervalDay, 
			Integer intervalDelay, 
			Date endTime, 
			Date lastTime, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, dataCleanTaskDO.getId());
        assertEquals(taskName, dataCleanTaskDO.getTaskName());
        assertEquals(tName, dataCleanTaskDO.gettName());
        assertEquals(timeSlice, dataCleanTaskDO.getTimeSlice());
        assertEquals(intervalDay, dataCleanTaskDO.getIntervalDay());
        assertEquals(intervalDelay, dataCleanTaskDO.getIntervalDelay());
        assertEquals(endTime, dataCleanTaskDO.getEndTime());
        assertEquals(lastTime, dataCleanTaskDO.getLastTime());
        assertEquals(status, dataCleanTaskDO.getStatus());
        assertEquals(rawAddTime, dataCleanTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, dataCleanTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言data_clean_task表数据
	 */
	public void assertDataCleanTask(DataCleanTaskDO expect, DataCleanTaskDO dataCleanTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			dataCleanTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != dataCleanTaskDO.getRawAddTime());
		expect.setRawAddTime(dataCleanTaskDO.getRawAddTime());
        Assertions.assertTrue(null != dataCleanTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(dataCleanTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, dataCleanTaskDO);
	}

    /**
	 * 插入data_clean_task表数据
	 */
	public void insertDataCleanTask(DataCleanTaskDO dataCleanTaskDO) {
		dataCleanTaskDAO.insert(dataCleanTaskDO);
	}

    /**
	 * 插入data_clean_task表数据
	 */
	public void insertDataCleanTask(
			Long id, 
			String taskName, 
			String tName, 
			String timeSlice, 
			Integer intervalDay, 
			Integer intervalDelay, 
			Date endTime, 
			Date lastTime, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		DataCleanTaskDO dataCleanTaskDO = new DataCleanTaskDO();
		dataCleanTaskDO.setId(id);
		dataCleanTaskDO.setTaskName(taskName);
		dataCleanTaskDO.settName(tName);
		dataCleanTaskDO.setTimeSlice(timeSlice);
		dataCleanTaskDO.setIntervalDay(intervalDay);
		dataCleanTaskDO.setIntervalDelay(intervalDelay);
		dataCleanTaskDO.setEndTime(endTime);
		dataCleanTaskDO.setLastTime(lastTime);
		dataCleanTaskDO.setStatus(status);
		dataCleanTaskDO.setRawAddTime(rawAddTime);
		dataCleanTaskDO.setRawUpdateTime(rawUpdateTime);
		dataCleanTaskDAO.insert(dataCleanTaskDO);
	}

    /**
     * 删除data_clean_task表所有数据
     */
    public void cleanDataCleanTask() {
        DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
        exam.createCriteria();
        dataCleanTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除data_clean_task表数据
	 */
	public void cleanDataCleanTaskById(Long id) {
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dataCleanTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据taskName删除data_clean_task表数据
	*/
	public void cleanDataCleanTaskByTaskName(String taskName) {
        if (StringUtils.isBlank(taskName)){
            taskName = "test_taskName";
        }
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andTaskNameEqualTo(taskName);
		dataCleanTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据tName删除data_clean_task表数据
	*/
	public void cleanDataCleanTaskByTName(String tName) {
        if (StringUtils.isBlank(tName)){
            tName = "test_tName";
        }
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andTNameEqualTo(tName);
		dataCleanTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询data_clean_task表所有数据
     */
    public List<DataCleanTaskDO> findDataCleanTaskAll() {
        DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
        exam.createCriteria();
		return dataCleanTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询data_clean_task表数据
	 */
	public List<DataCleanTaskDO> findDataCleanTaskById(Long id) {
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return dataCleanTaskDAO.selectByExample(exam);
	}

	/**
	* 根据taskName查询data_clean_task表数据
	*/
	public List<DataCleanTaskDO> findDataCleanTaskByTaskName(String taskName) {
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andTaskNameEqualTo(taskName);
		return dataCleanTaskDAO.selectByExample(exam);
	}

	/**
	* 根据tName查询data_clean_task表数据
	*/
	public List<DataCleanTaskDO> findDataCleanTaskByTName(String tName) {
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andTNameEqualTo(tName);
		return dataCleanTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新data_clean_task表数据
	 */
	public void updateDataCleanTaskById(Long id,DataCleanTaskDO dataCleanTaskDO) {
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dataCleanTaskDAO.updateByExample(dataCleanTaskDO, exam);
	}

	/**
	* 根据taskName更新data_clean_task表数据
	*/
	public void updateDataCleanTaskByTaskName(String taskName,DataCleanTaskDO dataCleanTaskDO) {
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andTaskNameEqualTo(taskName);
		dataCleanTaskDAO.updateByExample(dataCleanTaskDO, exam);
	}

	/**
	* 根据tName更新data_clean_task表数据
	*/
	public void updateDataCleanTaskByTName(String tName,DataCleanTaskDO dataCleanTaskDO) {
		DataCleanTaskDOExample exam = new DataCleanTaskDOExample();
		exam.createCriteria().andTNameEqualTo(tName);
		dataCleanTaskDAO.updateByExample(dataCleanTaskDO, exam);
	}

    /**
	 * 断言date_list表
	 */
	public void dateListAssert(
	        DateListDO dateListDO,
			Integer id, 
			Date dates, 
			Integer year, 
			Integer month, 
			Integer days, 
			Integer week
	) {
        assertEquals(id, dateListDO.getId());
        assertEquals(dates, dateListDO.getDates());
        assertEquals(year, dateListDO.getYear());
        assertEquals(month, dateListDO.getMonth());
        assertEquals(days, dateListDO.getDays());
        assertEquals(week, dateListDO.getWeek());
	}

	/**
	 * 断言date_list表数据
	 */
	public void assertDateList(DateListDO expect, DateListDO dateListDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			dateListDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, dateListDO);
	}

    /**
	 * 插入date_list表数据
	 */
	public void insertDateList(DateListDO dateListDO) {
		dateListDAO.insert(dateListDO);
	}

    /**
	 * 插入date_list表数据
	 */
	public void insertDateList(
			Integer id, 
			Date dates, 
			Integer year, 
			Integer month, 
			Integer days, 
			Integer week
	) {
		DateListDO dateListDO = new DateListDO();
		dateListDO.setId(id);
		dateListDO.setDates(dates);
		dateListDO.setYear(year);
		dateListDO.setMonth(month);
		dateListDO.setDays(days);
		dateListDO.setWeek(week);
		dateListDAO.insert(dateListDO);
	}

    /**
     * 删除date_list表所有数据
     */
    public void cleanDateList() {
        DateListDOExample exam = new DateListDOExample();
        exam.createCriteria();
        dateListDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除date_list表数据
	 */
	public void cleanDateListById(Integer id) {
		DateListDOExample exam = new DateListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dateListDAO.deleteByExample(exam);
	}

    /**
     * 查询date_list表所有数据
     */
    public List<DateListDO> findDateListAll() {
        DateListDOExample exam = new DateListDOExample();
        exam.createCriteria();
		return dateListDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询date_list表数据
	 */
	public List<DateListDO> findDateListById(Integer id) {
		DateListDOExample exam = new DateListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return dateListDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新date_list表数据
	 */
	public void updateDateListById(Integer id,DateListDO dateListDO) {
		DateListDOExample exam = new DateListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dateListDAO.updateByExample(dateListDO, exam);
	}

    /**
	 * 断言detail_head表
	 */
	public void detailHeadAssert(
	        DetailHeadDO detailHeadDO,
			Long id, 
			String modelId, 
			String headName, 
			String headCode, 
			String headColumn, 
			String filedType, 
			String filter, 
			String filterHeadConfig, 
			String mask, 
			String sumValue, 
			String orderBy, 
			String onShow, 
			String headMemo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, detailHeadDO.getId());
        assertEquals(modelId, detailHeadDO.getModelId());
        assertEquals(headName, detailHeadDO.getHeadName());
        assertEquals(headCode, detailHeadDO.getHeadCode());
        assertEquals(headColumn, detailHeadDO.getHeadColumn());
        assertEquals(filedType, detailHeadDO.getFiledType());
        assertEquals(filter, detailHeadDO.getFilter());
        assertEquals(filterHeadConfig, detailHeadDO.getFilterHeadConfig());
        assertEquals(mask, detailHeadDO.getMask());
        assertEquals(sumValue, detailHeadDO.getSumValue());
        assertEquals(orderBy, detailHeadDO.getOrderBy());
        assertEquals(onShow, detailHeadDO.getOnShow());
        assertEquals(headMemo, detailHeadDO.getHeadMemo());
        assertEquals(rawAddTime, detailHeadDO.getRawAddTime());
        assertEquals(rawUpdateTime, detailHeadDO.getRawUpdateTime());
	}

	/**
	 * 断言detail_head表数据
	 */
	public void assertDetailHead(DetailHeadDO expect, DetailHeadDO detailHeadDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			detailHeadDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != detailHeadDO.getRawAddTime());
		expect.setRawAddTime(detailHeadDO.getRawAddTime());
        Assertions.assertTrue(null != detailHeadDO.getRawUpdateTime());
		expect.setRawUpdateTime(detailHeadDO.getRawUpdateTime());
		Assertions.assertEquals(expect, detailHeadDO);
	}

    /**
	 * 插入detail_head表数据
	 */
	public void insertDetailHead(DetailHeadDO detailHeadDO) {
		detailHeadDAO.insert(detailHeadDO);
	}

    /**
	 * 插入detail_head表数据
	 */
	public void insertDetailHead(
			Long id, 
			String modelId, 
			String headName, 
			String headCode, 
			String headColumn, 
			String filedType, 
			String filter, 
			String filterHeadConfig, 
			String mask, 
			String sumValue, 
			String orderBy, 
			String onShow, 
			String headMemo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		DetailHeadDO detailHeadDO = new DetailHeadDO();
		detailHeadDO.setId(id);
		detailHeadDO.setModelId(modelId);
		detailHeadDO.setHeadName(headName);
		detailHeadDO.setHeadCode(headCode);
		detailHeadDO.setHeadColumn(headColumn);
		detailHeadDO.setFiledType(filedType);
		detailHeadDO.setFilter(filter);
		detailHeadDO.setFilterHeadConfig(filterHeadConfig);
		detailHeadDO.setMask(mask);
		detailHeadDO.setSumValue(sumValue);
		detailHeadDO.setOrderBy(orderBy);
		detailHeadDO.setOnShow(onShow);
		detailHeadDO.setHeadMemo(headMemo);
		detailHeadDO.setRawAddTime(rawAddTime);
		detailHeadDO.setRawUpdateTime(rawUpdateTime);
		detailHeadDAO.insert(detailHeadDO);
	}

    /**
     * 删除detail_head表所有数据
     */
    public void cleanDetailHead() {
        DetailHeadDOExample exam = new DetailHeadDOExample();
        exam.createCriteria();
        detailHeadDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除detail_head表数据
	 */
	public void cleanDetailHeadById(Long id) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andIdEqualTo(id);
		detailHeadDAO.deleteByExample(exam);
	}

	/**
	 * 根据modelId删除detail_head表数据
	 */
	public void cleanDetailHeadByModelId(String modelId) {
        if (StringUtils.isBlank(modelId)){
            modelId = "test_modelId";
        }
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andModelIdEqualTo(modelId);
		detailHeadDAO.deleteByExample(exam);
	}

	/**
	* 根据headName删除detail_head表数据
	*/
	public void cleanDetailHeadByHeadName(String headName) {
        if (StringUtils.isBlank(headName)){
            headName = "test_headName";
        }
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andHeadNameEqualTo(headName);
		detailHeadDAO.deleteByExample(exam);
	}

	/**
	* 根据headCode删除detail_head表数据
	*/
	public void cleanDetailHeadByHeadCode(String headCode) {
        if (StringUtils.isBlank(headCode)){
            headCode = "test_headCode";
        }
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andHeadCodeEqualTo(headCode);
		detailHeadDAO.deleteByExample(exam);
	}

    /**
     * 查询detail_head表所有数据
     */
    public List<DetailHeadDO> findDetailHeadAll() {
        DetailHeadDOExample exam = new DetailHeadDOExample();
        exam.createCriteria();
		return detailHeadDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询detail_head表数据
	 */
	public List<DetailHeadDO> findDetailHeadById(Long id) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return detailHeadDAO.selectByExample(exam);
	}

    /**
	 * 根据modelId查询detail_head表数据
	 */
	public List<DetailHeadDO> findDetailHeadByModelId(String modelId) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andModelIdEqualTo(modelId);
		return detailHeadDAO.selectByExample(exam);
	}

	/**
	* 根据headName查询detail_head表数据
	*/
	public List<DetailHeadDO> findDetailHeadByHeadName(String headName) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andHeadNameEqualTo(headName);
		return detailHeadDAO.selectByExample(exam);
	}

	/**
	* 根据headCode查询detail_head表数据
	*/
	public List<DetailHeadDO> findDetailHeadByHeadCode(String headCode) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andHeadCodeEqualTo(headCode);
		return detailHeadDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新detail_head表数据
	 */
	public void updateDetailHeadById(Long id,DetailHeadDO detailHeadDO) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andIdEqualTo(id);
		detailHeadDAO.updateByExample(detailHeadDO, exam);
	}

    /**
	 * 根据modelId更新detail_head表数据
	 */
	public void updateDetailHeadByModelId(String modelId,DetailHeadDO detailHeadDO) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andModelIdEqualTo(modelId);
		detailHeadDAO.updateByExample(detailHeadDO, exam);
	}

	/**
	* 根据headName更新detail_head表数据
	*/
	public void updateDetailHeadByHeadName(String headName,DetailHeadDO detailHeadDO) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andHeadNameEqualTo(headName);
		detailHeadDAO.updateByExample(detailHeadDO, exam);
	}

	/**
	* 根据headCode更新detail_head表数据
	*/
	public void updateDetailHeadByHeadCode(String headCode,DetailHeadDO detailHeadDO) {
		DetailHeadDOExample exam = new DetailHeadDOExample();
		exam.createCriteria().andHeadCodeEqualTo(headCode);
		detailHeadDAO.updateByExample(detailHeadDO, exam);
	}

    /**
	 * 断言detail_model表
	 */
	public void detailModelAssert(
	        DetailModelDO detailModelDO,
			Long id, 
			String modelName, 
			String modelId, 
			String modelCode, 
			String spoutName, 
			String status, 
			String memo, 
			String headDefaultFilter, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, detailModelDO.getId());
        assertEquals(modelName, detailModelDO.getModelName());
        assertEquals(modelId, detailModelDO.getModelId());
        assertEquals(modelCode, detailModelDO.getModelCode());
        assertEquals(spoutName, detailModelDO.getSpoutName());
        assertEquals(status, detailModelDO.getStatus());
        assertEquals(memo, detailModelDO.getMemo());
        assertEquals(headDefaultFilter, detailModelDO.getHeadDefaultFilter());
        assertEquals(rawAddTime, detailModelDO.getRawAddTime());
        assertEquals(rawUpdateTime, detailModelDO.getRawUpdateTime());
	}

	/**
	 * 断言detail_model表数据
	 */
	public void assertDetailModel(DetailModelDO expect, DetailModelDO detailModelDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			detailModelDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != detailModelDO.getRawAddTime());
		expect.setRawAddTime(detailModelDO.getRawAddTime());
        Assertions.assertTrue(null != detailModelDO.getRawUpdateTime());
		expect.setRawUpdateTime(detailModelDO.getRawUpdateTime());
		Assertions.assertEquals(expect, detailModelDO);
	}

    /**
	 * 插入detail_model表数据
	 */
	public void insertDetailModel(DetailModelDO detailModelDO) {
		detailModelDAO.insert(detailModelDO);
	}

    /**
	 * 插入detail_model表数据
	 */
	public void insertDetailModel(
			Long id, 
			String modelName, 
			String modelId, 
			String modelCode, 
			String spoutName, 
			String status, 
			String memo, 
			String headDefaultFilter, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		DetailModelDO detailModelDO = new DetailModelDO();
		detailModelDO.setId(id);
		detailModelDO.setModelName(modelName);
		detailModelDO.setModelId(modelId);
		detailModelDO.setModelCode(modelCode);
		detailModelDO.setSpoutName(spoutName);
		detailModelDO.setStatus(status);
		detailModelDO.setMemo(memo);
		detailModelDO.setHeadDefaultFilter(headDefaultFilter);
		detailModelDO.setRawAddTime(rawAddTime);
		detailModelDO.setRawUpdateTime(rawUpdateTime);
		detailModelDAO.insert(detailModelDO);
	}

    /**
     * 删除detail_model表所有数据
     */
    public void cleanDetailModel() {
        DetailModelDOExample exam = new DetailModelDOExample();
        exam.createCriteria();
        detailModelDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除detail_model表数据
	 */
	public void cleanDetailModelById(Long id) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		detailModelDAO.deleteByExample(exam);
	}

	/**
	* 根据modelName删除detail_model表数据
	*/
	public void cleanDetailModelByModelName(String modelName) {
        if (StringUtils.isBlank(modelName)){
            modelName = "test_modelName";
        }
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		detailModelDAO.deleteByExample(exam);
	}

	/**
	 * 根据modelId删除detail_model表数据
	 */
	public void cleanDetailModelByModelId(String modelId) {
        if (StringUtils.isBlank(modelId)){
            modelId = "test_modelId";
        }
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelIdEqualTo(modelId);
		detailModelDAO.deleteByExample(exam);
	}

	/**
	* 根据modelCode删除detail_model表数据
	*/
	public void cleanDetailModelByModelCode(String modelCode) {
        if (StringUtils.isBlank(modelCode)){
            modelCode = "test_modelCode";
        }
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelCodeEqualTo(modelCode);
		detailModelDAO.deleteByExample(exam);
	}

	/**
	* 根据spoutName删除detail_model表数据
	*/
	public void cleanDetailModelBySpoutName(String spoutName) {
        if (StringUtils.isBlank(spoutName)){
            spoutName = "test_spoutName";
        }
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		detailModelDAO.deleteByExample(exam);
	}

    /**
     * 查询detail_model表所有数据
     */
    public List<DetailModelDO> findDetailModelAll() {
        DetailModelDOExample exam = new DetailModelDOExample();
        exam.createCriteria();
		return detailModelDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询detail_model表数据
	 */
	public List<DetailModelDO> findDetailModelById(Long id) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return detailModelDAO.selectByExample(exam);
	}

	/**
	* 根据modelName查询detail_model表数据
	*/
	public List<DetailModelDO> findDetailModelByModelName(String modelName) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		return detailModelDAO.selectByExample(exam);
	}

    /**
	 * 根据modelId查询detail_model表数据
	 */
	public List<DetailModelDO> findDetailModelByModelId(String modelId) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelIdEqualTo(modelId);
		return detailModelDAO.selectByExample(exam);
	}

	/**
	* 根据modelCode查询detail_model表数据
	*/
	public List<DetailModelDO> findDetailModelByModelCode(String modelCode) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelCodeEqualTo(modelCode);
		return detailModelDAO.selectByExample(exam);
	}

	/**
	* 根据spoutName查询detail_model表数据
	*/
	public List<DetailModelDO> findDetailModelBySpoutName(String spoutName) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		return detailModelDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新detail_model表数据
	 */
	public void updateDetailModelById(Long id,DetailModelDO detailModelDO) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		detailModelDAO.updateByExample(detailModelDO, exam);
	}

	/**
	* 根据modelName更新detail_model表数据
	*/
	public void updateDetailModelByModelName(String modelName,DetailModelDO detailModelDO) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		detailModelDAO.updateByExample(detailModelDO, exam);
	}

    /**
	 * 根据modelId更新detail_model表数据
	 */
	public void updateDetailModelByModelId(String modelId,DetailModelDO detailModelDO) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelIdEqualTo(modelId);
		detailModelDAO.updateByExample(detailModelDO, exam);
	}

	/**
	* 根据modelCode更新detail_model表数据
	*/
	public void updateDetailModelByModelCode(String modelCode,DetailModelDO detailModelDO) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andModelCodeEqualTo(modelCode);
		detailModelDAO.updateByExample(detailModelDO, exam);
	}

	/**
	* 根据spoutName更新detail_model表数据
	*/
	public void updateDetailModelBySpoutName(String spoutName,DetailModelDO detailModelDO) {
		DetailModelDOExample exam = new DetailModelDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		detailModelDAO.updateByExample(detailModelDO, exam);
	}

    /**
	 * 断言detail_model_program表
	 */
	public void detailModelProgramAssert(
	        DetailModelProgramDO detailModelProgramDO,
			Long id, 
			String programName, 
			String programNo, 
			String modelCode, 
			String programType, 
			String operateId, 
			String programMemo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String detailHeadFilter, 
			String detailHeadOrderBy, 
			String detailHeadShow
	) {
        assertEquals(id, detailModelProgramDO.getId());
        assertEquals(programName, detailModelProgramDO.getProgramName());
        assertEquals(programNo, detailModelProgramDO.getProgramNo());
        assertEquals(modelCode, detailModelProgramDO.getModelCode());
        assertEquals(programType, detailModelProgramDO.getProgramType());
        assertEquals(operateId, detailModelProgramDO.getOperateId());
        assertEquals(programMemo, detailModelProgramDO.getProgramMemo());
        assertEquals(rawAddTime, detailModelProgramDO.getRawAddTime());
        assertEquals(rawUpdateTime, detailModelProgramDO.getRawUpdateTime());
        assertEquals(detailHeadFilter, detailModelProgramDO.getDetailHeadFilter());
        assertEquals(detailHeadOrderBy, detailModelProgramDO.getDetailHeadOrderBy());
        assertEquals(detailHeadShow, detailModelProgramDO.getDetailHeadShow());
	}

	/**
	 * 断言detail_model_program表数据
	 */
	public void assertDetailModelProgram(DetailModelProgramDO expect, DetailModelProgramDO detailModelProgramDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			detailModelProgramDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != detailModelProgramDO.getRawAddTime());
		expect.setRawAddTime(detailModelProgramDO.getRawAddTime());
        Assertions.assertTrue(null != detailModelProgramDO.getRawUpdateTime());
		expect.setRawUpdateTime(detailModelProgramDO.getRawUpdateTime());
		Assertions.assertEquals(expect, detailModelProgramDO);
	}

    /**
	 * 插入detail_model_program表数据
	 */
	public void insertDetailModelProgram(DetailModelProgramDO detailModelProgramDO) {
		detailModelProgramDAO.insert(detailModelProgramDO);
	}

    /**
	 * 插入detail_model_program表数据
	 */
	public void insertDetailModelProgram(
			Long id, 
			String programName, 
			String programNo, 
			String modelCode, 
			String programType, 
			String operateId, 
			String programMemo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String detailHeadFilter, 
			String detailHeadOrderBy, 
			String detailHeadShow
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		DetailModelProgramDO detailModelProgramDO = new DetailModelProgramDO();
		detailModelProgramDO.setId(id);
		detailModelProgramDO.setProgramName(programName);
		detailModelProgramDO.setProgramNo(programNo);
		detailModelProgramDO.setModelCode(modelCode);
		detailModelProgramDO.setProgramType(programType);
		detailModelProgramDO.setOperateId(operateId);
		detailModelProgramDO.setProgramMemo(programMemo);
		detailModelProgramDO.setRawAddTime(rawAddTime);
		detailModelProgramDO.setRawUpdateTime(rawUpdateTime);
		detailModelProgramDO.setDetailHeadFilter(detailHeadFilter);
		detailModelProgramDO.setDetailHeadOrderBy(detailHeadOrderBy);
		detailModelProgramDO.setDetailHeadShow(detailHeadShow);
		detailModelProgramDAO.insert(detailModelProgramDO);
	}

    /**
     * 删除detail_model_program表所有数据
     */
    public void cleanDetailModelProgram() {
        DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
        exam.createCriteria();
        detailModelProgramDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除detail_model_program表数据
	 */
	public void cleanDetailModelProgramById(Long id) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andIdEqualTo(id);
		detailModelProgramDAO.deleteByExample(exam);
	}

	/**
	* 根据programName删除detail_model_program表数据
	*/
	public void cleanDetailModelProgramByProgramName(String programName) {
        if (StringUtils.isBlank(programName)){
            programName = "test_programName";
        }
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andProgramNameEqualTo(programName);
		detailModelProgramDAO.deleteByExample(exam);
	}

	/**
	 * 根据programNo删除detail_model_program表数据
	 */
	public void cleanDetailModelProgramByProgramNo(String programNo) {
        if (StringUtils.isBlank(programNo)){
            programNo = "test_programNo";
        }
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andProgramNoEqualTo(programNo);
		detailModelProgramDAO.deleteByExample(exam);
	}

	/**
	* 根据modelCode删除detail_model_program表数据
	*/
	public void cleanDetailModelProgramByModelCode(String modelCode) {
        if (StringUtils.isBlank(modelCode)){
            modelCode = "test_modelCode";
        }
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andModelCodeEqualTo(modelCode);
		detailModelProgramDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除detail_model_program表数据
	 */
	public void cleanDetailModelProgramByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		detailModelProgramDAO.deleteByExample(exam);
	}

    /**
     * 查询detail_model_program表所有数据
     */
    public List<DetailModelProgramDO> findDetailModelProgramAll() {
        DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
        exam.createCriteria();
		return detailModelProgramDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询detail_model_program表数据
	 */
	public List<DetailModelProgramDO> findDetailModelProgramById(Long id) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return detailModelProgramDAO.selectByExample(exam);
	}

	/**
	* 根据programName查询detail_model_program表数据
	*/
	public List<DetailModelProgramDO> findDetailModelProgramByProgramName(String programName) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andProgramNameEqualTo(programName);
		return detailModelProgramDAO.selectByExample(exam);
	}

    /**
	 * 根据programNo查询detail_model_program表数据
	 */
	public List<DetailModelProgramDO> findDetailModelProgramByProgramNo(String programNo) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andProgramNoEqualTo(programNo);
		return detailModelProgramDAO.selectByExample(exam);
	}

	/**
	* 根据modelCode查询detail_model_program表数据
	*/
	public List<DetailModelProgramDO> findDetailModelProgramByModelCode(String modelCode) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andModelCodeEqualTo(modelCode);
		return detailModelProgramDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询detail_model_program表数据
	 */
	public List<DetailModelProgramDO> findDetailModelProgramByOperateId(String operateId) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return detailModelProgramDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新detail_model_program表数据
	 */
	public void updateDetailModelProgramById(Long id,DetailModelProgramDO detailModelProgramDO) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andIdEqualTo(id);
		detailModelProgramDAO.updateByExample(detailModelProgramDO, exam);
	}

	/**
	* 根据programName更新detail_model_program表数据
	*/
	public void updateDetailModelProgramByProgramName(String programName,DetailModelProgramDO detailModelProgramDO) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andProgramNameEqualTo(programName);
		detailModelProgramDAO.updateByExample(detailModelProgramDO, exam);
	}

    /**
	 * 根据programNo更新detail_model_program表数据
	 */
	public void updateDetailModelProgramByProgramNo(String programNo,DetailModelProgramDO detailModelProgramDO) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andProgramNoEqualTo(programNo);
		detailModelProgramDAO.updateByExample(detailModelProgramDO, exam);
	}

	/**
	* 根据modelCode更新detail_model_program表数据
	*/
	public void updateDetailModelProgramByModelCode(String modelCode,DetailModelProgramDO detailModelProgramDO) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andModelCodeEqualTo(modelCode);
		detailModelProgramDAO.updateByExample(detailModelProgramDO, exam);
	}

    /**
	 * 根据operateId更新detail_model_program表数据
	 */
	public void updateDetailModelProgramByOperateId(String operateId,DetailModelProgramDO detailModelProgramDO) {
		DetailModelProgramDOExample exam = new DetailModelProgramDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		detailModelProgramDAO.updateByExample(detailModelProgramDO, exam);
	}

    /**
	 * 断言distinct_detail表
	 */
	public void distinctDetailAssert(
	        DistinctDetailDO distinctDetailDO,
			Long id, 
			String rowKey, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String distinctData
	) {
        assertEquals(id, distinctDetailDO.getId());
        assertEquals(rowKey, distinctDetailDO.getRowKey());
        assertEquals(rawAddTime, distinctDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, distinctDetailDO.getRawUpdateTime());
        assertEquals(distinctData, distinctDetailDO.getDistinctData());
	}

	/**
	 * 断言distinct_detail表数据
	 */
	public void assertDistinctDetail(DistinctDetailDO expect, DistinctDetailDO distinctDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			distinctDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != distinctDetailDO.getRawAddTime());
		expect.setRawAddTime(distinctDetailDO.getRawAddTime());
        Assertions.assertTrue(null != distinctDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(distinctDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, distinctDetailDO);
	}

    /**
	 * 插入distinct_detail表数据
	 */
	public void insertDistinctDetail(DistinctDetailDO distinctDetailDO) {
		distinctDetailDAO.insert(distinctDetailDO);
	}

    /**
	 * 插入distinct_detail表数据
	 */
	public void insertDistinctDetail(
			Long id, 
			String rowKey, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String distinctData
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		DistinctDetailDO distinctDetailDO = new DistinctDetailDO();
		distinctDetailDO.setId(id);
		distinctDetailDO.setRowKey(rowKey);
		distinctDetailDO.setRawAddTime(rawAddTime);
		distinctDetailDO.setRawUpdateTime(rawUpdateTime);
		distinctDetailDO.setDistinctData(distinctData);
		distinctDetailDAO.insert(distinctDetailDO);
	}

    /**
     * 删除distinct_detail表所有数据
     */
    public void cleanDistinctDetail() {
        DistinctDetailDOExample exam = new DistinctDetailDOExample();
        exam.createCriteria();
        distinctDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除distinct_detail表数据
	 */
	public void cleanDistinctDetailById(Long id) {
		DistinctDetailDOExample exam = new DistinctDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		distinctDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询distinct_detail表所有数据
     */
    public List<DistinctDetailDO> findDistinctDetailAll() {
        DistinctDetailDOExample exam = new DistinctDetailDOExample();
        exam.createCriteria();
		return distinctDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询distinct_detail表数据
	 */
	public List<DistinctDetailDO> findDistinctDetailById(Long id) {
		DistinctDetailDOExample exam = new DistinctDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return distinctDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新distinct_detail表数据
	 */
	public void updateDistinctDetailById(Long id,DistinctDetailDO distinctDetailDO) {
		DistinctDetailDOExample exam = new DistinctDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		distinctDetailDAO.updateByExample(distinctDetailDO, exam);
	}

    /**
	 * 断言distributed_lock表
	 */
	public void distributedLockAssert(
	        DistributedLockDO distributedLockDO,
			Long id, 
			String policy, 
			String lockModule, 
			String lockName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, distributedLockDO.getId());
        assertEquals(policy, distributedLockDO.getPolicy());
        assertEquals(lockModule, distributedLockDO.getLockModule());
        assertEquals(lockName, distributedLockDO.getLockName());
        assertEquals(rawAddTime, distributedLockDO.getRawAddTime());
        assertEquals(rawUpdateTime, distributedLockDO.getRawUpdateTime());
	}

	/**
	 * 断言distributed_lock表数据
	 */
	public void assertDistributedLock(DistributedLockDO expect, DistributedLockDO distributedLockDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			distributedLockDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != distributedLockDO.getRawAddTime());
		expect.setRawAddTime(distributedLockDO.getRawAddTime());
        Assertions.assertTrue(null != distributedLockDO.getRawUpdateTime());
		expect.setRawUpdateTime(distributedLockDO.getRawUpdateTime());
		Assertions.assertEquals(expect, distributedLockDO);
	}

    /**
	 * 插入distributed_lock表数据
	 */
	public void insertDistributedLock(DistributedLockDO distributedLockDO) {
		distributedLockDAO.insert(distributedLockDO);
	}

    /**
	 * 插入distributed_lock表数据
	 */
	public void insertDistributedLock(
			Long id, 
			String policy, 
			String lockModule, 
			String lockName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		DistributedLockDO distributedLockDO = new DistributedLockDO();
		distributedLockDO.setId(id);
		distributedLockDO.setPolicy(policy);
		distributedLockDO.setLockModule(lockModule);
		distributedLockDO.setLockName(lockName);
		distributedLockDO.setRawAddTime(rawAddTime);
		distributedLockDO.setRawUpdateTime(rawUpdateTime);
		distributedLockDAO.insert(distributedLockDO);
	}

    /**
     * 删除distributed_lock表所有数据
     */
    public void cleanDistributedLock() {
        DistributedLockDOExample exam = new DistributedLockDOExample();
        exam.createCriteria();
        distributedLockDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除distributed_lock表数据
	 */
	public void cleanDistributedLockById(Long id) {
		DistributedLockDOExample exam = new DistributedLockDOExample();
		exam.createCriteria().andIdEqualTo(id);
		distributedLockDAO.deleteByExample(exam);
	}

	/**
	* 根据lockName删除distributed_lock表数据
	*/
	public void cleanDistributedLockByLockName(String lockName) {
        if (StringUtils.isBlank(lockName)){
            lockName = "test_lockName";
        }
		DistributedLockDOExample exam = new DistributedLockDOExample();
		exam.createCriteria().andLockNameEqualTo(lockName);
		distributedLockDAO.deleteByExample(exam);
	}

    /**
     * 查询distributed_lock表所有数据
     */
    public List<DistributedLockDO> findDistributedLockAll() {
        DistributedLockDOExample exam = new DistributedLockDOExample();
        exam.createCriteria();
		return distributedLockDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询distributed_lock表数据
	 */
	public List<DistributedLockDO> findDistributedLockById(Long id) {
		DistributedLockDOExample exam = new DistributedLockDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return distributedLockDAO.selectByExample(exam);
	}

	/**
	* 根据lockName查询distributed_lock表数据
	*/
	public List<DistributedLockDO> findDistributedLockByLockName(String lockName) {
		DistributedLockDOExample exam = new DistributedLockDOExample();
		exam.createCriteria().andLockNameEqualTo(lockName);
		return distributedLockDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新distributed_lock表数据
	 */
	public void updateDistributedLockById(Long id,DistributedLockDO distributedLockDO) {
		DistributedLockDOExample exam = new DistributedLockDOExample();
		exam.createCriteria().andIdEqualTo(id);
		distributedLockDAO.updateByExample(distributedLockDO, exam);
	}

	/**
	* 根据lockName更新distributed_lock表数据
	*/
	public void updateDistributedLockByLockName(String lockName,DistributedLockDO distributedLockDO) {
		DistributedLockDOExample exam = new DistributedLockDOExample();
		exam.createCriteria().andLockNameEqualTo(lockName);
		distributedLockDAO.updateByExample(distributedLockDO, exam);
	}

    /**
	 * 断言file_download表
	 */
	public void fileDownloadAssert(
	        FileDownloadDO fileDownloadDO,
			Long id, 
			String operateId, 
			String fileType, 
			String fileName, 
			String fileFormat, 
			String fileUrl, 
			String downloadUrl, 
			String status, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
        assertEquals(id, fileDownloadDO.getId());
        assertEquals(operateId, fileDownloadDO.getOperateId());
        assertEquals(fileType, fileDownloadDO.getFileType());
        assertEquals(fileName, fileDownloadDO.getFileName());
        assertEquals(fileFormat, fileDownloadDO.getFileFormat());
        assertEquals(fileUrl, fileDownloadDO.getFileUrl());
        assertEquals(downloadUrl, fileDownloadDO.getDownloadUrl());
        assertEquals(status, fileDownloadDO.getStatus());
        assertEquals(memo, fileDownloadDO.getMemo());
        assertEquals(rawAddTime, fileDownloadDO.getRawAddTime());
        assertEquals(rawUpdateTime, fileDownloadDO.getRawUpdateTime());
        assertEquals(context, fileDownloadDO.getContext());
	}

	/**
	 * 断言file_download表数据
	 */
	public void assertFileDownload(FileDownloadDO expect, FileDownloadDO fileDownloadDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			fileDownloadDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != fileDownloadDO.getRawAddTime());
		expect.setRawAddTime(fileDownloadDO.getRawAddTime());
        Assertions.assertTrue(null != fileDownloadDO.getRawUpdateTime());
		expect.setRawUpdateTime(fileDownloadDO.getRawUpdateTime());
		Assertions.assertEquals(expect, fileDownloadDO);
	}

    /**
	 * 插入file_download表数据
	 */
	public void insertFileDownload(FileDownloadDO fileDownloadDO) {
		fileDownloadDAO.insert(fileDownloadDO);
	}

    /**
	 * 插入file_download表数据
	 */
	public void insertFileDownload(
			Long id, 
			String operateId, 
			String fileType, 
			String fileName, 
			String fileFormat, 
			String fileUrl, 
			String downloadUrl, 
			String status, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		FileDownloadDO fileDownloadDO = new FileDownloadDO();
		fileDownloadDO.setId(id);
		fileDownloadDO.setOperateId(operateId);
		fileDownloadDO.setFileType(fileType);
		fileDownloadDO.setFileName(fileName);
		fileDownloadDO.setFileFormat(fileFormat);
		fileDownloadDO.setFileUrl(fileUrl);
		fileDownloadDO.setDownloadUrl(downloadUrl);
		fileDownloadDO.setStatus(status);
		fileDownloadDO.setMemo(memo);
		fileDownloadDO.setRawAddTime(rawAddTime);
		fileDownloadDO.setRawUpdateTime(rawUpdateTime);
		fileDownloadDO.setContext(context);
		fileDownloadDAO.insert(fileDownloadDO);
	}

    /**
     * 删除file_download表所有数据
     */
    public void cleanFileDownload() {
        FileDownloadDOExample exam = new FileDownloadDOExample();
        exam.createCriteria();
        fileDownloadDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除file_download表数据
	 */
	public void cleanFileDownloadById(Long id) {
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andIdEqualTo(id);
		fileDownloadDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除file_download表数据
	 */
	public void cleanFileDownloadByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		fileDownloadDAO.deleteByExample(exam);
	}

	/**
	* 根据fileName删除file_download表数据
	*/
	public void cleanFileDownloadByFileName(String fileName) {
        if (StringUtils.isBlank(fileName)){
            fileName = "test_fileName";
        }
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		fileDownloadDAO.deleteByExample(exam);
	}

    /**
     * 查询file_download表所有数据
     */
    public List<FileDownloadDO> findFileDownloadAll() {
        FileDownloadDOExample exam = new FileDownloadDOExample();
        exam.createCriteria();
		return fileDownloadDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询file_download表数据
	 */
	public List<FileDownloadDO> findFileDownloadById(Long id) {
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return fileDownloadDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询file_download表数据
	 */
	public List<FileDownloadDO> findFileDownloadByOperateId(String operateId) {
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return fileDownloadDAO.selectByExample(exam);
	}

	/**
	* 根据fileName查询file_download表数据
	*/
	public List<FileDownloadDO> findFileDownloadByFileName(String fileName) {
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		return fileDownloadDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新file_download表数据
	 */
	public void updateFileDownloadById(Long id,FileDownloadDO fileDownloadDO) {
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andIdEqualTo(id);
		fileDownloadDAO.updateByExample(fileDownloadDO, exam);
	}

    /**
	 * 根据operateId更新file_download表数据
	 */
	public void updateFileDownloadByOperateId(String operateId,FileDownloadDO fileDownloadDO) {
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		fileDownloadDAO.updateByExample(fileDownloadDO, exam);
	}

	/**
	* 根据fileName更新file_download表数据
	*/
	public void updateFileDownloadByFileName(String fileName,FileDownloadDO fileDownloadDO) {
		FileDownloadDOExample exam = new FileDownloadDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		fileDownloadDAO.updateByExample(fileDownloadDO, exam);
	}

    /**
	 * 断言gas_account_change表
	 */
	public void gasAccountChangeAssert(
	        GasAccountChangeDO gasAccountChangeDO,
			Long id, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String sourceType, 
			String sourceId, 
			String showText, 
			String changeType, 
			String changeMode, 
			Long amount, 
			String memo, 
			Date changeTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasAccountChangeDO.getId());
        assertEquals(partnerId, gasAccountChangeDO.getPartnerId());
        assertEquals(partnerName, gasAccountChangeDO.getPartnerName());
        assertEquals(stationId, gasAccountChangeDO.getStationId());
        assertEquals(stationCode, gasAccountChangeDO.getStationCode());
        assertEquals(stationName, gasAccountChangeDO.getStationName());
        assertEquals(operateId, gasAccountChangeDO.getOperateId());
        assertEquals(operateName, gasAccountChangeDO.getOperateName());
        assertEquals(terminalType, gasAccountChangeDO.getTerminalType());
        assertEquals(terminalCode, gasAccountChangeDO.getTerminalCode());
        assertEquals(userId, gasAccountChangeDO.getUserId());
        assertEquals(realName, gasAccountChangeDO.getRealName());
        assertEquals(nickName, gasAccountChangeDO.getNickName());
        assertEquals(memberType, gasAccountChangeDO.getMemberType());
        assertEquals(mobile, gasAccountChangeDO.getMobile());
        assertEquals(sourceType, gasAccountChangeDO.getSourceType());
        assertEquals(sourceId, gasAccountChangeDO.getSourceId());
        assertEquals(showText, gasAccountChangeDO.getShowText());
        assertEquals(changeType, gasAccountChangeDO.getChangeType());
        assertEquals(changeMode, gasAccountChangeDO.getChangeMode());
        assertEquals(amount, gasAccountChangeDO.getAmount());
        assertEquals(memo, gasAccountChangeDO.getMemo());
        assertEquals(changeTime, gasAccountChangeDO.getChangeTime());
        assertEquals(rawAddTime, gasAccountChangeDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasAccountChangeDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_account_change表数据
	 */
	public void assertGasAccountChange(GasAccountChangeDO expect, GasAccountChangeDO gasAccountChangeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasAccountChangeDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasAccountChangeDO.getRawAddTime());
		expect.setRawAddTime(gasAccountChangeDO.getRawAddTime());
        Assertions.assertTrue(null != gasAccountChangeDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasAccountChangeDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasAccountChangeDO);
	}

    /**
	 * 插入gas_account_change表数据
	 */
	public void insertGasAccountChange(GasAccountChangeDO gasAccountChangeDO) {
		gasAccountChangeDAO.insert(gasAccountChangeDO);
	}

    /**
	 * 插入gas_account_change表数据
	 */
	public void insertGasAccountChange(
			Long id, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String sourceType, 
			String sourceId, 
			String showText, 
			String changeType, 
			String changeMode, 
			Long amount, 
			String memo, 
			Date changeTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasAccountChangeDO gasAccountChangeDO = new GasAccountChangeDO();
		gasAccountChangeDO.setId(id);
		gasAccountChangeDO.setPartnerId(partnerId);
		gasAccountChangeDO.setPartnerName(partnerName);
		gasAccountChangeDO.setStationId(stationId);
		gasAccountChangeDO.setStationCode(stationCode);
		gasAccountChangeDO.setStationName(stationName);
		gasAccountChangeDO.setOperateId(operateId);
		gasAccountChangeDO.setOperateName(operateName);
		gasAccountChangeDO.setTerminalType(terminalType);
		gasAccountChangeDO.setTerminalCode(terminalCode);
		gasAccountChangeDO.setUserId(userId);
		gasAccountChangeDO.setRealName(realName);
		gasAccountChangeDO.setNickName(nickName);
		gasAccountChangeDO.setMemberType(memberType);
		gasAccountChangeDO.setMobile(mobile);
		gasAccountChangeDO.setSourceType(sourceType);
		gasAccountChangeDO.setSourceId(sourceId);
		gasAccountChangeDO.setShowText(showText);
		gasAccountChangeDO.setChangeType(changeType);
		gasAccountChangeDO.setChangeMode(changeMode);
		gasAccountChangeDO.setAmount(amount);
		gasAccountChangeDO.setMemo(memo);
		gasAccountChangeDO.setChangeTime(changeTime);
		gasAccountChangeDO.setRawAddTime(rawAddTime);
		gasAccountChangeDO.setRawUpdateTime(rawUpdateTime);
		gasAccountChangeDAO.insert(gasAccountChangeDO);
	}

    /**
     * 删除gas_account_change表所有数据
     */
    public void cleanGasAccountChange() {
        GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
        exam.createCriteria();
        gasAccountChangeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_account_change表数据
	 */
	public void cleanGasAccountChangeById(Long id) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_account_change表数据
	 */
	public void cleanGasAccountChangeByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_account_change表数据
	*/
	public void cleanGasAccountChangeByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_account_change表数据
	 */
	public void cleanGasAccountChangeByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_account_change表数据
	*/
	public void cleanGasAccountChangeByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_account_change表数据
	*/
	public void cleanGasAccountChangeByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_account_change表数据
	 */
	public void cleanGasAccountChangeByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_account_change表数据
	*/
	public void cleanGasAccountChangeByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_account_change表数据
	*/
	public void cleanGasAccountChangeByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_account_change表数据
	 */
	public void cleanGasAccountChangeByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_account_change表数据
	*/
	public void cleanGasAccountChangeByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_account_change表数据
	*/
	public void cleanGasAccountChangeByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_account_change表数据
	 */
	public void cleanGasAccountChangeByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasAccountChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据sourceId删除gas_account_change表数据
	 */
	public void cleanGasAccountChangeBySourceId(String sourceId) {
        if (StringUtils.isBlank(sourceId)){
            sourceId = "test_sourceId";
        }
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andSourceIdEqualTo(sourceId);
		gasAccountChangeDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_account_change表所有数据
     */
    public List<GasAccountChangeDO> findGasAccountChangeAll() {
        GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
        exam.createCriteria();
		return gasAccountChangeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_account_change表数据
	 */
	public List<GasAccountChangeDO> findGasAccountChangeById(Long id) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasAccountChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_account_change表数据
	 */
	public List<GasAccountChangeDO> findGasAccountChangeByPartnerId(String partnerId) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasAccountChangeDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_account_change表数据
	*/
	public List<GasAccountChangeDO> findGasAccountChangeByPartnerName(String partnerName) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasAccountChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_account_change表数据
	 */
	public List<GasAccountChangeDO> findGasAccountChangeByStationId(String stationId) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasAccountChangeDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_account_change表数据
	*/
	public List<GasAccountChangeDO> findGasAccountChangeByStationCode(String stationCode) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasAccountChangeDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_account_change表数据
	*/
	public List<GasAccountChangeDO> findGasAccountChangeByStationName(String stationName) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasAccountChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_account_change表数据
	 */
	public List<GasAccountChangeDO> findGasAccountChangeByOperateId(String operateId) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasAccountChangeDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_account_change表数据
	*/
	public List<GasAccountChangeDO> findGasAccountChangeByOperateName(String operateName) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasAccountChangeDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_account_change表数据
	*/
	public List<GasAccountChangeDO> findGasAccountChangeByTerminalCode(String terminalCode) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasAccountChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_account_change表数据
	 */
	public List<GasAccountChangeDO> findGasAccountChangeByUserId(String userId) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasAccountChangeDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_account_change表数据
	*/
	public List<GasAccountChangeDO> findGasAccountChangeByRealName(String realName) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasAccountChangeDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_account_change表数据
	*/
	public List<GasAccountChangeDO> findGasAccountChangeByNickName(String nickName) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasAccountChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_account_change表数据
	 */
	public List<GasAccountChangeDO> findGasAccountChangeByMobile(String mobile) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasAccountChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据sourceId查询gas_account_change表数据
	 */
	public List<GasAccountChangeDO> findGasAccountChangeBySourceId(String sourceId) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andSourceIdEqualTo(sourceId);
		return gasAccountChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_account_change表数据
	 */
	public void updateGasAccountChangeById(Long id,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

    /**
	 * 根据partnerId更新gas_account_change表数据
	 */
	public void updateGasAccountChangeByPartnerId(String partnerId,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

	/**
	* 根据partnerName更新gas_account_change表数据
	*/
	public void updateGasAccountChangeByPartnerName(String partnerName,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

    /**
	 * 根据stationId更新gas_account_change表数据
	 */
	public void updateGasAccountChangeByStationId(String stationId,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

	/**
	* 根据stationCode更新gas_account_change表数据
	*/
	public void updateGasAccountChangeByStationCode(String stationCode,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

	/**
	* 根据stationName更新gas_account_change表数据
	*/
	public void updateGasAccountChangeByStationName(String stationName,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

    /**
	 * 根据operateId更新gas_account_change表数据
	 */
	public void updateGasAccountChangeByOperateId(String operateId,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

	/**
	* 根据operateName更新gas_account_change表数据
	*/
	public void updateGasAccountChangeByOperateName(String operateName,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

	/**
	* 根据terminalCode更新gas_account_change表数据
	*/
	public void updateGasAccountChangeByTerminalCode(String terminalCode,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

    /**
	 * 根据userId更新gas_account_change表数据
	 */
	public void updateGasAccountChangeByUserId(String userId,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

	/**
	* 根据realName更新gas_account_change表数据
	*/
	public void updateGasAccountChangeByRealName(String realName,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

	/**
	* 根据nickName更新gas_account_change表数据
	*/
	public void updateGasAccountChangeByNickName(String nickName,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

    /**
	 * 根据mobile更新gas_account_change表数据
	 */
	public void updateGasAccountChangeByMobile(String mobile,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

    /**
	 * 根据sourceId更新gas_account_change表数据
	 */
	public void updateGasAccountChangeBySourceId(String sourceId,GasAccountChangeDO gasAccountChangeDO) {
		GasAccountChangeDOExample exam = new GasAccountChangeDOExample();
		exam.createCriteria().andSourceIdEqualTo(sourceId);
		gasAccountChangeDAO.updateByExample(gasAccountChangeDO, exam);
	}

    /**
	 * 断言gas_campaign_definition表
	 */
	public void gasCampaignDefinitionAssert(
	        GasCampaignDefinitionDO gasCampaignDefinitionDO,
			Integer id, 
			String partnerId, 
			String campaignType, 
			String campaignNo, 
			String name, 
			String title, 
			Date startTime, 
			Date endTime, 
			Date giveTime, 
			String status, 
			String memo, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasCampaignDefinitionDO.getId());
        assertEquals(partnerId, gasCampaignDefinitionDO.getPartnerId());
        assertEquals(campaignType, gasCampaignDefinitionDO.getCampaignType());
        assertEquals(campaignNo, gasCampaignDefinitionDO.getCampaignNo());
        assertEquals(name, gasCampaignDefinitionDO.getName());
        assertEquals(title, gasCampaignDefinitionDO.getTitle());
        assertEquals(startTime, gasCampaignDefinitionDO.getStartTime());
        assertEquals(endTime, gasCampaignDefinitionDO.getEndTime());
        assertEquals(giveTime, gasCampaignDefinitionDO.getGiveTime());
        assertEquals(status, gasCampaignDefinitionDO.getStatus());
        assertEquals(memo, gasCampaignDefinitionDO.getMemo());
        assertEquals(createTime, gasCampaignDefinitionDO.getCreateTime());
        assertEquals(updateTime, gasCampaignDefinitionDO.getUpdateTime());
        assertEquals(rawAddTime, gasCampaignDefinitionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasCampaignDefinitionDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_campaign_definition表数据
	 */
	public void assertGasCampaignDefinition(GasCampaignDefinitionDO expect, GasCampaignDefinitionDO gasCampaignDefinitionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasCampaignDefinitionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasCampaignDefinitionDO.getRawAddTime());
		expect.setRawAddTime(gasCampaignDefinitionDO.getRawAddTime());
        Assertions.assertTrue(null != gasCampaignDefinitionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasCampaignDefinitionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasCampaignDefinitionDO);
	}

    /**
	 * 插入gas_campaign_definition表数据
	 */
	public void insertGasCampaignDefinition(GasCampaignDefinitionDO gasCampaignDefinitionDO) {
		gasCampaignDefinitionDAO.insert(gasCampaignDefinitionDO);
	}

    /**
	 * 插入gas_campaign_definition表数据
	 */
	public void insertGasCampaignDefinition(
			Integer id, 
			String partnerId, 
			String campaignType, 
			String campaignNo, 
			String name, 
			String title, 
			Date startTime, 
			Date endTime, 
			Date giveTime, 
			String status, 
			String memo, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasCampaignDefinitionDO gasCampaignDefinitionDO = new GasCampaignDefinitionDO();
		gasCampaignDefinitionDO.setId(id);
		gasCampaignDefinitionDO.setPartnerId(partnerId);
		gasCampaignDefinitionDO.setCampaignType(campaignType);
		gasCampaignDefinitionDO.setCampaignNo(campaignNo);
		gasCampaignDefinitionDO.setName(name);
		gasCampaignDefinitionDO.setTitle(title);
		gasCampaignDefinitionDO.setStartTime(startTime);
		gasCampaignDefinitionDO.setEndTime(endTime);
		gasCampaignDefinitionDO.setGiveTime(giveTime);
		gasCampaignDefinitionDO.setStatus(status);
		gasCampaignDefinitionDO.setMemo(memo);
		gasCampaignDefinitionDO.setCreateTime(createTime);
		gasCampaignDefinitionDO.setUpdateTime(updateTime);
		gasCampaignDefinitionDO.setRawAddTime(rawAddTime);
		gasCampaignDefinitionDO.setRawUpdateTime(rawUpdateTime);
		gasCampaignDefinitionDAO.insert(gasCampaignDefinitionDO);
	}

    /**
     * 删除gas_campaign_definition表所有数据
     */
    public void cleanGasCampaignDefinition() {
        GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
        exam.createCriteria();
        gasCampaignDefinitionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_campaign_definition表数据
	 */
	public void cleanGasCampaignDefinitionById(Integer id) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCampaignDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_campaign_definition表数据
	 */
	public void cleanGasCampaignDefinitionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasCampaignDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除gas_campaign_definition表数据
	 */
	public void cleanGasCampaignDefinitionByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		gasCampaignDefinitionDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除gas_campaign_definition表数据
	*/
	public void cleanGasCampaignDefinitionByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasCampaignDefinitionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_campaign_definition表所有数据
     */
    public List<GasCampaignDefinitionDO> findGasCampaignDefinitionAll() {
        GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
        exam.createCriteria();
		return gasCampaignDefinitionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_campaign_definition表数据
	 */
	public List<GasCampaignDefinitionDO> findGasCampaignDefinitionById(Integer id) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasCampaignDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_campaign_definition表数据
	 */
	public List<GasCampaignDefinitionDO> findGasCampaignDefinitionByPartnerId(String partnerId) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasCampaignDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询gas_campaign_definition表数据
	 */
	public List<GasCampaignDefinitionDO> findGasCampaignDefinitionByCampaignNo(String campaignNo) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return gasCampaignDefinitionDAO.selectByExample(exam);
	}

	/**
	* 根据name查询gas_campaign_definition表数据
	*/
	public List<GasCampaignDefinitionDO> findGasCampaignDefinitionByName(String name) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return gasCampaignDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_campaign_definition表数据
	 */
	public void updateGasCampaignDefinitionById(Integer id,GasCampaignDefinitionDO gasCampaignDefinitionDO) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCampaignDefinitionDAO.updateByExample(gasCampaignDefinitionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_campaign_definition表数据
	 */
	public void updateGasCampaignDefinitionByPartnerId(String partnerId,GasCampaignDefinitionDO gasCampaignDefinitionDO) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasCampaignDefinitionDAO.updateByExample(gasCampaignDefinitionDO, exam);
	}

    /**
	 * 根据campaignNo更新gas_campaign_definition表数据
	 */
	public void updateGasCampaignDefinitionByCampaignNo(String campaignNo,GasCampaignDefinitionDO gasCampaignDefinitionDO) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		gasCampaignDefinitionDAO.updateByExample(gasCampaignDefinitionDO, exam);
	}

	/**
	* 根据name更新gas_campaign_definition表数据
	*/
	public void updateGasCampaignDefinitionByName(String name,GasCampaignDefinitionDO gasCampaignDefinitionDO) {
		GasCampaignDefinitionDOExample exam = new GasCampaignDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasCampaignDefinitionDAO.updateByExample(gasCampaignDefinitionDO, exam);
	}

    /**
	 * 断言gas_coupon_definition表
	 */
	public void gasCouponDefinitionAssert(
	        GasCouponDefinitionDO gasCouponDefinitionDO,
			Integer id, 
			String partnerId, 
			String definitionId, 
			String definitionStatus, 
			String name, 
			String type, 
			String bizType, 
			Date createTime, 
			Date updateTime, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasCouponDefinitionDO.getId());
        assertEquals(partnerId, gasCouponDefinitionDO.getPartnerId());
        assertEquals(definitionId, gasCouponDefinitionDO.getDefinitionId());
        assertEquals(definitionStatus, gasCouponDefinitionDO.getDefinitionStatus());
        assertEquals(name, gasCouponDefinitionDO.getName());
        assertEquals(type, gasCouponDefinitionDO.getType());
        assertEquals(bizType, gasCouponDefinitionDO.getBizType());
        assertEquals(createTime, gasCouponDefinitionDO.getCreateTime());
        assertEquals(updateTime, gasCouponDefinitionDO.getUpdateTime());
        assertEquals(memo, gasCouponDefinitionDO.getMemo());
        assertEquals(rawAddTime, gasCouponDefinitionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasCouponDefinitionDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_coupon_definition表数据
	 */
	public void assertGasCouponDefinition(GasCouponDefinitionDO expect, GasCouponDefinitionDO gasCouponDefinitionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasCouponDefinitionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasCouponDefinitionDO.getRawAddTime());
		expect.setRawAddTime(gasCouponDefinitionDO.getRawAddTime());
        Assertions.assertTrue(null != gasCouponDefinitionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasCouponDefinitionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasCouponDefinitionDO);
	}

    /**
	 * 插入gas_coupon_definition表数据
	 */
	public void insertGasCouponDefinition(GasCouponDefinitionDO gasCouponDefinitionDO) {
		gasCouponDefinitionDAO.insert(gasCouponDefinitionDO);
	}

    /**
	 * 插入gas_coupon_definition表数据
	 */
	public void insertGasCouponDefinition(
			Integer id, 
			String partnerId, 
			String definitionId, 
			String definitionStatus, 
			String name, 
			String type, 
			String bizType, 
			Date createTime, 
			Date updateTime, 
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
		GasCouponDefinitionDO gasCouponDefinitionDO = new GasCouponDefinitionDO();
		gasCouponDefinitionDO.setId(id);
		gasCouponDefinitionDO.setPartnerId(partnerId);
		gasCouponDefinitionDO.setDefinitionId(definitionId);
		gasCouponDefinitionDO.setDefinitionStatus(definitionStatus);
		gasCouponDefinitionDO.setName(name);
		gasCouponDefinitionDO.setType(type);
		gasCouponDefinitionDO.setBizType(bizType);
		gasCouponDefinitionDO.setCreateTime(createTime);
		gasCouponDefinitionDO.setUpdateTime(updateTime);
		gasCouponDefinitionDO.setMemo(memo);
		gasCouponDefinitionDO.setRawAddTime(rawAddTime);
		gasCouponDefinitionDO.setRawUpdateTime(rawUpdateTime);
		gasCouponDefinitionDAO.insert(gasCouponDefinitionDO);
	}

    /**
     * 删除gas_coupon_definition表所有数据
     */
    public void cleanGasCouponDefinition() {
        GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
        exam.createCriteria();
        gasCouponDefinitionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_coupon_definition表数据
	 */
	public void cleanGasCouponDefinitionById(Integer id) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCouponDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_coupon_definition表数据
	 */
	public void cleanGasCouponDefinitionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasCouponDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除gas_coupon_definition表数据
	 */
	public void cleanGasCouponDefinitionByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		gasCouponDefinitionDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除gas_coupon_definition表数据
	*/
	public void cleanGasCouponDefinitionByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasCouponDefinitionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_coupon_definition表所有数据
     */
    public List<GasCouponDefinitionDO> findGasCouponDefinitionAll() {
        GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
        exam.createCriteria();
		return gasCouponDefinitionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_coupon_definition表数据
	 */
	public List<GasCouponDefinitionDO> findGasCouponDefinitionById(Integer id) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasCouponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_coupon_definition表数据
	 */
	public List<GasCouponDefinitionDO> findGasCouponDefinitionByPartnerId(String partnerId) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasCouponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询gas_coupon_definition表数据
	 */
	public List<GasCouponDefinitionDO> findGasCouponDefinitionByDefinitionId(String definitionId) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return gasCouponDefinitionDAO.selectByExample(exam);
	}

	/**
	* 根据name查询gas_coupon_definition表数据
	*/
	public List<GasCouponDefinitionDO> findGasCouponDefinitionByName(String name) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return gasCouponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_coupon_definition表数据
	 */
	public void updateGasCouponDefinitionById(Integer id,GasCouponDefinitionDO gasCouponDefinitionDO) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCouponDefinitionDAO.updateByExample(gasCouponDefinitionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_coupon_definition表数据
	 */
	public void updateGasCouponDefinitionByPartnerId(String partnerId,GasCouponDefinitionDO gasCouponDefinitionDO) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasCouponDefinitionDAO.updateByExample(gasCouponDefinitionDO, exam);
	}

    /**
	 * 根据definitionId更新gas_coupon_definition表数据
	 */
	public void updateGasCouponDefinitionByDefinitionId(String definitionId,GasCouponDefinitionDO gasCouponDefinitionDO) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		gasCouponDefinitionDAO.updateByExample(gasCouponDefinitionDO, exam);
	}

	/**
	* 根据name更新gas_coupon_definition表数据
	*/
	public void updateGasCouponDefinitionByName(String name,GasCouponDefinitionDO gasCouponDefinitionDO) {
		GasCouponDefinitionDOExample exam = new GasCouponDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasCouponDefinitionDAO.updateByExample(gasCouponDefinitionDO, exam);
	}

    /**
	 * 断言gas_goods表
	 */
	public void gasGoodsAssert(
	        GasGoodsDO gasGoodsDO,
			Long id, 
			String goodsType, 
			String goodsGroupType, 
			Long groupId, 
			String goodsName, 
			String goodsCode, 
			Integer orderNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasGoodsDO.getId());
        assertEquals(goodsType, gasGoodsDO.getGoodsType());
        assertEquals(goodsGroupType, gasGoodsDO.getGoodsGroupType());
        assertEquals(groupId, gasGoodsDO.getGroupId());
        assertEquals(goodsName, gasGoodsDO.getGoodsName());
        assertEquals(goodsCode, gasGoodsDO.getGoodsCode());
        assertEquals(orderNo, gasGoodsDO.getOrderNo());
        assertEquals(rawAddTime, gasGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_goods表数据
	 */
	public void assertGasGoods(GasGoodsDO expect, GasGoodsDO gasGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasGoodsDO);
	}

    /**
	 * 插入gas_goods表数据
	 */
	public void insertGasGoods(GasGoodsDO gasGoodsDO) {
		gasGoodsDAO.insert(gasGoodsDO);
	}

    /**
	 * 插入gas_goods表数据
	 */
	public void insertGasGoods(
			Long id, 
			String goodsType, 
			String goodsGroupType, 
			Long groupId, 
			String goodsName, 
			String goodsCode, 
			Integer orderNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasGoodsDO gasGoodsDO = new GasGoodsDO();
		gasGoodsDO.setId(id);
		gasGoodsDO.setGoodsType(goodsType);
		gasGoodsDO.setGoodsGroupType(goodsGroupType);
		gasGoodsDO.setGroupId(groupId);
		gasGoodsDO.setGoodsName(goodsName);
		gasGoodsDO.setGoodsCode(goodsCode);
		gasGoodsDO.setOrderNo(orderNo);
		gasGoodsDO.setRawAddTime(rawAddTime);
		gasGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasGoodsDAO.insert(gasGoodsDO);
	}

    /**
     * 删除gas_goods表所有数据
     */
    public void cleanGasGoods() {
        GasGoodsDOExample exam = new GasGoodsDOExample();
        exam.createCriteria();
        gasGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_goods表数据
	 */
	public void cleanGasGoodsById(Long id) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupId删除gas_goods表数据
	 */
	public void cleanGasGoodsByGroupId(Long groupId) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_goods表数据
	*/
	public void cleanGasGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_goods表数据
	*/
	public void cleanGasGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_goods表数据
	 */
	public void cleanGasGoodsByOrderNo(Integer orderNo) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_goods表所有数据
     */
    public List<GasGoodsDO> findGasGoodsAll() {
        GasGoodsDOExample exam = new GasGoodsDOExample();
        exam.createCriteria();
		return gasGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsById(Long id) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据groupId查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsByGroupId(Long groupId) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		return gasGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByGoodsName(String goodsName) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByGoodsCode(String goodsCode) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsByOrderNo(Integer orderNo) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_goods表数据
	 */
	public void updateGasGoodsById(Long id,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

    /**
	 * 根据groupId更新gas_goods表数据
	 */
	public void updateGasGoodsByGroupId(Long groupId,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_goods表数据
	*/
	public void updateGasGoodsByGoodsName(String goodsName,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

	/**
	* 根据goodsCode更新gas_goods表数据
	*/
	public void updateGasGoodsByGoodsCode(String goodsCode,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

    /**
	 * 根据orderNo更新gas_goods表数据
	 */
	public void updateGasGoodsByOrderNo(Integer orderNo,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

    /**
	 * 断言gas_grade_user表
	 */
	public void gasGradeUserAssert(
	        GasGradeUserDO gasGradeUserDO,
			Long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String nickName, 
			String realName, 
			String certNo, 
			String changeType, 
			String headImgUrl, 
			String carNumber, 
			String sex, 
			String memberType, 
			String grade, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasGradeUserDO.getId());
        assertEquals(userId, gasGradeUserDO.getUserId());
        assertEquals(partnerId, gasGradeUserDO.getPartnerId());
        assertEquals(mobile, gasGradeUserDO.getMobile());
        assertEquals(birthday, gasGradeUserDO.getBirthday());
        assertEquals(nickName, gasGradeUserDO.getNickName());
        assertEquals(realName, gasGradeUserDO.getRealName());
        assertEquals(certNo, gasGradeUserDO.getCertNo());
        assertEquals(changeType, gasGradeUserDO.getChangeType());
        assertEquals(headImgUrl, gasGradeUserDO.getHeadImgUrl());
        assertEquals(carNumber, gasGradeUserDO.getCarNumber());
        assertEquals(sex, gasGradeUserDO.getSex());
        assertEquals(memberType, gasGradeUserDO.getMemberType());
        assertEquals(grade, gasGradeUserDO.getGrade());
        assertEquals(createTime, gasGradeUserDO.getCreateTime());
        assertEquals(updateTime, gasGradeUserDO.getUpdateTime());
        assertEquals(rawAddTime, gasGradeUserDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasGradeUserDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_grade_user表数据
	 */
	public void assertGasGradeUser(GasGradeUserDO expect, GasGradeUserDO gasGradeUserDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasGradeUserDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasGradeUserDO.getRawAddTime());
		expect.setRawAddTime(gasGradeUserDO.getRawAddTime());
        Assertions.assertTrue(null != gasGradeUserDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasGradeUserDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasGradeUserDO);
	}

    /**
	 * 插入gas_grade_user表数据
	 */
	public void insertGasGradeUser(GasGradeUserDO gasGradeUserDO) {
		gasGradeUserDAO.insert(gasGradeUserDO);
	}

    /**
	 * 插入gas_grade_user表数据
	 */
	public void insertGasGradeUser(
			Long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String nickName, 
			String realName, 
			String certNo, 
			String changeType, 
			String headImgUrl, 
			String carNumber, 
			String sex, 
			String memberType, 
			String grade, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasGradeUserDO gasGradeUserDO = new GasGradeUserDO();
		gasGradeUserDO.setId(id);
		gasGradeUserDO.setUserId(userId);
		gasGradeUserDO.setPartnerId(partnerId);
		gasGradeUserDO.setMobile(mobile);
		gasGradeUserDO.setBirthday(birthday);
		gasGradeUserDO.setNickName(nickName);
		gasGradeUserDO.setRealName(realName);
		gasGradeUserDO.setCertNo(certNo);
		gasGradeUserDO.setChangeType(changeType);
		gasGradeUserDO.setHeadImgUrl(headImgUrl);
		gasGradeUserDO.setCarNumber(carNumber);
		gasGradeUserDO.setSex(sex);
		gasGradeUserDO.setMemberType(memberType);
		gasGradeUserDO.setGrade(grade);
		gasGradeUserDO.setCreateTime(createTime);
		gasGradeUserDO.setUpdateTime(updateTime);
		gasGradeUserDO.setRawAddTime(rawAddTime);
		gasGradeUserDO.setRawUpdateTime(rawUpdateTime);
		gasGradeUserDAO.insert(gasGradeUserDO);
	}

    /**
     * 删除gas_grade_user表所有数据
     */
    public void cleanGasGradeUser() {
        GasGradeUserDOExample exam = new GasGradeUserDOExample();
        exam.createCriteria();
        gasGradeUserDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_grade_user表数据
	 */
	public void cleanGasGradeUserById(Long id) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGradeUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_grade_user表数据
	 */
	public void cleanGasGradeUserByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasGradeUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_grade_user表数据
	 */
	public void cleanGasGradeUserByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasGradeUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_grade_user表数据
	 */
	public void cleanGasGradeUserByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasGradeUserDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_grade_user表数据
	*/
	public void cleanGasGradeUserByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasGradeUserDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_grade_user表数据
	*/
	public void cleanGasGradeUserByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasGradeUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除gas_grade_user表数据
	 */
	public void cleanGasGradeUserByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasGradeUserDAO.deleteByExample(exam);
	}

	/**
	* 根据carNumber删除gas_grade_user表数据
	*/
	public void cleanGasGradeUserByCarNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)){
            carNumber = "test_carNumber";
        }
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		gasGradeUserDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_grade_user表所有数据
     */
    public List<GasGradeUserDO> findGasGradeUserAll() {
        GasGradeUserDOExample exam = new GasGradeUserDOExample();
        exam.createCriteria();
		return gasGradeUserDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_grade_user表数据
	 */
	public List<GasGradeUserDO> findGasGradeUserById(Long id) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasGradeUserDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_grade_user表数据
	 */
	public List<GasGradeUserDO> findGasGradeUserByUserId(String userId) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasGradeUserDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_grade_user表数据
	 */
	public List<GasGradeUserDO> findGasGradeUserByPartnerId(String partnerId) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasGradeUserDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_grade_user表数据
	 */
	public List<GasGradeUserDO> findGasGradeUserByMobile(String mobile) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasGradeUserDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_grade_user表数据
	*/
	public List<GasGradeUserDO> findGasGradeUserByNickName(String nickName) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasGradeUserDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_grade_user表数据
	*/
	public List<GasGradeUserDO> findGasGradeUserByRealName(String realName) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasGradeUserDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询gas_grade_user表数据
	 */
	public List<GasGradeUserDO> findGasGradeUserByCertNo(String certNo) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return gasGradeUserDAO.selectByExample(exam);
	}

	/**
	* 根据carNumber查询gas_grade_user表数据
	*/
	public List<GasGradeUserDO> findGasGradeUserByCarNumber(String carNumber) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		return gasGradeUserDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_grade_user表数据
	 */
	public void updateGasGradeUserById(Long id,GasGradeUserDO gasGradeUserDO) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGradeUserDAO.updateByExample(gasGradeUserDO, exam);
	}

    /**
	 * 根据userId更新gas_grade_user表数据
	 */
	public void updateGasGradeUserByUserId(String userId,GasGradeUserDO gasGradeUserDO) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasGradeUserDAO.updateByExample(gasGradeUserDO, exam);
	}

    /**
	 * 根据partnerId更新gas_grade_user表数据
	 */
	public void updateGasGradeUserByPartnerId(String partnerId,GasGradeUserDO gasGradeUserDO) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasGradeUserDAO.updateByExample(gasGradeUserDO, exam);
	}

    /**
	 * 根据mobile更新gas_grade_user表数据
	 */
	public void updateGasGradeUserByMobile(String mobile,GasGradeUserDO gasGradeUserDO) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasGradeUserDAO.updateByExample(gasGradeUserDO, exam);
	}

	/**
	* 根据nickName更新gas_grade_user表数据
	*/
	public void updateGasGradeUserByNickName(String nickName,GasGradeUserDO gasGradeUserDO) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasGradeUserDAO.updateByExample(gasGradeUserDO, exam);
	}

	/**
	* 根据realName更新gas_grade_user表数据
	*/
	public void updateGasGradeUserByRealName(String realName,GasGradeUserDO gasGradeUserDO) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasGradeUserDAO.updateByExample(gasGradeUserDO, exam);
	}

    /**
	 * 根据certNo更新gas_grade_user表数据
	 */
	public void updateGasGradeUserByCertNo(String certNo,GasGradeUserDO gasGradeUserDO) {
		GasGradeUserDOExample exam = new GasGradeUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasGradeUserDAO.updateByExample(gasGradeUserDO, exam);
	}

    /**
	 * 断言gas_market_campaign_detail表
	 */
	public void gasMarketCampaignDetailAssert(
	        GasMarketCampaignDetailDO gasMarketCampaignDetailDO,
			Long id, 
			String gid, 
			String partnerId, 
			String partnerName, 
			String bizNo, 
			String groupNo, 
			String groupName, 
			String campaignNo, 
			String campaignName, 
			Date joinTime, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String memo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMarketCampaignDetailDO.getId());
        assertEquals(gid, gasMarketCampaignDetailDO.getGid());
        assertEquals(partnerId, gasMarketCampaignDetailDO.getPartnerId());
        assertEquals(partnerName, gasMarketCampaignDetailDO.getPartnerName());
        assertEquals(bizNo, gasMarketCampaignDetailDO.getBizNo());
        assertEquals(groupNo, gasMarketCampaignDetailDO.getGroupNo());
        assertEquals(groupName, gasMarketCampaignDetailDO.getGroupName());
        assertEquals(campaignNo, gasMarketCampaignDetailDO.getCampaignNo());
        assertEquals(campaignName, gasMarketCampaignDetailDO.getCampaignName());
        assertEquals(joinTime, gasMarketCampaignDetailDO.getJoinTime());
        assertEquals(userId, gasMarketCampaignDetailDO.getUserId());
        assertEquals(realName, gasMarketCampaignDetailDO.getRealName());
        assertEquals(nickName, gasMarketCampaignDetailDO.getNickName());
        assertEquals(memberType, gasMarketCampaignDetailDO.getMemberType());
        assertEquals(mobile, gasMarketCampaignDetailDO.getMobile());
        assertEquals(stationId, gasMarketCampaignDetailDO.getStationId());
        assertEquals(stationCode, gasMarketCampaignDetailDO.getStationCode());
        assertEquals(stationName, gasMarketCampaignDetailDO.getStationName());
        assertEquals(operateId, gasMarketCampaignDetailDO.getOperateId());
        assertEquals(operateName, gasMarketCampaignDetailDO.getOperateName());
        assertEquals(terminalType, gasMarketCampaignDetailDO.getTerminalType());
        assertEquals(terminalCode, gasMarketCampaignDetailDO.getTerminalCode());
        assertEquals(memo, gasMarketCampaignDetailDO.getMemo());
        assertEquals(status, gasMarketCampaignDetailDO.getStatus());
        assertEquals(rawAddTime, gasMarketCampaignDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMarketCampaignDetailDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_market_campaign_detail表数据
	 */
	public void assertGasMarketCampaignDetail(GasMarketCampaignDetailDO expect, GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMarketCampaignDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMarketCampaignDetailDO.getRawAddTime());
		expect.setRawAddTime(gasMarketCampaignDetailDO.getRawAddTime());
        Assertions.assertTrue(null != gasMarketCampaignDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMarketCampaignDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMarketCampaignDetailDO);
	}

    /**
	 * 插入gas_market_campaign_detail表数据
	 */
	public void insertGasMarketCampaignDetail(GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		gasMarketCampaignDetailDAO.insert(gasMarketCampaignDetailDO);
	}

    /**
	 * 插入gas_market_campaign_detail表数据
	 */
	public void insertGasMarketCampaignDetail(
			Long id, 
			String gid, 
			String partnerId, 
			String partnerName, 
			String bizNo, 
			String groupNo, 
			String groupName, 
			String campaignNo, 
			String campaignName, 
			Date joinTime, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String memo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMarketCampaignDetailDO gasMarketCampaignDetailDO = new GasMarketCampaignDetailDO();
		gasMarketCampaignDetailDO.setId(id);
		gasMarketCampaignDetailDO.setGid(gid);
		gasMarketCampaignDetailDO.setPartnerId(partnerId);
		gasMarketCampaignDetailDO.setPartnerName(partnerName);
		gasMarketCampaignDetailDO.setBizNo(bizNo);
		gasMarketCampaignDetailDO.setGroupNo(groupNo);
		gasMarketCampaignDetailDO.setGroupName(groupName);
		gasMarketCampaignDetailDO.setCampaignNo(campaignNo);
		gasMarketCampaignDetailDO.setCampaignName(campaignName);
		gasMarketCampaignDetailDO.setJoinTime(joinTime);
		gasMarketCampaignDetailDO.setUserId(userId);
		gasMarketCampaignDetailDO.setRealName(realName);
		gasMarketCampaignDetailDO.setNickName(nickName);
		gasMarketCampaignDetailDO.setMemberType(memberType);
		gasMarketCampaignDetailDO.setMobile(mobile);
		gasMarketCampaignDetailDO.setStationId(stationId);
		gasMarketCampaignDetailDO.setStationCode(stationCode);
		gasMarketCampaignDetailDO.setStationName(stationName);
		gasMarketCampaignDetailDO.setOperateId(operateId);
		gasMarketCampaignDetailDO.setOperateName(operateName);
		gasMarketCampaignDetailDO.setTerminalType(terminalType);
		gasMarketCampaignDetailDO.setTerminalCode(terminalCode);
		gasMarketCampaignDetailDO.setMemo(memo);
		gasMarketCampaignDetailDO.setStatus(status);
		gasMarketCampaignDetailDO.setRawAddTime(rawAddTime);
		gasMarketCampaignDetailDO.setRawUpdateTime(rawUpdateTime);
		gasMarketCampaignDetailDAO.insert(gasMarketCampaignDetailDO);
	}

    /**
     * 删除gas_market_campaign_detail表所有数据
     */
    public void cleanGasMarketCampaignDetail() {
        GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
        exam.createCriteria();
        gasMarketCampaignDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailById(Long id) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupNo删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByGroupNo(String groupNo) {
        if (StringUtils.isBlank(groupNo)){
            groupNo = "test_groupNo";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据campaignName删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByCampaignName(String campaignName) {
        if (StringUtils.isBlank(campaignName)){
            campaignName = "test_campaignName";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_market_campaign_detail表数据
	 */
	public void cleanGasMarketCampaignDetailByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_market_campaign_detail表数据
	*/
	public void cleanGasMarketCampaignDetailByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasMarketCampaignDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_market_campaign_detail表所有数据
     */
    public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailAll() {
        GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
        exam.createCriteria();
		return gasMarketCampaignDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailById(Long id) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByGid(String gid) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByPartnerId(String partnerId) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByPartnerName(String partnerName) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByBizNo(String bizNo) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据groupNo查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByGroupNo(String groupNo) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByGroupName(String groupName) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByCampaignNo(String campaignNo) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据campaignName查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByCampaignName(String campaignName) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByUserId(String userId) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByRealName(String realName) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByNickName(String nickName) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByMobile(String mobile) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByStationId(String stationId) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByStationCode(String stationCode) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByStationName(String stationName) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_market_campaign_detail表数据
	 */
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByOperateId(String operateId) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByOperateName(String operateName) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_market_campaign_detail表数据
	*/
	public List<GasMarketCampaignDetailDO> findGasMarketCampaignDetailByTerminalCode(String terminalCode) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasMarketCampaignDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailById(Long id,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据gid更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByGid(String gid,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据partnerId更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByPartnerId(String partnerId,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据partnerName更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByPartnerName(String partnerName,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据bizNo更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByBizNo(String bizNo,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据groupNo更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByGroupNo(String groupNo,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据groupName更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByGroupName(String groupName,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据campaignNo更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByCampaignNo(String campaignNo,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据campaignName更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByCampaignName(String campaignName,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据userId更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByUserId(String userId,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据realName更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByRealName(String realName,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据nickName更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByNickName(String nickName,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据mobile更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByMobile(String mobile,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据stationId更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByStationId(String stationId,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据stationCode更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByStationCode(String stationCode,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据stationName更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByStationName(String stationName,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 根据operateId更新gas_market_campaign_detail表数据
	 */
	public void updateGasMarketCampaignDetailByOperateId(String operateId,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据operateName更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByOperateName(String operateName,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

	/**
	* 根据terminalCode更新gas_market_campaign_detail表数据
	*/
	public void updateGasMarketCampaignDetailByTerminalCode(String terminalCode,GasMarketCampaignDetailDO gasMarketCampaignDetailDO) {
		GasMarketCampaignDetailDOExample exam = new GasMarketCampaignDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasMarketCampaignDetailDAO.updateByExample(gasMarketCampaignDetailDO, exam);
	}

    /**
	 * 断言gas_market_give表
	 */
	public void gasMarketGiveAssert(
	        GasMarketGiveDO gasMarketGiveDO,
			Long id, 
			String gid, 
			String partnerId, 
			String partnerName, 
			String sourceType, 
			String giveType, 
			String givePersonType, 
			String bizNo, 
			String campaignNo, 
			String campaignName, 
			Long ruleId, 
			String definitionId, 
			String definitionName, 
			Long favourAmount, 
			Long giveNum, 
			Date giveTime, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String memo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMarketGiveDO.getId());
        assertEquals(gid, gasMarketGiveDO.getGid());
        assertEquals(partnerId, gasMarketGiveDO.getPartnerId());
        assertEquals(partnerName, gasMarketGiveDO.getPartnerName());
        assertEquals(sourceType, gasMarketGiveDO.getSourceType());
        assertEquals(giveType, gasMarketGiveDO.getGiveType());
        assertEquals(givePersonType, gasMarketGiveDO.getGivePersonType());
        assertEquals(bizNo, gasMarketGiveDO.getBizNo());
        assertEquals(campaignNo, gasMarketGiveDO.getCampaignNo());
        assertEquals(campaignName, gasMarketGiveDO.getCampaignName());
        assertEquals(ruleId, gasMarketGiveDO.getRuleId());
        assertEquals(definitionId, gasMarketGiveDO.getDefinitionId());
        assertEquals(definitionName, gasMarketGiveDO.getDefinitionName());
        assertEquals(favourAmount, gasMarketGiveDO.getFavourAmount());
        assertEquals(giveNum, gasMarketGiveDO.getGiveNum());
        assertEquals(giveTime, gasMarketGiveDO.getGiveTime());
        assertEquals(userId, gasMarketGiveDO.getUserId());
        assertEquals(realName, gasMarketGiveDO.getRealName());
        assertEquals(nickName, gasMarketGiveDO.getNickName());
        assertEquals(memberType, gasMarketGiveDO.getMemberType());
        assertEquals(mobile, gasMarketGiveDO.getMobile());
        assertEquals(stationId, gasMarketGiveDO.getStationId());
        assertEquals(stationCode, gasMarketGiveDO.getStationCode());
        assertEquals(stationName, gasMarketGiveDO.getStationName());
        assertEquals(operateId, gasMarketGiveDO.getOperateId());
        assertEquals(operateName, gasMarketGiveDO.getOperateName());
        assertEquals(terminalType, gasMarketGiveDO.getTerminalType());
        assertEquals(terminalCode, gasMarketGiveDO.getTerminalCode());
        assertEquals(memo, gasMarketGiveDO.getMemo());
        assertEquals(status, gasMarketGiveDO.getStatus());
        assertEquals(rawAddTime, gasMarketGiveDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMarketGiveDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_market_give表数据
	 */
	public void assertGasMarketGive(GasMarketGiveDO expect, GasMarketGiveDO gasMarketGiveDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMarketGiveDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMarketGiveDO.getRawAddTime());
		expect.setRawAddTime(gasMarketGiveDO.getRawAddTime());
        Assertions.assertTrue(null != gasMarketGiveDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMarketGiveDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMarketGiveDO);
	}

    /**
	 * 插入gas_market_give表数据
	 */
	public void insertGasMarketGive(GasMarketGiveDO gasMarketGiveDO) {
		gasMarketGiveDAO.insert(gasMarketGiveDO);
	}

    /**
	 * 插入gas_market_give表数据
	 */
	public void insertGasMarketGive(
			Long id, 
			String gid, 
			String partnerId, 
			String partnerName, 
			String sourceType, 
			String giveType, 
			String givePersonType, 
			String bizNo, 
			String campaignNo, 
			String campaignName, 
			Long ruleId, 
			String definitionId, 
			String definitionName, 
			Long favourAmount, 
			Long giveNum, 
			Date giveTime, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String memo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMarketGiveDO gasMarketGiveDO = new GasMarketGiveDO();
		gasMarketGiveDO.setId(id);
		gasMarketGiveDO.setGid(gid);
		gasMarketGiveDO.setPartnerId(partnerId);
		gasMarketGiveDO.setPartnerName(partnerName);
		gasMarketGiveDO.setSourceType(sourceType);
		gasMarketGiveDO.setGiveType(giveType);
		gasMarketGiveDO.setGivePersonType(givePersonType);
		gasMarketGiveDO.setBizNo(bizNo);
		gasMarketGiveDO.setCampaignNo(campaignNo);
		gasMarketGiveDO.setCampaignName(campaignName);
		gasMarketGiveDO.setRuleId(ruleId);
		gasMarketGiveDO.setDefinitionId(definitionId);
		gasMarketGiveDO.setDefinitionName(definitionName);
		gasMarketGiveDO.setFavourAmount(favourAmount);
		gasMarketGiveDO.setGiveNum(giveNum);
		gasMarketGiveDO.setGiveTime(giveTime);
		gasMarketGiveDO.setUserId(userId);
		gasMarketGiveDO.setRealName(realName);
		gasMarketGiveDO.setNickName(nickName);
		gasMarketGiveDO.setMemberType(memberType);
		gasMarketGiveDO.setMobile(mobile);
		gasMarketGiveDO.setStationId(stationId);
		gasMarketGiveDO.setStationCode(stationCode);
		gasMarketGiveDO.setStationName(stationName);
		gasMarketGiveDO.setOperateId(operateId);
		gasMarketGiveDO.setOperateName(operateName);
		gasMarketGiveDO.setTerminalType(terminalType);
		gasMarketGiveDO.setTerminalCode(terminalCode);
		gasMarketGiveDO.setMemo(memo);
		gasMarketGiveDO.setStatus(status);
		gasMarketGiveDO.setRawAddTime(rawAddTime);
		gasMarketGiveDO.setRawUpdateTime(rawUpdateTime);
		gasMarketGiveDAO.insert(gasMarketGiveDO);
	}

    /**
     * 删除gas_market_give表所有数据
     */
    public void cleanGasMarketGive() {
        GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
        exam.createCriteria();
        gasMarketGiveDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveById(Long id) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据campaignName删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByCampaignName(String campaignName) {
        if (StringUtils.isBlank(campaignName)){
            campaignName = "test_campaignName";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByRuleId(Long ruleId) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据definitionName删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByDefinitionName(String definitionName) {
        if (StringUtils.isBlank(definitionName)){
            definitionName = "test_definitionName";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andDefinitionNameEqualTo(definitionName);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_market_give表数据
	 */
	public void cleanGasMarketGiveByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasMarketGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_market_give表数据
	*/
	public void cleanGasMarketGiveByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasMarketGiveDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_market_give表所有数据
     */
    public List<GasMarketGiveDO> findGasMarketGiveAll() {
        GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
        exam.createCriteria();
		return gasMarketGiveDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveById(Long id) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByGid(String gid) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByPartnerId(String partnerId) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByPartnerName(String partnerName) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByBizNo(String bizNo) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByCampaignNo(String campaignNo) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据campaignName查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByCampaignName(String campaignName) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByRuleId(Long ruleId) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByDefinitionId(String definitionId) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据definitionName查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByDefinitionName(String definitionName) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andDefinitionNameEqualTo(definitionName);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByUserId(String userId) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByRealName(String realName) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByNickName(String nickName) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByMobile(String mobile) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByStationId(String stationId) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByStationCode(String stationCode) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByStationName(String stationName) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_market_give表数据
	 */
	public List<GasMarketGiveDO> findGasMarketGiveByOperateId(String operateId) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByOperateName(String operateName) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasMarketGiveDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_market_give表数据
	*/
	public List<GasMarketGiveDO> findGasMarketGiveByTerminalCode(String terminalCode) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasMarketGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_market_give表数据
	 */
	public void updateGasMarketGiveById(Long id,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据gid更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByGid(String gid,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据partnerId更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByPartnerId(String partnerId,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据partnerName更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByPartnerName(String partnerName,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据bizNo更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByBizNo(String bizNo,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据campaignNo更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByCampaignNo(String campaignNo,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据campaignName更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByCampaignName(String campaignName,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据ruleId更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByRuleId(Long ruleId,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据definitionId更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByDefinitionId(String definitionId,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据definitionName更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByDefinitionName(String definitionName,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andDefinitionNameEqualTo(definitionName);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据userId更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByUserId(String userId,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据realName更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByRealName(String realName,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据nickName更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByNickName(String nickName,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据mobile更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByMobile(String mobile,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据stationId更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByStationId(String stationId,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据stationCode更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByStationCode(String stationCode,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据stationName更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByStationName(String stationName,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 根据operateId更新gas_market_give表数据
	 */
	public void updateGasMarketGiveByOperateId(String operateId,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据operateName更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByOperateName(String operateName,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

	/**
	* 根据terminalCode更新gas_market_give表数据
	*/
	public void updateGasMarketGiveByTerminalCode(String terminalCode,GasMarketGiveDO gasMarketGiveDO) {
		GasMarketGiveDOExample exam = new GasMarketGiveDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasMarketGiveDAO.updateByExample(gasMarketGiveDO, exam);
	}

    /**
	 * 断言gas_market_precise_detail表
	 */
	public void gasMarketPreciseDetailAssert(
	        GasMarketPreciseDetailDO gasMarketPreciseDetailDO,
			Long id, 
			String partnerId, 
			String partnerName, 
			String giveId, 
			Date lastGiveTime, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String giveJson
	) {
        assertEquals(id, gasMarketPreciseDetailDO.getId());
        assertEquals(partnerId, gasMarketPreciseDetailDO.getPartnerId());
        assertEquals(partnerName, gasMarketPreciseDetailDO.getPartnerName());
        assertEquals(giveId, gasMarketPreciseDetailDO.getGiveId());
        assertEquals(lastGiveTime, gasMarketPreciseDetailDO.getLastGiveTime());
        assertEquals(userId, gasMarketPreciseDetailDO.getUserId());
        assertEquals(realName, gasMarketPreciseDetailDO.getRealName());
        assertEquals(nickName, gasMarketPreciseDetailDO.getNickName());
        assertEquals(memberType, gasMarketPreciseDetailDO.getMemberType());
        assertEquals(mobile, gasMarketPreciseDetailDO.getMobile());
        assertEquals(memo, gasMarketPreciseDetailDO.getMemo());
        assertEquals(rawAddTime, gasMarketPreciseDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMarketPreciseDetailDO.getRawUpdateTime());
        assertEquals(giveJson, gasMarketPreciseDetailDO.getGiveJson());
	}

	/**
	 * 断言gas_market_precise_detail表数据
	 */
	public void assertGasMarketPreciseDetail(GasMarketPreciseDetailDO expect, GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMarketPreciseDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMarketPreciseDetailDO.getRawAddTime());
		expect.setRawAddTime(gasMarketPreciseDetailDO.getRawAddTime());
        Assertions.assertTrue(null != gasMarketPreciseDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMarketPreciseDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMarketPreciseDetailDO);
	}

    /**
	 * 插入gas_market_precise_detail表数据
	 */
	public void insertGasMarketPreciseDetail(GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		gasMarketPreciseDetailDAO.insert(gasMarketPreciseDetailDO);
	}

    /**
	 * 插入gas_market_precise_detail表数据
	 */
	public void insertGasMarketPreciseDetail(
			Long id, 
			String partnerId, 
			String partnerName, 
			String giveId, 
			Date lastGiveTime, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String giveJson
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMarketPreciseDetailDO gasMarketPreciseDetailDO = new GasMarketPreciseDetailDO();
		gasMarketPreciseDetailDO.setId(id);
		gasMarketPreciseDetailDO.setPartnerId(partnerId);
		gasMarketPreciseDetailDO.setPartnerName(partnerName);
		gasMarketPreciseDetailDO.setGiveId(giveId);
		gasMarketPreciseDetailDO.setLastGiveTime(lastGiveTime);
		gasMarketPreciseDetailDO.setUserId(userId);
		gasMarketPreciseDetailDO.setRealName(realName);
		gasMarketPreciseDetailDO.setNickName(nickName);
		gasMarketPreciseDetailDO.setMemberType(memberType);
		gasMarketPreciseDetailDO.setMobile(mobile);
		gasMarketPreciseDetailDO.setMemo(memo);
		gasMarketPreciseDetailDO.setRawAddTime(rawAddTime);
		gasMarketPreciseDetailDO.setRawUpdateTime(rawUpdateTime);
		gasMarketPreciseDetailDO.setGiveJson(giveJson);
		gasMarketPreciseDetailDAO.insert(gasMarketPreciseDetailDO);
	}

    /**
     * 删除gas_market_precise_detail表所有数据
     */
    public void cleanGasMarketPreciseDetail() {
        GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
        exam.createCriteria();
        gasMarketPreciseDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_market_precise_detail表数据
	 */
	public void cleanGasMarketPreciseDetailById(Long id) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_market_precise_detail表数据
	 */
	public void cleanGasMarketPreciseDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_market_precise_detail表数据
	*/
	public void cleanGasMarketPreciseDetailByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据giveId删除gas_market_precise_detail表数据
	 */
	public void cleanGasMarketPreciseDetailByGiveId(String giveId) {
        if (StringUtils.isBlank(giveId)){
            giveId = "test_giveId";
        }
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andGiveIdEqualTo(giveId);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_market_precise_detail表数据
	 */
	public void cleanGasMarketPreciseDetailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_market_precise_detail表数据
	*/
	public void cleanGasMarketPreciseDetailByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_market_precise_detail表数据
	*/
	public void cleanGasMarketPreciseDetailByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_market_precise_detail表数据
	 */
	public void cleanGasMarketPreciseDetailByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasMarketPreciseDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_market_precise_detail表所有数据
     */
    public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailAll() {
        GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
        exam.createCriteria();
		return gasMarketPreciseDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_market_precise_detail表数据
	 */
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailById(Long id) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_market_precise_detail表数据
	 */
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailByPartnerId(String partnerId) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_market_precise_detail表数据
	*/
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailByPartnerName(String partnerName) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据giveId查询gas_market_precise_detail表数据
	 */
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailByGiveId(String giveId) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andGiveIdEqualTo(giveId);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_market_precise_detail表数据
	 */
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailByUserId(String userId) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_market_precise_detail表数据
	*/
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailByRealName(String realName) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_market_precise_detail表数据
	*/
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailByNickName(String nickName) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_market_precise_detail表数据
	 */
	public List<GasMarketPreciseDetailDO> findGasMarketPreciseDetailByMobile(String mobile) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasMarketPreciseDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_market_precise_detail表数据
	 */
	public void updateGasMarketPreciseDetailById(Long id,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

    /**
	 * 根据partnerId更新gas_market_precise_detail表数据
	 */
	public void updateGasMarketPreciseDetailByPartnerId(String partnerId,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

	/**
	* 根据partnerName更新gas_market_precise_detail表数据
	*/
	public void updateGasMarketPreciseDetailByPartnerName(String partnerName,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

    /**
	 * 根据giveId更新gas_market_precise_detail表数据
	 */
	public void updateGasMarketPreciseDetailByGiveId(String giveId,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andGiveIdEqualTo(giveId);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

    /**
	 * 根据userId更新gas_market_precise_detail表数据
	 */
	public void updateGasMarketPreciseDetailByUserId(String userId,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

	/**
	* 根据realName更新gas_market_precise_detail表数据
	*/
	public void updateGasMarketPreciseDetailByRealName(String realName,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

	/**
	* 根据nickName更新gas_market_precise_detail表数据
	*/
	public void updateGasMarketPreciseDetailByNickName(String nickName,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

    /**
	 * 根据mobile更新gas_market_precise_detail表数据
	 */
	public void updateGasMarketPreciseDetailByMobile(String mobile,GasMarketPreciseDetailDO gasMarketPreciseDetailDO) {
		GasMarketPreciseDetailDOExample exam = new GasMarketPreciseDetailDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasMarketPreciseDetailDAO.updateByExample(gasMarketPreciseDetailDO, exam);
	}

    /**
	 * 断言gas_merchant表
	 */
	public void gasMerchantAssert(
	        GasMerchantDO gasMerchantDO,
			Long id, 
			String partnerId, 
			String partnerName, 
			String shortName, 
			String mobileNo, 
			String email, 
			String accountNo, 
			String marketAccountNo, 
			String status, 
			String headImgUrl, 
			Date queryDepth, 
			String collectionModel, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDO.getId());
        assertEquals(partnerId, gasMerchantDO.getPartnerId());
        assertEquals(partnerName, gasMerchantDO.getPartnerName());
        assertEquals(shortName, gasMerchantDO.getShortName());
        assertEquals(mobileNo, gasMerchantDO.getMobileNo());
        assertEquals(email, gasMerchantDO.getEmail());
        assertEquals(accountNo, gasMerchantDO.getAccountNo());
        assertEquals(marketAccountNo, gasMerchantDO.getMarketAccountNo());
        assertEquals(status, gasMerchantDO.getStatus());
        assertEquals(headImgUrl, gasMerchantDO.getHeadImgUrl());
        assertEquals(queryDepth, gasMerchantDO.getQueryDepth());
        assertEquals(collectionModel, gasMerchantDO.getCollectionModel());
        assertEquals(createTime, gasMerchantDO.getCreateTime());
        assertEquals(updateTime, gasMerchantDO.getUpdateTime());
        assertEquals(rawAddTime, gasMerchantDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant表数据
	 */
	public void assertGasMerchant(GasMerchantDO expect, GasMerchantDO gasMerchantDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantDO);
	}

    /**
	 * 插入gas_merchant表数据
	 */
	public void insertGasMerchant(GasMerchantDO gasMerchantDO) {
		gasMerchantDAO.insert(gasMerchantDO);
	}

    /**
	 * 插入gas_merchant表数据
	 */
	public void insertGasMerchant(
			Long id, 
			String partnerId, 
			String partnerName, 
			String shortName, 
			String mobileNo, 
			String email, 
			String accountNo, 
			String marketAccountNo, 
			String status, 
			String headImgUrl, 
			Date queryDepth, 
			String collectionModel, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantDO gasMerchantDO = new GasMerchantDO();
		gasMerchantDO.setId(id);
		gasMerchantDO.setPartnerId(partnerId);
		gasMerchantDO.setPartnerName(partnerName);
		gasMerchantDO.setShortName(shortName);
		gasMerchantDO.setMobileNo(mobileNo);
		gasMerchantDO.setEmail(email);
		gasMerchantDO.setAccountNo(accountNo);
		gasMerchantDO.setMarketAccountNo(marketAccountNo);
		gasMerchantDO.setStatus(status);
		gasMerchantDO.setHeadImgUrl(headImgUrl);
		gasMerchantDO.setQueryDepth(queryDepth);
		gasMerchantDO.setCollectionModel(collectionModel);
		gasMerchantDO.setCreateTime(createTime);
		gasMerchantDO.setUpdateTime(updateTime);
		gasMerchantDO.setRawAddTime(rawAddTime);
		gasMerchantDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantDAO.insert(gasMerchantDO);
	}

    /**
     * 删除gas_merchant表所有数据
     */
    public void cleanGasMerchant() {
        GasMerchantDOExample exam = new GasMerchantDOExample();
        exam.createCriteria();
        gasMerchantDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant表数据
	 */
	public void cleanGasMerchantById(Long id) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant表数据
	 */
	public void cleanGasMerchantByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_merchant表数据
	*/
	public void cleanGasMerchantByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	* 根据shortName删除gas_merchant表数据
	*/
	public void cleanGasMerchantByShortName(String shortName) {
        if (StringUtils.isBlank(shortName)){
            shortName = "test_shortName";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andShortNameEqualTo(shortName);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobileNo删除gas_merchant表数据
	 */
	public void cleanGasMerchantByMobileNo(String mobileNo) {
        if (StringUtils.isBlank(mobileNo)){
            mobileNo = "test_mobileNo";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除gas_merchant表数据
	 */
	public void cleanGasMerchantByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据marketAccountNo删除gas_merchant表数据
	 */
	public void cleanGasMerchantByMarketAccountNo(String marketAccountNo) {
        if (StringUtils.isBlank(marketAccountNo)){
            marketAccountNo = "test_marketAccountNo";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMarketAccountNoEqualTo(marketAccountNo);
		gasMerchantDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant表所有数据
     */
    public List<GasMerchantDO> findGasMerchantAll() {
        GasMerchantDOExample exam = new GasMerchantDOExample();
        exam.createCriteria();
		return gasMerchantDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantById(Long id) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByPartnerId(String partnerId) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_merchant表数据
	*/
	public List<GasMerchantDO> findGasMerchantByPartnerName(String partnerName) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasMerchantDAO.selectByExample(exam);
	}

	/**
	* 根据shortName查询gas_merchant表数据
	*/
	public List<GasMerchantDO> findGasMerchantByShortName(String shortName) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andShortNameEqualTo(shortName);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据mobileNo查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByMobileNo(String mobileNo) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByAccountNo(String accountNo) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据marketAccountNo查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByMarketAccountNo(String marketAccountNo) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMarketAccountNoEqualTo(marketAccountNo);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant表数据
	 */
	public void updateGasMerchantById(Long id,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant表数据
	 */
	public void updateGasMerchantByPartnerId(String partnerId,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

	/**
	* 根据partnerName更新gas_merchant表数据
	*/
	public void updateGasMerchantByPartnerName(String partnerName,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

	/**
	* 根据shortName更新gas_merchant表数据
	*/
	public void updateGasMerchantByShortName(String shortName,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andShortNameEqualTo(shortName);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据mobileNo更新gas_merchant表数据
	 */
	public void updateGasMerchantByMobileNo(String mobileNo,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据accountNo更新gas_merchant表数据
	 */
	public void updateGasMerchantByAccountNo(String accountNo,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据marketAccountNo更新gas_merchant表数据
	 */
	public void updateGasMerchantByMarketAccountNo(String marketAccountNo,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMarketAccountNoEqualTo(marketAccountNo);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 断言gas_merchant_goods表
	 */
	public void gasMerchantGoodsAssert(
	        GasMerchantGoodsDO gasMerchantGoodsDO,
			Long id, 
			String partnerId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			Long groupId, 
			Integer orderNo, 
			String status, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantGoodsDO.getId());
        assertEquals(partnerId, gasMerchantGoodsDO.getPartnerId());
        assertEquals(goodsName, gasMerchantGoodsDO.getGoodsName());
        assertEquals(goodsCode, gasMerchantGoodsDO.getGoodsCode());
        assertEquals(goodsType, gasMerchantGoodsDO.getGoodsType());
        assertEquals(groupId, gasMerchantGoodsDO.getGroupId());
        assertEquals(orderNo, gasMerchantGoodsDO.getOrderNo());
        assertEquals(status, gasMerchantGoodsDO.getStatus());
        assertEquals(createTime, gasMerchantGoodsDO.getCreateTime());
        assertEquals(updateTime, gasMerchantGoodsDO.getUpdateTime());
        assertEquals(rawAddTime, gasMerchantGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_goods表数据
	 */
	public void assertGasMerchantGoods(GasMerchantGoodsDO expect, GasMerchantGoodsDO gasMerchantGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantGoodsDO);
	}

    /**
	 * 插入gas_merchant_goods表数据
	 */
	public void insertGasMerchantGoods(GasMerchantGoodsDO gasMerchantGoodsDO) {
		gasMerchantGoodsDAO.insert(gasMerchantGoodsDO);
	}

    /**
	 * 插入gas_merchant_goods表数据
	 */
	public void insertGasMerchantGoods(
			Long id, 
			String partnerId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			Long groupId, 
			Integer orderNo, 
			String status, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantGoodsDO gasMerchantGoodsDO = new GasMerchantGoodsDO();
		gasMerchantGoodsDO.setId(id);
		gasMerchantGoodsDO.setPartnerId(partnerId);
		gasMerchantGoodsDO.setGoodsName(goodsName);
		gasMerchantGoodsDO.setGoodsCode(goodsCode);
		gasMerchantGoodsDO.setGoodsType(goodsType);
		gasMerchantGoodsDO.setGroupId(groupId);
		gasMerchantGoodsDO.setOrderNo(orderNo);
		gasMerchantGoodsDO.setStatus(status);
		gasMerchantGoodsDO.setCreateTime(createTime);
		gasMerchantGoodsDO.setUpdateTime(updateTime);
		gasMerchantGoodsDO.setRawAddTime(rawAddTime);
		gasMerchantGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantGoodsDAO.insert(gasMerchantGoodsDO);
	}

    /**
     * 删除gas_merchant_goods表所有数据
     */
    public void cleanGasMerchantGoods() {
        GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
        exam.createCriteria();
        gasMerchantGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsById(Long id) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupId删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByGroupId(Long groupId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByOrderNo(Integer orderNo) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_goods表所有数据
     */
    public List<GasMerchantGoodsDO> findGasMerchantGoodsAll() {
        GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
        exam.createCriteria();
		return gasMerchantGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsById(Long id) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByPartnerId(String partnerId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByGoodsName(String goodsName) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByGoodsCode(String goodsCode) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据groupId查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByGroupId(Long groupId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByOrderNo(Integer orderNo) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsById(Long id,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByPartnerId(String partnerId,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByGoodsName(String goodsName,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

	/**
	* 根据goodsCode更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByGoodsCode(String goodsCode,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 根据groupId更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByGroupId(Long groupId,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 根据orderNo更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByOrderNo(Integer orderNo,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 断言gas_merchant_pay_way表
	 */
	public void gasMerchantPayWayAssert(
	        GasMerchantPayWayDO gasMerchantPayWayDO,
			Long id, 
			String partnerId, 
			String payWayCode, 
			String payWayName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantPayWayDO.getId());
        assertEquals(partnerId, gasMerchantPayWayDO.getPartnerId());
        assertEquals(payWayCode, gasMerchantPayWayDO.getPayWayCode());
        assertEquals(payWayName, gasMerchantPayWayDO.getPayWayName());
        assertEquals(rawAddTime, gasMerchantPayWayDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantPayWayDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_pay_way表数据
	 */
	public void assertGasMerchantPayWay(GasMerchantPayWayDO expect, GasMerchantPayWayDO gasMerchantPayWayDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantPayWayDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantPayWayDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantPayWayDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantPayWayDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantPayWayDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantPayWayDO);
	}

    /**
	 * 插入gas_merchant_pay_way表数据
	 */
	public void insertGasMerchantPayWay(GasMerchantPayWayDO gasMerchantPayWayDO) {
		gasMerchantPayWayDAO.insert(gasMerchantPayWayDO);
	}

    /**
	 * 插入gas_merchant_pay_way表数据
	 */
	public void insertGasMerchantPayWay(
			Long id, 
			String partnerId, 
			String payWayCode, 
			String payWayName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantPayWayDO gasMerchantPayWayDO = new GasMerchantPayWayDO();
		gasMerchantPayWayDO.setId(id);
		gasMerchantPayWayDO.setPartnerId(partnerId);
		gasMerchantPayWayDO.setPayWayCode(payWayCode);
		gasMerchantPayWayDO.setPayWayName(payWayName);
		gasMerchantPayWayDO.setRawAddTime(rawAddTime);
		gasMerchantPayWayDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantPayWayDAO.insert(gasMerchantPayWayDO);
	}

    /**
     * 删除gas_merchant_pay_way表所有数据
     */
    public void cleanGasMerchantPayWay() {
        GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
        exam.createCriteria();
        gasMerchantPayWayDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_pay_way表数据
	 */
	public void cleanGasMerchantPayWayById(Long id) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantPayWayDAO.deleteByExample(exam);
	}
	/**
	 * 根据partnerId,payWayCode删除gas_merchant_pay_way表数据
	 */
	public void cleanGasMerchantPayWayByPartnerIdAndPayWayCode(String partnerId,String payWayCode) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
        if (StringUtils.isBlank(payWayCode)){
            payWayCode = "test_payWayCode";
        }
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andPayWayCodeEqualTo(payWayCode);
		gasMerchantPayWayDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_pay_way表数据
	 */
	public void cleanGasMerchantPayWayByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantPayWayDAO.deleteByExample(exam);
	}

	/**
	* 根据payWayCode删除gas_merchant_pay_way表数据
	*/
	public void cleanGasMerchantPayWayByPayWayCode(String payWayCode) {
        if (StringUtils.isBlank(payWayCode)){
            payWayCode = "test_payWayCode";
        }
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPayWayCodeEqualTo(payWayCode);
		gasMerchantPayWayDAO.deleteByExample(exam);
	}

	/**
	* 根据payWayName删除gas_merchant_pay_way表数据
	*/
	public void cleanGasMerchantPayWayByPayWayName(String payWayName) {
        if (StringUtils.isBlank(payWayName)){
            payWayName = "test_payWayName";
        }
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPayWayNameEqualTo(payWayName);
		gasMerchantPayWayDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_pay_way表所有数据
     */
    public List<GasMerchantPayWayDO> findGasMerchantPayWayAll() {
        GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
        exam.createCriteria();
		return gasMerchantPayWayDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_pay_way表数据
	 */
	public List<GasMerchantPayWayDO> findGasMerchantPayWayById(Long id) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantPayWayDAO.selectByExample(exam);
	}

	/**
	 * 根据partnerId,payWayCode查询gas_merchant_pay_way表数据
	 */
	public List<GasMerchantPayWayDO> findGasMerchantPayWayByPartnerIdAndPayWayCode(String partnerId,String payWayCode) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andPayWayCodeEqualTo(payWayCode);
		return gasMerchantPayWayDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_pay_way表数据
	 */
	public List<GasMerchantPayWayDO> findGasMerchantPayWayByPartnerId(String partnerId) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantPayWayDAO.selectByExample(exam);
	}

	/**
	* 根据payWayCode查询gas_merchant_pay_way表数据
	*/
	public List<GasMerchantPayWayDO> findGasMerchantPayWayByPayWayCode(String payWayCode) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPayWayCodeEqualTo(payWayCode);
		return gasMerchantPayWayDAO.selectByExample(exam);
	}

	/**
	* 根据payWayName查询gas_merchant_pay_way表数据
	*/
	public List<GasMerchantPayWayDO> findGasMerchantPayWayByPayWayName(String payWayName) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPayWayNameEqualTo(payWayName);
		return gasMerchantPayWayDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_pay_way表数据
	 */
	public void updateGasMerchantPayWayById(Long id,GasMerchantPayWayDO gasMerchantPayWayDO) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantPayWayDAO.updateByExample(gasMerchantPayWayDO, exam);
	}

	/**
	 * 根据partnerId,payWayCode更新gas_merchant_pay_way表数据
	 */
	public void updateGasMerchantPayWayByPartnerIdAndPayWayCode(String partnerId,String payWayCode,GasMerchantPayWayDO gasMerchantPayWayDO) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andPayWayCodeEqualTo(payWayCode);
		gasMerchantPayWayDAO.updateByExample(gasMerchantPayWayDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_pay_way表数据
	 */
	public void updateGasMerchantPayWayByPartnerId(String partnerId,GasMerchantPayWayDO gasMerchantPayWayDO) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantPayWayDAO.updateByExample(gasMerchantPayWayDO, exam);
	}

	/**
	* 根据payWayCode更新gas_merchant_pay_way表数据
	*/
	public void updateGasMerchantPayWayByPayWayCode(String payWayCode,GasMerchantPayWayDO gasMerchantPayWayDO) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPayWayCodeEqualTo(payWayCode);
		gasMerchantPayWayDAO.updateByExample(gasMerchantPayWayDO, exam);
	}

	/**
	* 根据payWayName更新gas_merchant_pay_way表数据
	*/
	public void updateGasMerchantPayWayByPayWayName(String payWayName,GasMerchantPayWayDO gasMerchantPayWayDO) {
		GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
		exam.createCriteria().andPayWayNameEqualTo(payWayName);
		gasMerchantPayWayDAO.updateByExample(gasMerchantPayWayDO, exam);
	}

    /**
	 * 断言gas_merchant_station表
	 */
	public void gasMerchantStationAssert(
	        GasMerchantStationDO gasMerchantStationDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String stationName, 
			String stationCode, 
			String phoneNo, 
			String status, 
			Byte connectOilMachine, 
			Long provinceId, 
			String provinceName, 
			Long cityId, 
			String cityName, 
			Long districtId, 
			String districtName, 
			String stationAddress, 
			Double longitude, 
			Double latitude, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantStationDO.getId());
        assertEquals(partnerId, gasMerchantStationDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantStationDO.getPlatPartnerId());
        assertEquals(stationId, gasMerchantStationDO.getStationId());
        assertEquals(stationName, gasMerchantStationDO.getStationName());
        assertEquals(stationCode, gasMerchantStationDO.getStationCode());
        assertEquals(phoneNo, gasMerchantStationDO.getPhoneNo());
        assertEquals(status, gasMerchantStationDO.getStatus());
        assertEquals(connectOilMachine, gasMerchantStationDO.getConnectOilMachine());
        assertEquals(provinceId, gasMerchantStationDO.getProvinceId());
        assertEquals(provinceName, gasMerchantStationDO.getProvinceName());
        assertEquals(cityId, gasMerchantStationDO.getCityId());
        assertEquals(cityName, gasMerchantStationDO.getCityName());
        assertEquals(districtId, gasMerchantStationDO.getDistrictId());
        assertEquals(districtName, gasMerchantStationDO.getDistrictName());
        assertEquals(stationAddress, gasMerchantStationDO.getStationAddress());
        assertEquals(longitude, gasMerchantStationDO.getLongitude());
        assertEquals(latitude, gasMerchantStationDO.getLatitude());
        assertEquals(createTime, gasMerchantStationDO.getCreateTime());
        assertEquals(updateTime, gasMerchantStationDO.getUpdateTime());
        assertEquals(rawAddTime, gasMerchantStationDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantStationDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_station表数据
	 */
	public void assertGasMerchantStation(GasMerchantStationDO expect, GasMerchantStationDO gasMerchantStationDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantStationDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantStationDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantStationDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantStationDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantStationDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantStationDO);
	}

    /**
	 * 插入gas_merchant_station表数据
	 */
	public void insertGasMerchantStation(GasMerchantStationDO gasMerchantStationDO) {
		gasMerchantStationDAO.insert(gasMerchantStationDO);
	}

    /**
	 * 插入gas_merchant_station表数据
	 */
	public void insertGasMerchantStation(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String stationName, 
			String stationCode, 
			String phoneNo, 
			String status, 
			Byte connectOilMachine, 
			Long provinceId, 
			String provinceName, 
			Long cityId, 
			String cityName, 
			Long districtId, 
			String districtName, 
			String stationAddress, 
			Double longitude, 
			Double latitude, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantStationDO gasMerchantStationDO = new GasMerchantStationDO();
		gasMerchantStationDO.setId(id);
		gasMerchantStationDO.setPartnerId(partnerId);
		gasMerchantStationDO.setPlatPartnerId(platPartnerId);
		gasMerchantStationDO.setStationId(stationId);
		gasMerchantStationDO.setStationName(stationName);
		gasMerchantStationDO.setStationCode(stationCode);
		gasMerchantStationDO.setPhoneNo(phoneNo);
		gasMerchantStationDO.setStatus(status);
		gasMerchantStationDO.setConnectOilMachine(connectOilMachine);
		gasMerchantStationDO.setProvinceId(provinceId);
		gasMerchantStationDO.setProvinceName(provinceName);
		gasMerchantStationDO.setCityId(cityId);
		gasMerchantStationDO.setCityName(cityName);
		gasMerchantStationDO.setDistrictId(districtId);
		gasMerchantStationDO.setDistrictName(districtName);
		gasMerchantStationDO.setStationAddress(stationAddress);
		gasMerchantStationDO.setLongitude(longitude);
		gasMerchantStationDO.setLatitude(latitude);
		gasMerchantStationDO.setCreateTime(createTime);
		gasMerchantStationDO.setUpdateTime(updateTime);
		gasMerchantStationDO.setRawAddTime(rawAddTime);
		gasMerchantStationDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantStationDAO.insert(gasMerchantStationDO);
	}

    /**
     * 删除gas_merchant_station表所有数据
     */
    public void cleanGasMerchantStation() {
        GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
        exam.createCriteria();
        gasMerchantStationDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationById(Long id) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_merchant_station表数据
	*/
	public void cleanGasMerchantStationByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_merchant_station表数据
	*/
	public void cleanGasMerchantStationByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据phoneNo删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByPhoneNo(String phoneNo) {
        if (StringUtils.isBlank(phoneNo)){
            phoneNo = "test_phoneNo";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPhoneNoEqualTo(phoneNo);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据provinceId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByProvinceId(Long provinceId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	* 根据provinceName删除gas_merchant_station表数据
	*/
	public void cleanGasMerchantStationByProvinceName(String provinceName) {
        if (StringUtils.isBlank(provinceName)){
            provinceName = "test_provinceName";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据cityId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByCityId(Long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	* 根据cityName删除gas_merchant_station表数据
	*/
	public void cleanGasMerchantStationByCityName(String cityName) {
        if (StringUtils.isBlank(cityName)){
            cityName = "test_cityName";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据districtId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByDistrictId(Long districtId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	* 根据districtName删除gas_merchant_station表数据
	*/
	public void cleanGasMerchantStationByDistrictName(String districtName) {
        if (StringUtils.isBlank(districtName)){
            districtName = "test_districtName";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		gasMerchantStationDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_station表所有数据
     */
    public List<GasMerchantStationDO> findGasMerchantStationAll() {
        GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
        exam.createCriteria();
		return gasMerchantStationDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationById(Long id) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPartnerId(String partnerId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPlatPartnerId(String platPartnerId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByStationId(String stationId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_merchant_station表数据
	*/
	public List<GasMerchantStationDO> findGasMerchantStationByStationName(String stationName) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasMerchantStationDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_merchant_station表数据
	*/
	public List<GasMerchantStationDO> findGasMerchantStationByStationCode(String stationCode) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据phoneNo查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPhoneNo(String phoneNo) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPhoneNoEqualTo(phoneNo);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据provinceId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByProvinceId(Long provinceId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

	/**
	* 根据provinceName查询gas_merchant_station表数据
	*/
	public List<GasMerchantStationDO> findGasMerchantStationByProvinceName(String provinceName) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据cityId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByCityId(Long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

	/**
	* 根据cityName查询gas_merchant_station表数据
	*/
	public List<GasMerchantStationDO> findGasMerchantStationByCityName(String cityName) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据districtId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByDistrictId(Long districtId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

	/**
	* 根据districtName查询gas_merchant_station表数据
	*/
	public List<GasMerchantStationDO> findGasMerchantStationByDistrictName(String districtName) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationById(Long id,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPartnerId(String partnerId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPlatPartnerId(String platPartnerId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据stationId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByStationId(String stationId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

	/**
	* 根据stationName更新gas_merchant_station表数据
	*/
	public void updateGasMerchantStationByStationName(String stationName,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

	/**
	* 根据stationCode更新gas_merchant_station表数据
	*/
	public void updateGasMerchantStationByStationCode(String stationCode,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据phoneNo更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPhoneNo(String phoneNo,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPhoneNoEqualTo(phoneNo);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据provinceId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByProvinceId(Long provinceId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

	/**
	* 根据provinceName更新gas_merchant_station表数据
	*/
	public void updateGasMerchantStationByProvinceName(String provinceName,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据cityId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByCityId(Long cityId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

	/**
	* 根据cityName更新gas_merchant_station表数据
	*/
	public void updateGasMerchantStationByCityName(String cityName,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据districtId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByDistrictId(Long districtId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

	/**
	* 根据districtName更新gas_merchant_station表数据
	*/
	public void updateGasMerchantStationByDistrictName(String districtName,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 断言gas_merchant_user表
	 */
	public void gasMerchantUserAssert(
	        GasMerchantUserDO gasMerchantUserDO,
			Long id, 
			String partnerId, 
			String userId, 
			Long roleId, 
			String roleNo, 
			String userType, 
			String userName, 
			String mobileNo, 
			String account, 
			String password, 
			String salt, 
			String status, 
			String uqKey, 
			Integer loginErrorCount, 
			Integer loginErrorLimit, 
			Date lastLoginTime, 
			Date lastLoginSuccessTime, 
			Date lastLogoutSuccessTime, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantUserDO.getId());
        assertEquals(partnerId, gasMerchantUserDO.getPartnerId());
        assertEquals(userId, gasMerchantUserDO.getUserId());
        assertEquals(roleId, gasMerchantUserDO.getRoleId());
        assertEquals(roleNo, gasMerchantUserDO.getRoleNo());
        assertEquals(userType, gasMerchantUserDO.getUserType());
        assertEquals(userName, gasMerchantUserDO.getUserName());
        assertEquals(mobileNo, gasMerchantUserDO.getMobileNo());
        assertEquals(account, gasMerchantUserDO.getAccount());
        assertEquals(password, gasMerchantUserDO.getPassword());
        assertEquals(salt, gasMerchantUserDO.getSalt());
        assertEquals(status, gasMerchantUserDO.getStatus());
        assertEquals(uqKey, gasMerchantUserDO.getUqKey());
        assertEquals(loginErrorCount, gasMerchantUserDO.getLoginErrorCount());
        assertEquals(loginErrorLimit, gasMerchantUserDO.getLoginErrorLimit());
        assertEquals(lastLoginTime, gasMerchantUserDO.getLastLoginTime());
        assertEquals(lastLoginSuccessTime, gasMerchantUserDO.getLastLoginSuccessTime());
        assertEquals(lastLogoutSuccessTime, gasMerchantUserDO.getLastLogoutSuccessTime());
        assertEquals(createTime, gasMerchantUserDO.getCreateTime());
        assertEquals(updateTime, gasMerchantUserDO.getUpdateTime());
        assertEquals(rawAddTime, gasMerchantUserDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantUserDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_user表数据
	 */
	public void assertGasMerchantUser(GasMerchantUserDO expect, GasMerchantUserDO gasMerchantUserDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantUserDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantUserDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantUserDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantUserDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantUserDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantUserDO);
	}

    /**
	 * 插入gas_merchant_user表数据
	 */
	public void insertGasMerchantUser(GasMerchantUserDO gasMerchantUserDO) {
		gasMerchantUserDAO.insert(gasMerchantUserDO);
	}

    /**
	 * 插入gas_merchant_user表数据
	 */
	public void insertGasMerchantUser(
			Long id, 
			String partnerId, 
			String userId, 
			Long roleId, 
			String roleNo, 
			String userType, 
			String userName, 
			String mobileNo, 
			String account, 
			String password, 
			String salt, 
			String status, 
			String uqKey, 
			Integer loginErrorCount, 
			Integer loginErrorLimit, 
			Date lastLoginTime, 
			Date lastLoginSuccessTime, 
			Date lastLogoutSuccessTime, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantUserDO gasMerchantUserDO = new GasMerchantUserDO();
		gasMerchantUserDO.setId(id);
		gasMerchantUserDO.setPartnerId(partnerId);
		gasMerchantUserDO.setUserId(userId);
		gasMerchantUserDO.setRoleId(roleId);
		gasMerchantUserDO.setRoleNo(roleNo);
		gasMerchantUserDO.setUserType(userType);
		gasMerchantUserDO.setUserName(userName);
		gasMerchantUserDO.setMobileNo(mobileNo);
		gasMerchantUserDO.setAccount(account);
		gasMerchantUserDO.setPassword(password);
		gasMerchantUserDO.setSalt(salt);
		gasMerchantUserDO.setStatus(status);
		gasMerchantUserDO.setUqKey(uqKey);
		gasMerchantUserDO.setLoginErrorCount(loginErrorCount);
		gasMerchantUserDO.setLoginErrorLimit(loginErrorLimit);
		gasMerchantUserDO.setLastLoginTime(lastLoginTime);
		gasMerchantUserDO.setLastLoginSuccessTime(lastLoginSuccessTime);
		gasMerchantUserDO.setLastLogoutSuccessTime(lastLogoutSuccessTime);
		gasMerchantUserDO.setCreateTime(createTime);
		gasMerchantUserDO.setUpdateTime(updateTime);
		gasMerchantUserDO.setRawAddTime(rawAddTime);
		gasMerchantUserDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantUserDAO.insert(gasMerchantUserDO);
	}

    /**
     * 删除gas_merchant_user表所有数据
     */
    public void cleanGasMerchantUser() {
        GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
        exam.createCriteria();
        gasMerchantUserDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserById(Long id) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByRoleId(Long roleId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleNo删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByRoleNo(String roleNo) {
        if (StringUtils.isBlank(roleNo)){
            roleNo = "test_roleNo";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除gas_merchant_user表数据
	*/
	public void cleanGasMerchantUserByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobileNo删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByMobileNo(String mobileNo) {
        if (StringUtils.isBlank(mobileNo)){
            mobileNo = "test_mobileNo";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantUserDAO.deleteByExample(exam);
	}
	/**
	 * 根据uqKey,userType删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByUqKeyAndUserType(String uqKey,String userType) {
        if (StringUtils.isBlank(uqKey)){
            uqKey = "test_uqKey";
        }
        if (StringUtils.isBlank(userType)){
            userType = "test_userType";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUqKeyEqualTo(uqKey).andUserTypeEqualTo(userType);
		gasMerchantUserDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_user表所有数据
     */
    public List<GasMerchantUserDO> findGasMerchantUserAll() {
        GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
        exam.createCriteria();
		return gasMerchantUserDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserById(Long id) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByPartnerId(String partnerId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByUserId(String userId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByRoleId(Long roleId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据roleNo查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByRoleNo(String roleNo) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		return gasMerchantUserDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询gas_merchant_user表数据
	*/
	public List<GasMerchantUserDO> findGasMerchantUserByUserName(String userName) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据mobileNo查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByMobileNo(String mobileNo) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		return gasMerchantUserDAO.selectByExample(exam);
	}

	/**
	 * 根据uqKey,userType查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByUqKeyAndUserType(String uqKey,String userType) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUqKeyEqualTo(uqKey).andUserTypeEqualTo(userType);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserById(Long id,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByPartnerId(String partnerId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByUserId(String userId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByRoleId(Long roleId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据roleNo更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByRoleNo(String roleNo,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

	/**
	* 根据userName更新gas_merchant_user表数据
	*/
	public void updateGasMerchantUserByUserName(String userName,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据mobileNo更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByMobileNo(String mobileNo,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

	/**
	 * 根据uqKey,userType更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByUqKeyAndUserType(String uqKey,String userType,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUqKeyEqualTo(uqKey).andUserTypeEqualTo(userType);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 断言gas_merchant_user_station表
	 */
	public void gasMerchantUserStationAssert(
	        GasMerchantUserStationDO gasMerchantUserStationDO,
			Long id, 
			String partnerId, 
			String userId, 
			Long roleId, 
			String userType, 
			String userName, 
			String mobileNo, 
			String account, 
			String userStatus, 
			String stationId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantUserStationDO.getId());
        assertEquals(partnerId, gasMerchantUserStationDO.getPartnerId());
        assertEquals(userId, gasMerchantUserStationDO.getUserId());
        assertEquals(roleId, gasMerchantUserStationDO.getRoleId());
        assertEquals(userType, gasMerchantUserStationDO.getUserType());
        assertEquals(userName, gasMerchantUserStationDO.getUserName());
        assertEquals(mobileNo, gasMerchantUserStationDO.getMobileNo());
        assertEquals(account, gasMerchantUserStationDO.getAccount());
        assertEquals(userStatus, gasMerchantUserStationDO.getUserStatus());
        assertEquals(stationId, gasMerchantUserStationDO.getStationId());
        assertEquals(rawAddTime, gasMerchantUserStationDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantUserStationDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_user_station表数据
	 */
	public void assertGasMerchantUserStation(GasMerchantUserStationDO expect, GasMerchantUserStationDO gasMerchantUserStationDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantUserStationDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantUserStationDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantUserStationDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantUserStationDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantUserStationDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantUserStationDO);
	}

    /**
	 * 插入gas_merchant_user_station表数据
	 */
	public void insertGasMerchantUserStation(GasMerchantUserStationDO gasMerchantUserStationDO) {
		gasMerchantUserStationDAO.insert(gasMerchantUserStationDO);
	}

    /**
	 * 插入gas_merchant_user_station表数据
	 */
	public void insertGasMerchantUserStation(
			Long id, 
			String partnerId, 
			String userId, 
			Long roleId, 
			String userType, 
			String userName, 
			String mobileNo, 
			String account, 
			String userStatus, 
			String stationId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantUserStationDO gasMerchantUserStationDO = new GasMerchantUserStationDO();
		gasMerchantUserStationDO.setId(id);
		gasMerchantUserStationDO.setPartnerId(partnerId);
		gasMerchantUserStationDO.setUserId(userId);
		gasMerchantUserStationDO.setRoleId(roleId);
		gasMerchantUserStationDO.setUserType(userType);
		gasMerchantUserStationDO.setUserName(userName);
		gasMerchantUserStationDO.setMobileNo(mobileNo);
		gasMerchantUserStationDO.setAccount(account);
		gasMerchantUserStationDO.setUserStatus(userStatus);
		gasMerchantUserStationDO.setStationId(stationId);
		gasMerchantUserStationDO.setRawAddTime(rawAddTime);
		gasMerchantUserStationDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantUserStationDAO.insert(gasMerchantUserStationDO);
	}

    /**
     * 删除gas_merchant_user_station表所有数据
     */
    public void cleanGasMerchantUserStation() {
        GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
        exam.createCriteria();
        gasMerchantUserStationDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationById(Long id) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationByRoleId(Long roleId) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除gas_merchant_user_station表数据
	*/
	public void cleanGasMerchantUserStationByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobileNo删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationByMobileNo(String mobileNo) {
        if (StringUtils.isBlank(mobileNo)){
            mobileNo = "test_mobileNo";
        }
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_user_station表所有数据
     */
    public List<GasMerchantUserStationDO> findGasMerchantUserStationAll() {
        GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
        exam.createCriteria();
		return gasMerchantUserStationDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationById(Long id) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByPartnerId(String partnerId) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByUserId(String userId) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByRoleId(Long roleId) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询gas_merchant_user_station表数据
	*/
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByUserName(String userName) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据mobileNo查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByMobileNo(String mobileNo) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByStationId(String stationId) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationById(Long id,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByPartnerId(String partnerId,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByUserId(String userId,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByRoleId(Long roleId,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

	/**
	* 根据userName更新gas_merchant_user_station表数据
	*/
	public void updateGasMerchantUserStationByUserName(String userName,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 根据mobileNo更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByMobileNo(String mobileNo,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 根据stationId更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByStationId(String stationId,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 断言gas_payway_dict表
	 */
	public void gasPaywayDictAssert(
	        GasPaywayDictDO gasPaywayDictDO,
			Long id, 
			String paywayType, 
			String paywayCode, 
			String paywayName, 
			String paywayIcon, 
			String paywaySmallIcon, 
			String channelCode, 
			String channelFunction, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasPaywayDictDO.getId());
        assertEquals(paywayType, gasPaywayDictDO.getPaywayType());
        assertEquals(paywayCode, gasPaywayDictDO.getPaywayCode());
        assertEquals(paywayName, gasPaywayDictDO.getPaywayName());
        assertEquals(paywayIcon, gasPaywayDictDO.getPaywayIcon());
        assertEquals(paywaySmallIcon, gasPaywayDictDO.getPaywaySmallIcon());
        assertEquals(channelCode, gasPaywayDictDO.getChannelCode());
        assertEquals(channelFunction, gasPaywayDictDO.getChannelFunction());
        assertEquals(rawAddTime, gasPaywayDictDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasPaywayDictDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_payway_dict表数据
	 */
	public void assertGasPaywayDict(GasPaywayDictDO expect, GasPaywayDictDO gasPaywayDictDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasPaywayDictDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasPaywayDictDO.getRawAddTime());
		expect.setRawAddTime(gasPaywayDictDO.getRawAddTime());
        Assertions.assertTrue(null != gasPaywayDictDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasPaywayDictDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasPaywayDictDO);
	}

    /**
	 * 插入gas_payway_dict表数据
	 */
	public void insertGasPaywayDict(GasPaywayDictDO gasPaywayDictDO) {
		gasPaywayDictDAO.insert(gasPaywayDictDO);
	}

    /**
	 * 插入gas_payway_dict表数据
	 */
	public void insertGasPaywayDict(
			Long id, 
			String paywayType, 
			String paywayCode, 
			String paywayName, 
			String paywayIcon, 
			String paywaySmallIcon, 
			String channelCode, 
			String channelFunction, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasPaywayDictDO gasPaywayDictDO = new GasPaywayDictDO();
		gasPaywayDictDO.setId(id);
		gasPaywayDictDO.setPaywayType(paywayType);
		gasPaywayDictDO.setPaywayCode(paywayCode);
		gasPaywayDictDO.setPaywayName(paywayName);
		gasPaywayDictDO.setPaywayIcon(paywayIcon);
		gasPaywayDictDO.setPaywaySmallIcon(paywaySmallIcon);
		gasPaywayDictDO.setChannelCode(channelCode);
		gasPaywayDictDO.setChannelFunction(channelFunction);
		gasPaywayDictDO.setRawAddTime(rawAddTime);
		gasPaywayDictDO.setRawUpdateTime(rawUpdateTime);
		gasPaywayDictDAO.insert(gasPaywayDictDO);
	}

    /**
     * 删除gas_payway_dict表所有数据
     */
    public void cleanGasPaywayDict() {
        GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
        exam.createCriteria();
        gasPaywayDictDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_payway_dict表数据
	 */
	public void cleanGasPaywayDictById(Long id) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPaywayDictDAO.deleteByExample(exam);
	}

	/**
	* 根据paywayCode删除gas_payway_dict表数据
	*/
	public void cleanGasPaywayDictByPaywayCode(String paywayCode) {
        if (StringUtils.isBlank(paywayCode)){
            paywayCode = "test_paywayCode";
        }
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		gasPaywayDictDAO.deleteByExample(exam);
	}

	/**
	* 根据paywayName删除gas_payway_dict表数据
	*/
	public void cleanGasPaywayDictByPaywayName(String paywayName) {
        if (StringUtils.isBlank(paywayName)){
            paywayName = "test_paywayName";
        }
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		gasPaywayDictDAO.deleteByExample(exam);
	}

	/**
	* 根据channelCode删除gas_payway_dict表数据
	*/
	public void cleanGasPaywayDictByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)){
            channelCode = "test_channelCode";
        }
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		gasPaywayDictDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_payway_dict表所有数据
     */
    public List<GasPaywayDictDO> findGasPaywayDictAll() {
        GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
        exam.createCriteria();
		return gasPaywayDictDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_payway_dict表数据
	 */
	public List<GasPaywayDictDO> findGasPaywayDictById(Long id) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasPaywayDictDAO.selectByExample(exam);
	}

	/**
	* 根据paywayCode查询gas_payway_dict表数据
	*/
	public List<GasPaywayDictDO> findGasPaywayDictByPaywayCode(String paywayCode) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		return gasPaywayDictDAO.selectByExample(exam);
	}

	/**
	* 根据paywayName查询gas_payway_dict表数据
	*/
	public List<GasPaywayDictDO> findGasPaywayDictByPaywayName(String paywayName) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		return gasPaywayDictDAO.selectByExample(exam);
	}

	/**
	* 根据channelCode查询gas_payway_dict表数据
	*/
	public List<GasPaywayDictDO> findGasPaywayDictByChannelCode(String channelCode) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		return gasPaywayDictDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_payway_dict表数据
	 */
	public void updateGasPaywayDictById(Long id,GasPaywayDictDO gasPaywayDictDO) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPaywayDictDAO.updateByExample(gasPaywayDictDO, exam);
	}

	/**
	* 根据paywayCode更新gas_payway_dict表数据
	*/
	public void updateGasPaywayDictByPaywayCode(String paywayCode,GasPaywayDictDO gasPaywayDictDO) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		gasPaywayDictDAO.updateByExample(gasPaywayDictDO, exam);
	}

	/**
	* 根据paywayName更新gas_payway_dict表数据
	*/
	public void updateGasPaywayDictByPaywayName(String paywayName,GasPaywayDictDO gasPaywayDictDO) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		gasPaywayDictDAO.updateByExample(gasPaywayDictDO, exam);
	}

	/**
	* 根据channelCode更新gas_payway_dict表数据
	*/
	public void updateGasPaywayDictByChannelCode(String channelCode,GasPaywayDictDO gasPaywayDictDO) {
		GasPaywayDictDOExample exam = new GasPaywayDictDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		gasPaywayDictDAO.updateByExample(gasPaywayDictDO, exam);
	}

    /**
	 * 断言gas_points_change表
	 */
	public void gasPointsChangeAssert(
	        GasPointsChangeDO gasPointsChangeDO,
			Long id, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String sourceType, 
			String sourceId, 
			String showText, 
			String changeType, 
			String changeMode, 
			Long points, 
			String memo, 
			Date changeTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasPointsChangeDO.getId());
        assertEquals(partnerId, gasPointsChangeDO.getPartnerId());
        assertEquals(partnerName, gasPointsChangeDO.getPartnerName());
        assertEquals(stationId, gasPointsChangeDO.getStationId());
        assertEquals(stationCode, gasPointsChangeDO.getStationCode());
        assertEquals(stationName, gasPointsChangeDO.getStationName());
        assertEquals(operateId, gasPointsChangeDO.getOperateId());
        assertEquals(operateName, gasPointsChangeDO.getOperateName());
        assertEquals(terminalType, gasPointsChangeDO.getTerminalType());
        assertEquals(terminalCode, gasPointsChangeDO.getTerminalCode());
        assertEquals(userId, gasPointsChangeDO.getUserId());
        assertEquals(realName, gasPointsChangeDO.getRealName());
        assertEquals(nickName, gasPointsChangeDO.getNickName());
        assertEquals(memberType, gasPointsChangeDO.getMemberType());
        assertEquals(mobile, gasPointsChangeDO.getMobile());
        assertEquals(sourceType, gasPointsChangeDO.getSourceType());
        assertEquals(sourceId, gasPointsChangeDO.getSourceId());
        assertEquals(showText, gasPointsChangeDO.getShowText());
        assertEquals(changeType, gasPointsChangeDO.getChangeType());
        assertEquals(changeMode, gasPointsChangeDO.getChangeMode());
        assertEquals(points, gasPointsChangeDO.getPoints());
        assertEquals(memo, gasPointsChangeDO.getMemo());
        assertEquals(changeTime, gasPointsChangeDO.getChangeTime());
        assertEquals(rawAddTime, gasPointsChangeDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasPointsChangeDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_points_change表数据
	 */
	public void assertGasPointsChange(GasPointsChangeDO expect, GasPointsChangeDO gasPointsChangeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasPointsChangeDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasPointsChangeDO.getRawAddTime());
		expect.setRawAddTime(gasPointsChangeDO.getRawAddTime());
        Assertions.assertTrue(null != gasPointsChangeDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasPointsChangeDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasPointsChangeDO);
	}

    /**
	 * 插入gas_points_change表数据
	 */
	public void insertGasPointsChange(GasPointsChangeDO gasPointsChangeDO) {
		gasPointsChangeDAO.insert(gasPointsChangeDO);
	}

    /**
	 * 插入gas_points_change表数据
	 */
	public void insertGasPointsChange(
			Long id, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String sourceType, 
			String sourceId, 
			String showText, 
			String changeType, 
			String changeMode, 
			Long points, 
			String memo, 
			Date changeTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasPointsChangeDO gasPointsChangeDO = new GasPointsChangeDO();
		gasPointsChangeDO.setId(id);
		gasPointsChangeDO.setPartnerId(partnerId);
		gasPointsChangeDO.setPartnerName(partnerName);
		gasPointsChangeDO.setStationId(stationId);
		gasPointsChangeDO.setStationCode(stationCode);
		gasPointsChangeDO.setStationName(stationName);
		gasPointsChangeDO.setOperateId(operateId);
		gasPointsChangeDO.setOperateName(operateName);
		gasPointsChangeDO.setTerminalType(terminalType);
		gasPointsChangeDO.setTerminalCode(terminalCode);
		gasPointsChangeDO.setUserId(userId);
		gasPointsChangeDO.setRealName(realName);
		gasPointsChangeDO.setNickName(nickName);
		gasPointsChangeDO.setMemberType(memberType);
		gasPointsChangeDO.setMobile(mobile);
		gasPointsChangeDO.setSourceType(sourceType);
		gasPointsChangeDO.setSourceId(sourceId);
		gasPointsChangeDO.setShowText(showText);
		gasPointsChangeDO.setChangeType(changeType);
		gasPointsChangeDO.setChangeMode(changeMode);
		gasPointsChangeDO.setPoints(points);
		gasPointsChangeDO.setMemo(memo);
		gasPointsChangeDO.setChangeTime(changeTime);
		gasPointsChangeDO.setRawAddTime(rawAddTime);
		gasPointsChangeDO.setRawUpdateTime(rawUpdateTime);
		gasPointsChangeDAO.insert(gasPointsChangeDO);
	}

    /**
     * 删除gas_points_change表所有数据
     */
    public void cleanGasPointsChange() {
        GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
        exam.createCriteria();
        gasPointsChangeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_points_change表数据
	 */
	public void cleanGasPointsChangeById(Long id) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_points_change表数据
	 */
	public void cleanGasPointsChangeByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_points_change表数据
	*/
	public void cleanGasPointsChangeByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_points_change表数据
	 */
	public void cleanGasPointsChangeByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_points_change表数据
	*/
	public void cleanGasPointsChangeByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_points_change表数据
	*/
	public void cleanGasPointsChangeByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_points_change表数据
	 */
	public void cleanGasPointsChangeByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_points_change表数据
	*/
	public void cleanGasPointsChangeByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_points_change表数据
	*/
	public void cleanGasPointsChangeByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_points_change表数据
	 */
	public void cleanGasPointsChangeByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_points_change表数据
	*/
	public void cleanGasPointsChangeByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_points_change表数据
	*/
	public void cleanGasPointsChangeByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_points_change表数据
	 */
	public void cleanGasPointsChangeByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasPointsChangeDAO.deleteByExample(exam);
	}

	/**
	 * 根据sourceId删除gas_points_change表数据
	 */
	public void cleanGasPointsChangeBySourceId(String sourceId) {
        if (StringUtils.isBlank(sourceId)){
            sourceId = "test_sourceId";
        }
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andSourceIdEqualTo(sourceId);
		gasPointsChangeDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_points_change表所有数据
     */
    public List<GasPointsChangeDO> findGasPointsChangeAll() {
        GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
        exam.createCriteria();
		return gasPointsChangeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_points_change表数据
	 */
	public List<GasPointsChangeDO> findGasPointsChangeById(Long id) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasPointsChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_points_change表数据
	 */
	public List<GasPointsChangeDO> findGasPointsChangeByPartnerId(String partnerId) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasPointsChangeDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_points_change表数据
	*/
	public List<GasPointsChangeDO> findGasPointsChangeByPartnerName(String partnerName) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasPointsChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_points_change表数据
	 */
	public List<GasPointsChangeDO> findGasPointsChangeByStationId(String stationId) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasPointsChangeDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_points_change表数据
	*/
	public List<GasPointsChangeDO> findGasPointsChangeByStationCode(String stationCode) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasPointsChangeDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_points_change表数据
	*/
	public List<GasPointsChangeDO> findGasPointsChangeByStationName(String stationName) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasPointsChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_points_change表数据
	 */
	public List<GasPointsChangeDO> findGasPointsChangeByOperateId(String operateId) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasPointsChangeDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_points_change表数据
	*/
	public List<GasPointsChangeDO> findGasPointsChangeByOperateName(String operateName) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasPointsChangeDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_points_change表数据
	*/
	public List<GasPointsChangeDO> findGasPointsChangeByTerminalCode(String terminalCode) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasPointsChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_points_change表数据
	 */
	public List<GasPointsChangeDO> findGasPointsChangeByUserId(String userId) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasPointsChangeDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_points_change表数据
	*/
	public List<GasPointsChangeDO> findGasPointsChangeByRealName(String realName) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasPointsChangeDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_points_change表数据
	*/
	public List<GasPointsChangeDO> findGasPointsChangeByNickName(String nickName) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasPointsChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_points_change表数据
	 */
	public List<GasPointsChangeDO> findGasPointsChangeByMobile(String mobile) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasPointsChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据sourceId查询gas_points_change表数据
	 */
	public List<GasPointsChangeDO> findGasPointsChangeBySourceId(String sourceId) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andSourceIdEqualTo(sourceId);
		return gasPointsChangeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_points_change表数据
	 */
	public void updateGasPointsChangeById(Long id,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

    /**
	 * 根据partnerId更新gas_points_change表数据
	 */
	public void updateGasPointsChangeByPartnerId(String partnerId,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

	/**
	* 根据partnerName更新gas_points_change表数据
	*/
	public void updateGasPointsChangeByPartnerName(String partnerName,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

    /**
	 * 根据stationId更新gas_points_change表数据
	 */
	public void updateGasPointsChangeByStationId(String stationId,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

	/**
	* 根据stationCode更新gas_points_change表数据
	*/
	public void updateGasPointsChangeByStationCode(String stationCode,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

	/**
	* 根据stationName更新gas_points_change表数据
	*/
	public void updateGasPointsChangeByStationName(String stationName,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

    /**
	 * 根据operateId更新gas_points_change表数据
	 */
	public void updateGasPointsChangeByOperateId(String operateId,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

	/**
	* 根据operateName更新gas_points_change表数据
	*/
	public void updateGasPointsChangeByOperateName(String operateName,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

	/**
	* 根据terminalCode更新gas_points_change表数据
	*/
	public void updateGasPointsChangeByTerminalCode(String terminalCode,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

    /**
	 * 根据userId更新gas_points_change表数据
	 */
	public void updateGasPointsChangeByUserId(String userId,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

	/**
	* 根据realName更新gas_points_change表数据
	*/
	public void updateGasPointsChangeByRealName(String realName,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

	/**
	* 根据nickName更新gas_points_change表数据
	*/
	public void updateGasPointsChangeByNickName(String nickName,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

    /**
	 * 根据mobile更新gas_points_change表数据
	 */
	public void updateGasPointsChangeByMobile(String mobile,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

    /**
	 * 根据sourceId更新gas_points_change表数据
	 */
	public void updateGasPointsChangeBySourceId(String sourceId,GasPointsChangeDO gasPointsChangeDO) {
		GasPointsChangeDOExample exam = new GasPointsChangeDOExample();
		exam.createCriteria().andSourceIdEqualTo(sourceId);
		gasPointsChangeDAO.updateByExample(gasPointsChangeDO, exam);
	}

    /**
	 * 断言gas_terminal_login表
	 */
	public void gasTerminalLoginAssert(
	        GasTerminalLoginDO gasTerminalLoginDO,
			Long id, 
			String userId, 
			String partnerId, 
			String stationId, 
			String stationName, 
			String account, 
			String userName, 
			String deviceType, 
			String deviceCode, 
			Date loginTime, 
			Date logoutTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTerminalLoginDO.getId());
        assertEquals(userId, gasTerminalLoginDO.getUserId());
        assertEquals(partnerId, gasTerminalLoginDO.getPartnerId());
        assertEquals(stationId, gasTerminalLoginDO.getStationId());
        assertEquals(stationName, gasTerminalLoginDO.getStationName());
        assertEquals(account, gasTerminalLoginDO.getAccount());
        assertEquals(userName, gasTerminalLoginDO.getUserName());
        assertEquals(deviceType, gasTerminalLoginDO.getDeviceType());
        assertEquals(deviceCode, gasTerminalLoginDO.getDeviceCode());
        assertEquals(loginTime, gasTerminalLoginDO.getLoginTime());
        assertEquals(logoutTime, gasTerminalLoginDO.getLogoutTime());
        assertEquals(rawAddTime, gasTerminalLoginDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTerminalLoginDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_terminal_login表数据
	 */
	public void assertGasTerminalLogin(GasTerminalLoginDO expect, GasTerminalLoginDO gasTerminalLoginDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTerminalLoginDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTerminalLoginDO.getRawAddTime());
		expect.setRawAddTime(gasTerminalLoginDO.getRawAddTime());
        Assertions.assertTrue(null != gasTerminalLoginDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTerminalLoginDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTerminalLoginDO);
	}

    /**
	 * 插入gas_terminal_login表数据
	 */
	public void insertGasTerminalLogin(GasTerminalLoginDO gasTerminalLoginDO) {
		gasTerminalLoginDAO.insert(gasTerminalLoginDO);
	}

    /**
	 * 插入gas_terminal_login表数据
	 */
	public void insertGasTerminalLogin(
			Long id, 
			String userId, 
			String partnerId, 
			String stationId, 
			String stationName, 
			String account, 
			String userName, 
			String deviceType, 
			String deviceCode, 
			Date loginTime, 
			Date logoutTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTerminalLoginDO gasTerminalLoginDO = new GasTerminalLoginDO();
		gasTerminalLoginDO.setId(id);
		gasTerminalLoginDO.setUserId(userId);
		gasTerminalLoginDO.setPartnerId(partnerId);
		gasTerminalLoginDO.setStationId(stationId);
		gasTerminalLoginDO.setStationName(stationName);
		gasTerminalLoginDO.setAccount(account);
		gasTerminalLoginDO.setUserName(userName);
		gasTerminalLoginDO.setDeviceType(deviceType);
		gasTerminalLoginDO.setDeviceCode(deviceCode);
		gasTerminalLoginDO.setLoginTime(loginTime);
		gasTerminalLoginDO.setLogoutTime(logoutTime);
		gasTerminalLoginDO.setRawAddTime(rawAddTime);
		gasTerminalLoginDO.setRawUpdateTime(rawUpdateTime);
		gasTerminalLoginDAO.insert(gasTerminalLoginDO);
	}

    /**
     * 删除gas_terminal_login表所有数据
     */
    public void cleanGasTerminalLogin() {
        GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
        exam.createCriteria();
        gasTerminalLoginDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_terminal_login表数据
	 */
	public void cleanGasTerminalLoginById(Long id) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTerminalLoginDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_terminal_login表数据
	 */
	public void cleanGasTerminalLoginByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTerminalLoginDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_terminal_login表数据
	 */
	public void cleanGasTerminalLoginByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTerminalLoginDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_terminal_login表数据
	 */
	public void cleanGasTerminalLoginByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTerminalLoginDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_terminal_login表数据
	*/
	public void cleanGasTerminalLoginByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTerminalLoginDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除gas_terminal_login表数据
	*/
	public void cleanGasTerminalLoginByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasTerminalLoginDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_terminal_login表数据
	*/
	public void cleanGasTerminalLoginByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasTerminalLoginDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_terminal_login表所有数据
     */
    public List<GasTerminalLoginDO> findGasTerminalLoginAll() {
        GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
        exam.createCriteria();
		return gasTerminalLoginDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_terminal_login表数据
	 */
	public List<GasTerminalLoginDO> findGasTerminalLoginById(Long id) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTerminalLoginDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_terminal_login表数据
	 */
	public List<GasTerminalLoginDO> findGasTerminalLoginByUserId(String userId) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasTerminalLoginDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_terminal_login表数据
	 */
	public List<GasTerminalLoginDO> findGasTerminalLoginByPartnerId(String partnerId) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasTerminalLoginDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_terminal_login表数据
	 */
	public List<GasTerminalLoginDO> findGasTerminalLoginByStationId(String stationId) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTerminalLoginDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_terminal_login表数据
	*/
	public List<GasTerminalLoginDO> findGasTerminalLoginByStationName(String stationName) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasTerminalLoginDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询gas_terminal_login表数据
	*/
	public List<GasTerminalLoginDO> findGasTerminalLoginByUserName(String userName) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return gasTerminalLoginDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_terminal_login表数据
	*/
	public List<GasTerminalLoginDO> findGasTerminalLoginByDeviceCode(String deviceCode) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasTerminalLoginDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_terminal_login表数据
	 */
	public void updateGasTerminalLoginById(Long id,GasTerminalLoginDO gasTerminalLoginDO) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTerminalLoginDAO.updateByExample(gasTerminalLoginDO, exam);
	}

    /**
	 * 根据userId更新gas_terminal_login表数据
	 */
	public void updateGasTerminalLoginByUserId(String userId,GasTerminalLoginDO gasTerminalLoginDO) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTerminalLoginDAO.updateByExample(gasTerminalLoginDO, exam);
	}

    /**
	 * 根据partnerId更新gas_terminal_login表数据
	 */
	public void updateGasTerminalLoginByPartnerId(String partnerId,GasTerminalLoginDO gasTerminalLoginDO) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTerminalLoginDAO.updateByExample(gasTerminalLoginDO, exam);
	}

    /**
	 * 根据stationId更新gas_terminal_login表数据
	 */
	public void updateGasTerminalLoginByStationId(String stationId,GasTerminalLoginDO gasTerminalLoginDO) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTerminalLoginDAO.updateByExample(gasTerminalLoginDO, exam);
	}

	/**
	* 根据stationName更新gas_terminal_login表数据
	*/
	public void updateGasTerminalLoginByStationName(String stationName,GasTerminalLoginDO gasTerminalLoginDO) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTerminalLoginDAO.updateByExample(gasTerminalLoginDO, exam);
	}

	/**
	* 根据userName更新gas_terminal_login表数据
	*/
	public void updateGasTerminalLoginByUserName(String userName,GasTerminalLoginDO gasTerminalLoginDO) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasTerminalLoginDAO.updateByExample(gasTerminalLoginDO, exam);
	}

	/**
	* 根据deviceCode更新gas_terminal_login表数据
	*/
	public void updateGasTerminalLoginByDeviceCode(String deviceCode,GasTerminalLoginDO gasTerminalLoginDO) {
		GasTerminalLoginDOExample exam = new GasTerminalLoginDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasTerminalLoginDAO.updateByExample(gasTerminalLoginDO, exam);
	}

    /**
	 * 断言gas_trade_favour表
	 */
	public void gasTradeFavourAssert(
	        GasTradeFavourDO gasTradeFavourDO,
			Long id, 
			String bizNo, 
			String tradeType, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String cardNo, 
			String tradePayType, 
			String payModel, 
			String favourDefinitionId, 
			String favourId, 
			String favourName, 
			String favourCategory, 
			String favourType, 
			String favourRule, 
			String promotionWay, 
			Long favourAmount, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTradeFavourDO.getId());
        assertEquals(bizNo, gasTradeFavourDO.getBizNo());
        assertEquals(tradeType, gasTradeFavourDO.getTradeType());
        assertEquals(tradeNo, gasTradeFavourDO.getTradeNo());
        assertEquals(partnerId, gasTradeFavourDO.getPartnerId());
        assertEquals(partnerName, gasTradeFavourDO.getPartnerName());
        assertEquals(stationId, gasTradeFavourDO.getStationId());
        assertEquals(stationCode, gasTradeFavourDO.getStationCode());
        assertEquals(stationName, gasTradeFavourDO.getStationName());
        assertEquals(operateId, gasTradeFavourDO.getOperateId());
        assertEquals(operateName, gasTradeFavourDO.getOperateName());
        assertEquals(terminalType, gasTradeFavourDO.getTerminalType());
        assertEquals(terminalCode, gasTradeFavourDO.getTerminalCode());
        assertEquals(userId, gasTradeFavourDO.getUserId());
        assertEquals(realName, gasTradeFavourDO.getRealName());
        assertEquals(nickName, gasTradeFavourDO.getNickName());
        assertEquals(memberType, gasTradeFavourDO.getMemberType());
        assertEquals(mobile, gasTradeFavourDO.getMobile());
        assertEquals(cardNo, gasTradeFavourDO.getCardNo());
        assertEquals(tradePayType, gasTradeFavourDO.getTradePayType());
        assertEquals(payModel, gasTradeFavourDO.getPayModel());
        assertEquals(favourDefinitionId, gasTradeFavourDO.getFavourDefinitionId());
        assertEquals(favourId, gasTradeFavourDO.getFavourId());
        assertEquals(favourName, gasTradeFavourDO.getFavourName());
        assertEquals(favourCategory, gasTradeFavourDO.getFavourCategory());
        assertEquals(favourType, gasTradeFavourDO.getFavourType());
        assertEquals(favourRule, gasTradeFavourDO.getFavourRule());
        assertEquals(promotionWay, gasTradeFavourDO.getPromotionWay());
        assertEquals(favourAmount, gasTradeFavourDO.getFavourAmount());
        assertEquals(status, gasTradeFavourDO.getStatus());
        assertEquals(state, gasTradeFavourDO.getState());
        assertEquals(createTime, gasTradeFavourDO.getCreateTime());
        assertEquals(finishTime, gasTradeFavourDO.getFinishTime());
        assertEquals(rawAddTime, gasTradeFavourDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTradeFavourDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_trade_favour表数据
	 */
	public void assertGasTradeFavour(GasTradeFavourDO expect, GasTradeFavourDO gasTradeFavourDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTradeFavourDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTradeFavourDO.getRawAddTime());
		expect.setRawAddTime(gasTradeFavourDO.getRawAddTime());
        Assertions.assertTrue(null != gasTradeFavourDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTradeFavourDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTradeFavourDO);
	}

    /**
	 * 插入gas_trade_favour表数据
	 */
	public void insertGasTradeFavour(GasTradeFavourDO gasTradeFavourDO) {
		gasTradeFavourDAO.insert(gasTradeFavourDO);
	}

    /**
	 * 插入gas_trade_favour表数据
	 */
	public void insertGasTradeFavour(
			Long id, 
			String bizNo, 
			String tradeType, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String cardNo, 
			String tradePayType, 
			String payModel, 
			String favourDefinitionId, 
			String favourId, 
			String favourName, 
			String favourCategory, 
			String favourType, 
			String favourRule, 
			String promotionWay, 
			Long favourAmount, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTradeFavourDO gasTradeFavourDO = new GasTradeFavourDO();
		gasTradeFavourDO.setId(id);
		gasTradeFavourDO.setBizNo(bizNo);
		gasTradeFavourDO.setTradeType(tradeType);
		gasTradeFavourDO.setTradeNo(tradeNo);
		gasTradeFavourDO.setPartnerId(partnerId);
		gasTradeFavourDO.setPartnerName(partnerName);
		gasTradeFavourDO.setStationId(stationId);
		gasTradeFavourDO.setStationCode(stationCode);
		gasTradeFavourDO.setStationName(stationName);
		gasTradeFavourDO.setOperateId(operateId);
		gasTradeFavourDO.setOperateName(operateName);
		gasTradeFavourDO.setTerminalType(terminalType);
		gasTradeFavourDO.setTerminalCode(terminalCode);
		gasTradeFavourDO.setUserId(userId);
		gasTradeFavourDO.setRealName(realName);
		gasTradeFavourDO.setNickName(nickName);
		gasTradeFavourDO.setMemberType(memberType);
		gasTradeFavourDO.setMobile(mobile);
		gasTradeFavourDO.setCardNo(cardNo);
		gasTradeFavourDO.setTradePayType(tradePayType);
		gasTradeFavourDO.setPayModel(payModel);
		gasTradeFavourDO.setFavourDefinitionId(favourDefinitionId);
		gasTradeFavourDO.setFavourId(favourId);
		gasTradeFavourDO.setFavourName(favourName);
		gasTradeFavourDO.setFavourCategory(favourCategory);
		gasTradeFavourDO.setFavourType(favourType);
		gasTradeFavourDO.setFavourRule(favourRule);
		gasTradeFavourDO.setPromotionWay(promotionWay);
		gasTradeFavourDO.setFavourAmount(favourAmount);
		gasTradeFavourDO.setStatus(status);
		gasTradeFavourDO.setState(state);
		gasTradeFavourDO.setCreateTime(createTime);
		gasTradeFavourDO.setFinishTime(finishTime);
		gasTradeFavourDO.setRawAddTime(rawAddTime);
		gasTradeFavourDO.setRawUpdateTime(rawUpdateTime);
		gasTradeFavourDAO.insert(gasTradeFavourDO);
	}

    /**
     * 删除gas_trade_favour表所有数据
     */
    public void cleanGasTradeFavour() {
        GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
        exam.createCriteria();
        gasTradeFavourDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourById(Long id) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByTradeNo(String tradeNo) {
        if (StringUtils.isBlank(tradeNo)){
            tradeNo = "test_tradeNo";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据favourDefinitionId删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByFavourDefinitionId(String favourDefinitionId) {
        if (StringUtils.isBlank(favourDefinitionId)){
            favourDefinitionId = "test_favourDefinitionId";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourDefinitionIdEqualTo(favourDefinitionId);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	 * 根据favourId删除gas_trade_favour表数据
	 */
	public void cleanGasTradeFavourByFavourId(String favourId) {
        if (StringUtils.isBlank(favourId)){
            favourId = "test_favourId";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourIdEqualTo(favourId);
		gasTradeFavourDAO.deleteByExample(exam);
	}

	/**
	* 根据favourName删除gas_trade_favour表数据
	*/
	public void cleanGasTradeFavourByFavourName(String favourName) {
        if (StringUtils.isBlank(favourName)){
            favourName = "test_favourName";
        }
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourNameEqualTo(favourName);
		gasTradeFavourDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_trade_favour表所有数据
     */
    public List<GasTradeFavourDO> findGasTradeFavourAll() {
        GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
        exam.createCriteria();
		return gasTradeFavourDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourById(Long id) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByBizNo(String bizNo) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByTradeNo(String tradeNo) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByPartnerId(String partnerId) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByPartnerName(String partnerName) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByStationId(String stationId) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByStationCode(String stationCode) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByStationName(String stationName) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByOperateId(String operateId) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByOperateName(String operateName) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByTerminalCode(String terminalCode) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByUserId(String userId) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByRealName(String realName) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByNickName(String nickName) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByMobile(String mobile) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByCardNo(String cardNo) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据favourDefinitionId查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByFavourDefinitionId(String favourDefinitionId) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourDefinitionIdEqualTo(favourDefinitionId);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据favourId查询gas_trade_favour表数据
	 */
	public List<GasTradeFavourDO> findGasTradeFavourByFavourId(String favourId) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourIdEqualTo(favourId);
		return gasTradeFavourDAO.selectByExample(exam);
	}

	/**
	* 根据favourName查询gas_trade_favour表数据
	*/
	public List<GasTradeFavourDO> findGasTradeFavourByFavourName(String favourName) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourNameEqualTo(favourName);
		return gasTradeFavourDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourById(Long id,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据bizNo更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByBizNo(String bizNo,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据tradeNo更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByTradeNo(String tradeNo,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据partnerId更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByPartnerId(String partnerId,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据partnerName更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByPartnerName(String partnerName,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据stationId更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByStationId(String stationId,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据stationCode更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByStationCode(String stationCode,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据stationName更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByStationName(String stationName,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据operateId更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByOperateId(String operateId,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据operateName更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByOperateName(String operateName,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据terminalCode更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByTerminalCode(String terminalCode,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据userId更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByUserId(String userId,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据realName更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByRealName(String realName,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据nickName更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByNickName(String nickName,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据mobile更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByMobile(String mobile,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据cardNo更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByCardNo(String cardNo,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据favourDefinitionId更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByFavourDefinitionId(String favourDefinitionId,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourDefinitionIdEqualTo(favourDefinitionId);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 根据favourId更新gas_trade_favour表数据
	 */
	public void updateGasTradeFavourByFavourId(String favourId,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourIdEqualTo(favourId);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

	/**
	* 根据favourName更新gas_trade_favour表数据
	*/
	public void updateGasTradeFavourByFavourName(String favourName,GasTradeFavourDO gasTradeFavourDO) {
		GasTradeFavourDOExample exam = new GasTradeFavourDOExample();
		exam.createCriteria().andFavourNameEqualTo(favourName);
		gasTradeFavourDAO.updateByExample(gasTradeFavourDO, exam);
	}

    /**
	 * 断言gas_trade_goods表
	 */
	public void gasTradeGoodsAssert(
	        GasTradeGoodsDO gasTradeGoodsDO,
			Long id, 
			String bizNo, 
			String tradeType, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String certNo, 
			String nickName, 
			String memberType, 
			String mobile, 
			String userGrade, 
			String groupCode, 
			String groupName, 
			String cardNo, 
			String goodsType, 
			String goodsCode, 
			String goodsName, 
			Long goodsPrice, 
			Integer goodsPiece, 
			Long goodsAmount, 
			Long goodsFavourAmount, 
			String tradePayType, 
			String payModel, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTradeGoodsDO.getId());
        assertEquals(bizNo, gasTradeGoodsDO.getBizNo());
        assertEquals(tradeType, gasTradeGoodsDO.getTradeType());
        assertEquals(tradeNo, gasTradeGoodsDO.getTradeNo());
        assertEquals(partnerId, gasTradeGoodsDO.getPartnerId());
        assertEquals(partnerName, gasTradeGoodsDO.getPartnerName());
        assertEquals(stationId, gasTradeGoodsDO.getStationId());
        assertEquals(stationCode, gasTradeGoodsDO.getStationCode());
        assertEquals(stationName, gasTradeGoodsDO.getStationName());
        assertEquals(operateId, gasTradeGoodsDO.getOperateId());
        assertEquals(operateName, gasTradeGoodsDO.getOperateName());
        assertEquals(terminalType, gasTradeGoodsDO.getTerminalType());
        assertEquals(terminalCode, gasTradeGoodsDO.getTerminalCode());
        assertEquals(userId, gasTradeGoodsDO.getUserId());
        assertEquals(realName, gasTradeGoodsDO.getRealName());
        assertEquals(certNo, gasTradeGoodsDO.getCertNo());
        assertEquals(nickName, gasTradeGoodsDO.getNickName());
        assertEquals(memberType, gasTradeGoodsDO.getMemberType());
        assertEquals(mobile, gasTradeGoodsDO.getMobile());
        assertEquals(userGrade, gasTradeGoodsDO.getUserGrade());
        assertEquals(groupCode, gasTradeGoodsDO.getGroupCode());
        assertEquals(groupName, gasTradeGoodsDO.getGroupName());
        assertEquals(cardNo, gasTradeGoodsDO.getCardNo());
        assertEquals(goodsType, gasTradeGoodsDO.getGoodsType());
        assertEquals(goodsCode, gasTradeGoodsDO.getGoodsCode());
        assertEquals(goodsName, gasTradeGoodsDO.getGoodsName());
        assertEquals(goodsPrice, gasTradeGoodsDO.getGoodsPrice());
        assertEquals(goodsPiece, gasTradeGoodsDO.getGoodsPiece());
        assertEquals(goodsAmount, gasTradeGoodsDO.getGoodsAmount());
        assertEquals(goodsFavourAmount, gasTradeGoodsDO.getGoodsFavourAmount());
        assertEquals(tradePayType, gasTradeGoodsDO.getTradePayType());
        assertEquals(payModel, gasTradeGoodsDO.getPayModel());
        assertEquals(status, gasTradeGoodsDO.getStatus());
        assertEquals(state, gasTradeGoodsDO.getState());
        assertEquals(createTime, gasTradeGoodsDO.getCreateTime());
        assertEquals(finishTime, gasTradeGoodsDO.getFinishTime());
        assertEquals(rawAddTime, gasTradeGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTradeGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_trade_goods表数据
	 */
	public void assertGasTradeGoods(GasTradeGoodsDO expect, GasTradeGoodsDO gasTradeGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTradeGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTradeGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasTradeGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasTradeGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTradeGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTradeGoodsDO);
	}

    /**
	 * 插入gas_trade_goods表数据
	 */
	public void insertGasTradeGoods(GasTradeGoodsDO gasTradeGoodsDO) {
		gasTradeGoodsDAO.insert(gasTradeGoodsDO);
	}

    /**
	 * 插入gas_trade_goods表数据
	 */
	public void insertGasTradeGoods(
			Long id, 
			String bizNo, 
			String tradeType, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String certNo, 
			String nickName, 
			String memberType, 
			String mobile, 
			String userGrade, 
			String groupCode, 
			String groupName, 
			String cardNo, 
			String goodsType, 
			String goodsCode, 
			String goodsName, 
			Long goodsPrice, 
			Integer goodsPiece, 
			Long goodsAmount, 
			Long goodsFavourAmount, 
			String tradePayType, 
			String payModel, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTradeGoodsDO gasTradeGoodsDO = new GasTradeGoodsDO();
		gasTradeGoodsDO.setId(id);
		gasTradeGoodsDO.setBizNo(bizNo);
		gasTradeGoodsDO.setTradeType(tradeType);
		gasTradeGoodsDO.setTradeNo(tradeNo);
		gasTradeGoodsDO.setPartnerId(partnerId);
		gasTradeGoodsDO.setPartnerName(partnerName);
		gasTradeGoodsDO.setStationId(stationId);
		gasTradeGoodsDO.setStationCode(stationCode);
		gasTradeGoodsDO.setStationName(stationName);
		gasTradeGoodsDO.setOperateId(operateId);
		gasTradeGoodsDO.setOperateName(operateName);
		gasTradeGoodsDO.setTerminalType(terminalType);
		gasTradeGoodsDO.setTerminalCode(terminalCode);
		gasTradeGoodsDO.setUserId(userId);
		gasTradeGoodsDO.setRealName(realName);
		gasTradeGoodsDO.setCertNo(certNo);
		gasTradeGoodsDO.setNickName(nickName);
		gasTradeGoodsDO.setMemberType(memberType);
		gasTradeGoodsDO.setMobile(mobile);
		gasTradeGoodsDO.setUserGrade(userGrade);
		gasTradeGoodsDO.setGroupCode(groupCode);
		gasTradeGoodsDO.setGroupName(groupName);
		gasTradeGoodsDO.setCardNo(cardNo);
		gasTradeGoodsDO.setGoodsType(goodsType);
		gasTradeGoodsDO.setGoodsCode(goodsCode);
		gasTradeGoodsDO.setGoodsName(goodsName);
		gasTradeGoodsDO.setGoodsPrice(goodsPrice);
		gasTradeGoodsDO.setGoodsPiece(goodsPiece);
		gasTradeGoodsDO.setGoodsAmount(goodsAmount);
		gasTradeGoodsDO.setGoodsFavourAmount(goodsFavourAmount);
		gasTradeGoodsDO.setTradePayType(tradePayType);
		gasTradeGoodsDO.setPayModel(payModel);
		gasTradeGoodsDO.setStatus(status);
		gasTradeGoodsDO.setState(state);
		gasTradeGoodsDO.setCreateTime(createTime);
		gasTradeGoodsDO.setFinishTime(finishTime);
		gasTradeGoodsDO.setRawAddTime(rawAddTime);
		gasTradeGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasTradeGoodsDAO.insert(gasTradeGoodsDO);
	}

    /**
     * 删除gas_trade_goods表所有数据
     */
    public void cleanGasTradeGoods() {
        GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
        exam.createCriteria();
        gasTradeGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsById(Long id) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByTradeNo(String tradeNo) {
        if (StringUtils.isBlank(tradeNo)){
            tradeNo = "test_tradeNo";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据groupCode删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByGroupCode(String groupCode) {
        if (StringUtils.isBlank(groupCode)){
            groupCode = "test_groupCode";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除gas_trade_goods表数据
	 */
	public void cleanGasTradeGoodsByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_trade_goods表数据
	*/
	public void cleanGasTradeGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasTradeGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_trade_goods表所有数据
     */
    public List<GasTradeGoodsDO> findGasTradeGoodsAll() {
        GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
        exam.createCriteria();
		return gasTradeGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsById(Long id) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByBizNo(String bizNo) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByTradeNo(String tradeNo) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByPartnerId(String partnerId) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByPartnerName(String partnerName) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByStationId(String stationId) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByStationCode(String stationCode) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByStationName(String stationName) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByOperateId(String operateId) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByOperateName(String operateName) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByTerminalCode(String terminalCode) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByUserId(String userId) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByRealName(String realName) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByCertNo(String certNo) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByNickName(String nickName) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByMobile(String mobile) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据groupCode查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByGroupCode(String groupCode) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByGroupName(String groupName) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询gas_trade_goods表数据
	 */
	public List<GasTradeGoodsDO> findGasTradeGoodsByCardNo(String cardNo) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByGoodsCode(String goodsCode) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_trade_goods表数据
	*/
	public List<GasTradeGoodsDO> findGasTradeGoodsByGoodsName(String goodsName) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasTradeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsById(Long id,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据bizNo更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByBizNo(String bizNo,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据tradeNo更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByTradeNo(String tradeNo,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据partnerId更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByPartnerId(String partnerId,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据partnerName更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByPartnerName(String partnerName,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据stationId更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByStationId(String stationId,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据stationCode更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByStationCode(String stationCode,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据stationName更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByStationName(String stationName,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据operateId更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByOperateId(String operateId,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据operateName更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByOperateName(String operateName,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据terminalCode更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByTerminalCode(String terminalCode,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据userId更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByUserId(String userId,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据realName更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByRealName(String realName,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据certNo更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByCertNo(String certNo,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据nickName更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByNickName(String nickName,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据mobile更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByMobile(String mobile,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据groupCode更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByGroupCode(String groupCode,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据groupName更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByGroupName(String groupName,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 根据cardNo更新gas_trade_goods表数据
	 */
	public void updateGasTradeGoodsByCardNo(String cardNo,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据goodsCode更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByGoodsCode(String goodsCode,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_trade_goods表数据
	*/
	public void updateGasTradeGoodsByGoodsName(String goodsName,GasTradeGoodsDO gasTradeGoodsDO) {
		GasTradeGoodsDOExample exam = new GasTradeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasTradeGoodsDAO.updateByExample(gasTradeGoodsDO, exam);
	}

    /**
	 * 断言gas_trade_oil表
	 */
	public void gasTradeOilAssert(
	        GasTradeOilDO gasTradeOilDO,
			Long id, 
			String bizNo, 
			String tradeType, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String certNo, 
			String nickName, 
			String memberType, 
			String mobile, 
			String userGrade, 
			String groupCode, 
			String groupName, 
			String cardNo, 
			String carNumber, 
			String oilType, 
			String oilCode, 
			String oilName, 
			Long listedPrice, 
			Long oilPrice, 
			Double oilLiter, 
			String oilGun, 
			Long oilAmount, 
			Long oilFavourAmount, 
			String tradePayType, 
			String payModel, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTradeOilDO.getId());
        assertEquals(bizNo, gasTradeOilDO.getBizNo());
        assertEquals(tradeType, gasTradeOilDO.getTradeType());
        assertEquals(tradeNo, gasTradeOilDO.getTradeNo());
        assertEquals(partnerId, gasTradeOilDO.getPartnerId());
        assertEquals(partnerName, gasTradeOilDO.getPartnerName());
        assertEquals(stationId, gasTradeOilDO.getStationId());
        assertEquals(stationCode, gasTradeOilDO.getStationCode());
        assertEquals(stationName, gasTradeOilDO.getStationName());
        assertEquals(operateId, gasTradeOilDO.getOperateId());
        assertEquals(operateName, gasTradeOilDO.getOperateName());
        assertEquals(terminalType, gasTradeOilDO.getTerminalType());
        assertEquals(terminalCode, gasTradeOilDO.getTerminalCode());
        assertEquals(userId, gasTradeOilDO.getUserId());
        assertEquals(realName, gasTradeOilDO.getRealName());
        assertEquals(certNo, gasTradeOilDO.getCertNo());
        assertEquals(nickName, gasTradeOilDO.getNickName());
        assertEquals(memberType, gasTradeOilDO.getMemberType());
        assertEquals(mobile, gasTradeOilDO.getMobile());
        assertEquals(userGrade, gasTradeOilDO.getUserGrade());
        assertEquals(groupCode, gasTradeOilDO.getGroupCode());
        assertEquals(groupName, gasTradeOilDO.getGroupName());
        assertEquals(cardNo, gasTradeOilDO.getCardNo());
        assertEquals(carNumber, gasTradeOilDO.getCarNumber());
        assertEquals(oilType, gasTradeOilDO.getOilType());
        assertEquals(oilCode, gasTradeOilDO.getOilCode());
        assertEquals(oilName, gasTradeOilDO.getOilName());
        assertEquals(listedPrice, gasTradeOilDO.getListedPrice());
        assertEquals(oilPrice, gasTradeOilDO.getOilPrice());
        assertEquals(oilLiter, gasTradeOilDO.getOilLiter());
        assertEquals(oilGun, gasTradeOilDO.getOilGun());
        assertEquals(oilAmount, gasTradeOilDO.getOilAmount());
        assertEquals(oilFavourAmount, gasTradeOilDO.getOilFavourAmount());
        assertEquals(tradePayType, gasTradeOilDO.getTradePayType());
        assertEquals(payModel, gasTradeOilDO.getPayModel());
        assertEquals(status, gasTradeOilDO.getStatus());
        assertEquals(state, gasTradeOilDO.getState());
        assertEquals(createTime, gasTradeOilDO.getCreateTime());
        assertEquals(finishTime, gasTradeOilDO.getFinishTime());
        assertEquals(rawAddTime, gasTradeOilDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTradeOilDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_trade_oil表数据
	 */
	public void assertGasTradeOil(GasTradeOilDO expect, GasTradeOilDO gasTradeOilDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTradeOilDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTradeOilDO.getRawAddTime());
		expect.setRawAddTime(gasTradeOilDO.getRawAddTime());
        Assertions.assertTrue(null != gasTradeOilDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTradeOilDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTradeOilDO);
	}

    /**
	 * 插入gas_trade_oil表数据
	 */
	public void insertGasTradeOil(GasTradeOilDO gasTradeOilDO) {
		gasTradeOilDAO.insert(gasTradeOilDO);
	}

    /**
	 * 插入gas_trade_oil表数据
	 */
	public void insertGasTradeOil(
			Long id, 
			String bizNo, 
			String tradeType, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String certNo, 
			String nickName, 
			String memberType, 
			String mobile, 
			String userGrade, 
			String groupCode, 
			String groupName, 
			String cardNo, 
			String carNumber, 
			String oilType, 
			String oilCode, 
			String oilName, 
			Long listedPrice, 
			Long oilPrice, 
			Double oilLiter, 
			String oilGun, 
			Long oilAmount, 
			Long oilFavourAmount, 
			String tradePayType, 
			String payModel, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTradeOilDO gasTradeOilDO = new GasTradeOilDO();
		gasTradeOilDO.setId(id);
		gasTradeOilDO.setBizNo(bizNo);
		gasTradeOilDO.setTradeType(tradeType);
		gasTradeOilDO.setTradeNo(tradeNo);
		gasTradeOilDO.setPartnerId(partnerId);
		gasTradeOilDO.setPartnerName(partnerName);
		gasTradeOilDO.setStationId(stationId);
		gasTradeOilDO.setStationCode(stationCode);
		gasTradeOilDO.setStationName(stationName);
		gasTradeOilDO.setOperateId(operateId);
		gasTradeOilDO.setOperateName(operateName);
		gasTradeOilDO.setTerminalType(terminalType);
		gasTradeOilDO.setTerminalCode(terminalCode);
		gasTradeOilDO.setUserId(userId);
		gasTradeOilDO.setRealName(realName);
		gasTradeOilDO.setCertNo(certNo);
		gasTradeOilDO.setNickName(nickName);
		gasTradeOilDO.setMemberType(memberType);
		gasTradeOilDO.setMobile(mobile);
		gasTradeOilDO.setUserGrade(userGrade);
		gasTradeOilDO.setGroupCode(groupCode);
		gasTradeOilDO.setGroupName(groupName);
		gasTradeOilDO.setCardNo(cardNo);
		gasTradeOilDO.setCarNumber(carNumber);
		gasTradeOilDO.setOilType(oilType);
		gasTradeOilDO.setOilCode(oilCode);
		gasTradeOilDO.setOilName(oilName);
		gasTradeOilDO.setListedPrice(listedPrice);
		gasTradeOilDO.setOilPrice(oilPrice);
		gasTradeOilDO.setOilLiter(oilLiter);
		gasTradeOilDO.setOilGun(oilGun);
		gasTradeOilDO.setOilAmount(oilAmount);
		gasTradeOilDO.setOilFavourAmount(oilFavourAmount);
		gasTradeOilDO.setTradePayType(tradePayType);
		gasTradeOilDO.setPayModel(payModel);
		gasTradeOilDO.setStatus(status);
		gasTradeOilDO.setState(state);
		gasTradeOilDO.setCreateTime(createTime);
		gasTradeOilDO.setFinishTime(finishTime);
		gasTradeOilDO.setRawAddTime(rawAddTime);
		gasTradeOilDO.setRawUpdateTime(rawUpdateTime);
		gasTradeOilDAO.insert(gasTradeOilDO);
	}

    /**
     * 删除gas_trade_oil表所有数据
     */
    public void cleanGasTradeOil() {
        GasTradeOilDOExample exam = new GasTradeOilDOExample();
        exam.createCriteria();
        gasTradeOilDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilById(Long id) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByTradeNo(String tradeNo) {
        if (StringUtils.isBlank(tradeNo)){
            tradeNo = "test_tradeNo";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据groupCode删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByGroupCode(String groupCode) {
        if (StringUtils.isBlank(groupCode)){
            groupCode = "test_groupCode";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除gas_trade_oil表数据
	 */
	public void cleanGasTradeOilByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据carNumber删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByCarNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)){
            carNumber = "test_carNumber";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据oilCode删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByOilCode(String oilCode) {
        if (StringUtils.isBlank(oilCode)){
            oilCode = "test_oilCode";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOilCodeEqualTo(oilCode);
		gasTradeOilDAO.deleteByExample(exam);
	}

	/**
	* 根据oilName删除gas_trade_oil表数据
	*/
	public void cleanGasTradeOilByOilName(String oilName) {
        if (StringUtils.isBlank(oilName)){
            oilName = "test_oilName";
        }
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOilNameEqualTo(oilName);
		gasTradeOilDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_trade_oil表所有数据
     */
    public List<GasTradeOilDO> findGasTradeOilAll() {
        GasTradeOilDOExample exam = new GasTradeOilDOExample();
        exam.createCriteria();
		return gasTradeOilDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilById(Long id) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByBizNo(String bizNo) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByTradeNo(String tradeNo) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByPartnerId(String partnerId) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByPartnerName(String partnerName) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByStationId(String stationId) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByStationCode(String stationCode) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByStationName(String stationName) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByOperateId(String operateId) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByOperateName(String operateName) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByTerminalCode(String terminalCode) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByUserId(String userId) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByRealName(String realName) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByCertNo(String certNo) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByNickName(String nickName) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByMobile(String mobile) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据groupCode查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByGroupCode(String groupCode) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByGroupName(String groupName) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询gas_trade_oil表数据
	 */
	public List<GasTradeOilDO> findGasTradeOilByCardNo(String cardNo) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据carNumber查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByCarNumber(String carNumber) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据oilCode查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByOilCode(String oilCode) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOilCodeEqualTo(oilCode);
		return gasTradeOilDAO.selectByExample(exam);
	}

	/**
	* 根据oilName查询gas_trade_oil表数据
	*/
	public List<GasTradeOilDO> findGasTradeOilByOilName(String oilName) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOilNameEqualTo(oilName);
		return gasTradeOilDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilById(Long id,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据bizNo更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByBizNo(String bizNo,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据tradeNo更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByTradeNo(String tradeNo,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据partnerId更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByPartnerId(String partnerId,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据partnerName更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByPartnerName(String partnerName,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据stationId更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByStationId(String stationId,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据stationCode更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByStationCode(String stationCode,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据stationName更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByStationName(String stationName,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据operateId更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByOperateId(String operateId,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据operateName更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByOperateName(String operateName,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据terminalCode更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByTerminalCode(String terminalCode,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据userId更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByUserId(String userId,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据realName更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByRealName(String realName,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据certNo更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByCertNo(String certNo,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据nickName更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByNickName(String nickName,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据mobile更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByMobile(String mobile,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据groupCode更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByGroupCode(String groupCode,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据groupName更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByGroupName(String groupName,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 根据cardNo更新gas_trade_oil表数据
	 */
	public void updateGasTradeOilByCardNo(String cardNo,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据oilCode更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByOilCode(String oilCode,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOilCodeEqualTo(oilCode);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

	/**
	* 根据oilName更新gas_trade_oil表数据
	*/
	public void updateGasTradeOilByOilName(String oilName,GasTradeOilDO gasTradeOilDO) {
		GasTradeOilDOExample exam = new GasTradeOilDOExample();
		exam.createCriteria().andOilNameEqualTo(oilName);
		gasTradeOilDAO.updateByExample(gasTradeOilDO, exam);
	}

    /**
	 * 断言gas_trade_order表
	 */
	public void gasTradeOrderAssert(
	        GasTradeOrderDO gasTradeOrderDO,
			Long id, 
			String tradeType, 
			String orderType, 
			String bizNo, 
			String reqId, 
			String gid, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String certNo, 
			String nickName, 
			String memberType, 
			String mobile, 
			String userGrade, 
			String groupCode, 
			String groupName, 
			String cardNo, 
			String cardType, 
			String cardBizType, 
			String carNumber, 
			Long balance, 
			String oilType, 
			String oilCode, 
			String oilName, 
			Long oilAmount, 
			Long oilFavourAmount, 
			Long goodsAmount, 
			Long goodsFavourAmount, 
			String payNo, 
			String tradePayType, 
			String payModel, 
			Long amount, 
			Long payAmount, 
			Long favourAmount, 
			Long feeAmount, 
			Long settlementAmount, 
			Long channelFavourAmount, 
			String memo, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTradeOrderDO.getId());
        assertEquals(tradeType, gasTradeOrderDO.getTradeType());
        assertEquals(orderType, gasTradeOrderDO.getOrderType());
        assertEquals(bizNo, gasTradeOrderDO.getBizNo());
        assertEquals(reqId, gasTradeOrderDO.getReqId());
        assertEquals(gid, gasTradeOrderDO.getGid());
        assertEquals(tradeNo, gasTradeOrderDO.getTradeNo());
        assertEquals(partnerId, gasTradeOrderDO.getPartnerId());
        assertEquals(partnerName, gasTradeOrderDO.getPartnerName());
        assertEquals(stationId, gasTradeOrderDO.getStationId());
        assertEquals(stationCode, gasTradeOrderDO.getStationCode());
        assertEquals(stationName, gasTradeOrderDO.getStationName());
        assertEquals(operateId, gasTradeOrderDO.getOperateId());
        assertEquals(operateName, gasTradeOrderDO.getOperateName());
        assertEquals(terminalType, gasTradeOrderDO.getTerminalType());
        assertEquals(terminalCode, gasTradeOrderDO.getTerminalCode());
        assertEquals(userId, gasTradeOrderDO.getUserId());
        assertEquals(realName, gasTradeOrderDO.getRealName());
        assertEquals(certNo, gasTradeOrderDO.getCertNo());
        assertEquals(nickName, gasTradeOrderDO.getNickName());
        assertEquals(memberType, gasTradeOrderDO.getMemberType());
        assertEquals(mobile, gasTradeOrderDO.getMobile());
        assertEquals(userGrade, gasTradeOrderDO.getUserGrade());
        assertEquals(groupCode, gasTradeOrderDO.getGroupCode());
        assertEquals(groupName, gasTradeOrderDO.getGroupName());
        assertEquals(cardNo, gasTradeOrderDO.getCardNo());
        assertEquals(cardType, gasTradeOrderDO.getCardType());
        assertEquals(cardBizType, gasTradeOrderDO.getCardBizType());
        assertEquals(carNumber, gasTradeOrderDO.getCarNumber());
        assertEquals(balance, gasTradeOrderDO.getBalance());
        assertEquals(oilType, gasTradeOrderDO.getOilType());
        assertEquals(oilCode, gasTradeOrderDO.getOilCode());
        assertEquals(oilName, gasTradeOrderDO.getOilName());
        assertEquals(oilAmount, gasTradeOrderDO.getOilAmount());
        assertEquals(oilFavourAmount, gasTradeOrderDO.getOilFavourAmount());
        assertEquals(goodsAmount, gasTradeOrderDO.getGoodsAmount());
        assertEquals(goodsFavourAmount, gasTradeOrderDO.getGoodsFavourAmount());
        assertEquals(payNo, gasTradeOrderDO.getPayNo());
        assertEquals(tradePayType, gasTradeOrderDO.getTradePayType());
        assertEquals(payModel, gasTradeOrderDO.getPayModel());
        assertEquals(amount, gasTradeOrderDO.getAmount());
        assertEquals(payAmount, gasTradeOrderDO.getPayAmount());
        assertEquals(favourAmount, gasTradeOrderDO.getFavourAmount());
        assertEquals(feeAmount, gasTradeOrderDO.getFeeAmount());
        assertEquals(settlementAmount, gasTradeOrderDO.getSettlementAmount());
        assertEquals(channelFavourAmount, gasTradeOrderDO.getChannelFavourAmount());
        assertEquals(memo, gasTradeOrderDO.getMemo());
        assertEquals(status, gasTradeOrderDO.getStatus());
        assertEquals(state, gasTradeOrderDO.getState());
        assertEquals(createTime, gasTradeOrderDO.getCreateTime());
        assertEquals(finishTime, gasTradeOrderDO.getFinishTime());
        assertEquals(rawAddTime, gasTradeOrderDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTradeOrderDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_trade_order表数据
	 */
	public void assertGasTradeOrder(GasTradeOrderDO expect, GasTradeOrderDO gasTradeOrderDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTradeOrderDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTradeOrderDO.getRawAddTime());
		expect.setRawAddTime(gasTradeOrderDO.getRawAddTime());
        Assertions.assertTrue(null != gasTradeOrderDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTradeOrderDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTradeOrderDO);
	}

    /**
	 * 插入gas_trade_order表数据
	 */
	public void insertGasTradeOrder(GasTradeOrderDO gasTradeOrderDO) {
		gasTradeOrderDAO.insert(gasTradeOrderDO);
	}

    /**
	 * 插入gas_trade_order表数据
	 */
	public void insertGasTradeOrder(
			Long id, 
			String tradeType, 
			String orderType, 
			String bizNo, 
			String reqId, 
			String gid, 
			String tradeNo, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String certNo, 
			String nickName, 
			String memberType, 
			String mobile, 
			String userGrade, 
			String groupCode, 
			String groupName, 
			String cardNo, 
			String cardType, 
			String cardBizType, 
			String carNumber, 
			Long balance, 
			String oilType, 
			String oilCode, 
			String oilName, 
			Long oilAmount, 
			Long oilFavourAmount, 
			Long goodsAmount, 
			Long goodsFavourAmount, 
			String payNo, 
			String tradePayType, 
			String payModel, 
			Long amount, 
			Long payAmount, 
			Long favourAmount, 
			Long feeAmount, 
			Long settlementAmount, 
			Long channelFavourAmount, 
			String memo, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTradeOrderDO gasTradeOrderDO = new GasTradeOrderDO();
		gasTradeOrderDO.setId(id);
		gasTradeOrderDO.setTradeType(tradeType);
		gasTradeOrderDO.setOrderType(orderType);
		gasTradeOrderDO.setBizNo(bizNo);
		gasTradeOrderDO.setReqId(reqId);
		gasTradeOrderDO.setGid(gid);
		gasTradeOrderDO.setTradeNo(tradeNo);
		gasTradeOrderDO.setPartnerId(partnerId);
		gasTradeOrderDO.setPartnerName(partnerName);
		gasTradeOrderDO.setStationId(stationId);
		gasTradeOrderDO.setStationCode(stationCode);
		gasTradeOrderDO.setStationName(stationName);
		gasTradeOrderDO.setOperateId(operateId);
		gasTradeOrderDO.setOperateName(operateName);
		gasTradeOrderDO.setTerminalType(terminalType);
		gasTradeOrderDO.setTerminalCode(terminalCode);
		gasTradeOrderDO.setUserId(userId);
		gasTradeOrderDO.setRealName(realName);
		gasTradeOrderDO.setCertNo(certNo);
		gasTradeOrderDO.setNickName(nickName);
		gasTradeOrderDO.setMemberType(memberType);
		gasTradeOrderDO.setMobile(mobile);
		gasTradeOrderDO.setUserGrade(userGrade);
		gasTradeOrderDO.setGroupCode(groupCode);
		gasTradeOrderDO.setGroupName(groupName);
		gasTradeOrderDO.setCardNo(cardNo);
		gasTradeOrderDO.setCardType(cardType);
		gasTradeOrderDO.setCardBizType(cardBizType);
		gasTradeOrderDO.setCarNumber(carNumber);
		gasTradeOrderDO.setBalance(balance);
		gasTradeOrderDO.setOilType(oilType);
		gasTradeOrderDO.setOilCode(oilCode);
		gasTradeOrderDO.setOilName(oilName);
		gasTradeOrderDO.setOilAmount(oilAmount);
		gasTradeOrderDO.setOilFavourAmount(oilFavourAmount);
		gasTradeOrderDO.setGoodsAmount(goodsAmount);
		gasTradeOrderDO.setGoodsFavourAmount(goodsFavourAmount);
		gasTradeOrderDO.setPayNo(payNo);
		gasTradeOrderDO.setTradePayType(tradePayType);
		gasTradeOrderDO.setPayModel(payModel);
		gasTradeOrderDO.setAmount(amount);
		gasTradeOrderDO.setPayAmount(payAmount);
		gasTradeOrderDO.setFavourAmount(favourAmount);
		gasTradeOrderDO.setFeeAmount(feeAmount);
		gasTradeOrderDO.setSettlementAmount(settlementAmount);
		gasTradeOrderDO.setChannelFavourAmount(channelFavourAmount);
		gasTradeOrderDO.setMemo(memo);
		gasTradeOrderDO.setStatus(status);
		gasTradeOrderDO.setState(state);
		gasTradeOrderDO.setCreateTime(createTime);
		gasTradeOrderDO.setFinishTime(finishTime);
		gasTradeOrderDO.setRawAddTime(rawAddTime);
		gasTradeOrderDO.setRawUpdateTime(rawUpdateTime);
		gasTradeOrderDAO.insert(gasTradeOrderDO);
	}

    /**
     * 删除gas_trade_order表所有数据
     */
    public void cleanGasTradeOrder() {
        GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
        exam.createCriteria();
        gasTradeOrderDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderById(Long id) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByTradeNo(String tradeNo) {
        if (StringUtils.isBlank(tradeNo)){
            tradeNo = "test_tradeNo";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据groupCode删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByGroupCode(String groupCode) {
        if (StringUtils.isBlank(groupCode)){
            groupCode = "test_groupCode";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据carNumber删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByCarNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)){
            carNumber = "test_carNumber";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据oilCode删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByOilCode(String oilCode) {
        if (StringUtils.isBlank(oilCode)){
            oilCode = "test_oilCode";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOilCodeEqualTo(oilCode);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	* 根据oilName删除gas_trade_order表数据
	*/
	public void cleanGasTradeOrderByOilName(String oilName) {
        if (StringUtils.isBlank(oilName)){
            oilName = "test_oilName";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOilNameEqualTo(oilName);
		gasTradeOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据payNo删除gas_trade_order表数据
	 */
	public void cleanGasTradeOrderByPayNo(String payNo) {
        if (StringUtils.isBlank(payNo)){
            payNo = "test_payNo";
        }
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPayNoEqualTo(payNo);
		gasTradeOrderDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_trade_order表所有数据
     */
    public List<GasTradeOrderDO> findGasTradeOrderAll() {
        GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
        exam.createCriteria();
		return gasTradeOrderDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderById(Long id) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByBizNo(String bizNo) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByReqId(String reqId) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByGid(String gid) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByTradeNo(String tradeNo) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByPartnerId(String partnerId) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByPartnerName(String partnerName) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByStationId(String stationId) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByStationCode(String stationCode) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByStationName(String stationName) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByOperateId(String operateId) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByOperateName(String operateName) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByTerminalCode(String terminalCode) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByUserId(String userId) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByRealName(String realName) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByCertNo(String certNo) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByNickName(String nickName) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByMobile(String mobile) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据groupCode查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByGroupCode(String groupCode) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByGroupName(String groupName) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByCardNo(String cardNo) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据carNumber查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByCarNumber(String carNumber) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据oilCode查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByOilCode(String oilCode) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOilCodeEqualTo(oilCode);
		return gasTradeOrderDAO.selectByExample(exam);
	}

	/**
	* 根据oilName查询gas_trade_order表数据
	*/
	public List<GasTradeOrderDO> findGasTradeOrderByOilName(String oilName) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOilNameEqualTo(oilName);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据payNo查询gas_trade_order表数据
	 */
	public List<GasTradeOrderDO> findGasTradeOrderByPayNo(String payNo) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPayNoEqualTo(payNo);
		return gasTradeOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderById(Long id,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据bizNo更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByBizNo(String bizNo,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据reqId更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByReqId(String reqId,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据gid更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByGid(String gid,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据tradeNo更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByTradeNo(String tradeNo,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据partnerId更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByPartnerId(String partnerId,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据partnerName更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByPartnerName(String partnerName,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据stationId更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByStationId(String stationId,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据stationCode更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByStationCode(String stationCode,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据stationName更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByStationName(String stationName,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据operateId更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByOperateId(String operateId,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据operateName更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByOperateName(String operateName,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据terminalCode更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByTerminalCode(String terminalCode,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据userId更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByUserId(String userId,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据realName更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByRealName(String realName,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据certNo更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByCertNo(String certNo,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据nickName更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByNickName(String nickName,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据mobile更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByMobile(String mobile,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据groupCode更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByGroupCode(String groupCode,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据groupName更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByGroupName(String groupName,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据cardNo更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByCardNo(String cardNo,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据oilCode更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByOilCode(String oilCode,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOilCodeEqualTo(oilCode);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

	/**
	* 根据oilName更新gas_trade_order表数据
	*/
	public void updateGasTradeOrderByOilName(String oilName,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andOilNameEqualTo(oilName);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 根据payNo更新gas_trade_order表数据
	 */
	public void updateGasTradeOrderByPayNo(String payNo,GasTradeOrderDO gasTradeOrderDO) {
		GasTradeOrderDOExample exam = new GasTradeOrderDOExample();
		exam.createCriteria().andPayNoEqualTo(payNo);
		gasTradeOrderDAO.updateByExample(gasTradeOrderDO, exam);
	}

    /**
	 * 断言gas_trade_points_redeem表
	 */
	public void gasTradePointsRedeemAssert(
	        GasTradePointsRedeemDO gasTradePointsRedeemDO,
			Long id, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String goodsId, 
			String goodsType, 
			String goodsName, 
			String goodsImg, 
			String couponType, 
			Integer goodsNum, 
			String gainStyle, 
			String gainAdr, 
			Integer points, 
			String memo, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTradePointsRedeemDO.getId());
        assertEquals(bizNo, gasTradePointsRedeemDO.getBizNo());
        assertEquals(reqId, gasTradePointsRedeemDO.getReqId());
        assertEquals(gid, gasTradePointsRedeemDO.getGid());
        assertEquals(partnerId, gasTradePointsRedeemDO.getPartnerId());
        assertEquals(partnerName, gasTradePointsRedeemDO.getPartnerName());
        assertEquals(stationId, gasTradePointsRedeemDO.getStationId());
        assertEquals(stationCode, gasTradePointsRedeemDO.getStationCode());
        assertEquals(stationName, gasTradePointsRedeemDO.getStationName());
        assertEquals(operateId, gasTradePointsRedeemDO.getOperateId());
        assertEquals(operateName, gasTradePointsRedeemDO.getOperateName());
        assertEquals(terminalType, gasTradePointsRedeemDO.getTerminalType());
        assertEquals(terminalCode, gasTradePointsRedeemDO.getTerminalCode());
        assertEquals(userId, gasTradePointsRedeemDO.getUserId());
        assertEquals(realName, gasTradePointsRedeemDO.getRealName());
        assertEquals(nickName, gasTradePointsRedeemDO.getNickName());
        assertEquals(memberType, gasTradePointsRedeemDO.getMemberType());
        assertEquals(mobile, gasTradePointsRedeemDO.getMobile());
        assertEquals(goodsId, gasTradePointsRedeemDO.getGoodsId());
        assertEquals(goodsType, gasTradePointsRedeemDO.getGoodsType());
        assertEquals(goodsName, gasTradePointsRedeemDO.getGoodsName());
        assertEquals(goodsImg, gasTradePointsRedeemDO.getGoodsImg());
        assertEquals(couponType, gasTradePointsRedeemDO.getCouponType());
        assertEquals(goodsNum, gasTradePointsRedeemDO.getGoodsNum());
        assertEquals(gainStyle, gasTradePointsRedeemDO.getGainStyle());
        assertEquals(gainAdr, gasTradePointsRedeemDO.getGainAdr());
        assertEquals(points, gasTradePointsRedeemDO.getPoints());
        assertEquals(memo, gasTradePointsRedeemDO.getMemo());
        assertEquals(status, gasTradePointsRedeemDO.getStatus());
        assertEquals(state, gasTradePointsRedeemDO.getState());
        assertEquals(createTime, gasTradePointsRedeemDO.getCreateTime());
        assertEquals(finishTime, gasTradePointsRedeemDO.getFinishTime());
        assertEquals(rawAddTime, gasTradePointsRedeemDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTradePointsRedeemDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_trade_points_redeem表数据
	 */
	public void assertGasTradePointsRedeem(GasTradePointsRedeemDO expect, GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTradePointsRedeemDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTradePointsRedeemDO.getRawAddTime());
		expect.setRawAddTime(gasTradePointsRedeemDO.getRawAddTime());
        Assertions.assertTrue(null != gasTradePointsRedeemDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTradePointsRedeemDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTradePointsRedeemDO);
	}

    /**
	 * 插入gas_trade_points_redeem表数据
	 */
	public void insertGasTradePointsRedeem(GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		gasTradePointsRedeemDAO.insert(gasTradePointsRedeemDO);
	}

    /**
	 * 插入gas_trade_points_redeem表数据
	 */
	public void insertGasTradePointsRedeem(
			Long id, 
			String bizNo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operateId, 
			String operateName, 
			String terminalType, 
			String terminalCode, 
			String userId, 
			String realName, 
			String nickName, 
			String memberType, 
			String mobile, 
			String goodsId, 
			String goodsType, 
			String goodsName, 
			String goodsImg, 
			String couponType, 
			Integer goodsNum, 
			String gainStyle, 
			String gainAdr, 
			Integer points, 
			String memo, 
			String status, 
			String state, 
			Date createTime, 
			Date finishTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTradePointsRedeemDO gasTradePointsRedeemDO = new GasTradePointsRedeemDO();
		gasTradePointsRedeemDO.setId(id);
		gasTradePointsRedeemDO.setBizNo(bizNo);
		gasTradePointsRedeemDO.setReqId(reqId);
		gasTradePointsRedeemDO.setGid(gid);
		gasTradePointsRedeemDO.setPartnerId(partnerId);
		gasTradePointsRedeemDO.setPartnerName(partnerName);
		gasTradePointsRedeemDO.setStationId(stationId);
		gasTradePointsRedeemDO.setStationCode(stationCode);
		gasTradePointsRedeemDO.setStationName(stationName);
		gasTradePointsRedeemDO.setOperateId(operateId);
		gasTradePointsRedeemDO.setOperateName(operateName);
		gasTradePointsRedeemDO.setTerminalType(terminalType);
		gasTradePointsRedeemDO.setTerminalCode(terminalCode);
		gasTradePointsRedeemDO.setUserId(userId);
		gasTradePointsRedeemDO.setRealName(realName);
		gasTradePointsRedeemDO.setNickName(nickName);
		gasTradePointsRedeemDO.setMemberType(memberType);
		gasTradePointsRedeemDO.setMobile(mobile);
		gasTradePointsRedeemDO.setGoodsId(goodsId);
		gasTradePointsRedeemDO.setGoodsType(goodsType);
		gasTradePointsRedeemDO.setGoodsName(goodsName);
		gasTradePointsRedeemDO.setGoodsImg(goodsImg);
		gasTradePointsRedeemDO.setCouponType(couponType);
		gasTradePointsRedeemDO.setGoodsNum(goodsNum);
		gasTradePointsRedeemDO.setGainStyle(gainStyle);
		gasTradePointsRedeemDO.setGainAdr(gainAdr);
		gasTradePointsRedeemDO.setPoints(points);
		gasTradePointsRedeemDO.setMemo(memo);
		gasTradePointsRedeemDO.setStatus(status);
		gasTradePointsRedeemDO.setState(state);
		gasTradePointsRedeemDO.setCreateTime(createTime);
		gasTradePointsRedeemDO.setFinishTime(finishTime);
		gasTradePointsRedeemDO.setRawAddTime(rawAddTime);
		gasTradePointsRedeemDO.setRawUpdateTime(rawUpdateTime);
		gasTradePointsRedeemDAO.insert(gasTradePointsRedeemDO);
	}

    /**
     * 删除gas_trade_points_redeem表所有数据
     */
    public void cleanGasTradePointsRedeem() {
        GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
        exam.createCriteria();
        gasTradePointsRedeemDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemById(Long id) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据operateName删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByOperateName(String operateName) {
        if (StringUtils.isBlank(operateName)){
            operateName = "test_operateName";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	 * 根据goodsId删除gas_trade_points_redeem表数据
	 */
	public void cleanGasTradePointsRedeemByGoodsId(String goodsId) {
        if (StringUtils.isBlank(goodsId)){
            goodsId = "test_goodsId";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_trade_points_redeem表数据
	*/
	public void cleanGasTradePointsRedeemByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasTradePointsRedeemDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_trade_points_redeem表所有数据
     */
    public List<GasTradePointsRedeemDO> findGasTradePointsRedeemAll() {
        GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
        exam.createCriteria();
		return gasTradePointsRedeemDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemById(Long id) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByBizNo(String bizNo) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByReqId(String reqId) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByGid(String gid) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByPartnerId(String partnerId) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByPartnerName(String partnerName) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByStationId(String stationId) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByStationCode(String stationCode) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByStationName(String stationName) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByOperateId(String operateId) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据operateName查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByOperateName(String operateName) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByTerminalCode(String terminalCode) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByUserId(String userId) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByRealName(String realName) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByNickName(String nickName) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByMobile(String mobile) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据goodsId查询gas_trade_points_redeem表数据
	 */
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByGoodsId(String goodsId) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_trade_points_redeem表数据
	*/
	public List<GasTradePointsRedeemDO> findGasTradePointsRedeemByGoodsName(String goodsName) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasTradePointsRedeemDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemById(Long id,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据bizNo更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByBizNo(String bizNo,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据reqId更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByReqId(String reqId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据gid更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByGid(String gid,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据partnerId更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByPartnerId(String partnerId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据partnerName更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByPartnerName(String partnerName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据stationId更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByStationId(String stationId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据stationCode更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByStationCode(String stationCode,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据stationName更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByStationName(String stationName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据operateId更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByOperateId(String operateId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据operateName更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByOperateName(String operateName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andOperateNameEqualTo(operateName);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据terminalCode更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByTerminalCode(String terminalCode,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据userId更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByUserId(String userId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据realName更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByRealName(String realName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据nickName更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByNickName(String nickName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据mobile更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByMobile(String mobile,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 根据goodsId更新gas_trade_points_redeem表数据
	 */
	public void updateGasTradePointsRedeemByGoodsId(String goodsId,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

	/**
	* 根据goodsName更新gas_trade_points_redeem表数据
	*/
	public void updateGasTradePointsRedeemByGoodsName(String goodsName,GasTradePointsRedeemDO gasTradePointsRedeemDO) {
		GasTradePointsRedeemDOExample exam = new GasTradePointsRedeemDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasTradePointsRedeemDAO.updateByExample(gasTradePointsRedeemDO, exam);
	}

    /**
	 * 断言gas_user表
	 */
	public void gasUserAssert(
	        GasUserDO gasUserDO,
			Long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String shortBirthday, 
			String nickName, 
			String realName, 
			String certNo, 
			String accountTag, 
			String headImgUrl, 
			String carNumber, 
			String carType, 
			String sex, 
			String memberType, 
			String grade, 
			String groupName, 
			String groupCode, 
			String recommendSource, 
			String recommendId, 
			String recommendStationId, 
			String recommendStationName, 
			String recommendStationCode, 
			String recommendMobile, 
			String recommendName, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasUserDO.getId());
        assertEquals(userId, gasUserDO.getUserId());
        assertEquals(partnerId, gasUserDO.getPartnerId());
        assertEquals(mobile, gasUserDO.getMobile());
        assertEquals(birthday, gasUserDO.getBirthday());
        assertEquals(shortBirthday, gasUserDO.getShortBirthday());
        assertEquals(nickName, gasUserDO.getNickName());
        assertEquals(realName, gasUserDO.getRealName());
        assertEquals(certNo, gasUserDO.getCertNo());
        assertEquals(accountTag, gasUserDO.getAccountTag());
        assertEquals(headImgUrl, gasUserDO.getHeadImgUrl());
        assertEquals(carNumber, gasUserDO.getCarNumber());
        assertEquals(carType, gasUserDO.getCarType());
        assertEquals(sex, gasUserDO.getSex());
        assertEquals(memberType, gasUserDO.getMemberType());
        assertEquals(grade, gasUserDO.getGrade());
        assertEquals(groupName, gasUserDO.getGroupName());
        assertEquals(groupCode, gasUserDO.getGroupCode());
        assertEquals(recommendSource, gasUserDO.getRecommendSource());
        assertEquals(recommendId, gasUserDO.getRecommendId());
        assertEquals(recommendStationId, gasUserDO.getRecommendStationId());
        assertEquals(recommendStationName, gasUserDO.getRecommendStationName());
        assertEquals(recommendStationCode, gasUserDO.getRecommendStationCode());
        assertEquals(recommendMobile, gasUserDO.getRecommendMobile());
        assertEquals(recommendName, gasUserDO.getRecommendName());
        assertEquals(createTime, gasUserDO.getCreateTime());
        assertEquals(updateTime, gasUserDO.getUpdateTime());
        assertEquals(rawAddTime, gasUserDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasUserDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_user表数据
	 */
	public void assertGasUser(GasUserDO expect, GasUserDO gasUserDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasUserDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasUserDO.getRawAddTime());
		expect.setRawAddTime(gasUserDO.getRawAddTime());
        Assertions.assertTrue(null != gasUserDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasUserDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasUserDO);
	}

    /**
	 * 插入gas_user表数据
	 */
	public void insertGasUser(GasUserDO gasUserDO) {
		gasUserDAO.insert(gasUserDO);
	}

    /**
	 * 插入gas_user表数据
	 */
	public void insertGasUser(
			Long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String shortBirthday, 
			String nickName, 
			String realName, 
			String certNo, 
			String accountTag, 
			String headImgUrl, 
			String carNumber, 
			String carType, 
			String sex, 
			String memberType, 
			String grade, 
			String groupName, 
			String groupCode, 
			String recommendSource, 
			String recommendId, 
			String recommendStationId, 
			String recommendStationName, 
			String recommendStationCode, 
			String recommendMobile, 
			String recommendName, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasUserDO gasUserDO = new GasUserDO();
		gasUserDO.setId(id);
		gasUserDO.setUserId(userId);
		gasUserDO.setPartnerId(partnerId);
		gasUserDO.setMobile(mobile);
		gasUserDO.setBirthday(birthday);
		gasUserDO.setShortBirthday(shortBirthday);
		gasUserDO.setNickName(nickName);
		gasUserDO.setRealName(realName);
		gasUserDO.setCertNo(certNo);
		gasUserDO.setAccountTag(accountTag);
		gasUserDO.setHeadImgUrl(headImgUrl);
		gasUserDO.setCarNumber(carNumber);
		gasUserDO.setCarType(carType);
		gasUserDO.setSex(sex);
		gasUserDO.setMemberType(memberType);
		gasUserDO.setGrade(grade);
		gasUserDO.setGroupName(groupName);
		gasUserDO.setGroupCode(groupCode);
		gasUserDO.setRecommendSource(recommendSource);
		gasUserDO.setRecommendId(recommendId);
		gasUserDO.setRecommendStationId(recommendStationId);
		gasUserDO.setRecommendStationName(recommendStationName);
		gasUserDO.setRecommendStationCode(recommendStationCode);
		gasUserDO.setRecommendMobile(recommendMobile);
		gasUserDO.setRecommendName(recommendName);
		gasUserDO.setCreateTime(createTime);
		gasUserDO.setUpdateTime(updateTime);
		gasUserDO.setRawAddTime(rawAddTime);
		gasUserDO.setRawUpdateTime(rawUpdateTime);
		gasUserDAO.insert(gasUserDO);
	}

    /**
     * 删除gas_user表所有数据
     */
    public void cleanGasUser() {
        GasUserDOExample exam = new GasUserDOExample();
        exam.createCriteria();
        gasUserDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_user表数据
	 */
	public void cleanGasUserById(Long id) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_user表数据
	 */
	public void cleanGasUserByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasUserDAO.deleteByExample(exam);
	}
	/**
	 * 根据partnerId,mobile删除gas_user表数据
	 */
	public void cleanGasUserByPartnerIdAndMobile(String partnerId,String mobile) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andMobileEqualTo(mobile);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_user表数据
	 */
	public void cleanGasUserByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除gas_user表数据
	 */
	public void cleanGasUserByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除gas_user表数据
	*/
	public void cleanGasUserByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除gas_user表数据
	*/
	public void cleanGasUserByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除gas_user表数据
	 */
	public void cleanGasUserByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据carNumber删除gas_user表数据
	*/
	public void cleanGasUserByCarNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)){
            carNumber = "test_carNumber";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除gas_user表数据
	*/
	public void cleanGasUserByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据groupCode删除gas_user表数据
	*/
	public void cleanGasUserByGroupCode(String groupCode) {
        if (StringUtils.isBlank(groupCode)){
            groupCode = "test_groupCode";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据recommendId删除gas_user表数据
	 */
	public void cleanGasUserByRecommendId(String recommendId) {
        if (StringUtils.isBlank(recommendId)){
            recommendId = "test_recommendId";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendIdEqualTo(recommendId);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据recommendStationId删除gas_user表数据
	 */
	public void cleanGasUserByRecommendStationId(String recommendStationId) {
        if (StringUtils.isBlank(recommendStationId)){
            recommendStationId = "test_recommendStationId";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationIdEqualTo(recommendStationId);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据recommendStationName删除gas_user表数据
	*/
	public void cleanGasUserByRecommendStationName(String recommendStationName) {
        if (StringUtils.isBlank(recommendStationName)){
            recommendStationName = "test_recommendStationName";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationNameEqualTo(recommendStationName);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据recommendStationCode删除gas_user表数据
	*/
	public void cleanGasUserByRecommendStationCode(String recommendStationCode) {
        if (StringUtils.isBlank(recommendStationCode)){
            recommendStationCode = "test_recommendStationCode";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationCodeEqualTo(recommendStationCode);
		gasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据recommendName删除gas_user表数据
	*/
	public void cleanGasUserByRecommendName(String recommendName) {
        if (StringUtils.isBlank(recommendName)){
            recommendName = "test_recommendName";
        }
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendNameEqualTo(recommendName);
		gasUserDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_user表所有数据
     */
    public List<GasUserDO> findGasUserAll() {
        GasUserDOExample exam = new GasUserDOExample();
        exam.createCriteria();
		return gasUserDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserById(Long id) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserByUserId(String userId) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	 * 根据partnerId,mobile查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserByPartnerIdAndMobile(String partnerId,String mobile) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andMobileEqualTo(mobile);
		return gasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserByPartnerId(String partnerId) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserByMobile(String mobile) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByNickName(String nickName) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByRealName(String realName) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return gasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserByCertNo(String certNo) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据carNumber查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByCarNumber(String carNumber) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByGroupName(String groupName) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据groupCode查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByGroupCode(String groupCode) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		return gasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据recommendId查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserByRecommendId(String recommendId) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendIdEqualTo(recommendId);
		return gasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据recommendStationId查询gas_user表数据
	 */
	public List<GasUserDO> findGasUserByRecommendStationId(String recommendStationId) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationIdEqualTo(recommendStationId);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据recommendStationName查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByRecommendStationName(String recommendStationName) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationNameEqualTo(recommendStationName);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据recommendStationCode查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByRecommendStationCode(String recommendStationCode) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationCodeEqualTo(recommendStationCode);
		return gasUserDAO.selectByExample(exam);
	}

	/**
	* 根据recommendName查询gas_user表数据
	*/
	public List<GasUserDO> findGasUserByRecommendName(String recommendName) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendNameEqualTo(recommendName);
		return gasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_user表数据
	 */
	public void updateGasUserById(Long id,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

    /**
	 * 根据userId更新gas_user表数据
	 */
	public void updateGasUserByUserId(String userId,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	 * 根据partnerId,mobile更新gas_user表数据
	 */
	public void updateGasUserByPartnerIdAndMobile(String partnerId,String mobile,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andMobileEqualTo(mobile);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

    /**
	 * 根据partnerId更新gas_user表数据
	 */
	public void updateGasUserByPartnerId(String partnerId,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

    /**
	 * 根据mobile更新gas_user表数据
	 */
	public void updateGasUserByMobile(String mobile,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	* 根据nickName更新gas_user表数据
	*/
	public void updateGasUserByNickName(String nickName,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	* 根据realName更新gas_user表数据
	*/
	public void updateGasUserByRealName(String realName,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

    /**
	 * 根据certNo更新gas_user表数据
	 */
	public void updateGasUserByCertNo(String certNo,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	* 根据groupName更新gas_user表数据
	*/
	public void updateGasUserByGroupName(String groupName,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	* 根据groupCode更新gas_user表数据
	*/
	public void updateGasUserByGroupCode(String groupCode,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andGroupCodeEqualTo(groupCode);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

    /**
	 * 根据recommendId更新gas_user表数据
	 */
	public void updateGasUserByRecommendId(String recommendId,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendIdEqualTo(recommendId);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

    /**
	 * 根据recommendStationId更新gas_user表数据
	 */
	public void updateGasUserByRecommendStationId(String recommendStationId,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationIdEqualTo(recommendStationId);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	* 根据recommendStationName更新gas_user表数据
	*/
	public void updateGasUserByRecommendStationName(String recommendStationName,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationNameEqualTo(recommendStationName);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	* 根据recommendStationCode更新gas_user表数据
	*/
	public void updateGasUserByRecommendStationCode(String recommendStationCode,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendStationCodeEqualTo(recommendStationCode);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

	/**
	* 根据recommendName更新gas_user表数据
	*/
	public void updateGasUserByRecommendName(String recommendName,GasUserDO gasUserDO) {
		GasUserDOExample exam = new GasUserDOExample();
		exam.createCriteria().andRecommendNameEqualTo(recommendName);
		gasUserDAO.updateByExample(gasUserDO, exam);
	}

    /**
	 * 断言gas_user_group表
	 */
	public void gasUserGroupAssert(
	        GasUserGroupDO gasUserGroupDO,
			Long id, 
			String userGroupNo, 
			String platPartnerId, 
			String name, 
			String userGroupType, 
			String memo, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasUserGroupDO.getId());
        assertEquals(userGroupNo, gasUserGroupDO.getUserGroupNo());
        assertEquals(platPartnerId, gasUserGroupDO.getPlatPartnerId());
        assertEquals(name, gasUserGroupDO.getName());
        assertEquals(userGroupType, gasUserGroupDO.getUserGroupType());
        assertEquals(memo, gasUserGroupDO.getMemo());
        assertEquals(createTime, gasUserGroupDO.getCreateTime());
        assertEquals(updateTime, gasUserGroupDO.getUpdateTime());
        assertEquals(rawAddTime, gasUserGroupDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasUserGroupDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_user_group表数据
	 */
	public void assertGasUserGroup(GasUserGroupDO expect, GasUserGroupDO gasUserGroupDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasUserGroupDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasUserGroupDO.getRawAddTime());
		expect.setRawAddTime(gasUserGroupDO.getRawAddTime());
        Assertions.assertTrue(null != gasUserGroupDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasUserGroupDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasUserGroupDO);
	}

    /**
	 * 插入gas_user_group表数据
	 */
	public void insertGasUserGroup(GasUserGroupDO gasUserGroupDO) {
		gasUserGroupDAO.insert(gasUserGroupDO);
	}

    /**
	 * 插入gas_user_group表数据
	 */
	public void insertGasUserGroup(
			Long id, 
			String userGroupNo, 
			String platPartnerId, 
			String name, 
			String userGroupType, 
			String memo, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasUserGroupDO gasUserGroupDO = new GasUserGroupDO();
		gasUserGroupDO.setId(id);
		gasUserGroupDO.setUserGroupNo(userGroupNo);
		gasUserGroupDO.setPlatPartnerId(platPartnerId);
		gasUserGroupDO.setName(name);
		gasUserGroupDO.setUserGroupType(userGroupType);
		gasUserGroupDO.setMemo(memo);
		gasUserGroupDO.setCreateTime(createTime);
		gasUserGroupDO.setUpdateTime(updateTime);
		gasUserGroupDO.setRawAddTime(rawAddTime);
		gasUserGroupDO.setRawUpdateTime(rawUpdateTime);
		gasUserGroupDAO.insert(gasUserGroupDO);
	}

    /**
     * 删除gas_user_group表所有数据
     */
    public void cleanGasUserGroup() {
        GasUserGroupDOExample exam = new GasUserGroupDOExample();
        exam.createCriteria();
        gasUserGroupDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_user_group表数据
	 */
	public void cleanGasUserGroupById(Long id) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasUserGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据userGroupNo删除gas_user_group表数据
	 */
	public void cleanGasUserGroupByUserGroupNo(String userGroupNo) {
        if (StringUtils.isBlank(userGroupNo)){
            userGroupNo = "test_userGroupNo";
        }
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		gasUserGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_user_group表数据
	 */
	public void cleanGasUserGroupByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasUserGroupDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除gas_user_group表数据
	*/
	public void cleanGasUserGroupByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasUserGroupDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_user_group表所有数据
     */
    public List<GasUserGroupDO> findGasUserGroupAll() {
        GasUserGroupDOExample exam = new GasUserGroupDOExample();
        exam.createCriteria();
		return gasUserGroupDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_user_group表数据
	 */
	public List<GasUserGroupDO> findGasUserGroupById(Long id) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasUserGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据userGroupNo查询gas_user_group表数据
	 */
	public List<GasUserGroupDO> findGasUserGroupByUserGroupNo(String userGroupNo) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		return gasUserGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_user_group表数据
	 */
	public List<GasUserGroupDO> findGasUserGroupByPlatPartnerId(String platPartnerId) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasUserGroupDAO.selectByExample(exam);
	}

	/**
	* 根据name查询gas_user_group表数据
	*/
	public List<GasUserGroupDO> findGasUserGroupByName(String name) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return gasUserGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_user_group表数据
	 */
	public void updateGasUserGroupById(Long id,GasUserGroupDO gasUserGroupDO) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasUserGroupDAO.updateByExample(gasUserGroupDO, exam);
	}

    /**
	 * 根据userGroupNo更新gas_user_group表数据
	 */
	public void updateGasUserGroupByUserGroupNo(String userGroupNo,GasUserGroupDO gasUserGroupDO) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		gasUserGroupDAO.updateByExample(gasUserGroupDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_user_group表数据
	 */
	public void updateGasUserGroupByPlatPartnerId(String platPartnerId,GasUserGroupDO gasUserGroupDO) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasUserGroupDAO.updateByExample(gasUserGroupDO, exam);
	}

	/**
	* 根据name更新gas_user_group表数据
	*/
	public void updateGasUserGroupByName(String name,GasUserGroupDO gasUserGroupDO) {
		GasUserGroupDOExample exam = new GasUserGroupDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasUserGroupDAO.updateByExample(gasUserGroupDO, exam);
	}

    /**
	 * 断言group_script表
	 */
	public void groupScriptAssert(
	        GroupScriptDO groupScriptDO,
			Long id, 
			String columnCode, 
			String title, 
			Integer cascadeLevel, 
			String scriptFunction, 
			String scriptType, 
			String script, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, groupScriptDO.getId());
        assertEquals(columnCode, groupScriptDO.getColumnCode());
        assertEquals(title, groupScriptDO.getTitle());
        assertEquals(cascadeLevel, groupScriptDO.getCascadeLevel());
        assertEquals(scriptFunction, groupScriptDO.getScriptFunction());
        assertEquals(scriptType, groupScriptDO.getScriptType());
        assertEquals(script, groupScriptDO.getScript());
        assertEquals(memo, groupScriptDO.getMemo());
        assertEquals(rawAddTime, groupScriptDO.getRawAddTime());
        assertEquals(rawUpdateTime, groupScriptDO.getRawUpdateTime());
	}

	/**
	 * 断言group_script表数据
	 */
	public void assertGroupScript(GroupScriptDO expect, GroupScriptDO groupScriptDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			groupScriptDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != groupScriptDO.getRawAddTime());
		expect.setRawAddTime(groupScriptDO.getRawAddTime());
        Assertions.assertTrue(null != groupScriptDO.getRawUpdateTime());
		expect.setRawUpdateTime(groupScriptDO.getRawUpdateTime());
		Assertions.assertEquals(expect, groupScriptDO);
	}

    /**
	 * 插入group_script表数据
	 */
	public void insertGroupScript(GroupScriptDO groupScriptDO) {
		groupScriptDAO.insert(groupScriptDO);
	}

    /**
	 * 插入group_script表数据
	 */
	public void insertGroupScript(
			Long id, 
			String columnCode, 
			String title, 
			Integer cascadeLevel, 
			String scriptFunction, 
			String scriptType, 
			String script, 
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
		GroupScriptDO groupScriptDO = new GroupScriptDO();
		groupScriptDO.setId(id);
		groupScriptDO.setColumnCode(columnCode);
		groupScriptDO.setTitle(title);
		groupScriptDO.setCascadeLevel(cascadeLevel);
		groupScriptDO.setScriptFunction(scriptFunction);
		groupScriptDO.setScriptType(scriptType);
		groupScriptDO.setScript(script);
		groupScriptDO.setMemo(memo);
		groupScriptDO.setRawAddTime(rawAddTime);
		groupScriptDO.setRawUpdateTime(rawUpdateTime);
		groupScriptDAO.insert(groupScriptDO);
	}

    /**
     * 删除group_script表所有数据
     */
    public void cleanGroupScript() {
        GroupScriptDOExample exam = new GroupScriptDOExample();
        exam.createCriteria();
        groupScriptDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除group_script表数据
	 */
	public void cleanGroupScriptById(Long id) {
		GroupScriptDOExample exam = new GroupScriptDOExample();
		exam.createCriteria().andIdEqualTo(id);
		groupScriptDAO.deleteByExample(exam);
	}

	/**
	* 根据columnCode删除group_script表数据
	*/
	public void cleanGroupScriptByColumnCode(String columnCode) {
        if (StringUtils.isBlank(columnCode)){
            columnCode = "test_columnCode";
        }
		GroupScriptDOExample exam = new GroupScriptDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		groupScriptDAO.deleteByExample(exam);
	}

    /**
     * 查询group_script表所有数据
     */
    public List<GroupScriptDO> findGroupScriptAll() {
        GroupScriptDOExample exam = new GroupScriptDOExample();
        exam.createCriteria();
		return groupScriptDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询group_script表数据
	 */
	public List<GroupScriptDO> findGroupScriptById(Long id) {
		GroupScriptDOExample exam = new GroupScriptDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return groupScriptDAO.selectByExample(exam);
	}

	/**
	* 根据columnCode查询group_script表数据
	*/
	public List<GroupScriptDO> findGroupScriptByColumnCode(String columnCode) {
		GroupScriptDOExample exam = new GroupScriptDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		return groupScriptDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新group_script表数据
	 */
	public void updateGroupScriptById(Long id,GroupScriptDO groupScriptDO) {
		GroupScriptDOExample exam = new GroupScriptDOExample();
		exam.createCriteria().andIdEqualTo(id);
		groupScriptDAO.updateByExample(groupScriptDO, exam);
	}

	/**
	* 根据columnCode更新group_script表数据
	*/
	public void updateGroupScriptByColumnCode(String columnCode,GroupScriptDO groupScriptDO) {
		GroupScriptDOExample exam = new GroupScriptDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		groupScriptDAO.updateByExample(groupScriptDO, exam);
	}

    /**
	 * 断言merchant_report表
	 */
	public void merchantReportAssert(
	        MerchantReportDO merchantReportDO,
			Long id, 
			String partnerId, 
			String partnerName, 
			Long reportId, 
			String reportCode, 
			String reportRule, 
			String ruleName, 
			String reportStatus, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantReportDO.getId());
        assertEquals(partnerId, merchantReportDO.getPartnerId());
        assertEquals(partnerName, merchantReportDO.getPartnerName());
        assertEquals(reportId, merchantReportDO.getReportId());
        assertEquals(reportCode, merchantReportDO.getReportCode());
        assertEquals(reportRule, merchantReportDO.getReportRule());
        assertEquals(ruleName, merchantReportDO.getRuleName());
        assertEquals(reportStatus, merchantReportDO.getReportStatus());
        assertEquals(memo, merchantReportDO.getMemo());
        assertEquals(rawAddTime, merchantReportDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantReportDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_report表数据
	 */
	public void assertMerchantReport(MerchantReportDO expect, MerchantReportDO merchantReportDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantReportDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantReportDO.getRawAddTime());
		expect.setRawAddTime(merchantReportDO.getRawAddTime());
        Assertions.assertTrue(null != merchantReportDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantReportDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantReportDO);
	}

    /**
	 * 插入merchant_report表数据
	 */
	public void insertMerchantReport(MerchantReportDO merchantReportDO) {
		merchantReportDAO.insert(merchantReportDO);
	}

    /**
	 * 插入merchant_report表数据
	 */
	public void insertMerchantReport(
			Long id, 
			String partnerId, 
			String partnerName, 
			Long reportId, 
			String reportCode, 
			String reportRule, 
			String ruleName, 
			String reportStatus, 
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
		MerchantReportDO merchantReportDO = new MerchantReportDO();
		merchantReportDO.setId(id);
		merchantReportDO.setPartnerId(partnerId);
		merchantReportDO.setPartnerName(partnerName);
		merchantReportDO.setReportId(reportId);
		merchantReportDO.setReportCode(reportCode);
		merchantReportDO.setReportRule(reportRule);
		merchantReportDO.setRuleName(ruleName);
		merchantReportDO.setReportStatus(reportStatus);
		merchantReportDO.setMemo(memo);
		merchantReportDO.setRawAddTime(rawAddTime);
		merchantReportDO.setRawUpdateTime(rawUpdateTime);
		merchantReportDAO.insert(merchantReportDO);
	}

    /**
     * 删除merchant_report表所有数据
     */
    public void cleanMerchantReport() {
        MerchantReportDOExample exam = new MerchantReportDOExample();
        exam.createCriteria();
        merchantReportDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_report表数据
	 */
	public void cleanMerchantReportById(Long id) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantReportDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_report表数据
	 */
	public void cleanMerchantReportByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantReportDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除merchant_report表数据
	*/
	public void cleanMerchantReportByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		merchantReportDAO.deleteByExample(exam);
	}

	/**
	 * 根据reportId删除merchant_report表数据
	 */
	public void cleanMerchantReportByReportId(Long reportId) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andReportIdEqualTo(reportId);
		merchantReportDAO.deleteByExample(exam);
	}

	/**
	* 根据reportCode删除merchant_report表数据
	*/
	public void cleanMerchantReportByReportCode(String reportCode) {
        if (StringUtils.isBlank(reportCode)){
            reportCode = "test_reportCode";
        }
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andReportCodeEqualTo(reportCode);
		merchantReportDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleName删除merchant_report表数据
	*/
	public void cleanMerchantReportByRuleName(String ruleName) {
        if (StringUtils.isBlank(ruleName)){
            ruleName = "test_ruleName";
        }
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andRuleNameEqualTo(ruleName);
		merchantReportDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_report表所有数据
     */
    public List<MerchantReportDO> findMerchantReportAll() {
        MerchantReportDOExample exam = new MerchantReportDOExample();
        exam.createCriteria();
		return merchantReportDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_report表数据
	 */
	public List<MerchantReportDO> findMerchantReportById(Long id) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantReportDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_report表数据
	 */
	public List<MerchantReportDO> findMerchantReportByPartnerId(String partnerId) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantReportDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询merchant_report表数据
	*/
	public List<MerchantReportDO> findMerchantReportByPartnerName(String partnerName) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return merchantReportDAO.selectByExample(exam);
	}

    /**
	 * 根据reportId查询merchant_report表数据
	 */
	public List<MerchantReportDO> findMerchantReportByReportId(Long reportId) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andReportIdEqualTo(reportId);
		return merchantReportDAO.selectByExample(exam);
	}

	/**
	* 根据reportCode查询merchant_report表数据
	*/
	public List<MerchantReportDO> findMerchantReportByReportCode(String reportCode) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andReportCodeEqualTo(reportCode);
		return merchantReportDAO.selectByExample(exam);
	}

	/**
	* 根据ruleName查询merchant_report表数据
	*/
	public List<MerchantReportDO> findMerchantReportByRuleName(String ruleName) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andRuleNameEqualTo(ruleName);
		return merchantReportDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_report表数据
	 */
	public void updateMerchantReportById(Long id,MerchantReportDO merchantReportDO) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantReportDAO.updateByExample(merchantReportDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_report表数据
	 */
	public void updateMerchantReportByPartnerId(String partnerId,MerchantReportDO merchantReportDO) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantReportDAO.updateByExample(merchantReportDO, exam);
	}

	/**
	* 根据partnerName更新merchant_report表数据
	*/
	public void updateMerchantReportByPartnerName(String partnerName,MerchantReportDO merchantReportDO) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		merchantReportDAO.updateByExample(merchantReportDO, exam);
	}

    /**
	 * 根据reportId更新merchant_report表数据
	 */
	public void updateMerchantReportByReportId(Long reportId,MerchantReportDO merchantReportDO) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andReportIdEqualTo(reportId);
		merchantReportDAO.updateByExample(merchantReportDO, exam);
	}

	/**
	* 根据reportCode更新merchant_report表数据
	*/
	public void updateMerchantReportByReportCode(String reportCode,MerchantReportDO merchantReportDO) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andReportCodeEqualTo(reportCode);
		merchantReportDAO.updateByExample(merchantReportDO, exam);
	}

	/**
	* 根据ruleName更新merchant_report表数据
	*/
	public void updateMerchantReportByRuleName(String ruleName,MerchantReportDO merchantReportDO) {
		MerchantReportDOExample exam = new MerchantReportDOExample();
		exam.createCriteria().andRuleNameEqualTo(ruleName);
		merchantReportDAO.updateByExample(merchantReportDO, exam);
	}

    /**
	 * 断言notify_task表
	 */
	public void notifyTaskAssert(
	        NotifyTaskDO notifyTaskDO,
			Long id, 
			String identity, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String status, 
			String detail, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
        assertEquals(id, notifyTaskDO.getId());
        assertEquals(identity, notifyTaskDO.getIdentity());
        assertEquals(notifyType, notifyTaskDO.getNotifyType());
        assertEquals(retryCount, notifyTaskDO.getRetryCount());
        assertEquals(maxRetryCount, notifyTaskDO.getMaxRetryCount());
        assertEquals(status, notifyTaskDO.getStatus());
        assertEquals(detail, notifyTaskDO.getDetail());
        assertEquals(gid, notifyTaskDO.getGid());
        assertEquals(rawAddTime, notifyTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, notifyTaskDO.getRawUpdateTime());
        assertEquals(context, notifyTaskDO.getContext());
	}

	/**
	 * 断言notify_task表数据
	 */
	public void assertNotifyTask(NotifyTaskDO expect, NotifyTaskDO notifyTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			notifyTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != notifyTaskDO.getRawAddTime());
		expect.setRawAddTime(notifyTaskDO.getRawAddTime());
        Assertions.assertTrue(null != notifyTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(notifyTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, notifyTaskDO);
	}

    /**
	 * 插入notify_task表数据
	 */
	public void insertNotifyTask(NotifyTaskDO notifyTaskDO) {
		notifyTaskDAO.insert(notifyTaskDO);
	}

    /**
	 * 插入notify_task表数据
	 */
	public void insertNotifyTask(
			Long id, 
			String identity, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String status, 
			String detail, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		NotifyTaskDO notifyTaskDO = new NotifyTaskDO();
		notifyTaskDO.setId(id);
		notifyTaskDO.setIdentity(identity);
		notifyTaskDO.setNotifyType(notifyType);
		notifyTaskDO.setRetryCount(retryCount);
		notifyTaskDO.setMaxRetryCount(maxRetryCount);
		notifyTaskDO.setStatus(status);
		notifyTaskDO.setDetail(detail);
		notifyTaskDO.setGid(gid);
		notifyTaskDO.setRawAddTime(rawAddTime);
		notifyTaskDO.setRawUpdateTime(rawUpdateTime);
		notifyTaskDO.setContext(context);
		notifyTaskDAO.insert(notifyTaskDO);
	}

    /**
     * 删除notify_task表所有数据
     */
    public void cleanNotifyTask() {
        NotifyTaskDOExample exam = new NotifyTaskDOExample();
        exam.createCriteria();
        notifyTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除notify_task表数据
	 */
	public void cleanNotifyTaskById(Long id) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		notifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据identity删除notify_task表数据
	 */
	public void cleanNotifyTaskByIdentity(String identity) {
        if (StringUtils.isBlank(identity)){
            identity = "test_identity";
        }
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		notifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除notify_task表数据
	 */
	public void cleanNotifyTaskByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		notifyTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询notify_task表所有数据
     */
    public List<NotifyTaskDO> findNotifyTaskAll() {
        NotifyTaskDOExample exam = new NotifyTaskDOExample();
        exam.createCriteria();
		return notifyTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskById(Long id) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return notifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据identity查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskByIdentity(String identity) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return notifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskByGid(String gid) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return notifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新notify_task表数据
	 */
	public void updateNotifyTaskById(Long id,NotifyTaskDO notifyTaskDO) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		notifyTaskDAO.updateByExample(notifyTaskDO, exam);
	}

    /**
	 * 根据identity更新notify_task表数据
	 */
	public void updateNotifyTaskByIdentity(String identity,NotifyTaskDO notifyTaskDO) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		notifyTaskDAO.updateByExample(notifyTaskDO, exam);
	}

    /**
	 * 根据gid更新notify_task表数据
	 */
	public void updateNotifyTaskByGid(String gid,NotifyTaskDO notifyTaskDO) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		notifyTaskDAO.updateByExample(notifyTaskDO, exam);
	}

    /**
	 * 断言persona_task表
	 */
	public void personaTaskAssert(
	        PersonaTaskDO personaTaskDO,
			Long id, 
			Long personaId, 
			String gid, 
			String generateType, 
			String topic, 
			String event, 
			String fileName, 
			String filePath, 
			Long personaCount, 
			Long personaIndex, 
			String status, 
			String message, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, personaTaskDO.getId());
        assertEquals(personaId, personaTaskDO.getPersonaId());
        assertEquals(gid, personaTaskDO.getGid());
        assertEquals(generateType, personaTaskDO.getGenerateType());
        assertEquals(topic, personaTaskDO.getTopic());
        assertEquals(event, personaTaskDO.getEvent());
        assertEquals(fileName, personaTaskDO.getFileName());
        assertEquals(filePath, personaTaskDO.getFilePath());
        assertEquals(personaCount, personaTaskDO.getPersonaCount());
        assertEquals(personaIndex, personaTaskDO.getPersonaIndex());
        assertEquals(status, personaTaskDO.getStatus());
        assertEquals(message, personaTaskDO.getMessage());
        assertEquals(rawAddTime, personaTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, personaTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言persona_task表数据
	 */
	public void assertPersonaTask(PersonaTaskDO expect, PersonaTaskDO personaTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			personaTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != personaTaskDO.getRawAddTime());
		expect.setRawAddTime(personaTaskDO.getRawAddTime());
        Assertions.assertTrue(null != personaTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(personaTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, personaTaskDO);
	}

    /**
	 * 插入persona_task表数据
	 */
	public void insertPersonaTask(PersonaTaskDO personaTaskDO) {
		personaTaskDAO.insert(personaTaskDO);
	}

    /**
	 * 插入persona_task表数据
	 */
	public void insertPersonaTask(
			Long id, 
			Long personaId, 
			String gid, 
			String generateType, 
			String topic, 
			String event, 
			String fileName, 
			String filePath, 
			Long personaCount, 
			Long personaIndex, 
			String status, 
			String message, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PersonaTaskDO personaTaskDO = new PersonaTaskDO();
		personaTaskDO.setId(id);
		personaTaskDO.setPersonaId(personaId);
		personaTaskDO.setGid(gid);
		personaTaskDO.setGenerateType(generateType);
		personaTaskDO.setTopic(topic);
		personaTaskDO.setEvent(event);
		personaTaskDO.setFileName(fileName);
		personaTaskDO.setFilePath(filePath);
		personaTaskDO.setPersonaCount(personaCount);
		personaTaskDO.setPersonaIndex(personaIndex);
		personaTaskDO.setStatus(status);
		personaTaskDO.setMessage(message);
		personaTaskDO.setRawAddTime(rawAddTime);
		personaTaskDO.setRawUpdateTime(rawUpdateTime);
		personaTaskDAO.insert(personaTaskDO);
	}

    /**
     * 删除persona_task表所有数据
     */
    public void cleanPersonaTask() {
        PersonaTaskDOExample exam = new PersonaTaskDOExample();
        exam.createCriteria();
        personaTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除persona_task表数据
	 */
	public void cleanPersonaTaskById(Long id) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		personaTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据personaId删除persona_task表数据
	 */
	public void cleanPersonaTaskByPersonaId(Long personaId) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		personaTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除persona_task表数据
	 */
	public void cleanPersonaTaskByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		personaTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据fileName删除persona_task表数据
	*/
	public void cleanPersonaTaskByFileName(String fileName) {
        if (StringUtils.isBlank(fileName)){
            fileName = "test_fileName";
        }
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		personaTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询persona_task表所有数据
     */
    public List<PersonaTaskDO> findPersonaTaskAll() {
        PersonaTaskDOExample exam = new PersonaTaskDOExample();
        exam.createCriteria();
		return personaTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询persona_task表数据
	 */
	public List<PersonaTaskDO> findPersonaTaskById(Long id) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return personaTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据personaId查询persona_task表数据
	 */
	public List<PersonaTaskDO> findPersonaTaskByPersonaId(Long personaId) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		return personaTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询persona_task表数据
	 */
	public List<PersonaTaskDO> findPersonaTaskByGid(String gid) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return personaTaskDAO.selectByExample(exam);
	}

	/**
	* 根据fileName查询persona_task表数据
	*/
	public List<PersonaTaskDO> findPersonaTaskByFileName(String fileName) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		return personaTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新persona_task表数据
	 */
	public void updatePersonaTaskById(Long id,PersonaTaskDO personaTaskDO) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		personaTaskDAO.updateByExample(personaTaskDO, exam);
	}

    /**
	 * 根据personaId更新persona_task表数据
	 */
	public void updatePersonaTaskByPersonaId(Long personaId,PersonaTaskDO personaTaskDO) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		personaTaskDAO.updateByExample(personaTaskDO, exam);
	}

    /**
	 * 根据gid更新persona_task表数据
	 */
	public void updatePersonaTaskByGid(String gid,PersonaTaskDO personaTaskDO) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		personaTaskDAO.updateByExample(personaTaskDO, exam);
	}

	/**
	* 根据fileName更新persona_task表数据
	*/
	public void updatePersonaTaskByFileName(String fileName,PersonaTaskDO personaTaskDO) {
		PersonaTaskDOExample exam = new PersonaTaskDOExample();
		exam.createCriteria().andFileNameEqualTo(fileName);
		personaTaskDAO.updateByExample(personaTaskDO, exam);
	}

    /**
	 * 断言personas_condition表
	 */
	public void personasConditionAssert(
	        PersonasConditionDO personasConditionDO,
			Long id, 
			String conditionType, 
			String conditionName, 
			String conditionCode, 
			String conditionColumn, 
			String filedType, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, personasConditionDO.getId());
        assertEquals(conditionType, personasConditionDO.getConditionType());
        assertEquals(conditionName, personasConditionDO.getConditionName());
        assertEquals(conditionCode, personasConditionDO.getConditionCode());
        assertEquals(conditionColumn, personasConditionDO.getConditionColumn());
        assertEquals(filedType, personasConditionDO.getFiledType());
        assertEquals(rawAddTime, personasConditionDO.getRawAddTime());
        assertEquals(rawUpdateTime, personasConditionDO.getRawUpdateTime());
	}

	/**
	 * 断言personas_condition表数据
	 */
	public void assertPersonasCondition(PersonasConditionDO expect, PersonasConditionDO personasConditionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			personasConditionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != personasConditionDO.getRawAddTime());
		expect.setRawAddTime(personasConditionDO.getRawAddTime());
        Assertions.assertTrue(null != personasConditionDO.getRawUpdateTime());
		expect.setRawUpdateTime(personasConditionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, personasConditionDO);
	}

    /**
	 * 插入personas_condition表数据
	 */
	public void insertPersonasCondition(PersonasConditionDO personasConditionDO) {
		personasConditionDAO.insert(personasConditionDO);
	}

    /**
	 * 插入personas_condition表数据
	 */
	public void insertPersonasCondition(
			Long id, 
			String conditionType, 
			String conditionName, 
			String conditionCode, 
			String conditionColumn, 
			String filedType, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PersonasConditionDO personasConditionDO = new PersonasConditionDO();
		personasConditionDO.setId(id);
		personasConditionDO.setConditionType(conditionType);
		personasConditionDO.setConditionName(conditionName);
		personasConditionDO.setConditionCode(conditionCode);
		personasConditionDO.setConditionColumn(conditionColumn);
		personasConditionDO.setFiledType(filedType);
		personasConditionDO.setRawAddTime(rawAddTime);
		personasConditionDO.setRawUpdateTime(rawUpdateTime);
		personasConditionDAO.insert(personasConditionDO);
	}

    /**
     * 删除personas_condition表所有数据
     */
    public void cleanPersonasCondition() {
        PersonasConditionDOExample exam = new PersonasConditionDOExample();
        exam.createCriteria();
        personasConditionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除personas_condition表数据
	 */
	public void cleanPersonasConditionById(Long id) {
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		personasConditionDAO.deleteByExample(exam);
	}

	/**
	* 根据conditionName删除personas_condition表数据
	*/
	public void cleanPersonasConditionByConditionName(String conditionName) {
        if (StringUtils.isBlank(conditionName)){
            conditionName = "test_conditionName";
        }
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andConditionNameEqualTo(conditionName);
		personasConditionDAO.deleteByExample(exam);
	}

	/**
	* 根据conditionCode删除personas_condition表数据
	*/
	public void cleanPersonasConditionByConditionCode(String conditionCode) {
        if (StringUtils.isBlank(conditionCode)){
            conditionCode = "test_conditionCode";
        }
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andConditionCodeEqualTo(conditionCode);
		personasConditionDAO.deleteByExample(exam);
	}

    /**
     * 查询personas_condition表所有数据
     */
    public List<PersonasConditionDO> findPersonasConditionAll() {
        PersonasConditionDOExample exam = new PersonasConditionDOExample();
        exam.createCriteria();
		return personasConditionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询personas_condition表数据
	 */
	public List<PersonasConditionDO> findPersonasConditionById(Long id) {
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return personasConditionDAO.selectByExample(exam);
	}

	/**
	* 根据conditionName查询personas_condition表数据
	*/
	public List<PersonasConditionDO> findPersonasConditionByConditionName(String conditionName) {
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andConditionNameEqualTo(conditionName);
		return personasConditionDAO.selectByExample(exam);
	}

	/**
	* 根据conditionCode查询personas_condition表数据
	*/
	public List<PersonasConditionDO> findPersonasConditionByConditionCode(String conditionCode) {
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andConditionCodeEqualTo(conditionCode);
		return personasConditionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新personas_condition表数据
	 */
	public void updatePersonasConditionById(Long id,PersonasConditionDO personasConditionDO) {
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		personasConditionDAO.updateByExample(personasConditionDO, exam);
	}

	/**
	* 根据conditionName更新personas_condition表数据
	*/
	public void updatePersonasConditionByConditionName(String conditionName,PersonasConditionDO personasConditionDO) {
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andConditionNameEqualTo(conditionName);
		personasConditionDAO.updateByExample(personasConditionDO, exam);
	}

	/**
	* 根据conditionCode更新personas_condition表数据
	*/
	public void updatePersonasConditionByConditionCode(String conditionCode,PersonasConditionDO personasConditionDO) {
		PersonasConditionDOExample exam = new PersonasConditionDOExample();
		exam.createCriteria().andConditionCodeEqualTo(conditionCode);
		personasConditionDAO.updateByExample(personasConditionDO, exam);
	}

    /**
	 * 断言report_config表
	 */
	public void reportConfigAssert(
	        ReportConfigDO reportConfigDO,
			Long id, 
			String reportName, 
			String reportCode, 
			String reportUnit, 
			Long offSet, 
			String offSetExpr, 
			String reportStatus, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String statisticModel, 
			String reportColumn
	) {
        assertEquals(id, reportConfigDO.getId());
        assertEquals(reportName, reportConfigDO.getReportName());
        assertEquals(reportCode, reportConfigDO.getReportCode());
        assertEquals(reportUnit, reportConfigDO.getReportUnit());
        assertEquals(offSet, reportConfigDO.getOffSet());
        assertEquals(offSetExpr, reportConfigDO.getOffSetExpr());
        assertEquals(reportStatus, reportConfigDO.getReportStatus());
        assertEquals(memo, reportConfigDO.getMemo());
        assertEquals(rawAddTime, reportConfigDO.getRawAddTime());
        assertEquals(rawUpdateTime, reportConfigDO.getRawUpdateTime());
        assertEquals(statisticModel, reportConfigDO.getStatisticModel());
        assertEquals(reportColumn, reportConfigDO.getReportColumn());
	}

	/**
	 * 断言report_config表数据
	 */
	public void assertReportConfig(ReportConfigDO expect, ReportConfigDO reportConfigDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			reportConfigDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != reportConfigDO.getRawAddTime());
		expect.setRawAddTime(reportConfigDO.getRawAddTime());
        Assertions.assertTrue(null != reportConfigDO.getRawUpdateTime());
		expect.setRawUpdateTime(reportConfigDO.getRawUpdateTime());
		Assertions.assertEquals(expect, reportConfigDO);
	}

    /**
	 * 插入report_config表数据
	 */
	public void insertReportConfig(ReportConfigDO reportConfigDO) {
		reportConfigDAO.insert(reportConfigDO);
	}

    /**
	 * 插入report_config表数据
	 */
	public void insertReportConfig(
			Long id, 
			String reportName, 
			String reportCode, 
			String reportUnit, 
			Long offSet, 
			String offSetExpr, 
			String reportStatus, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String statisticModel, 
			String reportColumn
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ReportConfigDO reportConfigDO = new ReportConfigDO();
		reportConfigDO.setId(id);
		reportConfigDO.setReportName(reportName);
		reportConfigDO.setReportCode(reportCode);
		reportConfigDO.setReportUnit(reportUnit);
		reportConfigDO.setOffSet(offSet);
		reportConfigDO.setOffSetExpr(offSetExpr);
		reportConfigDO.setReportStatus(reportStatus);
		reportConfigDO.setMemo(memo);
		reportConfigDO.setRawAddTime(rawAddTime);
		reportConfigDO.setRawUpdateTime(rawUpdateTime);
		reportConfigDO.setStatisticModel(statisticModel);
		reportConfigDO.setReportColumn(reportColumn);
		reportConfigDAO.insert(reportConfigDO);
	}

    /**
     * 删除report_config表所有数据
     */
    public void cleanReportConfig() {
        ReportConfigDOExample exam = new ReportConfigDOExample();
        exam.createCriteria();
        reportConfigDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除report_config表数据
	 */
	public void cleanReportConfigById(Long id) {
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		reportConfigDAO.deleteByExample(exam);
	}

	/**
	* 根据reportName删除report_config表数据
	*/
	public void cleanReportConfigByReportName(String reportName) {
        if (StringUtils.isBlank(reportName)){
            reportName = "test_reportName";
        }
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andReportNameEqualTo(reportName);
		reportConfigDAO.deleteByExample(exam);
	}

	/**
	* 根据reportCode删除report_config表数据
	*/
	public void cleanReportConfigByReportCode(String reportCode) {
        if (StringUtils.isBlank(reportCode)){
            reportCode = "test_reportCode";
        }
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andReportCodeEqualTo(reportCode);
		reportConfigDAO.deleteByExample(exam);
	}

    /**
     * 查询report_config表所有数据
     */
    public List<ReportConfigDO> findReportConfigAll() {
        ReportConfigDOExample exam = new ReportConfigDOExample();
        exam.createCriteria();
		return reportConfigDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询report_config表数据
	 */
	public List<ReportConfigDO> findReportConfigById(Long id) {
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return reportConfigDAO.selectByExample(exam);
	}

	/**
	* 根据reportName查询report_config表数据
	*/
	public List<ReportConfigDO> findReportConfigByReportName(String reportName) {
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andReportNameEqualTo(reportName);
		return reportConfigDAO.selectByExample(exam);
	}

	/**
	* 根据reportCode查询report_config表数据
	*/
	public List<ReportConfigDO> findReportConfigByReportCode(String reportCode) {
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andReportCodeEqualTo(reportCode);
		return reportConfigDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新report_config表数据
	 */
	public void updateReportConfigById(Long id,ReportConfigDO reportConfigDO) {
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		reportConfigDAO.updateByExample(reportConfigDO, exam);
	}

	/**
	* 根据reportName更新report_config表数据
	*/
	public void updateReportConfigByReportName(String reportName,ReportConfigDO reportConfigDO) {
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andReportNameEqualTo(reportName);
		reportConfigDAO.updateByExample(reportConfigDO, exam);
	}

	/**
	* 根据reportCode更新report_config表数据
	*/
	public void updateReportConfigByReportCode(String reportCode,ReportConfigDO reportConfigDO) {
		ReportConfigDOExample exam = new ReportConfigDOExample();
		exam.createCriteria().andReportCodeEqualTo(reportCode);
		reportConfigDAO.updateByExample(reportConfigDO, exam);
	}

    /**
	 * 断言report_export_task表
	 */
	public void reportExportTaskAssert(
	        ReportExportTaskDO reportExportTaskDO,
			Long id, 
			String partnerId, 
			String partnerName, 
			Long reportId, 
			String reportName, 
			String conditions, 
			Date startTime, 
			Date endTime, 
			String reportFile, 
			String reportUrl, 
			String status, 
			String state, 
			String description, 
			String operateId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, reportExportTaskDO.getId());
        assertEquals(partnerId, reportExportTaskDO.getPartnerId());
        assertEquals(partnerName, reportExportTaskDO.getPartnerName());
        assertEquals(reportId, reportExportTaskDO.getReportId());
        assertEquals(reportName, reportExportTaskDO.getReportName());
        assertEquals(conditions, reportExportTaskDO.getConditions());
        assertEquals(startTime, reportExportTaskDO.getStartTime());
        assertEquals(endTime, reportExportTaskDO.getEndTime());
        assertEquals(reportFile, reportExportTaskDO.getReportFile());
        assertEquals(reportUrl, reportExportTaskDO.getReportUrl());
        assertEquals(status, reportExportTaskDO.getStatus());
        assertEquals(state, reportExportTaskDO.getState());
        assertEquals(description, reportExportTaskDO.getDescription());
        assertEquals(operateId, reportExportTaskDO.getOperateId());
        assertEquals(rawAddTime, reportExportTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, reportExportTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言report_export_task表数据
	 */
	public void assertReportExportTask(ReportExportTaskDO expect, ReportExportTaskDO reportExportTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			reportExportTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != reportExportTaskDO.getRawAddTime());
		expect.setRawAddTime(reportExportTaskDO.getRawAddTime());
        Assertions.assertTrue(null != reportExportTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(reportExportTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, reportExportTaskDO);
	}

    /**
	 * 插入report_export_task表数据
	 */
	public void insertReportExportTask(ReportExportTaskDO reportExportTaskDO) {
		reportExportTaskDAO.insert(reportExportTaskDO);
	}

    /**
	 * 插入report_export_task表数据
	 */
	public void insertReportExportTask(
			Long id, 
			String partnerId, 
			String partnerName, 
			Long reportId, 
			String reportName, 
			String conditions, 
			Date startTime, 
			Date endTime, 
			String reportFile, 
			String reportUrl, 
			String status, 
			String state, 
			String description, 
			String operateId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ReportExportTaskDO reportExportTaskDO = new ReportExportTaskDO();
		reportExportTaskDO.setId(id);
		reportExportTaskDO.setPartnerId(partnerId);
		reportExportTaskDO.setPartnerName(partnerName);
		reportExportTaskDO.setReportId(reportId);
		reportExportTaskDO.setReportName(reportName);
		reportExportTaskDO.setConditions(conditions);
		reportExportTaskDO.setStartTime(startTime);
		reportExportTaskDO.setEndTime(endTime);
		reportExportTaskDO.setReportFile(reportFile);
		reportExportTaskDO.setReportUrl(reportUrl);
		reportExportTaskDO.setStatus(status);
		reportExportTaskDO.setState(state);
		reportExportTaskDO.setDescription(description);
		reportExportTaskDO.setOperateId(operateId);
		reportExportTaskDO.setRawAddTime(rawAddTime);
		reportExportTaskDO.setRawUpdateTime(rawUpdateTime);
		reportExportTaskDAO.insert(reportExportTaskDO);
	}

    /**
     * 删除report_export_task表所有数据
     */
    public void cleanReportExportTask() {
        ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
        exam.createCriteria();
        reportExportTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除report_export_task表数据
	 */
	public void cleanReportExportTaskById(Long id) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		reportExportTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除report_export_task表数据
	 */
	public void cleanReportExportTaskByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		reportExportTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除report_export_task表数据
	*/
	public void cleanReportExportTaskByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		reportExportTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据reportId删除report_export_task表数据
	 */
	public void cleanReportExportTaskByReportId(Long reportId) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andReportIdEqualTo(reportId);
		reportExportTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据reportName删除report_export_task表数据
	*/
	public void cleanReportExportTaskByReportName(String reportName) {
        if (StringUtils.isBlank(reportName)){
            reportName = "test_reportName";
        }
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andReportNameEqualTo(reportName);
		reportExportTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除report_export_task表数据
	 */
	public void cleanReportExportTaskByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		reportExportTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询report_export_task表所有数据
     */
    public List<ReportExportTaskDO> findReportExportTaskAll() {
        ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
        exam.createCriteria();
		return reportExportTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询report_export_task表数据
	 */
	public List<ReportExportTaskDO> findReportExportTaskById(Long id) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return reportExportTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询report_export_task表数据
	 */
	public List<ReportExportTaskDO> findReportExportTaskByPartnerId(String partnerId) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return reportExportTaskDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询report_export_task表数据
	*/
	public List<ReportExportTaskDO> findReportExportTaskByPartnerName(String partnerName) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return reportExportTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据reportId查询report_export_task表数据
	 */
	public List<ReportExportTaskDO> findReportExportTaskByReportId(Long reportId) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andReportIdEqualTo(reportId);
		return reportExportTaskDAO.selectByExample(exam);
	}

	/**
	* 根据reportName查询report_export_task表数据
	*/
	public List<ReportExportTaskDO> findReportExportTaskByReportName(String reportName) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andReportNameEqualTo(reportName);
		return reportExportTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询report_export_task表数据
	 */
	public List<ReportExportTaskDO> findReportExportTaskByOperateId(String operateId) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return reportExportTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新report_export_task表数据
	 */
	public void updateReportExportTaskById(Long id,ReportExportTaskDO reportExportTaskDO) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		reportExportTaskDAO.updateByExample(reportExportTaskDO, exam);
	}

    /**
	 * 根据partnerId更新report_export_task表数据
	 */
	public void updateReportExportTaskByPartnerId(String partnerId,ReportExportTaskDO reportExportTaskDO) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		reportExportTaskDAO.updateByExample(reportExportTaskDO, exam);
	}

	/**
	* 根据partnerName更新report_export_task表数据
	*/
	public void updateReportExportTaskByPartnerName(String partnerName,ReportExportTaskDO reportExportTaskDO) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		reportExportTaskDAO.updateByExample(reportExportTaskDO, exam);
	}

    /**
	 * 根据reportId更新report_export_task表数据
	 */
	public void updateReportExportTaskByReportId(Long reportId,ReportExportTaskDO reportExportTaskDO) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andReportIdEqualTo(reportId);
		reportExportTaskDAO.updateByExample(reportExportTaskDO, exam);
	}

	/**
	* 根据reportName更新report_export_task表数据
	*/
	public void updateReportExportTaskByReportName(String reportName,ReportExportTaskDO reportExportTaskDO) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andReportNameEqualTo(reportName);
		reportExportTaskDAO.updateByExample(reportExportTaskDO, exam);
	}

    /**
	 * 根据operateId更新report_export_task表数据
	 */
	public void updateReportExportTaskByOperateId(String operateId,ReportExportTaskDO reportExportTaskDO) {
		ReportExportTaskDOExample exam = new ReportExportTaskDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		reportExportTaskDAO.updateByExample(reportExportTaskDO, exam);
	}

    /**
	 * 断言statistics_column表
	 */
	public void statisticsColumnAssert(
	        StatisticsColumnDO statisticsColumnDO,
			Long id, 
			String poolsName, 
			String poolsCode, 
			String columnName, 
			String columnCode, 
			String columnType, 
			String sumVertical, 
			String statisticsModel, 
			String statisticsCode, 
			String showValue, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, statisticsColumnDO.getId());
        assertEquals(poolsName, statisticsColumnDO.getPoolsName());
        assertEquals(poolsCode, statisticsColumnDO.getPoolsCode());
        assertEquals(columnName, statisticsColumnDO.getColumnName());
        assertEquals(columnCode, statisticsColumnDO.getColumnCode());
        assertEquals(columnType, statisticsColumnDO.getColumnType());
        assertEquals(sumVertical, statisticsColumnDO.getSumVertical());
        assertEquals(statisticsModel, statisticsColumnDO.getStatisticsModel());
        assertEquals(statisticsCode, statisticsColumnDO.getStatisticsCode());
        assertEquals(showValue, statisticsColumnDO.getShowValue());
        assertEquals(memo, statisticsColumnDO.getMemo());
        assertEquals(rawAddTime, statisticsColumnDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsColumnDO.getRawUpdateTime());
	}

	/**
	 * 断言statistics_column表数据
	 */
	public void assertStatisticsColumn(StatisticsColumnDO expect, StatisticsColumnDO statisticsColumnDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsColumnDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsColumnDO.getRawAddTime());
		expect.setRawAddTime(statisticsColumnDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsColumnDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsColumnDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsColumnDO);
	}

    /**
	 * 插入statistics_column表数据
	 */
	public void insertStatisticsColumn(StatisticsColumnDO statisticsColumnDO) {
		statisticsColumnDAO.insert(statisticsColumnDO);
	}

    /**
	 * 插入statistics_column表数据
	 */
	public void insertStatisticsColumn(
			Long id, 
			String poolsName, 
			String poolsCode, 
			String columnName, 
			String columnCode, 
			String columnType, 
			String sumVertical, 
			String statisticsModel, 
			String statisticsCode, 
			String showValue, 
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
		StatisticsColumnDO statisticsColumnDO = new StatisticsColumnDO();
		statisticsColumnDO.setId(id);
		statisticsColumnDO.setPoolsName(poolsName);
		statisticsColumnDO.setPoolsCode(poolsCode);
		statisticsColumnDO.setColumnName(columnName);
		statisticsColumnDO.setColumnCode(columnCode);
		statisticsColumnDO.setColumnType(columnType);
		statisticsColumnDO.setSumVertical(sumVertical);
		statisticsColumnDO.setStatisticsModel(statisticsModel);
		statisticsColumnDO.setStatisticsCode(statisticsCode);
		statisticsColumnDO.setShowValue(showValue);
		statisticsColumnDO.setMemo(memo);
		statisticsColumnDO.setRawAddTime(rawAddTime);
		statisticsColumnDO.setRawUpdateTime(rawUpdateTime);
		statisticsColumnDAO.insert(statisticsColumnDO);
	}

    /**
     * 删除statistics_column表所有数据
     */
    public void cleanStatisticsColumn() {
        StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
        exam.createCriteria();
        statisticsColumnDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_column表数据
	 */
	public void cleanStatisticsColumnById(Long id) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据poolsName删除statistics_column表数据
	*/
	public void cleanStatisticsColumnByPoolsName(String poolsName) {
        if (StringUtils.isBlank(poolsName)){
            poolsName = "test_poolsName";
        }
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		statisticsColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据poolsCode删除statistics_column表数据
	*/
	public void cleanStatisticsColumnByPoolsCode(String poolsCode) {
        if (StringUtils.isBlank(poolsCode)){
            poolsCode = "test_poolsCode";
        }
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据columnName删除statistics_column表数据
	*/
	public void cleanStatisticsColumnByColumnName(String columnName) {
        if (StringUtils.isBlank(columnName)){
            columnName = "test_columnName";
        }
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andColumnNameEqualTo(columnName);
		statisticsColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据columnCode删除statistics_column表数据
	*/
	public void cleanStatisticsColumnByColumnCode(String columnCode) {
        if (StringUtils.isBlank(columnCode)){
            columnCode = "test_columnCode";
        }
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		statisticsColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据statisticsCode删除statistics_column表数据
	*/
	public void cleanStatisticsColumnByStatisticsCode(String statisticsCode) {
        if (StringUtils.isBlank(statisticsCode)){
            statisticsCode = "test_statisticsCode";
        }
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andStatisticsCodeEqualTo(statisticsCode);
		statisticsColumnDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_column表所有数据
     */
    public List<StatisticsColumnDO> findStatisticsColumnAll() {
        StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
        exam.createCriteria();
		return statisticsColumnDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_column表数据
	 */
	public List<StatisticsColumnDO> findStatisticsColumnById(Long id) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsColumnDAO.selectByExample(exam);
	}

	/**
	* 根据poolsName查询statistics_column表数据
	*/
	public List<StatisticsColumnDO> findStatisticsColumnByPoolsName(String poolsName) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		return statisticsColumnDAO.selectByExample(exam);
	}

	/**
	* 根据poolsCode查询statistics_column表数据
	*/
	public List<StatisticsColumnDO> findStatisticsColumnByPoolsCode(String poolsCode) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		return statisticsColumnDAO.selectByExample(exam);
	}

	/**
	* 根据columnName查询statistics_column表数据
	*/
	public List<StatisticsColumnDO> findStatisticsColumnByColumnName(String columnName) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andColumnNameEqualTo(columnName);
		return statisticsColumnDAO.selectByExample(exam);
	}

	/**
	* 根据columnCode查询statistics_column表数据
	*/
	public List<StatisticsColumnDO> findStatisticsColumnByColumnCode(String columnCode) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		return statisticsColumnDAO.selectByExample(exam);
	}

	/**
	* 根据statisticsCode查询statistics_column表数据
	*/
	public List<StatisticsColumnDO> findStatisticsColumnByStatisticsCode(String statisticsCode) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andStatisticsCodeEqualTo(statisticsCode);
		return statisticsColumnDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_column表数据
	 */
	public void updateStatisticsColumnById(Long id,StatisticsColumnDO statisticsColumnDO) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsColumnDAO.updateByExample(statisticsColumnDO, exam);
	}

	/**
	* 根据poolsName更新statistics_column表数据
	*/
	public void updateStatisticsColumnByPoolsName(String poolsName,StatisticsColumnDO statisticsColumnDO) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		statisticsColumnDAO.updateByExample(statisticsColumnDO, exam);
	}

	/**
	* 根据poolsCode更新statistics_column表数据
	*/
	public void updateStatisticsColumnByPoolsCode(String poolsCode,StatisticsColumnDO statisticsColumnDO) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsColumnDAO.updateByExample(statisticsColumnDO, exam);
	}

	/**
	* 根据columnName更新statistics_column表数据
	*/
	public void updateStatisticsColumnByColumnName(String columnName,StatisticsColumnDO statisticsColumnDO) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andColumnNameEqualTo(columnName);
		statisticsColumnDAO.updateByExample(statisticsColumnDO, exam);
	}

	/**
	* 根据columnCode更新statistics_column表数据
	*/
	public void updateStatisticsColumnByColumnCode(String columnCode,StatisticsColumnDO statisticsColumnDO) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		statisticsColumnDAO.updateByExample(statisticsColumnDO, exam);
	}

	/**
	* 根据statisticsCode更新statistics_column表数据
	*/
	public void updateStatisticsColumnByStatisticsCode(String statisticsCode,StatisticsColumnDO statisticsColumnDO) {
		StatisticsColumnDOExample exam = new StatisticsColumnDOExample();
		exam.createCriteria().andStatisticsCodeEqualTo(statisticsCode);
		statisticsColumnDAO.updateByExample(statisticsColumnDO, exam);
	}

    /**
	 * 断言statistics_data表
	 */
	public void statisticsDataAssert(
	        StatisticsDataDO statisticsDataDO,
			Long id, 
			String spoutName, 
			String modelName, 
			String rowKey, 
			Date timeUnit, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String statisticData, 
			String groups
	) {
        assertEquals(id, statisticsDataDO.getId());
        assertEquals(spoutName, statisticsDataDO.getSpoutName());
        assertEquals(modelName, statisticsDataDO.getModelName());
        assertEquals(rowKey, statisticsDataDO.getRowKey());
        assertEquals(timeUnit, statisticsDataDO.getTimeUnit());
        assertEquals(rawAddTime, statisticsDataDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsDataDO.getRawUpdateTime());
        assertEquals(statisticData, statisticsDataDO.getStatisticData());
        assertEquals(groups, statisticsDataDO.getGroups());
	}

	/**
	 * 断言statistics_data表数据
	 */
	public void assertStatisticsData(StatisticsDataDO expect, StatisticsDataDO statisticsDataDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsDataDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsDataDO.getRawAddTime());
		expect.setRawAddTime(statisticsDataDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsDataDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsDataDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsDataDO);
	}

    /**
	 * 插入statistics_data表数据
	 */
	public void insertStatisticsData(StatisticsDataDO statisticsDataDO) {
		statisticsDataDAO.insert(statisticsDataDO);
	}

    /**
	 * 插入statistics_data表数据
	 */
	public void insertStatisticsData(
			Long id, 
			String spoutName, 
			String modelName, 
			String rowKey, 
			Date timeUnit, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String statisticData, 
			String groups
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		StatisticsDataDO statisticsDataDO = new StatisticsDataDO();
		statisticsDataDO.setId(id);
		statisticsDataDO.setSpoutName(spoutName);
		statisticsDataDO.setModelName(modelName);
		statisticsDataDO.setRowKey(rowKey);
		statisticsDataDO.setTimeUnit(timeUnit);
		statisticsDataDO.setRawAddTime(rawAddTime);
		statisticsDataDO.setRawUpdateTime(rawUpdateTime);
		statisticsDataDO.setStatisticData(statisticData);
		statisticsDataDO.setGroups(groups);
		statisticsDataDAO.insert(statisticsDataDO);
	}

    /**
     * 删除statistics_data表所有数据
     */
    public void cleanStatisticsData() {
        StatisticsDataDOExample exam = new StatisticsDataDOExample();
        exam.createCriteria();
        statisticsDataDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_data表数据
	 */
	public void cleanStatisticsDataById(Long id) {
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsDataDAO.deleteByExample(exam);
	}

	/**
	* 根据spoutName删除statistics_data表数据
	*/
	public void cleanStatisticsDataBySpoutName(String spoutName) {
        if (StringUtils.isBlank(spoutName)){
            spoutName = "test_spoutName";
        }
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsDataDAO.deleteByExample(exam);
	}

	/**
	* 根据modelName删除statistics_data表数据
	*/
	public void cleanStatisticsDataByModelName(String modelName) {
        if (StringUtils.isBlank(modelName)){
            modelName = "test_modelName";
        }
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		statisticsDataDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_data表所有数据
     */
    public List<StatisticsDataDO> findStatisticsDataAll() {
        StatisticsDataDOExample exam = new StatisticsDataDOExample();
        exam.createCriteria();
		return statisticsDataDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_data表数据
	 */
	public List<StatisticsDataDO> findStatisticsDataById(Long id) {
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsDataDAO.selectByExample(exam);
	}

	/**
	* 根据spoutName查询statistics_data表数据
	*/
	public List<StatisticsDataDO> findStatisticsDataBySpoutName(String spoutName) {
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		return statisticsDataDAO.selectByExample(exam);
	}

	/**
	* 根据modelName查询statistics_data表数据
	*/
	public List<StatisticsDataDO> findStatisticsDataByModelName(String modelName) {
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		return statisticsDataDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_data表数据
	 */
	public void updateStatisticsDataById(Long id,StatisticsDataDO statisticsDataDO) {
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsDataDAO.updateByExample(statisticsDataDO, exam);
	}

	/**
	* 根据spoutName更新statistics_data表数据
	*/
	public void updateStatisticsDataBySpoutName(String spoutName,StatisticsDataDO statisticsDataDO) {
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsDataDAO.updateByExample(statisticsDataDO, exam);
	}

	/**
	* 根据modelName更新statistics_data表数据
	*/
	public void updateStatisticsDataByModelName(String modelName,StatisticsDataDO statisticsDataDO) {
		StatisticsDataDOExample exam = new StatisticsDataDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		statisticsDataDAO.updateByExample(statisticsDataDO, exam);
	}

    /**
	 * 断言statistics_group_column表
	 */
	public void statisticsGroupColumnAssert(
	        StatisticsGroupColumnDO statisticsGroupColumnDO,
			Long id, 
			String poolsName, 
			String poolsCode, 
			String columnName, 
			String columnCode, 
			String orderByCode, 
			String columnType, 
			String mustFilter, 
			String subtotal, 
			String across, 
			String cycle, 
			String showValue, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, statisticsGroupColumnDO.getId());
        assertEquals(poolsName, statisticsGroupColumnDO.getPoolsName());
        assertEquals(poolsCode, statisticsGroupColumnDO.getPoolsCode());
        assertEquals(columnName, statisticsGroupColumnDO.getColumnName());
        assertEquals(columnCode, statisticsGroupColumnDO.getColumnCode());
        assertEquals(orderByCode, statisticsGroupColumnDO.getOrderByCode());
        assertEquals(columnType, statisticsGroupColumnDO.getColumnType());
        assertEquals(mustFilter, statisticsGroupColumnDO.getMustFilter());
        assertEquals(subtotal, statisticsGroupColumnDO.getSubtotal());
        assertEquals(across, statisticsGroupColumnDO.getAcross());
        assertEquals(cycle, statisticsGroupColumnDO.getCycle());
        assertEquals(showValue, statisticsGroupColumnDO.getShowValue());
        assertEquals(memo, statisticsGroupColumnDO.getMemo());
        assertEquals(rawAddTime, statisticsGroupColumnDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsGroupColumnDO.getRawUpdateTime());
	}

	/**
	 * 断言statistics_group_column表数据
	 */
	public void assertStatisticsGroupColumn(StatisticsGroupColumnDO expect, StatisticsGroupColumnDO statisticsGroupColumnDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsGroupColumnDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsGroupColumnDO.getRawAddTime());
		expect.setRawAddTime(statisticsGroupColumnDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsGroupColumnDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsGroupColumnDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsGroupColumnDO);
	}

    /**
	 * 插入statistics_group_column表数据
	 */
	public void insertStatisticsGroupColumn(StatisticsGroupColumnDO statisticsGroupColumnDO) {
		statisticsGroupColumnDAO.insert(statisticsGroupColumnDO);
	}

    /**
	 * 插入statistics_group_column表数据
	 */
	public void insertStatisticsGroupColumn(
			Long id, 
			String poolsName, 
			String poolsCode, 
			String columnName, 
			String columnCode, 
			String orderByCode, 
			String columnType, 
			String mustFilter, 
			String subtotal, 
			String across, 
			String cycle, 
			String showValue, 
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
		StatisticsGroupColumnDO statisticsGroupColumnDO = new StatisticsGroupColumnDO();
		statisticsGroupColumnDO.setId(id);
		statisticsGroupColumnDO.setPoolsName(poolsName);
		statisticsGroupColumnDO.setPoolsCode(poolsCode);
		statisticsGroupColumnDO.setColumnName(columnName);
		statisticsGroupColumnDO.setColumnCode(columnCode);
		statisticsGroupColumnDO.setOrderByCode(orderByCode);
		statisticsGroupColumnDO.setColumnType(columnType);
		statisticsGroupColumnDO.setMustFilter(mustFilter);
		statisticsGroupColumnDO.setSubtotal(subtotal);
		statisticsGroupColumnDO.setAcross(across);
		statisticsGroupColumnDO.setCycle(cycle);
		statisticsGroupColumnDO.setShowValue(showValue);
		statisticsGroupColumnDO.setMemo(memo);
		statisticsGroupColumnDO.setRawAddTime(rawAddTime);
		statisticsGroupColumnDO.setRawUpdateTime(rawUpdateTime);
		statisticsGroupColumnDAO.insert(statisticsGroupColumnDO);
	}

    /**
     * 删除statistics_group_column表所有数据
     */
    public void cleanStatisticsGroupColumn() {
        StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
        exam.createCriteria();
        statisticsGroupColumnDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_group_column表数据
	 */
	public void cleanStatisticsGroupColumnById(Long id) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsGroupColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据poolsName删除statistics_group_column表数据
	*/
	public void cleanStatisticsGroupColumnByPoolsName(String poolsName) {
        if (StringUtils.isBlank(poolsName)){
            poolsName = "test_poolsName";
        }
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		statisticsGroupColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据poolsCode删除statistics_group_column表数据
	*/
	public void cleanStatisticsGroupColumnByPoolsCode(String poolsCode) {
        if (StringUtils.isBlank(poolsCode)){
            poolsCode = "test_poolsCode";
        }
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsGroupColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据columnName删除statistics_group_column表数据
	*/
	public void cleanStatisticsGroupColumnByColumnName(String columnName) {
        if (StringUtils.isBlank(columnName)){
            columnName = "test_columnName";
        }
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andColumnNameEqualTo(columnName);
		statisticsGroupColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据columnCode删除statistics_group_column表数据
	*/
	public void cleanStatisticsGroupColumnByColumnCode(String columnCode) {
        if (StringUtils.isBlank(columnCode)){
            columnCode = "test_columnCode";
        }
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		statisticsGroupColumnDAO.deleteByExample(exam);
	}

	/**
	* 根据orderByCode删除statistics_group_column表数据
	*/
	public void cleanStatisticsGroupColumnByOrderByCode(String orderByCode) {
        if (StringUtils.isBlank(orderByCode)){
            orderByCode = "test_orderByCode";
        }
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andOrderByCodeEqualTo(orderByCode);
		statisticsGroupColumnDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_group_column表所有数据
     */
    public List<StatisticsGroupColumnDO> findStatisticsGroupColumnAll() {
        StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
        exam.createCriteria();
		return statisticsGroupColumnDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_group_column表数据
	 */
	public List<StatisticsGroupColumnDO> findStatisticsGroupColumnById(Long id) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsGroupColumnDAO.selectByExample(exam);
	}

	/**
	* 根据poolsName查询statistics_group_column表数据
	*/
	public List<StatisticsGroupColumnDO> findStatisticsGroupColumnByPoolsName(String poolsName) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		return statisticsGroupColumnDAO.selectByExample(exam);
	}

	/**
	* 根据poolsCode查询statistics_group_column表数据
	*/
	public List<StatisticsGroupColumnDO> findStatisticsGroupColumnByPoolsCode(String poolsCode) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		return statisticsGroupColumnDAO.selectByExample(exam);
	}

	/**
	* 根据columnName查询statistics_group_column表数据
	*/
	public List<StatisticsGroupColumnDO> findStatisticsGroupColumnByColumnName(String columnName) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andColumnNameEqualTo(columnName);
		return statisticsGroupColumnDAO.selectByExample(exam);
	}

	/**
	* 根据columnCode查询statistics_group_column表数据
	*/
	public List<StatisticsGroupColumnDO> findStatisticsGroupColumnByColumnCode(String columnCode) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		return statisticsGroupColumnDAO.selectByExample(exam);
	}

	/**
	* 根据orderByCode查询statistics_group_column表数据
	*/
	public List<StatisticsGroupColumnDO> findStatisticsGroupColumnByOrderByCode(String orderByCode) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andOrderByCodeEqualTo(orderByCode);
		return statisticsGroupColumnDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_group_column表数据
	 */
	public void updateStatisticsGroupColumnById(Long id,StatisticsGroupColumnDO statisticsGroupColumnDO) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsGroupColumnDAO.updateByExample(statisticsGroupColumnDO, exam);
	}

	/**
	* 根据poolsName更新statistics_group_column表数据
	*/
	public void updateStatisticsGroupColumnByPoolsName(String poolsName,StatisticsGroupColumnDO statisticsGroupColumnDO) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		statisticsGroupColumnDAO.updateByExample(statisticsGroupColumnDO, exam);
	}

	/**
	* 根据poolsCode更新statistics_group_column表数据
	*/
	public void updateStatisticsGroupColumnByPoolsCode(String poolsCode,StatisticsGroupColumnDO statisticsGroupColumnDO) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsGroupColumnDAO.updateByExample(statisticsGroupColumnDO, exam);
	}

	/**
	* 根据columnName更新statistics_group_column表数据
	*/
	public void updateStatisticsGroupColumnByColumnName(String columnName,StatisticsGroupColumnDO statisticsGroupColumnDO) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andColumnNameEqualTo(columnName);
		statisticsGroupColumnDAO.updateByExample(statisticsGroupColumnDO, exam);
	}

	/**
	* 根据columnCode更新statistics_group_column表数据
	*/
	public void updateStatisticsGroupColumnByColumnCode(String columnCode,StatisticsGroupColumnDO statisticsGroupColumnDO) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andColumnCodeEqualTo(columnCode);
		statisticsGroupColumnDAO.updateByExample(statisticsGroupColumnDO, exam);
	}

	/**
	* 根据orderByCode更新statistics_group_column表数据
	*/
	public void updateStatisticsGroupColumnByOrderByCode(String orderByCode,StatisticsGroupColumnDO statisticsGroupColumnDO) {
		StatisticsGroupColumnDOExample exam = new StatisticsGroupColumnDOExample();
		exam.createCriteria().andOrderByCodeEqualTo(orderByCode);
		statisticsGroupColumnDAO.updateByExample(statisticsGroupColumnDO, exam);
	}

    /**
	 * 断言statistics_group_pools表
	 */
	public void statisticsGroupPoolsAssert(
	        StatisticsGroupPoolsDO statisticsGroupPoolsDO,
			Long id, 
			String poolsName, 
			String poolsCode, 
			String groupSql, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, statisticsGroupPoolsDO.getId());
        assertEquals(poolsName, statisticsGroupPoolsDO.getPoolsName());
        assertEquals(poolsCode, statisticsGroupPoolsDO.getPoolsCode());
        assertEquals(groupSql, statisticsGroupPoolsDO.getGroupSql());
        assertEquals(rawAddTime, statisticsGroupPoolsDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsGroupPoolsDO.getRawUpdateTime());
	}

	/**
	 * 断言statistics_group_pools表数据
	 */
	public void assertStatisticsGroupPools(StatisticsGroupPoolsDO expect, StatisticsGroupPoolsDO statisticsGroupPoolsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsGroupPoolsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsGroupPoolsDO.getRawAddTime());
		expect.setRawAddTime(statisticsGroupPoolsDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsGroupPoolsDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsGroupPoolsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsGroupPoolsDO);
	}

    /**
	 * 插入statistics_group_pools表数据
	 */
	public void insertStatisticsGroupPools(StatisticsGroupPoolsDO statisticsGroupPoolsDO) {
		statisticsGroupPoolsDAO.insert(statisticsGroupPoolsDO);
	}

    /**
	 * 插入statistics_group_pools表数据
	 */
	public void insertStatisticsGroupPools(
			Long id, 
			String poolsName, 
			String poolsCode, 
			String groupSql, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		StatisticsGroupPoolsDO statisticsGroupPoolsDO = new StatisticsGroupPoolsDO();
		statisticsGroupPoolsDO.setId(id);
		statisticsGroupPoolsDO.setPoolsName(poolsName);
		statisticsGroupPoolsDO.setPoolsCode(poolsCode);
		statisticsGroupPoolsDO.setGroupSql(groupSql);
		statisticsGroupPoolsDO.setRawAddTime(rawAddTime);
		statisticsGroupPoolsDO.setRawUpdateTime(rawUpdateTime);
		statisticsGroupPoolsDAO.insert(statisticsGroupPoolsDO);
	}

    /**
     * 删除statistics_group_pools表所有数据
     */
    public void cleanStatisticsGroupPools() {
        StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
        exam.createCriteria();
        statisticsGroupPoolsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_group_pools表数据
	 */
	public void cleanStatisticsGroupPoolsById(Long id) {
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsGroupPoolsDAO.deleteByExample(exam);
	}

	/**
	* 根据poolsName删除statistics_group_pools表数据
	*/
	public void cleanStatisticsGroupPoolsByPoolsName(String poolsName) {
        if (StringUtils.isBlank(poolsName)){
            poolsName = "test_poolsName";
        }
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		statisticsGroupPoolsDAO.deleteByExample(exam);
	}

	/**
	* 根据poolsCode删除statistics_group_pools表数据
	*/
	public void cleanStatisticsGroupPoolsByPoolsCode(String poolsCode) {
        if (StringUtils.isBlank(poolsCode)){
            poolsCode = "test_poolsCode";
        }
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsGroupPoolsDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_group_pools表所有数据
     */
    public List<StatisticsGroupPoolsDO> findStatisticsGroupPoolsAll() {
        StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
        exam.createCriteria();
		return statisticsGroupPoolsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_group_pools表数据
	 */
	public List<StatisticsGroupPoolsDO> findStatisticsGroupPoolsById(Long id) {
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsGroupPoolsDAO.selectByExample(exam);
	}

	/**
	* 根据poolsName查询statistics_group_pools表数据
	*/
	public List<StatisticsGroupPoolsDO> findStatisticsGroupPoolsByPoolsName(String poolsName) {
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		return statisticsGroupPoolsDAO.selectByExample(exam);
	}

	/**
	* 根据poolsCode查询statistics_group_pools表数据
	*/
	public List<StatisticsGroupPoolsDO> findStatisticsGroupPoolsByPoolsCode(String poolsCode) {
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		return statisticsGroupPoolsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_group_pools表数据
	 */
	public void updateStatisticsGroupPoolsById(Long id,StatisticsGroupPoolsDO statisticsGroupPoolsDO) {
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsGroupPoolsDAO.updateByExample(statisticsGroupPoolsDO, exam);
	}

	/**
	* 根据poolsName更新statistics_group_pools表数据
	*/
	public void updateStatisticsGroupPoolsByPoolsName(String poolsName,StatisticsGroupPoolsDO statisticsGroupPoolsDO) {
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andPoolsNameEqualTo(poolsName);
		statisticsGroupPoolsDAO.updateByExample(statisticsGroupPoolsDO, exam);
	}

	/**
	* 根据poolsCode更新statistics_group_pools表数据
	*/
	public void updateStatisticsGroupPoolsByPoolsCode(String poolsCode,StatisticsGroupPoolsDO statisticsGroupPoolsDO) {
		StatisticsGroupPoolsDOExample exam = new StatisticsGroupPoolsDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsGroupPoolsDAO.updateByExample(statisticsGroupPoolsDO, exam);
	}

    /**
	 * 断言statistics_group_program表
	 */
	public void statisticsGroupProgramAssert(
	        StatisticsGroupProgramDO statisticsGroupProgramDO,
			Long id, 
			String operateId, 
			String programName, 
			String programCode, 
			String programType, 
			String gradeType, 
			String poolsCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupConfig
	) {
        assertEquals(id, statisticsGroupProgramDO.getId());
        assertEquals(operateId, statisticsGroupProgramDO.getOperateId());
        assertEquals(programName, statisticsGroupProgramDO.getProgramName());
        assertEquals(programCode, statisticsGroupProgramDO.getProgramCode());
        assertEquals(programType, statisticsGroupProgramDO.getProgramType());
        assertEquals(gradeType, statisticsGroupProgramDO.getGradeType());
        assertEquals(poolsCode, statisticsGroupProgramDO.getPoolsCode());
        assertEquals(rawAddTime, statisticsGroupProgramDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsGroupProgramDO.getRawUpdateTime());
        assertEquals(groupConfig, statisticsGroupProgramDO.getGroupConfig());
	}

	/**
	 * 断言statistics_group_program表数据
	 */
	public void assertStatisticsGroupProgram(StatisticsGroupProgramDO expect, StatisticsGroupProgramDO statisticsGroupProgramDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsGroupProgramDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsGroupProgramDO.getRawAddTime());
		expect.setRawAddTime(statisticsGroupProgramDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsGroupProgramDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsGroupProgramDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsGroupProgramDO);
	}

    /**
	 * 插入statistics_group_program表数据
	 */
	public void insertStatisticsGroupProgram(StatisticsGroupProgramDO statisticsGroupProgramDO) {
		statisticsGroupProgramDAO.insert(statisticsGroupProgramDO);
	}

    /**
	 * 插入statistics_group_program表数据
	 */
	public void insertStatisticsGroupProgram(
			Long id, 
			String operateId, 
			String programName, 
			String programCode, 
			String programType, 
			String gradeType, 
			String poolsCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupConfig
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		StatisticsGroupProgramDO statisticsGroupProgramDO = new StatisticsGroupProgramDO();
		statisticsGroupProgramDO.setId(id);
		statisticsGroupProgramDO.setOperateId(operateId);
		statisticsGroupProgramDO.setProgramName(programName);
		statisticsGroupProgramDO.setProgramCode(programCode);
		statisticsGroupProgramDO.setProgramType(programType);
		statisticsGroupProgramDO.setGradeType(gradeType);
		statisticsGroupProgramDO.setPoolsCode(poolsCode);
		statisticsGroupProgramDO.setRawAddTime(rawAddTime);
		statisticsGroupProgramDO.setRawUpdateTime(rawUpdateTime);
		statisticsGroupProgramDO.setGroupConfig(groupConfig);
		statisticsGroupProgramDAO.insert(statisticsGroupProgramDO);
	}

    /**
     * 删除statistics_group_program表所有数据
     */
    public void cleanStatisticsGroupProgram() {
        StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
        exam.createCriteria();
        statisticsGroupProgramDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_group_program表数据
	 */
	public void cleanStatisticsGroupProgramById(Long id) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsGroupProgramDAO.deleteByExample(exam);
	}

	/**
	 * 根据operateId删除statistics_group_program表数据
	 */
	public void cleanStatisticsGroupProgramByOperateId(String operateId) {
        if (StringUtils.isBlank(operateId)){
            operateId = "test_operateId";
        }
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		statisticsGroupProgramDAO.deleteByExample(exam);
	}

	/**
	* 根据programName删除statistics_group_program表数据
	*/
	public void cleanStatisticsGroupProgramByProgramName(String programName) {
        if (StringUtils.isBlank(programName)){
            programName = "test_programName";
        }
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andProgramNameEqualTo(programName);
		statisticsGroupProgramDAO.deleteByExample(exam);
	}

	/**
	* 根据programCode删除statistics_group_program表数据
	*/
	public void cleanStatisticsGroupProgramByProgramCode(String programCode) {
        if (StringUtils.isBlank(programCode)){
            programCode = "test_programCode";
        }
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andProgramCodeEqualTo(programCode);
		statisticsGroupProgramDAO.deleteByExample(exam);
	}

	/**
	* 根据poolsCode删除statistics_group_program表数据
	*/
	public void cleanStatisticsGroupProgramByPoolsCode(String poolsCode) {
        if (StringUtils.isBlank(poolsCode)){
            poolsCode = "test_poolsCode";
        }
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsGroupProgramDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_group_program表所有数据
     */
    public List<StatisticsGroupProgramDO> findStatisticsGroupProgramAll() {
        StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
        exam.createCriteria();
		return statisticsGroupProgramDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_group_program表数据
	 */
	public List<StatisticsGroupProgramDO> findStatisticsGroupProgramById(Long id) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsGroupProgramDAO.selectByExample(exam);
	}

    /**
	 * 根据operateId查询statistics_group_program表数据
	 */
	public List<StatisticsGroupProgramDO> findStatisticsGroupProgramByOperateId(String operateId) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		return statisticsGroupProgramDAO.selectByExample(exam);
	}

	/**
	* 根据programName查询statistics_group_program表数据
	*/
	public List<StatisticsGroupProgramDO> findStatisticsGroupProgramByProgramName(String programName) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andProgramNameEqualTo(programName);
		return statisticsGroupProgramDAO.selectByExample(exam);
	}

	/**
	* 根据programCode查询statistics_group_program表数据
	*/
	public List<StatisticsGroupProgramDO> findStatisticsGroupProgramByProgramCode(String programCode) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andProgramCodeEqualTo(programCode);
		return statisticsGroupProgramDAO.selectByExample(exam);
	}

	/**
	* 根据poolsCode查询statistics_group_program表数据
	*/
	public List<StatisticsGroupProgramDO> findStatisticsGroupProgramByPoolsCode(String poolsCode) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		return statisticsGroupProgramDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_group_program表数据
	 */
	public void updateStatisticsGroupProgramById(Long id,StatisticsGroupProgramDO statisticsGroupProgramDO) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsGroupProgramDAO.updateByExample(statisticsGroupProgramDO, exam);
	}

    /**
	 * 根据operateId更新statistics_group_program表数据
	 */
	public void updateStatisticsGroupProgramByOperateId(String operateId,StatisticsGroupProgramDO statisticsGroupProgramDO) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andOperateIdEqualTo(operateId);
		statisticsGroupProgramDAO.updateByExample(statisticsGroupProgramDO, exam);
	}

	/**
	* 根据programName更新statistics_group_program表数据
	*/
	public void updateStatisticsGroupProgramByProgramName(String programName,StatisticsGroupProgramDO statisticsGroupProgramDO) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andProgramNameEqualTo(programName);
		statisticsGroupProgramDAO.updateByExample(statisticsGroupProgramDO, exam);
	}

	/**
	* 根据programCode更新statistics_group_program表数据
	*/
	public void updateStatisticsGroupProgramByProgramCode(String programCode,StatisticsGroupProgramDO statisticsGroupProgramDO) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andProgramCodeEqualTo(programCode);
		statisticsGroupProgramDAO.updateByExample(statisticsGroupProgramDO, exam);
	}

	/**
	* 根据poolsCode更新statistics_group_program表数据
	*/
	public void updateStatisticsGroupProgramByPoolsCode(String poolsCode,StatisticsGroupProgramDO statisticsGroupProgramDO) {
		StatisticsGroupProgramDOExample exam = new StatisticsGroupProgramDOExample();
		exam.createCriteria().andPoolsCodeEqualTo(poolsCode);
		statisticsGroupProgramDAO.updateByExample(statisticsGroupProgramDO, exam);
	}

    /**
	 * 断言statistics_model表
	 */
	public void statisticsModelAssert(
	        StatisticsModelDO statisticsModelDO,
			Long id, 
			String spoutName, 
			String modelName, 
			String modelType, 
			Long offSet, 
			String offSetExpr, 
			String timeFiled, 
			String windowType, 
			String windowUnit, 
			Integer windowLength, 
			String status, 
			String enable, 
			String calculateStatus, 
			String aggregates, 
			String conditions, 
			String groups, 
			String distincts, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, statisticsModelDO.getId());
        assertEquals(spoutName, statisticsModelDO.getSpoutName());
        assertEquals(modelName, statisticsModelDO.getModelName());
        assertEquals(modelType, statisticsModelDO.getModelType());
        assertEquals(offSet, statisticsModelDO.getOffSet());
        assertEquals(offSetExpr, statisticsModelDO.getOffSetExpr());
        assertEquals(timeFiled, statisticsModelDO.getTimeFiled());
        assertEquals(windowType, statisticsModelDO.getWindowType());
        assertEquals(windowUnit, statisticsModelDO.getWindowUnit());
        assertEquals(windowLength, statisticsModelDO.getWindowLength());
        assertEquals(status, statisticsModelDO.getStatus());
        assertEquals(enable, statisticsModelDO.getEnable());
        assertEquals(calculateStatus, statisticsModelDO.getCalculateStatus());
        assertEquals(aggregates, statisticsModelDO.getAggregates());
        assertEquals(conditions, statisticsModelDO.getConditions());
        assertEquals(groups, statisticsModelDO.getGroups());
        assertEquals(distincts, statisticsModelDO.getDistincts());
        assertEquals(memo, statisticsModelDO.getMemo());
        assertEquals(rawAddTime, statisticsModelDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsModelDO.getRawUpdateTime());
	}

	/**
	 * 断言statistics_model表数据
	 */
	public void assertStatisticsModel(StatisticsModelDO expect, StatisticsModelDO statisticsModelDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsModelDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsModelDO.getRawAddTime());
		expect.setRawAddTime(statisticsModelDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsModelDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsModelDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsModelDO);
	}

    /**
	 * 插入statistics_model表数据
	 */
	public void insertStatisticsModel(StatisticsModelDO statisticsModelDO) {
		statisticsModelDAO.insert(statisticsModelDO);
	}

    /**
	 * 插入statistics_model表数据
	 */
	public void insertStatisticsModel(
			Long id, 
			String spoutName, 
			String modelName, 
			String modelType, 
			Long offSet, 
			String offSetExpr, 
			String timeFiled, 
			String windowType, 
			String windowUnit, 
			Integer windowLength, 
			String status, 
			String enable, 
			String calculateStatus, 
			String aggregates, 
			String conditions, 
			String groups, 
			String distincts, 
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
		StatisticsModelDO statisticsModelDO = new StatisticsModelDO();
		statisticsModelDO.setId(id);
		statisticsModelDO.setSpoutName(spoutName);
		statisticsModelDO.setModelName(modelName);
		statisticsModelDO.setModelType(modelType);
		statisticsModelDO.setOffSet(offSet);
		statisticsModelDO.setOffSetExpr(offSetExpr);
		statisticsModelDO.setTimeFiled(timeFiled);
		statisticsModelDO.setWindowType(windowType);
		statisticsModelDO.setWindowUnit(windowUnit);
		statisticsModelDO.setWindowLength(windowLength);
		statisticsModelDO.setStatus(status);
		statisticsModelDO.setEnable(enable);
		statisticsModelDO.setCalculateStatus(calculateStatus);
		statisticsModelDO.setAggregates(aggregates);
		statisticsModelDO.setConditions(conditions);
		statisticsModelDO.setGroups(groups);
		statisticsModelDO.setDistincts(distincts);
		statisticsModelDO.setMemo(memo);
		statisticsModelDO.setRawAddTime(rawAddTime);
		statisticsModelDO.setRawUpdateTime(rawUpdateTime);
		statisticsModelDAO.insert(statisticsModelDO);
	}

    /**
     * 删除statistics_model表所有数据
     */
    public void cleanStatisticsModel() {
        StatisticsModelDOExample exam = new StatisticsModelDOExample();
        exam.createCriteria();
        statisticsModelDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_model表数据
	 */
	public void cleanStatisticsModelById(Long id) {
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsModelDAO.deleteByExample(exam);
	}

	/**
	* 根据spoutName删除statistics_model表数据
	*/
	public void cleanStatisticsModelBySpoutName(String spoutName) {
        if (StringUtils.isBlank(spoutName)){
            spoutName = "test_spoutName";
        }
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsModelDAO.deleteByExample(exam);
	}

	/**
	* 根据modelName删除statistics_model表数据
	*/
	public void cleanStatisticsModelByModelName(String modelName) {
        if (StringUtils.isBlank(modelName)){
            modelName = "test_modelName";
        }
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		statisticsModelDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_model表所有数据
     */
    public List<StatisticsModelDO> findStatisticsModelAll() {
        StatisticsModelDOExample exam = new StatisticsModelDOExample();
        exam.createCriteria();
		return statisticsModelDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_model表数据
	 */
	public List<StatisticsModelDO> findStatisticsModelById(Long id) {
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsModelDAO.selectByExample(exam);
	}

	/**
	* 根据spoutName查询statistics_model表数据
	*/
	public List<StatisticsModelDO> findStatisticsModelBySpoutName(String spoutName) {
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		return statisticsModelDAO.selectByExample(exam);
	}

	/**
	* 根据modelName查询statistics_model表数据
	*/
	public List<StatisticsModelDO> findStatisticsModelByModelName(String modelName) {
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		return statisticsModelDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_model表数据
	 */
	public void updateStatisticsModelById(Long id,StatisticsModelDO statisticsModelDO) {
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsModelDAO.updateByExample(statisticsModelDO, exam);
	}

	/**
	* 根据spoutName更新statistics_model表数据
	*/
	public void updateStatisticsModelBySpoutName(String spoutName,StatisticsModelDO statisticsModelDO) {
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsModelDAO.updateByExample(statisticsModelDO, exam);
	}

	/**
	* 根据modelName更新statistics_model表数据
	*/
	public void updateStatisticsModelByModelName(String modelName,StatisticsModelDO statisticsModelDO) {
		StatisticsModelDOExample exam = new StatisticsModelDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		statisticsModelDAO.updateByExample(statisticsModelDO, exam);
	}

    /**
	 * 断言statistics_report表
	 */
	public void statisticsReportAssert(
	        StatisticsReportDO statisticsReportDO,
			Long id, 
			String rowKey, 
			String partnerId, 
			String partnerName, 
			String reportType, 
			String groups, 
			String groupsIndex, 
			String conditions, 
			String conditionsIndex, 
			Date statisticsTime, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String reportColumn
	) {
        assertEquals(id, statisticsReportDO.getId());
        assertEquals(rowKey, statisticsReportDO.getRowKey());
        assertEquals(partnerId, statisticsReportDO.getPartnerId());
        assertEquals(partnerName, statisticsReportDO.getPartnerName());
        assertEquals(reportType, statisticsReportDO.getReportType());
        assertEquals(groups, statisticsReportDO.getGroups());
        assertEquals(groupsIndex, statisticsReportDO.getGroupsIndex());
        assertEquals(conditions, statisticsReportDO.getConditions());
        assertEquals(conditionsIndex, statisticsReportDO.getConditionsIndex());
        assertEquals(statisticsTime, statisticsReportDO.getStatisticsTime());
        assertEquals(rawAddTime, statisticsReportDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsReportDO.getRawUpdateTime());
        assertEquals(reportColumn, statisticsReportDO.getReportColumn());
	}

	/**
	 * 断言statistics_report表数据
	 */
	public void assertStatisticsReport(StatisticsReportDO expect, StatisticsReportDO statisticsReportDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsReportDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsReportDO.getRawAddTime());
		expect.setRawAddTime(statisticsReportDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsReportDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsReportDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsReportDO);
	}

    /**
	 * 插入statistics_report表数据
	 */
	public void insertStatisticsReport(StatisticsReportDO statisticsReportDO) {
		statisticsReportDAO.insert(statisticsReportDO);
	}

    /**
	 * 插入statistics_report表数据
	 */
	public void insertStatisticsReport(
			Long id, 
			String rowKey, 
			String partnerId, 
			String partnerName, 
			String reportType, 
			String groups, 
			String groupsIndex, 
			String conditions, 
			String conditionsIndex, 
			Date statisticsTime, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String reportColumn
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		StatisticsReportDO statisticsReportDO = new StatisticsReportDO();
		statisticsReportDO.setId(id);
		statisticsReportDO.setRowKey(rowKey);
		statisticsReportDO.setPartnerId(partnerId);
		statisticsReportDO.setPartnerName(partnerName);
		statisticsReportDO.setReportType(reportType);
		statisticsReportDO.setGroups(groups);
		statisticsReportDO.setGroupsIndex(groupsIndex);
		statisticsReportDO.setConditions(conditions);
		statisticsReportDO.setConditionsIndex(conditionsIndex);
		statisticsReportDO.setStatisticsTime(statisticsTime);
		statisticsReportDO.setRawAddTime(rawAddTime);
		statisticsReportDO.setRawUpdateTime(rawUpdateTime);
		statisticsReportDO.setReportColumn(reportColumn);
		statisticsReportDAO.insert(statisticsReportDO);
	}

    /**
     * 删除statistics_report表所有数据
     */
    public void cleanStatisticsReport() {
        StatisticsReportDOExample exam = new StatisticsReportDOExample();
        exam.createCriteria();
        statisticsReportDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_report表数据
	 */
	public void cleanStatisticsReportById(Long id) {
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsReportDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除statistics_report表数据
	 */
	public void cleanStatisticsReportByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		statisticsReportDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除statistics_report表数据
	*/
	public void cleanStatisticsReportByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		statisticsReportDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_report表所有数据
     */
    public List<StatisticsReportDO> findStatisticsReportAll() {
        StatisticsReportDOExample exam = new StatisticsReportDOExample();
        exam.createCriteria();
		return statisticsReportDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_report表数据
	 */
	public List<StatisticsReportDO> findStatisticsReportById(Long id) {
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsReportDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询statistics_report表数据
	 */
	public List<StatisticsReportDO> findStatisticsReportByPartnerId(String partnerId) {
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return statisticsReportDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询statistics_report表数据
	*/
	public List<StatisticsReportDO> findStatisticsReportByPartnerName(String partnerName) {
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return statisticsReportDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_report表数据
	 */
	public void updateStatisticsReportById(Long id,StatisticsReportDO statisticsReportDO) {
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsReportDAO.updateByExample(statisticsReportDO, exam);
	}

    /**
	 * 根据partnerId更新statistics_report表数据
	 */
	public void updateStatisticsReportByPartnerId(String partnerId,StatisticsReportDO statisticsReportDO) {
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		statisticsReportDAO.updateByExample(statisticsReportDO, exam);
	}

	/**
	* 根据partnerName更新statistics_report表数据
	*/
	public void updateStatisticsReportByPartnerName(String partnerName,StatisticsReportDO statisticsReportDO) {
		StatisticsReportDOExample exam = new StatisticsReportDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		statisticsReportDAO.updateByExample(statisticsReportDO, exam);
	}

    /**
	 * 断言statistics_spout表
	 */
	public void statisticsSpoutAssert(
	        StatisticsSpoutDO statisticsSpoutDO,
			Long id, 
			String spoutName, 
			String scanTable, 
			String scanFile, 
			String scanType, 
			Long step, 
			String filter, 
			String scanColumn, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, statisticsSpoutDO.getId());
        assertEquals(spoutName, statisticsSpoutDO.getSpoutName());
        assertEquals(scanTable, statisticsSpoutDO.getScanTable());
        assertEquals(scanFile, statisticsSpoutDO.getScanFile());
        assertEquals(scanType, statisticsSpoutDO.getScanType());
        assertEquals(step, statisticsSpoutDO.getStep());
        assertEquals(filter, statisticsSpoutDO.getFilter());
        assertEquals(scanColumn, statisticsSpoutDO.getScanColumn());
        assertEquals(memo, statisticsSpoutDO.getMemo());
        assertEquals(rawAddTime, statisticsSpoutDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsSpoutDO.getRawUpdateTime());
	}

	/**
	 * 断言statistics_spout表数据
	 */
	public void assertStatisticsSpout(StatisticsSpoutDO expect, StatisticsSpoutDO statisticsSpoutDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsSpoutDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsSpoutDO.getRawAddTime());
		expect.setRawAddTime(statisticsSpoutDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsSpoutDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsSpoutDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsSpoutDO);
	}

    /**
	 * 插入statistics_spout表数据
	 */
	public void insertStatisticsSpout(StatisticsSpoutDO statisticsSpoutDO) {
		statisticsSpoutDAO.insert(statisticsSpoutDO);
	}

    /**
	 * 插入statistics_spout表数据
	 */
	public void insertStatisticsSpout(
			Long id, 
			String spoutName, 
			String scanTable, 
			String scanFile, 
			String scanType, 
			Long step, 
			String filter, 
			String scanColumn, 
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
		StatisticsSpoutDO statisticsSpoutDO = new StatisticsSpoutDO();
		statisticsSpoutDO.setId(id);
		statisticsSpoutDO.setSpoutName(spoutName);
		statisticsSpoutDO.setScanTable(scanTable);
		statisticsSpoutDO.setScanFile(scanFile);
		statisticsSpoutDO.setScanType(scanType);
		statisticsSpoutDO.setStep(step);
		statisticsSpoutDO.setFilter(filter);
		statisticsSpoutDO.setScanColumn(scanColumn);
		statisticsSpoutDO.setMemo(memo);
		statisticsSpoutDO.setRawAddTime(rawAddTime);
		statisticsSpoutDO.setRawUpdateTime(rawUpdateTime);
		statisticsSpoutDAO.insert(statisticsSpoutDO);
	}

    /**
     * 删除statistics_spout表所有数据
     */
    public void cleanStatisticsSpout() {
        StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
        exam.createCriteria();
        statisticsSpoutDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_spout表数据
	 */
	public void cleanStatisticsSpoutById(Long id) {
		StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsSpoutDAO.deleteByExample(exam);
	}

	/**
	* 根据spoutName删除statistics_spout表数据
	*/
	public void cleanStatisticsSpoutBySpoutName(String spoutName) {
        if (StringUtils.isBlank(spoutName)){
            spoutName = "test_spoutName";
        }
		StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsSpoutDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_spout表所有数据
     */
    public List<StatisticsSpoutDO> findStatisticsSpoutAll() {
        StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
        exam.createCriteria();
		return statisticsSpoutDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_spout表数据
	 */
	public List<StatisticsSpoutDO> findStatisticsSpoutById(Long id) {
		StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsSpoutDAO.selectByExample(exam);
	}

	/**
	* 根据spoutName查询statistics_spout表数据
	*/
	public List<StatisticsSpoutDO> findStatisticsSpoutBySpoutName(String spoutName) {
		StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		return statisticsSpoutDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_spout表数据
	 */
	public void updateStatisticsSpoutById(Long id,StatisticsSpoutDO statisticsSpoutDO) {
		StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsSpoutDAO.updateByExample(statisticsSpoutDO, exam);
	}

	/**
	* 根据spoutName更新statistics_spout表数据
	*/
	public void updateStatisticsSpoutBySpoutName(String spoutName,StatisticsSpoutDO statisticsSpoutDO) {
		StatisticsSpoutDOExample exam = new StatisticsSpoutDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsSpoutDAO.updateByExample(statisticsSpoutDO, exam);
	}

    /**
	 * 断言statistics_task表
	 */
	public void statisticsTaskAssert(
	        StatisticsTaskDO statisticsTaskDO,
			Long id, 
			String spoutName, 
			String modelName, 
			String dataScan, 
			String startIndex, 
			String endIndex, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, statisticsTaskDO.getId());
        assertEquals(spoutName, statisticsTaskDO.getSpoutName());
        assertEquals(modelName, statisticsTaskDO.getModelName());
        assertEquals(dataScan, statisticsTaskDO.getDataScan());
        assertEquals(startIndex, statisticsTaskDO.getStartIndex());
        assertEquals(endIndex, statisticsTaskDO.getEndIndex());
        assertEquals(rawAddTime, statisticsTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, statisticsTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言statistics_task表数据
	 */
	public void assertStatisticsTask(StatisticsTaskDO expect, StatisticsTaskDO statisticsTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			statisticsTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != statisticsTaskDO.getRawAddTime());
		expect.setRawAddTime(statisticsTaskDO.getRawAddTime());
        Assertions.assertTrue(null != statisticsTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(statisticsTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, statisticsTaskDO);
	}

    /**
	 * 插入statistics_task表数据
	 */
	public void insertStatisticsTask(StatisticsTaskDO statisticsTaskDO) {
		statisticsTaskDAO.insert(statisticsTaskDO);
	}

    /**
	 * 插入statistics_task表数据
	 */
	public void insertStatisticsTask(
			Long id, 
			String spoutName, 
			String modelName, 
			String dataScan, 
			String startIndex, 
			String endIndex, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		StatisticsTaskDO statisticsTaskDO = new StatisticsTaskDO();
		statisticsTaskDO.setId(id);
		statisticsTaskDO.setSpoutName(spoutName);
		statisticsTaskDO.setModelName(modelName);
		statisticsTaskDO.setDataScan(dataScan);
		statisticsTaskDO.setStartIndex(startIndex);
		statisticsTaskDO.setEndIndex(endIndex);
		statisticsTaskDO.setRawAddTime(rawAddTime);
		statisticsTaskDO.setRawUpdateTime(rawUpdateTime);
		statisticsTaskDAO.insert(statisticsTaskDO);
	}

    /**
     * 删除statistics_task表所有数据
     */
    public void cleanStatisticsTask() {
        StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
        exam.createCriteria();
        statisticsTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除statistics_task表数据
	 */
	public void cleanStatisticsTaskById(Long id) {
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据spoutName删除statistics_task表数据
	*/
	public void cleanStatisticsTaskBySpoutName(String spoutName) {
        if (StringUtils.isBlank(spoutName)){
            spoutName = "test_spoutName";
        }
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据modelName删除statistics_task表数据
	*/
	public void cleanStatisticsTaskByModelName(String modelName) {
        if (StringUtils.isBlank(modelName)){
            modelName = "test_modelName";
        }
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		statisticsTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询statistics_task表所有数据
     */
    public List<StatisticsTaskDO> findStatisticsTaskAll() {
        StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
        exam.createCriteria();
		return statisticsTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询statistics_task表数据
	 */
	public List<StatisticsTaskDO> findStatisticsTaskById(Long id) {
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return statisticsTaskDAO.selectByExample(exam);
	}

	/**
	* 根据spoutName查询statistics_task表数据
	*/
	public List<StatisticsTaskDO> findStatisticsTaskBySpoutName(String spoutName) {
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		return statisticsTaskDAO.selectByExample(exam);
	}

	/**
	* 根据modelName查询statistics_task表数据
	*/
	public List<StatisticsTaskDO> findStatisticsTaskByModelName(String modelName) {
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		return statisticsTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新statistics_task表数据
	 */
	public void updateStatisticsTaskById(Long id,StatisticsTaskDO statisticsTaskDO) {
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		statisticsTaskDAO.updateByExample(statisticsTaskDO, exam);
	}

	/**
	* 根据spoutName更新statistics_task表数据
	*/
	public void updateStatisticsTaskBySpoutName(String spoutName,StatisticsTaskDO statisticsTaskDO) {
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andSpoutNameEqualTo(spoutName);
		statisticsTaskDAO.updateByExample(statisticsTaskDO, exam);
	}

	/**
	* 根据modelName更新statistics_task表数据
	*/
	public void updateStatisticsTaskByModelName(String modelName,StatisticsTaskDO statisticsTaskDO) {
		StatisticsTaskDOExample exam = new StatisticsTaskDOExample();
		exam.createCriteria().andModelNameEqualTo(modelName);
		statisticsTaskDAO.updateByExample(statisticsTaskDO, exam);
	}

    /**
	 * 断言temp_user_car表
	 */
	public void tempUserCarAssert(
	        TempUserCarDO tempUserCarDO,
			Long id, 
			String userId, 
			String carNumber, 
			String carType
	) {
        assertEquals(id, tempUserCarDO.getId());
        assertEquals(userId, tempUserCarDO.getUserId());
        assertEquals(carNumber, tempUserCarDO.getCarNumber());
        assertEquals(carType, tempUserCarDO.getCarType());
	}

	/**
	 * 断言temp_user_car表数据
	 */
	public void assertTempUserCar(TempUserCarDO expect, TempUserCarDO tempUserCarDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			tempUserCarDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, tempUserCarDO);
	}

    /**
	 * 插入temp_user_car表数据
	 */
	public void insertTempUserCar(TempUserCarDO tempUserCarDO) {
		tempUserCarDAO.insert(tempUserCarDO);
	}

    /**
	 * 插入temp_user_car表数据
	 */
	public void insertTempUserCar(
			Long id, 
			String userId, 
			String carNumber, 
			String carType
	) {
		TempUserCarDO tempUserCarDO = new TempUserCarDO();
		tempUserCarDO.setId(id);
		tempUserCarDO.setUserId(userId);
		tempUserCarDO.setCarNumber(carNumber);
		tempUserCarDO.setCarType(carType);
		tempUserCarDAO.insert(tempUserCarDO);
	}

    /**
     * 删除temp_user_car表所有数据
     */
    public void cleanTempUserCar() {
        TempUserCarDOExample exam = new TempUserCarDOExample();
        exam.createCriteria();
        tempUserCarDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除temp_user_car表数据
	 */
	public void cleanTempUserCarById(Long id) {
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andIdEqualTo(id);
		tempUserCarDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除temp_user_car表数据
	 */
	public void cleanTempUserCarByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tempUserCarDAO.deleteByExample(exam);
	}

	/**
	* 根据carNumber删除temp_user_car表数据
	*/
	public void cleanTempUserCarByCarNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)){
            carNumber = "test_carNumber";
        }
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		tempUserCarDAO.deleteByExample(exam);
	}

    /**
     * 查询temp_user_car表所有数据
     */
    public List<TempUserCarDO> findTempUserCarAll() {
        TempUserCarDOExample exam = new TempUserCarDOExample();
        exam.createCriteria();
		return tempUserCarDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询temp_user_car表数据
	 */
	public List<TempUserCarDO> findTempUserCarById(Long id) {
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return tempUserCarDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询temp_user_car表数据
	 */
	public List<TempUserCarDO> findTempUserCarByUserId(String userId) {
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return tempUserCarDAO.selectByExample(exam);
	}

	/**
	* 根据carNumber查询temp_user_car表数据
	*/
	public List<TempUserCarDO> findTempUserCarByCarNumber(String carNumber) {
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		return tempUserCarDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新temp_user_car表数据
	 */
	public void updateTempUserCarById(Long id,TempUserCarDO tempUserCarDO) {
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andIdEqualTo(id);
		tempUserCarDAO.updateByExample(tempUserCarDO, exam);
	}

    /**
	 * 根据userId更新temp_user_car表数据
	 */
	public void updateTempUserCarByUserId(String userId,TempUserCarDO tempUserCarDO) {
		TempUserCarDOExample exam = new TempUserCarDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tempUserCarDAO.updateByExample(tempUserCarDO, exam);
	}

    /**
	 * 断言user_dimension表
	 */
	public void userDimensionAssert(
	        UserDimensionDO userDimensionDO,
			Long id, 
			String dimensionType, 
			String dimensionName, 
			String dimensionCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userDimensionDO.getId());
        assertEquals(dimensionType, userDimensionDO.getDimensionType());
        assertEquals(dimensionName, userDimensionDO.getDimensionName());
        assertEquals(dimensionCode, userDimensionDO.getDimensionCode());
        assertEquals(rawAddTime, userDimensionDO.getRawAddTime());
        assertEquals(rawUpdateTime, userDimensionDO.getRawUpdateTime());
	}

	/**
	 * 断言user_dimension表数据
	 */
	public void assertUserDimension(UserDimensionDO expect, UserDimensionDO userDimensionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userDimensionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userDimensionDO.getRawAddTime());
		expect.setRawAddTime(userDimensionDO.getRawAddTime());
        Assertions.assertTrue(null != userDimensionDO.getRawUpdateTime());
		expect.setRawUpdateTime(userDimensionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userDimensionDO);
	}

    /**
	 * 插入user_dimension表数据
	 */
	public void insertUserDimension(UserDimensionDO userDimensionDO) {
		userDimensionDAO.insert(userDimensionDO);
	}

    /**
	 * 插入user_dimension表数据
	 */
	public void insertUserDimension(
			Long id, 
			String dimensionType, 
			String dimensionName, 
			String dimensionCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserDimensionDO userDimensionDO = new UserDimensionDO();
		userDimensionDO.setId(id);
		userDimensionDO.setDimensionType(dimensionType);
		userDimensionDO.setDimensionName(dimensionName);
		userDimensionDO.setDimensionCode(dimensionCode);
		userDimensionDO.setRawAddTime(rawAddTime);
		userDimensionDO.setRawUpdateTime(rawUpdateTime);
		userDimensionDAO.insert(userDimensionDO);
	}

    /**
     * 删除user_dimension表所有数据
     */
    public void cleanUserDimension() {
        UserDimensionDOExample exam = new UserDimensionDOExample();
        exam.createCriteria();
        userDimensionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_dimension表数据
	 */
	public void cleanUserDimensionById(Long id) {
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userDimensionDAO.deleteByExample(exam);
	}

	/**
	* 根据dimensionName删除user_dimension表数据
	*/
	public void cleanUserDimensionByDimensionName(String dimensionName) {
        if (StringUtils.isBlank(dimensionName)){
            dimensionName = "test_dimensionName";
        }
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andDimensionNameEqualTo(dimensionName);
		userDimensionDAO.deleteByExample(exam);
	}

	/**
	* 根据dimensionCode删除user_dimension表数据
	*/
	public void cleanUserDimensionByDimensionCode(String dimensionCode) {
        if (StringUtils.isBlank(dimensionCode)){
            dimensionCode = "test_dimensionCode";
        }
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andDimensionCodeEqualTo(dimensionCode);
		userDimensionDAO.deleteByExample(exam);
	}

    /**
     * 查询user_dimension表所有数据
     */
    public List<UserDimensionDO> findUserDimensionAll() {
        UserDimensionDOExample exam = new UserDimensionDOExample();
        exam.createCriteria();
		return userDimensionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_dimension表数据
	 */
	public List<UserDimensionDO> findUserDimensionById(Long id) {
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userDimensionDAO.selectByExample(exam);
	}

	/**
	* 根据dimensionName查询user_dimension表数据
	*/
	public List<UserDimensionDO> findUserDimensionByDimensionName(String dimensionName) {
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andDimensionNameEqualTo(dimensionName);
		return userDimensionDAO.selectByExample(exam);
	}

	/**
	* 根据dimensionCode查询user_dimension表数据
	*/
	public List<UserDimensionDO> findUserDimensionByDimensionCode(String dimensionCode) {
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andDimensionCodeEqualTo(dimensionCode);
		return userDimensionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_dimension表数据
	 */
	public void updateUserDimensionById(Long id,UserDimensionDO userDimensionDO) {
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userDimensionDAO.updateByExample(userDimensionDO, exam);
	}

	/**
	* 根据dimensionName更新user_dimension表数据
	*/
	public void updateUserDimensionByDimensionName(String dimensionName,UserDimensionDO userDimensionDO) {
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andDimensionNameEqualTo(dimensionName);
		userDimensionDAO.updateByExample(userDimensionDO, exam);
	}

	/**
	* 根据dimensionCode更新user_dimension表数据
	*/
	public void updateUserDimensionByDimensionCode(String dimensionCode,UserDimensionDO userDimensionDO) {
		UserDimensionDOExample exam = new UserDimensionDOExample();
		exam.createCriteria().andDimensionCodeEqualTo(dimensionCode);
		userDimensionDAO.updateByExample(userDimensionDO, exam);
	}

    /**
	 * 断言user_invite_log表
	 */
	public void userInviteLogAssert(
	        UserInviteLogDO userInviteLogDO,
			Long id, 
			String partnerId, 
			String userId, 
			String mobile, 
			Date birthday, 
			String nickName, 
			String realName, 
			String sex, 
			String memberType, 
			String grade, 
			String userInviterId, 
			String userInviterName, 
			String userInviterMobile, 
			Date inviteTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userInviteLogDO.getId());
        assertEquals(partnerId, userInviteLogDO.getPartnerId());
        assertEquals(userId, userInviteLogDO.getUserId());
        assertEquals(mobile, userInviteLogDO.getMobile());
        assertEquals(birthday, userInviteLogDO.getBirthday());
        assertEquals(nickName, userInviteLogDO.getNickName());
        assertEquals(realName, userInviteLogDO.getRealName());
        assertEquals(sex, userInviteLogDO.getSex());
        assertEquals(memberType, userInviteLogDO.getMemberType());
        assertEquals(grade, userInviteLogDO.getGrade());
        assertEquals(userInviterId, userInviteLogDO.getUserInviterId());
        assertEquals(userInviterName, userInviteLogDO.getUserInviterName());
        assertEquals(userInviterMobile, userInviteLogDO.getUserInviterMobile());
        assertEquals(inviteTime, userInviteLogDO.getInviteTime());
        assertEquals(rawAddTime, userInviteLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, userInviteLogDO.getRawUpdateTime());
	}

	/**
	 * 断言user_invite_log表数据
	 */
	public void assertUserInviteLog(UserInviteLogDO expect, UserInviteLogDO userInviteLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userInviteLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userInviteLogDO.getRawAddTime());
		expect.setRawAddTime(userInviteLogDO.getRawAddTime());
        Assertions.assertTrue(null != userInviteLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(userInviteLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userInviteLogDO);
	}

    /**
	 * 插入user_invite_log表数据
	 */
	public void insertUserInviteLog(UserInviteLogDO userInviteLogDO) {
		userInviteLogDAO.insert(userInviteLogDO);
	}

    /**
	 * 插入user_invite_log表数据
	 */
	public void insertUserInviteLog(
			Long id, 
			String partnerId, 
			String userId, 
			String mobile, 
			Date birthday, 
			String nickName, 
			String realName, 
			String sex, 
			String memberType, 
			String grade, 
			String userInviterId, 
			String userInviterName, 
			String userInviterMobile, 
			Date inviteTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserInviteLogDO userInviteLogDO = new UserInviteLogDO();
		userInviteLogDO.setId(id);
		userInviteLogDO.setPartnerId(partnerId);
		userInviteLogDO.setUserId(userId);
		userInviteLogDO.setMobile(mobile);
		userInviteLogDO.setBirthday(birthday);
		userInviteLogDO.setNickName(nickName);
		userInviteLogDO.setRealName(realName);
		userInviteLogDO.setSex(sex);
		userInviteLogDO.setMemberType(memberType);
		userInviteLogDO.setGrade(grade);
		userInviteLogDO.setUserInviterId(userInviterId);
		userInviteLogDO.setUserInviterName(userInviterName);
		userInviteLogDO.setUserInviterMobile(userInviterMobile);
		userInviteLogDO.setInviteTime(inviteTime);
		userInviteLogDO.setRawAddTime(rawAddTime);
		userInviteLogDO.setRawUpdateTime(rawUpdateTime);
		userInviteLogDAO.insert(userInviteLogDO);
	}

    /**
     * 删除user_invite_log表所有数据
     */
    public void cleanUserInviteLog() {
        UserInviteLogDOExample exam = new UserInviteLogDOExample();
        exam.createCriteria();
        userInviteLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_invite_log表数据
	 */
	public void cleanUserInviteLogById(Long id) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_invite_log表数据
	 */
	public void cleanUserInviteLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_invite_log表数据
	 */
	public void cleanUserInviteLogByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除user_invite_log表数据
	 */
	public void cleanUserInviteLogByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除user_invite_log表数据
	*/
	public void cleanUserInviteLogByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除user_invite_log表数据
	*/
	public void cleanUserInviteLogByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userInviterId删除user_invite_log表数据
	 */
	public void cleanUserInviteLogByUserInviterId(String userInviterId) {
        if (StringUtils.isBlank(userInviterId)){
            userInviterId = "test_userInviterId";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviterIdEqualTo(userInviterId);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	* 根据userInviterName删除user_invite_log表数据
	*/
	public void cleanUserInviteLogByUserInviterName(String userInviterName) {
        if (StringUtils.isBlank(userInviterName)){
            userInviterName = "test_userInviterName";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviterNameEqualTo(userInviterName);
		userInviteLogDAO.deleteByExample(exam);
	}

    /**
     * 查询user_invite_log表所有数据
     */
    public List<UserInviteLogDO> findUserInviteLogAll() {
        UserInviteLogDOExample exam = new UserInviteLogDOExample();
        exam.createCriteria();
		return userInviteLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_invite_log表数据
	 */
	public List<UserInviteLogDO> findUserInviteLogById(Long id) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userInviteLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_invite_log表数据
	 */
	public List<UserInviteLogDO> findUserInviteLogByPartnerId(String partnerId) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userInviteLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_invite_log表数据
	 */
	public List<UserInviteLogDO> findUserInviteLogByUserId(String userId) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userInviteLogDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询user_invite_log表数据
	 */
	public List<UserInviteLogDO> findUserInviteLogByMobile(String mobile) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return userInviteLogDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询user_invite_log表数据
	*/
	public List<UserInviteLogDO> findUserInviteLogByNickName(String nickName) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return userInviteLogDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询user_invite_log表数据
	*/
	public List<UserInviteLogDO> findUserInviteLogByRealName(String realName) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return userInviteLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userInviterId查询user_invite_log表数据
	 */
	public List<UserInviteLogDO> findUserInviteLogByUserInviterId(String userInviterId) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviterIdEqualTo(userInviterId);
		return userInviteLogDAO.selectByExample(exam);
	}

	/**
	* 根据userInviterName查询user_invite_log表数据
	*/
	public List<UserInviteLogDO> findUserInviteLogByUserInviterName(String userInviterName) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviterNameEqualTo(userInviterName);
		return userInviteLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_invite_log表数据
	 */
	public void updateUserInviteLogById(Long id,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

    /**
	 * 根据partnerId更新user_invite_log表数据
	 */
	public void updateUserInviteLogByPartnerId(String partnerId,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

    /**
	 * 根据userId更新user_invite_log表数据
	 */
	public void updateUserInviteLogByUserId(String userId,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

    /**
	 * 根据mobile更新user_invite_log表数据
	 */
	public void updateUserInviteLogByMobile(String mobile,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

	/**
	* 根据nickName更新user_invite_log表数据
	*/
	public void updateUserInviteLogByNickName(String nickName,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

	/**
	* 根据realName更新user_invite_log表数据
	*/
	public void updateUserInviteLogByRealName(String realName,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

    /**
	 * 根据userInviterId更新user_invite_log表数据
	 */
	public void updateUserInviteLogByUserInviterId(String userInviterId,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviterIdEqualTo(userInviterId);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

	/**
	* 根据userInviterName更新user_invite_log表数据
	*/
	public void updateUserInviteLogByUserInviterName(String userInviterName,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviterNameEqualTo(userInviterName);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

    /**
	 * 断言user_persona表
	 */
	public void userPersonaAssert(
	        UserPersonaDO userPersonaDO,
			Long id, 
			String personaName, 
			String personaCode, 
			Date startTime, 
			Date endTime, 
			String status, 
			String calculateStatus, 
			Integer scanCount, 
			Integer scanSize, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String filedCondition
	) {
        assertEquals(id, userPersonaDO.getId());
        assertEquals(personaName, userPersonaDO.getPersonaName());
        assertEquals(personaCode, userPersonaDO.getPersonaCode());
        assertEquals(startTime, userPersonaDO.getStartTime());
        assertEquals(endTime, userPersonaDO.getEndTime());
        assertEquals(status, userPersonaDO.getStatus());
        assertEquals(calculateStatus, userPersonaDO.getCalculateStatus());
        assertEquals(scanCount, userPersonaDO.getScanCount());
        assertEquals(scanSize, userPersonaDO.getScanSize());
        assertEquals(memo, userPersonaDO.getMemo());
        assertEquals(rawAddTime, userPersonaDO.getRawAddTime());
        assertEquals(rawUpdateTime, userPersonaDO.getRawUpdateTime());
        assertEquals(filedCondition, userPersonaDO.getFiledCondition());
	}

	/**
	 * 断言user_persona表数据
	 */
	public void assertUserPersona(UserPersonaDO expect, UserPersonaDO userPersonaDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userPersonaDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userPersonaDO.getRawAddTime());
		expect.setRawAddTime(userPersonaDO.getRawAddTime());
        Assertions.assertTrue(null != userPersonaDO.getRawUpdateTime());
		expect.setRawUpdateTime(userPersonaDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userPersonaDO);
	}

    /**
	 * 插入user_persona表数据
	 */
	public void insertUserPersona(UserPersonaDO userPersonaDO) {
		userPersonaDAO.insert(userPersonaDO);
	}

    /**
	 * 插入user_persona表数据
	 */
	public void insertUserPersona(
			Long id, 
			String personaName, 
			String personaCode, 
			Date startTime, 
			Date endTime, 
			String status, 
			String calculateStatus, 
			Integer scanCount, 
			Integer scanSize, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String filedCondition
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserPersonaDO userPersonaDO = new UserPersonaDO();
		userPersonaDO.setId(id);
		userPersonaDO.setPersonaName(personaName);
		userPersonaDO.setPersonaCode(personaCode);
		userPersonaDO.setStartTime(startTime);
		userPersonaDO.setEndTime(endTime);
		userPersonaDO.setStatus(status);
		userPersonaDO.setCalculateStatus(calculateStatus);
		userPersonaDO.setScanCount(scanCount);
		userPersonaDO.setScanSize(scanSize);
		userPersonaDO.setMemo(memo);
		userPersonaDO.setRawAddTime(rawAddTime);
		userPersonaDO.setRawUpdateTime(rawUpdateTime);
		userPersonaDO.setFiledCondition(filedCondition);
		userPersonaDAO.insert(userPersonaDO);
	}

    /**
     * 删除user_persona表所有数据
     */
    public void cleanUserPersona() {
        UserPersonaDOExample exam = new UserPersonaDOExample();
        exam.createCriteria();
        userPersonaDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_persona表数据
	 */
	public void cleanUserPersonaById(Long id) {
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userPersonaDAO.deleteByExample(exam);
	}

	/**
	* 根据personaName删除user_persona表数据
	*/
	public void cleanUserPersonaByPersonaName(String personaName) {
        if (StringUtils.isBlank(personaName)){
            personaName = "test_personaName";
        }
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andPersonaNameEqualTo(personaName);
		userPersonaDAO.deleteByExample(exam);
	}

	/**
	* 根据personaCode删除user_persona表数据
	*/
	public void cleanUserPersonaByPersonaCode(String personaCode) {
        if (StringUtils.isBlank(personaCode)){
            personaCode = "test_personaCode";
        }
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andPersonaCodeEqualTo(personaCode);
		userPersonaDAO.deleteByExample(exam);
	}

    /**
     * 查询user_persona表所有数据
     */
    public List<UserPersonaDO> findUserPersonaAll() {
        UserPersonaDOExample exam = new UserPersonaDOExample();
        exam.createCriteria();
		return userPersonaDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_persona表数据
	 */
	public List<UserPersonaDO> findUserPersonaById(Long id) {
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userPersonaDAO.selectByExample(exam);
	}

	/**
	* 根据personaName查询user_persona表数据
	*/
	public List<UserPersonaDO> findUserPersonaByPersonaName(String personaName) {
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andPersonaNameEqualTo(personaName);
		return userPersonaDAO.selectByExample(exam);
	}

	/**
	* 根据personaCode查询user_persona表数据
	*/
	public List<UserPersonaDO> findUserPersonaByPersonaCode(String personaCode) {
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andPersonaCodeEqualTo(personaCode);
		return userPersonaDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_persona表数据
	 */
	public void updateUserPersonaById(Long id,UserPersonaDO userPersonaDO) {
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userPersonaDAO.updateByExample(userPersonaDO, exam);
	}

	/**
	* 根据personaName更新user_persona表数据
	*/
	public void updateUserPersonaByPersonaName(String personaName,UserPersonaDO userPersonaDO) {
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andPersonaNameEqualTo(personaName);
		userPersonaDAO.updateByExample(userPersonaDO, exam);
	}

	/**
	* 根据personaCode更新user_persona表数据
	*/
	public void updateUserPersonaByPersonaCode(String personaCode,UserPersonaDO userPersonaDO) {
		UserPersonaDOExample exam = new UserPersonaDOExample();
		exam.createCriteria().andPersonaCodeEqualTo(personaCode);
		userPersonaDAO.updateByExample(userPersonaDO, exam);
	}

    /**
	 * 断言user_persona_notify_task表
	 */
	public void userPersonaNotifyTaskAssert(
	        UserPersonaNotifyTaskDO userPersonaNotifyTaskDO,
			Long id, 
			Long personaId, 
			String userId, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
        assertEquals(id, userPersonaNotifyTaskDO.getId());
        assertEquals(personaId, userPersonaNotifyTaskDO.getPersonaId());
        assertEquals(userId, userPersonaNotifyTaskDO.getUserId());
        assertEquals(rawAddTime, userPersonaNotifyTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, userPersonaNotifyTaskDO.getRawUpdateTime());
        assertEquals(context, userPersonaNotifyTaskDO.getContext());
	}

	/**
	 * 断言user_persona_notify_task表数据
	 */
	public void assertUserPersonaNotifyTask(UserPersonaNotifyTaskDO expect, UserPersonaNotifyTaskDO userPersonaNotifyTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userPersonaNotifyTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userPersonaNotifyTaskDO.getRawAddTime());
		expect.setRawAddTime(userPersonaNotifyTaskDO.getRawAddTime());
        Assertions.assertTrue(null != userPersonaNotifyTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(userPersonaNotifyTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userPersonaNotifyTaskDO);
	}

    /**
	 * 插入user_persona_notify_task表数据
	 */
	public void insertUserPersonaNotifyTask(UserPersonaNotifyTaskDO userPersonaNotifyTaskDO) {
		userPersonaNotifyTaskDAO.insert(userPersonaNotifyTaskDO);
	}

    /**
	 * 插入user_persona_notify_task表数据
	 */
	public void insertUserPersonaNotifyTask(
			Long id, 
			Long personaId, 
			String userId, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserPersonaNotifyTaskDO userPersonaNotifyTaskDO = new UserPersonaNotifyTaskDO();
		userPersonaNotifyTaskDO.setId(id);
		userPersonaNotifyTaskDO.setPersonaId(personaId);
		userPersonaNotifyTaskDO.setUserId(userId);
		userPersonaNotifyTaskDO.setRawAddTime(rawAddTime);
		userPersonaNotifyTaskDO.setRawUpdateTime(rawUpdateTime);
		userPersonaNotifyTaskDO.setContext(context);
		userPersonaNotifyTaskDAO.insert(userPersonaNotifyTaskDO);
	}

    /**
     * 删除user_persona_notify_task表所有数据
     */
    public void cleanUserPersonaNotifyTask() {
        UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
        exam.createCriteria();
        userPersonaNotifyTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_persona_notify_task表数据
	 */
	public void cleanUserPersonaNotifyTaskById(Long id) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userPersonaNotifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据personaId删除user_persona_notify_task表数据
	 */
	public void cleanUserPersonaNotifyTaskByPersonaId(Long personaId) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		userPersonaNotifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_persona_notify_task表数据
	 */
	public void cleanUserPersonaNotifyTaskByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userPersonaNotifyTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询user_persona_notify_task表所有数据
     */
    public List<UserPersonaNotifyTaskDO> findUserPersonaNotifyTaskAll() {
        UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
        exam.createCriteria();
		return userPersonaNotifyTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_persona_notify_task表数据
	 */
	public List<UserPersonaNotifyTaskDO> findUserPersonaNotifyTaskById(Long id) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userPersonaNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据personaId查询user_persona_notify_task表数据
	 */
	public List<UserPersonaNotifyTaskDO> findUserPersonaNotifyTaskByPersonaId(Long personaId) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		return userPersonaNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_persona_notify_task表数据
	 */
	public List<UserPersonaNotifyTaskDO> findUserPersonaNotifyTaskByUserId(String userId) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userPersonaNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_persona_notify_task表数据
	 */
	public void updateUserPersonaNotifyTaskById(Long id,UserPersonaNotifyTaskDO userPersonaNotifyTaskDO) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userPersonaNotifyTaskDAO.updateByExample(userPersonaNotifyTaskDO, exam);
	}

    /**
	 * 根据personaId更新user_persona_notify_task表数据
	 */
	public void updateUserPersonaNotifyTaskByPersonaId(Long personaId,UserPersonaNotifyTaskDO userPersonaNotifyTaskDO) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		userPersonaNotifyTaskDAO.updateByExample(userPersonaNotifyTaskDO, exam);
	}

    /**
	 * 根据userId更新user_persona_notify_task表数据
	 */
	public void updateUserPersonaNotifyTaskByUserId(String userId,UserPersonaNotifyTaskDO userPersonaNotifyTaskDO) {
		UserPersonaNotifyTaskDOExample exam = new UserPersonaNotifyTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userPersonaNotifyTaskDAO.updateByExample(userPersonaNotifyTaskDO, exam);
	}

    /**
	 * 断言user_spread_log表
	 */
	public void userSpreadLogAssert(
	        UserSpreadLogDO userSpreadLogDO,
			Long id, 
			String partnerId, 
			String userId, 
			String mobile, 
			Date birthday, 
			String nickName, 
			String realName, 
			String sex, 
			String memberType, 
			String grade, 
			String stationId, 
			String stationName, 
			String stationCode, 
			String operatorId, 
			String operatorName, 
			String operatorMobile, 
			Date spreadTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userSpreadLogDO.getId());
        assertEquals(partnerId, userSpreadLogDO.getPartnerId());
        assertEquals(userId, userSpreadLogDO.getUserId());
        assertEquals(mobile, userSpreadLogDO.getMobile());
        assertEquals(birthday, userSpreadLogDO.getBirthday());
        assertEquals(nickName, userSpreadLogDO.getNickName());
        assertEquals(realName, userSpreadLogDO.getRealName());
        assertEquals(sex, userSpreadLogDO.getSex());
        assertEquals(memberType, userSpreadLogDO.getMemberType());
        assertEquals(grade, userSpreadLogDO.getGrade());
        assertEquals(stationId, userSpreadLogDO.getStationId());
        assertEquals(stationName, userSpreadLogDO.getStationName());
        assertEquals(stationCode, userSpreadLogDO.getStationCode());
        assertEquals(operatorId, userSpreadLogDO.getOperatorId());
        assertEquals(operatorName, userSpreadLogDO.getOperatorName());
        assertEquals(operatorMobile, userSpreadLogDO.getOperatorMobile());
        assertEquals(spreadTime, userSpreadLogDO.getSpreadTime());
        assertEquals(rawAddTime, userSpreadLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, userSpreadLogDO.getRawUpdateTime());
	}

	/**
	 * 断言user_spread_log表数据
	 */
	public void assertUserSpreadLog(UserSpreadLogDO expect, UserSpreadLogDO userSpreadLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userSpreadLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userSpreadLogDO.getRawAddTime());
		expect.setRawAddTime(userSpreadLogDO.getRawAddTime());
        Assertions.assertTrue(null != userSpreadLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(userSpreadLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userSpreadLogDO);
	}

    /**
	 * 插入user_spread_log表数据
	 */
	public void insertUserSpreadLog(UserSpreadLogDO userSpreadLogDO) {
		userSpreadLogDAO.insert(userSpreadLogDO);
	}

    /**
	 * 插入user_spread_log表数据
	 */
	public void insertUserSpreadLog(
			Long id, 
			String partnerId, 
			String userId, 
			String mobile, 
			Date birthday, 
			String nickName, 
			String realName, 
			String sex, 
			String memberType, 
			String grade, 
			String stationId, 
			String stationName, 
			String stationCode, 
			String operatorId, 
			String operatorName, 
			String operatorMobile, 
			Date spreadTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserSpreadLogDO userSpreadLogDO = new UserSpreadLogDO();
		userSpreadLogDO.setId(id);
		userSpreadLogDO.setPartnerId(partnerId);
		userSpreadLogDO.setUserId(userId);
		userSpreadLogDO.setMobile(mobile);
		userSpreadLogDO.setBirthday(birthday);
		userSpreadLogDO.setNickName(nickName);
		userSpreadLogDO.setRealName(realName);
		userSpreadLogDO.setSex(sex);
		userSpreadLogDO.setMemberType(memberType);
		userSpreadLogDO.setGrade(grade);
		userSpreadLogDO.setStationId(stationId);
		userSpreadLogDO.setStationName(stationName);
		userSpreadLogDO.setStationCode(stationCode);
		userSpreadLogDO.setOperatorId(operatorId);
		userSpreadLogDO.setOperatorName(operatorName);
		userSpreadLogDO.setOperatorMobile(operatorMobile);
		userSpreadLogDO.setSpreadTime(spreadTime);
		userSpreadLogDO.setRawAddTime(rawAddTime);
		userSpreadLogDO.setRawUpdateTime(rawUpdateTime);
		userSpreadLogDAO.insert(userSpreadLogDO);
	}

    /**
     * 删除user_spread_log表所有数据
     */
    public void cleanUserSpreadLog() {
        UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
        exam.createCriteria();
        userSpreadLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_spread_log表数据
	 */
	public void cleanUserSpreadLogById(Long id) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_spread_log表数据
	 */
	public void cleanUserSpreadLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_spread_log表数据
	 */
	public void cleanUserSpreadLogByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除user_spread_log表数据
	 */
	public void cleanUserSpreadLogByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除user_spread_log表数据
	*/
	public void cleanUserSpreadLogByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除user_spread_log表数据
	*/
	public void cleanUserSpreadLogByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除user_spread_log表数据
	 */
	public void cleanUserSpreadLogByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除user_spread_log表数据
	*/
	public void cleanUserSpreadLogByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除user_spread_log表数据
	*/
	public void cleanUserSpreadLogByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除user_spread_log表数据
	 */
	public void cleanUserSpreadLogByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		userSpreadLogDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除user_spread_log表数据
	*/
	public void cleanUserSpreadLogByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		userSpreadLogDAO.deleteByExample(exam);
	}

    /**
     * 查询user_spread_log表所有数据
     */
    public List<UserSpreadLogDO> findUserSpreadLogAll() {
        UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
        exam.createCriteria();
		return userSpreadLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogById(Long id) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userSpreadLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogByPartnerId(String partnerId) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userSpreadLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogByUserId(String userId) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userSpreadLogDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogByMobile(String mobile) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return userSpreadLogDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询user_spread_log表数据
	*/
	public List<UserSpreadLogDO> findUserSpreadLogByNickName(String nickName) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return userSpreadLogDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询user_spread_log表数据
	*/
	public List<UserSpreadLogDO> findUserSpreadLogByRealName(String realName) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return userSpreadLogDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogByStationId(String stationId) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return userSpreadLogDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询user_spread_log表数据
	*/
	public List<UserSpreadLogDO> findUserSpreadLogByStationName(String stationName) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return userSpreadLogDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询user_spread_log表数据
	*/
	public List<UserSpreadLogDO> findUserSpreadLogByStationCode(String stationCode) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return userSpreadLogDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogByOperatorId(String operatorId) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return userSpreadLogDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询user_spread_log表数据
	*/
	public List<UserSpreadLogDO> findUserSpreadLogByOperatorName(String operatorName) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return userSpreadLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_spread_log表数据
	 */
	public void updateUserSpreadLogById(Long id,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

    /**
	 * 根据partnerId更新user_spread_log表数据
	 */
	public void updateUserSpreadLogByPartnerId(String partnerId,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

    /**
	 * 根据userId更新user_spread_log表数据
	 */
	public void updateUserSpreadLogByUserId(String userId,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

    /**
	 * 根据mobile更新user_spread_log表数据
	 */
	public void updateUserSpreadLogByMobile(String mobile,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

	/**
	* 根据nickName更新user_spread_log表数据
	*/
	public void updateUserSpreadLogByNickName(String nickName,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

	/**
	* 根据realName更新user_spread_log表数据
	*/
	public void updateUserSpreadLogByRealName(String realName,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

    /**
	 * 根据stationId更新user_spread_log表数据
	 */
	public void updateUserSpreadLogByStationId(String stationId,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

	/**
	* 根据stationName更新user_spread_log表数据
	*/
	public void updateUserSpreadLogByStationName(String stationName,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

	/**
	* 根据stationCode更新user_spread_log表数据
	*/
	public void updateUserSpreadLogByStationCode(String stationCode,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

    /**
	 * 根据operatorId更新user_spread_log表数据
	 */
	public void updateUserSpreadLogByOperatorId(String operatorId,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

	/**
	* 根据operatorName更新user_spread_log表数据
	*/
	public void updateUserSpreadLogByOperatorName(String operatorName,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		userSpreadLogDAO.updateByExample(userSpreadLogDO, exam);
	}

    /**
	 * 断言wash_coupon表
	 */
	public void washCouponAssert(
	        WashCouponDO washCouponDO,
			Long id, 
			String definitionId, 
			String partnerId, 
			String couponName, 
			String couponBizType, 
			String status, 
			String useTimeUnit, 
			String days, 
			Integer maxUse, 
			String timeSlots, 
			String couponUseRule, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, washCouponDO.getId());
        assertEquals(definitionId, washCouponDO.getDefinitionId());
        assertEquals(partnerId, washCouponDO.getPartnerId());
        assertEquals(couponName, washCouponDO.getCouponName());
        assertEquals(couponBizType, washCouponDO.getCouponBizType());
        assertEquals(status, washCouponDO.getStatus());
        assertEquals(useTimeUnit, washCouponDO.getUseTimeUnit());
        assertEquals(days, washCouponDO.getDays());
        assertEquals(maxUse, washCouponDO.getMaxUse());
        assertEquals(timeSlots, washCouponDO.getTimeSlots());
        assertEquals(couponUseRule, washCouponDO.getCouponUseRule());
        assertEquals(rawAddTime, washCouponDO.getRawAddTime());
        assertEquals(rawUpdateTime, washCouponDO.getRawUpdateTime());
	}

	/**
	 * 断言wash_coupon表数据
	 */
	public void assertWashCoupon(WashCouponDO expect, WashCouponDO washCouponDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			washCouponDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != washCouponDO.getRawAddTime());
		expect.setRawAddTime(washCouponDO.getRawAddTime());
        Assertions.assertTrue(null != washCouponDO.getRawUpdateTime());
		expect.setRawUpdateTime(washCouponDO.getRawUpdateTime());
		Assertions.assertEquals(expect, washCouponDO);
	}

    /**
	 * 插入wash_coupon表数据
	 */
	public void insertWashCoupon(WashCouponDO washCouponDO) {
		washCouponDAO.insert(washCouponDO);
	}

    /**
	 * 插入wash_coupon表数据
	 */
	public void insertWashCoupon(
			Long id, 
			String definitionId, 
			String partnerId, 
			String couponName, 
			String couponBizType, 
			String status, 
			String useTimeUnit, 
			String days, 
			Integer maxUse, 
			String timeSlots, 
			String couponUseRule, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		WashCouponDO washCouponDO = new WashCouponDO();
		washCouponDO.setId(id);
		washCouponDO.setDefinitionId(definitionId);
		washCouponDO.setPartnerId(partnerId);
		washCouponDO.setCouponName(couponName);
		washCouponDO.setCouponBizType(couponBizType);
		washCouponDO.setStatus(status);
		washCouponDO.setUseTimeUnit(useTimeUnit);
		washCouponDO.setDays(days);
		washCouponDO.setMaxUse(maxUse);
		washCouponDO.setTimeSlots(timeSlots);
		washCouponDO.setCouponUseRule(couponUseRule);
		washCouponDO.setRawAddTime(rawAddTime);
		washCouponDO.setRawUpdateTime(rawUpdateTime);
		washCouponDAO.insert(washCouponDO);
	}

    /**
     * 删除wash_coupon表所有数据
     */
    public void cleanWashCoupon() {
        WashCouponDOExample exam = new WashCouponDOExample();
        exam.createCriteria();
        washCouponDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除wash_coupon表数据
	 */
	public void cleanWashCouponById(Long id) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washCouponDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除wash_coupon表数据
	 */
	public void cleanWashCouponByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		washCouponDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除wash_coupon表数据
	 */
	public void cleanWashCouponByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washCouponDAO.deleteByExample(exam);
	}

	/**
	* 根据couponName删除wash_coupon表数据
	*/
	public void cleanWashCouponByCouponName(String couponName) {
        if (StringUtils.isBlank(couponName)){
            couponName = "test_couponName";
        }
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		washCouponDAO.deleteByExample(exam);
	}

    /**
     * 查询wash_coupon表所有数据
     */
    public List<WashCouponDO> findWashCouponAll() {
        WashCouponDOExample exam = new WashCouponDOExample();
        exam.createCriteria();
		return washCouponDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询wash_coupon表数据
	 */
	public List<WashCouponDO> findWashCouponById(Long id) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return washCouponDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询wash_coupon表数据
	 */
	public List<WashCouponDO> findWashCouponByDefinitionId(String definitionId) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return washCouponDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询wash_coupon表数据
	 */
	public List<WashCouponDO> findWashCouponByPartnerId(String partnerId) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return washCouponDAO.selectByExample(exam);
	}

	/**
	* 根据couponName查询wash_coupon表数据
	*/
	public List<WashCouponDO> findWashCouponByCouponName(String couponName) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		return washCouponDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新wash_coupon表数据
	 */
	public void updateWashCouponById(Long id,WashCouponDO washCouponDO) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washCouponDAO.updateByExample(washCouponDO, exam);
	}

    /**
	 * 根据definitionId更新wash_coupon表数据
	 */
	public void updateWashCouponByDefinitionId(String definitionId,WashCouponDO washCouponDO) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		washCouponDAO.updateByExample(washCouponDO, exam);
	}

    /**
	 * 根据partnerId更新wash_coupon表数据
	 */
	public void updateWashCouponByPartnerId(String partnerId,WashCouponDO washCouponDO) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washCouponDAO.updateByExample(washCouponDO, exam);
	}

	/**
	* 根据couponName更新wash_coupon表数据
	*/
	public void updateWashCouponByCouponName(String couponName,WashCouponDO washCouponDO) {
		WashCouponDOExample exam = new WashCouponDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		washCouponDAO.updateByExample(washCouponDO, exam);
	}

    /**
	 * 断言wash_luck_draw_campaign表
	 */
	public void washLuckDrawCampaignAssert(
	        WashLuckDrawCampaignDO washLuckDrawCampaignDO,
			Long id, 
			String name, 
			String campaignNo, 
			String partnerId, 
			String title, 
			String description, 
			String status, 
			String luckDrawType, 
			String lifeCycle, 
			String campaignUrl, 
			Date startTime, 
			Date endTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, washLuckDrawCampaignDO.getId());
        assertEquals(name, washLuckDrawCampaignDO.getName());
        assertEquals(campaignNo, washLuckDrawCampaignDO.getCampaignNo());
        assertEquals(partnerId, washLuckDrawCampaignDO.getPartnerId());
        assertEquals(title, washLuckDrawCampaignDO.getTitle());
        assertEquals(description, washLuckDrawCampaignDO.getDescription());
        assertEquals(status, washLuckDrawCampaignDO.getStatus());
        assertEquals(luckDrawType, washLuckDrawCampaignDO.getLuckDrawType());
        assertEquals(lifeCycle, washLuckDrawCampaignDO.getLifeCycle());
        assertEquals(campaignUrl, washLuckDrawCampaignDO.getCampaignUrl());
        assertEquals(startTime, washLuckDrawCampaignDO.getStartTime());
        assertEquals(endTime, washLuckDrawCampaignDO.getEndTime());
        assertEquals(rawAddTime, washLuckDrawCampaignDO.getRawAddTime());
        assertEquals(rawUpdateTime, washLuckDrawCampaignDO.getRawUpdateTime());
	}

	/**
	 * 断言wash_luck_draw_campaign表数据
	 */
	public void assertWashLuckDrawCampaign(WashLuckDrawCampaignDO expect, WashLuckDrawCampaignDO washLuckDrawCampaignDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			washLuckDrawCampaignDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != washLuckDrawCampaignDO.getRawAddTime());
		expect.setRawAddTime(washLuckDrawCampaignDO.getRawAddTime());
        Assertions.assertTrue(null != washLuckDrawCampaignDO.getRawUpdateTime());
		expect.setRawUpdateTime(washLuckDrawCampaignDO.getRawUpdateTime());
		Assertions.assertEquals(expect, washLuckDrawCampaignDO);
	}

    /**
	 * 插入wash_luck_draw_campaign表数据
	 */
	public void insertWashLuckDrawCampaign(WashLuckDrawCampaignDO washLuckDrawCampaignDO) {
		washLuckDrawCampaignDAO.insert(washLuckDrawCampaignDO);
	}

    /**
	 * 插入wash_luck_draw_campaign表数据
	 */
	public void insertWashLuckDrawCampaign(
			Long id, 
			String name, 
			String campaignNo, 
			String partnerId, 
			String title, 
			String description, 
			String status, 
			String luckDrawType, 
			String lifeCycle, 
			String campaignUrl, 
			Date startTime, 
			Date endTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		WashLuckDrawCampaignDO washLuckDrawCampaignDO = new WashLuckDrawCampaignDO();
		washLuckDrawCampaignDO.setId(id);
		washLuckDrawCampaignDO.setName(name);
		washLuckDrawCampaignDO.setCampaignNo(campaignNo);
		washLuckDrawCampaignDO.setPartnerId(partnerId);
		washLuckDrawCampaignDO.setTitle(title);
		washLuckDrawCampaignDO.setDescription(description);
		washLuckDrawCampaignDO.setStatus(status);
		washLuckDrawCampaignDO.setLuckDrawType(luckDrawType);
		washLuckDrawCampaignDO.setLifeCycle(lifeCycle);
		washLuckDrawCampaignDO.setCampaignUrl(campaignUrl);
		washLuckDrawCampaignDO.setStartTime(startTime);
		washLuckDrawCampaignDO.setEndTime(endTime);
		washLuckDrawCampaignDO.setRawAddTime(rawAddTime);
		washLuckDrawCampaignDO.setRawUpdateTime(rawUpdateTime);
		washLuckDrawCampaignDAO.insert(washLuckDrawCampaignDO);
	}

    /**
     * 删除wash_luck_draw_campaign表所有数据
     */
    public void cleanWashLuckDrawCampaign() {
        WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
        exam.createCriteria();
        washLuckDrawCampaignDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除wash_luck_draw_campaign表数据
	 */
	public void cleanWashLuckDrawCampaignById(Long id) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washLuckDrawCampaignDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除wash_luck_draw_campaign表数据
	*/
	public void cleanWashLuckDrawCampaignByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washLuckDrawCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除wash_luck_draw_campaign表数据
	 */
	public void cleanWashLuckDrawCampaignByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washLuckDrawCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除wash_luck_draw_campaign表数据
	 */
	public void cleanWashLuckDrawCampaignByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washLuckDrawCampaignDAO.deleteByExample(exam);
	}

    /**
     * 查询wash_luck_draw_campaign表所有数据
     */
    public List<WashLuckDrawCampaignDO> findWashLuckDrawCampaignAll() {
        WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
        exam.createCriteria();
		return washLuckDrawCampaignDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询wash_luck_draw_campaign表数据
	 */
	public List<WashLuckDrawCampaignDO> findWashLuckDrawCampaignById(Long id) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return washLuckDrawCampaignDAO.selectByExample(exam);
	}

	/**
	* 根据name查询wash_luck_draw_campaign表数据
	*/
	public List<WashLuckDrawCampaignDO> findWashLuckDrawCampaignByName(String name) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return washLuckDrawCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询wash_luck_draw_campaign表数据
	 */
	public List<WashLuckDrawCampaignDO> findWashLuckDrawCampaignByCampaignNo(String campaignNo) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return washLuckDrawCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询wash_luck_draw_campaign表数据
	 */
	public List<WashLuckDrawCampaignDO> findWashLuckDrawCampaignByPartnerId(String partnerId) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return washLuckDrawCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新wash_luck_draw_campaign表数据
	 */
	public void updateWashLuckDrawCampaignById(Long id,WashLuckDrawCampaignDO washLuckDrawCampaignDO) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washLuckDrawCampaignDAO.updateByExample(washLuckDrawCampaignDO, exam);
	}

	/**
	* 根据name更新wash_luck_draw_campaign表数据
	*/
	public void updateWashLuckDrawCampaignByName(String name,WashLuckDrawCampaignDO washLuckDrawCampaignDO) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washLuckDrawCampaignDAO.updateByExample(washLuckDrawCampaignDO, exam);
	}

    /**
	 * 根据campaignNo更新wash_luck_draw_campaign表数据
	 */
	public void updateWashLuckDrawCampaignByCampaignNo(String campaignNo,WashLuckDrawCampaignDO washLuckDrawCampaignDO) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washLuckDrawCampaignDAO.updateByExample(washLuckDrawCampaignDO, exam);
	}

    /**
	 * 根据partnerId更新wash_luck_draw_campaign表数据
	 */
	public void updateWashLuckDrawCampaignByPartnerId(String partnerId,WashLuckDrawCampaignDO washLuckDrawCampaignDO) {
		WashLuckDrawCampaignDOExample exam = new WashLuckDrawCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washLuckDrawCampaignDAO.updateByExample(washLuckDrawCampaignDO, exam);
	}

    /**
	 * 断言wash_precise_give表
	 */
	public void washPreciseGiveAssert(
	        WashPreciseGiveDO washPreciseGiveDO,
			Long id, 
			String campaignNo, 
			String partnerId, 
			String name, 
			String filterType, 
			String filterRule, 
			String userGroupNo, 
			String handleRules, 
			Date giveTime, 
			String status, 
			String memo, 
			String operator, 
			String ruleSetCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			Long personaId
	) {
        assertEquals(id, washPreciseGiveDO.getId());
        assertEquals(campaignNo, washPreciseGiveDO.getCampaignNo());
        assertEquals(partnerId, washPreciseGiveDO.getPartnerId());
        assertEquals(name, washPreciseGiveDO.getName());
        assertEquals(filterType, washPreciseGiveDO.getFilterType());
        assertEquals(filterRule, washPreciseGiveDO.getFilterRule());
        assertEquals(userGroupNo, washPreciseGiveDO.getUserGroupNo());
        assertEquals(handleRules, washPreciseGiveDO.getHandleRules());
        assertEquals(giveTime, washPreciseGiveDO.getGiveTime());
        assertEquals(status, washPreciseGiveDO.getStatus());
        assertEquals(memo, washPreciseGiveDO.getMemo());
        assertEquals(operator, washPreciseGiveDO.getOperator());
        assertEquals(ruleSetCode, washPreciseGiveDO.getRuleSetCode());
        assertEquals(rawAddTime, washPreciseGiveDO.getRawAddTime());
        assertEquals(rawUpdateTime, washPreciseGiveDO.getRawUpdateTime());
        assertEquals(personaId, washPreciseGiveDO.getPersonaId());
	}

	/**
	 * 断言wash_precise_give表数据
	 */
	public void assertWashPreciseGive(WashPreciseGiveDO expect, WashPreciseGiveDO washPreciseGiveDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			washPreciseGiveDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != washPreciseGiveDO.getRawAddTime());
		expect.setRawAddTime(washPreciseGiveDO.getRawAddTime());
        Assertions.assertTrue(null != washPreciseGiveDO.getRawUpdateTime());
		expect.setRawUpdateTime(washPreciseGiveDO.getRawUpdateTime());
		Assertions.assertEquals(expect, washPreciseGiveDO);
	}

    /**
	 * 插入wash_precise_give表数据
	 */
	public void insertWashPreciseGive(WashPreciseGiveDO washPreciseGiveDO) {
		washPreciseGiveDAO.insert(washPreciseGiveDO);
	}

    /**
	 * 插入wash_precise_give表数据
	 */
	public void insertWashPreciseGive(
			Long id, 
			String campaignNo, 
			String partnerId, 
			String name, 
			String filterType, 
			String filterRule, 
			String userGroupNo, 
			String handleRules, 
			Date giveTime, 
			String status, 
			String memo, 
			String operator, 
			String ruleSetCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			Long personaId
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		WashPreciseGiveDO washPreciseGiveDO = new WashPreciseGiveDO();
		washPreciseGiveDO.setId(id);
		washPreciseGiveDO.setCampaignNo(campaignNo);
		washPreciseGiveDO.setPartnerId(partnerId);
		washPreciseGiveDO.setName(name);
		washPreciseGiveDO.setFilterType(filterType);
		washPreciseGiveDO.setFilterRule(filterRule);
		washPreciseGiveDO.setUserGroupNo(userGroupNo);
		washPreciseGiveDO.setHandleRules(handleRules);
		washPreciseGiveDO.setGiveTime(giveTime);
		washPreciseGiveDO.setStatus(status);
		washPreciseGiveDO.setMemo(memo);
		washPreciseGiveDO.setOperator(operator);
		washPreciseGiveDO.setRuleSetCode(ruleSetCode);
		washPreciseGiveDO.setRawAddTime(rawAddTime);
		washPreciseGiveDO.setRawUpdateTime(rawUpdateTime);
		washPreciseGiveDO.setPersonaId(personaId);
		washPreciseGiveDAO.insert(washPreciseGiveDO);
	}

    /**
     * 删除wash_precise_give表所有数据
     */
    public void cleanWashPreciseGive() {
        WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
        exam.createCriteria();
        washPreciseGiveDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除wash_precise_give表数据
	 */
	public void cleanWashPreciseGiveById(Long id) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washPreciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除wash_precise_give表数据
	 */
	public void cleanWashPreciseGiveByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washPreciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除wash_precise_give表数据
	 */
	public void cleanWashPreciseGiveByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washPreciseGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除wash_precise_give表数据
	*/
	public void cleanWashPreciseGiveByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washPreciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据userGroupNo删除wash_precise_give表数据
	 */
	public void cleanWashPreciseGiveByUserGroupNo(String userGroupNo) {
        if (StringUtils.isBlank(userGroupNo)){
            userGroupNo = "test_userGroupNo";
        }
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		washPreciseGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleSetCode删除wash_precise_give表数据
	*/
	public void cleanWashPreciseGiveByRuleSetCode(String ruleSetCode) {
        if (StringUtils.isBlank(ruleSetCode)){
            ruleSetCode = "test_ruleSetCode";
        }
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		washPreciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据personaId删除wash_precise_give表数据
	 */
	public void cleanWashPreciseGiveByPersonaId(Long personaId) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		washPreciseGiveDAO.deleteByExample(exam);
	}

    /**
     * 查询wash_precise_give表所有数据
     */
    public List<WashPreciseGiveDO> findWashPreciseGiveAll() {
        WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
        exam.createCriteria();
		return washPreciseGiveDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询wash_precise_give表数据
	 */
	public List<WashPreciseGiveDO> findWashPreciseGiveById(Long id) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return washPreciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询wash_precise_give表数据
	 */
	public List<WashPreciseGiveDO> findWashPreciseGiveByCampaignNo(String campaignNo) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return washPreciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询wash_precise_give表数据
	 */
	public List<WashPreciseGiveDO> findWashPreciseGiveByPartnerId(String partnerId) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return washPreciseGiveDAO.selectByExample(exam);
	}

	/**
	* 根据name查询wash_precise_give表数据
	*/
	public List<WashPreciseGiveDO> findWashPreciseGiveByName(String name) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return washPreciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据userGroupNo查询wash_precise_give表数据
	 */
	public List<WashPreciseGiveDO> findWashPreciseGiveByUserGroupNo(String userGroupNo) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		return washPreciseGiveDAO.selectByExample(exam);
	}

	/**
	* 根据ruleSetCode查询wash_precise_give表数据
	*/
	public List<WashPreciseGiveDO> findWashPreciseGiveByRuleSetCode(String ruleSetCode) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		return washPreciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据personaId查询wash_precise_give表数据
	 */
	public List<WashPreciseGiveDO> findWashPreciseGiveByPersonaId(Long personaId) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		return washPreciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新wash_precise_give表数据
	 */
	public void updateWashPreciseGiveById(Long id,WashPreciseGiveDO washPreciseGiveDO) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washPreciseGiveDAO.updateByExample(washPreciseGiveDO, exam);
	}

    /**
	 * 根据campaignNo更新wash_precise_give表数据
	 */
	public void updateWashPreciseGiveByCampaignNo(String campaignNo,WashPreciseGiveDO washPreciseGiveDO) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washPreciseGiveDAO.updateByExample(washPreciseGiveDO, exam);
	}

    /**
	 * 根据partnerId更新wash_precise_give表数据
	 */
	public void updateWashPreciseGiveByPartnerId(String partnerId,WashPreciseGiveDO washPreciseGiveDO) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washPreciseGiveDAO.updateByExample(washPreciseGiveDO, exam);
	}

	/**
	* 根据name更新wash_precise_give表数据
	*/
	public void updateWashPreciseGiveByName(String name,WashPreciseGiveDO washPreciseGiveDO) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washPreciseGiveDAO.updateByExample(washPreciseGiveDO, exam);
	}

    /**
	 * 根据userGroupNo更新wash_precise_give表数据
	 */
	public void updateWashPreciseGiveByUserGroupNo(String userGroupNo,WashPreciseGiveDO washPreciseGiveDO) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		washPreciseGiveDAO.updateByExample(washPreciseGiveDO, exam);
	}

	/**
	* 根据ruleSetCode更新wash_precise_give表数据
	*/
	public void updateWashPreciseGiveByRuleSetCode(String ruleSetCode,WashPreciseGiveDO washPreciseGiveDO) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		washPreciseGiveDAO.updateByExample(washPreciseGiveDO, exam);
	}

    /**
	 * 根据personaId更新wash_precise_give表数据
	 */
	public void updateWashPreciseGiveByPersonaId(Long personaId,WashPreciseGiveDO washPreciseGiveDO) {
		WashPreciseGiveDOExample exam = new WashPreciseGiveDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		washPreciseGiveDAO.updateByExample(washPreciseGiveDO, exam);
	}

    /**
	 * 断言wash_recommend_gas_user表
	 */
	public void washRecommendGasUserAssert(
	        WashRecommendGasUserDO washRecommendGasUserDO,
			Long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String shortBirthday, 
			String nickName, 
			String realName, 
			String certNo, 
			String accountTag, 
			String headImgUrl, 
			String carNumber, 
			String carType, 
			String sex, 
			String memberType, 
			String grade, 
			String recommendSource, 
			String recommendId, 
			String recommendStationId, 
			String recommendStationName, 
			String recommendStationCode, 
			String recommendMobile, 
			String recommendName, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, washRecommendGasUserDO.getId());
        assertEquals(userId, washRecommendGasUserDO.getUserId());
        assertEquals(partnerId, washRecommendGasUserDO.getPartnerId());
        assertEquals(mobile, washRecommendGasUserDO.getMobile());
        assertEquals(birthday, washRecommendGasUserDO.getBirthday());
        assertEquals(shortBirthday, washRecommendGasUserDO.getShortBirthday());
        assertEquals(nickName, washRecommendGasUserDO.getNickName());
        assertEquals(realName, washRecommendGasUserDO.getRealName());
        assertEquals(certNo, washRecommendGasUserDO.getCertNo());
        assertEquals(accountTag, washRecommendGasUserDO.getAccountTag());
        assertEquals(headImgUrl, washRecommendGasUserDO.getHeadImgUrl());
        assertEquals(carNumber, washRecommendGasUserDO.getCarNumber());
        assertEquals(carType, washRecommendGasUserDO.getCarType());
        assertEquals(sex, washRecommendGasUserDO.getSex());
        assertEquals(memberType, washRecommendGasUserDO.getMemberType());
        assertEquals(grade, washRecommendGasUserDO.getGrade());
        assertEquals(recommendSource, washRecommendGasUserDO.getRecommendSource());
        assertEquals(recommendId, washRecommendGasUserDO.getRecommendId());
        assertEquals(recommendStationId, washRecommendGasUserDO.getRecommendStationId());
        assertEquals(recommendStationName, washRecommendGasUserDO.getRecommendStationName());
        assertEquals(recommendStationCode, washRecommendGasUserDO.getRecommendStationCode());
        assertEquals(recommendMobile, washRecommendGasUserDO.getRecommendMobile());
        assertEquals(recommendName, washRecommendGasUserDO.getRecommendName());
        assertEquals(createTime, washRecommendGasUserDO.getCreateTime());
        assertEquals(updateTime, washRecommendGasUserDO.getUpdateTime());
        assertEquals(rawAddTime, washRecommendGasUserDO.getRawAddTime());
        assertEquals(rawUpdateTime, washRecommendGasUserDO.getRawUpdateTime());
	}

	/**
	 * 断言wash_recommend_gas_user表数据
	 */
	public void assertWashRecommendGasUser(WashRecommendGasUserDO expect, WashRecommendGasUserDO washRecommendGasUserDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			washRecommendGasUserDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != washRecommendGasUserDO.getRawAddTime());
		expect.setRawAddTime(washRecommendGasUserDO.getRawAddTime());
        Assertions.assertTrue(null != washRecommendGasUserDO.getRawUpdateTime());
		expect.setRawUpdateTime(washRecommendGasUserDO.getRawUpdateTime());
		Assertions.assertEquals(expect, washRecommendGasUserDO);
	}

    /**
	 * 插入wash_recommend_gas_user表数据
	 */
	public void insertWashRecommendGasUser(WashRecommendGasUserDO washRecommendGasUserDO) {
		washRecommendGasUserDAO.insert(washRecommendGasUserDO);
	}

    /**
	 * 插入wash_recommend_gas_user表数据
	 */
	public void insertWashRecommendGasUser(
			Long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String shortBirthday, 
			String nickName, 
			String realName, 
			String certNo, 
			String accountTag, 
			String headImgUrl, 
			String carNumber, 
			String carType, 
			String sex, 
			String memberType, 
			String grade, 
			String recommendSource, 
			String recommendId, 
			String recommendStationId, 
			String recommendStationName, 
			String recommendStationCode, 
			String recommendMobile, 
			String recommendName, 
			Date createTime, 
			Date updateTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		WashRecommendGasUserDO washRecommendGasUserDO = new WashRecommendGasUserDO();
		washRecommendGasUserDO.setId(id);
		washRecommendGasUserDO.setUserId(userId);
		washRecommendGasUserDO.setPartnerId(partnerId);
		washRecommendGasUserDO.setMobile(mobile);
		washRecommendGasUserDO.setBirthday(birthday);
		washRecommendGasUserDO.setShortBirthday(shortBirthday);
		washRecommendGasUserDO.setNickName(nickName);
		washRecommendGasUserDO.setRealName(realName);
		washRecommendGasUserDO.setCertNo(certNo);
		washRecommendGasUserDO.setAccountTag(accountTag);
		washRecommendGasUserDO.setHeadImgUrl(headImgUrl);
		washRecommendGasUserDO.setCarNumber(carNumber);
		washRecommendGasUserDO.setCarType(carType);
		washRecommendGasUserDO.setSex(sex);
		washRecommendGasUserDO.setMemberType(memberType);
		washRecommendGasUserDO.setGrade(grade);
		washRecommendGasUserDO.setRecommendSource(recommendSource);
		washRecommendGasUserDO.setRecommendId(recommendId);
		washRecommendGasUserDO.setRecommendStationId(recommendStationId);
		washRecommendGasUserDO.setRecommendStationName(recommendStationName);
		washRecommendGasUserDO.setRecommendStationCode(recommendStationCode);
		washRecommendGasUserDO.setRecommendMobile(recommendMobile);
		washRecommendGasUserDO.setRecommendName(recommendName);
		washRecommendGasUserDO.setCreateTime(createTime);
		washRecommendGasUserDO.setUpdateTime(updateTime);
		washRecommendGasUserDO.setRawAddTime(rawAddTime);
		washRecommendGasUserDO.setRawUpdateTime(rawUpdateTime);
		washRecommendGasUserDAO.insert(washRecommendGasUserDO);
	}

    /**
     * 删除wash_recommend_gas_user表所有数据
     */
    public void cleanWashRecommendGasUser() {
        WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
        exam.createCriteria();
        washRecommendGasUserDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除wash_recommend_gas_user表数据
	 */
	public void cleanWashRecommendGasUserById(Long id) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除wash_recommend_gas_user表数据
	 */
	public void cleanWashRecommendGasUserByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除wash_recommend_gas_user表数据
	 */
	public void cleanWashRecommendGasUserByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除wash_recommend_gas_user表数据
	 */
	public void cleanWashRecommendGasUserByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据nickName删除wash_recommend_gas_user表数据
	*/
	public void cleanWashRecommendGasUserByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除wash_recommend_gas_user表数据
	*/
	public void cleanWashRecommendGasUserByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除wash_recommend_gas_user表数据
	 */
	public void cleanWashRecommendGasUserByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据carNumber删除wash_recommend_gas_user表数据
	*/
	public void cleanWashRecommendGasUserByCarNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)){
            carNumber = "test_carNumber";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据recommendId删除wash_recommend_gas_user表数据
	 */
	public void cleanWashRecommendGasUserByRecommendId(String recommendId) {
        if (StringUtils.isBlank(recommendId)){
            recommendId = "test_recommendId";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendIdEqualTo(recommendId);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据recommendStationId删除wash_recommend_gas_user表数据
	 */
	public void cleanWashRecommendGasUserByRecommendStationId(String recommendStationId) {
        if (StringUtils.isBlank(recommendStationId)){
            recommendStationId = "test_recommendStationId";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationIdEqualTo(recommendStationId);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据recommendStationName删除wash_recommend_gas_user表数据
	*/
	public void cleanWashRecommendGasUserByRecommendStationName(String recommendStationName) {
        if (StringUtils.isBlank(recommendStationName)){
            recommendStationName = "test_recommendStationName";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationNameEqualTo(recommendStationName);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据recommendStationCode删除wash_recommend_gas_user表数据
	*/
	public void cleanWashRecommendGasUserByRecommendStationCode(String recommendStationCode) {
        if (StringUtils.isBlank(recommendStationCode)){
            recommendStationCode = "test_recommendStationCode";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationCodeEqualTo(recommendStationCode);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

	/**
	* 根据recommendName删除wash_recommend_gas_user表数据
	*/
	public void cleanWashRecommendGasUserByRecommendName(String recommendName) {
        if (StringUtils.isBlank(recommendName)){
            recommendName = "test_recommendName";
        }
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendNameEqualTo(recommendName);
		washRecommendGasUserDAO.deleteByExample(exam);
	}

    /**
     * 查询wash_recommend_gas_user表所有数据
     */
    public List<WashRecommendGasUserDO> findWashRecommendGasUserAll() {
        WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
        exam.createCriteria();
		return washRecommendGasUserDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询wash_recommend_gas_user表数据
	 */
	public List<WashRecommendGasUserDO> findWashRecommendGasUserById(Long id) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询wash_recommend_gas_user表数据
	 */
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByUserId(String userId) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询wash_recommend_gas_user表数据
	 */
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByPartnerId(String partnerId) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询wash_recommend_gas_user表数据
	 */
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByMobile(String mobile) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

	/**
	* 根据nickName查询wash_recommend_gas_user表数据
	*/
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByNickName(String nickName) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询wash_recommend_gas_user表数据
	*/
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByRealName(String realName) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询wash_recommend_gas_user表数据
	 */
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByCertNo(String certNo) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

	/**
	* 根据carNumber查询wash_recommend_gas_user表数据
	*/
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByCarNumber(String carNumber) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据recommendId查询wash_recommend_gas_user表数据
	 */
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByRecommendId(String recommendId) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendIdEqualTo(recommendId);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据recommendStationId查询wash_recommend_gas_user表数据
	 */
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByRecommendStationId(String recommendStationId) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationIdEqualTo(recommendStationId);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

	/**
	* 根据recommendStationName查询wash_recommend_gas_user表数据
	*/
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByRecommendStationName(String recommendStationName) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationNameEqualTo(recommendStationName);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

	/**
	* 根据recommendStationCode查询wash_recommend_gas_user表数据
	*/
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByRecommendStationCode(String recommendStationCode) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationCodeEqualTo(recommendStationCode);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

	/**
	* 根据recommendName查询wash_recommend_gas_user表数据
	*/
	public List<WashRecommendGasUserDO> findWashRecommendGasUserByRecommendName(String recommendName) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendNameEqualTo(recommendName);
		return washRecommendGasUserDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新wash_recommend_gas_user表数据
	 */
	public void updateWashRecommendGasUserById(Long id,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

    /**
	 * 根据userId更新wash_recommend_gas_user表数据
	 */
	public void updateWashRecommendGasUserByUserId(String userId,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

    /**
	 * 根据partnerId更新wash_recommend_gas_user表数据
	 */
	public void updateWashRecommendGasUserByPartnerId(String partnerId,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

    /**
	 * 根据mobile更新wash_recommend_gas_user表数据
	 */
	public void updateWashRecommendGasUserByMobile(String mobile,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

	/**
	* 根据nickName更新wash_recommend_gas_user表数据
	*/
	public void updateWashRecommendGasUserByNickName(String nickName,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

	/**
	* 根据realName更新wash_recommend_gas_user表数据
	*/
	public void updateWashRecommendGasUserByRealName(String realName,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

    /**
	 * 根据certNo更新wash_recommend_gas_user表数据
	 */
	public void updateWashRecommendGasUserByCertNo(String certNo,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

    /**
	 * 根据recommendId更新wash_recommend_gas_user表数据
	 */
	public void updateWashRecommendGasUserByRecommendId(String recommendId,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendIdEqualTo(recommendId);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

    /**
	 * 根据recommendStationId更新wash_recommend_gas_user表数据
	 */
	public void updateWashRecommendGasUserByRecommendStationId(String recommendStationId,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationIdEqualTo(recommendStationId);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

	/**
	* 根据recommendStationName更新wash_recommend_gas_user表数据
	*/
	public void updateWashRecommendGasUserByRecommendStationName(String recommendStationName,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationNameEqualTo(recommendStationName);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

	/**
	* 根据recommendStationCode更新wash_recommend_gas_user表数据
	*/
	public void updateWashRecommendGasUserByRecommendStationCode(String recommendStationCode,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendStationCodeEqualTo(recommendStationCode);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

	/**
	* 根据recommendName更新wash_recommend_gas_user表数据
	*/
	public void updateWashRecommendGasUserByRecommendName(String recommendName,WashRecommendGasUserDO washRecommendGasUserDO) {
		WashRecommendGasUserDOExample exam = new WashRecommendGasUserDOExample();
		exam.createCriteria().andRecommendNameEqualTo(recommendName);
		washRecommendGasUserDAO.updateByExample(washRecommendGasUserDO, exam);
	}

    /**
	 * 断言wash_sales_campaign表
	 */
	public void washSalesCampaignAssert(
	        WashSalesCampaignDO washSalesCampaignDO,
			Long id, 
			String campaignNo, 
			String partnerId, 
			String name, 
			String description, 
			String memo, 
			String lifeCycle, 
			Date startTime, 
			Date endTime, 
			String useTimeUnit, 
			String days, 
			String timeSlot, 
			String status, 
			String eventRoutes, 
			Byte limitStation, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String campaignRules, 
			String partakeRule
	) {
        assertEquals(id, washSalesCampaignDO.getId());
        assertEquals(campaignNo, washSalesCampaignDO.getCampaignNo());
        assertEquals(partnerId, washSalesCampaignDO.getPartnerId());
        assertEquals(name, washSalesCampaignDO.getName());
        assertEquals(description, washSalesCampaignDO.getDescription());
        assertEquals(memo, washSalesCampaignDO.getMemo());
        assertEquals(lifeCycle, washSalesCampaignDO.getLifeCycle());
        assertEquals(startTime, washSalesCampaignDO.getStartTime());
        assertEquals(endTime, washSalesCampaignDO.getEndTime());
        assertEquals(useTimeUnit, washSalesCampaignDO.getUseTimeUnit());
        assertEquals(days, washSalesCampaignDO.getDays());
        assertEquals(timeSlot, washSalesCampaignDO.getTimeSlot());
        assertEquals(status, washSalesCampaignDO.getStatus());
        assertEquals(eventRoutes, washSalesCampaignDO.getEventRoutes());
        assertEquals(limitStation, washSalesCampaignDO.getLimitStation());
        assertEquals(context, washSalesCampaignDO.getContext());
        assertEquals(rawAddTime, washSalesCampaignDO.getRawAddTime());
        assertEquals(rawUpdateTime, washSalesCampaignDO.getRawUpdateTime());
        assertEquals(campaignRules, washSalesCampaignDO.getCampaignRules());
        assertEquals(partakeRule, washSalesCampaignDO.getPartakeRule());
	}

	/**
	 * 断言wash_sales_campaign表数据
	 */
	public void assertWashSalesCampaign(WashSalesCampaignDO expect, WashSalesCampaignDO washSalesCampaignDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			washSalesCampaignDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != washSalesCampaignDO.getRawAddTime());
		expect.setRawAddTime(washSalesCampaignDO.getRawAddTime());
        Assertions.assertTrue(null != washSalesCampaignDO.getRawUpdateTime());
		expect.setRawUpdateTime(washSalesCampaignDO.getRawUpdateTime());
		Assertions.assertEquals(expect, washSalesCampaignDO);
	}

    /**
	 * 插入wash_sales_campaign表数据
	 */
	public void insertWashSalesCampaign(WashSalesCampaignDO washSalesCampaignDO) {
		washSalesCampaignDAO.insert(washSalesCampaignDO);
	}

    /**
	 * 插入wash_sales_campaign表数据
	 */
	public void insertWashSalesCampaign(
			Long id, 
			String campaignNo, 
			String partnerId, 
			String name, 
			String description, 
			String memo, 
			String lifeCycle, 
			Date startTime, 
			Date endTime, 
			String useTimeUnit, 
			String days, 
			String timeSlot, 
			String status, 
			String eventRoutes, 
			Byte limitStation, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String campaignRules, 
			String partakeRule
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		WashSalesCampaignDO washSalesCampaignDO = new WashSalesCampaignDO();
		washSalesCampaignDO.setId(id);
		washSalesCampaignDO.setCampaignNo(campaignNo);
		washSalesCampaignDO.setPartnerId(partnerId);
		washSalesCampaignDO.setName(name);
		washSalesCampaignDO.setDescription(description);
		washSalesCampaignDO.setMemo(memo);
		washSalesCampaignDO.setLifeCycle(lifeCycle);
		washSalesCampaignDO.setStartTime(startTime);
		washSalesCampaignDO.setEndTime(endTime);
		washSalesCampaignDO.setUseTimeUnit(useTimeUnit);
		washSalesCampaignDO.setDays(days);
		washSalesCampaignDO.setTimeSlot(timeSlot);
		washSalesCampaignDO.setStatus(status);
		washSalesCampaignDO.setEventRoutes(eventRoutes);
		washSalesCampaignDO.setLimitStation(limitStation);
		washSalesCampaignDO.setContext(context);
		washSalesCampaignDO.setRawAddTime(rawAddTime);
		washSalesCampaignDO.setRawUpdateTime(rawUpdateTime);
		washSalesCampaignDO.setCampaignRules(campaignRules);
		washSalesCampaignDO.setPartakeRule(partakeRule);
		washSalesCampaignDAO.insert(washSalesCampaignDO);
	}

    /**
     * 删除wash_sales_campaign表所有数据
     */
    public void cleanWashSalesCampaign() {
        WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
        exam.createCriteria();
        washSalesCampaignDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除wash_sales_campaign表数据
	 */
	public void cleanWashSalesCampaignById(Long id) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washSalesCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除wash_sales_campaign表数据
	 */
	public void cleanWashSalesCampaignByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washSalesCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除wash_sales_campaign表数据
	 */
	public void cleanWashSalesCampaignByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washSalesCampaignDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除wash_sales_campaign表数据
	*/
	public void cleanWashSalesCampaignByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washSalesCampaignDAO.deleteByExample(exam);
	}

    /**
     * 查询wash_sales_campaign表所有数据
     */
    public List<WashSalesCampaignDO> findWashSalesCampaignAll() {
        WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
        exam.createCriteria();
		return washSalesCampaignDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询wash_sales_campaign表数据
	 */
	public List<WashSalesCampaignDO> findWashSalesCampaignById(Long id) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return washSalesCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询wash_sales_campaign表数据
	 */
	public List<WashSalesCampaignDO> findWashSalesCampaignByCampaignNo(String campaignNo) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return washSalesCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询wash_sales_campaign表数据
	 */
	public List<WashSalesCampaignDO> findWashSalesCampaignByPartnerId(String partnerId) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return washSalesCampaignDAO.selectByExample(exam);
	}

	/**
	* 根据name查询wash_sales_campaign表数据
	*/
	public List<WashSalesCampaignDO> findWashSalesCampaignByName(String name) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return washSalesCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新wash_sales_campaign表数据
	 */
	public void updateWashSalesCampaignById(Long id,WashSalesCampaignDO washSalesCampaignDO) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washSalesCampaignDAO.updateByExample(washSalesCampaignDO, exam);
	}

    /**
	 * 根据campaignNo更新wash_sales_campaign表数据
	 */
	public void updateWashSalesCampaignByCampaignNo(String campaignNo,WashSalesCampaignDO washSalesCampaignDO) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washSalesCampaignDAO.updateByExample(washSalesCampaignDO, exam);
	}

    /**
	 * 根据partnerId更新wash_sales_campaign表数据
	 */
	public void updateWashSalesCampaignByPartnerId(String partnerId,WashSalesCampaignDO washSalesCampaignDO) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washSalesCampaignDAO.updateByExample(washSalesCampaignDO, exam);
	}

	/**
	* 根据name更新wash_sales_campaign表数据
	*/
	public void updateWashSalesCampaignByName(String name,WashSalesCampaignDO washSalesCampaignDO) {
		WashSalesCampaignDOExample exam = new WashSalesCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washSalesCampaignDAO.updateByExample(washSalesCampaignDO, exam);
	}

    /**
	 * 断言wash_scan_take_campaign表
	 */
	public void washScanTakeCampaignAssert(
	        WashScanTakeCampaignDO washScanTakeCampaignDO,
			Long id, 
			String name, 
			String campaignNo, 
			String partnerId, 
			String status, 
			Integer oneTakeNum, 
			Integer stockNum, 
			String promotionWay, 
			String campaignUrl, 
			Date validStartTime, 
			Date validEndTime, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String giveDetail
	) {
        assertEquals(id, washScanTakeCampaignDO.getId());
        assertEquals(name, washScanTakeCampaignDO.getName());
        assertEquals(campaignNo, washScanTakeCampaignDO.getCampaignNo());
        assertEquals(partnerId, washScanTakeCampaignDO.getPartnerId());
        assertEquals(status, washScanTakeCampaignDO.getStatus());
        assertEquals(oneTakeNum, washScanTakeCampaignDO.getOneTakeNum());
        assertEquals(stockNum, washScanTakeCampaignDO.getStockNum());
        assertEquals(promotionWay, washScanTakeCampaignDO.getPromotionWay());
        assertEquals(campaignUrl, washScanTakeCampaignDO.getCampaignUrl());
        assertEquals(validStartTime, washScanTakeCampaignDO.getValidStartTime());
        assertEquals(validEndTime, washScanTakeCampaignDO.getValidEndTime());
        assertEquals(rawAddTime, washScanTakeCampaignDO.getRawAddTime());
        assertEquals(rawUpdateTime, washScanTakeCampaignDO.getRawUpdateTime());
        assertEquals(giveDetail, washScanTakeCampaignDO.getGiveDetail());
	}

	/**
	 * 断言wash_scan_take_campaign表数据
	 */
	public void assertWashScanTakeCampaign(WashScanTakeCampaignDO expect, WashScanTakeCampaignDO washScanTakeCampaignDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			washScanTakeCampaignDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != washScanTakeCampaignDO.getRawAddTime());
		expect.setRawAddTime(washScanTakeCampaignDO.getRawAddTime());
        Assertions.assertTrue(null != washScanTakeCampaignDO.getRawUpdateTime());
		expect.setRawUpdateTime(washScanTakeCampaignDO.getRawUpdateTime());
		Assertions.assertEquals(expect, washScanTakeCampaignDO);
	}

    /**
	 * 插入wash_scan_take_campaign表数据
	 */
	public void insertWashScanTakeCampaign(WashScanTakeCampaignDO washScanTakeCampaignDO) {
		washScanTakeCampaignDAO.insert(washScanTakeCampaignDO);
	}

    /**
	 * 插入wash_scan_take_campaign表数据
	 */
	public void insertWashScanTakeCampaign(
			Long id, 
			String name, 
			String campaignNo, 
			String partnerId, 
			String status, 
			Integer oneTakeNum, 
			Integer stockNum, 
			String promotionWay, 
			String campaignUrl, 
			Date validStartTime, 
			Date validEndTime, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String giveDetail
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		WashScanTakeCampaignDO washScanTakeCampaignDO = new WashScanTakeCampaignDO();
		washScanTakeCampaignDO.setId(id);
		washScanTakeCampaignDO.setName(name);
		washScanTakeCampaignDO.setCampaignNo(campaignNo);
		washScanTakeCampaignDO.setPartnerId(partnerId);
		washScanTakeCampaignDO.setStatus(status);
		washScanTakeCampaignDO.setOneTakeNum(oneTakeNum);
		washScanTakeCampaignDO.setStockNum(stockNum);
		washScanTakeCampaignDO.setPromotionWay(promotionWay);
		washScanTakeCampaignDO.setCampaignUrl(campaignUrl);
		washScanTakeCampaignDO.setValidStartTime(validStartTime);
		washScanTakeCampaignDO.setValidEndTime(validEndTime);
		washScanTakeCampaignDO.setRawAddTime(rawAddTime);
		washScanTakeCampaignDO.setRawUpdateTime(rawUpdateTime);
		washScanTakeCampaignDO.setGiveDetail(giveDetail);
		washScanTakeCampaignDAO.insert(washScanTakeCampaignDO);
	}

    /**
     * 删除wash_scan_take_campaign表所有数据
     */
    public void cleanWashScanTakeCampaign() {
        WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
        exam.createCriteria();
        washScanTakeCampaignDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除wash_scan_take_campaign表数据
	 */
	public void cleanWashScanTakeCampaignById(Long id) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washScanTakeCampaignDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除wash_scan_take_campaign表数据
	*/
	public void cleanWashScanTakeCampaignByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washScanTakeCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除wash_scan_take_campaign表数据
	 */
	public void cleanWashScanTakeCampaignByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washScanTakeCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除wash_scan_take_campaign表数据
	 */
	public void cleanWashScanTakeCampaignByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washScanTakeCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据validStartTime删除wash_scan_take_campaign表数据
	 */
	public void cleanWashScanTakeCampaignByValidStartTime(Date validStartTime) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andValidStartTimeEqualTo(validStartTime);
		washScanTakeCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据validEndTime删除wash_scan_take_campaign表数据
	 */
	public void cleanWashScanTakeCampaignByValidEndTime(Date validEndTime) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		washScanTakeCampaignDAO.deleteByExample(exam);
	}

    /**
     * 查询wash_scan_take_campaign表所有数据
     */
    public List<WashScanTakeCampaignDO> findWashScanTakeCampaignAll() {
        WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
        exam.createCriteria();
		return washScanTakeCampaignDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询wash_scan_take_campaign表数据
	 */
	public List<WashScanTakeCampaignDO> findWashScanTakeCampaignById(Long id) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return washScanTakeCampaignDAO.selectByExample(exam);
	}

	/**
	* 根据name查询wash_scan_take_campaign表数据
	*/
	public List<WashScanTakeCampaignDO> findWashScanTakeCampaignByName(String name) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return washScanTakeCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询wash_scan_take_campaign表数据
	 */
	public List<WashScanTakeCampaignDO> findWashScanTakeCampaignByCampaignNo(String campaignNo) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return washScanTakeCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询wash_scan_take_campaign表数据
	 */
	public List<WashScanTakeCampaignDO> findWashScanTakeCampaignByPartnerId(String partnerId) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return washScanTakeCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据validStartTime查询wash_scan_take_campaign表数据
	 */
	public List<WashScanTakeCampaignDO> findWashScanTakeCampaignByValidStartTime(Date validStartTime) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andValidStartTimeEqualTo(validStartTime);
		return washScanTakeCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据validEndTime查询wash_scan_take_campaign表数据
	 */
	public List<WashScanTakeCampaignDO> findWashScanTakeCampaignByValidEndTime(Date validEndTime) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		return washScanTakeCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新wash_scan_take_campaign表数据
	 */
	public void updateWashScanTakeCampaignById(Long id,WashScanTakeCampaignDO washScanTakeCampaignDO) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		washScanTakeCampaignDAO.updateByExample(washScanTakeCampaignDO, exam);
	}

	/**
	* 根据name更新wash_scan_take_campaign表数据
	*/
	public void updateWashScanTakeCampaignByName(String name,WashScanTakeCampaignDO washScanTakeCampaignDO) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		washScanTakeCampaignDAO.updateByExample(washScanTakeCampaignDO, exam);
	}

    /**
	 * 根据campaignNo更新wash_scan_take_campaign表数据
	 */
	public void updateWashScanTakeCampaignByCampaignNo(String campaignNo,WashScanTakeCampaignDO washScanTakeCampaignDO) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		washScanTakeCampaignDAO.updateByExample(washScanTakeCampaignDO, exam);
	}

    /**
	 * 根据partnerId更新wash_scan_take_campaign表数据
	 */
	public void updateWashScanTakeCampaignByPartnerId(String partnerId,WashScanTakeCampaignDO washScanTakeCampaignDO) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		washScanTakeCampaignDAO.updateByExample(washScanTakeCampaignDO, exam);
	}

    /**
	 * 根据validStartTime更新wash_scan_take_campaign表数据
	 */
	public void updateWashScanTakeCampaignByValidStartTime(Date validStartTime,WashScanTakeCampaignDO washScanTakeCampaignDO) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andValidStartTimeEqualTo(validStartTime);
		washScanTakeCampaignDAO.updateByExample(washScanTakeCampaignDO, exam);
	}

    /**
	 * 根据validEndTime更新wash_scan_take_campaign表数据
	 */
	public void updateWashScanTakeCampaignByValidEndTime(Date validEndTime,WashScanTakeCampaignDO washScanTakeCampaignDO) {
		WashScanTakeCampaignDOExample exam = new WashScanTakeCampaignDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		washScanTakeCampaignDAO.updateByExample(washScanTakeCampaignDO, exam);
	}
}
