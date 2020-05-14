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
import dal.dao.shellmerchant.*;
import dal.model.shellmerchant.*;
import com.xjy.autotest.config.ShellmerchantDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/05/30.
 */
@Service
@Import({
        ShellmerchantDataSourceConfig.class
})
public class ShellmerchantTestBase {

	@Autowired
	ActivityZoneConfigDAO activityZoneConfigDAO;

	@Autowired
	GasCityDAO gasCityDAO;

	@Autowired
	GasDevicePrintDAO gasDevicePrintDAO;

	@Autowired
	GasDeviceResourceDAO gasDeviceResourceDAO;

	@Autowired
	GasDictDataDAO gasDictDataDAO;

	@Autowired
	GasDictTypeDAO gasDictTypeDAO;

	@Autowired
	GasDistrictDAO gasDistrictDAO;

	@Autowired
	GasGoodsDAO gasGoodsDAO;

	@Autowired
	GasLoginLogDAO gasLoginLogDAO;

	@Autowired
	GasMallExchangeGoodsDAO gasMallExchangeGoodsDAO;

	@Autowired
	GasMallExchangeRecordDAO gasMallExchangeRecordDAO;

	@Autowired
	GasMerchantCardDAO gasMerchantCardDAO;

	@Autowired
	GasMerchantCardObjectDAO gasMerchantCardObjectDAO;

	@Autowired
	GasMerchantCardRuleDAO gasMerchantCardRuleDAO;

	@Autowired
	GasMerchantDAO gasMerchantDAO;

	@Autowired
	GasMerchantDeviceDAO gasMerchantDeviceDAO;

	@Autowired
	GasMerchantDeviceFunctionDAO gasMerchantDeviceFunctionDAO;

	@Autowired
	GasMerchantGoodsDAO gasMerchantGoodsDAO;

	@Autowired
	GasMerchantGoodsPricePlanDAO gasMerchantGoodsPricePlanDAO;

	@Autowired
	GasMerchantPaywayDAO gasMerchantPaywayDAO;

	@Autowired
	GasMerchantResourceDAO gasMerchantResourceDAO;

	@Autowired
	GasMerchantRoleDAO gasMerchantRoleDAO;

	@Autowired
	GasMerchantRoleResourceDAO gasMerchantRoleResourceDAO;

	@Autowired
	GasMerchantSourceDataDAO gasMerchantSourceDataDAO;

	@Autowired
	GasMerchantStationDAO gasMerchantStationDAO;

	@Autowired
	GasMerchantUserDAO gasMerchantUserDAO;

	@Autowired
	GasMerchantUserStationDAO gasMerchantUserStationDAO;

	@Autowired
	GasProvinceDAO gasProvinceDAO;

	@Autowired
	GasRoleDAO gasRoleDAO;

	@Autowired
	GasRuleDescriptionDAO gasRuleDescriptionDAO;

	@Autowired
	GasStationGoodsPricePlanDAO gasStationGoodsPricePlanDAO;

	@Autowired
	GasStationOilGunDAO gasStationOilGunDAO;

	@Autowired
	GasStationServiceTagDAO gasStationServiceTagDAO;

	@Autowired
	MerchantProtocolRuleDAO merchantProtocolRuleDAO;

	@Autowired
	NotifyTaskDAO notifyTaskDAO;

	public ActivityZoneConfigDAO getActivityZoneConfigDAO() {
		return this.activityZoneConfigDAO;
	}

	public GasCityDAO getGasCityDAO() {
		return this.gasCityDAO;
	}

	public GasDevicePrintDAO getGasDevicePrintDAO() {
		return this.gasDevicePrintDAO;
	}

	public GasDeviceResourceDAO getGasDeviceResourceDAO() {
		return this.gasDeviceResourceDAO;
	}

	public GasDictDataDAO getGasDictDataDAO() {
		return this.gasDictDataDAO;
	}

	public GasDictTypeDAO getGasDictTypeDAO() {
		return this.gasDictTypeDAO;
	}

	public GasDistrictDAO getGasDistrictDAO() {
		return this.gasDistrictDAO;
	}

	public GasGoodsDAO getGasGoodsDAO() {
		return this.gasGoodsDAO;
	}

	public GasLoginLogDAO getGasLoginLogDAO() {
		return this.gasLoginLogDAO;
	}

	public GasMallExchangeGoodsDAO getGasMallExchangeGoodsDAO() {
		return this.gasMallExchangeGoodsDAO;
	}

	public GasMallExchangeRecordDAO getGasMallExchangeRecordDAO() {
		return this.gasMallExchangeRecordDAO;
	}

	public GasMerchantCardDAO getGasMerchantCardDAO() {
		return this.gasMerchantCardDAO;
	}

	public GasMerchantCardObjectDAO getGasMerchantCardObjectDAO() {
		return this.gasMerchantCardObjectDAO;
	}

	public GasMerchantCardRuleDAO getGasMerchantCardRuleDAO() {
		return this.gasMerchantCardRuleDAO;
	}

	public GasMerchantDAO getGasMerchantDAO() {
		return this.gasMerchantDAO;
	}

	public GasMerchantDeviceDAO getGasMerchantDeviceDAO() {
		return this.gasMerchantDeviceDAO;
	}

	public GasMerchantDeviceFunctionDAO getGasMerchantDeviceFunctionDAO() {
		return this.gasMerchantDeviceFunctionDAO;
	}

	public GasMerchantGoodsDAO getGasMerchantGoodsDAO() {
		return this.gasMerchantGoodsDAO;
	}

	public GasMerchantGoodsPricePlanDAO getGasMerchantGoodsPricePlanDAO() {
		return this.gasMerchantGoodsPricePlanDAO;
	}

	public GasMerchantPaywayDAO getGasMerchantPaywayDAO() {
		return this.gasMerchantPaywayDAO;
	}

	public GasMerchantResourceDAO getGasMerchantResourceDAO() {
		return this.gasMerchantResourceDAO;
	}

	public GasMerchantRoleDAO getGasMerchantRoleDAO() {
		return this.gasMerchantRoleDAO;
	}

	public GasMerchantRoleResourceDAO getGasMerchantRoleResourceDAO() {
		return this.gasMerchantRoleResourceDAO;
	}

	public GasMerchantSourceDataDAO getGasMerchantSourceDataDAO() {
		return this.gasMerchantSourceDataDAO;
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

	public GasProvinceDAO getGasProvinceDAO() {
		return this.gasProvinceDAO;
	}

	public GasRoleDAO getGasRoleDAO() {
		return this.gasRoleDAO;
	}

	public GasRuleDescriptionDAO getGasRuleDescriptionDAO() {
		return this.gasRuleDescriptionDAO;
	}

	public GasStationGoodsPricePlanDAO getGasStationGoodsPricePlanDAO() {
		return this.gasStationGoodsPricePlanDAO;
	}

	public GasStationOilGunDAO getGasStationOilGunDAO() {
		return this.gasStationOilGunDAO;
	}

	public GasStationServiceTagDAO getGasStationServiceTagDAO() {
		return this.gasStationServiceTagDAO;
	}

	public MerchantProtocolRuleDAO getMerchantProtocolRuleDAO() {
		return this.merchantProtocolRuleDAO;
	}

	public NotifyTaskDAO getNotifyTaskDAO() {
		return this.notifyTaskDAO;
	}


	/**
	 * 断言activity_zone_config表数据
	 */
	public void assertActivityZoneConfig(ActivityZoneConfigDO expect, ActivityZoneConfigDO activityZoneConfigDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			activityZoneConfigDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != activityZoneConfigDO.getRawAddTime());
		expect.setRawAddTime(activityZoneConfigDO.getRawAddTime());
        Assertions.assertTrue(null != activityZoneConfigDO.getRawUpdateTime());
		expect.setRawUpdateTime(activityZoneConfigDO.getRawUpdateTime());
		Assertions.assertEquals(expect, activityZoneConfigDO);
	}

    /**
	 * 插入activity_zone_config表数据
	 */
	public void insertActivityZoneConfig(ActivityZoneConfigDO activityZoneConfigDO) {
		activityZoneConfigDAO.insert(activityZoneConfigDO);
	}

    /**
	 * 插入activity_zone_config表数据
	 */
	public void insertActivityZoneConfig(
			long id, 
			String activityZoneName, 
			String partnerId, 
			String memo, 
			String activityImgUrl, 
			String activityShowState, 
			String activityContentUrl, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ActivityZoneConfigDO activityZoneConfigDO = new ActivityZoneConfigDO();
		activityZoneConfigDO.setId(id);
		activityZoneConfigDO.setActivityZoneName(activityZoneName);
		activityZoneConfigDO.setPartnerId(partnerId);
		activityZoneConfigDO.setMemo(memo);
		activityZoneConfigDO.setActivityImgUrl(activityImgUrl);
		activityZoneConfigDO.setActivityShowState(activityShowState);
		activityZoneConfigDO.setActivityContentUrl(activityContentUrl);
		activityZoneConfigDO.setRawAddTime(rawAddTime);
		activityZoneConfigDO.setRawUpdateTime(rawUpdateTime);
		activityZoneConfigDAO.insert(activityZoneConfigDO);
	}

    /**
     * 删除activity_zone_config表所有数据
     */
    public void cleanActivityZoneConfig() {
        ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
        exam.createCriteria();
        activityZoneConfigDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除activity_zone_config表数据
	 */
	public void cleanActivityZoneConfigById(long id) {
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		activityZoneConfigDAO.deleteByExample(exam);
	}

	/**
	* 根据activityZoneName删除activity_zone_config表数据
	*/
	public void cleanActivityZoneConfigByActivityZoneName(String activityZoneName) {
        if (StringUtils.isBlank(activityZoneName)){
            activityZoneName = "test_activityZoneName";
        }
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andActivityZoneNameEqualTo(activityZoneName);
		activityZoneConfigDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除activity_zone_config表数据
	 */
	public void cleanActivityZoneConfigByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		activityZoneConfigDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询activity_zone_config表数据
	 */
	public List<ActivityZoneConfigDO> findActivityZoneConfigById(long id) {
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return activityZoneConfigDAO.selectByExample(exam);
	}

	/**
	* 根据activityZoneName查询activity_zone_config表数据
	*/
	public List<ActivityZoneConfigDO> findActivityZoneConfigByActivityZoneName(String activityZoneName) {
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andActivityZoneNameEqualTo(activityZoneName);
		return activityZoneConfigDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询activity_zone_config表数据
	 */
	public List<ActivityZoneConfigDO> findActivityZoneConfigByPartnerId(String partnerId) {
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return activityZoneConfigDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新activity_zone_config表数据
	 */
	public void updateActivityZoneConfigById(long id,ActivityZoneConfigDO activityZoneConfigDO) {
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		activityZoneConfigDAO.updateByExample(activityZoneConfigDO, exam);
	}

	/**
	* 根据activityZoneName更新activity_zone_config表数据
	*/
	public void updateActivityZoneConfigByActivityZoneName(String activityZoneName,ActivityZoneConfigDO activityZoneConfigDO) {
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andActivityZoneNameEqualTo(activityZoneName);
		activityZoneConfigDAO.updateByExample(activityZoneConfigDO, exam);
	}

    /**
	 * 根据partnerId更新activity_zone_config表数据
	 */
	public void updateActivityZoneConfigByPartnerId(String partnerId,ActivityZoneConfigDO activityZoneConfigDO) {
		ActivityZoneConfigDOExample exam = new ActivityZoneConfigDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		activityZoneConfigDAO.updateByExample(activityZoneConfigDO, exam);
	}

	/**
	 * 断言gas_city表数据
	 */
	public void assertGasCity(GasCityDO expect, GasCityDO gasCityDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasCityDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasCityDO);
	}

    /**
	 * 插入gas_city表数据
	 */
	public void insertGasCity(GasCityDO gasCityDO) {
		gasCityDAO.insert(gasCityDO);
	}

    /**
	 * 插入gas_city表数据
	 */
	public void insertGasCity(
			long id, 
			String cityName, 
			String cityChar, 
			long provinceId
	) {
		GasCityDO gasCityDO = new GasCityDO();
		gasCityDO.setId(id);
		gasCityDO.setCityName(cityName);
		gasCityDO.setCityChar(cityChar);
		gasCityDO.setProvinceId(provinceId);
		gasCityDAO.insert(gasCityDO);
	}

    /**
     * 删除gas_city表所有数据
     */
    public void cleanGasCity() {
        GasCityDOExample exam = new GasCityDOExample();
        exam.createCriteria();
        gasCityDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_city表数据
	 */
	public void cleanGasCityById(long id) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCityDAO.deleteByExample(exam);
	}

	/**
	* 根据cityName删除gas_city表数据
	*/
	public void cleanGasCityByCityName(String cityName) {
        if (StringUtils.isBlank(cityName)){
            cityName = "test_cityName";
        }
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		gasCityDAO.deleteByExample(exam);
	}

	/**
	 * 根据provinceId删除gas_city表数据
	 */
	public void cleanGasCityByProvinceId(long provinceId) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasCityDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_city表数据
	 */
	public List<GasCityDO> findGasCityById(long id) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasCityDAO.selectByExample(exam);
	}

	/**
	* 根据cityName查询gas_city表数据
	*/
	public List<GasCityDO> findGasCityByCityName(String cityName) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		return gasCityDAO.selectByExample(exam);
	}

    /**
	 * 根据provinceId查询gas_city表数据
	 */
	public List<GasCityDO> findGasCityByProvinceId(long provinceId) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		return gasCityDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_city表数据
	 */
	public void updateGasCityById(long id,GasCityDO gasCityDO) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCityDAO.updateByExample(gasCityDO, exam);
	}

	/**
	* 根据cityName更新gas_city表数据
	*/
	public void updateGasCityByCityName(String cityName,GasCityDO gasCityDO) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		gasCityDAO.updateByExample(gasCityDO, exam);
	}

    /**
	 * 根据provinceId更新gas_city表数据
	 */
	public void updateGasCityByProvinceId(long provinceId,GasCityDO gasCityDO) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasCityDAO.updateByExample(gasCityDO, exam);
	}

	/**
	 * 断言gas_device_print表数据
	 */
	public void assertGasDevicePrint(GasDevicePrintDO expect, GasDevicePrintDO gasDevicePrintDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDevicePrintDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDevicePrintDO.getRawAddTime());
		expect.setRawAddTime(gasDevicePrintDO.getRawAddTime());
        Assertions.assertTrue(null != gasDevicePrintDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDevicePrintDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDevicePrintDO);
	}

    /**
	 * 插入gas_device_print表数据
	 */
	public void insertGasDevicePrint(GasDevicePrintDO gasDevicePrintDO) {
		gasDevicePrintDAO.insert(gasDevicePrintDO);
	}

    /**
	 * 插入gas_device_print表数据
	 */
	public void insertGasDevicePrint(
			long id, 
			String printId, 
			String partnerId, 
			String stationId, 
			String deviceType, 
			String printType, 
			String printTitle, 
			Integer printSleep, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasDevicePrintDO gasDevicePrintDO = new GasDevicePrintDO();
		gasDevicePrintDO.setId(id);
		gasDevicePrintDO.setPrintId(printId);
		gasDevicePrintDO.setPartnerId(partnerId);
		gasDevicePrintDO.setStationId(stationId);
		gasDevicePrintDO.setDeviceType(deviceType);
		gasDevicePrintDO.setPrintType(printType);
		gasDevicePrintDO.setPrintTitle(printTitle);
		gasDevicePrintDO.setPrintSleep(printSleep);
		gasDevicePrintDO.setRawAddTime(rawAddTime);
		gasDevicePrintDO.setRawUpdateTime(rawUpdateTime);
		gasDevicePrintDAO.insert(gasDevicePrintDO);
	}

    /**
     * 删除gas_device_print表所有数据
     */
    public void cleanGasDevicePrint() {
        GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
        exam.createCriteria();
        gasDevicePrintDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintById(long id) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDevicePrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据printId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByPrintId(String printId) {
        if (StringUtils.isBlank(printId)){
            printId = "test_printId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPrintIdEqualTo(printId);
		gasDevicePrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasDevicePrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasDevicePrintDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintById(long id) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据printId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByPrintId(String printId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPrintIdEqualTo(printId);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByPartnerId(String partnerId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByStationId(String stationId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_device_print表数据
	 */
	public void updateGasDevicePrintById(long id,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 根据printId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByPrintId(String printId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPrintIdEqualTo(printId);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 根据partnerId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByPartnerId(String partnerId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 根据stationId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByStationId(String stationId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

	/**
	 * 断言gas_device_resource表数据
	 */
	public void assertGasDeviceResource(GasDeviceResourceDO expect, GasDeviceResourceDO gasDeviceResourceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDeviceResourceDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDeviceResourceDO.getRawAddTime());
		expect.setRawAddTime(gasDeviceResourceDO.getRawAddTime());
        Assertions.assertTrue(null != gasDeviceResourceDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDeviceResourceDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDeviceResourceDO);
	}

    /**
	 * 插入gas_device_resource表数据
	 */
	public void insertGasDeviceResource(GasDeviceResourceDO gasDeviceResourceDO) {
		gasDeviceResourceDAO.insert(gasDeviceResourceDO);
	}

    /**
	 * 插入gas_device_resource表数据
	 */
	public void insertGasDeviceResource(
			long id, 
			String deviceType, 
			long parentId, 
			String name, 
			String code, 
			String url, 
			String resourceType, 
			Integer orderNo, 
			String icon, 
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
		GasDeviceResourceDO gasDeviceResourceDO = new GasDeviceResourceDO();
		gasDeviceResourceDO.setId(id);
		gasDeviceResourceDO.setDeviceType(deviceType);
		gasDeviceResourceDO.setParentId(parentId);
		gasDeviceResourceDO.setName(name);
		gasDeviceResourceDO.setCode(code);
		gasDeviceResourceDO.setUrl(url);
		gasDeviceResourceDO.setResourceType(resourceType);
		gasDeviceResourceDO.setOrderNo(orderNo);
		gasDeviceResourceDO.setIcon(icon);
		gasDeviceResourceDO.setMemo(memo);
		gasDeviceResourceDO.setRawAddTime(rawAddTime);
		gasDeviceResourceDO.setRawUpdateTime(rawUpdateTime);
		gasDeviceResourceDAO.insert(gasDeviceResourceDO);
	}

    /**
     * 删除gas_device_resource表所有数据
     */
    public void cleanGasDeviceResource() {
        GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
        exam.createCriteria();
        gasDeviceResourceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_device_resource表数据
	 */
	public void cleanGasDeviceResourceById(long id) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentId删除gas_device_resource表数据
	 */
	public void cleanGasDeviceResourceByParentId(long parentId) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除gas_device_resource表数据
	*/
	public void cleanGasDeviceResourceByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除gas_device_resource表数据
	*/
	public void cleanGasDeviceResourceByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_device_resource表数据
	 */
	public void cleanGasDeviceResourceByOrderNo(Integer orderNo) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceById(long id) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据parentId查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceByParentId(long parentId) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

	/**
	* 根据name查询gas_device_resource表数据
	*/
	public List<GasDeviceResourceDO> findGasDeviceResourceByName(String name) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

	/**
	* 根据code查询gas_device_resource表数据
	*/
	public List<GasDeviceResourceDO> findGasDeviceResourceByCode(String code) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceByOrderNo(Integer orderNo) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_device_resource表数据
	 */
	public void updateGasDeviceResourceById(long id,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

    /**
	 * 根据parentId更新gas_device_resource表数据
	 */
	public void updateGasDeviceResourceByParentId(long parentId,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

	/**
	* 根据name更新gas_device_resource表数据
	*/
	public void updateGasDeviceResourceByName(String name,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

	/**
	* 根据code更新gas_device_resource表数据
	*/
	public void updateGasDeviceResourceByCode(String code,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

    /**
	 * 根据orderNo更新gas_device_resource表数据
	 */
	public void updateGasDeviceResourceByOrderNo(Integer orderNo,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

	/**
	 * 断言gas_dict_data表数据
	 */
	public void assertGasDictData(GasDictDataDO expect, GasDictDataDO gasDictDataDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDictDataDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDictDataDO.getRawAddTime());
		expect.setRawAddTime(gasDictDataDO.getRawAddTime());
        Assertions.assertTrue(null != gasDictDataDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDictDataDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDictDataDO);
	}

    /**
	 * 插入gas_dict_data表数据
	 */
	public void insertGasDictData(GasDictDataDO gasDictDataDO) {
		gasDictDataDAO.insert(gasDictDataDO);
	}

    /**
	 * 插入gas_dict_data表数据
	 */
	public void insertGasDictData(
			long id, 
			String typeCode, 
			String dataCode, 
			String dataName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasDictDataDO gasDictDataDO = new GasDictDataDO();
		gasDictDataDO.setId(id);
		gasDictDataDO.setTypeCode(typeCode);
		gasDictDataDO.setDataCode(dataCode);
		gasDictDataDO.setDataName(dataName);
		gasDictDataDO.setRawAddTime(rawAddTime);
		gasDictDataDO.setRawUpdateTime(rawUpdateTime);
		gasDictDataDAO.insert(gasDictDataDO);
	}

    /**
     * 删除gas_dict_data表所有数据
     */
    public void cleanGasDictData() {
        GasDictDataDOExample exam = new GasDictDataDOExample();
        exam.createCriteria();
        gasDictDataDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_dict_data表数据
	 */
	public void cleanGasDictDataById(long id) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictDataDAO.deleteByExample(exam);
	}

	/**
	* 根据typeCode删除gas_dict_data表数据
	*/
	public void cleanGasDictDataByTypeCode(String typeCode) {
        if (StringUtils.isBlank(typeCode)){
            typeCode = "test_typeCode";
        }
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictDataDAO.deleteByExample(exam);
	}

	/**
	* 根据dataCode删除gas_dict_data表数据
	*/
	public void cleanGasDictDataByDataCode(String dataCode) {
        if (StringUtils.isBlank(dataCode)){
            dataCode = "test_dataCode";
        }
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataCodeEqualTo(dataCode);
		gasDictDataDAO.deleteByExample(exam);
	}

	/**
	* 根据dataName删除gas_dict_data表数据
	*/
	public void cleanGasDictDataByDataName(String dataName) {
        if (StringUtils.isBlank(dataName)){
            dataName = "test_dataName";
        }
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataNameEqualTo(dataName);
		gasDictDataDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_dict_data表数据
	 */
	public List<GasDictDataDO> findGasDictDataById(long id) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDictDataDAO.selectByExample(exam);
	}

	/**
	* 根据typeCode查询gas_dict_data表数据
	*/
	public List<GasDictDataDO> findGasDictDataByTypeCode(String typeCode) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		return gasDictDataDAO.selectByExample(exam);
	}

	/**
	* 根据dataCode查询gas_dict_data表数据
	*/
	public List<GasDictDataDO> findGasDictDataByDataCode(String dataCode) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataCodeEqualTo(dataCode);
		return gasDictDataDAO.selectByExample(exam);
	}

	/**
	* 根据dataName查询gas_dict_data表数据
	*/
	public List<GasDictDataDO> findGasDictDataByDataName(String dataName) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataNameEqualTo(dataName);
		return gasDictDataDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_dict_data表数据
	 */
	public void updateGasDictDataById(long id,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

	/**
	* 根据typeCode更新gas_dict_data表数据
	*/
	public void updateGasDictDataByTypeCode(String typeCode,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

	/**
	* 根据dataCode更新gas_dict_data表数据
	*/
	public void updateGasDictDataByDataCode(String dataCode,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataCodeEqualTo(dataCode);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

	/**
	* 根据dataName更新gas_dict_data表数据
	*/
	public void updateGasDictDataByDataName(String dataName,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataNameEqualTo(dataName);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

	/**
	 * 断言gas_dict_type表数据
	 */
	public void assertGasDictType(GasDictTypeDO expect, GasDictTypeDO gasDictTypeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDictTypeDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDictTypeDO.getRawAddTime());
		expect.setRawAddTime(gasDictTypeDO.getRawAddTime());
        Assertions.assertTrue(null != gasDictTypeDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDictTypeDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDictTypeDO);
	}

    /**
	 * 插入gas_dict_type表数据
	 */
	public void insertGasDictType(GasDictTypeDO gasDictTypeDO) {
		gasDictTypeDAO.insert(gasDictTypeDO);
	}

    /**
	 * 插入gas_dict_type表数据
	 */
	public void insertGasDictType(
			long id, 
			String typeCode, 
			String typeName, 
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
		GasDictTypeDO gasDictTypeDO = new GasDictTypeDO();
		gasDictTypeDO.setId(id);
		gasDictTypeDO.setTypeCode(typeCode);
		gasDictTypeDO.setTypeName(typeName);
		gasDictTypeDO.setMemo(memo);
		gasDictTypeDO.setRawAddTime(rawAddTime);
		gasDictTypeDO.setRawUpdateTime(rawUpdateTime);
		gasDictTypeDAO.insert(gasDictTypeDO);
	}

    /**
     * 删除gas_dict_type表所有数据
     */
    public void cleanGasDictType() {
        GasDictTypeDOExample exam = new GasDictTypeDOExample();
        exam.createCriteria();
        gasDictTypeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_dict_type表数据
	 */
	public void cleanGasDictTypeById(long id) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictTypeDAO.deleteByExample(exam);
	}

	/**
	* 根据typeCode删除gas_dict_type表数据
	*/
	public void cleanGasDictTypeByTypeCode(String typeCode) {
        if (StringUtils.isBlank(typeCode)){
            typeCode = "test_typeCode";
        }
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictTypeDAO.deleteByExample(exam);
	}

	/**
	* 根据typeName删除gas_dict_type表数据
	*/
	public void cleanGasDictTypeByTypeName(String typeName) {
        if (StringUtils.isBlank(typeName)){
            typeName = "test_typeName";
        }
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeNameEqualTo(typeName);
		gasDictTypeDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_dict_type表数据
	 */
	public List<GasDictTypeDO> findGasDictTypeById(long id) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDictTypeDAO.selectByExample(exam);
	}

	/**
	* 根据typeCode查询gas_dict_type表数据
	*/
	public List<GasDictTypeDO> findGasDictTypeByTypeCode(String typeCode) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		return gasDictTypeDAO.selectByExample(exam);
	}

	/**
	* 根据typeName查询gas_dict_type表数据
	*/
	public List<GasDictTypeDO> findGasDictTypeByTypeName(String typeName) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeNameEqualTo(typeName);
		return gasDictTypeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_dict_type表数据
	 */
	public void updateGasDictTypeById(long id,GasDictTypeDO gasDictTypeDO) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictTypeDAO.updateByExample(gasDictTypeDO, exam);
	}

	/**
	* 根据typeCode更新gas_dict_type表数据
	*/
	public void updateGasDictTypeByTypeCode(String typeCode,GasDictTypeDO gasDictTypeDO) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictTypeDAO.updateByExample(gasDictTypeDO, exam);
	}

	/**
	* 根据typeName更新gas_dict_type表数据
	*/
	public void updateGasDictTypeByTypeName(String typeName,GasDictTypeDO gasDictTypeDO) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeNameEqualTo(typeName);
		gasDictTypeDAO.updateByExample(gasDictTypeDO, exam);
	}

	/**
	 * 断言gas_district表数据
	 */
	public void assertGasDistrict(GasDistrictDO expect, GasDistrictDO gasDistrictDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDistrictDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasDistrictDO);
	}

    /**
	 * 插入gas_district表数据
	 */
	public void insertGasDistrict(GasDistrictDO gasDistrictDO) {
		gasDistrictDAO.insert(gasDistrictDO);
	}

    /**
	 * 插入gas_district表数据
	 */
	public void insertGasDistrict(
			long id, 
			String districtName, 
			String districtChar, 
			long cityId
	) {
		GasDistrictDO gasDistrictDO = new GasDistrictDO();
		gasDistrictDO.setId(id);
		gasDistrictDO.setDistrictName(districtName);
		gasDistrictDO.setDistrictChar(districtChar);
		gasDistrictDO.setCityId(cityId);
		gasDistrictDAO.insert(gasDistrictDO);
	}

    /**
     * 删除gas_district表所有数据
     */
    public void cleanGasDistrict() {
        GasDistrictDOExample exam = new GasDistrictDOExample();
        exam.createCriteria();
        gasDistrictDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_district表数据
	 */
	public void cleanGasDistrictById(long id) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDistrictDAO.deleteByExample(exam);
	}

	/**
	* 根据districtName删除gas_district表数据
	*/
	public void cleanGasDistrictByDistrictName(String districtName) {
        if (StringUtils.isBlank(districtName)){
            districtName = "test_districtName";
        }
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		gasDistrictDAO.deleteByExample(exam);
	}

	/**
	 * 根据cityId删除gas_district表数据
	 */
	public void cleanGasDistrictByCityId(long cityId) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasDistrictDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_district表数据
	 */
	public List<GasDistrictDO> findGasDistrictById(long id) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDistrictDAO.selectByExample(exam);
	}

	/**
	* 根据districtName查询gas_district表数据
	*/
	public List<GasDistrictDO> findGasDistrictByDistrictName(String districtName) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		return gasDistrictDAO.selectByExample(exam);
	}

    /**
	 * 根据cityId查询gas_district表数据
	 */
	public List<GasDistrictDO> findGasDistrictByCityId(long cityId) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		return gasDistrictDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_district表数据
	 */
	public void updateGasDistrictById(long id,GasDistrictDO gasDistrictDO) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDistrictDAO.updateByExample(gasDistrictDO, exam);
	}

	/**
	* 根据districtName更新gas_district表数据
	*/
	public void updateGasDistrictByDistrictName(String districtName,GasDistrictDO gasDistrictDO) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		gasDistrictDAO.updateByExample(gasDistrictDO, exam);
	}

    /**
	 * 根据cityId更新gas_district表数据
	 */
	public void updateGasDistrictByCityId(long cityId,GasDistrictDO gasDistrictDO) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasDistrictDAO.updateByExample(gasDistrictDO, exam);
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
			long id, 
			String goodsType, 
			String goodsGroupType, 
			long groupId, 
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
	public void cleanGasGoodsById(long id) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupId删除gas_goods表数据
	 */
	public void cleanGasGoodsByGroupId(long groupId) {
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
	 * 根据id查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsById(long id) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据groupId查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsByGroupId(long groupId) {
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
	public void updateGasGoodsById(long id,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

    /**
	 * 根据groupId更新gas_goods表数据
	 */
	public void updateGasGoodsByGroupId(long groupId,GasGoodsDO gasGoodsDO) {
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
	 * 断言gas_login_log表数据
	 */
	public void assertGasLoginLog(GasLoginLogDO expect, GasLoginLogDO gasLoginLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasLoginLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasLoginLogDO.getRawAddTime());
		expect.setRawAddTime(gasLoginLogDO.getRawAddTime());
        Assertions.assertTrue(null != gasLoginLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasLoginLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasLoginLogDO);
	}

    /**
	 * 插入gas_login_log表数据
	 */
	public void insertGasLoginLog(GasLoginLogDO gasLoginLogDO) {
		gasLoginLogDAO.insert(gasLoginLogDO);
	}

    /**
	 * 插入gas_login_log表数据
	 */
	public void insertGasLoginLog(
			long id, 
			String deviceType, 
			String userId, 
			String account, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationName, 
			String userName, 
			String deviceCode, 
			Date loginTime, 
			Date logoutTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (loginTime == null) {
			loginTime = new Date();
		}
		if (logoutTime == null) {
			logoutTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasLoginLogDO gasLoginLogDO = new GasLoginLogDO();
		gasLoginLogDO.setId(id);
		gasLoginLogDO.setDeviceType(deviceType);
		gasLoginLogDO.setUserId(userId);
		gasLoginLogDO.setAccount(account);
		gasLoginLogDO.setPartnerId(partnerId);
		gasLoginLogDO.setPartnerName(partnerName);
		gasLoginLogDO.setStationId(stationId);
		gasLoginLogDO.setStationName(stationName);
		gasLoginLogDO.setUserName(userName);
		gasLoginLogDO.setDeviceCode(deviceCode);
		gasLoginLogDO.setLoginTime(loginTime);
		gasLoginLogDO.setLogoutTime(logoutTime);
		gasLoginLogDO.setRawAddTime(rawAddTime);
		gasLoginLogDO.setRawUpdateTime(rawUpdateTime);
		gasLoginLogDAO.insert(gasLoginLogDO);
	}

    /**
     * 删除gas_login_log表所有数据
     */
    public void cleanGasLoginLog() {
        GasLoginLogDOExample exam = new GasLoginLogDOExample();
        exam.createCriteria();
        gasLoginLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_login_log表数据
	 */
	public void cleanGasLoginLogById(long id) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasLoginLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogById(long id) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByUserId(String userId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByPartnerId(String partnerId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByPartnerName(String partnerName) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByStationId(String stationId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByStationName(String stationName) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByUserName(String userName) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByDeviceCode(String deviceCode) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_login_log表数据
	 */
	public void updateGasLoginLogById(long id,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 根据userId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByUserId(String userId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 根据partnerId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByPartnerId(String partnerId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据partnerName更新gas_login_log表数据
	*/
	public void updateGasLoginLogByPartnerName(String partnerName,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 根据stationId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByStationId(String stationId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据stationName更新gas_login_log表数据
	*/
	public void updateGasLoginLogByStationName(String stationName,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据userName更新gas_login_log表数据
	*/
	public void updateGasLoginLogByUserName(String userName,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据deviceCode更新gas_login_log表数据
	*/
	public void updateGasLoginLogByDeviceCode(String deviceCode,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	 * 断言gas_mall_exchange_goods表数据
	 */
	public void assertGasMallExchangeGoods(GasMallExchangeGoodsDO expect, GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMallExchangeGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMallExchangeGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasMallExchangeGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasMallExchangeGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMallExchangeGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMallExchangeGoodsDO);
	}

    /**
	 * 插入gas_mall_exchange_goods表数据
	 */
	public void insertGasMallExchangeGoods(GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		gasMallExchangeGoodsDAO.insert(gasMallExchangeGoodsDO);
	}

    /**
	 * 插入gas_mall_exchange_goods表数据
	 */
	public void insertGasMallExchangeGoods(
			long id, 
			String goodsId, 
			String partnerId, 
			String goodsType, 
			String goodsName, 
			String goodsDescription, 
			String goodsImg, 
			Date forSaleTime, 
			Date invalidTime, 
			Integer exchangePoint, 
			Integer storeNum, 
			Integer freezeStoreNum, 
			Integer oneExchangeTimes, 
			String gainStyle, 
			String gainStation, 
			Integer exchangedCount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (forSaleTime == null) {
			forSaleTime = new Date();
		}
		if (invalidTime == null) {
			invalidTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMallExchangeGoodsDO gasMallExchangeGoodsDO = new GasMallExchangeGoodsDO();
		gasMallExchangeGoodsDO.setId(id);
		gasMallExchangeGoodsDO.setGoodsId(goodsId);
		gasMallExchangeGoodsDO.setPartnerId(partnerId);
		gasMallExchangeGoodsDO.setGoodsType(goodsType);
		gasMallExchangeGoodsDO.setGoodsName(goodsName);
		gasMallExchangeGoodsDO.setGoodsDescription(goodsDescription);
		gasMallExchangeGoodsDO.setGoodsImg(goodsImg);
		gasMallExchangeGoodsDO.setForSaleTime(forSaleTime);
		gasMallExchangeGoodsDO.setInvalidTime(invalidTime);
		gasMallExchangeGoodsDO.setExchangePoint(exchangePoint);
		gasMallExchangeGoodsDO.setStoreNum(storeNum);
		gasMallExchangeGoodsDO.setFreezeStoreNum(freezeStoreNum);
		gasMallExchangeGoodsDO.setOneExchangeTimes(oneExchangeTimes);
		gasMallExchangeGoodsDO.setGainStyle(gainStyle);
		gasMallExchangeGoodsDO.setGainStation(gainStation);
		gasMallExchangeGoodsDO.setExchangedCount(exchangedCount);
		gasMallExchangeGoodsDO.setRawAddTime(rawAddTime);
		gasMallExchangeGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasMallExchangeGoodsDAO.insert(gasMallExchangeGoodsDO);
	}

    /**
     * 删除gas_mall_exchange_goods表所有数据
     */
    public void cleanGasMallExchangeGoods() {
        GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
        exam.createCriteria();
        gasMallExchangeGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsById(long id) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据goodsId删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByGoodsId(String goodsId) {
        if (StringUtils.isBlank(goodsId)){
            goodsId = "test_goodsId";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_mall_exchange_goods表数据
	*/
	public void cleanGasMallExchangeGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据invalidTime删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByInvalidTime(Date invalidTime) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andInvalidTimeEqualTo(invalidTime);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsById(long id) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据goodsId查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByGoodsId(String goodsId) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByPartnerId(String partnerId) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_mall_exchange_goods表数据
	*/
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByGoodsName(String goodsName) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据invalidTime查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByInvalidTime(Date invalidTime) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andInvalidTimeEqualTo(invalidTime);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsById(long id,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 根据goodsId更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByGoodsId(String goodsId,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 根据partnerId更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByPartnerId(String partnerId,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_mall_exchange_goods表数据
	*/
	public void updateGasMallExchangeGoodsByGoodsName(String goodsName,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 根据invalidTime更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByInvalidTime(Date invalidTime,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andInvalidTimeEqualTo(invalidTime);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

	/**
	 * 断言gas_mall_exchange_record表数据
	 */
	public void assertGasMallExchangeRecord(GasMallExchangeRecordDO expect, GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMallExchangeRecordDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMallExchangeRecordDO.getRawAddTime());
		expect.setRawAddTime(gasMallExchangeRecordDO.getRawAddTime());
        Assertions.assertTrue(null != gasMallExchangeRecordDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMallExchangeRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMallExchangeRecordDO);
	}

    /**
	 * 插入gas_mall_exchange_record表数据
	 */
	public void insertGasMallExchangeRecord(GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		gasMallExchangeRecordDAO.insert(gasMallExchangeRecordDO);
	}

    /**
	 * 插入gas_mall_exchange_record表数据
	 */
	public void insertGasMallExchangeRecord(
			long id, 
			String partnerId, 
			String userId, 
			String goodsId, 
			String goodsType, 
			String orderNo, 
			Integer exchangeCount, 
			String exchangeStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMallExchangeRecordDO gasMallExchangeRecordDO = new GasMallExchangeRecordDO();
		gasMallExchangeRecordDO.setId(id);
		gasMallExchangeRecordDO.setPartnerId(partnerId);
		gasMallExchangeRecordDO.setUserId(userId);
		gasMallExchangeRecordDO.setGoodsId(goodsId);
		gasMallExchangeRecordDO.setGoodsType(goodsType);
		gasMallExchangeRecordDO.setOrderNo(orderNo);
		gasMallExchangeRecordDO.setExchangeCount(exchangeCount);
		gasMallExchangeRecordDO.setExchangeStatus(exchangeStatus);
		gasMallExchangeRecordDO.setRawAddTime(rawAddTime);
		gasMallExchangeRecordDO.setRawUpdateTime(rawUpdateTime);
		gasMallExchangeRecordDAO.insert(gasMallExchangeRecordDO);
	}

    /**
     * 删除gas_mall_exchange_record表所有数据
     */
    public void cleanGasMallExchangeRecord() {
        GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
        exam.createCriteria();
        gasMallExchangeRecordDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordById(long id) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据goodsId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByGoodsId(String goodsId) {
        if (StringUtils.isBlank(goodsId)){
            goodsId = "test_goodsId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)){
            orderNo = "test_orderNo";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordById(long id) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByPartnerId(String partnerId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByUserId(String userId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据goodsId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByGoodsId(String goodsId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByOrderNo(String orderNo) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordById(long id,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据partnerId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByPartnerId(String partnerId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据userId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByUserId(String userId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据goodsId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByGoodsId(String goodsId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据orderNo更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByOrderNo(String orderNo,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

	/**
	 * 断言gas_merchant_card表数据
	 */
	public void assertGasMerchantCard(GasMerchantCardDO expect, GasMerchantCardDO gasMerchantCardDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantCardDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantCardDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantCardDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantCardDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantCardDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantCardDO);
	}

    /**
	 * 插入gas_merchant_card表数据
	 */
	public void insertGasMerchantCard(GasMerchantCardDO gasMerchantCardDO) {
		gasMerchantCardDAO.insert(gasMerchantCardDO);
	}

    /**
	 * 插入gas_merchant_card表数据
	 */
	public void insertGasMerchantCard(
			long id, 
			String partnerId, 
			String cardObjectId, 
			String cardType, 
			String tag, 
			String parentCardNo, 
			String cardNo, 
			String internalNo, 
			long cardRuleId, 
			String operatorAccount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantCardDO gasMerchantCardDO = new GasMerchantCardDO();
		gasMerchantCardDO.setId(id);
		gasMerchantCardDO.setPartnerId(partnerId);
		gasMerchantCardDO.setCardObjectId(cardObjectId);
		gasMerchantCardDO.setCardType(cardType);
		gasMerchantCardDO.setTag(tag);
		gasMerchantCardDO.setParentCardNo(parentCardNo);
		gasMerchantCardDO.setCardNo(cardNo);
		gasMerchantCardDO.setInternalNo(internalNo);
		gasMerchantCardDO.setCardRuleId(cardRuleId);
		gasMerchantCardDO.setOperatorAccount(operatorAccount);
		gasMerchantCardDO.setRawAddTime(rawAddTime);
		gasMerchantCardDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantCardDAO.insert(gasMerchantCardDO);
	}

    /**
     * 删除gas_merchant_card表所有数据
     */
    public void cleanGasMerchantCard() {
        GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
        exam.createCriteria();
        gasMerchantCardDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardById(long id) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardObjectId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardObjectId(String cardObjectId) {
        if (StringUtils.isBlank(cardObjectId)){
            cardObjectId = "test_cardObjectId";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardObjectIdEqualTo(cardObjectId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentCardNo删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByParentCardNo(String parentCardNo) {
        if (StringUtils.isBlank(parentCardNo)){
            parentCardNo = "test_parentCardNo";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andParentCardNoEqualTo(parentCardNo);
		gasMerchantCardDAO.deleteByExample(exam);
	}
	/**
	 * 根据cardNo,id删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardNoAndId(String cardNo,long id) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo).andIdEqualTo(id);
		gasMerchantCardDAO.deleteByExample(exam);
	}
	/**
	 * 根据cardNo,partnerId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardNoAndPartnerId(String cardNo,String partnerId) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo).andPartnerIdEqualTo(partnerId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据internalNo删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByInternalNo(String internalNo) {
        if (StringUtils.isBlank(internalNo)){
            internalNo = "test_internalNo";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardRuleId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardRuleId(long cardRuleId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardById(long id) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByPartnerId(String partnerId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据cardObjectId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardObjectId(String cardObjectId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardObjectIdEqualTo(cardObjectId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据parentCardNo查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByParentCardNo(String parentCardNo) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andParentCardNoEqualTo(parentCardNo);
		return gasMerchantCardDAO.selectByExample(exam);
	}

	/**
	 * 根据cardNo,id查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardNoAndId(String cardNo,long id) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo).andIdEqualTo(id);
		return gasMerchantCardDAO.selectByExample(exam);
	}

	/**
	 * 根据cardNo,partnerId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardNoAndPartnerId(String cardNo,String partnerId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo).andPartnerIdEqualTo(partnerId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardNo(String cardNo) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据internalNo查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByInternalNo(String internalNo) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据cardRuleId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardRuleId(long cardRuleId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardById(long id,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByPartnerId(String partnerId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据cardObjectId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardObjectId(String cardObjectId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardObjectIdEqualTo(cardObjectId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据parentCardNo更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByParentCardNo(String parentCardNo,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andParentCardNoEqualTo(parentCardNo);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

	/**
	 * 根据cardNo,id更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardNoAndId(String cardNo,long id,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo).andIdEqualTo(id);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

	/**
	 * 根据cardNo,partnerId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardNoAndPartnerId(String cardNo,String partnerId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo).andPartnerIdEqualTo(partnerId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据cardNo更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardNo(String cardNo,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据internalNo更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByInternalNo(String internalNo,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据cardRuleId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardRuleId(long cardRuleId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

	/**
	 * 断言gas_merchant_card_object表数据
	 */
	public void assertGasMerchantCardObject(GasMerchantCardObjectDO expect, GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantCardObjectDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantCardObjectDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantCardObjectDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantCardObjectDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantCardObjectDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantCardObjectDO);
	}

    /**
	 * 插入gas_merchant_card_object表数据
	 */
	public void insertGasMerchantCardObject(GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		gasMerchantCardObjectDAO.insert(gasMerchantCardObjectDO);
	}

    /**
	 * 插入gas_merchant_card_object表数据
	 */
	public void insertGasMerchantCardObject(
			long id, 
			String objectId, 
			String partnerId, 
			String cardType, 
			String tag, 
			String objectName, 
			String objectCompany, 
			String status, 
			Date validStart, 
			Date validEnd, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (validStart == null) {
			validStart = new Date();
		}
		if (validEnd == null) {
			validEnd = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantCardObjectDO gasMerchantCardObjectDO = new GasMerchantCardObjectDO();
		gasMerchantCardObjectDO.setId(id);
		gasMerchantCardObjectDO.setObjectId(objectId);
		gasMerchantCardObjectDO.setPartnerId(partnerId);
		gasMerchantCardObjectDO.setCardType(cardType);
		gasMerchantCardObjectDO.setTag(tag);
		gasMerchantCardObjectDO.setObjectName(objectName);
		gasMerchantCardObjectDO.setObjectCompany(objectCompany);
		gasMerchantCardObjectDO.setStatus(status);
		gasMerchantCardObjectDO.setValidStart(validStart);
		gasMerchantCardObjectDO.setValidEnd(validEnd);
		gasMerchantCardObjectDO.setMemo(memo);
		gasMerchantCardObjectDO.setRawAddTime(rawAddTime);
		gasMerchantCardObjectDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantCardObjectDAO.insert(gasMerchantCardObjectDO);
	}

    /**
     * 删除gas_merchant_card_object表所有数据
     */
    public void cleanGasMerchantCardObject() {
        GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
        exam.createCriteria();
        gasMerchantCardObjectDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectById(long id) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据objectId删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByObjectId(String objectId) {
        if (StringUtils.isBlank(objectId)){
            objectId = "test_objectId";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectIdEqualTo(objectId);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	* 根据objectName删除gas_merchant_card_object表数据
	*/
	public void cleanGasMerchantCardObjectByObjectName(String objectName) {
        if (StringUtils.isBlank(objectName)){
            objectName = "test_objectName";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectNameEqualTo(objectName);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据validStart删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByValidStart(Date validStart) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidStartEqualTo(validStart);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据validEnd删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByValidEnd(Date validEnd) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidEndEqualTo(validEnd);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectById(long id) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据objectId查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByObjectId(String objectId) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectIdEqualTo(objectId);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByPartnerId(String partnerId) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

	/**
	* 根据objectName查询gas_merchant_card_object表数据
	*/
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByObjectName(String objectName) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectNameEqualTo(objectName);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据validStart查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByValidStart(Date validStart) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidStartEqualTo(validStart);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据validEnd查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByValidEnd(Date validEnd) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidEndEqualTo(validEnd);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectById(long id,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据objectId更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByObjectId(String objectId,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectIdEqualTo(objectId);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByPartnerId(String partnerId,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

	/**
	* 根据objectName更新gas_merchant_card_object表数据
	*/
	public void updateGasMerchantCardObjectByObjectName(String objectName,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectNameEqualTo(objectName);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据validStart更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByValidStart(Date validStart,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidStartEqualTo(validStart);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据validEnd更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByValidEnd(Date validEnd,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidEndEqualTo(validEnd);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

	/**
	 * 断言gas_merchant_card_rule表数据
	 */
	public void assertGasMerchantCardRule(GasMerchantCardRuleDO expect, GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantCardRuleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantCardRuleDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantCardRuleDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantCardRuleDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantCardRuleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantCardRuleDO);
	}

    /**
	 * 插入gas_merchant_card_rule表数据
	 */
	public void insertGasMerchantCardRule(GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		gasMerchantCardRuleDAO.insert(gasMerchantCardRuleDO);
	}

    /**
	 * 插入gas_merchant_card_rule表数据
	 */
	public void insertGasMerchantCardRule(
			long id, 
			String partnerId, 
			Integer rangeStart, 
			Integer rangeEnd, 
			String excludeCardNo, 
			String excludeNumber, 
			String operatorAccount, 
			Integer validCount, 
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
		GasMerchantCardRuleDO gasMerchantCardRuleDO = new GasMerchantCardRuleDO();
		gasMerchantCardRuleDO.setId(id);
		gasMerchantCardRuleDO.setPartnerId(partnerId);
		gasMerchantCardRuleDO.setRangeStart(rangeStart);
		gasMerchantCardRuleDO.setRangeEnd(rangeEnd);
		gasMerchantCardRuleDO.setExcludeCardNo(excludeCardNo);
		gasMerchantCardRuleDO.setExcludeNumber(excludeNumber);
		gasMerchantCardRuleDO.setOperatorAccount(operatorAccount);
		gasMerchantCardRuleDO.setValidCount(validCount);
		gasMerchantCardRuleDO.setMemo(memo);
		gasMerchantCardRuleDO.setRawAddTime(rawAddTime);
		gasMerchantCardRuleDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantCardRuleDAO.insert(gasMerchantCardRuleDO);
	}

    /**
     * 删除gas_merchant_card_rule表所有数据
     */
    public void cleanGasMerchantCardRule() {
        GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
        exam.createCriteria();
        gasMerchantCardRuleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleById(long id) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据excludeCardNo删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByExcludeCardNo(String excludeCardNo) {
        if (StringUtils.isBlank(excludeCardNo)){
            excludeCardNo = "test_excludeCardNo";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeCardNoEqualTo(excludeCardNo);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	* 根据excludeNumber删除gas_merchant_card_rule表数据
	*/
	public void cleanGasMerchantCardRuleByExcludeNumber(String excludeNumber) {
        if (StringUtils.isBlank(excludeNumber)){
            excludeNumber = "test_excludeNumber";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeNumberEqualTo(excludeNumber);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据validCount删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByValidCount(Integer validCount) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andValidCountEqualTo(validCount);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleById(long id) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByPartnerId(String partnerId) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据excludeCardNo查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByExcludeCardNo(String excludeCardNo) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeCardNoEqualTo(excludeCardNo);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

	/**
	* 根据excludeNumber查询gas_merchant_card_rule表数据
	*/
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByExcludeNumber(String excludeNumber) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeNumberEqualTo(excludeNumber);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据validCount查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByValidCount(Integer validCount) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andValidCountEqualTo(validCount);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleById(long id,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByPartnerId(String partnerId,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 根据excludeCardNo更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByExcludeCardNo(String excludeCardNo,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeCardNoEqualTo(excludeCardNo);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 根据validCount更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByValidCount(Integer validCount,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andValidCountEqualTo(validCount);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
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
			long id, 
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
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (queryDepth == null) {
			queryDepth = new Date();
		}
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
	public void cleanGasMerchantById(long id) {
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
	 * 根据id查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantById(long id) {
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
	public void updateGasMerchantById(long id,GasMerchantDO gasMerchantDO) {
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
	 * 断言gas_merchant_device表数据
	 */
	public void assertGasMerchantDevice(GasMerchantDeviceDO expect, GasMerchantDeviceDO gasMerchantDeviceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantDeviceDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantDeviceDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantDeviceDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantDeviceDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantDeviceDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantDeviceDO);
	}

    /**
	 * 插入gas_merchant_device表数据
	 */
	public void insertGasMerchantDevice(GasMerchantDeviceDO gasMerchantDeviceDO) {
		gasMerchantDeviceDAO.insert(gasMerchantDeviceDO);
	}

    /**
	 * 插入gas_merchant_device表数据
	 */
	public void insertGasMerchantDevice(
			long id, 
			String partnerId, 
			String deviceType, 
			String deviceCode, 
			String loginStatus, 
			String loginUserId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantDeviceDO gasMerchantDeviceDO = new GasMerchantDeviceDO();
		gasMerchantDeviceDO.setId(id);
		gasMerchantDeviceDO.setPartnerId(partnerId);
		gasMerchantDeviceDO.setDeviceType(deviceType);
		gasMerchantDeviceDO.setDeviceCode(deviceCode);
		gasMerchantDeviceDO.setLoginStatus(loginStatus);
		gasMerchantDeviceDO.setLoginUserId(loginUserId);
		gasMerchantDeviceDO.setRawAddTime(rawAddTime);
		gasMerchantDeviceDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantDeviceDAO.insert(gasMerchantDeviceDO);
	}

    /**
     * 删除gas_merchant_device表所有数据
     */
    public void cleanGasMerchantDevice() {
        GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
        exam.createCriteria();
        gasMerchantDeviceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceById(long id) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_merchant_device表数据
	*/
	public void cleanGasMerchantDeviceByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

	/**
	 * 根据loginUserId删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceByLoginUserId(String loginUserId) {
        if (StringUtils.isBlank(loginUserId)){
            loginUserId = "test_loginUserId";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andLoginUserIdEqualTo(loginUserId);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceById(long id) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByPartnerId(String partnerId) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_merchant_device表数据
	*/
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByDeviceCode(String deviceCode) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

    /**
	 * 根据loginUserId查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByLoginUserId(String loginUserId) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andLoginUserIdEqualTo(loginUserId);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceById(long id,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceByPartnerId(String partnerId,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

	/**
	* 根据deviceCode更新gas_merchant_device表数据
	*/
	public void updateGasMerchantDeviceByDeviceCode(String deviceCode,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

    /**
	 * 根据loginUserId更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceByLoginUserId(String loginUserId,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andLoginUserIdEqualTo(loginUserId);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

	/**
	 * 断言gas_merchant_device_function表数据
	 */
	public void assertGasMerchantDeviceFunction(GasMerchantDeviceFunctionDO expect, GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantDeviceFunctionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantDeviceFunctionDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantDeviceFunctionDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantDeviceFunctionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantDeviceFunctionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantDeviceFunctionDO);
	}

    /**
	 * 插入gas_merchant_device_function表数据
	 */
	public void insertGasMerchantDeviceFunction(GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		gasMerchantDeviceFunctionDAO.insert(gasMerchantDeviceFunctionDO);
	}

    /**
	 * 插入gas_merchant_device_function表数据
	 */
	public void insertGasMerchantDeviceFunction(
			long id, 
			String partnerId, 
			String stationId, 
			String funcType, 
			Byte open, 
			String deviceType, 
			String deviceCode, 
			String userId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO = new GasMerchantDeviceFunctionDO();
		gasMerchantDeviceFunctionDO.setId(id);
		gasMerchantDeviceFunctionDO.setPartnerId(partnerId);
		gasMerchantDeviceFunctionDO.setStationId(stationId);
		gasMerchantDeviceFunctionDO.setFuncType(funcType);
		gasMerchantDeviceFunctionDO.setOpen(open);
		gasMerchantDeviceFunctionDO.setDeviceType(deviceType);
		gasMerchantDeviceFunctionDO.setDeviceCode(deviceCode);
		gasMerchantDeviceFunctionDO.setUserId(userId);
		gasMerchantDeviceFunctionDO.setRawAddTime(rawAddTime);
		gasMerchantDeviceFunctionDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantDeviceFunctionDAO.insert(gasMerchantDeviceFunctionDO);
	}

    /**
     * 删除gas_merchant_device_function表所有数据
     */
    public void cleanGasMerchantDeviceFunction() {
        GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
        exam.createCriteria();
        gasMerchantDeviceFunctionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionById(long id) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_merchant_device_function表数据
	*/
	public void cleanGasMerchantDeviceFunctionByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionById(long id) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByPartnerId(String partnerId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByStationId(String stationId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_merchant_device_function表数据
	*/
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByDeviceCode(String deviceCode) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByUserId(String userId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionById(long id,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByPartnerId(String partnerId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 根据stationId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByStationId(String stationId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

	/**
	* 根据deviceCode更新gas_merchant_device_function表数据
	*/
	public void updateGasMerchantDeviceFunctionByDeviceCode(String deviceCode,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByUserId(String userId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
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
			long id, 
			String partnerId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			long groupId, 
			Integer orderNo, 
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
		GasMerchantGoodsDO gasMerchantGoodsDO = new GasMerchantGoodsDO();
		gasMerchantGoodsDO.setId(id);
		gasMerchantGoodsDO.setPartnerId(partnerId);
		gasMerchantGoodsDO.setGoodsName(goodsName);
		gasMerchantGoodsDO.setGoodsCode(goodsCode);
		gasMerchantGoodsDO.setGoodsType(goodsType);
		gasMerchantGoodsDO.setGroupId(groupId);
		gasMerchantGoodsDO.setOrderNo(orderNo);
		gasMerchantGoodsDO.setStatus(status);
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
	public void cleanGasMerchantGoodsById(long id) {
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
	public void cleanGasMerchantGoodsByGroupId(long groupId) {
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
	 * 根据id查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsById(long id) {
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
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByGroupId(long groupId) {
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
	public void updateGasMerchantGoodsById(long id,GasMerchantGoodsDO gasMerchantGoodsDO) {
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
	public void updateGasMerchantGoodsByGroupId(long groupId,GasMerchantGoodsDO gasMerchantGoodsDO) {
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
	 * 断言gas_merchant_goods_price_plan表数据
	 */
	public void assertGasMerchantGoodsPricePlan(GasMerchantGoodsPricePlanDO expect, GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantGoodsPricePlanDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantGoodsPricePlanDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantGoodsPricePlanDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantGoodsPricePlanDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantGoodsPricePlanDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantGoodsPricePlanDO);
	}

    /**
	 * 插入gas_merchant_goods_price_plan表数据
	 */
	public void insertGasMerchantGoodsPricePlan(GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		gasMerchantGoodsPricePlanDAO.insert(gasMerchantGoodsPricePlanDO);
	}

    /**
	 * 插入gas_merchant_goods_price_plan表数据
	 */
	public void insertGasMerchantGoodsPricePlan(
			long id, 
			String planId, 
			String priceName, 
			String partnerId, 
			Date effectTime, 
			String deleteFlag, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
		if (effectTime == null) {
			effectTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO = new GasMerchantGoodsPricePlanDO();
		gasMerchantGoodsPricePlanDO.setId(id);
		gasMerchantGoodsPricePlanDO.setPlanId(planId);
		gasMerchantGoodsPricePlanDO.setPriceName(priceName);
		gasMerchantGoodsPricePlanDO.setPartnerId(partnerId);
		gasMerchantGoodsPricePlanDO.setEffectTime(effectTime);
		gasMerchantGoodsPricePlanDO.setDeleteFlag(deleteFlag);
		gasMerchantGoodsPricePlanDO.setRawAddTime(rawAddTime);
		gasMerchantGoodsPricePlanDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantGoodsPricePlanDO.setGoodsInfo(goodsInfo);
		gasMerchantGoodsPricePlanDAO.insert(gasMerchantGoodsPricePlanDO);
	}

    /**
     * 删除gas_merchant_goods_price_plan表所有数据
     */
    public void cleanGasMerchantGoodsPricePlan() {
        GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
        exam.createCriteria();
        gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanById(long id) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据planId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByPlanId(String planId) {
        if (StringUtils.isBlank(planId)){
            planId = "test_planId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据priceName删除gas_merchant_goods_price_plan表数据
	*/
	public void cleanGasMerchantGoodsPricePlanByPriceName(String priceName) {
        if (StringUtils.isBlank(priceName)){
            priceName = "test_priceName";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanById(long id) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据planId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPlanId(String planId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据priceName查询gas_merchant_goods_price_plan表数据
	*/
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPriceName(String priceName) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPartnerId(String partnerId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanById(long id,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 根据planId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByPlanId(String planId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

	/**
	* 根据priceName更新gas_merchant_goods_price_plan表数据
	*/
	public void updateGasMerchantGoodsPricePlanByPriceName(String priceName,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByPartnerId(String partnerId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

	/**
	 * 断言gas_merchant_payway表数据
	 */
	public void assertGasMerchantPayway(GasMerchantPaywayDO expect, GasMerchantPaywayDO gasMerchantPaywayDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantPaywayDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantPaywayDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantPaywayDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantPaywayDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantPaywayDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantPaywayDO);
	}

    /**
	 * 插入gas_merchant_payway表数据
	 */
	public void insertGasMerchantPayway(GasMerchantPaywayDO gasMerchantPaywayDO) {
		gasMerchantPaywayDAO.insert(gasMerchantPaywayDO);
	}

    /**
	 * 插入gas_merchant_payway表数据
	 */
	public void insertGasMerchantPayway(
			long id, 
			String partnerId, 
			String paywayCode, 
			String paywayName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantPaywayDO gasMerchantPaywayDO = new GasMerchantPaywayDO();
		gasMerchantPaywayDO.setId(id);
		gasMerchantPaywayDO.setPartnerId(partnerId);
		gasMerchantPaywayDO.setPaywayCode(paywayCode);
		gasMerchantPaywayDO.setPaywayName(paywayName);
		gasMerchantPaywayDO.setRawAddTime(rawAddTime);
		gasMerchantPaywayDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantPaywayDAO.insert(gasMerchantPaywayDO);
	}

    /**
     * 删除gas_merchant_payway表所有数据
     */
    public void cleanGasMerchantPayway() {
        GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
        exam.createCriteria();
        gasMerchantPaywayDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_payway表数据
	 */
	public void cleanGasMerchantPaywayById(long id) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_payway表数据
	 */
	public void cleanGasMerchantPaywayByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	* 根据paywayCode删除gas_merchant_payway表数据
	*/
	public void cleanGasMerchantPaywayByPaywayCode(String paywayCode) {
        if (StringUtils.isBlank(paywayCode)){
            paywayCode = "test_paywayCode";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	* 根据paywayName删除gas_merchant_payway表数据
	*/
	public void cleanGasMerchantPaywayByPaywayName(String paywayName) {
        if (StringUtils.isBlank(paywayName)){
            paywayName = "test_paywayName";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayById(long id) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPartnerId(String partnerId) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

	/**
	* 根据paywayCode查询gas_merchant_payway表数据
	*/
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPaywayCode(String paywayCode) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

	/**
	* 根据paywayName查询gas_merchant_payway表数据
	*/
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPaywayName(String paywayName) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayById(long id,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayByPartnerId(String partnerId,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

	/**
	* 根据paywayCode更新gas_merchant_payway表数据
	*/
	public void updateGasMerchantPaywayByPaywayCode(String paywayCode,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

	/**
	* 根据paywayName更新gas_merchant_payway表数据
	*/
	public void updateGasMerchantPaywayByPaywayName(String paywayName,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

	/**
	 * 断言gas_merchant_resource表数据
	 */
	public void assertGasMerchantResource(GasMerchantResourceDO expect, GasMerchantResourceDO gasMerchantResourceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantResourceDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasMerchantResourceDO);
	}

    /**
	 * 插入gas_merchant_resource表数据
	 */
	public void insertGasMerchantResource(GasMerchantResourceDO gasMerchantResourceDO) {
		gasMerchantResourceDAO.insert(gasMerchantResourceDO);
	}

    /**
	 * 插入gas_merchant_resource表数据
	 */
	public void insertGasMerchantResource(
			long id, 
			String partnerId, 
			long resourceId
	) {
		GasMerchantResourceDO gasMerchantResourceDO = new GasMerchantResourceDO();
		gasMerchantResourceDO.setId(id);
		gasMerchantResourceDO.setPartnerId(partnerId);
		gasMerchantResourceDO.setResourceId(resourceId);
		gasMerchantResourceDAO.insert(gasMerchantResourceDO);
	}

    /**
     * 删除gas_merchant_resource表所有数据
     */
    public void cleanGasMerchantResource() {
        GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
        exam.createCriteria();
        gasMerchantResourceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceById(long id) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据resourceId删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceByResourceId(long resourceId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceById(long id) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceByPartnerId(String partnerId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据resourceId查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceByResourceId(long resourceId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceById(long id,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceByPartnerId(String partnerId,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 根据resourceId更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceByResourceId(long resourceId,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

	/**
	 * 断言gas_merchant_role表数据
	 */
	public void assertGasMerchantRole(GasMerchantRoleDO expect, GasMerchantRoleDO gasMerchantRoleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantRoleDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasMerchantRoleDO);
	}

    /**
	 * 插入gas_merchant_role表数据
	 */
	public void insertGasMerchantRole(GasMerchantRoleDO gasMerchantRoleDO) {
		gasMerchantRoleDAO.insert(gasMerchantRoleDO);
	}

    /**
	 * 插入gas_merchant_role表数据
	 */
	public void insertGasMerchantRole(
			long id, 
			String partnerId, 
			long roleId
	) {
		GasMerchantRoleDO gasMerchantRoleDO = new GasMerchantRoleDO();
		gasMerchantRoleDO.setId(id);
		gasMerchantRoleDO.setPartnerId(partnerId);
		gasMerchantRoleDO.setRoleId(roleId);
		gasMerchantRoleDAO.insert(gasMerchantRoleDO);
	}

    /**
     * 删除gas_merchant_role表所有数据
     */
    public void cleanGasMerchantRole() {
        GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
        exam.createCriteria();
        gasMerchantRoleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleById(long id) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleByRoleId(long roleId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleById(long id) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleByPartnerId(String partnerId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleByRoleId(long roleId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleById(long id,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleByPartnerId(String partnerId,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleByRoleId(long roleId,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

	/**
	 * 断言gas_merchant_role_resource表数据
	 */
	public void assertGasMerchantRoleResource(GasMerchantRoleResourceDO expect, GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantRoleResourceDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasMerchantRoleResourceDO);
	}

    /**
	 * 插入gas_merchant_role_resource表数据
	 */
	public void insertGasMerchantRoleResource(GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		gasMerchantRoleResourceDAO.insert(gasMerchantRoleResourceDO);
	}

    /**
	 * 插入gas_merchant_role_resource表数据
	 */
	public void insertGasMerchantRoleResource(
			long id, 
			long roleId, 
			long resourceId
	) {
		GasMerchantRoleResourceDO gasMerchantRoleResourceDO = new GasMerchantRoleResourceDO();
		gasMerchantRoleResourceDO.setId(id);
		gasMerchantRoleResourceDO.setRoleId(roleId);
		gasMerchantRoleResourceDO.setResourceId(resourceId);
		gasMerchantRoleResourceDAO.insert(gasMerchantRoleResourceDO);
	}

    /**
     * 删除gas_merchant_role_resource表所有数据
     */
    public void cleanGasMerchantRoleResource() {
        GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
        exam.createCriteria();
        gasMerchantRoleResourceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceById(long id) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceByRoleId(long roleId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据resourceId删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceByResourceId(long resourceId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceById(long id) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceByRoleId(long roleId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据resourceId查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceByResourceId(long resourceId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceById(long id,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceByRoleId(long roleId,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 根据resourceId更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceByResourceId(long resourceId,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

	/**
	 * 断言gas_merchant_source_data表数据
	 */
	public void assertGasMerchantSourceData(GasMerchantSourceDataDO expect, GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantSourceDataDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantSourceDataDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantSourceDataDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantSourceDataDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantSourceDataDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantSourceDataDO);
	}

    /**
	 * 插入gas_merchant_source_data表数据
	 */
	public void insertGasMerchantSourceData(GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		gasMerchantSourceDataDAO.insert(gasMerchantSourceDataDO);
	}

    /**
	 * 插入gas_merchant_source_data表数据
	 */
	public void insertGasMerchantSourceData(
			long id, 
			String partnerId, 
			String sourceType, 
			String sourceKey, 
			Byte authorized, 
			String authorizerAccessToken, 
			String authorizerAccessTokenTime, 
			String authorizerRefreshToken, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String sourceInfo, 
			String funcInfo
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantSourceDataDO gasMerchantSourceDataDO = new GasMerchantSourceDataDO();
		gasMerchantSourceDataDO.setId(id);
		gasMerchantSourceDataDO.setPartnerId(partnerId);
		gasMerchantSourceDataDO.setSourceType(sourceType);
		gasMerchantSourceDataDO.setSourceKey(sourceKey);
		gasMerchantSourceDataDO.setAuthorized(authorized);
		gasMerchantSourceDataDO.setAuthorizerAccessToken(authorizerAccessToken);
		gasMerchantSourceDataDO.setAuthorizerAccessTokenTime(authorizerAccessTokenTime);
		gasMerchantSourceDataDO.setAuthorizerRefreshToken(authorizerRefreshToken);
		gasMerchantSourceDataDO.setRawAddTime(rawAddTime);
		gasMerchantSourceDataDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantSourceDataDO.setSourceInfo(sourceInfo);
		gasMerchantSourceDataDO.setFuncInfo(funcInfo);
		gasMerchantSourceDataDAO.insert(gasMerchantSourceDataDO);
	}

    /**
     * 删除gas_merchant_source_data表所有数据
     */
    public void cleanGasMerchantSourceData() {
        GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
        exam.createCriteria();
        gasMerchantSourceDataDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_source_data表数据
	 */
	public void cleanGasMerchantSourceDataById(long id) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantSourceDataDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_source_data表数据
	 */
	public void cleanGasMerchantSourceDataByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantSourceDataDAO.deleteByExample(exam);
	}
	/**
	 * 根据sourceType,sourceKey删除gas_merchant_source_data表数据
	 */
	public void cleanGasMerchantSourceDataBySourceTypeAndSourceKey(String sourceType,String sourceKey) {
        if (StringUtils.isBlank(sourceType)){
            sourceType = "test_sourceType";
        }
        if (StringUtils.isBlank(sourceKey)){
            sourceKey = "test_sourceKey";
        }
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andSourceTypeEqualTo(sourceType).andSourceKeyEqualTo(sourceKey);
		gasMerchantSourceDataDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataById(long id) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantSourceDataDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataByPartnerId(String partnerId) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantSourceDataDAO.selectByExample(exam);
	}

	/**
	 * 根据sourceType,sourceKey查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataBySourceTypeAndSourceKey(String sourceType,String sourceKey) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andSourceTypeEqualTo(sourceType).andSourceKeyEqualTo(sourceKey);
		return gasMerchantSourceDataDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_source_data表数据
	 */
	public void updateGasMerchantSourceDataById(long id,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantSourceDataDAO.updateByExample(gasMerchantSourceDataDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_source_data表数据
	 */
	public void updateGasMerchantSourceDataByPartnerId(String partnerId,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantSourceDataDAO.updateByExample(gasMerchantSourceDataDO, exam);
	}

	/**
	 * 根据sourceType,sourceKey更新gas_merchant_source_data表数据
	 */
	public void updateGasMerchantSourceDataBySourceTypeAndSourceKey(String sourceType,String sourceKey,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andSourceTypeEqualTo(sourceType).andSourceKeyEqualTo(sourceKey);
		gasMerchantSourceDataDAO.updateByExample(gasMerchantSourceDataDO, exam);
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
			long id, 
			String stationId, 
			String partnerId, 
			String stationName, 
			String stationCode, 
			String phoneNo, 
			String status, 
			Byte connectOilMachine, 
			long provinceId, 
			long cityId, 
			long districtId, 
			String stationAddress, 
			Double longitude, 
			Double latitude, 
			String area, 
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
		gasMerchantStationDO.setStationId(stationId);
		gasMerchantStationDO.setPartnerId(partnerId);
		gasMerchantStationDO.setStationName(stationName);
		gasMerchantStationDO.setStationCode(stationCode);
		gasMerchantStationDO.setPhoneNo(phoneNo);
		gasMerchantStationDO.setStatus(status);
		gasMerchantStationDO.setConnectOilMachine(connectOilMachine);
		gasMerchantStationDO.setProvinceId(provinceId);
		gasMerchantStationDO.setCityId(cityId);
		gasMerchantStationDO.setDistrictId(districtId);
		gasMerchantStationDO.setStationAddress(stationAddress);
		gasMerchantStationDO.setLongitude(longitude);
		gasMerchantStationDO.setLatitude(latitude);
		gasMerchantStationDO.setArea(area);
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
	public void cleanGasMerchantStationById(long id) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	public void cleanGasMerchantStationByProvinceId(long provinceId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据cityId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByCityId(long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据districtId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByDistrictId(long districtId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationById(long id) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据partnerId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPartnerId(String partnerId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	public List<GasMerchantStationDO> findGasMerchantStationByProvinceId(long provinceId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据cityId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByCityId(long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据districtId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByDistrictId(long districtId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationById(long id,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据partnerId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPartnerId(String partnerId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	public void updateGasMerchantStationByProvinceId(long provinceId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据cityId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByCityId(long cityId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据districtId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByDistrictId(long districtId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
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
			long id, 
			String userId, 
			long roleId, 
			String userType, 
			String partnerId, 
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
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (lastLoginTime == null) {
			lastLoginTime = new Date();
		}
		if (lastLoginSuccessTime == null) {
			lastLoginSuccessTime = new Date();
		}
		if (lastLogoutSuccessTime == null) {
			lastLogoutSuccessTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantUserDO gasMerchantUserDO = new GasMerchantUserDO();
		gasMerchantUserDO.setId(id);
		gasMerchantUserDO.setUserId(userId);
		gasMerchantUserDO.setRoleId(roleId);
		gasMerchantUserDO.setUserType(userType);
		gasMerchantUserDO.setPartnerId(partnerId);
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
	public void cleanGasMerchantUserById(long id) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	public void cleanGasMerchantUserByRoleId(long roleId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
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
	 * 根据id查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserById(long id) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	public List<GasMerchantUserDO> findGasMerchantUserByRoleId(long roleId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
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
	 * 根据id更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserById(long id,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	public void updateGasMerchantUserByRoleId(long roleId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
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
	 * 断言gas_merchant_user_station表数据
	 */
	public void assertGasMerchantUserStation(GasMerchantUserStationDO expect, GasMerchantUserStationDO gasMerchantUserStationDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantUserStationDO.setId(expect.getId());
		}
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
			long id, 
			String userId, 
			String stationId
	) {
		GasMerchantUserStationDO gasMerchantUserStationDO = new GasMerchantUserStationDO();
		gasMerchantUserStationDO.setId(id);
		gasMerchantUserStationDO.setUserId(userId);
		gasMerchantUserStationDO.setStationId(stationId);
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
	public void cleanGasMerchantUserStationById(long id) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据id查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationById(long id) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	public void updateGasMerchantUserStationById(long id,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据stationId更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByStationId(String stationId,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

	/**
	 * 断言gas_province表数据
	 */
	public void assertGasProvince(GasProvinceDO expect, GasProvinceDO gasProvinceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasProvinceDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasProvinceDO);
	}

    /**
	 * 插入gas_province表数据
	 */
	public void insertGasProvince(GasProvinceDO gasProvinceDO) {
		gasProvinceDAO.insert(gasProvinceDO);
	}

    /**
	 * 插入gas_province表数据
	 */
	public void insertGasProvince(
			long id, 
			String provinceName, 
			String provinceShort, 
			String provinceChar
	) {
		GasProvinceDO gasProvinceDO = new GasProvinceDO();
		gasProvinceDO.setId(id);
		gasProvinceDO.setProvinceName(provinceName);
		gasProvinceDO.setProvinceShort(provinceShort);
		gasProvinceDO.setProvinceChar(provinceChar);
		gasProvinceDAO.insert(gasProvinceDO);
	}

    /**
     * 删除gas_province表所有数据
     */
    public void cleanGasProvince() {
        GasProvinceDOExample exam = new GasProvinceDOExample();
        exam.createCriteria();
        gasProvinceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_province表数据
	 */
	public void cleanGasProvinceById(long id) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasProvinceDAO.deleteByExample(exam);
	}

	/**
	* 根据provinceName删除gas_province表数据
	*/
	public void cleanGasProvinceByProvinceName(String provinceName) {
        if (StringUtils.isBlank(provinceName)){
            provinceName = "test_provinceName";
        }
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		gasProvinceDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_province表数据
	 */
	public List<GasProvinceDO> findGasProvinceById(long id) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasProvinceDAO.selectByExample(exam);
	}

	/**
	* 根据provinceName查询gas_province表数据
	*/
	public List<GasProvinceDO> findGasProvinceByProvinceName(String provinceName) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		return gasProvinceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_province表数据
	 */
	public void updateGasProvinceById(long id,GasProvinceDO gasProvinceDO) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasProvinceDAO.updateByExample(gasProvinceDO, exam);
	}

	/**
	* 根据provinceName更新gas_province表数据
	*/
	public void updateGasProvinceByProvinceName(String provinceName,GasProvinceDO gasProvinceDO) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		gasProvinceDAO.updateByExample(gasProvinceDO, exam);
	}

	/**
	 * 断言gas_role表数据
	 */
	public void assertGasRole(GasRoleDO expect, GasRoleDO gasRoleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasRoleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasRoleDO.getRawAddTime());
		expect.setRawAddTime(gasRoleDO.getRawAddTime());
        Assertions.assertTrue(null != gasRoleDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasRoleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasRoleDO);
	}

    /**
	 * 插入gas_role表数据
	 */
	public void insertGasRole(GasRoleDO gasRoleDO) {
		gasRoleDAO.insert(gasRoleDO);
	}

    /**
	 * 插入gas_role表数据
	 */
	public void insertGasRole(
			long id, 
			String roleType, 
			long parentId, 
			String roleName, 
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
		GasRoleDO gasRoleDO = new GasRoleDO();
		gasRoleDO.setId(id);
		gasRoleDO.setRoleType(roleType);
		gasRoleDO.setParentId(parentId);
		gasRoleDO.setRoleName(roleName);
		gasRoleDO.setMemo(memo);
		gasRoleDO.setRawAddTime(rawAddTime);
		gasRoleDO.setRawUpdateTime(rawUpdateTime);
		gasRoleDAO.insert(gasRoleDO);
	}

    /**
     * 删除gas_role表所有数据
     */
    public void cleanGasRole() {
        GasRoleDOExample exam = new GasRoleDOExample();
        exam.createCriteria();
        gasRoleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_role表数据
	 */
	public void cleanGasRoleById(long id) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentId删除gas_role表数据
	 */
	public void cleanGasRoleByParentId(long parentId) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasRoleDAO.deleteByExample(exam);
	}

	/**
	* 根据roleName删除gas_role表数据
	*/
	public void cleanGasRoleByRoleName(String roleName) {
        if (StringUtils.isBlank(roleName)){
            roleName = "test_roleName";
        }
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		gasRoleDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_role表数据
	 */
	public List<GasRoleDO> findGasRoleById(long id) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据parentId查询gas_role表数据
	 */
	public List<GasRoleDO> findGasRoleByParentId(long parentId) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		return gasRoleDAO.selectByExample(exam);
	}

	/**
	* 根据roleName查询gas_role表数据
	*/
	public List<GasRoleDO> findGasRoleByRoleName(String roleName) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		return gasRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_role表数据
	 */
	public void updateGasRoleById(long id,GasRoleDO gasRoleDO) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRoleDAO.updateByExample(gasRoleDO, exam);
	}

    /**
	 * 根据parentId更新gas_role表数据
	 */
	public void updateGasRoleByParentId(long parentId,GasRoleDO gasRoleDO) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasRoleDAO.updateByExample(gasRoleDO, exam);
	}

	/**
	* 根据roleName更新gas_role表数据
	*/
	public void updateGasRoleByRoleName(String roleName,GasRoleDO gasRoleDO) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		gasRoleDAO.updateByExample(gasRoleDO, exam);
	}

	/**
	 * 断言gas_rule_description表数据
	 */
	public void assertGasRuleDescription(GasRuleDescriptionDO expect, GasRuleDescriptionDO gasRuleDescriptionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasRuleDescriptionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasRuleDescriptionDO.getRawAddTime());
		expect.setRawAddTime(gasRuleDescriptionDO.getRawAddTime());
        Assertions.assertTrue(null != gasRuleDescriptionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasRuleDescriptionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasRuleDescriptionDO);
	}

    /**
	 * 插入gas_rule_description表数据
	 */
	public void insertGasRuleDescription(GasRuleDescriptionDO gasRuleDescriptionDO) {
		gasRuleDescriptionDAO.insert(gasRuleDescriptionDO);
	}

    /**
	 * 插入gas_rule_description表数据
	 */
	public void insertGasRuleDescription(
			Integer id, 
			String partnerId, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String description
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasRuleDescriptionDO gasRuleDescriptionDO = new GasRuleDescriptionDO();
		gasRuleDescriptionDO.setId(id);
		gasRuleDescriptionDO.setPartnerId(partnerId);
		gasRuleDescriptionDO.setRuleType(ruleType);
		gasRuleDescriptionDO.setRawAddTime(rawAddTime);
		gasRuleDescriptionDO.setRawUpdateTime(rawUpdateTime);
		gasRuleDescriptionDO.setDescription(description);
		gasRuleDescriptionDAO.insert(gasRuleDescriptionDO);
	}

    /**
     * 删除gas_rule_description表所有数据
     */
    public void cleanGasRuleDescription() {
        GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
        exam.createCriteria();
        gasRuleDescriptionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_rule_description表数据
	 */
	public void cleanGasRuleDescriptionById(Integer id) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRuleDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_rule_description表数据
	 */
	public void cleanGasRuleDescriptionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasRuleDescriptionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_rule_description表数据
	 */
	public List<GasRuleDescriptionDO> findGasRuleDescriptionById(Integer id) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasRuleDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_rule_description表数据
	 */
	public List<GasRuleDescriptionDO> findGasRuleDescriptionByPartnerId(String partnerId) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasRuleDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_rule_description表数据
	 */
	public void updateGasRuleDescriptionById(Integer id,GasRuleDescriptionDO gasRuleDescriptionDO) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRuleDescriptionDAO.updateByExample(gasRuleDescriptionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_rule_description表数据
	 */
	public void updateGasRuleDescriptionByPartnerId(String partnerId,GasRuleDescriptionDO gasRuleDescriptionDO) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasRuleDescriptionDAO.updateByExample(gasRuleDescriptionDO, exam);
	}

	/**
	 * 断言gas_station_goods_price_plan表数据
	 */
	public void assertGasStationGoodsPricePlan(GasStationGoodsPricePlanDO expect, GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationGoodsPricePlanDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationGoodsPricePlanDO.getRawAddTime());
		expect.setRawAddTime(gasStationGoodsPricePlanDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationGoodsPricePlanDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationGoodsPricePlanDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationGoodsPricePlanDO);
	}

    /**
	 * 插入gas_station_goods_price_plan表数据
	 */
	public void insertGasStationGoodsPricePlan(GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		gasStationGoodsPricePlanDAO.insert(gasStationGoodsPricePlanDO);
	}

    /**
	 * 插入gas_station_goods_price_plan表数据
	 */
	public void insertGasStationGoodsPricePlan(
			long id, 
			String planId, 
			String merchantPlanId, 
			String priceName, 
			String partnerId, 
			String stationId, 
			Date effectTime, 
			String deleteFlag, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
		if (effectTime == null) {
			effectTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO = new GasStationGoodsPricePlanDO();
		gasStationGoodsPricePlanDO.setId(id);
		gasStationGoodsPricePlanDO.setPlanId(planId);
		gasStationGoodsPricePlanDO.setMerchantPlanId(merchantPlanId);
		gasStationGoodsPricePlanDO.setPriceName(priceName);
		gasStationGoodsPricePlanDO.setPartnerId(partnerId);
		gasStationGoodsPricePlanDO.setStationId(stationId);
		gasStationGoodsPricePlanDO.setEffectTime(effectTime);
		gasStationGoodsPricePlanDO.setDeleteFlag(deleteFlag);
		gasStationGoodsPricePlanDO.setRawAddTime(rawAddTime);
		gasStationGoodsPricePlanDO.setRawUpdateTime(rawUpdateTime);
		gasStationGoodsPricePlanDO.setGoodsInfo(goodsInfo);
		gasStationGoodsPricePlanDAO.insert(gasStationGoodsPricePlanDO);
	}

    /**
     * 删除gas_station_goods_price_plan表所有数据
     */
    public void cleanGasStationGoodsPricePlan() {
        GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
        exam.createCriteria();
        gasStationGoodsPricePlanDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanById(long id) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据planId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByPlanId(String planId) {
        if (StringUtils.isBlank(planId)){
            planId = "test_planId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantPlanId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByMerchantPlanId(String merchantPlanId) {
        if (StringUtils.isBlank(merchantPlanId)){
            merchantPlanId = "test_merchantPlanId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andMerchantPlanIdEqualTo(merchantPlanId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据priceName删除gas_station_goods_price_plan表数据
	*/
	public void cleanGasStationGoodsPricePlanByPriceName(String priceName) {
        if (StringUtils.isBlank(priceName)){
            priceName = "test_priceName";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanById(long id) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据planId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPlanId(String planId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantPlanId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByMerchantPlanId(String merchantPlanId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andMerchantPlanIdEqualTo(merchantPlanId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据priceName查询gas_station_goods_price_plan表数据
	*/
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPriceName(String priceName) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPartnerId(String partnerId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByStationId(String stationId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanById(long id,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据planId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByPlanId(String planId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据merchantPlanId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByMerchantPlanId(String merchantPlanId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andMerchantPlanIdEqualTo(merchantPlanId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

	/**
	* 根据priceName更新gas_station_goods_price_plan表数据
	*/
	public void updateGasStationGoodsPricePlanByPriceName(String priceName,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据partnerId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByPartnerId(String partnerId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByStationId(String stationId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

	/**
	 * 断言gas_station_oil_gun表数据
	 */
	public void assertGasStationOilGun(GasStationOilGunDO expect, GasStationOilGunDO gasStationOilGunDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationOilGunDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationOilGunDO.getRawAddTime());
		expect.setRawAddTime(gasStationOilGunDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationOilGunDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationOilGunDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationOilGunDO);
	}

    /**
	 * 插入gas_station_oil_gun表数据
	 */
	public void insertGasStationOilGun(GasStationOilGunDO gasStationOilGunDO) {
		gasStationOilGunDAO.insert(gasStationOilGunDO);
	}

    /**
	 * 插入gas_station_oil_gun表数据
	 */
	public void insertGasStationOilGun(
			long id, 
			String partnerId, 
			String stationId, 
			String oilGunNo, 
			String goodsCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			Integer sortNo
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationOilGunDO gasStationOilGunDO = new GasStationOilGunDO();
		gasStationOilGunDO.setId(id);
		gasStationOilGunDO.setPartnerId(partnerId);
		gasStationOilGunDO.setStationId(stationId);
		gasStationOilGunDO.setOilGunNo(oilGunNo);
		gasStationOilGunDO.setGoodsCode(goodsCode);
		gasStationOilGunDO.setRawAddTime(rawAddTime);
		gasStationOilGunDO.setRawUpdateTime(rawUpdateTime);
		gasStationOilGunDO.setSortNo(sortNo);
		gasStationOilGunDAO.insert(gasStationOilGunDO);
	}

    /**
     * 删除gas_station_oil_gun表所有数据
     */
    public void cleanGasStationOilGun() {
        GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
        exam.createCriteria();
        gasStationOilGunDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunById(long id) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据oilGunNo删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByOilGunNo(String oilGunNo) {
        if (StringUtils.isBlank(oilGunNo)){
            oilGunNo = "test_oilGunNo";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andOilGunNoEqualTo(oilGunNo);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_station_oil_gun表数据
	*/
	public void cleanGasStationOilGunByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据sortNo删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunBySortNo(Integer sortNo) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andSortNoEqualTo(sortNo);
		gasStationOilGunDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunById(long id) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByPartnerId(String partnerId) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByStationId(String stationId) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据oilGunNo查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByOilGunNo(String oilGunNo) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andOilGunNoEqualTo(oilGunNo);
		return gasStationOilGunDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_station_oil_gun表数据
	*/
	public List<GasStationOilGunDO> findGasStationOilGunByGoodsCode(String goodsCode) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据sortNo查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunBySortNo(Integer sortNo) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andSortNoEqualTo(sortNo);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunById(long id,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据partnerId更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByPartnerId(String partnerId,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByStationId(String stationId,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据oilGunNo更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByOilGunNo(String oilGunNo,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andOilGunNoEqualTo(oilGunNo);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

	/**
	* 根据goodsCode更新gas_station_oil_gun表数据
	*/
	public void updateGasStationOilGunByGoodsCode(String goodsCode,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据sortNo更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunBySortNo(Integer sortNo,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andSortNoEqualTo(sortNo);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

	/**
	 * 断言gas_station_service_tag表数据
	 */
	public void assertGasStationServiceTag(GasStationServiceTagDO expect, GasStationServiceTagDO gasStationServiceTagDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationServiceTagDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationServiceTagDO.getRawAddTime());
		expect.setRawAddTime(gasStationServiceTagDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationServiceTagDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationServiceTagDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationServiceTagDO);
	}

    /**
	 * 插入gas_station_service_tag表数据
	 */
	public void insertGasStationServiceTag(GasStationServiceTagDO gasStationServiceTagDO) {
		gasStationServiceTagDAO.insert(gasStationServiceTagDO);
	}

    /**
	 * 插入gas_station_service_tag表数据
	 */
	public void insertGasStationServiceTag(
			long id, 
			String partnerId, 
			String stationId, 
			String serviceTag, 
			Byte tagStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationServiceTagDO gasStationServiceTagDO = new GasStationServiceTagDO();
		gasStationServiceTagDO.setId(id);
		gasStationServiceTagDO.setPartnerId(partnerId);
		gasStationServiceTagDO.setStationId(stationId);
		gasStationServiceTagDO.setServiceTag(serviceTag);
		gasStationServiceTagDO.setTagStatus(tagStatus);
		gasStationServiceTagDO.setRawAddTime(rawAddTime);
		gasStationServiceTagDO.setRawUpdateTime(rawUpdateTime);
		gasStationServiceTagDAO.insert(gasStationServiceTagDO);
	}

    /**
     * 删除gas_station_service_tag表所有数据
     */
    public void cleanGasStationServiceTag() {
        GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
        exam.createCriteria();
        gasStationServiceTagDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_service_tag表数据
	 */
	public void cleanGasStationServiceTagById(long id) {
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationServiceTagDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_station_service_tag表数据
	 */
	public void cleanGasStationServiceTagByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationServiceTagDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_service_tag表数据
	 */
	public void cleanGasStationServiceTagByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationServiceTagDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询gas_station_service_tag表数据
	 */
	public List<GasStationServiceTagDO> findGasStationServiceTagById(long id) {
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationServiceTagDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_station_service_tag表数据
	 */
	public List<GasStationServiceTagDO> findGasStationServiceTagByPartnerId(String partnerId) {
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasStationServiceTagDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_service_tag表数据
	 */
	public List<GasStationServiceTagDO> findGasStationServiceTagByStationId(String stationId) {
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationServiceTagDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_service_tag表数据
	 */
	public void updateGasStationServiceTagById(long id,GasStationServiceTagDO gasStationServiceTagDO) {
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationServiceTagDAO.updateByExample(gasStationServiceTagDO, exam);
	}

    /**
	 * 根据partnerId更新gas_station_service_tag表数据
	 */
	public void updateGasStationServiceTagByPartnerId(String partnerId,GasStationServiceTagDO gasStationServiceTagDO) {
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationServiceTagDAO.updateByExample(gasStationServiceTagDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_service_tag表数据
	 */
	public void updateGasStationServiceTagByStationId(String stationId,GasStationServiceTagDO gasStationServiceTagDO) {
		GasStationServiceTagDOExample exam = new GasStationServiceTagDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationServiceTagDAO.updateByExample(gasStationServiceTagDO, exam);
	}

	/**
	 * 断言merchant_protocol_rule表数据
	 */
	public void assertMerchantProtocolRule(MerchantProtocolRuleDO expect, MerchantProtocolRuleDO merchantProtocolRuleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantProtocolRuleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantProtocolRuleDO.getRawAddTime());
		expect.setRawAddTime(merchantProtocolRuleDO.getRawAddTime());
        Assertions.assertTrue(null != merchantProtocolRuleDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantProtocolRuleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantProtocolRuleDO);
	}

    /**
	 * 插入merchant_protocol_rule表数据
	 */
	public void insertMerchantProtocolRule(MerchantProtocolRuleDO merchantProtocolRuleDO) {
		merchantProtocolRuleDAO.insert(merchantProtocolRuleDO);
	}

    /**
	 * 插入merchant_protocol_rule表数据
	 */
	public void insertMerchantProtocolRule(
			long id, 
			String partnerId, 
			String status, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String protocol, 
			String description, 
			String ruleData
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantProtocolRuleDO merchantProtocolRuleDO = new MerchantProtocolRuleDO();
		merchantProtocolRuleDO.setId(id);
		merchantProtocolRuleDO.setPartnerId(partnerId);
		merchantProtocolRuleDO.setStatus(status);
		merchantProtocolRuleDO.setRuleType(ruleType);
		merchantProtocolRuleDO.setRawAddTime(rawAddTime);
		merchantProtocolRuleDO.setRawUpdateTime(rawUpdateTime);
		merchantProtocolRuleDO.setProtocol(protocol);
		merchantProtocolRuleDO.setDescription(description);
		merchantProtocolRuleDO.setRuleData(ruleData);
		merchantProtocolRuleDAO.insert(merchantProtocolRuleDO);
	}

    /**
     * 删除merchant_protocol_rule表所有数据
     */
    public void cleanMerchantProtocolRule() {
        MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
        exam.createCriteria();
        merchantProtocolRuleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_protocol_rule表数据
	 */
	public void cleanMerchantProtocolRuleById(long id) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProtocolRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_protocol_rule表数据
	 */
	public void cleanMerchantProtocolRuleByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantProtocolRuleDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询merchant_protocol_rule表数据
	 */
	public List<MerchantProtocolRuleDO> findMerchantProtocolRuleById(long id) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantProtocolRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_protocol_rule表数据
	 */
	public List<MerchantProtocolRuleDO> findMerchantProtocolRuleByPartnerId(String partnerId) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantProtocolRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_protocol_rule表数据
	 */
	public void updateMerchantProtocolRuleById(long id,MerchantProtocolRuleDO merchantProtocolRuleDO) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProtocolRuleDAO.updateByExample(merchantProtocolRuleDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_protocol_rule表数据
	 */
	public void updateMerchantProtocolRuleByPartnerId(String partnerId,MerchantProtocolRuleDO merchantProtocolRuleDO) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantProtocolRuleDAO.updateByExample(merchantProtocolRuleDO, exam);
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
			long id, 
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
	public void cleanNotifyTaskById(long id) {
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
	 * 根据id查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskById(long id) {
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
	public void updateNotifyTaskById(long id,NotifyTaskDO notifyTaskDO) {
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
}
